/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績の基本情報（公費）を保持するクラスです。
 *
 * @author N8223 朴 義一
 */
public class KyufuJissekiKihonKohi {

    private final RString 公費１負担者番号;
    private final RString 公費１受給者番号;
    private final RString 公費２負担者番号;
    private final RString 公費２受給者番号;
    private final RString 公費３負担者番号;
    private final RString 公費３受給者番号;

    /**
     * インスタンスを生成します。
     *
     * @param 公費１負担者番号 公費１負担者番号
     * @param 公費１受給者番号 公費１受給者番号
     * @param 公費２負担者番号 公費２負担者番号
     * @param 公費２受給者番号 公費２受給者番号
     * @param 公費３負担者番号 公費３負担者番号
     * @param 公費３受給者番号 公費３受給者番号
     */
    public KyufuJissekiKihonKohi(
            RString 公費１負担者番号,
            RString 公費１受給者番号,
            RString 公費２負担者番号,
            RString 公費２受給者番号,
            RString 公費３負担者番号,
            RString 公費３受給者番号) {
        this.公費１負担者番号 = 公費１負担者番号;
        this.公費１受給者番号 = 公費１受給者番号;
        this.公費２負担者番号 = 公費２負担者番号;
        this.公費２受給者番号 = 公費２受給者番号;
        this.公費３負担者番号 = 公費３負担者番号;
        this.公費３受給者番号 = 公費３受給者番号;
    }

    /**
     * 公費１負担者番号を返します。
     *
     * @return 公費１負担者番号
     */
    public RString get公費１負担者番号() {
        return 公費１負担者番号;
    }

    /**
     * 公費１受給者番号を返します。
     *
     * @return 公費１
     */
    public RString get公費１受給者番号() {
        return 公費１受給者番号;
    }

    /**
     * 公費２負担者番号を返します。
     *
     * @return 公費２負担者番号
     */
    public RString get公費２負担者番号() {
        return 公費２負担者番号;
    }

    /**
     * 公費２受給者番号を返します。
     *
     * @return 公費２受給者番号
     */
    public RString get公費２受給者番号() {
        return 公費２受給者番号;
    }

    /**
     * 公費３負担者番号を返します。
     *
     * @return 公費３負担者番号
     */
    public RString get公費３負担者番号() {
        return 公費３負担者番号;
    }

    /**
     * 公費３受給者番号を返します。
     *
     * @return 公費３受給者番号
     */
    public RString get公費３受給者番号() {
        return 公費３受給者番号;
    }
}
