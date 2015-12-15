package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認知症高齢者の日常生活自立度の蓋然性評価コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class GaizenseiHyokaCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GaizenseiHyokaCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GaizenseiHyokaCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_判定なしを返す() {
        assertThat(GaizenseiHyokaCode.toValue(new RString("0")), is(GaizenseiHyokaCode.判定なし));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_Aを返す() {
        assertThat(GaizenseiHyokaCode.toValue(new RString("1")), is(GaizenseiHyokaCode.A));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_Bを返す() {
        assertThat(GaizenseiHyokaCode.toValue(new RString("2")), is(GaizenseiHyokaCode.B));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_Cを返す() {
        assertThat(GaizenseiHyokaCode.toValue(new RString("3")), is(GaizenseiHyokaCode.C));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_Dを返す() {
        assertThat(GaizenseiHyokaCode.toValue(new RString("4")), is(GaizenseiHyokaCode.D));
    }

    @Test
    public void 判定なしを指定した場合_getコードは_0を返す() {
        assertThat(GaizenseiHyokaCode.判定なし.getコード(), is(new RString("0")));
    }

    @Test
    public void Aを指定した場合_getコードは_1を返す() {
        assertThat(GaizenseiHyokaCode.A.getコード(), is(new RString("1")));
    }

    @Test
    public void Bを指定した場合_getコードは_2を返す() {
        assertThat(GaizenseiHyokaCode.B.getコード(), is(new RString("2")));
    }

    @Test
    public void Cを指定した場合_getコードは_3を返す() {
        assertThat(GaizenseiHyokaCode.C.getコード(), is(new RString("3")));
    }

    @Test
    public void Dを指定した場合_getコードは_4を返す() {
        assertThat(GaizenseiHyokaCode.D.getコード(), is(new RString("4")));
    }

    @Test
    public void 判定なしを指定した場合_get名称は_判定なしを返す() {
        assertThat(GaizenseiHyokaCode.判定なし.get名称(), is(new RString("判定なし")));
    }

    @Test
    public void Aを指定した場合_get名称は_Aを返す() {
        assertThat(GaizenseiHyokaCode.A.get名称(), is(new RString("A")));
    }

    @Test
    public void Bを指定した場合_get名称は_Bを返す() {
        assertThat(GaizenseiHyokaCode.B.get名称(), is(new RString("B")));
    }

    @Test
    public void Cを指定した場合_get名称は_Cを返す() {
        assertThat(GaizenseiHyokaCode.C.get名称(), is(new RString("C")));
    }

    @Test
    public void Dを指定した場合_get名称は_Dを返す() {
        assertThat(GaizenseiHyokaCode.D.get名称(), is(new RString("D")));
    }

}
