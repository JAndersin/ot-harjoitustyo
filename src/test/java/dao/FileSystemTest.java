package dao;

import dao.FileSystem;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileSystemTest {
    
    private FileSystem expectedFileSystem = new FileSystem();
    
    public FileSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        File newFile = new File("src/test/java/dao/provinces.JSON");
        expectedFileSystem.setJsonFile(newFile);
        
        File newImgFile = new File("src/test/java/dao/map.bmp");
        expectedFileSystem.setImageFile(newImgFile);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetJsonFile() {
        FileSystem testFileSystem = new FileSystem();
        File newFile = new File("src/test/java/dao/provinces.JSON");
        testFileSystem.setJsonFile(newFile);
        assertEquals(expectedFileSystem.returnJsonFile(), testFileSystem.returnJsonFile());
    }

    @Test
    public void testReturnJsonFile() {
        FileSystem testFileSystem = new FileSystem();
        File newFile = new File("src/test/java/dao/provinces.JSON");
        testFileSystem.setJsonFile(newFile);
        File returnedFile = testFileSystem.returnJsonFile();
        
        assertEquals(expectedFileSystem.returnJsonFile(), returnedFile);
    }
    
    @Test
    public void testSetImageFile() {
        FileSystem testFileSystem = new FileSystem();
        File newFile = new File("src/test/java/dao/map.bmp");
        testFileSystem.setImageFile(newFile);
        assertEquals(expectedFileSystem.returnImageFile(), testFileSystem.returnImageFile());
    }

    @Test
    public void testReturnImageFile() {
        FileSystem testFileSystem = new FileSystem();
        File newFile = new File("src/test/java/dao/map.bmp");
        testFileSystem.setImageFile(newFile);
        File returnedFile = testFileSystem.returnImageFile();
        
        assertEquals(expectedFileSystem.returnImageFile(), returnedFile);
    }
}
