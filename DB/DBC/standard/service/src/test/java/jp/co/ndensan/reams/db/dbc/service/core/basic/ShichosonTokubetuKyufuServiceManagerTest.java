/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuService;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3066ShichosonTokubetuKyufuServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3066ShichosonTokubetuKyufuServiceDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ShichosonTokubetuKyufuServiceManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShichosonTokubetuKyufuServiceManagerTest {

    private static DbT3066ShichosonTokubetuKyufuServiceDac dac;
    private static ShichosonTokubetuKyufuServiceManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3066ShichosonTokubetuKyufuServiceDac.class);
        sut = new ShichosonTokubetuKyufuServiceManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get市町村特別給付サービス内容 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス有効期間開始年月日;
            Decimal 主キー3 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_履歴番号;
            sut.get市町村特別給付サービス内容(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
            Decimal 主キー3 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_履歴番号;
            sut.get市町村特別給付サービス内容(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
            FlexibleDate 主キー2 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス有効期間開始年月日;
            sut.get市町村特別給付サービス内容(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(null);
            RString 主キー1 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
            FlexibleDate 主キー2 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス有効期間開始年月日;
            Decimal 主キー3 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_履歴番号;
            ShichosonTokubetuKyufuService result = sut.get市町村特別給付サービス内容(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3066ShichosonTokubetuKyufuServiceEntity entity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            when(dac.selectByKey(any(RString.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(entity);
            RString 主キー1 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
            FlexibleDate 主キー2 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス有効期間開始年月日;
            Decimal 主キー3 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_履歴番号;
            ShichosonTokubetuKyufuService result = sut.get市町村特別給付サービス内容(主キー1, 主キー2, 主キー3);

            assertThat(result.get市町村特別給付用サービスコード(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービスコード));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get市町村特別給付サービス内容一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShichosonTokubetuKyufuService> result = sut.get市町村特別給付サービス内容一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3066ShichosonTokubetuKyufuServiceEntity> entityList = Arrays.asList(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShichosonTokubetuKyufuService> result = sut.get市町村特別給付サービス内容一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get市町村特別給付用サービスコード(), is(DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービスコード));
        }
    }

    public static class save市町村特別給付サービス内容 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3066ShichosonTokubetuKyufuServiceEntity.class))).thenReturn(1);

            DbT3066ShichosonTokubetuKyufuServiceEntity entity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = new ShichosonTokubetuKyufuService(entity);

            assertThat(sut.save市町村特別給付サービス内容(市町村特別給付サービス内容), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3066ShichosonTokubetuKyufuServiceEntity.class))).thenReturn(0);

            DbT3066ShichosonTokubetuKyufuServiceEntity entity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = new ShichosonTokubetuKyufuService(entity);

            assertThat(sut.save市町村特別給付サービス内容(市町村特別給付サービス内容), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3066ShichosonTokubetuKyufuServiceEntity.class))).thenReturn(1);

            DbT3066ShichosonTokubetuKyufuServiceEntity entity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            entity.initializeMd5();
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = new ShichosonTokubetuKyufuService(entity);
            市町村特別給付サービス内容 = 市町村特別給付サービス内容.createBuilderForEdit().set市町村特別給付用サービス区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save市町村特別給付サービス内容(市町村特別給付サービス内容), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3066ShichosonTokubetuKyufuServiceEntity.class))).thenReturn(0);

            DbT3066ShichosonTokubetuKyufuServiceEntity entity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            entity.initializeMd5();
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = new ShichosonTokubetuKyufuService(entity);
            市町村特別給付サービス内容 = 市町村特別給付サービス内容.createBuilderForEdit().set市町村特別給付用サービス区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save市町村特別給付サービス内容(市町村特別給付サービス内容), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3066ShichosonTokubetuKyufuServiceEntity.class))).thenReturn(1);

            DbT3066ShichosonTokubetuKyufuServiceEntity entity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            entity.initializeMd5();
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = new ShichosonTokubetuKyufuService(entity);
            市町村特別給付サービス内容 = 市町村特別給付サービス内容.deleted();

            assertThat(sut.save市町村特別給付サービス内容(市町村特別給付サービス内容), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3066ShichosonTokubetuKyufuServiceEntity.class))).thenReturn(0);

            DbT3066ShichosonTokubetuKyufuServiceEntity entity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            entity.initializeMd5();
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = new ShichosonTokubetuKyufuService(entity);
            市町村特別給付サービス内容 = 市町村特別給付サービス内容.deleted();

            assertThat(sut.save市町村特別給付サービス内容(市町村特別給付サービス内容), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3066ShichosonTokubetuKyufuServiceEntity entity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            entity.initializeMd5();
            ShichosonTokubetuKyufuService 市町村特別給付サービス内容 = new ShichosonTokubetuKyufuService(entity);

            assertThat(sut.save市町村特別給付サービス内容(市町村特別給付サービス内容), is(false));
        }
    }
}
