package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Doctor;
import com.example.modal.DocModal;
import com.example.repository.DocRepo;

@Service
public class DocService {
	
	@Autowired
	private DocRepo repo;

	public DocModal savedoc( DocModal modal) 
	{
		Doctor doc= new Doctor();
		BeanUtils.copyProperties(modal, doc);
		repo.save(doc);
		return modal;
	}
	
	public List<DocModal> getall()
	{
		List<Doctor>docc=repo.findAll();
		
		List<DocModal>docmodall=docc.stream()
		.map(doc->
				new DocModal(
						doc.getId(),
						doc.getFname(),
						doc.getLname(),
						doc.getDegree(),
						doc.getSpecialty(),
						doc.getLicenseno(),
						doc.getMobileno())).
		       collect(Collectors.toList());
	
		
		return docmodall;
	}
	
	public Optional<Doctor> getById(Long id)
	{
//		Optional<Doctor> doc=repo.findById(id);
//		DocModal docc=new DocModal();
//		BeanUtils.copyProperties(doc, docc);
		return repo.findById(id);
		
	}
	
	public boolean deleteById(Long id)
	{
		Doctor doc = repo.findById(id).get();
		repo.delete(doc);
		return true;
	}
	
	public Doctor update(Long id,DocModal odc)
	{
		Doctor coc=repo.findById(id).get();
	coc.setFname(odc.getFname());
	coc.setLname(odc.getLname());
	coc.setDegree(odc.getDegree());
	coc.setLicenseno(odc.getLicenseno());
	coc.setSpecialty(odc.getSpecialty());
	coc.setMobileno(odc.getMobileno());
	return repo.save(coc);
	}
}
