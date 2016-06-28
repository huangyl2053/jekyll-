/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1120002;

import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeitanitu.ShotokuJohoTyushutuRenkeiTanituParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120002.ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120002.ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;

/**
 * 所得情報抽出・連携（単一他社）のクラスです。
 *
 * @reamsid_L DBB-1690-030 sunhui
 */
public class ShotokuJohoChushutsuTanitsuTashaBatchParameter {

    private static final RString 処理待ち = new RString("処理待ち");
    private static final RString 所得情報ファイル = new RString("BBKAIGOxxxxxxxx.CSV");
    private static final RString 共有ファイル名 = new RString("ShotokuJohoChushutsuTanitsuTasha");
    private static final RString COMMON_BUTTON_FIELD_NAME = new RString("btnBatchRegisterTanitsuTasha");
    private static final ReportId 帳票ID = new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran");
    private static final ReportId BBKAIGO = new ReportId("BBKAIGO");
    private static final RString RESULT_TRUE = new RString("true");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     * @return ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv>
     */
    public ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv> onLoad(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div) {
        RDate currentTime = RDate.getNowDate();
        ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler handler = getHandler(div);
        handler.initCheck(currentTime);
        handler.initTorikoShori(currentTime);
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtShoriNendoTanitsuTasha().setDisabled(true);
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai().setDisabled(true);
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getToriKomiTaisho().getUplUpload().setDisabled(false);
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getToriKomiTaisho().getBtnUpload().setDisabled(false);
        if (div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai().getValue().equals(処理待ち)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, true);
        }
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getCcdChohyoShutsuryokujunTanitsuTasha()
                .load(SubGyomuCode.DBB介護賦課, 帳票ID);
        return createResponse(div);
    }

    /**
     * ファイルアップロードメソッドです。
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     * @param files FileData[]
     * @return ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv> onclick_uplUpload(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div, FileData[] files) {
        FilesystemName sharedFileName = new FilesystemName(共有ファイル名);
        SharedFile.defineSharedFile(sharedFileName);
        FilesystemPath 絶対パス = new FilesystemPath(files[0].getFilePath());
        SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロード」ボタンのサーバへファイルのアップロードメソッドです。
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     * @param files FileData[]
     * @return ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv> onclick_btnUpload(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div, FileData[] files) {
        onclick_checkRegister(div, files);
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), 所得情報ファイル);
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(所得情報ファイル));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        entry.getFileDescriptor();

        if (RESULT_TRUE.compareTo(div.getHiddenResult()) != 0) {
            throw new ApplicationException(DbzErrorMessages.アップロードファイルが不正.getMessage().evaluate());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、バリデーションメソッドです。
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     * @param files FileData[]
     * @return ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    private ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv> onclick_checkRegister(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div, FileData[] files) {
        if (files != null && files.length == 1) {
            RString filename = files[0].getFileName();
            if (!filename.startsWith(BBKAIGO.toString())) {
                div.setHiddenResult(RESULT_TRUE);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * s
     * 「実行する」を押下場合、バリデーション、バッチパラメータの設定とバッチを起動します。
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     * @return ResponseData<ShotokuJohoTyushutuRenkeiTanituParameter>
     */
    public ResponseData<ShotokuJohoTyushutuRenkeiTanituParameter> onclick_batchRegister(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div) {
        if (RESULT_TRUE.compareTo(div.getHiddenResult()) != 0) {
            throw new ApplicationException(DbzErrorMessages.アップロードファイルが不正.getMessage().evaluate());
        }
        ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler handler = getHandler(div);
        ShotokuJohoTyushutuRenkeiTanituParameter parameter = handler.getBatchParamter();
        return ResponseData.of(parameter).respond();
    }

    private ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv> createResponse(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div) {

        return ResponseData.of(div).respond();
    }

    private ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler getHandler(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div) {
        return ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler.of(div);
    }

}
