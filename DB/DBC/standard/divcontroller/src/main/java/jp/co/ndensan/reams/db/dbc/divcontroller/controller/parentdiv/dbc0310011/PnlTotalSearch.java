/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0310011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300011.DBC0300011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.DBC0310011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.PnlTotalSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0310011.PnlTotalSearchHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_検索
 */
public class PnlTotalSearch {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 参照 = new RString("参照");

    /**
     * コンストラクタです。
     *
     * @param div PnlTotalSearchDiv
     */
    private PnlTotalSearchHandler getHandler(PnlTotalSearchDiv div) {
        return PnlTotalSearchHandler.of(div);
    }

    /**
     * onLoad事件
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onLoad(PnlTotalSearchDiv div) {
        getHandler(div).set初期化状態();
        ShokanJuryoininKeiyakushaParameter parameter = ViewStateHolder
                .get(ViewStateKeys.契約者一覧検索キー, ShokanJuryoininKeiyakushaParameter.class);
        if (parameter != null) {
            List<ShokanJuryoininKeiyakusha> shokanList = getHandler(div).get契約者一覧(parameter);
            if (shokanList == null || shokanList.isEmpty()) {
                return ResponseData.of(div).respond();
            }
            Decimal 最大取得件数 = ViewStateHolder
                    .get(ViewStateKeys.受領委任契約事業者検索最大件数, Decimal.class);
            div.getPnlSearch().getTxtMaxCount().setValue(最大取得件数);
            return set契約者一覧(div, shokanList);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 被保番号検索ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnHihokensyaSearch(PnlTotalSearchDiv div) {
        // TODO QA No.473(Redmine#:79880)
        return ResponseData.of(div).respond();
    }

    /**
     * 「被保番号」テキストボックス
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onBlur_txtHihokenshaNo(PnlTotalSearchDiv div) {
        // TODO QA No.473(Redmine#:79880)
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
        RString 被保険者名 = ViewStateHolder.get(ViewStateKeys.被保険者名, RString.class);
        if (被保険者番号 != null) {
            if (被保険者番号.equals(div.getPnlSearch().getTxtHihokenshaNo().getValue())) {
                div.getPnlSearch().getTxtName().setValue(被保険者名);
            } else {
                div.getPnlSearch().getTxtName().clearValue();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 契約事業者検索ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnJigyoshakeiyakuSearch(PnlTotalSearchDiv div) {
        ViewStateHolder.put(ViewStateKeys.基本情報パラメータ, getHandler(div).createParameter());
        ViewStateHolder.put(ViewStateKeys.被保険者名, div.getPnlSearch().getTxtName().getValue());
        ViewStateHolder.put(ViewStateKeys.契約事業者名, div.getPnlSearch().getTxtJigyoshakeiyakuName().getValue());
        ViewStateHolder.put(ViewStateKeys.受領委任契約事業者検索最大件数, div.getPnlSearch().getTxtMaxCount().getValue());
        // TODO QA No.473(Redmine#:79880)
        return ResponseData.of(div).forwardWithEventName(DBC0300011TransitionEventName.事業者選択).respond();
    }

    /**
     * 「契約事業者番号」テキストボックス
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onBlur_txtJigyoshakeiyakuNo(PnlTotalSearchDiv div) {
        // TODO QA No.473(Redmine#:79880)
        RString 契約事業者番号 = ViewStateHolder.get(ViewStateKeys.契約事業者番号, RString.class);
        RString 契約事業者名 = ViewStateHolder.get(ViewStateKeys.契約事業者名, RString.class);
        if (契約事業者番号 != null) {
            if (契約事業者番号.equals(div.getPnlSearch().getTxtJigyoshakeiyakuNo().getValue())) {
                div.getPnlSearch().getTxtJigyoshakeiyakuName().setValue(契約事業者名);
            } else {
                div.getPnlSearch().getTxtJigyoshakeiyakuName().clearValue();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnClear(PnlTotalSearchDiv div) {
        div.getPnlSearch().getTxtHihokenshaNo().clearValue();
        div.getPnlSearch().getTxtName().clearValue();
        div.getPnlSearch().getTxtShinseiYMDRange().clearFromValue();
        div.getPnlSearch().getTxtShinseiYMDRange().clearToValue();
        div.getPnlSearch().getTxtKetteYMDRange().clearFromValue();
        div.getPnlSearch().getTxtKetteYMDRange().clearToValue();
        div.getPnlSearch().getTxtJigyoshakeiyakuNo().clearValue();
        div.getPnlSearch().getTxtJigyoshakeiyakuName().clearValue();
        div.getPnlSearch().getDdlKeiyakuServiceShurui().setSelectedKey(RString.EMPTY);
        div.getPnlSearch().getTxtYear().clearDomain();
        div.getPnlSearch().getTxtKeiyakuNo().clearValue();
        div.getPnlSearch().getTxtMaxCount().setValue(new Decimal(DbBusinessConifg.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(),
                        SubGyomuCode.DBU介護統計報告).toString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnSearch(PnlTotalSearchDiv div) {
        if (div.getPnlSearch().getTxtHihokenshaNo().getValue().isEmpty()
                && div.getPnlSearch().getTxtShinseiYMDRange().getFromValue() == null
                && div.getPnlSearch().getTxtShinseiYMDRange().getToValue() == null
                && div.getPnlSearch().getTxtKetteYMDRange().getFromValue() == null
                && div.getPnlSearch().getTxtKetteYMDRange().getToValue() == null
                && div.getPnlSearch().getTxtJigyoshakeiyakuNo().getValue().isEmpty()
                && div.getPnlSearch().getDdlKeiyakuServiceShurui().getSelectedKey().isEmpty()
                && div.getPnlSearch().getTxtYear().getDomain() == null
                && div.getPnlSearch().getTxtKeiyakuNo().getValue().isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                // TODO QA No.472(Redmine#:79879)
                throw new ApplicationException(UrWarningMessages.未入力.getMessage()
                        .replace("検索条件の項目いずれも"));
            }
            return ResponseData.of(div).respond();
        }
        ShokanJuryoininKeiyakushaParameter parameter = getHandler(div).createParameter();
        ViewStateHolder.put(ViewStateKeys.契約者一覧検索キー, parameter);
        ViewStateHolder.put(ViewStateKeys.被保険者名, div.getPnlSearch().getTxtName().getValue());
        ViewStateHolder.put(ViewStateKeys.契約事業者名, div.getPnlSearch().getTxtJigyoshakeiyakuName().getValue());
        ViewStateHolder.put(ViewStateKeys.受領委任契約事業者検索最大件数, div.getPnlSearch().getTxtMaxCount().getValue());
        List<ShokanJuryoininKeiyakusha> shokanList = getHandler(div).get契約者一覧(parameter);
        return set契約者一覧(div, shokanList);
    }

    /**
     * グレードの選択ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnSelect(PnlTotalSearchDiv div) {
        getHandler(div).putViewStateHolder(参照);
        return ResponseData.of(div).forwardWithEventName(DBC0310011TransitionEventName.契約者選択).respond();
    }

    /**
     * グレードの修正ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnModify(PnlTotalSearchDiv div) {
        getHandler(div).putViewStateHolder(修正);
        return ResponseData.of(div).forwardWithEventName(DBC0310011TransitionEventName.契約者選択).respond();
    }

    /**
     * グレードの削除ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnDelete(PnlTotalSearchDiv div) {
        getHandler(div).putViewStateHolder(削除);
        return ResponseData.of(div).forwardWithEventName(DBC0310011TransitionEventName.契約者選択).respond();
    }

    /**
     * 「再検索する」ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnSearchAgain(PnlTotalSearchDiv div) {
        div.getPnlKeiyakusyaList().getDgKeyakusya().getDataSource().clear();
        div.getPnlSearch().setDisplayNone(false);
        div.getPnlKeiyakusyaList().setDisplayNone(true);
        div.getBtnSearchAgain().setDisabled(true);
        div.getPnlSearch().getDdlKeiyakuServiceShurui().setDataSource(getHandler(div).createDropDownList());
        ShokanJuryoininKeiyakushaParameter parameter = ViewStateHolder
                .get(ViewStateKeys.契約者一覧検索キー, ShokanJuryoininKeiyakushaParameter.class);
        if (parameter != null) {
            getHandler(div).set基本情報パラメータ(parameter);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 契約者一覧を設定
     *
     * @param div PnlTotalSearchDiv
     * @param shokanList List<ShokanJuryoininKeiyakusha>
     * @return ResponseData<PnlTotalSearchDiv>
     */
    private ResponseData<PnlTotalSearchDiv> set契約者一覧(PnlTotalSearchDiv div,
            List<ShokanJuryoininKeiyakusha> shokanList) {
        div.getPnlSearch().getDdlKeiyakuServiceShurui().setDataSource(getHandler(div).createDropDownList());
        int maxCount = div.getPnlSearch().getTxtMaxCount().getValue().intValue();
        if (shokanList != null && shokanList.size() > maxCount) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbzQuestionMessages.最大表示件数超過確認.getMessage().getCode(),
                        DbzQuestionMessages.最大表示件数超過確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbzQuestionMessages.最大表示件数超過確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).initializeGrid(shokanList);
            }
        } else {
            getHandler(div).initializeGrid(shokanList);
        }
        return ResponseData.of(div).respond();
    }
}
