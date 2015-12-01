/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteitiyousaiirai;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5101NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link INinteiShinseiJohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class INinteiShinseiJohoMapperTest {

    private static INinteiShinseiJohoMapper sut;
    private static DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac;
    private static final ShinseishoKanriNo 申請書管理番号_1 = new ShinseishoKanriNo("1");
    private static final ShinseishoKanriNo 申請書管理番号_2 = new ShinseishoKanriNo("2");
    private static MapperProvider mapperProvider;

    @BeforeClass
    public static void setUpClass() {
        要介護認定申請情報Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
    }

    public static class getNinteiShinseiJohoEntityTest extends DbeTestDacBase {

        @Before
        public void setUp() {
            mapperProvider = InstanceProvider.create(MapperProvider.class);
            sut = mapperProvider.create(INinteiShinseiJohoMapper.class);
            TestSupport.insertDbT5101(申請書管理番号_1);
        }

        @Test
        public void データが見つかる検索条件を渡すと_要介護認定申請情報Entity返す() {
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createParam(申請書管理番号_1);
            assertThat(sut.getNinteiShinseiJohoEntity(要介護認定申請情報検索条件).get要介護認定申請情報Entity().getShinseishoKanriNo(), is(申請書管理番号_1));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createParam(申請書管理番号_2);
            assertThat(sut.getNinteiShinseiJohoEntity(要介護認定申請情報検索条件), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insertDbT5101(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5101NinteiShinseiJohoEntity entity = DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            要介護認定申請情報Dac.save(entity);
        }
    }
}
