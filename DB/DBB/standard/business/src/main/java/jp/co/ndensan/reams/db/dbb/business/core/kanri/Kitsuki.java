/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kanri;

import jp.co.ndensan.reams.db.dbb.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 期月です。
 */
public class Kitsuki {

    private Tsuki 月;
    private RString 期;
    //月処理区分
    private boolean 実在フラグ;

    //期月表記
    public int get期AsInt() {
        int 期 = Integer.parseInt(this.期.toString());
        return 期;
    }

    public RString get期() {
        return this.期;
    }

    public int get月AsInt() {
        int 月 = Integer.parseInt(this.月.getコード().toString());
        return 月;
    }

    public Tsuki get月() {
        return this.月;
    }

    public RString get表記() {
        return null;
    }

    public RString get月処理区分() {
        return null;
    }

    public boolean isPresent() {
        return this.実在フラグ;
    }

}
