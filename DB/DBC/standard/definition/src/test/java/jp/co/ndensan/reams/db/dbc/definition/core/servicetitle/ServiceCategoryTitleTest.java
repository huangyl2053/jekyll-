package jp.co.ndensan.reams.db.dbc.definition.core.servicetitle;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * タイトルのテストクラスです。
 * 
 * @author LDNS 
 */
public class ServiceCategoryTitleTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ServiceCategoryTitle.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ServiceCategoryTitle.toValue(new RString("99999"));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_指定居宅サービスを返す() {
        assertThat(ServiceCategoryTitle.toValue(new RString("無し")), is(ServiceCategoryTitle.指定居宅サービス));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_居宅介護を返す() {
        assertThat(ServiceCategoryTitle.toValue(new RString("無し")), is(ServiceCategoryTitle.居宅介護));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_指定施設サービス等を返す() {
        assertThat(ServiceCategoryTitle.toValue(new RString("無し")), is(ServiceCategoryTitle.指定施設サービス等));
    }

    @Test
    public void 指定居宅サービスを指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategoryTitle.指定居宅サービス.getコード(), is(new RString("無し")));
    }

    @Test
    public void 居宅介護を指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategoryTitle.居宅介護.getコード(), is(new RString("無し")));
    }

    @Test
    public void 指定施設サービス等を指定した場合_getコードは_無しを返す() {
        assertThat(ServiceCategoryTitle.指定施設サービス等.getコード(), is(new RString("無し")));
    }

    @Test
    public void 指定居宅サービスを指定した場合_get名称は_指定居宅サービスを返す() {
        assertThat(ServiceCategoryTitle.指定居宅サービス.get名称(), is(new RString("指定居宅サービス")));
    }

    @Test
    public void 居宅介護を指定した場合_get名称は_居宅介護を返す() {
        assertThat(ServiceCategoryTitle.居宅介護.get名称(), is(new RString("居宅介護")));
    }

    @Test
    public void 指定施設サービス等を指定した場合_get名称は_指定施設サービス等を返す() {
        assertThat(ServiceCategoryTitle.指定施設サービス等.get名称(), is(new RString("指定施設サービス等")));
    }

}
