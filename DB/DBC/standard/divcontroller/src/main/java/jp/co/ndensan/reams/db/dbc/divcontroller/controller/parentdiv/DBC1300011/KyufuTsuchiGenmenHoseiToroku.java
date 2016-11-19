/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC1300011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiTuchiHosei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiTuchiHoseiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouRegisterResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhigenmenjyouhouregister.GenmenJyouhouParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouregisterParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011.DBC1300011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011.DBC1300011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011.DataGridItiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1300011.KyufuTsuchiGenmenHoseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1300011.KyufuTsuchiGenmenHoseiTorokuHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1300011.KyufuTsuchiGenmenHoseiTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KyufuhiTuchiHoseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouRegisterManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 画面設計_DBCMN71001_給付費通知減免情報補正登録クラスです。
 *
 * @reamsid_L DBC-2260-010 xuyongchao
 */
public class KyufuTsuchiGenmenHoseiToroku {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString ADDED = new RString("Added");
    private static final RString BTN_HOZON = new RString("btnHozon");
    private static final int NUM_6 = 6;
    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");
//    private static final RString 被保険者 = new RString("被保険者");
    private static final RString 完了メッセージ = new RString("給付費通知減免情報の更新が正常に行われました");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onLoad(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示無し);
//        ViewStateHolder.put(ViewStateKeys.被保険者, 被保険者);
        getHandler(div).onLoad(資格対象者.get識別コード(), 資格対象者.get被保険者番号());
        return ResponseData.of(div).respond();
    }

    /**
     * 画面遷移処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_ButtonHyouji(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        //#100344のご指示によって、ペンディングとする
        // return ResponseData.of(div).forwardWithEventName(DBC1300011TransitionEventName.).respond();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索 ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_ButtonSearch(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        ValidationMessageControlPairs pair = getValidationHandler(div).validate検索する();
        if (pair.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pair).respond();
        }
        KyufuhigenmenjyouhouRegisterManager manager = KyufuhigenmenjyouhouRegisterManager.createInstance();
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo hiHokenshaNo = 資格対象者.get被保険者番号();
        FlexibleYearMonth startTime = FlexibleYearMonth.EMPTY;
        FlexibleYearMonth endTime = FlexibleYearMonth.EMPTY;
        if (div.getTextBoxDateService().getFromValue() != null) {
            startTime = new FlexibleYearMonth(div.getTextBoxDateService().getFromValue().toDateString().substring(0, NUM_6));
        }
        if (div.getTextBoxDateService().getToValue() != null) {
            endTime = new FlexibleYearMonth(div.getTextBoxDateService().getToValue().toDateString().substring(0, NUM_6));
        }
        KyufuhigenmenjyouhouregisterParameter parameter = KyufuhigenmenjyouhouregisterParameter.createSelectByKeyParam(hiHokenshaNo,
                startTime,
                endTime,
                div.getTextBoxNumKensuu().getValue().intValue());
        List<KyufuhigenmenjyouhouRegisterResult> resultList = manager.getGenmenJyouhou(parameter).records();
        List<KyufuhiTuchiHosei> updateList = manager.regGenmenJyouhou(parameter).records();
        ViewStateHolder.put(ViewStateKeys.給付費通知補正, Models.create(updateList));
        getHandler(div).search(resultList);
        return ResponseData.of(div).respond();
    }

    /**
     * 補正情報を追加する ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_ButtonTuika(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().setState(状態_追加);
        div.getKyufuTsuchiGenmenHoseiTorokuSearch().setDisabled(true);
        div.getKyufuTsuchiGenmenHoseiTorokuList().setDisabled(true);
        div.getTextBoxDateSaabisu().setDisabled(false);
        div.getCcdHokenshaList().setDisabled(false);
        div.getCcdJigyoshaInput().setDisabled(false);
        div.getCcdServiceTypeInput().setDisabled(false);
        div.getTextBoxFudangoukei().setDisabled(false);
        div.getTextBoxNumHiyouGoukei().setDisabled(false);
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().setNyuryokuShisetsuKodo(RString.EMPTY);
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().setShisetsuMeisho(RString.EMPTY);
        div.getCcdServiceTypeInput().clear();
        getHandler(div).tuika();
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().setHiddenInputDiv(getHandler(div).getInputDiv());
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正」ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_ButtonModify(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().setState(状態_修正);
        div.getKyufuTsuchiGenmenHoseiTorokuSearch().setDisabled(true);
        div.getKyufuTsuchiGenmenHoseiTorokuList().setDisabled(true);
        div.getTextBoxDateSaabisu().setDisabled(true);
        div.getCcdHokenshaList().setDisabled(true);
        div.getCcdJigyoshaInput().setDisabled(true);
        div.getCcdServiceTypeInput().setDisabled(true);
        div.getTextBoxFudangoukei().setDisabled(false);
        div.getTextBoxNumHiyouGoukei().setDisabled(false);
        getHandler(div).modify();
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().setHiddenInputDiv(getHandler(div).getInputDiv());
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_ButtonDelete(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo hiHokenshaNo = 資格対象者.get被保険者番号();
        Models<KyufuhiTuchiHoseiIdentifier, KyufuhiTuchiHosei> models
                = ViewStateHolder.get(ViewStateKeys.給付費通知補正, Models.class);
        div.getKyufuTsuchiGenmenHoseiTorokuDetail().setState(状態_削除);
        div.getTextBoxDateSaabisu().setDisabled(true);
        div.getCcdHokenshaList().setDisabled(true);
        div.getCcdJigyoshaInput().setDisabled(true);
        div.getCcdServiceTypeInput().setDisabled(true);
        div.getTextBoxFudangoukei().setDisabled(true);
        div.getTextBoxNumHiyouGoukei().setDisabled(true);
        DataGridItiran_Row row = div.getDataGridItiran().getActiveRow();
        int index = div.getDataGridItiran().getClickedRowId();
        RString jotai = new RString(row.getRowState().toString());
        KyufuhiTuchiHoseiIdentifier key = new KyufuhiTuchiHoseiIdentifier(new HokenshaNo(row.getTxtShokisaiNo()),
                hiHokenshaNo,
                new FlexibleYearMonth(row.getTxtServiceNengetsu()),
                new JigyoshaNo(row.getTxtJigyoshaNo()),
                new ServiceShuruiCode(row.getTxtServiceShurui().substring(0, 2)),
                Decimal.ONE);
        if (ADDED.equals(jotai)) {
            models.deleteOrRemove(key);
            div.getDataGridItiran().getDataSource().remove(index);
            getHandler(div).back();
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTN_HOZON, true);
        } else {
            row.setRowState(RowState.Deleted);
            KyufuhiTuchiHosei kyufuhiTuchiHosei = models.get(key).deleted();
            models.deleteOrRemove(key);
            models.add(kyufuhiTuchiHosei);
            ViewStateHolder.put(ViewStateKeys.給付費通知補正, models);
            getHandler(div).delete();
        }
        div.getKyufuTsuchiGenmenHoseiTorokuSearch().setDisabled(true);
        div.getKyufuTsuchiGenmenHoseiTorokuList().setDisabled(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「補正情報を保存する」ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_ButtonHozon(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<KyufuhiTuchiHoseiIdentifier, KyufuhiTuchiHosei> models = ViewStateHolder.
                    get(ViewStateKeys.給付費通知補正, Models.class);
            KyufuhiTuchiHoseiManager kyufuhiTuchiHoseiManager = KyufuhiTuchiHoseiManager.createInstance();
            for (KyufuhiTuchiHosei kyufuhiTuchiHosei : models) {
                kyufuhiTuchiHoseiManager.saveOrdelete給付費通知補正(kyufuhiTuchiHosei);
            }
            TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            HihokenshaNo hiHokenshaNo = 資格対象者.get被保険者番号();
            div.getCcdKanryoMessage().setMessage(完了メッセージ, hiHokenshaNo.value(),
                    div.getKyufuTsuchiGenmenHoseiTorokuKihon().get氏名カナ(), true);
            return ResponseData.of(div).setState(DBC1300011StateName.kanryo);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「補正情報一覧に戻る」ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_ButtonBack(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                    UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).back();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「補正情報を確定する」ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_ButtonKakutei(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        ValidationMessageControlPairs 事業者入力pair = getValidationHandler(div).validate事業者入力();
        if (事業者入力pair.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(事業者入力pair).respond();
        }
        ValidationMessageControlPairs pair = getValidationHandler(div).validate確定する();
        if (pair.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pair).respond();
        }
        div.getKyufuTsuchiGenmenHoseiTorokuSearch().setDisabled(false);
        div.getKyufuTsuchiGenmenHoseiTorokuList().setDisabled(false);
        if (changeCheck(div)) {
            return ResponseData.of(div).respond();
        }
        if (kakutei(div)) {
            addDataGrid(div);
        } else {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(DbcQuestionMessages.給付費通知補正情報登録.getMessage().getCode(),
                        DbcQuestionMessages.給付費通知補正情報登録.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(DbcQuestionMessages.給付費通知補正情報登録.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                addDataGrid(div);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「再検索する」ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_btnResearch(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).back();
            return ResponseData.of(div).forwardWithEventName(DBC1300011TransitionEventName.再検索).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv>
     */
    public ResponseData<KyufuTsuchiGenmenHoseiTorokuDiv> onClick_btnSearchResult(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).back();
            return ResponseData.of(div).forwardWithEventName(DBC1300011TransitionEventName.検索結果一覧).respond();
        }

        return ResponseData.of(div).respond();
    }

    private boolean kakutei(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo hiHokenshaNo = 資格対象者.get被保険者番号();
        KyufuhigenmenjyouhouRegisterManager manager = KyufuhigenmenjyouhouRegisterManager.createInstance();
        GenmenJyouhouParameter parameter = GenmenJyouhouParameter.createByKeyParam(
                hiHokenshaNo,
                new HokenshaNo(div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value()),
                new FlexibleYearMonth(div.getTextBoxDateSaabisu().getValue().toDateString().substring(0, NUM_6)),
                new JigyoshaNo(div.getCcdJigyoshaInput().getNyuryokuShisetsuKodo()),
                new ServiceShuruiCode(div.getCcdServiceTypeInput().getサービス種類コード()),
                Decimal.ZERO,
                Decimal.ZERO,
                Decimal.ONE
        );
        return manager.isKyufuJissekiJyouhou(parameter);
    }

    private void addDataGrid(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo hiHokenshaNo = 資格対象者.get被保険者番号();
        RString イベント状態 = div.getKyufuTsuchiGenmenHoseiTorokuDetail().getState();
        Models<KyufuhiTuchiHoseiIdentifier, KyufuhiTuchiHosei> models
                = ViewStateHolder.get(ViewStateKeys.給付費通知補正, Models.class);
        if (状態_追加.equals(イベント状態)) {
            KyufuhiTuchiHosei kyufuhiTuchiHosei = new KyufuhiTuchiHosei(new HokenshaNo(div.getKyufuTsuchiGenmenHoseiTorokuDetail().
                    getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value()),
                    hiHokenshaNo,
                    new FlexibleYearMonth(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxDateSaabisu().getValue().toDateString().substring(0, NUM_6)),
                    new JigyoshaNo(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().getNyuryokuShisetsuKodo()),
                    new ServiceShuruiCode(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdServiceTypeInput().getサービス種類コード()),
                    Decimal.ONE);
            kyufuhiTuchiHosei = getHandler(div).edit(kyufuhiTuchiHosei);
            if (models == null) {
                List<KyufuhiTuchiHosei> list = new ArrayList<>();
                models = Models.create(list);
            }
            models.add(kyufuhiTuchiHosei);
        } else if (状態_修正.equals(イベント状態)) {
            KyufuhiTuchiHoseiIdentifier key = new KyufuhiTuchiHoseiIdentifier(new HokenshaNo(div.getKyufuTsuchiGenmenHoseiTorokuDetail().
                    getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value()),
                    hiHokenshaNo,
                    new FlexibleYearMonth(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxDateSaabisu().getValue().toDateString().substring(0, NUM_6)),
                    new JigyoshaNo(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().getNyuryokuShisetsuKodo()),
                    new ServiceShuruiCode(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdServiceTypeInput().getサービス種類コード()),
                    Decimal.ONE);
            KyufuhiTuchiHosei kyufuhiTuchiHosei = getHandler(div).edit(models.get(key).modifiedModel());
            models.deleteOrRemove(key);
            models.add(kyufuhiTuchiHosei);
        } else if (状態_削除.equals(イベント状態)) {
            KyufuhiTuchiHoseiIdentifier key = new KyufuhiTuchiHoseiIdentifier(new HokenshaNo(div.getKyufuTsuchiGenmenHoseiTorokuDetail().
                    getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value()),
                    hiHokenshaNo,
                    new FlexibleYearMonth(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getTextBoxDateSaabisu().getValue().toDateString().substring(0, NUM_6)),
                    new JigyoshaNo(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdJigyoshaInput().getNyuryokuShisetsuKodo()),
                    new ServiceShuruiCode(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getCcdServiceTypeInput().getサービス種類コード()),
                    Decimal.ONE);
            RString jotai = new RString(div.getDataGridItiran().getActiveRow().getRowState().toString());
            if (状態_追加.equals(jotai)) {
                models.deleteOrRemove(key);
            } else {
                KyufuhiTuchiHosei kyufuhiTuchiHosei = getHandler(div).edit(models.get(key).
                        deleted());
                models.add(kyufuhiTuchiHosei);
            }

        }

        ViewStateHolder.put(ViewStateKeys.給付費通知補正, models);
        getHandler(div).setDetail(イベント状態);
    }

    private KyufuTsuchiGenmenHoseiTorokuHandler getHandler(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        return new KyufuTsuchiGenmenHoseiTorokuHandler(div);
    }

    private KyufuTsuchiGenmenHoseiTorokuValidationHandler getValidationHandler(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        return new KyufuTsuchiGenmenHoseiTorokuValidationHandler(div);
    }

    private boolean changeCheck(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        RString state = div.getKyufuTsuchiGenmenHoseiTorokuDetail().getState();
        if ((状態_追加.equals(state) || 状態_修正.equals(state)) && (状態_修正.equals(state) && !isUpdate(div))) {
            return true;
        }
        return false;
    }

    private boolean isUpdate(KyufuTsuchiGenmenHoseiTorokuDiv div) {
        return !getHandler(div).getInputDiv().equals(div.getKyufuTsuchiGenmenHoseiTorokuDetail().getHiddenInputDiv());
    }
}
