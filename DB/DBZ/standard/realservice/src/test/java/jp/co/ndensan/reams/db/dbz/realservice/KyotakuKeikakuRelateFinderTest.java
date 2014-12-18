/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJigyoshaSakuseiModel;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJikoSakuseiModel;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuTodokedeModel;
import jp.co.ndensan.reams.db.dbz.model.relate.KyotakuKeikakuRelateModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KyotakuKeikakuRelateDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KyotakuKeikakuRelateFinder}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuRelateFinderTest {

    private static KyotakuKeikakuRelateDac dac;
    private static KyotakuKeikakuRelateFinder sut;

    @BeforeClass
    public static void test() {
        dac = mock(KyotakuKeikakuRelateDac.class);
        sut = new KyotakuKeikakuRelateFinder(dac);
    }

    public static class find居宅計画履歴一覧Test extends DbzTestBase {

        @Test
        public void データが見つかる検索条件を指定した場合_居宅給付計画履歴が返る() {

            List<KyotakuKeikakuRelateModel> 居宅給付計画履歴モデルリスト = new ArrayList<>();
            居宅給付計画履歴モデルリスト.add(createModel());
            居宅給付計画履歴モデルリスト.add(createModel());
            IItemList<KyotakuKeikakuRelateModel> list = ItemList.of(居宅給付計画履歴モデルリスト);

            when(dac.select居宅計画履歴一覧By被保険者番号(any(HihokenshaNo.class))).thenReturn(list);

            IItemList<KyotakuKeikakuRelateModel> 居宅給付計画履歴リスト = sut.find居宅計画履歴一覧(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号);

            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画履歴リスト.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(居宅給付計画履歴リスト.toList().get(0).get居宅給付計画届出モデル().get暫定区分(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_暫定区分));
            assertThat(居宅給付計画履歴リスト.toList().get(1).get居宅給付計画届出モデル().get暫定区分(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_暫定区分));
        }
    }

    private static KyotakuKeikakuRelateModel createModel() {
        return new KyotakuKeikakuRelateModel(
                new KyotakuKeikakuTodokedeModel(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity()),
                DbOptional.ofNullable(new KyotakuKeikakuJigyoshaSakuseiModel(DbT3006KyotakuKeikakuJigyoshaSakuseiEntityGenerator.createDbT3006KyotakuKeikakuJigyoshaSakuseiEntity())),
                DbOptional.ofNullable(new KyotakuKeikakuJikoSakuseiModel(DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.createDbT3007KyotakuKeikakuJikoSakuseiEntity())));

    }

}
