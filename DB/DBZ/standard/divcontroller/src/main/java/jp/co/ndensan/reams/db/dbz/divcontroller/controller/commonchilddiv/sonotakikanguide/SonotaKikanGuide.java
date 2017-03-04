/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.sonotakikanguide;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuide;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuideModel;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.sonotakikanguide.SoNoTaKikanGuideParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.sonotakikanguide.SonotaKikanGuide.SoNoTaKikanGuideHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.sonotakikanguide.SonotaKikanGuide.SonotaKikanGuideDiv;
import jp.co.ndensan.reams.db.dbz.service.core.sonotakikanguide.SoNoTaKikanGuideFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * その他機関選択ガイドのクラスです。
 *
 * @reamsid_L DBE-3000-050 wangkun
 */
public class SonotaKikanGuide {

    private static final RString 有効 = new RString("key0");
    private static final RString 無効 = new RString("key1");
    private final SoNoTaKikanGuideFinder service;

    /**
     * コンストラクタです。
     */
    public SonotaKikanGuide() {
        service = SoNoTaKikanGuideFinder.createInstance();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<SonotaKikanGuideDiv>
     */
    public ResponseData<SonotaKikanGuideDiv> onLoad(SonotaKikanGuideDiv div) {
        getHandler(div).load();
        onClick_Kensaku(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<SonotaKikanGuideDiv>
     */
    public ResponseData<SonotaKikanGuideDiv> onClick_Kensaku(SonotaKikanGuideDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs validPairs = getHandler(div).大小関係チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        boolean 状況フラグ = false;
        if (有効.equals(div.getRadHaisi().getSelectedKey())) {
            状況フラグ = false;
        } else if (無効.equals(div.getRadHaisi().getSelectedKey())) {
            状況フラグ = true;
        }
        List<SoNoTaKikanGuide> businessList = service.getKoseiShichoson(SoNoTaKikanGuideParameter
                .createその他機関情報の取得キー作成(div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value(),
                        div.getTxtSonotaKikanCodefrom().getValue(),
                        div.getTxtSonotaKikanCodeto().getValue(), 状況フラグ,
                        div.getTxtSonotaKikanName().getValue(),
                        div.getDdlChosaItakusakiKubun().getSelectedKey(),
                        div.getTxtMaxDisp().getValue().toBigInteger().intValue())).records();

        if (businessList.isEmpty()) {
            div.getDgSonotaKikanIchiran().clearSource();
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        validPairs = getHandler(div).その他機関一覧データなしチェック(businessList);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).set一覧データ(businessList);
        return ResponseData.of(div).respond();
    }

    /**
     * 条件をクリアするボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<SonotaKikanGuideDiv>
     */
    public ResponseData<SonotaKikanGuideDiv> onClick_Clear(SonotaKikanGuideDiv div) {
        getHandler(div).clear();
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索ボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<SonotaKikanGuideDiv>
     */
    public ResponseData<SonotaKikanGuideDiv> onClick_SaiKenSaKu(SonotaKikanGuideDiv div) {
        getHandler(div).load();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<SonotaKikanGuideDiv>
     */
    public ResponseData<SonotaKikanGuideDiv> onClick_Select(SonotaKikanGuideDiv div) {
        SoNoTaKikanGuideModel model = new SoNoTaKikanGuideModel();
        model.setその他機関コード(nullToEmpty(div.getDgSonotaKikanIchiran().getActiveRow().getSonotakikancode()));
        model.setその他機関名称(nullToEmpty(div.getDgSonotaKikanIchiran().getActiveRow().getSonotakikanname()));

        ViewStateHolder.put(ViewStateKeys.その他機関選択ガイド_モード, model);
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<SonotaKikanGuideDiv>
     */
    public ResponseData<SonotaKikanGuideDiv> onClick_Moderu(SonotaKikanGuideDiv div) {
        return ResponseData.of(div).respond();
    }

    private SoNoTaKikanGuideHandler getHandler(SonotaKikanGuideDiv div) {
        return new SoNoTaKikanGuideHandler(div);
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
