/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010000;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.DBC0010000StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000.KyufuJissekiShokaiHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000.KyufuJissekiShokaiValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_給付実績照会検索一覧画面
 *
 * @reamsid_L DBC-2970-010 linghuhang
 */
public class KyufuJissekiShokai {

    private static final int INT_ZERO = 0;
    private static final int INT_ROKU = 6;
    private static final int INT_NJYUNG = 75;
    private static final RString サービス提供月_開始 = new RString("04");
    private static final RString サービス提供月_終了 = new RString("03");

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onLoad(KyufuJissekiShokaiDiv div) {
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            div.getCcdKaigoShikakuKihon().setVisible(true);
            return ResponseData.of(div).addMessage(new InformationMessage(
                    DbcInformationMessages.被保険者でないデータ.getMessage().getCode(),
                    DbcInformationMessages.被保険者でないデータ.getMessage().evaluate())).respond();
        }
        setアクセスログ(識別コード, 被保険者番号);
        getHandler(div).onLoad(被保険者番号, 識別コード);
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
    }

    /**
     * 「条件をクリアする」ボタン押下する、検索条件パネル内の状態を初期状態にする。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnKyufuJissekiSearchClear(KyufuJissekiShokaiDiv div) {
        getHandler(div).onClick_btnKyufuJissekiSearchClear();
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
    }

    /**
     * 抽出範囲を変更する場合、画面を表示する。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onChange_radKyufuJissekiSearchDateType(KyufuJissekiShokaiDiv div) {
        getHandler(div).onChange_radKyufuJissekiSearchDateType();
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
    }

    /**
     * 「検索する」ボタン押下する、画面一覧を表示する。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnKyufuJissekiSearch(KyufuJissekiShokaiDiv div) {
        ValidationMessageControlPairs validation = getValidationHandler(div).doチェック();
        if (validation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validation).respond();
        }
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        FlexibleYearMonth サービス提供年月_開始 = FlexibleYearMonth.EMPTY;
        FlexibleYearMonth サービス提供年月_終了 = FlexibleYearMonth.EMPTY;
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        if (!RString.isNullOrEmpty(div.getRadNendo().getSelectedKey())) {
            RString 年度 = div.getDdlKyufuJissekiSearchNendo().getSelectedKey();
            if (!RString.isNullOrEmpty(年度)) {
                サービス提供年月_開始 = new FlexibleYearMonth(年度.concat(サービス提供月_開始));
                サービス提供年月_終了 = new FlexibleYearMonth(
                        new RString(Integer.parseInt(年度.toString()) + 1).concat(サービス提供月_終了));
            }
        } else {
            if (div.getTxtKyufuJissekiSearchServiceTeikyoYM().getFromValue() != null) {
                サービス提供年月_開始 = new FlexibleYearMonth(div.getTxtKyufuJissekiSearchServiceTeikyoYM().
                        getFromValue().toDateString().substring(INT_ZERO, INT_ROKU));
            }
            if (div.getTxtKyufuJissekiSearchServiceTeikyoYM().getToValue() != null) {
                サービス提供年月_終了 = new FlexibleYearMonth(div.getTxtKyufuJissekiSearchServiceTeikyoYM().
                        getToValue().toDateString().substring(INT_ZERO, INT_ROKU));
            }
        }
        List<KyufuJissekiHedajyoho1> 給付実績ヘッダ情報1 = KyufuJissekiShokaiFinder.createInstance().
                getKyufuJissekiHeaderJoho1(被保険者番号).records();
        KyufuJissekiPrmBusiness 給付実績情報照会情報 = KyufuJissekiShokaiFinder.createInstance().
                get検索データ取得(被保険者番号, サービス提供年月_開始, サービス提供年月_終了);
//        List<KyufujissekiKihon> 給付基本情報 = 給付実績情報照会情報.getJukyushaData();
        getHandler(div).onClick_btnKyufuJissekiSearch(給付実績ヘッダ情報1.get(INT_ZERO),
                サービス提供年月_開始, サービス提供年月_終了);
        ViewStateHolder.put(ViewStateKeys.給付実績情報照会情報, 給付実績情報照会情報);
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会一覧);
    }

    /**
     * 「再検索する」ボタンを押下する、画面を表示する。
     *
     * @param div 給付実績照会検索一覧のDIV
     * @return 給付実績照会検索一覧
     */
    public ResponseData<KyufuJissekiShokaiDiv> onClick_btnKyufuJissekiResearch(KyufuJissekiShokaiDiv div) {
        for (int i = INT_ZERO; i < INT_NJYUNG; i++) {
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(false);
            div.getDgKyufuJissekiGokeiList().getGridSetting().getColumns().get(i).setVisible(false);
        }
        return ResponseData.of(div).setState(DBC0010000StateName.給付実績照会検索);
    }

    private KyufuJissekiShokaiHandler getHandler(KyufuJissekiShokaiDiv div) {
        return new KyufuJissekiShokaiHandler(div);
    }

    private KyufuJissekiShokaiValidationHandler getValidationHandler(KyufuJissekiShokaiDiv div) {
        return new KyufuJissekiShokaiValidationHandler(div);
    }

    private void setアクセスログ(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        PersonalData personalData = PersonalData.of(識別コード,
                new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value()));
        AccessLogger.log(AccessLogType.照会, personalData);
    }
}
