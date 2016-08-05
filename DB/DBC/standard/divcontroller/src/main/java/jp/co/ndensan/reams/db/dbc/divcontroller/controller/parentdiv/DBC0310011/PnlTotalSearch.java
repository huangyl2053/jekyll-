/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0310011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.DBC0310011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.DBC0310011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.PnlTotalSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011.dgKeyakusya_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0310011.PnlTotalSearchHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310011.PnlTotalSearchParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzQuestionMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会_検索
 *
 * @reamsid_L DBC-2130-010 cuilin
 */
public class PnlTotalSearch {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 参照 = new RString("参照");
    private static final RString 修正モード = new RString("修正モード");
    private static final RString 照会モード = new RString("照会モード");
    private static final RString 未入力エラー = new RString("検索条件の項目いずれも");
    private static final RString 契約者選択 = new RString("契約者選択");
    private static final RString 対象者検索 = new RString("対象者検索");
    private static final RString 事業者検索 = new RString("事業者検索");
    private static final RString 照会タイトル = new RString("受領委任契約申請照会");
    private static final RString 修正タイトル = new RString("受領委任契約申請登録・修正");

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
        RString 表示モード = ViewStateHolder.get(ViewStateKeys.表示モード, RString.class);
        RString モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        if (モード == null || モード.isEmpty()) {
            if (修正モード.equals(ResponseHolder.getState())) {
                ViewStateHolder.put(ViewStateKeys.画面モード, 修正);
            } else if (照会モード.equals(ResponseHolder.getState())) {
                ViewStateHolder.put(ViewStateKeys.画面モード, 参照);
            }
        }
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        getHandler(div).set初期化状態(表示モード, ViewStateHolder.get(ViewStateKeys.画面モード, RString.class));
        if (表示モード == null || 表示モード.isEmpty()) {
            div.getPnlSearch().getDdlKeiyakuServiceShurui().setSelectedKey(RString.EMPTY);
            div.getPnlSearch().getTxtMaxCount().setValue(new Decimal(DbBusinessConfig.
                    get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(),
                            SubGyomuCode.DBU介護統計報告).toString()));
        } else {
            ShokanJuryoininKeiyakushaParameter parameter = ViewStateHolder
                    .get(ViewStateKeys.契約者一覧検索キー, ShokanJuryoininKeiyakushaParameter.class);
            getHandler(div).set基本情報パラメータ(parameter);
            RString 保険者名 = ViewStateHolder.get(ViewStateKeys.被保険者名, RString.class);
            div.getPnlSearch().getTxtName().setValue(保険者名);
            RString 契約事業者名 = ViewStateHolder.get(ViewStateKeys.契約事業者名, RString.class);
            div.getPnlSearch().getTxtJigyoshakeiyakuName().setValue(契約事業者名);
            Decimal 最大取得件数 = ViewStateHolder
                    .get(ViewStateKeys.最大件数, Decimal.class);
            div.getPnlSearch().getTxtMaxCount().setValue(最大取得件数);

            if (対象者検索.equals(表示モード)) {
                TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
                HihokenshaNo 被保険者番号 = key.get被保険者番号();
                ShokanJuryoininKeiyakushaFinder finder = ShokanJuryoininKeiyakushaFinder.createInstance();
                IName 被保険者名 = finder.get氏名(被保険者番号);
                div.getPnlSearch().getTxtHihokenshaNo().setValue(被保険者番号.getColumnValue());
                div.getPnlSearch().getTxtName().setValue(被保険者名 == null ? RString.EMPTY
                        : 被保険者名.getName().getColumnValue());
            } else if (事業者検索.equals(表示モード)) {
                JuryoininKeiyakuJigyosha data = ViewStateHolder
                        .get(ViewStateKeys.詳細データ, JuryoininKeiyakuJigyosha.class);
                ViewStateHolder.put(ViewStateKeys.契約事業者番号, data.get契約事業者番号());
                ViewStateHolder.put(ViewStateKeys.契約事業者名, data.get契約事業者名称().getColumnValue());
                div.getPnlSearch().getTxtJigyoshakeiyakuNo().setValue(data.get契約事業者番号());
                div.getPnlSearch().getTxtJigyoshakeiyakuName().setValue(data.get契約事業者名称().getColumnValue());
            }
        }
        if (契約者選択.equals(表示モード)) {
            ShokanJuryoininKeiyakushaParameter parameter = ViewStateHolder
                    .get(ViewStateKeys.契約者一覧検索キー, ShokanJuryoininKeiyakushaParameter.class);
            List<ShokanJuryoininKeiyakushaResult> shokanResultList = getHandler(div).get契約者一覧(parameter);
            Decimal 最大取得件数 = ViewStateHolder
                    .get(ViewStateKeys.最大件数, Decimal.class);
            div.getPnlSearch().getTxtMaxCount().setValue(最大取得件数);
            return set契約者一覧(div, shokanResultList, 最大取得件数);
        }
        if (参照.equals(画面モード)) {
            return ResponseData.of(ResponseData.of(div).setState(DBC0310011StateName.照会モード).data).rootTitle(照会タイトル).respond();
        } else {
            return ResponseData.of(ResponseData.of(div).setState(DBC0310011StateName.修正モード).data).rootTitle(修正タイトル).respond();
        }
    }

    /**
     * 被保番号検索ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnHihokensyaSearch(PnlTotalSearchDiv div) {
        ViewStateHolder.put(ViewStateKeys.契約者一覧検索キー, getHandler(div).createParameter());
        ViewStateHolder.put(ViewStateKeys.被保険者名, div.getPnlSearch().getTxtName().getValue());
        ViewStateHolder.put(ViewStateKeys.契約事業者名, div.getPnlSearch().getTxtJigyoshakeiyakuName().getValue());
        ViewStateHolder.put(ViewStateKeys.最大件数, div.getPnlSearch().getTxtMaxCount().getValue());
        ViewStateHolder.put(ViewStateKeys.表示モード, 対象者検索);
        return ResponseData.of(div).forwardWithEventName(DBC0310011TransitionEventName.対象者検索).respond();
    }

    /**
     * 「被保番号」テキストボックス
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onBlur_txtHihokenshaNo(PnlTotalSearchDiv div) {
        RString 被保険者番号 = div.getPnlSearch().getTxtHihokenshaNo().getValue();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            ShokanJuryoininKeiyakushaFinder finder = ShokanJuryoininKeiyakushaFinder.createInstance();
            IName 被保険者名 = finder.get氏名(new HihokenshaNo(被保険者番号));
            if (被保険者名 != null) {
                div.getPnlSearch().getTxtName().setValue(被保険者名.getName().getColumnValue());
            } else {
                div.getPnlSearch().getTxtName().clearValue();
            }
        } else {
            div.getPnlSearch().getTxtName().clearValue();
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
        ViewStateHolder.put(ViewStateKeys.契約者一覧検索キー, getHandler(div).createParameter());
        ViewStateHolder.put(ViewStateKeys.被保険者名, div.getPnlSearch().getTxtName().getValue());
        ViewStateHolder.put(ViewStateKeys.契約事業者名, div.getPnlSearch().getTxtJigyoshakeiyakuName().getValue());
        ViewStateHolder.put(ViewStateKeys.最大件数, div.getPnlSearch().getTxtMaxCount().getValue());
        ViewStateHolder.put(ViewStateKeys.表示モード, 事業者検索);
        ViewStateHolder.put(ViewStateKeys.状態, 参照);
        return ResponseData.of(div).forwardWithEventName(DBC0310011TransitionEventName.事業者検索).respond();
    }

    /**
     * 「契約事業者番号」テキストボックス
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onBlur_txtJigyoshakeiyakuNo(PnlTotalSearchDiv div) {
        RString 契約事業者番号 = ViewStateHolder.get(ViewStateKeys.契約事業者番号, RString.class);
        RString 契約事業者名 = ViewStateHolder.get(ViewStateKeys.契約事業者名, RString.class);
        if (契約事業者番号 != null) {
            if (契約事業者番号.equals(div.getPnlSearch().getTxtJigyoshakeiyakuNo().getValue())) {
                div.getPnlSearch().getTxtJigyoshakeiyakuName().setValue(契約事業者名);
            } else {
                div.getPnlSearch().getTxtJigyoshakeiyakuName().clearValue();
            }
        } else {
            div.getPnlSearch().getTxtJigyoshakeiyakuName().clearValue();
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
        div.getPnlSearch().getTxtMaxCount().setValue(new Decimal(DbBusinessConfig.
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
                throw new ApplicationException(UrWarningMessages.未入力.getMessage()
                        .replace(未入力エラー.toString()).evaluate());
            }
            return ResponseData.of(div).respond();
        }
        ShokanJuryoininKeiyakushaParameter parameter = getHandler(div).createParameter();
        Decimal 最大取得件数 = div.getPnlSearch().getTxtMaxCount().getValue();
        ViewStateHolder.put(ViewStateKeys.契約者一覧検索キー, parameter);
        ViewStateHolder.put(ViewStateKeys.被保険者名, div.getPnlSearch().getTxtName().getValue());
        ViewStateHolder.put(ViewStateKeys.契約事業者名, div.getPnlSearch().getTxtJigyoshakeiyakuName().getValue());
        ViewStateHolder.put(ViewStateKeys.最大件数, 最大取得件数);
        List<ShokanJuryoininKeiyakushaResult> shokanResultList = getHandler(div).get契約者一覧(parameter);
        return set契約者一覧(div, shokanResultList, 最大取得件数);
    }

    /**
     * グレードの選択ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnSelect(PnlTotalSearchDiv div) {
        putViewStateHolder(参照, div);
        return ResponseData.of(div).forwardWithEventName(DBC0310011TransitionEventName.契約者選択).respond();
    }

    /**
     * グレードの修正ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnModify(PnlTotalSearchDiv div) {
        putViewStateHolder(修正, div);
        return ResponseData.of(div).forwardWithEventName(DBC0310011TransitionEventName.契約者選択).respond();
    }

    /**
     * グレードの削除ボタン
     *
     * @param div PnlTotalSearchDiv
     * @return ResponseData<PnlTotalSearchDiv>
     */
    public ResponseData<PnlTotalSearchDiv> onClick_btnDelete(PnlTotalSearchDiv div) {
        putViewStateHolder(削除, div);
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
            RString 被保険者名 = ViewStateHolder.get(ViewStateKeys.被保険者名, RString.class);
            div.getPnlSearch().getTxtName().setValue(被保険者名);
            RString 契約事業者名 = ViewStateHolder.get(ViewStateKeys.契約事業者名, RString.class);
            div.getPnlSearch().getTxtJigyoshakeiyakuName().setValue(契約事業者名);
            Decimal 最大取得件数 = ViewStateHolder
                    .get(ViewStateKeys.最大件数, Decimal.class);
            div.getPnlSearch().getTxtMaxCount().setValue(最大取得件数);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * ViewStateHolderの設定
     *
     * @param 画面モード RString
     */
    private void putViewStateHolder(RString 画面モード, PnlTotalSearchDiv div) {
        List<KeyValueDataSource> keiyakuServiceShuruiList = div.getPnlSearch()
                .getDdlKeiyakuServiceShurui().getDataSource();
        dgKeyakusya_Row row = div.getPnlKeiyakusyaList().getDgKeyakusya().getClickedItem();
        RString 契約サービス種類 = RString.EMPTY;
        for (KeyValueDataSource keyValue : keiyakuServiceShuruiList) {
            if (row.getTxtServiceShurui().equals(keyValue.getValue())) {
                契約サービス種類 = keyValue.getKey();
                break;
            }
        }
        PnlTotalSearchParameter pnlTotalSearchParameter = new PnlTotalSearchParameter(
                row.getTxtKeiyakuNo(),
                契約サービス種類,
                row.getTxtHihoNo(),
                row.getTxtShimei(),
                new FlexibleDate(row.getTxtKeiyakuShenseibi().getValue().toDateString()),
                row.getTxtKeiyakuKeteibi().getValue() == null ? null
                : new FlexibleDate(row.getTxtKeiyakuKeteibi().getValue().toDateString()),
                row.getTxtKeiyakuJigyoshaNo(),
                row.getTxtKeiyakuJigyoshamei(),
                row.getTxtShikibetsuCode());
        ShokanJuryoininKeiyakushaFinder finder = ShokanJuryoininKeiyakushaFinder.createInstance();
        ShokanJuryoininKeiyakusha shokanData = finder.getShokanJuryoininKeiyakusha(
                new HihokenshaNo(pnlTotalSearchParameter.get被保番号()),
                pnlTotalSearchParameter.get契約申請日(),
                pnlTotalSearchParameter.get契約事業者番号(),
                pnlTotalSearchParameter.get契約サービス種類());
        if (shokanData == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.契約者一覧情報, pnlTotalSearchParameter);
        ViewStateHolder.put(ViewStateKeys.最大件数, div.getPnlSearch().getTxtMaxCount().getValue());
        ViewStateHolder.put(ViewStateKeys.表示モード, 契約者選択);
        ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
    }

    /**
     * 契約者一覧を設定
     *
     * @param div PnlTotalSearchDiv
     * @param shokanList List<ShokanJuryoininKeiyakusha>
     * @return ResponseData<PnlTotalSearchDiv>
     */
    private ResponseData<PnlTotalSearchDiv> set契約者一覧(PnlTotalSearchDiv div,
            List<ShokanJuryoininKeiyakushaResult> shokanResultList, Decimal maxCount) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        div.getPnlSearch().getDdlKeiyakuServiceShurui().setDataSource(getHandler(div).createDropDownList());
        if (shokanResultList != null && shokanResultList.size() > maxCount.intValue()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(
                        DbzQuestionMessages.最大表示件数超過確認.getMessage().getCode(),
                        DbzQuestionMessages.最大表示件数超過確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbzQuestionMessages.最大表示件数超過確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).initializeGrid(shokanResultList, maxCount);
            }
        } else {
            getHandler(div).initializeGrid(shokanResultList, maxCount);
        }
        if (参照.equals(画面モード)) {
            return ResponseData.of(ResponseData.of(div).setState(DBC0310011StateName.照会モード).data).rootTitle(照会タイトル).respond();
        } else {
            return ResponseData.of(ResponseData.of(div).setState(DBC0310011StateName.修正モード).data).rootTitle(修正タイトル).respond();
        }
    }
}
