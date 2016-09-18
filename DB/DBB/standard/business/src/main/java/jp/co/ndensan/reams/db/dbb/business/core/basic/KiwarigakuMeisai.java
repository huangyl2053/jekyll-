/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 期割額の明細情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KiwarigakuMeisai implements Serializable {

    private final KibetsuChoteiKyotsu 期別調定共通;
    private final Decimal 収入額;

    /**
     * コンストラクタです。
     *
     * @param 期別調定共通 期別調定共通
     * @param 収入額 収入額
     */
    public KiwarigakuMeisai(KibetsuChoteiKyotsu 期別調定共通, Decimal 収入額) {
        this.期別調定共通 = 期別調定共通;
        this.収入額 = 収入額;
    }

    /**
     * 期別調定共通を返します。
     *
     * @return 期別調定共通
     */
    @Deprecated
    public KibetsuChoteiKyotsu get期別調定共通() {
        return 期別調定共通;
    }

    /**
     * 期を返します。
     *
     * @return 期
     */
    public int get期() {
        return this.期別調定共通.get介護期別モデル().get期();
    }

    /**
     * 調定額を返します。
     *
     * @return 調定額
     */
    public Decimal get調定額() {
        return this.期別調定共通.get調定共通モデル().get調定額();
    }

    /**
     *
     * @return
     */
    public RString get調定額表記() {
        return composedカンマ編集OrEmpty(this.get調定額());
    }

    private static RString composedカンマ編集OrEmpty(Decimal value) {
        return value == null ? RString.EMPTY : new RString(value.toString("#,##0"));
    }

    /**
     * 収入額を返します。
     *
     * @return 収入額
     */
    public Decimal get収入額() {
        return 収入額;
    }

    /**
     *
     * @return
     */
    public RString get収入額表記() {
        return composedカンマ編集OrEmpty(this.get収入額());
    }

    /**
     * 徴収方法を返します。
     *
     * @return 徴収方法
     */
    public ChoshuHohoKibetsu get徴収方法() {
        return ChoshuHohoKibetsu.toValue(this.期別調定共通.get介護期別モデル().get徴収方法());
    }
}
