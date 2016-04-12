/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払不支給決定情報のヘッダ部。
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public class ShokanFushikyuKetteiInHeaderCSVEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 30, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 60, name = "国保連合会名")
    private RString 国保連合会名;

    /**
     * get交換情報識別番号
     *
     * @return 交換情報識別番号
     */
    public RString get交換情報識別番号() {
        return 交換情報識別番号;
    }

    /**
     * get帳票レコード種別
     *
     * @return 帳票レコード種別
     */
    public RString get帳票レコード種別() {
        return 帳票レコード種別;
    }

    /**
     * get証記載保険者番号
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * get保険者名
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return 保険者名;
    }

    /**
     * get作成年月日
     *
     * @return 作成年月日
     */
    public RString get作成年月日() {
        return 作成年月日;
    }

    /**
     * get国保連合会名
     *
     * @return 国保連合会名
     */
    public RString get国保連合会名() {
        return 国保連合会名;
    }

    /**
     * set交換情報識別番号
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public void set交換情報識別番号(RString 交換情報識別番号) {
        this.交換情報識別番号 = 交換情報識別番号;
    }

    /**
     * set帳票レコード種別
     *
     * @param 帳票レコード種別 帳票レコード種別
     */
    public void set帳票レコード種別(RString 帳票レコード種別) {
        this.帳票レコード種別 = 帳票レコード種別;
    }

    /**
     * set証記載保険者番号
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(RString 証記載保険者番号) {
        this.証記載保険者番号 = 証記載保険者番号;
    }

    /**
     * set保険者名
     *
     * @param 保険者名 保険者名
     */
    public void set保険者名(RString 保険者名) {
        this.保険者名 = 保険者名;
    }

    /**
     * set作成年月日
     *
     * @param 作成年月日 作成年月日
     */
    public void set作成年月日(RString 作成年月日) {
        this.作成年月日 = 作成年月日;
    }

    /**
     * set国保連合会名
     *
     * @param 国保連合会名 国保連合会名
     */
    public void set国保連合会名(RString 国保連合会名) {
        this.国保連合会名 = 国保連合会名;
    }

}
