/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * {link KaigoServiceNaiyouManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceNaiyouManagerTest {

    private static DbT7131KaigoServiceNaiyouDac dac;
    private static KaigoServiceNaiyouManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7131KaigoServiceNaiyouDac.class);
        sut = new KaigoServiceNaiyouManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護サービス内容 extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のKaigoServiceShuruiCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード;
            sut.get介護サービス内容(null, 主キー2, FlexibleYearMonth.MAX, Decimal.ZERO);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のRStringにnullを指定した場合_NullPointerExceptionが発生する() {
            KaigoServiceShuruiCode 主キー1 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード;
            sut.get介護サービス内容(主キー1, null, FlexibleYearMonth.MAX, Decimal.ZERO);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(KaigoServiceShuruiCode.class), any(RString.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(null);

            KaigoServiceShuruiCode 主キー1 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード;
            RString 主キー2 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード;
            KaigoServiceNaiyou result = sut.get介護サービス内容(主キー1, 主キー2, FlexibleYearMonth.MAX, Decimal.ZERO);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            when(dac.selectByKey(any(KaigoServiceShuruiCode.class), any(RString.class), any(FlexibleYearMonth.class), any(Decimal.class))).thenReturn(entity);

            KaigoServiceShuruiCode 主キー1 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード;
            RString 主キー2 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード;
            KaigoServiceNaiyou result = sut.get介護サービス内容(主キー1, 主キー2, FlexibleYearMonth.MAX, Decimal.ZERO);

            assertThat(result.getサービス種類コード().value(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護サービス内容一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KaigoServiceNaiyou> result = sut.get介護サービス内容一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7131KaigoServiceNaiyouEntity> entityList = Arrays.asList(DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KaigoServiceNaiyou> result = sut.get介護サービス内容一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getサービス種類コード().value(), is(DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス種類コード.value()));
        }
    }

    public static class save介護サービス内容 extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(1);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);

            assertThat(sut.save介護サービス内容(介護サービス内容), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(0);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);

            assertThat(sut.save介護サービス内容(介護サービス内容), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(1);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);
            介護サービス内容 = 介護サービス内容.createBuilderForEdit().set異動事由(new Code("01")).build();

            assertThat(sut.save介護サービス内容(介護サービス内容), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(0);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);
            介護サービス内容 = 介護サービス内容.createBuilderForEdit().set異動事由(new Code("01")).build();

            assertThat(sut.save介護サービス内容(介護サービス内容), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(1);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);
            介護サービス内容 = 介護サービス内容.deleted();

            assertThat(sut.save介護サービス内容(介護サービス内容), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7131KaigoServiceNaiyouEntity.class))).thenReturn(0);

            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);
            介護サービス内容 = 介護サービス内容.deleted();

            assertThat(sut.save介護サービス内容(介護サービス内容), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7131KaigoServiceNaiyouEntity entity = DbT7131KaigoServiceNaiyouEntityGenerator.createDbT7131KaigoServiceNaiyouEntity();
            entity.initializeMd5();
            KaigoServiceNaiyou 介護サービス内容 = new KaigoServiceNaiyou(entity);

            assertThat(sut.save介護サービス内容(介護サービス内容), is(false));
        }
    }
}
