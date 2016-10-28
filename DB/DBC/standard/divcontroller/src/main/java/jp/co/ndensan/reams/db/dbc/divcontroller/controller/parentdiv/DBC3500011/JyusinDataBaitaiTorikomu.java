/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC3500011;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.config.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshasofulist.HokenshaSofuListMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011.JyusinDataBaitaiTorikomuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011.JyusinDataList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3500011.HokenshaSofuListHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報データ媒体取込のクラスです。
 *
 * @reamsid_L DBC-3030-010 lihang
 */
public class JyusinDataBaitaiTorikomu {

    private static final int ゼロ = 0;
    private final RString searchSharedFile = new RString("1\\_%");
    private static final int 一1 = 1;
    private static final int 三 = 3;
    private static final int 四 = 4;
    private static final int 五 = 5;
    private static final int 六 = 6;
    private static final RString カンマ = new RString(",");
    private static final RString CSV = new RString(".csv");
    private static final RString 給付実績情報111 = new RString("111");
    private static final RString 識別番号011 = new RString("011");
    private static final RString 二 = new RString("2");
    private FlexibleYearMonth 審査年月;
    private static FlexibleYearMonth 審査年月の翌月;
    private static FlexibleYearMonth 処理年月;
    private static FlexibleYearMonth 処理年月の前月;
    private RString 識別番号;

    /**
     * 画面初期化のメソッドです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     *
     * @return ResponseData
     */
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onLoad(JyusinDataBaitaiTorikomuDiv div) {

        div.getPanelUpload().setVisible(false);
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 受信データリスト.「削除」ボタンのメソッドです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     *
     * @return ResponseData
     */
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onClick_delete(JyusinDataBaitaiTorikomuDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.削除の確認.getMessage().getCode(),
                    UrQuestionMessages.削除の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.削除の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).deleteCsv();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 受信データ媒体取込の「受信データを取り込む」ボタンのメソッドです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     *
     * @return ResponseData
     */
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onClick_torikomu(JyusinDataBaitaiTorikomuDiv div) {

        div.getPanelUpload().setVisible(true);
        List<JyusinDataList_Row> rowList = div.getJyusinDataList().getDataSource();
        for (JyusinDataList_Row row : rowList) {
            row.setDeleteButtonState(DataGridButtonState.Disabled);
        }
        div.getJyusinDataList().setDataSource(rowList);
        return ResponseData.of(div).respond();
    }

    /**
     * 受信データアップロードダイアログ「閉じる」ボタンのメソッドです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     *
     * @return ResponseData
     */
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onClick_close(JyusinDataBaitaiTorikomuDiv div) {

        div.getPanelUpload().setVisible(false);
        List<JyusinDataList_Row> rowList = div.getJyusinDataList().getDataSource();
        for (JyusinDataList_Row row : rowList) {
            row.setDeleteButtonState(DataGridButtonState.Enabled);
        }
        div.getJyusinDataList().setDataSource(rowList);
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードButtonaを押します.
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     * @param files FileData[]
     * @return ResponseData<JyusinDataBaitaiTorikomuDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<JyusinDataBaitaiTorikomuDiv> onClick_btnUpload(JyusinDataBaitaiTorikomuDiv div, FileData[] files) {
        FileData file = new FileData();
        if (files != null && files.length != ゼロ) {
            file = files[ゼロ];
            RString fileName = file.getFileName();
            RString filePath = file.getFilePath();
            ViewStateHolder.put(ViewStateKeys.イメージ情報, (Serializable) fileName);
            ViewStateHolder.put(ViewStateKeys.サービス情報, (Serializable) filePath);
        } else {
            file.setFileName(ViewStateHolder.get(ViewStateKeys.イメージ情報, RString.class));
            file.setFilePath(ViewStateHolder.get(ViewStateKeys.サービス情報, RString.class));
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(file.getFileName()));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        if (files != null && files.length != ゼロ) {
            SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(file.getFilePath()), opts);
        }
        HokenshaSofuListMybatisParameter myBatisParameter = new HokenshaSofuListMybatisParameter();
        try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(file.getFilePath())
                .setDelimiter(カンマ).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
            List<RString> コントロールレコード = csvReader.readLine();
            List<RString> データレコード = csvReader.readLine();

            RString データ種別 = コントロールレコード.get(四);
            RString 給付実績情報作成区分コード = データレコード.get(五);
            if (給付実績情報111.equals(データ種別)) {
                審査年月 = getHandler(div).判断１(データレコード, 給付実績情報作成区分コード, myBatisParameter);
            } else {
                審査年月 = FlexibleYearMonth.MIN;
            }
            if (myBatisParameter.is同月過誤取下分フラグ()) {
                識別番号 = 識別番号011;
            } else {
                識別番号 = データ種別;
            }
            RString 共有ファイル名 = searchSharedFile.concat(識別番号)
                    .concat(コントロールレコード.get(Integer.parseInt(二.toString()))).concat(コントロールレコード.get(六)).concat(CSV);

            List<UzT0885SharedFileEntryEntity> uzt0885EntityList = SharedFile.searchSharedFile(共有ファイル名);
            for (UzT0885SharedFileEntryEntity entity : uzt0885EntityList) {
                List<RString> コントロールレコード2 = csvReader.readLine();
                RString データ種別2 = コントロールレコード2.get(四);
                try {
                    ConfigKeysKokuhorenTorikomi.toValue(データ種別2);
                } catch (IllegalArgumentException e) {
                    ReadOnlySharedFileEntryDescriptor deleteEntity = new ReadOnlySharedFileEntryDescriptor(
                            new FilesystemName(entity.getSharedFileName()), entity.getSharedFileId());
                    SharedFile.deleteEntry(deleteEntity);
                    throw new ApplicationException(DbcErrorMessages.国保連アップロード対象ファイル不正.getMessage());
                }
            }
            getHandler(div).コントロールレコード配列内容チェック(コントロールレコード, file, データレコード, データ種別);
            処理年月 = getHandler(div).処理年月取得(データ種別);
            if (処理年月 != null) {
                処理年月の前月 = 処理年月.minusMonth(一1);
            }

            RString 二重取込チェック = getHandler(div).二重取込チェック(file, データ種別, 処理年月, myBatisParameter, コントロールレコード);
            if (二重取込チェック != null) {
                return getHandler(div).二重取込message(二重取込チェック, 処理年月, データ種別);
            }

            RString 審査年月チェック = getHandler(div).審査年月チェック(file, データ種別, 処理年月の前月, 審査年月の翌月, 審査年月);
            if (審査年月チェック != null) {
                return getHandler(div).審査年月message(審査年月チェック, 処理年月の前月, 審査年月の翌月, 審査年月);
            }

            List<UzT0885SharedFileEntryEntity> uzt0885EntityList2 = SharedFile.searchSharedFile(searchSharedFile);
            getHandler(div).setDatasource(uzt0885EntityList2);
            List<JyusinDataList_Row> rowList = div.getJyusinDataList().getDataSource();
            for (JyusinDataList_Row row : rowList) {
                row.setDeleteButtonState(DataGridButtonState.Disabled);
            }
        }
        return ResponseData.of(div).respond();
    }

    private HokenshaSofuListHandler getHandler(JyusinDataBaitaiTorikomuDiv div) {
        return new HokenshaSofuListHandler(div);
    }
}
