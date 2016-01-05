/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuTodokedeBuilder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuTodokedeBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuTodokedeBuilderTest extends DbzTestBase {

    private static DbT3005KyotakuKeikakuTodokedeEntity KyotakuKeikakuTodokedeEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth 対象年月;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
        対象年月 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
        履歴番号 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KyotakuKeikakuTodokedeBuilder sut;
        private static KyotakuKeikakuTodokede business;

        @Before
        public void setUp() {
            KyotakuKeikakuTodokedeEntity = new DbT3005KyotakuKeikakuTodokedeEntity();
            KyotakuKeikakuTodokedeEntity.setHihokenshaNo(被保険者番号);
            KyotakuKeikakuTodokedeEntity.setTaishoYM(対象年月);
            KyotakuKeikakuTodokedeEntity.setRirekiNo(履歴番号);

            business = new KyotakuKeikakuTodokede(KyotakuKeikakuTodokedeEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            business = sut.set対象年月(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月).build();
            assertThat(business.get対象年月(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の届出区分は_設定した値と同じ届出区分を返す() {
            business = sut.set届出区分(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出区分).build();
            assertThat(business.get届出区分(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出区分));
        }

        @Test
        public void 戻り値の届出年月日は_設定した値と同じ届出年月日を返す() {
            business = sut.set届出年月日(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出年月日).build();
            assertThat(business.get届出年月日(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出年月日));
        }

        @Test
        public void 戻り値の届出者氏名は_設定した値と同じ届出者氏名を返す() {
            business = sut.set届出者氏名(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者氏名).build();
            assertThat(business.get届出者氏名(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者氏名));
        }

        @Test
        public void 戻り値の届出者氏名カナは_設定した値と同じ届出者氏名カナを返す() {
            business = sut.set届出者氏名カナ(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者氏名カナ).build();
            assertThat(business.get届出者氏名カナ(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者氏名カナ));
        }

        @Test
        public void 戻り値の届出者郵便番号は_設定した値と同じ届出者郵便番号を返す() {
            business = sut.set届出者郵便番号(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者郵便番号).build();
            assertThat(business.get届出者郵便番号(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者郵便番号));
        }

        @Test
        public void 戻り値の届出者住所は_設定した値と同じ届出者住所を返す() {
            business = sut.set届出者住所(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者住所).build();
            assertThat(business.get届出者住所(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者住所));
        }

        @Test
        public void 戻り値の届出者電話番号は_設定した値と同じ届出者電話番号を返す() {
            business = sut.set届出者電話番号(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者電話番号).build();
            assertThat(business.get届出者電話番号(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者電話番号));
        }

        @Test
        public void 戻り値の届出者関係区分は_設定した値と同じ届出者関係区分を返す() {
            business = sut.set届出者関係区分(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者関係区分).build();
            assertThat(business.get届出者関係区分(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_届出者関係区分));
        }

        @Test
        public void 戻り値の暫定区分は_設定した値と同じ暫定区分を返す() {
            business = sut.set暫定区分(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_暫定区分).build();
            assertThat(business.get暫定区分(), is(DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_暫定区分));
        }

    }
}
