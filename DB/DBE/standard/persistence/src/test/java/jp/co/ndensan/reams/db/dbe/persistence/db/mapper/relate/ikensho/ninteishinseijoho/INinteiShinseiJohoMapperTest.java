/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikensho.ninteishinseijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikensho.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5101NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.ninteishinseijoho.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5300GeninShikkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5301ShujiiIkenshoIraiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5302ShujiiIkenshoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5303ShujiiIkenshoKinyuItemEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5304ShujiiIkenshoIkenItemEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5300GeninShikkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5300GeninShikkanDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5301ShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5302ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5303ShujiiIkenshoKinyuItemDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5304ShujiiIkenshoIkenItemDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * {@link INinteiShinseiJohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class INinteiShinseiJohoMapperTest {

    private static INinteiShinseiJohoMapper sut;
    private static DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac;
    private static DbT5300GeninShikkanDac 原因疾患Dac;
    private static DbT5301ShujiiIkenshoIraiJohoDac 主治医意見書作成依頼情報Dac;

    private static DbT5302ShujiiIkenshoJohoDac 要介護認定主治医意見書情報Dac;
    private static DbT5303ShujiiIkenshoKinyuItemDac 要介護認定主治医意見書記入項目Dac;
    private static DbT5304ShujiiIkenshoIkenItemDac 要介護認定主治医意見書意見項目Dac;
    private static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    private static final ShinseishoKanriNo DEFAULT_申請書管理番号_1 = new ShinseishoKanriNo("aaa");
    private static final int DEFAULT_主治医意見書作成依頼履歴番号 = 1;
    private static final int DEFAULT_主治医意見書作成依頼履歴番号_1 = 0;

    @BeforeClass
    public static void setUpClass() {
        要介護認定申請情報Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        原因疾患Dac = InstanceProvider.create(DbT5300GeninShikkanDac.class);
        主治医意見書作成依頼情報Dac = InstanceProvider.create(DbT5301ShujiiIkenshoIraiJohoDac.class);
        要介護認定主治医意見書情報Dac = InstanceProvider.create(DbT5302ShujiiIkenshoJohoDac.class);
        要介護認定主治医意見書記入項目Dac = InstanceProvider.create(DbT5303ShujiiIkenshoKinyuItemDac.class);
        要介護認定主治医意見書意見項目Dac = InstanceProvider.create(DbT5304ShujiiIkenshoIkenItemDac.class);
    }

    public static class select要介護認定申請情報ByKeyTest extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(INinteiShinseiJohoMapper.class);
            TestSupport.insertDbT5101(DEFAULT_申請書管理番号);

            TestSupport.insertDbT5300(DEFAULT_申請書管理番号);

            TestSupport.insertDbT5301(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号);
            TestSupport.insertDbT5301(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号_1);

            TestSupport.insertDbT5302(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号);
            TestSupport.insertDbT5302(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号_1);

            TestSupport.insertDbT5303(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号);
            TestSupport.insertDbT5303(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号_1);

            TestSupport.insertDbT5304(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号);
            TestSupport.insertDbT5304(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号_1);
        }

        @After
        public void after() {
            rollback();
        }

        @Test
        public void データが見つかる検索条件を渡すと_要介護認定申請情報Entity返す() {
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectByKeyParam(DEFAULT_申請書管理番号);
            assertThat(sut.select要介護認定申請情報ByKey(要介護認定申請情報検索条件).get要介護認定申請情報Entity().getShinseishoKanriNo(), is(DEFAULT_申請書管理番号));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectByKeyParam(DEFAULT_申請書管理番号_1);
            assertThat(sut.select要介護認定申請情報ByKey(要介護認定申請情報検索条件), is(nullValue()));
        }
    }

    public static class select要介護認定申請情報一覧By主キーTest extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(INinteiShinseiJohoMapper.class);
            TestSupport.insertDbT5101(DEFAULT_申請書管理番号);

            TestSupport.insertDbT5300(DEFAULT_申請書管理番号);

            TestSupport.insertDbT5301(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号);
            TestSupport.insertDbT5301(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号_1);

            TestSupport.insertDbT5302(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号);
            TestSupport.insertDbT5302(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号_1);

            TestSupport.insertDbT5303(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号);
            TestSupport.insertDbT5303(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号_1);

            TestSupport.insertDbT5304(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号);
            TestSupport.insertDbT5304(DEFAULT_申請書管理番号, DEFAULT_主治医意見書作成依頼履歴番号_1);
        }

        @After
        public void after() {
            rollback();
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectListParam(DEFAULT_申請書管理番号);
            List<NinteiShinseiJohoEntity> entityList = sut.select要介護認定申請情報リストBy主キー1(要介護認定申請情報検索条件);
            assertThat(entityList.size(), is(1));
            assertThat(entityList.get(0).get要介護認定申請情報Entity().getShinseishoKanriNo(), is(DEFAULT_申請書管理番号));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectListParam(DEFAULT_申請書管理番号_1);
            assertThat(sut.select要介護認定申請情報リストBy主キー1(要介護認定申請情報検索条件).isEmpty(), is(false));
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

        public static void insertDbT5300(
                ShinseishoKanriNo 申請書管理番号) {
            DbT5300GeninShikkanEntity entity = DbT5300GeninShikkanEntityGenerator.createDbT5300GeninShikkanEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setState(EntityDataState.Added);
            原因疾患Dac.save(entity);
        }

        public static void insertDbT5301(
                ShinseishoKanriNo 申請書管理番号,
                int 主治医意見書作成依頼履歴番号) {
            DbT5301ShujiiIkenshoIraiJohoEntity entity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
            entity.setState(EntityDataState.Added);
            主治医意見書作成依頼情報Dac.save(entity);
        }

        public static void insertDbT5302(
                ShinseishoKanriNo 申請書管理番号,
                int 主治医意見書作成依頼履歴番号) {
            DbT5302ShujiiIkenshoJohoEntity entity = DbT5302ShujiiIkenshoJohoEntityGenerator.createDbT5302ShujiiIkenshoJohoEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
            entity.setState(EntityDataState.Added);
            要介護認定主治医意見書情報Dac.save(entity);
        }

        public static void insertDbT5303(
                ShinseishoKanriNo 申請書管理番号,
                int 主治医意見書作成依頼履歴番号) {
            DbT5303ShujiiIkenshoKinyuItemEntity entity = DbT5303ShujiiIkenshoKinyuItemEntityGenerator.createDbT5303ShujiiIkenshoKinyuItemEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
            entity.setState(EntityDataState.Added);
            要介護認定主治医意見書記入項目Dac.save(entity);
        }

        public static void insertDbT5304(
                ShinseishoKanriNo 申請書管理番号,
                int 主治医意見書作成依頼履歴番号) {
            DbT5304ShujiiIkenshoIkenItemEntity entity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
            entity.setShinseishoKanriNo(申請書管理番号);
            entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
            entity.setState(EntityDataState.Added);
            要介護認定主治医意見書意見項目Dac.save(entity);
        }
    }

}
