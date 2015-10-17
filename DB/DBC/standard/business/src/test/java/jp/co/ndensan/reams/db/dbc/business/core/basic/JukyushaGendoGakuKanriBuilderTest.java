/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JukyushaGendoGakuKanriBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JukyushaGendoGakuKanriBuilderTest extends DbcTestBase {

    private static DbT7116JukyushaGendoGakuKanriEntity JukyushaGendoGakuKanriEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static FlexibleYearMonth 主キー名3;
    private static int 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分;
        主キー名3 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月;
        主キー名4 = jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static JukyushaGendoGakuKanriBuilder sut;
        private static JukyushaGendoGakuKanri business;

        @Before
        public void setUp() {
            JukyushaGendoGakuKanriEntity = new DbT7116JukyushaGendoGakuKanriEntity();
            JukyushaGendoGakuKanriEntity.setHihokenshaNo(主キー名1);
            JukyushaGendoGakuKanriEntity.setShikibetsuKubun(主キー名2);

            business = new JukyushaGendoGakuKanri(JukyushaGendoGakuKanriEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の識別区分は_設定した値と同じ識別区分を返す() {
            business = sut.set識別区分(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分).build();
            assertThat(business.get識別区分(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_識別区分));
        }

        @Test
        public void 戻り値の有効開始年月は_設定した値と同じ有効開始年月を返す() {
            business = sut.set有効開始年月(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月).build();
            assertThat(business.get有効開始年月(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効開始年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の有効終了年月は_設定した値と同じ有効終了年月を返す() {
            business = sut.set有効終了年月(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効終了年月).build();
            assertThat(business.get有効終了年月(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_有効終了年月));
        }

        @Test
        public void 戻り値の要介護状態区分は_設定した値と同じ要介護状態区分を返す() {
            business = sut.set要介護状態区分(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_要介護状態区分).build();
            assertThat(business.get要介護状態区分(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_要介護状態区分));
        }

        @Test
        public void 戻り値の拡大倍数は_設定した値と同じ拡大倍数を返す() {
            business = sut.set拡大倍数(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_拡大倍数).build();
            assertThat(business.get拡大倍数(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_拡大倍数));
        }

        @Test
        public void 戻り値の切り分け単位数は_設定した値と同じ切り分け単位数を返す() {
            business = sut.set切り分け単位数(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_切り分け単位数).build();
            assertThat(business.get切り分け単位数(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_切り分け単位数));
        }

        @Test
        public void 戻り値の登録年月日は_設定した値と同じ登録年月日を返す() {
            business = sut.set登録年月日(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_登録年月日).build();
            assertThat(business.get登録年月日(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_登録年月日));
        }

        @Test
        public void 戻り値の変更年月日は_設定した値と同じ変更年月日を返す() {
            business = sut.set変更年月日(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_変更年月日).build();
            assertThat(business.get変更年月日(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_変更年月日));
        }

        @Test
        public void 戻り値の限度額管理期間数は_設定した値と同じ限度額管理期間数を返す() {
            business = sut.set限度額管理期間数(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_限度額管理期間数).build();
            assertThat(business.get限度額管理期間数(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_限度額管理期間数));
        }

        @Test
        public void 戻り値の新体系管理区分は_設定した値と同じ新体系管理区分を返す() {
            business = sut.set新体系管理区分(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_新体系管理区分).build();
            assertThat(business.get新体系管理区分(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_新体系管理区分));
        }

        @Test
        public void 戻り値の新体系拡大適用有無は_設定した値と同じ新体系拡大適用有無を返す() {
            business = sut.set新体系拡大適用有無(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_新体系拡大適用有無).build();
            assertThat(business.get新体系拡大適用有無(), is(DbT7116JukyushaGendoGakuKanriEntityGenerator.DEFAULT_新体系拡大適用有無));
        }

    }
}
