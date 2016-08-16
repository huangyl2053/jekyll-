/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5610001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishiencentersoshin.NinteiShienCenterSoshinData;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteishiencentersoshin.NinteiShienCenterSoshinParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001.DBE5610001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001.NinteiShienCenterSoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5610001.CenterSoshinTaishoshaIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5610001.NinteiShienCenterSoshinHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5610001.NinteiShienCenterSoshinValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteishiencentersoshin.NinteiShienCenterSoshinFander;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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

/**
 * センター送信準備のクラスです。
 *
 * @reamsid_L DBE-1520-011 lishengli
 */
public class NinteiShienCenterSoshin {

    private static final RString 未出力 = new RString("key0");
    private static final RString CSVファイル名 = new RString("CenterSoshinTaishoshaIchiran.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * センター送信準備の初期化。
     *
     * @param div NinteiShienCenterSoshinDiv
     * @return レスポンスデータ
     */
    public ResponseData<NinteiShienCenterSoshinDiv> onLoad(NinteiShienCenterSoshinDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE5610001StateName.初期表示);
    }

    /**
     * センター送信準備の初期化。
     *
     * @param div NinteiShienCenterSoshinDiv
     * @return レスポンスデータ
     */
    public ResponseData<NinteiShienCenterSoshinDiv> onClick_BtnClear(NinteiShienCenterSoshinDiv div) {
        getHandler(div).onClick_BtnClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタンの初期化。
     *
     * @param div NinteiShienCenterSoshinDiv
     * @return レスポンスデータ
     */
    public ResponseData<NinteiShienCenterSoshinDiv> onClick_BtnKensaku(NinteiShienCenterSoshinDiv div) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).二次判定日大小関係チェック();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        NinteiShienCenterSoshinParameter parameter = new NinteiShienCenterSoshinParameter();
        parameter.set未出力(未出力.equals(div.getRadDataShutsuryoku().getSelectedKey()));
        parameter.setHas二次判定日_開始(div.getTxtNijiHanteibi().getFromValue() != null);
        parameter.setHas二次判定日_終了(div.getTxtNijiHanteibi().getToValue() != null);
        parameter.set二次判定日_開始(rDatetoFlexibleDate(div.getTxtNijiHanteibi().getFromValue()));
        parameter.set二次判定日_終了(rDatetoFlexibleDate(div.getTxtNijiHanteibi().getFromValue()));
        if (div.getTxtDispMax().getValue() != null) {
            parameter.set件数(div.getTxtDispMax().getValue().intValue());
        }
        List<NinteiShienCenterSoshinData> dataList = NinteiShienCenterSoshinFander.creatInstance().get対象者一覧情報(parameter).records();
        validationMessages = getValidationHandler(div).対象者一覧0件チェック(dataList.size());
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        for (NinteiShienCenterSoshinData data : dataList) {
            PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0001"),
                    new RString("申請書管理番号"), data.get申請書管理番号().value()));
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), data.get被保険者番号()));
            AccessLogger.log(AccessLogType.照会, personalData);
        }
        getHandler(div).set対象者一覧(dataList);
        return ResponseData.of(div).setState(DBE5610001StateName.検索結果);
    }

    /**
     * 対象者一覧を出力するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinteiShienCenterSoshinDiv> onClick_BtnTaishoshaOutput(NinteiShienCenterSoshinDiv div) {
        ValidationMessageControlPairs validationMessages = getValidationHandler(div).対象者一覧未選択チェック();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者一覧を出力するボタンが押下された場合、ＣＳＶを出力します。
     *
     * @param div ShujiiIkenshoIraiTaishoIchiranDiv
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_btnOutputCsv(NinteiShienCenterSoshinDiv div, IDownLoadServletResponse response) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<CenterSoshinTaishoshaIchiranCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            List<dgTaishoshaIchiran_Row> rowList = div.getDgTaishoshaIchiran().getSelectedItems();
            for (dgTaishoshaIchiran_Row row : rowList) {
                csvWriter.writeLine(getCsvData(row));
                PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(new Code("0003"),
                        new RString("被保険者番号"), row.getHihokenshaBango()));
                AccessLogger.log(AccessLogType.照会, personalData);
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(new SharedFileDirectAccessDescriptor(entry, CSVファイル名), response);
    }

    /**
     * 再検索するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinteiShienCenterSoshinDiv> onClick_BtnResearch(NinteiShienCenterSoshinDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE5610001StateName.初期表示);
    }

    /**
     * 送信データの作成を実行するボタンの押下チェック処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<NinteiShienCenterSoshinDiv> onClick_BtnDataoutput(NinteiShienCenterSoshinDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = getValidationHandler(div).対象者一覧未選択チェック();
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            //TODO バッチ設計_DBE561001_センター送信データ作成時装待ち。
//            List<dgTaishoshaIchiran_Row> rowList = div.getDgTaishoshaIchiran().getSelectedItems();
//            List<RString> 申請書管理番号リスト = new ArrayList<>();
//            for (dgTaishoshaIchiran_Row row : rowList) {
//                申請書管理番号リスト.add(row.getShinseishokanrino());
//            }
//            RDate 二次判定日_開始 = div.getTxtNijiHanteibi().getFromValue();
//            RDate 二次判定日_終了 = div.getTxtNijiHanteibi().getToValue();
//            RString 転入_死亡情報出力区分 = div.getRadTennyuShiboJoho().getSelectedKey();
//            return ResponseData.of(div).forwardWithEventName(DBE0220001TransitionEventName.センター送信).respond();
        }
        return ResponseData.of(div).respond();
    }

    private FlexibleDate rDatetoFlexibleDate(RDate 二次判定日) {
        if (二次判定日 == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(二次判定日.toString());
    }

    private CenterSoshinTaishoshaIchiranCsvEntity getCsvData(dgTaishoshaIchiran_Row row) {
        return new CenterSoshinTaishoshaIchiranCsvEntity(
                row.getHokensha(),
                row.getHihokenshaBango(),
                row.getHihokenshaShimei(),
                row.getHihokenshaShimeiKana(),
                row.getSex(),
                getパターン1(row.getBirthDate().getValue()),
                getパターン1(row.getNinteiShinseibi().getValue()),
                row.getShinseiKubunShin(),
                row.getShinseiKubunHo(),
                row.getNijiHanteiKekka(),
                row.getNinteiYukoKikan(),
                getパターン1(row.getYukoKikanstart().getValue()),
                getパターン1(row.getYukokikanend().getValue()),
                getパターン1(row.getDataShutsuryoku().getValue()));
    }

    private RString getパターン1(RDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private NinteiShienCenterSoshinHandler getHandler(NinteiShienCenterSoshinDiv div) {
        return new NinteiShienCenterSoshinHandler(div);
    }

    private NinteiShienCenterSoshinValidationHandler getValidationHandler(NinteiShienCenterSoshinDiv div) {
        return new NinteiShienCenterSoshinValidationHandler(div);
    }

}
