/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.koikijushochi;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広住特者住民コードSQL取得のビジュネスクラス
 */
public class KoikinaiJutokuTaishoshaSql {

    private RString 対象者SQL1;

    private RString 対象者SQL2;

    /**
     * 対象者SQL1を返します
     *
     * @return 対象者SQL1
     */
    public RString get対象者SQL1() {
        return 対象者SQL1;
    }

    /**
     * 対象者SQL1のsetメソッドです
     *
     * @param 対象者SQL1 RString
     */
    public void set対象者SQL1(RString 対象者SQL1) {
        this.対象者SQL1 = 対象者SQL1;
    }

    /**
     * 対象者SQL2を返します
     *
     * @return 対象者SQL2
     */
    public RString get対象者SQL2() {
        return 対象者SQL2;
    }

    /**
     * 対象者SQL2のsetメソッドです
     *
     * @param 対象者SQL2 RString
     */
    public void set対象者SQL2(RString 対象者SQL2) {
        this.対象者SQL2 = 対象者SQL2;
    }
}
