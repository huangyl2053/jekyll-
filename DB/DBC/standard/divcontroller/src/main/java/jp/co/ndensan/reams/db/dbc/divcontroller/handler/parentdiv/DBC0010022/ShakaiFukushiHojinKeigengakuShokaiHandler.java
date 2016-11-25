/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010022;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShakaiFukushiHojinKeigengakuBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010022.ShakaiFukushiHojinKeigengakuShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010022.dgShakaiFukushiHojinKeigengaku_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績の社会福祉法人軽減額を照会の画面処理Handlerクラスです。
 *
 * @reamsid_L DBC-2970-140 zhaoyao
 */
public class ShakaiFukushiHojinKeigengakuShokaiHandler {

    private final ShakaiFukushiHojinKeigengakuShokaiDiv div;
    private static final RString 後 = new RString("後");
    private static final int INT_ZERO = 0;
    private static final RString ZERO = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShakaiFukushiHojinKeigengakuShokaiHandler(ShakaiFukushiHojinKeigengakuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化です。
     *
     * @param 給付実績社会福祉法人軽減額リスト List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness>
     */
    public void onLoad(List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額リスト) {
        List<dgShakaiFukushiHojinKeigengaku_Row> rowList = new ArrayList<>();
        for (KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額 : 給付実績社会福祉法人軽減額リスト) {
            rowList.add(setEmptyRowData(給付実績社会福祉法人軽減額));
            rowList.add(setKoRowData(給付実績社会福祉法人軽減額));
        }
        div.getDgShakaiFukushiHojinKeigengaku().setDataSource(rowList);
    }

    private dgShakaiFukushiHojinKeigengaku_Row setEmptyRowData(
            KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額) {
        RString 審査年月 = RString.EMPTY;
        if (給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get審査年月() != null) {
            審査年月 = 給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get審査年月().wareki().toDateString();
        }
        dgShakaiFukushiHojinKeigengaku_Row row = new dgShakaiFukushiHojinKeigengaku_Row();
        row.setTxtKeigenritsu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get軽減率().intValue()));
        row.setTxtShurui(給付実績社会福祉法人軽減額.getサービス種類略称());
        row.setTxtZengo(RString.EMPTY);
        row.setTxtJuryoSubekiRiyoshaFutanSogaku(kinngakuFormat(
                給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get受領すべき利用者負担の総額()));
        row.setTxtKeigengaku(kinngakuFormat(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get軽減額()));
        row.setTxtKeigengoRiyoshaFutangaku(kinngakuFormat(
                給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get軽減後利用者負担額()));
        row.setTxtBiko(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get備考());
        row.setTxtSaishinsaKaisu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get再審査回数()));
        row.setTxtKagoKaisu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get過誤回数()));
        row.setTxtShinsaYM(審査年月);
        return row;
    }

    private dgShakaiFukushiHojinKeigengaku_Row setKoRowData(
            KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績社会福祉法人軽減額) {
        RString 審査年月 = RString.EMPTY;
        if (給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get審査年月() != null) {
            審査年月 = 給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get審査年月().wareki().toDateString();
        }
        dgShakaiFukushiHojinKeigengaku_Row row = new dgShakaiFukushiHojinKeigengaku_Row();
        row.setTxtKeigenritsu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get軽減率().intValue()));
        row.setTxtShurui(給付実績社会福祉法人軽減額.getサービス種類略称());
        row.setTxtZengo(後);
        row.setTxtJuryoSubekiRiyoshaFutanSogaku(kinngakuFormat(
                給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get後_受領すべき利用者負担の総額()));
        row.setTxtKeigengaku(kinngakuFormat(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get後_軽減額()));
        row.setTxtKeigengoRiyoshaFutangaku(kinngakuFormat(
                給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get後_軽減後利用者負担額()));
        row.setTxtBiko(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get備考());
        row.setTxtSaishinsaKaisu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get再審査回数()));
        row.setTxtKagoKaisu(new RString(給付実績社会福祉法人軽減額.get給付実績社会福祉法人軽減額情報().get過誤回数()));
        row.setTxtShinsaYM(審査年月);
        return row;
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 識別番号管理
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {
        div.getBtnKogakuKaigoService().setDisabled(true);
        if (ZERO.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }
        if (ZERO.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }
        div.getBtnShafukuKeigen().setDisabled(true);
    }

    private RString kinngakuFormat(Decimal date) {
        if (date == null || date == Decimal.ZERO) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(date, INT_ZERO);
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<FlexibleYearMonth>, Serializable {

        private static final long serialVersionUID = -358607129021022956L;

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o2.compareTo(o1);
        }
    }

    private static class DateComparatorServiceYM implements Comparator<FlexibleYearMonth>, Serializable {

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o1.compareTo(o2);
        }
    }
}
