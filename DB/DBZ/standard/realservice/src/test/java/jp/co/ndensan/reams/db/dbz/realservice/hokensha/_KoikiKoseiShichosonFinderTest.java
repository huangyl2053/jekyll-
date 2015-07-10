/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.hokensha.GappeiKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.business.hokensha.KoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ContainsKyuShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * {@link _KoikiKoseiShichosonFinder}のテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class _KoikiKoseiShichosonFinderTest extends DbzTestBase {

    public _KoikiKoseiShichosonFinderTest() {
    }

    public static class load広域構成市町村 extends DbzTestBase {

        private _KoikiKoseiShichosonFinder sut;
        private KoseiShichosonMasterManager manager;

        @Before
        public void setUp() {
            manager = mock(KoseiShichosonMasterManager.class);
            sut = new _KoikiKoseiShichosonFinder(manager);
        }

        @Test
        public void load広域構成市町村は_managerがload広域構成市町村で返すitemListと_同じ要素数のKoikiKoseiShichosonsを返す() {
            IItemList<KoseiShichosonMasterModel> models = createModels();
            when(manager.load広域構成市町村(any(ContainsKyuShichoson.class))).thenReturn(models);
            assertThat(sut.load広域構成市町村(ContainsKyuShichoson.旧市町村を含む).size(), is(models.size()));
        }
    }

    private static KoseiShichosonMasterModel createModel(final FlexibleDate kanyuYMD) {
        KoseiShichosonMasterModel model = mock(KoseiShichosonMasterModel.class);
        when(model.get加入日()).thenReturn(kanyuYMD);
        return model;
    }

    private static IItemList<KoseiShichosonMasterModel> createModels() {
        List<KoseiShichosonMasterModel> list = new ArrayList<>();
        list.add(createModel(new FlexibleDate("20010101")));
        list.add(createModel(new FlexibleDate("20020101")));
        list.add(createModel(new FlexibleDate("20030101")));
        list.add(createModel(new FlexibleDate("20040101")));
        list.add(createModel(new FlexibleDate("20050101")));
        return ItemList.of(list);
    }

    public static class find構成市町村_LasdecCode_ContainsKyuShichoson extends DbzTestBase {

        private _KoikiKoseiShichosonFinder sut;
        private KoseiShichosonMasterManager manager;
        private IItemList<KoseiShichosonMasterModel> models;

        @Before
        public void setUp() {
            models = createModels();
            manager = mock(KoseiShichosonMasterManager.class);
            when(manager.find構成市町村(any(LasdecCode.class), any(ContainsKyuShichoson.class)
            )).thenReturn(models);
            sut = new _KoikiKoseiShichosonFinder(manager);
        }

        @Test
        public void find構成市町村は_引数にContainsKyuShichoson$旧市町村を含む_が渡されたとき_GappeiKoikiKoseiShichosonのインスタンスを返す() {
            assertThat(sut.find構成市町村(LasdecCode.EMPTY, ContainsKyuShichoson.旧市町村を含む).get(), is(instanceOf(GappeiKoikiKoseiShichoson.class)));
        }

        @Test
        public void find構成市町村は_引数にContainsKyuShichoson$旧市町村を含まない_が渡されたとき_KoikiKoseiShichosonのインスタンスを返す() {
            assertThat(sut.find構成市町村(LasdecCode.EMPTY, ContainsKyuShichoson.旧市町村を含まない).get(), is(instanceOf(KoikiKoseiShichoson.class)));
        }

    }
}
