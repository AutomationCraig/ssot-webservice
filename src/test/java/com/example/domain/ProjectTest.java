package com.example.domain;

import java.util.Arrays;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

//@RunWith(Arquillian.class)
public class ProjectTest {
//    @Inject private MyWebService myWebService;
//
//    @Deployment public static WebArchive createDeployment() {
//        return ShrinkWrap.create(WebArchive.class, "test.war")
//                .addClasses(MyWebService.class)
//                .addClasses(TestCase.class)
//                .addClasses(Project.class)
//                .addClasses(TestSuite.class)
//                		.addAsResource("META-INF/persistence.xml")
//                		.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
//    }
//
//    @Test
//    public void testIsDeployed() {
//        Assert.assertNotNull(myWebService);
//    }
    
    @Test
    public void projectToStringTest() {
    	TestCase test1 = new TestCase("Desc 1", true, new Date());
    	TestCase test2 = new TestCase("Desc 2", false, new Date());
    	Project project = new Project("svn path", "jenkins url", Arrays.asList(test1, test2));
    	System.out.println(project);
    	Assert.assertTrue(true);
    }

//    @Test
//    public void testProjectAddAndRemove(){
//    	TestCase test1 = new TestCase("Desc 1", true, new Date());
//    	TestCase test2 = new TestCase("Desc 2", false, new Date());
//    	TestSuite testSuite = new TestSuite(Arrays.asList(test1, test2));
//    	Project project = new Project("svn path", "jenkins url", testSuite);
//
//    	
//    	Project player = myWebService.playerPOSTRequest(999, "Ima Player", friendIDList);
//		TestCase user = myWebService.getUser(67890);
//		
//		//Asserts after POST
//		Assert.assertTrue(player.getFriendList().size()==1);
//		Assert.assertTrue(player.getPlayerInfo().getName().equals("Ima Player"));
//		Assert.assertTrue(user.getImageURL().equals(myWebService.resolveURL(67890)));
//		
//		long points = myWebService.getPlayerPoints(999);
//		
//		//Assert after GET
//		Assert.assertTrue(points==100);
//		
//		//Remove the Player and make sure it happened
//		String result = myWebService.playerRemovalRequest(999);
//		Assert.assertTrue(result.equals("Player removed with FacbookID: 999"));
//    }
}