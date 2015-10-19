/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoServiceShuruiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiBuilderTest extends DbxTestBase {

    private static DbT7130KaigoServiceShuruiEntity KaigoServiceShuruiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KaigoServiceShuruiCode 主キー名1;
    private static FlexibleYearMonth 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static KaigoServiceShuruiBuilder sut;
        private static KaigoServiceShurui business;

        @Before
        public void setUp() {
            KaigoServiceShuruiEntity = new DbT7130KaigoServiceShuruiEntity();
            KaigoServiceShuruiEntity.setServiceShuruiCd(主キー名1);
            KaigoServiceShuruiEntity.setTeikyoKaishiYM(主キー名2);

            business = new KaigoServiceShurui(KaigoServiceShuruiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の提供開始年月は_設定した値と同じ提供開始年月を返す() {
            business = sut.set提供開始年月(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月).build();
            assertThat(business.get提供開始年月(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月));
        }

        @Test
        public void 戻り値の提供終了年月は_設定した値と同じ提供終了年月を返す() {
            business = sut.set提供終了年月(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供終了年月).build();
            assertThat(business.get提供終了年月(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供終了年月));
        }

        @Test
        public void 戻り値のサービス種類名称は_設定した値と同じサービス種類名称を返す() {
            business = sut.setサービス種類名称(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類名称).build();
            assertThat(business.getサービス種類名称(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類名称));
        }

        @Test
        public void 戻り値のサービス種類略称は_設定した値と同じサービス種類略称を返す() {
            business = sut.setサービス種類略称(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類略称).build();
            assertThat(business.getサービス種類略称(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類略称));
        }

        @Test
        public void 戻り値のサービス分類コードは_設定した値と同じサービス分類コードを返す() {
            business = sut.setサービス分類コード(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス分類コード.value()).build();
            assertThat(business.getサービス分類コード(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス分類コード.value()));
        }

    }
}
