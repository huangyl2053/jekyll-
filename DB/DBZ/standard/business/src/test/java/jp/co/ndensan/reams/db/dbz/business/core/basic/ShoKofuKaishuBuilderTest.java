/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7037ShoKofuKaishuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShoKofuKaishuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShoKofuKaishuBuilderTest extends DbzTestBase {

    private static DbT7037ShoKofuKaishuEntity ShoKofuKaishuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static RString 交付証種類;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号;
        交付証種類 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付証種類;
        履歴番号 = DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShoKofuKaishuBuilder sut;
        private static ShoKofuKaishu business;

        @Before
        public void setUp() {
            ShoKofuKaishuEntity = new DbT7037ShoKofuKaishuEntity();
            ShoKofuKaishuEntity.setHihokenshaNo(被保険者番号);
            ShoKofuKaishuEntity.setKofuShoShurui(交付証種類);
            ShoKofuKaishuEntity.setRirekiNo(履歴番号);

            business = new ShoKofuKaishu(ShoKofuKaishuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の交付証種類は_設定した値と同じ交付証種類を返す() {
            business = sut.set交付証種類(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付証種類).build();
            assertThat(business.get交付証種類(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付証種類));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の交付年月日は_設定した値と同じ交付年月日を返す() {
            business = sut.set交付年月日(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付年月日).build();
            assertThat(business.get交付年月日(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付年月日));
        }

        @Test
        public void 戻り値の有効期限は_設定した値と同じ有効期限を返す() {
            business = sut.set有効期限(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_有効期限).build();
            assertThat(business.get有効期限(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_有効期限));
        }

        @Test
        public void 戻り値の交付事由は_設定した値と同じ交付事由を返す() {
            business = sut.set交付事由(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付事由).build();
            assertThat(business.get交付事由(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付事由));
        }

        @Test
        public void 戻り値の交付理由は_設定した値と同じ交付理由を返す() {
            business = sut.set交付理由(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付理由).build();
            assertThat(business.get交付理由(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_交付理由));
        }

        @Test
        public void 戻り値の回収年月日は_設定した値と同じ回収年月日を返す() {
            business = sut.set回収年月日(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_回収年月日).build();
            assertThat(business.get回収年月日(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_回収年月日));
        }

        @Test
        public void 戻り値の回収事由は_設定した値と同じ回収事由を返す() {
            business = sut.set回収事由(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_回収事由).build();
            assertThat(business.get回収事由(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_回収事由));
        }

        @Test
        public void 戻り値の回収理由は_設定した値と同じ回収理由を返す() {
            business = sut.set回収理由(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_回収理由).build();
            assertThat(business.get回収理由(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_回収理由));
        }

        @Test
        public void 戻り値の単票発行有無フラグは_設定した値と同じ単票発行有無フラグを返す() {
            business = sut.set単票発行有無フラグ(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_単票発行有無フラグ).build();
            assertThat(business.get単票発行有無フラグ(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_単票発行有無フラグ));
        }

        @Test
        public void 戻り値の発行処理日時は_設定した値と同じ発行処理日時を返す() {
            business = sut.set発行処理日時(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_発行処理日時).build();
            assertThat(business.get発行処理日時(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_発行処理日時));
        }

        @Test
        public void 戻り値の新様式印書済区分コードは_設定した値と同じ新様式印書済区分コードを返す() {
            business = sut.set新様式印書済区分コード(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_新様式印書済区分コード).build();
            assertThat(business.get新様式印書済区分コード(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_新様式印書済区分コード));
        }

        @Test
        public void 戻り値の証様式区分コードは_設定した値と同じ証様式区分コードを返す() {
            business = sut.set証様式区分コード(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_証様式区分コード).build();
            assertThat(business.get証様式区分コード(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_証様式区分コード));
        }

        @Test
        public void 戻り値の論理削除フラグは_設定した値と同じ論理削除フラグを返す() {
            business = sut.set論理削除フラグ(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_論理削除フラグ).build();
            assertThat(business.get論理削除フラグ(), is(DbT7037ShoKofuKaishuEntityGenerator.DEFAULT_論理削除フラグ));
        }

    }
}
