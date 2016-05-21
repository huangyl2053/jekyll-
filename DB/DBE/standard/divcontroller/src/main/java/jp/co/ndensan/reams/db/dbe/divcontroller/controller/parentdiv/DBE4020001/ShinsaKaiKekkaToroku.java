/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE4020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.shinsei.NijiHanteiKekkaInputHoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.DBE4020001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.DBE4020001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 完了処理・審査会結果登録のコントローラです。
 *
 * @reamsid_L DBE-0350-010 linghuhang
 */
public class ShinsaKaiKekkaToroku {

    private static final RString 出力名 = new RString("審査会結果一覧.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 審査会結果登録 = new RString("完了処理・審査会結果登録");
    private static final RString 認定ｿﾌﾄ99 = new RString("99A");
    private static final RString 認定ｿﾌﾄ2002 = new RString("02A");
    private static final RString 認定ｿﾌﾄ2006 = new RString("06A");
    private static final RString 認定ｿﾌﾄ2009_A = new RString("09A");
    private static final RString 認定ｿﾌﾄ2009_B = new RString("09B");

    /**
     * 画面初期化処理です。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData<ShinsaKaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onLoad(ShinsaKaiKekkaTorokuDiv div) {
        前排他キーのセット();
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタンを押下前、チェックの処理する。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData<ShinsaKaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnRyooutputBoffer(ShinsaKaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        ValidationMessageControlPairs validation = getValidationHandler(div).選択チェック(存在チェック結果);
        if (validation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタンを押下するとき、介護認定審査会結果一覧データの作成を行う。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<ShinsaKaiKekkaTorokuDiv>
     */
    public IDownLoadServletResponse onClick_btnRyooutput(ShinsaKaiKekkaTorokuDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 出力名);
        try (CsvWriter<ShinsaKaiKekkaTorokuCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(false).build()) {
            List<dgNinteiTaskList_Row> dataList = div.getCcdTaskList().getCheckbox();
            for (dgNinteiTaskList_Row row : dataList) {
                csvWriter.writeLine(getCsvData(row));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, 出力名), response);
    }

    /**
     * 審査結果を登録するボタンを押下する場合、審査会対象者個別結果登録(画面ID：DBE4021001)へ遷移する。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData<ShinsaKaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnCompleteKekkaToroku(ShinsaKaiKekkaTorokuDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
            ValidationMessageControlPairs validation = getValidationHandler(div).選択チェック(存在チェック結果);
            if (validation.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validation).respond();
            } else {
                申請書管理番号リスト(div.getCcdTaskList().getCheckbox());
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBE4020001TransitionEventName.審査会対象者個別結果登録へ遷移する).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * モバイルより結果登録するボタンを押下する場合、データ更新する。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData<ShinsaKaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnMobileToroku(ShinsaKaiKekkaTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
            ValidationMessageControlPairs validation = getValidationHandler(div).選択チェック(存在チェック結果);
            if (validation.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validation).respond();
            } else {
//TODO 楊さん確認中.モバイル登録を実行する
//            １）モバイルPCおよびUSBから二次判定結果登録済みデータを受け取る。また、1.5次判定があれば取込み可能。
//ファイルの場所：カスタムコンフィグ.審査結果取込用データ（モバイル）パス
//ファイルの名称：カスタムコンフィグ.審査結果取込用データ（モバイル）パス
//            上記受け取ったCSVファイルのデータをDBへ更新する
//「DB出力(要介護認定結果情報)」に記載するように登録する。また、
//1.5次判定データがDBにあれば、DB出力(要介護認定1.5次判定結果情報)のように更新する、
//1.5次判定データがDBになければ、DB出力(要介護認定1.5次判定結果情報)のように登録する、
                前排他キーの解除();
                onLoad(div);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * OCRより結果登録するボタンを押下する場合、介護認定審査会審査結果登録（OCR)(画面ID：DBE5240001)へ遷移する。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData<ShinsaKaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnOCRToroku(ShinsaKaiKekkaTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
            ValidationMessageControlPairs validation = getValidationHandler(div).選択チェック(存在チェック結果);
            if (validation.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validation).respond();
            } else {
                前排他キーの解除();
                return ResponseData.of(div).forwardWithEventName(DBE4020001TransitionEventName.介護認定審査会審査結果登録_OCR_へ遷移する).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 結果登録を完了するボタンを押下する場合、審査会結果登録完了処理を行う。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData<ShinsaKaiKekkaTorokuDiv>
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnKekkaToroku(ShinsaKaiKekkaTorokuDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
            ValidationMessageControlPairs 選択チェック = getValidationHandler(div).選択チェック(存在チェック結果);
            ValidationMessageControlPairs validation = getValidationHandler(div).完了処理事前チェック(選択チェック);
            if (validation.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validation).respond();
            } else {
                getHandler(div).要介護認定完了更新();
                前排他キーの解除();
                div.getCcdKanryoMsg().setMessage(new RString(UrInformationMessages.正常終了.getMessage().
                        replace(審査会結果登録.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBE4020001StateName.完了);
            }
        }
        return ResponseData.of(div).respond();
    }

    private ShinsaKaiKekkaTorokuCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        RString 申請時コード = RString.EMPTY;
        RString 法令コード = RString.EMPTY;
        RString 入力方法 = RString.EMPTY;
        if (!RString.isNullOrEmpty(row.getShinseiKubunShinseiji())) {
            申請時コード = NinteiShinseiShinseijiKubunCode.valueOf(row.getShinseiKubunShinseiji().toString()).getコード();
        }
        if (!RString.isNullOrEmpty(row.getShinseiKubunHorei())) {
            法令コード = NinteiShinseiHoreiCode.valueOf(row.getShinseiKubunHorei().toString()).getコード();
        }
        if (!RString.isNullOrEmpty(row.getNyuryokuHoho())) {
            入力方法 = NijiHanteiKekkaInputHoho.valueOf(row.getNyuryokuHoho().toString()).getコード();
        }
        ShinsaKaiKekkaTorokuCsvEntity data = new ShinsaKaiKekkaTorokuCsvEntity(
                row.getShinseishoKanriNo(),
                row.getHokensha(),
                row.getHihoNumber(),
                row.getHihoShimei(),
                申請時コード,
                row.getShinseiKubunShinseiji(),
                法令コード,
                row.getShinseiKubunHorei(),
                日期転換(row.getNinteiShinseiDay().getValue()),
                日期転換(row.getNijihanteiKanryoDay().getValue()),
                日期転換(row.getNijihanteiKekkaToroku().getValue()),
                入力方法,
                row.getNyuryokuHoho(),
                row.getNijiHanteiYokaigoJotaiKubunCode(),
                二次判定結果の名称(row.getKoroshoIfShikibetsuCode(), row.getNijiHanteiYokaigoJotaiKubunCode()),
                row.getNijihanteiYukoKikan(),
                日期転換(row.getNijihanteiShinsakaiKaisaiDay().getValue()),
                row.getNijihanteiKaisaiNumber());
        return data;
    }

    private RString 日期転換(RDate 日期) {
        if (日期 != null) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private void 前排他キーのセット() {
        LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));
        if (!RealInitialLocker.tryGetLock(排他キー)) {
            ErrorMessage message = new ErrorMessage(UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().getCode(),
                    UrErrorMessages.排他_バッチ実行中で更新不可.getMessage().evaluate());
            throw new ApplicationException(message);
        }
    }

    private void 前排他キーの解除() {
        LockingKey 排他キー = new LockingKey(new RString("ShinseishoKanriNo"));
        RealInitialLocker.release(排他キー);
    }

    private RString 二次判定結果の名称(RString 厚労省IF識別コード, RString 二次判定結果コード) {
        if (認定ｿﾌﾄ99.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun99.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード).get名称();
        } else if (認定ｿﾌﾄ2002.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun02.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード).get名称();
        } else if (認定ｿﾌﾄ2006.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun06.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード).get名称();
        } else if (認定ｿﾌﾄ2009_A.equals(厚労省IF識別コード)
                || 認定ｿﾌﾄ2009_B.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun09.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード).get名称();
        }
        return RString.EMPTY;
    }

    private void 申請書管理番号リスト(List<dgNinteiTaskList_Row> 選択データ) {
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            申請書管理番号リスト.add(データ.getShinseishoKanriNo());
        }
        ShinseishoKanriNoList shinseishoKanriNoList = new ShinseishoKanriNoList();
        shinseishoKanriNoList.setShinseishoKanriNoList(申請書管理番号リスト);
        ViewStateHolder.put(ViewStateKeys.主治医意見書依頼_申請書管理番号List, shinseishoKanriNoList);
    }

    private ShinsaKaiKekkaTorokuHandler getHandler(ShinsaKaiKekkaTorokuDiv div) {
        return new ShinsaKaiKekkaTorokuHandler(div);
    }

    private ShinsaKaiKekkaTorokuValidationHandler getValidationHandler(ShinsaKaiKekkaTorokuDiv div) {
        return new ShinsaKaiKekkaTorokuValidationHandler(div);
    }
}
