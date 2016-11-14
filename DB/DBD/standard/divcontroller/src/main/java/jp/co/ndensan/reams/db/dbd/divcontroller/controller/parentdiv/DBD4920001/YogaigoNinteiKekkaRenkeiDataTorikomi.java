/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4920001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD492001.DBD492001_NinteiKekkaInfoUploadParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.DBD4920001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4920001.YogaigoNinteiKekkaRenkeiDataTorikomiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4920001.YogaigoNinteiKekkaRenkeiDataTorikomiHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4920001.YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定結果連携データ取込のコントローラです。
 *
 * @reamsid_L DBD-1510-010 liuyl
 */
public class YogaigoNinteiKekkaRenkeiDataTorikomi {

    /**
     * 初期化の設定します。
     *
     * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
     * @return ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv>
     */
    public ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv> onLoad(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 取込みデータを押下。
     *
     * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
     * @return ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv>
     */
    public ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv> onChange_data(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        getHandler(div).onChange_data();
        return ResponseData.of(div).respond();
    }

    /**
     * 新/旧フォーマットを押下。
     *
     * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
     * @return ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv>
     */
    public ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv> onChange_type(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        getHandler(div).onChange_type();
        return ResponseData.of(div).respond();
    }

    /**
     * 連携データを取込みするを押下。
     *
     * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
     * @param files FileData[]
     * @return ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv>
     */
    public ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv> onClick_appurodo(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div, FileData... files) {
        if (files.length > 0) {
            getHandler(div).before_onClick(files);
            YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler validationHandler = new YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler(div);
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            if (!div.getHdNum().getValue().equals(new RString("0")) && !div.getUploadTool().getRemainUnUploadedFiles().get(0).
                    equalsIgnoreCase(div.getDataGridFile().getDataSource().get(0).getFileName())) {
                if (div.getRadDataSelect().getSelectedKey().equals(new RString("key0"))) {
                    throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("日次進捗情報ファイル"));
                } else {
                    throw new ApplicationException(UrErrorMessages.不正.getMessage().replace("認定結果情報ファイル"));
                }
            }
            RString csvPath = getHandler(div).onClick_appurodo(files);
            ViewStateHolder.put(ViewStateKeys.利用モード, csvPath);
            div.getDataGridFile().getDataSource().get(0).setTotal(div.getNum());
            validationHandler.保険者一致チェック_識別コード(pairs);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return ResponseData.of(div).setState(DBD4920001StateName.一覧表示);

    }

    /**
     * 画面の取込ファイル内容一覧に設定する。
     *
     * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
     * @return ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv>
     */
    public ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv> after_onClick(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {

        return ResponseData.of(div).setState(DBD4920001StateName.一覧表示);
    }

    /**
     * 実行ボタンのチェックです。
     *
     * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
     * @return ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv>
     */
    public ResponseData<YogaigoNinteiKekkaRenkeiDataTorikomiDiv> before_onClick(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler validationHandler = new YogaigoNinteiKekkaRenkeiDataTorikomiValidationHandler(div);
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        validationHandler.取込みファイル内容一覧対象未選択チェック(pairs);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        if (div.getHokenshaList().getSelectedItem().get証記載保険者番号() != null
                && !div.getHokenshaList().getSelectedItem().get証記載保険者番号().isEmpty()) {
            validationHandler.保険者一致チェック_保険者番号(pairs);
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタン処理です。
     *
     * @param div YogaigoNinteiKekkaRenkeiDataTorikomiDiv
     * @return ResponseData<DBD492001_NinteiKekkaInfoUploadParameter>
     */
    public ResponseData<DBD492001_NinteiKekkaInfoUploadParameter> onClick_btnBatch(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        RString csvPath = ViewStateHolder.get(ViewStateKeys.利用モード, RString.class);
        DBD492001_NinteiKekkaInfoUploadParameter parameter = getHandler(div).toParameter(csvPath);
        return ResponseData.of(parameter).respond();
    }

    private YogaigoNinteiKekkaRenkeiDataTorikomiHandler getHandler(YogaigoNinteiKekkaRenkeiDataTorikomiDiv div) {
        return new YogaigoNinteiKekkaRenkeiDataTorikomiHandler(div);
    }

}
