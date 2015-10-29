/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate;

import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.IChohyoSeigyoKyotsuMapper;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.ChohyoSeigyoKyotsuMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7065ChohyoSeigyoKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7066ChohyoSeigyoKyotsuControlEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7067ChohyoSeigyoHanyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7066ChohyoSeigyoKyotsuControlDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * {@link IChohyoSeigyoKyotsuMapper}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IChohyoSeigyoKyotsuMapperTest {

    private static IChohyoSeigyoKyotsuMapper sut;
    private static DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private static DbT7066ChohyoSeigyoKyotsuControlDac 帳票制御共通コントロールDac;
    private static DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static final SubGyomuCode 主キー11 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
    private static final SubGyomuCode 主キー12 = new SubGyomuCode("DBZ");
    private static final ReportId 主キー21 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
    private static final ReportId 主キー22 = new ReportId("00000001");

    @BeforeClass
    public static void setUpClass() {
        帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        帳票制御共通コントロールDac = InstanceProvider.create(DbT7066ChohyoSeigyoKyotsuControlDac.class);
        帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select帳票制御共通ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IChohyoSeigyoKyotsuMapper.class);
            TestSupport.insertDbT7065(主キー11, 主キー21);
            TestSupport.insertDbT7065(主キー11, 主キー22);
            TestSupport.insertDbT7065(主キー12, 主キー21);
            TestSupport.insertDbT7065(主キー12, 主キー22);

            TestSupport.insertDbT7066(主キー11, 主キー21);
            TestSupport.insertDbT7066(主キー11, 主キー22);
            TestSupport.insertDbT7066(主キー12, 主キー21);
            TestSupport.insertDbT7066(主キー12, 主キー22);

            TestSupport.insertDbT7067(主キー11, 主キー21);
            TestSupport.insertDbT7067(主キー11, 主キー22);
            TestSupport.insertDbT7067(主キー12, 主キー21);
            TestSupport.insertDbT7067(主キー12, 主キー22);
        }

        // TODO 見つかる場合、帳票制御共通Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_帳票制御共通Entity返す() {
            ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件 = ChohyoSeigyoKyotsuMapperParameter.createSelectByKeyParam(主キー11, 主キー21);
            assertThat(sut.select帳票制御共通ByKey(帳票制御共通検索条件).get帳票制御共通Entity().getSubGyomuCode(), is(主キー11));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件 = ChohyoSeigyoKyotsuMapperParameter.createSelectByKeyParam(new SubGyomuCode("DQY"), 主キー21);
            assertThat(sut.select帳票制御共通ByKey(帳票制御共通検索条件), is(nullValue()));
        }
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select帳票制御共通一覧By主キーTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(IChohyoSeigyoKyotsuMapper.class);
            TestSupport.insertDbT7065(主キー11, 主キー21);
            TestSupport.insertDbT7065(主キー11, 主キー22);
            TestSupport.insertDbT7065(主キー12, 主キー21);
            TestSupport.insertDbT7065(主キー12, 主キー22);

            TestSupport.insertDbT7066(主キー11, 主キー21);
            TestSupport.insertDbT7066(主キー11, 主キー22);
            TestSupport.insertDbT7066(主キー12, 主キー21);
            TestSupport.insertDbT7066(主キー12, 主キー22);

            TestSupport.insertDbT7067(主キー11, 主キー21);
            TestSupport.insertDbT7067(主キー11, 主キー22);
            TestSupport.insertDbT7067(主キー12, 主キー21);
            TestSupport.insertDbT7067(主キー12, 主キー22);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳Entityリストを返す() {
            ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件 = ChohyoSeigyoKyotsuMapperParameter.createSelectListParam(主キー11);
            List<ChohyoSeigyoKyotsuEntity> entityList = sut.select帳票制御共通リストBy主キー1(帳票制御共通検索条件);
            assertThat(entityList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(entityList.get(0).get帳票制御共通Entity().getSubGyomuCode(), is(主キー11));
            assertThat(entityList.get(1).get帳票制御共通Entity().getSubGyomuCode(), is(主キー11));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件 = ChohyoSeigyoKyotsuMapperParameter.createSelectListParam(new SubGyomuCode("DQY"));
            assertThat(sut.select帳票制御共通リストBy主キー1(帳票制御共通検索条件).isEmpty(), is(true));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT7065(
                SubGyomuCode 主キー1,
                ReportId 主キー2) {
            DbT7065ChohyoSeigyoKyotsuEntity entity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            entity.setSubGyomuCode(主キー1);
            entity.setChohyoBunruiID(主キー2);
            entity.setState(EntityDataState.Added);
            帳票制御共通Dac.save(entity);
        }

        public static void insertDbT7066(
                SubGyomuCode 主キー1,
                ReportId 主キー2) {
            DbT7066ChohyoSeigyoKyotsuControlEntity entity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            entity.setSubGyomuCode(主キー1);
            entity.setChohyoBunruiID(主キー2);
            entity.setState(EntityDataState.Added);
            帳票制御共通コントロールDac.save(entity);
        }

        public static void insertDbT7067(
                SubGyomuCode 主キー1,
                ReportId 主キー2) {
            DbT7067ChohyoSeigyoHanyoEntity entity = DbT7067ChohyoSeigyoHanyoEntityGenerator.createDbT7067ChohyoSeigyoHanyoEntity();
            entity.setSubGyomuCode(主キー1);
            entity.setChohyoBunruiID(主キー2);
            entity.setState(EntityDataState.Added);
            帳票制御汎用Dac.save(entity);
        }
    }

}
