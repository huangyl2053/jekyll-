/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ChosaItakusakiAndChosainGuide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjoho;
import jp.co.ndensan.reams.db.dbz.business.core.inkijuntsukishichosonjoho.KijuntsukiShichosonjohoiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ikninteichosaitakusakijoho.ChosaItakusakiAndChosainGuideParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideDiv.TaishoMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuideValidationHandler;
import jp.co.ndensan.reams.db.dbz.service.core.iknijuntsukishichosonjoho.KijuntsukiShichosonjohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 調査委託先＆調査員ガイドのクラス。
 *
 * @reamsid_L DBZ-1300-020 wanghui
 */
public class ChosaItakusakiAndChosainGuide {

    private final KijuntsukiShichosonjohoFinder finder;
    private RString 市町村コード;
    private RString 調査委託先コードFrom = RString.EMPTY;
    private RString 調査委託先コードTo = RString.EMPTY;
    private RString 調査員コードFrom = RString.EMPTY;
    private RString 調査員コードTo = RString.EMPTY;
    private static final RString 状況フラグ無効可 = new RString("状況フラグ無効可");

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
     * @return ResponseData<ChosaItakusakiAndChosainGuideDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainGuideDiv> onLoad(ChosaItakusakiAndChosainGuideDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        div.getHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        getHandler(div).intialize();

        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        if (dataPassModel != null) {
            div.getHokensha().setSelectedShichosonIfExist(new LasdecCode(dataPassModel.get市町村コード()));
            div.getTxtChosaItakusakiCodeFrom().setValue(RString.EMPTY);
            div.getTxtChosaItakuaskiCodeTo().setValue(RString.EMPTY);
            div.getTxtChosaItakusakiName().setValue(RString.EMPTY);
            if (dataPassModel.get対象モード().equals(new RString(TaishoMode.Chosain.name()))) {
                div.getTxtChosaItakusakiCodeFrom().setValue(dataPassModel.get委託先コード() != null ? dataPassModel.get委託先コード() : RString.EMPTY);
                div.getTxtChosaItakuaskiCodeTo().setValue(dataPassModel.get委託先コード() != null ? dataPassModel.get委託先コード() : RString.EMPTY);
                div.getTxtChosaItakusakiName().setValue(dataPassModel.get委託先名() != null ? dataPassModel.get委託先名() : RString.EMPTY);
            }
            if (!RString.isNullOrEmpty(div.getHdnCanJokyoMuko())) {
                if (状況フラグ無効可.equals(div.getHdnCanJokyoMuko())) {
                    div.getRadItakusakiJokyo().setDisabled(false);
                    div.getRadChosainJokyo().setDisabled(false);
                }
            }

            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForMaxKensu();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            search認定調査委託先and調査員(div, dataPassModel);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<ChosaItakusakiAndChosainGuideDiv> search認定調査委託先and調査員(ChosaItakusakiAndChosainGuideDiv div, KijuntsukiShichosonjohoiDataPassModel dataPassModel) {
        List<KijuntsukiShichosonjoho> list = new ArrayList<>();
        if (dataPassModel.get対象モード().toString().equals(TaishoMode.Itakusaki.name())) {
            list = finder.getChosaItakusaki(createParam(div)).records();
        }
        if (dataPassModel.get対象モード().toString().equals(TaishoMode.Chosain.name())) {
            list = finder.getKojinJokyoShokai(createParam(div)).records();
        }
        if (!list.isEmpty()) {
            getHandler(div).setDataGrid(list, dataPassModel.get対象モード());
        } else {
            div.getDgKensakuKekkaIchiran().clearSource();
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先＆調査員ガイドの検索。<br/>
     *
     * @param div ChosaItakusakiAndChosainGuideDiv
     * @return ResponseData<ChosaItakusakiAndChosainGuideDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainGuideDiv> onClick_btnKensaku(ChosaItakusakiAndChosainGuideDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForMaxKensu();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        KijuntsukiShichosonjohoiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), KijuntsukiShichosonjohoiDataPassModel.class);
        if (dataPassModel != null) {
            search認定調査委託先and調査員(div, dataPassModel);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調査委託先＆調査員ガイドの検索条件をクリアする。<br/>
     *
     * @param div ChosaItakusakiAndChosainGuideDiv
     * @return ResponseData<ChosaItakusakiAndChosainGuideDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainGuideDiv> onClick_btnClear(ChosaItakusakiAndChosainGuideDiv div) {
        getHandler(div).検索条件クリア();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果一覧にて、選択ボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<ChosaItakusakiAndChosainGuideDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainGuideDiv> onSelect(ChosaItakusakiAndChosainGuideDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForSelectbtn();
        if (validPairs.iterator().hasNext()) {
            div.getDgKensakuKekkaIchiran().setReadOnly(true);
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onSelectbtn();
        return ResponseData.of(div).dialogOKClose();
    }

    private ChosaItakusakiAndChosainGuideHandler getHandler(ChosaItakusakiAndChosainGuideDiv div) {
        return new ChosaItakusakiAndChosainGuideHandler(div);
    }

    private ChosaItakusakiAndChosainGuideParameter createParam(ChosaItakusakiAndChosainGuideDiv div) {
        if (!RString.isNullOrEmpty(div.getTxtChosaItakusakiCodeFrom().getText())
                && !RString.isNullOrEmpty(div.getTxtChosaItakuaskiCodeTo().getText())) {
            if (Long.valueOf(div.getTxtChosaItakusakiCodeFrom().getText().toString())
                    > Long.valueOf(div.getTxtChosaItakuaskiCodeTo().getText().toString())) {
                調査委託先コードFrom = div.getTxtChosaItakuaskiCodeTo().getText();
                調査委託先コードTo = div.getTxtChosaItakusakiCodeFrom().getText();
            } else {
                調査委託先コードFrom = div.getTxtChosaItakusakiCodeFrom().getText();
                調査委託先コードTo = div.getTxtChosaItakuaskiCodeTo().getText();
            }
        } else {
            調査委託先コードFrom = div.getTxtChosaItakusakiCodeFrom().getText();
            調査委託先コードTo = div.getTxtChosaItakuaskiCodeTo().getText();
        }
        if (!RString.isNullOrEmpty(div.getTxtChosainCodeFrom().getText())
                && !RString.isNullOrEmpty(div.getTxtChosainCodeTo().getText())) {
            if (Long.valueOf(div.getTxtChosainCodeFrom().getText().toString())
                    > Long.valueOf(div.getTxtChosainCodeTo().getText().toString())) {
                調査員コードFrom = div.getTxtChosainCodeTo().getText();
                調査員コードTo = div.getTxtChosainCodeFrom().getText();
            } else {
                調査員コードFrom = div.getTxtChosainCodeFrom().getText();
                調査員コードTo = div.getTxtChosainCodeTo().getText();
            }
        } else {
            調査員コードFrom = div.getTxtChosainCodeFrom().getText();
            調査員コードTo = div.getTxtChosainCodeTo().getText();
        }
        市町村コード = div.getHokensha().getSelectedItem().get市町村コード().value();
        return ChosaItakusakiAndChosainGuideParameter.createParam(
                調査委託先コードFrom,
                調査委託先コードTo,
                div.getRadItakusakiJokyo().getSelectedKey(),
                div.getTxtChosaItakusakiName().getValue(),
                div.getTxtChosaItakusakiKanaMeisho().getValue(),
                調査員コードFrom,
                調査員コードTo,
                div.getRadChosainJokyo().getSelectedKey(),
                div.getTxtChosainName().getValue(),
                div.getTxtChosainKanaShimei().getValue(),
                null,
                市町村コード,
                ControlDataHolder.getSubGyomuCD().value(),
                div.getTxtChikuCode().getDomain().value(),
                div.getDdlChosaItakusakiKubun().getSelectedKey());
    }

    private ChosaItakusakiAndChosainGuideValidationHandler getValidationHandler(ChosaItakusakiAndChosainGuideDiv div) {
        return new ChosaItakusakiAndChosainGuideValidationHandler(div);
    }

    /**
     * 調査委託先＆調査員ガイド戻るのボタンを押下します。<br/>
     *
     * @param div ChosaItakusakiAndChosainGuideDiv
     * @return ResponseData<ChosaItakusakiAndChosainGuideDiv>
     */
    public ResponseData<ChosaItakusakiAndChosainGuideDiv> onClick_btnModoru(ChosaItakusakiAndChosainGuideDiv div) {
        return ResponseData.of(div).dialogOKClose();

    }
}
