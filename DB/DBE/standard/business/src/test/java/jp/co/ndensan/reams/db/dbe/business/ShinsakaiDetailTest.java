/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiDummyKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GogitaiSeishinkaIshiSonzaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiKyukaiKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会情報のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiDetailTest {

    private static ShinsakaiDetail sut;
    private static ShinsakaiKaisaiNo 審査会開催番号;
    private static FlexibleDate 審査会開催年月日;
    private static TimeString 審査会開始時間;
    private static TimeString 審査会終了時間;
    private static GogitaiDetail 合議体情報;
    private static ShinsakaiKaisaiBasho 開催場所;
    private static int 審査会予定定員;
    private static int 審査会最大定員;
    private static int 審査会自動割当定員;
    private static int 審査会委員定員;
    private static GogitaiSeishinkaIshiSonzaiKubun 精神科医師存在区分;
    private static GogitaiDummyKubun ダミー区分;
    private static FlexibleDate 審査会資料作成年月日;
    private static ShinsakaiKyukaiKubun 休会区分;
    private static int 審査会割当済み人数;

    public static class 審査会情報Builderコンストラクタのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            審査会開催番号 = new ShinsakaiKaisaiNo(1);
            審査会開催年月日 = new FlexibleDate("19800101");
            審査会開始時間 = new TimeString("1234");
            審査会終了時間 = new TimeString("2345");
            合議体情報 = ShinsakaiTestBusinessCreator.create合議体情報(1);
            開催場所 = ShinsakaiTestBusinessCreator.create審査会開催場所("A001");
            審査会予定定員 = 5;
            審査会最大定員 = 6;
            審査会自動割当定員 = 7;
            審査会委員定員 = 8;
            精神科医師存在区分 = GogitaiSeishinkaIshiSonzaiKubun.不在;
            ダミー区分 = GogitaiDummyKubun.ダミー;
            審査会資料作成年月日 = new FlexibleDate("19901010");
            休会区分 = ShinsakaiKyukaiKubun.休会;
            審査会割当済み人数 = 9;
        }

        @Test(expected = NullPointerException.class)
        public void 審査会開催番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(null, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報).build();
        }

        @Test(expected = NullPointerException.class)
        public void 審査会開催年月日にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, null, 審査会開始時間, 審査会終了時間, 合議体情報).build();
        }

        @Test(expected = NullPointerException.class)
        public void 審査会開始時間にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, null, 審査会終了時間, 合議体情報).build();
        }

        @Test(expected = NullPointerException.class)
        public void 審査会終了時間にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, null, 合議体情報).build();
        }

        @Test(expected = NullPointerException.class)
        public void 合議体情報にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, null).build();
        }
    }

    public static class Builder_buildのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 開催場所にnullが設定されたとき_NullPointerExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(null).build();
        }
    }

    public static class Builder_例外処理が存在する各設定メソッドのテスト extends DbeTestBase {

        @Test(expected = IllegalArgumentException.class)
        public void 審査会予定定員に0より小さい数値が設定されたとき_IllegalArgumentExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会予定定員(-1).build();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会最大定員に0より小さい数値が設定されたとき_IllegalArgumentExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会最大定員(-1).build();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会自動割当定員に0より小さい数値が設定されたとき_IllegalArgumentExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会自動割当定員(-1).build();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会委員定員に0より小さい数値が設定されたとき_IllegalArgumentExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会委員定員(-1).build();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会割当済み人数に0より小さい数値が設定されたとき_IllegalArgumentExceptionが発生する() {
            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会割当済み人数(-1).build();
        }
    }

    public static class equalsのテスト extends DbeTestBase {

        private ShinsakaiDetail sut2;

        @Before
        public void setUp() {
            審査会開催番号 = new ShinsakaiKaisaiNo(1);
            審査会開催年月日 = new FlexibleDate("19800101");
            審査会開始時間 = new TimeString("1234");
            審査会終了時間 = new TimeString("2345");
            合議体情報 = ShinsakaiTestBusinessCreator.create合議体情報(1);
            開催場所 = ShinsakaiTestBusinessCreator.create審査会開催場所("A001");
            審査会予定定員 = 5;
            審査会最大定員 = 6;
            審査会自動割当定員 = 7;
            審査会委員定員 = 8;
            精神科医師存在区分 = GogitaiSeishinkaIshiSonzaiKubun.不在;
            ダミー区分 = GogitaiDummyKubun.ダミー;
            審査会資料作成年月日 = new FlexibleDate("19901010");
            休会区分 = ShinsakaiKyukaiKubun.休会;
            審査会割当済み人数 = 9;

            sut = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
        }

        @Test
        public void すべてのメンバが同値であると判断された場合_trueが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(true));
        }

        @Test
        public void 引数にnullが渡されたとき_falseが返る() {
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 引数に型の違うインスタンスが渡されたとき_falseが返る() {
            assertThat(sut.equals(new RString("srt")), is(false));
        }

        @Test
        public void 審査会開催番号が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(new ShinsakaiKaisaiNo(34), 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 審査会開催年月日が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, FlexibleDate.EMPTY, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 審査会開始時間が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, new TimeString("0012"), 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 審査会終了時間が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, new TimeString("0001"), 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 合議体情報が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, ShinsakaiTestBusinessCreator.create合議体情報(24))
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 開催場所が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(ShinsakaiTestBusinessCreator.create審査会開催場所("1")).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員)
                    .set審査会自動割当定員(審査会自動割当定員).set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 審査会予定定員が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(99).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 審査会最大定員が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(99).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 審査会自動割当定員が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(99)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 審査会委員定員が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(99).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 精神科医師存在区分が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(GogitaiSeishinkaIshiSonzaiKubun.存在).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void ダミー区分が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(GogitaiDummyKubun.正規)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 審査会資料作成年月日が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(new FlexibleDate("29991212")).set審査会休会区分(休会区分).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 休会区分が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(ShinsakaiKyukaiKubun.開催).set審査会割当済み人数(審査会割当済み人数).build();
            assertThat(sut.equals(sut2), is(false));
        }

        @Test
        public void 審査会割当済み人数が違う値の場合_falseが返る() {
            sut2 = new ShinsakaiDetail.Builder(審査会開催番号, 審査会開催年月日, 審査会開始時間, 審査会終了時間, 合議体情報)
                    .set審査会開催場所(開催場所).set審査会予定定員(審査会予定定員).set審査会最大定員(審査会最大定員).set審査会自動割当定員(審査会自動割当定員)
                    .set審査会委員定員(審査会委員定員).set精神科医存在区分(精神科医師存在区分).set合議体ダミー区分(ダミー区分)
                    .set審査会資料作成年月日(審査会資料作成年月日).set審査会休会区分(休会区分).set審査会割当済み人数(99).build();
            assertThat(sut.equals(sut2), is(false));
        }
    }
}
