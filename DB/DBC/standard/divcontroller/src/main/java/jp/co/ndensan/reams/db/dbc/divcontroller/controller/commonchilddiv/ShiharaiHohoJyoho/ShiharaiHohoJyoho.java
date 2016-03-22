package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShiharaiHohoJyoho;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.shiharaihohojyoho.KozaJohoPSM.KozaJohoPSM;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KozaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.handler.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyohoHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.ShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.shiharaihohojyoho.ShiharaiHohoJyohoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 支払方法情報のコントローラです。
 *
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
            div.getTxtStartYobi().setValue(new RString(div.getTxtStartYMD().getValue().getDayOfWeek().toString()));
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
            div.getTxtEndYobi().setValue(new RString(div.getTxtEndYMD().getValue().getDayOfWeek().toString()));
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
        KozaJohoPSM kozaJohoPSM = ShiharaiHohoJyohoFinder.createInstance().
                getKozaJyoho(new KozaParameter(Long.parseLong(div.getDdlKozaID().getSelectedKey().toString()), null, null));
        handler.口座払いエリアの初期化(kozaJohoPSM, Long.parseLong(div.getDdlKozaID().getSelectedKey().toString()));
        response.data = div;
        return response;
    }

    /**
     * 「口座情報を登録する」ボタンをクリックします。
     *
     * @param div 支払方法情報
     * @return ResponseData
     */
    public ResponseData onClick_btnKozaToroku(ShiharaiHohoJyohoDiv div) {
        ResponseData<ShiharaiHohoJyohoDiv> response = new ResponseData<>();
//        TODO 口座情報照会ダイアログ
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
//        TODO QA:内部番号 444「DBCMN31003_受領委任契約（福祉用具購入費・住宅改修費）登録・追加・修正・照会」画面へ遷移する
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
                getKeiyakuJigyosya(KeiyakushaParameter.
                        createParam(new HihokenshaNo(div.getTxtKeiyakuNo().getValue()),
                                支給申請情報.getShikyushinseiServiceYM() == null ? FlexibleYearMonth.EMPTY : 支給申請情報.getShikyushinseiServiceYM(),
                                支給申請情報.getShikyushinseiSeiriNo() == null ? RString.EMPTY : 支給申請情報.getShikyushinseiSeiriNo(),
                                支給申請情報.getShiharaiBasho() == null ? RString.EMPTY : 支給申請情報.getShiharaiBasho()));
        getHandler(div).受領委任払いエリアの初期化(支給申請情報, 受領委任契約事業者);
        response.data = div;
        return response;
    }

    private ShiharaiHohoJyohoHandler getHandler(ShiharaiHohoJyohoDiv div) {
        return new ShiharaiHohoJyohoHandler(div);
    }
}
