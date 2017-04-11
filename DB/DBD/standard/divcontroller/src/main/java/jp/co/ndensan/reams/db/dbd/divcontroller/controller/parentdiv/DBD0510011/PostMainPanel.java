/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD0510011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD130010.DBD130010_KokuhoShikakuIdoInParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD130020.DBD130020_KokikoreishaShikakuIdoInParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD0510011.DBD0510011StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD0510011.PostMainPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD0510011.dgShichoson_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD0510011.PostMainPanelCheck;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD0510011.PostMainPanelHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD0510011.PostMainPanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class PostMainPanel {

    private RString UIContainerID;
    private static final RString DBDUC05100 = new RString("DBDUC05100");
    private static final RString DBDUC05101 = new RString("DBDUC05101");
    private static final RString 国保資格異動情報取込 = new RString("国保資格異動情報取込");
    private static final RString 後期資格異動情報取込 = new RString("後期資格異動情報取込");
    private static final RString STRING_1 = new RString("1");
    private static final RString STRING_2 = new RString("2");
    private static final RDate DATE = RDate.getNowDate();
    private static final RString BTNJIKOKOKUHO = new RString("btnJikoKokuho");
    private static final RString BTNJIKOKOKIKOEI = new RString("btnJikoKokikorei");
    private static final RString NUM_00 = new RString("00");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<PostMainPanelDiv> onLoad(PostMainPanelDiv div) {
        UIContainerID = ResponseHolder.getUIContainerId();
        DBD0510011StateName stateName = DBD0510011StateName.NoChange;
        if (UIContainerID.equals(DBDUC05100)) {
            div.setTitle(国保資格異動情報取込);
            stateName = DBD0510011StateName.国保;
        }
        if (UIContainerID.equals(DBDUC05101)) {
            div.setTitle(後期資格異動情報取込);
            stateName = DBD0510011StateName.後期;
        }
        RString 場合 = getHandler(div).initialize();
        ViewStateHolder.put(ViewStateKeys.場合, 場合);
        return ResponseData.of(div).setState(stateName);
    }

    /**
     * onClick_btnTorikomiのメソッドます。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData PostMainPanelDiv
     */
    public ResponseData<PostMainPanelDiv> onClick_btnTorikomi(PostMainPanelDiv div) {
        div.getFileUpload().setVisible(true);
        UIContainerID = ResponseHolder.getUIContainerId();
        if (UIContainerID.equals(DBDUC05100)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNJIKOKOKUHO, true);
        }
        if (UIContainerID.equals(DBDUC05101)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNJIKOKOKIKOEI, true);
        }

        div.getBtnTorikomi().setDisabled(true);
        List<dgShichoson_Row> rowList = div.getDgShichoson().getDataSource();
        if (rowList != null && !rowList.isEmpty()) {
            for (dgShichoson_Row row : rowList) {
                row.getBtnTorikomiKoiki().setDisabled(true);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnCancelのメソッドます。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData PostMainPanelDiv
     */
    public ResponseData<PostMainPanelDiv> onClick_btnCancel(PostMainPanelDiv div) {
        div.getFileUpload().setVisible(false);
        UIContainerID = ResponseHolder.getUIContainerId();
        if (UIContainerID.equals(DBDUC05100)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNJIKOKOKUHO, false);
        }
        if (UIContainerID.equals(DBDUC05101)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNJIKOKOKIKOEI, false);
        }
        div.getBtnTorikomi().setDisabled(false);
        List<dgShichoson_Row> rowList = div.getDgShichoson().getDataSource();
        if (rowList != null && !rowList.isEmpty()) {
            for (dgShichoson_Row row : rowList) {
                row.getBtnTorikomiKoiki().setDisabled(false);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードButtonaを押します。
     *
     * @param div PostMainPanelDiv
     * @param files FileData[]
     * @return ResponseData PostMainPanelDiv
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<PostMainPanelDiv> onClick_btnUpload(PostMainPanelDiv div, FileData[] files) {
        if (files != null && files.length != 0 && files[0] != null) {
            FileData file = files[0];
            SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(file.getFileName()));
            sfd = SharedFile.defineSharedFile(sfd);
            CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
            SharedFileEntryDescriptor aa = SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(file.getFilePath()), opts);
            getCheck(div).validateCheck();
            RDateTime ファイル日時 = aa.getSharedFileId();
            getHandler(div).setTime(ファイル日時);
        }
        div.getFileUpload().setVisible(false);
        UIContainerID = ResponseHolder.getUIContainerId();
        if (UIContainerID.equals(DBDUC05100)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNJIKOKOKUHO, false);
        }
        if (UIContainerID.equals(DBDUC05101)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(BTNJIKOKOKIKOEI, false);
        }
        div.getBtnTorikomi().setDisabled(false);
        List<dgShichoson_Row> rowList = div.getDgShichoson().getDataSource();
        if (rowList != null && !rowList.isEmpty()) {
            for (dgShichoson_Row row : rowList) {
                row.getBtnTorikomiKoiki().setDisabled(false);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の早期処理」ボタンのメソッドです。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<PostMainPanelDiv> onBeforeOpenCheck(PostMainPanelDiv div) {

        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate(ViewStateHolder.get(
                ViewStateKeys.場合, RString.class));
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<DBD130020_KokikoreishaShikakuIdoInParameter> onClick_btnLast(
            PostMainPanelDiv div) {
        getCheck(div).validateCheckNew();
        DBD130020_KokikoreishaShikakuIdoInParameter param = setBatchParameter(div);
        return ResponseData.of(param).respond();
    }

    private DBD130020_KokikoreishaShikakuIdoInParameter setBatchParameter(PostMainPanelDiv div) {
        DBD130020_KokikoreishaShikakuIdoInParameter parameter = new DBD130020_KokikoreishaShikakuIdoInParameter();
        if (div.getTxtRenkekeishiki().isVisible() && !div.getTxtRenkekeishiki().getValue().isEmpty()
                && !div.getTxtRenkekeishiki().getValue().isNull()) {
            parameter.setInsurerDistinction(STRING_1);
            List<RString> list = new ArrayList<>();
            list.add(NUM_00);
            parameter.setShoriShichoson(list);
        } else {
            parameter.setInsurerDistinction(STRING_2);
            List<RString> listresult = new ArrayList();
            for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                listresult.add(row.getShichosonShikibetuID());
            }
            parameter.setShoriShichoson(listresult);
        }

        parameter.setTableName(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期Ｆ, DATE,
                SubGyomuCode.DBC介護給付));

        parameter.setIfType(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期ＩＦ種類,
                DATE, SubGyomuCode.DBC介護給付));
        parameter.setTorikomiKeishiki(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_後期全件差分区分, DATE,
                SubGyomuCode.DBC介護給付));
        parameter.setShoriTimestamp(new RString(RDate.getNowDateTime().toString()));
        return parameter;
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div PostMainPanelDiv
     * @return ResponseData
     */
    public ResponseData<DBD130010_KokuhoShikakuIdoInParameter> onClick_btnKoku(
            PostMainPanelDiv div) {
        getCheck(div).validateCheckNew();
        DBD130010_KokuhoShikakuIdoInParameter param = setBatchParameters(div);
        return ResponseData.of(param).respond();
    }

    private DBD130010_KokuhoShikakuIdoInParameter setBatchParameters(PostMainPanelDiv div) {
        DBD130010_KokuhoShikakuIdoInParameter parameter = new DBD130010_KokuhoShikakuIdoInParameter();
        if (div.getTxtRenkekeishiki().isVisible() && !div.getTxtRenkekeishiki().getValue().isEmpty()
                && !div.getTxtRenkekeishiki().getValue().isNull()) {
            parameter.setInsurerDistinction(STRING_1);
            List<RString> list = new ArrayList<>();
            list.add(NUM_00);
            parameter.setShoriShichoson(list);
        } else {
            parameter.setInsurerDistinction(STRING_2);
            List<RString> listresult = new ArrayList();
            for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                listresult.add(row.getShichosonShikibetuID());
            }
            parameter.setShoriShichoson(listresult);
        }

        parameter.setTableName(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保Ｆ, DATE,
                SubGyomuCode.DBC介護給付));

        parameter.setIfType(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保ＩＦ種類,
                DATE, SubGyomuCode.DBC介護給付));
        parameter.setTorikomiKeishiki(DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保全件差分区分,
                DATE, SubGyomuCode.DBC介護給付));

        parameter.setShoriTimestamp(new RString(RDate.getNowDateTime().toString()));
        return parameter;
    }

    private PostMainPanelHandler getHandler(PostMainPanelDiv div) {
        return new PostMainPanelHandler(div);
    }

    private PostMainPanelValidationHandler getValidationHandler(PostMainPanelDiv div) {
        return new PostMainPanelValidationHandler(div);
    }

    private PostMainPanelCheck getCheck(PostMainPanelDiv div) {
        return new PostMainPanelCheck(div);
    }
}
