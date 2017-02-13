/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE4020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.DBE4020001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.DBE4020001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaInputCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4020001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4020001.ShinsaKaiKekkaTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・審査会結果登録のコントローラです。
 *
 * @reamsid_L DBE-0350-010 linghuhang
 */
public class ShinsaKaiKekkaToroku {

    private static final RString CSVファイルID_審査会結果登録一覧 = new RString("DBE402001");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 完了処理_審査会結果登録 = new RString("完了処理・審査会結果登録");
    private static final RString 審査会結果登録 = new RString("審査会結果登録");
    private static final RString 認定ｿﾌﾄ99 = new RString("99A");
    private static final RString 認定ｿﾌﾄ2002 = new RString("02A");
    private static final RString 認定ｿﾌﾄ2006 = new RString("06A");
    private static final RString 認定ｿﾌﾄ2009_A = new RString("09A");
    private static final RString 認定ｿﾌﾄ2009_B = new RString("09B");
    private static final RString 審査会結果OCR使用 = new RString("1");

    /**
     * 画面初期化処理です。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onLoad(ShinsaKaiKekkaTorokuDiv div) {
        ShinsaKaiKekkaTorokuHandler handler = getHandler(div);
        handler.onLoad();
        handler.initTextOf処理を進めるボタン();
        handler.setDisplayOCR結果登録ボタン(uses審査会結果登録OCR());
        handler.setDisabled登録ボタンfrom選択状態();
        return ResponseData.of(div).respond();
    }

    /**
     * onActiveイベントです。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onActive(ShinsaKaiKekkaTorokuDiv div) {
        ShinsaKaiKekkaTorokuHandler handler = getHandler(div);
        handler.setJyotaiKubun();
        handler.setDisabled登録ボタンfrom選択状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者状態ラジオボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onChange_radTaishoshaJotai(ShinsaKaiKekkaTorokuDiv div) {
        ShinsaKaiKekkaTorokuHandler handler = getHandler(div);
        handler.setJyotaiKubun();
        handler.setDisabled登録ボタンfrom選択状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧データグリッド選択列が変更された際のイベントです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onChange_dgNinteiTaskListSelected(ShinsaKaiKekkaTorokuDiv div) {
        ShinsaKaiKekkaTorokuHandler handler = getHandler(div);
        handler.setDisabled登録ボタンfrom選択状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 最大表示件数テキストボックスの値が変更された際の動作です。
     *
     * @param requestDiv NinteichosaIraiDiv
     * @return ResponseData
     */
    public ResponseData onChange_txtMaxCount(ShinsaKaiKekkaTorokuDiv requestDiv) {
        getHandler(requestDiv).二次判定モード();
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 一覧を出力するボタンを押下前、チェックの処理する。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnRyooutputBoffer(ShinsaKaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        if (存在チェック結果.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(存在チェック結果).respond();
        }
        ValidationMessageControlPairs validation = getValidationHandler(div).選択チェック();
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
     * @return ResponseData
     */
    public IDownLoadServletResponse onClick_btnRyooutput(ShinsaKaiKekkaTorokuDiv div, IDownLoadServletResponse response) {
        RString 出力名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, CSVファイルID_審査会結果登録一覧);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 出力名);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<ShinsaKaiKekkaTorokuCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {

            List<dgNinteiTaskList_Row> dataList = div.getDgNinteiTaskList().getSelectedItems();
            for (dgNinteiTaskList_Row row : dataList) {
                personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                        row.getShinseishoKanriNo()));
                csvWriter.writeLine(getCsvData(row));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(出力名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        AccessLogger.log(AccessLogType.照会, personalData);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, 出力名), response);
    }

    /**
     * 審査結果を登録するボタンを押下する場合、審査会対象者個別結果登録(画面ID：DBE4021001)へ遷移する。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnCompleteKekkaToroku(ShinsaKaiKekkaTorokuDiv div) {

        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        if (存在チェック結果.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(存在チェック結果).respond();
        }
        ValidationMessageControlPairs validation = getValidationHandler(div).選択チェック();
        if (validation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validation).respond();
        } else {
            set遷移先引数(div.getDgNinteiTaskList().getSelectedItems().get(0));
            return ResponseData.of(div).forwardWithEventName(DBE4020001TransitionEventName.審査会対象者個別結果登録へ遷移する).respond();
        }
    }

    /**
     * モバイルより結果登録するボタンを押下する場合、データ更新する。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnMobileToroku(ShinsaKaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        if (存在チェック結果.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(存在チェック結果).respond();
        }
        ValidationMessageControlPairs validation = getValidationHandler(div).選択チェック();
        if (validation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            RDate 日期 = RDate.getNowDate();
            RString ファイルの場所 = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル_パス, 日期, SubGyomuCode.DBE認定支援);
            RString ファイルの名称 = DbBusinessConfig.get(ConfigNameDBE.審査結果取込用データ_モバイル, 日期, SubGyomuCode.DBE認定支援);
            List<ShinsaKaiKekkaInputCsvEntity> ファイルデータ = insertCsvDate(ファイルの場所, ファイルの名称);
            getHandler(div).onClick_btnCyosakekkaInput(ファイルデータ);
            onLoad(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * OCRより結果登録するボタンを押下する場合、介護認定審査会審査結果登録（OCR)(画面ID：DBE5240001)へ遷移する。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnOCRToroku(ShinsaKaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        if (存在チェック結果.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(存在チェック結果).respond();
        }
        ValidationMessageControlPairs validation = getValidationHandler(div).選択チェック();
        if (validation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validation).respond();
        } else {
            ViewStateHolder.put(ViewStateKeys.開催番号, div.getDgNinteiTaskList().getSelectedItems().get(0).getNijihanteiKaisaiNumber());
            return ResponseData.of(div).forwardWithEventName(DBE4020001TransitionEventName.介護認定審査会審査結果登録_OCR_へ遷移する).respond();
        }
    }

    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_shorikeizoku(ShinsaKaiKekkaTorokuDiv div) {
        onLoad(div);
        return ResponseData.of(div).setState(DBE4020001StateName.登録);
    }

    /**
     * 結果登録を完了するボタンを押下する場合、審査会結果登録完了処理を行う。
     *
     * @param div ShinsaKaiKekkaTorokuDiv
     * @return ResponseData
     */
    public ResponseData<ShinsaKaiKekkaTorokuDiv> onClick_btnKekkaToroku(ShinsaKaiKekkaTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        if (存在チェック結果.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(存在チェック結果).respond();
        }
        ValidationMessageControlPairs 選択チェック = getValidationHandler(div).選択チェック();
        if (選択チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(選択チェック).respond();
        }
        ValidationMessageControlPairs validation = getValidationHandler(div).完了処理事前チェック();
        if (validation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div)
                    .addMessage(DbeQuestionMessages.完了日登録確認.getMessage().replace(審査会結果登録.toString()))
                    .respond();
        }
        if (new RString(DbeQuestionMessages.完了日登録確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> models
                    = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
            getHandler(div).要介護認定完了更新(models);
            div.getCcdKanryoMsg().setMessage(new RString(UrInformationMessages.正常終了.getMessage().
                    replace(完了処理_審査会結果登録.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
            div.getBtnShinsakaikanryooutput().setDisplayNone(true);
            return ResponseData.of(div).setState(DBE4020001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private ShinsaKaiKekkaTorokuCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        ShinsaKaiKekkaTorokuCsvEntity data = new ShinsaKaiKekkaTorokuCsvEntity(
                row.getJotai(),
                row.getHokensha(),
                日期転換(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                row.getShinseiKubunShinseiji(),
                row.getShinseiKubunHorei(),
                日期転換(row.getNijihanteiKekkaToroku().getValue()),
                row.getNyuryokuHoho(),
                二次判定結果の名称(row.getKoroshoIfShikibetsuCode(), row.getNijiHanteiYokaigoJotaiKubunCode()),
                row.getNijihanteiYukoKikan(),
                日期転換(row.getNijihanteiShinsakaiKaisaiDay().getValue()),
                row.getNijihanteiKaisaiNumber());
        return data;
    }

    private List<ShinsaKaiKekkaInputCsvEntity> insertCsvDate(RString ファイルの場所, RString ファイルの名称) {
        RString filePath = Path.combinePath(ファイルの場所, ファイルの名称);
        CsvReader csvReader = new CsvReader.InstanceBuilder(filePath, ShinsaKaiKekkaInputCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile(csvReader);
    }

    private List<ShinsaKaiKekkaInputCsvEntity> readCsvFile(CsvReader csvReader) {
        List<ShinsaKaiKekkaInputCsvEntity> csvEntityList = new ArrayList<>();
        while (true) {
            ShinsaKaiKekkaInputCsvEntity entity = (ShinsaKaiKekkaInputCsvEntity) csvReader.readLine();
            if (entity != null) {
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return csvEntityList;
    }

    private RString 日期転換(RDate 日期) {
        if (日期 != null) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
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

    private void set遷移先引数(dgNinteiTaskList_Row row) {
        ViewStateHolder.put(ViewStateKeys.開催番号, row.getNaibuShinsakaiNo());
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, row.getShinseishoKanriNo());
    }

    private ShinsaKaiKekkaTorokuHandler getHandler(ShinsaKaiKekkaTorokuDiv div) {
        return new ShinsaKaiKekkaTorokuHandler(div);
    }

    private ShinsaKaiKekkaTorokuValidationHandler getValidationHandler(ShinsaKaiKekkaTorokuDiv div) {
        return new ShinsaKaiKekkaTorokuValidationHandler(div);
    }

    private static boolean uses審査会結果登録OCR() {
        RString 審査会結果登録OCR使用可否
                = DbBusinessConfig.get(ConfigNameDBE.審査会結果OCR使用有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        return (審査会結果登録OCR使用可否.equals(審査会結果OCR使用));
    }
}
