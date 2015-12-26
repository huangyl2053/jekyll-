package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認知機能及び状態安定性から推定される給付区分コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class SuiteiKyufuKubunCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SuiteiKyufuKubunCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SuiteiKyufuKubunCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_予防給付相当を返す() {
        assertThat(SuiteiKyufuKubunCode.toValue(new RString("1")), is(SuiteiKyufuKubunCode.予防給付相当));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_介護給付相当を返す() {
        assertThat(SuiteiKyufuKubunCode.toValue(new RString("2")), is(SuiteiKyufuKubunCode.介護給付相当));
    }

    @Test
    public void 予防給付相当を指定した場合_getコードは_1を返す() {
        assertThat(SuiteiKyufuKubunCode.予防給付相当.getコード(), is(new RString("1")));
    }

    @Test
    public void 介護給付相当を指定した場合_getコードは_2を返す() {
        assertThat(SuiteiKyufuKubunCode.介護給付相当.getコード(), is(new RString("2")));
    }

    @Test
    public void 予防給付相当を指定した場合_get名称は_予防給付相当を返す() {
        assertThat(SuiteiKyufuKubunCode.予防給付相当.get名称(), is(new RString("予防給付相当")));
    }

    @Test
    public void 介護給付相当を指定した場合_get名称は_介護給付相当を返す() {
        assertThat(SuiteiKyufuKubunCode.介護給付相当.get名称(), is(new RString("介護給付相当")));
    }

}
