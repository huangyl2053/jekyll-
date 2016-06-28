package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShiharaiHohoJyoho;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KozaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.ShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.ShiharaiHohoJyohoHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shiharaihohojyoho.ShiharaiHohoJyohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 支払方法情報のコントローラです。
 *
 * @reamsid_L DBC-0300-010 houtianpeng
 */
public class ShiharaiHohoJyoho {

    private final RString 窓口払い = new RString("1");
    private final RString 口座払い = new RString("2");
    private final RString 受領委任払い = new RString("3");

    /**
     * ｢1:窓口払い｣を選択します。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData onClick_radMadoguti(ShiharaiHohoJyohoDiv div) {
        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();

        div.getRadMadoguti().setSelectedKey(窓口払い);
        ShiharaiHohoJyohoHandler handler = getHandler(div);
        handler.入力可_窓口払い();
        handler.入力不可_口座払い();
        handler.入力不可_受領委任払い();
        response.data = div;
        return response;
    }

    /**
     * ｢2:口座払い｣を選択します。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData onClick_radKoza(ShiharaiHohoJyohoDiv div) {
        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();

        div.getRadKoza().setSelectedKey(口座払い);
        div.getDdlKozaID().setDisabled(false);
        div.getBtnKozaToroku().setDisabled(false);
        ShiharaiHohoJyohoHandler handler = getHandler(div);
        handler.入力不可_窓口払い();
        handler.入力不可_受領委任払い();
        response.data = div;
        return response;
    }

    /**
     * ｢3:受領委任払い｣を選択します。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData onClick_radJyryoinin(ShiharaiHohoJyohoDiv div) {
        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();

        div.getRadJyryoinin().setSelectedKey(受領委任払い);
        div.getTxtKeiyakuNo().setReadOnly(false);
        div.getBtnSelect().setDisabled(false);
        ShiharaiHohoJyohoHandler handler = getHandler(div);
        handler.入力不可_窓口払い();
        handler.入力不可_口座払い();
        response.data = div;
        return response;
    }

    /**
     * 「開始日」テキストボックスがonBlur場合、開始日曜日を設定します。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData onBlur_txtStartYMD(ShiharaiHohoJyohoDiv div) {
        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();

        if (div.getTxtStartYMD().getValue() == null) {
            div.getTxtStartYobi().setValue(RString.EMPTY);
        } else {
            RString 曜日 = new RString(div.getTxtStartYMD().getValue().getDayOfWeek().getMiddleTerm());
            getHandler(div).開始日_曜日の表示色(曜日);
            div.getTxtStartYobi().setValue(曜日);
        }
        response.data = div;
        return response;
    }

    /**
     * 「終了日」テキストボックスがonBlur場合、終了日曜日を設定します。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData onBlur_txtEndYMD(ShiharaiHohoJyohoDiv div) {
        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();

        if (div.getTxtEndYMD().getValue() != null) {
            RString 曜日 = new RString(div.getTxtEndYMD().getValue().getDayOfWeek().getMiddleTerm());
            getHandler(div).終了日_曜日の表示色(曜日);
            div.getTxtEndYobi().setValue(曜日);
        } else {
            div.getTxtEndYobi().setValue(RString.EMPTY);
        }
        response.data = div;
        return response;
    }

    /**
     * 口座IDが変更場合、口座払いエリア情報を設定します。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData onChange_ddlKozaID(ShiharaiHohoJyohoDiv div) {
        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();
        ShiharaiHohoJyohoHandler handler = getHandler(div);
        getHandler(div).clear口座払い();
        if (!div.getDdlKozaID().getSelectedKey().isNullOrEmpty()) {
            SearchResult<Koza> koza = ShiharaiHohoJyohoFinder.createInstance().
                    getKozaJyoho(KozaParameter.createParam(Long.parseLong(div.getDdlKozaID().getSelectedKey().toString()), null, null));
            handler.口座払いエリアの初期化(koza.records().get(0), Long.parseLong(div.getDdlKozaID().getSelectedKey().toString()));
        } else {
            getHandler(div).clear口座払い();
        }
        response.data = div;
        return response;
    }

    /**
     * 「参考」ボタンをクリックします。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKeiyakuNo(ShiharaiHohoJyohoDiv div) {
        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * 口座IDドロップダウンリスト再設定。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData<ShiharaiHohoJyohoDiv> onOkClose_ddlKozaID(ShiharaiHohoJyohoDiv div) {

        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();
        ShunoKamokuShubetsu 業務内区分コード = getHandler(div).get業務内区分コード();
        SikyuSinseiJyohoParameter parameter = ViewStateHolder.
                get(ViewStateKeys.支給申請情報パラメータ, SikyuSinseiJyohoParameter.class);
        getHandler(div).set口座ID(parameter, 業務内区分コード);
        div.getDdlKozaID().setSelectedKey(RString.EMPTY);
        response.data = div;
        return response;
    }

    /**
     * 「契約番号」テキストボックスがonBlur場合、契約事業者情報取得を設定します。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData onBlur_txtKeiyakuNo(ShiharaiHohoJyohoDiv div) {
        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();
        getHandler(div).clear受領委任払い();
        SikyuSinseiJyohoParameter 支給申請情報 = ViewStateHolder.get(ViewStateKeys.支給申請情報パラメータ, SikyuSinseiJyohoParameter.class);
        JuryoininKeiyakuJigyosha 受領委任契約事業者 = ShiharaiHohoJyohoFinder.createInstance().
                getKeiyakuJigyosya(new KeiyakushaParameter(null, null, null, null).
                        createParam(支給申請情報.getHihokenshaNo() == null ? HihokenshaNo.EMPTY : new HihokenshaNo(支給申請情報.getHihokenshaNo().value()),
                                支給申請情報.getShikyushinseiServiceYM() == null ? FlexibleYearMonth.EMPTY : 支給申請情報.getShikyushinseiServiceYM(),
                                支給申請情報.getShikyushinseiSeiriNo() == null ? RString.EMPTY : 支給申請情報.getShikyushinseiSeiriNo(),
                                div.getTxtKeiyakuNo() == null ? RString.EMPTY : div.getTxtKeiyakuNo().getValue()));
        getHandler(div).受領委任払いエリアの初期化(支給申請情報, 受領委任契約事業者, RString.EMPTY);
        response.data = div;
        return response;
    }

    private ShiharaiHohoJyohoHandler getHandler(ShiharaiHohoJyohoDiv div) {
        return new ShiharaiHohoJyohoHandler(div);
    }
}
