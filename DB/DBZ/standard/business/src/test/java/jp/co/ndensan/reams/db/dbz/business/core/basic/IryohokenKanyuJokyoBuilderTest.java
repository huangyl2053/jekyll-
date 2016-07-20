/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1008IryohokenKanyuJokyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IryohokenKanyuJokyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IryohokenKanyuJokyoBuilderTest extends DbzTestBase {

    private static DbT1008IryohokenKanyuJokyoEntity IryohokenKanyuJokyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static IryohokenKanyuJokyoBuilder sut;
        private static IryohokenKanyuJokyo business;

        @Before
        public void setUp() {
            IryohokenKanyuJokyoEntity = new DbT1008IryohokenKanyuJokyoEntity();
            IryohokenKanyuJokyoEntity.setShikibetsuCode(識別コード);
            IryohokenKanyuJokyoEntity.setRirekiNo(履歴番号);
            business = new IryohokenKanyuJokyo(IryohokenKanyuJokyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の医療保険種別コードは_設定した値と同じ医療保険種別コードを返す() {
            business = sut.set医療保険種別コード(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険種別コード).build();
            assertThat(business.get医療保険種別コード(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険種別コード));
        }

        @Test
        public void 戻り値の医療保険者番号は_設定した値と同じ医療保険者番号を返す() {
            business = sut.set医療保険者番号(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険者番号).build();
            assertThat(business.get医療保険者番号(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険者番号));
        }

        @Test
        public void 戻り値の医療保険者名称は_設定した値と同じ医療保険者名称を返す() {
            business = sut.set医療保険者名称(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険者名称).build();
            assertThat(business.get医療保険者名称(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険者名称));
        }

        @Test
        public void 戻り値の医療保険記号番号は_設定した値と同じ医療保険記号番号を返す() {
            business = sut.set医療保険記号番号(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険記号番号).build();
            assertThat(business.get医療保険記号番号(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険記号番号));
        }

        @Test
        public void 戻り値の医療保険加入年月日は_設定した値と同じ医療保険加入年月日を返す() {
            business = sut.set医療保険加入年月日(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険加入年月日).build();
            assertThat(business.get医療保険加入年月日(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険加入年月日));
        }

        @Test
        public void 戻り値の医療保険脱退年月日は_設定した値と同じ医療保険脱退年月日を返す() {
            business = sut.set医療保険脱退年月日(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険脱退年月日).build();
            assertThat(business.get医療保険脱退年月日(), is(DbT1008IryohokenKanyuJokyoEntityGenerator.DEFAULT_医療保険脱退年月日));
        }

    }
}
