package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認知症高齢者自立度コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class NinchishoNichijoSeikatsuJiritsudoCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NinchishoNichijoSeikatsuJiritsudoCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_自立を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("1")), is(NinchishoNichijoSeikatsuJiritsudoCode.自立));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_Ⅰを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("2")), is(NinchishoNichijoSeikatsuJiritsudoCode.Ⅰ));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_Ⅱaを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("3")), is(NinchishoNichijoSeikatsuJiritsudoCode.Ⅱa));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_Ⅱbを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("4")), is(NinchishoNichijoSeikatsuJiritsudoCode.Ⅱb));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_Ⅲaを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("5")), is(NinchishoNichijoSeikatsuJiritsudoCode.Ⅲa));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_Ⅲbを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("6")), is(NinchishoNichijoSeikatsuJiritsudoCode.Ⅲb));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_Ⅳを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("7")), is(NinchishoNichijoSeikatsuJiritsudoCode.Ⅳ));
    }

    @Test
    public void 引数に8を指定した場合_toValueは_Mを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("8")), is(NinchishoNichijoSeikatsuJiritsudoCode.M));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_記載無しを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.toValue(new RString("9")), is(NinchishoNichijoSeikatsuJiritsudoCode.記載無し));
    }

    @Test
    public void 自立を指定した場合_getコードは_1を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.自立.getコード(), is(new RString("1")));
    }

    @Test
    public void Ⅰを指定した場合_getコードは_2を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅰ.getコード(), is(new RString("2")));
    }

    @Test
    public void Ⅱaを指定した場合_getコードは_3を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅱa.getコード(), is(new RString("3")));
    }

    @Test
    public void Ⅱbを指定した場合_getコードは_4を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅱb.getコード(), is(new RString("4")));
    }

    @Test
    public void Ⅲaを指定した場合_getコードは_5を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅲa.getコード(), is(new RString("5")));
    }

    @Test
    public void Ⅲbを指定した場合_getコードは_6を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅲb.getコード(), is(new RString("6")));
    }

    @Test
    public void Ⅳを指定した場合_getコードは_7を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅳ.getコード(), is(new RString("7")));
    }

    @Test
    public void Mを指定した場合_getコードは_8を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.M.getコード(), is(new RString("8")));
    }

    @Test
    public void 記載無しを指定した場合_getコードは_9を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.記載無し.getコード(), is(new RString("9")));
    }

    @Test
    public void 自立を指定した場合_get名称は_自立を返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.自立.get名称(), is(new RString("自立")));
    }

    @Test
    public void Ⅰを指定した場合_get名称は_Ⅰを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅰ.get名称(), is(new RString("Ⅰ")));
    }

    @Test
    public void Ⅱaを指定した場合_get名称は_Ⅱaを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅱa.get名称(), is(new RString("Ⅱa")));
    }

    @Test
    public void Ⅱbを指定した場合_get名称は_Ⅱbを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅱb.get名称(), is(new RString("Ⅱb")));
    }

    @Test
    public void Ⅲaを指定した場合_get名称は_Ⅲaを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅲa.get名称(), is(new RString("Ⅲa")));
    }

    @Test
    public void Ⅲbを指定した場合_get名称は_Ⅲbを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅲb.get名称(), is(new RString("Ⅲb")));
    }

    @Test
    public void Ⅳを指定した場合_get名称は_Ⅳを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.Ⅳ.get名称(), is(new RString("Ⅳ")));
    }

    @Test
    public void Mを指定した場合_get名称は_Mを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.M.get名称(), is(new RString("M")));
    }

    @Test
    public void 記載無しを指定した場合_get名称は_記載無しを返す() {
        assertThat(NinchishoNichijoSeikatsuJiritsudoCode.記載無し.get名称(), is(new RString("記載無し")));
    }

}
