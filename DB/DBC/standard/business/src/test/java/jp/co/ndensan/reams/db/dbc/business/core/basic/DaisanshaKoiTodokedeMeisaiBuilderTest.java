/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DaisanshaKoiTodokedeMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiTodokedeMeisaiBuilderTest extends DbcTestBase {

    private static DbT3085DaisanshaKoiTodokedeMeisaiEntity DaisanshaKoiTodokedeMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static DaisanshaKoiTodokedeMeisaiBuilder sut;
        private static DaisanshaKoiTodokedeMeisai business;

        @Before
        public void setUp() {
            DaisanshaKoiTodokedeMeisaiEntity = new DbT3085DaisanshaKoiTodokedeMeisaiEntity();
            DaisanshaKoiTodokedeMeisaiEntity.setXXX(主キー名1);
            DaisanshaKoiTodokedeMeisaiEntity.setXXX(主キー名2);

            business = new DaisanshaKoiTodokedeMeisai(DaisanshaKoiTodokedeMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の第三者行為届出管理番号は_設定した値と同じ第三者行為届出管理番号を返す() {
            business = sut.set第三者行為届出管理番号(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号).build();
            assertThat(business.get第三者行為届出管理番号(), is(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_第三者行為届出管理番号));
        }

        @Test
        public void 戻り値のサービス提供事業者番号は_設定した値と同じサービス提供事業者番号を返す() {
            business = sut.setサービス提供事業者番号(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号).build();
            assertThat(business.getサービス提供事業者番号(), is(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_サービス提供事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値のサービス利用開始年月日は_設定した値と同じサービス利用開始年月日を返す() {
            business = sut.setサービス利用開始年月日(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_サービス利用開始年月日).build();
            assertThat(business.getサービス利用開始年月日(), is(DbT3085DaisanshaKoiTodokedeMeisaiEntityGenerator.DEFAULT_サービス利用開始年月日));
        }

    }
}
