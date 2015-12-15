package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 要介護認定一次判定結果コード09（認知症加算）のテストクラスです。
 *
 * @author LDNS
 */
public class IchijiHanteiKekkaNinchishoKasanCodeTest extends DbdTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        IchijiHanteiKekkaNinchishoKasanCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        IchijiHanteiKekkaNinchishoKasanCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_なしを返す() {
        assertThat(IchijiHanteiKekkaNinchishoKasanCode.toValue(new RString("1")), is(IchijiHanteiKekkaNinchishoKasanCode.なし));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_一段階の重度変更を返す() {
        assertThat(IchijiHanteiKekkaNinchishoKasanCode.toValue(new RString("2")), is(IchijiHanteiKekkaNinchishoKasanCode.一段階の重度変更));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_二段階の重度変更を返す() {
        assertThat(IchijiHanteiKekkaNinchishoKasanCode.toValue(new RString("3")), is(IchijiHanteiKekkaNinchishoKasanCode.二段階の重度変更));
    }

    @Test
    public void なしを指定した場合_getコードは_1を返す() {
        assertThat(IchijiHanteiKekkaNinchishoKasanCode.なし.getコード(), is(new RString("1")));
    }

    @Test
    public void 一段階の重度変更を指定した場合_getコードは_2を返す() {
        assertThat(IchijiHanteiKekkaNinchishoKasanCode.一段階の重度変更.getコード(), is(new RString("2")));
    }

    @Test
    public void 二段階の重度変更を指定した場合_getコードは_3を返す() {
        assertThat(IchijiHanteiKekkaNinchishoKasanCode.二段階の重度変更.getコード(), is(new RString("3")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(IchijiHanteiKekkaNinchishoKasanCode.なし.get名称(), is(new RString("なし（□□）")));
    }

    @Test
    public void 一段階の重度変更を指定した場合_get名称は_一段階の重度変更を返す() {
        assertThat(IchijiHanteiKekkaNinchishoKasanCode.一段階の重度変更.get名称(), is(new RString("一段階の重度変更（■□）")));
    }

    @Test
    public void 二段階の重度変更を指定した場合_get名称は_二段階の重度変更を返す() {
        assertThat(IchijiHanteiKekkaNinchishoKasanCode.二段階の重度変更.get名称(), is(new RString("二段階の重度変更（■■）")));
    }

}
