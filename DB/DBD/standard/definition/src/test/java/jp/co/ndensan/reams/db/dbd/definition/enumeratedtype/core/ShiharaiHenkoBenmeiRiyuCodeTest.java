package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 支払方法変更弁明理由コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiharaiHenkoBenmeiRiyuCodeTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiharaiHenkoBenmeiRiyuCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiharaiHenkoBenmeiRiyuCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_公費負担医療の受給を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.toValue(new RString("01")), is(ShiharaiHenkoBenmeiRiyuCode.公費負担医療の受給));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_災害を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.toValue(new RString("02")), is(ShiharaiHenkoBenmeiRiyuCode.災害));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_重大な障害または長期入院を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.toValue(new RString("03")), is(ShiharaiHenkoBenmeiRiyuCode.重大な障害または長期入院));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_滞納保険料の減少を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.toValue(new RString("04")), is(ShiharaiHenkoBenmeiRiyuCode.滞納保険料の減少));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_保険料完納を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.toValue(new RString("05")), is(ShiharaiHenkoBenmeiRiyuCode.保険料完納));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_その他を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.toValue(new RString("99")), is(ShiharaiHenkoBenmeiRiyuCode.その他));
    }

    @Test
    public void 公費負担医療の受給を指定した場合_getコードは_01を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.公費負担医療の受給.getコード(), is(new RString("01")));
    }

    @Test
    public void 災害を指定した場合_getコードは_02を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.災害.getコード(), is(new RString("02")));
    }

    @Test
    public void 重大な障害または長期入院を指定した場合_getコードは_03を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.重大な障害または長期入院.getコード(), is(new RString("03")));
    }

    @Test
    public void 滞納保険料の減少を指定した場合_getコードは_04を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.滞納保険料の減少.getコード(), is(new RString("04")));
    }

    @Test
    public void 保険料完納を指定した場合_getコードは_05を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.保険料完納.getコード(), is(new RString("05")));
    }

    @Test
    public void その他を指定した場合_getコードは_99を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.その他.getコード(), is(new RString("99")));
    }

    @Test
    public void 公費負担医療の受給を指定した場合_get名称は_公費負担医療の受給を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.公費負担医療の受給.get名称(), is(new RString("公費負担医療の受給")));
    }

    @Test
    public void 災害を指定した場合_get名称は_災害を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.災害.get名称(), is(new RString("災害")));
    }

    @Test
    public void 重大な障害または長期入院を指定した場合_get名称は_重大な障害または長期入院を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.重大な障害または長期入院.get名称(), is(new RString("重大な障害または長期入院")));
    }

    @Test
    public void 滞納保険料の減少を指定した場合_get名称は_滞納保険料の減少を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.滞納保険料の減少.get名称(), is(new RString("滞納保険料の減少")));
    }

    @Test
    public void 保険料完納を指定した場合_get名称は_保険料完納を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.保険料完納.get名称(), is(new RString("保険料完納")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(ShiharaiHenkoBenmeiRiyuCode.その他.get名称(), is(new RString("その他")));
    }

}
