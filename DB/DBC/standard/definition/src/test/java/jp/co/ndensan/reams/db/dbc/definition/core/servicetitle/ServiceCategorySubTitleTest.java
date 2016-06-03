package jp.co.ndensan.reams.db.dbc.definition.core.servicetitle;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * サブタイトルのテストクラスです。
 * 
 * @author LDNS 
 */
public class ServiceCategorySubTitleTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ServiceCategorySubTitle.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ServiceCategorySubTitle.toValue(new RString("99999"));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_訪問通所を返す() {
        assertThat(ServiceCategorySubTitle.toValue(new RString("無し")), is(ServiceCategorySubTitle.訪問通所));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_短期入所を返す() {
        assertThat(ServiceCategorySubTitle.toValue(new RString("無し")), is(ServiceCategorySubTitle.短期入所));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_地域密着を返す() {
        assertThat(ServiceCategorySubTitle.toValue(new RString("無し")), is(ServiceCategorySubTitle.地域密着));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_サブタイトルなしを返す() {
        assertThat(ServiceCategorySubTitle.toValue(new RString("無し")), is(ServiceCategorySubTitle.サブタイトルなし));
    }

    @Test
    public void 訪問通所を指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategorySubTitle.訪問通所.getコード(), is(new RString("無し")));
    }

    @Test
    public void 短期入所を指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategorySubTitle.短期入所.getコード(), is(new RString("無し")));
    }

    @Test
    public void 地域密着を指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategorySubTitle.地域密着.getコード(), is(new RString("無し")));
    }

    @Test
    public void サブタイトルなしを指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategorySubTitle.サブタイトルなし.getコード(), is(new RString("無し")));
    }

    @Test
    public void 訪問通所を指定した場合_get名称は_訪問通所を返す() {
        assertThat(ServiceCategorySubTitle.訪問通所.get名称(), is(new RString("訪問通所")));
    }

    @Test
    public void 短期入所を指定した場合_get名称は_短期入所を返す() {
        assertThat(ServiceCategorySubTitle.短期入所.get名称(), is(new RString("短期入所")));
    }

    @Test
    public void 地域密着を指定した場合_get名称は_地域密着を返す() {
        assertThat(ServiceCategorySubTitle.地域密着.get名称(), is(new RString("地域密着")));
    }

    @Test
    public void サブタイトルなしを指定した場合_get名称は_サブタイトルなしを返す() {
        assertThat(ServiceCategorySubTitle.サブタイトルなし.get名称(), is(new RString("サブタイトルなし")));
    }

}
