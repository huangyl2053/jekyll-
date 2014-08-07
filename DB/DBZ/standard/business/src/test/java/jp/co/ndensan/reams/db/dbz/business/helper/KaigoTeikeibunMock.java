/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.helper;

import jp.co.ndensan.reams.db.dbz.business.KaigoTeikeibun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護定型文の共通Mockです。
 *
 * @author N9606 漢那 憲作
 */
public class KaigoTeikeibunMock {

    public static KaigoTeikeibun create介護定型文() {
        return new KaigoTeikeibun(
                new RString("1"),
                new RString("001"),
                new RString("0001"),
                new RString("定型文理由てすと")
        );
    }
}
