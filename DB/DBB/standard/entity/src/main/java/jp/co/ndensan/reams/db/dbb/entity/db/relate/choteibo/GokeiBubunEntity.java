/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 合計部分一時テーブルEntityです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GokeiBubunEntity implements IDbAccessable {

    private RString choshuHouhou;
    private int dogetsuFlag;
    private RString dankai;
    private RString karisanFlag;
    private Decimal choteigaku4GatsuCount;
    private Decimal choteigaku5GatsuCount;
    private Decimal choteigaku6GatsuCount;
    private Decimal choteigaku7GatsuCount;
    private Decimal choteigaku8GatsuCount;
    private Decimal choteigaku9GatsuCount;
    private Decimal choteigaku10GatsuCount;
    private Decimal choteigaku11GatsuCount;
    private Decimal choteigaku12GatsuCount;
    private Decimal choteigaku1GatsuCount;
    private Decimal choteigaku2GatsuCount;
    private Decimal choteigaku3GatsuCount;
    private Decimal choteigaku4GatsuCountYoku;
    private Decimal choteigaku5GatsuCountYoku;
    private Decimal zengetsusueKensuCount;
    private Decimal zengetsusueChoteigakuCount;
    private Decimal fueKensuCount;
    private Decimal fueChoteigakuCount;
    private Decimal genKensuCount;
    private Decimal genChoteigakuCount;
    private Decimal dogetsusueKensuCount;
    private Decimal dogetsusueChoteigakuCount;
    private Decimal tokuchosyaKensuCount;
    private Decimal fuchosyaKensuCount;
    private Decimal naiheisyaKensuCount;

    /**
     * ○月の調定額の小計を集計する。
     *
     * @param 月別 月別
     * @param 調定額の小計 調定額の小計
     */
    public void add月の調定額の小計By月別(Tsuki 月別, Decimal 調定額の小計) {
        調定額の小計 = (調定額の小計 == null) ? Decimal.ZERO : 調定額の小計;
        if (Tsuki._1月.equals(月別)) {
            choteigaku1GatsuCount = add(choteigaku1GatsuCount, 調定額の小計);
        } else if (Tsuki._2月.equals(月別)) {
            choteigaku2GatsuCount = add(choteigaku2GatsuCount, 調定額の小計);
        } else if (Tsuki._3月.equals(月別)) {
            choteigaku3GatsuCount = add(choteigaku3GatsuCount, 調定額の小計);
        } else if (Tsuki._4月.equals(月別)) {
            choteigaku4GatsuCount = add(choteigaku4GatsuCount, 調定額の小計);
        } else if (Tsuki._5月.equals(月別)) {
            choteigaku5GatsuCount = add(choteigaku5GatsuCount, 調定額の小計);
        } else if (Tsuki._6月.equals(月別)) {
            choteigaku6GatsuCount = add(choteigaku6GatsuCount, 調定額の小計);
        } else if (Tsuki._7月.equals(月別)) {
            choteigaku7GatsuCount = add(choteigaku7GatsuCount, 調定額の小計);
        } else if (Tsuki._8月.equals(月別)) {
            choteigaku8GatsuCount = add(choteigaku8GatsuCount, 調定額の小計);
        } else if (Tsuki._9月.equals(月別)) {
            choteigaku9GatsuCount = add(choteigaku9GatsuCount, 調定額の小計);
        } else if (Tsuki._10月.equals(月別)) {
            choteigaku10GatsuCount = add(choteigaku10GatsuCount, 調定額の小計);
        } else if (Tsuki._11月.equals(月別)) {
            choteigaku11GatsuCount = add(choteigaku11GatsuCount, 調定額の小計);
        } else if (Tsuki._12月.equals(月別)) {
            choteigaku12GatsuCount = add(choteigaku12GatsuCount, 調定額の小計);
        } else if (Tsuki.翌年度4月.equals(月別)) {
            choteigaku4GatsuCountYoku = add(choteigaku4GatsuCountYoku, 調定額の小計);
        } else if (Tsuki.翌年度5月.equals(月別)) {
            choteigaku5GatsuCountYoku = add(choteigaku5GatsuCountYoku, 調定額の小計);
        }
    }

    private Decimal add(Decimal val1, Decimal val2) {
        val1 = (val1 == null) ? Decimal.ZERO : val1;
        val2 = (val2 == null) ? Decimal.ZERO : val2;
        return val1.add(val2);
    }
}
