/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.relate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsuControl;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsuControlBuilder;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.ChohyoSeigyoKyotsuMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7065ChohyoSeigyoKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.chohyoseigyokyotsu.IChohyoSeigyoKyotsuMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuControlManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ChohyoSeigyoKyotsuManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ChohyoSeigyoKyotsuManagerTest {

    // 帳票制御共通
    private static DbT7065ChohyoSeigyoKyotsuDac dac;
    private static ChohyoSeigyoKyotsuManager sut;
    private static ChohyoSeigyoKyotsuControlManager 帳票制御共通コントロールManager;
    private static ChohyoSeigyoHanyoManager 帳票制御汎用Manager;

    private static MapperProvider provider;
    private static IChohyoSeigyoKyotsuMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IChohyoSeigyoKyotsuMapper.class);
// 帳票制御共通
        dac = mock(DbT7065ChohyoSeigyoKyotsuDac.class);
        帳票制御共通コントロールManager = mock(ChohyoSeigyoKyotsuControlManager.class);
        帳票制御汎用Manager = mock(ChohyoSeigyoHanyoManager.class);
        sut = new ChohyoSeigyoKyotsuManager(provider, dac,
                帳票制御共通コントロールManager,
                帳票制御汎用Manager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            ChohyoSeigyoKyotsuManager result = ChohyoSeigyoKyotsuManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            ChohyoSeigyoKyotsuManager result = ChohyoSeigyoKyotsuManager.createInstance();
            assertThat(result, instanceOf(ChohyoSeigyoKyotsuManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get帳票制御共通 extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get帳票制御共通(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select帳票制御共通ByKey(any(ChohyoSeigyoKyotsuMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;

            ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件 = ChohyoSeigyoKyotsuMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            ChohyoSeigyoKyotsu result = sut.get帳票制御共通(帳票制御共通検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            ChohyoSeigyoKyotsuEntity entity = new ChohyoSeigyoKyotsuEntity();
            entity.set帳票制御共通Entity(DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity());
            when(mapper.select帳票制御共通ByKey(any(ChohyoSeigyoKyotsuMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
            ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件 = ChohyoSeigyoKyotsuMapperParameter.createSelectByKeyParam(主キー1, 主キー2);
            ChohyoSeigyoKyotsu result = sut.get帳票制御共通(帳票制御共通検索条件);

            assertThat(result.getサブ業務コード().value(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get帳票制御共通リストBy主キー1 extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get帳票制御共通リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select帳票制御共通リストBy主キー1(any(ChohyoSeigyoKyotsuMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件 = ChohyoSeigyoKyotsuMapperParameter.createSelectListParam(主キー1);
            List<ChohyoSeigyoKyotsu> result = sut.get帳票制御共通リストBy主キー1(帳票制御共通検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            ChohyoSeigyoKyotsuEntity entity = new ChohyoSeigyoKyotsuEntity();
            entity.set帳票制御共通Entity(DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity());

            List<ChohyoSeigyoKyotsuEntity> entityList = Arrays.asList(entity);
            when(mapper.select帳票制御共通リストBy主キー1(any(ChohyoSeigyoKyotsuMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ChohyoSeigyoKyotsuMapperParameter 帳票制御共通検索条件 = ChohyoSeigyoKyotsuMapperParameter.createSelectListParam(主キー1);
            List<ChohyoSeigyoKyotsu> result = sut.get帳票制御共通リストBy主キー1(帳票制御共通検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサブ業務コード().value(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード.value()));
        }
    }

    public static class save帳票制御共通 extends DbzTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 帳票制御共通
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);
            when(帳票制御共通コントロールManager.save帳票制御共通コントロール(any(ChohyoSeigyoKyotsuControl.class))).thenReturn(true);
            when(帳票制御汎用Manager.save帳票制御汎用(any(ChohyoSeigyoHanyo.class))).thenReturn(true);
            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
            ChohyoSeigyoKyotsu 帳票制御共通 = TestSupport.createChohyoSeigyoKyotsu(主キー1, 主キー2);

            assertThat(sut.save(帳票制御共通), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 帳票制御共通
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);
            when(帳票制御共通コントロールManager.save帳票制御共通コントロール(any(ChohyoSeigyoKyotsuControl.class))).thenReturn(true);
            when(帳票制御汎用Manager.save帳票制御汎用(any(ChohyoSeigyoHanyo.class))).thenReturn(true);
            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
            ChohyoSeigyoKyotsu 帳票制御共通 = TestSupport.createChohyoSeigyoKyotsu(主キー1, 主キー2);

            assertThat(sut.save(帳票制御共通), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 帳票制御共通
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);
            when(帳票制御共通コントロールManager.save帳票制御共通コントロール(any(ChohyoSeigyoKyotsuControl.class))).thenReturn(true);
            when(帳票制御汎用Manager.save帳票制御汎用(any(ChohyoSeigyoHanyo.class))).thenReturn(true);

            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
            ChohyoSeigyoKyotsu 帳票制御共通 = TestSupport.createChohyoSeigyoKyotsu(主キー1, 主キー2);
            帳票制御共通 = TestSupport.initializeChohyoSeigyoKyotsu(帳票制御共通);
            帳票制御共通 = TestSupport.modifiedChohyoSeigyoKyotsu(帳票制御共通);

            assertThat(sut.save(帳票制御共通), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 帳票制御共通
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);
            when(帳票制御共通コントロールManager.save帳票制御共通コントロール(any(ChohyoSeigyoKyotsuControl.class))).thenReturn(true);
            when(帳票制御汎用Manager.save帳票制御汎用(any(ChohyoSeigyoHanyo.class))).thenReturn(true);

            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
            ChohyoSeigyoKyotsu 帳票制御共通 = TestSupport.createChohyoSeigyoKyotsu(主キー1, 主キー2);
            帳票制御共通 = TestSupport.initializeChohyoSeigyoKyotsu(帳票制御共通);
            帳票制御共通 = TestSupport.modifiedChohyoSeigyoKyotsu(帳票制御共通);

            assertThat(sut.save(帳票制御共通), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 帳票制御共通
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);
            when(帳票制御共通コントロールManager.save帳票制御共通コントロール(any(ChohyoSeigyoKyotsuControl.class))).thenReturn(true);
            when(帳票制御汎用Manager.save帳票制御汎用(any(ChohyoSeigyoHanyo.class))).thenReturn(true);

            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
            ChohyoSeigyoKyotsu 帳票制御共通 = TestSupport.createChohyoSeigyoKyotsu(主キー1, 主キー2);
            帳票制御共通 = TestSupport.initializeChohyoSeigyoKyotsu(帳票制御共通);
            帳票制御共通 = 帳票制御共通.deleted();

            assertThat(sut.save(帳票制御共通), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 帳票制御共通
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);
            when(帳票制御共通コントロールManager.save帳票制御共通コントロール(any(ChohyoSeigyoKyotsuControl.class))).thenReturn(true);
            when(帳票制御汎用Manager.save帳票制御汎用(any(ChohyoSeigyoHanyo.class))).thenReturn(true);

            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
            ChohyoSeigyoKyotsu 帳票制御共通 = TestSupport.createChohyoSeigyoKyotsu(主キー1, 主キー2);
            帳票制御共通 = TestSupport.initializeChohyoSeigyoKyotsu(帳票制御共通);
            帳票制御共通 = 帳票制御共通.deleted();

            assertThat(sut.save(帳票制御共通), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 帳票制御共通
            when(dac.save(any(DbT7065ChohyoSeigyoKyotsuEntity.class))).thenReturn(1);
            when(帳票制御共通コントロールManager.save帳票制御共通コントロール(any(ChohyoSeigyoKyotsuControl.class))).thenReturn(true);
            when(帳票制御汎用Manager.save帳票制御汎用(any(ChohyoSeigyoHanyo.class))).thenReturn(true);

            SubGyomuCode 主キー1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
            ReportId 主キー2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
            ChohyoSeigyoKyotsu 帳票制御共通 = TestSupport.createChohyoSeigyoKyotsu(主キー1, 主キー2);
            帳票制御共通 = TestSupport.initializeChohyoSeigyoKyotsu(帳票制御共通);

            assertThat(sut.save(帳票制御共通), is(false));
        }
    }

    private static class TestSupport {

        public static ChohyoSeigyoKyotsu createChohyoSeigyoKyotsu(SubGyomuCode 主キー1, ReportId 主キー2) {
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(主キー1, 主キー2);
            return 帳票制御共通.createBuilderForEdit()
                    // 帳票制御共通コントロール
                    .setChohyoSeigyoKyotsu(createChohyoSeigyoKyotsuControl(主キー1, 主キー2))
                    // 帳票制御汎用
                    .setChohyoSeigyoHanyo(createChohyoSeigyoHanyo(主キー1, 主キー2))
                    .build();
        }

// 帳票制御共通コントロール
        private static ChohyoSeigyoKyotsuControl createChohyoSeigyoKyotsuControl(SubGyomuCode 主キー1, ReportId 主キー2) {
            return new ChohyoSeigyoKyotsuControl(
                    主キー1,
                    主キー2);
        }
// 帳票制御汎用

        private static ChohyoSeigyoHanyo createChohyoSeigyoHanyo(SubGyomuCode 主キー1, ReportId 主キー2) {
            return new ChohyoSeigyoHanyo(主キー1, 主キー2, RString.EMPTY);
        }

        public static ChohyoSeigyoKyotsu initializeChohyoSeigyoKyotsu(ChohyoSeigyoKyotsu 帳票制御共通) {

            DbT7065ChohyoSeigyoKyotsuEntity techoEntity = 帳票制御共通.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT7066ChohyoSeigyoKyotsuControlEntity> ChohyoSeigyoKyotsuControlEntityList = new ArrayList<>();
            List<ChohyoSeigyoKyotsuControl> 帳票制御共通コントロールリスト = 帳票制御共通.getChohyoSeigyoKyotsuControlList();
            for (ChohyoSeigyoKyotsuControl 帳票制御共通コントロール : 帳票制御共通コントロールリスト) {
                ChohyoSeigyoKyotsuControlEntityList.add(帳票制御共通コントロール.toEntity());
            }
            List<DbT7067ChohyoSeigyoHanyoEntity> ChohyoSeigyoHanyoEntityList = new ArrayList<>();
            List<ChohyoSeigyoHanyo> 帳票制御汎用リスト = 帳票制御共通.getChohyoSeigyoHanyoList();
            for (ChohyoSeigyoHanyo 帳票制御汎用 : 帳票制御汎用リスト) {
                ChohyoSeigyoHanyoEntityList.add(帳票制御汎用.toEntity());
            }

            ChohyoSeigyoKyotsuEntity relateEntity = new ChohyoSeigyoKyotsuEntity();
            relateEntity.set帳票制御共通Entity(techoEntity);
            relateEntity.set帳票制御共通コントロールEntity(ChohyoSeigyoKyotsuControlEntityList);
            relateEntity.set帳票制御汎用Entity(ChohyoSeigyoHanyoEntityList);
            relateEntity.initializeMd5ToEntities();

// 帳票制御共通
            return new ChohyoSeigyoKyotsu(relateEntity.get帳票制御共通Entity());
        }

        public static ChohyoSeigyoKyotsu modifiedChohyoSeigyoKyotsu(ChohyoSeigyoKyotsu 帳票制御共通) {

// 帳票制御共通コントロール
            ChohyoSeigyoKyotsuControlBuilder ChohyoSeigyoKyotsuControlBuilder = 帳票制御共通.getChohyoSeigyoKyotsuControlList().get(0).createBuilderForEdit();
            ChohyoSeigyoKyotsuControl ChohyoSeigyoKyotsuControl = ChohyoSeigyoKyotsuControlBuilder.setカスタマバーコード使用区分(new RString("1")).build();
// 帳票制御汎用
            ChohyoSeigyoHanyoBuilder ChohyoSeigyoHanyoBuilder = 帳票制御共通.getChohyoSeigyoHanyoList().get(0).createBuilderForEdit();
            ChohyoSeigyoHanyo ChohyoSeigyoHanyo = ChohyoSeigyoHanyoBuilder.set設定値(new RString("1")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            帳票制御共通 = 帳票制御共通.createBuilderForEdit()
                    .setカスタマバーコード使用有無(false) // TODO 任意項目の値を変更してください。
                    // 帳票制御共通コントロール
                    .setChohyoSeigyoKyotsu(ChohyoSeigyoKyotsuControl)
                    // 帳票制御汎用
                    .setChohyoSeigyoHanyo(ChohyoSeigyoHanyo)
                    .build();
            return 帳票制御共通.modified();
        }
    }
}
