/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0900031;

import jp.co.ndensan.reams.db.dbu.business.core.benmeitoroku.BenmeiTorokuMeisaiJoho;
import jp.co.ndensan.reams.db.dbu.definition.core.benmeitoroku.BenmeiTorokuViewStateKeys;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031.BenmeiTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900031.DBU0900031TransitionEventName;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.dbu0900031.BenmeiTorokuPanelHandler;
import jp.co.ndensan.reams.db.dbu.service.core.benmeitoroku.BenmeiTorokuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitate;
import jp.co.ndensan.reams.db.dbz.business.core.basic.FufukuMoshitateBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
    private HihokenshaNo 被保険者番号;
    private FlexibleDate 審査請求届出日;
    private FlexibleDate 弁明書作成日;

    /**
     * 画面初期化を表示です。
     *
     * @param panelDiv ShikakukihonPanelDiv
     * @return ResponseData<ShikakukihonPanelDiv>
     */
    public ResponseData<BenmeiTorokuPanelDiv> onLoad(BenmeiTorokuPanelDiv panelDiv) {
        //TODO ViewStateより弁明登録一覧画面からの引き継ぎ情報を取得する。
        識別コード = ViewStateHolder.get(BenmeiTorokuViewStateKeys.識別コード, ShikibetsuCode.class);
        被保険者番号 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.被保険者番号, HihokenshaNo.class);
        審査請求届出日 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.審査請求届出日, FlexibleDate.class);
        弁明書作成日 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.弁明書作成日, FlexibleDate.class);
        RString 初期_状態 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.モード, RString.class);
        //TODO 共通Div（AtenaCommonChildDiv）を呼び出しの場合、異常を発生する。
        //panelDiv.getAtenaPanel().getAtenaCommonChildDiv().load(識別コード);
        panelDiv.getShikakuKihonCommonChildDiv().initialize(被保険者番号);
        get保存情報の取得(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日);
        if (初期_状態.equals(状態_修正)) {
            benmeiTorokuMeisaiJoho = get弁明登録明細情報の取得(識別コード, 被保険者番号, 審査請求届出日);
            ViewStateHolder.put(BenmeiTorokuViewStateKeys.弁明登録情報, benmeiTorokuMeisaiJoho);
            getHandler(panelDiv).initialize(benmeiTorokuMeisaiJoho, 初期_状態);
        } else if (初期_状態.equals(状態_削除)) {
            benmeiTorokuMeisaiJoho = get弁明登録明細情報の取得(識別コード, 被保険者番号, 審査請求届出日);
            if (benmeiTorokuMeisaiJoho != null) {
                getHandler(panelDiv).initialize(benmeiTorokuMeisaiJoho, 初期_状態);
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
        benmeiTorokuMeisaiJoho = ViewStateHolder.get(BenmeiTorokuViewStateKeys.弁明登録情報, BenmeiTorokuMeisaiJoho.class);
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
            HihokenshaNo 被保険者番号,
            FlexibleDate 審査請求届出日) {
        BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
        BenmeiTorokuMeisaiJoho benmeiTorokuMeisai
                = benmeiTorokuManager.getBenmeiTorokuMeisaiJoho(識別コード, 被保険者番号, 審査請求届出日);
        return benmeiTorokuMeisai;
    }

    private void get保存情報の取得(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日, FlexibleDate 弁明書作成日) {
        BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
        FufukuMoshitate fufukuMoshitate = benmeiTorokuManager.getFufukuMoshitate(識別コード, 被保険者番号, 審査請求届出日);
        ViewStateHolder.put(BenmeiTorokuViewStateKeys.不服審査申立情報, fufukuMoshitate);
        BemmeiNaiyo bemmeiNaiyo = benmeiTorokuManager.getBenmeiNaiyo(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日);
        ViewStateHolder.put(BenmeiTorokuViewStateKeys.弁明内容, bemmeiNaiyo);
        BemmeishaJoho bemmeishaJoho = benmeiTorokuManager.getBenmeishaJoho(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日);
        ViewStateHolder.put(BenmeiTorokuViewStateKeys.弁明者情報, bemmeishaJoho);
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
            識別コード = ViewStateHolder.get(BenmeiTorokuViewStateKeys.識別コード, ShikibetsuCode.class);
            被保険者番号 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.被保険者番号, HihokenshaNo.class);
            審査請求届出日 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.審査請求届出日, FlexibleDate.class);
            弁明書作成日 = ViewStateHolder.get(BenmeiTorokuViewStateKeys.弁明書作成日, FlexibleDate.class);

            BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
            LasdecCode shichosonCode = benmeiTorokuManager.get地方公共団体コード();
            FufukuMoshitate fufukuMoshitate = new FufukuMoshitate(識別コード, 被保険者番号, 審査請求届出日);
            FufukuMoshitateBuilder fufukuBuilder = fufukuMoshitate.createBuilderForEdit();
            fufukuBuilder.set弁明書作成日(new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().getValue().toDateString()));
            fufukuMoshitate = fufukuBuilder.build();
            BemmeiNaiyo bemmeiNaiyo = new BemmeiNaiyo(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日);
            BemmeiNaiyoBuilder bemmeiNaiyoBuilder = bemmeiNaiyo.createBuilderForEdit();
            bemmeiNaiyoBuilder.set市町村コード(shichosonCode);
            bemmeiNaiyoBuilder.set審査請求に係る処分内容(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue());
            bemmeiNaiyoBuilder.set弁明内容(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue());
            bemmeiNaiyoBuilder.set弁明書作成日提出日(new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().getValue().toDateString()));
            bemmeiNaiyo = bemmeiNaiyoBuilder.build();
            BemmeishaJoho bemmeishaJoho = new BemmeishaJoho(識別コード, 被保険者番号, 審査請求届出日, 弁明書作成日, new Decimal("1"));
            BemmeishaJohoBuilder bemmeishaJohoBuilder = bemmeishaJoho.createBuilderForEdit();
            bemmeishaJohoBuilder.set市町村コード(shichosonCode);
            bemmeishaJohoBuilder.set弁明者氏名(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue());
            bemmeishaJoho = bemmeishaJohoBuilder.build();

            boolean blnState = get弁明登録明細情報の登録処理結果(fufukuMoshitate, bemmeiNaiyo, bemmeishaJoho);
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

                FufukuMoshitate fufukuMoshitate = ViewStateHolder.get(BenmeiTorokuViewStateKeys.不服審査申立情報, FufukuMoshitate.class);
                FufukuMoshitateBuilder fufukuBuilder = fufukuMoshitate.createBuilderForEdit();
                fufukuBuilder.set弁明書作成日(new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().getValue().toDateString()));
                fufukuMoshitate = fufukuBuilder.build();

                BemmeiNaiyo bemmeiNaiyo = ViewStateHolder.get(BenmeiTorokuViewStateKeys.弁明内容, BemmeiNaiyo.class);
                BemmeiNaiyoBuilder bemmeiNaiyoBuilder = bemmeiNaiyo.createBuilderForEdit();
                //TODO PKをUpdateする
                //bemmeiNaiyoBuilder.set弁明書作成日();
                bemmeiNaiyoBuilder.set弁明内容(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue());
                bemmeiNaiyoBuilder.set審査請求に係る処分内容(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue());
                bemmeiNaiyoBuilder.set弁明書作成日提出日(new FlexibleDate(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().getValue().toDateString()));
                bemmeiNaiyo = bemmeiNaiyoBuilder.build();

                BemmeishaJoho bemmeishaJoho = ViewStateHolder.get(BenmeiTorokuViewStateKeys.弁明者情報, BemmeishaJoho.class);
                BemmeishaJohoBuilder bemmeishaJohoBuilder = bemmeishaJoho.createBuilderForEdit();
                //TODO PKをUpdateする
                //bemmeishaJohoBuilder.set弁明書作成日();
                bemmeishaJohoBuilder.set弁明者氏名(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue());
                bemmeishaJoho = bemmeishaJohoBuilder.build();

                boolean blnState = get弁明登録明細情報の更新処理結果(fufukuMoshitate, bemmeiNaiyo, bemmeishaJoho);
                if (blnState) {
                    //TODO DBZInformationMessage．DBZI00004（更新は正常に終了しました。）
                    return ResponseData.of(panelDiv).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
                }
            }
        } else {
            //TODO DBZInformationMessage．DBZI00006（内容が変更されていないため、保存はできません。） 明細画面に戻る
            throw new ApplicationException(UrErrorMessages.必須項目.getMessage());
        }
        return ResponseData.of(panelDiv).respond();
    }

    private ResponseData<BenmeiTorokuPanelDiv> get弁明登録明細情報の削除処理(BenmeiTorokuPanelDiv panelDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(panelDiv).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            FufukuMoshitate fufukuMoshitate = ViewStateHolder.get(BenmeiTorokuViewStateKeys.不服審査申立情報, FufukuMoshitate.class);
            FufukuMoshitateBuilder fufukuBuilder = fufukuMoshitate.createBuilderForEdit();
            fufukuBuilder.set弁明書作成日(new FlexibleDate(""));
            fufukuMoshitate = fufukuBuilder.build();
            BemmeiNaiyo bemmeiNaiyo = ViewStateHolder.get(BenmeiTorokuViewStateKeys.弁明内容, BemmeiNaiyo.class);
            BemmeiNaiyoBuilder bemmeiNaiyoBuilder = bemmeiNaiyo.createBuilderForEdit();
            bemmeiNaiyo = bemmeiNaiyoBuilder.build();
            BemmeishaJoho bemmeishaJoho = ViewStateHolder.get(BenmeiTorokuViewStateKeys.弁明者情報, BemmeishaJoho.class);
            BemmeishaJohoBuilder bemmeishaJohoBuilder = bemmeishaJoho.createBuilderForEdit();
            bemmeishaJoho = bemmeishaJohoBuilder.build();
            boolean blnState = get弁明登録明細情報の削除処理結果(fufukuMoshitate, bemmeiNaiyo, bemmeishaJoho);
            if (blnState) {
                //TODO DBZInformationMessage．DBZI00005(削除は正常に終了しました。）
                return ResponseData.of(panelDiv).addMessage(UrInformationMessages.対象データ削除済み.getMessage()).respond();
            }
        }
        return ResponseData.of(panelDiv).respond();
    }

    private boolean get弁明登録明細情報の登録処理結果(FufukuMoshitate fufukuMoshitate, BemmeiNaiyo bemmeiNaiyo, BemmeishaJoho bemmeishaJoho) {
        BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
        return benmeiTorokuManager.insBenmeiTorokuJoho(fufukuMoshitate, bemmeiNaiyo, bemmeishaJoho);
    }

    private boolean get弁明登録明細情報の更新処理結果(FufukuMoshitate fufukuMoshitate, BemmeiNaiyo bemmeiNaiyo, BemmeishaJoho bemmeishaJoho) {
        BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
        return benmeiTorokuManager.updBenmeiTorokuJoho(fufukuMoshitate, bemmeiNaiyo, bemmeishaJoho);
    }

    private boolean get弁明登録明細情報の削除処理結果(FufukuMoshitate fufukuMoshitate, BemmeiNaiyo bemmeiNaiyo, BemmeishaJoho bemmeishaJoho) {
        BenmeiTorokuManager benmeiTorokuManager = BenmeiTorokuManager.createInstance();
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
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().getValue().toDateString() == null
                ? RString.EMPTY : panelDiv.getBenmeiTorokuMeisaiPanel().getTxtdateBenmeiSyoSakuseibi().getValue().toDateString());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue() == null
                ? RString.EMPTY : panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeisya().getValue());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue() == null
                ? RString.EMPTY : panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineShobunNaiyo().getValue());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue() == null
                ? RString.EMPTY : panelDiv.getBenmeiTorokuMeisaiPanel().getTxtMultiLineBenmeiNaiyo().getValue());
        inputDiv.append(panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().getValue().toDateString() == null
                ? RString.EMPTY : panelDiv.getBenmeiTorokuMeisaiPanel().getTxtDateBenmeisyoTeishutubi().getValue().toDateString());
        return inputDiv.toRString();
    }

    private BenmeiTorokuPanelHandler getHandler(BenmeiTorokuPanelDiv div) {
        return new BenmeiTorokuPanelHandler(div);
    }
}
