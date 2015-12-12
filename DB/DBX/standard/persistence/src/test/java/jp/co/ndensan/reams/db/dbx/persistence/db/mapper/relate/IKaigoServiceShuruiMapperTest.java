/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.relate.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IKaigoServiceShuruiMapper}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IKaigoServiceShuruiMapperTest {

    private static IKaigoServiceShuruiMapper sut;
    private static DbT7130KaigoServiceShuruiDac 介護サービス種類Dac;
    private static DbT7131KaigoServiceNaiyouDac 介護サービス内容Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final KaigoServiceShuruiCode 主キー11 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
    private static final KaigoServiceShuruiCode 主キー12 = new KaigoServiceShuruiCode("01");
    private static final FlexibleYearMonth 主キー21 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
    private static final FlexibleYearMonth 主キー22 = new FlexibleYearMonth("201509");

    @BeforeClass
    public static void setUpClass() {
        介護サービス種類Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        介護サービス内容Dac = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護サービス種類ByKeyTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKaigoServiceShuruiMapper.class);
            TestSupport.insertDbT7130(主キー11, 主キー21);
            TestSupport.insertDbT7130(主キー11, 主キー22);
            TestSupport.insertDbT7130(主キー12, 主キー21);
            TestSupport.insertDbT7130(主キー12, 主キー22);

            TestSupport.insertDbT7131(主キー11, 主キー21);
            TestSupport.insertDbT7131(主キー11, 主キー22);
            TestSupport.insertDbT7131(主キー12, 主キー21);
            TestSupport.insertDbT7131(主キー12, 主キー22);
        }

        // TODO 見つかる場合、介護サービス種類Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_介護サービス種類Entity返す() {
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select介護サービス種類ByKey(介護サービス種類検索条件).get介護サービス種類Entity().getServiceShuruiCd(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(new KaigoServiceShuruiCode("01"), 主キー21);
            assertThat(sut.select介護サービス種類ByKey(介護サービス種類検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護サービス種類一覧By主キーTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKaigoServiceShuruiMapper.class);
            TestSupport.insertDbT7130(主キー11, 主キー21);
            TestSupport.insertDbT7130(主キー11, 主キー22);
            TestSupport.insertDbT7130(主キー12, 主キー21);
            TestSupport.insertDbT7130(主キー12, 主キー22);

            TestSupport.insertDbT7131(主キー11, 主キー21);
            TestSupport.insertDbT7131(主キー11, 主キー22);
            TestSupport.insertDbT7131(主キー12, 主キー21);
            TestSupport.insertDbT7131(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createSelectListParam(主キー11);
            List<KaigoServiceShuruiEntity> entityList = sut.select介護サービス種類リストBy主キー1(介護サービス種類検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get介護サービス種類Entity().getServiceShuruiCd(), is(主キー11));
            assertThat(entityList.get(1).get介護サービス種類Entity().getServiceShuruiCd(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createSelectListParam(new KaigoServiceShuruiCode("01"));
            assertThat(sut.select介護サービス種類リストBy主キー1(介護サービス種類検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT7130(
                KaigoServiceShuruiCode 主キー1,
                FlexibleYearMonth 主キー2) {
            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            entity.setServiceShuruiCd(主キー1);
            entity.setTeikyoKaishiYM(主キー2);
            entity.setState(EntityDataState.Added);
            介護サービス種類Dac.save(entity);
        }

        public static void insertDbT7131(
                KaigoServiceShuruiCode 主キー1,
                FlexibleYearMonth 主キー2) {
            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.setServiceShuruiCode(主キー1);
            entity.setTeikyoKaishiYM(主キー2);
            entity.setState(EntityDataState.Added);
            介護サービス内容Dac.save(entity);
        }
    }

}
