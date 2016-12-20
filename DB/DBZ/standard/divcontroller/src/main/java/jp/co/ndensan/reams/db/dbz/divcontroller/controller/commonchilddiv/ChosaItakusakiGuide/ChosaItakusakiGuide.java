/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ChosaItakusakiGuide;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjoho;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ikninteichosaitakusakijoho.ChosaItakusakiAndChosainGuideParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiGuide.ChosaItakusakiGuide.ChosaItakusakiGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiGuide.ChosaItakusakiGuide.ChosaItakusakiGuideHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiGuide.ChosaItakusakiGuide.ChosaItakusakiGuideValidationHandler;
import jp.co.ndensan.reams.db.dbz.service.core.iknijuntsukishichosonjoho.KijuntsukiShichosonjohoFinder;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 調査委託先ガイドのクラス。
 *
 * @reamsid_L DBZ-1300-020 wanghui
 */
public class ChosaItakusakiGuide {

    private RString 市町村コード;

    /**
     * 調査委託先ガイドの初期化。<br/>
     *
     * @param div ChosaItakusakiGuideDiv
     * @return ResponseData<ChosaItakusakiGuideDiv>
     */
    public ResponseData<ChosaItakusakiGuideDiv> onLoad(ChosaItakusakiGuideDiv div) {
        div.getHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        ChosaItakusakiGuideHandler handler = getHandler(div);
        handler.intialize();
        handler.setDataGrid(searchChosaItakusaki(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先ガイドの検索。<br/>
     *
     * @param div ChosaItakusakiGuideDiv
     * @return ResponseData<ChosaItakusakiGuideDiv>
     */
    public ResponseData<ChosaItakusakiGuideDiv> onClick_btnKensaku(ChosaItakusakiGuideDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForMaxKensu();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).setDataGrid(searchChosaItakusaki(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先ガイドの検索条件をクリアする。<br/>
     *
     * @param div ChosaItakusakiGuideDiv
     * @return ResponseData<ChosaItakusakiGuideDiv>
     */
    public ResponseData<ChosaItakusakiGuideDiv> onClick_btnClear(ChosaItakusakiGuideDiv div) {
        getHandler(div).検索条件クリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果一覧にて、選択ボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<ChosaItakusakiGuideDiv>
     */
    public ResponseData<ChosaItakusakiGuideDiv> onSelect(ChosaItakusakiGuideDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForSelectbtn();
        if (validPairs.iterator().hasNext()) {
            div.getDgKensakuKekkaIchiran().setReadOnly(true);
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onSelectbtn();
        return ResponseData.of(div).dialogOKClose();
    }

    private ChosaItakusakiGuideHandler getHandler(ChosaItakusakiGuideDiv div) {
        return new ChosaItakusakiGuideHandler(div);
    }

    private List<KijuntsukiShichosonjoho> searchChosaItakusaki(ChosaItakusakiGuideDiv div) {
        KijuntsukiShichosonjohoFinder finder = KijuntsukiShichosonjohoFinder.createInstance();
        List<KijuntsukiShichosonjoho> list = finder.getChosaItakusaki(createParam(div)).records();
        return list;
    }

    private ChosaItakusakiAndChosainGuideParameter createParam(ChosaItakusakiGuideDiv div) {
        市町村コード = div.getHokensha().getSelectedItem().get市町村コード().value();
        return ChosaItakusakiAndChosainGuideParameter.createParam(
                div.getTxtChosaItakusakiCodeFrom().getValue(),
                div.getTxtChosaItakuaskiCodeTo().getValue(),
                div.getRadItakusakiJokyo().getSelectedKey(),
                div.getTxtChosaItakusakiName().getValue(),
                div.getTxtChosaItakusakiKanaMeisho().getValue(),
                //                div.getTxtChosainCodeFrom().getValue(),
                //                div.getTxtChosainCodeTo().getValue(),
                //                div.getRadChosainJokyo().getSelectedKey(),
                //                div.getTxtChosainName().getValue(),
                //                div.getTxtChosainKanaShimei().getValue(),
                new RString(""),
                new RString(""),
                new RString(""),
                new RString(""),
                new RString(""),
                div.getTxtMaxKensu().getValue(),
                市町村コード,
                ControlDataHolder.getSubGyomuCD().value(),
                div.getTxtChikuCode().getDomain().value(),
                div.getDdlChosaItakusakiKubun().getSelectedKey());
    }

    private ChosaItakusakiGuideValidationHandler getValidationHandler(ChosaItakusakiGuideDiv div) {
        return new ChosaItakusakiGuideValidationHandler(div);
    }

    /**
     * 調査委託先ガイド戻るのボタンを押下します。<br/>
     *
     * @param div ChosaItakusakiGuideDiv
     * @return ResponseData<ChosaItakusakiGuideDiv>
     */
    public ResponseData<ChosaItakusakiGuideDiv> onClick_btnModoru(ChosaItakusakiGuideDiv div) {
        return ResponseData.of(div).dialogOKClose();

    }
}
