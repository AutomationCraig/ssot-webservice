package com.example.domain.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.domain.Product;
import com.example.domain.Project;
import com.example.domain.Build;

public class DBSearch {
	
	
	/** Return a Product object if name matched to 1 and only 1.
	 * If no name match is found, or multiple matches are found, we return null.
	 * @param em
	 * @param codePath
	 * @return
	 */
	public Product getProductByName(EntityManager em, String name) {
		Product returnProduct = null;
		try {

			TypedQuery<Product> query = em.createQuery(
					"from Product p where p.productName = ?",
					Product.class);
			query.setParameter(1, name);
			List<Product> result = query.getResultList();
			if (result.isEmpty()) {
				return returnProduct;
			} else {
				if (result.size() > 1) {
					System.err
							.println("ERROR: We have ["
									+ result.size()
									+ "] Products that have the name of ["
									+ name
									+ "]. This should not happen.  Returning null");
					return returnProduct;
				} else {
					// We returned 1 and only 1 User from the query
					returnProduct = result.get(0);
					return returnProduct;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Encountered error in getProductByName function : "
							+ e);
			return returnProduct;
		}
	}// getProductByName
	
	/** Return a Product object if ID matched to 1 and only 1.
	 * If no ID match is found, or multiple matches are found, we return null.
	 * @param em
	 * @param codePath
	 * @return
	 */
	public Product getProductByID(EntityManager em, long prodcutId) {
		Product returnProduct = null;
		try {

			TypedQuery<Product> query = em.createQuery(
					"from Product p where p.prodcutId = ?",
					Product.class);
			query.setParameter(1, prodcutId);
			List<Product> result = query.getResultList();
			if (result.isEmpty()) {
				return returnProduct;
			} else {
				if (result.size() > 1) {
					System.err
							.println("ERROR: We have ["
									+ result.size()
									+ "] Products that have the prodcutId of ["
									+ prodcutId
									+ "]. This should not happen.  Returning null");
					return returnProduct;
				} else {
					// We returned 1 and only 1 User from the query
					returnProduct = result.get(0);
					return returnProduct;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Encountered error in getProductByName function : "
							+ e);
			return returnProduct;
		}
	}// getProductByID
	
	/** Return a Project object if name matched to 1 and only 1.
	 * If no name match is found, or multiple matches are found, we return null.
	 * @param em
	 * @param codePath
	 * @return
	 */
	public Project getProjectByName(EntityManager em, String name) {
		Project returnProject = null;
		try {

			TypedQuery<Project> query = em.createQuery(
					"from Project p where p.projectName = ?",
					Project.class);
			query.setParameter(1, name);
			List<Project> result = query.getResultList();
			if (result.isEmpty()) {
				return returnProject;
			} else {
				if (result.size() > 1) {
					System.err
							.println("ERROR: We have ["
									+ result.size()
									+ "] Projects that have the name of ["
									+ name
									+ "]. This should not happen.  Returning null");
					return returnProject;
				} else {
					// We returned 1 and only 1 User from the query
					returnProject = result.get(0);
					return returnProject;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Encountered error in getProjectByName function : "
							+ e);
			return returnProject;
		}
	}// getProjectByName
	
	/** Return a Project object if ID matched to 1 and only 1.
	 * If no ID match is found, or multiple matches are found, we return null.
	 * @param em
	 * @param codePath
	 * @return
	 */
	public Project getProjectByID(EntityManager em, long id) {
		Project returnProject = null;
		try {

			TypedQuery<Project> query = em.createQuery(
					"from Project p where p.projectId = ?",
					Project.class);
			query.setParameter(1, id);
			List<Project> result = query.getResultList();
			if (result.isEmpty()) {
				return returnProject;
			} else {
				if (result.size() > 1) {
					System.err
							.println("ERROR: We have ["
									+ result.size()
									+ "] Projects that have the id of ["
									+ id
									+ "]. This should not happen.  Returning null");
					return returnProject;
				} else {
					// We returned 1 and only 1 User from the query
					returnProject = result.get(0);
					return returnProject;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Encountered error in getProjectByName function : "
							+ e);
			return returnProject;
		}
	}// getProjectByName

	public Build getProjecRuntByProjectNameAndFirstTestID(EntityManager em, String projectName, Long id) {
		Build returnProjectRun = null;
		try {

			TypedQuery<Build> query = em.createQuery(
					"from ProjectRun p where p.project.projectName = ? and p.testCaseRuns.testCaseId = ?",
					Build.class);
			query.setParameter(1, projectName);
			query.setParameter(1, id);
			List<Build> result = query.getResultList();
			if (result.isEmpty()) {
				return returnProjectRun;
			} else {
				if (result.size() > 1) {
					System.err
							.println("ERROR: We have ["
									+ result.size()
									+ "] Project Runs that have the name of ["
									+ projectName + "] and first test ID of [" + id
									+ "]. This should not happen.  Returning null");
					return returnProjectRun;
				} else {
					// We returned 1 and only 1 User from the query
					returnProjectRun = result.get(0);
					return returnProjectRun;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Encountered error in getProjectByName function : "
							+ e);
			return returnProjectRun;
		}
	}
	
//	/** Return a ProjectRun object if codePath matched to 1 and only 1.
//	 * If no codePath match is found, or multiple matches are found, we return null.
//	 * @param em
//	 * @param codePath
//	 * @return
//	 */
//	public ProjectRun getProjecRuntByCodePath(EntityManager em, String codePath) {
//		ProjectRun returnProjectRun = null;
//		try {
//
//			TypedQuery<ProjectRun> query = em.createQuery(
//					"from ProjectRun p where p.codePath = ?",
//					ProjectRun.class);
//			query.setParameter(1, codePath);
//			List<ProjectRun> result = query.getResultList();
//			if (result.isEmpty()) {
//				return returnProjectRun;
//			} else {
//				if (result.size() > 1) {
//					System.err
//							.println("ERROR: We have ["
//									+ result.size()
//									+ "] ProjectRuns that have the codePath of ["
//									+ codePath
//									+ "]. This should not happen.  Returning null");
//					return returnProjectRun;
//				} else {
//					// We returned 1 and only 1 User from the query
//					returnProjectRun = result.get(0);
//					return returnProjectRun;
//				}
//			}
//		} catch (Exception e) {
//			System.out
//					.println("Encountered error in getProjectRunByCodePath function : "
//							+ e);
//			return returnProjectRun;
//		}
//	}// getProjectRunByCodePath
}
