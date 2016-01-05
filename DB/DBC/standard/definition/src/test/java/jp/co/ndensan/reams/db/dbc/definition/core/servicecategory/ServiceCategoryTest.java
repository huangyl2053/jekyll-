package jp.co.ndensan.reams.db.dbc.definition.core.servicecategory;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 給付実績集計の合計対象のテストクラスです。
 * 
 * @author LDNS 
 */
public class ServiceCategoryTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ServiceCategory.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ServiceCategory.toValue(new RString("99999"));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_居宅サービスを返す() {
        assertThat(ServiceCategory.toValue(new RString("無し")), is(ServiceCategory.居宅サービス));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_施設サービスを返す() {
        assertThat(ServiceCategory.toValue(new RString("無し")), is(ServiceCategory.施設サービス));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_地域密着型サービスを返す() {
        assertThat(ServiceCategory.toValue(new RString("無し")), is(ServiceCategory.地域密着型サービス));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_合計対象外を返す() {
        assertThat(ServiceCategory.toValue(new RString("無し")), is(ServiceCategory.合計対象外));
    }

    @Test
    public void 居宅サービスを指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategory.居宅サービス.getコード(), is(new RString("無し")));
    }

    @Test
    public void 施設サービスを指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategory.施設サービス.getコード(), is(new RString("無し")));
    }

    @Test
    public void 地域密着型サービスを指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategory.地域密着型サービス.getコード(), is(new RString("無し")));
    }

    @Test
    public void 合計対象外を指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategory.合計対象外.getコード(), is(new RString("無し")));
    }

    @Test
    public void 居宅サービスを指定した場合_get名称は_居宅サービスを返す() {
        assertThat(ServiceCategory.居宅サービス.get名称(), is(new RString("居宅サービス")));
    }

    @Test
    public void 施設サービスを指定した場合_get名称は_施設サービスを返す() {
        assertThat(ServiceCategory.施設サービス.get名称(), is(new RString("施設サービス")));
    }

    @Test
    public void 地域密着型サービスを指定した場合_get名称は_地域密着型サービスを返す() {
        assertThat(ServiceCategory.地域密着型サービス.get名称(), is(new RString("地域密着型サービス")));
    }

    @Test
    public void 合計対象外を指定した場合_get名称は_合計対象外を返す() {
        assertThat(ServiceCategory.合計対象外.get名称(), is(new RString("合計対象外")));
    }

}
