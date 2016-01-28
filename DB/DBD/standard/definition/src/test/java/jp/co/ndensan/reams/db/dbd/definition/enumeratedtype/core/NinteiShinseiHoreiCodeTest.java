package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 申請区分（法令）コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class NinteiShinseiHoreiCodeTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NinteiShinseiHoreiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NinteiShinseiHoreiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_新規申請を返す() {
        assertThat(NinteiShinseiHoreiCode.toValue(new RString("1")), is(NinteiShinseiHoreiCode.新規申請));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_更新申請を返す() {
        assertThat(NinteiShinseiHoreiCode.toValue(new RString("2")), is(NinteiShinseiHoreiCode.更新申請));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_区分変更申請を返す() {
        assertThat(NinteiShinseiHoreiCode.toValue(new RString("3")), is(NinteiShinseiHoreiCode.区分変更申請));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_職権を返す() {
        assertThat(NinteiShinseiHoreiCode.toValue(new RString("4")), is(NinteiShinseiHoreiCode.職権));
    }

    @Test
    public void 新規申請を指定した場合_getコードは_1を返す() {
        assertThat(NinteiShinseiHoreiCode.新規申請.getコード(), is(new RString("1")));
    }

    @Test
    public void 更新申請を指定した場合_getコードは_2を返す() {
        assertThat(NinteiShinseiHoreiCode.更新申請.getコード(), is(new RString("2")));
    }

    @Test
    public void 区分変更申請を指定した場合_getコードは_3を返す() {
        assertThat(NinteiShinseiHoreiCode.区分変更申請.getコード(), is(new RString("3")));
    }

    @Test
    public void 職権を指定した場合_getコードは_4を返す() {
        assertThat(NinteiShinseiHoreiCode.職権.getコード(), is(new RString("4")));
    }

    @Test
    public void 新規申請を指定した場合_get名称は_新規申請を返す() {
        assertThat(NinteiShinseiHoreiCode.新規申請.get名称(), is(new RString("新規申請")));
    }

    @Test
    public void 更新申請を指定した場合_get名称は_更新申請を返す() {
        assertThat(NinteiShinseiHoreiCode.更新申請.get名称(), is(new RString("更新申請")));
    }

    @Test
    public void 区分変更申請を指定した場合_get名称は_区分変更申請を返す() {
        assertThat(NinteiShinseiHoreiCode.区分変更申請.get名称(), is(new RString("区分変更申請")));
    }

    @Test
    public void 職権を指定した場合_get名称は_職権を返す() {
        assertThat(NinteiShinseiHoreiCode.職権.get名称(), is(new RString("職権")));
    }

}
