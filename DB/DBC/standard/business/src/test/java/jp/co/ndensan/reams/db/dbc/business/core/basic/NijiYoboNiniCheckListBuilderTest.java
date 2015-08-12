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
 * {@link NijiYoboNiniCheckListBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboNiniCheckListBuilderTest extends DbcTestBase {

    private static DbT3102NijiYoboNiniCheckListEntity NijiYoboNiniCheckListEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static NijiYoboNiniCheckListBuilder sut;
        private static NijiYoboNiniCheckList business;

        @Before
        public void setUp() {
            NijiYoboNiniCheckListEntity = new DbT3102NijiYoboNiniCheckListEntity();
            NijiYoboNiniCheckListEntity.setXXX(主キー名1);
            NijiYoboNiniCheckListEntity.setXXX(主キー名2);

            business = new NijiYoboNiniCheckList(NijiYoboNiniCheckListEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の任意質問番号は_設定した値と同じ任意質問番号を返す() {
            business = sut.set任意質問番号(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号).build();
            assertThat(business.get任意質問番号(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の任意質問事項は_設定した値と同じ任意質問事項を返す() {
            business = sut.set任意質問事項(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問事項).build();
            assertThat(business.get任意質問事項(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問事項));
        }

    }
}
