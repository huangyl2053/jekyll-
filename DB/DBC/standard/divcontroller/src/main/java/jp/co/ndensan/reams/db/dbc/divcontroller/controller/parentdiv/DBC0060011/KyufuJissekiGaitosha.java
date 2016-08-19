/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0060011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060011.KyufuJissekiGaitoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060011.KyufuJissekiGaitoshaHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060011.KyufuJissekiGaitoshaValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.kyufukanrihyoshokai.KyufuKanrihyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付管理票照会のControllerです。
 *
 * @reamsid_L DBC-2960-010 chenxiangyu
 */
public class KyufuJissekiGaitosha {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 給付管理票照会のDIVです。
     * @return 給付管理票照会
     */
    public ResponseData<KyufuJissekiGaitoshaDiv> onLoad(KyufuJissekiGaitoshaDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンを押すの場合。
     *
     * @param div 給付管理票照会のDIVです。
     * @return 給付管理票照会
     */
    public ResponseData<KyufuJissekiGaitoshaDiv> onClick_btnSearch(KyufuJissekiGaitoshaDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validateFor必須項目();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        List<KyufuKanrihyoShokaiBusiness> 給付管理票一覧 = KyufuKanrihyoShokai.createInstance().selectKyufuKanrihyoList(
                div.getSearchToKyufujissekiPanel().getTxtHihoNo().getValue(),
                div.getSearchToKyufujissekiPanel().getTxtJigyoshaNo().getValue(),
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getFromValue().toDateString(),
                div.getSearchToKyufujissekiPanel().getTxtTeikyoYMRange().getToValue().toDateString());
        getHandler(div).onClick_btnSearch(給付管理票一覧);
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」ボタンを押すの場合。
     *
     * @param div 給付管理票照会のDIVです。
     * @return 給付管理票照会
     */
    public ResponseData<KyufuJissekiGaitoshaDiv> onSelectBySelectButton(KyufuJissekiGaitoshaDiv div) {
        KyufuKanrihyoShokaiDataModel 給付管理票 = getHandler(div).getKyufuKanrihyo200604();
        ArrayList<KyufuKanrihyoShokaiBusiness> 給付管理明細一覧 = (ArrayList) KyufuKanrihyoShokai.createInstance().
                selectKyufuKanriMeisaiList(
                        給付管理票.get審査年月().toDateString(),
                        給付管理票.getサービス提供年月().toDateString(),
                        給付管理票.get被保険者番号().value());
        ArrayList<KyufuKanrihyoShokaiDataModel> 給付管理明細一覧Model = new ArrayList<>();
        Boolean 居宅サービスフラグ = false;
        Boolean 訪問通所サービスフラグ = false;
        Boolean 短期入所サービスフラグ = false;
        for (KyufuKanrihyoShokaiBusiness 給付管理明細 : 給付管理明細一覧) {
            給付管理明細一覧Model.add(KyufuKanrihyoShokaiDataModel.createDataModel(給付管理明細));
            if (!居宅サービスフラグ && KyotakuServiceKubun.居宅サービス.get名称().equals(
                    給付管理明細.get給付管理票種別区分コード())) {
                居宅サービスフラグ = true;
            } else if (!訪問通所サービスフラグ && KyotakuServiceKubun.訪問通所.get名称().equals(
                    給付管理明細.get給付管理票種別区分コード())) {
                訪問通所サービスフラグ = true;
            } else if (!短期入所サービスフラグ && KyotakuServiceKubun.短期入所.get名称().equals(
                    給付管理明細.get給付管理票種別区分コード())) {
                短期入所サービスフラグ = true;
            }
        }
        ViewStateHolder.put(ViewStateKeys.給付管理明細一覧, 給付管理明細一覧Model);
        ViewStateHolder.put(ViewStateKeys.給付管理票200604Entity, 給付管理票);
        ViewStateHolder.put(ViewStateKeys.訪問通所サービスフラグ, 訪問通所サービスフラグ);
        ViewStateHolder.put(ViewStateKeys.短期入所サービスフラグ, 短期入所サービスフラグ);
        ViewStateHolder.put(ViewStateKeys.居宅サービスフラグ, 居宅サービスフラグ);
        // TODO QA#96146 UIコンテナは「DBCUC00600」が存在しない、画面を遷移できません。
//        FlexibleYearMonth 支給限度額一本化年月 = new FlexibleYearMonth(div.getHdn支給限度額一本化年月());
//        FlexibleYearMonth サービス提供年月 = 給付管理票.getサービス提供年月();
//        if (支給限度額一本化年月.isBeforeOrEquals(サービス提供年月)) {
//            return ResponseData.of(div).forwardWithEventName(居宅).respond();
//        } else {
//            return ResponseData.of(div).forwardWithEventName(訪問通所).respond();
//        }
        return ResponseData.of(div).respond();
    }

    private KyufuJissekiGaitoshaHandler getHandler(KyufuJissekiGaitoshaDiv div) {
        return new KyufuJissekiGaitoshaHandler(div);
    }

    private KyufuJissekiGaitoshaValidationHandler getValidationHandler(KyufuJissekiGaitoshaDiv div) {
        return new KyufuJissekiGaitoshaValidationHandler(div);
    }
}
