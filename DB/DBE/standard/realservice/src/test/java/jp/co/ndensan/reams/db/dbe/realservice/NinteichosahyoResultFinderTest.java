/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.NinteichosahyoKaitoHairetsuCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.NinteichosahyoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 認定調査票結果Finderのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosahyoResultFinderTest {

    private static NinteichosahyoResultFinder sut;

    public static class get認定調査票回答結果のテスト extends DbeTestBase {

        @Test
        public void 認定調査票の回答結果が取得できる() {
            sut = new NinteichosahyoResultFinder(createDacMock());
            NinteichosahyoKaitoHairetsuCode result = sut.get認定調査票回答結果(new ShinseishoKanriNo(new RString("A001")));
            assertThat(result.get調査項目回答(),
                    is(new RString("22222111112222211111222223333311111222223333344444111112222233333444445555511111222223333344444555556")));
        }

        private NinteichosahyoDac createDacMock() {
            NinteichosahyoDac dac = mock(NinteichosahyoDac.class);
            DbT5009NinteichosahyoJohoEntity entity = IchijiHanteiTestEntityCreator.create認定調査票Entity();
            when(dac.select(any(ShinseishoKanriNo.class))).thenReturn(entity);
            return dac;
        }
    }
}
