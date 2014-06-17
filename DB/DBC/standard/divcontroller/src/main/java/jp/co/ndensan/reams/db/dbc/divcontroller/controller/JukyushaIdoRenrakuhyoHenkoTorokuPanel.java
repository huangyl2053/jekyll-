/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoGemmenGengakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoHyojunFutanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKihonJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKokiKoreiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKokuhoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyotakuServicePlanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyufuSeigenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoNijiyoboJigyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoRiyoshaFutanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoRojinHokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoYokaigoninteiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者異動連絡票変更登録 受給者異動連絡票のコントローラークラスです。
 *
 * @author n8156 宮本 康
 */
public class JukyushaIdoRenrakuhyoHenkoTorokuPanel {

    private static final RString YML_NAME = new RString("dbc0220012/JukyushaIdoRenrakuhyoHenkoToroku.yml");
    private static final int YML_IDX_KIHON = 0;
    private static final int YML_IDX_YOKAIGO_NINTEI = 1;
    private static final int YML_IDX_SHIKYU_GENDO_KIJUN = 2;
    private static final int YML_IDX_SERVICE_KEIKAKU = 3;
    private static final int YML_IDX_GENMEN_GENGAKU = 4;
    private static final int YML_IDX_KOKI_KOREI_KOKUHO = 5;
    private static final int YML_IDX_KYUFU_SEIGEN = 6;
    private static final int YML_IDX_NIJI_YOBO_JIGYO = 7;
    private static final int YML_IDX_ROJIN_HOKEN = 8;

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv> onLoad(JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv panel) {
        ResponseData<JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv> response = new ResponseData<>();

        setJukyushaIdoRenrakuhyoKihonJohoData(panel);

        response.data = panel;
        return response;
    }

    private void setJukyushaIdoRenrakuhyoKihonJohoData(JukyushaIdoRenrakuhyoShinkiTorokuPanelDiv panel) {

        List<HashMap> ymlData = getYmlData();

        HashMap map = ymlData.get(YML_IDX_KIHON);
        JukyushaIdoRenrakuhyoKihonJohoDiv kihonJohoDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho();
        kihonJohoDiv.getTxtRenrakuhyoIdoDate().setValue(new FlexibleDate(map.get("異動日").toString()));
        kihonJohoDiv.getRadRenrakuhyoIdoKubun().setSelectedItem(new RString(map.get("異動区分").toString()));
        kihonJohoDiv.getDdlIdoJiyu().setSelectedItem(new RString(map.get("異動事由").toString()));
        kihonJohoDiv.getTxtRenrakuhyoHihoNo().setValue(new RString(map.get("被保番号").toString()));
        kihonJohoDiv.getTxtRenrakuhyoHihoName().setValue(new RString(map.get("カナ氏名").toString()));
        kihonJohoDiv.getTxtHihoBirthday().setValue(new FlexibleDate(map.get("生年月日").toString()));
        kihonJohoDiv.getRadHihoSex().setSelectedItem(new RString(map.get("性別").toString()));
        kihonJohoDiv.getTxtShikakuShutokuDate().setValue(new FlexibleDate(map.get("資格取得日").toString()));
        kihonJohoDiv.getTxtShikakuSoshitsuDate().setValue(new FlexibleDate(map.get("資格喪失日").toString()));
        kihonJohoDiv.getTxtShokisaiHokenshaNo().setValue(new RString(map.get("証記載保険者番号").toString()));
        kihonJohoDiv.getTxtKoikiHokenshaNo().setValue(new RString(map.get("広域保険者番号").toString()));
        kihonJohoDiv.getTxtRenrakuhyoSendYM().setValue(new FlexibleDate(map.get("送付年月").toString()));

        map = ymlData.get(YML_IDX_YOKAIGO_NINTEI);
        JukyushaIdoRenrakuhyoYokaigoninteiDiv ninteiDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei();
        ninteiDiv.getTxtShinseiDate().setValue(new FlexibleDate(map.get("申請日").toString()));
        ninteiDiv.getDdlYokaigoJotaiKubun().setSelectedItem(new RString(map.get("状態区分").toString()));
        ninteiDiv.getTxtNinteiDateRange().setFromValue(new RDate(map.get("認定開始日").toString()));
        ninteiDiv.getTxtNinteiDateRange().setToValue(new RDate(map.get("認定終了日").toString()));
        ninteiDiv.getRadShinseiType().setSelectedItem(new RString(map.get("申請種別").toString()));
        ninteiDiv.getRadHenkoShinseichuKubun().setSelectedItem(new RString(map.get("変更申請中区分").toString()));
        ninteiDiv.getRadMinashiYokaigoKubun().setSelectedItem(new RString(map.get("みなし区分").toString()));

        map = ymlData.get(YML_IDX_SHIKYU_GENDO_KIJUN);
        JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv jungakuDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku();
        jungakuDiv.getTxtKyuHomonTsushoShikyuGendoKijungaku().setValue(new Decimal(map.get("旧訪問通所基準額").toString()));
        jungakuDiv.getTxtKyuHomonTsushoKanriTekiyoDateRange().setFromValue(new RDate(map.get("旧訪問通所適用開始日").toString()));
        jungakuDiv.getTxtKyuHomonTsushoKanriTekiyoDateRange().setToValue(new RDate(map.get("旧訪問通所適用終了日").toString()));
        jungakuDiv.getTxtKyuTankiNyushoShikyuGendoKijungaku().setValue(new Decimal(map.get("旧短期入所基準額").toString()));
        jungakuDiv.getTxtKyuTankiNyushoKanriTekiyoDateRange().setFromValue(new RDate(map.get("旧短期入所適用開始日").toString()));
        jungakuDiv.getTxtKyuTankiNyushoKanriTekiyoDateRange().setToValue(new RDate(map.get("旧短期入所適用終了日").toString()));

        map = ymlData.get(YML_IDX_SERVICE_KEIKAKU);
        JukyushaIdoRenrakuhyoKyotakuServicePlanDiv planDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan();
        planDiv.getRadPlanSakuseiKubun().setSelectedItem(new RString(map.get("計画作成区分").toString()));
        planDiv.getTxtShienJigyoshaNo().setValue(new RString(map.get("支援事業者コード").toString()));
        planDiv.getTxtShienJigyoshaName().setValue(new RString(map.get("支援事業者名").toString()));
        planDiv.getTxtKyotakuServicePlanTekiyoDateRange().setFromValue(new RDate(map.get("適用開始日").toString()));
        planDiv.getTxtKyotakuServicePlanTekiyoDateRange().setToValue(new RDate(map.get("適用終了日").toString()));
        planDiv.getRadShokiboKyotakuServiceRiyoUmu().setSelectedItem(new RString(map.get("小規模居宅サービス利用").toString()));

        map = ymlData.get(YML_IDX_GENMEN_GENGAKU);
        JukyushaIdoRenrakuhyoGemmenGengakuDiv gengakuDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoGemmenGengaku();
        gengakuDiv.getRadGemmenShinseichuKubun().setSelectedItem(new RString(map.get("減免申請中区分").toString()));
        JukyushaIdoRenrakuhyoRiyoshaFutanDiv riyoshaFutanDiv
                = gengakuDiv.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoRiyoshaFutan();
        riyoshaFutanDiv.getRadRiyoshaFutanKubun().setSelectedItem(new RString(map.get("利用者負担区分").toString()));
        riyoshaFutanDiv.getTxtRiyoshaFutanKyufuritsu().setValue(new Decimal(map.get("利用者負担給付率").toString()));
        riyoshaFutanDiv.getTxtRiyoshaFutanTekiyoDateRange().setFromValue(new RDate(map.get("利用者負担適用開始日").toString()));
        riyoshaFutanDiv.getTxtRiyoshaFutanTekiyoDateRange().setToValue(new RDate(map.get("利用者負担適用終了日").toString()));
        JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv shafukuKeigenDiv
                = gengakuDiv.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen();
        shafukuKeigenDiv.getTxtKeigenritsu().setValue(new Decimal(map.get("社福法人軽軽減率").toString()));
        shafukuKeigenDiv.getTxtKeigenritsuTekiyoDateRange().setFromValue(new RDate(map.get("社福法人軽減適用開始日").toString()));
        shafukuKeigenDiv.getTxtKeigenritsuTekiyoDateRange().setToValue(new RDate(map.get("社福法人軽減適用終了日").toString()));
        JukyushaIdoRenrakuhyoHyojunFutanDiv hyojunFutanDiv
                = gengakuDiv.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan();
        hyojunFutanDiv.getRadHyojunFutanKubun().setSelectedItem(new RString(map.get("標準負担区分").toString()));
        hyojunFutanDiv.getTxtHyojunFutangaku().setValue(new Decimal(map.get("標準負担額").toString()));
        hyojunFutanDiv.getTxtHyojunFutanTekiyoDateRange().setFromValue(new RDate(map.get("標準負担適用開始日").toString()));
        hyojunFutanDiv.getTxtHyojunFutanTekiyoDateRange().setToValue(new RDate(map.get("標準負担適用終了日").toString()));
        JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv serviceHiDiv = gengakuDiv.getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi();
        serviceHiDiv.getRadNinteiShinseichuKubun().setSelectedItem(new RString(map.get("認定申請中区分").toString()));
        serviceHiDiv.getRadServiceKubun().setSelectedItem(new RString(map.get("サービス区分").toString()));
        serviceHiDiv.getRadTokureiKeigenSochiTaisho().setSelectedItem(new RString(map.get("特例減額措置対象").toString()));
        serviceHiDiv.getTxtShokuhiFutanGendogaku().setValue(new Decimal(map.get("食費負担限度額").toString()));
        serviceHiDiv.getTxtFutanGendogakuTekiyoDateRange().setFromValue(new RDate(map.get("負担限度額適用開始日").toString()));
        serviceHiDiv.getTxtFutanGendogakuTekiyoDateRange().setToValue(new RDate(map.get("負担限度額適用終了日").toString()));
        serviceHiDiv.getTxtUnitKoshitsuGendogaku().setValue(new Decimal(map.get("ユニット型個室").toString()));
        serviceHiDiv.getTxtUnitJunKoshitsuFutanGendogaku().setValue(new Decimal(map.get("ユニット型準個室").toString()));
        serviceHiDiv.getTxtJuraigataKoshitsuTokuyoFutanGendogaku().setValue(new Decimal(map.get("従来型個室(特養等)").toString()));
        serviceHiDiv.getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku().setValue(new Decimal(map.get("従来型個室(老健、療養等)").toString()));
        serviceHiDiv.getTxtTashoshitsu().setValue(new Decimal(map.get("多床室").toString()));

        map = ymlData.get(YML_IDX_KOKI_KOREI_KOKUHO);
        JukyushaIdoRenrakuhyoKokiKoreiDiv koreiDiv
                = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKokiKoreiKokuho().getJukyushaIdoRenrakuhyoKokiKorei();
        koreiDiv.getTxtKokiKoreiHokenshaNo().setValue(new RString(map.get("後期高齢保険者番号").toString()));
        koreiDiv.getTxtKokiKoreiHihokenshaNo().setValue(new RString(map.get("後期高齢被保番号").toString()));
        JukyushaIdoRenrakuhyoKokuhoDiv kokuhoDiv
                = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKokiKoreiKokuho().getJukyushaIdoRenrakuhyoKokuho();
        kokuhoDiv.getTxtKokuhoHokenshaNo().setValue(new RString(map.get("国保保険者番号").toString()));
        kokuhoDiv.getTxtKokuhoHihokenshashoNo().setValue(new RString(map.get("国保被保険者証番号").toString()));
        kokuhoDiv.getTxtKokuhoKojinNo().setValue(new RString(map.get("国保個人番号").toString()));

        map = ymlData.get(YML_IDX_KYUFU_SEIGEN);
        JukyushaIdoRenrakuhyoKyufuSeigenDiv seigenDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyufuSeigen();
        seigenDiv.getRadKohiFutanJogengakuGengakuUmu().setSelectedItem(new RString(map.get("生活保護等").toString()));
        seigenDiv.getTxtShokanBaraikaDateRange().setFromValue(new RDate(map.get("償還払化開始日").toString()));
        seigenDiv.getTxtShokanBaraikaDateRange().setToValue(new RDate(map.get("償還払化終了日").toString()));
        seigenDiv.getTxtKyufuritsuHikisageDateRange().setFromValue(new RDate(map.get("給付率引下げ開始日").toString()));
        seigenDiv.getTxtKyufuritsuHikisageDateRange().setToValue(new RDate(map.get("給付率引下げ終了日").toString()));

        map = ymlData.get(YML_IDX_NIJI_YOBO_JIGYO);
        JukyushaIdoRenrakuhyoNijiyoboJigyoDiv jigyoDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoNijiyoboJigyo();
        jigyoDiv.getRadNijiyoboJigyoKubun().setSelectedItem(new RString(map.get("事業区分").toString()));
        jigyoDiv.getTxtNijiyoboJigyoYukoDateRange().setFromValue(new RDate(map.get("事業有効開始日").toString()));
        jigyoDiv.getTxtNijiyoboJigyoYukoDateRange().setToValue(new RDate(map.get("事業有効終了日").toString()));

        map = ymlData.get(YML_IDX_ROJIN_HOKEN);
        JukyushaIdoRenrakuhyoRojinHokenDiv rojinHokenDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoRojinHoken();
        rojinHokenDiv.getRokenShichosonNo().setValue(new RString(map.get("市町村番号").toString()));
        rojinHokenDiv.getRokenJukyushaNo().setValue(new RString(map.get("受給者番号").toString()));
        rojinHokenDiv.getRokenKohiFutanshaNo().setValue(new RString(map.get("公費負担番号").toString()));
    }

    private List<HashMap> getYmlData() {
        return YamlLoader.DBC.loadAsList(YML_NAME);
    }
}
