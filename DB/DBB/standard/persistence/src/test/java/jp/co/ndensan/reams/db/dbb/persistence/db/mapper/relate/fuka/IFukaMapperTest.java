/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.FukaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.FukaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IFukaMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IFukaMapperTest {

    private static DbT2002FukaDac 介護賦課Dac;
    private static DbT2003KibetsuDac 介護期別Dac;
    private static FukaEntity result;
    private static IFukaMapper sut;

    private static FukaMapperParameter param;
    private static DbTestHelper dbTestHelper;

    private static FlexibleYear choteiNendo;
    private static FlexibleYear fukaNendo;
    private static TsuchishoNo tsuchishoNo;
    private static Decimal rirekiNo;
    private static RString choshuHouhou;
    private static Decimal choteiId;

    @BeforeClass
    public static void setUpClass() {
        dbTestHelper = new DbTestHelper();
        choteiNendo = new FlexibleYear(new RString("2011"));
        fukaNendo = new FlexibleYear(new RString("2015"));
        tsuchishoNo = new TsuchishoNo(new RString("123"));
        rirekiNo = new Decimal(156);

    }

    @AfterClass
    public static void tearDownClass() {
        DbbTestDacBase.tearDownClass();
    }

    public static class get介護賦課_DbT2002Fuka介護賦課情報取得Test extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IFukaMapper.class);
            dbTestHelper.truncateTable(sqlSession, DbT2002FukaEntity.TABLE_NAME);
        }

        @Test
        public void 指定のパラメータと同様ない主キーを持つDbT2002Fuka介護賦課が存在しない場合_getFukaEntityメソッドにより_nullが返却される() {

            TestSupport.insertDbT2002(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
            param = FukaMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, new Decimal(157));
            result = sut.getFukaEntity(param);
            assertThat(result, is(nullValue()));

        }

        @Test
        public void 指定のパラメータと同様の主キーを持つDbT2002介護賦課が存在する場合_getFukaEntityメソッドにより_指定のパラメータと同様の主キーを持つ介護賦課DbT2002Fukaを保持するFukaEntityを取得する() {
            TestSupport.insertDbT2002(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
            param = FukaMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
            result = sut.getFukaEntity(param);
            assertThat(result.get介護賦課Entity().getChoteiNendo(), is(choteiNendo));
            assertThat(result.get介護賦課Entity().getFukaNendo(), is(fukaNendo));
            assertThat(result.get介護賦課Entity().getTsuchishoNo(), is(tsuchishoNo));
            assertThat(result.get介護賦課Entity().getRirekiNo(), is(rirekiNo));
        }
    }

    public static class get介護賦課_DbT2003Kibetsu介護期別情報取得Test extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IFukaMapper.class);
            dbTestHelper = new DbTestHelper();
            choteiNendo = new FlexibleYear(new RString("2011"));
            fukaNendo = new FlexibleYear(new RString("2015"));
            tsuchishoNo = new TsuchishoNo(new RString("123"));
            rirekiNo = new Decimal(156);
            choshuHouhou = new RString("789");
            choteiId = new Decimal(1024);
        }

        @Test
        public void 指定のパラメータと同様ない主キーを持つDbT2003Kibetsu介護賦課が存在しない場合_getFukaEntityメソッドにより_nullが返却される() {
            TestSupport.insertDbT2003(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo, choshuHouhou, 1);
            param = FukaMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, new Decimal(157));
            result = sut.getFukaEntity(param);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 指定のパラメータと同様の主キーを持つDbT2003介護期別が存在する場合_getKaigoServiceEntityメソッドにより_指定のパラメータと同様の主キーを持つ介護期別DbT2003Kibetsuを保持するFukaEntityを取得する() {
            TestSupport.insertDbT2003(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo, choshuHouhou, 1);
            param = FukaMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
            result = sut.getFukaEntity(param);
            assertThat(result.get介護期別Entity().get(0).getChoteiNendo(), is(choteiNendo));
            assertThat(result.get介護期別Entity().get(0).getFukaNendo(), is(fukaNendo));
            assertThat(result.get介護期別Entity().get(0).getTsuchishoNo(), is(tsuchishoNo));
            assertThat(result.get介護期別Entity().get(0).getRirekiNo(), is(rirekiNo));
        }

    }

    private static class TestSupport {

        public static void insertDbT2002(
                FlexibleYear choteiNendo,
                FlexibleYear fukaNendo,
                TsuchishoNo tsuchishoNo,
                Decimal rirekiNo) {
            DbT2002FukaEntity entity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            entity.setChoteiNendo(choteiNendo);
            entity.setFukaNendo(fukaNendo);
            entity.setTsuchishoNo(tsuchishoNo);
            entity.setRirekiNo(rirekiNo);
            entity.setState(EntityDataState.Added);
            介護賦課Dac.save(entity);
        }

        public static void insertDbT2003(
                FlexibleYear choteiNendo,
                FlexibleYear fukaNendo,
                TsuchishoNo tsuchishoNo,
                Decimal rirekiNo,
                RString choshuHouhou,
                int ki) {
            DbT2003KibetsuEntity entity = DbT2003KibetsuEntityGenerator.createDbT2003KibetsuEntity();
            entity.setChoteiNendo(choteiNendo);
            entity.setFukaNendo(fukaNendo);
            entity.setTsuchishoNo(tsuchishoNo);
            entity.setRirekiNo(rirekiNo);
            entity.setChoshuHouhou(choshuHouhou);
            entity.setKi(ki);
            entity.setState(EntityDataState.Added);
            介護期別Dac.save(entity);
        }

    }
}
