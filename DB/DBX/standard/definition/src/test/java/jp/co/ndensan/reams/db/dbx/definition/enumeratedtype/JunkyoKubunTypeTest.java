/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JunkyoKubunType}のテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class JunkyoKubunTypeTest {

    public JunkyoKubunTypeTest() {
    }

    public static class toRString extends DbxTestBase {

        @Test
        public void toRStringは_nameをRStringへ変換した物を返す() {
            JunkyoKubunType sut = JunkyoKubunType.準拠しない;
            assertThat(sut.toRString(), is(new RString(sut.name())));
        }
    }

    public static class toValue extends DbxTestBase {

        private JunkyoKubunType sut;

        @Test
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが有る時_そのオブジェクトを返す() {
            JunkyoKubunType result = sut.toValue(JunkyoKubunType.準拠する.code());
            assertThat(result, is(JunkyoKubunType.準拠する));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_引数と同じ値のcodeを持つオブジェクトが無い時_IllegalArgumentExceptionをスローする() {
            sut.toValue(null);
        }
    }

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_codeが準拠するの場合_valueOfは_準拠するを返す() {
            assertThat(JunkyoKubunType.valueOf("準拠する"), is(JunkyoKubunType.準拠する));
        }
    }
}
