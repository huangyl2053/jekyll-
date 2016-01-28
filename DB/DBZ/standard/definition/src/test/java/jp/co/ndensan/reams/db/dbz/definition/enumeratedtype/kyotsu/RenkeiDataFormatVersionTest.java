package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 連携データフォーマットバージョンのテストクラスです。
 *
 * @author LDNS
 */
public class RenkeiDataFormatVersionTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        RenkeiDataFormatVersion.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        RenkeiDataFormatVersion.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_ＲⅢ介護標準_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("1")), is(RenkeiDataFormatVersion.ＲⅢ介護標準_固定長));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_ＲⅢ介護標準_ＣＳＶを返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("2")), is(RenkeiDataFormatVersion.ＲⅢ介護標準_ＣＳＶ));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_Ｒ_ＮＥＴ介護標準_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("3")), is(RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_固定長));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_Ｒ_ＮＥＴ介護標準_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("4")), is(RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_ＣＳＶ版));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_他社介護標準_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("5")), is(RenkeiDataFormatVersion.他社介護標準_固定長));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_他社介護標準_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("6")), is(RenkeiDataFormatVersion.他社介護標準_ＣＳＶ版));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_SBS独自_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("7")), is(RenkeiDataFormatVersion.SBS独自_固定長));
    }

    @Test
    public void 引数に8を指定した場合_toValueは_SBS独自_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("8")), is(RenkeiDataFormatVersion.SBS独自_ＣＳＶ版));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_後期高齢_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("9")), is(RenkeiDataFormatVersion.後期高齢_固定長));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_後期高齢_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("10")), is(RenkeiDataFormatVersion.後期高齢_ＣＳＶ版));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_両毛独自_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("11")), is(RenkeiDataFormatVersion.両毛独自_固定長));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_両毛独自_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("12")), is(RenkeiDataFormatVersion.両毛独自_ＣＳＶ版));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_Ｒｅａｍｓ介護標準_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("13")), is(RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_固定長));
    }

    @Test
    public void 引数に14を指定した場合_toValueは_Ｒｅａｍｓ介護標準_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.toValue(new RString("14")), is(RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_ＣＳＶ版));
    }

    @Test
    public void ＲⅢ介護標準_固定長を指定した場合_getコードは_1を返す() {
        assertThat(RenkeiDataFormatVersion.ＲⅢ介護標準_固定長.getコード(), is(new RString("1")));
    }

    @Test
    public void ＲⅢ介護標準_ＣＳＶを指定した場合_getコードは_2を返す() {
        assertThat(RenkeiDataFormatVersion.ＲⅢ介護標準_ＣＳＶ.getコード(), is(new RString("2")));
    }

    @Test
    public void Ｒ_ＮＥＴ介護標準_固定長を指定した場合_getコードは_3を返す() {
        assertThat(RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_固定長.getコード(), is(new RString("3")));
    }

    @Test
    public void Ｒ_ＮＥＴ介護標準_ＣＳＶ版を指定した場合_getコードは_4を返す() {
        assertThat(RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_ＣＳＶ版.getコード(), is(new RString("4")));
    }

    @Test
    public void 他社介護標準_固定長を指定した場合_getコードは_5を返す() {
        assertThat(RenkeiDataFormatVersion.他社介護標準_固定長.getコード(), is(new RString("5")));
    }

    @Test
    public void 他社介護標準_ＣＳＶ版を指定した場合_getコードは_6を返す() {
        assertThat(RenkeiDataFormatVersion.他社介護標準_ＣＳＶ版.getコード(), is(new RString("6")));
    }

    @Test
    public void SBS独自_固定長を指定した場合_getコードは_7を返す() {
        assertThat(RenkeiDataFormatVersion.SBS独自_固定長.getコード(), is(new RString("7")));
    }

    @Test
    public void SBS独自_ＣＳＶ版を指定した場合_getコードは_8を返す() {
        assertThat(RenkeiDataFormatVersion.SBS独自_ＣＳＶ版.getコード(), is(new RString("8")));
    }

    @Test
    public void 後期高齢_固定長を指定した場合_getコードは_9を返す() {
        assertThat(RenkeiDataFormatVersion.後期高齢_固定長.getコード(), is(new RString("9")));
    }

    @Test
    public void 後期高齢_ＣＳＶ版を指定した場合_getコードは_10を返す() {
        assertThat(RenkeiDataFormatVersion.後期高齢_ＣＳＶ版.getコード(), is(new RString("10")));
    }

    @Test
    public void 両毛独自_固定長を指定した場合_getコードは_11を返す() {
        assertThat(RenkeiDataFormatVersion.両毛独自_固定長.getコード(), is(new RString("11")));
    }

    @Test
    public void 両毛独自_ＣＳＶ版を指定した場合_getコードは_12を返す() {
        assertThat(RenkeiDataFormatVersion.両毛独自_ＣＳＶ版.getコード(), is(new RString("12")));
    }

    @Test
    public void Ｒｅａｍｓ介護標準_固定長を指定した場合_getコードは_13を返す() {
        assertThat(RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_固定長.getコード(), is(new RString("13")));
    }

    @Test
    public void Ｒｅａｍｓ介護標準_ＣＳＶ版を指定した場合_getコードは_14を返す() {
        assertThat(RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_ＣＳＶ版.getコード(), is(new RString("14")));
    }

    @Test
    public void ＲⅢ介護標準_固定長を指定した場合_get名称は_ＲⅢ介護標準_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.ＲⅢ介護標準_固定長.get名称(), is(new RString("ＲⅢ介護標準（固定長）")));
    }

    @Test
    public void ＲⅢ介護標準_ＣＳＶを指定した場合_get名称は_ＲⅢ介護標準_ＣＳＶを返す() {
        assertThat(RenkeiDataFormatVersion.ＲⅢ介護標準_ＣＳＶ.get名称(), is(new RString("ＲⅢ介護標準（ＣＳＶ）")));
    }

    @Test
    public void Ｒ_ＮＥＴ介護標準_固定長を指定した場合_get名称は_Ｒ_ＮＥＴ介護標準_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_固定長.get名称(), is(new RString("Ｒ．ＮＥＴ介護標準（固定長）")));
    }

    @Test
    public void Ｒ_ＮＥＴ介護標準_ＣＳＶ版を指定した場合_get名称は_Ｒ_ＮＥＴ介護標準_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_ＣＳＶ版.get名称(), is(new RString("Ｒ．ＮＥＴ介護標準（ＣＳＶ版）")));
    }

    @Test
    public void 他社介護標準_固定長を指定した場合_get名称は_他社介護標準_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.他社介護標準_固定長.get名称(), is(new RString("他社介護標準（固定長）")));
    }

    @Test
    public void 他社介護標準_ＣＳＶ版を指定した場合_get名称は_他社介護標準_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.他社介護標準_ＣＳＶ版.get名称(), is(new RString("他社介護標準（ＣＳＶ版）")));
    }

    @Test
    public void SBS独自_固定長を指定した場合_get名称は_SBS独自_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.SBS独自_固定長.get名称(), is(new RString("SBS独自（固定長）")));
    }

    @Test
    public void SBS独自_ＣＳＶ版を指定した場合_get名称は_SBS独自_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.SBS独自_ＣＳＶ版.get名称(), is(new RString("SBS独自（ＣＳＶ版）")));
    }

    @Test
    public void 後期高齢_固定長を指定した場合_get名称は_後期高齢_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.後期高齢_固定長.get名称(), is(new RString("後期高齢（固定長）")));
    }

    @Test
    public void 後期高齢_ＣＳＶ版を指定した場合_get名称は_後期高齢_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.後期高齢_ＣＳＶ版.get名称(), is(new RString("後期高齢（ＣＳＶ版）")));
    }

    @Test
    public void 両毛独自_固定長を指定した場合_get名称は_両毛独自_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.両毛独自_固定長.get名称(), is(new RString("両毛独自（固定長）")));
    }

    @Test
    public void 両毛独自_ＣＳＶ版を指定した場合_get名称は_両毛独自_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.両毛独自_ＣＳＶ版.get名称(), is(new RString("両毛独自（ＣＳＶ版）")));
    }

    @Test
    public void Ｒｅａｍｓ介護標準_固定長を指定した場合_get名称は_Ｒｅａｍｓ介護標準_固定長を返す() {
        assertThat(RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_固定長.get名称(), is(new RString("Ｒｅａｍｓ介護標準（固定長）")));
    }

    @Test
    public void Ｒｅａｍｓ介護標準_ＣＳＶ版を指定した場合_get名称は_Ｒｅａｍｓ介護標準_ＣＳＶ版を返す() {
        assertThat(RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_ＣＳＶ版.get名称(), is(new RString("Ｒｅａｍｓ介護標準（ＣＳＶ版）")));
    }

}
