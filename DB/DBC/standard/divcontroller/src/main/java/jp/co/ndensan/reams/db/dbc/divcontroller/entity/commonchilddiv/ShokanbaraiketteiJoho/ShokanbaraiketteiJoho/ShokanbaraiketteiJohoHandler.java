/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho.ShokanbaraiketteiJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.SyokanbaraiketteJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraikettejoho.SyokanbaraiketteJohoManager;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 償還払決定一覧のHandlerクラスです。
 *
 * @reamsid_L DBC-0950-010 zuotao
 */
public class ShokanbaraiketteiJohoHandler {

    private final ShokanbaraiketteiJohoDiv div;
    private static final RString 差止控除区分_10 = new RString("10");
    private static final RString 差止控除区分_20 = new RString("20");
    private static final RString 差止控除区分_21 = new RString("21");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_照会 = new RString("照会");
    private static final RString 支給区分_支給 = new RString("1");
    private static final RString 支給区分_不支給 = new RString("0");
    private static final RString GYOKUKBN_住宅改修 = new RString("01");
    private static final RString GYOKUKBN_福祉用具販売費 = new RString("02");
    private static final RString GYOKUKBN_償還払い費 = new RString("03");
    private static final Decimal 数字_100 = new Decimal("100");

    /**
     * コンストラクタです。
     *
     * @param div IkenshoShujiiIchiranDiv
     */
    public ShokanbaraiketteiJohoHandler(ShokanbaraiketteiJohoDiv div) {
        this.div = div;
    }

    /**
     * 償還払決定一覧情報内容を設定します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param serviceTekyoYM サービス提供年月
     * @param seiriNo 整理番号
     * @param gyomuKbn 業務区分
     * @param mode モード
     */
    public void initialize(HihokenshaNo hihokenshaNo, FlexibleYearMonth serviceTekyoYM, RString seiriNo, RString gyomuKbn, RString mode) {
        SyokanbaraiketteJohoManager manager = SyokanbaraiketteJohoManager.createInstance();
        KetteJoho 決定情報 = manager.getKetteJoho(hihokenshaNo, serviceTekyoYM, seiriNo, gyomuKbn);
        Decimal 上限金額 = Decimal.ZERO;
        if (GYOKUKBN_住宅改修.equals(gyomuKbn) || GYOKUKBN_福祉用具販売費.equals(gyomuKbn)) {
            ShokanShinsei 償還払支給申請情報 = manager.getShokanShinsei(hihokenshaNo, serviceTekyoYM, seiriNo);
            if (償還払支給申請情報 == null) {
                上限金額 = JutakuKaishuJizenShinsei.createInstance().getShikyuGendoGaku(hihokenshaNo, serviceTekyoYM);
            } else {
                上限金額 = 償還払支給申請情報.get保険対象費用額();
            }
        }
        init(get償還払決定一覧情報(hihokenshaNo, serviceTekyoYM, seiriNo, gyomuKbn),
                manager.getShashitomeKojyoKubun(mode, hihokenshaNo, serviceTekyoYM, seiriNo),
                決定情報, mode, 上限金額, gyomuKbn);
        ViewStateHolder.put(ViewStateKeys.決定情報, 決定情報);
    }

    /**
     * 支給区分の変更連動を処理します。
     */
    public void onChange_rdoShikyukubun() {
        set決定情報(ViewStateHolder.get(ViewStateKeys.決定情報, KetteJoho.class), div.getRdoShikyukubun().getSelectedKey());
    }

    /**
     * データグリッドの差額金額を合計して、差額支払金額合計に設定します。
     */
    public void onChange_defaultDataName6() {
        Decimal 差額支払金額合計 = new Decimal(0);
        for (dgSyokanbaraikete_Row row : div.getDgSyokanbaraikete().getDataSource()) {
            if (row.getSagakuKingaku().getValue() != null) {
                差額支払金額合計 = 差額支払金額合計.add(row.getSagakuKingaku().getValue());
            }
        }
        div.getTxtSagakuGoke().setValue(差額支払金額合計);
    }

    private void init(List<SyokanbaraiketteJoho> 償還払決定一覧情報, RString 差止控除区分,
            KetteJoho 決定情報, RString mode, Decimal 上限金額, RString gyomuKbn) {
        boolean 差額登録フラグ = false;
        if (モード_修正.equals(mode) && (差止控除区分_20.equals(差止控除区分) || 差止控除区分_21.equals(差止控除区分))) {
            差額登録フラグ = true;
        }
        div.getDgSyokanbaraikete().setDataSource(set償還払決定一覧情報(差額登録フラグ, 償還払決定一覧情報, gyomuKbn, 上限金額));
        RString 支給区分 = null;
        if (決定情報 == null) {
            div.getTxtKetebi().setValue(RDate.getNowDate());
            setState(支給区分_支給);
            div.getRdoShikyukubun().setDisabled(false);
            div.getRdoShikyukubun().setSelectedKey(支給区分_支給);
            div.getTxtShiharaikingakugoke().setValue(ViewStateHolder.get(ViewStateKeys.支払金額合計, Decimal.class));
            div.getTxtZogentani().setValue(Decimal.ZERO);
        } else {
            支給区分 = 決定情報.getShikyuHushikyuKetteiKubun();
            if (RString.isNullOrEmpty(支給区分) || 差額登録フラグ) {
                支給区分 = 支給区分_支給;
            }
            set決定情報(決定情報, 支給区分);
            if (isFlexibleDateNullOrEmpty(決定情報.getKetteiYMD())) {
                div.getTxtKetebi().setValue(RDate.getNowDate());
            } else {
                div.getTxtKetebi().setValue(new RDate(決定情報.getKetteiYMD().toString()));
            }
            div.getRdoShikyukubun().setSelectedKey(支給区分);
            if (!isFlexibleDateNullOrEmpty(決定情報.getKetteiTsuchishoSakuseiYMD())) {
                div.getTxtKetteiTsuchiSakuseiYMD().setValue(new RDate(決定情報.getKetteiTsuchishoSakuseiYMD().toString()));
            }
            if (決定情報.getKetteiTsuchiNo() != null && !RString.EMPTY.equals(決定情報.getKetteiTsuchiNo())) {
                div.getTxtKetteiTsuchiNo().setValue(new Decimal(決定情報.getKetteiTsuchiNo().toString()));
            }
            if (!isFlexibleDateNullOrEmpty(決定情報.getFurikomiMeisaishoSakuseiYMD())) {
                div.getTxtFurikomiMeisaiSakuseiYMD().setValue(new RDate(決定情報.getFurikomiMeisaishoSakuseiYMD().toString()));
            }
        }
        if (差止控除区分_10.equals(差止控除区分) || モード_照会.equals(mode)) {
            setState(支給区分);
            div.getTxtKetebi().setDisabled(true);
            div.getRdoShikyukubun().setDisabled(true);
        } else {
            div.getTxtKetebi().setDisabled(false);
        }
        if (差額登録フラグ) {
            div.getRdoShikyukubun().setDisabled(true);
            div.getRdoShikyukubun().setSelectedKey(ShikyuFushikyuKubun.支給.getコード());
        }
        if (モード_照会.equals(mode)) {
            div.getTxtKetebi().setDisabled(true);
            div.getTxtZogenriyu().setDisabled(true);
            div.getTxtFuSyikyuriyu1().setDisabled(true);
            div.getTxtFushikyuriyu2().setDisabled(true);
            div.getRdoShikyukubun().setDisabled(true);
        }
        div.getTxtShiharaikingakugoke().setDisabled(true);
        div.getTxtZogentani().setDisabled(true);
    }

    private boolean isFlexibleDateNullOrEmpty(FlexibleDate date) {
        return null == date || date.isEmpty();
    }

    private List<dgSyokanbaraikete_Row> set償還払決定一覧情報(boolean 差額登録フラグ,
            List<SyokanbaraiketteJoho> 償還払決定一覧情報, RString gyomuKbn, Decimal 上限金額) {
        List<dgSyokanbaraikete_Row> dataRowList = new ArrayList<>();
        Integer index = 1;
        Decimal 差額支払金額合計 = Decimal.ZERO;
        Decimal 支払金額合計 = Decimal.ZERO;
        Decimal 残上限金額 = 上限金額;
        Decimal 保険対象費用額;
//        int count = 1;
        for (SyokanbaraiketteJoho syokanbaraiketteJoho : 償還払決定一覧情報) {
            dgSyokanbaraikete_Row row = new dgSyokanbaraikete_Row();
            row.setNo(syokanbaraiketteJoho.getServiceCode().isEmpty() ? RString.EMPTY : new RString(index.toString()));
            row.setJigyoshaNo(syokanbaraiketteJoho.getJigyoshaNo().value());
            row.setYoshikiNo(syokanbaraiketteJoho.getYoshikiNo());
            row.setShurui(syokanbaraiketteJoho.getServiceCode().value());
            row.setServiceShuruiName(syokanbaraiketteJoho.getServiceName());
            row.setFukushiYoguName(syokanbaraiketteJoho.getFukushiYoguShohinName());
            if (syokanbaraiketteJoho.getKounyuKingaku() != null) {
                row.getTaniKingaku().setValue(new Decimal(syokanbaraiketteJoho.getKounyuKingaku()));
            } else {
                row.getTaniKingaku().setValue(Decimal.ZERO);
            }
            保険対象費用額 = set支払金額(syokanbaraiketteJoho, 残上限金額, row, gyomuKbn);
            残上限金額 = 残上限金額.subtract(保険対象費用額);
            if (syokanbaraiketteJoho.getSagakuKingaku() != null) {
                row.getSagakuKingaku().setValue(new Decimal(syokanbaraiketteJoho.getSagakuKingaku()));
            } else {
                row.getSagakuKingaku().setValue(Decimal.ZERO);
            }
            row.setTableKubun(syokanbaraiketteJoho.getTableKbn());
            row.setDekidakaKubun(syokanbaraiketteJoho.getDekidakaKbn());
            row.setMeisaiNo(syokanbaraiketteJoho.getMeisaiNo());
            row.setRenban(syokanbaraiketteJoho.getRenban());
            row.setUpdateCount(new RString(String.valueOf(syokanbaraiketteJoho.getUpdateCount())));
            if (差額登録フラグ) {
                row.getSagakuKingaku().setDisabled(false);
            } else {
                row.getSagakuKingaku().setDisabled(true);
            }
            if (syokanbaraiketteJoho.getSagakuKingaku() != null) {
                差額支払金額合計 = 差額支払金額合計.add(syokanbaraiketteJoho.getSagakuKingaku());
            }
            if (syokanbaraiketteJoho.getShiharaiKingaku() != null) {
                支払金額合計 = 支払金額合計.add(initDecimal(row.getShiharaiKingaku().getValue()));
            }
            count++;
            dataRowList.add(row);
            if (!syokanbaraiketteJoho.getServiceCode().isEmpty()) {
                index++;
            }
        }
        div.getTxtSagakuGoke().setValue(差額支払金額合計);
        ViewStateHolder.put(ViewStateKeys.支払金額合計, 支払金額合計);
        return dataRowList;
    }

    private Decimal initDecimal(Decimal kingaku) {
        return kingaku == null ? new Decimal(0) : kingaku;
    }

    private void set決定情報(KetteJoho 決定情報, RString 支給区分) {

        if (支給区分_支給.equals(支給区分)) {
            div.getTxtZogenriyu().setDisabled(false);
            div.getTxtFuSyikyuriyu1().setDisabled(true);
            div.getTxtFushikyuriyu2().setDisabled(true);
            if (決定情報 != null && 決定情報.getZougenRiyu() != null) {
                div.getTxtZogenriyu().setValue(決定情報.getZougenRiyu());
            } else {
                div.getTxtZogenriyu().setValue(RString.EMPTY);
            }
            div.getTxtFuSyikyuriyu1().setValue(RString.EMPTY);
            div.getTxtFushikyuriyu2().setValue(RString.EMPTY);
            if (決定情報 != null && 決定情報.getZougenten() != null) {

                div.getTxtZogentani().setValue(new Decimal(決定情報.getZougenten()));
            } else {
                div.getTxtZogentani().setValue(Decimal.ZERO);
            }
            div.getTxtShiharaikingakugoke().setValue(ViewStateHolder.get(ViewStateKeys.支払金額合計, Decimal.class));
        } else if (支給区分_不支給.equals(支給区分)) {
            div.getTxtZogenriyu().setDisabled(true);
            div.getTxtFuSyikyuriyu1().setDisabled(false);
            div.getTxtFushikyuriyu2().setDisabled(false);
            if (決定情報 != null && 決定情報.getHushikyuRiyu() != null) {
                div.getTxtFuSyikyuriyu1().setValue(決定情報.getHushikyuRiyu());
            } else {
                div.getTxtFuSyikyuriyu1().setValue(RString.EMPTY);
            }
            if (決定情報 != null && 決定情報.getKounyuKaishuRireki() != null) {
                div.getTxtFushikyuriyu2().setValue(決定情報.getKounyuKaishuRireki());
            } else {
                div.getTxtFushikyuriyu2().setValue(RString.EMPTY);
            }
            div.getTxtZogenriyu().setValue(RString.EMPTY);
            div.getTxtZogentani().setValue(Decimal.ZERO);
            div.getTxtShiharaikingakugoke().setValue(Decimal.ZERO);
        } else {
            setState(支給区分);
            div.getRdoShikyukubun().setDisabled(false);
        }
    }

    private List<SyokanbaraiketteJoho> get償還払決定一覧情報(HihokenshaNo hiHokenshaNo, FlexibleYearMonth serviceTeikyoYM,
            RString seiriNo, RString gyomuKbn) {

        List<SyokanbaraiketteJoho> 償還払決定一覧情報 = null;
        SyokanbaraiketteJohoManager manager = SyokanbaraiketteJohoManager.createInstance();
        if (GYOKUKBN_住宅改修.equals(gyomuKbn)) {

            償還払決定一覧情報 = manager.getSyokanbaraiketteJyutakuList(hiHokenshaNo, serviceTeikyoYM, seiriNo).records();
            div.getDgSyokanbaraikete().getGridSetting().getColumn("serviceShuruiName").setVisible(true);
            div.getDgSyokanbaraikete().getGridSetting().getColumn("fukushiYoguName").setVisible(false);
            div.getDgSyokanbaraikete().getGridSetting().getColumn("jigyoshaNo").setVisible(false);
        } else if (GYOKUKBN_福祉用具販売費.equals(gyomuKbn)) {

            償還払決定一覧情報 = manager.getSyokanbaraiketteFukushiList(hiHokenshaNo, serviceTeikyoYM, seiriNo).records();
            div.getDgSyokanbaraikete().getGridSetting().getColumn("serviceShuruiName").setVisible(false);
            div.getDgSyokanbaraikete().getGridSetting().getColumn("fukushiYoguName").setVisible(true);
            div.getDgSyokanbaraikete().getGridSetting().getColumn("jigyoshaNo").setVisible(true);
        } else if (GYOKUKBN_償還払い費.equals(gyomuKbn)) {
            償還払決定一覧情報 = new ArrayList<>();
            List<SyokanbaraiketteJoho> temp償還払決定一覧情報
                    = manager.getSyokanbaraiketteSyokanList(hiHokenshaNo, serviceTeikyoYM, seiriNo).records();
            div.getDgSyokanbaraikete().getGridSetting().getColumn("serviceShuruiName").setVisible(true);
            div.getDgSyokanbaraikete().getGridSetting().getColumn("fukushiYoguName").setVisible(false);
            div.getDgSyokanbaraikete().getGridSetting().getColumn("jigyoshaNo").setVisible(true);
            List<RString> yoshikiNoList = new ArrayList<>();
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2141_様式第三.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2142_様式第三.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2143_様式第三.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2144_様式第三の二.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2151_様式第四.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2152_様式第四.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2153_様式第四.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2154_様式第四の二.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2155_様式第四.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2156_様式第四の二.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2161_様式第五.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2162_様式第五.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2163_様式第五.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2164_様式第五.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2165_様式第五の二.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2181_様式第八.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2182_様式第八.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2183_様式第八.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2191_様式第九.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2192_様式第九.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2193_様式第九.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2194_様式第九.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._2195_様式第九.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._21A1_様式第十.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._21A2_様式第十.getコード());
            yoshikiNoList.add(KyufuJissekiYoshikiKubun._21A3_様式第十.getコード());
            for (SyokanbaraiketteJoho joho : temp償還払決定一覧情報) {
                if (!joho.getServiceCode().isEmpty()) {
                    償還払決定一覧情報.add(joho);
                } else if (yoshikiNoList.contains(joho.getYoshikiNo())) {
                    償還払決定一覧情報.add(joho);
                }
            }
        }
        return 償還払決定一覧情報;
    }

    private void setState(RString 支給区分) {
        div.getTxtZogenriyu().setDisabled(true);
        div.getTxtFuSyikyuriyu1().setDisabled(true);
        div.getTxtFushikyuriyu2().setDisabled(true);
        if (支給区分 == null) {
            div.getTxtZogenriyu().setValue(RString.EMPTY);
            div.getTxtZogentani().setValue(Decimal.ZERO);
            div.getTxtShiharaikingakugoke().setValue(Decimal.ZERO);
            div.getRdoShikyukubun().setDisabled(false);
            div.getTxtFuSyikyuriyu1().setValue(RString.EMPTY);
            div.getTxtFushikyuriyu2().setValue(RString.EMPTY);
        } else if (支給区分_支給.equals(支給区分)) {
            div.getTxtZogenriyu().setDisabled(false);
            div.getTxtFuSyikyuriyu1().setDisabled(true);
            div.getTxtFushikyuriyu2().setDisabled(true);
        } else {
            div.getRdoShikyukubun().setDisabled(true);
        }
    }

    private Decimal set支払金額(SyokanbaraiketteJoho syokanbaraiketteJoho,
            Decimal 残上限金額, dgSyokanbaraikete_Row row, RString mode) {
        Decimal 単位金額 = Decimal.ZERO;
        if (syokanbaraiketteJoho.getKounyuKingaku() != null) {
            単位金額 = new Decimal(syokanbaraiketteJoho.getKounyuKingaku());
        }
        Decimal 保険対象費用額 = Decimal.ZERO;
        if (GYOKUKBN_償還払い費.equals(mode)) {
            if (syokanbaraiketteJoho.getShiharaiKingaku() != null) {
                row.getShiharaiKingaku().setValue(syokanbaraiketteJoho.getShiharaiKingaku());
            } else {
                row.getShiharaiKingaku().setValue(Decimal.ZERO);
            }
        } else if (残上限金額.compareTo(Decimal.ZERO) <= 0 || syokanbaraiketteJoho.get給付率() == null) {
            row.getShiharaiKingaku().setValue(Decimal.ZERO);
        } else if (単位金額.compareTo(残上限金額) < 0) {
            保険対象費用額 = 単位金額;
            row.getShiharaiKingaku().setValue(単位金額.multiply(syokanbaraiketteJoho.get給付率().divide(数字_100)).roundDownTo(0));
        } else {
            保険対象費用額 = 残上限金額;
            row.getShiharaiKingaku().setValue(残上限金額.multiply(syokanbaraiketteJoho.get給付率().divide(数字_100)).roundDownTo(0));
        }
        return 保険対象費用額;
    }
}
