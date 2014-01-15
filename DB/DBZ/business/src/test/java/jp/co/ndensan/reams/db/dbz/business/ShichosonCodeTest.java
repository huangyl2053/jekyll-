/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.ur.urz.business.ILocalGovernmentCode;
import jp.co.ndensan.reams.ur.urz.business._LocalGovernmentCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShichosonCodeTest extends TestBase {

    public static class コンストラクタ_RString extends TestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタ引数のRStringにnullを指定した時_NullPointerExceptionを返す() {
            RString test = null;
            ShichosonCode sut = new ShichosonCode(test);
        }
    }

    public static class コンストラクタ_ILocalGovernment extends TestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタ引数のILocalGovernmentにnullを指定した時_NullPointerExceptionを返す() {
            ILocalGovernmentCode test = null;
            ShichosonCode sut = new ShichosonCode(test);
        }
    }

    public static class GetCode extends TestBase {

        @Test
        public void インスタンスが地方公共団体コードから生成されたとき_getCodeは_都道府県コードと市区町村コードの値を結合したものと同値を返す() {
            ILocalGovernmentCode 地方公共団体コード = create地方公共団体コード();

            String 都道府県コード = "12";
            when(地方公共団体コード.get都道府県コード()).thenReturn(new RString(都道府県コード));

            String 市区町村コード = "345";
            when(地方公共団体コード.get市区町村コード()).thenReturn(new RString(市区町村コード));

            ShichosonCode sut = new ShichosonCode(地方公共団体コード);
            assertThat(sut.getCode(), is(new RString(都道府県コード + 市区町村コード)));
        }
    }

    private static ILocalGovernmentCode create地方公共団体コード() {
        return mock(_LocalGovernmentCode.class);
    }
}
