package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 資格取得前申請区分のテストクラスです。
 *
 * @author LDNS
 */
public class ShikakuShutokuMaeShinseiKubunTest extends DbdTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_資格取得前申請を返す() {
        assertThat(ShikakuShutokuMaeShinseiKubun.toValue(true), is(ShikakuShutokuMaeShinseiKubun.資格取得前申請));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_資格取得前申請以外を返す() {
        assertThat(ShikakuShutokuMaeShinseiKubun.toValue(false), is(ShikakuShutokuMaeShinseiKubun.資格取得前申請以外));
    }

    @Test
    public void 資格取得前申請を指定した場合_getコードは_Trueを返す() {
        assertThat(ShikakuShutokuMaeShinseiKubun.資格取得前申請.getコード(), is(true));
    }

    @Test
    public void 資格取得前申請以外を指定した場合_getコードは_Falseを返す() {
        assertThat(ShikakuShutokuMaeShinseiKubun.資格取得前申請以外.getコード(), is(false));
    }

    @Test
    public void 資格取得前申請を指定した場合_get名称は_資格取得前申請を返す() {
        assertThat(ShikakuShutokuMaeShinseiKubun.資格取得前申請.get名称(), is(new RString("資格取得前申請")));
    }

    @Test
    public void 資格取得前申請以外を指定した場合_get名称は_資格取得前申請以外を返す() {
        assertThat(ShikakuShutokuMaeShinseiKubun.資格取得前申請以外.get名称(), is(new RString("資格取得前申請以外")));
    }

}
