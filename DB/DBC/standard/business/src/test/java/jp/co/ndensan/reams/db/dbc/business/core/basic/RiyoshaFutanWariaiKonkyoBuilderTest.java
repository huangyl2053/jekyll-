/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
    private static FlexibleYear 年度;
    private static HihokenshaNo 被保険者番号;
    private static int 履歴番号;
    private static int 枝番号;
    private static HihokenshaNo 世帯員被保険者番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        年度 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_年度;
        被保険者番号 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_履歴番号;
        枝番号 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_枝番号;
        世帯員被保険者番号 = DbT3115RiyoshaFutanWariaiKonkyoEntityGenerator.DEFAULT_世帯員被保険者番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static RiyoshaFutanWariaiKonkyoBuilder sut;
        private static RiyoshaFutanWariaiKonkyo business;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiKonkyoEntity = new DbT3115RiyoshaFutanWariaiKonkyoEntity();
            RiyoshaFutanWariaiKonkyoEntity.setNendo(年度);
            RiyoshaFutanWariaiKonkyoEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiKonkyoEntity.setRirekiNo(履歴番号);
            RiyoshaFutanWariaiKonkyoEntity.setEdaNo(枝番号);
            RiyoshaFutanWariaiKonkyoEntity.setSetaiinHihokenshaNo(世帯員被保険者番号);

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
