/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.NinteichosahyoInserter;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査票情報Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosahyoDacTest {

    private static NinteichosahyoDac sut;
    private static NinteichosahyoInserter chosahyoInserter;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(NinteichosahyoDac.class);
        chosahyoInserter = InstanceProvider.create(NinteichosahyoInserter.class);
    }

    public static class selectのテスト extends DbeTestDacBase {

        private DbT5009NinteichosahyoJohoEntity result;

        @Before
        public void setUp() {
            chosahyoInserter.insert(IchijiHanteiTestEntityCreator.create認定調査票Entity("A001", 1));
            chosahyoInserter.insert(IchijiHanteiTestEntityCreator.create認定調査票Entity("A001", 2));
            chosahyoInserter.insert(IchijiHanteiTestEntityCreator.create認定調査票Entity("A001", 3));
            result = sut.select(new ShinseishoKanriNo(new RString("A001")));
        }

        @Test
        public void 申請書管理番号がA001の_認定調査票Entityが取得できる() {
            assertThat(result.getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("A001"))));
        }

        @Test
        public void 履歴が存在するとき_最新の認定調査票Entityが取得できる() {
            int 最新履歴番号 = 3;
            assertThat(result.getNinteichosaRirekiNo(), is(最新履歴番号));
        }
    }
}
