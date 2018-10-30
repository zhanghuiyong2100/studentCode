/*
package junittest;

*/
/**
 * @author 章辉勇
 * @创建时间 2018年10月22日
 * @描述: 单元测试基础01
 **//*


public class LargestTest {
    public LargestTest(String name) {
        super(name);
    }

    //test numbers
    public void testNums() {
        //general test
        assertEquals(9, Largest.largest(new int[]{7, 8, 9}));
        //order test
        assertEquals(9, Largest.largest(new int[]{7, 9, 8}));
        assertEquals(9, Largest.largest(new int[]{9, 8, 7}));
        //repetition test
        assertEquals(9, Largest.largest(new int[]{7, 9, 8, 9}));
        //single test
        assertEquals(9, Largest.largest(new int[]{9}));
        //negative test
        assertEquals(-7, Largest.largest(new int[]{-7, -8, -9}));
    }

    //test empty
    public void testisEmpty() {
        try {
            Largest.largest(new int[]{});
            fail("An exception should been thrown!");
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }
}
*/
