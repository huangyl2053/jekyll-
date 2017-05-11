/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinsakaijohokojin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin.KaisaiKekkaAndBashoJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 *
 */
public class IShinsakaiJohoKojinMapperTest extends DbeTestDacBase {

    public IShinsakaiJohoKojinMapperTest() {
    }

    public static void setUpClass() {
        beforeSetUpClass();
    }

    @Test
    public void testSomeMethod() {
        IShinsakaiJohoKojinMapper sut = this.sqlSession.getMapper(IShinsakaiJohoKojinMapper.class);
        KaisaiKekkaAndBashoJohoEntity result = sut.getKaisaikekkaandbashojoho(new ShinseishoKanriNo("20211920150900069"), RString.EMPTY);
        System.out.println(result.get介護認定審査会開催番号());
    }
}
