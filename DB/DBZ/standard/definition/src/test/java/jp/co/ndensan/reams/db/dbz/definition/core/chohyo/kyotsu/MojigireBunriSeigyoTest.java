package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 文字切れ分離制御のテストクラスです。
 * 
 * @author LDNS 
 */
public class MojigireBunriSeigyoTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        MojigireBunriSeigyo.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        MojigireBunriSeigyo.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_分けないを返す() {
        assertThat(MojigireBunriSeigyo.toValue(new RString("0")), is(MojigireBunriSeigyo.分けない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_分けるを返す() {
        assertThat(MojigireBunriSeigyo.toValue(new RString("1")), is(MojigireBunriSeigyo.分ける));
    }

    @Test
    public void 分けないを指定した場合_getコードは_0を返す() {
        assertThat(MojigireBunriSeigyo.分けない.getコード(), is(new RString("0")));
    }

    @Test
    public void 分けるを指定した場合_getコードは_1を返す() {
        assertThat(MojigireBunriSeigyo.分ける.getコード(), is(new RString("1")));
    }

    @Test
    public void 分けないを指定した場合_get名称は_山分けしないを返す() {
        assertThat(MojigireBunriSeigyo.分けない.get名称(), is(new RString("山分けしない")));
    }

    @Test
    public void 分けるを指定した場合_get名称は_山分けするを返す() {
        assertThat(MojigireBunriSeigyo.分ける.get名称(), is(new RString("山分けする")));
    }

    @Test
    public void 分けないを指定した場合_get略称は_分けないを返す() {
        assertThat(MojigireBunriSeigyo.分けない.get略称(), is(new RString("分けない")));
    }

    @Test
    public void 分けるを指定した場合_get略称は_分けるを返す() {
        assertThat(MojigireBunriSeigyo.分ける.get略称(), is(new RString("分ける")));
    }

}
