/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 合計部分一時テーブルEntityです
 */
@lombok.Getter
@lombok.Setter
public class GokeiBubunEntity implements IDbAccessable {

    /**
     * 徴収方法
     */
    private RString choshuHouhou;
    /**
     * 当月フラグ
     */
    private int dogetsuFlag;
    /**
     * 段階
     */
    private RString dankai;
    /**
     * 4月の調定額の小計
     */
    private Decimal choteigaku4GatsuCount;
    /**
     * 5月の調定額の小計
     */
    private Decimal choteigaku5GatsuCount;
    /**
     * 6月の調定額の小計
     */
    private Decimal choteigaku6GatsuCount;
    /**
     * 7月の調定額の小計
     */
    private Decimal choteigaku7GatsuCount;
    /**
     * 8月の調定額の小計
     */
    private Decimal choteigaku8GatsuCount;
    /**
     * 9月の調定額の小計
     */
    private Decimal choteigaku9GatsuCount;
    /**
     * 10月の調定額の小計
     */
    private Decimal choteigaku10GatsuCount;
    /**
     * 11月の調定額の小計
     */
    private Decimal choteigaku11GatsuCount;
    /**
     * 12月の調定額の小計
     */
    private Decimal choteigaku12GatsuCount;
    /**
     * 1月の調定額の小計
     */
    private Decimal choteigaku1GatsuCount;
    /**
     * 2月の調定額の小計
     */
    private Decimal choteigaku2GatsuCount;
    /**
     * 3月の調定額の小計
     */
    private Decimal choteigaku3GatsuCount;
    /**
     * 4月の調定額の小計(翌)
     */
    private Decimal choteigaku4GatsuCountYoku;
    /**
     * 5月の調定額の小計(翌)
     */
    private Decimal choteigaku5GatsuCountYoku;
    /**
     * 該当する段階の前月末の件数の小計
     */
    private Decimal zengetsusueKensuCount;
    /**
     * 該当する段階の前月末の調定額の小計
     */
    private Decimal zengetsusueChoteigakuCount;
    /**
     * 該当する段階の増の件数の小計
     */
    private Decimal fueKensuCount;
    /**
     * 該当する段階の増の調定額の小計
     */
    private Decimal fueChoteigakuCount;
    /**
     * 該当する段階の減の件数の小計
     */
    private Decimal genKensuCount;
    /**
     * 該当する段階の減の調定額の小計
     */
    private Decimal genChoteigakuCount;
    /**
     * 該当する段階の当月末の件数の小計
     */
    private Decimal dogetsusueKensuCount;
    /**
     * 該当する段階の当月末の調定額の小計
     */
    private Decimal dogetsusueChoteigakuCount;
    /**
     * 該当する段階の特徴者数の件数の小計
     */
    private Decimal tokuchosyaKensuCount;
    /**
     * 該当する段階の普徴者数の件数の小計
     */
    private Decimal fuchosyaKensuCount;
    /**
     * 該当する段階の内併徴者数の件数の小計
     */
    private Decimal naiheisyaKensuCount;
}
