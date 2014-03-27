/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.ShujiIkenshoShosaiJohoInserter;
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
 * 主治医意見書詳細情報Dacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoShosaiJohoDacTest {

    private static ShujiiIkenshoShosaiJohoDac sut;
    private static ShujiIkenshoShosaiJohoInserter shujiiInserter;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(ShujiiIkenshoShosaiJohoDac.class);
        shujiiInserter = InstanceProvider.create(ShujiIkenshoShosaiJohoInserter.class);
    }

    public static class selectのテスト extends DbeTestDacBase {

        private DbT5013ShujiiIkenshoShosaiJohoEntity result;

        @Before
        public void setUp() {
            shujiiInserter.insert(IchijiHanteiTestEntityCreator.create主治医意見書5項目Entity("A001", 1));
            shujiiInserter.insert(IchijiHanteiTestEntityCreator.create主治医意見書5項目Entity("A001", 2));
            result = sut.select(new ShinseishoKanriNo(new RString("A001")));
        }

        @Test
        public void 申請書管理番号がA001の_主治医意見書Entityが取得できる() {
            assertThat(result.getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("A001"))));
        }

        @Test
        public void 履歴番号が2の_主治医意見書Entityが取得できる() {
            assertThat(result.getIkenshoIraiRirekiNo(), is(2));
        }
    }
}
