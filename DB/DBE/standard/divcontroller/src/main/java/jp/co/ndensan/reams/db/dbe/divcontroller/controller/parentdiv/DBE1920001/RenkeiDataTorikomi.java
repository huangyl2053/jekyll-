/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE1920001;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.renkeidatatorikomi.RenkeiDataTorikomiBatchParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.DBE1920001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001.RenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001.RenkeiDataTorikomiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE1920001.RenkeiDataTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.renkeidatatorikomi.RenkeiDataTorikomiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定申請連携データ取込のコントローラです。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
public class RenkeiDataTorikomi {

    private static final int 一件目 = 0;
    private static final int 二件目 = 1;
    private static final int 三件目 = 2;
    private static final int 四件目 = 3;
    private static final int 五件目 = 4;

    /**
     * 初期化の設定します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<RenkeiDataTorikomiDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onLoad(RenkeiDataTorikomiDiv div) {
        RString path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        getHandler(div).onLoad(RenkeiDataTorikomiFinder.createInstance().get法改正前Flag(FlexibleDate.getNowDate()), path);
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs = getValidationHandler(div).check認定申請情報ファイル(validPairs, path, false);
        validPairs = getValidationHandler(div).check認定調査委託先情報ファイル(validPairs, path, false);
        validPairs = getValidationHandler(div).check認定調査員情報ファイル(validPairs, path, false);
        validPairs = getValidationHandler(div).check主治医医療機関情報ファイル(validPairs, path, false);
        validPairs = getValidationHandler(div).check主治医情報ファイル(validPairs, path, false);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).getFileData();
        if (div.getTorikomiichiran().getDgtorikomidataichiran().getDataSource().isEmpty()) {
            return ResponseData.of(div).respond();
        } else {
            return ResponseData.of(div).setState(DBE1920001StateName.一覧表示);
        }
    }

    /**
     * 「連携データの取込みを実行する」ボタンを押下します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<RenkeiDataTorikomiDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onClick_TorikomiBtn(RenkeiDataTorikomiDiv div) {
        RString path = div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource().get(一件目).getFileName();
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        boolean flag;
        if (path.contains(File.separator)) {
            flag = true;
        } else {
            flag = false;
            path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
        validPairs = getValidationHandler(div).check認定申請情報ファイル(validPairs, path, flag);
        path = div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource().get(二件目).getFileName();
        if (path.contains(File.separator)) {
            flag = true;
        } else {
            flag = false;
            path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
        validPairs = getValidationHandler(div).check認定調査委託先情報ファイル(validPairs, path, flag);
        path = div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource().get(三件目).getFileName();
        if (path.contains(File.separator)) {
            flag = true;
        } else {
            flag = false;
            path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
        validPairs = getValidationHandler(div).check認定調査員情報ファイル(validPairs, path, flag);
        path = div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource().get(四件目).getFileName();
        if (path.contains(File.separator)) {
            flag = true;
        } else {
            flag = false;
            path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
        validPairs = getValidationHandler(div).check主治医医療機関情報ファイル(validPairs, path, flag);
        path = div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getDataSource().get(五件目).getFileName();
        if (path.contains(File.separator)) {
            flag = true;
        } else {
            flag = false;
            path = DbBusinessConfig.get(ConfigNameDBE.認定申請連携データ出力先, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        }
        validPairs = getValidationHandler(div).check主治医情報ファイル(validPairs, path, flag);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).getFileData();
        return ResponseData.of(div).respond();
    }

    /**
     * 「参照」ボタンを押下します。
     *
     * @param div RenkeiDataTorikomiDiv
     * @return ResponseData<RenkeiDataTorikomiDiv>
     */
    public ResponseData<RenkeiDataTorikomiDiv> onClick_SanshouBtn(RenkeiDataTorikomiDiv div) {
        // TOTO 対象ファイルの格納先が「エクスプローラー」で開く
        RStringBuilder builder = new RStringBuilder();
        FileDialog fileDialog = new FileDialog(new Frame(), "連携データの取込みを参照する", FileDialog.LOAD);
        fileDialog.setVisible(true);
        builder.append(fileDialog.getDirectory());
        builder.append(fileDialog.getFile());
        div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getClickedItem().setFileName(builder.toRString());
        div.getRenkeiDataTorikomiBatchParameter().getDgTorikomiTaisho().getClickedItem().setSelected(Boolean.TRUE);
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタン押下前、チェック実施。
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
    public ResponseData<RenkeiDataTorikomiBatchParamter> onClick_JikkouBtn(RenkeiDataTorikomiDiv div) {
        return ResponseData.of(getHandler(div).setBatchParameter()).respond();
    }

    private RenkeiDataTorikomiHandler getHandler(RenkeiDataTorikomiDiv div) {
        return new RenkeiDataTorikomiHandler(div);
    }

    private RenkeiDataTorikomiValidationHandler getValidationHandler(RenkeiDataTorikomiDiv div) {
        return new RenkeiDataTorikomiValidationHandler(div);
    }
}
