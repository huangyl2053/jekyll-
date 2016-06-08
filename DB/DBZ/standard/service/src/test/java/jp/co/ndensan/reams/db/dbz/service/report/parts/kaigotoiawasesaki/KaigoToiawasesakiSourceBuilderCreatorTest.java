/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki;

import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_サブ業務コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_帳票分類ID;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7069KaigoToiawasesakiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoToiawasesakiSourceBuilderCreator}のテストクラスです
 */
@RunWith(Enclosed.class)
public class KaigoToiawasesakiSourceBuilderCreatorTest extends DbzTestDacBase {

    private static DbT7069KaigoToiawasesakiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7069KaigoToiawasesakiDac.class);
    }

    public static class create extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DEFAULT_サブ業務コード,
                    DEFAULT_帳票分類ID);
        }

        @Test
        public void 介護問合せ先ソースビルダー作成_問合せ先未取得の場合_介護問合せ先ソースビルダーが返る() {
            IKaigoToiawasesakiSourceBuilder result = KaigoToiawasesakiSourceBuilderCreator.create(DEFAULT_サブ業務コード, DEFAULT_帳票分類ID);
            assertThat(result, is(notNullValue()));
        }

        @Test
        public void 介護問合せ先ソースビルダー作成_問合せ先取得済みの場合_介護問合せ先ソースビルダーが返る() {
            KaigoToiawasesaki toiawasesaki = new KaigoToiawasesaki(DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity());
            IKaigoToiawasesakiSourceBuilder result = KaigoToiawasesakiSourceBuilderCreator.create(toiawasesaki);
            assertThat(result, is(notNullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                SubGyomuCode サブ業務コード,
                ReportId 帳票分類ID) {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setChohyoBunruiID(帳票分類ID);
            sut.save(entity);
        }

        public static void deleteData() {
            CSVDataUtilForUseSession utilForUseSession = new CSVDataUtilForUseSession();
            utilForUseSession.clearTable(sqlSession, DbT7069KaigoToiawasesakiEntity.TABLE_NAME.toString());
        }
    }

}
