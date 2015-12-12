/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2009RentaiGimushaEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2009RentaiGimushaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link RentaiGimushaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class RentaiGimushaManagerTest {

    private static DbT2009RentaiGimushaDac dac;
    private static RentaiGimushaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT2009RentaiGimushaDac.class);
        sut = new RentaiGimushaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get連帯納付義務者 extends DbbTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            Decimal 主キー2 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_履歴番号;
            sut.get連帯納付義務者(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号;
            sut.get連帯納付義務者(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー2 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_履歴番号;
            RentaiGimusha result = sut.get連帯納付義務者(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(Decimal.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー2 = DbT2009RentaiGimushaEntityGenerator.DEFAULT_履歴番号;
            RentaiGimusha result = sut.get連帯納付義務者(主キー1, 主キー2);

            assertThat(result.get被保険者番号().value(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get連帯納付義務者一覧 extends DbbTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<RentaiGimusha> result = sut.get連帯納付義務者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT2009RentaiGimushaEntity> entityList = Arrays.asList(DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<RentaiGimusha> result = sut.get連帯納付義務者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT2009RentaiGimushaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save連帯納付義務者 extends DbbTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT2009RentaiGimushaEntity.class))).thenReturn(1);

            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            RentaiGimusha 連帯納付義務者 = new RentaiGimusha(entity);

            assertThat(sut.save連帯納付義務者(連帯納付義務者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT2009RentaiGimushaEntity.class))).thenReturn(0);

            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            RentaiGimusha 連帯納付義務者 = new RentaiGimusha(entity);

            assertThat(sut.save連帯納付義務者(連帯納付義務者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT2009RentaiGimushaEntity.class))).thenReturn(1);

            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            entity.initializeMd5();
            RentaiGimusha 連帯納付義務者 = new RentaiGimusha(entity);
            連帯納付義務者 = 連帯納付義務者.createBuilderForEdit().set終了年月日(new FlexibleDate("20101231")).build();

            assertThat(sut.save連帯納付義務者(連帯納付義務者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT2009RentaiGimushaEntity.class))).thenReturn(0);

            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            entity.initializeMd5();
            RentaiGimusha 連帯納付義務者 = new RentaiGimusha(entity);
            連帯納付義務者 = 連帯納付義務者.createBuilderForEdit().set終了年月日(new FlexibleDate("20101231")).build();

            assertThat(sut.save連帯納付義務者(連帯納付義務者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT2009RentaiGimushaEntity.class))).thenReturn(1);

            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            entity.initializeMd5();
            RentaiGimusha 連帯納付義務者 = new RentaiGimusha(entity);
            連帯納付義務者 = 連帯納付義務者.deleted();

            assertThat(sut.save連帯納付義務者(連帯納付義務者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT2009RentaiGimushaEntity.class))).thenReturn(0);

            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            entity.initializeMd5();
            RentaiGimusha 連帯納付義務者 = new RentaiGimusha(entity);
            連帯納付義務者 = 連帯納付義務者.deleted();

            assertThat(sut.save連帯納付義務者(連帯納付義務者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT2009RentaiGimushaEntity entity = DbT2009RentaiGimushaEntityGenerator.createDbT2009RentaiGimushaEntity();
            entity.initializeMd5();
            RentaiGimusha 連帯納付義務者 = new RentaiGimusha(entity);

            assertThat(sut.save連帯納付義務者(連帯納付義務者), is(false));
        }
    }
}
