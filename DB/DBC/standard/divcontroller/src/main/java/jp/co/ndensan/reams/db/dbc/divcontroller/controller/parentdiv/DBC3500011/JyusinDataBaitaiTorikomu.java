/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC3500011;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.business.core.hokenshasofulist.HokenshaSofuResult;
import jp.co.ndensan.reams.db.dbc.definition.core.config.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshasofulist.HokenshaSofuListMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011.JyusinDataBaitaiTorikomuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011.JyusinDataList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3500011.HokenshaSofuListHandler;
import jp.co.ndensan.reams.db.dbc.service.core.hokenshasofu.HokenshaSofuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
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
    private final RString sharedFileStr = new RString("1_");
    private final RString searchSharedFile = new RString("1\\_%");
    private static final int 一1 = 1;
    private static final int 四 = 4;
    private static final int 五 = 5;
    private static final int 六 = 6;
    private static final RString カンマ = new RString(",");
    private static final RString CSV = new RString(".csv");
    private static final RString 給付実績情報111 = new RString("111");
    private static final RString 識別番号011 = new RString("011");
    private FlexibleYearMonth 審査年月;
    private FlexibleYearMonth 審査年月の翌月;
    private FlexibleYearMonth 処理年月;
    private static final int 処理年月INDEX = 10;
    private FlexibleYearMonth 処理年月の前月;
    private RString 識別番号;
    private static final int 配列 = 1024000;

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
            ViewStateHolder.put(ViewStateKeys.共有ファイル名, (Serializable) fileName);
            ViewStateHolder.put(ViewStateKeys.共有ファイルエントリ情報, (Serializable) filePath);
        } else {
            file.setFileName(ViewStateHolder.get(ViewStateKeys.共有ファイル名, RString.class));
            file.setFilePath(ViewStateHolder.get(ViewStateKeys.共有ファイルエントリ情報, RString.class));
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
            }
            if (myBatisParameter.is同月過誤取下分フラグ()) {
                識別番号 = 識別番号011;
            } else {
                識別番号 = データ種別;
            }
            RString 共有ファイル名 = sharedFileStr.concat(識別番号).concat(コントロールレコード.get(六)).concat(CSV);

            getHandler(div).コントロールレコード配列内容チェック(コントロールレコード, file, データレコード, データ種別);

            処理年月 = getHandler(div).処理年月取得(データ種別);
            処理年月の前月 = FlexibleYearMonth.EMPTY;
            if (処理年月 != null && !処理年月.isEmpty()) {
                処理年月の前月 = 処理年月.minusMonth(一1);
            }
            HokenshaSofuResult entity = HokenshaSofuFinder.createInstance().get国保連管理(データ種別, 処理年月);
            RString 二重取込チェック = getHandler(div).二重取込チェック(file, データ種別, myBatisParameter, コントロールレコード, entity);

            if (二重取込チェック != null) {
                return 二重取込message(二重取込チェック, コントロールレコード.get(処理年月INDEX), データ種別, div);
            }

            entity = HokenshaSofuFinder.createInstance().get国保連管理2(データ種別, 処理年月の前月);
            KokuhorenInterfaceKanri kanri = null;
            if (判断(entity)) {
                kanri = entity.getKokuhorenInterfaceKanriList().get(ゼロ);
            }
            審査年月の翌月 = FlexibleYearMonth.EMPTY;
            if (kanri != null && kanri.get実績データ上審査年月() != null && !kanri.get実績データ上審査年月().isEmpty()) {
                審査年月の翌月 = kanri.get実績データ上審査年月().plusMonth(一1);
            }
            RString 審査年月チェック = getHandler(div).審査年月チェック(file, データ種別, 審査年月の翌月, 審査年月, kanri);
            if (審査年月チェック != null) {
                return 審査年月message(審査年月チェック, 処理年月の前月, 審査年月の翌月, 審査年月, div);
            }

            upload共有ファイル情報(共有ファイル名, file);
            set共有ファイル情報to画面Grid(div);
            div.getPanelUpload().setVisible(false);
        } catch (Exception ex) {
            throw ex;
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<JyusinDataBaitaiTorikomuDiv> 二重取込message(RString 二重取込チェック,
            RString 処理年月, RString データ種別, JyusinDataBaitaiTorikomuDiv div) {
        switch (二重取込チェック.toString()) {
            case "国保連取込済続行確認":
                return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連取込済続行確認.getMessage()
                        .replace(処理年月.toString(), ConfigKeysKokuhorenTorikomi.toValue(データ種別).toString())).respond();
            case "国保連取込済二重取込続行確認":
                return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連取込済二重取込続行確認.getMessage()
                        .replace(処理年月.toString(), ConfigKeysKokuhorenTorikomi.toValue(データ種別).toString())).respond();
            default:
                return ResponseData.of(div).respond();
        }
    }

    private ResponseData<JyusinDataBaitaiTorikomuDiv> 審査年月message(RString 審査年月チェック, FlexibleYearMonth 処理年月の前月,
            FlexibleYearMonth 審査年月の翌月, FlexibleYearMonth 審査年月, JyusinDataBaitaiTorikomuDiv div) {
        switch (審査年月チェック.toString()) {
            case "国保連先月処理なし取込漏れ確認":
                return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連先月処理なし取込漏れ確認.getMessage()
                        .replace(get和暦年月(処理年月の前月).toString())).respond();
            case "国保連取込漏れ確認":
                return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連取込漏れ確認.getMessage()
                        .replace(get和暦年月(審査年月の翌月).toString(), get和暦年月(審査年月).toString())).respond();
            case "国保連取込順序逆転確認":
                return ResponseData.of(div).addMessage(DbcQuestionMessages.国保連取込順序逆転確認.getMessage()
                        .replace(get和暦年月(審査年月の翌月).toString(), get和暦年月(審査年月).toString())).respond();
            default:
                return ResponseData.of(div).respond();
        }
    }

    private RString get和暦年月(FlexibleYearMonth 年月) {
        if (null == 年月 || FlexibleYearMonth.EMPTY.equals(年月)) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.ZERO).toDateString();
    }

    private void upload共有ファイル情報(RString fileName, FileData file) {
        File from = new File(file.getFilePath().toString());
        File to = new File(from.getParent() + File.separator + fileName.toString());
        try {
            copyFile(from, to);
        } catch (IOException ex) {
            Logger.getLogger(JyusinDataBaitaiTorikomu.class.getName()).log(Level.SEVERE, null, ex);
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(fileName));
        sfd = SharedFile.defineSharedFile(sfd, 1, SharedFile.GROUP_ALL, null, true, null);

        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(to.getPath()), opts);
    }

    private void set共有ファイル情報to画面Grid(JyusinDataBaitaiTorikomuDiv div) {
        List<UzT0885SharedFileEntryEntity> uzt0885EntityList2 = SharedFile.searchSharedFile(searchSharedFile);
        getHandler(div).setDatasource(uzt0885EntityList2);
    }

    private boolean 判断(HokenshaSofuResult entity) {
        return entity != null && entity.getKokuhorenInterfaceKanriList() != null && !entity.getKokuhorenInterfaceKanriList().isEmpty();
    }

    private HokenshaSofuListHandler getHandler(JyusinDataBaitaiTorikomuDiv div) {
        return new HokenshaSofuListHandler(div);
    }

    private void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
            //CHECKSTYLE IGNORE IllegalToken FOR NEXT 1 LINES
            byte[] b = new byte[配列];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            outBuff.flush();
        } finally {
            if (inBuff != null) {
                inBuff.close();
            }
            if (outBuff != null) {
                outBuff.close();
            }
        }
    }
}
