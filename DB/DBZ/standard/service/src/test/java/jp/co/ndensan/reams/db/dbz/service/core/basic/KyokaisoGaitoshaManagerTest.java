/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1006KyokaisoGaitoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1006KyokaisoGaitoshaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link KyokaisoGaitoshaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyokaisoGaitoshaManagerTest {

    private static DbT1006KyokaisoGaitoshaDac dac;
    private static KyokaisoGaitoshaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT1006KyokaisoGaitoshaDac.class);
        sut = new KyokaisoGaitoshaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get境界層該当者 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            Decimal 主キー2 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_履歴番号;
            sut.get境界層該当者(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号;
            sut.get境界層該当者(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(Decimal.class))).thenReturn(null);

            HihokenshaNo 主キー1 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー2 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_履歴番号;
            KyokaisoGaitosha result = sut.get境界層該当者(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT1006KyokaisoGaitoshaEntity entity = DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(Decimal.class))).thenReturn(entity);

            HihokenshaNo 主キー1 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー2 = DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_履歴番号;
            KyokaisoGaitosha result = sut.get境界層該当者(主キー1, 主キー2);

            assertThat(result.get被保険者番号().value(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get境界層該当者一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyokaisoGaitosha> result = sut.get境界層該当者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT1006KyokaisoGaitoshaEntity> entityList = Arrays.asList(DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyokaisoGaitosha> result = sut.get境界層該当者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT1006KyokaisoGaitoshaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save境界層該当者 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT1006KyokaisoGaitoshaEntity.class))).thenReturn(1);

            DbT1006KyokaisoGaitoshaEntity entity = DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity();
            KyokaisoGaitosha 境界層該当者 = new KyokaisoGaitosha(entity);

            assertThat(sut.save境界層該当者(境界層該当者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT1006KyokaisoGaitoshaEntity.class))).thenReturn(0);

            DbT1006KyokaisoGaitoshaEntity entity = DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity();
            KyokaisoGaitosha 境界層該当者 = new KyokaisoGaitosha(entity);

            assertThat(sut.save境界層該当者(境界層該当者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT1006KyokaisoGaitoshaEntity.class))).thenReturn(1);

            DbT1006KyokaisoGaitoshaEntity entity = DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity();
            entity.initializeMd5();
            KyokaisoGaitosha 境界層該当者 = new KyokaisoGaitosha(entity);
            境界層該当者 = 境界層該当者.createBuilderForEdit().set居住費軽減後居室種類コード(new RString("11")).build();

            assertThat(sut.save境界層該当者(境界層該当者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT1006KyokaisoGaitoshaEntity.class))).thenReturn(0);

            DbT1006KyokaisoGaitoshaEntity entity = DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity();
            entity.initializeMd5();
            KyokaisoGaitosha 境界層該当者 = new KyokaisoGaitosha(entity);
            境界層該当者 = 境界層該当者.createBuilderForEdit().set居住費軽減後居室種類コード(new RString("11")).build();

            assertThat(sut.save境界層該当者(境界層該当者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT1006KyokaisoGaitoshaEntity.class))).thenReturn(1);

            DbT1006KyokaisoGaitoshaEntity entity = DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity();
            entity.initializeMd5();
            KyokaisoGaitosha 境界層該当者 = new KyokaisoGaitosha(entity);
            境界層該当者 = 境界層該当者.deleted();

            assertThat(sut.save境界層該当者(境界層該当者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT1006KyokaisoGaitoshaEntity.class))).thenReturn(0);

            DbT1006KyokaisoGaitoshaEntity entity = DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity();
            entity.initializeMd5();
            KyokaisoGaitosha 境界層該当者 = new KyokaisoGaitosha(entity);
            境界層該当者 = 境界層該当者.deleted();

            assertThat(sut.save境界層該当者(境界層該当者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT1006KyokaisoGaitoshaEntity entity = DbT1006KyokaisoGaitoshaEntityGenerator.createDbT1006KyokaisoGaitoshaEntity();
            entity.initializeMd5();
            KyokaisoGaitosha 境界層該当者 = new KyokaisoGaitosha(entity);

            assertThat(sut.save境界層該当者(境界層該当者), is(false));
        }
    }
}
