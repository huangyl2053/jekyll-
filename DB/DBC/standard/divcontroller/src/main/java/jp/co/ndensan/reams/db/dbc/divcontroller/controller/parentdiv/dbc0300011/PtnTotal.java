package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0300011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.juryoininkeiyakujigyosha.JuryoininKeiyakuJigyoshaParameter;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.DBC0300011TransitionEventName.事業者選択;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.PtnTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0300011.PtnTotalHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約事業者登録・追加・修正・照会_検索
 */
public class PtnTotal {

    /**
     * 初期表示
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onLoad(PtnTotalDiv div) {
        ResponseData<PtnTotalDiv> responseData = new ResponseData<>();
        PtnTotalHandler handler = getHandler(div);
        JuryoininKeiyakuJigyoshaParameter searchKey = ViewStateHolder
                .get(ViewStateKeys.受領委任契約事業者検索キー, JuryoininKeiyakuJigyoshaParameter.class);
        if (searchKey == null) {
            handler.set初期化状態(true);
            responseData.data = div;
            return responseData;
        }

        handler.set初期化状態(false);
        if (searchKey.isSelectedBango()) {
            handler.click契約事業者番号();
            div.getPnlCondition().getRdoBango().setSelectedKey(new RString("1"));
            div.getPnlCondition().getTxtJigyosyakeyakuNo()
                    .setValue(new Decimal(searchKey.getKeiyakuJigyoshaNo().toString()));
        }
        if (searchKey.isSelectedName()) {
            handler.click契約事業者名称();
            div.getPnlCondition().getRdoMeisyo().setSelectedKey(new RString("2"));
            if (searchKey.getKeiyakuJigyoshaKanaName() != null) {
                div.getPnlCondition().getTxtMeisyoKana().setValue(searchKey.getKeiyakuJigyoshaKanaName().value());
            }
            List<RString> list = new ArrayList<>();
            list.add(new RString("1"));
            if (searchKey.isSameKanaName()) {
                div.getPnlCondition().getChkJyusyoKanji().setSelectedItemsByKey(list);
            }
            if (searchKey.getKeiyakuJigyoshaName() != null) {
                div.getPnlCondition().getTxtMeisyoKanji().setValue(searchKey.getKeiyakuJigyoshaName().value());
            }
            if (searchKey.isSameJigyoshaName()) {
                div.getPnlCondition().getChkMeisyoKanji().setSelectedItemsByKey(list);
            }
            if (searchKey.getKeiyakuShurui() != null) {
                div.getPnlCondition().getDdlKeiyakuSyurui().setSelectedKey(searchKey.getKeiyakuShurui());
            }
        }
        if (searchKey.isSelectedJusho()) {
            handler.click契約事業者住所();
            div.getPnlCondition().getRdoJyusyo().setSelectedKey(new RString("3"));
            if (searchKey.getKeiyakuJigyoshaYubinNo() != null) {
                div.getPnlCondition().getTxtYubin().setValue(searchKey.getKeiyakuJigyoshaYubinNo());
            }
            List<RString> list = new ArrayList<>();
            list.add(new RString("1"));
            if (searchKey.getKeiyakuJigyoshaJusho() != null) {
                div.getPnlCondition().getTxtJyusyoKanji().setValue(searchKey.getKeiyakuJigyoshaJusho().value());
            }
            if (searchKey.isSameJusho()) {
                div.getPnlCondition().getChkJyusyoKanji().setSelectedItemsByKey(list);
            }
        }
        handler.click検索();
        responseData.data = div;
        return responseData;
    }

    /**
     * 契約事業者番号検索
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_rdoBango(PtnTotalDiv div) {
        ResponseData<PtnTotalDiv> responseData = new ResponseData<>();
        PtnTotalHandler handler = getHandler(div);
        handler.click契約事業者番号();

        responseData.data = div;
        return responseData;
    }

    /**
     * 契約事業者名称検索
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_rdoMeisyo(PtnTotalDiv div) {
        ResponseData<PtnTotalDiv> responseData = new ResponseData<>();
        PtnTotalHandler handler = getHandler(div);
        handler.click契約事業者名称();

        responseData.data = div;
        return responseData;
    }

    /**
     * 契約事業者住所検索
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_rdoJyusyo(PtnTotalDiv div) {
        ResponseData<PtnTotalDiv> responseData = new ResponseData<>();
        PtnTotalHandler handler = getHandler(div);
        handler.click契約事業者住所();

        responseData.data = div;
        return responseData;
    }

    /**
     * 「条件をクリアする」ボタン
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_btnClear(PtnTotalDiv div) {
        ResponseData<PtnTotalDiv> responseData = new ResponseData<>();
        PtnTotalHandler handler = getHandler(div);
        handler.set初期化状態(true);

        responseData.data = div;
        return responseData;
    }

    /**
     * 「検索する」ボタン
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_btnSearch(PtnTotalDiv div) {
        if (new RString("1").equals(div.getPnlCondition().getRdoBango().getSelectedKey())) {
            if (div.getPnlCondition().getTxtJigyosyakeyakuNo().getValue() == null) {
                throw new ApplicationException(UrWarningMessages.未入力.getMessage().replace("契約事業者番号"));
            }
        } else if (new RString("2").equals(div.getPnlCondition().getRdoMeisyo().getSelectedKey())) {
            if (div.getPnlCondition().getTxtMeisyoKana().getValue().isNullOrEmpty()
                    && div.getPnlCondition().getTxtMeisyoKanji().getValue().isNullOrEmpty()
                    && div.getPnlCondition().getDdlKeiyakuSyurui().getSelectedKey().isNullOrEmpty()) {
                throw new ApplicationException(UrWarningMessages.未入力.getMessage().replace("カナ名称、漢字名称、契約種類"));
            }
        } else {
            if (div.getPnlCondition().getTxtYubin().getValue().isEmpty()
                    && div.getPnlCondition().getTxtJyusyoKanji().getValue().isNullOrEmpty()) {
                throw new ApplicationException(UrWarningMessages.未入力.getMessage().replace("郵便番号、漢字名称（住所）"));
            }
        }

        ResponseData<PtnTotalDiv> responseData = new ResponseData<>();
        PtnTotalHandler handler = getHandler(div);
        handler.click検索();

        responseData.data = div;
        return responseData;
    }

    /**
     * 選択ボタン
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_selectButton(PtnTotalDiv div) {
        PtnTotalHandler handler = getHandler(div);
        handler.setSelectedRow();
        ViewStateHolder.put(ViewStateKeys.処理モード, new RString("参照"));
        return ResponseData.of(div).forwardWithEventName(事業者選択).respond();
    }

    /**
     * 修正ボタン
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_modifyButton(PtnTotalDiv div) {
        PtnTotalHandler handler = getHandler(div);
        handler.setSelectedRow();
        ViewStateHolder.put(ViewStateKeys.処理モード, new RString("修正"));
        return ResponseData.of(div).forwardWithEventName(事業者選択).respond();
    }

    /**
     * 削除ボタン
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_deleteButton(PtnTotalDiv div) {
        PtnTotalHandler handler = getHandler(div);
        handler.setSelectedRow();
        ViewStateHolder.put(ViewStateKeys.処理モード, new RString("削除"));
        return ResponseData.of(div).forwardWithEventName(事業者選択).respond();
    }

    /**
     * 「再検索する」ボタン
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_btnSearchAgain(PtnTotalDiv div) {
        ResponseData<PtnTotalDiv> responseData = new ResponseData<>();
        PtnTotalHandler handler = getHandler(div);
        handler.click再検索();

        responseData.data = div;
        return responseData;
    }

    /**
     * Handlerクラスの取得
     *
     * @param div PtnTotalDiv
     * @return PtnTotalHandler
     */
    private PtnTotalHandler getHandler(PtnTotalDiv div) {
        return PtnTotalHandler.of(div);
    }
}
