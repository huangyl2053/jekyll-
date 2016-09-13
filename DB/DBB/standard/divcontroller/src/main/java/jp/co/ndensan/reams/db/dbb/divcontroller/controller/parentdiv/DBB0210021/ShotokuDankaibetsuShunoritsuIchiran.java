/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0210021;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021021.DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210021.ShotokuDankaibetsuShunoritsuIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210021.ShotokuDankaibetsuShunoritsuIchiranHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210021.ShotokuDankaibetsuShunoritsuIchiranHandlerValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBB0210021_保険料段階別収納率一覧表作成のクラスです。
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
public class ShotokuDankaibetsuShunoritsuIchiran {

    /**
     * onloadのメソッドです。
     *
     * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
     * @return ResponseData ShotokuDankaibetsuShunoritsuIchiranDiv
     */
    public ResponseData<ShotokuDankaibetsuShunoritsuIchiranDiv> onload(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        getHandler(div).onLoad();
        div.getCcdChikuShichosonSelect().initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * onChange_radChushutsuJokenのメソッドです。
     *
     * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
     * @return ResponseData ShotokuDankaibetsuShunoritsuIchiranDiv
     */
    public ResponseData<ShotokuDankaibetsuShunoritsuIchiranDiv> onChange_radChushutsuJoken(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        RDate 基準日 = RDate.getNowDate();
        RString 日付関連_調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, 基準日, SubGyomuCode.DBB介護賦課);
        RDate 調定年度 = new RDate(日付関連_調定年度.toString());
        getHandler(div).onChange_radChushutsuJoken(調定年度);
        return ResponseData.of(div).respond();
    }

    /**
     * onChange_radUmareYMDのメソッドです。
     *
     * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
     * @return ResponseData ShotokuDankaibetsuShunoritsuIchiranDiv
     */
    public ResponseData<ShotokuDankaibetsuShunoritsuIchiranDiv> onChange_radUmareYMD(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        getHandler(div).年齢_生年月日の選択状態();
        return ResponseData.of(div).respond();
    }

    /**
     * onBeforeOpenDialogのメソッドです。
     *
     * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
     * @return ResponseData ShotokuDankaibetsuShunoritsuIchiranDiv
     */
    public ResponseData<ShotokuDankaibetsuShunoritsuIchiranDiv> onBeforeOpenDialog(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        ShotokuDankaibetsuShunoritsuIchiranHandlerValidationHandler validation = new ShotokuDankaibetsuShunoritsuIchiranHandlerValidationHandler(div);
        ValidationMessageControlPairs pairs = validation.validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * onClick_btnBatchRegisterのメソッドです。
     *
     * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
     * @return ResponseData
     * DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter
     */
    public ResponseData<DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter> onClick_btnBatchRegister(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter parameter = getHandler(div).createDankaibetsuShunoritsuIchiranBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    /**
     * onClick_btnBatchReserveのメソッドです。
     *
     * @param div ShotokuDankaibetsuShunoritsuIchiranDiv
     * @return ResponseData
     * DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter
     */
    public ResponseData<DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter> onClick_btnBatchReserve(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        DBB021021_DankaibetsuShunoritsuIchiranhyoSakuseiParameter parameter = getHandler(div).createDankaibetsuShunoritsuIchiranBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private ShotokuDankaibetsuShunoritsuIchiranHandler getHandler(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
        return ShotokuDankaibetsuShunoritsuIchiranHandler.of(div);
    }
}
