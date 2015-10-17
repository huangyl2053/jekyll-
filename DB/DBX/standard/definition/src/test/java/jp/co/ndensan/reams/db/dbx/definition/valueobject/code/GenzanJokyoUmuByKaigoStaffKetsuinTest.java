package jp.co.ndensan.reams.db.dbx.definition.valueobject.code;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.GenzanJokyoUmuByKaigoStaffKetsuin;
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
 * 介護職員の欠員による減算の状況の有無を表すドメインクラスです。
 *
 * @author LDNS 孫亜威
 */
@RunWith(Enclosed.class)
public class GenzanJokyoUmuByKaigoStaffKetsuinTest extends DbxTestBase {

    private static GenzanJokyoUmuByKaigoStaffKetsuin sut;

    @BeforeClass
    public static void setUp() {
        sut = new GenzanJokyoUmuByKaigoStaffKetsuin(new RString("10"));
    }

    /**
     * valueのテストです。
     *
     */
    public static class valueテスト extends DbxTestBase {

        @Test
        public void LDNS_10を指定した場合_valueは_10を戻す() {
            assertThat(sut.value(), is(new Code(new RString("10"))));
        }
    }

    /**
     * equalsのテストです。
     *
     */
    public static class equalsテスト extends DbxTestBase {

        @Test
        public void LDNS_Objectがnullの場合_equalsは_falseを戻す() {
            Object data = null;
            assertFalse(sut.equals(data));
        }

        @Test
        public void LDNS_Objectがnull以外かつGenzanJokyoUmuByKaigoStaffKetsuinではないの場合_equalsは_falseを戻す() {
            Object data = new RString("1111");
            assertFalse(sut.equals(data));
        }

        @Test
        public void LDNS_Objectのcodeとコンストラクタのcodeが不一致の場合_equalsは_falseを戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut2 = new GenzanJokyoUmuByKaigoStaffKetsuin(new RString("90"));
            assertFalse(sut.equals(sut2));
        }

        @Test
        public void LDNS_Object値とコンストラクタ値が一致の場合_equalsは_trueを戻す() {
            assertTrue(sut.equals(new GenzanJokyoUmuByKaigoStaffKetsuin(new RString("10"))));
        }

    }

    /**
     * toStringのテストです。
     *
     */
    public static class toStringテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnullの場合_toStringは_emptyを戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin((Code) null);
            assertThat(sut.toString(), is(RString.EMPTY.toString()));
        }

        @Test
        public void LDNS_codeが1234567の場合_toStringは_1234567を戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin(new Code("1234567"));
            assertThat(sut.toString(), is("1234567"));
        }
    }

    /**
     * hashCodeのテストです。
     *
     */
    public static class hashCodeテスト extends DbxTestBase {

        @Test
        public void LDNS_設定した対象とコンストラクタ同じの場合_hashCodeは_同じhashCodeを戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut2 = new GenzanJokyoUmuByKaigoStaffKetsuin(new RString("10"));
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }

    /**
     * getColumnValueのテストです。
     *
     */
    public static class getColumnValueテスト extends DbxTestBase {

        @Test
        public void LDNS_10を指定した場合_getColumnValueは_10を戻す() {
            assertThat(sut.getColumnValue(), is(new RString("10")));
        }
    }

    /**
     * toRStringのテストです。
     *
     */
    public static class toRStringテスト extends DbxTestBase {

        @Test
        public void LDNS_10を指定した場合_toRStringは_10を戻す() {
            assertThat(sut.toRString(), is(new RString("10")));
        }
    }

    /**
     * getMeishoのテストです。
     *
     */
    public static class getMeishoパラメタあるテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnull場合_getMeishoは_emptyを戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin((Code) null);
            assertThat(sut.getMeisho(new FlexibleDate("20150303")), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeがnull以外の場合_getMeishoは_介護職員の欠員による減算の状況の有無を戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin(new Code("1234567"));
            assertThat(sut.getMeisho(new FlexibleDate("20150303")), is(new RString("介護職員の欠員による減算の状況の有無")));
        }
    }

    /**
     * getMeishoのテストです。
     *
     */
    public static class getMeishoテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnull場合_getMeishoは_emptyを戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin((Code) null);
            assertThat(sut.getMeisho(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeがnull以外の場合_getMeishoは_介護職員の欠員による減算の状況の有無を戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin(new Code("1234567"));
            assertThat(sut.getMeisho(), is(new RString("介護職員の欠員による減算の状況の有無")));
        }
    }

    /**
     * getRyakushoのテストです。
     *
     */
    public static class getRyakushoパラメタあるテスト extends DbxTestBase {

        @Test
        public void LDNS_Codeがnull場合_getRyakushoは_emptyを戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin((Code) null);
            assertThat(sut.getRyakusho(new FlexibleDate("20150303")), is(RString.EMPTY));
        }

        @Test
        public void LDNS_Codeがnull以外の場合_getRyakushoは_介護職員の欠員による減算の状況の有無を戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin(new Code("1234567"));
            assertThat(sut.getRyakusho(new FlexibleDate("20150303")), is(new RString("介護職員の欠員による減算の状況の有無")));
        }
    }

    /**
     * getRyakushoのテストです。
     *
     */
    public static class getRyakushoテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnull場合_getRyakushoは_emptyを戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin((Code) null);
            assertThat(sut.getRyakusho(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeがnull以外の場合_getRyakushoは_介護職員の欠員による減算の状況の有無を戻す() {
            GenzanJokyoUmuByKaigoStaffKetsuin sut = new GenzanJokyoUmuByKaigoStaffKetsuin(new Code("1234567"));
            assertThat(sut.getRyakusho(), is(new RString("介護職員の欠員による減算の状況の有無")));
        }
    }
}
