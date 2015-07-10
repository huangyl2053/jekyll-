/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.helper.ShisetsuNyutaishoModelTestHelper;
import jp.co.ndensan.reams.db.dbz.model.kaigojogaitokureitaishoshisetsu.KaigoJogaiTokureiTaishoShisetsuModel;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ShisetsuNyutaishoTokureiTaishoRelateDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * {@link jp.co.ndensan.reams.db.dbz.realservice.ShisetsuNyutaishoTokureiTaishoRelateManager}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoTokureiTaishoRelateManagerTest {

    private static ShisetsuNyutaishoTokureiTaishoRelateManager sut;
    private static IItemList<ShisetsuNyutaishoRelateModel> result;

    public static class get介護保険施設入退所一覧By主キー1 extends DbzTestBase {

        @Test
        public void キーを指定してデータが取得できる() {
            sut = new ShisetsuNyutaishoTokureiTaishoRelateManager(createMockDac());
            result = sut.get介護保険施設入退所一覧By主キー1(ShikibetsuCode.EMPTY);
            assertThat(result.size(), is(3));
        }
    }

    public static class get台帳別施設入退所List extends DbzTestBase {

        @Test
        public void キーを指定してデータが取得できる() {
            sut = new ShisetsuNyutaishoTokureiTaishoRelateManager(createMockDac());
            result = sut.get台帳別施設入退所List(ShikibetsuCode.EMPTY, DaichoType.被保険者);
            assertThat(result.size(), is(3));
        }
    }

    private static ShisetsuNyutaishoTokureiTaishoRelateDac createMockDac() {
        ShisetsuNyutaishoRelateModel nyutaishoModel = ShisetsuNyutaishoModelTestHelper.createModel();
        IItemList<ShisetsuNyutaishoRelateModel> list = ItemList.of(nyutaishoModel, nyutaishoModel, nyutaishoModel);

        AtenaMeisho shisetsuName = new AtenaMeisho("shisetsuName");
        KaigoJogaiTokureiTaishoShisetsuModel tokureiShisetsu = mock(KaigoJogaiTokureiTaishoShisetsuModel.class);
        when(tokureiShisetsu.get事業者名称()).thenReturn(shisetsuName);

        ShisetsuNyutaishoTokureiTaishoRelateDac dac = mock(ShisetsuNyutaishoTokureiTaishoRelateDac.class);
        when(dac.select介護保険施設入退所一覧By識別コード(any(ShikibetsuCode.class))).thenReturn(list);
        when(dac.select介護除外住所地特例対象施設ByKey(any(RString.class), any(RString.class),
                any(FlexibleDate.class))).thenReturn(Optional.of(tokureiShisetsu));
        when(dac.select台帳別施設入退所一覧(any(ShikibetsuCode.class), any(DaichoType.class))).thenReturn(list);
        return dac;
    }
}
