package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 直近異動事由コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class ChokkinIdoJiyuCodeTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChokkinIdoJiyuCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChokkinIdoJiyuCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_未登録を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("00")), is(ChokkinIdoJiyuCode.未登録));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_追加_認定を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("01")), is(ChokkinIdoJiyuCode.追加_認定));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_要介護度変更申請認定を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("02")), is(ChokkinIdoJiyuCode.要介護度変更申請認定));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_要介護度変更申請却下を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("03")), is(ChokkinIdoJiyuCode.要介護度変更申請却下));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_サービス種類変更申請認定を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("04")), is(ChokkinIdoJiyuCode.サービス種類変更申請認定));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_サービス種類変更申請却下を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("05")), is(ChokkinIdoJiyuCode.サービス種類変更申請却下));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_削除を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("06")), is(ChokkinIdoJiyuCode.削除));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_修正を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("07")), is(ChokkinIdoJiyuCode.修正));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_受給申請却下を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("08")), is(ChokkinIdoJiyuCode.受給申請却下));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_削除回復を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("09")), is(ChokkinIdoJiyuCode.削除回復));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_職権記載を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("10")), is(ChokkinIdoJiyuCode.職権記載));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_職権修正を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("11")), is(ChokkinIdoJiyuCode.職権修正));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_職権取消を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("12")), is(ChokkinIdoJiyuCode.職権取消));
    }

    @Test
    public void 引数に20を指定した場合_toValueは_履歴修正を返す() {
        assertThat(ChokkinIdoJiyuCode.toValue(new RString("20")), is(ChokkinIdoJiyuCode.履歴修正));
    }

    @Test
    public void 未登録を指定した場合_getコードは_00を返す() {
        assertThat(ChokkinIdoJiyuCode.未登録.getコード(), is(new RString("00")));
    }

    @Test
    public void 追加_認定を指定した場合_getコードは_01を返す() {
        assertThat(ChokkinIdoJiyuCode.追加_認定.getコード(), is(new RString("01")));
    }

    @Test
    public void 要介護度変更申請認定を指定した場合_getコードは_02を返す() {
        assertThat(ChokkinIdoJiyuCode.要介護度変更申請認定.getコード(), is(new RString("02")));
    }

    @Test
    public void 要介護度変更申請却下を指定した場合_getコードは_03を返す() {
        assertThat(ChokkinIdoJiyuCode.要介護度変更申請却下.getコード(), is(new RString("03")));
    }

    @Test
    public void サービス種類変更申請認定を指定した場合_getコードは_04を返す() {
        assertThat(ChokkinIdoJiyuCode.サービス種類変更申請認定.getコード(), is(new RString("04")));
    }

    @Test
    public void サービス種類変更申請却下を指定した場合_getコードは_05を返す() {
        assertThat(ChokkinIdoJiyuCode.サービス種類変更申請却下.getコード(), is(new RString("05")));
    }

    @Test
    public void 削除を指定した場合_getコードは_06を返す() {
        assertThat(ChokkinIdoJiyuCode.削除.getコード(), is(new RString("06")));
    }

    @Test
    public void 修正を指定した場合_getコードは_07を返す() {
        assertThat(ChokkinIdoJiyuCode.修正.getコード(), is(new RString("07")));
    }

    @Test
    public void 受給申請却下を指定した場合_getコードは_08を返す() {
        assertThat(ChokkinIdoJiyuCode.受給申請却下.getコード(), is(new RString("08")));
    }

    @Test
    public void 削除回復を指定した場合_getコードは_09を返す() {
        assertThat(ChokkinIdoJiyuCode.削除回復.getコード(), is(new RString("09")));
    }

    @Test
    public void 職権記載を指定した場合_getコードは_10を返す() {
        assertThat(ChokkinIdoJiyuCode.職権記載.getコード(), is(new RString("10")));
    }

    @Test
    public void 職権修正を指定した場合_getコードは_11を返す() {
        assertThat(ChokkinIdoJiyuCode.職権修正.getコード(), is(new RString("11")));
    }

    @Test
    public void 職権取消を指定した場合_getコードは_12を返す() {
        assertThat(ChokkinIdoJiyuCode.職権取消.getコード(), is(new RString("12")));
    }

    @Test
    public void 履歴修正を指定した場合_getコードは_20を返す() {
        assertThat(ChokkinIdoJiyuCode.履歴修正.getコード(), is(new RString("20")));
    }

    @Test
    public void 未登録を指定した場合_get名称は_未登録を返す() {
        assertThat(ChokkinIdoJiyuCode.未登録.get名称(), is(new RString("未登録")));
    }

    @Test
    public void 追加_認定を指定した場合_get名称は_追加_認定を返す() {
        assertThat(ChokkinIdoJiyuCode.追加_認定.get名称(), is(new RString("追加（認定）")));
    }

    @Test
    public void 要介護度変更申請認定を指定した場合_get名称は_要介護度変更申請認定を返す() {
        assertThat(ChokkinIdoJiyuCode.要介護度変更申請認定.get名称(), is(new RString("要介護度変更申請認定")));
    }

    @Test
    public void 要介護度変更申請却下を指定した場合_get名称は_要介護度変更申請却下を返す() {
        assertThat(ChokkinIdoJiyuCode.要介護度変更申請却下.get名称(), is(new RString("要介護度変更申請却下")));
    }

    @Test
    public void サービス種類変更申請認定を指定した場合_get名称は_サービス種類変更申請認定を返す() {
        assertThat(ChokkinIdoJiyuCode.サービス種類変更申請認定.get名称(), is(new RString("サービス種類変更申請認定")));
    }

    @Test
    public void サービス種類変更申請却下を指定した場合_get名称は_サービス種類変更申請却下を返す() {
        assertThat(ChokkinIdoJiyuCode.サービス種類変更申請却下.get名称(), is(new RString("サービス種類変更申請却下")));
    }

    @Test
    public void 削除を指定した場合_get名称は_削除を返す() {
        assertThat(ChokkinIdoJiyuCode.削除.get名称(), is(new RString("削除")));
    }

    @Test
    public void 修正を指定した場合_get名称は_修正を返す() {
        assertThat(ChokkinIdoJiyuCode.修正.get名称(), is(new RString("修正")));
    }

    @Test
    public void 受給申請却下を指定した場合_get名称は_受給申請却下を返す() {
        assertThat(ChokkinIdoJiyuCode.受給申請却下.get名称(), is(new RString("受給申請却下")));
    }

    @Test
    public void 削除回復を指定した場合_get名称は_削除回復を返す() {
        assertThat(ChokkinIdoJiyuCode.削除回復.get名称(), is(new RString("削除回復")));
    }

    @Test
    public void 職権記載を指定した場合_get名称は_職権記載を返す() {
        assertThat(ChokkinIdoJiyuCode.職権記載.get名称(), is(new RString("職権記載")));
    }

    @Test
    public void 職権修正を指定した場合_get名称は_職権修正を返す() {
        assertThat(ChokkinIdoJiyuCode.職権修正.get名称(), is(new RString("職権修正")));
    }

    @Test
    public void 職権取消を指定した場合_get名称は_職権取消を返す() {
        assertThat(ChokkinIdoJiyuCode.職権取消.get名称(), is(new RString("職権取消")));
    }

    @Test
    public void 履歴修正を指定した場合_get名称は_履歴修正を返す() {
        assertThat(ChokkinIdoJiyuCode.履歴修正.get名称(), is(new RString("履歴修正")));
    }

}
