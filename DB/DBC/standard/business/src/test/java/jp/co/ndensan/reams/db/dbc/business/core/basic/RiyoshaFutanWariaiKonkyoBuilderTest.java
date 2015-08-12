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
 * {@link RiyoshaFutanWariaiKonkyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RiyoshaFutanWariaiKonkyoBuilderTest extends DbcTestBase {

    private static DbT3115RiyoshaFutanWariaiKonkyoEntity RiyoshaFutanWariaiKonkyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static RiyoshaFutanWariaiKonkyoBuilder sut;
        private static RiyoshaFutanWariaiKonkyo business;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiKonkyoEntity = new DbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名1);
            RiyoshaFutanWariaiKonkyoEntity.setXXX(主キー名2);

            business = new RiyoshaFutanWariaiKonkyo(RiyoshaFutanWariaiKonkyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の年度は_設定した値と同じ年度を返す() {
            business = sut.set年度(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度).build();
            assertThat(business.get年度(), is(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の枝番号は_設定した値と同じ枝番号を返す() {
            business = sut.set枝番号(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_枝番号).build();
            assertThat(business.get枝番号(), is(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_枝番号));
        }

        @Test
        public void 戻り値の世帯員被保険者番号は_設定した値と同じ世帯員被保険者番号を返す() {
            business = sut.set世帯員被保険者番号(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員被保険者番号).build();
            assertThat(business.get世帯員被保険者番号(), is(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員被保険者番号));
        }

        @Test
        public void 戻り値の世帯員所得履歴番号は_設定した値と同じ世帯員所得履歴番号を返す() {
            business = sut.set世帯員所得履歴番号(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員所得履歴番号).build();
            assertThat(business.get世帯員所得履歴番号(), is(DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員所得履歴番号));
        }

    }
}
