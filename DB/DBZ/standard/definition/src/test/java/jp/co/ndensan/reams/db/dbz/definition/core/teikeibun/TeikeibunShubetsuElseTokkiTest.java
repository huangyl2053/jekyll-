package jp.co.ndensan.reams.db.dbz.definition.core.teikeibun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特記事項以外定型文種別のテストクラスです。
 * 
 * @author LDNS 
 */
public class TeikeibunShubetsuElseTokkiTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TeikeibunShubetsuElseTokki.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TeikeibunShubetsuElseTokki.toValue(new RString("99999"));
    }

    @Test
    public void 引数に001を指定した場合_toValueは_申請理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.toValue(new RString("001")), is(TeikeibunShubetsuElseTokki.申請理由));
    }

    @Test
    public void 引数に002を指定した場合_toValueは_認定理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.toValue(new RString("002")), is(TeikeibunShubetsuElseTokki.認定理由));
    }

    @Test
    public void 引数に003を指定した場合_toValueは_サービス変更理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.toValue(new RString("003")), is(TeikeibunShubetsuElseTokki.サービス変更理由));
    }

    @Test
    public void 引数に004を指定した場合_toValueは_取消理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.toValue(new RString("004")), is(TeikeibunShubetsuElseTokki.取消理由));
    }

    @Test
    public void 引数に005を指定した場合_toValueは_却下理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.toValue(new RString("005")), is(TeikeibunShubetsuElseTokki.却下理由));
    }

    @Test
    public void 引数に006を指定した場合_toValueは_延期理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.toValue(new RString("006")), is(TeikeibunShubetsuElseTokki.延期理由));
    }

    @Test
    public void 引数に007を指定した場合_toValueは_サービス種類を返す() {
        assertThat(TeikeibunShubetsuElseTokki.toValue(new RString("007")), is(TeikeibunShubetsuElseTokki.サービス種類));
    }

    @Test
    public void 引数に008を指定した場合_toValueは_意見書意見を返す() {
        assertThat(TeikeibunShubetsuElseTokki.toValue(new RString("008")), is(TeikeibunShubetsuElseTokki.意見書意見));
    }

    @Test
    public void 申請理由を指定した場合_getコードは_001を返す() {
        assertThat(TeikeibunShubetsuElseTokki.申請理由.getコード(), is(new RString("001")));
    }

    @Test
    public void 認定理由を指定した場合_getコードは_002を返す() {
        assertThat(TeikeibunShubetsuElseTokki.認定理由.getコード(), is(new RString("002")));
    }

    @Test
    public void サービス変更理由を指定した場合_getコードは_003を返す() {
        assertThat(TeikeibunShubetsuElseTokki.サービス変更理由.getコード(), is(new RString("003")));
    }

    @Test
    public void 取消理由を指定した場合_getコードは_004を返す() {
        assertThat(TeikeibunShubetsuElseTokki.取消理由.getコード(), is(new RString("004")));
    }

    @Test
    public void 却下理由を指定した場合_getコードは_005を返す() {
        assertThat(TeikeibunShubetsuElseTokki.却下理由.getコード(), is(new RString("005")));
    }

    @Test
    public void 延期理由を指定した場合_getコードは_006を返す() {
        assertThat(TeikeibunShubetsuElseTokki.延期理由.getコード(), is(new RString("006")));
    }

    @Test
    public void サービス種類を指定した場合_getコードは_007を返す() {
        assertThat(TeikeibunShubetsuElseTokki.サービス種類.getコード(), is(new RString("007")));
    }

    @Test
    public void 意見書意見を指定した場合_getコードは_008を返す() {
        assertThat(TeikeibunShubetsuElseTokki.意見書意見.getコード(), is(new RString("008")));
    }

    @Test
    public void 申請理由を指定した場合_get名称は_申請理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.申請理由.get名称(), is(new RString("申請理由")));
    }

    @Test
    public void 認定理由を指定した場合_get名称は_認定理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.認定理由.get名称(), is(new RString("認定理由")));
    }

    @Test
    public void サービス変更理由を指定した場合_get名称は_サービス変更理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.サービス変更理由.get名称(), is(new RString("サービス変更理由")));
    }

    @Test
    public void 取消理由を指定した場合_get名称は_取消理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.取消理由.get名称(), is(new RString("取消理由")));
    }

    @Test
    public void 却下理由を指定した場合_get名称は_却下理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.却下理由.get名称(), is(new RString("却下理由")));
    }

    @Test
    public void 延期理由を指定した場合_get名称は_延期理由を返す() {
        assertThat(TeikeibunShubetsuElseTokki.延期理由.get名称(), is(new RString("延期理由")));
    }

    @Test
    public void サービス種類を指定した場合_get名称は_サービス種類を返す() {
        assertThat(TeikeibunShubetsuElseTokki.サービス種類.get名称(), is(new RString("サービス種類")));
    }

    @Test
    public void 意見書意見を指定した場合_get名称は_意見書意見を返す() {
        assertThat(TeikeibunShubetsuElseTokki.意見書意見.get名称(), is(new RString("意見書意見")));
    }

}
