/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.IShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4120ShinseitodokedeJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbd.persistence.basic.DbT4120HokenshaShinseitodokedeJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import static org.hamcrest.CoreMatchers.is;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link HokenshaShinseitodokedeJohoManager}のテストクラスです。
 * 
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class HokenshaShinseitodokedeJohoManagerTest {
   
    private static final ShinseishoKanriNo 申請管理番号 = new ShinseishoKanriNo("0000000001"); 
    private static final ShinseishoKanriNo notFound申請管理番号 = new ShinseishoKanriNo("9000000001"); 
      
    public HokenshaShinseitodokedeJohoManagerTest() {
    }
    
     /**
     * Test of find申請届出者情報 method, of class HokenshaShinseitodokedeJohoManager.
     */
    public static class  testFind申請届出者情報 extends DbdTestBase {
        
      private HokenshaShinseitodokedeJohoManager sut;
      private DbT4120HokenshaShinseitodokedeJohoDac dac; 
  
        
    @Before
    public void setUp() {
        dac = mock(DbT4120HokenshaShinseitodokedeJohoDac.class);
        sut = new HokenshaShinseitodokedeJohoManager(dac);
    }
     
  
    private static IShinseitodokedeJoho createBusiness(ShinseishoKanriNo 申請管理番号) {

            IShinseitodokedeJoho business = mock(IShinseitodokedeJoho.class);
            when(business.get申請書管理番号()).thenReturn(申請管理番号);

            return business;
    }  
    
    @Test
    public void testFind申請届出者情報_該当の情報がないとき_Optionalのemptyを返す() {
            Optional<DbT4120ShinseitodokedeJohoEntity> entity = Optional.empty();
            Optional<IShinseitodokedeJoho> business = Optional.empty();

            when(dac.selectByKey(notFound申請管理番号)).thenReturn(entity);
            Optional<IShinseitodokedeJoho> result = sut.find申請届出者情報(notFound申請管理番号);
            assertThat(result, is(business));
    }    
    
        

    @Test
    public void testFind申請届出者情報_該当の情報があるとき_該当情報を返す() {
            ShinseishoKanriNo DEFAULT_申請管理番号 = new ShinseishoKanriNo("0000000001");
  
            IShinseitodokedeJoho business = createBusiness(DEFAULT_申請管理番号);

            Optional<DbT4120ShinseitodokedeJohoEntity> entity = Optional.ofNullable(DbT4120ShinseitodokedeJohoEntityGenerator.createDbT4120ShinseitodokedeJohoEntity());

            when(dac.selectByKey(申請管理番号)).thenReturn(entity);
            Optional<IShinseitodokedeJoho> result = sut.find申請届出者情報(申請管理番号);
            assertThat(result.get().get申請書管理番号().value(), is(business.get申請書管理番号().value()));
       }
    }
    
}
