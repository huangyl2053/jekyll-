/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0550001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteiidokanendo.HonsanteiIdoDivParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendo.HonsanteiIdoKanendoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.DBB0550001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.KanendoFukaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0550001.KanendoFukaHandler;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendo.HonsanteiIdoKanendo;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @reamsid_L DBB-1760-010 quxiaodong
 */
public class KanendoFuka {

    private static final RString 過年度賦課 = new RString("過年度賦課");
    private static final RString 過年度賦課確定 = new RString("過年度賦課確定");
    private final RString 過年度異動通知書作成 = new RString("DBBMN45002");

    /**
     * onLoad事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KanendoFukaDiv> onLoad(KanendoFukaDiv div) {
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        ShoriDateKanri 過年度賦課基準日時 = HonsanteiIdoKanendo.createInstance().get最大基準日時(過年度賦課, 調定年度);
        ShoriDateKanri 過年度賦課確定基準日時 = HonsanteiIdoKanendo.
                createInstance().get最大基準日時(過年度賦課確定, 調定年度);
        SubGyomuCode サブ業務コード = SubGyomuCode.DBB介護賦課;
        RString 処理名 = ShoriName.過年度賦課.get名称();
        ShoriDateKanri 基準日時 = HonsanteiIdoKanendo.createInstance().
                getShuchutsuKaishiJikan(調定年度, サブ業務コード, 処理名);
        if ((過年度賦課確定基準日時.get基準日時() != null && 過年度賦課基準日時.get基準日時() != null
                && 過年度賦課確定基準日時.get基準日時().isBefore(過年度賦課基準日時.get基準日時()))
                || (過年度賦課確定基準日時.get基準日時() == null || 過年度賦課基準日時.get基準日時() == null)) {
            throw new ApplicationException(DbbErrorMessages.前回過年度賦課確定未処理.getMessage());
        }
        List<ShoriDateKanri> 処理状況list = HonsanteiIdoKanendo.createInstance().getShoriJokyo(調定年度);
        boolean flag = getHandler(div).initialize(調定年度, 処理状況list, 基準日時);
        ViewStateHolder.put(ViewStateKeys.実行フラグ, flag);
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (過年度異動通知書作成.equals(menuID)) {
            div.getKanendoFukaChushutsuJoken().setDisplayNone(true);
            return ResponseData.of(div).setState(DBB0550001StateName.過年度通知書一括発行);
        } else {
            return ResponseData.of(div).setState(DBB0550001StateName.Default);
        }
    }

    /**
     * 「実行する」ボタンの必須チェックのメソッドます。
     *
     * @param div コントロールdiv
     * @return ResponseData
     */
    public ResponseData<KanendoFukaDiv> onClick_onBeforeCheck(KanendoFukaDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).getCheckMessage();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン
     *
     * @param div KanendoFukaDiv
     * @return ResponseData
     */
    public ResponseData<HonsanteiIdoKanendoBatchParameter> onClick_Reserve(KanendoFukaDiv div) {
        HonsanteiIdoDivParameter parameter = getHandler(div).setBatchParam();
        HonsanteiIdoKanendoBatchParameter para = HonsanteiIdoKanendo.createInstance().createBatchParam(parameter);
        return ResponseData.of(para).respond();
    }

    /**
     * 「実行する」ボタンを設定する。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KanendoFukaDiv> onStateTransition(KanendoFukaDiv div) {
        boolean falg = ViewStateHolder.get(ViewStateKeys.実行フラグ, Boolean.class);
        getHandler(div).set実行ボタン(falg);
        return ResponseData.of(div).respond();
    }

    /**
     * 「抽出日時」ボタンを設定する。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KanendoFukaDiv> onChange_radChushutsuJoken(KanendoFukaDiv div) {
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        SubGyomuCode サブ業務コード = SubGyomuCode.DBB介護賦課;
        RString 処理名 = ShoriName.過年度賦課.get名称();
        ShoriDateKanri 基準日時 = HonsanteiIdoKanendo.createInstance().
                getShuchutsuKaishiJikan(調定年度, サブ業務コード, 処理名);
        getHandler(div).set抽出開始日時と終了日時(基準日時);
        return ResponseData.of(div).respond();
    }

    /**
     * 「出力期」ボタンを設定する。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KanendoFukaDiv> onChange_ddlShoritsuki(KanendoFukaDiv div) {
        getHandler(div).set帳票作成個別情報();
        return ResponseData.of(div).respond();
    }

    private KanendoFukaHandler getHandler(KanendoFukaDiv div) {
        return new KanendoFukaHandler(div);
    }
}
