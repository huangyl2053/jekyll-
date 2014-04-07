/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.IShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIryoKikan;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IryoKikanJokyo;
import jp.co.ndensan.reams.db.dbe.definition.IryoKikanKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShuJiiIryoKikanDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.IIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * 主治医医療機関Managerのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShujiiIryoKikanManagerTest extends TestBase {

    private static IShujiiIryoKikanManager sut;

    public static class saveのテスト extends TestBase {

        @Test
        public void 更新件数が1件である場合_trueが返る() {
            sut = new ShujiiIryoKikanManager(createDac_insertOrUpdateの戻り値を指定(1));
            assertThat(sut.save(create主治医医療機関()), is(true));
        }

        @Test
        public void 更新件数が0件の場合_falseが返る() {
            sut = new ShujiiIryoKikanManager(createDac_insertOrUpdateの戻り値を指定(0));
            assertThat(sut.save(create主治医医療機関()), is(false));
        }
    }

    public static class removeのテスト {

        @Test
        public void 削除件数が1件である場合_trueが返る() {
            sut = new ShujiiIryoKikanManager(createDac_deleteの戻り値を指定(1));
            assertThat(sut.remove(create主治医医療機関()), is(true));
        }

        @Test
        public void 削除件数が0件の場合_falseが返る() {
            sut = new ShujiiIryoKikanManager(createDac_deleteの戻り値を指定(0));
            assertThat(sut.remove(create主治医医療機関()), is(false));
        }
    }

    public static class saveAs有効のテスト {

        @Test
        public void 更新件数が1件である場合_trueが返る() {
            sut = new ShujiiIryoKikanManager(createDac_insertOrUpdateの戻り値を指定(1));
            assertThat(sut.saveAs有効(create主治医医療機関()), is(true));
        }

        @Test
        public void 更新件数が0件の場合_falseが返る() {
            sut = new ShujiiIryoKikanManager(createDac_insertOrUpdateの戻り値を指定(0));
            assertThat(sut.saveAs有効(create主治医医療機関()), is(false));
        }
    }

    public static class saveAs無効のテスト {

        @Test
        public void 更新件数が1件である場合_trueが返る() {
            sut = new ShujiiIryoKikanManager(createDac_insertOrUpdateの戻り値を指定(1));
            assertThat(sut.saveAs無効(create主治医医療機関()), is(true));
        }

        @Test
        public void 更新件数が0件の場合_falseが返る() {
            sut = new ShujiiIryoKikanManager(createDac_insertOrUpdateの戻り値を指定(0));
            assertThat(sut.saveAs無効(create主治医医療機関()), is(false));
        }
    }

    private static IShuJiiIryoKikanDac createDac_insertOrUpdateの戻り値を指定(int 更新件数) {
        IShuJiiIryoKikanDac dac = mock(IShuJiiIryoKikanDac.class);
        when(dac.insertOrUpdate(any(DbT7011ShujiiIryoKikanJohoEntity.class))).thenReturn(更新件数);
        return dac;
    }

    private static IShuJiiIryoKikanDac createDac_deleteの戻り値を指定(int 更新件数) {
        IShuJiiIryoKikanDac dac = mock(IShuJiiIryoKikanDac.class);
        when(dac.delete(any(DbT7011ShujiiIryoKikanJohoEntity.class))).thenReturn(更新件数);
        return dac;
    }

    private static IShujiiIryoKikan create主治医医療機関() {
        ShoKisaiHokenshaNo 証記載保険者番号_A00001 = new ShoKisaiHokenshaNo(new RString("A00001"));
        KaigoIryoKikanCode 介護医療機関コード_B001 = new KaigoIryoKikanCode(new RString("B001"));
        IIryoKikanCode 医療機関コード_C00000001 = new _IryoKikanCode(new RString("C00000001"));
        IryoKikanJokyo 医療機関状況_有効 = IryoKikanJokyo.有効;
        IryoKikanKubun 医療機関区分_ABC = new IryoKikanKubun(new RString("ABC"), new RString("名称"), new RString("略称"));

        return new ShujiiIryoKikan(証記載保険者番号_A00001, 介護医療機関コード_B001, 医療機関コード_C00000001, 医療機関状況_有効, 医療機関区分_ABC);
    }
}
