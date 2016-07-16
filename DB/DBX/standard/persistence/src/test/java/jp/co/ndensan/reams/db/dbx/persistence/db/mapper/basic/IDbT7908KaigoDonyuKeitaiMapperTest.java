/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7908KaigoDonyuKeitaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7908KaigoDonyuKeitaiDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IDbT7908KaigoDonyuKeitaiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT7908KaigoDonyuKeitaiMapperTest extends DbxTestDacBase {

    private static DbT7908KaigoDonyuKeitaiEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT7908KaigoDonyuKeitaiDac dac;
    private static IDbT7908KaigoDonyuKeitaiMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    @Ignore
    public static class getEntityメソッドTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT7908KaigoDonyuKeitaiEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
            sut = sqlSession.getMapper(IDbT7908KaigoDonyuKeitaiMapper.class);
            entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            dac.save(entity);
        }

        @Test
        public void 正しく業務分類されている() {
            assertThat(sut.getEntity().getGyomuBunrui(), is(entity.getGyomuBunrui()));
        }

        @Test
        public void 正しく導入形態コードされている() {
            assertThat(sut.getEntity().getDonyuKeitaiCode(), is(entity.getDonyuKeitaiCode()));
        }

        @Test
        public void 正しく支所管理有無フラグされている() {
            assertThat(sut.getEntity().getShishoKanriUmuFlag(), is(entity.getShishoKanriUmuFlag()));
        }
    }

}
