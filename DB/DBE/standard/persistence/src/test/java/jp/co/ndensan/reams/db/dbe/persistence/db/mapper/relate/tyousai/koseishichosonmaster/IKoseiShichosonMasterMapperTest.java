/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.tyousai.koseishichosonmaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.tyousai.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5910NinteichosaItakusakiJohoEntityGenerator.DEFAULT_認定調査委託先コード;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5913ChosainJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5913ChosainJohoEntityGenerator.DEFAULT_認定調査員コード;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import static jp.co.ndensan.reams.db.dbe.entity.helper.DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5051KoseiShichosonMasterDac;
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
 * {@link IKoseiShichosonMasterMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IKoseiShichosonMasterMapperTest {

    private static IKoseiShichosonMasterMapper sut;
    private static DbT5051KoseiShichosonMasterDac 構成市町村マスタDac;
    private static DbT5910NinteichosaItakusakiJohoDac 認定調査委託先情報Dac;
    private static DbT5913ChosainJohoDac 調査員情報Dac;
    private static MapperProvider mapperProvider;
    private static final RString shichosonShokibetsuID_1 = DEFAULT_市町村識別ID;
    private static final RString shichosonShokibetsuID_2 = new RString("市町村");
    private static final LasdecCode shichosonCode_1 = DEFAULT_市町村コード;
    private static final RString ninteichosaItakusakiCode_1 = DEFAULT_認定調査委託先コード;
    private static final RString ninteichosaItakusakiCode_2 = new RString("");
    private static final RString ninteiChosainNo_1 = DEFAULT_認定調査員コード;
    private static final RString ninteiChosainNo_2 = new RString("");

    @BeforeClass
    public static void setUpClass() {
        構成市町村マスタDac = InstanceProvider.create(DbT5051KoseiShichosonMasterDac.class);
        認定調査委託先情報Dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        調査員情報Dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
    }

    public static class select構成市町村マスタByKeyTest extends DbeTestDacBase {

        @Before
        public void setUp() {
            mapperProvider = InstanceProvider.create(MapperProvider.class);
            sut = mapperProvider.create(IKoseiShichosonMasterMapper.class);
            TestSupport.insertDbT5051(shichosonShokibetsuID_1);

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
        public void データが見つかる検索条件を渡すと_構成市町村マスタEntity返す() {
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(shichosonShokibetsuID_1);
            assertThat(sut.select構成市町村マスタByKey(構成市町村マスタ検索条件).get構成市町村マスタEntity().getShichosonShokibetsuID(), is(shichosonShokibetsuID_1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(shichosonShokibetsuID_2);
            assertThat(sut.select構成市町村マスタByKey(構成市町村マスタ検索条件), is(nullValue()));
        }
    }

    public static class select構成市町村マスタ一覧By主キーTest extends DbeTestDacBase {

        @Before
        public void setUp() {
            mapperProvider = InstanceProvider.create(MapperProvider.class);
            sut = mapperProvider.create(IKoseiShichosonMasterMapper.class);
            TestSupport.insertDbT5051(shichosonShokibetsuID_1);

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
        public void データが見つかる検索条件を渡すと_構成市町村マスタEntityリストを返す() {
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectListParam(shichosonShokibetsuID_1);
            List<KoseiShichosonMasterRelateEntity> entityList = sut.select構成市町村マスタリストBy主キー1(構成市町村マスタ検索条件);
            assertThat(entityList.size(), is(1));
            assertThat(entityList.get(0).get構成市町村マスタEntity().getShichosonShokibetsuID(), is(shichosonShokibetsuID_1));
        }

        @Test
        public void データが見つかない検索条件を渡すと__構成市町村マスタEntityを返す() {
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectListParam(shichosonShokibetsuID_2);
            assertThat(sut.select構成市町村マスタリストBy主キー1(構成市町村マスタ検索条件).isEmpty(), is(false));
        }
    }

    private static class TestSupport {

        public static void insertDbT5051(
                RString 市町村識別ID) {
            DbT5051KoseiShichosonMasterEntity entity = DbT5051KoseiShichosonMasterEntityGenerator.createDbT5051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(市町村識別ID);
            entity.setState(EntityDataState.Added);
            構成市町村マスタDac.save(entity);
        }

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
