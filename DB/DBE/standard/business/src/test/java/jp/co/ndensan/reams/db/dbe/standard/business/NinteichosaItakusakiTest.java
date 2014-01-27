/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.standard.business;

import jp.co.ndensan.reams.db.dbe.standard.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.standard.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.standard.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * NinteichosaItakusakiのテストクラスです
 *
 * @author N1013 松本直樹
 */
@RunWith(Enclosed.class)
public class NinteichosaItakusakiTest extends TestBase {

    public static class ConstructorTest extends TestBase {

        NinteichosaItakusaki sut;
        private RString 市町村コード;
        private KaigoJigyoshaNo 介護事業者番号;
        private JigyoshaNo 事業者番号;
        private boolean 有効区分;
        private ChosaItakuKubun 調査委託区分;
        private int 割付定員;
        private RString 割付地区;
        private RString 機関の区分;

        @Override
        public void setUp() {
            市町村コード = new RString("20213");
            介護事業者番号 = new KaigoJigyoshaNo(new RString("0000000001"));
            事業者番号 = new JigyoshaNo(new RString("0000000001"));
            有効区分 = true;
            調査委託区分 = ChosaItakuKubun.その他;
            割付定員 = 1;
            割付地区 = new RString("地区１");
            機関の区分 = new RString("介護保険施設");
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの市町村コードに_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new NinteichosaItakusaki(null, 介護事業者番号, 事業者番号, 有効区分, 調査委託区分,
                    割付定員, 割付地区, 機関の区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの事業者番号に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new NinteichosaItakusaki(市町村コード, 介護事業者番号, null, 有効区分, 調査委託区分,
                    割付定員, 割付地区, 機関の区分);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの介護事業者に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new NinteichosaItakusaki(市町村コード, null, 事業者番号, 有効区分, 調査委託区分,
                    割付定員, 割付地区, 機関の区分);
        }
    }
}
