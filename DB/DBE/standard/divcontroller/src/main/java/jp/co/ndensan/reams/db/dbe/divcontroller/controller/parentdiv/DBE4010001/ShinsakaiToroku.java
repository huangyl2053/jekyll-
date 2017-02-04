/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE4010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.DBE4010001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.DBE4010001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.ShinsakaiTorokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.ShinsakaiTorokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4010001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4010001.ShinsakaiTorokuHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4010001.ShinsakaiTorokuValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku.ShinsakaiTorokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeWarningMessages;
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
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 完了処理・介護認定審査会登録のコントローラです。
 *
 * @reamsid_L DBE-0340-010 linghuhang
 */
public class ShinsakaiToroku {

    private static final RString CSVファイルID_審査会登録一覧 = new RString("DBE401001");
    private final RString 介護認定審査会登録 = new RString("完了処理・介護認定審査会登録");
    private final RString 介護認定審査会割当 = new RString("完了処理・介護認定審査会割当");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString 割付未完了のみ = new RString("割付未完了分のみ");

    /**
     * 画面初期化処理です。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onLoad(ShinsakaiTorokuDiv div) {
        getHandler(div).set対象者最大表示件数();
        getHandler(div).onLoad();
        getHandler(div).審査会一覧データグリッド初期化();       
        getHandler(div).set審査会最大表示件数();
        ViewStateHolder.put(ViewStateKeys.状態, div.getRadTaishoshaJotai().getSelectedKey());
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を出力するボタンを押下前、チェックの処理する。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnRyooutputBoffer(ShinsakaiTorokuDiv div) {
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
     * 一覧を出力するボタンを押下するとき、介護認定審査会登録一覧データの作成を行う。
     *
     * @param div ShinsakaiTorokuDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public IDownLoadServletResponse onClick_btnRyooutput(ShinsakaiTorokuDiv div, IDownLoadServletResponse response) {
        RString 出力名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, CSVファイルID_審査会登録一覧);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 出力名);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
        try (CsvWriter<ShinsakaiTorokuCsvEntity> csvWriter
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
     * 審査会に割付するボタンを押下するとき、審査会対象者個別割付画面を表示します。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnShinsakai(ShinsakaiTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        if (存在チェック結果.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(存在チェック結果).respond();
        }
        ValidationMessageControlPairs 選択チェック = getValidationHandler(div).選択チェック();
        if (選択チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(選択チェック).respond();
        }
        ValidationMessageControlPairs validation = getValidationHandler(div).割付可能チェック();
        if (validation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validation).respond();
        } else {
            申請書管理番号リスト(div.getDgNinteiTaskList().getSelectedItems());
            return ResponseData.of(div).forwardWithEventName(DBE4010001TransitionEventName.審査会対象者個別割付へ遷移する)
                    .parameter(new RString("申請書管理番号リスト"));
        }
    }

    /**
     * 審査会登録を完了するボタンを押下するとき、ＤＢに更新します。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnShinsakaiToruku(ShinsakaiTorokuDiv div) {
        ValidationMessageControlPairs 存在チェック結果 = getValidationHandler(div).存在チェック();
        if (存在チェック結果.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(存在チェック結果).respond();
        }
        ValidationMessageControlPairs 選択チェック = getValidationHandler(div).選択チェック();
        if (選択チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(選択チェック).respond();
        }
        ValidationMessageControlPairs 完了処理事前チェック = getValidationHandler(div).完了処理事前チェック();
        ValidationMessageControlPairs validation = getValidationHandler(div).マスキング完了チェック(完了処理事前チェック);
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
            Models<NinteiKanryoJohoIdentifier, NinteiKanryoJoho> models
                    = ViewStateHolder.get(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.class);
            getHandler(div).要介護認定完了更新(models);
            div.getCcdKanryoMsg().setMessage(new RString(UrInformationMessages.正常終了.getMessage().
                    replace(介護認定審査会登録.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
            div.getBtnShinsakekkakanryooutput().setDisplayNone(true);
            return ResponseData.of(div).setState(DBE4010001StateName.完了);

        }
        return ResponseData.of(div).setState(DBE4010001StateName.登録);
    }

    /**
     * 対象者状態ラジオボタンの押下チェック処理です。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onChange_radTaishoshaJotai(ShinsakaiTorokuDiv div) {
        if (!get修正リスト(div).isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                div.getRadTaishoshaJotai().setSelectedKey(ViewStateHolder.get(ViewStateKeys.状態, RString.class));
                return ResponseData.of(div).respond();
            }
        }
        ViewStateHolder.put(ViewStateKeys.状態, div.getRadTaishoshaJotai().getSelectedKey());
        getHandler(div).setJyotaiKubun();
        return ResponseData.of(div).respond();
    }

    /**
     * データグリッドの取消ボタン押下時のイベントです。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onSelect_btnCancel(ShinsakaiTorokuDiv div) {
        dgNinteiTaskList_Row row = div.getDgNinteiTaskList().getClickedItem();
        getHandler(div).onSelect_btnCancel(row);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索ボタンクリックイベントです。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnSearch(ShinsakaiTorokuDiv div) {
        div.getDgShinsakaiList().getDataSource().clear();
        RDate 表示期間From = div.getTxtKensakuKaisaiYoteiYmd().getFromValue();
        RDate 表示期間To = div.getTxtKensakuKaisaiYoteiYmd().getToValue();
        ValidationMessageControlPairs validationMessages
                = getHandler(div).表示期間Fromと表示期間Toの前後順チェック();
        if (表示期間From != null && 表示期間To != null && 表示期間To.isBefore(表示期間From)) {
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        List<ShinsakaiKaisai> 審査会一覧 = ShinsakaiTorokuFinder.createInstance().get審査会一覧(
                表示期間From, 表示期間To, RString.EMPTY, 割付未完了のみ, div.getTxtShinsakaiMaxHyojiKensu().getValue(), RString.EMPTY).records();
        if (審査会一覧 == null || 審査会一覧.isEmpty()) {
            validationMessages = getHandler(div).該当データが存在のチェック();
            return ResponseData.of(div).addValidationMessages(validationMessages).respond();
        }
        getHandler(div).onClick_btnSearch(審査会一覧);

        return ResponseData.of(div).respond();
    }

    /**
     * 割り付けボタンクリックイベントです。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnWaritsuke(ShinsakaiTorokuDiv div) {
        ValidationMessageControlPairs 対象者選択チェック = getValidationHandler(div).対象者選択チェック();
        if (対象者選択チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(対象者選択チェック).respond();
        }
        ValidationMessageControlPairs 割付可能チェック = getValidationHandler(div).割付可能チェック();
        if (割付可能チェック.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(割付可能チェック).respond();
        }
        Decimal 予定定員 = div.getDgShinsakaiList().getClickedItem().getYoteiTeiin().getValue();
        Decimal 割当済人数 = div.getDgShinsakaiList().getClickedItem().getWariateZumiNinzu().getValue();
        List<dgNinteiTaskList_Row> 選択データ = div.getDgNinteiTaskList().getSelectedItems();
        if (予定定員.compareTo(割当済人数.add(選択データ.size())) == -1) {
            if (!ResponseHolder.isReRequest()) {
                WarningMessage message = new WarningMessage(DbeWarningMessages.割付申請者人数が最大割付可能人数を超過.getMessage().getCode(),
                        DbeWarningMessages.割付申請者人数が最大割付可能人数を超過.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        getHandler(div).onClick_btnWaritsuke(div.getDgShinsakaiList().getClickedItem(), get修正リスト(div));
        return ResponseData.of(div).respond();
    }

    /**
     * 対象者最大審査順表示件数テキスト変更イベントです。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onChange_txtTaishoshaMaxHyojiKensu(ShinsakaiTorokuDiv div) {
        if (!get修正リスト(div).isEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 保存するボタンクリックイベントです。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnSave(ShinsakaiTorokuDiv div) {
        ValidationMessageControlPairs 対象者データ有無チェック = getValidationHandler(div).対象者データ有無チェック();
        List<dgNinteiTaskList_Row> 修正リスト = get修正リスト(div);
        if (修正リスト.isEmpty()) {
            return ResponseData.of(div).addValidationMessages(対象者データ有無チェック).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).onClick_btnSave(修正リスト);
            div.getCcdKanryoMsg().setMessage(new RString(UrInformationMessages.正常終了.getMessage().
                    replace(介護認定審査会割当.toString()).evaluate()), RString.EMPTY, RString.EMPTY, true);
            div.getBtnShinsakekkakanryooutput().setDisplayNone(true);
            return ResponseData.of(div).setState(DBE4010001StateName.完了);

        }
        return ResponseData.of(div).setState(DBE4010001StateName.登録);
    }

    
    /**
     * 継続ボタン押下動作です。
     *
     * @param div ShinsakaiTorokuDiv
     * @return ResponseData<ShinsakaiTorokuDiv>
     */
    public ResponseData<ShinsakaiTorokuDiv> onClick_btnContinue(ShinsakaiTorokuDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBE4010001StateName.登録);
    }
    private List<dgNinteiTaskList_Row> get修正リスト(ShinsakaiTorokuDiv div) {
        List<dgNinteiTaskList_Row> データリスト = div.getDgNinteiTaskList().getDataSource();
        List<dgNinteiTaskList_Row> 修正リスト = new ArrayList<>();
        for (dgNinteiTaskList_Row データ : データリスト) {
            if (データ.getRowState().equals(RowState.Modified)) {
                修正リスト.add(データ);
            }
        }
        return 修正リスト;
    }

    private ShinsakaiTorokuCsvEntity getCsvData(dgNinteiTaskList_Row row) {
        ShinsakaiTorokuCsvEntity data = new ShinsakaiTorokuCsvEntity(
                row.getJotai(),
                row.getHokensha(),
                日期転換(row.getNinteiShinseiDay().getValue()),
                row.getHihoNumber(),
                row.getHihoShimei(),
                row.getShinseiKubunShinseiji(),
                row.getShinseiKubunHorei(),
                日期転換(row.getChosahyoKanryoDay().getValue()),
                日期転換(row.getIkenshoNyushuKanryoDay().getValue()),
                日期転換(row.getMaskingKanryoDay().getValue()),
                日期転換(row.getShinsakaiwaritukeDay().getValue()),
                日期転換(row.getShinsakaiKaisaiDay().getValue()),
                時刻転換(row.getShinsakaiKaisaiJikan().getValue()),
                row.getYusenWaritsukesha(),
                row.getShinsakaiMeisho(),
                row.getGogitai());
        return data;
    }

    private RString 日期転換(RDate 日期) {
        if (日期 != null) {
            return 日期.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString 時刻転換(RTime 時刻) {
        if (時刻 != null) {
            return new RString(時刻.toFormattedTimeString(DisplayTimeFormat.HH_mm).toString());
        }
        return RString.EMPTY;
    }

    private void 申請書管理番号リスト(List<dgNinteiTaskList_Row> 選択データ) {
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        for (dgNinteiTaskList_Row データ : 選択データ) {
            申請書管理番号リスト.add(データ.getShinseishoKanriNo());
        }
        ShinseishoKanriNoList shinseishoKanriNoList = new ShinseishoKanriNoList();
        shinseishoKanriNoList.setShinseishoKanriNoS(申請書管理番号リスト);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号リスト, shinseishoKanriNoList);
    }

    private ShinsakaiTorokuHandler getHandler(ShinsakaiTorokuDiv div) {
        return new ShinsakaiTorokuHandler(div);
    }

    private ShinsakaiTorokuValidationHandler getValidationHandler(ShinsakaiTorokuDiv div) {
        return new ShinsakaiTorokuValidationHandler(div);
    }
}
