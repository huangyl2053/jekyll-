/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.basic;

import jp.co.ndensan.reams.db.dba.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dba.business.Hihokensha;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * T1001被保険者台帳Entityのテストクラスです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class DbT1001HihokenshaDaichoEntityTest extends TestBase {

    public static class コンストラクタ extends TestBase {

        @Test(expected = NullPointerException.class)
        public void 引数のhihokenshaがnullのときは_NullPointerExceptionを投げる() {
            Hihokensha nullな被保険者 = null;
            DbT1001HihokenshaDaichoEntity sut = new DbT1001HihokenshaDaichoEntity(nullな被保険者);
        }
    }
}
