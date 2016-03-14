/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0310011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.DBC0300011TransitionEventName.事業者選択;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.DBC0310011TransitionEventName.契約者選択;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.PnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0310011.PnlTotalHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZU020001.DBZU020001TransitionEventName.対象者特定;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_検索
 */
public class PnlTotal {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 参照 = new RString("参照");

    /**
     * コンストラクタです。
     *
     * @param div PtnTotalDiv
     */
    private PnlTotalHandler getHandler(PnlTotalDiv div) {
        return PnlTotalHandler.of(div);
    }

    /**
     * onLoad事件
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onLoad(PnlTotalDiv div) {
        getHandler(div).set初期化状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 被保番号検索ボタン
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onClick_btnHihokensyaSearch(PnlTotalDiv div) {
        return ResponseData.of(div).forwardWithEventName(対象者特定).respond();
    }

    /**
     * 「被保番号」テキストボックス
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onBlur_txtHihokenshaNo(PnlTotalDiv div) {
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        RString 被保険者名 = ViewStateHolder.get(ViewStateKeys.被保険者名, RString.class);
        if (被保険者番号 != null) {
            if (被保険者番号.equals(div.getTxtHihokenshaNo().getValue())) {
                div.getTxtName().setValue(被保険者名);
            } else {
                div.getTxtName().clearValue();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 契約事業者検索ボタン
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onClick_btnJigyoshakeiyakuSearch(PnlTotalDiv div) {
        return ResponseData.of(div).forwardWithEventName(事業者選択).respond();
    }

    /**
     * 「契約事業者番号」テキストボックス
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onBlur_txtJigyoshakeiyakuNo(PnlTotalDiv div) {
        RString 契約事業者番号 = ViewStateHolder.get(ViewStateKeys.契約事業者番号, RString.class);
        RString 契約事業者名 = ViewStateHolder.get(ViewStateKeys.契約事業者名, RString.class);
        if (契約事業者番号 != null) {
            if (契約事業者番号.equals(div.getTxtJigyoshakeiyakuNo().getValue())) {
                div.getTxtJigyoshakeiyakuName().setValue(契約事業者名);
            } else {
                div.getTxtJigyoshakeiyakuName().clearValue();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタン
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onClick_btnClear(PnlTotalDiv div) {
        div.getTxtHihokenshaNo().clearValue();
        div.getTxtName().clearValue();
        div.getTxtShinseiYMDRange().clearFromValue();
        div.getTxtShinseiYMDRange().clearToValue();
        div.getTxtKetteYMDRange().clearFromValue();
        div.getTxtKetteYMDRange().clearToValue();
        div.getTxtJigyoshakeiyakuNo().clearValue();
        div.getTxtJigyoshakeiyakuName().clearValue();
        div.getDdlKeiyakuServiceShurui().setSelectedKey(RString.EMPTY);
        div.getTxtYear().clearDomain();
        div.getTxtKeiyakuNo().clearValue();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタン
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onClick_btnSearch(PnlTotalDiv div) {
        if (div.getTxtHihokenshaNo().getValue().isEmpty()
                && div.getTxtShinseiYMDRange().getFromValue() == null
                && div.getTxtShinseiYMDRange().getToValue() == null
                && div.getTxtKetteYMDRange().getFromValue() == null
                && div.getTxtKetteYMDRange().getToValue() == null
                && div.getTxtJigyoshakeiyakuNo().getValue().isEmpty()
                && div.getDdlKeiyakuServiceShurui().getSelectedKey().isEmpty()
                && div.getTxtYear().getDomain() == null
                && div.getTxtKeiyakuNo().getValue().isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrWarningMessages.未入力.getMessage()
                        .replace("検索条件の項目いずれも")).respond();
            }
            return ResponseData.of(div).respond();
        }
        List<ShokanJuryoininKeiyakusha> shokanList = getHandler(div).get契約者一覧();
        if (shokanList == null || shokanList.isEmpty()) {
            return ResponseData.of(div).respond();
        }
        int maxCount = div.getPnlSearch().getTxtMaxCount().getValue().intValue();

        if (shokanList.size() > maxCount) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzQuestionMessages.最大表示件数超過確認.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).initializeGrid(shokanList);
            }
        } else {
            getHandler(div).initializeGrid(shokanList);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * グレードの選択ボタン
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onClick_btnSelect(PnlTotalDiv div) {
        getHandler(div).putViewStateHolder(参照);
        return ResponseData.of(div).forwardWithEventName(契約者選択).respond();
    }

    /**
     * グレードの修正ボタン
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onClick_btnModify(PnlTotalDiv div) {
        getHandler(div).putViewStateHolder(修正);
        return ResponseData.of(div).forwardWithEventName(契約者選択).respond();
    }

    /**
     * グレードの削除ボタン
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onClick_btnDelete(PnlTotalDiv div) {
        getHandler(div).putViewStateHolder(削除);
        return ResponseData.of(div).forwardWithEventName(契約者選択).respond();
    }

    /**
     * 「再検索する」ボタン
     *
     * @param div PnlTotalDiv
     * @return ResponseData<PnlTotalDiv>
     */
    public ResponseData<PnlTotalDiv> onClick_btnSearchAgain(PnlTotalDiv div) {
        div.getPnlKeiyakusyaList().getDgKeyakusya().getDataSource().clear();
        div.getPnlSearch().setDisplayNone(false);
        div.getPnlKeiyakusyaList().setDisplayNone(true);
        div.getBtnSearchAgain().setDisabled(true);
        return ResponseData.of(div).respond();
    }
}
