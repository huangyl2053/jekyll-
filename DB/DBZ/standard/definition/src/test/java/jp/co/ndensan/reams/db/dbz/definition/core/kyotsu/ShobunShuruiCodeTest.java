package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 処分種類コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class ShobunShuruiCodeTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShobunShuruiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShobunShuruiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_要介護認定又は要支援認定に関する処分を返す() {
        assertThat(ShobunShuruiCode.toValue(new RString("01")), is(ShobunShuruiCode.要介護認定又は要支援認定に関する処分));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_被保険者証の交付の請求に関する処分を返す() {
        assertThat(ShobunShuruiCode.toValue(new RString("02")), is(ShobunShuruiCode.被保険者証の交付の請求に関する処分));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_03居宅介護サービス費等の支給を返す() {
        assertThat(ShobunShuruiCode.toValue(new RString("03")), is(ShobunShuruiCode.居宅介護サービス費等の支給));
    }

      @Test
    public void 引数に05を指定した場合_toValueは_給付制限に関する処分を返す() {
        assertThat(ShobunShuruiCode.toValue(new RString("04")), is(ShobunShuruiCode.給付制限に関する処分));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_保険料に関する処分を返す() {
        assertThat(ShobunShuruiCode.toValue(new RString("05")), is(ShobunShuruiCode.保険料に関する処分));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_不正利得に関る徴収金等に係る賦課徴収を返す() {
        assertThat(ShobunShuruiCode.toValue(new RString("06")), is(ShobunShuruiCode.不正利得に関る徴収金等に係る賦課徴収));
    }

    @Test
    public void 要介護認定又は要支援認定に関する処分を指定した場合_getコードは_01を返す() {
        assertThat(ShobunShuruiCode.要介護認定又は要支援認定に関する処分.getコード(), is(new RString("01")));
    }

    @Test
    public void 被保険者証の交付の請求に関する処分を指定した場合_getコードは_02を返す() {
        assertThat(ShobunShuruiCode.被保険者証の交付の請求に関する処分.getコード(), is(new RString("02")));
    }

    @Test
    public void _03居宅介護サービス費等の支給を指定した場合_getコードは_03を返す() {
        assertThat(ShobunShuruiCode.居宅介護サービス費等の支給.getコード(), is(new RString("03")));
    }

    @Test
    public void 給付制限に関する処分を指定した場合_getコードは_05を返す() {
        assertThat(ShobunShuruiCode.給付制限に関する処分.getコード(), is(new RString("04")));
    }

    @Test
    public void 保険料に関する処分を指定した場合_getコードは_06を返す() {
        assertThat(ShobunShuruiCode.保険料に関する処分.getコード(), is(new RString("05")));
    }

    @Test
    public void 不正利得に関る徴収金等に係る賦課徴収を指定した場合_getコードは_07を返す() {
        assertThat(ShobunShuruiCode.不正利得に関る徴収金等に係る賦課徴収.getコード(), is(new RString("06")));
    }

    @Test
    public void 要介護認定又は要支援認定に関する処分を指定した場合_get名称は_要介護認定又は要支援認定に関する処分を返す() {
        assertThat(ShobunShuruiCode.要介護認定又は要支援認定に関する処分.get名称(), is(new RString("要介護認定又は要支援認定に関する処分")));
    }

    @Test
    public void 被保険者証の交付の請求に関する処分を指定した場合_get名称は_被保険者証の交付の請求に関する処分を返す() {
        assertThat(ShobunShuruiCode.被保険者証の交付の請求に関する処分.get名称(), is(new RString("被保険者証の交付の請求に関する処分")));
    }

    @Test
    public void _03居宅介護サービス費等の支給を指定した場合_get名称は_居宅介護サービス費等の支給を返す() {
        assertThat(ShobunShuruiCode.居宅介護サービス費等の支給.get名称(), is(new RString("居宅介護サービス費等の支給")));
    }

    @Test
    public void 給付制限に関する処分を指定した場合_get名称は_給付制限に関する処分を返す() {
        assertThat(ShobunShuruiCode.給付制限に関する処分.get名称(), is(new RString("給付制限に関する処分")));
    }

    @Test
    public void 保険料に関する処分を指定した場合_get名称は_保険料に関する処分を返す() {
        assertThat(ShobunShuruiCode.保険料に関する処分.get名称(), is(new RString("保険料に関する処分")));
    }

    @Test
    public void 不正利得に関る徴収金等に係る賦課徴収を指定した場合_get名称は_不正利得に関る徴収金等に係る賦課徴収を返す() {
        assertThat(ShobunShuruiCode.不正利得に関る徴収金等に係る賦課徴収.get名称(), is(new RString("不正利得に関る徴収金等に係る賦課徴収")));
    }

}
