package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認証者電子公印種別コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class NinshoshaDenshikoinshubetsuCodeTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        NinshoshaDenshikoinshubetsuCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        NinshoshaDenshikoinshubetsuCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0001を指定した場合_toValueは_保険者印を返す() {
        assertThat(NinshoshaDenshikoinshubetsuCode.toValue(new RString("0001")), is(NinshoshaDenshikoinshubetsuCode.保険者印));
    }

    @Test
    public void 引数に0002を指定した場合_toValueは_印の字を返す() {
        assertThat(NinshoshaDenshikoinshubetsuCode.toValue(new RString("0002")), is(NinshoshaDenshikoinshubetsuCode.印の字));
    }

    @Test
    public void 保険者印を指定した場合_getコードは_0001を返す() {
        assertThat(NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), is(new RString("0001")));
    }

    @Test
    public void 印の字を指定した場合_getコードは_0002を返す() {
        assertThat(NinshoshaDenshikoinshubetsuCode.印の字.getコード(), is(new RString("0002")));
    }

    @Test
    public void 保険者印を指定した場合_get名称は_保険者印を返す() {
        assertThat(NinshoshaDenshikoinshubetsuCode.保険者印.get名称(), is(new RString("保険者印")));
    }

    @Test
    public void 印の字を指定した場合_get名称は_印の字を返す() {
        assertThat(NinshoshaDenshikoinshubetsuCode.印の字.get名称(), is(new RString("印の字")));
    }

}
