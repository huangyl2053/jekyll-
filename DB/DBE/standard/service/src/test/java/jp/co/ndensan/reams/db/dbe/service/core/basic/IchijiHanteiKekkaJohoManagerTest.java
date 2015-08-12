/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5116IchijiHanteiKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link IchijiHanteiKekkaJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKekkaJohoManagerTest {

    private static DbT5116IchijiHanteiKekkaJohoDac dac;
    private static IchijiHanteiKekkaJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5116IchijiHanteiKekkaJohoDac.class);
        sut = new IchijiHanteiKekkaJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定一次判定結果情報 extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey()).thenReturn(null);
            IchijiHanteiKekkaJoho result = sut.get要介護認定一次判定結果情報();

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
            when(dac.selectByKey()).thenReturn(entity);
            IchijiHanteiKekkaJoho result = sut.get要介護認定一次判定結果情報();

            assertThat(result.getチャート(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_チャート));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定一次判定結果情報一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<IchijiHanteiKekkaJoho> result = sut.get要介護認定一次判定結果情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5116IchijiHanteiKekkaJohoEntity> entityList = Arrays.asList(DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<IchijiHanteiKekkaJoho> result = sut.get要介護認定一次判定結果情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).getチャート(), is(DbT5116IchijiHanteiKekkaJohoEntityGenerator.DEFAULT_チャート));
        }
    }

    public static class save要介護認定一次判定結果情報 extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5116IchijiHanteiKekkaJohoEntity.class))).thenReturn(1);

            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5116IchijiHanteiKekkaJohoEntity.class))).thenReturn(0);

            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5116IchijiHanteiKekkaJohoEntity.class))).thenReturn(1);

            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);
            要介護認定一次判定結果情報 = 要介護認定一次判定結果情報.createBuilderForEdit().setチャート(new RString("任意項目1を変更")).build();

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5116IchijiHanteiKekkaJohoEntity.class))).thenReturn(0);

            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);
            要介護認定一次判定結果情報 = 要介護認定一次判定結果情報.createBuilderForEdit().setチャート(new RString("任意項目1を変更")).build();

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5116IchijiHanteiKekkaJohoEntity.class))).thenReturn(1);

            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);
            要介護認定一次判定結果情報 = 要介護認定一次判定結果情報.deleted();

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5116IchijiHanteiKekkaJohoEntity.class))).thenReturn(0);

            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);
            要介護認定一次判定結果情報 = 要介護認定一次判定結果情報.deleted();

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5116IchijiHanteiKekkaJohoEntity entity = DbT5116IchijiHanteiKekkaJohoEntityGenerator.createDbT5116IchijiHanteiKekkaJohoEntity();
            entity.initializeMd5();
            IchijiHanteiKekkaJoho 要介護認定一次判定結果情報 = new IchijiHanteiKekkaJoho(entity);

            assertThat(sut.save要介護認定一次判定結果情報(要介護認定一次判定結果情報), is(false));
        }
    }
}
