/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.ur.urf.business.IJigyosha;
import jp.co.ndensan.reams.ur.urf.business._Jigyosha;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * NinteichosaItakusakiのテストクラスです
 * 
 * @author N1013 松本直樹
 */
@RunWith(Enclosed.class)
public class NinteichosaItakusakiTest extends TestBase{
    
    public static class ConstructorTest extends TestBase {
        NinteichosaItakusaki sut;
        private RString 市町村コード;
        private IJigyosha 事業者;
        private KaigoJigyoshaNo 介護事業者番号;
        private boolean 有効区分;
        private ChosaItakuKubun 調査委託区分;
        private int 割付定員;
        private RString 割付地区;

        @Override
        public void setUp(){
            市町村コード = new RString("20213");
            事業者 = mock(_Jigyosha.class);
            介護事業者番号 = new KaigoJigyoshaNo(new RString("0000000001"));
            有効区分 = true;
            調査委託区分 = ChosaItakuKubun.その他;
            割付定員 = 1;
            割付地区 = new RString("地区１");
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの市町村コードに_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new NinteichosaItakusaki(null, 事業者, 介護事業者番号, 有効区分,調査委託区分, 
                    割付定員, 割付地区);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの事業者に_Nullを指定した場合_NullPointerExceptionが発生する() {
            sut = new NinteichosaItakusaki(市町村コード, null, 介護事業者番号, 有効区分,調査委託区分, 
                    割付定員, 割付地区);
        }
    }

}
