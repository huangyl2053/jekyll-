/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihonBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihonBuilder;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3038ShokanKihonEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShokanKihonBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanKihonBuilderTest extends DbcTestBase {

    private static DbT3038ShokanKihonEntity ShokanKihonEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3038ShokanKihonEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3038ShokanKihonEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3038ShokanKihonEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3038ShokanKihonEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3038ShokanKihonEntityGenerator.DEFAULT_明細番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static ShokanKihonBuilder sut;
        private static ShokanKihon business;

        @Before
        public void setUp() {
            ShokanKihonEntity = new DbT3038ShokanKihonEntity();
            ShokanKihonEntity.setHiHokenshaNo(主キー名1);
            ShokanKihonEntity.setServiceTeikyoYM(主キー名2);

            business = new ShokanKihon(ShokanKihonEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の様式番号は_設定した値と同じ様式番号を返す() {
            business = sut.set様式番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_様式番号).build();
            assertThat(business.get様式番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_様式番号));
        }

        @Test
        public void 戻り値の明細番号は_設定した値と同じ明細番号を返す() {
            business = sut.set明細番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_明細番号).build();
            assertThat(business.get明細番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_明細番号));
        }

        @Test
        public void 戻り値の旧措置入所者特例コードは_設定した値と同じ旧措置入所者特例コードを返す() {
            business = sut.set旧措置入所者特例コード(DbT3038ShokanKihonEntityGenerator.DEFAULT_旧措置入所者特例コード).build();
            assertThat(business.get旧措置入所者特例コード(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_旧措置入所者特例コード));
        }

        @Test
        public void 戻り値の居宅サービス計画作成区分コードは_設定した値と同じ居宅サービス計画作成区分コードを返す() {
            business = sut.set居宅サービス計画作成区分コード(DbT3038ShokanKihonEntityGenerator.DEFAULT_居宅サービス計画作成区分コード).build();
            assertThat(business.get居宅サービス計画作成区分コード(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_居宅サービス計画作成区分コード));
        }

        @Test
        public void 戻り値の居宅サービス計画事業者番号は_設定した値と同じ居宅サービス計画事業者番号を返す() {
            business = sut.set居宅サービス計画事業者番号(DbT3038ShokanKihonEntityGenerator.DEFAULT_居宅サービス計画事業者番号).build();
            assertThat(business.get居宅サービス計画事業者番号(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_居宅サービス計画事業者番号));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            business = sut.set開始年月日(DbT3038ShokanKihonEntityGenerator.DEFAULT_開始年月日).build();
            assertThat(business.get開始年月日(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の中止年月日は_設定した値と同じ中止年月日を返す() {
            business = sut.set中止年月日(DbT3038ShokanKihonEntityGenerator.DEFAULT_中止年月日).build();
            assertThat(business.get中止年月日(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_中止年月日));
        }

        @Test
        public void 戻り値の中止理由_入所_院_前の状況コードは_設定した値と同じ中止理由_入所_院前の状況コードを返す() {
            business = sut.set中止理由_入所_院前の状況コード(DbT3038ShokanKihonEntityGenerator.DEFAULT_中止理由_入所_院_前の状況コード).build();
            assertThat(business.get中止理由_入所_院前の状況コード(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_中止理由_入所_院_前の状況コード));
        }

        @Test
        public void 戻り値の入所_院年月日は_設定した値と同じ入所_院年月日を返す() {
            business = sut.set入所_院年月日(DbT3038ShokanKihonEntityGenerator.DEFAULT_入所_院_年月日).build();
            assertThat(business.get入所_院年月日(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_入所_院_年月日));
        }

        @Test
        public void 戻り値の退所_院年月日は_設定した値と同じ退所_院年月日を返す() {
            business = sut.set退所_院年月日(DbT3038ShokanKihonEntityGenerator.DEFAULT_退所_院_年月日).build();
            assertThat(business.get退所_院年月日(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_退所_院_年月日));
        }

        @Test
        public void 戻り値の入所_院実日数は_設定した値と同じ入所_院実日数を返す() {
            business = sut.set入所_院実日数(DbT3038ShokanKihonEntityGenerator.DEFAULT_入所_院_実日数).build();
            assertThat(business.get入所_院実日数(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_入所_院_実日数));
        }

        @Test
        public void 戻り値の外泊日数は_設定した値と同じ外泊日数を返す() {
            business = sut.set外泊日数(DbT3038ShokanKihonEntityGenerator.DEFAULT_外泊日数).build();
            assertThat(business.get外泊日数(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_外泊日数));
        }

        @Test
        public void 戻り値の退所_院後の状態コードは_設定した値と同じ退所_院後の状態コードを返す() {
            business = sut.set退所_院後の状態コード(DbT3038ShokanKihonEntityGenerator.DEFAULT_退所_院_後の状態コード).build();
            assertThat(business.get退所_院後の状態コード(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_退所_院_後の状態コード));
        }

        @Test
        public void 戻り値の保険給付率は_設定した値と同じ保険給付率を返す() {
            business = sut.set保険給付率(DbT3038ShokanKihonEntityGenerator.DEFAULT_保険給付率).build();
            assertThat(business.get保険給付率(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_保険給付率));
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            business = sut.setサービス単位数(DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス単位数).build();
            assertThat(business.getサービス単位数(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の保険請求額は_設定した値と同じ保険請求額を返す() {
            business = sut.set保険請求額(DbT3038ShokanKihonEntityGenerator.DEFAULT_保険請求額).build();
            assertThat(business.get保険請求額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_保険請求額));
        }

        @Test
        public void 戻り値の利用者負担額は_設定した値と同じ利用者負担額を返す() {
            business = sut.set利用者負担額(DbT3038ShokanKihonEntityGenerator.DEFAULT_利用者負担額).build();
            assertThat(business.get利用者負担額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_利用者負担額));
        }

        @Test
        public void 戻り値の緊急時施設療養費請求額は_設定した値と同じ緊急時施設療養費請求額を返す() {
            business = sut.set緊急時施設療養費請求額(DbT3038ShokanKihonEntityGenerator.DEFAULT_緊急時施設療養費請求額).build();
            assertThat(business.get緊急時施設療養費請求額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_緊急時施設療養費請求額));
        }

        @Test
        public void 戻り値の特定診療費請求額は_設定した値と同じ特定診療費請求額を返す() {
            business = sut.set特定診療費請求額(DbT3038ShokanKihonEntityGenerator.DEFAULT_特定診療費請求額).build();
            assertThat(business.get特定診療費請求額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_特定診療費請求額));
        }

        @Test
        public void 戻り値の特定入所者介護サービス費等請求額は_設定した値と同じ特定入所者介護サービス費等請求額を返す() {
            business = sut.set特定入所者介護サービス費等請求額(DbT3038ShokanKihonEntityGenerator.DEFAULT_特定入所者介護サービス費等請求額).build();
            assertThat(business.get特定入所者介護サービス費等請求額(), is(DbT3038ShokanKihonEntityGenerator.DEFAULT_特定入所者介護サービス費等請求額));
        }

    }
}
