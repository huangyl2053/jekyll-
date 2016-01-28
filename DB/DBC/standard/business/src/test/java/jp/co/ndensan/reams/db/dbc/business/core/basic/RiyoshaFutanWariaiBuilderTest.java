/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3113RiyoshaFutanWariaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
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
 * {@link RiyoshaFutanWariaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RiyoshaFutanWariaiBuilderTest extends DbcTestBase {

    private static DbT3113RiyoshaFutanWariaiEntity RiyoshaFutanWariaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 年度;
    private static HihokenshaNo 被保険者番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        年度 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
        被保険者番号 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static RiyoshaFutanWariaiBuilder sut;
        private static RiyoshaFutanWariai business;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiEntity = new DbT3113RiyoshaFutanWariaiEntity();
            RiyoshaFutanWariaiEntity.setNendo(年度);
            RiyoshaFutanWariaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiEntity.setRirekiNo(履歴番号);

            business = new RiyoshaFutanWariai(RiyoshaFutanWariaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の年度は_設定した値と同じ年度を返す() {
            business = sut.set年度(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度).build();
            assertThat(business.get年度(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の発行不要フラグは_設定した値と同じ発行不要フラグを返す() {
            business = sut.set発行不要フラグ(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_発行不要フラグ).build();
            assertThat(business.is発行不要フラグ(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_発行不要フラグ));
        }

        @Test
        public void 戻り値の職権変更フラグは_設定した値と同じ職権変更フラグを返す() {
            business = sut.set職権変更フラグ(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_職権変更フラグ).build();
            assertThat(business.is職権変更フラグ(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_職権変更フラグ));
        }

        @Test
        public void 戻り値の判定日は_設定した値と同じ判定日を返す() {
            business = sut.set判定日(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_判定日).build();
            assertThat(business.get判定日(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_判定日));
        }

        @Test
        public void 戻り値の判定区分は_設定した値と同じ判定区分を返す() {
            business = sut.set判定区分(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_判定区分).build();
            assertThat(business.get判定区分(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_判定区分));
        }

        @Test
        public void 戻り値の更正事由は_設定した値と同じ更正事由を返す() {
            business = sut.set更正事由(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_更正事由).build();
            assertThat(business.get更正事由(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_更正事由));
        }

        @Test
        public void 戻り値の発行区分は_設定した値と同じ発行区分を返す() {
            business = sut.set発行区分(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_発行区分).build();
            assertThat(business.get発行区分(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_発行区分));
        }

        @Test
        public void 戻り値の発行日は_設定した値と同じ発行日を返す() {
            business = sut.set発行日(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_発行日).build();
            assertThat(business.get発行日(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_発行日));
        }

        @Test
        public void 戻り値の交付日は_設定した値と同じ交付日を返す() {
            business = sut.set交付日(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_交付日).build();
            assertThat(business.get交付日(), is(DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_交付日));
        }

    }
}
