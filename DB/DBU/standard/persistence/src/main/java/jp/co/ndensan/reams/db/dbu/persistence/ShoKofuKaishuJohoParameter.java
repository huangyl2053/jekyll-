/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査請求書登録のParameterクラスです。
 */
public final class ShoKofuKaishuJohoParameter {

    private final RString gamennmodel;
    private final FlexibleDate shinsaSeikyuTodokedeYMD;

    private ShoKofuKaishuJohoParameter(
            RString gamennmodel,
            FlexibleDate shinsaSeikyuTodokedeYMD) {
        this.gamennmodel = gamennmodel;
        this.shinsaSeikyuTodokedeYMD = shinsaSeikyuTodokedeYMD;
    }

    /**
     * 画面モードを返します。
     *
     * @return 画面モード
     */
    public RString getGamennmodel() {
        return gamennmodel;
    }

    /**
     * 審査請求届出日を返します。
     *
     * @return 審査請求届出日
     */
    public FlexibleDate getShinsaSeikyuTodokedeYMD() {
        return shinsaSeikyuTodokedeYMD;
    }
}
