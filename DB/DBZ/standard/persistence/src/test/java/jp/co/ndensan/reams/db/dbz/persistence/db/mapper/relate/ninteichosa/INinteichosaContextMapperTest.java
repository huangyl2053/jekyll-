/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteichosa;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteichosa.NinteichosaContextMapperParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * {@link INinteichosaContextMapper}のテストです。
 */
public class INinteichosaContextMapperTest extends DbeTestDacBase {

    public INinteichosaContextMapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        beforeSetUpClass();
    }

    @Test
    public void testSomeMethod() {
        INinteichosaContextMapper sut = this.sqlSession.getMapper(INinteichosaContextMapper.class);
        NinteichosaContextMapperParameter param = NinteichosaContextMapperParameter.hasBeenExaminedBefore(new RString("20211900000049535"), 1);
        System.out.println(sut.hasBeenExaminedBefore(param));
    }

}
