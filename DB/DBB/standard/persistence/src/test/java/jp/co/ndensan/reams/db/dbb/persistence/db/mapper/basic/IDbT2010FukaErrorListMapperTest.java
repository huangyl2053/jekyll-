/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2010FukaErrorListEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
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
 * {@link IDbT2010FukaErrorListMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2010FukaErrorListMapperTest extends DbbTestDacBase {

    private static DbT2010FukaErrorListEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2010FukaErrorListDac dac;
    private static IDbT2010FukaErrorListMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbbTestDacBase.setUpClass();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2010FukaErrorListEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
            sut = sqlSession.getMapper(IDbT2010FukaErrorListMapper.class);
            entity = DbT2010FukaErrorListEntityGenerator.createDbT2010FukaErrorListEntity();
            dac.save(entity);
        }

        @Test
        public void 正しくサブ業務コードされている() {
            assertThat(sut.getEntity().getSubGyomuCode(), is(entity.getSubGyomuCode()));
        }

        @Test
        public void 正しく内部帳票IDされている() {
            assertThat(sut.getEntity().getInternalReportId(), is(entity.getInternalReportId()));
        }

        @Test
        public void 正しく内部帳票作成日時されている() {
            assertThat(sut.getEntity().getInternalReportCreationDateTime(), is(entity.getInternalReportCreationDateTime()));
        }

        @Test
        public void 正しくバッチIDされている() {
            assertThat(sut.getEntity().getBatchId(), is(entity.getBatchId()));
        }

        @Test
        public void 正しくバッチ起動日時されている() {
            assertThat(sut.getEntity().getBatchStartingDateTime(), is(entity.getBatchStartingDateTime()));
        }

        @Test
        public void 正しく処理区分コードされている() {
            assertThat(sut.getEntity().getShoriKubunCode(), is(entity.getShoriKubunCode()));
        }

        @Test
        public void 正しく賦課年度されている() {
            assertThat(sut.getEntity().getFukaNendo(), is(entity.getFukaNendo()));
        }

        @Test
        public void 正しく通知書番号されている() {
            assertThat(sut.getEntity().getTsuchishoNo(), is(entity.getTsuchishoNo()));
        }

        @Test
        public void 正しくエラーコードされている() {
            assertThat(sut.getEntity().getErrorCode(), is(entity.getErrorCode()));
        }

        @Test
        public void 正しく被保険者番号されている() {
            assertThat(sut.getEntity().getHihokenshaNo(), is(entity.getHihokenshaNo()));
        }

        @Test
        public void 正しく識別コードされている() {
            assertThat(sut.getEntity().getShikibetsuCode(), is(entity.getShikibetsuCode()));
        }
    }

}
