package jp.co.ndensan.reams.db.dbx.definition.core.kensakuseigyo;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 広域内住所地特例者検索制御のテストクラスです。
 *
 */
public class KoikinaiJushochitokureiKensakuSeigyoTest extends DbxTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KoikinaiJushochitokureiKensakuSeigyo.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("99999"));
    }

    @Test
    public void 引数にCAAを指定した場合_toValueは_広域内住所地特例者検索制御_措置元_措置先区分_収納を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("CAA")), is(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_収納));
    }

    @Test
    public void 引数にCABを指定した場合_toValueは_広域内住所地特例者検索制御_措置元_措置先区分_滞納を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("CAB")), is(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_滞納));
    }

    @Test
    public void 引数にDBAを指定した場合_toValueは_広域内住所地特例者検索制御_措置元_措置先区分_介護資格を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("DBA")), is(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護資格));
    }

    @Test
    public void 引数にDBBを指定した場合_toValueは_広域内住所地特例者検索制御_措置元_措置先区分_介護賦課を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("DBB")), is(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護賦課));
    }

    @Test
    public void 引数にDBCを指定した場合_toValueは_広域内住所地特例者検索制御_措置元_措置先区分_介護給付を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("DBC")), is(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護給付));
    }

    @Test
    public void 引数にDBDを指定した場合_toValueは_広域内住所地特例者検索制御_措置元_措置先区分_介護受給を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("DBD")), is(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護受給));
    }

    @Test
    public void 引数にDBEを指定した場合_toValueは_広域内住所地特例者検索制御_措置元_措置先区分_介護認定を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("DBE")), is(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護認定));
    }

    @Test
    public void 引数にDBUを指定した場合_toValueは_広域内住所地特例者検索制御_措置元_措置先区分_介護共通を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("DBU")), is(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護共通));
    }

    @Test
    public void 引数にUAAを指定した場合_toValueは_広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.toValue(new RString("UAA")), is(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_収納を指定した場合_getコードは_CAAを返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_収納.getコード(), is(new RString("CAA")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_滞納を指定した場合_getコードは_CABを返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_滞納.getコード(), is(new RString("CAB")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護資格を指定した場合_getコードは_DBAを返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護資格.getコード(), is(new RString("DBA")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護賦課を指定した場合_getコードは_DBBを返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護賦課.getコード(), is(new RString("DBB")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護給付を指定した場合_getコードは_DBCを返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護給付.getコード(), is(new RString("DBC")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護受給を指定した場合_getコードは_DBDを返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護受給.getコード(), is(new RString("DBD")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護認定を指定した場合_getコードは_DBEを返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護認定.getコード(), is(new RString("DBE")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護共通を指定した場合_getコードは_DBUを返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護共通.getコード(), is(new RString("DBU")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座を指定した場合_getコードは_UAAを返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座.getコード(), is(new RString("UAA")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_収納を指定した場合_get名称は_広域内住所地特例者検索制御_措置元_措置先区分_収納を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_収納.get名称(), is(new RString("広域内住所地特例者検索制御_措置元_措置先区分_収納")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_滞納を指定した場合_get名称は_広域内住所地特例者検索制御_措置元_措置先区分_滞納を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_滞納.get名称(), is(new RString("広域内住所地特例者検索制御_措置元_措置先区分_滞納")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護資格を指定した場合_get名称は_広域内住所地特例者検索制御_措置元_措置先区分_介護資格を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護資格.get名称(), is(new RString("広域内住所地特例者検索制御_措置元_措置先区分_介護資格")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護賦課を指定した場合_get名称は_広域内住所地特例者検索制御_措置元_措置先区分_介護賦課を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護賦課.get名称(), is(new RString("広域内住所地特例者検索制御_措置元_措置先区分_介護賦課")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護給付を指定した場合_get名称は_広域内住所地特例者検索制御_措置元_措置先区分_介護給付を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護給付.get名称(), is(new RString("広域内住所地特例者検索制御_措置元_措置先区分_介護給付")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護受給を指定した場合_get名称は_広域内住所地特例者検索制御_措置元_措置先区分_介護受給を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護受給.get名称(), is(new RString("広域内住所地特例者検索制御_措置元_措置先区分_介護受給")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護認定を指定した場合_get名称は_広域内住所地特例者検索制御_措置元_措置先区分_介護認定を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護認定.get名称(), is(new RString("広域内住所地特例者検索制御_措置元_措置先区分_介護認定")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_介護共通を指定した場合_get名称は_広域内住所地特例者検索制御_措置元_措置先区分_介護共通を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_介護共通.get名称(), is(new RString("広域内住所地特例者検索制御_措置元_措置先区分_介護共通")));
    }

    @Test
    public void 広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座を指定した場合_get名称は_広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座を返す() {
        assertThat(KoikinaiJushochitokureiKensakuSeigyo.広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座.get名称(), is(new RString("広域内住所地特例者検索制御_措置元_措置先区分_宛名_口座")));
    }

}
