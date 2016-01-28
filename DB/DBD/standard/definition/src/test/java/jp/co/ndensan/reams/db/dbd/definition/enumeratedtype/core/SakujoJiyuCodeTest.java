package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 削除事由コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class SakujoJiyuCodeTest extends DbdTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SakujoJiyuCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SakujoJiyuCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_過誤による削除を返す() {
        assertThat(SakujoJiyuCode.toValue(new RString("01")), is(SakujoJiyuCode.過誤による削除));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_資格喪失による削除を返す() {
        assertThat(SakujoJiyuCode.toValue(new RString("02")), is(SakujoJiyuCode.資格喪失による削除));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_変更申請による削除を返す() {
        assertThat(SakujoJiyuCode.toValue(new RString("03")), is(SakujoJiyuCode.変更申請による削除));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_再調査による削除を返す() {
        assertThat(SakujoJiyuCode.toValue(new RString("04")), is(SakujoJiyuCode.再調査による削除));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_不服申立による削除を返す() {
        assertThat(SakujoJiyuCode.toValue(new RString("05")), is(SakujoJiyuCode.不服申立による削除));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_06認定取下げによる削除を返す() {
        assertThat(SakujoJiyuCode.toValue(new RString("06")), is(SakujoJiyuCode._06認定取下げによる削除));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_09認定取下げによる削除を返す() {
        assertThat(SakujoJiyuCode.toValue(new RString("09")), is(SakujoJiyuCode._09認定取下げによる削除));
    }

    @Test
    public void 過誤による削除を指定した場合_getコードは_01を返す() {
        assertThat(SakujoJiyuCode.過誤による削除.getコード(), is(new RString("01")));
    }

    @Test
    public void 資格喪失による削除を指定した場合_getコードは_02を返す() {
        assertThat(SakujoJiyuCode.資格喪失による削除.getコード(), is(new RString("02")));
    }

    @Test
    public void 変更申請による削除を指定した場合_getコードは_03を返す() {
        assertThat(SakujoJiyuCode.変更申請による削除.getコード(), is(new RString("03")));
    }

    @Test
    public void 再調査による削除を指定した場合_getコードは_04を返す() {
        assertThat(SakujoJiyuCode.再調査による削除.getコード(), is(new RString("04")));
    }

    @Test
    public void 不服申立による削除を指定した場合_getコードは_05を返す() {
        assertThat(SakujoJiyuCode.不服申立による削除.getコード(), is(new RString("05")));
    }

    @Test
    public void _06認定取下げによる削除を指定した場合_getコードは_06を返す() {
        assertThat(SakujoJiyuCode._06認定取下げによる削除.getコード(), is(new RString("06")));
    }

    @Test
    public void _09認定取下げによる削除を指定した場合_getコードは_09を返す() {
        assertThat(SakujoJiyuCode._09認定取下げによる削除.getコード(), is(new RString("09")));
    }

    @Test
    public void 過誤による削除を指定した場合_get名称は_過誤による削除を返す() {
        assertThat(SakujoJiyuCode.過誤による削除.get名称(), is(new RString("過誤による削除")));
    }

    @Test
    public void 資格喪失による削除を指定した場合_get名称は_資格喪失による削除を返す() {
        assertThat(SakujoJiyuCode.資格喪失による削除.get名称(), is(new RString("資格喪失による削除")));
    }

    @Test
    public void 変更申請による削除を指定した場合_get名称は_変更申請による削除を返す() {
        assertThat(SakujoJiyuCode.変更申請による削除.get名称(), is(new RString("変更申請による削除")));
    }

    @Test
    public void 再調査による削除を指定した場合_get名称は_再調査による削除を返す() {
        assertThat(SakujoJiyuCode.再調査による削除.get名称(), is(new RString("再調査による削除")));
    }

    @Test
    public void 不服申立による削除を指定した場合_get名称は_不服申立による削除を返す() {
        assertThat(SakujoJiyuCode.不服申立による削除.get名称(), is(new RString("不服申立による削除")));
    }

    @Test
    public void _06認定取下げによる削除を指定した場合_get名称は_認定取下げによる削除を返す() {
        assertThat(SakujoJiyuCode._06認定取下げによる削除.get名称(), is(new RString("認定取下げによる削除")));
    }

    @Test
    public void _09認定取下げによる削除を指定した場合_get名称は_認定取下げによる削除を返す() {
        assertThat(SakujoJiyuCode._09認定取下げによる削除.get名称(), is(new RString("認定取下げによる削除")));
    }

}
