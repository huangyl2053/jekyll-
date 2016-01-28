package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 申請区分（申請時）コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class NinteiShinseiShinseijiKubunCodeTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NinteiShinseiShinseijiKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NinteiShinseiShinseijiKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_新規申請を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.toValue(new RString("1")), is(NinteiShinseiShinseijiKubunCode.新規申請));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_更新申請を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.toValue(new RString("2")), is(NinteiShinseiShinseijiKubunCode.更新申請));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_区分変更申請を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.toValue(new RString("3")), is(NinteiShinseiShinseijiKubunCode.区分変更申請));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_職権を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.toValue(new RString("4")), is(NinteiShinseiShinseijiKubunCode.職権));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_転入申請を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.toValue(new RString("5")), is(NinteiShinseiShinseijiKubunCode.転入申請));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_資格喪失_死亡を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.toValue(new RString("6")), is(NinteiShinseiShinseijiKubunCode.資格喪失_死亡));
    }

    @Test
    public void 引数にAを指定した場合_toValueは_新規申請_事前を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.toValue(new RString("A")), is(NinteiShinseiShinseijiKubunCode.新規申請_事前));
    }

    @Test
    public void 引数にBを指定した場合_toValueは_更新申請_事前を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.toValue(new RString("B")), is(NinteiShinseiShinseijiKubunCode.更新申請_事前));
    }

    @Test
    public void 新規申請を指定した場合_getコードは_1を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.新規申請.getコード(), is(new RString("1")));
    }

    @Test
    public void 更新申請を指定した場合_getコードは_2を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.更新申請.getコード(), is(new RString("2")));
    }

    @Test
    public void 区分変更申請を指定した場合_getコードは_3を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.区分変更申請.getコード(), is(new RString("3")));
    }

    @Test
    public void 職権を指定した場合_getコードは_4を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.職権.getコード(), is(new RString("4")));
    }

    @Test
    public void 転入申請を指定した場合_getコードは_5を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.転入申請.getコード(), is(new RString("5")));
    }

    @Test
    public void 資格喪失_死亡を指定した場合_getコードは_6を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード(), is(new RString("6")));
    }

    @Test
    public void 新規申請_事前を指定した場合_getコードは_Aを返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.新規申請_事前.getコード(), is(new RString("A")));
    }

    @Test
    public void 更新申請_事前を指定した場合_getコードは_Bを返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.更新申請_事前.getコード(), is(new RString("B")));
    }

    @Test
    public void 新規申請を指定した場合_get名称は_新規申請を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.新規申請.get名称(), is(new RString("新規申請")));
    }

    @Test
    public void 更新申請を指定した場合_get名称は_更新申請を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.更新申請.get名称(), is(new RString("更新申請")));
    }

    @Test
    public void 区分変更申請を指定した場合_get名称は_区分変更申請を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.区分変更申請.get名称(), is(new RString("区分変更申請")));
    }

    @Test
    public void 職権を指定した場合_get名称は_職権を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.職権.get名称(), is(new RString("職権")));
    }

    @Test
    public void 転入申請を指定した場合_get名称は_転入申請を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.転入申請.get名称(), is(new RString("転入申請")));
    }

    @Test
    public void 資格喪失_死亡を指定した場合_get名称は_資格喪失_死亡を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.資格喪失_死亡.get名称(), is(new RString("資格喪失（死亡）")));
    }

    @Test
    public void 新規申請_事前を指定した場合_get名称は_新規申請_事前を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.新規申請_事前.get名称(), is(new RString("新規申請（事前）")));
    }

    @Test
    public void 更新申請_事前を指定した場合_get名称は_更新申請_事前を返す() {
        assertThat(NinteiShinseiShinseijiKubunCode.更新申請_事前.get名称(), is(new RString("更新申請（事前）")));
    }

}
