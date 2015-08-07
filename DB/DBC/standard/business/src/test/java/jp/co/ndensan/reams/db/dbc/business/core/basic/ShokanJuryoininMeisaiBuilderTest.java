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
 * {@link ShokanJuryoininMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJuryoininMeisaiBuilderTest extends DbcTestBase {

    private static DbT3037ShokanJuryoininMeisaiEntity ShokanJuryoininMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static ShokanJuryoininMeisaiBuilder sut;
        private static ShokanJuryoininMeisai business;

        @Before
        public void setUp() {
            ShokanJuryoininMeisaiEntity = new DbT3037ShokanJuryoininMeisaiEntity();
            ShokanJuryoininMeisaiEntity.setXXX(主キー名1);
            ShokanJuryoininMeisaiEntity.setXXX(主キー名2);

            business = new ShokanJuryoininMeisai(ShokanJuryoininMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の契約番号は_設定した値と同じ契約番号を返す() {
            business = sut.set契約番号(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_契約番号).build();
            assertThat(business.get契約番号(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_契約番号));
        }

        @Test
        public void 戻り値の支払金額は_設定した値と同じ支払金額を返す() {
            business = sut.set支払金額(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_支払金額).build();
            assertThat(business.get支払金額(), is(DbT3037ShokanJuryoininMeisaiEntityGenerator.DEFAULT_支払金額));
        }

    }
}
