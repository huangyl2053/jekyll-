/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link KaigoServiceShuruiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiManagerTest {

    private static DbT7130KaigoServiceShuruiDac dac;
    private static KaigoServiceShuruiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7130KaigoServiceShuruiDac.class);
        sut = new KaigoServiceShuruiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護サービス種類 extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のKaigoServiceShuruiCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            sut.get介護サービス種類(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のFlexibleYearMonthにnullを指定した場合_NullPointerExceptionが発生する() {
            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            sut.get介護サービス種類(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(KaigoServiceShuruiCode.class), any(FlexibleYearMonth.class))).thenReturn(null);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShurui result = sut.get介護サービス種類(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            when(dac.selectByKey(any(KaigoServiceShuruiCode.class), any(FlexibleYearMonth.class))).thenReturn(entity);

            KaigoServiceShuruiCode 主キー1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
            FlexibleYearMonth 主キー2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
            KaigoServiceShurui result = sut.get介護サービス種類(主キー1, 主キー2);

            assertThat(result.getサービス種類コード().value(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護サービス種類一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KaigoServiceShurui> result = sut.get介護サービス種類一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7130KaigoServiceShuruiEntity> entityList = Arrays.asList(DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KaigoServiceShurui> result = sut.get介護サービス種類一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサービス種類コード().value(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    public static class save介護サービス種類 extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);

            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(entity);

            assertThat(sut.save介護サービス種類(介護サービス種類), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(0);

            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(entity);

            assertThat(sut.save介護サービス種類(介護サービス種類), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);

            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            entity.initializeMd5();
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(entity);
            介護サービス種類 = 介護サービス種類.createBuilderForEdit().set提供終了年月(new FlexibleYearMonth("201509")).build();

            assertThat(sut.save介護サービス種類(介護サービス種類), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(0);

            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            entity.initializeMd5();
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(entity);
            介護サービス種類 = 介護サービス種類.createBuilderForEdit().set提供終了年月(new FlexibleYearMonth("201509")).build();

            assertThat(sut.save介護サービス種類(介護サービス種類), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(1);

            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            entity.initializeMd5();
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(entity);
            介護サービス種類 = 介護サービス種類.deleted();

            assertThat(sut.save介護サービス種類(介護サービス種類), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7130KaigoServiceShuruiEntity.class))).thenReturn(0);

            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            entity.initializeMd5();
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(entity);
            介護サービス種類 = 介護サービス種類.deleted();

            assertThat(sut.save介護サービス種類(介護サービス種類), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7130KaigoServiceShuruiEntity entity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            entity.initializeMd5();
            KaigoServiceShurui 介護サービス種類 = new KaigoServiceShurui(entity);

            assertThat(sut.save介護サービス種類(介護サービス種類), is(false));
        }
    }
}
