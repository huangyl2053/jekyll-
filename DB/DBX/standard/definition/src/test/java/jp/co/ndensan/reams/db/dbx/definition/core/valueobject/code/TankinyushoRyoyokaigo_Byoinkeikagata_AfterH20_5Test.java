package  jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5;
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
 * 短期入所療養介護_病院経過型_平成20年5月以降を表すドメインのテストクラスです。
 *
 * @author LDNS 梁百川
 */
@RunWith(Enclosed.class)
public class TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5Test extends DbxTestBase {

    private static TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut;

    @BeforeClass
    public static void setUp() {
        sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5(new RString("10"));
    }

    /**
     * valueのテストです。
     *
     */
    public static class valueテスト extends DbxTestBase {

        @Test
        public void LDNS_入力のパラメタが10を指定した場合_valueは_10を戻す() {
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
            Object obj = null;
            assertFalse(sut.equals(obj));
        }

        @Test
        public void LDNS_Objectがnull以外かつTankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5ではないの場合_equalsは_falseを戻す() {
            Object obj = new RString("1111");
            assertFalse(sut.equals(obj));
        }

        @Test
        public void LDNS_Objectのcodeとコンストラクタのcodeが不一致の場合_equalsは_falseを戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut2 = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5(new RString("90"));
            assertFalse(sut.equals(sut2));
        }

        @Test
        public void LDNS_Object値とコンストラクタ値が一致の場合_equalsは_trueを戻す() {
            assertTrue(sut.equals(new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5(new RString("10"))));
        }

    }

    /**
     * toStringのテストです。
     *
     */
    public static class toStringテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnullの場合_toStringは_emptyを戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5((Code) null);
            assertThat(sut.toString(), is(RString.EMPTY.toString()));
        }

        @Test
        public void LDNS_codeが1234567の場合_toStringは_1234567を戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5(new Code("1234567"));
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
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut2 = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5(new RString("10"));
            assertThat(sut.hashCode(), is(sut2.hashCode()));
        }
    }

    /**
     * getColumnValueのテストです。
     *
     */
    public static class getColumnValueテスト extends DbxTestBase {

        @Test
        public void LDNS_入力のパラメタが10を指定した場合_getColumnValueは_10を戻す() {
            assertThat(sut.getColumnValue(), is(new RString("10")));
        }
    }

    /**
     * toRStringのテストです。
     *
     */
    public static class toRStringテスト extends DbxTestBase {

        @Test
        public void LDNS_入力のパラメタが10を指定した場合_toRStringは_10を戻す() {
            assertThat(sut.toRString(), is(new RString("10")));
        }
    }

    /**
     * getMeishoのテストです。
     *
     */
    public static class getMeishoパラメタあるテスト extends DbxTestBase {

        @Test
        public void LDNS_入力のパラメタがnull場合_getMeishoは_emptyを戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5((Code) null);
            assertThat(sut.getMeisho(new FlexibleDate("20150303")), is(RString.EMPTY));
        }

        @Test
        public void LDNS_入力のパラメタがnull以外の場合_getMeishoは_短期入所療養介護_病院経過型_平成20年5月以降を戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5(new Code("1234567"));
            assertThat(sut.getMeisho(new FlexibleDate("20150303")), is(new RString("短期入所療養介護_病院経過型_平成20年5月以降")));
        }
    }

    /**
     * getMeishoのテストです。
     *
     */
    public static class getMeishoテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnull場合_getMeishoは_emptyを戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5((Code) null);
            assertThat(sut.getMeisho(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeがnull以外の場合_getMeishoは_短期入所療養介護_病院経過型_平成20年5月以降を戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5(new Code("1234567"));
            assertThat(sut.getMeisho(), is(new RString("短期入所療養介護_病院経過型_平成20年5月以降")));
        }
    }

    /**
     * getRyakushoのテストです。
     *
     */
    public static class getRyakushoパラメタあるテスト extends DbxTestBase {

        @Test
        public void LDNS_入力のパラメタがnull場合_getRyakushoは_emptyを戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5((Code) null);
            assertThat(sut.getRyakusho(new FlexibleDate("20150303")), is(RString.EMPTY));
        }

        @Test
        public void LDNS_入力のパラメタがnull以外の場合_getRyakushoは_短期入所療養介護_病院経過型_平成20年5月以降を戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5(new Code("1234567"));
            assertThat(sut.getRyakusho(new FlexibleDate("20150303")), is(new RString("短期入所療養介護_病院経過型_平成20年5月以降")));
        }
    }

    /**
     * getRyakushoのテストです。
     *
     */
    public static class getRyakushoテスト extends DbxTestBase {

        @Test
        public void LDNS_codeがnull場合_getRyakushoは_emptyを戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5((Code) null);
            assertThat(sut.getRyakusho(), is(RString.EMPTY));
        }

        @Test
        public void LDNS_codeがnull以外の場合_getRyakushoは_短期入所療養介護_病院経過型_平成20年5月以降を戻す() {
            TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5 sut = new TankinyushoRyoyokaigo_Byoinkeikagata_AfterH20_5(new Code("1234567"));
            assertThat(sut.getRyakusho(), is(new RString("短期入所療養介護_病院経過型_平成20年5月以降")));
        }
    }
}
