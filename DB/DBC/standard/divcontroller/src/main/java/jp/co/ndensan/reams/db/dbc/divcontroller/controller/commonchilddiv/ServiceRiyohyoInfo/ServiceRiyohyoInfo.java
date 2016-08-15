/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ServiceRiyohyoInfo;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.ServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo.ServiceRiyohyoInfoDivHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * サービス利用票情報のコントローラです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoInfo {

    private ServiceRiyohyoInfoDivHandler getHandler(ServiceRiyohyoInfoDiv div) {
        return new ServiceRiyohyoInfoDivHandler(div);
    }

    /**
     * 「種類限度額確認」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnShowShuruiGendogaku(ServiceRiyohyoInfoDiv div) {
//        FlexibleYearMonth 利用年月 = ViewStateHolder.get(ViewStateKeys.利用年月, FlexibleYearMonth.class);
//
//        getHandler(div).get明細合計一覧Grid();
        return ResponseData.of(div).respond();
    }

    /**
     * 「前月の情報をコピーする」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnZengetsuCopy(ServiceRiyohyoInfoDiv div) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth 対象年月 = ViewStateHolder.get(ViewStateKeys.対象年月, FlexibleYearMonth.class);
        int 履歴番号 = ViewStateHolder.get(ViewStateKeys.履歴番号, Integer.class);
        FlexibleYearMonth 利用年月 = ViewStateHolder.get(ViewStateKeys.利用年月, FlexibleYearMonth.class);
        getHandler(div).setサービス利用票(被保険者番号, 対象年月, 履歴番号, 利用年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 前月までの利用日数onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtZengetsuRiyoNissu(ServiceRiyohyoInfoDiv div) {
        getHandler(div).set累積利用日数();
        return ResponseData.of(div).respond();
    }

    /**
     * 当月の計画利用日数onBlurのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onBlur_txtTogetsuRiyoNissu(ServiceRiyohyoInfoDiv div) {
        getHandler(div).set累積利用日数();
        return ResponseData.of(div).respond();
    }

    /**
     * 「明細情報を追加する」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnBeppyoMeisaiNew(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoMeisai().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「合計情報を追加する」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnBeppyoGokeiNew(ServiceRiyohyoInfoDiv div) {
        div.getServiceRiyohyoBeppyoGokei().setDisabled(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 明細・合計情報一覧の「選択」ボタンのイベントです。
     *
     * @param div ServiceRiyohyoInfoDiv
     * @return ResponseData<ServiceRiyohyoInfoDiv>
     */
    public ResponseData<ServiceRiyohyoInfoDiv> onClick_btnSelect(ServiceRiyohyoInfoDiv div) {
        getHandler(div).setパネルにデータ反映();
        return ResponseData.of(div).respond();
    }
}
