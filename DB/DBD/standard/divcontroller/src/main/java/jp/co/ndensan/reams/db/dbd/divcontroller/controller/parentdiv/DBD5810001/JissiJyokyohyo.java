/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5810001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd581001.YokaigoJissiJyokyohyoParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5810001.JissiJyokyohyoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5810001.JissiJyokyohyoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5810001.JissiJyokyohyoValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 要介護認定実施状況表（統計表）画面のDivControllerです。
 *
 * @reamsid_L DBD-1771-010 chenxin
 */
public class JissiJyokyohyo {

    /**
     * 画面初期化処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<JissiJyokyohyoDiv> onLoad(JissiJyokyohyoDiv div) {
        getHandler().onLoad(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 出力帳票ラジオを操作です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<JissiJyokyohyoDiv> onChange_rdoCyouhyou(JissiJyokyohyoDiv div) {
        getHandler().onChange_rdoCyouhyou(div);
        return ResponseData.of(div).respond();
    }

    public ResponseData<JissiJyokyohyoDiv> onChange_rdoKijyun(JissiJyokyohyoDiv div) {

        return ResponseData.of(div).respond();
    }

    public ResponseData<JissiJyokyohyoDiv> onChange_rdoshinsei(JissiJyokyohyoDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 年齢と生年月日ラジオを操作です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<JissiJyokyohyoDiv> onChange_rdoNenrei(JissiJyokyohyoDiv div) {
        getHandler().onChange_rdoNenrei(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 地区DDLを操作です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<JissiJyokyohyoDiv> onChange_ddlChiku(JissiJyokyohyoDiv div) {
        getHandler().onChange_ddlChiku(div);
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータを設定、バッチ起動を起動します。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<YokaigoJissiJyokyohyoParameter> onCilck_btnJikkou(JissiJyokyohyoDiv div) {

        YokaigoJissiJyokyohyoParameter parameter = new YokaigoJissiJyokyohyoParameter();
        getHandler().onCilck_btnJikkou(div, parameter);
        return ResponseData.of(parameter).respond();
    }

    public ResponseData<JissiJyokyohyoDiv> onBeforeCilck_btnJikkou(JissiJyokyohyoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor行政区大小関係チェック(pairs, div);
        getValidationHandler().validateFor地区２大小関係チェック(pairs, div);
        getValidationHandler().validateFor住所大小関係チェック(pairs, div);
        getValidationHandler().validateFor年齢の未入力チェック(pairs, div);
        getValidationHandler().validateFor生年月日の未入力チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    private JissiJyokyohyoHandler getHandler() {
        return new JissiJyokyohyoHandler();
    }

    private JissiJyokyohyoValidationHandler getValidationHandler() {
        return new JissiJyokyohyoValidationHandler();
    }
}
