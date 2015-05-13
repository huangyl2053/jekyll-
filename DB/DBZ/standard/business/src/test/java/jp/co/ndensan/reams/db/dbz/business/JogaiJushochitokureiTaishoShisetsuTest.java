/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 介護除外・住所地特例対象施設を扱うクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JogaiJushochitokureiTaishoShisetsuTest extends DbzTestBase {

    private static JogaiJushochitokureiTaishoShisetsu sut;
    private static ShisetsuType 施設種類;
    private static ShisetsuCode 施設コード;
    private static RDateTime 処理日時;
    private static Range<FlexibleDate> 有効期間;
    private static ShikibetsuCode 識別コード;
    private static RString 施設略称;
    private static RString 施設略称カナ;
    private static RString 施設住所カナ;
    private static RString 異動事由コード;
    private static FlexibleDate 異動年月日;
    private static RString 法人種別コード;
    private static FlexibleDate 施設開始年月日;
    private static FlexibleDate 施設休止年月日;
    private static FlexibleDate 施設廃止年月日;
    private static FlexibleDate 施設再開年月日;

    @BeforeClass
    public static void setUp() {
        施設種類 = ShisetsuType.介護保険施設;
        //ShisetsuCodeがfinalのため、コメントアウトし、施設コードのインスタンスを生成
//        施設コード = mock(ShisetsuCode.class);
        施設コード = new ShisetsuCode(new RString("施設コード"));
        処理日時 = mock(RDateTime.class);
        有効期間 = create有効期間();
        識別コード = mock(ShikibetsuCode.class);
        施設略称 = new RString("ひまわり");
        施設略称カナ = new RString("ヒマワリ");
        施設住所カナ = new RString("オミムラ");
        異動事由コード = new RString("11");
        異動年月日 = mock(FlexibleDate.class);
        法人種別コード = new RString("01");
        施設開始年月日 = mock(FlexibleDate.class);
        施設休止年月日 = mock(FlexibleDate.class);
        施設廃止年月日 = mock(FlexibleDate.class);
        施設再開年月日 = mock(FlexibleDate.class);
    }

    public static class constructor extends DbzTestBase {

        @Test
        public void 引数に必要な値が渡された時_インスタンスが生成される() {
            sut = new JogaiJushochitokureiTaishoShisetsu(
                    施設種類, 施設コード, 処理日時,
                    有効期間, 識別コード,
                    施設略称, 施設略称カナ, 施設住所カナ,
                    異動事由コード, 異動年月日, 法人種別コード,
                    施設開始年月日, 施設休止年月日,
                    施設廃止年月日, 施設再開年月日);
            assertThat(sut, is(instanceOf(JogaiJushochitokureiTaishoShisetsu.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 施設種類がnullの時_NullPointerExceptionが発生する() {
            sut = new JogaiJushochitokureiTaishoShisetsu(
                    null, 施設コード, 処理日時,
                    有効期間, 識別コード,
                    施設略称, 施設略称カナ, 施設住所カナ,
                    異動事由コード, 異動年月日, 法人種別コード,
                    施設開始年月日, 施設休止年月日,
                    施設廃止年月日, 施設再開年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 施設コードがnullの時_NullPointerExceptionが発生する() {
            sut = new JogaiJushochitokureiTaishoShisetsu(
                    施設種類, null, 処理日時,
                    有効期間, 識別コード,
                    施設略称, 施設略称カナ, 施設住所カナ,
                    異動事由コード, 異動年月日, 法人種別コード,
                    施設開始年月日, 施設休止年月日,
                    施設廃止年月日, 施設再開年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの時_NullPointerExceptionが発生する() {
            sut = new JogaiJushochitokureiTaishoShisetsu(
                    施設種類, 施設コード, null,
                    有効期間, 識別コード,
                    施設略称, 施設略称カナ, 施設住所カナ,
                    異動事由コード, 異動年月日, 法人種別コード,
                    施設開始年月日, 施設休止年月日,
                    施設廃止年月日, 施設再開年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効期間がnullの時_NullPointerExceptionが発生する() {
            sut = new JogaiJushochitokureiTaishoShisetsu(
                    施設種類, 施設コード, 処理日時,
                    null, 識別コード,
                    施設略称, 施設略称カナ, 施設住所カナ,
                    異動事由コード, 異動年月日, 法人種別コード,
                    施設開始年月日, 施設休止年月日,
                    施設廃止年月日, 施設再開年月日);
        }
    }

    private static Range<FlexibleDate> create有効期間() {
        FlexibleDate 開始年月日 = mock(FlexibleDate.class);
        FlexibleDate 終了年月日 = mock(FlexibleDate.class);
        return new Range(開始年月日, 終了年月日);
    }
}
