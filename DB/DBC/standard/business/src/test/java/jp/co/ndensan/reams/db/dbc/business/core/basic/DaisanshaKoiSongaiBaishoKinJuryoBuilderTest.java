/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DaisanshaKoiSongaiBaishoKinJuryoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiSongaiBaishoKinJuryoBuilderTest extends DbcTestBase {

    private static DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity DaisanshaKoiSongaiBaishoKinJuryoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号;
        主キー名3 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号;
        主キー名4 = DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static DaisanshaKoiSongaiBaishoKinJuryoBuilder sut;
        private static DaisanshaKoiSongaiBaishoKinJuryo business;

        @Before
        public void setUp() {
            DaisanshaKoiSongaiBaishoKinJuryoEntity = new DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity();
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiSongaiBaishoKinJuryoEntity.setTodokedeKanriNo(主キー名2);

            business = new DaisanshaKoiSongaiBaishoKinJuryo(DaisanshaKoiSongaiBaishoKinJuryoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            business = sut.set第三者行為届出管理番号(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号).build();
            assertThat(business.get第三者行為届出管理番号(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値の第三者行為求償請求番号は_設定した値と同じ第三者行為求償請求番号を返す() {
            business = sut.set第三者行為求償請求番号(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号).build();
            assertThat(business.get第三者行為求償請求番号(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_第三者行為求償請求番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の入金確認年月日は_設定した値と同じ入金確認年月日を返す() {
            business = sut.set入金確認年月日(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_入金確認年月日).build();
            assertThat(business.get入金確認年月日(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_入金確認年月日));
        }

        @Test
        public void 戻り値の領収年月日は_設定した値と同じ領収年月日を返す() {
            business = sut.set領収年月日(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_領収年月日).build();
            assertThat(business.get領収年月日(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_領収年月日));
        }

        @Test
        public void 戻り値の領収金額は_設定した値と同じ領収金額を返す() {
            business = sut.set領収金額(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_領収金額).build();
            assertThat(business.get領収金額(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_領収金額));
        }

        @Test
        public void 戻り値の過不足金有無は_設定した値と同じ過不足金有無を返す() {
            business = sut.set過不足金有無(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_過不足金有無).build();
            assertThat(business.get過不足金有無(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_過不足金有無));
        }

        @Test
        public void 戻り値の過不足額は_設定した値と同じ過不足額を返す() {
            business = sut.set過不足額(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_過不足額).build();
            assertThat(business.get過不足額(), is(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntityGenerator.DEFAULT_過不足額));
        }

    }
}
