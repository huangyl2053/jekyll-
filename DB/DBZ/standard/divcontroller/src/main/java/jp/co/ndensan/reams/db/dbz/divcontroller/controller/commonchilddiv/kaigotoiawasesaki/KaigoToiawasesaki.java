/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.kaigotoiawasesaki;

import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesakiIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigotoiawasesaki.KaigoToiawasesaki.KaigoToiawasesakiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigotoiawasesaki.KaigoToiawasesaki.KaigoToiawasesakiHandler;
import jp.co.ndensan.reams.db.dbz.service.core.kaigotoiawasesaki.KaigoToiawasesakiFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 介護問合せ先のコントローラです。
 *
 * @reamsid_L DBA-1201-040 xuyannan
 */
public class KaigoToiawasesaki {

    private static final RString 表示モード_追加 = new RString("追加");
    private static final RString 表示モード_表示 = new RString("表示");
    private static final RString 表示モード_修正 = new RString("修正");
    private static final ReportId CHOHYOBUNRUIID = new ReportId("000000000");
    private static final RString 介護共通 = new RString("0");
    private static final RString サブ業務単位 = new RString("1");
    private static final RString 帳票独自無し = new RString("0");
    private static final RString 帳票独自あり = new RString("1");

    /**
     * 介護問合せ先の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoToiawasesakiDiv>
     */
    public ResponseData<KaigoToiawasesakiDiv> onLoad(KaigoToiawasesakiDiv div) {
        ViewStateHolder.put(ViewStateKeys.介護問合せ先情報,
                Models.create(KaigoToiawasesakiFinder.createInstance().get介護問合せ先情報().records()));
        RString 問合せ先管理単位 = DbBusinessConfig.get(ConfigNameDBU.問合せ先_管理単位, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        SubGyomuCode subGyomuCode = SubGyomuCode.EMPTY;
        if (介護共通.equals(問合せ先管理単位)) {
            subGyomuCode = SubGyomuCode.DBZ介護共通;
        } else if (サブ業務単位.equals(問合せ先管理単位)) {
            subGyomuCode = new SubGyomuCode(div.getHdnSubGyomuCode());
        }
        getHandler(div).onLoad(
                KaigoToiawasesakiFinder.createInstance().getResult(subGyomuCode, CHOHYOBUNRUIID),
                KaigoToiawasesakiFinder.createInstance().getResult(
                        new SubGyomuCode(div.getHdnSubGyomuCode()), new ReportId(div.getHdnChohyoBunruiID())), 問合せ先管理単位);
        return ResponseData.of(div).respond();
    }

    /**
     * 「帳票独自を追加する」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoToiawasesakiDiv>
     */
    public ResponseData<KaigoToiawasesakiDiv> onClick_btnAddChohyoDokuji(KaigoToiawasesakiDiv div) {
        getHandler(div).onClick_dataSettei(表示モード_追加);
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択アイコン」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoToiawasesakiDiv>
     */
    public ResponseData<KaigoToiawasesakiDiv> onClick_dgToiawasesakiControl(KaigoToiawasesakiDiv div) {
        getHandler(div).onClick_dataSettei(表示モード_表示);
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoToiawasesakiDiv>
     */
    public ResponseData<KaigoToiawasesakiDiv> onClick_dgToiawasesakiControl_modify(KaigoToiawasesakiDiv div) {
        getHandler(div).onClick_dataSettei(表示モード_修正);
        return ResponseData.of(div).respond();
    }

    /**
     * 「削除」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoToiawasesakiDiv>
     */
    public ResponseData<KaigoToiawasesakiDiv> onClick_dgToiawasesakiControl_delete(KaigoToiawasesakiDiv div) {
        getHandler(div).onbtn_Delete();
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力確定」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoToiawasesakiDiv>
     */
    public ResponseData<KaigoToiawasesakiDiv> onClick_btnDecide(KaigoToiawasesakiDiv div) {
        getHandler(div).onbtn_OK();
        return ResponseData.of(div).respond();
    }

    /**
     * 「入力取消」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoToiawasesakiDiv>
     */
    public ResponseData<KaigoToiawasesakiDiv> onClick_btnCancel(KaigoToiawasesakiDiv div) {
        getHandler(div).onbtn_Cancel();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoToiawasesakiDiv>
     */
    public ResponseData<KaigoToiawasesakiDiv> onClick_btnSave(KaigoToiawasesakiDiv div) {
        RString 問合せ先管理単位 = DbBusinessConfig.get(ConfigNameDBU.問合せ先_管理単位, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        KaigoToiawasesakiIdentifier oneKey = null;
        if (介護共通.equals(問合せ先管理単位)) {
            oneKey = new KaigoToiawasesakiIdentifier(SubGyomuCode.DBZ介護共通, CHOHYOBUNRUIID);
        } else if (サブ業務単位.equals(問合せ先管理単位)) {
            oneKey = new KaigoToiawasesakiIdentifier(new SubGyomuCode(div.getHdnSubGyomuCode()),
                    CHOHYOBUNRUIID);
        }
        if (ViewStateHolder.get(ViewStateKeys.介護問合せ先情報, Models.class).get(oneKey) != null) {
            KaigoToiawasesakiFinder.createInstance().insertOrUpdate(
                    getHandler(div).updateOneRow(ViewStateHolder.get(ViewStateKeys.介護問合せ先情報, Models.class), oneKey).build());
        }
        KaigoToiawasesakiIdentifier twoKey = new KaigoToiawasesakiIdentifier(new SubGyomuCode(div.getHdnSubGyomuCode()),
                new ReportId(div.getHdnChohyoBunruiID()));
        if (帳票独自あり.equals(div.getHdnChohyoDokujiToiawasesakiUmu())) {
            KaigoToiawasesakiFinder.createInstance().insertOrUpdate(
                    getHandler(div).updateOrInsertTwoRow(
                            ViewStateHolder.get(ViewStateKeys.介護問合せ先情報, Models.class), twoKey).build());
        } else if (帳票独自無し.equals(div.getHdnChohyoDokujiToiawasesakiUmu())) {
            KaigoToiawasesakiFinder.createInstance().delete(ViewStateHolder.get(ViewStateKeys.介護問合せ先情報, Models.class), twoKey);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「閉じる」を押します。
     *
     * @param div 画面情報
     * @return ResponseData<KaigoToiawasesakiDiv>
     */
    public ResponseData<KaigoToiawasesakiDiv> onClick_btnClose(KaigoToiawasesakiDiv div) {
        return ResponseData.of(div).respond();
    }

    private KaigoToiawasesakiHandler getHandler(KaigoToiawasesakiDiv div) {
        return new KaigoToiawasesakiHandler(div);
    }
}
