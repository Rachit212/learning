package com.Bing.Testing;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Bing.Action.*;

public class Testing {
	Action a = new Action();

	@BeforeTest
	public void Step_01_Set_Path() {
		a.Load_Driver();
	}

	@Test
	public void Step_02_Enter_Url() {
		a.Set_Path();
	}

	@Test
	public void Step_03_Selecting_Language() {
		a.Select_Language();
	}
	@Test
	public void Step_04_Giving_Input() {
		a.Give_Input();
	}
	
	@Test 
	public void Step_05_Swap_Text() throws InterruptedException {
		a.Swap_Values();
	}
	@Test
	public void Step_06_Clear_Text() {
		a.Check_Clear_Button();
	}
	@AfterTest
	public void afterTest() {
	}
}
