/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5304ShujiiIkenshoIkenItemEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5304ShujiiIkenshoIkenItemDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
 * {link ShujiiIkenshoIkenItemManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIkenItemManagerTest {

    private static DbT5304ShujiiIkenshoIkenItemDac dac;
    private static ShujiiIkenshoIkenItemManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5304ShujiiIkenshoIkenItemDac.class);
        sut = new ShujiiIkenshoIkenItemManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定主治医意見書意見項目 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の申請書管理番号にnullを指定した場合_NullPointerExceptionが発生する() {
            int 主治医意見書作成依頼履歴番号 = DbT5304ShujiiIkenshoIkenItemEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            sut.get要介護認定主治医意見書意見項目(null, 主治医意見書作成依頼履歴番号);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(null);

            ShinseishoKanriNo 申請書管理番号 = DbT5304ShujiiIkenshoIkenItemEntityGenerator.DEFAULT_申請書管理番号;
            int 主治医意見書作成依頼履歴番号 = DbT5304ShujiiIkenshoIkenItemEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            ShujiiIkenshoIkenItem result = sut.get要介護認定主治医意見書意見項目(申請書管理番号, 主治医意見書作成依頼履歴番号);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5304ShujiiIkenshoIkenItemEntity entity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
            when(dac.selectByKey(any(ShinseishoKanriNo.class), any(int.class))).thenReturn(entity);

            ShinseishoKanriNo 申請書管理番号 = DbT5304ShujiiIkenshoIkenItemEntityGenerator.DEFAULT_申請書管理番号;
            int 主治医意見書作成依頼履歴番号 = DbT5304ShujiiIkenshoIkenItemEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
            ShujiiIkenshoIkenItem result = sut.get要介護認定主治医意見書意見項目(申請書管理番号, 主治医意見書作成依頼履歴番号);

            assertThat(result.get申請書管理番号().value(), is(DbT5304ShujiiIkenshoIkenItemEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get要介護認定主治医意見書意見項目一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShujiiIkenshoIkenItem> result = sut.get要介護認定主治医意見書意見項目一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5304ShujiiIkenshoIkenItemEntity> entityList = Arrays.asList(DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShujiiIkenshoIkenItem> result = sut.get要介護認定主治医意見書意見項目一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().value(), is(DbT5304ShujiiIkenshoIkenItemEntityGenerator.DEFAULT_申請書管理番号.value()));
        }
    }

    public static class save要介護認定主治医意見書意見項目 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5304ShujiiIkenshoIkenItemEntity.class))).thenReturn(1);

            DbT5304ShujiiIkenshoIkenItemEntity entity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
            ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目 = new ShujiiIkenshoIkenItem(entity);

            assertThat(sut.save要介護認定主治医意見書意見項目(要介護認定主治医意見書意見項目), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5304ShujiiIkenshoIkenItemEntity.class))).thenReturn(0);

            DbT5304ShujiiIkenshoIkenItemEntity entity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
            ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目 = new ShujiiIkenshoIkenItem(entity);

            assertThat(sut.save要介護認定主治医意見書意見項目(要介護認定主治医意見書意見項目), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5304ShujiiIkenshoIkenItemEntity.class))).thenReturn(1);

            DbT5304ShujiiIkenshoIkenItemEntity entity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
            entity.initializeMd5();
            ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目 = new ShujiiIkenshoIkenItem(entity);
            要介護認定主治医意見書意見項目 = 要介護認定主治医意見書意見項目.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save要介護認定主治医意見書意見項目(要介護認定主治医意見書意見項目), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5304ShujiiIkenshoIkenItemEntity.class))).thenReturn(0);

            DbT5304ShujiiIkenshoIkenItemEntity entity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
            entity.initializeMd5();
            ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目 = new ShujiiIkenshoIkenItem(entity);
            要介護認定主治医意見書意見項目 = 要介護認定主治医意見書意見項目.createBuilderForEdit().set申請書管理番号(new ShinseishoKanriNo("申請書管理番号を変更")).build();

            assertThat(sut.save要介護認定主治医意見書意見項目(要介護認定主治医意見書意見項目), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5304ShujiiIkenshoIkenItemEntity.class))).thenReturn(1);

            DbT5304ShujiiIkenshoIkenItemEntity entity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
            entity.initializeMd5();
            ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目 = new ShujiiIkenshoIkenItem(entity);
            要介護認定主治医意見書意見項目 = 要介護認定主治医意見書意見項目.deleted();

            assertThat(sut.save要介護認定主治医意見書意見項目(要介護認定主治医意見書意見項目), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5304ShujiiIkenshoIkenItemEntity.class))).thenReturn(0);

            DbT5304ShujiiIkenshoIkenItemEntity entity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
            entity.initializeMd5();
            ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目 = new ShujiiIkenshoIkenItem(entity);
            要介護認定主治医意見書意見項目 = 要介護認定主治医意見書意見項目.deleted();

            assertThat(sut.save要介護認定主治医意見書意見項目(要介護認定主治医意見書意見項目), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5304ShujiiIkenshoIkenItemEntity entity = DbT5304ShujiiIkenshoIkenItemEntityGenerator.createDbT5304ShujiiIkenshoIkenItemEntity();
            entity.initializeMd5();
            ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目 = new ShujiiIkenshoIkenItem(entity);

            assertThat(sut.save要介護認定主治医意見書意見項目(要介護認定主治医意見書意見項目), is(false));
        }
    }
}
