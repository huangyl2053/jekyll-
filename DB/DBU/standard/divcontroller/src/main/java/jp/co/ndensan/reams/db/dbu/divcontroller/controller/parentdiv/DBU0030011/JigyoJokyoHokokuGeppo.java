/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0030011;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.yoshikibetsurenkeijoho.JigyoHokokuTokei;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.yoshikibetsurenkeijoho.ShukeiYearMouthGetterParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0030011.JigyoJokyoHokokuGeppoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0030011.JigyoJokyoHokokuGeppoHandler;
import jp.co.ndensan.reams.db.dbu.service.core.yoshikibetsurenkeijoho.ShukeiYearMouthGetterFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.koseishichosonselector.KoseiShiChosonSelectorModel;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 様式別連携情報作成の処理です。
 *
 * @reamsid_L DBU-4050-010 suguangjun
 */
public class JigyoJokyoHokokuGeppo {

    /**
     * 様式別連携情報作成の初期化処理です。
     *
     * @param div 様式別連携情報Div
     * @return ResponseData<JigyoJokyoHokokuGeppoDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoDiv> onLoad(JigyoJokyoHokokuGeppoDiv div) {
        List<JigyoHokokuTokei> kuTokeiList = ShukeiYearMouthGetterFinder.createInstance().get過去報告年月().records();
        getHandler(div).onLoad(kuTokeiList);
        getHandler(div).setRadKoikiKoseiShichoson();
        return ResponseData.of(div).respond();
    }

    /**
     * 過去報告年月DDLの処理です。
     *
     * @param div 様式別連携情報Div
     * @return ResponseData<JigyoJokyoHokokuGeppoDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoDiv> onChange_ddlKakoHokokuYM(JigyoJokyoHokokuGeppoDiv div) {
        getHandler(div).clearTxtShukeiYM();
        if (!RString.isNullOrEmpty(div.getJikkoTanni().getDdlKakoHokokuYM().getSelectedKey())) {
            FlexibleYearMonth yearMonth = new FlexibleYearMonth(div.getJikkoTanni().getDdlKakoHokokuYM().getSelectedKey());
            ShukeiYearMouthGetterFinder getterFinder = ShukeiYearMouthGetterFinder.createInstance();
            ShukeiYearMouthGetterParameter parameter = ShukeiYearMouthGetterParameter.createParam_common(yearMonth, FlexibleYear.EMPTY, RString.EMPTY);
            List<JigyoHokokuTokei> 集計年月_一般状況1から10 = getterFinder.get集計年月_一般状況1から10(parameter).records();
            List<JigyoHokokuTokei> 集計年月_11から14現物分 = getterFinder.get集計年月_一般状況11から14現物分(parameter).records();
            List<JigyoHokokuTokei> 審査年月_11から14償還分 = getterFinder.get審査年月_一般状況11から14償還分(parameter).records();
            List<JigyoHokokuTokei> 決定年月_11から14現物分 = getterFinder.get決定年月_一般状況11から14償還分(parameter).records();
            List<JigyoHokokuTokei> 集計年月_決定状況現物分 = getterFinder.get集計年月_決定状況現物分(parameter).records();
            List<JigyoHokokuTokei> 審査年月_決定状況償還分 = getterFinder.get審査年月_決定状況償還分(parameter).records();
            List<JigyoHokokuTokei> 決定年月_決定状況償還分 = getterFinder.get決定年月_決定状況償還分(parameter).records();
            getHandler(div).getShukeiYM(集計年月_一般状況1から10, 集計年月_11から14現物分, 審査年月_11から14償還分,
                    決定年月_11から14現物分, 集計年月_決定状況現物分, 審査年月_決定状況償還分, 決定年月_決定状況償還分);
            getHandler(div).getShutsuryokuAll();
            getHandler(div).setShutsuryoku();
            getHandler(div).setDisDisabledTrueToShutsuryokuAll();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * すべて選択チェックボックスの処理です。
     *
     * @param div 様式別連携情報Div
     * @return ResponseData<JigyoJokyoHokokuGeppoDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoDiv> onChange_cblShutsuryokuAll(JigyoJokyoHokokuGeppoDiv div) {
        getHandler(div).getCblShutsuryokuAll();
        return ResponseData.of(div).respond();
    }

    /**
     * 合併市町村用保険者選択ラジオボタンの処理です。
     *
     * @param div 様式別連携情報Div
     * @return ResponseData<JigyoJokyoHokokuGeppoDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoDiv> onChange_radHokenshaKyuShichoson(JigyoJokyoHokokuGeppoDiv div) {
        getHandler(div).setRadHokenshaKyuShichoson();
        return ResponseData.of(div).respond();
    }

    /**
     * 広域構成市町村用保険者選択ラジオボタンの処理です。
     *
     * @param div 様式別連携情報Div
     * @return ResponseData<JigyoJokyoHokokuGeppoDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoDiv> onChange_radKoikiKoseiShichoson(JigyoJokyoHokokuGeppoDiv div) {
        getHandler(div).setRadKoikiKoseiShichoson();
        return ResponseData.of(div).respond();
    }

    /**
     * 一般状況１１・１２～１４【償還分】集計年月選択ラジオボタンの処理です。
     *
     * @param div 様式別連携情報Div
     * @return ResponseData<JigyoJokyoHokokuGeppoDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoDiv> onChange_radShukeiType3(JigyoJokyoHokokuGeppoDiv div) {
        getHandler(div).setShukeiType3();
        return ResponseData.of(div).respond();
    }

    /**
     * 保険給付決定状況【償還分】集計年月選択ラジオボタンの処理です。
     *
     * @param div 様式別連携情報Div
     * @return ResponseData<JigyoJokyoHokokuGeppoDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoDiv> onChange_radShukeiType5(JigyoJokyoHokokuGeppoDiv div) {
        getHandler(div).setShukeiType5();
        return ResponseData.of(div).respond();
    }

    /**
     * 「市町村を選択する」ダイアログボタンの処理です。
     *
     * @param div 様式別連携情報Div
     * @return ResponseData<JigyoJokyoHokokuGeppoDiv>
     */
    public ResponseData<JigyoJokyoHokokuGeppoDiv> onClick_btnShichosonSentaku(JigyoJokyoHokokuGeppoDiv div) {
        KoseiShiChosonSelectorModel model = ViewStateHolder.get(ViewStateKeys.引き継ぎデータ, KoseiShiChosonSelectorModel.class);
        if (model != null) {
            div.setShichosonCode(model.get市町村コード());
        }
        return ResponseData.of(div).respond();
    }

    private JigyoJokyoHokokuGeppoHandler getHandler(JigyoJokyoHokokuGeppoDiv div) {
        return new JigyoJokyoHokokuGeppoHandler(div);
    }
}
