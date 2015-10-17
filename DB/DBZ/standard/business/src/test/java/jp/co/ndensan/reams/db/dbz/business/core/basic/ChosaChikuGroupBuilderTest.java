/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5225ChosaChikuGroupEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChosaChikuGroupBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChosaChikuGroupBuilderTest extends DbzTestBase {

    private static DbT5225ChosaChikuGroupEntity chosaChikuGroupEntity;
    private static Code 調査地区グループコード;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
        調査地区グループコード = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード;
        市町村コード = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ChosaChikuGroupBuilder sut;
        private static ChosaChikuGroup business;

        @Before
        public void setUp() {
            chosaChikuGroupEntity = new DbT5225ChosaChikuGroupEntity();

            business = new ChosaChikuGroup(chosaChikuGroupEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の調査地区グループコードは_設定した値と同じ調査地区グループコードを返す() {
            business = sut.set調査地区グループコード(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード).build();
            assertThat(business.get調査地区グループコード(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード));
        }

        @Test
        public void 戻り値の調査地区コードは_設定した値と同じ調査地区コードを返す() {
            business = sut.set調査地区コード(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区コード).build();
            assertThat(business.get調査地区コード(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の調査地区グループ名称は_設定した値と同じ調査地区グループ名称を返す() {
            business = sut.set調査地区グループ名称(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループ名称).build();
            assertThat(business.get調査地区グループ名称(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループ名称));
        }

        @Test
        public void 戻り値の優先番号は_設定した値と同じ優先番号を返す() {
            business = sut.set優先番号(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_優先番号).build();
            assertThat(business.get優先番号(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_優先番号));
        }

    }
}
