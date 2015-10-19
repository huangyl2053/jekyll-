package jp.co.ndensan.reams.db.dbx.business.core;

import java.lang.reflect.Constructor;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJigyoshaShiteiService}のテストです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaShiteiServiceTest extends DbxTestBase {

    public static class コンストラクタTest extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタに_Null_を指定した時_NullPointerExceptionが発生する() {
            KaigoJigyoshaShiteiService sut = new KaigoJigyoshaShiteiService(null);
        }
    }

    //TODO n3423 樋木隆真 stateの扱いについては現在検討中のため、決定後に対応する
//    public static class getStateTest extends DbxTestBase {
//
//        @Test
//        public void 状態Addedの取得確認() {
//            KaigoJigyoshaShiteiService sut = new KaigoJigyoshaShiteiService(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity());
//            assertThat(sut.getState(), is(EntityDataState.Added));
//        }
//
//        @Test
//        public void 状態Modifinedの取得確認() {
//            KaigoJigyoshaShiteiService sut = new KaigoJigyoshaShiteiService(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity());
//            sut.toEntity().initializeMd5();
//            sut.toEntity().setDaihyoshaYakushokuMei(new RString("係長"));
//            assertThat(sut.getState(), is(EntityDataState.Modified));
//        }
//
//        @Test
//        public void 状態Unchangedの取得確認() {
//            KaigoJigyoshaShiteiService sut = new KaigoJigyoshaShiteiService(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity());
//            sut.toEntity().initializeMd5();
//            assertThat(sut.getState(), is(EntityDataState.Unchanged));
//        }
//
//        @Test
//        public void 状態Deletedの取得確認() {
//            KaigoJigyoshaShiteiService sut = new KaigoJigyoshaShiteiService(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity());
//            sut.toEntity().initializeMd5();
//            sut.createBuilderForEdit().setDeletedState(result.get);
//
//            assertThat(sut.getState(), is(EntityDataState.Deleted));
//        }
//    }
    public static class BuilderTest {

        @Test
        public void setJigyoshaNoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshaNo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(result.get事業者番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void setServiceShuruiCodeで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setServiceShuruiCode(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(result.getサービス種類コード(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void setYukoKaishiYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setYukoKaishiYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効開始日).build();
            assertThat(result.get有効開始日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効開始日));
        }

        @Test
        public void setYukoShuryoYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setYukoShuryoYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効終了日).build();
            assertThat(result.get有効終了日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効終了日));
        }

        @Test
        public void setIdoYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setIdoYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_異動日).build();
            assertThat(result.get異動日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_異動日));
        }

        @Test
        public void setIdoJiyuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setIdoJiyu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_異動事由).build();
            assertThat(result.get異動事由(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_異動事由));
        }

        @Test
        public void setShiteiNoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShiteiNo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定番号).build();
            assertThat(result.get指定番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定番号));
        }

        @Test
        public void setKihonJohoJunkyoKubunで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKihonJohoJunkyoKubun(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_基本情報準拠区分).build();
            assertThat(result.get基本情報準拠区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_基本情報準拠区分));
        }

        @Test
        public void setJigyoKaishiYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoKaishiYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業開始日).build();
            assertThat(result.get事業開始日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業開始日));
        }

        @Test
        public void setJigyoKyushiYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoKyushiYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業休止日).build();
            assertThat(result.get事業休止日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業休止日));
        }

        @Test
        public void setJigyoSaikaiYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoSaikaiYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業再開日).build();
            assertThat(result.get事業再開日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業再開日));
        }

        @Test
        public void setJigyoHaishiYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoHaishiYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業廃止日).build();
            assertThat(result.get事業廃止日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業廃止日));
        }

        @Test
        public void setJigyoshaNameで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshaName(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者名称).build();
            assertThat(result.get事業者名称(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者名称));
        }

        @Test
        public void setJigyoshaNameKanaで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshaNameKana(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者名称カナ).build();
            assertThat(result.get事業者名称カナ(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者名称カナ));
        }

        @Test
        public void setJigyoshaYubinNoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshaYubinNo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者郵便番号).build();
            assertThat(result.get事業者郵便番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者郵便番号));
        }

        @Test
        public void setJigyoshaAddressで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshaAddress(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者住所).build();
            assertThat(result.get事業者住所(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者住所));
        }

        @Test
        public void setJigyoshaAddressKanaで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshaAddressKana(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者住所カナ).build();
            assertThat(result.get事業者住所カナ(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者住所カナ));
        }

        @Test
        public void setJigyoshaTelNoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshaTelNo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者電話番号).build();
            assertThat(result.get事業者電話番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者電話番号));
        }

        @Test
        public void setJigyoshaFaxNoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshaFaxNo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者FAX番号).build();
            assertThat(result.get事業者FAX番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者FAX番号));
        }

        @Test
        public void setTorokuHokenshaNoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTorokuHokenshaNo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録保険者番号).build();
            assertThat(result.get登録保険者番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録保険者番号));
        }

        @Test
        public void setJuryoininUmuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJuryoininUmu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_受領委任の有無).build();
            assertThat(result.get受領委任の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_受領委任の有無));
        }

        @Test
        public void setTorokuKaishiYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTorokuKaishiYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録開始日).build();
            assertThat(result.get登録開始日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録開始日));
        }

        @Test
        public void setTorokuShuryoYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTorokuShuryoYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録終了日).build();
            assertThat(result.get登録終了日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_登録終了日));
        }

        @Test
        public void setKanrishaNameで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKanrishaName(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者氏名).build();
            assertThat(result.get管理者名(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者氏名));
        }

        @Test
        public void setKanrishaNameKanaで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKanrishaNameKana(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者氏名カナ).build();
            assertThat(result.get管理者名カナ(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者氏名カナ));
        }

        @Test
        public void setKanrishaYubinNoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKanrishaYubinNo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者郵便番号).build();
            assertThat(result.get管理者住所郵便番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者郵便番号));
        }

        @Test
        public void setKanrishaAddressで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKanrishaAddress(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所).build();
            assertThat(result.get管理者住所(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所));
        }

        @Test
        public void setKanrishaAddressKanaで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKanrishaAddressKana(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所カナ).build();
            assertThat(result.get管理者住所カナ(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_管理者住所カナ));
        }

        @Test
        public void setKozaJohoJunkyoKubunで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKozaJohoJunkyoKubun(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座情報準拠区分).build();
            assertThat(result.get口座情報準拠区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座情報準拠区分));
        }

        @Test
        public void setGinkoCodeで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setGinkoCode(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_銀行コード).build();
            assertThat(result.get銀行コード(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_銀行コード));
        }

        @Test
        public void setShitenCodeで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShitenCode(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_支店コード).build();
            assertThat(result.get支店コード(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_支店コード));
        }

        @Test
        public void setKozaShubetsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKozaShubetsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座種別).build();
            assertThat(result.get口座種別(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座種別));
        }

        @Test
        public void setKozaNoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKozaNo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座番号).build();
            assertThat(result.get口座番号(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座番号));
        }

        @Test
        public void setKozaMeigininで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKozaMeiginin(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座名義人).build();
            assertThat(result.get口座名義人(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座名義人));
        }

        @Test
        public void setKozaMeigininKanaで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKozaMeigininKana(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座名義人カナ).build();
            assertThat(result.get口座名義人カナ(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口座名義人カナ));
        }

        @Test
        public void setShakaiFukushihoujinKeigenjigyouJisshi_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShakaiFukushihoujinKeigenjigyouJisshi_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_社会福祉法人軽減事業実施の有無).build();
            assertThat(result.get社会福祉法人軽減事業実施の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_社会福祉法人軽減事業実施の有無));
        }

        @Test
        public void setSeikatsuhogohouShitei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setSeikatsuhogohouShitei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_生活保護法による指定の有無).build();
            assertThat(result.get生活保護法による指定の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_生活保護法による指定の有無));
        }

        @Test
        public void setShisetsunadoKubunで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShisetsunadoKubun(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_施設等の区分).build();
            assertThat(result.get施設等の区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_施設等の区分));
        }

        @Test
        public void setJininHaichiKubunで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJininHaichiKubun(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_人員配置区分).build();
            assertThat(result.get人員配置区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_人員配置区分));
        }

        @Test
        public void setTokubetsuChiikiKasan_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTokubetsuChiikiKasan_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別地域加算の有無).build();
            assertThat(result.get特別地域加算の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別地域加算の有無));
        }

        @Test
        public void setKinkyujiHomonkaigoKasan_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKinkyujiHomonkaigoKasan_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急時訪問介護加算の有無).build();
            assertThat(result.get緊急時訪問介護加算の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急時訪問介護加算の有無));
        }

        @Test
        public void setTokubetsuKanriTaiseiで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTokubetsuKanriTaisei(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別管理体制).build();
            assertThat(result.get特別管理体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別管理体制));
        }

        @Test
        public void setKinoKunrenShidoTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKinoKunrenShidoTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_機能訓練指導体制の有無).build();
            assertThat(result.get機能訓練指導体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_機能訓練指導体制の有無));
        }

        @Test
        public void setShokujiTeikyoTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShokujiTeikyoTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_食事提供体制の有無).build();
            assertThat(result.get食事提供体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_食事提供体制の有無));
        }

        @Test
        public void setNyuyokuKaijoTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setNyuyokuKaijoTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_入浴介助体制の有無).build();
            assertThat(result.get入浴介助体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_入浴介助体制の有無));
        }

        @Test
        public void setTokubetsuNyuyokuKaijoTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTokubetsuNyuyokuKaijoTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別入浴介助体制の有無).build();
            assertThat(result.get特別入浴介助体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特別入浴介助体制の有無));
        }

        @Test
        public void setJoukinsenjuIshiHaichi_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJoukinsenjuIshiHaichi_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_常勤専従医師配置の有無).build();
            assertThat(result.get常勤専従医師配置の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_常勤専従医師配置の有無));
        }

        @Test
        public void setIshiHaichiKijunで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setIshiHaichiKijun(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医師の配置基準).build();
            assertThat(result.get医師の配置基準(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医師の配置基準));
        }

        @Test
        public void setSeisinkaIshiTeikitekiRyouyousidou_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setSeisinkaIshiTeikitekiRyouyousidou_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_精神科医師定期的療養指導の有無).build();
            assertThat(result.get精神科医師定期的療養指導の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_精神科医師定期的療養指導の有無));
        }

        @Test
        public void setYakanKinmuJokenKijunで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setYakanKinmuJokenKijun(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間勤務条件基準).build();
            assertThat(result.get夜間勤務条件基準(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間勤務条件基準));
        }

        @Test
        public void setNinchishouSenmontou_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setNinchishouSenmontou_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症専門棟の有無).build();
            assertThat(result.get認知症専門棟の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症専門棟の有無));
        }

        @Test
        public void setShokujiTeikyoJokyoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShokujiTeikyoJokyo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_食事提供の状況).build();
            assertThat(result.get食事提供の状況(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_食事提供の状況));
        }

        @Test
        public void setSougeiTaiseiで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setSougeiTaisei(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_送迎体制).build();
            assertThat(result.get送迎体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_送迎体制));
        }

        @Test
        public void setRehaTeikyoTaisei_SogoRehaShisetsu_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRehaTeikyoTaisei_SogoRehaShisetsu_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_総合リハビリテーション施設_の有無).build();
            assertThat(result.getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_総合リハビリテーション施設_の有無));
        }

        @Test
        public void setRehaTeikyoTaisei_RigakuRyohoII_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRehaTeikyoTaisei_RigakuRyohoII_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_理学療法Ⅱ_の有無).build();
            assertThat(result.getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_理学療法Ⅱ_の有無));
        }

        @Test
        public void setRehaTeikyoTaisei_RigakuRyohoIII_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRehaTeikyoTaisei_RigakuRyohoIII_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_理学療法Ⅲ_の有無).build();
            assertThat(result.getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_理学療法Ⅲ_の有無));
        }

        @Test
        public void setRehaTeikyoTaisei_SagyoRyohoII_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRehaTeikyoTaisei_SagyoRyohoII_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_作業療法Ⅱ_の有無).build();
            assertThat(result.getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_作業療法Ⅱ_の有無));
        }

        @Test
        public void setRehaTeikyoTaisei_SeisinkaSagyouRyoho_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_精神科作業療法_の有無).build();
            assertThat(result.getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_精神科作業療法_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_精神科作業療法_の有無));
        }

        @Test
        public void setRehaTeikyoTaisei_Sonota_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRehaTeikyoTaisei_Sonota_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_その他_の有無).build();
            assertThat(result.getﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション提供体制_その他_の有無));
        }

        @Test
        public void setRehabilitationKasanJokyoで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRehabilitationKasanJokyo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーションの加算状況の有無).build();
            assertThat(result.getﾘﾊﾋﾞﾘﾃｰｼｮﾝの加算状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーションの加算状況の有無));
        }

        @Test
        public void setRyoyoKankyoKijunで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRyoyoKankyoKijun(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養環境基準).build();
            assertThat(result.get療養環境基準(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養環境基準));
        }

        @Test
        public void setIshiKetuinGenzanJokyo_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setIshiKetuinGenzanJokyo_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医師の欠員による減算の状況の有無).build();
            assertThat(result.get医師の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医師の欠員による減算の状況の有無));
        }

        @Test
        public void setKangoShokuinKetsuinGenzanJokyo_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKangoShokuinKetsuinGenzanJokyo_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護職員の欠員による減算の状況の有無).build();
            assertThat(result.get看護職員の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護職員の欠員による減算の状況の有無));
        }

        @Test
        public void setRigakuRyouhousiKetsuinGenzanJokyo_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRigakuRyouhousiKetsuinGenzanJokyo_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_理学療法士の欠員による減算の状況の有無).build();
            assertThat(result.get理学療法士の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_理学療法士の欠員による減算の状況の有無));
        }

        @Test
        public void setSagyouRyouhousiKetsuinGenzanJokyo_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setSagyouRyouhousiKetsuinGenzanJokyo_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_作業療法士の欠員による減算の状況の有無).build();
            assertThat(result.get作業療法士の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_作業療法士の欠員による減算の状況の有無));
        }

        @Test
        public void setKaigoShokuinKetsuinGenzanJokyo_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKaigoShokuinKetsuinGenzanJokyo_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護職員の欠員による減算の状況の有無).build();
            assertThat(result.get介護職員の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護職員の欠員による減算の状況の有無));
        }

        @Test
        public void setKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員の欠員による減算の状況の有無).build();
            assertThat(result.get介護支援専門員の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員の欠員による減算の状況の有無));
        }

        @Test
        public void setKaigoJujishaKetsuinGenzanJokyo_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKaigoJujishaKetsuinGenzanJokyo_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護従業者の欠員による減算の状況の有無).build();
            assertThat(result.get介護従業者の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護従業者の欠員による減算の状況の有無));
        }

        @Test
        public void setKansenTaisakuSidoKanri_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKansenTaisakuSidoKanri_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_感染対策指導管理の有無).build();
            assertThat(result.get感染対策指導管理の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_感染対策指導管理の有無));
        }

        @Test
        public void setJushoHifuKaiyouShidoKanri_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJushoHifuKaiyouShidoKanri_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_重症皮膚潰瘍指導管理の有無).build();
            assertThat(result.get重症皮膚潰瘍指導管理の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_重症皮膚潰瘍指導管理の有無));
        }

        @Test
        public void setYakuzaiKaniriShido_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setYakuzaiKaniriShido_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_薬剤管理指導の有無).build();
            assertThat(result.get薬剤管理指導の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_薬剤管理指導の有無));
        }

        @Test
        public void setShogaishaSeikatsuShienTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShogaishaSeikatsuShienTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_障害者生活支援体制の有無).build();
            assertThat(result.get障害者生活支援体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_障害者生活支援体制の有無));
        }

        @Test
        public void setChiikiKubunCodeで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setChiikiKubunCode(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_地域区分コード).build();
            assertThat(result.get地域区分コード(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_地域区分コード));
        }

        @Test
        public void setJikanEnchoServiceTaiseiで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJikanEnchoServiceTaisei(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_時間延長サービス体制).build();
            assertThat(result.get時間延長サービス体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_時間延長サービス体制));
        }

        @Test
        public void setKobetsuRehabilitationTeikyoTaiseiで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehabilitationTeikyoTaisei(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制));
        }

        @Test
        public void setKyojuhiTaisakuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKyojuhiTaisaku(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_居住費対策).build();
            assertThat(result.get居住費対策(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_居住費対策));
        }

        @Test
        public void setYakanCare_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setYakanCare_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間ケアの有無).build();
            assertThat(result.get夜間ケアの有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間ケアの有無));
        }

        @Test
        public void setRehabilitationKinoKyoka_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRehabilitationKinoKyoka_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション機能強化の有無).build();
            assertThat(result.getﾘﾊﾋﾞﾘﾃｰｼｮﾝ機能強化の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_リハビリテーション機能強化の有無));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_総合リハビリテーション施設_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_総合ﾘﾊﾋﾞﾘﾃｰｼｮﾝ施設_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_総合リハビリテーション施設_の有無));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1で設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅱ_の有無1).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無1(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅱ_の有無1));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅲ_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅲ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅲ_の有無));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_SagyoRyohoII_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_作業療法Ⅱ_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法Ⅱ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_作業療法Ⅱ_の有無));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅰ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法Ⅱ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無));
        }

        @Test
        public void setGengoChokakushiKetsuinGenzanJokyo_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setGengoChokakushiKetsuinGenzanJokyo_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_言語聴覚士の欠員による減算の状況の有無).build();
            assertThat(result.get言語聴覚士の欠員による減算の状況の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_言語聴覚士の欠員による減算の状況の有無));
        }

        @Test
        public void setEiyouKanriHyokaで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setEiyouKanriHyoka(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_栄養管理の評価).build();
            assertThat(result.get栄養管理の評価(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_栄養管理の評価));
        }

        @Test
        public void setTokuteijigyoushoKasan_HomonKaigo_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTokuteijigyoushoKasan_HomonKaigo_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特定事業所加算_訪問介護_の有無).build();
            assertThat(result.get特定事業所加算_訪問介護_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特定事業所加算_訪問介護_の有無));
        }

        @Test
        public void setJakunenseiNinchishoCareTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJakunenseiNinchishoCareTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_若年性認知症ケア体制の有無).build();
            assertThat(result.get若年性認知症ケア体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_若年性認知症ケア体制の有無));
        }

        @Test
        public void setUndokiKinoKojoTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setUndokiKinoKojoTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_運動器機能向上体制の有無).build();
            assertThat(result.get運動器機能向上体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_運動器機能向上体制の有無));
        }

        @Test
        public void setEiyoManagement_KaizenTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setEiyoManagement_KaizenTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_栄養マネジメント_改善_体制の有無).build();
            assertThat(result.get栄養マネジメント_改善_体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_栄養マネジメント_改善_体制の有無));
        }

        @Test
        public void setKokuKinoKojoTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKokuKinoKojoTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口腔機能向上体制の有無).build();
            assertThat(result.get口腔機能向上体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_口腔機能向上体制の有無));
        }

        @Test
        public void setJigyoshoHyokaKasan_Moshide_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshoHyokaKasan_Moshide_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業所評価加算_申出_の有無).build();
            assertThat(result.get事業所評価加算_申出_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業所評価加算_申出_の有無));
        }

        @Test
        public void setJigyoshoHyokaKasan_Kettei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJigyoshoHyokaKasan_Kettei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業所評価加算_決定_の有無).build();
            assertThat(result.get事業所評価加算_決定_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業所評価加算_決定_の有無));
        }

        @Test
        public void setKinkyuUkeireTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKinkyuUkeireTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急受入体制の有無).build();
            assertThat(result.get緊急受入体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急受入体制の有無));
        }

        @Test
        public void setYakanKangoTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setYakanKangoTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間看護体制の有無).build();
            assertThat(result.get夜間看護体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間看護体制の有無));
        }

        @Test
        public void setTokuteijigyoshoKasan_Kyotakukaigoshien_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTokuteijigyoshoKasan_Kyotakukaigoshien_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特定事業所加算_居宅介護支援_の有無).build();
            assertThat(result.get特定事業所加算_居宅介護支援_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_特定事業所加算_居宅介護支援_の有無));
        }

        @Test
        public void setKaigoShienSemmoninSenjuJokinshaNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKaigoShienSemmoninSenjuJokinshaNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_専従の常勤者).build();
            assertThat(result.get介護支援専門員数_専従の常勤者(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_専従の常勤者));
        }

        @Test
        public void setKaigoSienSemmoninSenjuHijokinshaNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKaigoSienSemmoninSenjuHijokinshaNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_専従の非常勤者).build();
            assertThat(result.get介護支援専門員数_専従の非常勤者(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_専従の非常勤者));
        }

        @Test
        public void setKaigoSienSemmoninKemmuJokinshaNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKaigoSienSemmoninKemmuJokinshaNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_兼務の常勤者).build();
            assertThat(result.get介護支援専門員数_兼務の常勤者(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_兼務の常勤者));
        }

        @Test
        public void setKaigoSienSemmoninKemmuHijokinshaNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKaigoSienSemmoninKemmuHijokinshaNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_兼務の非常勤者).build();
            assertThat(result.get介護支援専門員数_兼務の非常勤者(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護支援専門員数_兼務の非常勤者));
        }

        @Test
        public void setHomonkaigoServiceTeikyoSekininshaNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setHomonkaigoServiceTeikyoSekininshaNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護サービス提供責任者数).build();
            assertThat(result.get訪問介護サービス提供責任者数(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護サービス提供責任者数));
        }

        @Test
        public void setHomonkaigoSenjuJokinshaNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setHomonkaigoSenjuJokinshaNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_専従の常勤者).build();
            assertThat(result.get訪問介護員数_専従の常勤者(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_専従の常勤者));
        }

        @Test
        public void setHomonkaigoSenjuHijokinshaNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setHomonkaigoSenjuHijokinshaNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_専従の非常勤者).build();
            assertThat(result.get訪問介護員数_専従の非常勤者(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_専従の非常勤者));
        }

        @Test
        public void setHomonkaigoKemmuJokinshaNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setHomonkaigoKemmuJokinshaNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_兼務の常勤者).build();
            assertThat(result.get訪問介護員数_兼務の常勤者(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_兼務の常勤者));
        }

        @Test
        public void setHomonkaigoKemmuHijokinshaNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setHomonkaigoKemmuHijokinshaNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_兼務の非常勤者).build();
            assertThat(result.get訪問介護員数_兼務の非常勤者(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_兼務の非常勤者));
        }

        @Test
        public void setHomonkaigoJokinKanzangoNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setHomonkaigoJokinKanzangoNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_常勤換算後の人数).build();
            assertThat(result.get訪問介護員数_常勤換算後の人数(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_訪問介護員数_常勤換算後の人数));
        }

        @Test
        public void setRiyoTeiinNinsuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRiyoTeiinNinsu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_利用定員数).build();
            assertThat(result.get利用定員数(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_利用定員数));
        }

        @Test
        public void setShiteiYukoKaishiYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShiteiYukoKaishiYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効開始日).build();
            assertThat(result.get指定有効開始日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効開始日));
        }

        @Test
        public void setShiteiYukoShuryoYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShiteiYukoShuryoYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定有効終了日).build();
            assertThat(result.get指定有効終了日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定有効終了日));
        }

        @Test
        public void setShiteiKoshinShinseichuKubunで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShiteiKoshinShinseichuKubun(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定更新申請中区分).build();
            assertThat(result.get指定更新申請中区分(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_指定更新申請中区分));
        }

        @Test
        public void setKoryokuTeishiKaishiYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKoryokuTeishiKaishiYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_効力停止開始日).build();
            assertThat(result.get効力停止開始日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_効力停止開始日));
        }

        @Test
        public void setKoryokuTeishiShuryoYMDで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKoryokuTeishiShuryoYMD(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_効力停止終了日).build();
            assertThat(result.get効力停止終了日(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_効力停止終了日));
        }

        @Test
        public void setDaikiboJigyoshaGaito_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setDaikiboJigyoshaGaito_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_大規模事業所該当の有無).build();
            assertThat(result.get大規模事業所該当の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_大規模事業所該当の有無));
        }

        @Test
        public void setJunUnitCareTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJunUnitCareTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_準ユニットケア体制の有無).build();
            assertThat(result.get準ユニットケア体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_準ユニットケア体制の有無));
        }

        @Test
        public void setJudokaTaioTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJudokaTaioTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_重度化対応体制の有無).build();
            assertThat(result.get重度化対応体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_重度化対応体制の有無));
        }

        @Test
        public void setIryoRenkeiTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setIryoRenkeiTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医療連携体制の有無).build();
            assertThat(result.get医療連携体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_医療連携体制の有無));
        }

        @Test
        public void setUnitCareTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setUnitCareTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_ユニットケア体制の有無).build();
            assertThat(result.getユニットケア体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_ユニットケア体制の有無));
        }

        @Test
        public void setZaitaku_nyushoSogoRiyoTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setZaitaku_nyushoSogoRiyoTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_在宅_入所相互利用体制の有無).build();
            assertThat(result.get在宅_入所相互利用体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_在宅_入所相互利用体制の有無));
        }

        @Test
        public void setTerminalCareTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTerminalCareTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_ターミナルケア体制_看取り介護体制_の有無).build();
            assertThat(result.getターミナルケア体制_看取り介護体制_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_ターミナルケア体制_看取り介護体制_の有無));
        }

        @Test
        public void setShintaiKosokuHaishiTorikumi_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShintaiKosokuHaishiTorikumi_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_身体拘束廃止取組の有無).build();
            assertThat(result.get身体拘束廃止取組の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_身体拘束廃止取組の有無));
        }

        @Test
        public void setShokiboKyotenShugoTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShokiboKyotenShugoTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_小規模拠点集合体制の有無).build();
            assertThat(result.get小規模拠点集合体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_小規模拠点集合体制の有無));
        }

        @Test
        public void setNinchishoCareKasan_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setNinchishoCareKasan_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症ケア加算の有無).build();
            assertThat(result.get認知症ケア加算の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症ケア加算の有無));
        }

        @Test
        public void setKobetsuKinoKunrenTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuKinoKunrenTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別機能訓練体制の有無).build();
            assertThat(result.get個別機能訓練体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別機能訓練体制の有無));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_RigakuRyohoI_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅰ_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅰ_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅰ_の有無));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2で設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅱ_の有無2).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_理学療法Ⅱ_の有無2(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_理学療法Ⅱ_の有無2));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_SagyoRyoho_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_SagyoRyoho_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_作業療法_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_作業療法_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_作業療法_の有無));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_言語聴覚療法_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_言語聴覚療法_の有無));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_Sonota_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_Sonota_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_その他_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_その他_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_その他_の有無));
        }

        @Test
        public void setSetsubiKijunで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setSetsubiKijun(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_設備基準).build();
            assertThat(result.get設備基準(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_設備基準));
        }

        @Test
        public void setRyoyoTaiseiIjiTokubetsuKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRyoyoTaiseiIjiTokubetsuKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養体制維持特別加算).build();
            assertThat(result.get療養体制維持特別加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養体制維持特別加算));
        }

        @Test
        public void setKobetsuRehaTeikyoTaisei_RehaShidoKanri_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_リハビリテーション指導管理_の有無).build();
            assertThat(result.get個別ﾘﾊﾋﾞﾘﾃｰｼｮﾝ提供体制_ﾘﾊﾋﾞﾘﾃｰｼｮﾝ指導管理_の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_個別リハビリテーション提供体制_リハビリテーション指導管理_の有無));
        }

        @Test
        public void setSankyuHelperTaiseiで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setSankyuHelperTaisei(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_３級ヘルパー体制).build();
            assertThat(result.get三級ヘルパー体制(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_３級ヘルパー体制));
        }

        @Test
        public void setChuSankanChiikiShokiboJigyoshoKasan_chiikiで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setChuSankanChiikiShokiboJigyoshoKasan_chiiki(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_中山間地域等における小規模事業所加算_地域に関する状況).build();
            assertThat(result.get中山間地域等における小規模事業所加算_地域に関する状況(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_中山間地域等における小規模事業所加算_地域に関する状況));
        }

        @Test
        public void setChuSankanChiikiShokiboJigyoushoKasan_kiboで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setChuSankanChiikiShokiboJigyoushoKasan_kibo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_中山間地域等における小規模事業所加算_規模に関する状況).build();
            assertThat(result.get中山間地域等における小規模事業所加算_規模に関する状況(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_中山間地域等における小規模事業所加算_規模に関する状況));
        }

        @Test
        public void setServiceTeikyoTaiseiKyokaKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setServiceTeikyoTaiseiKyokaKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供体制強化加算).build();
            assertThat(result.getサービス提供体制強化加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供体制強化加算));
        }

        @Test
        public void setNinchishoTankiShuchuRehabilitationKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setNinchishoTankiShuchuRehabilitationKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症短期集中リハビリテーション加算).build();
            assertThat(result.get認知症短期集中リハビリテーション加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症短期集中リハビリテーション加算));
        }

        @Test
        public void setJakunenseiNinchishoRiyoushaUkeeireKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setJakunenseiNinchishoRiyoushaUkeeireKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_若年性認知症利用者_入所者_患者_受入加算).build();
            assertThat(result.get若年性認知症利用者_入所者_患者_受入加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_若年性認知症利用者_入所者_患者_受入加算));
        }

        @Test
        public void setKangoTaiseiKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKangoTaiseiKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護体制加算).build();
            assertThat(result.get看護体制加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護体制加算));
        }

        @Test
        public void setYakinShokuinHaichiKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setYakinShokuinHaichiKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜勤職員配置加算).build();
            assertThat(result.get夜勤職員配置加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜勤職員配置加算));
        }

        @Test
        public void setRyoyoShokuKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setRyoyoShokuKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養食加算).build();
            assertThat(result.get療養食加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_療養食加算));
        }

        @Test
        public void setNichijoSeikatsuKeizokuShienKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setNichijoSeikatsuKeizokuShienKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_日常生活継続支援加算).build();
            assertThat(result.get日常生活継続支援加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_日常生活継続支援加算));
        }

        @Test
        public void setNinchishoSemmonCareKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setNinchishoSemmonCareKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症専門ケア加算).build();
            assertThat(result.get認知症専門ケア加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_認知症専門ケア加算));
        }

        @Test
        public void setTwentyFourHoursTsuhoTaioKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setTwentyFourHoursTsuhoTaioKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_２４時間通報対応加算).build();
            assertThat(result.get二十四時間通報対応加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_２４時間通報対応加算));
        }

        @Test
        public void setKangoShokuinHaichiKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKangoShokuinHaichiKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護職員配置加算).build();
            assertThat(result.get看護職員配置加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_看護職員配置加算));
        }

        @Test
        public void setYakanCareKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setYakanCareKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間ケア加算).build();
            assertThat(result.get夜間ケア加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_夜間ケア加算));
        }

        @Test
        public void setShudanCommunicationRyoho_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setShudanCommunicationRyoho_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_集団コミュニケーション療法の有無).build();
            assertThat(result.get集団コミュニケーション療法の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_集団コミュニケーション療法の有無));
        }

        @Test
        public void setServiceTeikyoTaiseiKyokaKasan_Karadokogataで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setServiceTeikyoTaiseiKyokaKasan_Karadokogata(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供体制強化加算_空床型).build();
            assertThat(result.getサービス提供体制強化加算_空床型(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供体制強化加算_空床型));
        }

        @Test
        public void setNitchuShintaikaigoTaise_20funmiman_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setNitchuShintaikaigoTaise_20funmiman_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_日中の身体介護２０分未満体制の有無).build();
            assertThat(result.get日中の身体介護２０分未満体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_日中の身体介護２０分未満体制の有無));
        }

        @Test
        public void setServiceTeikyoSekininshaTaisei_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setServiceTeikyoSekininshaTaisei_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供責任者体制の有無).build();
            assertThat(result.getサービス提供責任者体制の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス提供責任者体制の有無));
        }

        @Test
        public void setDoitsuTatemonoKyojuRiyoshaGenzan_umuで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setDoitsuTatemonoKyojuRiyoshaGenzan_umu(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_同一建物に居住する利用者の減算の有無).build();
            assertThat(result.get同一建物に居住する利用者の減算の有無(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_同一建物に居住する利用者の減算の有無));
        }

        @Test
        public void setKinkyuTankiNyushoTaiseiKakuhoKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKinkyuTankiNyushoTaiseiKakuhoKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急短期入所体制確保加算).build();
            assertThat(result.get緊急短期入所体制確保加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_緊急短期入所体制確保加算));
        }

        @Test
        public void setZaitakuFukki_ZaitakuRyoyoShienKinoKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setZaitakuFukki_ZaitakuRyoyoShienKinoKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_在宅復帰_在宅療養支援機能加算).build();
            assertThat(result.get在宅復帰_在宅療養支援機能加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_在宅復帰_在宅療養支援機能加算));
        }

        @Test
        public void setSeikatuKinoKojoGroupKatsudoKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setSeikatuKinoKojoGroupKatsudoKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_生活機能向上グループ活動加算).build();
            assertThat(result.get生活機能向上グループ活動加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_生活機能向上グループ活動加算));
        }

        @Test
        public void setKaigoShokuinShoguKaizenKasanで設定した値を_生成されたKaigoJigyoshaShiteiServiceも保持する() {
            KaigoJigyoshaShiteiService result = KaigoJigyoshaShiteiService.newBuilder().setKaigoShokuinShoguKaizenKasan(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護職員処遇改善加算).build();
            assertThat(result.get介護職員処遇改善加算(), is(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_介護職員処遇改善加算));
        }
    }

    public static class SerializationProxyTest {

        private KaigoJigyoshaShiteiService sut;

        @Before
        public void setUp() {
            sut = KaigoJigyoshaShiteiService.newBuilder().build();
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            sut.createBuilderForEdit().setJigyoshaNo(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号);
            String b64 = _Base64Serializer.serialize(sut.serialize());
            KaigoJigyoshaShiteiService desirialized = _Base64Serializer.deSerialize(b64, KaigoJigyoshaShiteiService.class);
            assertThat(desirialized.get事業者番号(), is(sut.get事業者番号()));
        }
    }

    public static class getStateTest extends DbxTestBase {

        private static KaigoJigyoshaShiteiService sut;

        @Before
        public void setUp() {
            sut = KaigoJigyoshaShiteiService.newBuilder().build();
        }

        @Test
        public void LDNS_メソッドgetStateが呼び出される場合_getStateは_Addedを返す() {
            assertThat(sut.getState(), is(EntityDataState.Added));
        }

    }

    public static class LDNS_コンストラクタTEST extends DbxTestBase {

        @Test
        public void LDNS_privateConstructor() throws Exception {
            Constructor<KaigoJigyoshaShiteiService> constructor = KaigoJigyoshaShiteiService.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }

    }
}
