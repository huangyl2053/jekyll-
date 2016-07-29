/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0900031;

import jp.co.ndensan.reams.db.dbu.business.core.benmeitoroku.BenmeiTorokuMeisaiJoho;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031.BenmeiTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031.DBU0900031StateName;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031.DBU0900031TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0900031.BenmeiTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbu.service.core.benmeitoroku.BenmeiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitateBuilder;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 弁明登録情報Divを制御します。
 *
 * @reamsid_L DBU-1080-020 lijia
 *
 */
public class BenmeiTorokuPanel {

    private static final RString 状態_登録 = new RString("登録");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    private BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho;
    private FlexibleDate 審査請求届出日;
    private FlexibleDate 弁明書作成日;
    private final BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();

    /**
     * 画面初期化を表示です。
     *
     * @param panelDiv ShikakukihonPanelDiv
     * @return ResponseData<ShikakukihonPanelDiv>
     */
    public ResponseData<BenmeiTorokuPanelDiv> onLoad(BenmeiTorokuPanelDiv panelDiv) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        審査請求届出日 = ViewStateHolder.get(ViewStateKeys.審査請求届出日, FlexibleDate.class);
        弁明書作成日 = ViewStateHolder.get(ViewStateKeys.弁明書作成日, FlexibleDate.class);
        RString 初期_状態 = ViewStateHolder.get(ViewStateKeys.状態, RString.class);
        panelDiv.getAtenaPanel().getCcdKaigoAtenaInfo().initialize(識別コード);
        panelDiv.getShikakukihonPanel().getCcdKaigoShikakuKihon().
                initialize(ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号());
        FufukuMoshitate fufukuMoshitate = benmeiTorokuManager.getFufukuMoshitate(識別コード, 被保険者番号, 審査請求届出日);
        ViewStateHolder.put(ViewStateKeys.不服審査申立情報, fufukuMoshitate);
        if (初期_状態.equals(修正)) {
            benmeiTorokuMeisaiJoho = get弁明登録明細情報の取得(識別コード, 被保険者番号, 審査請求届出日);
            if (弁明書作成日 != null && !弁明書作成日.isEmpty() && benmeiTorokuMeisaiJoho != null) {
                get保存情報の取得(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日);
            }
            ViewStateHolder.put(ViewStateKeys.弁明登録情報, benmeiTorokuMeisaiJoho);
            getHandler(panelDiv).initialize(benmeiTorokuMeisaiJoho, 初期_状態, 弁明書作成日);
        } else if (初期_状態.equals(削除)) {
            CommonButtonHolder.setTextByCommonButtonFieldName(new RString("btnSave"), "削除");
            benmeiTorokuMeisaiJoho = get弁明登録明細情報の取得(識別コード, 被保険者番号, 審査請求届出日);
            if (benmeiTorokuMeisaiJoho != null) {
                get保存情報の取得(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日);
                getHandler(panelDiv).initialize(benmeiTorokuMeisaiJoho, 初期_状態, 弁明書作成日);
            } else {
                throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("削除データ"));
            }
        }
        return ResponseData.of(panelDiv).respond();
    }

    /**
     * 画面の「取消する」ボタンの機能を処理です。
     *
     * @param panelDiv ShikakukihonPanelDiv
     * @return ResponseData<ShikakukihonPanelDiv>
     */
    public ResponseData<BenmeiTorokuPanelDiv> onClick_btnCancel(BenmeiTorokuPanelDiv panelDiv) {
        RString processState = panelDiv.getProcessState();
        benmeiTorokuMeisaiJoho = ViewStateHolder.get(ViewStateKeys.弁明登録情報, BenmeiTorokuMeisaiJoho.class);
        if (processState.equals(状態_登録) || processState.equals(修正)) {
            return get弁明登録明細の更新有り無しの判断(benmeiTorokuMeisaiJoho, panelDiv);
        } else if (processState.equals(削除)) {
            return ResponseData.of(panelDiv).forwardWithEventName(DBU0900031TransitionEventName.弁明登録一覧画面に遷移).respond();
        }
        return ResponseData.of(panelDiv).respond();
    }

    /**
     * 画面の「保存する」ボタンの機能を処理です。
     *
     * @param panelDiv ShikakukihonPanelDiv
     * @return ResponseData<ShikakukihonPanelDiv>
     */
    public ResponseData<BenmeiTorokuPanelDiv> onClick_btnSave(BenmeiTorokuPanelDiv panelDiv) {
        RString processState = panelDiv.getProcessState();
        benmeiTorokuMeisaiJoho = ViewStateHolder.get(ViewStateKeys.弁明登録情報, BenmeiTorokuMeisaiJoho.class);
        if (processState.equals(状態_登録)) {
            return get弁明登録明細情報の登録処理(panelDiv);
        } else if (processState.equals(修正)) {
            return get弁明登録明細情報の更新処理(benmeiTorokuMeisaiJoho, panelDiv);
        } else if (processState.equals(削除)) {
            return get弁明登録明細情報の削除処理(panelDiv);
        }
        return ResponseData.of(panelDiv).respond();
    }

    /**
     * 「完了する」ボタンの押下を処理です。
     *
     * @param panelDiv ShikakukihonPanelDiv
     * @return ResponseData<BenmeiTorokuPanelDiv>
     */
    public ResponseData<BenmeiTorokuPanelDiv> onClick_btnComplete(BenmeiTorokuPanelDiv panelDiv) {
        return ResponseData.of(panelDiv).forwardWithEventName(DBU0900031TransitionEventName.処理完了).respond();
    }

    private BenmeiTorokuMeisaiJoho get弁明登録明細情報の取得(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 審査請求届出日) {
        BenmeiTorokuMeisaiJoho benmeiTorokuMeisai
                = benmeiTorokuManager.getBenmeiTorokuMeisaiJoho(識別コード, 被保険者番号, 審査請求届出日);
        return benmeiTorokuMeisai;
    }

    private void get保存情報の取得(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日, FlexibleDate 弁明書作成日) {
        BemmeiNaiyo bemmeiNaiyo = benmeiTorokuManager.getBenmeiNaiyo(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日);
        ViewStateHolder.put(ViewStateKeys.弁明内容, bemmeiNaiyo);
        BemmeishaJoho bemmeishaJoho = benmeiTorokuManager.getBenmeishaJoho(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日);
        ViewStateHolder.put(ViewStateKeys.弁明者情報, bemmeishaJoho);
    }

    private ResponseData<BenmeiTorokuPanelDiv> get弁明登録明細の更新有り無しの判断(
            BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho, BenmeiTorokuPanelDiv panelDiv) {
        if (get弁明登録明細の更新有り無し(benmeiTorokuMeisaiJoho, panelDiv)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(panelDiv).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                return ResponseData.of(panelDiv).forwardWithEventName(DBU0900031TransitionEventName.弁明登録一覧画面に遷移).respond();
            }
        } else {
            return ResponseData.of(panelDiv).forwardWithEventName(DBU0900031TransitionEventName.弁明登録一覧画面に遷移).respond();
        }
        return ResponseData.of(panelDiv).respond();
    }

    private ResponseData<BenmeiTorokuPanelDiv> get弁明登録明細情報の登録処理(BenmeiTorokuPanelDiv panelDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(panelDiv).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            boolean blnState1 = get弁明登録明細情報の登録(panelDiv);
            if (blnState1) {
                panelDiv.getKanryoMessagePanel().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                        .replace(状態_登録.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(panelDiv).setState(DBU0900031StateName.完了状態);
            }
        }
        return ResponseData.of(panelDiv).respond();
    }

    private boolean get弁明登録明細情報の登録(BenmeiTorokuPanelDiv panelDiv) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get被保険者番号();
        審査請求届出日 = ViewStateHolder.get(ViewStateKeys.審査請求届出日, FlexibleDate.class);
        弁明書作成日 = ViewStateHolder.get(ViewStateKeys.弁明書作成日, FlexibleDate.class);
        LasdecCode shichosonCode = benmeiTorokuManager.get地方公共団体コード();
        FufukuMoshitate fufukuMoshitate = benmeiTorokuManager.getFufukuMoshitate(識別コード, 被保険者番号, 審査請求届出日);
        FufukuMoshitateBuilder fufukuBuilder = fufukuMoshitate.createBuilderForEdit();
        if (panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().getValue() == null) {
            弁明書作成日 = FlexibleDate.EMPTY;
        } else {
            弁明書作成日 = new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().getValue().toDateString());
        }
        fufukuBuilder.set弁明書作成日(弁明書作成日);
        fufukuMoshitate = fufukuBuilder.build();
        BemmeiNaiyo bemmeiNaiyo = new BemmeiNaiyo(識別コード, 被保険者番号, 審査請求届出日,
                new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().getValue().toDateString()));
        BemmeiNaiyoBuilder bemmeiNaiyoBuilder = bemmeiNaiyo.createBuilderForEdit();
        bemmeiNaiyoBuilder.set市町村コード(shichosonCode);
        if (panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue() == null) {
            bemmeiNaiyoBuilder.set審査請求に係る処分内容(RString.EMPTY);
        } else {
            bemmeiNaiyoBuilder.set審査請求に係る処分内容(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue());
        }
        if (panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue() == null) {
            bemmeiNaiyoBuilder.set弁明内容(RString.EMPTY);
        } else {
            bemmeiNaiyoBuilder.set弁明内容(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue());
        }
        if (panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeisyoTeishutubi().getValue() == null) {
            bemmeiNaiyoBuilder.set弁明書作成日提出日(FlexibleDate.EMPTY);
        } else {
            bemmeiNaiyoBuilder.set弁明書作成日提出日(new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeisyoTeishutubi().getValue().toDateString()));
        }
        bemmeiNaiyo = bemmeiNaiyoBuilder.build();
        BemmeishaJoho bemmeishaJoho = new BemmeishaJoho(識別コード, 被保険者番号, 審査請求届出日,
                new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().getValue().toDateString()), new Decimal("1"));
        BemmeishaJohoBuilder bemmeishaJohoBuilder = bemmeishaJoho.createBuilderForEdit();
        bemmeishaJohoBuilder.set市町村コード(shichosonCode);
        if (panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue() == null) {
            bemmeishaJohoBuilder.set弁明者氏名(RString.EMPTY);
        } else {
            bemmeishaJohoBuilder.set弁明者氏名(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue());
        }
        bemmeishaJoho = bemmeishaJohoBuilder.build();
        return benmeiTorokuManager.insBenmeiTorokuJoho(fufukuMoshitate, bemmeiNaiyo, bemmeishaJoho);
    }

    private ResponseData<BenmeiTorokuPanelDiv> get弁明登録明細情報の更新処理(
            BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho, BenmeiTorokuPanelDiv panelDiv) {
        if (get弁明登録明細の更新有り無し(benmeiTorokuMeisaiJoho, panelDiv)) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                        UrQuestionMessages.保存の確認.getMessage().evaluate());
                return ResponseData.of(panelDiv).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                get更新処理の実施(panelDiv);
                panelDiv.getKanryoMessagePanel().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                        .replace(修正.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(panelDiv).setState(DBU0900031StateName.完了状態);
            }
        } else {
            throw new ApplicationException("内容が変更されていないため、保存はできません。");
        }
        return ResponseData.of(panelDiv).respond();
    }

    private ResponseData<BenmeiTorokuPanelDiv> get更新処理の実施(BenmeiTorokuPanelDiv panelDiv) {
        boolean blnState = is弁明登録明細情報の削除();
        boolean blnStateIns = get弁明登録明細情報の登録(panelDiv);
        if (blnState && blnStateIns) {
            panelDiv.getKanryoMessagePanel().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                    .replace(修正.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
        }
        return ResponseData.of(panelDiv).respond();
    }

    private ResponseData<BenmeiTorokuPanelDiv> get弁明登録明細情報の削除処理(BenmeiTorokuPanelDiv panelDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(panelDiv).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            boolean blnStateDel = is弁明登録明細情報の削除();
            if (blnStateDel) {
                panelDiv.getKanryoMessagePanel().getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.正常終了.getMessage()
                        .replace(削除.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(panelDiv).setState(DBU0900031StateName.完了状態);
            }
        }
        return ResponseData.of(panelDiv).respond();
    }

    private boolean is弁明登録明細情報の削除() {
        FufukuMoshitate fufukuMoshitate = ViewStateHolder.get(ViewStateKeys.不服審査申立情報, FufukuMoshitate.class);
        FufukuMoshitateBuilder fufukuBuilder = fufukuMoshitate.createBuilderForEdit();
        fufukuBuilder.set弁明書作成日(FlexibleDate.EMPTY);
        fufukuMoshitate = fufukuBuilder.build();
        BemmeiNaiyo bemmeiNaiyo = ViewStateHolder.get(ViewStateKeys.弁明内容, BemmeiNaiyo.class);
        BemmeiNaiyoBuilder bemmeiNaiyoBuilder = bemmeiNaiyo.createBuilderForEdit();
        bemmeiNaiyo = bemmeiNaiyoBuilder.build();
        BemmeishaJoho bemmeishaJoho = ViewStateHolder.get(ViewStateKeys.弁明者情報, BemmeishaJoho.class);
        BemmeishaJohoBuilder bemmeishaJohoBuilder = bemmeishaJoho.createBuilderForEdit();
        bemmeishaJoho = bemmeishaJohoBuilder.build();
        return benmeiTorokuManager.delBenmeiTorokuJoho(fufukuMoshitate, bemmeiNaiyo, bemmeishaJoho);
    }

    private boolean get弁明登録明細の更新有り無し(BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho, BenmeiTorokuPanelDiv panelDiv) {
        if (benmeiTorokuMeisaiJoho == null) {
            return false;
        }
        RString selectResults = get弁明登録明細情報の編集結果(benmeiTorokuMeisaiJoho);
        RString inputDiv = get弁明登録明細入力の編集結果(panelDiv);
        return !selectResults.equals(inputDiv);
    }

    private RString get弁明登録明細情報の編集結果(BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho) {
        RStringBuilder selectResults = new RStringBuilder();
        selectResults.append(
                benmeiTorokuMeisaiJoho.getBemmeishoSakuseiYMD() == null
                ? RString.EMPTY : benmeiTorokuMeisaiJoho.getBemmeishoSakuseiYMD().toString());
        selectResults.append(
                benmeiTorokuMeisaiJoho.getBemmeisha() == null ? RString.EMPTY : benmeiTorokuMeisaiJoho.getBemmeisha());
        selectResults.append(
                benmeiTorokuMeisaiJoho.getShinsaseikyuKankeiShobunNaiyo() == null
                ? RString.EMPTY : benmeiTorokuMeisaiJoho.getShinsaseikyuKankeiShobunNaiyo());
        selectResults.append(
                benmeiTorokuMeisaiJoho.getBemmeiNaiyo() == null ? RString.EMPTY : benmeiTorokuMeisaiJoho.getBemmeiNaiyo());
        selectResults.append(
                benmeiTorokuMeisaiJoho.getBemmeishoTeishutsuYMD() == null
                ? RString.EMPTY : benmeiTorokuMeisaiJoho.getBemmeishoTeishutsuYMD().toString());
        return selectResults.toRString();
    }

    private RString get弁明登録明細入力の編集結果(BenmeiTorokuPanelDiv panelDiv) {
        RStringBuilder inputDiv = new RStringBuilder();
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().getValue().toDateString() == null
                ? RString.EMPTY : panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeiSyoSakuseibi().getValue().toDateString());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue() == null
                ? RString.EMPTY : panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue() == null
                ? RString.EMPTY : panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue() == null
                ? RString.EMPTY : panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue());
        RDate 弁明書提出日 = panelDiv.getBenmeiTorokuMeisaiPanel().getTxtBenmeisyoTeishutubi().getValue();
        inputDiv.append(弁明書提出日 == null ? RString.EMPTY : 弁明書提出日.toDateString());
        return inputDiv.toRString();
    }

    private BenmeiTorokuPanelHandler getHandler(BenmeiTorokuPanelDiv div) {
        return new BenmeiTorokuPanelHandler(div);
    }
}
