/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.KetteJoho;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraikettejoho.SyokanbaraiketteJoho;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraikettejoho.SyokanbaraiketteJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 償還払決定一覧のHandlerクラスです。
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
        init(get償還払決定一覧情報(hihokenshaNo, serviceTekyoYM, seiriNo, gyomuKbn),
                manager.getShashitomeKojyoKubun(mode, hihokenshaNo, serviceTekyoYM, seiriNo),
                決定情報, mode);
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
            if (row.getDefaultDataName6().getValue() != null) {
                差額支払金額合計 = 差額支払金額合計.add(row.getDefaultDataName6().getValue());
            }
        }
        div.getTxtSagakuGoke().setValue(差額支払金額合計);
    }

    private void init(List<SyokanbaraiketteJoho> 償還払決定一覧情報, RString 差止控除区分, KetteJoho 決定情報, RString mode) {
        boolean 差額登録フラグ = false;
        if (モード_修正.equals(mode) && (差止控除区分_20.equals(差止控除区分) || 差止控除区分_21.equals(差止控除区分))) {
            差額登録フラグ = true;
        }
        div.getDgSyokanbaraikete().setDataSource(set償還払決定一覧情報(差額登録フラグ, 償還払決定一覧情報));
        RString 支給区分 = null;
        if (決定情報 == null) {
            div.getTxtKetebi().setValue(RDate.getNowDate());
            setState(支給区分);
            div.getRdoShikyukubun().setDisabled(false);
        } else {
            支給区分 = 決定情報.getShikyuHushikyuKetteiKubun();
            set決定情報(決定情報, 支給区分);
            if (決定情報.getKetteiYMD() == null) {
                div.getTxtKetebi().setValue(RDate.getNowDate());
            } else {
                div.getTxtKetebi().setValue(new RDate(決定情報.getKetteiYMD().toString()));
            }
            if (支給区分 != null && !RString.EMPTY.equals(支給区分)) {
                div.getRdoShikyukubun().setSelectedKey(決定情報.getShikyuHushikyuKetteiKubun());
            }
        }
        if (差止控除区分_10.equals(差止控除区分) || モード_照会.equals(mode)) {
            setState(支給区分);
            div.getTxtKetebi().setDisabled(true);
            div.getRdoShikyukubun().setDisabled(true);
        } else {
            div.getTxtKetebi().setDisabled(false);
        }
    }

    private List<dgSyokanbaraikete_Row> set償還払決定一覧情報(boolean 差額登録フラグ, List<SyokanbaraiketteJoho> 償還払決定一覧情報) {
        List<dgSyokanbaraikete_Row> dataRowList = new ArrayList<>();
        Integer index = 1;
        Decimal 差額支払金額合計 = new Decimal(0);
        Decimal 支払金額合計 = new Decimal(0);
        for (SyokanbaraiketteJoho syokanbaraiketteJoho : 償還払決定一覧情報) {
            dgSyokanbaraikete_Row row = new dgSyokanbaraikete_Row();
            row.setDefaultDataName0(new RString(index.toString()));
            row.setDefaultDataName7(syokanbaraiketteJoho.getJigyoshaNo().value());
            row.setDefaultDataName8(syokanbaraiketteJoho.getYoshikiNo());
            row.setDefaultDataName1(syokanbaraiketteJoho.getServiceCode().value());
            row.setDefaultDataName2(syokanbaraiketteJoho.getServiceName());
            row.setDefaultDataName3(syokanbaraiketteJoho.getFukushiYoguShohinName());
            if (syokanbaraiketteJoho.getKounyuKingaku() != null) {

                row.getDefaultDataName4().setValue(new Decimal(syokanbaraiketteJoho.getKounyuKingaku()));
            } else {
                row.getDefaultDataName4().setValue(Decimal.ZERO);
            }
            if (syokanbaraiketteJoho.getShiharaiKingaku() != null) {

                row.getDefaultDataName5().setValue(new Decimal(syokanbaraiketteJoho.getShiharaiKingaku()));
            } else {
                row.getDefaultDataName5().setValue(Decimal.ZERO);
            }
            if (syokanbaraiketteJoho.getSagakuKingaku() != null) {

                row.getDefaultDataName6().setValue(new Decimal(syokanbaraiketteJoho.getSagakuKingaku()));
            } else {
                row.getDefaultDataName6().setValue(Decimal.ZERO);
            }
            row.setTableKbn(syokanbaraiketteJoho.getTableKbn());
            row.setDekidakaKbn(syokanbaraiketteJoho.getDekidakaKbn());
            row.setMeisaiNo(syokanbaraiketteJoho.getMeisaiNo());
            row.setRenban(syokanbaraiketteJoho.getRenban());
            if (差額登録フラグ) {
                row.getDefaultDataName6().setDisabled(false);
            } else {
                row.getDefaultDataName6().setDisabled(true);
            }
            if (syokanbaraiketteJoho.getSagakuKingaku() != null) {

                差額支払金額合計 = 差額支払金額合計.add(syokanbaraiketteJoho.getSagakuKingaku());
            }
            if (syokanbaraiketteJoho.getShiharaiKingaku() != null) {

                支払金額合計 = 支払金額合計.add(syokanbaraiketteJoho.getShiharaiKingaku());
            }
            dataRowList.add(row);
            index++;
        }
        div.getTxtSagakuGoke().setValue(差額支払金額合計);
        ViewStateHolder.put(ViewStateKeys.償還払決定一覧_支払金額合計, 支払金額合計);
        return dataRowList;
    }

    private void set決定情報(KetteJoho 決定情報, RString 支給区分) {
        if (決定情報 != null && 決定情報.getShiharaiKingaku() == null) {
            if (支給区分_不支給.equals(支給区分)) {
                div.getTxtShiharaikingakugoke().setValue(Decimal.ZERO);
            } else {
                div.getTxtShiharaikingakugoke().setValue(ViewStateHolder.get(ViewStateKeys.償還払決定一覧_支払金額合計, Decimal.class));
            }
        } else if (決定情報 != null && 決定情報.getShiharaiKingaku() != null) {
            div.getTxtShiharaikingakugoke().setValue(new Decimal(決定情報.getShiharaiKingaku()));
        }

        if (支給区分_支給.equals(支給区分)) {
            div.getTxtZogenriyu().setDisabled(false);
            div.getTxtZogentani().setDisabled(false);
            div.getTxtShiharaikingakugoke().setDisabled(false);
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
        } else if (支給区分_不支給.equals(支給区分)) {
            div.getTxtZogenriyu().setDisabled(true);
            div.getTxtZogentani().setDisabled(true);
            div.getTxtShiharaikingakugoke().setDisabled(true);
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
            div.getDgSyokanbaraikete().getGridSetting().getColumn("defaultDataName2").setVisible(true);
            div.getDgSyokanbaraikete().getGridSetting().getColumn("defaultDataName3").setVisible(false);
        } else if (GYOKUKBN_福祉用具販売費.equals(gyomuKbn)) {

            償還払決定一覧情報 = manager.getSyokanbaraiketteFukushiList(hiHokenshaNo, serviceTeikyoYM, seiriNo).records();
            div.getDgSyokanbaraikete().getGridSetting().getColumn("defaultDataName2").setVisible(false);
            div.getDgSyokanbaraikete().getGridSetting().getColumn("defaultDataName3").setVisible(true);
        } else if (GYOKUKBN_償還払い費.equals(gyomuKbn)) {

            償還払決定一覧情報 = manager.getSyokanbaraiketteSyokanList(hiHokenshaNo, serviceTeikyoYM, seiriNo).records();
            div.getDgSyokanbaraikete().getGridSetting().getColumn("defaultDataName2").setVisible(true);
            div.getDgSyokanbaraikete().getGridSetting().getColumn("defaultDataName3").setVisible(false);
        }
        return 償還払決定一覧情報;
    }

    private void setState(RString 支給区分) {
        div.getTxtZogenriyu().setDisabled(true);
        div.getTxtZogentani().setDisabled(true);
        div.getTxtShiharaikingakugoke().setDisabled(true);
        div.getTxtFuSyikyuriyu1().setDisabled(true);
        div.getTxtFushikyuriyu2().setDisabled(true);
        if (支給区分 == null) {
            div.getTxtZogenriyu().setValue(RString.EMPTY);
            div.getTxtZogentani().setValue(Decimal.ZERO);
            div.getTxtShiharaikingakugoke().setValue(Decimal.ZERO);
            div.getRdoShikyukubun().setDisabled(false);
            div.getTxtFuSyikyuriyu1().setValue(RString.EMPTY);
            div.getTxtFushikyuriyu2().setValue(RString.EMPTY);
        } else {
            div.getRdoShikyukubun().setDisabled(true);
        }
    }
}
