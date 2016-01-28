package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 定型文属性コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class TeikeibunZokuseiCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TeikeibunZokuseiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TeikeibunZokuseiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に101を指定した場合_toValueは_認定理由を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("101")), is(TeikeibunZokuseiCode.認定理由));
    }

    @Test
    public void 引数に102を指定した場合_toValueは_サ変理由を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("102")), is(TeikeibunZokuseiCode.サ変理由));
    }

    @Test
    public void 引数に103を指定した場合_toValueは_取消理由を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("103")), is(TeikeibunZokuseiCode.取消理由));
    }

    @Test
    public void 引数に104を指定した場合_toValueは_却下理由を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("104")), is(TeikeibunZokuseiCode.却下理由));
    }

    @Test
    public void 引数に105を指定した場合_toValueは_延期理由を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("105")), is(TeikeibunZokuseiCode.延期理由));
    }

    @Test
    public void 引数に109を指定した場合_toValueは_サービス種類を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("109")), is(TeikeibunZokuseiCode.サービス種類));
    }

    @Test
    public void 引数に201を指定した場合_toValueは_調査票住宅改修を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("201")), is(TeikeibunZokuseiCode.調査票住宅改修));
    }

    @Test
    public void 引数に202を指定した場合_toValueは_調査票主訴を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("202")), is(TeikeibunZokuseiCode.調査票主訴));
    }

    @Test
    public void 引数に203を指定した場合_toValueは_調査票家族状況を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("203")), is(TeikeibunZokuseiCode.調査票家族状況));
    }

    @Test
    public void 引数に204を指定した場合_toValueは_調査票居住環境を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("204")), is(TeikeibunZokuseiCode.調査票居住環境));
    }

    @Test
    public void 引数に205を指定した場合_toValueは_機器器械を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("205")), is(TeikeibunZokuseiCode.機器器械));
    }

    @Test
    public void 引数に210を指定した場合_toValueは_特記事項を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("210")), is(TeikeibunZokuseiCode.特記事項));
    }

    @Test
    public void 引数に501を指定した場合_toValueは_審査会意見を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("501")), is(TeikeibunZokuseiCode.審査会意見));
    }

    @Test
    public void 引数に502を指定した場合_toValueは_審査会メモを返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("502")), is(TeikeibunZokuseiCode.審査会メモ));
    }

    @Test
    public void 引数に503を指定した場合_toValueは_審査会メモ情報を返す() {
        assertThat(TeikeibunZokuseiCode.toValue(new RString("503")), is(TeikeibunZokuseiCode.審査会メモ情報));
    }

    @Test
    public void 認定理由を指定した場合_getコードは_101を返す() {
        assertThat(TeikeibunZokuseiCode.認定理由.getコード(), is(new RString("101")));
    }

    @Test
    public void サ変理由を指定した場合_getコードは_102を返す() {
        assertThat(TeikeibunZokuseiCode.サ変理由.getコード(), is(new RString("102")));
    }

    @Test
    public void 取消理由を指定した場合_getコードは_103を返す() {
        assertThat(TeikeibunZokuseiCode.取消理由.getコード(), is(new RString("103")));
    }

    @Test
    public void 却下理由を指定した場合_getコードは_104を返す() {
        assertThat(TeikeibunZokuseiCode.却下理由.getコード(), is(new RString("104")));
    }

    @Test
    public void 延期理由を指定した場合_getコードは_105を返す() {
        assertThat(TeikeibunZokuseiCode.延期理由.getコード(), is(new RString("105")));
    }

    @Test
    public void サービス種類を指定した場合_getコードは_109を返す() {
        assertThat(TeikeibunZokuseiCode.サービス種類.getコード(), is(new RString("109")));
    }

    @Test
    public void 調査票住宅改修を指定した場合_getコードは_201を返す() {
        assertThat(TeikeibunZokuseiCode.調査票住宅改修.getコード(), is(new RString("201")));
    }

    @Test
    public void 調査票主訴を指定した場合_getコードは_202を返す() {
        assertThat(TeikeibunZokuseiCode.調査票主訴.getコード(), is(new RString("202")));
    }

    @Test
    public void 調査票家族状況を指定した場合_getコードは_203を返す() {
        assertThat(TeikeibunZokuseiCode.調査票家族状況.getコード(), is(new RString("203")));
    }

    @Test
    public void 調査票居住環境を指定した場合_getコードは_204を返す() {
        assertThat(TeikeibunZokuseiCode.調査票居住環境.getコード(), is(new RString("204")));
    }

    @Test
    public void 機器器械を指定した場合_getコードは_205を返す() {
        assertThat(TeikeibunZokuseiCode.機器器械.getコード(), is(new RString("205")));
    }

    @Test
    public void 特記事項を指定した場合_getコードは_210を返す() {
        assertThat(TeikeibunZokuseiCode.特記事項.getコード(), is(new RString("210")));
    }

    @Test
    public void 審査会意見を指定した場合_getコードは_501を返す() {
        assertThat(TeikeibunZokuseiCode.審査会意見.getコード(), is(new RString("501")));
    }

    @Test
    public void 審査会メモを指定した場合_getコードは_502を返す() {
        assertThat(TeikeibunZokuseiCode.審査会メモ.getコード(), is(new RString("502")));
    }

    @Test
    public void 審査会メモ情報を指定した場合_getコードは_503を返す() {
        assertThat(TeikeibunZokuseiCode.審査会メモ情報.getコード(), is(new RString("503")));
    }

    @Test
    public void 認定理由を指定した場合_get名称は_認定理由を返す() {
        assertThat(TeikeibunZokuseiCode.認定理由.get名称(), is(new RString("認定理由")));
    }

    @Test
    public void サ変理由を指定した場合_get名称は_サ変理由を返す() {
        assertThat(TeikeibunZokuseiCode.サ変理由.get名称(), is(new RString("サ変理由")));
    }

    @Test
    public void 取消理由を指定した場合_get名称は_取消理由を返す() {
        assertThat(TeikeibunZokuseiCode.取消理由.get名称(), is(new RString("取消理由")));
    }

    @Test
    public void 却下理由を指定した場合_get名称は_却下理由を返す() {
        assertThat(TeikeibunZokuseiCode.却下理由.get名称(), is(new RString("却下理由")));
    }

    @Test
    public void 延期理由を指定した場合_get名称は_延期理由を返す() {
        assertThat(TeikeibunZokuseiCode.延期理由.get名称(), is(new RString("延期理由")));
    }

    @Test
    public void サービス種類を指定した場合_get名称は_サービス種類を返す() {
        assertThat(TeikeibunZokuseiCode.サービス種類.get名称(), is(new RString("サービス種類")));
    }

    @Test
    public void 調査票住宅改修を指定した場合_get名称は_調査票住宅改修を返す() {
        assertThat(TeikeibunZokuseiCode.調査票住宅改修.get名称(), is(new RString("調査票住宅改修")));
    }

    @Test
    public void 調査票主訴を指定した場合_get名称は_調査票主訴を返す() {
        assertThat(TeikeibunZokuseiCode.調査票主訴.get名称(), is(new RString("調査票主訴")));
    }

    @Test
    public void 調査票家族状況を指定した場合_get名称は_調査票家族状況を返す() {
        assertThat(TeikeibunZokuseiCode.調査票家族状況.get名称(), is(new RString("調査票家族状況")));
    }

    @Test
    public void 調査票居住環境を指定した場合_get名称は_調査票居住環境を返す() {
        assertThat(TeikeibunZokuseiCode.調査票居住環境.get名称(), is(new RString("調査票居住環境")));
    }

    @Test
    public void 機器器械を指定した場合_get名称は_機器器械を返す() {
        assertThat(TeikeibunZokuseiCode.機器器械.get名称(), is(new RString("機器器械")));
    }

    @Test
    public void 特記事項を指定した場合_get名称は_特記事項を返す() {
        assertThat(TeikeibunZokuseiCode.特記事項.get名称(), is(new RString("特記事項")));
    }

    @Test
    public void 審査会意見を指定した場合_get名称は_審査会意見を返す() {
        assertThat(TeikeibunZokuseiCode.審査会意見.get名称(), is(new RString("審査会意見")));
    }

    @Test
    public void 審査会メモを指定した場合_get名称は_審査会メモを返す() {
        assertThat(TeikeibunZokuseiCode.審査会メモ.get名称(), is(new RString("審査会メモ")));
    }

    @Test
    public void 審査会メモ情報を指定した場合_get名称は_審査会メモ情報を返す() {
        assertThat(TeikeibunZokuseiCode.審査会メモ情報.get名称(), is(new RString("審査会メモ情報")));
    }

}
