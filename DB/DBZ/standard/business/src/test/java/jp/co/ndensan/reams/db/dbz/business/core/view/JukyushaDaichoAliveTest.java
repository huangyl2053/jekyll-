/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV4001JukyushaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaDaichoAlive}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class JukyushaDaichoAliveTest extends DbzTestBase {

    private static DbV4001JukyushaDaichoEntity JukyushaDaichoAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static HihokenshaNo 被保険者番号;
    private static RString 履歴番号;
    private static RString 枝番;
    private static Code 受給申請事由;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_市町村コード;
        被保険者番号 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_履歴番号;
        枝番 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_枝番;
        受給申請事由 = DbV4001JukyushaDaichoEntityGenerator.DEFAULT_受給申請事由;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static JukyushaDaichoAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JukyushaDaichoAliveEntity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaDaichoAlive(null, 被保険者番号, 履歴番号, 枝番, 受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaDaichoAlive(市町村コード, null, 履歴番号, 枝番, 受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名3がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaDaichoAlive(市町村コード, 被保険者番号, null, 枝番, 受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名4がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaDaichoAlive(市町村コード, 被保険者番号, 履歴番号, null, 受給申請事由);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名5がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JukyushaDaichoAlive(市町村コード, 被保険者番号, 履歴番号, 枝番, null);
        }

        @Test
        public void 指定したキーが保持するDbV4001JukyushaDaichoEntityにセットされている() {
            sut = new JukyushaDaichoAlive(市町村コード, 被保険者番号, 履歴番号, 枝番, 受給申請事由);
            assertThat(sut.get市町村コード(), is(市町村コード));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void 指定したキーが保持するJukyushaDaichoAliveIdentifierにセットされている() {
            sut = new JukyushaDaichoAlive(市町村コード, 被保険者番号, 履歴番号, 枝番, 受給申請事由);
            // TODO
//            assertThat(sut.identifier().getXXX(), is(市町村コード));
//            assertThat(sut.identifier().getXXX(), is(被保険者番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static JukyushaDaichoAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JukyushaDaichoAliveEntity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JukyushaDaichoAlive(null);
        }

        @Test
        public void 指定したDbV4001JukyushaDaichoEntityのキー情報を識別子が持つ() {

            sut = new JukyushaDaichoAlive(JukyushaDaichoAliveEntity);

            //TODO
//            assertThat(sut.identifier().getXXX(), is(市町村コード));
//            assertThat(sut.identifier().getXXX(), is(被保険者番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static JukyushaDaichoAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JukyushaDaichoAliveEntity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();

            sut = new JukyushaDaichoAlive(JukyushaDaichoAliveEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(JukyushaDaichoAliveEntity.getShichosonCode()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(JukyushaDaichoAliveEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JukyushaDaichoAliveEntity.getRirekiNo()));
        }

        @Test
        public void get枝番は_entityが持つ枝番を返す() {
            assertThat(sut.get枝番(), is(JukyushaDaichoAliveEntity.getEdaban()));
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(JukyushaDaichoAliveEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get申請状況区分は_entityが持つ申請状況区分を返す() {
            assertThat(sut.get申請状況区分(), is(JukyushaDaichoAliveEntity.getShinseiJokyoKubun()));
        }

        @Test
        public void get支所コードは_entityが持つ支所コードを返す() {
            assertThat(sut.get支所コード(), is(JukyushaDaichoAliveEntity.getShishoCode()));
        }

        @Test
        public void is直近フラグは_entityが持つ直近フラグを返す() {
            assertThat(sut.is直近フラグ(), is(JukyushaDaichoAliveEntity.getChokkinFlag()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(JukyushaDaichoAliveEntity.getShikibetsuCode()));
        }

        @Test
        public void get受給申請事由は_entityが持つ受給申請事由を返す() {
            assertThat(sut.get受給申請事由(), is(JukyushaDaichoAliveEntity.getJukyuShinseiJiyu()));
        }

        @Test
        public void get申請理由は_entityが持つ申請理由を返す() {
            assertThat(sut.get申請理由(), is(JukyushaDaichoAliveEntity.getShinseiRiyu()));
        }

        @Test
        public void get届出者申請者関係コードは_entityが持つ届出者申請者関係コードを返す() {
            assertThat(sut.get届出者申請者関係コード(), is(JukyushaDaichoAliveEntity.getShinseishaKankeiCode()));
        }

        @Test
        public void get届出者本人との関係は_entityが持つ届出者本人との関係を返す() {
            assertThat(sut.get届出者本人との関係(), is(JukyushaDaichoAliveEntity.getHomninKankei()));
        }

        @Test
        public void get受給申請年月日は_entityが持つ受給申請年月日を返す() {
            assertThat(sut.get受給申請年月日(), is(JukyushaDaichoAliveEntity.getJukyuShinseiYMD()));
        }

        @Test
        public void get２号特定疾病コードは_entityが持つ２号特定疾病コードを返す() {
            assertThat(sut.get２号特定疾病コード(), is(JukyushaDaichoAliveEntity.getNigoTokuteiShippeiCode()));
        }

        @Test
        public void get審査会依頼年月日は_entityが持つ審査会依頼年月日を返す() {
            assertThat(sut.get審査会依頼年月日(), is(JukyushaDaichoAliveEntity.getShinsakaiIraiYMD()));
        }

        @Test
        public void get要介護認定状態区分コードは_entityが持つ要介護認定状態区分コードを返す() {
            assertThat(sut.get要介護認定状態区分コード(), is(JukyushaDaichoAliveEntity.getYokaigoJotaiKubunCode()));
        }

        @Test
        public void get認定有効期間開始年月日は_entityが持つ認定有効期間開始年月日を返す() {
            assertThat(sut.get認定有効期間開始年月日(), is(JukyushaDaichoAliveEntity.getNinteiYukoKikanKaishiYMD()));
        }

        @Test
        public void get認定有効期間終了年月日は_entityが持つ認定有効期間終了年月日を返す() {
            assertThat(sut.get認定有効期間終了年月日(), is(JukyushaDaichoAliveEntity.getNinteiYukoKikanShuryoYMD()));
        }

        @Test
        public void get認定年月日は_entityが持つ認定年月日を返す() {
            assertThat(sut.get認定年月日(), is(JukyushaDaichoAliveEntity.getNinteiYMD()));
        }

        @Test
        public void get指定サービス種類01は_entityが持つ指定サービス種類01を返す() {
            assertThat(sut.get指定サービス種類01(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui01()));
        }

        @Test
        public void get指定サービス種類02は_entityが持つ指定サービス種類02を返す() {
            assertThat(sut.get指定サービス種類02(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui02()));
        }

        @Test
        public void get指定サービス種類03は_entityが持つ指定サービス種類03を返す() {
            assertThat(sut.get指定サービス種類03(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui03()));
        }

        @Test
        public void get指定サービス種類04は_entityが持つ指定サービス種類04を返す() {
            assertThat(sut.get指定サービス種類04(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui04()));
        }

        @Test
        public void get指定サービス種類05は_entityが持つ指定サービス種類05を返す() {
            assertThat(sut.get指定サービス種類05(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui05()));
        }

        @Test
        public void get指定サービス種類06は_entityが持つ指定サービス種類06を返す() {
            assertThat(sut.get指定サービス種類06(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui06()));
        }

        @Test
        public void get指定サービス種類07は_entityが持つ指定サービス種類07を返す() {
            assertThat(sut.get指定サービス種類07(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui07()));
        }

        @Test
        public void get指定サービス種類08は_entityが持つ指定サービス種類08を返す() {
            assertThat(sut.get指定サービス種類08(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui08()));
        }

        @Test
        public void get指定サービス種類09は_entityが持つ指定サービス種類09を返す() {
            assertThat(sut.get指定サービス種類09(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui09()));
        }

        @Test
        public void get指定サービス種類10は_entityが持つ指定サービス種類10を返す() {
            assertThat(sut.get指定サービス種類10(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui10()));
        }

        @Test
        public void get指定サービス種類11は_entityが持つ指定サービス種類11を返す() {
            assertThat(sut.get指定サービス種類11(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui11()));
        }

        @Test
        public void get指定サービス種類12は_entityが持つ指定サービス種類12を返す() {
            assertThat(sut.get指定サービス種類12(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui12()));
        }

        @Test
        public void get指定サービス種類13は_entityが持つ指定サービス種類13を返す() {
            assertThat(sut.get指定サービス種類13(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui13()));
        }

        @Test
        public void get指定サービス種類14は_entityが持つ指定サービス種類14を返す() {
            assertThat(sut.get指定サービス種類14(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui14()));
        }

        @Test
        public void get指定サービス種類15は_entityが持つ指定サービス種類15を返す() {
            assertThat(sut.get指定サービス種類15(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui15()));
        }

        @Test
        public void get指定サービス種類16は_entityが持つ指定サービス種類16を返す() {
            assertThat(sut.get指定サービス種類16(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui16()));
        }

        @Test
        public void get指定サービス種類17は_entityが持つ指定サービス種類17を返す() {
            assertThat(sut.get指定サービス種類17(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui17()));
        }

        @Test
        public void get指定サービス種類18は_entityが持つ指定サービス種類18を返す() {
            assertThat(sut.get指定サービス種類18(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui18()));
        }

        @Test
        public void get指定サービス種類19は_entityが持つ指定サービス種類19を返す() {
            assertThat(sut.get指定サービス種類19(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui19()));
        }

        @Test
        public void get指定サービス種類20は_entityが持つ指定サービス種類20を返す() {
            assertThat(sut.get指定サービス種類20(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui20()));
        }

        @Test
        public void get指定サービス種類21は_entityが持つ指定サービス種類21を返す() {
            assertThat(sut.get指定サービス種類21(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui21()));
        }

        @Test
        public void get指定サービス種類22は_entityが持つ指定サービス種類22を返す() {
            assertThat(sut.get指定サービス種類22(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui22()));
        }

        @Test
        public void get指定サービス種類23は_entityが持つ指定サービス種類23を返す() {
            assertThat(sut.get指定サービス種類23(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui23()));
        }

        @Test
        public void get指定サービス種類24は_entityが持つ指定サービス種類24を返す() {
            assertThat(sut.get指定サービス種類24(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui24()));
        }

        @Test
        public void get指定サービス種類25は_entityが持つ指定サービス種類25を返す() {
            assertThat(sut.get指定サービス種類25(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui25()));
        }

        @Test
        public void get指定サービス種類26は_entityが持つ指定サービス種類26を返す() {
            assertThat(sut.get指定サービス種類26(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui26()));
        }

        @Test
        public void get指定サービス種類27は_entityが持つ指定サービス種類27を返す() {
            assertThat(sut.get指定サービス種類27(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui27()));
        }

        @Test
        public void get指定サービス種類28は_entityが持つ指定サービス種類28を返す() {
            assertThat(sut.get指定サービス種類28(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui28()));
        }

        @Test
        public void get指定サービス種類29は_entityが持つ指定サービス種類29を返す() {
            assertThat(sut.get指定サービス種類29(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui29()));
        }

        @Test
        public void get指定サービス種類30は_entityが持つ指定サービス種類30を返す() {
            assertThat(sut.get指定サービス種類30(), is(JukyushaDaichoAliveEntity.getShiteiServiceShurui30()));
        }

        @Test
        public void get喪失年月日は_entityが持つ喪失年月日を返す() {
            assertThat(sut.get喪失年月日(), is(JukyushaDaichoAliveEntity.getSoshitsuYMD()));
        }

        @Test
        public void get直近異動年月日は_entityが持つ直近異動年月日を返す() {
            assertThat(sut.get直近異動年月日(), is(JukyushaDaichoAliveEntity.getChokkinIdoYMD()));
        }

        @Test
        public void get直近異動事由コードは_entityが持つ直近異動事由コードを返す() {
            assertThat(sut.get直近異動事由コード(), is(JukyushaDaichoAliveEntity.getChokkinIdoJiyuCode()));
        }

        @Test
        public void get有効無効区分は_entityが持つ有効無効区分を返す() {
            assertThat(sut.get有効無効区分(), is(JukyushaDaichoAliveEntity.getYukoMukoKubun()));
        }

        @Test
        public void getデータ区分は_entityが持つデータ区分を返す() {
            assertThat(sut.getデータ区分(), is(JukyushaDaichoAliveEntity.getDataKubun()));
        }

        @Test
        public void get同一連番は_entityが持つ同一連番を返す() {
            assertThat(sut.get同一連番(), is(JukyushaDaichoAliveEntity.getRemban()));
        }

        @Test
        public void get異動理由は_entityが持つ異動理由を返す() {
            assertThat(sut.get異動理由(), is(JukyushaDaichoAliveEntity.getIdoRiyu()));
        }

        @Test
        public void get申請書区分は_entityが持つ申請書区分を返す() {
            assertThat(sut.get申請書区分(), is(JukyushaDaichoAliveEntity.getShinseishoKubun()));
        }

        @Test
        public void get削除事由コードは_entityが持つ削除事由コードを返す() {
            assertThat(sut.get削除事由コード(), is(JukyushaDaichoAliveEntity.getSakujoJiyuCode()));
        }

        @Test
        public void is要支援者認定申請区分は_entityが持つ要支援者認定申請区分を返す() {
            assertThat(sut.is要支援者認定申請区分(), is(JukyushaDaichoAliveEntity.getYoshienshaNinteiShinseiFlag()));
        }

        @Test
        public void get支給限度単位数は_entityが持つ支給限度単位数を返す() {
            assertThat(sut.get支給限度単位数(), is(JukyushaDaichoAliveEntity.getShikyuGendoTanisu()));
        }

        @Test
        public void get支給限度有効開始年月日は_entityが持つ支給限度有効開始年月日を返す() {
            assertThat(sut.get支給限度有効開始年月日(), is(JukyushaDaichoAliveEntity.getShikyuGendoKaishiYMD()));
        }

        @Test
        public void get支給限度有効終了年月日は_entityが持つ支給限度有効終了年月日を返す() {
            assertThat(sut.get支給限度有効終了年月日(), is(JukyushaDaichoAliveEntity.getShikyuGendoShuryoYMD()));
        }

        @Test
        public void get短期入所支給限度日数は_entityが持つ短期入所支給限度日数を返す() {
            assertThat(sut.get短期入所支給限度日数(), is(JukyushaDaichoAliveEntity.getTankiSikyuGendoNissu()));
        }

        @Test
        public void get短期入所支給限度開始年月日は_entityが持つ短期入所支給限度開始年月日を返す() {
            assertThat(sut.get短期入所支給限度開始年月日(), is(JukyushaDaichoAliveEntity.getTankiShikyuGendoKaishiYMD()));
        }

        @Test
        public void get短期入所支給限度終了年月日は_entityが持つ短期入所支給限度終了年月日を返す() {
            assertThat(sut.get短期入所支給限度終了年月日(), is(JukyushaDaichoAliveEntity.getTankiShikyuGendoShuryoYMD()));
        }

        @Test
        public void get当初認定有効開始年月日は_entityが持つ当初認定有効開始年月日を返す() {
            assertThat(sut.get当初認定有効開始年月日(), is(JukyushaDaichoAliveEntity.getToshoNinteiYukoKaishiYMD()));
        }

        @Test
        public void get当初認定有効終了年月日は_entityが持つ当初認定有効終了年月日を返す() {
            assertThat(sut.get当初認定有効終了年月日(), is(JukyushaDaichoAliveEntity.getToshoNinteiYukoShuryoYMD()));
        }

        @Test
        public void get受給資格証明書発行年月日１は_entityが持つ受給資格証明書発行年月日１を返す() {
            assertThat(sut.get受給資格証明書発行年月日１(), is(JukyushaDaichoAliveEntity.getJukyuShikakuShomeishoHakkoYMD1()));
        }

        @Test
        public void get受給資格証明書発行年月日２は_entityが持つ受給資格証明書発行年月日２を返す() {
            assertThat(sut.get受給資格証明書発行年月日２(), is(JukyushaDaichoAliveEntity.getJukyuShikakuShomeishoHakkoYMD2()));
        }

        @Test
        public void get診断命令書発行年月日は_entityが持つ診断命令書発行年月日を返す() {
            assertThat(sut.get診断命令書発行年月日(), is(JukyushaDaichoAliveEntity.getShindanMeireishoHakkoYMD()));
        }

        @Test
        public void get２号申請受理通知書発行年月日は_entityが持つ２号申請受理通知書発行年月日を返す() {
            assertThat(sut.get２号申請受理通知書発行年月日(), is(JukyushaDaichoAliveEntity.getNigoShinseiJuriTsuchishoHakkoYMD()));
        }

        @Test
        public void get認定結果通知書発行年月日は_entityが持つ認定結果通知書発行年月日を返す() {
            assertThat(sut.get認定結果通知書発行年月日(), is(JukyushaDaichoAliveEntity.getNinteiKekkaTsuchishoHakkoYMD()));
        }

        @Test
        public void get区分変更通知書発行年月日は_entityが持つ区分変更通知書発行年月日を返す() {
            assertThat(sut.get区分変更通知書発行年月日(), is(JukyushaDaichoAliveEntity.getKubunHenkoTsuchishoHakkoYMD()));
        }

        @Test
        public void getサービス変更通知書発行年月日は_entityが持つサービス変更通知書発行年月日を返す() {
            assertThat(sut.getサービス変更通知書発行年月日(), is(JukyushaDaichoAliveEntity.getServiceHenkoTsuchishoHakkoYMD()));
        }

        @Test
        public void get認定却下通知書発行年月日は_entityが持つ認定却下通知書発行年月日を返す() {
            assertThat(sut.get認定却下通知書発行年月日(), is(JukyushaDaichoAliveEntity.getNinteiKyakkaTsuchishoHakkoYMD()));
        }

        @Test
        public void get認定取消通知書発行年月日は_entityが持つ認定取消通知書発行年月日を返す() {
            assertThat(sut.get認定取消通知書発行年月日(), is(JukyushaDaichoAliveEntity.getNinteiTorikeshiTsuchishoHakkoYMD()));
        }

        @Test
        public void is資格取得前申請フラグは_entityが持つ資格取得前申請フラグを返す() {
            assertThat(sut.is資格取得前申請フラグ(), is(JukyushaDaichoAliveEntity.getShikakuShutokuMaeShinseiFlag()));
        }

        @Test
        public void is旧措置者フラグは_entityが持つ旧措置者フラグを返す() {
            assertThat(sut.is旧措置者フラグ(), is(JukyushaDaichoAliveEntity.getKyuSochishaFlag()));
        }

        @Test
        public void is論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.is論理削除フラグ(), is(JukyushaDaichoAliveEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static JukyushaDaichoAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JukyushaDaichoAliveEntity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();

            sut = new JukyushaDaichoAlive(JukyushaDaichoAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JukyushaDaichoAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static JukyushaDaichoAlive sut;

        @BeforeClass
        public static void setUpClass() {
            JukyushaDaichoAliveEntity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();

            sut = new JukyushaDaichoAlive(JukyushaDaichoAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static JukyushaDaichoAlive sut;
        private static JukyushaDaichoAlive result;

        @BeforeClass
        public static void setUpClass() {
            JukyushaDaichoAliveEntity = DbV4001JukyushaDaichoEntityGenerator.createDbV4001JukyushaDaichoEntity();

        }

        @Test
        public void JukyushaDaichoAliveが保持するDbV4001JukyushaDaichoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJukyushaDaichoAliveが保持するDbV4001JukyushaDaichoEntityのEntityDataStateがDeletedに指定されたJukyushaDaichoAliveが返る() {
            sut = TestSupport.setStateJukyushaDaichoAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JukyushaDaichoAliveが保持するDbV4001JukyushaDaichoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJukyushaDaichoAliveが保持するDbV4001JukyushaDaichoEntityのEntityDataStateがDeletedに指定されたJukyushaDaichoAliveが返る() {
            sut = TestSupport.setStateJukyushaDaichoAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JukyushaDaichoAliveが保持するDbV4001JukyushaDaichoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJukyushaDaichoAliveが保持するDbV4001JukyushaDaichoEntityのEntityDataStateがDeletedに指定されたJukyushaDaichoAliveが返る() {
            sut = TestSupport.setStateJukyushaDaichoAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JukyushaDaichoAliveが保持するDbV4001JukyushaDaichoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJukyushaDaichoAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JukyushaDaichoAlive setStateJukyushaDaichoAlive(EntityDataState parentState) {
            JukyushaDaichoAliveEntity.setState(parentState);
            return new JukyushaDaichoAlive(JukyushaDaichoAliveEntity);
        }
    }
}
