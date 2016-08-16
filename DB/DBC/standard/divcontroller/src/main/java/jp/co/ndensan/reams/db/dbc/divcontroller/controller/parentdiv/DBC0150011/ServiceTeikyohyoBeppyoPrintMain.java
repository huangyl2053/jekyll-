/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0150011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0150011.ServiceTeikyohyoBeppyoPrintMainHandler;
import jp.co.ndensan.reams.db.dbc.service.core.teikyohyobeppyo.TeikyohyoBeppyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBC0150011_サービス提供票別表のクラスです。
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
public class ServiceTeikyohyoBeppyoPrintMain {

    private static final RString 引数_被保険者番号なし = new RString("被保険者番号なし");

    private ServiceTeikyohyoBeppyoPrintMainHandler getHandler(ServiceTeikyohyoBeppyoPrintMainDiv div) {
        return ServiceTeikyohyoBeppyoPrintMainHandler.of(div);
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param div ServiceTeikyohyoBeppyoPrintMainDiv
     * @return ResponseData
     */
    public ResponseData<ServiceTeikyohyoBeppyoPrintMainDiv> onLoad(ServiceTeikyohyoBeppyoPrintMainDiv div) {

        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = key.get被保険者番号();
        ShikibetsuCode 識別コード = key.get識別コード();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        if (被保険者番号.isEmpty() || RString.isNullOrEmpty(被保険者番号.value())) {
            throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().
                    replace(引数_被保険者番号なし.toString()));
        } else {
            ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
            div.getCccKaigoShiKakuKihon().initialize(被保険者番号);
            div.getTxtSakuseiYmd().setValue(RDate.getNowDate());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタン押下時のイベントです。
     *
     * @param div KyodoIdoRenrakuhyoTorokuMainDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(ServiceTeikyohyoBeppyoPrintMainDiv div) {

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        TeikyohyoBeppyoManager manager = TeikyohyoBeppyoManager.createInstance();
        return ResponseData.of(getHandler(div).to帳票発行処理(被保険者番号, manager)).respond();
    }

}
