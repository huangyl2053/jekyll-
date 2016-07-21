/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJisseki;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiShafukuKeigen;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.ShakaiFukushiHojinKeigengakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgShakaiFukushiHojinKeigengaku_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N8156 宮本 康
 */
public class ShakaiFukushiHojinKeigengaku {

    private static final int INDEX_6 = 6;

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel ShakaiFukushiHojinKeigengakuDiv
     * @return ResponseData
     */
    public ResponseData<ShakaiFukushiHojinKeigengakuDiv> onLoad(ShakaiFukushiHojinKeigengakuDiv panel) {
        ResponseData<ShakaiFukushiHojinKeigengakuDiv> response = new ResponseData<>();

        KyufuJisseki kyufuJisseki = get給付実績();
        KyufuJissekiShafukuKeigen iFuJisseki = null;

        List<dgShakaiFukushiHojinKeigengaku_Row> shakaiHojinKeigengakuList = new ArrayList<>();

        for (Iterator<KyufuJissekiShafukuKeigen> i = kyufuJisseki.get社会福祉法人軽減額リスト().iterator(); i.hasNext();) {

            iFuJisseki = i.next();

            RString rsKeigenritsu = iFuJisseki.get軽減率();
            RString rsShurui = iFuJisseki.get種類();
            RString rsZengo = iFuJisseki.get前後();
            RString rsJuryoRiyoshaFutanSogaku = setCommFormat(iFuJisseki.get受領すべき利用者負担の総額());
            RString rsKeigengaku = setCommFormat(iFuJisseki.get軽減額());
            RString rsKeigengoRiyoshaFutangaku = setCommFormat(iFuJisseki.get軽減後利用者負担額());

            RString rsBiko = iFuJisseki.get備考();
            RString rsSaishinsaKaisu = toRString(iFuJisseki.get再審査回数());
            RString rsKagoKaisu = toRString(iFuJisseki.get過誤回数());
            RString rsShinsaYM = toWareki(iFuJisseki.get審査年月());

            shakaiHojinKeigengakuList.add(createShakaiFukushiHojinKeigengakuRow(
                    rsKeigenritsu, rsShurui, rsZengo, rsJuryoRiyoshaFutanSogaku, rsKeigengaku,
                    rsKeigengoRiyoshaFutangaku, rsBiko,
                    rsSaishinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgShakaiFukushiHojinKeigengaku().setDataSource(shakaiHojinKeigengakuList);

        response.data = panel;
        return response;
    }

    private dgShakaiFukushiHojinKeigengaku_Row createShakaiFukushiHojinKeigengakuRow(
            RString txtKeigenritsu, RString txtShurui, RString txtZengo, RString txtJuryoRiyoshaFutanSogaku,
            RString txtKeigengaku, RString txtKeigengoRiyoshaFutangaku, RString txtBiko, RString txtSaishinsaKaisu,
            RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgShakaiFukushiHojinKeigengaku_Row(
                txtKeigenritsu, txtShurui, txtZengo, txtJuryoRiyoshaFutanSogaku,
                txtKeigengaku, txtKeigengoRiyoshaFutangaku, txtBiko, txtSaishinsaKaisu, txtKagoKaisu, txtShinsaYM);
    }

    private KyufuJisseki get給付実績() {
        // TODO 未使用のローカル変数です。 Checkstyle 対応。

//        RString 被保番号 = (RString) ViewStateHolder.get("被保番号", RString.class);
//        RString サービス提供期間開始 = (RString) ViewStateHolder.get("サービス提供期間開始", RString.class);
//        RString サービス提供期間終了 = (RString) ViewStateHolder.get("サービス提供期間終了", RString.class);
//        RString 入力識別番号 = (RString) ViewStateHolder.get("入力識別番号", RString.class);
//        RString サービス種類 = (RString) ViewStateHolder.get("サービス種類", RString.class);
//        RString サービス提供年月 = (RString) ViewStateHolder.get("サービス提供年月", RString.class);
//
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

    private RString toWareki(FlexibleYearMonth data) {
        if (data == null || !data.isValid()) {
            return RString.EMPTY;
        }
        return data.wareki().toDateString().substring(0, INDEX_6);
    }

    private RString setCommFormat(Decimal data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString("##,###,###"));
    }

    private RString toRString(Integer data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }
}
