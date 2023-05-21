package com.java.ais;

import com.java.ais.enums.IrrigationStatus;
import com.java.ais.model.PlotLand;
import com.java.ais.repository.PlotLandRepository;
import com.java.ais.service.PlotLandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class PlotLandTest {

	@Autowired
	private PlotLandService plotLandService;

	@MockBean
	private PlotLandRepository plotLandRepository;

//	@Test
//	public void testAddNewOrEdit() {
//		PlotLand plotLand = new PlotLand();
//		plotLand.setPlotName("Test Plot");
//		plotLand.setCropType("Tree");
//		plotLand.setSoilType(1);
//		plotLand.setAreaSize(100);
//		plotLand.setIrrigationStatus(IrrigationStatus.NOT_IRRIGATED.ordinal());
//
//		when(plotLandRepository.save(plotLand)).thenReturn(plotLand);
//
//		PlotLand result = plotLandService.addNewOrEdit(plotLand);
//
//		assertNotNull(result);
//		assertEquals(plotLand.getId(), result.getId());
//		assertEquals(plotLand.getPlotName(), result.getPlotName());
//		assertEquals(plotLand.getCropType(), result.getCropType());
//		assertEquals(plotLand.getSoilType(), result.getSoilType());
//		assertEquals(plotLand.getAreaSize(), result.getAreaSize());
//		assertEquals(plotLand.getIrrigationStatus(), result.getIrrigationStatus());
//
//		verify(plotLandRepository, times(1)).save(plotLand);
//	}
}
