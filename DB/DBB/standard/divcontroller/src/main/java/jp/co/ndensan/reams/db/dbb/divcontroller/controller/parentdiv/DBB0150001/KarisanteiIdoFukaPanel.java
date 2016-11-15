/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0150001;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.karisanteiidofuka.TyouhyouResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015001.DBB015001_KarisanteiIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015003.DBB015003_KarisanteiIdoTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.DBB0150001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.KarisanteiIdoFukaPanelDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0150001.KarisanteiIdoFukaPanelHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBBGM36001_仮算定異動賦課のクラスです。
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoFukaPanel {

    private static final RString 仮算定異動賦課_MENU = new RString("DBBMN36001");
    private static final RString 特徴仮算定賦課 = new RString("仮算定異動賦課");
    private static final RString 通知書一括発行 = new RString("仮算定異動通知書作成");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaPanelDiv> onLoad(KarisanteiIdoFukaPanelDiv div) {
        if (getHandler(div).is基準日時()) {
            throw new ApplicationException(DbbErrorMessages.異動賦課の確定処理が未処理.getMessage());
        }
        List<TyouhyouResult> 帳票IDList = new ArrayList<>();
        boolean flag = getHandler(div).initialize(帳票IDList);
        ViewStateHolder.put(ViewStateKeys.実行フラグ, flag);
        ViewStateHolder.put(ViewStateKeys.仮算定異動賦課_帳票IDリスト, (Serializable) 帳票IDList);
        if (仮算定異動賦課_MENU.equals(ResponseHolder.getMenuID())) {
            return ResponseData.of(ResponseData.of(div).setState(
                    DBB0150001StateName.仮算定異動賦課).data).rootTitle(特徴仮算定賦課).respond();
        } else {
            return ResponseData.of(ResponseData.of(div).setState(
                    DBB0150001StateName.通知書一括発行).data).rootTitle(通知書一括発行).respond();
        }
    }

    /**
     * 「実行する」ボタンの必須チェックのメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaPanelDiv> onClick_onBeforeCheck(KarisanteiIdoFukaPanelDiv div) {
        ValidationMessageControlPairs pairs = getHandler(div).getCheckMessage();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).check帳票ID();
        return ResponseData.of(div).respond();
    }

    /**
     * 仮算定異動賦課「実行する」ボタンのメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<DBB015001_KarisanteiIdoFukaParameter> onClick_btnSantei(KarisanteiIdoFukaPanelDiv div) {
        List<TyouhyouResult> 帳票IDList = ViewStateHolder.get(ViewStateKeys.仮算定異動賦課_帳票IDリスト, List.class);
        DBB015001_KarisanteiIdoFukaParameter paramter = getHandler(div).getバッチパラメータ(帳票IDList);
        return ResponseData.of(paramter).respond();
    }

    /**
     * 仮算定異動通知書一括発行「実行する」ボタンのメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<DBB015003_KarisanteiIdoTsuchishoHakkoParameter> onClick_btnIkkatsuHakko(KarisanteiIdoFukaPanelDiv div) {
        List<TyouhyouResult> 帳票IDList = ViewStateHolder.get(ViewStateKeys.仮算定異動賦課_帳票IDリスト, List.class);
        DBB015001_KarisanteiIdoFukaParameter paramter = getHandler(div).getバッチパラメータ(帳票IDList);
        return ResponseData.of(paramter.toDBB015003_KarisanteiIdoTsuchishoHakkoParameter()).respond();
    }

    /**
     * 「処理対象」コンボボックスのメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaPanelDiv> onChange_ddlShorigetsu(KarisanteiIdoFukaPanelDiv div) {
        RDate date = RDate.getNowDate();
        getHandler(div).set帳票グループ(date);
        return ResponseData.of(div).respond();
    }

    /**
     * 抽出条件のメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaPanelDiv> onChange_radChushutsuJoken(KarisanteiIdoFukaPanelDiv div) {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        getHandler(div).set抽出条件(調定年度);
        return ResponseData.of(div).respond();
    }

    /**
     * 「出力期」を変更すると、「発行日」も変更するのメソッドます。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaPanelDiv> onChange_ddlNotsuShuturyokuki(KarisanteiIdoFukaPanelDiv div) {
        getHandler(div).set納入通知書の発行日();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタンを設定する。
     *
     * @param div KarisanteiIdoFukaPanelDiv
     * @return ResponseData
     */
    public ResponseData<KarisanteiIdoFukaPanelDiv> onStateTransition(KarisanteiIdoFukaPanelDiv div) {
        boolean falg = ViewStateHolder.get(ViewStateKeys.実行フラグ, Boolean.class);
        getHandler(div).set実行ボタン(falg);
        return ResponseData.of(div).respond();
    }

    private KarisanteiIdoFukaPanelHandler getHandler(KarisanteiIdoFukaPanelDiv div) {
        return new KarisanteiIdoFukaPanelHandler(div);
    }
}
