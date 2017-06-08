/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.yokaigoninteitasklist;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * {@link IYokaigoNinteiTaskListMapper}のテストです。
 */
public class IYokaigoNinteiTaskListMapperTest extends DbzTestDacBase {

    public IYokaigoNinteiTaskListMapperTest() {
    }

    @BeforeClass
    public static void beforeClass() {
        setUpClass();
    }

    @Test
    public void testSomeMethod() {
        YokaigoNinteiTaskListParameter p = YokaigoNinteiTaskListParameter.createParameter(new RString("0"), new RString("3"));
        this.sqlSession.getMapper(IYokaigoNinteiTaskListMapper.class).getマスキング(p);
    }

}
