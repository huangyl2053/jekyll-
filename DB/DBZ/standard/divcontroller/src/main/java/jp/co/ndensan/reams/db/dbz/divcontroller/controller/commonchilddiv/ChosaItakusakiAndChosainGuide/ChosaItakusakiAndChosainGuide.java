/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ChosaItakusakiAndChosainGuide;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjoho;
import jp.co.ndensan.reams.db.dbz.definition.param.ikninteichosaitakusakijoho.INinteichosaItakusakiJohoParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.cihosaitakusakiandchosainguide.ChosaItakusakiAndChosainGuideHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.cihosaitakusakiandchosainguide.ChosaItakusakiAndChosainGuideValidationHandler;
import jp.co.ndensan.reams.db.dbz.service.core.iknijuntsukishichosonjoho.KijuntsukiShichosonjohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 調査委託先＆調査員ガイドのクラス。
 */
public class ChosaItakusakiAndChosainGuide {

    //private static final RString 状況フラグ_有効 = new RString("有効");
    private final KijuntsukiShichosonjohoFinder finder;

    /**
     * コンストラクタです。
     */
    public ChosaItakusakiAndChosainGuide() {
        finder = KijuntsukiShichosonjohoFinder.createInstance();
    }

    /**
     * 調査委託先＆調査員ガイドの初期化。<br/>
     *
     * @param div ChosaItakusakiAndChosainGuideDiv
     * @return ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainGuideDiv> onLoad(ChosaItakusakiAndChosainGuideDiv div) {
        getHandler(div).intialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先＆調査員ガイドの検索。<br/>
     *
     * @param div ChosaItakusakiAndChosainGuideDiv
     * @return ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainGuideDiv> onClick_btnKensaku(ChosaItakusakiAndChosainGuideDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForMaxKensu();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        List<KijuntsukiShichosonjoho> list = finder.getKojinJokyoShokai(INinteichosaItakusakiJohoParameter.createParam(
                div.getTxtChosaItakusakiCodeFrom().getValue(),
                div.getTxtChosaItakuaskiCodeTo().getValue(),
                div.getRadItakusakiJokyo().getSelectedKey(),
                div.getTxtChosaItakusakiName().getValue(),
                div.getTxtChosaItakusakiKanaMeisho().getValue(),
                div.getTxtChosainCodeFrom().getValue(),
                div.getTxtChosainCodeTo().getValue(),
                div.getRadChosainJokyo().getSelectedKey(),
                div.getTxtChosainName().getValue(),
                div.getTxtChosainKanaShimei().getValue(),
                div.getTxtMaxKensu().getValue(),
                div.getTxtHokensha().getValue(),
                SubGyomuCode.DBD介護受給.value().equals(div.getHdnDatabaseSubGyomuCode()))).records();
        getHandler(div).setDataGrid(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先＆調査員ガイドの検索条件をクリアする。<br/>
     *
     * @param div ChosaItakusakiAndChosainGuideDiv
     * @return ResponseData<JigyoshaNyuryokuGudieCommonChildDivDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainGuideDiv> onClick_btnClear(ChosaItakusakiAndChosainGuideDiv div) {
        getHandler(div).検索条件クリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果一覧にて、選択ボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanAndShujiiGuideDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainGuideDiv> onSelect(ChosaItakusakiAndChosainGuideDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForSelectbtn();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).setModes();
        getHandler(div).onSelectbtn();
        return ResponseData.of(div).respond();
    }

    private ChosaItakusakiAndChosainGuideHandler getHandler(ChosaItakusakiAndChosainGuideDiv div) {
        return new ChosaItakusakiAndChosainGuideHandler(div);
    }

    private ChosaItakusakiAndChosainGuideValidationHandler getValidationHandler(ChosaItakusakiAndChosainGuideDiv div) {
        return new ChosaItakusakiAndChosainGuideValidationHandler(div);
    }
}
