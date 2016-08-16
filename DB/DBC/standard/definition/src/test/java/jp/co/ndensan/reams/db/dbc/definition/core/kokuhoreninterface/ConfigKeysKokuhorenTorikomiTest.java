package jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface;

import jp.co.ndensan.reams.db.dbc.definition.core.config.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 国保連取込コンフィグ一覧のテストクラスです。
 *
 * @author LDNS
 */
public class ConfigKeysKokuhorenTorikomiTest extends DbcTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ConfigKeysKokuhorenTorikomi.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ConfigKeysKokuhorenTorikomi.toValue(new RString("99999"));
    }

    @Test
    public void 引数に111を指定した場合_toValueは_受給者情報更新結果情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("111")), is(ConfigKeysKokuhorenTorikomi.受給者情報更新結果情報));
    }

    @Test
    public void 引数に112を指定した場合_toValueは_共同処理用受給者情報更新結果を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("112")), is(ConfigKeysKokuhorenTorikomi.共同処理用受給者情報更新結果));
    }

    @Test
    public void 引数に114を指定した場合_toValueは_給付実績情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("114")), is(ConfigKeysKokuhorenTorikomi.給付実績情報));
    }

    @Test
    public void 引数に121を指定した場合_toValueは_給付管理票情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("121")), is(ConfigKeysKokuhorenTorikomi.給付管理票情報));
    }

    @Test
    public void 引数に122を指定した場合_toValueは_給付実績更新結果情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("122")), is(ConfigKeysKokuhorenTorikomi.給付実績更新結果情報));
    }

    @Test
    public void 引数に151を指定した場合_toValueは_介護給付費等審査決定請求明細表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("151")), is(ConfigKeysKokuhorenTorikomi.介護給付費等審査決定請求明細表情報));
    }

    @Test
    public void 引数に152を指定した場合_toValueは_介護給付費過誤決定通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("152")), is(ConfigKeysKokuhorenTorikomi.介護給付費過誤決定通知書情報));
    }

    @Test
    public void 引数に161を指定した場合_toValueは_介護給付費再審査決定通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("161")), is(ConfigKeysKokuhorenTorikomi.介護給付費再審査決定通知書情報));
    }

    @Test
    public void 引数に162を指定した場合_toValueは_介護給付費等請求額通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("162")), is(ConfigKeysKokuhorenTorikomi.介護給付費等請求額通知書情報));
    }

    @Test
    public void 引数に171を指定した場合_toValueは_介護給付費過誤決定通知書公費情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("171")), is(ConfigKeysKokuhorenTorikomi.介護給付費過誤決定通知書公費情報));
    }

    @Test
    public void 引数に172を指定した場合_toValueは_介護給付費再審査決定通知書公費情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("172")), is(ConfigKeysKokuhorenTorikomi.介護給付費再審査決定通知書公費情報));
    }

    @Test
    public void 引数に175を指定した場合_toValueは_介護給付費等請求額通知書公費情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("175")), is(ConfigKeysKokuhorenTorikomi.介護給付費等請求額通知書公費情報));
    }

    @Test
    public void 引数に221を指定した場合_toValueは_介護給付費公費受給者別一覧表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("221")), is(ConfigKeysKokuhorenTorikomi.介護給付費公費受給者別一覧表情報));
    }

    @Test
    public void 引数に222を指定した場合_toValueは_償還払支給決定者一覧情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("222")), is(ConfigKeysKokuhorenTorikomi.償還払支給決定者一覧情報));
    }

    @Test
    public void 引数に331を指定した場合_toValueは_償還払不支給決定者一覧情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("331")), is(ConfigKeysKokuhorenTorikomi.償還払不支給決定者一覧情報));
    }

    @Test
    public void 引数に351を指定した場合_toValueは_高額介護サービス費給付対象者一覧表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("351")), is(ConfigKeysKokuhorenTorikomi.高額介護サービス費給付対象者一覧表情報));
    }

    @Test
    public void 引数に386を指定した場合_toValueは_高額介護サービス費支給不支給決定者一覧表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("386")), is(ConfigKeysKokuhorenTorikomi.高額介護サービス費支給不支給決定者一覧表情報));
    }

    @Test
    public void 引数に533を指定した場合_toValueは_受給者台帳情報一覧を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("533")), is(ConfigKeysKokuhorenTorikomi.受給者台帳情報一覧));
    }

    @Test
    public void 引数に534を指定した場合_toValueは_受給者台帳突合結果情報随時を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("534")), is(ConfigKeysKokuhorenTorikomi.受給者台帳突合結果情報随時));
    }

    @Test
    public void 引数に537を指定した場合_toValueは_共同処理用受給者情報一覧を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("537")), is(ConfigKeysKokuhorenTorikomi.共同処理用受給者情報一覧));
    }

    @Test
    public void 引数に631を指定した場合_toValueは_高額合算自己負担額確認情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("631")), is(ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報));
    }

    @Test
    public void 引数に641を指定した場合_toValueは_高額合算自己負担額証明書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("641")), is(ConfigKeysKokuhorenTorikomi.高額合算自己負担額証明書情報));
    }

    @Test
    public void 引数に651を指定した場合_toValueは_高額合算支給額計算結果連絡票情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("651")), is(ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報));
    }

    @Test
    public void 引数に652を指定した場合_toValueは_高額合算支給不支給決定通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("652")), is(ConfigKeysKokuhorenTorikomi.高額合算支給不支給決定通知書情報));
    }

    @Test
    public void 引数に741を指定した場合_toValueは_高額合算給付実績情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("741")), is(ConfigKeysKokuhorenTorikomi.高額合算給付実績情報));
    }

    @Test
    public void 引数に37Hを指定した場合_toValueは_総合事業費過誤決定通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("37H")), is(ConfigKeysKokuhorenTorikomi.総合事業費過誤決定通知書情報));
    }

    @Test
    public void 引数に37Jを指定した場合_toValueは_高額合算自己負担額確認情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("37J")), is(ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報));
    }

    @Test
    public void 引数に38Bを指定した場合_toValueは_総合事業費審査決定請求明細表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("38B")), is(ConfigKeysKokuhorenTorikomi.総合事業費審査決定請求明細表情報));
    }

    @Test
    public void 引数に38Pを指定した場合_toValueは_請求明細給付管理票返戻保留一覧表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("38P")), is(ConfigKeysKokuhorenTorikomi.請求明細給付管理票返戻保留一覧表情報));
    }

    @Test
    public void 引数に5C3を指定した場合_toValueは_共同処理用受給者情報更新結果を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("5C3")), is(ConfigKeysKokuhorenTorikomi.共同処理用受給者情報更新結果));
    }

    @Test
    public void 引数に5C4を指定した場合_toValueは_総合事業費資格照合表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.toValue(new RString("5C4")), is(ConfigKeysKokuhorenTorikomi.総合事業費資格照合表情報));
    }

    @Test
    public void 受給者情報更新結果情報を指定した場合_getコードは_111を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.受給者情報更新結果情報.getコード(), is(new RString("111")));
    }

    @Test
    public void 共同処理用受給者情報更新結果を指定した場合_getコードは_112を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.共同処理用受給者情報更新結果.getコード(), is(new RString("112")));
    }

    @Test
    public void 給付実績情報を指定した場合_getコードは_114を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.給付実績情報.getコード(), is(new RString("114")));
    }

    @Test
    public void 給付管理票情報を指定した場合_getコードは_121を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.給付管理票情報.getコード(), is(new RString("121")));
    }

    @Test
    public void 給付実績更新結果情報を指定した場合_getコードは_122を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.給付実績更新結果情報.getコード(), is(new RString("122")));
    }

    @Test
    public void 介護給付費等審査決定請求明細表情報を指定した場合_getコードは_151を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費等審査決定請求明細表情報.getコード(), is(new RString("151")));
    }

    @Test
    public void 介護給付費過誤決定通知書情報を指定した場合_getコードは_152を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費過誤決定通知書情報.getコード(), is(new RString("152")));
    }

    @Test
    public void 介護給付費再審査決定通知書情報を指定した場合_getコードは_161を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費再審査決定通知書情報.getコード(), is(new RString("161")));
    }

    @Test
    public void 介護給付費等請求額通知書情報を指定した場合_getコードは_162を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費等請求額通知書情報.getコード(), is(new RString("162")));
    }

    @Test
    public void 介護給付費過誤決定通知書公費情報を指定した場合_getコードは_171を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費過誤決定通知書公費情報.getコード(), is(new RString("171")));
    }

    @Test
    public void 介護給付費再審査決定通知書公費情報を指定した場合_getコードは_172を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費再審査決定通知書公費情報.getコード(), is(new RString("172")));
    }

    @Test
    public void 介護給付費等請求額通知書公費情報を指定した場合_getコードは_175を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費等請求額通知書公費情報.getコード(), is(new RString("175")));
    }

    @Test
    public void 介護給付費公費受給者別一覧表情報を指定した場合_getコードは_221を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費公費受給者別一覧表情報.getコード(), is(new RString("221")));
    }

    @Test
    public void 償還払支給決定者一覧情報を指定した場合_getコードは_222を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.償還払支給決定者一覧情報.getコード(), is(new RString("222")));
    }

    @Test
    public void 償還払不支給決定者一覧情報を指定した場合_getコードは_331を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.償還払不支給決定者一覧情報.getコード(), is(new RString("331")));
    }

    @Test
    public void 高額介護サービス費給付対象者一覧表情報を指定した場合_getコードは_351を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額介護サービス費給付対象者一覧表情報.getコード(), is(new RString("351")));
    }

    @Test
    public void 高額介護サービス費支給不支給決定者一覧表情報を指定した場合_getコードは_386を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額介護サービス費支給不支給決定者一覧表情報.getコード(), is(new RString("386")));
    }

    @Test
    public void 受給者台帳情報一覧を指定した場合_getコードは_533を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.受給者台帳情報一覧.getコード(), is(new RString("533")));
    }

    @Test
    public void 受給者台帳突合結果情報随時を指定した場合_getコードは_534を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.受給者台帳突合結果情報随時.getコード(), is(new RString("534")));
    }

    @Test
    public void 共同処理用受給者情報一覧を指定した場合_getコードは_537を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.共同処理用受給者情報一覧.getコード(), is(new RString("537")));
    }

    @Test
    public void 高額合算自己負担額確認情報を指定した場合_getコードは_631を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報.getコード(), is(new RString("631")));
    }

    @Test
    public void 高額合算自己負担額証明書情報を指定した場合_getコードは_641を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算自己負担額証明書情報.getコード(), is(new RString("641")));
    }

    @Test
    public void 高額合算支給額計算結果連絡票情報を指定した場合_getコードは_651を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報.getコード(), is(new RString("651")));
    }

    @Test
    public void 高額合算支給不支給決定通知書情報を指定した場合_getコードは_652を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算支給不支給決定通知書情報.getコード(), is(new RString("652")));
    }

    @Test
    public void 高額合算給付実績情報を指定した場合_getコードは_741を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算給付実績情報.getコード(), is(new RString("741")));
    }

    @Test
    public void 総合事業費過誤決定通知書情報を指定した場合_getコードは_37Hを返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.総合事業費過誤決定通知書情報.getコード(), is(new RString("37H")));
    }

    @Test
    public void 総合事業費請求額通知書情報を指定した場合_getコードは_37Jを返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報.getコード(), is(new RString("37J")));
    }

    @Test
    public void 総合事業費審査決定請求明細表情報を指定した場合_getコードは_38Bを返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.総合事業費審査決定請求明細表情報.getコード(), is(new RString("38B")));
    }

    @Test
    public void 請求明細給付管理票返戻保留一覧表情報を指定した場合_getコードは_38Pを返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.請求明細給付管理票返戻保留一覧表情報.getコード(), is(new RString("38P")));
    }

    @Test
    public void 資格照合表情報を指定した場合_getコードは_5C3を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.共同処理用受給者情報更新結果.getコード(), is(new RString("5C3")));
    }

    @Test
    public void 総合事業費資格照合表情報を指定した場合_getコードは_5C4を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.総合事業費資格照合表情報.getコード(), is(new RString("5C4")));
    }

    @Test
    public void 受給者情報更新結果情報を指定した場合_get名称は_受給者情報更新結果情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.受給者情報更新結果情報.get名称(), is(new RString("受給者情報更新結果情報")));
    }

    @Test
    public void 共同処理用受給者情報更新結果を指定した場合_get名称は_共同処理用受給者情報更新結果を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.共同処理用受給者情報更新結果.get名称(), is(new RString("共同処理用受給者情報更新結果")));
    }

    @Test
    public void 給付実績情報を指定した場合_get名称は_給付実績情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.給付実績情報.get名称(), is(new RString("給付実績情報")));
    }

    @Test
    public void 給付管理票情報を指定した場合_get名称は_給付管理票情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.給付管理票情報.get名称(), is(new RString("給付管理票情報")));
    }

    @Test
    public void 給付実績更新結果情報を指定した場合_get名称は_給付実績更新結果情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.給付実績更新結果情報.get名称(), is(new RString("給付実績更新結果情報")));
    }

    @Test
    public void 介護給付費等審査決定請求明細表情報を指定した場合_get名称は_介護給付費等審査決定請求明細表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費等審査決定請求明細表情報.get名称(), is(new RString("介護給付費等審査決定請求明細表情報")));
    }

    @Test
    public void 介護給付費過誤決定通知書情報を指定した場合_get名称は_介護給付費過誤決定通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費過誤決定通知書情報.get名称(), is(new RString("介護給付費過誤決定通知書情報")));
    }

    @Test
    public void 介護給付費再審査決定通知書情報を指定した場合_get名称は_介護給付費再審査決定通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費再審査決定通知書情報.get名称(), is(new RString("介護給付費再審査決定通知書情報")));
    }

    @Test
    public void 介護給付費等請求額通知書情報を指定した場合_get名称は_介護給付費等請求額通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費等請求額通知書情報.get名称(), is(new RString("介護給付費等請求額通知書情報")));
    }

    @Test
    public void 介護給付費過誤決定通知書公費情報を指定した場合_get名称は_介護給付費過誤決定通知書公費情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費過誤決定通知書公費情報.get名称(), is(new RString("介護給付費過誤決定通知書公費情報")));
    }

    @Test
    public void 介護給付費再審査決定通知書公費情報を指定した場合_get名称は_介護給付費再審査決定通知書公費情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費再審査決定通知書公費情報.get名称(), is(new RString("介護給付費再審査決定通知書公費情報")));
    }

    @Test
    public void 介護給付費等請求額通知書公費情報を指定した場合_get名称は_介護給付費等請求額通知書公費情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費等請求額通知書公費情報.get名称(), is(new RString("介護給付費等請求額通知書公費情報")));
    }

    @Test
    public void 介護給付費公費受給者別一覧表情報を指定した場合_get名称は_介護給付費公費受給者別一覧表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費公費受給者別一覧表情報.get名称(), is(new RString("介護給付費公費受給者別一覧表情報")));
    }

    @Test
    public void 償還払支給決定者一覧情報を指定した場合_get名称は_償還払支給決定者一覧情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.償還払支給決定者一覧情報.get名称(), is(new RString("償還払支給決定者一覧情報")));
    }

    @Test
    public void 償還払不支給決定者一覧情報を指定した場合_get名称は_償還払不支給決定者一覧情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.償還払不支給決定者一覧情報.get名称(), is(new RString("償還払不支給決定者一覧情報")));
    }

    @Test
    public void 高額介護サービス費給付対象者一覧表情報を指定した場合_get名称は_高額介護サービス費給付対象者一覧表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額介護サービス費給付対象者一覧表情報.get名称(), is(new RString("高額介護サービス費給付対象者一覧表情報")));
    }

    @Test
    public void 高額介護サービス費支給不支給決定者一覧表情報を指定した場合_get名称は_高額介護サービス費支給不支給決定者一覧表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額介護サービス費支給不支給決定者一覧表情報.get名称(), is(new RString("高額介護サービス費支給不支給決定者一覧表情報")));
    }

    @Test
    public void 受給者台帳情報一覧を指定した場合_get名称は_受給者台帳情報一覧を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.受給者台帳情報一覧.get名称(), is(new RString("受給者台帳情報一覧")));
    }

    @Test
    public void 受給者台帳突合結果情報随時を指定した場合_get名称は_受給者台帳突合結果情報随時を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.受給者台帳突合結果情報随時.get名称(), is(new RString("受給者台帳突合結果情報随時")));
    }

    @Test
    public void 共同処理用受給者情報一覧を指定した場合_get名称は_共同処理用受給者情報一覧を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.共同処理用受給者情報一覧.get名称(), is(new RString("共同処理用受給者情報一覧")));
    }

    @Test
    public void 高額合算自己負担額確認情報を指定した場合_get名称は_高額合算自己負担額確認情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算自己負担額確認情報.get名称(), is(new RString("高額合算自己負担額確認情報")));
    }

    @Test
    public void 高額合算自己負担額証明書情報を指定した場合_get名称は_高額合算自己負担額証明書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算自己負担額証明書情報.get名称(), is(new RString("高額合算自己負担額証明書情報")));
    }

    @Test
    public void 高額合算支給額計算結果連絡票情報を指定した場合_get名称は_高額合算支給額計算結果連絡票情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算支給額計算結果連絡票情報.get名称(), is(new RString("高額合算支給額計算結果連絡票情報")));
    }

    @Test
    public void 高額合算支給不支給決定通知書情報を指定した場合_get名称は_高額合算支給不支給決定通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算支給不支給決定通知書情報.get名称(), is(new RString("高額合算支給不支給決定通知書情報")));
    }

    @Test
    public void 高額合算給付実績情報を指定した場合_get名称は_高額合算給付実績情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.高額合算給付実績情報.get名称(), is(new RString("高額合算給付実績情報")));
    }

    @Test
    public void 総合事業費過誤決定通知書情報を指定した場合_get名称は_総合事業費過誤決定通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.総合事業費過誤決定通知書情報.get名称(), is(new RString("総合事業費過誤決定通知書情報")));
    }

    @Test
    public void 総合事業費経過措置請求額通知書情報を指定した場合_get名称は_総合事業費経過措置請求額通知書情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.総合事業費経過措置請求額通知書情報.get名称(), is(new RString("総合事業費経過措置請求額通知書情報")));
    }

    @Test
    public void 総合事業費審査決定請求明細表情報を指定した場合_get名称は_総合事業費審査決定請求明細表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.総合事業費審査決定請求明細表情報.get名称(), is(new RString("総合事業費審査決定請求明細表情報")));
    }

    @Test
    public void 請求明細給付管理票返戻保留一覧表情報を指定した場合_get名称は_請求明細給付管理票返戻保留一覧表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.請求明細給付管理票返戻保留一覧表情報.get名称(), is(new RString("請求明細給付管理票返戻保留一覧表情報")));
    }

    @Test
    public void 介護給付費資格照合表情報を指定した場合_get名称は_介護給付費資格照合表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.介護給付費資格照合表情報.get名称(), is(new RString("介護給付費資格照合表情報")));
    }

    @Test
    public void 総合事業費資格照合表情報を指定した場合_get名称は_総合事業費資格照合表情報を返す() {
        assertThat(ConfigKeysKokuhorenTorikomi.総合事業費資格照合表情報.get名称(), is(new RString("総合事業費資格照合表情報")));
    }

}
