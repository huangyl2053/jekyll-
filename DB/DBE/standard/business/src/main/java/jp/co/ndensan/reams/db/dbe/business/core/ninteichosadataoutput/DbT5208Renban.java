/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DbT5208テーブルの連番の列挙体クラスです。
 */
public enum DbT5208Renban {

    /**
     * サービスの状況フラグ連番01
     */
    サービスの状況フラグ連番01(1);

    private final int renban;

    private DbT5208Renban(int renban) {
        this.renban = renban;
    }

    /**
     * 連番を取得します。
     *
     * @return 連番
     */
    public RString get連番() {
        return new RString(renban);
    }
}
