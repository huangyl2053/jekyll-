/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kaigotoiawasesaki;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * {@link KaigoToiawsaesakiItem}のテストクラスです。
 */
public class KaigoToiawsaesakiItemTest extends DbzTestBase {

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KaigoToiawsaesakiItem.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_郵便番号を返す() {
        assertThat(KaigoToiawsaesakiItem.toValue(new RString("1")), is(KaigoToiawsaesakiItem.郵便番号));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_所在地を返す() {
        assertThat(KaigoToiawsaesakiItem.toValue(new RString("2")), is(KaigoToiawsaesakiItem.所在地));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_庁舎名を返す() {
        assertThat(KaigoToiawsaesakiItem.toValue(new RString("3")), is(KaigoToiawsaesakiItem.庁舎名));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_電話番号を返す() {
        assertThat(KaigoToiawsaesakiItem.toValue(new RString("4")), is(KaigoToiawsaesakiItem.電話番号));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_内線番号を返す() {
        assertThat(KaigoToiawsaesakiItem.toValue(new RString("5")), is(KaigoToiawsaesakiItem.内線番号));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_部署名を返す() {
        assertThat(KaigoToiawsaesakiItem.toValue(new RString("6")), is(KaigoToiawsaesakiItem.部署名));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_担当者名を返す() {
        assertThat(KaigoToiawsaesakiItem.toValue(new RString("7")), is(KaigoToiawsaesakiItem.担当者名));
    }

    @Test
    public void 引数に8を指定した場合_toValueは_当年度を返す() {
        assertThat(KaigoToiawsaesakiItem.toValue(new RString("8")), is(KaigoToiawsaesakiItem.当年度));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_翌年度を返す() {
        assertThat(KaigoToiawsaesakiItem.toValue(new RString("9")), is(KaigoToiawsaesakiItem.翌年度));
    }

    @Test
    public void 郵便番号を指定した場合_getコードは_1を返す() {
        assertThat(KaigoToiawsaesakiItem.郵便番号.getコード(), is(new RString("1")));
    }

    @Test
    public void 所在地を指定した場合_getコードは_2を返す() {
        assertThat(KaigoToiawsaesakiItem.所在地.getコード(), is(new RString("2")));
    }

    @Test
    public void 庁舎名を指定した場合_getコードは_3を返す() {
        assertThat(KaigoToiawsaesakiItem.庁舎名.getコード(), is(new RString("3")));
    }

    @Test
    public void 電話番号を指定した場合_getコードは_4を返す() {
        assertThat(KaigoToiawsaesakiItem.電話番号.getコード(), is(new RString("4")));
    }

    @Test
    public void 内線番号を指定した場合_getコードは_5を返す() {
        assertThat(KaigoToiawsaesakiItem.内線番号.getコード(), is(new RString("5")));
    }

    @Test
    public void 部署名を指定した場合_getコードは_1を返す() {
        assertThat(KaigoToiawsaesakiItem.部署名.getコード(), is(new RString("6")));
    }

    @Test
    public void 担当者名を指定した場合_getコードは_7を返す() {
        assertThat(KaigoToiawsaesakiItem.担当者名.getコード(), is(new RString("7")));
    }

    @Test
    public void 当年度を指定した場合_getコードは_8を返す() {
        assertThat(KaigoToiawsaesakiItem.当年度.getコード(), is(new RString("8")));
    }

    @Test
    public void 翌年度を指定した場合_getコードは_9を返す() {
        assertThat(KaigoToiawsaesakiItem.翌年度.getコード(), is(new RString("9")));
    }

    @Test
    public void 郵便番号を指定した場合_get名称は_郵便番号を返す() {
        assertThat(KaigoToiawsaesakiItem.郵便番号.get名称(), is(new RString("<郵便番号>")));
    }

    @Test
    public void 所在地を指定した場合_get名称は_所在地を返す() {
        assertThat(KaigoToiawsaesakiItem.所在地.get名称(), is(new RString("<所在地>")));
    }

    @Test
    public void 庁舎名を指定した場合_get名称は_庁舎名を返す() {
        assertThat(KaigoToiawsaesakiItem.庁舎名.get名称(), is(new RString("<庁舎名>")));
    }

    @Test
    public void 電話番号を指定した場合_get名称は_電話番号を返す() {
        assertThat(KaigoToiawsaesakiItem.電話番号.get名称(), is(new RString("<電話番号>")));
    }

    @Test
    public void 内線番号を指定した場合_get名称は_内線番号を返す() {
        assertThat(KaigoToiawsaesakiItem.内線番号.get名称(), is(new RString("<内線番号>")));
    }

    @Test
    public void 部署名を指定した場合_get名称は_部署名を返す() {
        assertThat(KaigoToiawsaesakiItem.部署名.get名称(), is(new RString("<部署名>")));
    }

    @Test
    public void 担当者名を指定した場合_get名称は_担当者名を返す() {
        assertThat(KaigoToiawsaesakiItem.担当者名.get名称(), is(new RString("<担当者名>")));
    }

    @Test
    public void 当年度を指定した場合_get名称は_当年度を返す() {
        assertThat(KaigoToiawsaesakiItem.当年度.get名称(), is(new RString("<当年度>")));
    }

    @Test
    public void 翌年度を指定した場合_get名称は_翌年度を返す() {
        assertThat(KaigoToiawsaesakiItem.翌年度.get名称(), is(new RString("<翌年度>")));
    }

}
