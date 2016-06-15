package  jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.code;

import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.code.TsushoRehabilitationAfterH214;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;
import org.junit.Test;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * TsushoRehabilitationAfterH214のテストクラスです。
 * 
 * @author LDNS 黄陽
 */
@RunWith(Enclosed.class)
public class TsushoRehabilitationAfterH214Test extends DbxTestBase {

    private static TsushoRehabilitationAfterH214 sut;

    @BeforeClass
    public static void setUp() {
        sut = new TsushoRehabilitationAfterH214(new RString("10"));
    }

    public static class valueテスト extends DbxTestBase {
        @Test
        public void LDNS_入力のパラメタ指定した場合_valueは_指定したパラメータを返す() {
            assertThat(sut.value(), is(new Code(new RString("10"))));
        }
    }

    public static class equalsテスト extends DbxTestBase {
        @Test
        public void LDNS_Objectがnullの場合_equalsは_falseを返す() {
            assertFalse(sut.equals(null));
        }

        @Test
        public void LDNS_Objectがnull以外かつTsushoRehabilitation_AfterH21_4ではないの場合_equalsは_falseを返す() {
            assertFalse(sut.equals(new RString("1111")));
        }

        @Test
        public void LDNS_Objectのcodeとコンストラクタのcodeが不一致の場合_equalsは_falseを返す() {
            TsushoRehabilitationAfterH214 sut2 = new TsushoRehabilitationAfterH214(new RString("90"));
            assertFalse(sut.equals(sut2));
        }

        @Test
        public void LDNS_Object値とコンストラクタ値が一致の場合_equalsは_trueを返す() {
            assertTrue(sut.equals(new TsushoRehabilitationAfterH214(new RString("10"))));
        }

    }

    public static class toStringテスト extends DbxTestBase {
        @Test
        public void LDNS_codeがnullの場合_toStringは_emptyを返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214((Code) null);
            assertThat(sut.toString(), is(RString.EMPTY.toString()));
        }
        @Test
        public void LDNS_codeが1234567の場合_toStringは_1234567を返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214(new Code("1234567"));
            assertThat(sut.toString(), is("1234567"));
        }
    }

    public static class hashCodeテスト extends DbxTestBase {
        @Test
        public void LDNS_設定した対象とコンストラクタ同じの場合_hashCodeは_同じhashCodeを返す() {
            TsushoRehabilitationAfterH214 sut2=new TsushoRehabilitationAfterH214(new RString("10"));
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class getColumnValueテスト extends DbxTestBase {
        @Test
        public void LDNS_入力のパラメタ指定した場合_getColumnValueは_指定したパラメータを返す() {
            assertThat(sut.getColumnValue(), is(new RString("10")));
        }
    }

    public static class toRStringテスト extends DbxTestBase {
        @Test
        public void LDNS_入力のパラメタ指定した場合_toRStringは_指定したパラメータを返す() {
            assertThat(sut.toRString(), is(new RString("10")));
        }
    }

    public static class getMeishoパラメタあるテスト extends DbxTestBase {

        @Test
        public void LDNS_入力のパラメタがnull場合_getMeishoは_emptyを返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214((Code) null);
            assertThat(sut.getMeisho(new FlexibleDate("20150303")), is(RString.EMPTY));
        }

        @Test
        public void LDNS_入力のパラメタが1234567の場合_getMeishoは_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降を返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214(new Code("1234567"));
            assertThat(sut.getMeisho(new FlexibleDate("20150303")), is(new RString("通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降")));
        }
    }

    public static class getMeishoテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnull場合_getMeishoは_emptyを返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214((Code) null);
            assertThat(sut.getMeisho(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeが1234567の場合_getMeishoは_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降を返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214(new Code("1234567"));
            assertThat(sut.getMeisho(), is(new RString("通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降")));
        }
    }

    public static class getRyakushoパラメタあるテスト extends DbxTestBase {

        @Test
        public void LDNS_入力のパラメタがnull場合_getRyakushoは_emptyを返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214((Code) null);
            assertThat(sut.getRyakusho(new FlexibleDate("20150303")), is(RString.EMPTY));
        }

        @Test
        public void LDNS_入力のパラメタが1234567の場合_getRyakushoは_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降を返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214(new Code("1234567"));
            assertThat(sut.getRyakusho(new FlexibleDate("20150303")), is(new RString("通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降")));
        }
    }

    public static class getRyakushoテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnull場合_getRyakushoは_emptyを返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214((Code) null);
            assertThat(sut.getRyakusho(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeが1234567の場合_getRyakushoは_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降を返す() {
            TsushoRehabilitationAfterH214 sut = new TsushoRehabilitationAfterH214(new Code("1234567"));
            assertThat(sut.getRyakusho(), is(new RString("通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_平成21年4月以降")));
        }
    }
}