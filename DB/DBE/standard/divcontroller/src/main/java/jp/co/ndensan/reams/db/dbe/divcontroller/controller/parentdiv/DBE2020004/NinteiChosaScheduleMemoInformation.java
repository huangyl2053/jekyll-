/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020004;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020004.DBE2020004StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004.NinteiChosaScheduleMemoInformationDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004.dgListOfCommonMemo_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004.dgListOfJichikuMemo_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020004.NinteiChosaScheduleMemoInformationHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020004.NinteiChosaScheduleMemoInformationValidationHandler;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiChosaScheduleMemo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiChosaScheduleMemoIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiChosaScheduleMemoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 認定調査スケジュール登録4のコントローラです。
 */
public class NinteiChosaScheduleMemoInformation {

    private final NinteiChosaScheduleMemoManager ninteiChosaScheduleMemoManager;
    private static final RString 通常 = new RString("通常");
    private static final RString 重要 = new RString("重要");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * コンストラクタです。
     */
    public NinteiChosaScheduleMemoInformation() {
        ninteiChosaScheduleMemoManager = NinteiChosaScheduleMemoManager.createInstance();
    }

    /**
     * 画面初期化処理です。
     *
     * @param div NinteiChosaIraiDiv
     * @return ResponseData<NinteiChosaIraiDiv>
     */
    public ResponseData<NinteiChosaScheduleMemoInformationDiv> onLoad(NinteiChosaScheduleMemoInformationDiv div) {

        FlexibleDate メモ年月日 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, FlexibleDate.class);
        Code 地区コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, Code.class);
        List<NinteiChosaScheduleMemo> ninteiChosaScheduleMemo = ninteiChosaScheduleMemoManager.
                get認定調査スケジュールメモ文本情報(メモ年月日, 地区コード).records();
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録_認定調査スケジュールメモ情報,
                Models.create(ninteiChosaScheduleMemo));
        int 通常件数 = getメモ情報件数(メモ年月日, 地区コード, 通常);
        int 重要件数 = getメモ情報件数(メモ年月日, 地区コード, 重要);
        int maxNo = ninteiChosaScheduleMemoManager.getMax連番();
        div.setMax連番(new RString(String.valueOf(maxNo)));
        getHandler(div).onLoad(ninteiChosaScheduleMemo, メモ年月日, 地区コード, 通常件数, 重要件数);
        return ResponseData.of(div).setState(DBE2020004StateName.スケジュールメモ);
    }

    /**
     * 共通メモ一覧に追加ボタンを押下時の処理。
     *
     * @param div 認定調査スケジュール情報Div
     * @return ResponseData
     */
    public ResponseData onClick_CommonAdd(NinteiChosaScheduleMemoInformationDiv div) {
        getHandler(div).getCommonAdd();
        return ResponseData.of(div).setState(DBE2020004StateName.スケジュールメモ);
    }

    /**
     * 共通編集アイコンを押下時の処理。
     *
     * @param div 認定調査スケジュール情報Div
     * @return ResponseData
     */
    public ResponseData onClick_EditCommon(NinteiChosaScheduleMemoInformationDiv div) {
        getHandler(div).getEditCommon();
        return ResponseData.of(div).setState(DBE2020004StateName.スケジュールメモ);
    }

    /**
     * 自地区メモ一覧に追加ボタンを押下時の処理。
     *
     * @param div 認定調査スケジュール情報Div
     * @return ResponseData
     */
    public ResponseData onClick_AutoAdd(NinteiChosaScheduleMemoInformationDiv div) {
        getHandler(div).getAutoAdd();
        return ResponseData.of(div).setState(DBE2020004StateName.スケジュールメモ);
    }

    /**
     * 自地区編集を押下時の処理。
     *
     * @param div 認定調査スケジュール情報Div
     * @return ResponseData
     */
    public ResponseData onClick_EditAuto(NinteiChosaScheduleMemoInformationDiv div) {
        getHandler(div).getEditAuto();
        return ResponseData.of(div).setState(DBE2020004StateName.スケジュールメモ);
    }

    /**
     * 中止ボタンを押下時の処理。
     *
     * @param div 認定調査スケジュール情報Div
     * @return ResponseData
     */
    public ResponseData onClick_ChuShi(NinteiChosaScheduleMemoInformationDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).内容の破棄();
        }
        return ResponseData.of(div).setState(DBE2020004StateName.スケジュールメモ);
    }

    /**
     * 削除ボタンを押下時の処理。
     *
     * @param div 認定調査スケジュール情報Div
     * @return ResponseData
     */
    public ResponseData onClick_Delete(NinteiChosaScheduleMemoInformationDiv div) {

        getHandler(div).onClick_Delete();
        return ResponseData.of(div).setState(DBE2020004StateName.スケジュールメモ);
    }

    /**
     * 登録ボタンを押下時の処理。
     *
     * @param div 認定調査スケジュール情報Div
     * @return ResponseData
     */
    public ResponseData onClick_Login(NinteiChosaScheduleMemoInformationDiv div) {
        if (getValidationHandler(div).メモの種類の必須チェック().iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(getValidationHandler(div).メモの種類の必須チェック()).respond();
        }
        getHandler(div).onClick_Login();
        return ResponseData.of(div).setState(DBE2020004StateName.スケジュールメモ);
    }

    /**
     * 保存するボタンを押下時の処理。
     *
     * @param div 認定調査スケジュール情報Div
     * @return ResponseData
     */
    public ResponseData onClick_Save(NinteiChosaScheduleMemoInformationDiv div) {

        if (getValidationHandler(div).一覧データの編集状態チェック().iterator().hasNext()) {

            return ResponseData.of(div).addValidationMessages(getValidationHandler(div).一覧データの編集状態チェック()).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            FlexibleDate メモ年月日 = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_設定日, FlexibleDate.class);
            Code 地区コード = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録_地区コード, Code.class);

            Models<NinteiChosaScheduleMemoIdentifier, NinteiChosaScheduleMemo> models = ViewStateHolder
                    .get(ViewStateKeys.認定調査スケジュール登録_認定調査スケジュールメモ情報, Models.class);
            for (dgListOfCommonMemo_Row dg_Row : div.getDgListOfCommonMemo().getDataSource()) {

                if (追加.equals(dg_Row.getJotai())) {

                    NinteiChosaScheduleMemo modelsNinteiChosaScheduleMemo
                            = new NinteiChosaScheduleMemo(メモ年月日, 地区コード,
                                    new Code(dg_Row.getMemokubun()),
                                    Integer.parseInt(dg_Row.getMemono().toString()));
                    NinteiChosaScheduleMemo ninteiChosaScheduleMemo = getHandler(div).
                            共通メモ一覧_登録と修正の編集(メモ年月日, 地区コード, dg_Row, modelsNinteiChosaScheduleMemo);
                    ninteiChosaScheduleMemo.toEntity().initializeMd5();
                    ninteiChosaScheduleMemoManager.save認定調査スケジュールメモ情報(ninteiChosaScheduleMemo);
                }
                if (修正.equals(dg_Row.getJotai())) {

                    NinteiChosaScheduleMemoIdentifier identifier = new NinteiChosaScheduleMemoIdentifier(メモ年月日,
                            地区コード, new Code(dg_Row.getMemokubun()),
                            Integer.parseInt(dg_Row.getMemono().toString()));
                    NinteiChosaScheduleMemo modelsNinteiChosaScheduleMemo = models.get(identifier);
                    NinteiChosaScheduleMemo ninteiChosaScheduleMemo = getHandler(div).
                            共通メモ一覧_登録と修正の編集(メモ年月日, 地区コード, dg_Row, modelsNinteiChosaScheduleMemo);
                    ninteiChosaScheduleMemo.toEntity().initializeMd5();
                    ninteiChosaScheduleMemoManager.save認定調査スケジュールメモ情報(ninteiChosaScheduleMemo.modifiedModel());
                }
                if (削除.equals(dg_Row.getJotai())) {

                    NinteiChosaScheduleMemoIdentifier identifier = new NinteiChosaScheduleMemoIdentifier(メモ年月日,
                            地区コード, new Code(dg_Row.getMemokubun()),
                            Integer.parseInt(dg_Row.getMemono().toString()));
                    NinteiChosaScheduleMemo modelsNinteiChosaScheduleMemo = models.get(identifier);
                    ninteiChosaScheduleMemoManager.delete認定調査スケジュールメモ情報(modelsNinteiChosaScheduleMemo.deleted());
                }
            }

            for (dgListOfJichikuMemo_Row dg_Row : div.getDgListOfJichikuMemo().getDataSource()) {

                if (追加.equals(dg_Row.getJotai())) {

                    NinteiChosaScheduleMemo modelsNinteiChosaScheduleMemo
                            = new NinteiChosaScheduleMemo(メモ年月日, 地区コード,
                                    new Code(dg_Row.getMemokubun()),
                                    Integer.parseInt(dg_Row.getMemono().toString()));
                    NinteiChosaScheduleMemo ninteiChosaScheduleMemo = getHandler(div).
                            自地区メモ一覧_登録と修正の編集(メモ年月日, 地区コード, dg_Row, modelsNinteiChosaScheduleMemo);
                    ninteiChosaScheduleMemoManager.save認定調査スケジュールメモ情報(ninteiChosaScheduleMemo);
                }
                if (修正.equals(dg_Row.getJotai())) {

                    NinteiChosaScheduleMemoIdentifier identifier = new NinteiChosaScheduleMemoIdentifier(メモ年月日,
                            地区コード, new Code(dg_Row.getMemokubun()),
                            Integer.parseInt(dg_Row.getMemono().toString()));
                    NinteiChosaScheduleMemo modelsNinteiChosaScheduleMemo = models.get(identifier);
                    NinteiChosaScheduleMemo ninteiChosaScheduleMemo = getHandler(div).
                            自地区メモ一覧_登録と修正の編集(メモ年月日, 地区コード, dg_Row, modelsNinteiChosaScheduleMemo);
                    ninteiChosaScheduleMemoManager.save認定調査スケジュールメモ情報(ninteiChosaScheduleMemo.modifiedModel());
                }
                if (削除.equals(dg_Row.getJotai())) {

                    NinteiChosaScheduleMemoIdentifier identifier = new NinteiChosaScheduleMemoIdentifier(メモ年月日,
                            地区コード, new Code(dg_Row.getMemokubun()),
                            Integer.parseInt(dg_Row.getMemono().toString()));
                    NinteiChosaScheduleMemo modelsNinteiChosaScheduleMemo = models.get(identifier);
                    ninteiChosaScheduleMemoManager.delete認定調査スケジュールメモ情報(modelsNinteiChosaScheduleMemo.deleted());
                }
            }
        }
        // TODO 画面の戻るボタンを実装しない、前排他を実装しない、遷移を実装しない。内部番号：612
        return ResponseData.of(div).setState(DBE2020004StateName.スケジュールメモ);
    }

    private NinteiChosaScheduleMemoInformationHandler getHandler(NinteiChosaScheduleMemoInformationDiv div) {
        return new NinteiChosaScheduleMemoInformationHandler(div);
    }

    private NinteiChosaScheduleMemoInformationValidationHandler getValidationHandler(NinteiChosaScheduleMemoInformationDiv div) {
        return new NinteiChosaScheduleMemoInformationValidationHandler(div);
    }

    private int getメモ情報件数(FlexibleDate メモ年月日, Code 地区コード, RString 通常または重要フラグ) {

        return ninteiChosaScheduleMemoManager.getメモ情報件数(メモ年月日, 地区コード, 通常または重要フラグ);
    }
}
