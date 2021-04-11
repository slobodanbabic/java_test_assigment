package com.alasdoo.developercourseassignment.service;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;

/**
 * @author Slobodan Babic
 *
 */
public interface TeacherService extends CrudService<TeacherDTO> {

	/**
	 * Find and return entity with passed name and surname.
	 * 
	 * @param name of the entity to return
	 * @param surname of the entity to return
	 * @return entity with passed name and surname or null if not found
	 */
	public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname);

	/**
	 * Find and return entity with passed email.
	 * 
	 * @param email of the entity to return
	 * @return entity with passed email or null if not found
	 */
	public TeacherDTO findByTeacherEmail(String email);
}
