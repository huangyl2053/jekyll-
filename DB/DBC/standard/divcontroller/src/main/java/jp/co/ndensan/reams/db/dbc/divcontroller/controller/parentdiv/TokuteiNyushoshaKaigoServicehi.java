/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJisseki;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiTokuteiNyushohi;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.TokuteiNyushoshaKaigoServicehiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgTokuteiNyushoshaKaigoServicehi_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N8156 宮本 康
 */
public class TokuteiNyushoshaKaigoServicehi {

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel TokuteiNyushoshaKaigoServicehiDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiNyushoshaKaigoServicehiDiv> onLoad(TokuteiNyushoshaKaigoServicehiDiv panel) {
        ResponseData<TokuteiNyushoshaKaigoServicehiDiv> response = new ResponseData<>();

        KyufuJisseki kyufuJisseki = get給付実績();

        //特定入所者介護サービスデータ取得、設定
        List<dgTokuteiNyushoshaKaigoServicehi_Row> tokuteiKaigoServicehiList = new ArrayList<>();

        for (KyufuJissekiTokuteiNyushohi iTokute : kyufuJisseki.get特定入所者リスト()) {

            RString rsService = iTokute.getサービス();
            RString rsFutanGendogaku = setCommFormat(iTokute.get負担限度額());
            RString rsKettei = iTokute.get決定();
            RString rsMeisaiGokei = iTokute.get明細合計();
            RString rsHiyoTanka = setCommFormat(iTokute.get費用単価());
            RString rsNissu = toRString(iTokute.get日数());
            RString rsHiyogaku = setCommFormat(iTokute.get費用額());
            RString rsSeikyugaku = setCommFormat(iTokute.get請求額());
            RString rsRiyoshaFutangaku = setCommFormat(iTokute.get利用者負担額());
            RString rsKohi1Nissu = toRString(iTokute.get公費1日数());
            RString rsKohi1Futangaku = toRString(iTokute.get公費1日数());
            RString rsKohi1Seikyugaku = setCommFormat(iTokute.get公費1負担額());
            RString rsKohi1HonninFutangaku = setCommFormat(iTokute.get公費1本人負担額());
            RString rsKohi2Nissu = toRString(iTokute.get公費2日数());
            RString rsKohi2Futangaku = setCommFormat(iTokute.get公費2負担額());
            RString rsKohi2Seikyugaku = setCommFormat(iTokute.get公費2請求額());
            RString rsKohi2HonninFutangaku = setCommFormat(iTokute.get公費2本人負担額());
            RString rsKohi3Nissu = toRString(iTokute.get公費3日数());
            RString rsKohi3Futangaku = setCommFormat(iTokute.get公費3負担額());
            RString rsKohi3Seikyugaku = setCommFormat(iTokute.get公費3請求額());
            RString rsKohi3HonninFutangaku = setCommFormat(iTokute.get公費3本人負担額());
            RString rsSaishinsaKaisu = toRString(iTokute.get再審査回数());
            RString rsKagoKaisu = toRString(iTokute.get過誤回数());
            RString rsShinsaYM = toWareki(iTokute.get審査年月());

            tokuteiKaigoServicehiList.add(createTokuteiNyushoshaKaigoServicehiRow(
                    rsService, rsFutanGendogaku, rsKettei, rsMeisaiGokei, rsHiyoTanka, rsNissu,
                    rsHiyogaku, rsSeikyugaku, rsRiyoshaFutangaku, rsKohi1Nissu, rsKohi1Futangaku,
                    rsKohi1Seikyugaku, rsKohi1HonninFutangaku, rsKohi2Nissu, rsKohi2Futangaku,
                    rsKohi2Seikyugaku, rsKohi2HonninFutangaku, rsKohi3Nissu, rsKohi3Futangaku,
                    rsKohi3Seikyugaku, rsKohi3HonninFutangaku,
                    rsSaishinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgTokuteiNyushoshaKaigoServicehi().setDataSource(tokuteiKaigoServicehiList);

        response.data = panel;
        return response;
    }

    private dgTokuteiNyushoshaKaigoServicehi_Row createTokuteiNyushoshaKaigoServicehiRow(
            RString txtService, RString txtFutanGendogaku, RString txtKettei, RString txtMeisaiGokei,
            RString txtHiyoTanka, RString txtNissu, RString txtHiyogaku, RString txtSeikyugaku, RString txtRiyoshaFutangaku,
            RString txtKohi1Nissu, RString txtKohi1Futangaku, RString txtKohi1Seikyugaku, RString txtKohi1HonninFutangaku,
            RString txtKohi2Nissu, RString txtKohi2Futangaku, RString txtKohi2Seikyugaku, RString txtKohi2HonninFutangaku,
            RString txtKohi3Nissu, RString txtKohi3Futangaku, RString txtKohi3Seikyugaku, RString txtKohi3HonninFutangaku,
            RString txtSaishinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgTokuteiNyushoshaKaigoServicehi_Row(
                txtService, txtFutanGendogaku, txtKettei, txtMeisaiGokei,
                txtHiyoTanka, txtNissu, txtHiyogaku, txtSeikyugaku, txtRiyoshaFutangaku,
                txtKohi1Nissu, txtKohi1Futangaku, txtKohi1Seikyugaku, txtKohi1HonninFutangaku,
                txtKohi2Nissu, txtKohi2Futangaku, txtKohi2Seikyugaku, txtKohi2HonninFutangaku,
                txtKohi3Nissu, txtKohi3Futangaku, txtKohi3Seikyugaku, txtKohi3HonninFutangaku,
                txtSaishinsaKaisu, txtKagoKaisu, txtShinsaYM);
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
//
//    private String setCommFormat(String str) {
//        if (str.isEmpty()) {
//            return str;
//        }
//        return new Decimal(str).toString("##,###,###");
//    }

    private RString setCommFormat(Decimal data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString("##,###,###"));
    }

    private static final int INDEX_6 = 6;

    private RString toWareki(FlexibleYearMonth data) {
        if (data == null || !data.isValid()) {
            return RString.EMPTY;
        }
        return data.wareki().toDateString().substring(0, INDEX_6);
    }

    private RString toRString(Integer data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }

}
