/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.FutanGendogakuNinteiData;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.HomonkaigoRiyoshaFutangakuGengakuData;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.HyojunFutangakuGengakuData;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.JukyushaData;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.RiyoshaFutangakuGemmenData;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.ShakaiFukushiHojinKeigenData;
import jp.co.ndensan.reams.db.dbd.divcontroller.demodata.TokubetsuChiikiKasanGemmenData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.ButtonsShosaiShijiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.IryoHokenDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.JukyushaShokaiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.JukyushaShokaiTargetSearchDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.NinteiDetailDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.NinteiResultDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.NinteiResultIdoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.NinteiResultEtceteraDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.NinteiTorikeshiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.NinteichosaDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.ShiteiServiceIchiranDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.ShujiiIkenshoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.dgNinteiRireki_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010002.dgShiteiServiceShurui_Row;
//import jp.co.ndensan.reams.db.dbz.divcontroller.controller.SearchResultOfHihokensha;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 *
 * @author N3327 三浦 凌
 */
public class JukyushaShokai {

    /**
     * ロード時の処理です。
     *
     * @param div JukyushaShokaiDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiDiv> onLoad(JukyushaShokaiDiv div) {
        return _createResponseData(div);
    }

    /**
     *
     * @param div JukyushaShokaiDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiDiv> onStart(JukyushaShokaiDiv div) {
        SearchResultOfHihokenshaDiv results = SearchResultForJukyushaShokai.getInstance().get();
        div.getNinteiRireki().getDgNinteiRireki().setDataSource(searchHistroyOfClickedHihokensha(results));

        RString hihokenshaNo = clickedItem(results).getHihokenshaNo();
        RString shikibetsuCode = clickedItem(results).getShikibetsuCode();

        div.getTxtHihokenshaNo().setValue(hihokenshaNo);
        _init_ButtonsShosaiShiji(div.getButtonsShosaiShiji(), hihokenshaNo);

        return _createResponseData(div);
    }

    private void _init_ButtonsShosaiShiji(ButtonsShosaiShijiDiv div, RString hihokenshaNo) {
        toBeAbleToPushOrNot_button(div.getBtnFutangendogakuNintei(),
                !new FutanGendogakuNinteiData().exists負担限度額認定履歴of(hihokenshaNo));
        toBeAbleToPushOrNot_button(div.getBtnHyojunFutangakuGengaku(),
                !new HyojunFutangakuGengakuData().exists標準負担額減額履歴Of(hihokenshaNo));
        toBeAbleToPushOrNot_button(div.getBtnRiyoshaFutangakuGemmen(),
                !new RiyoshaFutangakuGemmenData().exists利用者負担額減免履歴Of(hihokenshaNo));
        toBeAbleToPushOrNot_button(div.getBtnHomonKaigoRiyoshaFutangakuGengaku(),
                !new HomonkaigoRiyoshaFutangakuGengakuData().exsits訪問介護利用者負担額減額履歴(hihokenshaNo));
        toBeAbleToPushOrNot_button(div.getBtnShakaiFukushiHojinKeigen(),
                !new ShakaiFukushiHojinKeigenData().exists社会福祉法人軽減履歴Of(hihokenshaNo));
        toBeAbleToPushOrNot_button(div.getBtnTokubetsuChiikiKasanGemmen(),
                !new TokubetsuChiikiKasanGemmenData().exists特別地域加算減免履歴Of(hihokenshaNo));
    }

    private void toBeAbleToPushOrNot_button(ButtonDialog btn, boolean disable) {
        btn.setDisabled(disable);
    }

    private List<dgNinteiRireki_Row> searchHistroyOfClickedHihokensha(SearchResultOfHihokenshaDiv results) {
        return new JukyushaData().get履歴Of(clickedItem(results).getHihokenshaNo()).asConvertedType();
    }

    private dgSearchResult_Row clickedItem(SearchResultOfHihokenshaDiv results) {
        return results.getDgSearchResult().getClickedItem();
    }

    /**
     *
     * @param div JukyushaShokaiDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiDiv> onStart_Detail(JukyushaShokaiDiv div) {
        SearchResultOfHihokenshaDiv results = SearchResultForJukyushaShokai.getInstance().get();

        List<HashMap> history = new JukyushaData().get履歴Of(clickedItem(results).getHihokenshaNo()).asRow();
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
        new NinteiDetail(div).setDemoData(cg);
    }

    /**
     *
     * @param div JukyushaShokaiDiv
     * @param targets JukyushaShokaiTargetSearchDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiDiv> onClick_btnToReturnNinteiRireki(JukyushaShokaiDiv div, JukyushaShokaiTargetSearchDiv targets) {
        clear_Details(div);
        return _createResponseData(div);
    }

    private void clear_Details(JukyushaShokaiDiv div) {
        new NinteiDetail(div).clear();
    }

    /**
     * create ResponseData
     *
     * @param div JukyushaShokaiDiv
     * @return ResponseData
     */
    private ResponseData<JukyushaShokaiDiv> _createResponseData(JukyushaShokaiDiv div) {
        ResponseData<JukyushaShokaiDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    //<editor-fold defaultstate="collapsed" desc="NinteiDetail">
    private static class NinteiDetail {

        private final NinteiDetailDiv div;
        private final NinteiResult resultDetail;
        private final Ninteichosa chosa;
        private final ShujiiIkensho ikensho;
        private final IryoHoken iryoHoken;

        public NinteiDetail(JukyushaShokaiDiv div) {
            this.div = div.getNinteiDetail();
            this.resultDetail = new NinteiResult(div);
            this.chosa = new Ninteichosa(div);
            this.ikensho = new ShujiiIkensho(div);
            this.iryoHoken = new IryoHoken(div);
        }

        public void setDemoData(ControlGenerator cg) {
            this.resultDetail.setDemoData(cg);
            this.chosa.setDemoData(cg);
            this.ikensho.setDemoData(cg);
            this.iryoHoken.setDemoData(cg);
            this._setDemoData(cg);
        }

        private void _setDemoData(ControlGenerator cg) {
            div.getTxtIchijiHanteiKanryoYMD().setValue(cg.getAsFlexibleDate("一次判定完了日"));
            div.getTxtIchijiHanteiResult().setValue(cg.getAsRString("一次判定結果"));
            div.getTxtIchijiHanteiYMD().setValue(cg.getAsFlexibleDate("一次判定日"));
            div.getTxtNinteiShinseiKubunHorei().setValue(cg.getAsRString("申請区分_法令"));
            div.getTxtNinteiShinseiKubunShinseiji().setValue(cg.getAsRString("申請区分_申請時"));
            div.getTxtNinteiShinseiYMD().setValue(cg.getAsFlexibleDate("認定申請日"));
            div.getTxtNinteiShinseiYukoKubun().setValue(cg.getAsRString("申請有効区分"));
        }

        public void clear() {
            this.chosa.clear();
            this.ikensho.clear();
            this.iryoHoken.clear();
            this.resultDetail.clear();
            this._clear();
        }

        private void _clear() {
            div.getTxtIchijiHanteiKanryoYMD().clearValue();
            div.getTxtIchijiHanteiResult().clearValue();
            div.getTxtIchijiHanteiYMD().clearValue();
            div.getTxtNinteiShinseiKubunHorei().clearValue();
            div.getTxtNinteiShinseiKubunShinseiji().clearValue();
            div.getTxtNinteiShinseiYMD().clearValue();
            div.getTxtNinteiShinseiYukoKubun().clearValue();
        }
    }

    private static class Ninteichosa {

        private final NinteichosaDiv div;

        public Ninteichosa(JukyushaShokaiDiv div) {
            this.div = div.getNinteiDetail().getNinteichosa();
        }

        public void setDemoData(ControlGenerator cg) {
            div.getTxtNinteiChosaItakusakiCode().setValue(cg.getAsRString("調査委託先コード"));
            div.getTxtNinteiChosaItakusaki().setValue(cg.getAsRString("調査委託先名"));
            div.getTxtNinteiChosainCode().setValue(cg.getAsRString("調査員コード"));
            div.getTxtNinteiChosain().setValue(cg.getAsRString("調査員名"));
            div.getTxtNinteichosaJissiYMD().setValue(cg.getAsFlexibleDate("調査実施日"));
            div.getTxtNinteichosaJuryoYMD().setValue(cg.getAsFlexibleDate("調査受領日"));
            div.getTxtNinteichosaKanryoYMD().setValue(cg.getAsFlexibleDate("調査完了日"));
        }

        public void clear() {
            div.getTxtNinteiChosaItakusakiCode().clearValue();
            div.getTxtNinteiChosaItakusaki().clearValue();
            div.getTxtNinteiChosainCode().clearValue();
            div.getTxtNinteiChosain().clearValue();
            div.getTxtNinteichosaJissiYMD().clearValue();
            div.getTxtNinteichosaJuryoYMD().clearValue();
            div.getTxtNinteichosaKanryoYMD().clearValue();
        }
    }

    private static final class ShujiiIkensho {

        private final ShujiiIkenshoDiv div;

        public ShujiiIkensho(JukyushaShokaiDiv div) {
            this.div = div.getNinteiDetail().getShujiiIkensho();
        }

        public void setDemoData(ControlGenerator cg) {
            div.getTxtShujiiCode().setValue(cg.getAsRString("主治医コード"));
            div.getTxtShujiiMeisho().setValue(cg.getAsRString("主治医名称"));
            div.getTxtShujiiIryokikanCode().setValue(cg.getAsRString("医療機関コード"));
            div.getTxtShujiIryokikanMeisho().setValue(cg.getAsRString("医療機関名称"));
            div.getTxtShujiiIkenshoJuryoYMD().setValue(cg.getAsFlexibleDate("意見書受領日"));
            div.getTxtShujiiIkenshoKanryoYMD().setValue(cg.getAsFlexibleDate("意見書完了日"));
            div.getTxtShujiiIkenshoKinyuYMD().setValue(cg.getAsFlexibleDate("意見書記入日"));
        }

        public void clear() {
            div.getTxtShujiiCode().clearValue();
            div.getTxtShujiiMeisho().clearValue();
            div.getTxtShujiiIryokikanCode().clearValue();
            div.getTxtShujiIryokikanMeisho().clearValue();
            div.getTxtShujiiIkenshoJuryoYMD().clearValue();
            div.getTxtShujiiIkenshoKanryoYMD().clearValue();
            div.getTxtShujiiIkenshoKinyuYMD().clearValue();
        }
    }

    private static class IryoHoken {

        private final IryoHokenDiv div;

        public IryoHoken(JukyushaShokaiDiv div) {
            this.div = div.getNinteiDetail().getIryoHoken();
        }

        public void setDemoData(ControlGenerator cg) {
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

        private void clear() {
            div.getTxtHokenshaNo().clearValue();
            div.getTxtHokenshaMeisho().clearValue();
            div.getTxtIryoHokenShubetsu().clearValue();
            div.getTxtKigoBango().clearValue();
        }
    }

    private static class NinteiResult {

        private final NinteiResultDiv div;
        private final NinteiResultOther other;
        private final ShiteiServiceIchiran service;

        public NinteiResult(JukyushaShokaiDiv div) {
            this.div = div.getNinteiDetail().getNinteiResult();
            this.other = new NinteiResultOther(div);
            this.service = new ShiteiServiceIchiran(div);
        }

        public void setDemoData(ControlGenerator cg) {
            this.other.setDemoData(cg);
            this.service.setDemoData(cg);
            this._setDemoData(cg);
        }

        private void _setDemoData(ControlGenerator cg) {
            div.getTxtNinteiYMD().setValue(cg.getAsFlexibleDate("認定日"));
            div.getTxtYokaigodo().setValue(cg.getAsRString("要介護度"));
            div.getTxtYokaigodoCode().setValue(toYoKaigoJotaiKubun(cg.getAsRString("要介護度")).getCode());
            FlexibleDate yukoKikanKaishiDate = cg.getAsFlexibleDate("有効期間開始日");
            int yukoKikanTsukisu = cg.getAsDecimal("有効期間月数").intValue();
            div.getTxtYukokikanTsukisu().setValue(new RString(Integer.toString(yukoKikanTsukisu)));
            div.getTxtNinteiYukoKaishiYMD().setValue(yukoKikanKaishiDate);
            div.getTxtNinteiYukoShuryoYMD().setValue(
                    calculateYukoKikanShuryoDate(yukoKikanKaishiDate, yukoKikanTsukisu));
        }

        private FlexibleDate calculateYukoKikanShuryoDate(FlexibleDate date, int yukoKikanTsukisu) {
            FlexibleDate yukoKikanShuryoDate;
            if (date.getDayValue() == 1) {
                yukoKikanShuryoDate = date.plusMonth(yukoKikanTsukisu - 1);
            } else {
                yukoKikanShuryoDate = date.plusMonth(yukoKikanTsukisu);
            }
            return new FlexibleDate(yukoKikanShuryoDate.getYearMonth().toDateString()
                    + String.valueOf(yukoKikanShuryoDate.getLastDay()));
        }

        private YoKaigoJotaiKubun toYoKaigoJotaiKubun(RString rstr) {
            for (YoKaigoJotaiKubun kubun : YoKaigoJotaiKubun.values()) {
                if (kubun.name().equals(rstr.toString()) || kubun.getCode().equals(rstr)) {
                    return kubun;
                }
            }
            return YoKaigoJotaiKubun.非該当;
        }

        public void clear() {
            this.other.clear();
            this.service.clear();
            this._clear();
        }

        private void _clear() {
            div.getTxtNinteiYMD().clearValue();
            div.getTxtYokaigodo().clearValue();
            div.getTxtYokaigodoCode().clearValue();
            div.getTxtYukokikanTsukisu().clearValue();
            div.getTxtNinteiYukoKaishiYMD().clearValue();
            div.getTxtNinteiYukoShuryoYMD().clearValue();
        }

    }

    private static class NinteiResultOther {

        private final NinteiResultEtceteraDiv div;

        public NinteiResultOther(JukyushaShokaiDiv div) {
            this.div = div.getNinteiDetail().getNinteiResult().getNinteiResultEtcetera();
        }

        public void setDemoData(ControlGenerator cg) {
            div.getTxtShinsakaiIken().setValue(cg.getAsRString("審査会意見"));
            setTokuteiShippei(cg.getAsRString("特定疾病"));
            NinteiResultIdoDiv ido = div.getNinteiResultIdo();
            ido.getTxtNinteiResultIdoJiyu().setValue(cg.getAsRString("異動事由"));
            ido.getTxtNinteiResultIdoYMD().setValue(cg.getAsFlexibleDate("異動日"));
            ido.getTxtNinteiSoshitsuYMD().setValue(cg.getAsFlexibleDate("喪失日"));
            NinteiTorikeshiDiv torikeshi = div.getNinteiTorikeshi();
            torikeshi.getTxtNinteiTorikeshiRiyu().setValue(cg.getAsRString("取消理由"));
            torikeshi.getTxtTorikeshiYMD().setValue(cg.getAsFlexibleDate("取消日"));
        }

        private void setTokuteiShippei(RString tokuteiShippei) {
            boolean displayNone = RString.EMPTY.equals(tokuteiShippei);
            div.getTxtTokuteiShippei().setDisplayNone(displayNone);
            div.getLinTokuteiShippei().setDisplayNone(displayNone);
            div.getTxtTokuteiShippei().setValue(tokuteiShippei);
        }

        public void clear() {
            div.getTxtShinsakaiIken().clearValue();
            div.getTxtTokuteiShippei().clearValue();
            NinteiResultIdoDiv ido = div.getNinteiResultIdo();
            ido.getTxtNinteiResultIdoJiyu().clearValue();
            ido.getTxtNinteiResultIdoYMD().clearValue();
            ido.getTxtNinteiSoshitsuYMD().clearValue();
            NinteiTorikeshiDiv torikeshi = div.getNinteiTorikeshi();
            torikeshi.getTxtNinteiTorikeshiRiyu().clearValue();
            torikeshi.getTxtTorikeshiYMD().clearValue();
        }
    }

    private static class ShiteiServiceIchiran {

        private final ShiteiServiceIchiranDiv div;

        ShiteiServiceIchiran(JukyushaShokaiDiv div) {
            this.div = div.getNinteiDetail().getNinteiResult().getShiteiServiceIchiran();
        }

        public void setDemoData(ControlGenerator cg) {
            if (isEmpty(createTextBoxCodeFor指定サービス番号(cg, 1))) {
                div.setDisplayNone(true);
                return;
            }
            div.setDisplayNone(false);
            List<dgShiteiServiceShurui_Row> dataSource = new ArrayList<>();
            int i = 1;
            do {
                dataSource.add(new dgShiteiServiceShurui_Row(createTextBoxCodeFor指定サービス番号(cg, i), cg.getAsRString("指定サービス名称" + i)));
            } while (!isEmpty(createTextBoxCodeFor指定サービス番号(cg, ++i)));
            div.getDgShiteiServiceShurui().setDataSource(dataSource);
        }

        private boolean isEmpty(TextBoxCode txtBoxCode) {
            return RString.EMPTY.equals(txtBoxCode.getValue());
        }

        private TextBoxCode createTextBoxCodeFor指定サービス番号(ControlGenerator cg, int no) {
            return cg.getAsTextBoxCode("指定サービス番号" + no);
        }

        public void clear() {
            div.getDgShiteiServiceShurui().setDataSource(Collections.EMPTY_LIST);
        }
    }
    //</editor-fold>
}
