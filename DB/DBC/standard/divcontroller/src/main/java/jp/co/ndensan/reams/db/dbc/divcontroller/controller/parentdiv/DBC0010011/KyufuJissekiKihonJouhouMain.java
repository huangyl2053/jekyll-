/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKihonJyohou;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010011.KyufuJissekiKihonJouhouMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010011.KyufuJissekiKihonJouhouMainHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会_基本情報画面
 *
 * @reamsid_L DBC-2970-030 linghuhang
 */
public class KyufuJissekiKihonJouhouMain {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div 給付実績照会基本情報画面のDIVです。
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onLoad(KyufuJissekiKihonJouhouMainDiv div) {
        KyufuJissekiHeader 給付実績基本情報子Divデータ
                = ViewStateHolder.get(ViewStateKeys.給付実績基本情報子Div, KyufuJissekiHeader.class);
        div.getCcdKyufuJissekiHeader().set被保情報(給付実績基本情報子Divデータ);
        FlexibleYearMonth サービス提供年月
                = ViewStateHolder.get(ViewStateKeys.サービス提供年月, FlexibleYearMonth.class);
        List<KyufuJissekiKihonShukeiRelate> csData_A = get給付実績基本情報();
        List<KyufuJissekiKihonShukeiRelate> 該当月給付実績基本集計データ = get該当月給付実績基本集計データ(csData_A, サービス提供年月);
        if (!該当月給付実績基本集計データ.isEmpty()) {
            getHandler(div).onLoad(該当月給付実績基本集計データ.get(0));
            setHidden(サービス提供年月, csData_A, div);
            set事業者_月制御(csData_A, div);
        } else {
            div.getBtnMaeJigyosha().setDisabled(true);
            div.getBtnAtoJigyosha().setDisabled(true);
            div.getBtnZengetsu().setDisabled(true);
            div.getBtnJigetsu().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    private void setHidden(FlexibleYearMonth サービス提供年月, List<KyufuJissekiKihonShukeiRelate> csData_A, KyufuJissekiKihonJouhouMainDiv div) {
        int index = 0;
        boolean flag = false;
        for (KyufuJissekiKihonShukeiRelate csData : csData_A) {
            FlexibleYearMonth サービス提供 = csData.get給付実績基本データ().getサービス提供年月();
            if (!flag && サービス提供年月.equals(サービス提供)) {
                flag = true;
                div.setHdnCurrentOrder(new RString(index));
                div.setHdnStartOrder(new RString(index));
            }
            if (flag && (!サービス提供年月.equals(サービス提供))) {
                div.setHdnEndOrder(new RString(index - 1));
                break;
            }
            if (flag && (index == csData_A.size() - 1)) {
                div.setHdnEndOrder(new RString(index));
            }
            index++;
        }
    }

    private void set事業者_月制御(List<KyufuJissekiKihonShukeiRelate> csData_A, KyufuJissekiKihonJouhouMainDiv div) {
        int currentOrder = rStringToInt(div.getHdnCurrentOrder());
        int startOrder = rStringToInt(div.getHdnStartOrder());
        int endOrder = rStringToInt(div.getHdnEndOrder());
        div.getBtnMaeJigyosha().setDisabled(currentOrder == startOrder);
        div.getBtnAtoJigyosha().setDisabled(currentOrder == endOrder);
        div.getBtnZengetsu().setDisabled(startOrder == 0);
        div.getBtnJigetsu().setDisabled(endOrder == csData_A.size() - 1);
    }

    private int rStringToInt(RString value) {
        return Integer.parseInt(value.toString());
    }

    private List<KyufuJissekiKihonShukeiRelate> get該当月給付実績基本集計データ(
            List<KyufuJissekiKihonShukeiRelate> csData_A, FlexibleYearMonth サービス提供年月) {
        List<KyufuJissekiKihonShukeiRelate> 該当月給付実績基本集計データ = new ArrayList<>();
        for (KyufuJissekiKihonShukeiRelate 集計データ : csData_A) {
            if (サービス提供年月.equals(集計データ.get給付実績基本データ().getサービス提供年月())) {
                該当月給付実績基本集計データ.add(集計データ);
            }
        }
        return 該当月給付実績基本集計データ;
    }

    /**
     * 「合計情報」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_KihonGokei(KyufuJissekiKihonJouhouMainDiv div) {
        div.getKyufuJissekiKihonGokeiPanel().setIsOpen(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前事業者」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_MaeJigyosha(KyufuJissekiKihonJouhouMainDiv div) {
        int currenOrder = rStringToInt(div.getHdnCurrentOrder()) - 1;
        List<KyufuJissekiKihonShukeiRelate> csData_A = get給付実績基本情報();
        KyufuJissekiKihonShukeiRelate 該当給付実績基本集計データ = csData_A.get(currenOrder);
        clear画面(div);
        getHandler(div).setデータ(該当給付実績基本集計データ);
        div.setHdnCurrentOrder(new RString(currenOrder));
        set事業者_月制御(csData_A, div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「後事業者」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_AtoJigyosha(KyufuJissekiKihonJouhouMainDiv div) {
        int currenOrder = rStringToInt(div.getHdnCurrentOrder()) + 1;
        List<KyufuJissekiKihonShukeiRelate> csData_A = get給付実績基本情報();
        KyufuJissekiKihonShukeiRelate 該当給付実績基本集計データ = csData_A.get(currenOrder);
        clear画面(div);
        getHandler(div).setデータ(該当給付実績基本集計データ);
        div.setHdnCurrentOrder(new RString(currenOrder));
        set事業者_月制御(csData_A, div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前月」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIVです
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_Zengetsu(KyufuJissekiKihonJouhouMainDiv div) {
        List<KyufuJissekiKihonShukeiRelate> csData_A = get給付実績基本情報();
        FlexibleYearMonth サービス提供年月
                = csData_A.get(rStringToInt(div.getHdnStartOrder()) - 1).get給付実績基本データ().getサービス提供年月();
        List<KyufuJissekiKihonShukeiRelate> 該当月給付実績基本集計データ = get該当月給付実績基本集計データ(csData_A, サービス提供年月);
        KyufuJissekiKihonShukeiRelate 該当給付実績基本集計データ = 該当月給付実績基本集計データ.get(0);
        clear画面(div);
        getHandler(div).onLoad(該当給付実績基本集計データ);
        setHidden(サービス提供年月, csData_A, div);
        set事業者_月制御(csData_A, div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「次月」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIV
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_Jigetsu(KyufuJissekiKihonJouhouMainDiv div) {
        List<KyufuJissekiKihonShukeiRelate> csData_A = get給付実績基本情報();
        FlexibleYearMonth サービス提供年月
                = csData_A.get(rStringToInt(div.getHdnEndOrder()) + 1).get給付実績基本データ().getサービス提供年月();
        List<KyufuJissekiKihonShukeiRelate> 該当月給付実績基本集計データ = get該当月給付実績基本集計データ(csData_A, サービス提供年月);
        KyufuJissekiKihonShukeiRelate 該当給付実績基本集計データ = 該当月給付実績基本集計データ.get(0);
        clear画面(div);
        getHandler(div).onLoad(該当給付実績基本集計データ);
        setHidden(サービス提供年月, csData_A, div);
        set事業者_月制御(csData_A, div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「閉じる」ボタンを押下する場合、画面を表示します。
     *
     * @param div 給付実績照会基本情報画面のDIV
     * @return 給付実績照会基本情報画面
     */
    public ResponseData<KyufuJissekiKihonJouhouMainDiv> onClick_Close(KyufuJissekiKihonJouhouMainDiv div) {
        div.getKyufuJissekiKihonGokeiPanel().setIsOpen(false);
        return ResponseData.of(div).respond();
    }

    private List<KyufuJissekiKihonShukeiRelate> get給付実績基本情報() {
        return ViewStateHolder.get(ViewStateKeys.給付実績基本情報, KyufujissekiKihonJyohou.class).getCsData_A();
    }

    private KyufuJissekiKihonJouhouMainHandler getHandler(KyufuJissekiKihonJouhouMainDiv div) {
        return new KyufuJissekiKihonJouhouMainHandler(div);
    }

    private void clear画面(KyufuJissekiKihonJouhouMainDiv div) {
        clear申請内容エリア(div);
        clear合計内容エリア(div);
    }

    private void clear申請内容エリア(KyufuJissekiKihonJouhouMainDiv div) {
        div.getTxtKyufuJissekiKihonSakuseiKubun().clearValue();
        div.getTxtKyufuJissekiKihonYokaigodo().clearValue();
        div.getTxtYukoKaishiYMD().clearValue();
        div.getTxtYukoShuryoYMD().clearValue();
        div.getTxtKyufuJissekiKihonShinsaYM().clearValue();
        div.getTxtKyufuJissekiKihonKeikokuKubun().clearValue();
        div.getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei().clearValue();
        div.getTxtServiceTankasu().clearValue();
        div.getTxtHokenryoSeikyuGaku().clearValue();
        div.getTxtRiyoshaFutanGaku().clearValue();
        div.getTxtKyufuJissekiKihonRojinHokenShichosonNo().clearValue();
        div.getTxtKyufuJissekiKihonRojinHokenJukyushaNo().clearValue();
        div.getTxtKyufuJissekiKihonKokiKoreiHokenshaNo().clearValue();
        div.getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo().clearValue();
        div.getTxtKyufuJissekiKihonKokuhoHokenshaNo().clearValue();
        div.getTxtKyufuJissekiKihonKokuhoHihokenshashoNo().clearValue();
        div.getTxtKyufuJissekiKihonKokuhoKojinNo().clearValue();
        div.getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun().clearValue();
        div.getTxtKyufuJissekiKihonJigyoshoNo().clearValue();
        div.getTxtKyufuJissekiKihonJigyoshoName().clearValue();
        div.getTxtKyufuJissekiKihonKaishiYMD().clearValue();
        div.getTxtKyufuJissekiKihonChushiYMD().clearValue();
        div.getTxtKyufuJissekiKihonChushiRiyu().clearValue();
        div.getTxtKyufuJissekiKihonNyushoYMD().clearValue();
        div.getTxtKyufuJissekiKihonNyushoJitsuNissu().clearValue();
        div.getTxtKyufuJissekiKihonTaishoYMD().clearValue();
        div.getTxtKyufuJissekiKihonGaihakuNissu().clearValue();
        div.getTxtKyufuJissekiKihonNyushoMaeJokyo().clearValue();
        div.getTxtKyufuJissekiKihonNyushoAtoJokyo().clearValue();
        div.getTxtKyufuJissekiKihonHokenKyufuRitsu().clearValue();
        div.getTxtKyufuJissekiKihonKohi1KyufuRitsu().clearValue();
        div.getTxtKyufuJissekiKihonKohi2KyufuRitsu().clearValue();
        div.getTxtKyufuJissekiKihonKohi3KyufuRitsu().clearValue();
        div.getTxtKyufuJissekiKihonKohiFutanshaNo1().clearValue();
        div.getTxtKyufuJissekiKihonKohiJukyushaNo1().clearValue();
        div.getTxtKyufuJissekiKihonKohiFutanshaNo2().clearValue();
        div.getTxtKyufuJissekiKihonKohiJukyushaNo2().clearValue();
        div.getTxtKyufuJissekiKihonKohiFutanshaNo3().clearValue();
        div.getTxtKyufuJissekiKihonKohiJukyushaNo3().clearValue();
    }

    private void clear合計内容エリア(KyufuJissekiKihonJouhouMainDiv div) {
        div.getTxtMaeHokenServiceTanisu().clearValue();
        div.getTxtGoHokenServiceTanisu().clearValue();
        div.getTxtMaeKohi1ServiceTanisu().clearValue();
        div.getTxtGoKohi1ServiceTanisu().clearValue();
        div.getTxtMaeKohi2ServiceTanisu().clearValue();
        div.getTxtGoKohi2ServiceTanisu().clearValue();
        div.getTxtMaeKohi3ServiceTanisu().clearValue();
        div.getTxtGoKohi3ServiceTanisu().clearValue();
        div.getTxtMaeHokenHokenSeikyugaku().clearValue();
        div.getTxtGoHokenHokenSeikyugaku().clearValue();
        div.getTxtMaeKohi1HokenSeikyugaku().clearValue();
        div.getTxtGoKohi1HokenSeikyugaku().clearValue();
        div.getTxtMaeKohi2HokenSeikyugaku().clearValue();
        div.getTxtGoKohi2HokenSeikyugaku().clearValue();
        div.getTxtMaeKohi3HokenSeikyugaku().clearValue();
        div.getTxtGoKohi3HokenSeikyugaku().clearValue();
        div.getTxtMaeHokenRiyoshaFutangaku().clearValue();
        div.getTxtGoHokenRiyoshaFutangaku().clearValue();
        div.getTxtMaeKohi1RiyoshaFutangaku().clearValue();
        div.getTxtGoKohi1RiyoshaFutangaku().clearValue();
        div.getTxtMaeKohi2RiyoshaFutangaku().clearValue();
        div.getTxtGoKohi2RiyoshaFutangaku().clearValue();
        div.getTxtMaeKohi3RiyoshaFutangaku().clearValue();
        div.getTxtGoKohi3RiyoshaFutangaku().clearValue();
        div.getTxtMaeHokenKinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtGoHokenKinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtMaeKohi1KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtGoKohi1KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtMaeKohi2KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtGoKohi2KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtMaeKohi3KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtGoKohi3KinkyujiShisetsuRyoyohi().clearValue();
        div.getTxtMaeHokenTokuteiShinryohi().clearValue();
        div.getTxtGoHokenTokuteiShinryohi().clearValue();
        div.getTxtMaeKohi1TokuteiShinryohi().clearValue();
        div.getTxtGoKohi1TokuteiShinryohi().clearValue();
        div.getTxtMaeKohi2TokuteiShinryohi().clearValue();
        div.getTxtGoKohi2TokuteiShinryohi().clearValue();
        div.getTxtMaeKohi3TokuteiShinryohi().clearValue();
        div.getTxtGoKohi3TokuteiShinryohi().clearValue();
        div.getTxtMaeHokenTokuteiNyushosha().clearValue();
        div.getTxtGoHokenTokuteiNyushosha().clearValue();
        div.getTxtMaeKohi1TokuteiNyushosha().clearValue();
        div.getTxtGoKohi1TokuteiNyushosha().clearValue();
        div.getTxtMaeKohi2TokuteiNyushosha().clearValue();
        div.getTxtGoKohi2TokuteiNyushosha().clearValue();
        div.getTxtMaeKohi3TokuteiNyushosha().clearValue();
        div.getTxtGoKohi3TokuteiNyushosha().clearValue();
    }
}
