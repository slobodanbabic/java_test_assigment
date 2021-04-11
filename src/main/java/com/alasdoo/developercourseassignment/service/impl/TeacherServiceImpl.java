package com.alasdoo.developercourseassignment.service.impl;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import com.alasdoo.developercourseassignment.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

	//inject TeacherRepository 
	@Autowired
	private TeacherRepository teacherRepository;

	//inject TeacherMapper component
	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public TeacherDTO findOne(Integer id) {		
		//find an entity with given id
		Optional<Teacher> teacher = teacherRepository.findById(id);
		//throw IllegalArgumentException if value is not present
		if (!teacher.isPresent()) {
			throw new IllegalArgumentException("Teacher with the following id = " + id + " is not found.");
		}
		//transform an entity to DTO object
		return teacherMapper.transformToDTO(teacher.get());
	}

	@Override
	public List<TeacherDTO> findAll() {
		//create strem and transform each entity to DTO object and then collect to list
		return teacherRepository.findAll().stream().map(i -> teacherMapper.transformToDTO(i))
				.collect(Collectors.toList());
	}

	@Override
	public TeacherDTO save(TeacherDTO teacherDTO) {
		//transform DTO to entity
		Teacher teacher = teacherMapper.transformToEntity(teacherDTO);
		//save an entity to DB and transform to DTO and then return DTO object
		return teacherMapper.transformToDTO(teacherRepository.save(teacher));
	}

	@Override
	public void remove(Integer id) throws IllegalArgumentException {		
		Optional<Teacher> teacher = teacherRepository.findById(id);
		if (!teacher.isPresent()) {
			throw new IllegalArgumentException("Teacher with the following id = " + id + " is not found.");
		}
		//delete an entity from DB with given id
		teacherRepository.deleteById(id);
	}

	@Override
	public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
		Optional<Teacher> oldTeacher = teacherRepository.findById(id);
		if (!oldTeacher.isPresent()) {
			throw new IllegalArgumentException("Teacher with the following id = " + id + " is not found.");
		}
		//set new values to an entity
		oldTeacher.get().setTeacherName(teacherDTO.getTeacherName());
		oldTeacher.get().setTeacherSurname(teacherDTO.getTeacherSurname());
		oldTeacher.get().setTeacherEmail(teacherDTO.getTeacherEmail());
		//save an entity to DB with given id
		teacherRepository.save(oldTeacher.get());
		return teacherMapper.transformToDTO(oldTeacher.get());
	}

	@Override
	public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
		//find an entity with given name and surname
		Optional<Teacher> teacher = teacherRepository.findByTeacherNameAndTeacherSurname(name, surname);
		//throw IllegalArgumentException if value is not present
		if (!teacher.isPresent()) {
			throw new IllegalArgumentException("Teacher with the provided name and surname combination is not found.");
		}
		//transform an entity to DTO object
		return teacherMapper.transformToDTO(teacher.get());
	}

	@Override
	public TeacherDTO findByTeacherEmail(String email) {
		//find an entity with given name and surname
		Optional<Teacher> teacher = teacherRepository.findByTeacherEmail(email);
		if (!teacher.isPresent()) {
			throw new IllegalArgumentException("Teacher with the following email = " + email + " is not found.");
		}
		return teacherMapper.transformToDTO(teacher.get());
	}
}
