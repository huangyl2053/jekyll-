/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link JukyushaDaicho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaDaichoTest extends DbdTestBase {

    private static DbT4001JukyushaDaichoEntity JukyushaDaichoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 主キー名1;
    private static HihokenshaNo 主キー名2;
    private static RString 主キー名3;
    private static RString 主キー名4;
    private static Code 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード;
        主キー名2 = DbT4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号;
    }

    public static class 主キーコンストラクタテスト extends DbdTestBase {

        private static JukyushaDaicho sut;

        @Before
        public void setUp() {
            JukyushaDaichoEntity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            JukyushaDaichoEntity.setShichosonCode(主キー名1);
            JukyushaDaichoEntity.setHihokenshaNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaDaicho(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaDaicho(主キー名1, null, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test
        public void 指定したキーが保持するDbT4001JukyushaDaichoEntityにセットされている() {
            sut = new JukyushaDaicho(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.get市町村コード(), is(主キー名1));
            assertThat(sut.get被保険者番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJukyushaDaichoIdentifierにセットされている() {
            sut = new JukyushaDaicho(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.identifier().get市町村コード(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbdTestBase {

        private static JukyushaDaicho sut;

        @Before
        public void setUp() {
            JukyushaDaichoEntity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            JukyushaDaichoEntity.setShichosonCode(主キー名1);
            JukyushaDaichoEntity.setHihokenshaNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JukyushaDaicho(null);
        }

        @Test
        public void 指定したDbT4001JukyushaDaichoEntityのキー情報を識別子が持つ() {

            sut = new JukyushaDaicho(JukyushaDaichoEntity);

            assertThat(sut.identifier().get市町村コード(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbdTestBase {

        private static JukyushaDaicho sut;

        @Before
        public void setUp() {
            JukyushaDaichoEntity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            JukyushaDaichoEntity.setShichosonCode(主キー名1);
            JukyushaDaichoEntity.setHihokenshaNo(主キー名2);

            sut = new JukyushaDaicho(JukyushaDaichoEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(JukyushaDaichoEntity.getShichosonCode()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(JukyushaDaichoEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JukyushaDaichoEntity.getRirekiNo()));
        }

        @Test
        public void get枝番は_entityが持つ枝番を返す() {
            assertThat(sut.get枝番(), is(JukyushaDaichoEntity.getEdaban()));
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(JukyushaDaichoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get申請状況区分は_entityが持つ申請状況区分を返す() {
            assertThat(sut.get申請状況区分(), is(JukyushaDaichoEntity.getShinseiJokyoKubun()));
        }

        @Test
        public void get支所コードは_entityが持つ支所コードを返す() {
            assertThat(sut.get支所コード(), is(JukyushaDaichoEntity.getShishoCode()));
        }

        @Test
        public void get直近フラグは_entityが持つ直近フラグを返す() {
            assertThat(sut.get直近フラグ(), is(JukyushaDaichoEntity.getChokkinFlag()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(JukyushaDaichoEntity.getShikibetsuCode()));
        }

        @Test
        public void get受給申請事由は_entityが持つ受給申請事由を返す() {
            assertThat(sut.get受給申請事由(), is(JukyushaDaichoEntity.getJukyuShinseiJiyu()));
        }

        @Test
        public void get申請理由は_entityが持つ申請理由を返す() {
            assertThat(sut.get申請理由(), is(JukyushaDaichoEntity.getShinseiRiyu()));
        }

        @Test
        public void get届出者_申請者関係コードは_entityが持つ_届出者_申請者関係コードを返す() {
            assertThat(sut.get届出者_申請者関係コード(), is(JukyushaDaichoEntity.getShinseishaKankeiCode()));
        }

        @Test
        public void get届出者_本人との関係は_entityが持つ_届出者_本人との関係を返す() {
            assertThat(sut.get届出者_本人との関係(), is(JukyushaDaichoEntity.getHomninKankei()));
        }

        @Test
        public void get受給申請年月日は_entityが持つ受給申請年月日を返す() {
            assertThat(sut.get受給申請年月日(), is(JukyushaDaichoEntity.getJukyuShinseiYMD()));
        }

        @Test
        public void get２号特定疾病コードは_entityが持つ２号特定疾病コードを返す() {
            assertThat(sut.get２号特定疾病コード(), is(JukyushaDaichoEntity.getNigoTokuteiShippeiCode()));
        }

        @Test
        public void get審査会依頼年月日は_entityが持つ審査会依頼年月日を返す() {
            assertThat(sut.get審査会依頼年月日(), is(JukyushaDaichoEntity.getShinsakaiIraiYMD()));
        }

        @Test
        public void get要介護認定状態区分コードは_entityが持つ要介護認定状態区分コードを返す() {
            assertThat(sut.get要介護認定状態区分コード(), is(JukyushaDaichoEntity.getYokaigoJotaiKubunCode()));
        }

        @Test
        public void get認定有効期間開始年月日は_entityが持つ認定有効期間開始年月日を返す() {
            assertThat(sut.get認定有効期間開始年月日(), is(JukyushaDaichoEntity.getNinteiYukoKikanKaishiYMD()));
        }

        @Test
        public void get認定有効期間終了年月日は_entityが持つ認定有効期間終了年月日を返す() {
            assertThat(sut.get認定有効期間終了年月日(), is(JukyushaDaichoEntity.getNinteiYukoKikanShuryoYMD()));
        }

        @Test
        public void get認定年月日は_entityが持つ認定年月日を返す() {
            assertThat(sut.get認定年月日(), is(JukyushaDaichoEntity.getNinteiYMD()));
        }

        @Test
        public void getみなし要介護区分コードは_entityが持つみなし要介護区分コードを返す() {
            assertThat(sut.getみなし要介護区分コード(), is(JukyushaDaichoEntity.getMinashiCode()));
        }

        @Test
        public void get指定サービス種類01は_entityが持つ指定サービス種類01を返す() {
            assertThat(sut.get指定サービス種類01(), is(JukyushaDaichoEntity.getShiteiServiceShurui01()));
        }

        @Test
        public void get指定サービス種類02は_entityが持つ指定サービス種類02を返す() {
            assertThat(sut.get指定サービス種類02(), is(JukyushaDaichoEntity.getShiteiServiceShurui02()));
        }

        @Test
        public void get指定サービス種類03は_entityが持つ指定サービス種類03を返す() {
            assertThat(sut.get指定サービス種類03(), is(JukyushaDaichoEntity.getShiteiServiceShurui03()));
        }

        @Test
        public void get指定サービス種類04は_entityが持つ指定サービス種類04を返す() {
            assertThat(sut.get指定サービス種類04(), is(JukyushaDaichoEntity.getShiteiServiceShurui04()));
        }

        @Test
        public void get指定サービス種類05は_entityが持つ指定サービス種類05を返す() {
            assertThat(sut.get指定サービス種類05(), is(JukyushaDaichoEntity.getShiteiServiceShurui05()));
        }

        @Test
        public void get指定サービス種類06は_entityが持つ指定サービス種類06を返す() {
            assertThat(sut.get指定サービス種類06(), is(JukyushaDaichoEntity.getShiteiServiceShurui06()));
        }

        @Test
        public void get指定サービス種類07は_entityが持つ指定サービス種類07を返す() {
            assertThat(sut.get指定サービス種類07(), is(JukyushaDaichoEntity.getShiteiServiceShurui07()));
        }

        @Test
        public void get指定サービス種類08は_entityが持つ指定サービス種類08を返す() {
            assertThat(sut.get指定サービス種類08(), is(JukyushaDaichoEntity.getShiteiServiceShurui08()));
        }

        @Test
        public void get指定サービス種類09は_entityが持つ指定サービス種類09を返す() {
            assertThat(sut.get指定サービス種類09(), is(JukyushaDaichoEntity.getShiteiServiceShurui09()));
        }

        @Test
        public void get指定サービス種類10は_entityが持つ指定サービス種類10を返す() {
            assertThat(sut.get指定サービス種類10(), is(JukyushaDaichoEntity.getShiteiServiceShurui10()));
        }

        @Test
        public void get指定サービス種類11は_entityが持つ指定サービス種類11を返す() {
            assertThat(sut.get指定サービス種類11(), is(JukyushaDaichoEntity.getShiteiServiceShurui11()));
        }

        @Test
        public void get指定サービス種類12は_entityが持つ指定サービス種類12を返す() {
            assertThat(sut.get指定サービス種類12(), is(JukyushaDaichoEntity.getShiteiServiceShurui12()));
        }

        @Test
        public void get指定サービス種類13は_entityが持つ指定サービス種類13を返す() {
            assertThat(sut.get指定サービス種類13(), is(JukyushaDaichoEntity.getShiteiServiceShurui13()));
        }

        @Test
        public void get指定サービス種類14は_entityが持つ指定サービス種類14を返す() {
            assertThat(sut.get指定サービス種類14(), is(JukyushaDaichoEntity.getShiteiServiceShurui14()));
        }

        @Test
        public void get指定サービス種類15は_entityが持つ指定サービス種類15を返す() {
            assertThat(sut.get指定サービス種類15(), is(JukyushaDaichoEntity.getShiteiServiceShurui15()));
        }

        @Test
        public void get指定サービス種類16は_entityが持つ指定サービス種類16を返す() {
            assertThat(sut.get指定サービス種類16(), is(JukyushaDaichoEntity.getShiteiServiceShurui16()));
        }

        @Test
        public void get指定サービス種類17は_entityが持つ指定サービス種類17を返す() {
            assertThat(sut.get指定サービス種類17(), is(JukyushaDaichoEntity.getShiteiServiceShurui17()));
        }

        @Test
        public void get指定サービス種類18は_entityが持つ指定サービス種類18を返す() {
            assertThat(sut.get指定サービス種類18(), is(JukyushaDaichoEntity.getShiteiServiceShurui18()));
        }

        @Test
        public void get指定サービス種類19は_entityが持つ指定サービス種類19を返す() {
            assertThat(sut.get指定サービス種類19(), is(JukyushaDaichoEntity.getShiteiServiceShurui19()));
        }

        @Test
        public void get指定サービス種類20は_entityが持つ指定サービス種類20を返す() {
            assertThat(sut.get指定サービス種類20(), is(JukyushaDaichoEntity.getShiteiServiceShurui20()));
        }

        @Test
        public void get指定サービス種類21は_entityが持つ指定サービス種類21を返す() {
            assertThat(sut.get指定サービス種類21(), is(JukyushaDaichoEntity.getShiteiServiceShurui21()));
        }

        @Test
        public void get指定サービス種類22は_entityが持つ指定サービス種類22を返す() {
            assertThat(sut.get指定サービス種類22(), is(JukyushaDaichoEntity.getShiteiServiceShurui22()));
        }

        @Test
        public void get指定サービス種類23は_entityが持つ指定サービス種類23を返す() {
            assertThat(sut.get指定サービス種類23(), is(JukyushaDaichoEntity.getShiteiServiceShurui23()));
        }

        @Test
        public void get指定サービス種類24は_entityが持つ指定サービス種類24を返す() {
            assertThat(sut.get指定サービス種類24(), is(JukyushaDaichoEntity.getShiteiServiceShurui24()));
        }

        @Test
        public void get指定サービス種類25は_entityが持つ指定サービス種類25を返す() {
            assertThat(sut.get指定サービス種類25(), is(JukyushaDaichoEntity.getShiteiServiceShurui25()));
        }

        @Test
        public void get指定サービス種類26は_entityが持つ指定サービス種類26を返す() {
            assertThat(sut.get指定サービス種類26(), is(JukyushaDaichoEntity.getShiteiServiceShurui26()));
        }

        @Test
        public void get指定サービス種類27は_entityが持つ指定サービス種類27を返す() {
            assertThat(sut.get指定サービス種類27(), is(JukyushaDaichoEntity.getShiteiServiceShurui27()));
        }

        @Test
        public void get指定サービス種類28は_entityが持つ指定サービス種類28を返す() {
            assertThat(sut.get指定サービス種類28(), is(JukyushaDaichoEntity.getShiteiServiceShurui28()));
        }

        @Test
        public void get指定サービス種類29は_entityが持つ指定サービス種類29を返す() {
            assertThat(sut.get指定サービス種類29(), is(JukyushaDaichoEntity.getShiteiServiceShurui29()));
        }

        @Test
        public void get指定サービス種類30は_entityが持つ指定サービス種類30を返す() {
            assertThat(sut.get指定サービス種類30(), is(JukyushaDaichoEntity.getShiteiServiceShurui30()));
        }

        @Test
        public void get喪失年月日は_entityが持つ喪失年月日を返す() {
            assertThat(sut.get喪失年月日(), is(JukyushaDaichoEntity.getSoshitsuYMD()));
        }

        @Test
        public void get直近異動年月日は_entityが持つ直近異動年月日を返す() {
            assertThat(sut.get直近異動年月日(), is(JukyushaDaichoEntity.getChokkinIdoYMD()));
        }

        @Test
        public void get直近異動事由コードは_entityが持つ直近異動事由コードを返す() {
            assertThat(sut.get直近異動事由コード(), is(JukyushaDaichoEntity.getChokkinIdoJiyuCode()));
        }

        @Test
        public void get有効無効区分は_entityが持つ有効無効区分を返す() {
            assertThat(sut.get有効無効区分(), is(JukyushaDaichoEntity.getYukoMukoKubun()));
        }

        @Test
        public void getデータ区分は_entityが持つデータ区分を返す() {
            assertThat(sut.getデータ区分(), is(JukyushaDaichoEntity.getDataKubun()));
        }

        @Test
        public void get同一連番は_entityが持つ同一連番を返す() {
            assertThat(sut.get同一連番(), is(JukyushaDaichoEntity.getRemban()));
        }

        @Test
        public void get異動理由は_entityが持つ異動理由を返す() {
            assertThat(sut.get異動理由(), is(JukyushaDaichoEntity.getIdoRiyu()));
        }

        @Test
        public void get申請書区分は_entityが持つ申請書区分を返す() {
            assertThat(sut.get申請書区分(), is(JukyushaDaichoEntity.getShinseishoKubun()));
        }

        @Test
        public void get削除事由コードは_entityが持つ削除事由コードを返す() {
            assertThat(sut.get削除事由コード(), is(JukyushaDaichoEntity.getSakujoJiyuCode()));
        }

        @Test
        public void get要支援者認定申請区分は_entityが持つ要支援者認定申請区分を返す() {
            assertThat(sut.get要支援者認定申請区分(), is(JukyushaDaichoEntity.getYoshienshaNinteiShinseiFlag()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(JukyushaDaichoEntity.getShikyuGendoTanisu()));
        }

        @Test
        public void get支給限度有効開始年月日は_entityが持つ支給限度有効開始年月日を返す() {
            assertThat(sut.get支給限度有効開始年月日(), is(JukyushaDaichoEntity.getShikyuGendoKaishiYMD()));
        }

        @Test
        public void get支給限度有効終了年月日は_entityが持つ支給限度有効終了年月日を返す() {
            assertThat(sut.get支給限度有効終了年月日(), is(JukyushaDaichoEntity.getShikyuGendoShuryoYMD()));
        }

        @Test
        public void get短期入所支給限度日数は_entityが持つ短期入所支給限度日数を返す() {
            assertThat(sut.get短期入所支給限度日数(), is(JukyushaDaichoEntity.getTankiSikyuGendoNissu()));
        }

        @Test
        public void get短期入所支給限度開始年月日は_entityが持つ短期入所支給限度開始年月日を返す() {
            assertThat(sut.get短期入所支給限度開始年月日(), is(JukyushaDaichoEntity.getTankiShikyuGendoKaishiYMD()));
        }

        @Test
        public void get短期入所支給限度終了年月日は_entityが持つ短期入所支給限度終了年月日を返す() {
            assertThat(sut.get短期入所支給限度終了年月日(), is(JukyushaDaichoEntity.getTankiShikyuGendoShuryoYMD()));
        }

        @Test
        public void get当初認定有効開始年月日は_entityが持つ当初認定有効開始年月日を返す() {
            assertThat(sut.get当初認定有効開始年月日(), is(JukyushaDaichoEntity.getToshoNinteiYukoKaishiYMD()));
        }

        @Test
        public void get当初認定有効終了年月日は_entityが持つ当初認定有効終了年月日を返す() {
            assertThat(sut.get当初認定有効終了年月日(), is(JukyushaDaichoEntity.getToshoNinteiYukoShuryoYMD()));
        }

        @Test
        public void get受給資格証明書発行年月日１は_entityが持つ受給資格証明書発行年月日１を返す() {
            assertThat(sut.get受給資格証明書発行年月日１(), is(JukyushaDaichoEntity.getJukyuShikakuShomeishoHakkoYMD1()));
        }

        @Test
        public void get受給資格証明書発行年月日２は_entityが持つ受給資格証明書発行年月日２を返す() {
            assertThat(sut.get受給資格証明書発行年月日２(), is(JukyushaDaichoEntity.getJukyuShikakuShomeishoHakkoYMD2()));
        }

        @Test
        public void get診断命令書発行年月日は_entityが持つ診断命令書発行年月日を返す() {
            assertThat(sut.get診断命令書発行年月日(), is(JukyushaDaichoEntity.getShindanMeireishoHakkoYMD()));
        }

        @Test
        public void get２号申請受理通知書発行年月日は_entityが持つ２号申請受理通知書発行年月日を返す() {
            assertThat(sut.get２号申請受理通知書発行年月日(), is(JukyushaDaichoEntity.getNigoShinseiJuriTsuchishoHakkoYMD()));
        }

        @Test
        public void get認定結果通知書発行年月日は_entityが持つ認定結果通知書発行年月日を返す() {
            assertThat(sut.get認定結果通知書発行年月日(), is(JukyushaDaichoEntity.getNinteiKekkaTsuchishoHakkoYMD()));
        }

        @Test
        public void get区分変更通知書発行年月日は_entityが持つ区分変更通知書発行年月日を返す() {
            assertThat(sut.get区分変更通知書発行年月日(), is(JukyushaDaichoEntity.getKubunHenkoTsuchishoHakkoYMD()));
        }

        @Test
        public void getサービス変更通知書発行年月日は_entityが持つサービス変更通知書発行年月日を返す() {
            assertThat(sut.getサービス変更通知書発行年月日(), is(JukyushaDaichoEntity.getServiceHenkoTsuchishoHakkoYMD()));
        }

        @Test
        public void get認定却下通知書発行年月日は_entityが持つ認定却下通知書発行年月日を返す() {
            assertThat(sut.get認定却下通知書発行年月日(), is(JukyushaDaichoEntity.getNinteiKyakkaTsuchishoHakkoYMD()));
        }

        @Test
        public void get認定取消通知書発行年月日は_entityが持つ認定取消通知書発行年月日を返す() {
            assertThat(sut.get認定取消通知書発行年月日(), is(JukyushaDaichoEntity.getNinteiTorikeshiTsuchishoHakkoYMD()));
        }

        @Test
        public void get資格取得前申請フラグは_entityが持つ資格取得前申請フラグを返す() {
            assertThat(sut.get資格取得前申請フラグ(), is(JukyushaDaichoEntity.getShikakuShutokuMaeShinseiFlag()));
        }

        @Test
        public void get旧措置者フラグは_entityが持つ旧措置者フラグを返す() {
            assertThat(sut.get旧措置者フラグ(), is(JukyushaDaichoEntity.getKyuSochishaFlag()));
        }

        @Test
        public void get論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.get論理削除フラグ(), is(JukyushaDaichoEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbdTestBase {

        private static JukyushaDaicho sut;

        @Before
        public void setUp() {
            JukyushaDaichoEntity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            JukyushaDaichoEntity.setShichosonCode(主キー名1);
            JukyushaDaichoEntity.setHihokenshaNo(主キー名2);

            sut = new JukyushaDaicho(JukyushaDaichoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JukyushaDaichoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbdTestBase {

        private static JukyushaDaicho sut;

        @Before
        public void setUp() {
            JukyushaDaichoEntity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            JukyushaDaichoEntity.setShichosonCode(主キー名1);
            JukyushaDaichoEntity.setHihokenshaNo(主キー名2);

            sut = new JukyushaDaicho(JukyushaDaichoEntity);
        }

//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
    }

    public static class deletedテスト extends DbdTestBase {

        private static JukyushaDaicho sut;
        private static JukyushaDaicho result;

        @Before
        public void setUp() {
            JukyushaDaichoEntity = DbT4001JukyushaDaichoEntityGenerator.createDbT4001JukyushaDaichoEntity();
            JukyushaDaichoEntity.setShichosonCode(主キー名1);
            JukyushaDaichoEntity.setHihokenshaNo(主キー名2);

        }

        @Test
        public void JukyushaDaichoが保持するDbT4001JukyushaDaichoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJukyushaDaichoが保持するDbT4001JukyushaDaichoEntityのEntityDataStateがDeletedに指定されたJukyushaDaichoが返る() {
            sut = TestSupport.setStateJukyushaDaicho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JukyushaDaichoが保持するDbT4001JukyushaDaichoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJukyushaDaichoが保持するDbT4001JukyushaDaichoEntityのEntityDataStateがDeletedに指定されたJukyushaDaichoが返る() {
            sut = TestSupport.setStateJukyushaDaicho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JukyushaDaichoが保持するDbT4001JukyushaDaichoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJukyushaDaichoが保持するDbT4001JukyushaDaichoEntityのEntityDataStateがDeletedに指定されたJukyushaDaichoが返る() {
            sut = TestSupport.setStateJukyushaDaicho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JukyushaDaichoが保持するDbT4001JukyushaDaichoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJukyushaDaicho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JukyushaDaicho setStateJukyushaDaicho(EntityDataState parentState) {
            JukyushaDaichoEntity.setState(parentState);
            return new JukyushaDaicho(JukyushaDaichoEntity);
        }
    }
}
