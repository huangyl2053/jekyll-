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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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

        ControlGenerator cg = new ControlGenerator(ymlData.get(YML_IDX_KIHON));
        JukyushaIdoRenrakuhyoKihonJohoDiv kihonJohoDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKihonJoho();
        kihonJohoDiv.getTxtRenrakuhyoIdoDate().setValue(cg.getAsFlexibleDate("異動日"));
        kihonJohoDiv.getRadRenrakuhyoIdoKubun().setSelectedItem(cg.getAsRString("異動区分"));
        kihonJohoDiv.getDdlIdoJiyu().setSelectedItem(cg.getAsRString("異動事由"));
        kihonJohoDiv.getTxtRenrakuhyoHihoNo().setValue(cg.getAsRString("被保番号"));
        kihonJohoDiv.getTxtRenrakuhyoHihoName().setValue(cg.getAsRString("カナ氏名"));
        kihonJohoDiv.getTxtHihoBirthday().setValue(cg.getAsFlexibleDate("生年月日"));
        kihonJohoDiv.getRadHihoSex().setSelectedItem(cg.getAsRString("性別"));
        kihonJohoDiv.getTxtShikakuShutokuDate().setValue(cg.getAsFlexibleDate("資格取得日"));
        kihonJohoDiv.getTxtShikakuSoshitsuDate().setValue(cg.getAsFlexibleDate("資格喪失日"));
        kihonJohoDiv.getTxtShokisaiHokenshaNo().setValue(cg.getAsRString("証記載保険者番号"));
        kihonJohoDiv.getTxtKoikiHokenshaNo().setValue(cg.getAsRString("広域保険者番号"));
        kihonJohoDiv.getTxtRenrakuhyoSendYM().setValue(cg.getAsFlexibleDate("送付年月"));

        cg = new ControlGenerator(ymlData.get(YML_IDX_YOKAIGO_NINTEI));
        JukyushaIdoRenrakuhyoYokaigoninteiDiv ninteiDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoYokaigonintei();
        ninteiDiv.getTxtShinseiDate().setValue(cg.getAsFlexibleDate("申請日"));
        ninteiDiv.getDdlYokaigoJotaiKubun().setSelectedItem(cg.getAsRString("状態区分"));
        ninteiDiv.getTxtNinteiDateRange().setFromValue(cg.getAsRDate("認定開始日"));
        ninteiDiv.getTxtNinteiDateRange().setToValue(cg.getAsRDate("認定終了日"));
        ninteiDiv.getRadShinseiType().setSelectedItem(cg.getAsRString("申請種別"));
        ninteiDiv.getRadHenkoShinseichuKubun().setSelectedItem(cg.getAsRString("変更申請中区分"));
        ninteiDiv.getRadMinashiYokaigoKubun().setSelectedItem(cg.getAsRString("みなし区分"));

        cg = new ControlGenerator(ymlData.get(YML_IDX_SHIKYU_GENDO_KIJUN));
        JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv jungakuDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoShikyugendoKijungaku();
        jungakuDiv.getTxtKyuHomonTsushoShikyuGendoKijungaku().setValue(cg.getAsDecimal("旧訪問通所基準額"));
        jungakuDiv.getTxtKyuHomonTsushoKanriTekiyoDateRange().setFromValue(cg.getAsRDate("旧訪問通所適用開始日"));
        jungakuDiv.getTxtKyuHomonTsushoKanriTekiyoDateRange().setToValue(cg.getAsRDate("旧訪問通所適用終了日"));
        jungakuDiv.getTxtKyuTankiNyushoShikyuGendoKijungaku().setValue(cg.getAsDecimal("旧短期入所基準額"));
        jungakuDiv.getTxtKyuTankiNyushoKanriTekiyoDateRange().setFromValue(cg.getAsRDate("旧短期入所適用開始日"));
        jungakuDiv.getTxtKyuTankiNyushoKanriTekiyoDateRange().setToValue(cg.getAsRDate("旧短期入所適用終了日"));

        cg = new ControlGenerator(ymlData.get(YML_IDX_SERVICE_KEIKAKU));
        JukyushaIdoRenrakuhyoKyotakuServicePlanDiv planDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyotakuServicePlan();
        planDiv.getRadPlanSakuseiKubun().setSelectedItem(cg.getAsRString("計画作成区分"));
        planDiv.getTxtShienJigyoshaNo().setValue(cg.getAsRString("支援事業者コード"));
        planDiv.getTxtShienJigyoshaName().setValue(cg.getAsRString("支援事業者名"));
        planDiv.getTxtKyotakuServicePlanTekiyoDateRange().setFromValue(cg.getAsRDate("適用開始日"));
        planDiv.getTxtKyotakuServicePlanTekiyoDateRange().setToValue(cg.getAsRDate("適用終了日"));
        planDiv.getRadShokiboKyotakuServiceRiyoUmu().setSelectedItem(cg.getAsRString("小規模居宅サービス利用"));

        cg = new ControlGenerator(ymlData.get(YML_IDX_GENMEN_GENGAKU));
        JukyushaIdoRenrakuhyoGemmenGengakuDiv gengakuDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoGemmenGengaku();
        gengakuDiv.getRadGemmenShinseichuKubun().setSelectedItem(cg.getAsRString("減免申請中区分"));
        JukyushaIdoRenrakuhyoRiyoshaFutanDiv riyoshaFutanDiv
                = gengakuDiv.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoRiyoshaFutan();
        riyoshaFutanDiv.getRadRiyoshaFutanKubun().setSelectedItem(cg.getAsRString("利用者負担区分"));
        riyoshaFutanDiv.getTxtRiyoshaFutanKyufuritsu().setValue(cg.getAsDecimal("利用者負担給付率"));
        riyoshaFutanDiv.getTxtRiyoshaFutanTekiyoDateRange().setFromValue(cg.getAsRDate("利用者負担適用開始日"));
        riyoshaFutanDiv.getTxtRiyoshaFutanTekiyoDateRange().setToValue(cg.getAsRDate("利用者負担適用終了日"));
        JukyushaIdoRenrakuhyoFukushiHojinKeigenDiv shafukuKeigenDiv
                = gengakuDiv.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoFukushiHojinKeigen();
        shafukuKeigenDiv.getTxtKeigenritsu().setValue(cg.getAsDecimal("社福法人軽軽減率"));
        shafukuKeigenDiv.getTxtKeigenritsuTekiyoDateRange().setFromValue(cg.getAsRDate("社福法人軽減適用開始日"));
        shafukuKeigenDiv.getTxtKeigenritsuTekiyoDateRange().setToValue(cg.getAsRDate("社福法人軽減適用終了日"));
        JukyushaIdoRenrakuhyoHyojunFutanDiv hyojunFutanDiv
                = gengakuDiv.getJukyushaIdoRenrakuhyoGemmenGengakuSub().getJukyushaIdoRenrakuhyoHyojunFutan();
        hyojunFutanDiv.getRadHyojunFutanKubun().setSelectedItem(cg.getAsRString("標準負担区分"));
        hyojunFutanDiv.getTxtHyojunFutangaku().setValue(cg.getAsDecimal("標準負担額"));
        hyojunFutanDiv.getTxtHyojunFutanTekiyoDateRange().setFromValue(cg.getAsRDate("標準負担適用開始日"));
        hyojunFutanDiv.getTxtHyojunFutanTekiyoDateRange().setToValue(cg.getAsRDate("標準負担適用終了日"));
        JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv serviceHiDiv = gengakuDiv.getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi();
        serviceHiDiv.getRadNinteiShinseichuKubun().setSelectedItem(cg.getAsRString("認定申請中区分"));
        serviceHiDiv.getRadServiceKubun().setSelectedItem(cg.getAsRString("サービス区分"));
        serviceHiDiv.getRadTokureiKeigenSochiTaisho().setSelectedItem(cg.getAsRString("特例減額措置対象"));
        serviceHiDiv.getTxtShokuhiFutanGendogaku().setValue(cg.getAsDecimal("食費負担限度額"));
        serviceHiDiv.getTxtFutanGendogakuTekiyoDateRange().setFromValue(cg.getAsRDate("負担限度額適用開始日"));
        serviceHiDiv.getTxtFutanGendogakuTekiyoDateRange().setToValue(cg.getAsRDate("負担限度額適用終了日"));
        serviceHiDiv.getTxtUnitKoshitsuGendogaku().setValue(cg.getAsDecimal("ユニット型個室"));
        serviceHiDiv.getTxtUnitJunKoshitsuFutanGendogaku().setValue(cg.getAsDecimal("ユニット型準個室"));
        serviceHiDiv.getTxtJuraigataKoshitsuTokuyoFutanGendogaku().setValue(cg.getAsDecimal("従来型個室(特養等)"));
        serviceHiDiv.getTxtJuraigataKoshitsuRokenRyoyoFutanGendogaku().setValue(cg.getAsDecimal("従来型個室(老健、療養等)"));
        serviceHiDiv.getTxtTashoshitsu().setValue(cg.getAsDecimal("多床室"));

        cg = new ControlGenerator(ymlData.get(YML_IDX_KOKI_KOREI_KOKUHO));
        JukyushaIdoRenrakuhyoKokiKoreiDiv koreiDiv
                = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKokiKoreiKokuho().getJukyushaIdoRenrakuhyoKokiKorei();
        koreiDiv.getTxtKokiKoreiHokenshaNo().setValue(cg.getAsRString("後期高齢保険者番号"));
        koreiDiv.getTxtKokiKoreiHihokenshaNo().setValue(cg.getAsRString("後期高齢被保番号"));
        JukyushaIdoRenrakuhyoKokuhoDiv kokuhoDiv
                = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKokiKoreiKokuho().getJukyushaIdoRenrakuhyoKokuho();
        kokuhoDiv.getTxtKokuhoHokenshaNo().setValue(cg.getAsRString("国保保険者番号"));
        kokuhoDiv.getTxtKokuhoHihokenshashoNo().setValue(cg.getAsRString("国保被保険者証番号"));
        kokuhoDiv.getTxtKokuhoKojinNo().setValue(cg.getAsRString("国保個人番号"));

        cg = new ControlGenerator(ymlData.get(YML_IDX_KYUFU_SEIGEN));
        JukyushaIdoRenrakuhyoKyufuSeigenDiv seigenDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoKyufuSeigen();
        seigenDiv.getRadKohiFutanJogengakuGengakuUmu().setSelectedItem(cg.getAsRString("生活保護等"));
        seigenDiv.getTxtShokanBaraikaDateRange().setFromValue(cg.getAsRDate("償還払化開始日"));
        seigenDiv.getTxtShokanBaraikaDateRange().setToValue(cg.getAsRDate("償還払化終了日"));
        seigenDiv.getTxtKyufuritsuHikisageDateRange().setFromValue(cg.getAsRDate("給付率引下げ開始日"));
        seigenDiv.getTxtKyufuritsuHikisageDateRange().setToValue(cg.getAsRDate("給付率引下げ終了日"));

        cg = new ControlGenerator(ymlData.get(YML_IDX_NIJI_YOBO_JIGYO));
        JukyushaIdoRenrakuhyoNijiyoboJigyoDiv jigyoDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoNijiyoboJigyo();
        jigyoDiv.getRadNijiyoboJigyoKubun().setSelectedItem(cg.getAsRString("事業区分"));
        jigyoDiv.getTxtNijiyoboJigyoYukoDateRange().setFromValue(cg.getAsRDate("事業有効開始日"));
        jigyoDiv.getTxtNijiyoboJigyoYukoDateRange().setToValue(cg.getAsRDate("事業有効終了日"));

        cg = new ControlGenerator(ymlData.get(YML_IDX_ROJIN_HOKEN));
        JukyushaIdoRenrakuhyoRojinHokenDiv rojinHokenDiv = panel.getJukyushaIdoRenrakuhyo().getJukyushaIdoRenrakuhyoRojinHoken();
        rojinHokenDiv.getRokenShichosonNo().setValue(cg.getAsRString("市町村番号"));
        rojinHokenDiv.getRokenJukyushaNo().setValue(cg.getAsRString("受給者番号"));
        rojinHokenDiv.getRokenKohiFutanshaNo().setValue(cg.getAsRString("公費負担番号"));
    }

    private List<HashMap> getYmlData() {
        return YamlLoader.DBC.loadAsList(YML_NAME);
    }
}
