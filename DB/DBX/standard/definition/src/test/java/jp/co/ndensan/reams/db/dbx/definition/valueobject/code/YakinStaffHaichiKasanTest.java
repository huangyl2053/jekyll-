package  jp.co.ndensan.reams.db.dbx.definition.valueobject.code;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 夜勤職員配置加算を表すドメインクラスのテストクラスです。
 *
 * @author LDNS 王峰
 */
@RunWith(Enclosed.class)
public class YakinStaffHaichiKasanTest extends DbxTestBase {

    private static YakinStaffHaichiKasan sut;

    @BeforeClass
    public static void setUp() {
        sut = new YakinStaffHaichiKasan(new Code("123456"));
    }

    /**
     * コンストラクタのテストです。
     *
     */
    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_codeを123456指定した場合_valueは_123456を戻す() {
            YakinStaffHaichiKasan temp = new YakinStaffHaichiKasan(new RString("123456"));
            assertThat(temp.getColumnValue(), is(new RString("123456")));
        }
    }

    /**
     * valueのテスト。
     *
     */
    public static class valueテスト extends DbxTestBase {

        @Test
        public void LDNS_code指定した場合_valueは_123456を戻す() {
            assertThat(sut.value(), is(new Code("123456")));
        }
    }

    /**
     * equalsのテスト。
     *
     */
    public static class equalsテスト extends DbxTestBase {

        @Test
        public void LDNS_Objectがnullの場合_equalsは_falseを戻す() {
            Object obj = null;
            assertFalse(sut.equals(obj));
        }

        @Test
        public void LDNS_Objectがnull以外かつYakinStaffHaichiKasanではないの場合_equalsは_falseを戻す() {
            Object obj = new RString("1111");
            assertFalse(sut.equals(obj));
        }

        @Test
        public void LDNS_Objectのcodeとコンストラクタのcodeが不一致の場合_equalsは_falseを戻す() {
            YakinStaffHaichiKasan sut2 = new YakinStaffHaichiKasan(new Code("923456"));
            assertFalse(sut.equals(sut2));
        }

        @Test
        public void LDNS_Object値とコンストラクタ値が一致の場合_equalsは_trueを戻す() {
            assertTrue(sut.equals(new YakinStaffHaichiKasan(new Code("123456"))));
        }

    }

    /**
     * toStringのテスト。
     *
     */
    public static class toStringテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnullの場合_toStringは_emptyを戻す() {
            Code code = null;
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(code);
            assertThat(sut.toString(), is(RString.EMPTY.toString()));
        }

        @Test
        public void LDNS_codeが1234567の場合_toStringは_1234567を戻す() {
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(new Code("1234567"));
            assertThat(sut.toString(), is("1234567"));
        }
    }

    /**
     * hashCodeのテスト。
     *
     */
    public static class hashCodeテスト extends DbxTestBase {

        @Test
        public void LDNS_設定した対象とコンストラクタ同じの場合_hashCodeは_同じhashCodeを戻す() {
            YakinStaffHaichiKasan sut2 = new YakinStaffHaichiKasan(new Code("123456"));
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }

    /**
     * getColumnValueのテスト。
     *
     */
    public static class getColumnValueテスト extends DbxTestBase {

        @Test
        public void LDNS_codeを123456指定した場合_getColumnValueは_123456を戻す() {
            assertThat(sut.getColumnValue(), is(new RString("123456")));
        }
    }

    /**
     * toRStringのテスト。
     *
     */
    public static class toRStringテスト extends DbxTestBase {

        @Test
        public void LDNS_codeを123456指定した場合_toRStringは_123456を戻す() {
            assertThat(sut.toRString(), is(new RString("123456")));
        }
    }

    /**
     * getMeishoのテスト。
     *
     */
    public static class getMeishoテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnullの場合_getMeishoは_emptyを戻す() {
            Code code = null;
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(code);
            assertThat(sut.getMeisho(new FlexibleDate("20150303")), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeがnull以外の場合_getMeishoは_夜勤職員配置加算を戻す() {
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(new Code("1234567"));
            assertThat(sut.getMeisho(new FlexibleDate("20150303")), is(new RString("夜勤職員配置加算")));
        }

        @Test
        public void LDNS_codeがnull引数がない場合_getMeishoは_emptyを戻す() {
            Code code = null;
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(code);
            assertThat(sut.getMeisho(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeがnull以外引数がないの場合_getMeishoは_夜勤職員配置加算を戻す() {
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(new Code("1234567"));
            assertThat(sut.getMeisho(), is(new RString("夜勤職員配置加算")));
        }
    }

    /**
     * getRyakushoのテスト。
     *
     */
    public static class getRyakushoテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnullの場合_getRyakushoは_emptyを戻す() {
            Code code = null;
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(code);
            assertThat(sut.getRyakusho(new FlexibleDate("20150303")), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeがnull以外の場合_getRyakushoは_夜勤職員配置加算を戻す() {
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(new Code("1234567"));
            assertThat(sut.getRyakusho(new FlexibleDate("20150303")), is(new RString("夜勤職員配置加算")));
        }

        @Test
        public void LDNS_codeがnull引数がない場合_getRyakushoは_emptyを戻す() {
            Code code = null;
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(code);
            assertThat(sut.getRyakusho(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeがnull引数がない以外の場合_getRyakushoは_夜勤職員配置加算を戻す() {
            YakinStaffHaichiKasan sut = new YakinStaffHaichiKasan(new Code("1234567"));
            assertThat(sut.getRyakusho(), is(new RString("夜勤職員配置加算")));
        }
    }

}
