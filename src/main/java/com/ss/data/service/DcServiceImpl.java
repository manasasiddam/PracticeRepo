package com.ss.data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.data.Entity.ChildrenEntity;
import com.ss.data.Entity.CitizenAppEntity;
import com.ss.data.Entity.DcCasesEntity;
import com.ss.data.Entity.EducationEntity;
import com.ss.data.Entity.IncomeEntity;
import com.ss.data.Entity.PlanMasterEntity;
import com.ss.data.dto.ChildRequestDto;
import com.ss.data.dto.ChildrenDto;
import com.ss.data.dto.EducationDto;
import com.ss.data.dto.IncomeDto;
import com.ss.data.dto.PlanSelectionDto;
import com.ss.data.dto.SummaryOfDto;
import com.ss.data.repository.ChildrenEntityRepository;
import com.ss.data.repository.CitizenAppEntityRepository;
import com.ss.data.repository.DcCasesEntityRepository;
import com.ss.data.repository.EducationEntityRepository;
import com.ss.data.repository.IncomeEntityRepository;
import com.ss.data.repository.PlanMasterEntityRepository;

@Service
public class DcServiceImpl implements DcService {

	@Autowired
	private CitizenAppEntityRepository citizenAppEntityRepo;

	@Autowired
	private DcCasesEntityRepository dcCasesEntityRepo;

	@Autowired
	private ChildrenEntityRepository childrenEntityRepo;

	@Autowired
	private EducationEntityRepository educationEntityRepo;

	@Autowired
	private IncomeEntityRepository incomeEntityRepo;

	@Autowired
	private PlanMasterEntityRepository planMasterEntityRepo;

	@Override
	public Long loadCaseNum(Integer appId) {
		Optional<CitizenAppEntity> findById = citizenAppEntityRepo.findById(appId);
		if (findById.isPresent()) {
			DcCasesEntity dcCasesEntity = new DcCasesEntity();
			dcCasesEntity.setAppId(appId);
			DcCasesEntity save = dcCasesEntityRepo.save(dcCasesEntity);
			return save.getCaseNum();
		}

		return 0L;
	}

	@Override
	public Map<Integer, String> getPlanNames() {
		List<PlanMasterEntity> findAllEntities = planMasterEntityRepo.findAll();

		Map<Integer, String> planMap = new HashMap<>();

		for (PlanMasterEntity entity : findAllEntities) {
			planMap.put(entity.getPlanId(), entity.getPlanName());
		}

		return planMap;
	}

	@Override
	public Long savePlanSelection(PlanSelectionDto planSelectionDto) {
		Optional<DcCasesEntity> findById = dcCasesEntityRepo.findById(planSelectionDto.getCaseNum());
		if (findById.isPresent()) {
			DcCasesEntity dcCasesEntity = findById.get();
			dcCasesEntity.setPlanId(planSelectionDto.getPlanId());
			dcCasesEntityRepo.save(dcCasesEntity);

			return planSelectionDto.getCaseNum();
		}

		return null;
	}

	@Override
	public Long saveIncomeData(IncomeDto incomeDto) {
		Optional<DcCasesEntity> findById = dcCasesEntityRepo.findById(incomeDto.getCaseNum());
		if (findById.isPresent()) {
			IncomeEntity incomeEntity = new IncomeEntity();
			BeanUtils.copyProperties(incomeDto, incomeEntity);
			incomeEntityRepo.save(incomeEntity);
			return incomeDto.getCaseNum();

		}
		return null;
	}

	@Override
	public Long saveEducation(EducationDto educationDto) {
		Optional<DcCasesEntity> findById = dcCasesEntityRepo.findById(educationDto.getCaseNum());

		if (findById.isPresent()) {
			EducationEntity entity = new EducationEntity();
			BeanUtils.copyProperties(educationDto, entity);
			educationEntityRepo.save(entity);
			return educationDto.getCaseNum();

		}
		return null;
	}

	@Override
	public Long saveChildrenData(ChildRequestDto childRequest) {
		Optional<DcCasesEntity> findById = dcCasesEntityRepo.findById(childRequest.getCaseNum());
		
		if (findById.isPresent()) {
			List<ChildrenDto> childs = childRequest.getChilds();
			Long caseNum = childRequest.getCaseNum();

			for (ChildrenDto childrenDto : childs) {
				ChildrenEntity childrenEntity = new ChildrenEntity();
				BeanUtils.copyProperties(childrenDto, childrenEntity);
				childrenEntity.setCaseNum(caseNum);
				childrenEntityRepo.save(childrenEntity);
			}

			return childRequest.getCaseNum();
		}
		return null;
	}

	@Override
	public SummaryOfDto getSummary(Long caseNum) {
		String planName = "";

		IncomeEntity incomeEntityCaseNumber = incomeEntityRepo.findByCaseNum(caseNum);

		EducationEntity educationEntityCaseNumber = educationEntityRepo.findByCaseNum(caseNum);

		List<ChildrenEntity> ChildrenEntityCaseNumber = childrenEntityRepo.findByCaseNum(caseNum);

		Optional<DcCasesEntity> findById = dcCasesEntityRepo.findById(caseNum);

		if (findById.isPresent()) {
			Integer planId = findById.get().getPlanId();
			Optional<PlanMasterEntity> plan = planMasterEntityRepo.findById(planId);

			if (plan.isPresent()) {
				planName = plan.get().getPlanName();
			}

		}

		SummaryOfDto summary = new SummaryOfDto();
		summary.setPlanName(planName);

		EducationDto educationDto = new EducationDto();
		BeanUtils.copyProperties(educationEntityCaseNumber, educationDto);
		summary.setEducation(educationDto);

		IncomeDto incomeDto = new IncomeDto();
		BeanUtils.copyProperties(incomeEntityCaseNumber, incomeDto);
		summary.setIncome(incomeDto);

		List<ChildrenDto> childrens = new ArrayList<>();
		for (ChildrenEntity entity : ChildrenEntityCaseNumber) {
			ChildrenDto childrenDto = new ChildrenDto();
			BeanUtils.copyProperties(entity, childrenDto);
			childrens.add(childrenDto);
		}

		summary.setChildrens(childrens);
		return summary;
	}

}
