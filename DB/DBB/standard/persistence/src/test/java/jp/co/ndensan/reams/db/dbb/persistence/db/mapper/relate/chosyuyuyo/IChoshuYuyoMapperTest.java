/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.chosyuyuyo;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2006ChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2007KibetsuChoshuYuyoDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choshuyuyo.IChoshuYuyoMapper;
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
 * {@link IChoshuYuyoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IChoshuYuyoMapperTest {

    private static DbT2006ChoshuYuyoDac 介護賦課徴収猶予Dac;
    private static DbT2007KibetsuChoshuYuyoDac 介護期別徴収猶予Dac;
    private static ChoshuYuyoEntity result;
    private static IChoshuYuyoMapper sut;

    private static DbTestHelper dbTestHelper;
    private static ChoshuYuyoMapperParameter param;

    private static FlexibleYear choteiNendo;
    private static FlexibleYear fukaNendo;
    private static TsuchishoNo tsuchishoNo;
    private static Decimal rirekiNo;
    private static RString choshuHoho;
    private static int ki;

    @BeforeClass
    public static void setUpClass() {
        dbTestHelper = new DbTestHelper();
        choteiNendo = new FlexibleYear(new RString("2011"));
        fukaNendo = new FlexibleYear(new RString("2015"));
        tsuchishoNo = new TsuchishoNo(new RString("123"));
        rirekiNo = new Decimal(156);
        choshuHoho = new RString("789");
        ki = 1024;
    }

    @AfterClass
    public static void tearDownClass() {
        DbbTestDacBase.tearDownClass();
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class get介護賦課徴収猶予DbT2006ChoshuYuyoTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IChoshuYuyoMapper.class);
            dbTestHelper.truncateTable(sqlSession, DbT2006ChoshuYuyoEntity.TABLE_NAME);
        }

        // TODO 見つかる場合、介護賦課徴収猶予Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void 指定のパラメータと同様ない主キーを持つDbT2006介護賦課徴収猶予が存在しない場合_getChoshuyuyoEntityメソッドにより_nullが返却される() {
            TestSupport.insertDbT2006(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
            param = ChoshuYuyoMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, new Decimal(157));
            result = sut.getChoshuyuyoEntity(param);
            assertThat(result, is(nullValue()));

        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void 指定のパラメータと同様の主キーを持つDbT2006介護賦課徴収猶予が存在する場合_getChoshuyuyoEntityメソッドにより_指定のパラメータと同様の主キーを持つ介護賦課徴収猶予DbT2006を保持するgetChoshuyuyoEntityを取得する() {
            TestSupport.insertDbT2006(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
            param = ChoshuYuyoMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
            result = sut.getChoshuyuyoEntity(param);
            assertThat(result.get介護賦課徴収猶予Entity().getChoteiNendo(), is(choteiNendo));
            assertThat(result.get介護賦課徴収猶予Entity().getFukaNendo(), is(fukaNendo));
            assertThat(result.get介護賦課徴収猶予Entity().getTsuchishoNo(), is(tsuchishoNo));
            assertThat(result.get介護賦課徴収猶予Entity().getRirekiNo(), is(rirekiNo));

        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class get介護期別徴収猶予DbT2007KibetsuChoshuYuyoTest extends DbbTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IChoshuYuyoMapper.class);
            dbTestHelper.truncateTable(sqlSession, DbT2007KibetsuChoshuYuyoEntity.TABLE_NAME);
        }

        @Test
        public void 指定のパラメータと同様ない主キーを持つDbT2007介護賦課徴収猶予が存在しない場合_getChoshuyuyoEntityメソッドにより_nullが返却される() {
            TestSupport.insertDbT2007(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo, choshuHoho, ki);
            param = ChoshuYuyoMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, new Decimal(157));
            result = sut.getChoshuyuyoEntity(param);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 指定のパラメータと同様の主キーを持つDbT2007介護賦課徴収猶予が存在する場合_getChoshuyuyoEntityメソッドにより_指定のパラメータと同様の主キーを持つ介護賦課徴収猶予DbT2007を保持するgetChoshuyuyoEntityを取得する() {
            TestSupport.insertDbT2007(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo, choshuHoho, ki);
            param = ChoshuYuyoMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);
            result = sut.getChoshuyuyoEntity(param);
            assertThat(result.get介護期別徴収猶予Entity().get(0).getChoteiNendo(), is(choteiNendo));
            assertThat(result.get介護期別徴収猶予Entity().get(0).getFukaNendo(), is(fukaNendo));
            assertThat(result.get介護期別徴収猶予Entity().get(0).getTsuchishoNo(), is(tsuchishoNo));
            assertThat(result.get介護期別徴収猶予Entity().get(0).getRirekiNo(), is(rirekiNo));
            assertThat(result.get介護期別徴収猶予Entity().get(0).getChoshuHoho(), is(choshuHoho));
            assertThat(result.get介護期別徴収猶予Entity().get(0).getKi(), is(ki));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT2006(
                FlexibleYear choteiNendo,
                FlexibleYear fukaNendo,
                TsuchishoNo tsuchishoNo,
                Decimal rirekiNo) {
            DbT2006ChoshuYuyoEntity entity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            entity.setChoteiNendo(choteiNendo);
            entity.setFukaNendo(fukaNendo);
            entity.setTsuchishoNo(tsuchishoNo);
            entity.setRirekiNo(rirekiNo);
            entity.setState(EntityDataState.Added);
            介護賦課徴収猶予Dac.save(entity);
        }

        public static void insertDbT2007(
                FlexibleYear choteiNendo,
                FlexibleYear fukaNendo,
                TsuchishoNo tsuchishoNo,
                Decimal rirekiNo,
                RString choshuHoho,
                int ki) {
            DbT2007KibetsuChoshuYuyoEntity entity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            entity.setChoteiNendo(choteiNendo);
            entity.setFukaNendo(fukaNendo);
            entity.setTsuchishoNo(tsuchishoNo);
            entity.setRirekiNo(rirekiNo);
            entity.setChoshuHoho(choshuHoho);
            entity.setKi(ki);
            entity.setState(EntityDataState.Added);
            介護期別徴収猶予Dac.save(entity);
        }
    }

}
