/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiKashitsukekinShinsei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3086KyufuhiKashitsukekinShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3086KyufuhiKashitsukekinShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3086KyufuhiKashitsukekinShinseiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KyufuhiKashitsukekinShinseiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufuhiKashitsukekinShinseiManagerTest {

    private static DbT3086KyufuhiKashitsukekinShinseiDac dac;
    private static KyufuhiKashitsukekinShinseiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3086KyufuhiKashitsukekinShinseiDac.class);
        sut = new KyufuhiKashitsukekinShinseiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付費貸付金申請 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請年月日;
            Decimal 主キー3 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_履歴番号;
            sut.get給付費貸付金申請(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー3 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_履歴番号;
            sut.get給付費貸付金申請(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請年月日;
            sut.get給付費貸付金申請(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請年月日;
            Decimal 主キー3 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_履歴番号;
            KyufuhiKashitsukekinShinsei result = sut.get給付費貸付金申請(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3086KyufuhiKashitsukekinShinseiEntity entity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー2 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_借入申請年月日;
            Decimal 主キー3 = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_履歴番号;
            KyufuhiKashitsukekinShinsei result = sut.get給付費貸付金申請(主キー1, 主キー2, 主キー3);

            assertThat(result.get被保険者番号().value(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付費貸付金申請一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyufuhiKashitsukekinShinsei> result = sut.get給付費貸付金申請一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3086KyufuhiKashitsukekinShinseiEntity> entityList = Arrays.asList(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyufuhiKashitsukekinShinsei> result = sut.get給付費貸付金申請一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save給付費貸付金申請 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3086KyufuhiKashitsukekinShinseiEntity.class))).thenReturn(1);

            DbT3086KyufuhiKashitsukekinShinseiEntity entity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            KyufuhiKashitsukekinShinsei 給付費貸付金申請 = new KyufuhiKashitsukekinShinsei(entity);

            assertThat(sut.save給付費貸付金申請(給付費貸付金申請), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3086KyufuhiKashitsukekinShinseiEntity.class))).thenReturn(0);

            DbT3086KyufuhiKashitsukekinShinseiEntity entity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            KyufuhiKashitsukekinShinsei 給付費貸付金申請 = new KyufuhiKashitsukekinShinsei(entity);

            assertThat(sut.save給付費貸付金申請(給付費貸付金申請), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3086KyufuhiKashitsukekinShinseiEntity.class))).thenReturn(1);

            DbT3086KyufuhiKashitsukekinShinseiEntity entity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            entity.initializeMd5();
            KyufuhiKashitsukekinShinsei 給付費貸付金申請 = new KyufuhiKashitsukekinShinsei(entity);
            給付費貸付金申請 = 給付費貸付金申請.createBuilderForEdit().set保証人住所(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付費貸付金申請(給付費貸付金申請), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3086KyufuhiKashitsukekinShinseiEntity.class))).thenReturn(0);

            DbT3086KyufuhiKashitsukekinShinseiEntity entity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            entity.initializeMd5();
            KyufuhiKashitsukekinShinsei 給付費貸付金申請 = new KyufuhiKashitsukekinShinsei(entity);
            給付費貸付金申請 = 給付費貸付金申請.createBuilderForEdit().set保証人住所(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付費貸付金申請(給付費貸付金申請), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3086KyufuhiKashitsukekinShinseiEntity.class))).thenReturn(1);

            DbT3086KyufuhiKashitsukekinShinseiEntity entity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            entity.initializeMd5();
            KyufuhiKashitsukekinShinsei 給付費貸付金申請 = new KyufuhiKashitsukekinShinsei(entity);
            給付費貸付金申請 = 給付費貸付金申請.deleted();

            assertThat(sut.save給付費貸付金申請(給付費貸付金申請), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3086KyufuhiKashitsukekinShinseiEntity.class))).thenReturn(0);

            DbT3086KyufuhiKashitsukekinShinseiEntity entity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            entity.initializeMd5();
            KyufuhiKashitsukekinShinsei 給付費貸付金申請 = new KyufuhiKashitsukekinShinsei(entity);
            給付費貸付金申請 = 給付費貸付金申請.deleted();

            assertThat(sut.save給付費貸付金申請(給付費貸付金申請), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3086KyufuhiKashitsukekinShinseiEntity entity = DbT3086KyufuhiKashitsukekinShinseiEntityGenerator.createDbT3086KyufuhiKashitsukekinShinseiEntity();
            entity.initializeMd5();
            KyufuhiKashitsukekinShinsei 給付費貸付金申請 = new KyufuhiKashitsukekinShinsei(entity);

            assertThat(sut.save給付費貸付金申請(給付費貸付金申請), is(false));
        }
    }
}
