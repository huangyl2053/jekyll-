/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ContainsKyuShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * {link KoseiShichosonMasterManager}のテストクラスです。
 *
 * @author n3331 山邉 大貴
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterManagerTest {

    private static KoseiShichosonMasterDac dac;
    private static KoseiShichosonMasterManager sut;

    public static class selectBy_ContainsKyuShichoson extends DbzTestBase {

        @Before
        public void setUp() {
            dac = mock(KoseiShichosonMasterDac.class);
            sut = new KoseiShichosonMasterManager(dac);
        }

        @Test
        public void load広域構成市町村は_dacのselectBy_ContainsKyuShichoson_が返すitemListと同じ要素数のitemListを返す() {
            IItemList<KoseiShichosonMasterModel> models = createModelList(3);
            when(dac.selectBy(any(ContainsKyuShichoson.class))).thenReturn(models);
            assertThat(sut.load広域構成市町村(ContainsKyuShichoson.旧市町村を含む).size(), is(models.size()));
        }
    }

    private static IItemList<KoseiShichosonMasterModel> createModelList(int size) {
        IItemList<KoseiShichosonMasterModel> models = mock(IItemList.class);
        when(models.size()).thenReturn(size);
        return models;
    }

    public static class find構成市町村 extends DbzTestBase {

        @Before
        public void setUp() {
            dac = mock(KoseiShichosonMasterDac.class);
            sut = new KoseiShichosonMasterManager(dac);
        }

        @Test
        public void find構成市町村は_dacのselectBy_LasdecCode_ContainsKyuShichoson_が返すitemListと同じ要素数のitemListを返す() {
            IItemList<KoseiShichosonMasterModel> models = createModelList(3);
            when(dac.selectBy(any(LasdecCode.class), eq(ContainsKyuShichoson.旧市町村を含む))).thenReturn(models);
            assertThat(sut.find構成市町村(LasdecCode.EMPTY, ContainsKyuShichoson.旧市町村を含む).size(), is(models.size()));
        }
    }
}
