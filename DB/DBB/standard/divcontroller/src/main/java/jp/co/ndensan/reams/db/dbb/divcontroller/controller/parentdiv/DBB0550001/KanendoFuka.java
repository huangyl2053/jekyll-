/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0550001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteiidokanendo.HonsanteiIdoDivParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteiidokanendo.HonsanteiIdoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendo.HonsanteiIdoKanendoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendo.HonsanteiIdoKanendoResult;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.DBB0550001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.KanendoFukaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0550001.KanendoFukaHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0550001.KanendoFukaValidationHandler;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendo.HonsanteiIdoKanendo;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
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
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("2");

    /**
     * onLoad事件
     *
     * @param div KyufuShiharayiMeisaiPanelDiv
     * @return ResponseData
     */
    public ResponseData<KanendoFukaDiv> onLoad(KanendoFukaDiv div) {
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        ShoriDateKanri shoriDate1 = HonsanteiIdoKanendo.createInstance().get最大基準日時(過年度賦課, 調定年度);
        ShoriDateKanri shoriDate2 = HonsanteiIdoKanendo.createInstance().get最大基準日時(過年度賦課確定, 調定年度);
        ShoriDateKanri shoriDate3 = HonsanteiIdoKanendo.createInstance().getShuchutsuKaishiJikan(調定年度);
        if (shoriDate2.get基準日時() != null && shoriDate1.get基準日時() != null
                && shoriDate2.get基準日時().compareTo(shoriDate1.get基準日時()) < 0) {
            throw new ApplicationException(DbbErrorMessages.前回過年度賦課確定未処理.getMessage());
        }
        List<ShoriDateKanri> shdaList = HonsanteiIdoKanendo.createInstance().getShoriJokyo(調定年度);
        RString 決定_変更通知書区分 = ZERO;
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi().isAllSelected()) {
            決定_変更通知書区分 = ONE;
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi().isAllSelected()) {
            決定_変更通知書区分 = TWO;
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi().isAllSelected()
                && div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi().isAllSelected()) {
            決定_変更通知書区分 = THREE;
        }
        boolean flag = getHandler(div).initialize(調定年度, shdaList, shoriDate3);
        check帳票ID(決定_変更通知書区分, div);
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
        ValidationMessageControlPairs pairs = getValidationHandler(div).実行チェック();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        check帳票ID(ZERO, div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン
     *
     * @param div KanendoFukaDiv
     * @return ResponseData
     */
    public ResponseData<HonsanteiIdoKanendoBatchParameter> onImplement(KanendoFukaDiv div) {
        HonsanteiIdoDivParameter parameter = getHandler(div).setBatchParam();
        HonsanteiIdoKanendoBatchParameter para = HonsanteiIdoKanendo.createInstance().createBatchParam(parameter);
        return ResponseData.of(para).respond();
    }

    private void check帳票ID(RString 決定_変更通知書区分, KanendoFukaDiv div) {
        KanendoKiUtil kanUtil = new KanendoKiUtil();
        KitsukiList 期月リスト = kanUtil.get期月リスト();
        Kitsuki 期月 = 期月リスト.get月の期(Tsuki.toValue((div.getKanendoShoriNaiyo().
                getDdlShoritsuki().getSelectedKey())));
        List<HonsanteiIdoParameter> hoList = getHandler(div).get各通知書の帳票ID();
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        List<HonsanteiIdoKanendoResult> hoKnList = HonsanteiIdoKanendo.
                createInstance().getChohyoID(調定年度, 期月.get期(), hoList, 決定_変更通知書区分);
        for (HonsanteiIdoKanendoResult list : hoKnList) {
            RString 帳票ID = list.get帳票ID();
            if (帳票ID == null || 帳票ID.isEmpty()) {
                throw new ApplicationException(DbbErrorMessages.帳票ID取得不可のため処理不可.getMessage());
            }
        }
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

    private KanendoFukaHandler getHandler(KanendoFukaDiv div) {
        return new KanendoFukaHandler(div);
    }

    private KanendoFukaValidationHandler getValidationHandler(KanendoFukaDiv div) {
        return new KanendoFukaValidationHandler(div);
    }

}
