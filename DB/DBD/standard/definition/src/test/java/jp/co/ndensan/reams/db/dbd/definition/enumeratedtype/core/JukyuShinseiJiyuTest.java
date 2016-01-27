package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 受給申請事由のテストクラスです。
 * 
 * @author LDNS 
 */
public class JukyuShinseiJiyuTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JukyuShinseiJiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JukyuShinseiJiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_初回申請を返す() {
        assertThat(JukyuShinseiJiyu.toValue(new RString("1")), is(JukyuShinseiJiyu.初回申請));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_再申請_有効期限内を返す() {
        assertThat(JukyuShinseiJiyu.toValue(new RString("2")), is(JukyuShinseiJiyu.再申請_有効期限内));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_再申請_有効期限外を返す() {
        assertThat(JukyuShinseiJiyu.toValue(new RString("3")), is(JukyuShinseiJiyu.再申請_有効期限外));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_要介護度変更申請を返す() {
        assertThat(JukyuShinseiJiyu.toValue(new RString("4")), is(JukyuShinseiJiyu.要介護度変更申請));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_指定サービス種類変更申請を返す() {
        assertThat(JukyuShinseiJiyu.toValue(new RString("5")), is(JukyuShinseiJiyu.指定サービス種類変更申請));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_申請_法施行前を返す() {
        assertThat(JukyuShinseiJiyu.toValue(new RString("6")), is(JukyuShinseiJiyu.申請_法施行前));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_追加_申請なしの追加を返す() {
        assertThat(JukyuShinseiJiyu.toValue(new RString("7")), is(JukyuShinseiJiyu.追加_申請なしの追加));
    }

    @Test
    public void 初回申請を指定した場合_getコードは_1を返す() {
        assertThat(JukyuShinseiJiyu.初回申請.getコード(), is(new RString("1")));
    }

    @Test
    public void 再申請_有効期限内を指定した場合_getコードは_2を返す() {
        assertThat(JukyuShinseiJiyu.再申請_有効期限内.getコード(), is(new RString("2")));
    }

    @Test
    public void 再申請_有効期限外を指定した場合_getコードは_3を返す() {
        assertThat(JukyuShinseiJiyu.再申請_有効期限外.getコード(), is(new RString("3")));
    }

    @Test
    public void 要介護度変更申請を指定した場合_getコードは_4を返す() {
        assertThat(JukyuShinseiJiyu.要介護度変更申請.getコード(), is(new RString("4")));
    }

    @Test
    public void 指定サービス種類変更申請を指定した場合_getコードは_5を返す() {
        assertThat(JukyuShinseiJiyu.指定サービス種類変更申請.getコード(), is(new RString("5")));
    }

    @Test
    public void 申請_法施行前を指定した場合_getコードは_6を返す() {
        assertThat(JukyuShinseiJiyu.申請_法施行前.getコード(), is(new RString("6")));
    }

    @Test
    public void 追加_申請なしの追加を指定した場合_getコードは_7を返す() {
        assertThat(JukyuShinseiJiyu.追加_申請なしの追加.getコード(), is(new RString("7")));
    }

    @Test
    public void 初回申請を指定した場合_get名称は_初回申請を返す() {
        assertThat(JukyuShinseiJiyu.初回申請.get名称(), is(new RString("初回申請")));
    }

    @Test
    public void 再申請_有効期限内を指定した場合_get名称は_再申請_有効期限内を返す() {
        assertThat(JukyuShinseiJiyu.再申請_有効期限内.get名称(), is(new RString("再申請（有効期限内）")));
    }

    @Test
    public void 再申請_有効期限外を指定した場合_get名称は_再申請_有効期限外を返す() {
        assertThat(JukyuShinseiJiyu.再申請_有効期限外.get名称(), is(new RString("再申請（有効期限外）")));
    }

    @Test
    public void 要介護度変更申請を指定した場合_get名称は_要介護度変更申請を返す() {
        assertThat(JukyuShinseiJiyu.要介護度変更申請.get名称(), is(new RString("要介護度変更申請")));
    }

    @Test
    public void 指定サービス種類変更申請を指定した場合_get名称は_指定サービス種類変更申請を返す() {
        assertThat(JukyuShinseiJiyu.指定サービス種類変更申請.get名称(), is(new RString("指定サービス種類変更申請")));
    }

    @Test
    public void 申請_法施行前を指定した場合_get名称は_申請_法施行前を返す() {
        assertThat(JukyuShinseiJiyu.申請_法施行前.get名称(), is(new RString("申請（法施行前）")));
    }

    @Test
    public void 追加_申請なしの追加を指定した場合_get名称は_追加_申請なしの追加を返す() {
        assertThat(JukyuShinseiJiyu.追加_申請なしの追加.get名称(), is(new RString("追加（申請なしの追加）")));
    }

}
