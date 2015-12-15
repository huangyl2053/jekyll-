package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * データ区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class DatakubunTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        Datakubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        Datakubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に00を指定した場合_toValueは_通常_認定を返す() {
        assertThat(Datakubun.toValue(new RString("00")), is(Datakubun.通常_認定));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_職権による認定取消を返す() {
        assertThat(Datakubun.toValue(new RString("11")), is(Datakubun.職権による認定取消));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_審査会結果による認定取消を返す() {
        assertThat(Datakubun.toValue(new RString("12")), is(Datakubun.審査会結果による認定取消));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_本人届出_サ利用無による取消を返す() {
        assertThat(Datakubun.toValue(new RString("13")), is(Datakubun.本人届出_サ利用無による取消));
    }

    @Test
    public void 引数に14を指定した場合_toValueは_本人届出_その他による取消を返す() {
        assertThat(Datakubun.toValue(new RString("14")), is(Datakubun.本人届出_その他による取消));
    }

    @Test
    public void 引数に15を指定した場合_toValueは_要介護度3段階低下による取消を返す() {
        assertThat(Datakubun.toValue(new RString("15")), is(Datakubun.要介護度3段階低下による取消));
    }

    @Test
    public void 引数に19を指定した場合_toValueは_その他の理由による認定取消を返す() {
        assertThat(Datakubun.toValue(new RString("19")), is(Datakubun.その他の理由による認定取消));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_受給者転入を返す() {
        assertThat(Datakubun.toValue(new RString("21")), is(Datakubun.受給者転入));
    }

    @Test
    public void 引数に22を指定した場合_toValueは_過誤による追加を返す() {
        assertThat(Datakubun.toValue(new RString("22")), is(Datakubun.過誤による追加));
    }

    @Test
    public void 引数に23を指定した場合_toValueは_やむを得ない理由による追加を返す() {
        assertThat(Datakubun.toValue(new RString("23")), is(Datakubun.やむを得ない理由による追加));
    }

    @Test
    public void 引数に24を指定した場合_toValueは_職権による追加_修正を返す() {
        assertThat(Datakubun.toValue(new RString("24")), is(Datakubun.職権による追加_修正));
    }

    @Test
    public void 引数に25を指定した場合_toValueは_要介護度3段階低下による追加を返す() {
        assertThat(Datakubun.toValue(new RString("25")), is(Datakubun.要介護度3段階低下による追加));
    }

    @Test
    public void 引数に29を指定した場合_toValueは_その他の理由による追加を返す() {
        assertThat(Datakubun.toValue(new RString("29")), is(Datakubun.その他の理由による追加));
    }

    @Test
    public void 引数に31を指定した場合_toValueは_要介護度の変更無しによる却下を返す() {
        assertThat(Datakubun.toValue(new RString("31")), is(Datakubun.要介護度の変更無しによる却下));
    }

    @Test
    public void 引数に32を指定した場合_toValueは_自立による却下を返す() {
        assertThat(Datakubun.toValue(new RString("32")), is(Datakubun.自立による却下));
    }

    @Test
    public void 引数に33を指定した場合_toValueは_訪問調査未実施による却下を返す() {
        assertThat(Datakubun.toValue(new RString("33")), is(Datakubun.訪問調査未実施による却下));
    }

    @Test
    public void 引数に34を指定した場合_toValueは_意見書未実施による却下を返す() {
        assertThat(Datakubun.toValue(new RString("34")), is(Datakubun.意見書未実施による却下));
    }

    @Test
    public void 引数に35を指定した場合_toValueは_審査会都合による却下を返す() {
        assertThat(Datakubun.toValue(new RString("35")), is(Datakubun.審査会都合による却下));
    }

    @Test
    public void 引数に36を指定した場合_toValueは_要介護度3段階低下による却下を返す() {
        assertThat(Datakubun.toValue(new RString("36")), is(Datakubun.要介護度3段階低下による却下));
    }

    @Test
    public void 引数に37を指定した場合_toValueは_職権による却下を返す() {
        assertThat(Datakubun.toValue(new RString("37")), is(Datakubun.職権による却下));
    }

    @Test
    public void 引数に39を指定した場合_toValueは_その他の理由による却下を返す() {
        assertThat(Datakubun.toValue(new RString("39")), is(Datakubun.その他の理由による却下));
    }

    @Test
    public void 引数に41を指定した場合_toValueは_過誤による申請取消を返す() {
        assertThat(Datakubun.toValue(new RString("41")), is(Datakubun.過誤による申請取消));
    }

    @Test
    public void 引数に42を指定した場合_toValueは_申請による申請取消を返す() {
        assertThat(Datakubun.toValue(new RString("42")), is(Datakubun.申請による申請取消));
    }

    @Test
    public void 引数に43を指定した場合_toValueは_転出による申請取消を返す() {
        assertThat(Datakubun.toValue(new RString("43")), is(Datakubun.転出による申請取消));
    }

    @Test
    public void 引数に44を指定した場合_toValueは_死亡による申請取消を返す() {
        assertThat(Datakubun.toValue(new RString("44")), is(Datakubun.死亡による申請取消));
    }

    @Test
    public void 引数に45を指定した場合_toValueは_職権による申請取消を返す() {
        assertThat(Datakubun.toValue(new RString("45")), is(Datakubun.職権による申請取消));
    }

    @Test
    public void 引数に49を指定した場合_toValueは_その他の理由による申請取消を返す() {
        assertThat(Datakubun.toValue(new RString("49")), is(Datakubun.その他の理由による申請取消));
    }

    @Test
    public void 引数に91を指定した場合_toValueは_開始日同日の区分変更前情報を返す() {
        assertThat(Datakubun.toValue(new RString("91")), is(Datakubun.開始日同日の区分変更前情報));
    }

    @Test
    public void 通常_認定を指定した場合_getコードは_00を返す() {
        assertThat(Datakubun.通常_認定.getコード(), is(new RString("00")));
    }

    @Test
    public void 職権による認定取消を指定した場合_getコードは_11を返す() {
        assertThat(Datakubun.職権による認定取消.getコード(), is(new RString("11")));
    }

    @Test
    public void 審査会結果による認定取消を指定した場合_getコードは_12を返す() {
        assertThat(Datakubun.審査会結果による認定取消.getコード(), is(new RString("12")));
    }

    @Test
    public void 本人届出_サ利用無による取消を指定した場合_getコードは_13を返す() {
        assertThat(Datakubun.本人届出_サ利用無による取消.getコード(), is(new RString("13")));
    }

    @Test
    public void 本人届出_その他による取消を指定した場合_getコードは_14を返す() {
        assertThat(Datakubun.本人届出_その他による取消.getコード(), is(new RString("14")));
    }

    @Test
    public void 要介護度3段階低下による取消を指定した場合_getコードは_15を返す() {
        assertThat(Datakubun.要介護度3段階低下による取消.getコード(), is(new RString("15")));
    }

    @Test
    public void その他の理由による認定取消を指定した場合_getコードは_19を返す() {
        assertThat(Datakubun.その他の理由による認定取消.getコード(), is(new RString("19")));
    }

    @Test
    public void 受給者転入を指定した場合_getコードは_21を返す() {
        assertThat(Datakubun.受給者転入.getコード(), is(new RString("21")));
    }

    @Test
    public void 過誤による追加を指定した場合_getコードは_22を返す() {
        assertThat(Datakubun.過誤による追加.getコード(), is(new RString("22")));
    }

    @Test
    public void やむを得ない理由による追加を指定した場合_getコードは_23を返す() {
        assertThat(Datakubun.やむを得ない理由による追加.getコード(), is(new RString("23")));
    }

    @Test
    public void 職権による追加_修正を指定した場合_getコードは_24を返す() {
        assertThat(Datakubun.職権による追加_修正.getコード(), is(new RString("24")));
    }

    @Test
    public void 要介護度3段階低下による追加を指定した場合_getコードは_25を返す() {
        assertThat(Datakubun.要介護度3段階低下による追加.getコード(), is(new RString("25")));
    }

    @Test
    public void その他の理由による追加を指定した場合_getコードは_29を返す() {
        assertThat(Datakubun.その他の理由による追加.getコード(), is(new RString("29")));
    }

    @Test
    public void 要介護度の変更無しによる却下を指定した場合_getコードは_31を返す() {
        assertThat(Datakubun.要介護度の変更無しによる却下.getコード(), is(new RString("31")));
    }

    @Test
    public void 自立による却下を指定した場合_getコードは_32を返す() {
        assertThat(Datakubun.自立による却下.getコード(), is(new RString("32")));
    }

    @Test
    public void 訪問調査未実施による却下を指定した場合_getコードは_33を返す() {
        assertThat(Datakubun.訪問調査未実施による却下.getコード(), is(new RString("33")));
    }

    @Test
    public void 意見書未実施による却下を指定した場合_getコードは_34を返す() {
        assertThat(Datakubun.意見書未実施による却下.getコード(), is(new RString("34")));
    }

    @Test
    public void 審査会都合による却下を指定した場合_getコードは_35を返す() {
        assertThat(Datakubun.審査会都合による却下.getコード(), is(new RString("35")));
    }

    @Test
    public void 要介護度3段階低下による却下を指定した場合_getコードは_36を返す() {
        assertThat(Datakubun.要介護度3段階低下による却下.getコード(), is(new RString("36")));
    }

    @Test
    public void 職権による却下を指定した場合_getコードは_37を返す() {
        assertThat(Datakubun.職権による却下.getコード(), is(new RString("37")));
    }

    @Test
    public void その他の理由による却下を指定した場合_getコードは_39を返す() {
        assertThat(Datakubun.その他の理由による却下.getコード(), is(new RString("39")));
    }

    @Test
    public void 過誤による申請取消を指定した場合_getコードは_41を返す() {
        assertThat(Datakubun.過誤による申請取消.getコード(), is(new RString("41")));
    }

    @Test
    public void 申請による申請取消を指定した場合_getコードは_42を返す() {
        assertThat(Datakubun.申請による申請取消.getコード(), is(new RString("42")));
    }

    @Test
    public void 転出による申請取消を指定した場合_getコードは_43を返す() {
        assertThat(Datakubun.転出による申請取消.getコード(), is(new RString("43")));
    }

    @Test
    public void 死亡による申請取消を指定した場合_getコードは_44を返す() {
        assertThat(Datakubun.死亡による申請取消.getコード(), is(new RString("44")));
    }

    @Test
    public void 職権による申請取消を指定した場合_getコードは_45を返す() {
        assertThat(Datakubun.職権による申請取消.getコード(), is(new RString("45")));
    }

    @Test
    public void その他の理由による申請取消を指定した場合_getコードは_49を返す() {
        assertThat(Datakubun.その他の理由による申請取消.getコード(), is(new RString("49")));
    }

    @Test
    public void 開始日同日の区分変更前情報を指定した場合_getコードは_91を返す() {
        assertThat(Datakubun.開始日同日の区分変更前情報.getコード(), is(new RString("91")));
    }

    @Test
    public void 通常_認定を指定した場合_get名称は_通常_認定を返す() {
        assertThat(Datakubun.通常_認定.get名称(), is(new RString("通常（認定）")));
    }

    @Test
    public void 職権による認定取消を指定した場合_get名称は_職権による認定取消を返す() {
        assertThat(Datakubun.職権による認定取消.get名称(), is(new RString("職権による認定取消")));
    }

    @Test
    public void 審査会結果による認定取消を指定した場合_get名称は_審査会結果による認定取消を返す() {
        assertThat(Datakubun.審査会結果による認定取消.get名称(), is(new RString("審査会結果による認定取消")));
    }

    @Test
    public void 本人届出_サ利用無による取消を指定した場合_get名称は_本人届出_サ利用無による取消を返す() {
        assertThat(Datakubun.本人届出_サ利用無による取消.get名称(), is(new RString("本人届出・サ利用無による取消")));
    }

    @Test
    public void 本人届出_その他による取消を指定した場合_get名称は_本人届出_その他による取消を返す() {
        assertThat(Datakubun.本人届出_その他による取消.get名称(), is(new RString("本人届出・その他による取消")));
    }

    @Test
    public void 要介護度3段階低下による取消を指定した場合_get名称は_要介護度3段階低下による取消を返す() {
        assertThat(Datakubun.要介護度3段階低下による取消.get名称(), is(new RString("要介護度3段階低下による取消")));
    }

    @Test
    public void その他の理由による認定取消を指定した場合_get名称は_その他の理由による認定取消を返す() {
        assertThat(Datakubun.その他の理由による認定取消.get名称(), is(new RString("その他の理由による認定取消")));
    }

    @Test
    public void 受給者転入を指定した場合_get名称は_受給者転入を返す() {
        assertThat(Datakubun.受給者転入.get名称(), is(new RString("受給者転入")));
    }

    @Test
    public void 過誤による追加を指定した場合_get名称は_過誤による追加を返す() {
        assertThat(Datakubun.過誤による追加.get名称(), is(new RString("過誤による追加")));
    }

    @Test
    public void やむを得ない理由による追加を指定した場合_get名称は_やむを得ない理由による追加を返す() {
        assertThat(Datakubun.やむを得ない理由による追加.get名称(), is(new RString("やむを得ない理由による追加")));
    }

    @Test
    public void 職権による追加_修正を指定した場合_get名称は_職権による追加_修正を返す() {
        assertThat(Datakubun.職権による追加_修正.get名称(), is(new RString("職権による追加（修正）")));
    }

    @Test
    public void 要介護度3段階低下による追加を指定した場合_get名称は_要介護度3段階低下による追加を返す() {
        assertThat(Datakubun.要介護度3段階低下による追加.get名称(), is(new RString("要介護度3段階低下による追加")));
    }

    @Test
    public void その他の理由による追加を指定した場合_get名称は_その他の理由による追加を返す() {
        assertThat(Datakubun.その他の理由による追加.get名称(), is(new RString("その他の理由による追加")));
    }

    @Test
    public void 要介護度の変更無しによる却下を指定した場合_get名称は_要介護度の変更無しによる却下を返す() {
        assertThat(Datakubun.要介護度の変更無しによる却下.get名称(), is(new RString("要介護度の変更無しによる却下")));
    }

    @Test
    public void 自立による却下を指定した場合_get名称は_自立による却下を返す() {
        assertThat(Datakubun.自立による却下.get名称(), is(new RString("自立による却下")));
    }

    @Test
    public void 訪問調査未実施による却下を指定した場合_get名称は_訪問調査未実施による却下を返す() {
        assertThat(Datakubun.訪問調査未実施による却下.get名称(), is(new RString("訪問調査未実施による却下")));
    }

    @Test
    public void 意見書未実施による却下を指定した場合_get名称は_意見書未実施による却下を返す() {
        assertThat(Datakubun.意見書未実施による却下.get名称(), is(new RString("意見書未実施による却下")));
    }

    @Test
    public void 審査会都合による却下を指定した場合_get名称は_審査会都合による却下を返す() {
        assertThat(Datakubun.審査会都合による却下.get名称(), is(new RString("審査会都合による却下")));
    }

    @Test
    public void 要介護度3段階低下による却下を指定した場合_get名称は_要介護度3段階低下による却下を返す() {
        assertThat(Datakubun.要介護度3段階低下による却下.get名称(), is(new RString("要介護度3段階低下による却下")));
    }

    @Test
    public void 職権による却下を指定した場合_get名称は_職権による却下を返す() {
        assertThat(Datakubun.職権による却下.get名称(), is(new RString("職権による却下")));
    }

    @Test
    public void その他の理由による却下を指定した場合_get名称は_その他の理由による却下を返す() {
        assertThat(Datakubun.その他の理由による却下.get名称(), is(new RString("その他の理由による却下")));
    }

    @Test
    public void 過誤による申請取消を指定した場合_get名称は_過誤による申請取消を返す() {
        assertThat(Datakubun.過誤による申請取消.get名称(), is(new RString("過誤による申請取消")));
    }

    @Test
    public void 申請による申請取消を指定した場合_get名称は_申請による申請取消を返す() {
        assertThat(Datakubun.申請による申請取消.get名称(), is(new RString("申請による申請取消")));
    }

    @Test
    public void 転出による申請取消を指定した場合_get名称は_転出による申請取消を返す() {
        assertThat(Datakubun.転出による申請取消.get名称(), is(new RString("転出による申請取消")));
    }

    @Test
    public void 死亡による申請取消を指定した場合_get名称は_死亡による申請取消を返す() {
        assertThat(Datakubun.死亡による申請取消.get名称(), is(new RString("死亡による申請取消")));
    }

    @Test
    public void 職権による申請取消を指定した場合_get名称は_職権による申請取消を返す() {
        assertThat(Datakubun.職権による申請取消.get名称(), is(new RString("職権による申請取消")));
    }

    @Test
    public void その他の理由による申請取消を指定した場合_get名称は_その他の理由による申請取消を返す() {
        assertThat(Datakubun.その他の理由による申請取消.get名称(), is(new RString("その他の理由による申請取消")));
    }

    @Test
    public void 開始日同日の区分変更前情報を指定した場合_get名称は_開始日同日の区分変更前情報を返す() {
        assertThat(Datakubun.開始日同日の区分変更前情報.get名称(), is(new RString("開始日同日の区分変更前情報")));
    }

}
