package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * エラーコードのテストクラスです。
 *
 * @author LDNS
 */
public class ErrorCodeTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ErrorCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ErrorCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0801を指定した場合_toValueは_被保険者台帳データなしを返す() {
        assertThat(ErrorCode.toValue(new RString("0801")), is(ErrorCode.被保険者台帳データなし));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_資格と住基に不整合ありを返す() {
        assertThat(ErrorCode.toValue(new RString("02")), is(ErrorCode.資格と住基に不整合あり));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_世帯員所得データなしを返す() {
        assertThat(ErrorCode.toValue(new RString("03")), is(ErrorCode.世帯員所得データなし));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_賦課に減免ありを返す() {
        assertThat(ErrorCode.toValue(new RString("04")), is(ErrorCode.賦課に減免あり));
    }

    @Test
    public void 被保険者台帳データなしを指定した場合_getコードは_0801を返す() {
        assertThat(ErrorCode.被保険者台帳データなし.getコード(), is(new RString("0801")));
    }

    @Test
    public void 資格と住基に不整合ありを指定した場合_getコードは_02を返す() {
        assertThat(ErrorCode.資格と住基に不整合あり.getコード(), is(new RString("02")));
    }

    @Test
    public void 世帯員所得データなしを指定した場合_getコードは_03を返す() {
        assertThat(ErrorCode.世帯員所得データなし.getコード(), is(new RString("03")));
    }

    @Test
    public void 賦課に減免ありを指定した場合_getコードは_04を返す() {
        assertThat(ErrorCode.賦課に減免あり.getコード(), is(new RString("04")));
    }

    @Test
    public void 被保険者台帳データなしを指定した場合_get名称は_被保険者台帳データなしを返す() {
        assertThat(ErrorCode.被保険者台帳データなし.get名称(), is(new RString("被保険者台帳データなし")));
    }

    @Test
    public void 資格と住基に不整合ありを指定した場合_get名称は_資格と住基に不整合ありを返す() {
        assertThat(ErrorCode.資格と住基に不整合あり.get名称(), is(new RString("資格と住基に不整合あり")));
    }

    @Test
    public void 世帯員所得データなしを指定した場合_get名称は_世帯員所得データなしを返す() {
        assertThat(ErrorCode.世帯員所得データなし.get名称(), is(new RString("世帯員所得データなし")));
    }

    @Test
    public void 賦課に減免ありを指定した場合_get名称は_賦課に減免ありを返す() {
        assertThat(ErrorCode.賦課に減免あり.get名称(), is(new RString("賦課に減免あり")));
    }

}
