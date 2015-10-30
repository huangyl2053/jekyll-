/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeiNaiyo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7002BemmeiNaiyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7002BemmeiNaiyoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
 * {link BemmeiNaiyoManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class BemmeiNaiyoManagerTest {

    private static DbT7002BemmeiNaiyoDac dac;
    private static BemmeiNaiyoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7002BemmeiNaiyoDac.class);
        sut = new BemmeiNaiyoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get弁明内容 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のShoKisaiHokenshaNoにnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            sut.get弁明内容(null, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のShikibetsuCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            sut.get弁明内容(主キー1, null, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(ShikibetsuCode.class),
                    any(HihokenshaNo.class), any(FlexibleDate.class), any(FlexibleDate.class))).thenReturn(null);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyo result = sut.get弁明内容(主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(ShikibetsuCode.class),
                    any(HihokenshaNo.class), any(FlexibleDate.class), any(FlexibleDate.class))).thenReturn(entity);

            ShoKisaiHokenshaNo 主キー1 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_識別コード;
            BemmeiNaiyo result = sut.get弁明内容(主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX);

            assertThat(result.get証記載保険者番号().value(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get弁明内容一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<BemmeiNaiyo> result = sut.get弁明内容一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7002BemmeiNaiyoEntity> entityList = Arrays.asList(DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<BemmeiNaiyo> result = sut.get弁明内容一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get証記載保険者番号().value(), is(DbT7002BemmeiNaiyoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    public static class save弁明内容 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);

            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            BemmeiNaiyo 弁明内容 = new BemmeiNaiyo(entity);

            assertThat(sut.save弁明内容(弁明内容), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(0);

            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            BemmeiNaiyo 弁明内容 = new BemmeiNaiyo(entity);

            assertThat(sut.save弁明内容(弁明内容), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);

            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            entity.initializeMd5();
            BemmeiNaiyo 弁明内容 = new BemmeiNaiyo(entity);
            弁明内容 = 弁明内容.createBuilderForEdit().set弁明内容(new RString("任意項目1を変更")).build();

            assertThat(sut.save弁明内容(弁明内容), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(0);

            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            entity.initializeMd5();
            BemmeiNaiyo 弁明内容 = new BemmeiNaiyo(entity);
            弁明内容 = 弁明内容.createBuilderForEdit().set弁明内容(new RString("任意項目1を変更")).build();

            assertThat(sut.save弁明内容(弁明内容), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(1);

            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            entity.initializeMd5();
            BemmeiNaiyo 弁明内容 = new BemmeiNaiyo(entity);
            弁明内容 = 弁明内容.deleted();

            assertThat(sut.save弁明内容(弁明内容), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7002BemmeiNaiyoEntity.class))).thenReturn(0);

            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            entity.initializeMd5();
            BemmeiNaiyo 弁明内容 = new BemmeiNaiyo(entity);
            弁明内容 = 弁明内容.deleted();

            assertThat(sut.save弁明内容(弁明内容), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7002BemmeiNaiyoEntity entity = DbT7002BemmeiNaiyoEntityGenerator.createDbT7002BemmeiNaiyoEntity();
            entity.initializeMd5();
            BemmeiNaiyo 弁明内容 = new BemmeiNaiyo(entity);

            assertThat(sut.save弁明内容(弁明内容), is(false));
        }
    }
}
