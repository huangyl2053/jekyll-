/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbe.core.definition.IryoKikanKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 医療機関区分クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IryoKikanKubunTest extends TestBase {

    private static RString code;
    private static RString name;
    private static RString shortName;

    public static class コンストラクタのテスト extends TestBase {

        @Override
        public void setUp() {
            code = new RString("001");
            name = new RString("介護病院");
            shortName = new RString("介護病院");
        }

        @Test
        public void 必須項目がそろっているとき_インスタンスが生成される() {
            IryoKikanKubun sut = new IryoKikanKubun(code, name, shortName);
            assertThat(sut, instanceOf(IryoKikanKubun.class));
        }

        @Test(expected = NullPointerException.class)
        public void コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            IryoKikanKubun sut = new IryoKikanKubun(null, name, shortName);
        }

        @Test(expected = NullPointerException.class)
        public void 名称にnullが渡されたとき_NullPointerExceptionが発生する() {
            IryoKikanKubun sut = new IryoKikanKubun(code, null, shortName);
        }

        @Test(expected = NullPointerException.class)
        public void 略称にnullが渡されたとき_NullPointerExceptionが発生する() {
            IryoKikanKubun sut = new IryoKikanKubun(code, name, null);
        }
    }

    public static class equalsのテスト extends TestBase {

        @Override
        public void setUp() {
            code = new RString("001");
            name = new RString("介護病院");
            shortName = new RString("介護病院");
        }

        @Test
        public void codeが同一のとき_equalsはtrueを返す() {
            IryoKikanKubun sut1 = new IryoKikanKubun(code, name, shortName);
            IryoKikanKubun sut2 = new IryoKikanKubun(code, name, shortName);
            assertThat(sut1.equals(sut2), is(true));
        }

        @Test
        public void codeが同一でないとき_equalsはfalseを返す() {
            IryoKikanKubun sut1 = new IryoKikanKubun(code, name, shortName);
            IryoKikanKubun sut2 = new IryoKikanKubun(new RString("110"), name, shortName);
            assertThat(sut1.equals(sut2), is(false));
        }
    }

    public static class hashCodeのテスト extends TestBase {

        @Override
        public void setUp() {
            code = new RString("001");
            name = new RString("介護病院");
            shortName = new RString("介護病院");
        }

        @Test
        public void codeが同一のとき_hashCodeは同じ数値を返す() {
            IryoKikanKubun sut1 = new IryoKikanKubun(code, name, shortName);
            IryoKikanKubun sut2 = new IryoKikanKubun(code, name, shortName);
            assertThat(sut1.hashCode(), is(sut2.hashCode()));
        }
    }
}
