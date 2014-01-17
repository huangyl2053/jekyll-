/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaListTest extends TestBase {

    public static class コンストラクタ extends TestBase {

        @Test(expected = NullPointerException.class)
        public void 引数がnullのとき_NullPointerExceptionを投げる() {
            HihokenshaList sut = new HihokenshaList(null);
        }
    }

    public static class Get被保険者 extends TestBase {

        private HihokenshaList sut;

        @Override
        protected void setUp() {
            List<Hihokensha> 被保険者リスト = new ArrayList<>();
            sut = new HihokenshaList(被保険者リスト);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定した市町村コードと被保険者番号が見つからなかったとき_IllegalArgumentExceptionを投げる() {
            sut.get被保険者(null, null);
        }
    }
}
