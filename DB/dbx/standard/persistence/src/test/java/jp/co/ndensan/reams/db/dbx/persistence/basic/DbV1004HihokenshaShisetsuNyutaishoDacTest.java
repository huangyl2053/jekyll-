/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 施設入退所のデータアクセスクラスのテストクラスです。
 *
 * @author LDNS 孫海迪
 */
@RunWith(Enclosed.class)
public class DbV1004HihokenshaShisetsuNyutaishoDacTest extends DbxTestDacBase {

    private static DbV1004HihokenshaShisetsuNyutaishoDac sut;
    private static final LasdecCode 市町村コード = new LasdecCode("000001");
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("001");
    private static final RDateTime 処理日時 = RDateTime.MIN;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbV1004HihokenshaShisetsuNyutaishoDac.class);
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Test(expected = NullPointerException.class)
        public void LDNS_市町村コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    識別コード,
                    処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void LDNS_識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    市町村コード,
                    null,
                    処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void LDNS_処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    市町村コード,
                    識別コード,
                    null);
        }

        @Test
        public void LDNS_データが存在しない場合_selectByKeyは_nullを返す() {
            assertThat(sut.selectByKey(
                    市町村コード,
                    識別コード,
                    処理日時), is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbxTestDacBase {

        @Test
        public void LDNS_データが存在しない場合_selectAllは_空なリストを返す() {
            assertThat(sut.selectAll().size(), is(0));
        }
    }

    public static class selectのテスト extends DbxTestDacBase {

        @Test
        public void LDNS_データが存在しない場合_selectは_空なリストを返す() {
            assertThat(sut.select(識別コード).size(), is(0));
        }
    }
}
