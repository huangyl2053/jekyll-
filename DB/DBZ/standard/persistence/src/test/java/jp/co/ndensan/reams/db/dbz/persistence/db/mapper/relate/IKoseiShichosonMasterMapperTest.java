/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7052KoseiShichosonShishoMasterEntity;
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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IKoseiShichosonMasterMapper}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IKoseiShichosonMasterMapperTest {

    private static IKoseiShichosonMasterMapper sut;
    private static DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;
    private static DbT7052KoseiShichosonShishoMasterDac 構成市町村支所マスタDac;
    private static final RString 主キー11 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
    private static final RString 主キー12 = new RString("99");
    private static final LasdecCode 主キー21 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
    private static final LasdecCode 主キー22 = new LasdecCode("209007");
    private static final ShishoCode 主キー31 = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
    private static final ShishoCode 主キー32 = new ShishoCode("99");

    @BeforeClass
    public static void setUpClass() {
        構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        構成市町村支所マスタDac = InstanceProvider.create(DbT7052KoseiShichosonShishoMasterDac.class);
    }

    public static class select構成市町村マスタByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKoseiShichosonMasterMapper.class);
            TestSupport.insertDbT7051(主キー11);
            TestSupport.insertDbT7051(主キー11);
            TestSupport.insertDbT7051(主キー12);
            TestSupport.insertDbT7051(主キー12);

            TestSupport.insertDbT7052(主キー21, 主キー32);
            TestSupport.insertDbT7052(主キー21, 主キー32);
            TestSupport.insertDbT7052(主キー22, 主キー32);
            TestSupport.insertDbT7052(主キー22, 主キー32);
        }

        @Test
        public void データが見つかる検索条件を渡すと_構成市町村マスタEntity返す() {
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(主キー11);
            assertThat(sut.select構成市町村マスタByKey(構成市町村マスタ検索条件).get構成市町村マスタEntity().getShichosonShokibetsuID(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(new RString("fadfa"));
            assertThat(sut.select構成市町村マスタByKey(構成市町村マスタ検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
//    public static class select構成市町村マスタ一覧By主キーTest extends DbzTestDacBase {
//
//        @Before
//        public void setUp() {
//            sut = sqlSession.getMapper(IKoseiShichosonMasterMapper.class);
//            TestSupport.insertDbT7051(主キー11);
//            TestSupport.insertDbT7051(主キー11);
//            TestSupport.insertDbT7051(主キー12);
//            TestSupport.insertDbT7051(主キー12);
//
//            TestSupport.insertDbT7052(主キー21, 主キー32);
//            TestSupport.insertDbT7052(主キー21, 主キー32);
//            TestSupport.insertDbT7052(主キー22, 主キー32);
//            TestSupport.insertDbT7052(主キー22, 主キー32);
//        }
//
//        @Test
//        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
//            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectListParam(主キー11);
//            List<KoseiShichosonMasterEntity> entityList = sut.select構成市町村マスタリストBy主キー1(構成市町村マスタ検索条件);
//            assertThat(entityList.size(), is(2));
//            // 任意の項目が一致するテストケースを記述してください。
//            assertThat(entityList.get(0).get構成市町村マスタEntity().getShichosonShokibetsuID(), is(主キー11));
//            assertThat(entityList.get(1).get構成市町村マスタEntity().getShichosonShokibetsuID(), is(主キー11));
//        }
//
//        @Test
//        public void データが見つかない検索条件を渡すと__空のリストを返す() {
//            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectListParam(new RString("91"));
//            assertThat(sut.select構成市町村マスタリストBy主キー1(構成市町村マスタ検索条件).isEmpty(), is(true));
//        }
//    }
    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT7051(
                RString 主キー1) {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(主キー1);
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
