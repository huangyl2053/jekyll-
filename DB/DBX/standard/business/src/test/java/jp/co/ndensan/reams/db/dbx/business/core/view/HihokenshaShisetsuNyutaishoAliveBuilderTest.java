/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaShisetsuNyutaishoAliveBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HihokenshaShisetsuNyutaishoAliveBuilderTest extends DbxTestBase {

    private static DbV1004HihokenshaShisetsuNyutaishoEntity HihokenshaShisetsuNyutaishoAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 主キー名1;
    private static Decimal 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード;
        主キー名2 = DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static HihokenshaShisetsuNyutaishoAliveBuilder sut;
        private static HihokenshaShisetsuNyutaishoAlive business;

        @Before
        public void setUp() {
            HihokenshaShisetsuNyutaishoAliveEntity = new DbV1004HihokenshaShisetsuNyutaishoEntity();
            HihokenshaShisetsuNyutaishoAliveEntity.setShikibetsuCode(主キー名1);
            HihokenshaShisetsuNyutaishoAliveEntity.setRirekiNo(主キー名2);

            business = new HihokenshaShisetsuNyutaishoAlive(HihokenshaShisetsuNyutaishoAliveEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の台帳種別は_設定した値と同じ台帳種別を返す() {
            business = sut.set台帳種別(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_台帳種別).build();
            assertThat(business.get台帳種別(), is(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_台帳種別));
        }

        @Test
        public void 戻り値の入所施設種類は_設定した値と同じ入所施設種類を返す() {
            business = sut.set入所施設種類(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設種類).build();
            assertThat(business.get入所施設種類(), is(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設種類));
        }

        @Test
        public void 戻り値の入所施設コードは_設定した値と同じ入所施設コードを返す() {
            business = sut.set入所施設コード(new JigyoshaNo(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設コード.getColumnValue())).build();
            assertThat(business.get入所施設コード(), is(new JigyoshaNo(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_入所施設コード.getColumnValue())));
        }

        @Test
        public void 戻り値の入所年月日は_設定した値と同じ入所年月日を返す() {
            business = sut.set入所年月日(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_入所年月日).build();
            assertThat(business.get入所年月日(), is(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_入所年月日));
        }

        @Test
        public void 戻り値の退所年月日は_設定した値と同じ退所年月日を返す() {
            business = sut.set退所年月日(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_退所年月日).build();
            assertThat(business.get退所年月日(), is(DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.DEFAULT_退所年月日));
        }

    }
}
