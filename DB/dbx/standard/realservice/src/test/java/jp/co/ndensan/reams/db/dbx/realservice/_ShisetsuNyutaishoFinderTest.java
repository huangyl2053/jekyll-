/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.NyushoJyokyo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.helper.DbV1004HihokenshaShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.relate.NyutaishoRelateEntity;
import jp.co.ndensan.reams.db.dbx.persistence.relate.NyutaishoRelateDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 施設入退所の情報を管理するクラスのテストクラスです。
 *
 * @author n8156 宮本 康
 */
@RunWith(Enclosed.class)
public class _ShisetsuNyutaishoFinderTest extends DbxTestBase {

    public static class get施設入退所ALL extends DbxTestBase {

        @Test
        public void 入所状況が0件の時_get施設入退所ALLは_EMPTY_LISTを返す() {
            IShisetsuNyutaishoFinder sut = createShisetsuNyutaishoManager(0);
            List<NyushoJyokyo> result = sut.get施設入退所ALL(new ShikibetsuCode(new RString("00000000")));
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 入所状況が1件の時_get施設入退所ALLは_サイズ1のリストを返す() {
            IShisetsuNyutaishoFinder sut = createShisetsuNyutaishoManager(1);
            List<NyushoJyokyo> result = sut.get施設入退所ALL(new ShikibetsuCode(new RString("00000000")));
            assertThat(result.size(), is(1));
        }

        @Test
        public void 入所状況が2件の時_get施設入退所ALLは_サイズ2のリストを返す() {
            IShisetsuNyutaishoFinder sut = createShisetsuNyutaishoManager(2);
            List<NyushoJyokyo> result = sut.get施設入退所ALL(new ShikibetsuCode(new RString("00000000")));
            assertThat(result.size(), is(2));
        }
    }

    private static List<NyutaishoRelateEntity> createNyutaishoRelateEntityList(int count) {
        List<NyutaishoRelateEntity> list = new ArrayList<>();
        List<DbT7063KaigoJigyoshaShiteiServiceEntity> shiteiServiceList = new ArrayList<>();
        shiteiServiceList.add(DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.createDbT7063KaigoJigyoshaShiteiServiceEntity());
        for (int i = 0; i < count; i++) {
            list.add(new NyutaishoRelateEntity(DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity(),
                    DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.createDbV1004HihokenshaShisetsuNyutaishoEntity(),
                    shiteiServiceList,
                    DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.createDbT7062KaigoJigyoshaDaihyoshaEntity()));
        }
        return (0 < count) ? list : Collections.EMPTY_LIST;
    }

    private static IShisetsuNyutaishoFinder createShisetsuNyutaishoManager(int count) {
        NyutaishoRelateDac dac = mock(NyutaishoRelateDac.class);
        when(dac.select(any(ShikibetsuCode.class))).thenReturn(createNyutaishoRelateEntityList(count));
        return new _ShisetsuNyutaishoFinder(dac);
    }
}
