/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
public enum NinteichosaKomokuDummy implements INinteichosaKomoku {

    概況特記("999", "概況特記"),
    EMPTY("", "");

    private final RString theTokkiJikoNo;
    private final RString theName;

    private NinteichosaKomokuDummy(String theTokkiJikoNo, String theName) {
        this.theTokkiJikoNo = new RString(theTokkiJikoNo);
        this.theName = new RString(theName);
    }

    @Override
    public RString get名称() {
        return this.theName;
    }

    @Override
    public RString get特記事項番号() {
        return this.theTokkiJikoNo;
    }

    static NinteichosaKomokuDummy toValueFromTokkiJikoNo(RString tokkiJikoNo) {
        for (NinteichosaKomokuDummy v : values()) {
            if (java.util.Objects.equals(v.get特記事項番号(), tokkiJikoNo)) {
                return v;
            }
        }
        return EMPTY;
    }

}
