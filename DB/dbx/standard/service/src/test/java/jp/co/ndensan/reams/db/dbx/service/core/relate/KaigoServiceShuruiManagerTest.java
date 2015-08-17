/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KaigoServiceShuruiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiManagerTest {

    private static KaigoServiceShuruiDac relateDac;
  // 介護サービス種類
    private static DbT7130KaigoServiceShuruiDac dac;
    private static KaigoServiceShuruiManager sut;
    private static KaigoServiceNaiyouManager 介護サービス内容Manager;

    @BeforeClass
    public static void test() {
        provider = mock(MapperProvider.class);
        mapper = mock(IKaigoServiceShuruiMapper.class);
// 介護サービス種類
        dac = mock(DbT7130KaigoServiceShuruiDac.class);
        介護サービス内容Manager = mock(KaigoServiceNaiyouManager.class);
        sut = new KaigoServiceShuruiManager(provider, dac, 
介護サービス内容Manager);
    }
    
    
    public static class createInstanceのテスト {
    
        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            KaigoServiceShuruiManager result = KaigoServiceShuruiManager.createInstance();
            assertNotNull(result);
        }
        
        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            KaigoServiceShuruiManager result = KaigoServiceShuruiManager.createInstance();
            assertThat(result, instanceOf(KaigoServiceShuruiManager.class));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護サービス種類 extends FdaTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護サービス種類(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            when(mapper.getKaigoServiceShurui(any(KaigoServiceShuruiMapperParameter.class))).thenReturn(null);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            主キー型1 主キー1 = XXXEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = XXXEntityGenerator.DEFAULT_主キー2;
            
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createXXXParam(主キー1, 主キー2);
            親ビジネスクラス result = sut.get介護サービス種類(介護サービス種類検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoServiceShuruiEntity entity = new KaigoServiceShuruiEntity();
            entity.setXXXEntity(XXXEntityGenerator.createXXXEntity());
            when(mapper.getKaigoServiceShurui(any(KaigoServiceShuruiMapperParameter.class))).thenReturn(entity);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            主キー型1 主キー1 = XXXEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = XXXEntityGenerator.DEFAULT_主キー2;
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createXXXParam(主キー1, 主キー2);
            親ビジネスクラス result = sut.get介護サービス種類(介護サービス種類検索条件);


            assertThat(result.get主キー1().value(), is(XXXEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護サービス種類リストBy主キー1 extends FdaTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護サービス種類リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            when(mapper.getKaigoServiceShuruiBy主キー型1(any(KaigoServiceShuruiMapperParameter.class))).thenReturn(Collections.EMPTY_LIST);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            主キー型1 主キー1 = XXXEntityGenerator.DEFAULT_主キー1;
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createXXXParam(主キー1);
            List<親ビジネスクラス> result = sut.get介護サービス種類リストBy主キー1(介護サービス種類検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            KaigoServiceShuruiEntity entity = new KaigoServiceShuruiEntity();
            entity.setXXXEntity(XXXEntityGenerator.createXXXEntity());

            List<KaigoServiceShuruiEntity> entityList = Arrays.asList(entity);
            when(mapper.getKaigoServiceShuruiBy主キー型1(any(KaigoServiceShuruiMapperParameter.class))).thenReturn(entityList);

            when(provider.create(any(Class.class))).thenReturn(mapper);

            主キー型1 主キー1 = XXXEntityGenerator.DEFAULT_主キー1;
            KaigoServiceShuruiMapperParameter 介護サービス種類検索条件 = KaigoServiceShuruiMapperParameter.createXXXParam(主キー1);
            List<親ビジネスクラス> result = sut.get介護サービス種類リストBy主キー1(介護サービス種類検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(XXXEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save介護サービス種類 extends DbxTestBase {

        @Test
        public void insertに成功すると_trueが返る() {
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(1);
            主キー型1 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー2;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);

            assertThat(sut.save(介護サービス種類)
                    , is(true));
        }

        @Test
        public void insertに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(1);
            主キー型1 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー2;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);

            assertThat(sut.save(介護サービス種類)
                    , is(false));
        }

        @Test
        public void updateに成功すると_trueが返る() {
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー2;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeSeishinTecho(介護サービス種類);
            介護サービス種類 = TestSupport.modifiedKaigoServiceShurui(介護サービス種類);

            assertThat(sut.save(介護サービス種類)
                    , is(true));
        }

        @Test
        public void updateに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー2;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeSeishinTecho(介護サービス種類);
            介護サービス種類 = TestSupport.modifiedKaigoServiceShurui(介護サービス種類);

            assertThat(sut.save(介護サービス種類)
                    , is(false));
        }

        @Test
        public void deleteに成功すると_trueが返る() {
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー2;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
            介護サービス種類 = 介護サービス種類.deleted();

            assertThat(sut.save(介護サービス種類)
                    , is(true));
        }

        @Test
        public void deleteに失敗すると_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー2;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);
            介護サービス種類 = 介護サービス種類.deleted();

            assertThat(sut.save(介護サービス種類)
                    , is(false));
        }

        @Test
        public void 状態がUnchangedの場合_falseが返る() {
// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
// 介護サービス種類
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);
            when(介護サービス内容Manager.save介護サービス内容(any(KaigoServiceNaiyou.class))).thenReturn(1);

            主キー型1 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_主キー2;
            KaigoServiceShurui 介護サービス種類 = TestSupport.createKaigoServiceShurui(主キー1, 主キー2);
            介護サービス種類 = TestSupport.initializeKaigoServiceShurui(介護サービス種類);

            assertThat(sut.save(介護サービス種類)
                    , is(false));
        }
    }

    private static class TestSupport {

        public static KaigoServiceShurui createKaigoServiceShurui(主キー型1 主キー1, 主キー型2 主キー2) {
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(主キー1, 主キー2);
            return 介護サービス種類.createBuilderForEdit()
// 介護サービス内容
                    .setKaigoServiceNaiyou(createKaigoServiceNaiyou(主キー1, 主キー2))
                    .build();
        }

// 介護サービス内容
        private static KaigoServiceNaiyou createKaigoServiceNaiyou(主キー型1 主キー1, 主キー型2 主キー2) {
            return new KaigoServiceNaiyou(
                    主キー1, 
                    主キー2);
        }

        public static KaigoServiceShurui initializeKaigoServiceShurui(KaigoServiceShurui 介護サービス種類) {

            DbT7130KaigoServiceShuruiEntity techoEntity = 介護サービス種類.toEntity();

// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            List<DbT7131KaigoServiceNaiyouEntity> KaigoServiceNaiyouEntityList = new ArrayList<>();
            List<KaigoServiceNaiyou> 介護サービス内容リスト = XXX.getKaigoServiceNaiyouList();
            for (KaigoServiceNaiyou 介護サービス内容 : 介護サービス内容リスト) {
                KaigoServiceNaiyouEntityList.add(介護サービス内容.toEntity());
            }

            KaigoServiceShuruiEntity relateEntity = new KaigoServiceShuruiEntity();
            relateEntity.set介護サービス種類Entity(techoEntity);
            relateEntity.set介護サービス内容Entity(KaigoServiceNaiyouEntityList);
            relateEntity.initializeMd5ToEntities();

// 介護サービス種類
            return new KaigoServiceShurui(relateEntity);
        }

        public static KaigoServiceShurui modifiedKaigoServiceShurui(KaigoServiceShurui 介護サービス種類) {

// 介護サービス内容
            KaigoServiceNaiyouBuilder KaigoServiceNaiyouBuilder = XXX.getKaigoServiceNaiyouList().get(0).createBuilderForEdit();
            KaigoServiceNaiyou KaigoServiceNaiyou = KaigoServiceNaiyouBuilder.set任意項目1(new RString("任意項目1を変更")).build();
// TODO 下記のXXX部は本メソッドの引数名に変更してください。
            XXX = XXX.createBuilderForEdit()
                    .set交付備考(new RString("交付備考を変更"))  // TODO 任意項目の値を変更してください。
// 介護サービス内容
                    .setKaigoServiceNaiyou(KaigoServiceNaiyou)
                    .build();
            return XXX.modified();
        }
    }
}
