/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import jp.co.ndensan.reams.db.dbx.business.IKogakuKaigoServiceHi;
import jp.co.ndensan.reams.db.dbx.persistence.basic.IKogakuKaigoServiceHiDac;
import jp.co.ndensan.reams.db.dbx.realservice.helper.MockKogakuKaigoServiceHiEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link _KogakuKaigoServiceHiFinder}のテストクラスです。
 *
 * @author n9943 王 永康
 */
@RunWith(Enclosed.class)
public class _KogakuKaigoServiceHiFinderTest extends DbxTestBase {

    public static class Get支給情報テスト extends DbxTestBase {

        IKogakuKaigoServiceHiFinder sut;
        IKogakuKaigoServiceHiDac dac;
        IKogakuKaigoServiceHi result;

        @Before
        public void setUp() {
            dac = mock(IKogakuKaigoServiceHiDac.class);
            sut = new _KogakuKaigoServiceHiFinder(dac);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByShikibetsuCodeは_例外を投げる() {
            sut.get支給情報(null, mock(FlexibleYearMonth.class));
        }

        @Test(expected = NullPointerException.class)
        public void 対象年月がnullの場合_selectByShikibetsuCodeは_例外を投げる() {
            sut.get支給情報(RString.EMPTY, null);
        }

        @Test
        public void 検索結果が0件の場合_get支給情報は_nullを返す() {
            when(dac.select(any(RString.class), any(FlexibleYearMonth.class))).thenReturn(null);
            result = sut.get支給情報(RString.EMPTY, mock(FlexibleYearMonth.class));
            assertNull(result);
        }

        @Test
        public void 検索結果が1件の場合_get支給情報は_高額介護サービス費取得のインスタンスを返す() {
            when(dac.select(any(RString.class), any(FlexibleYearMonth.class))).thenReturn(MockKogakuKaigoServiceHiEntity.getSpiedInstance());
            result = sut.get支給情報(RString.EMPTY, mock(FlexibleYearMonth.class));
            assertThat(result, instanceOf(IKogakuKaigoServiceHi.class));
        }
    }
}
