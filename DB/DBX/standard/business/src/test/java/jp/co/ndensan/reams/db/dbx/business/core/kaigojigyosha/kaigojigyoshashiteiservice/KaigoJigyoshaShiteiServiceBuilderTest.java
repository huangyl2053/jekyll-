/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJigyoshaShiteiServiceBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaShiteiServiceBuilderTest extends DbxTestBase {

    private static DbT7063KaigoJigyoshaShiteiServiceEntity KaigoJigyoshaShiteiServiceEntity;

    private static KaigoJigyoshaNo 事業者番号;
    private static KaigoServiceShuruiCode サービス種類コード;
    private static FlexibleDate 有効開始日;

    @BeforeClass
    public static void setUpClass() {

        事業者番号 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号;
        サービス種類コード = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード;
        有効開始日 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効開始日;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static KaigoJigyoshaShiteiServiceBuilder sut;
        private static KaigoJigyoshaShiteiService business;

        @Before
        public void setUp() {
            KaigoJigyoshaShiteiServiceEntity = new DbT7063KaigoJigyoshaShiteiServiceEntity();
            KaigoJigyoshaShiteiServiceEntity.setJigyoshaNo(事業者番号);
            KaigoJigyoshaShiteiServiceEntity.setServiceShuruiCode(サービス種類コード);
            KaigoJigyoshaShiteiServiceEntity.setYukoKaishiYMD(有効開始日);

            business = new KaigoJigyoshaShiteiService(KaigoJigyoshaShiteiServiceEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の有効終了日は_設定した値と同じ有効終了日を返す() {
            business = sut.set有効終了日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効終了日).build();
            assertThat(business.get有効終了日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効終了日));
        }

        @Test
        public void 戻り値の異動日は_設定した値と同じ異動日を返す() {
            business = sut.set異動日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_異動日).build();
            assertThat(business.get異動日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_異動日));
        }

        @Test
        public void 戻り値の異動事由は_設定した値と同じ異動事由を返す() {
            business = sut.set異動事由(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_異動事由).build();
            assertThat(business.get異動事由(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_異動事由));
        }

        @Test
        public void 戻り値の指定番号は_設定した値と同じ指定番号を返す() {
            business = sut.set指定番号(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定番号).build();
            assertThat(business.get指定番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定番号));
        }

        @Test
        public void 戻り値の基本情報準拠区分は_設定した値と同じ基本情報準拠区分を返す() {
            business = sut.set基本情報準拠区分(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_基本情報準拠区分).build();
            assertThat(business.get基本情報準拠区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_基本情報準拠区分));
        }

        @Test
        public void 戻り値の事業開始日は_設定した値と同じ事業開始日を返す() {
            business = sut.set事業開始日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業開始日).build();
            assertThat(business.get事業開始日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業開始日));
        }

        @Test
        public void 戻り値の事業休止日は_設定した値と同じ事業休止日を返す() {
            business = sut.set事業休止日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業休止日).build();
            assertThat(business.get事業休止日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業休止日));
        }

        @Test
        public void 戻り値の事業再開日は_設定した値と同じ事業再開日を返す() {
            business = sut.set事業再開日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業再開日).build();
            assertThat(business.get事業再開日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業再開日));
        }

        @Test
        public void 戻り値の事業廃止日は_設定した値と同じ事業廃止日を返す() {
            business = sut.set事業廃止日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業廃止日).build();
            assertThat(business.get事業廃止日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業廃止日));
        }

        @Test
        public void 戻り値の事業者名称は_設定した値と同じ事業者名称を返す() {
            business = sut.set事業者名称(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者名称).build();
            assertThat(business.get事業者名称(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者名称));
        }

        @Test
        public void 戻り値の事業者名称カナは_設定した値と同じ事業者名称カナを返す() {
            business = sut.set事業者名称カナ(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者名称カナ).build();
            assertThat(business.get事業者名称カナ(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者名称カナ));
        }

        @Test
        public void 戻り値の事業者郵便番号は_設定した値と同じ事業者郵便番号を返す() {
            business = sut.set事業者郵便番号(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者郵便番号).build();
            assertThat(business.get事業者郵便番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者郵便番号));
        }

        @Test
        public void 戻り値の事業者住所は_設定した値と同じ事業者住所を返す() {
            business = sut.set事業者住所(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者住所).build();
            assertThat(business.get事業者住所(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者住所));
        }

        @Test
        public void 戻り値の事業者住所カナは_設定した値と同じ事業者住所カナを返す() {
            business = sut.set事業者住所カナ(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者住所カナ).build();
            assertThat(business.get事業者住所カナ(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者住所カナ));
        }

        @Test
        public void 戻り値の事業者電話番号は_設定した値と同じ事業者電話番号を返す() {
            business = sut.set事業者電話番号(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者電話番号).build();
            assertThat(business.get事業者電話番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者電話番号));
        }

        @Test
        public void 戻り値の事業者FAX番号は_設定した値と同じ事業者FAX番号を返す() {
            business = sut.set事業者FAX番号(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者FAX番号).build();
            assertThat(business.get事業者FAX番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者FAX番号));
        }

        @Test
        public void 戻り値の登録保険者番号は_設定した値と同じ登録保険者番号を返す() {
            business = sut.set登録保険者番号(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録保険者番号).build();
            assertThat(business.get登録保険者番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録保険者番号));
        }

        @Test
        public void 戻り値の受領委任の有無は_設定した値と同じ受領委任の有無を返す() {
            business = sut.set受領委任の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_受領委任の有無).build();
            assertThat(business.get受領委任の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_受領委任の有無));
        }

        @Test
        public void 戻り値の登録開始日は_設定した値と同じ登録開始日を返す() {
            business = sut.set登録開始日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録開始日).build();
            assertThat(business.get登録開始日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録開始日));
        }

        @Test
        public void 戻り値の登録終了日は_設定した値と同じ登録終了日を返す() {
            business = sut.set登録終了日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録終了日).build();
            assertThat(business.get登録終了日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録終了日));
        }

        @Test
        public void 戻り値の管理者氏名は_設定した値と同じ管理者氏名を返す() {
            business = sut.set管理者氏名(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者氏名).build();
            assertThat(business.get管理者氏名(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者氏名));
        }

        @Test
        public void 戻り値の管理者氏名カナは_設定した値と同じ管理者氏名カナを返す() {
            business = sut.set管理者氏名カナ(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者氏名カナ).build();
            assertThat(business.get管理者氏名カナ(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者氏名カナ));
        }

        @Test
        public void 戻り値の管理者住所郵便番号は_設定した値と同じ管理者住所郵便番号を返す() {
            business = sut.set管理者住所郵便番号(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所郵便番号).build();
            assertThat(business.get管理者住所郵便番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所郵便番号));
        }

        @Test
        public void 戻り値の管理者住所は_設定した値と同じ管理者住所を返す() {
            business = sut.set管理者住所(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所).build();
            assertThat(business.get管理者住所(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所));
        }

        @Test
        public void 戻り値の管理者住所カナは_設定した値と同じ管理者住所カナを返す() {
            business = sut.set管理者住所カナ(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所カナ).build();
            assertThat(business.get管理者住所カナ(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所カナ));
        }

        @Test
        public void 戻り値の口座情報準拠区分は_設定した値と同じ口座情報準拠区分を返す() {
            business = sut.set口座情報準拠区分(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座情報準拠区分).build();
            assertThat(business.get口座情報準拠区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座情報準拠区分));
        }

        @Test
        public void 戻り値の社会福祉法人軽減事業実施の有無は_設定した値と同じ社会福祉法人軽減事業実施の有無を返す() {
            business = sut.set社会福祉法人軽減事業実施の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_社会福祉法人軽減事業実施の有無).build();
            assertThat(business.get社会福祉法人軽減事業実施の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_社会福祉法人軽減事業実施の有無));
        }

        @Test
        public void 戻り値の生活保護法による指定の有無は_設定した値と同じ生活保護法による指定の有無を返す() {
            business = sut.set生活保護法による指定の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_生活保護法による指定の有無).build();
            assertThat(business.get生活保護法による指定の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_生活保護法による指定の有無));
        }

        @Test
        public void 戻り値の施設等の区分は_設定した値と同じ施設等の区分を返す() {
            business = sut.set施設等の区分(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_施設等の区分).build();
            assertThat(business.get施設等の区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_施設等の区分));
        }

        @Test
        public void 戻り値の人員配置区分は_設定した値と同じ人員配置区分を返す() {
            business = sut.set人員配置区分(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_人員配置区分).build();
            assertThat(business.get人員配置区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_人員配置区分));
        }

        @Test
        public void 戻り値の特別地域加算の有無は_設定した値と同じ特別地域加算の有無を返す() {
            business = sut.set特別地域加算の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別地域加算の有無).build();
            assertThat(business.get特別地域加算の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別地域加算の有無));
        }

        @Test
        public void 戻り値の緊急時訪問介護加算の有無は_設定した値と同じ緊急時訪問介護加算の有無を返す() {
            business = sut.set緊急時訪問介護加算の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急時訪問介護加算の有無).build();
            assertThat(business.get緊急時訪問介護加算の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急時訪問介護加算の有無));
        }

        @Test
        public void 戻り値の特別管理体制は_設定した値と同じ特別管理体制を返す() {
            business = sut.set特別管理体制(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別管理体制).build();
            assertThat(business.get特別管理体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別管理体制));
        }

        @Test
        public void 戻り値の機能訓練指導体制の有無は_設定した値と同じ機能訓練指導体制の有無を返す() {
            business = sut.set機能訓練指導体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_機能訓練指導体制の有無).build();
            assertThat(business.get機能訓練指導体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_機能訓練指導体制の有無));
        }

        @Test
        public void 戻り値の食事提供体制の有無は_設定した値と同じ食事提供体制の有無を返す() {
            business = sut.set食事提供体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_食事提供体制の有無).build();
            assertThat(business.get食事提供体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_食事提供体制の有無));
        }

        @Test
        public void 戻り値の入浴介助体制の有無は_設定した値と同じ入浴介助体制の有無を返す() {
            business = sut.set入浴介助体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_入浴介助体制の有無).build();
            assertThat(business.get入浴介助体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_入浴介助体制の有無));
        }

        @Test
        public void 戻り値の特別入浴介助体制の有無は_設定した値と同じ特別入浴介助体制の有無を返す() {
            business = sut.set特別入浴介助体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別入浴介助体制の有無).build();
            assertThat(business.get特別入浴介助体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別入浴介助体制の有無));
        }

        @Test
        public void 戻り値の常勤専従医師配置の有無は_設定した値と同じ常勤専従医師配置の有無を返す() {
            business = sut.set常勤専従医師配置の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_常勤専従医師配置の有無).build();
            assertThat(business.get常勤専従医師配置の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_常勤専従医師配置の有無));
        }

        @Test
        public void 戻り値の医師の配置基準は_設定した値と同じ医師の配置基準を返す() {
            business = sut.set医師の配置基準(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医師の配置基準).build();
            assertThat(business.get医師の配置基準(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医師の配置基準));
        }

        @Test
        public void 戻り値の精神科医師定期的療養指導の有無は_設定した値と同じ精神科医師定期的療養指導の有無を返す() {
            business = sut.set精神科医師定期的療養指導の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_精神科医師定期的療養指導の有無).build();
            assertThat(business.get精神科医師定期的療養指導の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_精神科医師定期的療養指導の有無));
        }

        @Test
        public void 戻り値の夜間勤務条件基準は_設定した値と同じ夜間勤務条件基準を返す() {
            business = sut.set夜間勤務条件基準(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間勤務条件基準).build();
            assertThat(business.get夜間勤務条件基準(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間勤務条件基準));
        }

        @Test
        public void 戻り値の認知症専門棟の有無は_設定した値と同じ認知症専門棟の有無を返す() {
            business = sut.set認知症専門棟の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症専門棟の有無).build();
            assertThat(business.get認知症専門棟の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症専門棟の有無));
        }

        @Test
        public void 戻り値の食事提供の状況は_設定した値と同じ食事提供の状況を返す() {
            business = sut.set食事提供の状況(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_食事提供の状況).build();
            assertThat(business.get食事提供の状況(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_食事提供の状況));
        }

        @Test
        public void 戻り値の送迎体制は_設定した値と同じ送迎体制を返す() {
            business = sut.set送迎体制(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_送迎体制).build();
            assertThat(business.get送迎体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_送迎体制));
        }

        @Test
        public void 戻り値のリハビリテーション提供体制_総合リハビリテーション施設_の有無は_設定した値と同じリハビリテーション提供体制_総合リハビリテーション施設_の有無を返す() {
            business = sut.setリハビリテーション提供体制_総合リハビリテーション施設_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_総合リハビリテーション施設_の有無).build();
            assertThat(business.getリハビリテーション提供体制_総合リハビリテーション施設_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_総合リハビリテーション施設_の有無));
        }

        @Test
        public void 戻り値のリハビリテーション提供体制_理学療法Ⅱ_の有無は_設定した値と同じリハビリテーション提供体制_理学療法Ⅱ_の有無を返す() {
            business = sut.setリハビリテーション提供体制_理学療法Ⅱ_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_理学療法Ⅱ_の有無).build();
            assertThat(business.getリハビリテーション提供体制_理学療法Ⅱ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_理学療法Ⅱ_の有無));
        }

        @Test
        public void 戻り値のリハビリテーション提供体制_理学療法Ⅲ_の有無は_設定した値と同じリハビリテーション提供体制_理学療法Ⅲ_の有無を返す() {
            business = sut.setリハビリテーション提供体制_理学療法Ⅲ_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_理学療法Ⅲ_の有無).build();
            assertThat(business.getリハビリテーション提供体制_理学療法Ⅲ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_理学療法Ⅲ_の有無));
        }

        @Test
        public void 戻り値のリハビリテーション提供体制_作業療法Ⅱ_の有無は_設定した値と同じリハビリテーション提供体制_作業療法Ⅱ_の有無を返す() {
            business = sut.setリハビリテーション提供体制_作業療法Ⅱ_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_作業療法Ⅱ_の有無).build();
            assertThat(business.getリハビリテーション提供体制_作業療法Ⅱ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_作業療法Ⅱ_の有無));
        }

        @Test
        public void 戻り値のリハビリテーション提供体制_精神科作業療法_の有無は_設定した値と同じリハビリテーション提供体制_精神科作業療法_の有無を返す() {
            business = sut.setリハビリテーション提供体制_精神科作業療法_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_精神科作業療法_の有無).build();
            assertThat(business.getリハビリテーション提供体制_精神科作業療法_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_精神科作業療法_の有無));
        }

        @Test
        public void 戻り値のリハビリテーション提供体制_その他_の有無は_設定した値と同じリハビリテーション提供体制_その他_の有無を返す() {
            business = sut.setリハビリテーション提供体制_その他_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_その他_の有無).build();
            assertThat(business.getリハビリテーション提供体制_その他_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_その他_の有無));
        }

        @Test
        public void 戻り値のリハビリテーションの加算状況の有無は_設定した値と同じリハビリテーションの加算状況の有無を返す() {
            business = sut.setリハビリテーションの加算状況の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーションの加算状況の有無).build();
            assertThat(business.getリハビリテーションの加算状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーションの加算状況の有無));
        }

        @Test
        public void 戻り値の療養環境基準は_設定した値と同じ療養環境基準を返す() {
            business = sut.set療養環境基準(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養環境基準).build();
            assertThat(business.get療養環境基準(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養環境基準));
        }

        @Test
        public void 戻り値の医師の欠員による減算の状況の有無は_設定した値と同じ医師の欠員による減算の状況の有無を返す() {
            business = sut.set医師の欠員による減算の状況の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医師の欠員による減算の状況の有無).build();
            assertThat(business.get医師の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医師の欠員による減算の状況の有無));
        }

        @Test
        public void 戻り値の看護職員の欠員による減算の状況の有無は_設定した値と同じ看護職員の欠員による減算の状況の有無を返す() {
            business = sut.set看護職員の欠員による減算の状況の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護職員の欠員による減算の状況の有無).build();
            assertThat(business.get看護職員の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護職員の欠員による減算の状況の有無));
        }

        @Test
        public void 戻り値の理学療法士の欠員による減算の状況の有無は_設定した値と同じ理学療法士の欠員による減算の状況の有無を返す() {
            business = sut.set理学療法士の欠員による減算の状況の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_理学療法士の欠員による減算の状況の有無).build();
            assertThat(business.get理学療法士の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_理学療法士の欠員による減算の状況の有無));
        }

        @Test
        public void 戻り値の作業療法士の欠員による減算の状況の有無は_設定した値と同じ作業療法士の欠員による減算の状況の有無を返す() {
            business = sut.set作業療法士の欠員による減算の状況の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_作業療法士の欠員による減算の状況の有無).build();
            assertThat(business.get作業療法士の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_作業療法士の欠員による減算の状況の有無));
        }

        @Test
        public void 戻り値の介護職員の欠員による減算の状況の有無は_設定した値と同じ介護職員の欠員による減算の状況の有無を返す() {
            business = sut.set介護職員の欠員による減算の状況の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護職員の欠員による減算の状況の有無).build();
            assertThat(business.get介護職員の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護職員の欠員による減算の状況の有無));
        }

        @Test
        public void 戻り値の介護支援専門員の欠員による減算の状況の有無は_設定した値と同じ介護支援専門員の欠員による減算の状況の有無を返す() {
            business = sut.set介護支援専門員の欠員による減算の状況の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員の欠員による減算の状況の有無).build();
            assertThat(business.get介護支援専門員の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員の欠員による減算の状況の有無));
        }

        @Test
        public void 戻り値の介護従業者の欠員による減算の状況の有無は_設定した値と同じ介護従業者の欠員による減算の状況の有無を返す() {
            business = sut.set介護従業者の欠員による減算の状況の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護従業者の欠員による減算の状況の有無).build();
            assertThat(business.get介護従業者の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護従業者の欠員による減算の状況の有無));
        }

        @Test
        public void 戻り値の感染対策指導管理の有無は_設定した値と同じ感染対策指導管理の有無を返す() {
            business = sut.set感染対策指導管理の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_感染対策指導管理の有無).build();
            assertThat(business.get感染対策指導管理の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_感染対策指導管理の有無));
        }

        @Test
        public void 戻り値の重症皮膚潰瘍指導管理の有無は_設定した値と同じ重症皮膚潰瘍指導管理の有無を返す() {
            business = sut.set重症皮膚潰瘍指導管理の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_重症皮膚潰瘍指導管理の有無).build();
            assertThat(business.get重症皮膚潰瘍指導管理の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_重症皮膚潰瘍指導管理の有無));
        }

        @Test
        public void 戻り値の薬剤管理指導の有無は_設定した値と同じ薬剤管理指導の有無を返す() {
            business = sut.set薬剤管理指導の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_薬剤管理指導の有無).build();
            assertThat(business.get薬剤管理指導の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_薬剤管理指導の有無));
        }

        @Test
        public void 戻り値の障害者生活支援体制の有無は_設定した値と同じ障害者生活支援体制の有無を返す() {
            business = sut.set障害者生活支援体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_障害者生活支援体制の有無).build();
            assertThat(business.get障害者生活支援体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_障害者生活支援体制の有無));
        }

        @Test
        public void 戻り値の地域区分コードは_設定した値と同じ地域区分コードを返す() {
            business = sut.set地域区分コード(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_地域区分コード).build();
            assertThat(business.get地域区分コード(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_地域区分コード));
        }

        @Test
        public void 戻り値の時間延長サービス体制は_設定した値と同じ時間延長サービス体制を返す() {
            business = sut.set時間延長サービス体制(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_時間延長サービス体制).build();
            assertThat(business.get時間延長サービス体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_時間延長サービス体制));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制は_設定した値と同じ個別リハビリテーション提供体制を返す() {
            business = sut.set個別リハビリテーション提供体制(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制).build();
            assertThat(business.get個別リハビリテーション提供体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制));
        }

        @Test
        public void 戻り値の居住費対策は_設定した値と同じ居住費対策を返す() {
            business = sut.set居住費対策(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_居住費対策).build();
            assertThat(business.get居住費対策(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_居住費対策));
        }

        @Test
        public void 戻り値の夜間ケアの有無は_設定した値と同じ夜間ケアの有無を返す() {
            business = sut.set夜間ケアの有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間ケアの有無).build();
            assertThat(business.get夜間ケアの有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間ケアの有無));
        }

        @Test
        public void 戻り値のリハビリテーション機能強化の有無は_設定した値と同じリハビリテーション機能強化の有無を返す() {
            business = sut.setリハビリテーション機能強化の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション機能強化の有無).build();
            assertThat(business.getリハビリテーション機能強化の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション機能強化の有無));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_総合リハビリテーション施設_の有無は_設定した値と同じ個別リハビリテーション提供体制_総合リハビリテーション施設_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_総合リハビリテーション施設_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_総合リハビリテーション施設_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_総合リハビリテーション施設_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_総合リハビリテーション施設_の有無));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_理学療法Ⅱ_の有無1は_設定した値と同じ個別リハビリテーション提供体制_理学療法Ⅱ_の有無1を返す() {
            business = sut.set個別リハビリテーション提供体制_理学療法Ⅱ_の有無1(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅱ_の有無1).build();
            assertThat(business.get個別リハビリテーション提供体制_理学療法Ⅱ_の有無1(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅱ_の有無1));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_理学療法Ⅲ_の有無は_設定した値と同じ個別リハビリテーション提供体制_理学療法Ⅲ_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_理学療法Ⅲ_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅲ_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_理学療法Ⅲ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅲ_の有無));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_作業療法Ⅱ_の有無は_設定した値と同じ個別リハビリテーション提供体制_作業療法Ⅱ_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_作業療法Ⅱ_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_作業療法Ⅱ_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_作業療法Ⅱ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_作業療法Ⅱ_の有無));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無は_設定した値と同じ個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無は_設定した値と同じ個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無));
        }

        @Test
        public void 戻り値の言語聴覚士の欠員による減算の状況の有無は_設定した値と同じ言語聴覚士の欠員による減算の状況の有無を返す() {
            business = sut.set言語聴覚士の欠員による減算の状況の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_言語聴覚士の欠員による減算の状況の有無).build();
            assertThat(business.get言語聴覚士の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_言語聴覚士の欠員による減算の状況の有無));
        }

        @Test
        public void 戻り値の栄養管理の評価は_設定した値と同じ栄養管理の評価を返す() {
            business = sut.set栄養管理の評価(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_栄養管理の評価).build();
            assertThat(business.get栄養管理の評価(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_栄養管理の評価));
        }

        @Test
        public void 戻り値の特定事業所加算_訪問介護_の有無は_設定した値と同じ特定事業所加算_訪問介護_の有無を返す() {
            business = sut.set特定事業所加算_訪問介護_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特定事業所加算_訪問介護_の有無).build();
            assertThat(business.get特定事業所加算_訪問介護_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特定事業所加算_訪問介護_の有無));
        }

        @Test
        public void 戻り値の若年性認知症ケア体制の有無は_設定した値と同じ若年性認知症ケア体制の有無を返す() {
            business = sut.set若年性認知症ケア体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_若年性認知症ケア体制の有無).build();
            assertThat(business.get若年性認知症ケア体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_若年性認知症ケア体制の有無));
        }

        @Test
        public void 戻り値の運動器機能向上体制の有無は_設定した値と同じ運動器機能向上体制の有無を返す() {
            business = sut.set運動器機能向上体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_運動器機能向上体制の有無).build();
            assertThat(business.get運動器機能向上体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_運動器機能向上体制の有無));
        }

        @Test
        public void 戻り値の栄養マネジメント_改善_体制の有無は_設定した値と同じ栄養マネジメント_改善_体制の有無を返す() {
            business = sut.set栄養マネジメント_改善_体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_栄養マネジメント_改善_体制の有無).build();
            assertThat(business.get栄養マネジメント_改善_体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_栄養マネジメント_改善_体制の有無));
        }

        @Test
        public void 戻り値の口腔機能向上体制の有無は_設定した値と同じ口腔機能向上体制の有無を返す() {
            business = sut.set口腔機能向上体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口腔機能向上体制の有無).build();
            assertThat(business.get口腔機能向上体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口腔機能向上体制の有無));
        }

        @Test
        public void 戻り値の事業所評価加算_申出_の有無は_設定した値と同じ事業所評価加算_申出_の有無を返す() {
            business = sut.set事業所評価加算_申出_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業所評価加算_申出_の有無).build();
            assertThat(business.get事業所評価加算_申出_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業所評価加算_申出_の有無));
        }

        @Test
        public void 戻り値の事業所評価加算_決定_の有無は_設定した値と同じ事業所評価加算_決定_の有無を返す() {
            business = sut.set事業所評価加算_決定_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業所評価加算_決定_の有無).build();
            assertThat(business.get事業所評価加算_決定_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業所評価加算_決定_の有無));
        }

        @Test
        public void 戻り値の緊急受入体制の有無は_設定した値と同じ緊急受入体制の有無を返す() {
            business = sut.set緊急受入体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急受入体制の有無).build();
            assertThat(business.get緊急受入体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急受入体制の有無));
        }

        @Test
        public void 戻り値の夜間看護体制の有無は_設定した値と同じ夜間看護体制の有無を返す() {
            business = sut.set夜間看護体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間看護体制の有無).build();
            assertThat(business.get夜間看護体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間看護体制の有無));
        }

        @Test
        public void 戻り値の特定事業所加算_居宅介護支援_の有無は_設定した値と同じ特定事業所加算_居宅介護支援_の有無を返す() {
            business = sut.set特定事業所加算_居宅介護支援_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特定事業所加算_居宅介護支援_の有無).build();
            assertThat(business.get特定事業所加算_居宅介護支援_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特定事業所加算_居宅介護支援_の有無));
        }

        @Test
        public void 戻り値の介護支援専門員数_専従の常勤者_は_設定した値と同じ介護支援専門員数_専従の常勤者_を返す() {
            business = sut.set介護支援専門員数_専従の常勤者_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_専従の常勤者_).build();
            assertThat(business.get介護支援専門員数_専従の常勤者_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_専従の常勤者_));
        }

        @Test
        public void 戻り値の介護支援専門員数_専従の非常勤者_は_設定した値と同じ介護支援専門員数_専従の非常勤者_を返す() {
            business = sut.set介護支援専門員数_専従の非常勤者_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_専従の非常勤者_).build();
            assertThat(business.get介護支援専門員数_専従の非常勤者_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_専従の非常勤者_));
        }

        @Test
        public void 戻り値の介護支援専門員数_兼務の常勤者_は_設定した値と同じ介護支援専門員数_兼務の常勤者_を返す() {
            business = sut.set介護支援専門員数_兼務の常勤者_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_兼務の常勤者_).build();
            assertThat(business.get介護支援専門員数_兼務の常勤者_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_兼務の常勤者_));
        }

        @Test
        public void 戻り値の介護支援専門員数_兼務の非常勤者_は_設定した値と同じ介護支援専門員数_兼務の非常勤者_を返す() {
            business = sut.set介護支援専門員数_兼務の非常勤者_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_兼務の非常勤者_).build();
            assertThat(business.get介護支援専門員数_兼務の非常勤者_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_兼務の非常勤者_));
        }

        @Test
        public void 戻り値の訪問介護サービス提供責任者数は_設定した値と同じ訪問介護サービス提供責任者数を返す() {
            business = sut.set訪問介護サービス提供責任者数(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護サービス提供責任者数).build();
            assertThat(business.get訪問介護サービス提供責任者数(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護サービス提供責任者数));
        }

        @Test
        public void 戻り値の訪問介護員数_専従の常勤者_は_設定した値と同じ訪問介護員数_専従の常勤者_を返す() {
            business = sut.set訪問介護員数_専従の常勤者_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_専従の常勤者_).build();
            assertThat(business.get訪問介護員数_専従の常勤者_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_専従の常勤者_));
        }

        @Test
        public void 戻り値の訪問介護員数_専従の非常勤者_は_設定した値と同じ訪問介護員数_専従の非常勤者_を返す() {
            business = sut.set訪問介護員数_専従の非常勤者_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_専従の非常勤者_).build();
            assertThat(business.get訪問介護員数_専従の非常勤者_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_専従の非常勤者_));
        }

        @Test
        public void 戻り値の訪問介護員数_兼務の常勤者_は_設定した値と同じ訪問介護員数_兼務の常勤者_を返す() {
            business = sut.set訪問介護員数_兼務の常勤者_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_兼務の常勤者_).build();
            assertThat(business.get訪問介護員数_兼務の常勤者_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_兼務の常勤者_));
        }

        @Test
        public void 戻り値の訪問介護員数_兼務の非常勤者_は_設定した値と同じ訪問介護員数_兼務の非常勤者_を返す() {
            business = sut.set訪問介護員数_兼務の非常勤者_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_兼務の非常勤者_).build();
            assertThat(business.get訪問介護員数_兼務の非常勤者_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_兼務の非常勤者_));
        }

        @Test
        public void 戻り値の訪問介護員数_常勤換算後の人数_は_設定した値と同じ訪問介護員数_常勤換算後の人数_を返す() {
            business = sut.set訪問介護員数_常勤換算後の人数_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_常勤換算後の人数_).build();
            assertThat(business.get訪問介護員数_常勤換算後の人数_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_常勤換算後の人数_));
        }

        @Test
        public void 戻り値の利用定員数は_設定した値と同じ利用定員数を返す() {
            business = sut.set利用定員数(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_利用定員数).build();
            assertThat(business.get利用定員数(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_利用定員数));
        }

        @Test
        public void 戻り値の指定有効開始日は_設定した値と同じ指定有効開始日を返す() {
            business = sut.set指定有効開始日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定有効開始日).build();
            assertThat(business.get指定有効開始日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定有効開始日));
        }

        @Test
        public void 戻り値の指定有効終了日は_設定した値と同じ指定有効終了日を返す() {
            business = sut.set指定有効終了日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定有効終了日).build();
            assertThat(business.get指定有効終了日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定有効終了日));
        }

        @Test
        public void 戻り値の指定更新申請中区分は_設定した値と同じ指定更新申請中区分を返す() {
            business = sut.set指定更新申請中区分(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定更新申請中区分).build();
            assertThat(business.get指定更新申請中区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定更新申請中区分));
        }

        @Test
        public void 戻り値の効力停止開始日は_設定した値と同じ効力停止開始日を返す() {
            business = sut.set効力停止開始日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_効力停止開始日).build();
            assertThat(business.get効力停止開始日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_効力停止開始日));
        }

        @Test
        public void 戻り値の効力停止終了日は_設定した値と同じ効力停止終了日を返す() {
            business = sut.set効力停止終了日(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_効力停止終了日).build();
            assertThat(business.get効力停止終了日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_効力停止終了日));
        }

        @Test
        public void 戻り値の大規模事業所該当の有無は_設定した値と同じ大規模事業所該当の有無を返す() {
            business = sut.set大規模事業所該当の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_大規模事業所該当の有無).build();
            assertThat(business.get大規模事業所該当の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_大規模事業所該当の有無));
        }

        @Test
        public void 戻り値の準ユニットケア体制の有無は_設定した値と同じ準ユニットケア体制の有無を返す() {
            business = sut.set準ユニットケア体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_準ユニットケア体制の有無).build();
            assertThat(business.get準ユニットケア体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_準ユニットケア体制の有無));
        }

        @Test
        public void 戻り値の重度化対応体制の有無は_設定した値と同じ重度化対応体制の有無を返す() {
            business = sut.set重度化対応体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_重度化対応体制の有無).build();
            assertThat(business.get重度化対応体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_重度化対応体制の有無));
        }

        @Test
        public void 戻り値の医療連携体制の有無は_設定した値と同じ医療連携体制の有無を返す() {
            business = sut.set医療連携体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医療連携体制の有無).build();
            assertThat(business.get医療連携体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医療連携体制の有無));
        }

        @Test
        public void 戻り値のユニットケア体制の有無は_設定した値と同じユニットケア体制の有無を返す() {
            business = sut.setユニットケア体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_ユニットケア体制の有無).build();
            assertThat(business.getユニットケア体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_ユニットケア体制の有無));
        }

        @Test
        public void 戻り値の在宅_入所相互利用体制の有無は_設定した値と同じ在宅_入所相互利用体制の有無を返す() {
            business = sut.set在宅_入所相互利用体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_在宅_入所相互利用体制の有無).build();
            assertThat(business.get在宅_入所相互利用体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_在宅_入所相互利用体制の有無));
        }

        @Test
        public void 戻り値のターミナルケア体制_看取り介護体制_の有無は_設定した値と同じターミナルケア体制_看取り介護体制_の有無を返す() {
            business = sut.setターミナルケア体制_看取り介護体制_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_ターミナルケア体制_看取り介護体制_の有無).build();
            assertThat(business.getターミナルケア体制_看取り介護体制_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_ターミナルケア体制_看取り介護体制_の有無));
        }

        @Test
        public void 戻り値の身体拘束廃止取組の有無は_設定した値と同じ身体拘束廃止取組の有無を返す() {
            business = sut.set身体拘束廃止取組の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_身体拘束廃止取組の有無).build();
            assertThat(business.get身体拘束廃止取組の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_身体拘束廃止取組の有無));
        }

        @Test
        public void 戻り値の小規模拠点集合体制の有無は_設定した値と同じ小規模拠点集合体制の有無を返す() {
            business = sut.set小規模拠点集合体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_小規模拠点集合体制の有無).build();
            assertThat(business.get小規模拠点集合体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_小規模拠点集合体制の有無));
        }

        @Test
        public void 戻り値の認知症ケア加算の有無は_設定した値と同じ認知症ケア加算の有無を返す() {
            business = sut.set認知症ケア加算の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症ケア加算の有無).build();
            assertThat(business.get認知症ケア加算の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症ケア加算の有無));
        }

        @Test
        public void 戻り値の個別機能訓練体制の有無は_設定した値と同じ個別機能訓練体制の有無を返す() {
            business = sut.set個別機能訓練体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別機能訓練体制の有無).build();
            assertThat(business.get個別機能訓練体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別機能訓練体制の有無));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_理学療法Ⅰ_の有無は_設定した値と同じ個別リハビリテーション提供体制_理学療法Ⅰ_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_理学療法Ⅰ_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅰ_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_理学療法Ⅰ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅰ_の有無));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_理学療法Ⅱ_の有無2は_設定した値と同じ個別リハビリテーション提供体制_理学療法Ⅱ_の有無2を返す() {
            business = sut.set個別リハビリテーション提供体制_理学療法Ⅱ_の有無2(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅱ_の有無2).build();
            assertThat(business.get個別リハビリテーション提供体制_理学療法Ⅱ_の有無2(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅱ_の有無2));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_作業療法_の有無は_設定した値と同じ個別リハビリテーション提供体制_作業療法_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_作業療法_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_作業療法_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_作業療法_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_作業療法_の有無));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_言語聴覚療法_の有無は_設定した値と同じ個別リハビリテーション提供体制_言語聴覚療法_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_言語聴覚療法_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_言語聴覚療法_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法_の有無));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_その他_の有無は_設定した値と同じ個別リハビリテーション提供体制_その他_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_その他_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_その他_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_その他_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_その他_の有無));
        }

        @Test
        public void 戻り値の設備基準は_設定した値と同じ設備基準を返す() {
            business = sut.set設備基準(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_設備基準).build();
            assertThat(business.get設備基準(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_設備基準));
        }

        @Test
        public void 戻り値の療養体制維持特別加算は_設定した値と同じ療養体制維持特別加算を返す() {
            business = sut.set療養体制維持特別加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養体制維持特別加算).build();
            assertThat(business.get療養体制維持特別加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養体制維持特別加算));
        }

        @Test
        public void 戻り値の個別リハビリテーション提供体制_リハビリテーション指導管理_の有無は_設定した値と同じ個別リハビリテーション提供体制_リハビリテーション指導管理_の有無を返す() {
            business = sut.set個別リハビリテーション提供体制_リハビリテーション指導管理_の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_リハビリテーション指導管理_の有無).build();
            assertThat(business.get個別リハビリテーション提供体制_リハビリテーション指導管理_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_リハビリテーション指導管理_の有無));
        }

        @Test
        public void 戻り値の３級ヘルパー体制は_設定した値と同じ３級ヘルパー体制を返す() {
            business = sut.set３級ヘルパー体制(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_３級ヘルパー体制).build();
            assertThat(business.get３級ヘルパー体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_３級ヘルパー体制));
        }

        @Test
        public void 戻り値の中山間地域等における小規模事業所加算_地域に関する状況_は_設定した値と同じ中山間地域等における小規模事業所加算_地域に関する状況_を返す() {
            business = sut.set中山間地域等における小規模事業所加算_地域に関する状況_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_中山間地域等における小規模事業所加算_地域に関する状況_).build();
            assertThat(business.get中山間地域等における小規模事業所加算_地域に関する状況_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_中山間地域等における小規模事業所加算_地域に関する状況_));
        }

        @Test
        public void 戻り値の中山間地域等における小規模事業所加算_規模に関する状況_は_設定した値と同じ中山間地域等における小規模事業所加算_規模に関する状況_を返す() {
            business = sut.set中山間地域等における小規模事業所加算_規模に関する状況_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_中山間地域等における小規模事業所加算_規模に関する状況_).build();
            assertThat(business.get中山間地域等における小規模事業所加算_規模に関する状況_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_中山間地域等における小規模事業所加算_規模に関する状況_));
        }

        @Test
        public void 戻り値のサービス提供体制強化加算は_設定した値と同じサービス提供体制強化加算を返す() {
            business = sut.setサービス提供体制強化加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供体制強化加算).build();
            assertThat(business.getサービス提供体制強化加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供体制強化加算));
        }

        @Test
        public void 戻り値の認知症短期集中リハビリテーション加算は_設定した値と同じ認知症短期集中リハビリテーション加算を返す() {
            business = sut.set認知症短期集中リハビリテーション加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症短期集中リハビリテーション加算).build();
            assertThat(business.get認知症短期集中リハビリテーション加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症短期集中リハビリテーション加算));
        }

        @Test
        public void 戻り値の若年性認知症利用者_入所者_患者_受入加算は_設定した値と同じ若年性認知症利用者_入所者_患者_受入加算を返す() {
            business = sut.set若年性認知症利用者_入所者_患者_受入加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_若年性認知症利用者_入所者_患者_受入加算).build();
            assertThat(business.get若年性認知症利用者_入所者_患者_受入加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_若年性認知症利用者_入所者_患者_受入加算));
        }

        @Test
        public void 戻り値の看護体制加算は_設定した値と同じ看護体制加算を返す() {
            business = sut.set看護体制加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護体制加算).build();
            assertThat(business.get看護体制加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護体制加算));
        }

        @Test
        public void 戻り値の夜勤職員配置加算は_設定した値と同じ夜勤職員配置加算を返す() {
            business = sut.set夜勤職員配置加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜勤職員配置加算).build();
            assertThat(business.get夜勤職員配置加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜勤職員配置加算));
        }

        @Test
        public void 戻り値の療養食加算は_設定した値と同じ療養食加算を返す() {
            business = sut.set療養食加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養食加算).build();
            assertThat(business.get療養食加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養食加算));
        }

        @Test
        public void 戻り値の日常生活継続支援加算は_設定した値と同じ日常生活継続支援加算を返す() {
            business = sut.set日常生活継続支援加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_日常生活継続支援加算).build();
            assertThat(business.get日常生活継続支援加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_日常生活継続支援加算));
        }

        @Test
        public void 戻り値の認知症専門ケア加算は_設定した値と同じ認知症専門ケア加算を返す() {
            business = sut.set認知症専門ケア加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症専門ケア加算).build();
            assertThat(business.get認知症専門ケア加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症専門ケア加算));
        }

        @Test
        public void 戻り値の２４時間通報対応加算は_設定した値と同じ２４時間通報対応加算を返す() {
            business = sut.set２４時間通報対応加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_２４時間通報対応加算).build();
            assertThat(business.get２４時間通報対応加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_２４時間通報対応加算));
        }

        @Test
        public void 戻り値の看護職員配置加算は_設定した値と同じ看護職員配置加算を返す() {
            business = sut.set看護職員配置加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護職員配置加算).build();
            assertThat(business.get看護職員配置加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護職員配置加算));
        }

        @Test
        public void 戻り値の夜間ケア加算は_設定した値と同じ夜間ケア加算を返す() {
            business = sut.set夜間ケア加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間ケア加算).build();
            assertThat(business.get夜間ケア加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間ケア加算));
        }

        @Test
        public void 戻り値の集団コミュニケーション療法の有無は_設定した値と同じ集団コミュニケーション療法の有無を返す() {
            business = sut.set集団コミュニケーション療法の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_集団コミュニケーション療法の有無).build();
            assertThat(business.get集団コミュニケーション療法の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_集団コミュニケーション療法の有無));
        }

        @Test
        public void 戻り値のサービス提供体制強化加算_空床型_は_設定した値と同じサービス提供体制強化加算_空床型_を返す() {
            business = sut.setサービス提供体制強化加算_空床型_(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供体制強化加算_空床型_).build();
            assertThat(business.getサービス提供体制強化加算_空床型_(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供体制強化加算_空床型_));
        }

        @Test
        public void 戻り値の日中の身体介護２０分未満体制の有無は_設定した値と同じ日中の身体介護２０分未満体制の有無を返す() {
            business = sut.set日中の身体介護２０分未満体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_日中の身体介護２０分未満体制の有無).build();
            assertThat(business.get日中の身体介護２０分未満体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_日中の身体介護２０分未満体制の有無));
        }

        @Test
        public void 戻り値のサービス提供責任者体制の有無は_設定した値と同じサービス提供責任者体制の有無を返す() {
            business = sut.setサービス提供責任者体制の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供責任者体制の有無).build();
            assertThat(business.getサービス提供責任者体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供責任者体制の有無));
        }

        @Test
        public void 戻り値の同一建物に居住する利用者の減算の有無は_設定した値と同じ同一建物に居住する利用者の減算の有無を返す() {
            business = sut.set同一建物に居住する利用者の減算の有無(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_同一建物に居住する利用者の減算の有無).build();
            assertThat(business.get同一建物に居住する利用者の減算の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_同一建物に居住する利用者の減算の有無));
        }

        @Test
        public void 戻り値の緊急短期入所体制確保加算は_設定した値と同じ緊急短期入所体制確保加算を返す() {
            business = sut.set緊急短期入所体制確保加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急短期入所体制確保加算).build();
            assertThat(business.get緊急短期入所体制確保加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急短期入所体制確保加算));
        }

        @Test
        public void 戻り値の在宅復帰_在宅療養支援機能加算は_設定した値と同じ在宅復帰_在宅療養支援機能加算を返す() {
            business = sut.set在宅復帰_在宅療養支援機能加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_在宅復帰_在宅療養支援機能加算).build();
            assertThat(business.get在宅復帰_在宅療養支援機能加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_在宅復帰_在宅療養支援機能加算));
        }

        @Test
        public void 戻り値の生活機能向上グループ活動加算は_設定した値と同じ生活機能向上グループ活動加算を返す() {
            business = sut.set生活機能向上グループ活動加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_生活機能向上グループ活動加算).build();
            assertThat(business.get生活機能向上グループ活動加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_生活機能向上グループ活動加算));
        }

        @Test
        public void 戻り値の介護職員処遇改善加算は_設定した値と同じ介護職員処遇改善加算を返す() {
            business = sut.set介護職員処遇改善加算(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護職員処遇改善加算).build();
            assertThat(business.get介護職員処遇改善加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護職員処遇改善加算));
        }

    }
}
