/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0510001;

import jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennen.SanteiIdoGennen;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.CreateHonsanteiIdoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001.DBB0510001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001.HonsanteiIdoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0510001.HonsanteiIdoHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0510001.HonsanteiIdoValidationHandler;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidogennendo.HonsanteiIdoGennendo;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM44001_本算定異動（現年度）のクラスです。
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class HonsanteiIdo {

    private static final RString 現年度異動賦課 = new RString("DBBMN44001");

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return ResponseData
     */
    public ResponseData<HonsanteiIdoDiv> onLoad(HonsanteiIdoDiv div) {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        if (getHandler(div).is基準日時(調定年度)) {
            throw new ApplicationException(DbbErrorMessages.異動賦課の確定処理が未処理.getMessage());
        }
        boolean flag = getHandler(div).initialize(new FlexibleYear(調定年度.toString()));
        ViewStateHolder.put(ViewStateKeys.実行フラグ, flag);
        if (現年度異動賦課.equals(ResponseHolder.getMenuID())) {
            return ResponseData.of(div).setState(DBB0510001StateName.現年度異動賦課);
        } else {
            return ResponseData.of(div).setState(DBB0510001StateName.現年度異動賦課通知書作成);
        }
    }

    /**
     * 「実行する」ボタンの必須チェックのメソッドです。
     *
     * @param div コントロールdiv
     * @return ResponseData
     */
    public ResponseData<HonsanteiIdoDiv> onClick_onBeforeCheck(HonsanteiIdoDiv div) {

        ValidationMessageControlPairs pairs = getHandler(div).getCheckMessage();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        pairs = getValidationHandler(div).処理対象と出力期のValidate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        getHandler(div).check帳票ID(new FlexibleYear(調定年度));
        return ResponseData.of(div).respond();
    }

    /**
     * 現年度異動賦課「実行する」ボタンをクリックのメソッドです。
     *
     * @param div コントロールdiv
     * @return ResponseData
     */
    public ResponseData<CreateHonsanteiIdoBatchParameter> onClick_Register(HonsanteiIdoDiv div) {
        SanteiIdoGennen paramter = getHandler(div).setParamter();
        CreateHonsanteiIdoBatchParameter batchParamter = HonsanteiIdoGennendo.createInstance().createBatchParam(paramter);
        return ResponseData.of(batchParamter).respond();
    }

    /**
     * 現年度異動賦課通知書作成「実行する」ボタンをクリックのメソッドです。
     *
     * @param div コントロールdiv
     * @return ResponseData
     */
    public ResponseData<CreateHonsanteiIdoBatchParameter> onClick_btnTsuchishoRegister(HonsanteiIdoDiv div) {
        SanteiIdoGennen paramter = getHandler(div).setParamter();
        CreateHonsanteiIdoBatchParameter batchParamter = HonsanteiIdoGennendo.createInstance().createBatchParam(paramter);
        return ResponseData.of(batchParamter).respond();
    }

    /**
     * 「実行する」ボタン表示制御を設定です。
     *
     * @param div HonsanteiIdoDiv
     * @return ResponseData
     */
    public ResponseData<HonsanteiIdoDiv> onStateTransition(HonsanteiIdoDiv div) {
        boolean falg = ViewStateHolder.get(ViewStateKeys.実行フラグ, Boolean.class);
        getHandler(div).set実行ボタン(falg);
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出条件のメソッドです。
     *
     * @param div HonsanteiIdoDiv
     * @return ResponseData
     */
    public ResponseData<HonsanteiIdoDiv> onChange_radChushutsuJoken(HonsanteiIdoDiv div) {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        getHandler(div).set抽出条件(new FlexibleYear(調定年度));
        return ResponseData.of(div).respond();
    }

    /**
     * 「処理対象」コンボボックスのメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<HonsanteiIdoDiv> onChange_ddlShoritsuki(HonsanteiIdoDiv div) {
        RDate date = RDate.getNowDate();
        getHandler(div).set帳票グループ(date);
        return ResponseData.of(div).respond();
    }

    private HonsanteiIdoHandler getHandler(HonsanteiIdoDiv div) {
        return new HonsanteiIdoHandler(div);
    }

    private HonsanteiIdoValidationHandler getValidationHandler(HonsanteiIdoDiv div) {
        return new HonsanteiIdoValidationHandler(div);
    }
}
