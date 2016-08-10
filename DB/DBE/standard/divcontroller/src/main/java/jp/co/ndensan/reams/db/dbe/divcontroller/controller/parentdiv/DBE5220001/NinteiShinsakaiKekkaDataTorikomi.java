/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5220001;

import java.io.File;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5220001.NinteiShinsakaiKekkaDataTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBE5220001_介護認定審査会審査結果データ取込み（モバイル）画面クラスです
 *
 * @reamsid_L DBE-1841-010 xuyongchao
 */
public class NinteiShinsakaiKekkaDataTorikomi {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv>
     */
    public ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv> onLoad(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        getHandler(div).setOnLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 取込み対象データラジオボタンイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv>
     */
    public ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv> onClick_ChkRadTorikomiTaishoData(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        if (div.getRadTorikomiTaishoData().getSelectedKey().contains(SELECT_KEY0)) {
            div.getRadTorikomiNaiyo().setDisabled(false);
            div.getRadShinsain().setDisabled(false);
        } else {
            div.getRadShinsain().setSelectedKey(SELECT_KEY1);
            div.getRadTorikomiNaiyo().setSelectedKey(SELECT_KEY1);
            div.getRadTorikomiNaiyo().setDisabled(true);
            div.getRadShinsain().setDisabled(true);
        }
        getHandler(div).setOnLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 出欠情報ラジオボタンイベント処理です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv>
     */
    public ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv> onClick_ChRradShinsain(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        getHandler(div).setOnLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン処理です。
     *
     * @param div 画面情報
     * @return NinteiShinsakaiKekkaDataTorikomiDiv
     */
    public ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv> onClick_Jikkou(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        getHandler(div).setBatchParameter();
        return ResponseData.of(div).respond();
    }

    /**
     * 「アップロードする」ボタンを押します。
     *
     * @param div 画面情報
     * @param files ファイル
     * @return ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv>
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv> onclick_BtnUpload(NinteiShinsakaiKekkaDataTorikomiDiv div, FileData[] files) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        for (FileData file : files) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).一致性チェック(validationMessages, file.getFileName(), file.getFilePath());
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            savaCsvファイル(file);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 入力チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv>
     */
    public ResponseData<NinteiShinsakaiKekkaDataTorikomiDiv> onClick_Check(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).対象未選択チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        validPairs = getValidationHandler(div).データ件数チェック(validationMessages);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private boolean savaCsvファイル(FileData file) {
        RString path = Path.combinePath(Path.getRootPath(RString.EMPTY), DbBusinessConfig
                .get(ConfigNameDBE.OCRアップロード用ファイル格納パス, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        File サーバ = new File(path.toString());
        File local = new File(file.getFilePath().toString());
        if (サーバ.exists() && local.exists()) {
            return local.renameTo(new File(サーバ, file.getFileName().toString()));
        }
        return true;
    }

    private NinteiShinsakaiKekkaDataTorikomiHandler getHandler(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        return new NinteiShinsakaiKekkaDataTorikomiHandler(div);
    }

    private NinteiShinsakaiKekkaDataTorikomiValidationHandler getValidationHandler(NinteiShinsakaiKekkaDataTorikomiDiv div) {
        return new NinteiShinsakaiKekkaDataTorikomiValidationHandler(div);
    }
}
