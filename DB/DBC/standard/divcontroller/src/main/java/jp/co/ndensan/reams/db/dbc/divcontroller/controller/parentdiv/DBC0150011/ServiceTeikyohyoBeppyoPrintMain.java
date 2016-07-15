/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0150011;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBC0150011_サービス提供票別表のクラスです。
 *
 * @reamsid_L DBC-5110-010 xupeng
 */
public class ServiceTeikyohyoBeppyoPrintMain {

    private static final RString KEY_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY_対象年月 = new RString("対象年月");
    private static final RString KEY_履歴番号 = new RString("履歴番号");
    private static final RString KEY_作成年月日 = new RString("作成年月日");
    private static final RString KEY_自己作成計画年月 = new RString("自己作成計画年月");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     * @return ResponseData
     */
    public ResponseData<ServiceTeikyohyoBeppyoPrintMainDiv> onLoad(ServiceTeikyohyoBeppyoPrintMainDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class);
        // ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000010");
        // HihokenshaNo 被保険者番号 = new HihokenshaNo("0000000001");
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        getHandler(div).initialize(被保険者番号);

        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタンのメソッドます。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(ServiceTeikyohyoBeppyoPrintMainDiv div) {
        RDate 作成年月日 = div.getPrintShiji().getTxtSakuseiYmd().getValue();
        RYearMonth 自己作成計画年月 = div.getPrintShiji().getTxtJikoSakuseiKeikakuYm().getValue().getYearMonth();
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        //HihokenshaNo 被保険者番号 = new HihokenshaNo("0000000001");
        //FlexibleYearMonth 対象年月 = new FlexibleYearMonth("201607");
        //int 履歴番号 = 10;
        FlexibleYearMonth 対象年月 = ViewStateHolder.get(ViewStateKeys.対象年月, FlexibleYearMonth.class);
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, int.class);
        Map<RString, Object> map = new HashMap<>();
        map.put(KEY_被保険者番号, 被保険者番号);
        map.put(KEY_対象年月, 対象年月);
        map.put(KEY_履歴番号, 履歴番号);
        map.put(KEY_作成年月日, 作成年月日);
        map.put(KEY_自己作成計画年月, 自己作成計画年月);
        SourceDataCollection dataCollection = getHandler(div).to帳票発行処理(map);
        return ResponseData.of(dataCollection).respond();
    }

    private ServiceTeikyohyoBeppyoPrintMainHandler getHandler(ServiceTeikyohyoBeppyoPrintMainDiv div) {
        return ServiceTeikyohyoBeppyoPrintMainHandler.of(div);
    }
}
