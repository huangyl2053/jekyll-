/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiYukoKikanKaishiYMD;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 合議体情報のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiJohoTest {

    private static GogitaiJoho sut1;
    private static GogitaiJoho sut2;
    private static GogitaiNo 合議体番号_1 = new GogitaiNo(1);
    private static RString 合議体名称_ABC = new RString("ABC");
    private static GogitaiYukoKikanKaishiYMD 有効期間開始年月日_19990101 = new GogitaiYukoKikanKaishiYMD("19990101");
    private static FlexibleDate 有効期間終了年月日_20100101 = new FlexibleDate("20100101");
    private static Range<TimeString> 開始終了予定時刻_0930_1730 = new Range<>(new TimeString("0930"), new TimeString("1730"));
    private static ShinsakaiKaisaiBasho 審査会開催場所_A001 = create審査会開催場所("A001");
    private static int 審査会予定定員_5 = 5;
    private static int 審査会自動割当定員_4 = 4;
    private static int 審査会委員定員_6 = 6;
    private static GogitaiSeishinkaIshiSonzaiKubun 精神科医師存在_存在 = GogitaiSeishinkaIshiSonzaiKubun.存在;
    private static GogitaiDummyKubun 合議体ダミー_正規 = GogitaiDummyKubun.正規;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test
        public void 必要項目が引数に渡されているとき_インスタンスが生成される() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 0, 0, 0, null, null);
            assertThat(sut1, is(instanceOf(GogitaiJoho.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 合議体番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut1 = new GogitaiJoho(null, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 審査会予定定員_5, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test(expected = NullPointerException.class)
        public void 合議体名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut1 = new GogitaiJoho(合議体番号_1, null, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 審査会予定定員_5, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test(expected = NullPointerException.class)
        public void 有効期間開始年月日にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, null, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 審査会予定定員_5, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test(expected = NullPointerException.class)
        public void 有効期間終了年月日にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, null,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 審査会予定定員_5, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test(expected = NullPointerException.class)
        public void 開始終了予定時刻にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    null, 審査会開催場所_A001, 審査会予定定員_5, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test(expected = NullPointerException.class)
        public void 審査会開催場所にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, null, 審査会予定定員_5, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会予定定員に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, -1, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会自動割当定員に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 審査会予定定員_5,
                    -1, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会委員定員に0より小さい値が渡されたとき_IllegalArgumentExceptionが発生する() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 審査会予定定員_5, 審査会自動割当定員_4,
                    -1, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test
        public void 審査会予定定_審査会自動割当定員員_審査会委員定員それぞれに_0以上の値が渡されたとき_インスタンスが生成される() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 0, 0, 0, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1, is(instanceOf(GogitaiJoho.class)));
        }
    }

    public static class hashCodeのテスト extends DbeTestBase {

        @Test
        public void インスタンスが持つすべての要素が同一であるとき_hashCodeは同値になる() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 審査会予定定員_5, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 審査会予定定員_5, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.hashCode(), is(equalTo(sut2.hashCode())));
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            sut1 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101,
                    開始終了予定時刻_0930_1730, 審査会開催場所_A001, 審査会予定定員_5, 審査会自動割当定員_4,
                    審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
        }

        @Test
        public void nullが渡されたとき_を返す() {
            assertThat(sut1.equals(null), is(false));
        }

        @Test
        public void 型の違うオブジェクトが渡されたとき_falseを返す() {
            assertThat(sut1.equals(new RString("001")), is(false));
        }

        @Test
        public void 合議体番号が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(new GogitaiNo(12), 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 合議体名称が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, new RString("EDF"), 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 合議体有効期間開始年月日が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, new GogitaiYukoKikanKaishiYMD("20010101"), 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 有効期間終了年月日が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, new FlexibleDate("23232323"), 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 開始予定時刻が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, new Range<>(new TimeString("0000"), new TimeString("1730")), 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 終了予定時刻が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, new Range<>(new TimeString("0930"), new TimeString("2359")), 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 審査会開催場所が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, create審査会開催場所("B001"),
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 審査会予定定員が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    78, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 審査会自動割当定員が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    審査会予定定員_5, 12, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 審査会委員定員が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 33, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 精神科医師存在が同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, GogitaiSeishinkaIshiSonzaiKubun.不在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 合議体ダミーが同値で無い場合_falseを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, GogitaiDummyKubun.ダミー);
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 合議体番号と合議体有効期間開始年月日が同値であるとき_trueを返す() {
            sut2 = new GogitaiJoho(合議体番号_1, 合議体名称_ABC, 有効期間開始年月日_19990101, 有効期間終了年月日_20100101, 開始終了予定時刻_0930_1730, 審査会開催場所_A001,
                    審査会予定定員_5, 審査会自動割当定員_4, 審査会委員定員_6, 精神科医師存在_存在, 合議体ダミー_正規);
            assertThat(sut1.equals(sut2), is(true));
        }
    }

    private static ShinsakaiKaisaiBasho create審査会開催場所(String 開催場所コード) {
        ShinsakaiKaisaiBasho kaisaiBasho = mock(ShinsakaiKaisaiBasho.class);
        when(kaisaiBasho.get開催場所コード()).thenReturn(new ShinsakaiKaisaiBashoCode(new RString(開催場所コード)));
        return kaisaiBasho;
    }
}
