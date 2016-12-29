/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DbT5210テーブルの連番の列挙体クラスです。
 */
public enum DbT5210Renban {

    /**
     * 施設利用連番01
     */
    施設利用連番01(1),
    /**
     * 施設利用連番02
     */
    施設利用連番02(2),
    /**
     * 施設利用連番03
     */
    施設利用連番03(3),
    /**
     * 施設利用連番04
     */
    施設利用連番04(4),
    /**
     * 施設利用連番05
     */
    施設利用連番05(5),
    /**
     * 施設利用連番06
     */
    施設利用連番06(6),
    /**
     * 施設利用連番07
     */
    施設利用連番07(7),
    /**
     * 施設利用連番08
     */
    施設利用連番08(8),
    /**
     * 施設利用連番09
     */
    施設利用連番09(9);

    private final int renban;

    private DbT5210Renban(int renban) {
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
