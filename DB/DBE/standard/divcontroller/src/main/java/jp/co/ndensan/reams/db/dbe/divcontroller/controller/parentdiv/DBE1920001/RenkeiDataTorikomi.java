/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1920001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE192001.DBE192001_NnteiShinseiInfoUploadParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.DBE1920001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.RenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.dgTorikomiTaisho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.dgtorikomidataichiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001.RenkeiDataTorikomiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001.RenkeiDataTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi.RenkeiDataTorikomiFinder;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.message.DbxErrorMessages;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定申請連携データ取込のコントローラです。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
public class RenkeiDataTorikomi {

    private static final RString 法改正前 = new RString("key0");
    private static RString 要介護認定申請連携データ取込みファイル名;
    private static RString 認定調査委託先データ取込みファイル名;
    private static RString 認定調査員データ取込みファイル名;
    private static RString 主治医医療機関データ取込みファイル名;
    private static RString 主治医データ取込みファイル名;
    private static boolean 前回認定申請情報ファイルチェックフラグ;
    private static final int なし = 0;

    /**
     * 初期化の設定します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<RenkeiDataTorikomiDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onLoad(RenkeiDataTorikomiDiv div) {
        RString path = RString.EMPTY;
        try {
            path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        } catch (SystemException e) {
            throw new ApplicationException(DbxErrorMessages.業務コンフィグなし.getMessage().replace(ConfigNameDBE.認定申請連携データ出力先.name()));
        }

        getHandler(div).onLoad(RenkeiDataTorikomiFinder.createInstance().get法改正前Flag(FlexibleDate.getNowDate()), path);
        RDate 基準日 = RDate.getNowDate();
        RString 市町村コード = RString.EMPTY;
        ShichosonSecurityJohoFinder finder = InstanceProvider.create(ShichosonSecurityJohoFinder.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = finder.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (市町村セキュリティ情報 != null) {
            if (!市町村セキュリティ情報.get市町村情報().get市町村識別ID().equals(new ShichosonShikibetsuID("00"))) {
                市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード().value();
            }
        }
        if (div.getRenkeiDataTorikomiBatchParameter().getRadHoKaisei().getSelectedKey().equals(法改正前)) {
            要介護認定申請連携データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.要介護認定申請連携データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            認定調査委託先データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定調査委託先データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            認定調査員データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定調査員データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            主治医医療機関データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.主治医医療機関データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            主治医データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.主治医データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
        } else {
            要介護認定申請連携データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.要介護認定申請連携データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            認定調査委託先データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定調査委託先データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            認定調査員データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定調査員データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            主治医医療機関データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.主治医医療機関データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            主治医データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.主治医データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
        }
        RString error = RString.EMPTY;
        for (dgTorikomiTaisho_Row row : div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource()) {
            if (Integer.parseInt(row.getTotal().toString()) > なし) {
                if (要介護認定申請連携データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check認定申請情報ファイル(error, path, false);
                } else if (認定調査委託先データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check認定調査委託先情報ファイル(error, path, false);
                } else if (認定調査員データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check認定調査員情報ファイル(error, path, false);
                } else if (主治医医療機関データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check主治医医療機関情報ファイル(error, path, false);
                } else if (主治医データ取込みファイル名.equals(row.getFileName())) {
                    error = getValidationHandler(div).check主治医情報ファイル(error, path, false);
                }
            }
            row.setSelectable(Boolean.FALSE);
        }
        if (!RString.isNullOrEmpty(error)) {
            return ResponseData.of(div).addMessage(getValidationHandler(div).get初期Error(error)).respond();
        }
        return ResponseData.of(div).setState(DBE1920001StateName.初期表示);
    }

    /**
     * 「連携データの取込みを実行する」ボタンを押下します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @param files 対象ファイル
     * @return ResponseData<RenkeiDataTorikomiDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<RenkeiDataTorikomiDiv> onClick_TorikomiBtn(RenkeiDataTorikomiDiv div, FileData[] files) {
        RString error = RString.EMPTY;
        RString 不正ファイル名 = RString.EMPTY;
        for (FileData file : files) {
            if (要介護認定申請連携データ取込みファイル名.equals(file.getFileName())) {
                error = getValidationHandler(div).check認定申請情報ファイル(error, file.getFilePath(), true);
            } else if (認定調査委託先データ取込みファイル名.equals(file.getFileName())) {
                error = getValidationHandler(div).check認定調査委託先情報ファイル(error, file.getFilePath(), true);
            } else if (認定調査員データ取込みファイル名.equals(file.getFileName())) {
                error = getValidationHandler(div).check認定調査員情報ファイル(error, file.getFilePath(), true);
            } else if (主治医医療機関データ取込みファイル名.equals(file.getFileName())) {
                error = getValidationHandler(div).check主治医医療機関情報ファイル(error, file.getFilePath(), true);
            } else if (主治医データ取込みファイル名.equals(file.getFileName())) {
                error = getValidationHandler(div).check主治医情報ファイル(error, file.getFilePath(), true);
            } else {
                不正ファイル名 = getValidationHandler(div).setファイル名不正(不正ファイル名, file);
            }
        }
        RStringBuilder buider = new RStringBuilder();
        for (FileData file : files) {
            getHandler(div).upLoadFile(file, buider);
        }
        boolean flag = false;
        if (div.getDgTorikomiTaisho().getSelectedItems() != null && !div.getDgTorikomiTaisho().getSelectedItems().isEmpty()) {
            flag = true;
        }
        if (flag) {
            div.getUploadArea().getBtnDataTorikomi().setDisabled(false);
        }
        if (RString.isNullOrEmpty(不正ファイル名) && RString.isNullOrEmpty(error)) {
            getValidationHandler(div).checkゼロ件ファイル(files);
        } else if (RString.isNullOrEmpty(不正ファイル名)){
            div.setHiddenErrorFiles(error);
        } else if (!RString.isNullOrEmpty(不正ファイル名)) {
            div.setHiddenErrorFiles(不正ファイル名);
        }
        dgTorikomiTaisho_Row ninteiShinseiJohoRow = 認定申請情報行取得(div);
        if (ninteiShinseiJohoRow.getSelected()) {
            前回認定申請情報ファイルチェックフラグ = true;
        } else {
            前回認定申請情報ファイルチェックフラグ = false;
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧を表示します。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onClick_SetItiran(RenkeiDataTorikomiDiv div) {
        getHandler(div).getFileData();
        return ResponseData.of(div).setState(DBE1920001StateName.一覧表示);
    }

    /**
     * 「実行する」ボタン押下前、チェック実施。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onClick_JikkouCheck(RenkeiDataTorikomiDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).checkSelected();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを押下します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<RenkeiDataTorikomiBatchParamter>
     */
    public ResponseData<DBE192001_NnteiShinseiInfoUploadParameter> onClick_JikkouBtn(RenkeiDataTorikomiDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }
    
    /**
     * 「実行する」ボタン表示制御。
     *
     * @param div 画面情報
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onSelect_JikkouCheck(RenkeiDataTorikomiDiv div) {
        dgTorikomiTaisho_Row ninteiShinseiJohoRow = 認定申請情報行取得(div);
        if (前回認定申請情報ファイルチェックフラグ && !ninteiShinseiJohoRow.getSelected()) {
            List<dgtorikomidataichiran_Row> list = new ArrayList<>();
            div.getDgtorikomidataichiran().setSelectedItems(list);
        } else if (!前回認定申請情報ファイルチェックフラグ && ninteiShinseiJohoRow.getSelected()) {
            List<dgtorikomidataichiran_Row> dataSource = div.getTorikomiichiran().getDgtorikomidataichiran().getDataSource();
            for (dgtorikomidataichiran_Row dataRow : dataSource) {
                dataRow.setSelected(true);
            }
        }
        前回認定申請情報ファイルチェックフラグ = ninteiShinseiJohoRow.getSelected();
        if (div.getDgTorikomiTaisho().getSelectedItems().isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnExcute"), true);
            
        } else if (認定申請情報行取得(div).getSelected() && div.getDgtorikomidataichiran().getSelectedItems().isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnExcute"), true);
            List<dgTorikomiTaisho_Row> dataSource = div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource();
            for (dgTorikomiTaisho_Row rowData : dataSource) {
                if (!rowData.getFileName().equals(要介護認定申請連携データ取込みファイル名) && rowData.getSelected()) {
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnExcute"), false);
                    break;
                }
            }
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnExcute"), false);
        }
         
        return ResponseData.of(div).respond();
    }

    /**
     * アップロード時のエラーチェックを行います。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> afterUpload(RenkeiDataTorikomiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            Message 不正ファイル名 = getValidationHandler(div).get不正ファイル名();
            if (!不正ファイル名.equals(Message.NO_MESSAGE)) {
                return ResponseData.of(div).addMessage(不正ファイル名).respond();
            }
            Message error = getValidationHandler(div).getError();
            if (!error.equals(Message.NO_MESSAGE)) {
                return ResponseData.of(div).addMessage(error).respond();
            }
            Message message = getValidationHandler(div).getMessage();
            if (!message.equals(Message.NO_MESSAGE)) {
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        return ResponseData.of(div).respond();
    }
    
    /**
     * 法改正ラジオボタンの変更時制御
     * 
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<ShinsakaiIinWaritsukeDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onChange_radHokaisei(RenkeiDataTorikomiDiv div) {
        RDate 基準日 = RDate.getNowDate();
        RString 市町村コード = RString.EMPTY;
        ShichosonSecurityJohoFinder finder = InstanceProvider.create(ShichosonSecurityJohoFinder.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = finder.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (市町村セキュリティ情報 != null) {
            if (!市町村セキュリティ情報.get市町村情報().get市町村識別ID().equals(new ShichosonShikibetsuID("00"))) {
                市町村コード = 市町村セキュリティ情報.get市町村情報().get市町村コード().value();
            }
        }
        if (div.getRenkeiDataTorikomiBatchParameter().getRadHoKaisei().getSelectedKey().equals(法改正前)) {
            要介護認定申請連携データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.要介護認定申請連携データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            認定調査委託先データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定調査委託先データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            認定調査員データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定調査員データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            主治医医療機関データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.主治医医療機関データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            主治医データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.主治医データ取込みファイル名, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
        } else {
            要介護認定申請連携データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.要介護認定申請連携データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            認定調査委託先データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定調査委託先データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            認定調査員データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.認定調査員データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            主治医医療機関データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.主治医医療機関データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
            主治医データ取込みファイル名 = DbBusinessConfig.get(ConfigNameDBE.主治医データ取込みファイル名_新, 基準日, SubGyomuCode.DBE認定支援, 市町村コード);
        }
        RString 要介護認定申請_名称 = DbBusinessConfig.get(ConfigNameDBE.NCI201ファイル名称, 基準日, SubGyomuCode.DBE認定支援);
        RString 認定調査委託先_名称 = DbBusinessConfig.get(ConfigNameDBE.NCI101ファイル名称, 基準日, SubGyomuCode.DBE認定支援);
        RString 認定調査員_名称 = DbBusinessConfig.get(ConfigNameDBE.NCI111ファイル名称, 基準日, SubGyomuCode.DBE認定支援);
        RString 主治医医療機関_名称 = DbBusinessConfig.get(ConfigNameDBE.NCI121ファイル名称, 基準日, SubGyomuCode.DBE認定支援);
        RString 主治医_名称 = DbBusinessConfig.get(ConfigNameDBE.NCI131ファイル名称, 基準日, SubGyomuCode.DBE認定支援);
        List<dgTorikomiTaisho_Row> rowList = div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource();
        for (dgTorikomiTaisho_Row row : rowList) {
            if (row.getMeisho().equals(要介護認定申請_名称)) {
                row.setFileName(要介護認定申請連携データ取込みファイル名);
            } else if (row.getMeisho().equals(認定調査委託先_名称)) {
                row.setFileName(認定調査委託先データ取込みファイル名);
            } else if (row.getMeisho().equals(認定調査員_名称)) {
                row.setFileName(認定調査員データ取込みファイル名);
            } else if (row.getMeisho().equals(主治医医療機関_名称)) {
                row.setFileName(主治医医療機関データ取込みファイル名);
            } else if (row.getMeisho().equals(主治医_名称)) {
                row.setFileName(主治医データ取込みファイル名);
            }
        }
        return ResponseData.of(div).respond();
    }

    private RenkeiDataTorikomiHandler getHandler(RenkeiDataTorikomiDiv div) {
        return new RenkeiDataTorikomiHandler(div);
    }

    private RenkeiDataTorikomiValidationHandler getValidationHandler(RenkeiDataTorikomiDiv div) {
        return new RenkeiDataTorikomiValidationHandler(div);
    }
    
    private dgTorikomiTaisho_Row 認定申請情報行取得(RenkeiDataTorikomiDiv div) {
        dgTorikomiTaisho_Row ninteiShinseiJohoRow = new dgTorikomiTaisho_Row();
        List<dgTorikomiTaisho_Row> dataSource = div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource();
        for (dgTorikomiTaisho_Row rowData : dataSource) {
            if (rowData.getFileName().equals(要介護認定申請連携データ取込みファイル名)) {
                ninteiShinseiJohoRow = rowData;
            }
        }
        return ninteiShinseiJohoRow;
    }
}
