/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給決定情報取込のヘッダ部。
 */
public class ShokanShikyuKetteiInHeaderCSVEntity {

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
     * 交換情報識別番号を取得する。
     *
     * @return the 交換情報識別番号
     */
    public RString get交換情報識別番号() {
        return 交換情報識別番号;
    }

    /**
     * 帳票レコード種別を取得する。
     *
     * @return the 帳票レコード種別
     */
    public RString get帳票レコード種別() {
        return 帳票レコード種別;
    }

    /**
     * 証記載保険者番号を取得する。
     *
     * @return the 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * 保険者名を取得する。
     *
     * @return the 保険者名
     */
    public RString get保険者名() {
        return 保険者名;
    }

    /**
     * 作成年月日を取得する。
     *
     * @return the 作成年月日
     */
    public RString get作成年月日() {
        return 作成年月日;
    }

    /**
     * 国保連合会名を取得する。
     *
     * @return the 国保連合会名
     */
    public RString get国保連合会名() {
        return 国保連合会名;
    }

    /**
     * 交換情報識別番号を取得する。
     *
     * @param 交換情報識別番号 the 交換情報識別番号 to set
     */
    public void set交換情報識別番号(RString 交換情報識別番号) {
        this.交換情報識別番号 = 交換情報識別番号;
    }

    /**
     * 帳票レコード種別を設定する。
     *
     * @param 帳票レコード種別 the 帳票レコード種別 to set
     */
    public void set帳票レコード種別(RString 帳票レコード種別) {
        this.帳票レコード種別 = 帳票レコード種別;
    }

    /**
     * 証記載保険者番号を設定する。
     *
     * @param 証記載保険者番号 the 証記載保険者番号 to set
     */
    public void set証記載保険者番号(RString 証記載保険者番号) {
        this.証記載保険者番号 = 証記載保険者番号;
    }

    /**
     * 保険者名を設定する。
     *
     * @param 保険者名 the 保険者名 to set
     */
    public void set保険者名(RString 保険者名) {
        this.保険者名 = 保険者名;
    }

    /**
     * 作成年月日を設定する。
     *
     * @param 作成年月日 the 作成年月日 to set
     */
    public void set作成年月日(RString 作成年月日) {
        this.作成年月日 = 作成年月日;
    }

    /**
     * 国保連合会名を設定する。
     *
     * @param 国保連合会名 the 国保連合会名 to set
     */
    public void set国保連合会名(RString 国保連合会名) {
        this.国保連合会名 = 国保連合会名;
    }

}
