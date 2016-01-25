/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0810027;

import jp.co.ndensan.reams.db.dbc.business.TestEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810027.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0810027.MainPanelHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い状況照会_緊急時施設療養費画面クラスです
 *
 * @author XuPeng
 */
public class MainPanel {

    /**
     * 償還払い状況照会_緊急時施設療養費画面初期化する
     *
     * @param div 緊急時施設療養費画面Div
     * @return response
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        TestEntity entity = new TestEntity();
        RString 申請書検索ViewSate_様式番号 = new RString("123");
        //介護宛名情報」共有子Divの初期化
//        div.getPanelCcd().getCcdKaigoAtenaInfo().load(entity.get識別コード());
        //介護資格系基本情報」共有子Div の初期化
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
//            div.getPanelCcd().getCcdKaigoShikakuKihon().initialize(entity.get被保険者番号());
        } else {
            div.getPanelCcd().getCcdKaigoAtenaInfo().setVisible(false);
        }
        MainPanelHandler handler = getHandler(div);
        handler.initPanelHead(entity.getサービス年月(),
                entity.get申請日(),
                entity.get事業者番号(),
                entity.get明細番号(),
                entity.get証明書(),
                申請書検索ViewSate_様式番号);
        handler.initList();
        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
//        List<ShokanKinkyuShisetsuRyoyo> list = finder.getKinkyujiShisetsuRyoyoData(
//                entity.get被保険者番号(),
//                entity.getサービス年月(),
//                entity.get整理番号(),
//                entity.get事業者番号(),
//                entity.get様式番号(),
//                entity.get明細番号(),
//                null);
//        if (list == null || list.isEmpty()) {
//            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
//        }
//        handler.initDgdKinkyujiShiseturyoyo(list);

//        ShikibetsuNoKanriEntity 識別番号 = finder.getShikibetsubangoKanri(entity.getサービス年月(),
//                ViewStateHolder.get(ViewStateKeys.償還払申請一覧_様式番号, RString.class));
//        handler.setボタン表示制御処理(識別番号, entity.getサービス年月());
        return ResponseData.of(div).respond();
    }

    /**
     * 基本情報ボタンを押下した際に実行します。<br/>
     * DBC0810021_基本情報画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnKihonInfo(MainPanelDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 特定診療費ボタンを押下した際に実行します。<br/>
     * DBC0810023_特定診療費画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnTokuteiShinryohi(MainPanelDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * サービス計画費ボタンを押下した際に実行します。<br/>
     * DBC0810024_サービス計画費画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnServiceKeikakuhi(MainPanelDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 特定入所者費用ボタンを押下した際に実行します。<br/>
     * DBC0810025_特定入所者費用画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnTokuteiNyushosya(MainPanelDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 合計情報ボタンを押下した際に実行します。<br/>
     * DBC0810026_合計情報画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnGoukeiInfo(MainPanelDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 給付費明細(住所地特例)ボタンを押下した際に実行します。<br/>
     * DBC0810032_給付費明細(住所地特例)画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnKyufuhiMeisaiJyuchi(MainPanelDiv div) {
        // DBC0810032_給付費明細(住所地特例)画面へ遷移する
        return ResponseData.of(div).respond();
    }

    /**
     * 食事費用ボタンを押下した際に実行します。<br/>
     * DBC0810029_食事費用画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnShokujiHiyo(MainPanelDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 請求額集計ボタンを押下した際に実行します。<br/>
     * DBC0810030_請求額集計画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnSeikyugakuShukei(MainPanelDiv div) {

        return ResponseData.of(div).respond();
    }

    /**
     * 社福軽減額ボタンを押下した際に実行します。<br/>
     * DBC0810031_社福軽減額画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnShafukukeigenGaku(MainPanelDiv div) {
        // DBC0810031_社福軽減額画面へ遷移する
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス提供証明書へ戻る」ボタン。<br/>
     * DBC0810014_サービス提供証明書画面へ遷移する
     *
     * @param div {@link MainPanelDiv 緊急時施設療養費画面Div}
     * @return 緊急時施設療養費画面Divを持つResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnServiceTeikyoShomeisho(MainPanelDiv div) {
        // DBC0810014_サービス提供証明書画面へ遷移する
        return ResponseData.of(div).respond();
    }

    public ResponseData<MainPanelDiv> onClick_btnSelectButton(MainPanelDiv div) {
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(false);
        TestEntity entity = new TestEntity();
        RString 連番 = div.getDgdKinkyujiShiseturyoyo().getClickedItem().getDefaultDataName5();
//        ShokanbaraiJyokyoShokai finder = ShokanbaraiJyokyoShokai.createInstance();
//        List<ShokanKinkyuShisetsuRyoyo> list = finder.getKinkyujiShisetsuRyoyoData(
//                entity.get被保険者番号(),
//                entity.getサービス年月(),
//                entity.get整理番号(),
//                entity.get事業者番号(),
//                entity.get明細番号(),
//                申請書検索ViewSate_様式番号,
//                連番);
//        ShokanKinkyuShisetsuRyoyo result=list.get(0);
//        getHandler(div).set傷病名(result);
//        getHandler(div).set往診通院(result);
//        getHandler(div).set治療点数(result);
        getHandler(div).set();
        return ResponseData.of(div).respond();
    }

    public ResponseData<MainPanelDiv> onClick_btnClose(MainPanelDiv div) {
        div.getPanelKinkyujiShiseturyoyoDetail().setDisplayNone(true);
        return ResponseData.of(div).respond();
    }

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return MainPanelHandler.of(div);
    }
}
