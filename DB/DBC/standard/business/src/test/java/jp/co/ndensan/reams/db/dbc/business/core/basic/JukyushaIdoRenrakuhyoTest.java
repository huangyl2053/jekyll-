/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3001JukyushaIdoRenrakuhyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaIdoRenrakuhyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaIdoRenrakuhyoTest extends DbcTestBase {

    private static DbT3001JukyushaIdoRenrakuhyoEntity JukyushaIdoRenrakuhyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動年月日;
        主キー名2 = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_異動区分コード;
        主キー名3 = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_受給者異動事由;
        主キー名4 = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JukyushaIdoRenrakuhyo sut;

        @Before
        public void setUp() {
            JukyushaIdoRenrakuhyoEntity = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.createDbT3001JukyushaIdoRenrakuhyoEntity();
            JukyushaIdoRenrakuhyoEntity.setIdoYMD(主キー名1);
            JukyushaIdoRenrakuhyoEntity.setIdoKubunCode(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaIdoRenrakuhyo(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaIdoRenrakuhyo(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3001JukyushaIdoRenrakuhyoEntityにセットされている() {
            sut = new JukyushaIdoRenrakuhyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get異動年月日(), is(主キー名1));
            assertThat(sut.get異動区分コード(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJukyushaIdoRenrakuhyoIdentifierにセットされている() {
            sut = new JukyushaIdoRenrakuhyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get異動年月日(), is(主キー名1));
            assertThat(sut.identifier().get異動区分コード(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JukyushaIdoRenrakuhyo sut;

        @Before
        public void setUp() {
            JukyushaIdoRenrakuhyoEntity = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.createDbT3001JukyushaIdoRenrakuhyoEntity();
            JukyushaIdoRenrakuhyoEntity.setIdoYMD(主キー名1);
            JukyushaIdoRenrakuhyoEntity.setIdoKubunCode(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JukyushaIdoRenrakuhyo(null);
        }

        @Test
        public void 指定したDbT3001JukyushaIdoRenrakuhyoEntityのキー情報を識別子が持つ() {

            sut = new JukyushaIdoRenrakuhyo(JukyushaIdoRenrakuhyoEntity);

            assertThat(sut.identifier().get異動年月日(), is(主キー名1));
            assertThat(sut.identifier().get異動区分コード(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static JukyushaIdoRenrakuhyo sut;

        @Before
        public void setUp() {
            JukyushaIdoRenrakuhyoEntity = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.createDbT3001JukyushaIdoRenrakuhyoEntity();
            JukyushaIdoRenrakuhyoEntity.setIdoYMD(主キー名1);
            JukyushaIdoRenrakuhyoEntity.setIdoKubunCode(主キー名2);

            sut = new JukyushaIdoRenrakuhyo(JukyushaIdoRenrakuhyoEntity);
        }

        @Test
        public void get異動年月日は_entityが持つ異動年月日を返す() {
            assertThat(sut.get異動年月日(), is(JukyushaIdoRenrakuhyoEntity.getIdoYMD()));
        }

        @Test
        public void get異動区分コードは_entityが持つ異動区分コードを返す() {
            assertThat(sut.get異動区分コード(), is(JukyushaIdoRenrakuhyoEntity.getIdoKubunCode()));
        }

        @Test
        public void get受給者異動事由は_entityが持つ受給者異動事由を返す() {
            assertThat(sut.get受給者異動事由(), is(JukyushaIdoRenrakuhyoEntity.getJukyushaIdoJiyu()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(JukyushaIdoRenrakuhyoEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(JukyushaIdoRenrakuhyoEntity.getHiHokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JukyushaIdoRenrakuhyoEntity.getRirekiNo()));
        }

        @Test
        public void get被保険者氏名カナは_entityが持つ被保険者氏名カナを返す() {
            assertThat(sut.get被保険者氏名カナ(), is(JukyushaIdoRenrakuhyoEntity.getHiHokenshaNameKana()));
        }

        @Test
        public void get生年月日は_entityが持つ生年月日を返す() {
            assertThat(sut.get生年月日(), is(JukyushaIdoRenrakuhyoEntity.getUmareYMD()));
        }

        @Test
        public void get性別コードは_entityが持つ性別コードを返す() {
            assertThat(sut.get性別コード(), is(JukyushaIdoRenrakuhyoEntity.getSeibetsuCode()));
        }

        @Test
        public void get資格取得年月日は_entityが持つ資格取得年月日を返す() {
            assertThat(sut.get資格取得年月日(), is(JukyushaIdoRenrakuhyoEntity.getShikakuShutokuYMD()));
        }

        @Test
        public void get資格喪失年月日は_entityが持つ資格喪失年月日を返す() {
            assertThat(sut.get資格喪失年月日(), is(JukyushaIdoRenrakuhyoEntity.getShikakuSoshitsuYMD()));
        }

        @Test
        public void get老人保健市町村番号は_entityが持つ老人保健市町村番号を返す() {
            assertThat(sut.get老人保健市町村番号(), is(JukyushaIdoRenrakuhyoEntity.getRojinHokenShichosonNo()));
        }

        @Test
        public void get老人保健受給者番号は_entityが持つ老人保健受給者番号を返す() {
            assertThat(sut.get老人保健受給者番号(), is(JukyushaIdoRenrakuhyoEntity.getRojinHokenJukyushaNo()));
        }

        @Test
        public void get公費負担者番号は_entityが持つ公費負担者番号を返す() {
            assertThat(sut.get公費負担者番号(), is(JukyushaIdoRenrakuhyoEntity.getKohiFutanshaNo()));
        }

        @Test
        public void get広域連合_政令市_保険者番号は_entityが持つ広域連合_政令市_保険者番号を返す() {
            assertThat(sut.get広域連合_政令市_保険者番号(), is(JukyushaIdoRenrakuhyoEntity.getKoikiRengoHokenshaNo()));
        }

        @Test
        public void get申請種別コードは_entityが持つ申請種別コードを返す() {
            assertThat(sut.get申請種別コード(), is(JukyushaIdoRenrakuhyoEntity.getShinseiShubetsuCode()));
        }

        @Test
        public void get変更申請中区分コードは_entityが持つ変更申請中区分コードを返す() {
            assertThat(sut.get変更申請中区分コード(), is(JukyushaIdoRenrakuhyoEntity.getHenkoShinseichuKubunCode()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(JukyushaIdoRenrakuhyoEntity.getShinseiYMD()));
        }

        @Test
        public void getみなし要介護状態区分コードは_entityが持つみなし要介護状態区分コードを返す() {
            assertThat(sut.getみなし要介護状態区分コード(), is(JukyushaIdoRenrakuhyoEntity.getMinashiYokaigoJotaiKubunCode()));
        }

        @Test
        public void get要介護状態区分コードは_entityが持つ要介護状態区分コードを返す() {
            assertThat(sut.get要介護状態区分コード(), is(JukyushaIdoRenrakuhyoEntity.getYokaigoJotaiKubunCode()));
        }

        @Test
        public void get認定有効期間開始年月日は_entityが持つ認定有効期間開始年月日を返す() {
            assertThat(sut.get認定有効期間開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getNinteiYukoKikankaishiYMD()));
        }

        @Test
        public void get認定有効期間終了年月日は_entityが持つ認定有効期間終了年月日を返す() {
            assertThat(sut.get認定有効期間終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getNinteiYukoKikanShuryoYMD()));
        }

        @Test
        public void get居宅サービス計画作成区分コードは_entityが持つ居宅サービス計画作成区分コードを返す() {
            assertThat(sut.get居宅サービス計画作成区分コード(), is(JukyushaIdoRenrakuhyoEntity.getKyotakuServiceSakuseiKubunCode()));
        }

        @Test
        public void get居宅介護支援事業所番号は_entityが持つ居宅介護支援事業所番号を返す() {
            assertThat(sut.get居宅介護支援事業所番号(), is(JukyushaIdoRenrakuhyoEntity.getKyotakuKaigoShienJigyoshoNo()));
        }

        @Test
        public void get居宅サービス計画適用開始年月日は_entityが持つ居宅サービス計画適用開始年月日を返す() {
            assertThat(sut.get居宅サービス計画適用開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getKyotakuServiceTekiyoKaishiYMD()));
        }

        @Test
        public void get居宅サービス計画適用終了年月日は_entityが持つ居宅サービス計画適用終了年月日を返す() {
            assertThat(sut.get居宅サービス計画適用終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getKyotakuServiceTekiyoShuryoYMD()));
        }

        @Test
        public void get訪問通所サービス支給限度基準額は_entityが持つ訪問通所サービス支給限度基準額を返す() {
            assertThat(sut.get訪問通所サービス支給限度基準額(), is(JukyushaIdoRenrakuhyoEntity.getHomonTsushoServiceShikyuGendoKijungaku()));
        }

        @Test
        public void get訪問通所サービス上限管理適用期間開始年月日は_entityが持つ訪問通所サービス上限管理適用期間開始年月日を返す() {
            assertThat(sut.get訪問通所サービス上限管理適用期間開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getHomonTsushoServiceJogenKanriTekiyoKaishiYMD()));
        }

        @Test
        public void get訪問通所サービス上限管理適用期間終了年月日は_entityが持つ訪問通所サービス上限管理適用期間終了年月日を返す() {
            assertThat(sut.get訪問通所サービス上限管理適用期間終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getHomonTsushoServiceJogenKanriTekiyoShuryoYMD()));
        }

        @Test
        public void get短期入所サービス支給限度基準額は_entityが持つ短期入所サービス支給限度基準額を返す() {
            assertThat(sut.get短期入所サービス支給限度基準額(), is(JukyushaIdoRenrakuhyoEntity.getTankiNyushoServiceShikyuGendoKijungaku()));
        }

        @Test
        public void get短期入所サービス上限管理適用期間開始年月日は_entityが持つ短期入所サービス上限管理適用期間開始年月日を返す() {
            assertThat(sut.get短期入所サービス上限管理適用期間開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getTankinyushoServiceJogenKanriTekiyoKaishiYMD()));
        }

        @Test
        public void get短期入所サービス上限管理適用期間終了年月日は_entityが持つ短期入所サービス上限管理適用期間終了年月日を返す() {
            assertThat(sut.get短期入所サービス上限管理適用期間終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getTankinyushoServiceJogenKanriTekiyoShuryoYMD()));
        }

        @Test
        public void get公費負担上限額減額有フラグは_entityが持つ公費負担上限額減額有フラグを返す() {
            assertThat(sut.is公費負担上限額減額有フラグ(), is(JukyushaIdoRenrakuhyoEntity.getKohiFutanJogenGengakuAriFlag()));
        }

        @Test
        public void get償還払化開始年月日は_entityが持つ償還払化開始年月日を返す() {
            assertThat(sut.get償還払化開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getShokanbaraikaKaishiYMD()));
        }

        @Test
        public void get償還払化終了年月日は_entityが持つ償還払化終了年月日を返す() {
            assertThat(sut.get償還払化終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getShokanbaraikaShuryoYMD()));
        }

        @Test
        public void get給付率引下げ開始年月日は_entityが持つ給付率引下げ開始年月日を返す() {
            assertThat(sut.get給付率引下げ開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getKyufuritsuHikisageKaishiYMD()));
        }

        @Test
        public void get給付率引下げ終了年月日は_entityが持つ給付率引下げ終了年月日を返す() {
            assertThat(sut.get給付率引下げ終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getKyufuritsuHikisageShuryoYMD()));
        }

        @Test
        public void get減免申請中区分コードは_entityが持つ減免申請中区分コードを返す() {
            assertThat(sut.get減免申請中区分コード(), is(JukyushaIdoRenrakuhyoEntity.getGemmenShinseichuKubunCode()));
        }

        @Test
        public void get利用者負担区分コードは_entityが持つ利用者負担区分コードを返す() {
            assertThat(sut.get利用者負担区分コード(), is(JukyushaIdoRenrakuhyoEntity.getRiyoshaFutanKubunCode()));
        }

        @Test
        public void get給付率は_entityが持つ給付率を返す() {
            assertThat(sut.get給付率(), is(JukyushaIdoRenrakuhyoEntity.getKyufuritsu()));
        }

        @Test
        public void get適用開始年月日は_entityが持つ適用開始年月日を返す() {
            assertThat(sut.get適用開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getTekiyoKaishiYMD()));
        }

        @Test
        public void get適用終了年月日は_entityが持つ適用終了年月日を返す() {
            assertThat(sut.get適用終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getTekiyoShuryoYMD()));
        }

        @Test
        public void get標準負担区分コードは_entityが持つ標準負担区分コードを返す() {
            assertThat(sut.get標準負担区分コード(), is(JukyushaIdoRenrakuhyoEntity.getHyojunFutanKubunCode()));
        }

        @Test
        public void get負担額は_entityが持つ負担額を返す() {
            assertThat(sut.get負担額(), is(JukyushaIdoRenrakuhyoEntity.getFutangaku()));
        }

        @Test
        public void get負担額適用開始年月日は_entityが持つ負担額適用開始年月日を返す() {
            assertThat(sut.get負担額適用開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getFutangakuTekiyoKaishiYMD()));
        }

        @Test
        public void get負担額適用終了年月日は_entityが持つ負担額適用終了年月日を返す() {
            assertThat(sut.get負担額適用終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getFutangakuTekiyoShuryoYMD()));
        }

        @Test
        public void get特定入所者認定申請中区分コードは_entityが持つ特定入所者認定申請中区分コードを返す() {
            assertThat(sut.get特定入所者認定申請中区分コード(), is(JukyushaIdoRenrakuhyoEntity.getTokuteiNyushoshaNinteiShinseichuKubunCode()));
        }

        @Test
        public void get特定入所者介護サービス区分コードは_entityが持つ特定入所者介護サービス区分コードを返す() {
            assertThat(sut.get特定入所者介護サービス区分コード(), is(JukyushaIdoRenrakuhyoEntity.getTokuteiNyushoshaKaigoServiceKubunCode()));
        }

        @Test
        public void get課税層の特例減額措置対象フラグは_entityが持つ課税層の特例減額措置対象フラグを返す() {
            assertThat(sut.is課税層の特例減額措置対象フラグ(), is(JukyushaIdoRenrakuhyoEntity.getKaizeisoTokureiGengakuSochiTaishoFlag()));
        }

        @Test
        public void get食費負担限度額は_entityが持つ食費負担限度額を返す() {
            assertThat(sut.get食費負担限度額(), is(JukyushaIdoRenrakuhyoEntity.getShokuhiFutanGendogaku()));
        }

        @Test
        public void get居住費ユニット型個室負担限度額は_entityが持つ居住費ユニット型個室負担限度額を返す() {
            assertThat(sut.get居住費ユニット型個室負担限度額(), is(JukyushaIdoRenrakuhyoEntity.getKyojuhiUnitGataKoshitsuFutanGendogaku()));
        }

        @Test
        public void get居住費ユニット型準個室負担限度額は_entityが持つ居住費ユニット型準個室負担限度額を返す() {
            assertThat(sut.get居住費ユニット型準個室負担限度額(), is(JukyushaIdoRenrakuhyoEntity.getKyojuhiUnitGataJunKoshitsuFutanGendogaku()));
        }

        @Test
        public void get居住費従来型個室特養等負担限度額は_entityが持つ居住費従来型個室特養等負担限度額を返す() {
            assertThat(sut.get居住費従来型個室特養等負担限度額(), is(JukyushaIdoRenrakuhyoEntity.getKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku()));
        }

        @Test
        public void get居住費従来型個室老健療養等負担限度額は_entityが持つ居住費従来型個室老健療養等負担限度額を返す() {
            assertThat(sut.get居住費従来型個室老健療養等負担限度額(), is(JukyushaIdoRenrakuhyoEntity.getKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku()));
        }

        @Test
        public void get居住費多床室負担限度額は_entityが持つ居住費多床室負担限度額を返す() {
            assertThat(sut.get居住費多床室負担限度額(), is(JukyushaIdoRenrakuhyoEntity.getKyujuhiTashoshitsuFutanGendogaku()));
        }

        @Test
        public void get負担限度額適用開始年月日は_entityが持つ負担限度額適用開始年月日を返す() {
            assertThat(sut.get負担限度額適用開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getFutanGendogakuTekiyoKaishiYMD()));
        }

        @Test
        public void get負担限度額適用終了年月日は_entityが持つ負担限度額適用終了年月日を返す() {
            assertThat(sut.get負担限度額適用終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getFutanGendogakuTekiyoShuryoYMD()));
        }

        @Test
        public void get軽減率は_entityが持つ軽減率を返す() {
            assertThat(sut.get軽減率(), is(JukyushaIdoRenrakuhyoEntity.getKeigenritsu()));
        }

        @Test
        public void get軽減率適用開始年月日は_entityが持つ軽減率適用開始年月日を返す() {
            assertThat(sut.get軽減率適用開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getKeigenritsuTekiyoKaishiYMD()));
        }

        @Test
        public void get軽減率適用終了年月日は_entityが持つ軽減率適用終了年月日を返す() {
            assertThat(sut.get軽減率適用終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getKeigenritsuTekiyoShuryoYMD()));
        }

        @Test
        public void get小多機能居宅介護利用開始月利用有フラグは_entityが持つ小多機能居宅介護利用開始月利用有フラグを返す() {
            assertThat(sut.is小多機能居宅介護利用開始月利用有フラグ(), is(JukyushaIdoRenrakuhyoEntity.getShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag()));
        }

        @Test
        public void get後期高齢者医療保険者番号は_entityが持つ後期高齢者医療保険者番号を返す() {
            assertThat(sut.get後期高齢者医療保険者番号(), is(JukyushaIdoRenrakuhyoEntity.getKokiKoureiIryoHokenshaNo()));
        }

        @Test
        public void get後期高齢者医療被保険者番号は_entityが持つ後期高齢者医療被保険者番号を返す() {
            assertThat(sut.get後期高齢者医療被保険者番号(), is(JukyushaIdoRenrakuhyoEntity.getKokikoureiIryoHiHokenshaNo()));
        }

        @Test
        public void get国民健康保険保険者番号は_entityが持つ国民健康保険保険者番号を返す() {
            assertThat(sut.get国民健康保険保険者番号(), is(JukyushaIdoRenrakuhyoEntity.getKokuhoHokenshaNo()));
        }

        @Test
        public void get国民健康保険被保険者証番号は_entityが持つ国民健康保険被保険者証番号を返す() {
            assertThat(sut.get国民健康保険被保険者証番号(), is(JukyushaIdoRenrakuhyoEntity.getKokuhoHiHokenshaNo()));
        }

        @Test
        public void get国民健康保険個人番号は_entityが持つ国民健康保険個人番号を返す() {
            assertThat(sut.get国民健康保険個人番号(), is(JukyushaIdoRenrakuhyoEntity.getKokuhoKojinNo()));
        }

        @Test
        public void get二次予防事業区分コードは_entityが持つ二次予防事業区分コードを返す() {
            assertThat(sut.get二次予防事業区分コード(), is(JukyushaIdoRenrakuhyoEntity.getNijiyoboJigyoKubunCode()));
        }

        @Test
        public void get二次予防事業有効期間開始年月日は_entityが持つ二次予防事業有効期間開始年月日を返す() {
            assertThat(sut.get二次予防事業有効期間開始年月日(), is(JukyushaIdoRenrakuhyoEntity.getNijiyoboJigyoYukoKikanKaishiYMD()));
        }

        @Test
        public void get二次予防事業有効期間終了年月日は_entityが持つ二次予防事業有効期間終了年月日を返す() {
            assertThat(sut.get二次予防事業有効期間終了年月日(), is(JukyushaIdoRenrakuhyoEntity.getNijiyoboJigyoYukoKikanShuryoYMD()));
        }

        @Test
        public void get訂正連絡票フラグは_entityが持つ訂正連絡票フラグを返す() {
            assertThat(sut.is訂正連絡票フラグ(), is(JukyushaIdoRenrakuhyoEntity.getTeiseiRenrakuhyoFlag()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(JukyushaIdoRenrakuhyoEntity.getSofuYM()));
        }

        @Test
        public void get住所地特例対象者区分コードは_entityが持つ住所地特例対象者区分コードを返す() {
            assertThat(sut.get住所地特例対象者区分コード(), is(JukyushaIdoRenrakuhyoEntity.getJushochiTokureiTaishoshaKubunCode()));
        }

        @Test
        public void get施設所在保険者番号は_entityが持つ施設所在保険者番号を返す() {
            assertThat(sut.get施設所在保険者番号(), is(JukyushaIdoRenrakuhyoEntity.getShisetsuShozaiHokenjaNo()));
        }

        @Test
        public void get住所地特例適用開始日は_entityが持つ住所地特例適用開始日を返す() {
            assertThat(sut.get住所地特例適用開始日(), is(JukyushaIdoRenrakuhyoEntity.getJushochiTokureiTekiyoKaishiYMD()));
        }

        @Test
        public void get住所地特例適用終了日は_entityが持つ住所地特例適用終了日を返す() {
            assertThat(sut.get住所地特例適用終了日(), is(JukyushaIdoRenrakuhyoEntity.getJushochiTokureiTekiyoShuryoYMD()));
        }

        @Test
        public void get居宅費_新１_負担限度額は_entityが持つ居宅費_新１_負担限度額を返す() {
            assertThat(sut.get居宅費_新１_負担限度額(), is(JukyushaIdoRenrakuhyoEntity.getKyotakuhiShin1FutanGendogaku()));
        }

        @Test
        public void get居宅費_新２_負担限度額は_entityが持つ居宅費_新２_負担限度額を返す() {
            assertThat(sut.get居宅費_新２_負担限度額(), is(JukyushaIdoRenrakuhyoEntity.getKyotakuhiShin2FutanGendogaku()));
        }

        @Test
        public void get居宅費_新３_負担限度額は_entityが持つ居宅費_新３_負担限度額を返す() {
            assertThat(sut.get居宅費_新３_負担限度額(), is(JukyushaIdoRenrakuhyoEntity.getKyotakuhiShin3FutanGendogaku()));
        }

        @Test
        public void get利用者負担割合有効開始日は_entityが持つ利用者負担割合有効開始日を返す() {
            assertThat(sut.get利用者負担割合有効開始日(), is(JukyushaIdoRenrakuhyoEntity.getRiyosyaFutanWariaiYukoKaishiYMD()));
        }

        @Test
        public void get利用者負担割合有効終了日は_entityが持つ利用者負担割合有効終了日を返す() {
            assertThat(sut.get利用者負担割合有効終了日(), is(JukyushaIdoRenrakuhyoEntity.getRiyosyaFutanWariaiYukoShuryoYMD()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static JukyushaIdoRenrakuhyo sut;

        @Before
        public void setUp() {
            JukyushaIdoRenrakuhyoEntity = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.createDbT3001JukyushaIdoRenrakuhyoEntity();
            JukyushaIdoRenrakuhyoEntity.setIdoYMD(主キー名1);
            JukyushaIdoRenrakuhyoEntity.setIdoKubunCode(主キー名2);

            sut = new JukyushaIdoRenrakuhyo(JukyushaIdoRenrakuhyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JukyushaIdoRenrakuhyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static JukyushaIdoRenrakuhyo sut;

        @Before
        public void setUp() {
            JukyushaIdoRenrakuhyoEntity = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.createDbT3001JukyushaIdoRenrakuhyoEntity();
            JukyushaIdoRenrakuhyoEntity.setIdoYMD(主キー名1);
            JukyushaIdoRenrakuhyoEntity.setIdoKubunCode(主キー名2);

            sut = new JukyushaIdoRenrakuhyo(JukyushaIdoRenrakuhyoEntity);
        }

//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static JukyushaIdoRenrakuhyo sut;
        private static JukyushaIdoRenrakuhyo result;

        @Before
        public void setUp() {
            JukyushaIdoRenrakuhyoEntity = DbT3001JukyushaIdoRenrakuhyoEntityGenerator.createDbT3001JukyushaIdoRenrakuhyoEntity();
            JukyushaIdoRenrakuhyoEntity.setIdoYMD(主キー名1);
            JukyushaIdoRenrakuhyoEntity.setIdoKubunCode(主キー名2);

        }

        @Test
        public void JukyushaIdoRenrakuhyoが保持するDbT3001JukyushaIdoRenrakuhyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJukyushaIdoRenrakuhyoが保持するDbT3001JukyushaIdoRenrakuhyoEntityのEntityDataStateがDeletedに指定されたJukyushaIdoRenrakuhyoが返る() {
            sut = TestSupport.setStateJukyushaIdoRenrakuhyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JukyushaIdoRenrakuhyoが保持するDbT3001JukyushaIdoRenrakuhyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJukyushaIdoRenrakuhyoが保持するDbT3001JukyushaIdoRenrakuhyoEntityのEntityDataStateがDeletedに指定されたJukyushaIdoRenrakuhyoが返る() {
            sut = TestSupport.setStateJukyushaIdoRenrakuhyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JukyushaIdoRenrakuhyoが保持するDbT3001JukyushaIdoRenrakuhyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJukyushaIdoRenrakuhyoが保持するDbT3001JukyushaIdoRenrakuhyoEntityのEntityDataStateがDeletedに指定されたJukyushaIdoRenrakuhyoが返る() {
            sut = TestSupport.setStateJukyushaIdoRenrakuhyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JukyushaIdoRenrakuhyoが保持するDbT3001JukyushaIdoRenrakuhyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJukyushaIdoRenrakuhyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JukyushaIdoRenrakuhyo setStateJukyushaIdoRenrakuhyo(EntityDataState parentState) {
            JukyushaIdoRenrakuhyoEntity.setState(parentState);
            return new JukyushaIdoRenrakuhyo(JukyushaIdoRenrakuhyoEntity);
        }
    }
}
