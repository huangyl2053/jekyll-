package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 障害高齢者自立度コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class ShogaiNichijoSeikatsuJiritsudoCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShogaiNichijoSeikatsuJiritsudoCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_自立を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("1")), is(ShogaiNichijoSeikatsuJiritsudoCode.自立));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_J1を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("2")), is(ShogaiNichijoSeikatsuJiritsudoCode.J1));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_J2を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("3")), is(ShogaiNichijoSeikatsuJiritsudoCode.J2));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_A1を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("4")), is(ShogaiNichijoSeikatsuJiritsudoCode.A1));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_A2を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("5")), is(ShogaiNichijoSeikatsuJiritsudoCode.A2));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_B1を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("6")), is(ShogaiNichijoSeikatsuJiritsudoCode.B1));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_B2を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("7")), is(ShogaiNichijoSeikatsuJiritsudoCode.B2));
    }

    @Test
    public void 引数に8を指定した場合_toValueは_C1を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("8")), is(ShogaiNichijoSeikatsuJiritsudoCode.C1));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_C2を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("9")), is(ShogaiNichijoSeikatsuJiritsudoCode.C2));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_記載無しを返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.toValue(new RString("10")), is(ShogaiNichijoSeikatsuJiritsudoCode.記載無し));
    }

    @Test
    public void 自立を指定した場合_getコードは_1を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.自立.getコード(), is(new RString("1")));
    }

    @Test
    public void J1を指定した場合_getコードは_2を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.J1.getコード(), is(new RString("2")));
    }

    @Test
    public void J2を指定した場合_getコードは_3を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.J2.getコード(), is(new RString("3")));
    }

    @Test
    public void A1を指定した場合_getコードは_4を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.A1.getコード(), is(new RString("4")));
    }

    @Test
    public void A2を指定した場合_getコードは_5を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.A2.getコード(), is(new RString("5")));
    }

    @Test
    public void B1を指定した場合_getコードは_6を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.B1.getコード(), is(new RString("6")));
    }

    @Test
    public void B2を指定した場合_getコードは_7を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.B2.getコード(), is(new RString("7")));
    }

    @Test
    public void C1を指定した場合_getコードは_8を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.C1.getコード(), is(new RString("8")));
    }

    @Test
    public void C2を指定した場合_getコードは_9を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.C2.getコード(), is(new RString("9")));
    }

    @Test
    public void 記載無しを指定した場合_getコードは_10を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.記載無し.getコード(), is(new RString("10")));
    }

    @Test
    public void 自立を指定した場合_get名称は_自立を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.自立.get名称(), is(new RString("自立")));
    }

    @Test
    public void J1を指定した場合_get名称は_J1を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.J1.get名称(), is(new RString("J1")));
    }

    @Test
    public void J2を指定した場合_get名称は_J2を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.J2.get名称(), is(new RString("J2")));
    }

    @Test
    public void A1を指定した場合_get名称は_A1を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.A1.get名称(), is(new RString("A1")));
    }

    @Test
    public void A2を指定した場合_get名称は_A2を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.A2.get名称(), is(new RString("A2")));
    }

    @Test
    public void B1を指定した場合_get名称は_B1を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.B1.get名称(), is(new RString("B1")));
    }

    @Test
    public void B2を指定した場合_get名称は_B2を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.B2.get名称(), is(new RString("B2")));
    }

    @Test
    public void C1を指定した場合_get名称は_C1を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.C1.get名称(), is(new RString("C1")));
    }

    @Test
    public void C2を指定した場合_get名称は_C2を返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.C2.get名称(), is(new RString("C2")));
    }

    @Test
    public void 記載無しを指定した場合_get名称は_記載無しを返す() {
        assertThat(ShogaiNichijoSeikatsuJiritsudoCode.記載無し.get名称(), is(new RString("記載無し")));
    }

}
