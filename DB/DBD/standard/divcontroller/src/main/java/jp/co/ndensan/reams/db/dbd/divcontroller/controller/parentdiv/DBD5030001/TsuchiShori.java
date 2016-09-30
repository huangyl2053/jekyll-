/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd5030001.DgTsuchishoHakkoBussiness;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.DBD5030001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.DBD5030001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.TsuchiShoriDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.dgtsuchishohakko_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5030001.TsuchiShoriHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5030001.TsuchiShoriValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.dbd5030001.TsuchiShoriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・通知書発行画面のDivControllerです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
public class TsuchiShori {

    private static final RString CSVファイル名 = new RString("通知書発行対象者一覧.csv");

    /**
     * 画面初期化
     *
     * @param div TsuchiShoriDiv
     * @return ResponseData<TsuchiShoriDiv>
     */
    public ResponseData<TsuchiShoriDiv> onLoad(TsuchiShoriDiv div) {
        List<dgtsuchishohakko_Row> 画面情報一覧 = getHandler().onLoad();
        div.getDgtsuchishohakko().setDataSource(画面情報一覧);
        AccessLogger.log(AccessLogType.照会, getHandler().アクセスログ情報(画面情報一覧));
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタンの押下チェック処理です。
     *
     * @param div TsuchiShoriDiv
     * @return ResponseData<TsuchiShoriDiv>
     */
    public ResponseData<TsuchiShoriDiv> onClick_btnCsvoutput(TsuchiShoriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor通知書発行対象者一覧データの存在チェック(pairs, div);
        getValidationHandler().validateFor通知書発行対象者一覧データの行選択チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタン押下された場合、ＣＳＶを出力します。
     *
     * @param div TsuchiShoriDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(TsuchiShoriDiv div, IDownLoadServletResponse response) {
        List<dgtsuchishohakko_Row> 画面更新情報 = div.getDgtsuchishohakko().getSelectedItems();
        List<DgTsuchishoHakkoBussiness> 画面更新情報ビジネス = new ArrayList<>();
        for (dgtsuchishohakko_Row row : 画面更新情報) {
            DgTsuchishoHakkoBussiness business = new DgTsuchishoHakkoBussiness();
            business.setHokensha(row.getHokensha());
            business.setHihoNumber(row.getHihoNumber());
            business.setHihoShimei(row.getHihoShimei());
            business.setNinteiShinseiDay(row.getNinteiShinseiDay());
            business.setShinseiKubunShinseiji(row.getShinseiKubunShinseiji());
            business.setShinseiKubunHorei(row.getShinseiKubunHorei());
            business.setTsuchiKanryobi(row.getTsuchiKanryobi());
            business.setNinteitsuchishobi(row.getNinteitsuchishobi());
            business.setKubunhenkotsuchishobi(row.getKubunhenkotsuchishobi());
            business.setServicehenkotsuchishobi(row.getServicehenkotsuchishobi());
            business.setNinteikyakatsuchishobi(row.getNinteikyakatsuchishobi());
            business.setNinteitorikeshitsuchishobi(row.getNinteitorikeshitsuchishobi());
            画面更新情報ビジネス.add(business);
        }
        TsuchiShoriManager manager = TsuchiShoriManager.createInstance();
        SharedFileEntryDescriptor entry = manager.ファイル出力(画面更新情報ビジネス);
        AccessLogger.log(AccessLogType.照会, getHandler().アクセスログ情報(画面更新情報));
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * 通知書を発行するボタン押下
     *
     * @param div TsuchiShoriDiv
     * @return ResponseData<TsuchiShoriDiv>
     */
    public ResponseData<TsuchiShoriDiv> onClick_btnHakkou(TsuchiShoriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.確認_汎用.getMessage().replace("遷移しますが")).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).forwardWithEventName(DBD5030001TransitionEventName.通知書発行).respond();
    }

    /**
     * 通知書発行を完了するボタン押下
     *
     * @param div TsuchiShoriDiv
     * @return ResponseData<TsuchiShoriDiv>
     */
    public ResponseData<TsuchiShoriDiv> onClick_btnKanryo(TsuchiShoriDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor通知書発行対象者一覧データの存在チェック(pairs, div);
        getValidationHandler().validateFor通知書発行対象者一覧データの行選択チェック(pairs, div);
        getValidationHandler().validateFor通知書発行対象者一覧選択行の完了処理事前チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        List<dgtsuchishohakko_Row> 画面更新情報 = div.getDgtsuchishohakko().getSelectedItems();
        getHandler().ＤＢ処理(画面更新情報);
        AccessLogger.log(AccessLogType.更新, getHandler().アクセスログ情報(画面更新情報));
        div.getCcdKanryoMessege().setMessage(new RString("完了処理・通知書発行の保存処理が完了しました。"), RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(div).setState(DBD5030001StateName.完了);
    }

    private TsuchiShoriHandler getHandler() {
        return new TsuchiShoriHandler();
    }

    private TsuchiShoriValidationHandler getValidationHandler() {
        return new TsuchiShoriValidationHandler();
    }
}
