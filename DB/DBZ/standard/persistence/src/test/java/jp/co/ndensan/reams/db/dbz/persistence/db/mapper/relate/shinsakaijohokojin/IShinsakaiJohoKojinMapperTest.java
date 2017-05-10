/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinsakaijohokojin;

//import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * {@link IShinsakaiJohoKojinMapper}のテストです。
 */
public class IShinsakaiJohoKojinMapperTest extends DbeTestDacBase {

    public IShinsakaiJohoKojinMapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        beforeSetUpClass();
    }

    @Test
    public void testSomeMethod() {
        IShinsakaiJohoKojinMapper sut = this.sqlSession.getMapper(IShinsakaiJohoKojinMapper.class);
//        System.out.println(sut.getKaisaikekkaandbashojoho(new ShinseishoKanriNo("20973220170300341"), RString.EMPTY).get審査会意見());
    }

}
