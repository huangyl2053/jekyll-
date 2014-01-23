/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business;

import jp.co.ndensan.reams.db.dba.definition.valueobject.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.definition.valueobject.HihokenshaKubun;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.helper.ShikibetsuCodeMock;
import jp.co.ndensan.reams.db.dba.definition.enumeratedtype.ShikakuIdoKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

        List<Hihokensha> 被保険者リスト;
        private HihokenshaList sut;

        @Override
        protected void setUp() {
            被保険者リスト = new ArrayList<>();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定した市町村コードと被保険者番号が見つからなかったとき_IllegalArgumentExceptionを投げる() {
            sut = new HihokenshaList(被保険者リスト);
            sut.get被保険者(null, null);
        }

        @Test
        public void 被保険者番号と市町村コードから_同じ値をもった被保険者を取得する() {
            KaigoHihokenshaNumber 被保険者番号 = new KaigoHihokenshaNumber(new RString("0000000001"));
            ShichosonCode 市町村コード = new ShichosonCode(new RString("12345"));

            Hihokensha 被保険者 = create被保険者(市町村コード, 被保険者番号);

            被保険者リスト = create該当1件の被保険者リスト(被保険者);
            sut = new HihokenshaList(被保険者リスト);

            assertThat(sut.get被保険者(市町村コード, 被保険者番号), is(被保険者));
        }
    }

    public static class Size extends TestBase {

        @Test
        public void sizeは_コンストラクタ引数のリストの要素数を返す() {
            List<Hihokensha> 被保険者リスト = new ArrayList<>(10);
            HihokenshaList sut = new HihokenshaList(被保険者リスト);
            assertThat(sut.size(), is(被保険者リスト.size()));
        }
    }

    private static List<Hihokensha> create該当1件の被保険者リスト(Hihokensha 該当被保険者) {
        List<Hihokensha> 被保険者リスト = new ArrayList<>();

        int 人数 = 10;

        for (int i = 1; i < 人数; i++) {
            被保険者リスト.add(create被保険者(
                    new ShichosonCode(new RString("")), new KaigoHihokenshaNumber(new RString(""))));
        }
        被保険者リスト.add(該当被保険者);

        System.out.println((被保険者リスト.size() + 1) + "");

        return 被保険者リスト;
    }

    private static Hihokensha create被保険者(ShichosonCode 市町村コード, KaigoHihokenshaNumber 被保険者番号) {
        Hihokensha 被保険者 = HihokenshaFactory.createInstance(
                被保険者番号, 市町村コード,
                ShikibetsuCodeMock.createInstance(new RString("")),
                ShikakuIdoKubun.資格取得, new HihokenshaKubun(RString.EMPTY, RString.EMPTY),
                RDate.MAX, RDate.MAX, new ShikakuShutokuJiyu(), RDate.MAX);
        return 被保険者;
    }
}
