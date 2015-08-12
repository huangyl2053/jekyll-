/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

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
 * {@link KoseiShichosonShishoMasterBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonShishoMasterBuilderTest extends DbeTestBase {

    private static DbT5052KoseiShichosonShishoMasterEntity KoseiShichosonShishoMasterEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KoseiShichosonShishoMasterBuilder sut;
        private static KoseiShichosonShishoMaster business;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = new DbT5052KoseiShichosonShishoMasterEntity();

            business = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の支所コードは_設定した値と同じ支所コードを返す() {
            business = sut.set支所コード(DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード).build();
            assertThat(business.get支所コード(), is(DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード));
        }

    }
}
