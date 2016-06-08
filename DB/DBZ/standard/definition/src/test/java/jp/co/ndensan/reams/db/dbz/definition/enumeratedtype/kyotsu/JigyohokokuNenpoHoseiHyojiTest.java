package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 事業報告年報補正表示のテストクラスです。
 * 
 * @author LDNS 
 */
public class JigyohokokuNenpoHoseiHyojiTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        JigyohokokuNenpoHoseiHyoji.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        JigyohokokuNenpoHoseiHyoji.toValue(new RString("99999"));
    }

    @Test
    public void 引数に001を指定した場合_toValueは_保険者_所得段階別第１号被保険者数を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.toValue(new RString("001")), is(JigyohokokuNenpoHoseiHyoji.保険者_所得段階別第１号被保険者数));
    }

    @Test
    public void 引数に101を指定した場合_toValueは_構成市町村_所得段階別第１号被保険者数を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.toValue(new RString("101")), is(JigyohokokuNenpoHoseiHyoji.構成市町村_所得段階別第１号被保険者数));
    }

    @Test
    public void 引数に201を指定した場合_toValueは_旧市町村_所得段階別第１号被保険者数を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.toValue(new RString("201")), is(JigyohokokuNenpoHoseiHyoji.旧市町村_所得段階別第１号被保険者数));
    }

    @Test
    public void 引数に002を指定した場合_toValueは_保険者_現物分_市町村特別給付を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.toValue(new RString("002")), is(JigyohokokuNenpoHoseiHyoji.保険者_現物分_市町村特別給付));
    }

    @Test
    public void 引数に102を指定した場合_toValueは_構成市町村_現物分_市町村特別給付を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.toValue(new RString("102")), is(JigyohokokuNenpoHoseiHyoji.構成市町村_現物分_市町村特別給付));
    }

    @Test
    public void 引数に202を指定した場合_toValueは_旧市町村_現物分_市町村特別給付を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.toValue(new RString("202")), is(JigyohokokuNenpoHoseiHyoji.旧市町村_現物分_市町村特別給付));
    }

    @Test
    public void 引数に003を指定した場合_toValueは_保険者_保険料収納状況_保険給付支払状況を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.toValue(new RString("003")), is(JigyohokokuNenpoHoseiHyoji.保険者_保険料収納状況_保険給付支払状況));
    }

    @Test
    public void 引数に103を指定した場合_toValueは_構成市町村_保険料収納状況_保険給付支払状況を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.toValue(new RString("103")), is(JigyohokokuNenpoHoseiHyoji.構成市町村_保険料収納状況_保険給付支払状況));
    }

    @Test
    public void 引数に203を指定した場合_toValueは_旧市町村_保険料収納状況_保険給付支払状況を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.toValue(new RString("203")), is(JigyohokokuNenpoHoseiHyoji.旧市町村_保険料収納状況_保険給付支払状況));
    }

    @Test
    public void 保険者_所得段階別第１号被保険者数を指定した場合_getコードは_001を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.保険者_所得段階別第１号被保険者数.getコード(), is(new RString("001")));
    }

    @Test
    public void 構成市町村_所得段階別第１号被保険者数を指定した場合_getコードは_101を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.構成市町村_所得段階別第１号被保険者数.getコード(), is(new RString("101")));
    }

    @Test
    public void 旧市町村_所得段階別第１号被保険者数を指定した場合_getコードは_201を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.旧市町村_所得段階別第１号被保険者数.getコード(), is(new RString("201")));
    }

    @Test
    public void 保険者_現物分_市町村特別給付を指定した場合_getコードは_002を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.保険者_現物分_市町村特別給付.getコード(), is(new RString("002")));
    }

    @Test
    public void 構成市町村_現物分_市町村特別給付を指定した場合_getコードは_102を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.構成市町村_現物分_市町村特別給付.getコード(), is(new RString("102")));
    }

    @Test
    public void 旧市町村_現物分_市町村特別給付を指定した場合_getコードは_202を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.旧市町村_現物分_市町村特別給付.getコード(), is(new RString("202")));
    }

    @Test
    public void 保険者_保険料収納状況_保険給付支払状況を指定した場合_getコードは_003を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.保険者_保険料収納状況_保険給付支払状況.getコード(), is(new RString("003")));
    }

    @Test
    public void 構成市町村_保険料収納状況_保険給付支払状況を指定した場合_getコードは_103を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.構成市町村_保険料収納状況_保険給付支払状況.getコード(), is(new RString("103")));
    }

    @Test
    public void 旧市町村_保険料収納状況_保険給付支払状況を指定した場合_getコードは_203を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.旧市町村_保険料収納状況_保険給付支払状況.getコード(), is(new RString("203")));
    }

    @Test
    public void 保険者_所得段階別第１号被保険者数を指定した場合_get名称は_保険者_所得段階別第１号被保険者数を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.保険者_所得段階別第１号被保険者数.get名称(), is(new RString("保険者／所得段階別第１号被保険者数")));
    }

    @Test
    public void 構成市町村_所得段階別第１号被保険者数を指定した場合_get名称は_構成市町村_所得段階別第１号被保険者数を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.構成市町村_所得段階別第１号被保険者数.get名称(), is(new RString("構成市町村／所得段階別第１号被保険者数")));
    }

    @Test
    public void 旧市町村_所得段階別第１号被保険者数を指定した場合_get名称は_旧市町村_所得段階別第１号被保険者数を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.旧市町村_所得段階別第１号被保険者数.get名称(), is(new RString("旧市町村／所得段階別第１号被保険者数")));
    }

    @Test
    public void 保険者_現物分_市町村特別給付を指定した場合_get名称は_保険者_現物分_市町村特別給付を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.保険者_現物分_市町村特別給付.get名称(), is(new RString("保険者／現物分／市町村特別給付")));
    }

    @Test
    public void 構成市町村_現物分_市町村特別給付を指定した場合_get名称は_構成市町村_現物分_市町村特別給付を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.構成市町村_現物分_市町村特別給付.get名称(), is(new RString("構成市町村／現物分／市町村特別給付")));
    }

    @Test
    public void 旧市町村_現物分_市町村特別給付を指定した場合_get名称は_旧市町村_現物分_市町村特別給付を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.旧市町村_現物分_市町村特別給付.get名称(), is(new RString("旧市町村／現物分／市町村特別給付")));
    }

    @Test
    public void 保険者_保険料収納状況_保険給付支払状況を指定した場合_get名称は_保険者_保険料収納状況_保険給付支払状況を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.保険者_保険料収納状況_保険給付支払状況.get名称(), is(new RString("保険者／保険料収納状況・保険給付支払状況")));
    }

    @Test
    public void 構成市町村_保険料収納状況_保険給付支払状況を指定した場合_get名称は_構成市町村_保険料収納状況_保険給付支払状況を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.構成市町村_保険料収納状況_保険給付支払状況.get名称(), is(new RString("構成市町村／保険料収納状況・保険給付支払状況")));
    }

    @Test
    public void 旧市町村_保険料収納状況_保険給付支払状況を指定した場合_get名称は_旧市町村_保険料収納状況_保険給付支払状況を返す() {
        assertThat(JigyohokokuNenpoHoseiHyoji.旧市町村_保険料収納状況_保険給付支払状況.get名称(), is(new RString("旧市町村／保険料収納状況・保険給付支払状況")));
    }

}
