/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0900031;

import jp.co.ndensan.reams.db.dbu.business.core.benmeitoroku.BenmeiTorokuMeisaiJoho;
import jp.co.ndensan.reams.db.dbu.definition.core.benmeitoroku.BenmeiTorokuViewStateKeys;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031.BenmeiTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0900031.BenmeiTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbu.service.core.benmeitoroku.BenmeiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 弁明登録情報Divを制御します。
 *
 */
public class BenmeiTorokuPanel {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho;
    private ShikibetsuCode 識別コード;
    private HihokenshaNo 原処分被保険者番号;
    private FlexibleDate 審査請求届出日;

    /**
     * 画面初期化を表示です。
     *
     * @param panelDiv ShikakukihonPanelDiv
     * @return ResponseData<ShikakukihonPanelDiv>
     */
    public ResponseData<BenmeiTorokuPanelDiv> onLoad(BenmeiTorokuPanelDiv panelDiv) {
        ViewStateHolder.put(BenmeiTorokuViewStateKeys.モード, 状態_修正);
        ViewStateHolder.put(BenmeiTorokuViewStateKeys.識別コード, new ShikibetsuCode("201609"));
        ViewStateHolder.put(BenmeiTorokuViewStateKeys.原処分被保険者番号, new HihokenshaNo("20160101"));
        ViewStateHolder.put(BenmeiTorokuViewStateKeys.審査請求届出日, new FlexibleDate("20160104"));
        //TODO ViewStateより弁明登録一覧画面からの引き継ぎ情報を取得する。
        識別コード = ViewStateHolder.get(BenmeiTorokuViewStateKeys.識別コード, ShikibetsuCode.class);
        原処分被保険者番号 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.原処分被保険者番号, HihokenshaNo.class);
        審査請求届出日 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.審査請求届出日, FlexibleDate.class);
        RString viewState = ViewStateHolder.get(BenmeiTorokuViewStateKeys.モード, RString.class);
        //TODO 共通Div（AtenaCommonChildDiv）異常を発生する。
        //panelDiv.getAtenaPanel().getAtenaCommonChildDiv().load(識別コード);
        panelDiv.getShikakuKihonCommonChildDiv().initialize(原処分被保険者番号);
        if (viewState.equals(状態_修正)) {
            benmeiTorokuMeisaiJoho = get弁明登録明細情報の取得(識別コード, 原処分被保険者番号, 審査請求届出日);
            ViewStateHolder.put(BenmeiTorokuViewStateKeys.弁明登録情報, benmeiTorokuMeisaiJoho);
            getHandler(panelDiv).initialize(benmeiTorokuMeisaiJoho, viewState);
        } else if (viewState.equals(状態_削除)) {
            benmeiTorokuMeisaiJoho = get弁明登録明細情報の取得(識別コード, 原処分被保険者番号, 審査請求届出日);
            if (benmeiTorokuMeisaiJoho != null) {
                getHandler(panelDiv).initialize(benmeiTorokuMeisaiJoho, viewState);
            } else {
                throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
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
        benmeiTorokuMeisaiJoho = ViewStateHolder.get(BenmeiTorokuViewStateKeys.弁明登録情報, BenmeiTorokuMeisaiJoho.class);
        if (processState.equals(状態_追加) || processState.equals(状態_修正)) {
            return get弁明登録明細の更新有り無しの判断(benmeiTorokuMeisaiJoho, panelDiv);
        } else if (processState.equals(状態_削除)) {
            //TODO明細画面を閉じて、弁明登録一覧画面に遷移する。
            //return ResponseData.of(panelDiv).forwardWithEventName(eventName).respond();
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
        benmeiTorokuMeisaiJoho = ViewStateHolder.get(BenmeiTorokuViewStateKeys.弁明登録情報, BenmeiTorokuMeisaiJoho.class);
        if (panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().getValue().toDateString() == null
                || panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().getValue().toDateString().equals(new RString(""))) {
            throw new ApplicationException(UrErrorMessages.必須項目.getMessage());
        }
        if (processState.equals(状態_追加)) {
            return get弁明登録明細情報の登録処理(panelDiv);
        } else if (processState.equals(状態_修正)) {
            return get弁明登録明細情報の更新処理(benmeiTorokuMeisaiJoho, panelDiv);
        } else if (processState.equals(状態_削除)) {
            return get弁明登録明細情報の削除処理(panelDiv);
        }
        return ResponseData.of(panelDiv).respond();
    }

    private BenmeiTorokuMeisaiJoho get弁明登録明細情報の取得(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) {
        BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
        BenmeiTorokuMeisaiJoho benmeiTorokuMeisai
                = benmeiTorokuManager.getBenmeiTorokuMeisaiJoho(識別コード, 原処分被保険者番号, 審査請求届出日);
        return benmeiTorokuMeisai;
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
                //TODO 明細画面に入力した内容を破棄して、弁明登録一覧画面に遷移する。
                //return ResponseData.of(panelDiv).forwardWithEventName(eventName).respond();
            }
        } else {
            //TODO明細画面を閉じて、弁明登録一覧画面に遷移する。
            //return ResponseData.of(panelDiv).forwardWithEventName(eventName).respond();
        }
        return ResponseData.of(panelDiv).respond();
    }

    private ResponseData<BenmeiTorokuPanelDiv> get弁明登録明細情報の登録処理(BenmeiTorokuPanelDiv panelDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(panelDiv).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            識別コード = ViewStateHolder.get(BenmeiTorokuViewStateKeys.識別コード, ShikibetsuCode.class);
            原処分被保険者番号 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.原処分被保険者番号, HihokenshaNo.class);
            審査請求届出日 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.審査請求届出日, FlexibleDate.class);
            boolean blnState = get弁明登録明細情報の登録処理結果(
                    識別コード, 原処分被保険者番号, 審査請求届出日,
                    new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().getValue().toDateString()),
                    panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue(),
                    panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue(),
                    panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue(),
                    new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().getValue().toDateString()));
            if (blnState) {
                //TODO DBZInformationMessage．DBZI00007（登録は正常に終了しました。）
                return ResponseData.of(panelDiv).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
            }
        }
        return ResponseData.of(panelDiv).respond();
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
                return get弁明登録明細情報の更新処理実行(panelDiv);
            }
        } else {
            //TODO DBZInformationMessage．DBZI00006（内容が変更されていないため、保存はできません。） 明細画面に戻る
            throw new ApplicationException(UrErrorMessages.必須項目.getMessage());
        }
        return ResponseData.of(panelDiv).respond();
    }

    private ResponseData<BenmeiTorokuPanelDiv> get弁明登録明細情報の更新処理実行(BenmeiTorokuPanelDiv panelDiv) {
        識別コード = ViewStateHolder.get(BenmeiTorokuViewStateKeys.識別コード, ShikibetsuCode.class);
        原処分被保険者番号 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.原処分被保険者番号, HihokenshaNo.class);
        審査請求届出日 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.審査請求届出日, FlexibleDate.class);
        boolean blnState = get弁明登録明細情報の更新処理結果(識別コード, 原処分被保険者番号, 審査請求届出日,
                new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().getValue().toDateString()),
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue(),
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue(),
                panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue(),
                new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().getValue().toDateString()));
        if (blnState) {
            //TODO DBZInformationMessage．DBZI00004（更新は正常に終了しました。）
            return ResponseData.of(panelDiv).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        }
        return ResponseData.of(panelDiv).respond();
    }

    private ResponseData<BenmeiTorokuPanelDiv> get弁明登録明細情報の削除処理(BenmeiTorokuPanelDiv panelDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(panelDiv).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            識別コード = ViewStateHolder.get(BenmeiTorokuViewStateKeys.識別コード, ShikibetsuCode.class);
            原処分被保険者番号 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.原処分被保険者番号, HihokenshaNo.class);
            審査請求届出日 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.審査請求届出日, FlexibleDate.class);
            boolean blnState = get弁明登録明細情報の削除処理結果(識別コード, 原処分被保険者番号, 審査請求届出日);
            if (blnState) {
                //TODO DBZInformationMessage．DBZI00005(削除は正常に終了しました。）
                return ResponseData.of(panelDiv).addMessage(UrInformationMessages.対象データ削除済み.getMessage()).respond();
            }
        }
        return ResponseData.of(panelDiv).respond();
    }

    private boolean get弁明登録明細情報の登録処理結果(ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            RString 弁明者,
            RString 審査請求に係る処分内容,
            RString 弁明内容,
            FlexibleDate 弁明書提出日) {
        BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
        return benmeiTorokuManager.insBenmeiTorokuJoho(
                識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日, 弁明者, 審査請求に係る処分内容, 弁明内容, 弁明書提出日);
    }

    private boolean get弁明登録明細情報の更新処理結果(ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            RString 弁明者,
            RString 審査請求に係る処分内容,
            RString 弁明内容,
            FlexibleDate 弁明書提出日) {
        BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
        return benmeiTorokuManager.updBenmeiTorokuJoho(
                識別コード, 原処分被保険者番号, 審査請求届出日, 弁明書作成日, 弁明者, 審査請求に係る処分内容, 弁明内容, 弁明書提出日);
    }

    private boolean get弁明登録明細情報の削除処理結果(ShikibetsuCode 識別コード, HihokenshaNo 原処分被保険者番号, FlexibleDate 審査請求届出日) {
        BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
        return benmeiTorokuManager.delBenmeiTorokuJoho(識別コード, 原処分被保険者番号, 審査請求届出日);
    }

    private boolean get弁明登録明細の更新有り無し(BenmeiTorokuMeisaiJoho benmeiTorokuMeisaiJoho, BenmeiTorokuPanelDiv panelDiv) {
        RString selectResults = get弁明登録明細情報の編集結果(benmeiTorokuMeisaiJoho);
        RString inputDiv = get弁明登録明細入力の編集結果(panelDiv);
        if (selectResults.equals(inputDiv)) {
            return false;
        }
        return true;
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
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().getValue().toDateString());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().getValue().toDateString());
        return inputDiv.toRString();
    }

    private BenmeiTorokuPanelHandler getHandler(BenmeiTorokuPanelDiv div) {
        return new BenmeiTorokuPanelHandler(div);
    }
}
