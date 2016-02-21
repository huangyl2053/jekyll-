/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0820027;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.KinkyujiShisetuRyoyohiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820027.dgdKinkyujiShiseturyoyo_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0820027.KinkyujiShisetuRyoyohiPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0810014.ServiceTeiKyoShomeishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette.SikibetuNokennsakuki;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払い費支給申請決定_サービス提供証明書(緊急時施設療養費)画面クラスです
 */
public class KinkyujiShisetuRyoyohiPanel {

    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");

    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onLoad(KinkyujiShisetuRyoyohiPanelDiv div) {
        ServiceTeiKyoShomeishoParameter parameter = new ServiceTeiKyoShomeishoParameter(
                new HihokenshaNo("0000000003"), new FlexibleYearMonth(new RString("201601")),
                new RString("0000000003"), new JigyoshaNo("0000000003"), new RString("0003"),
                new RString("0003"), new RString("証明書"));
        ViewStateHolder.put(ViewStateKeys.償還払費申請明細検索キー, parameter);

        FlexibleYearMonth サービス年月 = parameter.getServiceTeikyoYM();
        HihokenshaNo 被保険者番号 = parameter.getHiHokenshaNo();
        RString 整理番号 = parameter.getSeiriNp();
        JigyoshaNo 事業者番号 = parameter.getJigyoshaNo();
        RString 明細番号 = parameter.getMeisaiNo();
        RString 証明書 = parameter.getServiceYM();

        // TODO 申請書検索ViewSate．様式番号
        ViewStateHolder.put(ViewStateKeys.様式番号, new RString("0003"));
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.様式番号, RString.class);
        ViewStateHolder.put(ViewStateKeys.申請日, new RDate("20151124"));
        RDate 申請日 = ViewStateHolder.get(ViewStateKeys.申請日, RDate.class);

        //介護宛名情報」共有子Divの初期化
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(償還払費申請検索.get識別コード());
        //介護資格系基本情報」共有子Div の初期化
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(被保険者番号);
        } else {
            div.getPanelCcd().getCcdKaigoAtenaInfo().setVisible(false);
        }

        getHandler(div).initPanelHead(サービス年月, 申請日, 事業者番号, 明細番号, 証明書, 様式番号);
        //償還払請求緊急時施設療養データ取得
        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanKinkyuShisetsuRyoyo> list = finder.getKinkyujiShisetsuRyoyoData(
                被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        getHandler(div).initDgdKinkyujiShiseturyoyo(list);

        SikibetuNokennsakuki key = new SikibetuNokennsakuki(new RString("0003"),
                new FlexibleYearMonth(new RString("200501")));
        ViewStateHolder.put(ViewStateKeys.識別番号検索キー, key);
        SikibetuNokennsakuki kennsakuki = ViewStateHolder.get(ViewStateKeys.識別番号検索キー,
                SikibetuNokennsakuki.class);
        ShikibetsuNoKanri 識別番号管理情報 = SyokanbaraihiShikyuShinseiKetteManager.createInstance()
                .getShikibetsuNoKanri(kennsakuki.getServiceTeikyoYM(), kennsakuki.getSikibetuNo());
//        if (識別番号管理情報 != null) {
//            getHandler(div).getボタンを制御(識別番号管理情報);
//        } else {
//            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
//        }

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            div.getBtnAdd().setDisabled(true);
            div.getDgdKinkyujiShiseturyoyo().setReadOnly(true);
            div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);
        }
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnAdd(KinkyujiShisetuRyoyohiPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.状態, 登録);
        getHandler(div).initAdd();
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btndgdModify(KinkyujiShisetuRyoyohiPanelDiv div) {
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(false);
        dgdKinkyujiShiseturyoyo_Row row = div.getDgdKinkyujiShiseturyoyo().getClickedItem();
        getHandler(div).set登録(row);
        if (!登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class)) && 修正.equals(
                ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            ViewStateHolder.put(ViewStateKeys.状態, 修正);
        }
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btndgdDelete(KinkyujiShisetuRyoyohiPanelDiv div) {
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnCal1(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).cal1();
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnCal2(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).cal2();
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnClear(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).clear登録();
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnCancel(KinkyujiShisetuRyoyohiPanelDiv div) {
        div.getBtnAdd().setDisabled(false);
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);
        getHandler(div).clear登録();
        return ResponseData.of(div).respond();
    }

    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnConfirm(KinkyujiShisetuRyoyohiPanelDiv div) {
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);
        List<dgdKinkyujiShiseturyoyo_Row> list = div.getDgdKinkyujiShiseturyoyo().getDataSource();
        if (div.getDgdKinkyujiShiseturyoyo().getClickedRowId() != -1) {
            dgdKinkyujiShiseturyoyo_Row row = div.getDgdKinkyujiShiseturyoyo().getClickedItem();
            getHandler(div).confirm(div.getDgdKinkyujiShiseturyoyo().getClickedItem());
            list.set(div.getDgdKinkyujiShiseturyoyo().getClickedRowId(), row);
        } else {
            dgdKinkyujiShiseturyoyo_Row row = new dgdKinkyujiShiseturyoyo_Row();
            getHandler(div).confirm(row);
            list.add(row);
        }
        div.getDgdKinkyujiShiseturyoyo().setDataSource(list);
        return ResponseData.of(div).respond();
    }

    // 基本情報
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKihonInfo(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    //給付費明細
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKyufuhiMeisai(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    //特定診療費
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnTokuteiShinryohi(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    //サービス計画費
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnServiceKeikakuhi(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    // 特定入所者費用
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnTokuteiNyushosya(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    //合計情報
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnGoukeiInfo(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    // 給付費明細(住所地特例)
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(
            KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    // 「緊急時施設療養費」
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnKinkyujiShoteiShikan(
            KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    //食事費用
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnShokujiHiyo(KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    //請求額集計
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnSeikyugakuShukei(
            KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    //社福軽減額
    public ResponseData<KinkyujiShisetuRyoyohiPanelDiv> onClick_btnShafukukeigenGaku(
            KinkyujiShisetuRyoyohiPanelDiv div) {
        getHandler(div).putViewState();
        return ResponseData.of(div).respond();
    }

    private KinkyujiShisetuRyoyohiPanelHandler getHandler(KinkyujiShisetuRyoyohiPanelDiv div) {
        return KinkyujiShisetuRyoyohiPanelHandler.of(div);
    }

}
