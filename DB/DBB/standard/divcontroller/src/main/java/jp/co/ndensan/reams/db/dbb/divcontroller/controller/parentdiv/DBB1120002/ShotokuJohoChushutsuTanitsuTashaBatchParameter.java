/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1120002;

import java.io.File;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shutokujohochushutsurenkei.ShutokuJohoChushutsuRenkeiBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120002.ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120002.ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 所得情報抽出・連携（単一他社）のクラスです。
 *
 * @reamsid_L DBB-1690-030 sunhui
 */
public class ShotokuJohoChushutsuTanitsuTashaBatchParameter {

    private static final RString 処理待ち = new RString("処理待ち");
    private static final RString ファイル付箋 = new RString("ShotokuJohoChushutsuTanitsuTasha");
    private static final RString COMMON_BUTTON_FIELD_NAME_当初 = new RString("btnBatchRegisterDousyo");
    private static final RString COMMON_BUTTON_FIELD_NAME = new RString("btnBatchRegisterTanitsuTasha");
    private static final ReportId 帳票ID = new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran");
    private static final RString BBKAIGO = new RString("BBKAIGO");
    private static final RString 所得情報抽出_連携当初 = new RString("DBBMN51009");
    private static final RString 所得情報抽出_連携異動 = new RString("DBBMN51010");
    private static final RString 所得情報ファイル = new RString("BBKAIGO.CSV");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     * @return ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv>
     */
    public ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv> onLoad(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div) {
        RString 年度;
        RDate currentTime = RDate.getNowDate();
        RString メニューID = ResponseHolder.getMenuID();
        if (所得情報抽出_連携当初.equals(メニューID)) {
            年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, currentTime,
                    SubGyomuCode.DBB介護賦課);
            div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtShoriNendoTanitsuTasha().setValue(new RDate(年度.toString()));
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME_当初, true);
        } else if (所得情報抽出_連携異動.equals(メニューID)) {
            年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, currentTime,
                    SubGyomuCode.DBB介護賦課);
            div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtShoriNendoTanitsuTasha().setValue(new RDate(年度.toString()));
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME_当初, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, true);
        }
        ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler handler = getHandler(div);
        handler.initCheck(currentTime);
        handler.initTorikoShori(currentTime);
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtShoriNendoTanitsuTasha().setDisabled(true);
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai().setDisabled(true);
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getToriKomiTaisho().getUplUpload().setDisabled(false);
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getToriKomiTaisho().getBtnUpload().setDisabled(false);
        div.getShotokuJohoChushutsuTanitsuTashaPanel().getCcdChohyoShutsuryokujunTanitsuTasha()
                .load(SubGyomuCode.DBB介護賦課, 帳票ID);
        return createResponse(div);
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
        RString filename = files[0].getFileName();
        if (filename == null || !filename.startsWith(BBKAIGO)) {
            throw new ApplicationException(DbzErrorMessages.アップロードファイルが不正.getMessage()
                    .replace(BBKAIGO.toString()).evaluate());
        }
        FilesystemName sharedFileName = new FilesystemName(ファイル付箋);
        SharedFile.defineSharedFile(sharedFileName);
        FilesystemPath 絶対パス = new FilesystemPath(files[0].getFilePath());
        SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        RString path = new RString(SharedFile.getBasePath() + File.separator + 所得情報ファイル);
        File file = new File(path.toString());
        if (file.exists() && file.getName().contains(所得情報ファイル)) {
            div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai().setValue(処理待ち);
        } else {
            div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai().setValue(RString.EMPTY);
        }
        if (div.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai().getValue().equals(処理待ち)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME_当初, false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME_当初, true);
        }
        div.setHiddenResult(filename);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、バリデーションメソッドです。
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     * @return ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv>
     */
    public ResponseData<ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv> onclick_checkRegister(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div) {
        RString fileName = div.getHiddenResult();
        if (fileName == null || !fileName.startsWith(BBKAIGO)) {
            throw new ApplicationException(DbzErrorMessages.アップロードファイルが不正.getMessage()
                    .replace(BBKAIGO.toString()).evaluate());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、バリデーション、バッチパラメータの設定とバッチを起動します。
     *
     * @param div ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv
     * @return ResponseData<ShotokuJohoBatchresultTanituParameter>
     */
    public ResponseData<ShutokuJohoChushutsuRenkeiBatchParameter> onclick_batchRegister(
            ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv div) {
        ShotokuJohoChushutsuTanitsuTashaBatchParameterHandler handler = getHandler(div);
        ShutokuJohoChushutsuRenkeiBatchParameter parameter = handler.getBatchParamter();
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
