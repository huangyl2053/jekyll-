/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7052KoseiShichosonShishoMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IKoseiShichosonMasterMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IKoseiShichosonMasterMapperTest extends DbzTestDacBase {

    private static IKoseiShichosonMasterMapper sut;
    private static DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;
    private static DbT7052KoseiShichosonShishoMasterDac 構成市町村支所マスタDac;
    private static final RString shichosonShokibetsuID = new RString("22");
    private static final LasdecCode shichosonCode = new LasdecCode("223456");
    private static final ShishoCode shishoCode = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;

    @BeforeClass
    public static void setUpClass() {
        構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        構成市町村支所マスタDac = InstanceProvider.create(DbT7052KoseiShichosonShishoMasterDac.class);
    }

    public static class select構成市町村マスタByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKoseiShichosonMasterMapper.class);
            TestSupport.clearTable(DbT7051KoseiShichosonMasterEntity.TABLE_NAME.toString());
            TestSupport.clearTable(DbT7052KoseiShichosonShishoMasterEntity.TABLE_NAME.toString());
            TestSupport.insertDbT7051(shichosonShokibetsuID);
            TestSupport.insertDbT7052(shichosonCode, shishoCode);
        }

        @Test
        public void データが見つかる検索条件を渡すと_構成市町村マスタEntity返す() {
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(shichosonShokibetsuID);
            assertThat(sut.getKoseiShichosonEntity(構成市町村マスタ検索条件).get構成市町村マスタEntity().getShichosonShokibetsuID(), is(shichosonShokibetsuID));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(new RString("fadfa"));
            assertThat(sut.getKoseiShichosonEntity(構成市町村マスタ検索条件), is(nullValue()));
        }

        @After
        public void after() {
            rollback();
        }
    }

    private static class TestSupport {

        public static void clearTable(String tableName) {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, tableName);
        }

        public static void insertDbT7051(
                RString shichosonShokibetsuID) {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(shichosonShokibetsuID);
            entity.setState(EntityDataState.Added);
            構成市町村マスタDac.save(entity);
        }

        public static void insertDbT7052(
                LasdecCode 主キー1,
                ShishoCode 主キー2) {
            DbT7052KoseiShichosonShishoMasterEntity entity = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            entity.setShichosonCode(主キー1);
            entity.setShishoCode(主キー2);
            entity.setState(EntityDataState.Added);
            構成市町村支所マスタDac.save(entity);
        }
    }

}
