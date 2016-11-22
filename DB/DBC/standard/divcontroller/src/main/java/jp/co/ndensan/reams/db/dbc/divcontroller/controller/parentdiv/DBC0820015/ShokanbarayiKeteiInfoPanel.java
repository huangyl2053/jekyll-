/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0820015;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.DBHozonJoho;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ModoruEntity;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShomeishoNyuryokuFlag;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku.ShoukanharaihishinseimeisaikensakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShomeishoNyuryokuKubunType;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho.dgSyokanbaraikete_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.DBC0820015StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.DBC0820015TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820015.ShokanbarayiKeteiInfoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.shoukanharaihishinseikensaku.ShoukanharaihishinseikensakuParameter;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払い費支給申請決定_償還払決定情報
 *
 * @reamsid_L DBC-1030-180 xuhao
 */
public class ShokanbarayiKeteiInfoPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 証明書 = new RString("証明書");
    private static final RString 申請書入力済 = new RString("1");
    private static final RString 申請書入力未済あり = new RString("2");
    private static final RString 決定情報入力未済あり = new RString("3");
    private static final RString 必要項目 = new RString("必要項目");
    private static final int 定数_0 = 0;
    private static final int 定数_6 = 6;
    private static final int 定数_3 = 3;

    /**
     * onLoad
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onLoad(ShokanbarayiKeteiInfoPanelDiv div) {
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.整理番号, RString.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス年月;
        サービス年月 = new FlexibleYearMonth((new RDate(
                ViewStateHolder.get(ViewStateKeys.サービス年月, RString.class).
                toString())).getYearMonth().toDateString());
        ViewStateHolder.put(ViewStateKeys.申請検索キー, new ShoukanharaihishinseikensakuParameter(被保険者番号, サービス年月, 整理番号,
                null, null, null, null));
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        データ情報の初期化(db情報);
        div.getPanelOne().getCcdKaigoAtenaInfo().initialize(識別コード);
        if (!被保険者番号.isEmpty()) {
            div.getPanelOne().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelOne().getCcdKaigoShikakuKihon().setVisible(false);
        }
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        getHandler(div).initialize(被保険者番号, サービス年月, 整理番号, 画面モード);
        if (削除.equals(画面モード)) {
            return ResponseData.of(div).setState(DBC0820015StateName.削除モード);
        }
        List<dgSyokanbaraikete_Row> 決定情報登録_償還払決定一覧 = div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv()
                .getDgSyokanbaraikete().getDataSource();
        KetteJoho 決定情報 = ViewStateHolder.get(ViewStateKeys.決定情報, KetteJoho.class);
        Map<RString, Decimal> map_Row = new HashMap<>();
        for (dgSyokanbaraikete_Row list : 決定情報登録_償還払決定一覧) {
            map_Row.put(list.getNo(), list.getSagakuKingaku().getValue());
        }
        ViewStateHolder.put(ViewStateKeys.償還払決定一覧情報, (Serializable) map_Row);
        ViewStateHolder.put(ViewStateKeys.登録用決定情報, 決定情報);
        ViewStateHolder.put(ViewStateKeys.前回支払金額, div.getCcdShokanbaraiketteiJoho()
                .getShokanbaraiketteiJohoDiv().getTxtShiharaikingakugoke().getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnShinsei
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnShinsei(ShokanbarayiKeteiInfoPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        getDB情報(div);
        putViewState(div);
        if (登録.equals(画面モード) && !get画面有無変化(div)) {
            throw new ApplicationException(UrErrorMessages.未入力.getMessage().replace(必要項目.toString()));
        } else if (登録.equals(画面モード) && get画面有無変化(div)) {
            ViewStateHolder.put(ViewStateKeys.画面モード, 修正);
            ViewStateHolder.put(ViewStateKeys.処理モード, 修正);
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.申請情報).respond();
        } else {
            ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
            ViewStateHolder.put(ViewStateKeys.処理モード, 画面モード);
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.申請情報).respond();
        }
    }

    /**
     * onClick_btnKouza
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnKouza(ShokanbarayiKeteiInfoPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        getDB情報(div);
        ViewStateHolder.put(ViewStateKeys.処理モード, 画面モード);
        if (登録.equals(画面モード) && !get画面有無変化(div)) {
            throw new ApplicationException(UrErrorMessages.未入力.getMessage().replace(必要項目.toString()));
        } else {
            ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.口座情報).respond();
        }
    }

    /**
     * onClick_btnServiceTeikyoShomeisyo
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_btnServiceTeikyoShomeisyo(
            ShokanbarayiKeteiInfoPanelDiv div) {
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        ShoukanharaihishinseikensakuParameter parameter = ViewStateHolder.get(ViewStateKeys.申請検索キー, ShoukanharaihishinseikensakuParameter.class);
        getDB情報(div);
        ViewStateHolder.put(ViewStateKeys.処理モード, 画面モード);
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        if (登録.equals(画面モード)) {
            if (!getHandler(div).check支給申請(parameter.getHiHokenshaNo(), paramter.getServiceTeikyoYM(), paramter.getSeiriNp())) {
                throw new ApplicationException(UrErrorMessages.未入力.getMessage().replace(必要項目.toString()));
            }
        }
        if (getHandler(div).isチェック処理(paramter)) {
            putViewState(div);
            if (登録.equals(画面モード) && !get画面有無変化(div)) {
                throw new ApplicationException(UrErrorMessages.未入力.getMessage().replace(必要項目.toString()));
            } else {
                ViewStateHolder.put(ViewStateKeys.画面モード, 画面モード);
                return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.サービス提供証明書).respond();
            }
        } else {
            throw new ApplicationException(UrErrorMessages.既に登録済.getMessage().replace(証明書.toString()));
        }
    }

    /**
     * onClick_CommonCancel
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_CommonCancel(ShokanbarayiKeteiInfoPanelDiv div) {
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        HihokenshaNo 被保険者番号 = paramter.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = paramter.getServiceTeikyoYM();
        RString 整理番号 = paramter.getSeiriNp();
        if (削除.equals(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class))) {
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.一覧に戻る).respond();
        }
        Map<RString, Decimal> 償還払決定一覧 = ViewStateHolder.get(ViewStateKeys.償還払決定一覧情報, Map.class);
        KetteJoho 決定情報 = ViewStateHolder.get(ViewStateKeys.登録用決定情報, KetteJoho.class);
        boolean flag = getHandler(div).get内容変更状態(償還払決定一覧, 決定情報);
        if (flag) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
                getHandler(div).initialize(被保険者番号, サービス年月, 整理番号, 画面モード);
                return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.一覧に戻る).respond();
            } else {
                return ResponseData.of(div).respond();
            }
        } else {
            return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.一覧に戻る).respond();
        }
    }

    /**
     * onClick_CommonsShoriCancel
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_CommonsShoriCancel(ShokanbarayiKeteiInfoPanelDiv div) {
        if (DBC0820015StateName.処理完了.getName().equals(ResponseHolder.getState())) {
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, null);
        }
        return ResponseData.of(div).forwardWithEventName(DBC0820015TransitionEventName.一覧に戻る).respond();
    }

    /**
     * onClick_CommonSave
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_CommonSave(ShokanbarayiKeteiInfoPanelDiv div) {
        if (!get画面有無変化(div)) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(div).respond();
            }
            return ResponseData.of(div).respond();
        }
        try {
            ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                    ShoukanharaihishinseikensakuParameter.class);
            RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
            FlexibleDate 決定日 = ViewStateHolder.get(ViewStateKeys.決定日, FlexibleDate.class);
            DBHozonJoho データ情報 = getDB情報(div);
            if (情報のチェック(データ情報.getDB情報()) == 定数_3) {
                if (!ResponseHolder.isReRequest()) {
                    return ResponseData.of(div).addMessage(DbzInformationMessages.内容変更なしで保存不可.getMessage()).respond();
                }
                if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    return ResponseData.of(div).respond();
                }
            }
            RString 申請書入力済区分 = getHandler(div).get申請書入力済区分(get申請書入力済フラグ(get画面有無変化(div)));
            if (申請書入力済.equals(申請書入力済区分)) {
                ViewStateHolder.put(ViewStateKeys.申請書入力完了フラグ, 申請書入力済);
                getHandler(div).登録Save(データ情報.getDB情報(), データ情報.get修正前支給区分(), 決定日, paramter, 画面モード, 識別コード);
                div.getCcdKanryoMessage().setMessage(getKanryoMessage(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class)),
                        paramter.getHiHokenshaNo().value(), div.getPanelOne().getCcdKaigoAtenaInfo().get氏名漢字(), true);
                return ResponseData.of(div).setState(DBC0820015StateName.処理完了);
            } else if (申請書入力未済あり.equals(申請書入力済区分)) {
                ViewStateHolder.put(ViewStateKeys.申請書入力完了フラグ, 申請書入力未済あり);
                throw new ApplicationException(DbcErrorMessages.償還払い費支給申請決定_申請情報未入力.getMessage());
            } else if (決定情報入力未済あり.equals(申請書入力済区分)) {
                if (!ResponseHolder.isReRequest()) {
                    QuestionMessage message = new QuestionMessage("", "償還決定情報が登録されていません。よろしいですか？");
                    return ResponseData.of(div).addMessage(message).respond();
                }
                if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                    ViewStateHolder.put(ViewStateKeys.申請書入力完了フラグ, 決定情報入力未済あり);
                    getHandler(div).登録Save(データ情報.getDB情報(), データ情報.get修正前支給区分(), 決定日, paramter, 画面モード, 識別コード);
                    div.getCcdKanryoMessage().setMessage(getKanryoMessage(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class)),
                            paramter.getHiHokenshaNo().value(), div.getPanelOne().getCcdKaigoAtenaInfo().get氏名漢字(), true);
                    return ResponseData.of(div).setState(DBC0820015StateName.処理完了);
                }
            }
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_CommonDelete
     *
     * @param div 画面DIV
     * @return 画面DIV
     */
    public ResponseData<ShokanbarayiKeteiInfoPanelDiv> onClick_CommonDelete(ShokanbarayiKeteiInfoPanelDiv div) {
        try {
            ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                    ShoukanharaihishinseikensakuParameter.class);
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
            getHandler(div).削除Save(paramter, 識別コード);
            div.getCcdKanryoMessage().setMessage(getKanryoMessage(ViewStateHolder.get(ViewStateKeys.画面モード, RString.class)),
                    paramter.getHiHokenshaNo().value(), div.getPanelOne().getCcdKaigoAtenaInfo().get氏名漢字(), true);
            return ResponseData.of(div).setState(DBC0820015StateName.処理完了);
        } catch (Exception e) {
            e.toString();
            throw new ApplicationException(UrErrorMessages.異常終了.getMessage());
        }
    }

    private ShokanbarayiKeteiInfoPanelHandler getHandler(ShokanbarayiKeteiInfoPanelDiv div) {
        return ShokanbarayiKeteiInfoPanelHandler.of(div);
    }

    private void putViewState(ShokanbarayiKeteiInfoPanelDiv div) {
        FlexibleYearMonth サービス提供年月 = null;
        RString 整理番号 = null;
        if (div.getPanelTwo().getTxtServiceTeikyoYM().getValue() != null) {
            サービス提供年月 = new FlexibleYearMonth(div.getPanelTwo().getTxtServiceTeikyoYM().getValue().toDateString()
                    .substring(定数_0, 定数_6));
        }
        if (div.getPanelTwo().getTxtSeiriBango().getValue() != null) {
            整理番号 = div.getPanelTwo().getTxtSeiriBango().getValue();
        }

        ShoukanharaihishinseikensakuParameter paramter = new ShoukanharaihishinseikensakuParameter(
                ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                サービス提供年月,
                整理番号, null, null, null, null);
        ViewStateHolder.put(ViewStateKeys.申請検索キー, paramter);
    }

    private RString get申請書入力済フラグ(boolean flag) {
        if (flag) {
            return new RString("1");
        } else {
            return new RString("0");
        }
    }

    private boolean get画面有無変化(ShokanbarayiKeteiInfoPanelDiv div) {
        Map<RString, Decimal> 償還払決定一覧 = ViewStateHolder.get(ViewStateKeys.償還払決定一覧情報, Map.class);
        KetteJoho 決定情報 = ViewStateHolder.get(ViewStateKeys.登録用決定情報, KetteJoho.class);
        if (div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue() != null) {
            ViewStateHolder.put(ViewStateKeys.決定日,
                    new FlexibleDate(div.getCcdShokanbaraiketteiJoho().getShokanbaraiketteiJohoDiv().getTxtKetebi().getValue().toDateString()));
        } else {
            ViewStateHolder.put(ViewStateKeys.決定日, FlexibleDate.EMPTY);
        }
        return getHandler(div).get内容変更状態(償還払決定一覧, 決定情報);
    }

    private DBHozonJoho getDB情報(ShokanbarayiKeteiInfoPanelDiv div) {
        ShoukanharaihishinseikensakuParameter paramter = ViewStateHolder.get(ViewStateKeys.申請検索キー,
                ShoukanharaihishinseikensakuParameter.class);
        Decimal 支払金額合計初期 = ViewStateHolder.get(ViewStateKeys.前回支払金額, Decimal.class);
        RString 画面モード = ViewStateHolder.get(ViewStateKeys.画面モード, RString.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        DbJohoViewState db情報 = ViewStateHolder.get(ViewStateKeys.償還払ViewStateDB, DbJohoViewState.class);
        ShoukanharaihishinseimeisaikensakuParameter 明細キー = ViewStateHolder.get(ViewStateKeys.明細検索キー,
                ShoukanharaihishinseimeisaikensakuParameter.class);
        ShomeishoNyuryokuFlag 証明書入力済フラグ = new ShomeishoNyuryokuFlag();
        if (明細キー == null) {
            証明書入力済フラグ初期化(証明書入力済フラグ);
        }
        if (明細キー != null && db情報.get証明書入力済フラグMap() == null) {
            証明書入力済フラグ初期化(証明書入力済フラグ);
        }
        if (明細キー != null && db情報.get証明書入力済フラグMap() != null) {
            証明書入力済フラグ = db情報.get証明書入力済フラグMap().get(明細キー);
        }
        if (証明書入力済フラグ == null) {
            証明書入力済フラグ = new ShomeishoNyuryokuFlag();
            証明書入力済フラグ初期化(証明書入力済フラグ);
        }
        ModoruEntity 戻るの対象 = getHandler(div).return登録処理情報(paramter, 支払金額合計初期, 画面モード, 識別コード,
                証明書入力済フラグ, db情報);
        DbJohoViewState データ情報;
        RString 修正前支給区分;
        if (戻るの対象 != null) {
            データ情報 = getHandler(div).db情報保存(戻るの対象, db情報);
            修正前支給区分 = 戻るの対象.get修正前支給区分();
            ViewStateHolder.put(ViewStateKeys.修正前支給区分, 戻るの対象.get修正前支給区分());
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, データ情報);
            return new DBHozonJoho(データ情報, 修正前支給区分);
        } else {
            修正前支給区分 = RString.EMPTY;
            ViewStateHolder.put(ViewStateKeys.修正前支給区分, 修正前支給区分);
            return new DBHozonJoho(db情報, 修正前支給区分);
        }
    }

    private void 証明書入力済フラグ初期化(ShomeishoNyuryokuFlag 証明書入力済フラグ) {
        証明書入力済フラグ.setサービス計画費_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set請求額集計_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set食事費用_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
        証明書入力済フラグ.set特定入所者費用_証明書入力済フラグ(ShomeishoNyuryokuKubunType.入力なし);
    }

    private RString getKanryoMessage(RString model) {
        if (登録.equals(model)) {
            return new RString("登録は正常に終了しました。");
        } else if (修正.equals(model)) {
            return new RString("更新は正常に終了しました。");
        } else {
            return new RString("削除は正常に終了しました。");
        }
    }

    private void データ情報の初期化(DbJohoViewState db情報) {
        if (db情報 != null) {
            if (db情報.get償還払請求集計データList() == null) {
                ArrayList<ShokanShukeiResult> shokan = new ArrayList<>();
                db情報.set償還払請求集計データList(shokan);
            }
            if (db情報.get償還払請求食事費用データList() == null) {
                ArrayList<ShokanShokujiHiyo> shokuji = new ArrayList<>();
                db情報.set償還払請求食事費用データList(shokuji);
            }
            if (db情報.get償還払請求特定入所者介護サービス費用データList() == null) {
                ArrayList<ShokanTokuteiNyushoshaKaigoServiceHiyo> service = new ArrayList<>();
                db情報.set償還払請求特定入所者介護サービス費用データList(service);
            }
            if (db情報.get償還払請求サービス計画200904データResultList() == null) {
                ArrayList<ShokanServicePlan200904Result> service2009 = new ArrayList<>();
                db情報.set償還払請求サービス計画200904データResultList(service2009);
            }
            if (db情報.get償還払請求サービス計画200604データResultList() == null) {
                ArrayList<ShokanServicePlan200604Result> service200604 = new ArrayList<>();
                db情報.set償還払請求サービス計画200604データResultList(service200604);
            }
            if (db情報.get償還払請求サービス計画200004データResultList() == null) {
                ArrayList<ShokanServicePlan200004Result> service200004 = new ArrayList<>();
                db情報.set償還払請求サービス計画200004データResultList(service200004);
            }
            if (db情報.get住所地特例データList() == null) {
                ArrayList<ShokanMeisaiJushochiTokureiResult> tokurei = new ArrayList<>();
                db情報.set住所地特例データList(tokurei);
            }
            if (db情報.get償還払請求基本データList() == null) {
                ArrayList<ShokanKihon> kihon = new ArrayList<>();
                db情報.set償還払請求基本データList(kihon);
            }
            if (db情報.get償還払請求所定疾患施設療養費等データList() == null) {
                ArrayList<ShokanShoteiShikkanShisetsuRyoyo> ryoyo = new ArrayList<>();
                db情報.set償還払請求所定疾患施設療養費等データList(ryoyo);
            }
            if (db情報.get償還払請求明細データList() == null) {
                ArrayList<ShokanMeisaiResult> meisai = new ArrayList<>();
                db情報.set償還払請求明細データList(meisai);
            }
            if (db情報.get償還払請求特定診療費データList() == null) {
                ArrayList<ShokanTokuteiShinryohi> shinryohi = new ArrayList<>();
                db情報.set償還払請求特定診療費データList(shinryohi);
            }
            if (db情報.get償還払請求社会福祉法人軽減額データList() == null) {
                ArrayList<ShokanShakaiFukushiHojinKeigengakuResult> keigengaku = new ArrayList<>();
                db情報.set償還払請求社会福祉法人軽減額データList(keigengaku);
            }
            if (db情報.get償還払請求緊急時施設療養データList() == null) {
                ArrayList<ShokanKinkyuShisetsuRyoyo> shisetsuRyoyo = new ArrayList<>();
                db情報.set償還払請求緊急時施設療養データList(shisetsuRyoyo);
            }
            if (db情報.get特別療養費データList() == null) {
                ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> tokubetsuRyoyo = new ArrayList<>();
                db情報.set特別療養費データList(tokubetsuRyoyo);
            }
            ViewStateHolder.put(ViewStateKeys.償還払ViewStateDB, db情報);
        }
    }

    private int 情報のチェック一(DbJohoViewState db情報, int index) {
        if (db情報.get住所地特例データList().isEmpty()
                && db情報.get償還払請求サービス計画200004データResultList().isEmpty()
                && db情報.get償還払請求サービス計画200604データResultList().isEmpty()
                && db情報.get償還払請求サービス計画200904データResultList().isEmpty()
                && db情報.get償還払請求基本データList().isEmpty()
                && db情報.get償還払請求所定疾患施設療養費等データList().isEmpty()
                && db情報.get償還払請求明細データList().isEmpty()
                && db情報.get償還払請求特定入所者介護サービス費用データList().isEmpty()
                && db情報.get償還払請求特定診療費データList().isEmpty()
                && db情報.get償還払請求社会福祉法人軽減額データList().isEmpty()
                && db情報.get償還払請求緊急時施設療養データList().isEmpty()
                && db情報.get償還払請求集計データList().isEmpty()
                && db情報.get償還払請求食事費用データList().isEmpty()
                && db情報.get特別療養費データList().isEmpty()) {
            index++;
        }
        return index;

    }

    private int 情報のチェック(DbJohoViewState db情報) {
        int index = 0;
        index = 情報のチェック一(db情報, index);
        if (db情報.get償還払支給判定結果() != null) {
            if (EntityDataState.Unchanged.equals(db情報.get償還払支給判定結果().toEntity().getState())
                    || db情報.get償還払支給判定結果().toEntity().getState() == null) {
                index++;
            }
        }
        if (db情報.get償還払支給申請() != null) {
            if (EntityDataState.Unchanged.equals(db情報.get償還払支給申請().toEntity().getState())
                    || db情報.get償還払支給申請().toEntity().getState() == null) {
                index++;
            }
        }
        return index;

    }
}
