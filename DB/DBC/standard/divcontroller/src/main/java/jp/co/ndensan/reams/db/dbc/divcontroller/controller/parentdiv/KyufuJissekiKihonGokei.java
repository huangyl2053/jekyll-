/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJisseki;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonGokeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiKihonGokei_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiKihonGokei {

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel KyufuJissekiKihonGokeiDiv
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiKihonGokeiDiv> onLoad(KyufuJissekiKihonGokeiDiv panel) {
        ResponseData<KyufuJissekiKihonGokeiDiv> response = new ResponseData<>();

        KyufuJisseki kyufuJisseki = get給付実績();

        //給付実績基本合計データ取得、設定
        List<dgKyufuJissekiKihonGokei_Row> kyufuJissekiKihonGokeiList = new ArrayList<>();
        for (jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonGokei iKihonGokei : kyufuJisseki.get基本().get合計()) {

            RString rsHokenKohi = iKihonGokei.get保険公費();
            RString rsZengo = iKihonGokei.get前後();
            RString rsServiceTani = toRString(iKihonGokei.getサービス単位());
            RString rsRiyoshaFutangaku = setCommFormat(iKihonGokei.get利用者負担額());
            RString rsHokenryoSeikyugaku = setCommFormat(iKihonGokei.get保険料請求額());
            RString rsKinkyujiSeikyubunGokei = setCommFormat(iKihonGokei.get緊急時施設療養費保険請求分合計());
            RString rsTokuteiSeikyubunGokei = setCommFormat(iKihonGokei.get特定診療費公費請求分合計());
            RString rsKaigotoSeikyugaku = setCommFormat(iKihonGokei.get特定入所者介護等請求額());

            kyufuJissekiKihonGokeiList.add(createKyufuJissekiKihonGokeiRow(
                    rsHokenKohi, rsZengo, rsServiceTani, rsHokenryoSeikyugaku, rsRiyoshaFutangaku,
                    rsKinkyujiSeikyubunGokei, rsTokuteiSeikyubunGokei, rsKaigotoSeikyugaku));
        }
        panel.getDgKyufuJissekiKihonGokei().setDataSource(kyufuJissekiKihonGokeiList);

        response.data = panel;
        return response;
    }

    private dgKyufuJissekiKihonGokei_Row createKyufuJissekiKihonGokeiRow(
            RString txtHokenKohi, RString txtKettei, RString txtServiceTanisu, RString txtHokenryoSeikyugaku, RString txtRiyoshaFutangaku,
            RString txtShisetsuRyoyohi, RString txtTokuteiShinryohi, RString txtTokuteiNyushoshaKaigo) {
        return new dgKyufuJissekiKihonGokei_Row(
                txtHokenKohi, txtKettei, txtServiceTanisu, txtHokenryoSeikyugaku, txtRiyoshaFutangaku,
                txtShisetsuRyoyohi, txtTokuteiShinryohi, txtTokuteiNyushoshaKaigo);
    }

    private KyufuJisseki get給付実績() {

//        RString 被保番号 = (RString) ViewStateHolder.get("被保番号", RString.class);
//        RString サービス提供期間開始 = (RString) ViewStateHolder.get("サービス提供期間開始", RString.class);
//        RString サービス提供期間終了 = (RString) ViewStateHolder.get("サービス提供期間終了", RString.class);
//        RString 入力識別番号 = (RString) ViewStateHolder.get("入力識別番号", RString.class);
//        RString サービス種類 = (RString) ViewStateHolder.get("サービス種類", RString.class);
//        RString サービス提供年月 = (RString) ViewStateHolder.get("サービス提供年月", RString.class);
//        KyufuJissekiKeyInfo keyInfo = new KyufuJissekiKeyInfo(
//                new HihokenshaNo(被保番号),
//                new Range<>(new ServiceTeikyoYM(new FlexibleYearMonth(サービス提供期間開始)), new ServiceTeikyoYM((new FlexibleYearMonth(サービス提供期間終了)))),
//                new InputShikibetsuNo(new Code(入力識別番号), RString.EMPTY, RString.EMPTY),
//                new ServiceShuruiCode(サービス種類),
//                new ServiceTeikyoYM(new FlexibleYearMonth(サービス提供年月)));
        // TODO n8300姜　ビルドエラー回避のために暫定対応
//        KyufuJissekiFinder finder = new KyufuJissekiFinder();
//        KyufuJissekiDetailKeyInfo detailKeyInfo = finder.get給付実績詳細キー(keyInfo);
//        return detailKeyInfo != null ? finder.get給付実績(detailKeyInfo) : null;
        return null;
    }

    private RString setCommFormat(Decimal data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString("##,###,###"));
    }

    private RString toRString(Decimal data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }

}
