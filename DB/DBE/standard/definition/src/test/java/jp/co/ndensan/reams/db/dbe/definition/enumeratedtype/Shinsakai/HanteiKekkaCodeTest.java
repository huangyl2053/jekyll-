package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 判定結果コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class HanteiKekkaCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HanteiKekkaCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HanteiKekkaCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_認定を返す() {
        assertThat(HanteiKekkaCode.toValue(new RString("01")), is(HanteiKekkaCode.認定));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_未審査を返す() {
        assertThat(HanteiKekkaCode.toValue(new RString("11")), is(HanteiKekkaCode.未審査));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_再審査を返す() {
        assertThat(HanteiKekkaCode.toValue(new RString("21")), is(HanteiKekkaCode.再審査));
    }

    @Test
    public void 引数に31を指定した場合_toValueは_再調査_調査_意見書を返す() {
        assertThat(HanteiKekkaCode.toValue(new RString("31")), is(HanteiKekkaCode.再調査_調査_意見書));
    }

    @Test
    public void 引数に32を指定した場合_toValueは_再調査_調査のみを返す() {
        assertThat(HanteiKekkaCode.toValue(new RString("32")), is(HanteiKekkaCode.再調査_調査のみ));
    }

    @Test
    public void 引数に33を指定した場合_toValueは_再調査_意見書のみを返す() {
        assertThat(HanteiKekkaCode.toValue(new RString("33")), is(HanteiKekkaCode.再調査_意見書のみ));
    }

    @Test
    public void 認定を指定した場合_getコードは_01を返す() {
        assertThat(HanteiKekkaCode.認定.getコード(), is(new RString("01")));
    }

    @Test
    public void 未審査を指定した場合_getコードは_11を返す() {
        assertThat(HanteiKekkaCode.未審査.getコード(), is(new RString("11")));
    }

    @Test
    public void 再審査を指定した場合_getコードは_21を返す() {
        assertThat(HanteiKekkaCode.再審査.getコード(), is(new RString("21")));
    }

    @Test
    public void 再調査_調査_意見書を指定した場合_getコードは_31を返す() {
        assertThat(HanteiKekkaCode.再調査_調査_意見書.getコード(), is(new RString("31")));
    }

    @Test
    public void 再調査_調査のみを指定した場合_getコードは_32を返す() {
        assertThat(HanteiKekkaCode.再調査_調査のみ.getコード(), is(new RString("32")));
    }

    @Test
    public void 再調査_意見書のみを指定した場合_getコードは_33を返す() {
        assertThat(HanteiKekkaCode.再調査_意見書のみ.getコード(), is(new RString("33")));
    }

    @Test
    public void 認定を指定した場合_get名称は_認定を返す() {
        assertThat(HanteiKekkaCode.認定.get名称(), is(new RString("認定")));
    }

    @Test
    public void 未審査を指定した場合_get名称は_未審査を返す() {
        assertThat(HanteiKekkaCode.未審査.get名称(), is(new RString("未審査")));
    }

    @Test
    public void 再審査を指定した場合_get名称は_再審査を返す() {
        assertThat(HanteiKekkaCode.再審査.get名称(), is(new RString("再審査")));
    }

    @Test
    public void 再調査_調査_意見書を指定した場合_get名称は_再調査_調査_意見書を返す() {
        assertThat(HanteiKekkaCode.再調査_調査_意見書.get名称(), is(new RString("再調査（調査・意見書）")));
    }

    @Test
    public void 再調査_調査のみを指定した場合_get名称は_再調査_調査のみを返す() {
        assertThat(HanteiKekkaCode.再調査_調査のみ.get名称(), is(new RString("再調査（調査のみ）")));
    }

    @Test
    public void 再調査_意見書のみを指定した場合_get名称は_再調査_意見書のみを返す() {
        assertThat(HanteiKekkaCode.再調査_意見書のみ.get名称(), is(new RString("再調査（意見書のみ）")));
    }

}
