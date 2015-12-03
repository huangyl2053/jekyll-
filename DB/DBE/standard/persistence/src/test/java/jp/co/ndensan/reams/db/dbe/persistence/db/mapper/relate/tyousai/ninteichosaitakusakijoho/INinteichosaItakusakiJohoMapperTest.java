/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.tyousai.ninteichosaitakusakijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5913ChosainJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5913ChosainJohoEntityGenerator.DEFAULT_認定調査員コード;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link INinteichosaItakusakiJohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class INinteichosaItakusakiJohoMapperTest {

    private static INinteichosaItakusakiJohoMapper sut;
    private static DbT5910NinteichosaItakusakiJohoDac 認定調査委託先情報Dac;
    private static DbT5913ChosainJohoDac 調査員情報Dac;
    private static MapperProvider mapperProvider;
    private static final LasdecCode shichosonCode_1 = DEFAULT_市町村コード;
    private static final LasdecCode shichosonCode_2 = new LasdecCode(new RString(""));
    private static final RString ninteichosaItakusakiCode_1 = DEFAULT_認定調査委託先コード;
    private static final RString ninteichosaItakusakiCode_2 = new RString("");
    private static final RString ninteiChosainNo_1 = DEFAULT_認定調査員コード;
    private static final RString ninteiChosainNo_2 = new RString("");

    @BeforeClass
    public static void setUpClass() {
        認定調査委託先情報Dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        調査員情報Dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
    }

    public static class select認定調査委託先情報ByKeyTest extends DbeTestDacBase {

        @Before
        public void setUp() {
            mapperProvider = InstanceProvider.create(MapperProvider.class);
            sut = mapperProvider.create(INinteichosaItakusakiJohoMapper.class);
            TestSupport.insertDbT5910(shichosonCode_1, ninteichosaItakusakiCode_1);
            TestSupport.insertDbT5910(shichosonCode_1, ninteichosaItakusakiCode_2);

            TestSupport.insertDbT5913(shichosonCode_1, ninteichosaItakusakiCode_1, ninteiChosainNo_1);
            TestSupport.insertDbT5913(shichosonCode_1, ninteichosaItakusakiCode_2, ninteiChosainNo_2);
        }

        @After()
        public void after() {
            rollback();
        }

        @Test
        public void データが見つかる検索条件を渡すと_認定調査委託先情報Entity返す() {
            NinteichosaItakusakiJohoMapperParameter 認定調査委託先情報検索条件 = NinteichosaItakusakiJohoMapperParameter.createSelectByKeyParam(shichosonCode_1, ninteichosaItakusakiCode_1);
            assertThat(sut.select認定調査委託先情報ByKey(認定調査委託先情報検索条件).get認定調査委託先情報Entity().getShichosonCode(), is(shichosonCode_1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            NinteichosaItakusakiJohoMapperParameter 認定調査委託先情報検索条件 = NinteichosaItakusakiJohoMapperParameter.createSelectByKeyParam(shichosonCode_2, ninteichosaItakusakiCode_2);
            assertThat(sut.select認定調査委託先情報ByKey(認定調査委託先情報検索条件), is(nullValue()));
        }
    }

    public static class select認定調査委託先情報一覧By主キーTest extends DbeTestDacBase {

        @Before
        public void setUp() {
            mapperProvider = InstanceProvider.create(MapperProvider.class);
            sut = mapperProvider.create(INinteichosaItakusakiJohoMapper.class);
            TestSupport.insertDbT5910(shichosonCode_1, ninteichosaItakusakiCode_1);
            TestSupport.insertDbT5910(shichosonCode_1, ninteichosaItakusakiCode_2);
            TestSupport.insertDbT5913(shichosonCode_1, ninteichosaItakusakiCode_1, ninteiChosainNo_1);
            TestSupport.insertDbT5913(shichosonCode_1, ninteichosaItakusakiCode_2, ninteiChosainNo_2);
        }

        @After()
        public void after() {
            rollback();
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            NinteichosaItakusakiJohoMapperParameter 認定調査委託先情報検索条件 = NinteichosaItakusakiJohoMapperParameter.createSelectListParam(shichosonCode_1, ninteichosaItakusakiCode_1);
            List<NinteichosaItakusakiJohoRelateEntity> entityList = sut.select認定調査委託先情報リストBy主キー1(認定調査委託先情報検索条件);
            assertThat(entityList.size(), is(2));
            assertThat(entityList.get(0).get認定調査委託先情報Entity().getShichosonCode(), is(shichosonCode_1));
            assertThat(entityList.get(1).get認定調査委託先情報Entity().getShichosonCode(), is(shichosonCode_1));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            NinteichosaItakusakiJohoMapperParameter 認定調査委託先情報検索条件 = NinteichosaItakusakiJohoMapperParameter.createSelectListParam(shichosonCode_2, ninteichosaItakusakiCode_2);
            assertThat(sut.select認定調査委託先情報リストBy主キー1(認定調査委託先情報検索条件).isEmpty(), is(true));
        }
    }

    private static class TestSupport {

        public static void insertDbT5910(
                LasdecCode shichosonCode,
                RString ninteichosaItakusakiCode) {
            DbT5910NinteichosaItakusakiJohoEntity entity = DbT5910NinteichosaItakusakiJohoEntityGenerator.createDbT5910NinteichosaItakusakiJohoEntity();
            entity.setShichosonCode(shichosonCode);
            entity.setNinteichosaItakusakiCode(ninteichosaItakusakiCode);
            entity.setState(EntityDataState.Added);
            認定調査委託先情報Dac.save(entity);
        }

        public static void insertDbT5913(
                LasdecCode shichosonCode,
                RString ninteichosaItakusakiCode,
                RString ninteiChosainNo) {
            DbT5913ChosainJohoEntity entity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();
            entity.setShichosonCode(shichosonCode);
            entity.setNinteichosaItakusakiCode(ninteichosaItakusakiCode);
            entity.setNinteiChosainNo(ninteiChosainNo);
            entity.setState(EntityDataState.Added);
            調査員情報Dac.save(entity);
        }
    }

}
