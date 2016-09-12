package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0300011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.juryoininkeiyakujigyosha.JuryoininKeiyakuJigyoshaParameter;
import static jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.DBC0300011TransitionEventName.事業者選択;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.PtnTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.dgKeiyakuJigyosya_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0300011.PtnTotalHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JuryoininKeiyakuJigyoshaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約事業者登録・追加・修正・照会_検索
 *
 * @reamsid_L DBC-2120-010 panhe
 */
public class PtnTotal {

    private static final RString 参照 = new RString("参照");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString KEY_1 = new RString("1");
    private static final RString KEY_2 = new RString("2");
    private static final RString KEY_3 = new RString("3");
    private static final RString 追加メッセージ1 = new RString("契約事業者番号");
    private static final RString 追加メッセージ2 = new RString("カナ名称、漢字名称、契約種類");
    private static final RString 追加メッセージ3 = new RString("郵便番号、漢字名称（住所）");

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
                .get(ViewStateKeys.検索キー, JuryoininKeiyakuJigyoshaParameter.class);
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        Decimal 最大取得件数 = ViewStateHolder
                .get(ViewStateKeys.最大件数, Decimal.class);
        if (searchKey == null) {
            handler.set初期化状態(true, 状態, 最大取得件数);
            responseData.data = div;
            return responseData;
        }

        handler.set初期化状態(false, 状態, 最大取得件数);
        if (searchKey.isSelectedBango()) {
            handler.click契約事業者番号();
            div.getPnlCondition().getRdoBango().setSelectedKey(KEY_1);
            div.getPnlCondition().getTxtJigyosyakeyakuNo()
                    .setValue(searchKey.getKeiyakuJigyoshaNo());
        }
        if (searchKey.isSelectedName()) {
            handler.click契約事業者名称();
            div.getPnlCondition().getRdoMeisyo().setSelectedKey(KEY_2);
            if (searchKey.getKeiyakuJigyoshaKanaName() != null) {
                div.getPnlCondition().getTxtMeisyoKana().setValue(searchKey.getKeiyakuJigyoshaKanaName().value());
            }
            List<RString> list = new ArrayList<>();
            list.add(KEY_1);
            if (searchKey.isSameKanaName()) {
                div.getPnlCondition().getChkMeisyoKana().setSelectedItemsByKey(list);
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
            div.getPnlCondition().getRdoJyusyo().setSelectedKey(KEY_3);
            if (searchKey.getKeiyakuJigyoshaYubinNo() != null) {
                div.getPnlCondition().getTxtYubin().setValue(searchKey.getKeiyakuJigyoshaYubinNo());
            }
            List<RString> list = new ArrayList<>();
            list.add(KEY_1);
            if (searchKey.getKeiyakuJigyoshaJusho() != null) {
                div.getPnlCondition().getTxtJyusyoKanji().setValue(searchKey.getKeiyakuJigyoshaJusho().value());
            }
            if (searchKey.isSameJusho()) {
                div.getPnlCondition().getChkJyusyoKanji().setSelectedItemsByKey(list);
            }
        }
        click検索(div);
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
        RString 状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        Decimal 最大取得件数 = ViewStateHolder
                .get(ViewStateKeys.最大件数, Decimal.class);
        handler.set初期化状態(true, 状態, 最大取得件数);

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
        if (KEY_1.equals(div.getPnlCondition().getRdoBango().getSelectedKey())) {
            if (div.getPnlCondition().getTxtJigyosyakeyakuNo().getValue() == null) {
                throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage()
                        .replace(追加メッセージ1.toString()));
            }
        } else if (KEY_2.equals(div.getPnlCondition().getRdoMeisyo().getSelectedKey())) {
            if (div.getPnlCondition().getTxtMeisyoKana().getValue().isNullOrEmpty()
                    && div.getPnlCondition().getTxtMeisyoKanji().getValue().isNullOrEmpty()
                    && div.getPnlCondition().getDdlKeiyakuSyurui().getSelectedKey().isNullOrEmpty()) {
                throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage()
                        .replace(追加メッセージ2.toString()));
            }
        } else {
            if (div.getPnlCondition().getTxtYubin().getValue().isEmpty()
                    && div.getPnlCondition().getTxtJyusyoKanji().getValue().isNullOrEmpty()) {
                throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage()
                        .replace(追加メッセージ3.toString()));
            }
        }

        ResponseData<PtnTotalDiv> responseData = new ResponseData<>();
        click検索(div);

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
        setSelectedRow(div);
        ViewStateHolder.put(ViewStateKeys.処理モード, 参照);
        return ResponseData.of(div).forwardWithEventName(事業者選択).respond();
    }

    /**
     * 修正ボタン
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_modifyButton(PtnTotalDiv div) {
        setSelectedRow(div);
        ViewStateHolder.put(ViewStateKeys.処理モード, 修正);
        return ResponseData.of(div).forwardWithEventName(事業者選択).respond();
    }

    /**
     * 削除ボタン
     *
     * @param div PtnTotalDiv
     * @return ResponseData
     */
    public ResponseData<PtnTotalDiv> onClick_deleteButton(PtnTotalDiv div) {
        setSelectedRow(div);
        ViewStateHolder.put(ViewStateKeys.処理モード, 削除);
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

    private void click検索(PtnTotalDiv div) {
        div.getPnlCondition().setDisplayNone(true);
        div.getPnlData().setDisplayNone(false);
        div.getPnlData().getBtnSearchAgain().setDisabled(false);

        boolean selectedBango = false;
        boolean selectedName = false;
        boolean selectedJusho = false;
        RString keiyakuJigyoshaNo = null;
        AtenaKanaMeisho keiyakuJigyoshaKanaName = null;
        boolean sameKanaName = false;
        AtenaMeisho keiyakuJigyoshaName = null;
        boolean sameJigyoshaName = false;
        RString keiyakuShurui = null;
        YubinNo keiyakuJigyoshaYubinNo = null;
        AtenaJusho keiyakuJigyoshaJusho = null;
        boolean sameJusho = false;

        if (KEY_1.equals(div.getPnlCondition().getRdoBango().getSelectedKey())) {
            selectedBango = true;
            keiyakuJigyoshaNo = new RString(div.getPnlCondition().getTxtJigyosyakeyakuNo().getValue().toString());
        } else if (KEY_2.equals(div.getPnlCondition().getRdoMeisyo().getSelectedKey())) {
            selectedName = true;
            if (!div.getPnlCondition().getTxtMeisyoKana().getValue().isNullOrEmpty()) {
                keiyakuJigyoshaKanaName = new AtenaKanaMeisho(div.getPnlCondition().getTxtMeisyoKana().getValue());
            }
            if (div.getPnlCondition().getChkMeisyoKana().isAllSelected()) {
                sameKanaName = true;
            }
            if (!div.getPnlCondition().getTxtMeisyoKanji().getValue().isNullOrEmpty()) {
                keiyakuJigyoshaName = new AtenaMeisho(div.getPnlCondition().getTxtMeisyoKanji().getValue());
            }
            if (div.getPnlCondition().getChkMeisyoKanji().isAllSelected()) {
                sameJigyoshaName = true;
            }
            if (!RString.EMPTY.equals(div.getPnlCondition().getDdlKeiyakuSyurui().getSelectedKey())) {
                keiyakuShurui = div.getPnlCondition().getDdlKeiyakuSyurui().getSelectedKey();
            }
        } else if (KEY_3.equals(div.getPnlCondition().getRdoJyusyo().getSelectedKey())) {
            selectedJusho = true;
            if (!div.getPnlCondition().getTxtYubin().getValue().isEmpty()) {
                keiyakuJigyoshaYubinNo = div.getPnlCondition().getTxtYubin().getValue();
            }
            if (!div.getPnlCondition().getTxtJyusyoKanji().getValue().isNullOrEmpty()) {
                keiyakuJigyoshaJusho = new AtenaJusho(div.getPnlCondition().getTxtJyusyoKanji().getValue());
            }
            if (div.getPnlCondition().getChkJyusyoKanji().isAllSelected()) {
                sameJusho = true;
            }
        }

        JuryoininKeiyakuJigyoshaParameter parameter = JuryoininKeiyakuJigyoshaParameter.createMybatisParam(
                selectedBango,
                selectedName,
                selectedJusho,
                keiyakuJigyoshaNo,
                keiyakuJigyoshaKanaName,
                sameKanaName,
                keiyakuJigyoshaName,
                sameJigyoshaName,
                keiyakuShurui,
                keiyakuJigyoshaYubinNo,
                keiyakuJigyoshaJusho,
                sameJusho);

        ViewStateHolder.put(ViewStateKeys.検索キー, parameter);
        List<JuryoininKeiyakuJigyosha> dataList = JuryoininKeiyakuJigyoshaManager.createInstance()
                .getJuryoininKeiyakuJigyoshaList(parameter);
        List<dgKeiyakuJigyosya_Row> data = new ArrayList<>();
        if (dataList == null || dataList.isEmpty()) {
            div.getPnlData().getDgKeiyakuJigyosya().setDataSource(data);
            return;
        }
        int count;
        int limit = div.getPnlCondition().getTxtMaxCount().getValue().intValue();
        if (dataList.size() > limit) {
            count = limit;
        } else {
            count = dataList.size();
        }
        ViewStateHolder.put(ViewStateKeys.一覧データ, (ArrayList<JuryoininKeiyakuJigyosha>) dataList);
        ViewStateHolder.put(ViewStateKeys.最大件数, div.getPnlCondition().getTxtMaxCount().getValue());

        PtnTotalHandler handler = getHandler(div);
        handler.setGrid(count, dataList);
    }

    /**
     * 引継ぎデータの設定
     */
    private void setSelectedRow(PtnTotalDiv div) {
        ArrayList<JuryoininKeiyakuJigyosha> allData
                = ViewStateHolder.get(ViewStateKeys.一覧データ, ArrayList.class);
        for (JuryoininKeiyakuJigyosha tmp : allData) {
            if (tmp.get契約事業者番号().equals(
                    div.getPnlData().getDgKeiyakuJigyosya().getSelectedItems().get(0).getTxtKeiyakuJigyoshaNo())) {
                ViewStateHolder.put(ViewStateKeys.詳細データ, tmp);
            }
        }
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
