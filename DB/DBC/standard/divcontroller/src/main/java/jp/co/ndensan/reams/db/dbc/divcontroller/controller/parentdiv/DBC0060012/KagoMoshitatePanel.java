/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0060012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060012.KagoMoshitatePanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060012.KagoMoshitatePanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060012.KagoMoshitatePanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 居宅サービスの給付管理照会のControllerです。
 *
 * @reamsid_L DBC-2960-030 chenxiangyu
 */
public class KagoMoshitatePanel {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 居宅サービスの給付管理照会のDIVです。
     * @return 居宅サービスの給付管理照会
     */
    public ResponseData<KagoMoshitatePanelDiv> onLoad(KagoMoshitatePanelDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = key.get識別コード();
        div.getCommonKaigpAtenainfoChildDiv1().initialize(識別コード);

        KyufuKanrihyoShokaiDataModel 給付管理票 = ViewStateHolder.get(
                ViewStateKeys.給付管理票200604Entity, KyufuKanrihyoShokaiDataModel.class);
        ValidationMessageControlPairs pairs = getValidationHandler().validateFor被保険者番号(給付管理票);
        if (pairs.iterator().hasNext()) {
            div.getCommonKaigoshikakuKihonChildDiv2().setVisible(false);
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        } else {
            div.getCommonKaigoshikakuKihonChildDiv2().initialize(給付管理票.get被保険者番号());
        }

        List<KyufuKanrihyoShokaiDataModel> 給付管理表示用明細一覧
                = ViewStateHolder.get(ViewStateKeys.給付管理明細一覧, ArrayList.class);
        Boolean 居宅サービスフラグ = ViewStateHolder.get(ViewStateKeys.居宅サービスフラグ, Boolean.class);
        if (居宅サービスフラグ) {
            getHandler(div).set給付管理明細一覧(給付管理表示用明細一覧);
        }
        アクセスログ(給付管理票.get被保険者番号());
        getHandler(div).onLoad(給付管理票);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンを押すの場合。
     *
     * @param div 居宅サービスの給付管理照会のDIVです
     * @return 居宅サービスの給付管理照会
     */
    public ResponseData<KagoMoshitatePanelDiv> onClick_btnSave(KagoMoshitatePanelDiv div) {
        // TODO QA#96146 UIコンテナは「DBCUC00600」が存在しない、画面を遷移できません。
        return ResponseData.of(div).respond();
    }

    private void アクセスログ(HihokenshaNo 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号));
    }

    private PersonalData toPersonalData(HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private KagoMoshitatePanelHandler getHandler(KagoMoshitatePanelDiv div) {
        return new KagoMoshitatePanelHandler(div);
    }

    private KagoMoshitatePanelValidationHandler getValidationHandler() {
        return new KagoMoshitatePanelValidationHandler();
    }
}
