/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.ShujiiIkensho5Komoku;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShujiiIkenshoShosaiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * 主治医意見書5項目Finderのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShujiiIkensho5KomokuFinderTest {

    private static ShujiiIkensho5KomokuFinder sut;

    public static class get主治医意見書5項目のテスト extends DbeTestBase {

        @Test
        public void 主治医意見書5項目の回答結果が取得できる() {
            sut = new ShujiiIkensho5KomokuFinder(createDacMock());
            ShinseishoKanriNo 管理番号 = new ShinseishoKanriNo(new RString("A001"));
            IkenshosakuseiIraiRirekiNo 履歴番号 = new IkenshosakuseiIraiRirekiNo(12);
            ShujiiIkensho5Komoku result = sut.get主治医意見書5項目(管理番号, 履歴番号);
            assertThat(result.get5項目回答(), is(new RString("12231")));
        }

        private ShujiiIkenshoShosaiJohoDac createDacMock() {
            ShujiiIkenshoShosaiJohoDac dac = mock(ShujiiIkenshoShosaiJohoDac.class);
            DbT5013ShujiiIkenshoShosaiJohoEntity entity = IchijiHanteiTestEntityCreator.create主治医意見書5項目EntitySpy("12231");
            when(dac.select(any(ShinseishoKanriNo.class), any(IkenshosakuseiIraiRirekiNo.class))).thenReturn(entity);
            return dac;
        }
    }
}
