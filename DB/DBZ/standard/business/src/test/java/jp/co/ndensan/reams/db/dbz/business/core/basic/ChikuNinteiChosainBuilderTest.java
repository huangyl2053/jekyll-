/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5223ChikuNinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5223ChikuNinteiChosainEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChikuNinteiChosainBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChikuNinteiChosainBuilderTest extends DbzTestBase {

    private static DbT5223ChikuNinteiChosainEntity chikuNinteiChosainEntity;
    private static Code 調査地区コード;
    private static RString 認定調査委託先コード;
    private static RString 認定調査員コード;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
        調査地区コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード;
        認定調査委託先コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード;
        認定調査員コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード;
        市町村コード = DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ChikuNinteiChosainBuilder sut;
        private static ChikuNinteiChosain business;

        @Before
        public void setUp() {
            chikuNinteiChosainEntity = new DbT5223ChikuNinteiChosainEntity();

            business = new ChikuNinteiChosain(chikuNinteiChosainEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の調査地区コードは_設定した値と同じ調査地区コードを返す() {
            business = sut.set調査地区コード(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード).build();
            assertThat(business.get調査地区コード(), is(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_調査地区コード));
        }

        @Test
        public void 戻り値の認定調査委託先コードは_設定した値と同じ認定調査委託先コードを返す() {
            business = sut.set認定調査委託先コード(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード).build();
            assertThat(business.get認定調査委託先コード(), is(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査委託先コード));
        }

        @Test
        public void 戻り値の認定調査員コードは_設定した値と同じ認定調査員コードを返す() {
            business = sut.set認定調査員コード(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード).build();
            assertThat(business.get認定調査員コード(), is(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_認定調査員コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の優先番号は_設定した値と同じ優先番号を返す() {
            business = sut.set優先番号(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_優先番号).build();
            assertThat(business.get優先番号(), is(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_優先番号));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            business = sut.set備考(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_備考).build();
            assertThat(business.get備考(), is(DbT5223ChikuNinteiChosainEntityGenerator.DEFAULT_備考));
        }

    }
}
