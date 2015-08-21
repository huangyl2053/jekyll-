/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;

/**
 * 介護サービスコードクラスのテストクラスです
 *
 * @author n9935 知念 広宰
 */
@RunWith(Enclosed.class)
public class _KaigoServiceCodeTest extends DbxTestBase {

    private static _KaigoServiceCode sut;

    private static final KaigoServiceShuruiCode サービス種類コード = new KaigoServiceShuruiCode("01");
    private static final RString サービス項目コード = new RString("2345");

    @BeforeClass

    public static void setUpClass() {
        sut = new _KaigoServiceCode(サービス種類コード, サービス項目コード);

    }

    public static class コンストラクタ extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタのサービス種類コードにnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoServiceCode(null, サービス項目コード);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタのサービス項目コードにnullを指定した時_NullPointerExceptionを返す() {
            sut = new _KaigoServiceCode(サービス種類コード, null);
        }
    }

    public static class Getサービス種類コード extends DbxTestBase {

        @Test
        public void コンストラクタのサービス種類コードに_01_を指定した時_getサービス種類コードは_01_を返す() {
            assertThat(sut.getサービス種類コード(), is(サービス種類コード));
        }
    }

    public static class Getサービス項目コード extends DbxTestBase {

        @Test
        public void コンストラクタのサービス項目コードに_2345_を指定した時_getサービス項目コードは_2345_を返す() {
            assertThat(sut.getサービス項目コード(), is(サービス項目コード));
        }
    }

    public static class Getサービスコード extends DbxTestBase {

        @Test
        public void コンストラクタのサービス種類コードに01_サービス項目コードに_2345_を指定した時_getサービスコードは_012345_を返す() {
            assertThat(sut.getサービスコード(), is(new RString("012345")));
        }
    }
}
