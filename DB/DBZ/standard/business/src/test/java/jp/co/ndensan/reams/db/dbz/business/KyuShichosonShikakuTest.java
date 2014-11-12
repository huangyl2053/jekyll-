/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.IHihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.GesshoGetsumatsuKubun.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 旧市町村の被保険者情報を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyuShichosonShikakuTest extends DbzTestBase {

    public static class コンストラクタ {

        KyuShichosonShikaku sut;

        @Test(expected = NullPointerException.class)
        public void 被保険者台帳Listがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KyuShichosonShikaku(null);
        }
    }

    public static class get最新旧市町村資格履歴 {

        KyuShichosonShikaku sut;
        private final FlexibleDate 基準年月日 = new FlexibleDate("20140415");
        private final FlexibleDate 非暦上年月日 = new FlexibleDate("99999999");
        private final FlexibleDate 基準時最新取得日 = new FlexibleDate("20140410");

        @Before
        public void setUp() {
            List<IHihokenshaDaicho> 被保険者台帳List = new ArrayList<>();
            被保険者台帳List.add(create被保険者台帳("20140301"));
            被保険者台帳List.add(create被保険者台帳("20140401"));
            被保険者台帳List.add(create被保険者台帳("20140410"));
            被保険者台帳List.add(create被保険者台帳("20140420"));
            被保険者台帳List.add(create被保険者台帳("20140430"));
            被保険者台帳List.add(create被保険者台帳("20140501"));
            sut = new KyuShichosonShikaku(被保険者台帳List);
        }

        @Test(expected = NullPointerException.class)
        public void 基準年月日がnullの時_get最新旧市町村資格履歴は_NullPointerExceptionを投げる() {
            sut.get最新旧市町村被保険者情報(null);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 基準年月日が非暦上年月日の時_get最新旧市町村資格履歴は_IllegalArgumentExceptionを投げる() {
            sut.get最新旧市町村被保険者情報(非暦上年月日);
        }

        @Test
        public void 基準年月日の指定がある時_get最新旧市町村資格履歴は_基準年月日時点の最新履歴を返す() {
            assertThat(sut.get最新旧市町村被保険者情報(基準年月日).get().get資格取得日(), is(基準時最新取得日));
        }
    }

    public static class get月別最新旧市町村資格履歴 {

        KyuShichosonShikaku sut;
        private final FlexibleYear 基準年度 = new FlexibleYear("2013");
        private final FlexibleYear 非暦上年度 = new FlexibleYear("9999");
        private final FlexibleDate 基準時最新取得日_4月 = new FlexibleDate("20130415");
        private final int 基準日 = 20;
        private final int 非暦上日 = 99;
        private final int 月数 = 12;

        @Before
        public void setUp() {
            List<IHihokenshaDaicho> 被保険者台帳List = new ArrayList<>();
            for (int year = 2012; year <= 2014; year++) {
                for (int month = 1; month <= 12; month++) {
                    被保険者台帳List.add(create被保険者台帳(String.format("%1$04d%2$02d%3$02d", year, month, 5)));
                    被保険者台帳List.add(create被保険者台帳(String.format("%1$04d%2$02d%3$02d", year, month, 15)));
                    被保険者台帳List.add(create被保険者台帳(String.format("%1$04d%2$02d%3$02d", year, month, 25)));
                }
            }
            sut = new KyuShichosonShikaku(被保険者台帳List);
        }

        @Test(expected = NullPointerException.class)
        public void 基準年度がnullの時_get月別最新旧市町村資格履歴は_NullPointerExceptionを投げる() {
            sut.get月別最新旧市町村被保険者情報(null, 基準日);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 基準年度が非暦上年度の時_get月別最新旧市町村資格履歴は_IllegalArgumentExceptionを投げる() {
            sut.get月別最新旧市町村被保険者情報(非暦上年度, 基準日);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 基準日が非暦上日の時_get月別最新旧市町村資格履歴は_IllegalArgumentExceptionを投げる() {
            sut.get月別最新旧市町村被保険者情報(基準年度, 非暦上日);
        }

        @Test
        public void 基準年度の指定がある時_get月別最新旧市町村資格履歴は_基準年度の月数分の履歴を返す() {
            assertThat(sut.get月別最新旧市町村被保険者情報(基準年度, 基準日).size(), is(月数));
        }

        @Test
        public void 基準年度と基準日の指定がある時_get月別最新旧市町村資格履歴は_基準年度の月別基準日時点の最新履歴を返す() {
            assertThat(sut.get月別最新旧市町村被保険者情報(基準年度, 基準日).asList().get(0).get資格取得日(), is(基準時最新取得日_4月));
        }
    }

    public static class get最古旧市町村資格履歴 {

        KyuShichosonShikaku sut;
        private final FlexibleDate 最古取得日 = new FlexibleDate("20140301");

        @Before
        public void setUp() {
            List<IHihokenshaDaicho> 被保険者台帳List = new ArrayList<>();
            被保険者台帳List.add(create被保険者台帳("20140301"));
            被保険者台帳List.add(create被保険者台帳("20140401"));
            被保険者台帳List.add(create被保険者台帳("20140410"));
            被保険者台帳List.add(create被保険者台帳("20140420"));
            被保険者台帳List.add(create被保険者台帳("20140430"));
            被保険者台帳List.add(create被保険者台帳("20140501"));
            sut = new KyuShichosonShikaku(被保険者台帳List);
        }

        @Test
        public void 被保険者台帳Listの指定がある時_get最古旧市町村資格履歴は_最古履歴を返す() {
            assertThat(sut.get最古旧市町村被保険者情報().get().get資格取得日(), is(最古取得日));
        }
    }

    public static class get旧市町村資格履歴By月初月末指定 {

        KyuShichosonShikaku sut;
        private final FlexibleYearMonth 基準年月_取得日該当 = new FlexibleYearMonth("201404");
        private final FlexibleYearMonth 基準年月_喪失日該当 = new FlexibleYearMonth("201405");
        private final FlexibleYearMonth 基準年月_該当無 = new FlexibleYearMonth("201407");
        private final FlexibleYearMonth 非暦上年月 = new FlexibleYearMonth("999999");
        private final FlexibleDate 基準時最古取得日 = new FlexibleDate("20140405");
        private final FlexibleDate 基準時最古喪失日 = new FlexibleDate("20140505");
        private final FlexibleDate 基準時最新取得日 = new FlexibleDate("20140425");
        private final FlexibleDate 最新取得日 = new FlexibleDate("20140601");

        @Before
        public void setUp() {
            List<IHihokenshaDaicho> 被保険者台帳List = new ArrayList<>();
            被保険者台帳List.add(create被保険者台帳("20140301", "20140320"));
            被保険者台帳List.add(create被保険者台帳("20140405", "20140505"));
            被保険者台帳List.add(create被保険者台帳("20140415", "20140515"));
            被保険者台帳List.add(create被保険者台帳("20140425", "20140525"));
            被保険者台帳List.add(create被保険者台帳("20140601", "20140620"));
            sut = new KyuShichosonShikaku(被保険者台帳List);
        }

        @Test(expected = NullPointerException.class)
        public void 基準年月がnullの時_get旧市町村資格履歴By月初月末指定は_NullPointerExceptionを投げる() {
            sut.get旧市町村被保険者情報By月初月末指定(null, 指定無);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 基準年月が非暦上年月の時_get旧市町村資格履歴By月初月末指定は_IllegalArgumentExceptionを投げる() {
            sut.get旧市町村被保険者情報By月初月末指定(非暦上年月, 指定無);
        }

        @Test
        public void 月初月末区分が指定無の時_get旧市町村資格履歴By月初月末指定は_資格取得日が基準年月の最古履歴を返す() {
            assertThat(sut.get旧市町村被保険者情報By月初月末指定(基準年月_取得日該当, 指定無).get().get資格取得日(), is(基準時最古取得日));
        }

        @Test
        public void 月初月末区分が指定無の時_get旧市町村資格履歴By月初月末指定は_資格喪失日が基準年月の最古履歴を返す() {
            assertThat(sut.get旧市町村被保険者情報By月初月末指定(基準年月_喪失日該当, 指定無).get().get資格喪失日(), is(基準時最古喪失日));
        }

        @Test
        public void 月初月末区分が指定無_該当履歴無の時_get旧市町村資格履歴By月初月末指定は_基準年月時点の最新履歴を返す() {
            assertThat(sut.get旧市町村被保険者情報By月初月末指定(基準年月_該当無, 指定無).get().get資格取得日(), is(最新取得日));
        }

        @Test
        public void 月初月末区分が月初の時_get旧市町村資格履歴By月初月末指定は_資格取得日が基準年月の最古履歴を返す() {
            assertThat(sut.get旧市町村被保険者情報By月初月末指定(基準年月_取得日該当, 月初).get().get資格取得日(), is(基準時最古取得日));
        }

        @Test
        public void 月初月末区分が月初の時_get旧市町村資格履歴By月初月末指定は_資格喪失日が基準年月の最古履歴を返す() {
            assertThat(sut.get旧市町村被保険者情報By月初月末指定(基準年月_喪失日該当, 月初).get().get資格喪失日(), is(基準時最古喪失日));
        }

        @Test
        public void 月初月末区分が月初_該当履歴無の時_get旧市町村資格履歴By月初月末指定は_基準年月時点の最新履歴を返す() {
            assertThat(sut.get旧市町村被保険者情報By月初月末指定(基準年月_該当無, 月初).get().get資格取得日(), is(最新取得日));
        }

        @Test
        public void 月初月末区分が月末の時_get旧市町村資格履歴By月初月末指定は_基準年月時点の最新履歴を返す() {
            assertThat(sut.get旧市町村被保険者情報By月初月末指定(基準年月_取得日該当, 月末).get().get資格取得日(), is(基準時最新取得日));
        }
    }

    public static class edit旧市町村資格履歴 {

        KyuShichosonShikaku sut;
        private static final LasdecCode 旧市町村コードFrom証記載保険者番号 = new LasdecCode("000001");
        private static final LasdecCode 旧市町村コードFrom広住特措置元保険者番号 = new LasdecCode("000002");
        private static final LasdecCode 市町村コードFrom広住特措置元市町村コード = new LasdecCode("000002");
        private static final FlexibleDate 資格喪失日_固定値 = new FlexibleDate(new RString("99999999"));

        @Before
        public void setUp() {
            List<IHihokenshaDaicho> 被保険者台帳List = new ArrayList<>();
            被保険者台帳List.add(create被保険者台帳("000001", "20140101", "", ""));
            被保険者台帳List.add(create被保険者台帳("000001", "", "000002", ""));
            sut = new KyuShichosonShikaku(被保険者台帳List);
        }

        @Test
        public void 旧市町村コードと広住特措置元保険者番号がEMPTYの時_edit旧市町村資格履歴は_旧市町村コードに証記載保険者番号を設定する() {
            assertThat(sut.edit旧市町村被保険者情報().asList().get(0).get旧市町村コード(), is(旧市町村コードFrom証記載保険者番号));
        }

        @Test
        public void 旧市町村コードがEMPTYかつ広住特措置元保険者番号がEMPTY以外の時_edit旧市町村資格履歴は_旧市町村コードに広住特措置元保険者番号を設定する() {
            assertThat(sut.edit旧市町村被保険者情報().asList().get(1).get旧市町村コード(), is(旧市町村コードFrom広住特措置元保険者番号));
        }

        @Test
        public void 広住特措置元保険者番号がEMPTY以外の時_edit旧市町村資格履歴は_市町村コードに広住特措置元市町村コードを設定する() {
            assertThat(sut.edit旧市町村被保険者情報().asList().get(1).get市町村コード(), is(市町村コードFrom広住特措置元市町村コード));
        }

        @Test
        public void 資格喪失日がEMPTYの時_edit旧市町村資格履歴は_資格喪失日に固定値を設定を設定する() {
            assertThat(sut.edit旧市町村被保険者情報().asList().get(1).get資格喪失日(), is(資格喪失日_固定値));
        }
    }

    private static IHihokenshaDaicho create被保険者台帳(String 資格取得日) {
        return create被保険者台帳(資格取得日, 資格取得日);
    }

    private static IHihokenshaDaicho create被保険者台帳(String 資格取得日, String 資格喪失日) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setShikakuShutokuYMD(new FlexibleDate(資格取得日));
        entity.setShikakuSoshitsuYMD(new FlexibleDate(資格喪失日));
        return new HihokenshaDaichoModel(entity);
    }

    private static IHihokenshaDaicho create被保険者台帳(String 市町村コード, String 資格喪失日, String 広住特措置元市町村コード, String 旧市町村コード) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setShichosonCode(new LasdecCode(new RString(市町村コード)));
        entity.setShikakuSoshitsuYMD(new FlexibleDate(資格喪失日));
        entity.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode(広住特措置元市町村コード));
        entity.setKyuShichosonCode(new LasdecCode(旧市町村コード));
        return new HihokenshaDaichoModel(entity);
    }
}
