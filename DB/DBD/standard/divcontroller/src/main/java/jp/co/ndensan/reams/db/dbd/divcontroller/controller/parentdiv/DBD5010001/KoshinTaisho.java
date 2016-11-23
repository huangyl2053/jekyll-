/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd5010001.KoshinTaishoBussiness;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511002.DBD511002_KoshinOshiraseTsuchiParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.DBD5010001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001.KoshinTaishoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5010001.KoshinTaishoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5010001.KoshinTaishoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.dbd5010001.KoshinTaishoManager;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のDivControllerです。
 *
 * @author_L DBD-2030-010 x_youyj
 */
public class KoshinTaisho {

    private static final RString CSVファイル名 = new RString("更新管理対象者一覧.csv");
    private static final RString CSV調査ファイル名 = new RString("調査データ（モバイル用）.csv");
    private static final RString 更新対象モード = new RString("更新対象モード");
    private static final RString ZERO = new RString("0");
    private final RString バッチ = new RString("Batch");
    private final RString 更新 = new RString("Update");
    private final RString データ = new RString("key");

    /**
     * 画面初期化
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onLoad(KoshinTaishoDiv div) {
        div.getCcdChohyoShutsuryokuJun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD511002.getReportId());
        div.getCcdKoshinTaisho().initialize(更新対象モード);
        List<RString> selectedKey = new ArrayList<>();
        selectedKey.add(new RString("0"));
        div.getChkOutPutSelect().setSelectedItemsByKey(selectedKey);
        div.getTxtKikan().setFromValue(RDate.getNowDate());
        div.getTxtKikan().setToValue(RDate.getNowDate());
        div.getTxtHakobi().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
        AccessLogger.log(AccessLogType.照会, new KoshinTaishoHandler().アクセスログ情報(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタン
     *
     * @param div KoshinTaishoDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btndataoutput(KoshinTaishoDiv div, IDownLoadServletResponse response) {
        List<KoshinTaishoBussiness> 画面更新情報ビジネス = new ArrayList<>();
        for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
            KoshinTaishoBussiness bussiness = new KoshinTaishoBussiness();
            bussiness.set保険者(row.getHokensha());
            bussiness.set被保険者被保番号(row.getHihoNumber());
            bussiness.set被保険者氏名(row.getHihoShimei());
            if (row.getKoshinKanryoDay().getValue() != null) {
                bussiness.set更新対象完了日(row.getKoshinKanryoDay().getValue().wareki().toDateString());
            }
            if (row.getKoshinTsuchiYMD().getValue() != null) {
                bussiness.set更新対象通知年月日(row.getKoshinTsuchiYMD().getValue().wareki().toDateString());
            }
            画面更新情報ビジネス.add(bussiness);
        }
        KoshinTaishoManager manager = KoshinTaishoManager.createInstance();
        SharedFileEntryDescriptor entry = manager.csvSyutsuryoku(画面更新情報ビジネス);
        AccessLogger.log(AccessLogType.照会, new KoshinTaishoHandler().アクセスログ情報(div));
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * 調査用データと一覧を出力するボタンチェック
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onBeforeClick_NyuriKu(KoshinTaishoDiv div) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        validationHandler.更新管理完了対象者一覧データの存在チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定調査票を印刷する
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onClick_kakuteibutton(KoshinTaishoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        validationHandler.更新管理完了対象者一覧データの存在チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 調査用データを出力するボタン
     *
     * @param div KoshinTaishoDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_syuShayoubutton(KoshinTaishoDiv div, IDownLoadServletResponse response) {
        KoshinTaishoHandler taishoHandler = new KoshinTaishoHandler();
        SharedFileEntryDescriptor ptor = taishoHandler.csvSyuShayou(div);
        taishoHandler.koushiDb(div);
        AccessLogger.log(AccessLogType.照会, taishoHandler.アクセスログ情報(div));
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(ptor, CSV調査ファイル名), response);
    }

    /**
     * 帳票印刷処理を実行するボタン
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<NinshiuUpdatebatctParameter>
     */
    public ResponseData<DBD511002_KoshinOshiraseTsuchiParameter> onClick_cyoupuButton(KoshinTaishoDiv div) {
        FlowParameters fp = FlowParameters.of(データ, バッチ);
        FlowParameterAccessor.merge(fp);
        KoshinTaishoHandler taishoHandler = new KoshinTaishoHandler();
        DBD511002_KoshinOshiraseTsuchiParameter parameter = new DBD511002_KoshinOshiraseTsuchiParameter();
        taishoHandler.onCilck_btnBatchRegister(parameter, div);
        return ResponseData.of(parameter).respond();
    }

    /**
     * バッチ起動前のチェックです。
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onBeforeCilck_btnBatchRegister(KoshinTaishoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        validationHandler.更新管理完了対象者一覧データの存在チェック(pairs, div);
        validationHandler.抽出対象期間大小関係チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 更新管理を完了するボタン
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onClick_koshinnKannRibutton(KoshinTaishoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        KoshinTaishoValidationHandler validationHandler = new KoshinTaishoValidationHandler();
        validationHandler.更新管理完了対象者一覧データの存在チェック(pairs, div);
        validationHandler.更新管理完了対象者一覧選択行の完了処理事前チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        FlowParameters fp = FlowParameters.of(データ, 更新);
        FlowParameterAccessor.merge(fp);
        new KoshinTaishoHandler().youKihoKoushiDb(div);
        div.getCcdKanryoMessege().setMessage(new RString("完了処理・更新管理の保存処理が完了しました。"),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
        AccessLogger.log(AccessLogType.更新, new KoshinTaishoHandler().アクセスログ情報(div));
        return ResponseData.of(div).setState(DBD5010001StateName.完了);
    }

    /**
     * 帳票発行欄の出力対象をチック
     *
     * @param div KoshinTaishoDiv
     * @return ResponseData<KoshinTaishoDiv>
     */
    public ResponseData<KoshinTaishoDiv> onChange_SyutsurikuTaiyou(KoshinTaishoDiv div) {
        div.getTxtHakobi().setDisabled(true);
        div.getTxtHakobi().clearValue();
        if (div.getChkOutPutSelect().getSelectedKeys().size() > 0) {
            for (int i = 0; i < div.getChkOutPutSelect().getSelectedKeys().size(); i++) {
                if (ZERO.equals(div.getChkOutPutSelect().getSelectedKeys().get(i))) {
                    div.getTxtHakobi().setValue(new FlexibleDate(RDate.getNowDate().toDateString()));
                    div.getTxtHakobi().setDisabled(false);
                }
            }
        }
        return ResponseData.of(div).respond();
    }
}
