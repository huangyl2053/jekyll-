/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績の基本情報（合計）を保持するクラス
 *
 * @author n8223
 */
public class KyufuJissekiKihonGokei {

    private final RString 保険公費;
    private final RString 前後;
    private final Decimal サービス単位;
    private final Decimal 保険料請求額;
    private final Decimal 利用者負担額;
    private final Decimal 緊急時施設療養費保険請求分合計;
    private final Decimal 特定診療費公費請求分合計;
    private final Decimal 特定入所者介護等請求額;

    /**
     * コンストラクタです。
     *
     * @param 保険公費
     * @param 前後
     * @param サービス単位
     * @param 保険料請求額
     * @param 利用者負担額
     * @param 緊急時施設療養費保険請求分合計
     * @param 特定診療費公費請求分合計
     * @param 特定入所者介護等請求額
     */
    public KyufuJissekiKihonGokei(RString 保険公費, RString 前後, Decimal サービス単位, Decimal 保険料請求額, Decimal 利用者負担額, Decimal 緊急時施設療養費保険請求分合計, Decimal 特定診療費公費請求分合計, Decimal 特定入所者介護等請求額) {

        this.保険公費 = 保険公費;
        this.前後 = 前後;
        this.サービス単位 = サービス単位;
        this.保険料請求額 = 保険料請求額;
        this.利用者負担額 = 利用者負担額;
        this.緊急時施設療養費保険請求分合計 = 緊急時施設療養費保険請求分合計;
        this.特定診療費公費請求分合計 = 特定診療費公費請求分合計;
        this.特定入所者介護等請求額 = 特定入所者介護等請求額;

    }

    /**
     * 保険公費を返します。
     *
     * @return
     */
    public RString get保険公費() {
        return 保険公費;
    }

    /**
     * 前後を返します。
     *
     * @return 前後
     */
    public RString get前後() {
        return 前後;
    }

    /**
     * サービス単位を返します。
     *
     * @return サービス単位
     */
    public Decimal getサービス単位() {
        return サービス単位;
    }

    /**
     * 保険料請求額を返します。
     *
     * @return
     */
    public Decimal get保険料請求額() {
        return 保険料請求額;
    }

    /**
     * 利用者負担額を返します。
     *
     * @return
     */
    public Decimal get利用者負担額() {
        return 利用者負担額;
    }

    /**
     * 緊急時施設療養費保険請求分合計を返します。
     *
     * @return
     */
    public Decimal get緊急時施設療養費保険請求分合計() {
        return 緊急時施設療養費保険請求分合計;
    }

    /**
     * 特定診療費公費請求分合計を返します。
     *
     * @return
     */
    public Decimal get特定診療費公費請求分合計() {
        return 特定診療費公費請求分合計;
    }

    /**
     * 特定入所者介護等請求額を返します。
     *
     * @return
     */
    public Decimal get特定入所者介護等請求額() {
        return 特定入所者介護等請求額;
    }

}
