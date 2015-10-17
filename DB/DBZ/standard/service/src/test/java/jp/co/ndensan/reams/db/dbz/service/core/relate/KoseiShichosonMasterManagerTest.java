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
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoseiShichosonShishoMasterBuilder;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.IKoseiShichosonMasterMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KoseiShichosonShishoMasterManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KoseiShichosonMasterManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterManagerTest {

    private static KoseiShichosonMasterDac relateDac;
    // 構成市町村マスタ
    private static DbT7051KoseiShichosonMasterDac dac;
    private static KoseiShichosonMasterManager sut;
    private static KoseiShichosonShishoMasterManager 構成市町村支所マスタManager;

    private static MapperProvider provider;
    private static IKoseiShichosonMasterMapper mapper;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IKoseiShichosonMasterMapper.class);
// 構成市町村マスタ
        dac = mock(DbT7051KoseiShichosonMasterDac.class);
        構成市町村支所マスタManager = mock(KoseiShichosonShishoMasterManager.class);
        sut = new KoseiShichosonMasterManager(provider, dac,
                構成市町村支所マスタManager);
    }

    public static class createInstanceのテスト {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            KoseiShichosonMasterManager result = KoseiShichosonMasterManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            KoseiShichosonMasterManager result = KoseiShichosonMasterManager.createInstance();
            assertThat(result, instanceOf(KoseiShichosonMasterManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村マスタ extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get構成市町村マスタ(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.select構成市町村マスタByKey(any(KoseiShichosonMasterMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;

            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createXXXParam(主キー1);
            KoseiShichosonMaster result = sut.get構成市町村マスタ(構成市町村マスタ検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            KoseiShichosonMasterEntity entity = new KoseiShichosonMasterEntity();
            entity.set構成市町村マスタEntity(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());
            when(mapper.select構成市町村マスタByKey(any(KoseiShichosonMasterMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createXXXParam(主キー1);
            KoseiShichosonMaster result = sut.get構成市町村マスタ(構成市町村マスタ検索条件);

            assertThat(result.get市町村識別ID(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get構成市町村マスタリストBy主キー1 extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get構成市町村マスタリストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.select構成市町村マスタリストBy主キー1(any(KoseiShichosonMasterMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createXXXParam(主キー1);
            List<KoseiShichosonMaster> result = sut.get構成市町村マスタリストBy主キー1(構成市町村マスタ検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            KoseiShichosonMasterEntity entity = new KoseiShichosonMasterEntity();
            entity.set構成市町村マスタEntity(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());

            List<KoseiShichosonMasterEntity> entityList = Arrays.asList(entity);
            when(mapper.select構成市町村マスタリストBy主キー1(any(KoseiShichosonMasterMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createXXXParam(主キー1);
            List<KoseiShichosonMaster> result = sut.get構成市町村マスタリストBy主キー1(構成市町村マスタ検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村識別ID(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID));
        }
    }

    public static class save構成市町村マスタ extends DbzTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 構成市町村マスタ
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);
            when(構成市町村支所マスタManager.save構成市町村支所マスタ(any(KoseiShichosonShishoMaster.class))).thenReturn(true);
            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1);

            assertThat(sut.save(構成市町村マスタ), is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 構成市町村マスタ
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);
            when(構成市町村支所マスタManager.save構成市町村支所マスタ(any(KoseiShichosonShishoMaster.class))).thenReturn(true);
            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1);

            assertThat(sut.save(構成市町村マスタ), is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 構成市町村マスタ
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);
            when(構成市町村支所マスタManager.save構成市町村支所マスタ(any(KoseiShichosonShishoMaster.class))).thenReturn(true);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1);
            構成市町村マスタ = TestSupport.initializeKoseiShichosonMaster(構成市町村マスタ);
            構成市町村マスタ = TestSupport.modifiedKoseiShichosonMaster(構成市町村マスタ);

            assertThat(sut.save(構成市町村マスタ), is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 構成市町村マスタ
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);
            when(構成市町村支所マスタManager.save構成市町村支所マスタ(any(KoseiShichosonShishoMaster.class))).thenReturn(true);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1);
            構成市町村マスタ = TestSupport.initializeKoseiShichosonMaster(構成市町村マスタ);
            構成市町村マスタ = TestSupport.modifiedKoseiShichosonMaster(構成市町村マスタ);

            assertThat(sut.save(構成市町村マスタ), is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 構成市町村マスタ
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);
            when(構成市町村支所マスタManager.save構成市町村支所マスタ(any(KoseiShichosonShishoMaster.class))).thenReturn(true);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1);
            構成市町村マスタ = TestSupport.initializeKoseiShichosonMaster(構成市町村マスタ);
            構成市町村マスタ = 構成市町村マスタ.deleted();

            assertThat(sut.save(構成市町村マスタ), is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 構成市町村マスタ
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);
            when(構成市町村支所マスタManager.save構成市町村支所マスタ(any(KoseiShichosonShishoMaster.class))).thenReturn(true);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1);
            構成市町村マスタ = TestSupport.initializeKoseiShichosonMaster(構成市町村マスタ);
            構成市町村マスタ = 構成市町村マスタ.deleted();

            assertThat(sut.save(構成市町村マスタ), is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 構成市町村マスタ
            when(dac.save(any(DbT7051KoseiShichosonMasterEntity.class))).thenReturn(1);
            when(構成市町村支所マスタManager.save構成市町村支所マスタ(any(KoseiShichosonShishoMaster.class))).thenReturn(true);

            RString 主キー1 = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1);
            構成市町村マスタ = TestSupport.initializeKoseiShichosonMaster(構成市町村マスタ);

            assertThat(sut.save(構成市町村マスタ), is(false));
        }
    }

    private static class TestSupport {

        public static KoseiShichosonMaster createKoseiShichosonMaster(RString 主キー1) {
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(主キー1);
            return 構成市町村マスタ.createBuilderForEdit()
                    // 構成市町村支所マスタ
                    .setKoseiShichosonShishoMaster(createKoseiShichosonShishoMaster(new LasdecCode("209007"), new ShishoCode("0001")))
                    .build();
        }

// 構成市町村支所マスタ
        private static KoseiShichosonShishoMaster createKoseiShichosonShishoMaster(LasdecCode 主キー1, ShishoCode 主キー2) {
            return new KoseiShichosonShishoMaster(
                    主キー1,
                    主キー2);
        }

        public static KoseiShichosonMaster initializeKoseiShichosonMaster(KoseiShichosonMaster 構成市町村マスタ) {

            DbT7051KoseiShichosonMasterEntity techoEntity = 構成市町村マスタ.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT7052KoseiShichosonShishoMasterEntity> KoseiShichosonShishoMasterEntityList = new ArrayList<>();
            List<KoseiShichosonShishoMaster> 構成市町村支所マスタリスト = 構成市町村マスタ.getKoseiShichosonShishoMasterList();
            for (KoseiShichosonShishoMaster 構成市町村支所マスタ : 構成市町村支所マスタリスト) {
                KoseiShichosonShishoMasterEntityList.add(構成市町村支所マスタ.toEntity());
            }

            KoseiShichosonMasterEntity relateEntity = new KoseiShichosonMasterEntity();
            relateEntity.set構成市町村マスタEntity(techoEntity);
            relateEntity.set構成市町村支所マスタEntity(KoseiShichosonShishoMasterEntityList);
            relateEntity.initializeMd5ToEntities();

// 構成市町村マスタ
            return new KoseiShichosonMaster(relateEntity.get構成市町村マスタEntity());
        }

        public static KoseiShichosonMaster modifiedKoseiShichosonMaster(KoseiShichosonMaster 構成市町村マスタ) {

// 構成市町村支所マスタ
            KoseiShichosonShishoMasterBuilder KoseiShichosonShishoMasterBuilder = 構成市町村マスタ.getKoseiShichosonShishoMasterList().get(0).createBuilderForEdit();
            KoseiShichosonShishoMaster KoseiShichosonShishoMaster = KoseiShichosonShishoMasterBuilder.set支所名(new RString("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            構成市町村マスタ = 構成市町村マスタ.createBuilderForEdit()
                    .set郡名称(new RString("群")) // TODO 任意項目の値を変更してください。
                    // 構成市町村支所マスタ
                    .setKoseiShichosonShishoMaster(KoseiShichosonShishoMaster)
                    .build();
            return 構成市町村マスタ.modified();
        }
    }
}
