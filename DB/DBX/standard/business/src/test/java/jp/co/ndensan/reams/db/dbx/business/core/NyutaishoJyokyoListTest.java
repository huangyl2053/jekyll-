/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 施設入退所状況の情報を保持するクラスのテストクラスです。
 *
 * @author n3331 山邉 大貴
 */
@Ignore
@RunWith(Enclosed.class)
public class NyutaishoJyokyoListTest extends DbxTestBase {

    private static final FlexibleDate notFoundDate = new FlexibleDate(2015, 12, 1);
    private static final FlexibleDate foundDate = new FlexibleDate(2010, 12, 1);

    public static class get入所状況_基準日 extends DbxTestBase {

        @Test
        public void 基準日指定で入所状況が0件の時_get入所状況_基準日は_nullを返す() {
            NyutaishoJyokyoList sut = createNyutaishoJyokyoList();
            assertThat(sut.get入所状況(notFoundDate), is(nullValue()));
        }

        @Test
        public void 基準日指定で入所状況が1件の時_get入所状況_基準日は_入所状況を返す() {
            NyutaishoJyokyoList sut = createNyutaishoJyokyoList();
            assertThat(sut.get入所状況(foundDate).get識別コード(), is(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード));
        }
    }

    public static class iteratorTest extends DbxTestBase {

        @Test
        public void LDNS_メソッドiteratorが呼び出される場合_iteratorは_trueを返す() {
            NyutaishoJyokyoList sut = createNyutaishoJyokyoList();
            assertThat(sut.iterator().hasNext(), is(true));
        }
    }

    private static NyutaishoJyokyoList createNyutaishoJyokyoList() throws IllegalArgumentException {

        DbT7060KaigoJigyoshaEntity jigyoshaEntity = DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity();
        DbV1004HihokenshaShisetsuNyutaishoEntity nyutaishoEntity
                = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.createDbV1004HihokenshaShisetsuNyutaishoEntity();

        List<NyushoJyokyo> list = new ArrayList();
        list.add(new NyushoJyokyo(jigyoshaEntity, nyutaishoEntity));

        NyutaishoJyokyoList nyutaishoList = new NyutaishoJyokyoList(list);
        return nyutaishoList;
    }
}
