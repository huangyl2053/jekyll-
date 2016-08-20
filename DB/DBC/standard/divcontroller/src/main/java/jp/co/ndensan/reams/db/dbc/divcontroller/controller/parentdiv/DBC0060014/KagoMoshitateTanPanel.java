/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0060014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060014.DBC0060014TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060014.KagoMoshitateTanPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060014.KagoMoshitateTanPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060014.KagoMoshitateTanPanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import static jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys.資格対象者;
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
 * 画面設計_DBC0060014_短期入所サービスの給付管理照会のControllerです。
 *
 * @reamsid_L DBC-2960-050 lizhuoxuan
 */
public class KagoMoshitateTanPanel {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KagoMoshitateTanPanelDiv
     * @return 画面設計_DBC0060014_短期入所サービスの給付管理照会
     */
    public ResponseData<KagoMoshitateTanPanelDiv> onLoad(KagoMoshitateTanPanelDiv div) {

        TaishoshaKey key = ViewStateHolder.get(資格対象者, TaishoshaKey.class);
        ShikibetsuCode shikibetsuCode = key.get識別コード();
        div.getCommonKaigpAtenainfoChildDiv1().initialize(shikibetsuCode);
        KyufuKanrihyoShokaiDataModel 対象者一覧
                = ViewStateHolder.get(ViewStateKeys.給付管理票200604Entity, KyufuKanrihyoShokaiDataModel.class);
        if (対象者一覧.get被保険者番号() == null || 対象者一覧.get被保険者番号().isEmpty()) {
            onClick_Check();
            div.getCommonKaigoshikakuKihonChildDiv2().setVisible(false);
        } else {
            div.getCommonKaigoshikakuKihonChildDiv2().initialize(対象者一覧.get被保険者番号());
        }
        List<KyufuKanrihyoShokaiDataModel> 対象者一覧list
                = ViewStateHolder.get(ViewStateKeys.給付管理明細一覧, ArrayList.class);
        Boolean tanflg = ViewStateHolder.get(ViewStateKeys.訪問通所サービスフラグ, Boolean.class);
        if (tanflg) {
            onClick_BtnTanki(div);
        }
        アクセスログ(対象者一覧.get被保険者番号());
        getHandler(div).initialize(対象者一覧, 対象者一覧list, tanflg);
        return createResponse(div);
    }

    /**
     * チェックです。
     *
     * @param div 画面情報
     * @return ResponseData<KagoMoshitateTanPanelDiv>
     */
    private ValidationMessageControlPairs onClick_Check() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        getValidationHandler().被保険者番号チェック(validationMessages);
        return validationMessages;
    }

    /**
     * 「短期入所サービス」ボタンをクリック。
     *
     * @param div KagoMoshitateTanPanelDiv
     * @return ResponseData<KagoMoshitateTanPanelDiv>
     */
    public ResponseData<KagoMoshitateTanPanelDiv> onClick_BtnTanki(KagoMoshitateTanPanelDiv div) {
        ViewStateHolder.get(ViewStateKeys.給付管理明細一覧, ArrayList.class);
        ViewStateHolder.get(ViewStateKeys.給付管理票200604Entity, KyufuKanrihyoShokaiDataModel.class);
        ViewStateHolder.get(ViewStateKeys.訪問通所サービスフラグ, Boolean.class);
        ViewStateHolder.get(ViewStateKeys.短期入所サービスフラグ, Boolean.class);
        return ResponseData.of(div).forwardWithEventName(DBC0060014TransitionEventName.訪問通所サービスへ).respond();
    }

    /**
     * 「検索結果一覧へ」ボタンをクリック。
     *
     * @param div KagoMoshitateTanPanelDiv
     * @return ResponseData<KagoMoshitateTanPanelDiv>
     */
    public ResponseData<KagoMoshitateTanPanelDiv> onClick_btnSave(KagoMoshitateTanPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBC0060014TransitionEventName.検索結果一覧へ).respond();
    }

    /**
     * アクセスログを出力します。
     *
     * @param 識別コード 識別コード
     */
    private void アクセスログ(HihokenshaNo 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(被保険者番号));
    }

    private PersonalData toPersonalData(HihokenshaNo 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private KagoMoshitateTanPanelHandler getHandler(KagoMoshitateTanPanelDiv div) {
        return new KagoMoshitateTanPanelHandler(div);
    }

    private ResponseData<KagoMoshitateTanPanelDiv> createResponse(KagoMoshitateTanPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    private KagoMoshitateTanPanelValidationHandler getValidationHandler() {
        return new KagoMoshitateTanPanelValidationHandler();
    }
}
