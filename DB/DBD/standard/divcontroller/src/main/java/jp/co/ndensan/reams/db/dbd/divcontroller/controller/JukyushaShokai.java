/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.FutanGendogakuNinteiData;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.HyojunFutangakuGengakuData;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.JukyushaData;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.RiyoshaFutangakuGemmenData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.ButtonsShosaiShijiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.IryoHokenDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.JukyushaShokaiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.JukyushaShokaiTargetSearchDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiResultDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiResultIdoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiResultOtherDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteiTorikeshiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.NinteichosaDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.ShiteiServiceIchiranDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.ShujiiIkenshoDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.dgNinteiRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.DateRoundingType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;

/**
 *
 * @author N3327 三浦 凌
 */
public class JukyushaShokai {

    /**
     * ロード時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @param targets JukyushaShokaiTargetSearchDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiDiv> onLoad(JukyushaShokaiDiv div, JukyushaShokaiTargetSearchDiv targets) {
        return _createResponseData(div);
    }

    /**
     *
     * @param div JukyushaShokaiDiv
     * @param targets JukyushaShokaiTargetSearchDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiDiv> onStart(JukyushaShokaiDiv div, JukyushaShokaiTargetSearchDiv targets) {
        div.getNinteiRireki().getDgNinteiRireki().setDataSource(searchHistroyOfClickedHihokensha(targets));
        RString hihokenshaNo = clickedItem(targets).getHihokenshaNo();
        div.getHihokensha().getTxtHihokenshaNo().setValue(hihokenshaNo);
        initButtonsShosaiShiji(div.getButtonsShosaiShiji(), hihokenshaNo);
        return _createResponseData(div);
    }

    private void initButtonsShosaiShiji(ButtonsShosaiShijiDiv div, RString hihokenshaNo) {
        toBeAbleToPushOrNot_button(div.getBtnFutangendogakuNintei(),
                !new FutanGendogakuNinteiData().exists負担限度額認定履歴of(hihokenshaNo));
        toBeAbleToPushOrNot_button(div.getBtnHyojunFutangakuGengaku(),
                !new HyojunFutangakuGengakuData().exists標準負担額減額履歴Of(hihokenshaNo));
        toBeAbleToPushOrNot_button(div.getBtnRiyoshaFutangakuGemmen(),
                !new RiyoshaFutangakuGemmenData().exists利用者負担額減免履歴Of(hihokenshaNo));
    }

    private void toBeAbleToPushOrNot_button(ButtonDialog btn, boolean disable) {
        btn.setDisabled(disable);
    }

    private List<dgNinteiRireki_Row> searchHistroyOfClickedHihokensha(JukyushaShokaiTargetSearchDiv targets) {
        return new JukyushaData().get履歴Of(clickedItem(targets).getHihokenshaNo()).asConvertedType();
    }

    private dgSearchResult_Row clickedItem(JukyushaShokaiTargetSearchDiv targets) {
        return targets.getSearchResult().getDgSearchResult().getClickedItem();
    }

    /**
     *
     * @param div JukyushaShokaiDiv
     * @param targets JukyushaShokaiTargetSearchDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiDiv> onStart_Detail(JukyushaShokaiDiv div, JukyushaShokaiTargetSearchDiv targets) {
        List<HashMap> history = new JukyushaData().get履歴Of(clickedItem(targets).getHihokenshaNo()).asRow();
        dgNinteiRireki_Row clicked = div.getNinteiRireki().getDgNinteiRireki().getClickedItem();
        for (Map map : history) {
            if (clicked.getNinteiShinseiDate().getValue().toString().equals(map.get("認定申請日").toString())) {
                setUp_Details(div, new ControlGenerator(map));
                break;
            }
        }
        return _createResponseData(div);
    }

    private void setUp_Details(JukyushaShokaiDiv div, ControlGenerator cg) {
        _setUp_NinteiDetail(div.getNinteiDetail(), cg);
    }

    //<editor-fold defaultstate="collapsed" desc="_setUp_NinteiDetail">
    private void _setUp_NinteiDetail(NinteiDetailDiv div, ControlGenerator cg) {
        _setUp_NinteiResultDetail(div.getNinteiResultDetail(), cg);
        _setUp_NinteichosaDetail(div.getNinteichosaDetail(), cg);
        _setUP_ShujiiIkenshoDetail(div.getShujiiIkenshoDetail(), cg);
        _setUp_IryoHokenDetail(div.getIryoHokenDetail(), cg);
        div.getTxtIchijiHanteiKanryoYMD().setValue(cg.getAsFlexibleDate("一次判定完了日"));
        div.getTxtIchijiHanteiResult().setValue(cg.getAsRString("一次判定結果"));
        div.getTxtIchijiHanteiYMD().setValue(cg.getAsFlexibleDate("一次判定日"));
        div.getTxtNinteiShinseiKubunHorei().setValue(cg.getAsRString("申請区分_法令"));
        div.getTxtNinteiShinseiKubunShinseiji().setValue(cg.getAsRString("申請区分_申請時"));
        div.getTxtNinteiShinseiYMD().setValue(cg.getAsFlexibleDate("認定申請日"));
        div.getTxtNinteiShinseiYukoKubun().setValue(cg.getAsRString("申請有効区分"));
    }

    private void _setUp_NinteiResultDetail(NinteiResultDetailDiv div, ControlGenerator cg) {
        _setUp_NinteiResultOther(div.getNinteiResultOther(), cg);
        _setUp_ShiteiServiceIchiran(div.getShiteiServiceIchiran(), cg);
        div.getTxtNinteiYMD().setValue(cg.getAsFlexibleDate("認定日"));
        FlexibleDate yukoKikanKaishiDate = cg.getAsFlexibleDate("有効期間開始日");
        int yukoKikanTsukisu = cg.getAsDecimal("有効期間月数").intValue();
        div.getTxtYukokikanTsukisu().setValue(new RString(Integer.toString(yukoKikanTsukisu)));
        div.getTxtNinteiYukoKaishiYMD().setValue(yukoKikanKaishiDate);
        div.getTxtNinteiYukoShuryoYMD().setValue(
                calculateYukoKikanShuryoDate(yukoKikanKaishiDate, yukoKikanTsukisu));
        div.getTxtYokaigodo().setValue(cg.getAsRString("要介護度"));
        div.getTxtYokaigodoCode().setValue(toYoKaigoJotaiKubun(cg.getAsRString("要介護度")).getCode());
    }

    private FlexibleDate calculateYukoKikanShuryoDate(FlexibleDate date, int yukoKikanTsukisu) {
        return date.plusMonth(yukoKikanTsukisu).plusDay(31, DateRoundingType.同月の暦上日);
    }

    private YoKaigoJotaiKubun toYoKaigoJotaiKubun(RString rstr) {
        for (YoKaigoJotaiKubun kubun : YoKaigoJotaiKubun.values()) {
            if (kubun.name().equals(rstr.toString()) || kubun.getCode().equals(rstr)) {
                return kubun;
            }
        }
        return YoKaigoJotaiKubun.非該当;
    }

    private void _setUp_NinteiResultOther(NinteiResultOtherDiv div, ControlGenerator cg) {
        div.getTxtShinsakaiIken().setValue(cg.getAsRString("審査会意見"));
        RString tokuteiShippei = cg.getAsRString("特定疾病");
        if (RString.EMPTY.equals(tokuteiShippei)) {
            div.getTxtTokuteiShippei().setDisplayNone(true);
        } else {
            div.getTxtTokuteiShippei().setDisplayNone(false);
            div.getTxtTokuteiShippei().setValue(tokuteiShippei);
        }
        NinteiResultIdoDiv ido = div.getNinteiResultIdo();
        ido.getTxtNinteiResultIdoJiyu().setValue(cg.getAsRString("異動事由:"));
        ido.getTxtNinteiResultIdoYMD().setValue(cg.getAsFlexibleDate("異動日"));
        ido.getTxtNinteiSoshitsuYMD().setValue(cg.getAsFlexibleDate("喪失日"));
        NinteiTorikeshiDiv torikeshi = div.getNinteiTorikeshi();
        torikeshi.getTxtNinteiTorikeshiRiyu().setValue(cg.getAsRString("取消理由"));
        torikeshi.getTxtTorikeshiYMD().setValue(cg.getAsFlexibleDate("取消日"));
    }

    private void _setUp_ShiteiServiceIchiran(ShiteiServiceIchiranDiv div, ControlGenerator cg) {

    }

    private void _setUp_NinteichosaDetail(NinteichosaDetailDiv div, ControlGenerator cg) {
        div.getTxtNinteiChosaItakusakiCode().setValue(cg.getAsRString("調査委託先コード"));
        div.getTxtNinteiChosaItakusaki().setValue(cg.getAsRString("調査委託先名"));
        div.getTxtNinteiChosainCode().setValue(cg.getAsRString("調査員コード"));
        div.getTxtNinteiChosain().setValue(cg.getAsRString("調査員名"));
        div.getTxtNinteichosaJissiYMD().setValue(cg.getAsFlexibleDate("調査実施日"));
        div.getTxtNinteichosaJuryoYMD().setValue(cg.getAsFlexibleDate("調査受領日"));
        div.getTxtNinteichosaKanryoYMD().setValue(cg.getAsFlexibleDate("調査完了日"));
    }

    private void _setUP_ShujiiIkenshoDetail(ShujiiIkenshoDetailDiv div, ControlGenerator cg) {
        div.getTxtShujiiCode().setValue(cg.getAsRString("主治医コード"));
        div.getTxtShujiiMeisho().setValue(cg.getAsRString("主治医名称"));
        div.getTxtShujiiIryokikanCode().setValue(cg.getAsRString("医療機関コード"));
        div.getTxtShujiIryokikanMeisho().setValue(cg.getAsRString("医療機関名称"));
        div.getTxtShujiiIkenshoJuryoYMD().setValue(cg.getAsFlexibleDate("意見書受領日"));
        div.getTxtShujiiIkenshoKanryoYMD().setValue(cg.getAsFlexibleDate("意見書完了日"));
        div.getTxtShujiiIkenshoKinyuYMD().setValue(cg.getAsFlexibleDate("意見書記入日"));
    }

    private void _setUp_IryoHokenDetail(IryoHokenDetailDiv div, ControlGenerator cg) {
        Decimal iryoHokenshaNo = cg.getAsDecimal("医療保険者番号");
        if (iryoHokenshaNo == null) {
            div.setDisplayNone(true);
        } else {
            div.setDisplayNone(false);
            div.getTxtHokenshaNo().setValue(iryoHokenshaNo);
            div.getTxtHokenshaMeisho().setValue(cg.getAsRString("医療保険名称"));
            div.getTxtIryoHokenShubetsu().setValue(cg.getAsRString("医療保険種別"));
            div.getTxtKigoBango().setValue(cg.getAsRString("記号番号"));
        }
    }
    //</editor-fold>

    private ResponseData<JukyushaShokaiDiv> _createResponseData(JukyushaShokaiDiv div) {
        ResponseData<JukyushaShokaiDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
