/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.relate.KaigoJigyoshaMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link IKaigoJigyoshaMapper}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IKaigoJigyoshaMapperTest {

    private static IKaigoJigyoshaMapper sut;
    private static DbT7060KaigoJigyoshaDac 介護事業者Dac;
    private static DbT7062KaigoJigyoshaDaihyoshaDac 介護事業者代表者Dac;
    private static DbT7063KaigoJigyoshaShiteiServiceDac 介護事業者指定サービスDac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final KaigoJigyoshaNo 主キー11 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_事業者番号;
    private static final KaigoJigyoshaNo 主キー12 = new KaigoJigyoshaNo("0123400001");
    private static final FlexibleDate 主キー21 = DbT7060KaigoJigyoshaEntityGenerator.DEFAULT_有効開始日;
    private static final FlexibleDate 主キー22 = new FlexibleDate("001");

    @BeforeClass
    public static void setUpClass() {
        介護事業者Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        介護事業者代表者Dac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
        介護事業者指定サービスDac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護事業者ByKeyTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKaigoJigyoshaMapper.class);
            TestSupport.insertDbT7060(主キー11, 主キー21);
            TestSupport.insertDbT7060(主キー11, 主キー22);
            TestSupport.insertDbT7060(主キー12, 主キー21);
            TestSupport.insertDbT7060(主キー12, 主キー22);

            TestSupport.insertDbT7062(主キー11, 主キー21);
            TestSupport.insertDbT7062(主キー11, 主キー22);
            TestSupport.insertDbT7062(主キー12, 主キー21);
            TestSupport.insertDbT7062(主キー12, 主キー22);

            TestSupport.insertDbT7063(主キー11, 主キー21);
            TestSupport.insertDbT7063(主キー11, 主キー22);
            TestSupport.insertDbT7063(主キー12, 主キー21);
            TestSupport.insertDbT7063(主キー12, 主キー22);
        }

        // TODO 見つかる場合、介護事業者Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_介護事業者Entity返す() {
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select介護事業者ByKey(介護事業者検索条件).get介護事業者Entity().getJigyoshaNo(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectByKeyParam(new KaigoJigyoshaNo("0123400001"), 主キー21);
            assertThat(sut.select介護事業者ByKey(介護事業者検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select介護事業者一覧By主キーTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IKaigoJigyoshaMapper.class);
            TestSupport.insertDbT7060(主キー11, 主キー21);
            TestSupport.insertDbT7060(主キー11, 主キー22);
            TestSupport.insertDbT7060(主キー12, 主キー21);
            TestSupport.insertDbT7060(主キー12, 主キー22);

            TestSupport.insertDbT7062(主キー11, 主キー21);
            TestSupport.insertDbT7062(主キー11, 主キー22);
            TestSupport.insertDbT7062(主キー12, 主キー21);
            TestSupport.insertDbT7062(主キー12, 主キー22);

            TestSupport.insertDbT7063(主キー11, 主キー21);
            TestSupport.insertDbT7063(主キー11, 主キー22);
            TestSupport.insertDbT7063(主キー12, 主キー21);
            TestSupport.insertDbT7063(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectListParam(主キー11);
            List<KaigoJigyoshaEntity> entityList = sut.select介護事業者リストBy主キー1(介護事業者検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get介護事業者Entity().getJigyoshaNo(), is(主キー11));
            assertThat(entityList.get(1).get介護事業者Entity().getJigyoshaNo(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            KaigoJigyoshaMapperParameter 介護事業者検索条件 = KaigoJigyoshaMapperParameter.createSelectListParam(new KaigoJigyoshaNo("0123400001"));
            assertThat(sut.select介護事業者リストBy主キー1(介護事業者検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT7060(
                KaigoJigyoshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT7060KaigoJigyoshaEntity entity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
            entity.setJigyoshaNo(主キー1);
            entity.setYukoKaishiYMD(主キー2);
            entity.setState(EntityDataState.Added);
            介護事業者Dac.save(entity);
        }

        public static void insertDbT7062(
                KaigoJigyoshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT7062KaigoJigyoshaDaihyoshaEntity entity = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity();
            entity.setJigyoshaNo(主キー1);
            entity.setYukoKaishiYMD(主キー2);
            entity.setState(EntityDataState.Added);
            介護事業者代表者Dac.save(entity);
        }

        public static void insertDbT7063(
                KaigoJigyoshaNo 主キー1,
                FlexibleDate 主キー2) {
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity();
            entity.setJigyoshaNo(主キー1);
            entity.setYukoKaishiYMD(主キー2);
            entity.setState(EntityDataState.Added);
            介護事業者指定サービスDac.save(entity);
        }
    }

}
