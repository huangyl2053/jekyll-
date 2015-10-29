/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiSoshinzumiMaster;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5190NinteiSoshinzumiMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5190NinteiSoshinzumiMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5190NinteiSoshinzumiMasterDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
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
 * {link NinteiSoshinzumiMasterManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class NinteiSoshinzumiMasterManagerTest {

    private static DbT5190NinteiSoshinzumiMasterDac dac;
    private static NinteiSoshinzumiMasterManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5190NinteiSoshinzumiMasterDac.class);
        sut = new NinteiSoshinzumiMasterManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定送信済みマスタ extends DbeTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            ShinseishoKanriNo 主キー1 = DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_申請書管理番号;
            sut.get要介護認定送信済みマスタ(null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(null);
            ShinseishoKanriNo 主キー1 = DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_申請書管理番号;
            NinteiSoshinzumiMaster result = sut.get要介護認定送信済みマスタ(主キー1);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5190NinteiSoshinzumiMasterEntity entity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class))).thenReturn(entity);
            ShinseishoKanriNo 主キー1 = DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_申請書管理番号;
            NinteiSoshinzumiMaster result = sut.get要介護認定送信済みマスタ(主キー1);

            assertThat(result.get申請書管理番号().value(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定送信済みマスタ一覧 extends DbeTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NinteiSoshinzumiMaster> result = sut.get要介護認定送信済みマスタ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5190NinteiSoshinzumiMasterEntity> entityList = Arrays.asList(DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NinteiSoshinzumiMaster> result = sut.get要介護認定送信済みマスタ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save要介護認定送信済みマスタ extends DbeTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5190NinteiSoshinzumiMasterEntity.class))).thenReturn(1);

            DbT5190NinteiSoshinzumiMasterEntity entity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
            NinteiSoshinzumiMaster 要介護認定送信済みマスタ = new NinteiSoshinzumiMaster(entity);

            assertThat(sut.save要介護認定送信済みマスタ(要介護認定送信済みマスタ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5190NinteiSoshinzumiMasterEntity.class))).thenReturn(0);

            DbT5190NinteiSoshinzumiMasterEntity entity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
            NinteiSoshinzumiMaster 要介護認定送信済みマスタ = new NinteiSoshinzumiMaster(entity);

            assertThat(sut.save要介護認定送信済みマスタ(要介護認定送信済みマスタ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5190NinteiSoshinzumiMasterEntity.class))).thenReturn(1);

            DbT5190NinteiSoshinzumiMasterEntity entity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
            entity.initializeMd5();
            NinteiSoshinzumiMaster 要介護認定送信済みマスタ = new NinteiSoshinzumiMaster(entity);
            要介護認定送信済みマスタ = 要介護認定送信済みマスタ.createBuilderForEdit().set再調査送付区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save要介護認定送信済みマスタ(要介護認定送信済みマスタ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5190NinteiSoshinzumiMasterEntity.class))).thenReturn(0);

            DbT5190NinteiSoshinzumiMasterEntity entity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
            entity.initializeMd5();
            NinteiSoshinzumiMaster 要介護認定送信済みマスタ = new NinteiSoshinzumiMaster(entity);
            要介護認定送信済みマスタ = 要介護認定送信済みマスタ.createBuilderForEdit().set再調査送付区分(new RString("任意項目1を変更")).build();

            assertThat(sut.save要介護認定送信済みマスタ(要介護認定送信済みマスタ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5190NinteiSoshinzumiMasterEntity.class))).thenReturn(1);

            DbT5190NinteiSoshinzumiMasterEntity entity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
            entity.initializeMd5();
            NinteiSoshinzumiMaster 要介護認定送信済みマスタ = new NinteiSoshinzumiMaster(entity);
            要介護認定送信済みマスタ = 要介護認定送信済みマスタ.deleted();

            assertThat(sut.save要介護認定送信済みマスタ(要介護認定送信済みマスタ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5190NinteiSoshinzumiMasterEntity.class))).thenReturn(0);

            DbT5190NinteiSoshinzumiMasterEntity entity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
            entity.initializeMd5();
            NinteiSoshinzumiMaster 要介護認定送信済みマスタ = new NinteiSoshinzumiMaster(entity);
            要介護認定送信済みマスタ = 要介護認定送信済みマスタ.deleted();

            assertThat(sut.save要介護認定送信済みマスタ(要介護認定送信済みマスタ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5190NinteiSoshinzumiMasterEntity entity = DbT5190NinteiSoshinzumiMasterEntityGenerator.createDbT5190NinteiSoshinzumiMasterEntity();
            entity.initializeMd5();
            NinteiSoshinzumiMaster 要介護認定送信済みマスタ = new NinteiSoshinzumiMaster(entity);

            assertThat(sut.save要介護認定送信済みマスタ(要介護認定送信済みマスタ), is(false));
        }
    }
}
