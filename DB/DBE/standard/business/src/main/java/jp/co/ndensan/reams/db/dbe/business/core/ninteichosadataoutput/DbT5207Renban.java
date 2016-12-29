/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DbT5207テーブルの連番の列挙体クラスです。
 */
public enum DbT5207Renban {

    /**
     * サービスの状況連番01
     */
    サービスの状況連番01(1),
    /**
     * サービスの状況連番02
     */
    サービスの状況連番02(2),
    /**
     * サービスの状況連番03
     */
    サービスの状況連番03(3),
    /**
     * サービスの状況連番04
     */
    サービスの状況連番04(4),
    /**
     * サービスの状況連番05
     */
    サービスの状況連番05(5),
    /**
     * サービスの状況連番06
     */
    サービスの状況連番06(6),
    /**
     * サービスの状況連番07
     */
    サービスの状況連番07(7),
    /**
     * サービスの状況連番08
     */
    サービスの状況連番08(8),
    /**
     * サービスの状況連番09
     */
    サービスの状況連番09(9),
    /**
     * サービスの状況連番10
     */
    サービスの状況連番10(10),
    /**
     * サービスの状況連番11
     */
    サービスの状況連番11(11),
    /**
     * サービスの状況連番12
     */
    サービスの状況連番12(12),
    /**
     * サービスの状況連番13
     */
    サービスの状況連番13(13),
    /**
     * サービスの状況連番14
     */
    サービスの状況連番14(14),
    /**
     * サービスの状況連番15
     */
    サービスの状況連番15(15),
    /**
     * サービスの状況連番16
     */
    サービスの状況連番16(16),
    /**
     * サービスの状況連番17
     */
    サービスの状況連番17(17),
    /**
     * サービスの状況連番18
     */
    サービスの状況連番18(18),
    /**
     * サービスの状況連番19
     */
    サービスの状況連番19(19),
    /**
     * サービスの状況連番20
     */
    サービスの状況連番20(20);

    private final int renban;

    private DbT5207Renban(int renban) {
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
