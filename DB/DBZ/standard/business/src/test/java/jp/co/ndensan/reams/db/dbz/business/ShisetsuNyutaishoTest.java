/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 施設入退所情報を表すクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoTest extends DbzTestBase {

    private static ShisetsuNyutaisho sut;
    private static LasdecCode 市町村コード;
    private static ShikibetsuCode 個人識別コード;
    private static RDateTime 処理日時;
    private static DaichoType 台帳種別;
    private static Range<FlexibleDate> 入所期間;
    private static NyushoShisetsu 入所施設;
    private static FlexibleDate 入所処理年月日;
    private static FlexibleDate 退所処理年月日;

    @BeforeClass
    public static void setUp() {
        市町村コード = mock(LasdecCode.class);
        個人識別コード = mock(ShikibetsuCode.class);
        処理日時 = mock(RDateTime.class);
        台帳種別 = DaichoType.他市町村住所地特例者;
        入所期間 = create期間();
        入所施設 = mock(NyushoShisetsu.class);
        入所処理年月日 = mock(FlexibleDate.class);
        退所処理年月日 = mock(FlexibleDate.class);
    }

    public static class Constructor extends DbzTestBase {

        @Test
        public void 引数に必要な値が渡された時_インスタンスが生成される() {
            sut = new ShisetsuNyutaisho(市町村コード, 個人識別コード, 処理日時,
                    台帳種別, 入所期間, 入所施設, 入所処理年月日, 退所処理年月日);
            assertThat(sut, is(instanceOf(ShisetsuNyutaisho.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの時_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaisho(null, 個人識別コード, 処理日時,
                    台帳種別, 入所期間, 入所施設, 入所処理年月日, 退所処理年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 個人識別コードがnullの時_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaisho(市町村コード, null, 処理日時,
                    台帳種別, 入所期間, 入所施設, 入所処理年月日, 退所処理年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの時_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaisho(市町村コード, 個人識別コード, null,
                    台帳種別, 入所期間, 入所施設, 入所処理年月日, 退所処理年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 台帳種別がnullの時_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaisho(市町村コード, 個人識別コード, 処理日時,
                    null, 入所期間, 入所施設, 入所処理年月日, 退所処理年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 入所期間がnullの時_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaisho(市町村コード, 個人識別コード, 処理日時,
                    台帳種別, null, 入所施設, 入所処理年月日, 退所処理年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 入所施設がnullの時_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaisho(市町村コード, 個人識別コード, 処理日時,
                    台帳種別, 入所期間, null, 入所処理年月日, 退所処理年月日);
        }
    }

    private static Range<FlexibleDate> create期間() {
        FlexibleDate 開始年月日 = mock(FlexibleDate.class);
        FlexibleDate 終了年月日 = mock(FlexibleDate.class);
        return new Range(開始年月日, 終了年月日);
    }
}
