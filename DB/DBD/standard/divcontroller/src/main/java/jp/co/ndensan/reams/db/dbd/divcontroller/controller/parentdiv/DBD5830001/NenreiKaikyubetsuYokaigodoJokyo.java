/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5830001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD583001.DBD583001Parameter;
import jp.co.ndensan.reams.db.dbd.definition.core.chiku.ChikuKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5830001.NenreiKaikyubetsuYokaigodoJokyoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5830001.NenreiKaikyubetsuYokaigodoJokyoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5830001.NenreiKaikyubetsuYokaigodoJokyoValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 年齢階級別要介護度状況（統計表）画面のDivControllerです。
 *
 * @reamsid_L DBD-1790-010 donghj
 */
public class NenreiKaikyubetsuYokaigodoJokyo {

    /**
     * 画面初期化処理です。
     *
     * @param div NenreiKaikyubetsuYokaigodoJokyoDiv
     * @return ResponseData<NenreiKaikyubetsuYokaigodoJokyoDiv>
     */
    public ResponseData<NenreiKaikyubetsuYokaigodoJokyoDiv> onLoad(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 基準日と基準年月ラジオを操作です。
     *
     * @param div NenreiKaikyubetsuYokaigodoJokyoDiv
     * @return ResponseData<NenreiKaikyubetsuYokaigodoJokyoDiv>
     */
    public ResponseData<NenreiKaikyubetsuYokaigodoJokyoDiv> onChange_rdoKijyun(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
        getHandler(div).onChange_rdoKijyun();
        return ResponseData.of(div).respond();
    }

    /**
     * 地区DDLを操作です。
     *
     * @param div NenreiKaikyubetsuYokaigodoJokyoDiv
     * @return ResponseData<NenreiKaikyubetsuYokaigodoJokyoDiv>
     */
    public ResponseData<NenreiKaikyubetsuYokaigodoJokyoDiv> onChange_ddlChiku(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
        getHandler(div).onChange_ddlChiku();
        return ResponseData.of(div).respond();
    }

    /**
     * バッチ起動前のチェックです。
     *
     * @param div NenreiKaikyubetsuYokaigodoJokyoDiv
     * @return ResponseData<NenreiKaikyubetsuYokaigodoJokyoDiv>
     */
    public ResponseData<NenreiKaikyubetsuYokaigodoJokyoDiv> onBeforeOpenDialog_btnBatchRegister(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.getDdlChiku().getSelectedValue().equals(ChikuKubun.行政区.get漢字名称())) {
            getValidationHandler().validateFor行政区コード大小関係チェック(pairs, div);
        } else if (div.getDdlChiku().getSelectedValue().equals(ChikuKubun.組合.get漢字名称())) {
            getValidationHandler().validateFor組合コード大小関係チェック(pairs, div);
        } else if (div.getDdlChiku().getSelectedValue().equals(ChikuKubun.住所.get漢字名称())) {
            getValidationHandler().validateFor住所コード大小関係チェック(pairs, div);
        }
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * バッチパラメータを設定です。
     *
     * @param div NenreiKaikyubetsuYokaigodoJokyoDiv
     * @return ResponseData<NenreiKaikyubetsuYokaigodoJokyoParameter>
     */
    public ResponseData<DBD583001Parameter> onClick_btnBatchRegister(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
        DBD583001Parameter parameter = getHandler(div).getParameter();
        return ResponseData.of(parameter).respond();
    }

    private NenreiKaikyubetsuYokaigodoJokyoHandler getHandler(NenreiKaikyubetsuYokaigodoJokyoDiv div) {
        return new NenreiKaikyubetsuYokaigodoJokyoHandler(div);
    }

    private NenreiKaikyubetsuYokaigodoJokyoValidationHandler getValidationHandler() {
        return new NenreiKaikyubetsuYokaigodoJokyoValidationHandler();
    }
}
