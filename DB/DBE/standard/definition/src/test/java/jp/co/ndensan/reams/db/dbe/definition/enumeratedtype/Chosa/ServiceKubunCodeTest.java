package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 現在のサービス区分コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class ServiceKubunCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ServiceKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ServiceKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_予防給付サービスを返す() {
        assertThat(ServiceKubunCode.toValue(new RString("1")), is(ServiceKubunCode.予防給付サービス));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_介護給付サービスを返す() {
        assertThat(ServiceKubunCode.toValue(new RString("2")), is(ServiceKubunCode.介護給付サービス));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_なしを返す() {
        assertThat(ServiceKubunCode.toValue(new RString("9")), is(ServiceKubunCode.なし));
    }

    @Test
    public void 予防給付サービスを指定した場合_getコードは_1を返す() {
        assertThat(ServiceKubunCode.予防給付サービス.getコード(), is(new RString("1")));
    }

    @Test
    public void 介護給付サービスを指定した場合_getコードは_2を返す() {
        assertThat(ServiceKubunCode.介護給付サービス.getコード(), is(new RString("2")));
    }

    @Test
    public void なしを指定した場合_getコードは_9を返す() {
        assertThat(ServiceKubunCode.なし.getコード(), is(new RString("9")));
    }

    @Test
    public void 予防給付サービスを指定した場合_get名称は_予防給付サービスを返す() {
        assertThat(ServiceKubunCode.予防給付サービス.get名称(), is(new RString("予防給付サービス")));
    }

    @Test
    public void 介護給付サービスを指定した場合_get名称は_介護給付サービスを返す() {
        assertThat(ServiceKubunCode.介護給付サービス.get名称(), is(new RString("介護給付サービス")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(ServiceKubunCode.なし.get名称(), is(new RString("なし")));
    }

}
