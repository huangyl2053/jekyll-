/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1130011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.idochecklist.IdoCheckListResult;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1130011.IdochekkurisutoDiv;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 異動チェックリストの抽象Handlerクラスです。
 */
public class IdochekkurisutoHandler {

    private static final RString REPORT_ID_DBA200006 = new RString("DBA200006");

    private static final RString CHECKED_KEY_KEY0 = new RString("key0");
    private static final RString CHECKED_KEY_KEY1 = new RString("key1");
    private static final RString CHECKED_KEY_KEY2 = new RString("key2");
    private static final RString CHECKED_KEY_KEY3 = new RString("key3");
    private static final RString CHECKED_KEY_KEY4 = new RString("key4");

    private final IdochekkurisutoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IdochekkurisutoDiv
     */
    public IdochekkurisutoHandler(IdochekkurisutoDiv div) {
        this.div = div;
    }

    /**
     *
     * 異動チェックリスト初期化の設定します。
     *
     * @param result IdoCheckListResult
     */
    public void setLoad(SearchResult<IdoCheckListResult> result) {
        IdoCheckListResult idoCheckResult = result.records().get(0);
        FlexibleDate nowDate = FlexibleDate.getNowDate();
        if (result.records().isEmpty() || (idoCheckResult.get対象終了年月日() == null
                && idoCheckResult.get対象終了年月日() == null)) {
            div.getTxtkonkaikaishi().setValue(nowDate);
            div.getTxtkonkaishuryo().setValue(nowDate);
        } else if (nowDate.isBeforeOrEquals(idoCheckResult.get対象終了年月日())) {
            div.getTxtzenkaikaishi().setValue(idoCheckResult.get対象開始年月日());
            div.getTxtzenkaishuryo().setValue(idoCheckResult.get対象終了年月日());
            div.getTxtkonkaikaishi().setValue(div.getTxtzenkaishuryo().getValue());
            div.getTxtkonkaishuryo().setValue(div.getTxtzenkaishuryo().getValue());
        } else if (idoCheckResult.get対象終了年月日().isBefore(nowDate)) {
            div.getTxtzenkaikaishi().setValue(idoCheckResult.get対象開始年月日());
            div.getTxtzenkaishuryo().setValue(idoCheckResult.get対象終了年月日());
            div.getTxtkonkaikaishi().setValue(div.getTxtzenkaishuryo().getValue());
            div.getTxtkonkaishuryo().setValue(nowDate);
        }
        List<RString> items = new ArrayList<>();
        items.add(CHECKED_KEY_KEY0);
        items.add(CHECKED_KEY_KEY1);
        items.add(CHECKED_KEY_KEY2);
        items.add(CHECKED_KEY_KEY3);
        items.add(CHECKED_KEY_KEY4);
        div.getChktaishodaicho().setSelectedItemsByKey(items);
        div.getTxtzenkaikaishi().setDisabled(true);
        div.getTxtzenkaishuryo().setDisabled(true);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBA介護資格, new ReportId(REPORT_ID_DBA200006));
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("BatchRegister"), false);
    }

}
