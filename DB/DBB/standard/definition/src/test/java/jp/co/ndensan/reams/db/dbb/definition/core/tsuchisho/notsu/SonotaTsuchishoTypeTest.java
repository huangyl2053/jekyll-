package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * その他納入通知書タイプのテストクラスです。
 *
 * @author LDNS
 */
public class SonotaTsuchishoTypeTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SonotaTsuchishoType.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SonotaTsuchishoType.toValue(new RString("99999"));
    }

    @Test
    public void 引数に001を指定した場合_toValueは_標準版ブックタイプを返す() {
        assertThat(SonotaTsuchishoType.toValue(new RString("001")), is(SonotaTsuchishoType.標準版ブックタイプ));
    }

    @Test
    public void 引数に101を指定した場合_toValueは_標準版コンビニタイプを返す() {
        assertThat(SonotaTsuchishoType.toValue(new RString("101")), is(SonotaTsuchishoType.標準版コンビニタイプ));
    }

    @Test
    public void 引数に10Eを指定した場合_toValueは_飯田市版コンビニタイプを返す() {
        assertThat(SonotaTsuchishoType.toValue(new RString("10E")), is(SonotaTsuchishoType.飯田市版コンビニタイプ));
    }

    @Test
    public void 引数に10Cを指定した場合_toValueは_上田市版コンビニタイプを返す() {
        assertThat(SonotaTsuchishoType.toValue(new RString("10C")), is(SonotaTsuchishoType.上田市版コンビニタイプ));
    }

    @Test
    public void 標準版ブックタイプを指定した場合_getコードは_001を返す() {
        assertThat(SonotaTsuchishoType.標準版ブックタイプ.getコード(), is(new RString("001")));
    }

    @Test
    public void 標準版コンビニタイプを指定した場合_getコードは_101を返す() {
        assertThat(SonotaTsuchishoType.標準版コンビニタイプ.getコード(), is(new RString("101")));
    }

    @Test
    public void 飯田市版コンビニタイプを指定した場合_getコードは_10Eを返す() {
        assertThat(SonotaTsuchishoType.飯田市版コンビニタイプ.getコード(), is(new RString("10E")));
    }

    @Test
    public void 上田市版コンビニタイプを指定した場合_getコードは_10Cを返す() {
        assertThat(SonotaTsuchishoType.上田市版コンビニタイプ.getコード(), is(new RString("10C")));
    }

    @Test
    public void 標準版ブックタイプを指定した場合_get名称は_標準版ブックタイプを返す() {
        assertThat(SonotaTsuchishoType.標準版ブックタイプ.get名称(), is(new RString("標準版ブックタイプ")));
    }

    @Test
    public void 標準版コンビニタイプを指定した場合_get名称は_標準版コンビニタイプを返す() {
        assertThat(SonotaTsuchishoType.標準版コンビニタイプ.get名称(), is(new RString("標準版コンビニタイプ")));
    }

    @Test
    public void 飯田市版コンビニタイプを指定した場合_get名称は_飯田市版コンビニタイプを返す() {
        assertThat(SonotaTsuchishoType.飯田市版コンビニタイプ.get名称(), is(new RString("飯田市版コンビニタイプ")));
    }

    @Test
    public void 上田市版コンビニタイプを指定した場合_get名称は_上田市版コンビニタイプを返す() {
        assertThat(SonotaTsuchishoType.上田市版コンビニタイプ.get名称(), is(new RString("上田市版コンビニタイプ")));
    }

}
