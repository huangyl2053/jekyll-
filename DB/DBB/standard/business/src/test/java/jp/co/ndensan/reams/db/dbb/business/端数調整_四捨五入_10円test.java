package jp.co.ndensan.reams.db.dbb.business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jp.co.ndensan.reams.db.dbb.business.I端数調整;
import jp.co.ndensan.reams.db.dbb.business.端数調整_四捨五入_10円;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author n3336
 */
public class 端数調整_四捨五入_10円test {
    
    public 端数調整_四捨五入_10円test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void 四捨五入されているか_端数が4の場合に切り捨てられる(){
        I端数調整 test = new 端数調整_四捨五入_10円();
        assertThat(test.Calc端数(new Decimal("9994")), is(new Decimal("9990")));
    }
    
    @Test
    public void 四捨五入されているか_端数が5の場合切り上げられる(){
        I端数調整 test = new 端数調整_四捨五入_10円();
        assertThat(test.Calc端数(new Decimal("9995")), is(new Decimal("10000")));
    }
    
    @Test
    public void 四捨五入されているか_端数が6の場合切り上げられる(){
        I端数調整 test = new 端数調整_四捨五入_10円();
        assertThat(test.Calc端数(new Decimal("9996")), is(new Decimal("10000")));
    }
    
}
