/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiKashitsukeKinChoshu;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3092KyufuhiKashitsukeKinChoshuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3092KyufuhiKashitsukeKinChoshuDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {link KyufuhiKashitsukeKinChoshuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuhiKashitsukeKinChoshuManagerTest {

    private static DbT3092KyufuhiKashitsukeKinChoshuDac dac;
    private static KyufuhiKashitsukeKinChoshuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3092KyufuhiKashitsukeKinChoshuDac.class);
        sut = new KyufuhiKashitsukeKinChoshuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付費貸付金徴収 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付管理番号;
            Decimal 主キー3 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_履歴番号;
            sut.get給付費貸付金徴収(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_履歴番号;
            sut.get給付費貸付金徴収(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付管理番号;
            sut.get給付費貸付金徴収(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付管理番号;
            Decimal 主キー3 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_履歴番号;
            KyufuhiKashitsukeKinChoshu result = sut.get給付費貸付金徴収(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3092KyufuhiKashitsukeKinChoshuEntity entity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(RString.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_被保険者番号;
            RString 主キー2 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_貸付管理番号;
            Decimal 主キー3 = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_履歴番号;
            KyufuhiKashitsukeKinChoshu result = sut.get給付費貸付金徴収(主キー1, 主キー2, 主キー3);

            assertThat(result.get主キー1().value(), is(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付費貸付金徴収一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyufuhiKashitsukeKinChoshu> result = sut.get給付費貸付金徴収一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3092KyufuhiKashitsukeKinChoshuEntity> entityList = Arrays.asList(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyufuhiKashitsukeKinChoshu> result = sut.get給付費貸付金徴収一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save給付費貸付金徴収 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3092KyufuhiKashitsukeKinChoshuEntity.class))).thenReturn(1);

            DbT3092KyufuhiKashitsukeKinChoshuEntity entity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            KyufuhiKashitsukeKinChoshu 給付費貸付金徴収 = new KyufuhiKashitsukeKinChoshu(entity);

            assertThat(sut.save給付費貸付金徴収(給付費貸付金徴収), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3092KyufuhiKashitsukeKinChoshuEntity.class))).thenReturn(0);

            DbT3092KyufuhiKashitsukeKinChoshuEntity entity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            KyufuhiKashitsukeKinChoshu 給付費貸付金徴収 = new KyufuhiKashitsukeKinChoshu(entity);

            assertThat(sut.save給付費貸付金徴収(給付費貸付金徴収), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3092KyufuhiKashitsukeKinChoshuEntity.class))).thenReturn(1);

            DbT3092KyufuhiKashitsukeKinChoshuEntity entity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            entity.initializeMd5();
            KyufuhiKashitsukeKinChoshu 給付費貸付金徴収 = new KyufuhiKashitsukeKinChoshu(entity);
            給付費貸付金徴収 = 給付費貸付金徴収.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付費貸付金徴収(給付費貸付金徴収), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3092KyufuhiKashitsukeKinChoshuEntity.class))).thenReturn(0);

            DbT3092KyufuhiKashitsukeKinChoshuEntity entity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            entity.initializeMd5();
            KyufuhiKashitsukeKinChoshu 給付費貸付金徴収 = new KyufuhiKashitsukeKinChoshu(entity);
            給付費貸付金徴収 = 給付費貸付金徴収.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付費貸付金徴収(給付費貸付金徴収), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3092KyufuhiKashitsukeKinChoshuEntity.class))).thenReturn(1);

            DbT3092KyufuhiKashitsukeKinChoshuEntity entity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            entity.initializeMd5();
            KyufuhiKashitsukeKinChoshu 給付費貸付金徴収 = new KyufuhiKashitsukeKinChoshu(entity);
            給付費貸付金徴収 = 給付費貸付金徴収.deleted();

            assertThat(sut.save給付費貸付金徴収(給付費貸付金徴収), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3092KyufuhiKashitsukeKinChoshuEntity.class))).thenReturn(0);

            DbT3092KyufuhiKashitsukeKinChoshuEntity entity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            entity.initializeMd5();
            KyufuhiKashitsukeKinChoshu 給付費貸付金徴収 = new KyufuhiKashitsukeKinChoshu(entity);
            給付費貸付金徴収 = 給付費貸付金徴収.deleted();

            assertThat(sut.save給付費貸付金徴収(給付費貸付金徴収), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3092KyufuhiKashitsukeKinChoshuEntity entity = DbT3092KyufuhiKashitsukeKinChoshuEntityGenerator.createDbT3092KyufuhiKashitsukeKinChoshuEntity();
            entity.initializeMd5();
            KyufuhiKashitsukeKinChoshu 給付費貸付金徴収 = new KyufuhiKashitsukeKinChoshu(entity);

            assertThat(sut.save給付費貸付金徴収(給付費貸付金徴収), is(false));
        }
    }
}
