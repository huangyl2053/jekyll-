/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7006RoreiFukushiNenkinJukyushaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link RoreiFukushiNenkinJukyushaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RoreiFukushiNenkinJukyushaManagerTest {

    private static DbT7006RoreiFukushiNenkinJukyushaDac dac;
    private static RoreiFukushiNenkinJukyushaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        sut = new RoreiFukushiNenkinJukyushaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get老齢福祉年金受給者 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の識別コードeにnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 受給開始年月日 = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給開始年月日;
            sut.get老齢福祉年金受給者(null, 受給開始年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の受給開始年月日にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 識別コード = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード;
            sut.get老齢福祉年金受給者(識別コード, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(FlexibleDate.class))).thenReturn(null);

            ShikibetsuCode 識別コード = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 受給開始年月日 = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給開始年月日;
            RoreiFukushiNenkinJukyusha result = sut.get老齢福祉年金受給者(識別コード, 受給開始年月日);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7006RoreiFukushiNenkinJukyushaEntity entity = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(FlexibleDate.class))).thenReturn(entity);

            ShikibetsuCode 識別コード = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 受給開始年月日 = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給開始年月日;
            RoreiFukushiNenkinJukyusha result = sut.get老齢福祉年金受給者(識別コード, 受給開始年月日);

            assertThat(result.get識別コード().value(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get老齢福祉年金受給者一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<RoreiFukushiNenkinJukyusha> result = sut.get老齢福祉年金受給者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7006RoreiFukushiNenkinJukyushaEntity> entityList = Arrays.asList(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<RoreiFukushiNenkinJukyusha> result = sut.get老齢福祉年金受給者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get識別コード().value(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save老齢福祉年金受給者 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7006RoreiFukushiNenkinJukyushaEntity.class))).thenReturn(1);

            DbT7006RoreiFukushiNenkinJukyushaEntity entity = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            RoreiFukushiNenkinJukyusha 老齢福祉年金受給者 = new RoreiFukushiNenkinJukyusha(entity);

            assertThat(sut.save老齢福祉年金受給者(老齢福祉年金受給者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7006RoreiFukushiNenkinJukyushaEntity.class))).thenReturn(0);

            DbT7006RoreiFukushiNenkinJukyushaEntity entity = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            RoreiFukushiNenkinJukyusha 老齢福祉年金受給者 = new RoreiFukushiNenkinJukyusha(entity);

            assertThat(sut.save老齢福祉年金受給者(老齢福祉年金受給者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7006RoreiFukushiNenkinJukyushaEntity.class))).thenReturn(1);

            DbT7006RoreiFukushiNenkinJukyushaEntity entity = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            entity.initializeMd5();
            RoreiFukushiNenkinJukyusha 老齢福祉年金受給者 = new RoreiFukushiNenkinJukyusha(entity);
            老齢福祉年金受給者 = 老齢福祉年金受給者.createBuilderForEdit().set識別コード(new ShikibetsuCode("識別コードを変更")).build();

            assertThat(sut.save老齢福祉年金受給者(老齢福祉年金受給者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7006RoreiFukushiNenkinJukyushaEntity.class))).thenReturn(0);

            DbT7006RoreiFukushiNenkinJukyushaEntity entity = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            entity.initializeMd5();
            RoreiFukushiNenkinJukyusha 老齢福祉年金受給者 = new RoreiFukushiNenkinJukyusha(entity);
            老齢福祉年金受給者 = 老齢福祉年金受給者.createBuilderForEdit().set識別コード(new ShikibetsuCode("識別コードを変更")).build();

            assertThat(sut.save老齢福祉年金受給者(老齢福祉年金受給者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7006RoreiFukushiNenkinJukyushaEntity.class))).thenReturn(1);

            DbT7006RoreiFukushiNenkinJukyushaEntity entity = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            entity.initializeMd5();
            RoreiFukushiNenkinJukyusha 老齢福祉年金受給者 = new RoreiFukushiNenkinJukyusha(entity);
            老齢福祉年金受給者 = 老齢福祉年金受給者.deleted();

            assertThat(sut.save老齢福祉年金受給者(老齢福祉年金受給者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7006RoreiFukushiNenkinJukyushaEntity.class))).thenReturn(0);

            DbT7006RoreiFukushiNenkinJukyushaEntity entity = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            entity.initializeMd5();
            RoreiFukushiNenkinJukyusha 老齢福祉年金受給者 = new RoreiFukushiNenkinJukyusha(entity);
            老齢福祉年金受給者 = 老齢福祉年金受給者.deleted();

            assertThat(sut.save老齢福祉年金受給者(老齢福祉年金受給者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7006RoreiFukushiNenkinJukyushaEntity entity = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.createDbT7006RoreiFukushiNenkinJukyushaEntity();
            entity.initializeMd5();
            RoreiFukushiNenkinJukyusha 老齢福祉年金受給者 = new RoreiFukushiNenkinJukyusha(entity);

            assertThat(sut.save老齢福祉年金受給者(老齢福祉年金受給者), is(false));
        }
    }
}
