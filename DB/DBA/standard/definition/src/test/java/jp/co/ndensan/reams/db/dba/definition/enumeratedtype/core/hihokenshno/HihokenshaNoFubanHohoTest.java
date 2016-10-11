package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.core.hihokenshno;

import jp.co.ndensan.reams.db.dba.definition.core.hihokenshno.HihokenshaNoFubanHoho;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 被保険者番号付番方法のテストクラスです。
 *
 */
public class HihokenshaNoFubanHohoTest extends DbaTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HihokenshaNoFubanHoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HihokenshaNoFubanHoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_住民コード付番を返す() {
        assertThat(HihokenshaNoFubanHoho.toValue(new RString("1")), is(HihokenshaNoFubanHoho.住民コード付番));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_自動連番付番を返す() {
        assertThat(HihokenshaNoFubanHoho.toValue(new RString("2")), is(HihokenshaNoFubanHoho.自動連番付番));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_任意手入力付番を返す() {
        assertThat(HihokenshaNoFubanHoho.toValue(new RString("3")), is(HihokenshaNoFubanHoho.任意手入力付番));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_カスタマイズ付番を返す() {
        assertThat(HihokenshaNoFubanHoho.toValue(new RString("4")), is(HihokenshaNoFubanHoho.カスタマイズ付番));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_自動連番MCD10付番を返す() {
        assertThat(HihokenshaNoFubanHoho.toValue(new RString("5")), is(HihokenshaNoFubanHoho.自動連番_MCD10付番
        ));
    }

    @Test
    public void 住民コード付番を指定した場合_getコードは_1を返す() {
        assertThat(HihokenshaNoFubanHoho.住民コード付番.getコード(), is(new RString("1")));
    }

    @Test
    public void 自動連番付番を指定した場合_getコードは_2を返す() {
        assertThat(HihokenshaNoFubanHoho.自動連番付番.getコード(), is(new RString("2")));
    }

    @Test
    public void 任意手入力付番を指定した場合_getコードは_3を返す() {
        assertThat(HihokenshaNoFubanHoho.任意手入力付番.getコード(), is(new RString("3")));
    }

    @Test
    public void カスタマイズ付番を指定した場合_getコードは_4を返す() {
        assertThat(HihokenshaNoFubanHoho.カスタマイズ付番.getコード(), is(new RString("4")));
    }

    @Test
    public void 自動連番MCD10付番を指定した場合_getコードは_5を返す() {
        assertThat(HihokenshaNoFubanHoho.自動連番_MCD10付番.getコード(), is(new RString("5"))
        );
    }

    @Test
    public void 住民コード付番を指定した場合_get名称は_住民コード付番を返す() {
        assertThat(HihokenshaNoFubanHoho.住民コード付番.get名称(), is(new RString("住民コード付番")));
    }

    @Test
    public void 自動連番付番を指定した場合_get名称は_自動連番付番を返す() {
        assertThat(HihokenshaNoFubanHoho.自動連番付番.get名称(), is(new RString("自動連番付番")));
    }

    @Test
    public void 任意手入力付番を指定した場合_get名称は_任意手入力付番を返す() {
        assertThat(HihokenshaNoFubanHoho.任意手入力付番.get名称(), is(new RString("任意手入力付番")));
    }

    @Test
    public void カスタマイズ付番を指定した場合_get名称は_カスタマイズ付番を返す() {
        assertThat(HihokenshaNoFubanHoho.カスタマイズ付番.get名称(), is(new RString("カスタマイズ付番")));
    }

    @Test
    public void 自動連番MCD10付番を指定した場合_get名称は_自動連番_MCD10付番を返す() {
        assertThat(HihokenshaNoFubanHoho.自動連番_MCD10付番.get名称(), is(new RString("自動連番_MCD10付番"))
        );
    }

    @Test
    public void 住民コード付番を指定した場合_get略称は_住民コード付番を返す() {
        assertThat(HihokenshaNoFubanHoho.住民コード付番.get略称(), is(new RString("住民コード付番")));
    }

    @Test
    public void 自動連番付番を指定した場合_get略称は_自動連番付番を返す() {
        assertThat(HihokenshaNoFubanHoho.自動連番付番.get略称(), is(new RString("自動連番付番")));
    }

    @Test
    public void 任意手入力付番を指定した場合_get略称は_任意手入力付番を返す() {
        assertThat(HihokenshaNoFubanHoho.任意手入力付番.get略称(), is(new RString("任意手入力付番")));
    }

    @Test
    public void カスタマイズ付番を指定した場合_get略称は_カスタマイズ付番を返す() {
        assertThat(HihokenshaNoFubanHoho.カスタマイズ付番.get略称(), is(new RString("カスタマイズ付番")));
    }

    @Test
    public void 自動連番MCD10付番を指定した場合_get略称は_自動連番MCD10付番を返す() {
        assertThat(HihokenshaNoFubanHoho.自動連番_MCD10付番.get略称(), is(new RString("自動連番＋MCD10付番"))
        );
    }

}
