/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.viewstate;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2002FukaEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2002FukaEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaShokaiKey}のテストクラスです。
 *
 * @author n3317 塚田萌
 */
@RunWith(Enclosed.class)
public class FukaShokaiKeyTest extends DbzTestBase {

    public static class getterTest extends DbzTestBase {

        private static FukaShokaiKey sut;

        private static final SanteiState 算定状態 = SanteiState.仮算定;
        private static final boolean 減免あり = true;
        private static final boolean 徴収猶予あり = true;
        private static final AtenaMeisho 氏名 = AtenaMeisho.EMPTY;

        @BeforeClass
        public static void test() {
            sut = new FukaShokaiKey(
                    new ChoteiNendo(DEFAULT_調定年度),
                    new FukaNendo(DEFAULT_賦課年度),
                    DEFAULT_通知書番号,
                    DEFAULT_処理日時,
                    DEFAULT_被保険者番号,
                    DEFAULT_賦課期日,
                    DEFAULT_更正月,
                    DEFAULT_調定日時,
                    算定状態,
                    減免あり,
                    徴収猶予あり,
                    氏名);
        }

        @Test
        public void 戻り値の調定年度は_設定した値と同じ調定年度を返す() {
            assertThat(sut.get調定年度().value(), is(DbT2002FukaEntityGenerator.DEFAULT_調定年度));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            assertThat(sut.get賦課年度().value(), is(DbT2002FukaEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(DbT2002FukaEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            assertThat(sut.get処理日時(), is(DbT2002FukaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(DbT2002FukaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の賦課期日は_設定した値と同じ賦課期日を返す() {
            assertThat(sut.get賦課期日(), is(DbT2002FukaEntityGenerator.DEFAULT_賦課期日));
        }

        @Test
        public void 戻り値の更正月は_設定した値と同じ更正月を返す() {
            assertThat(sut.get更正月(), is(DbT2002FukaEntityGenerator.DEFAULT_更正月));
        }

        @Test
        public void 戻り値の更正日時は_設定した値と同じ更正日時を返す() {
            //更正日時＝調定日時
            assertThat(sut.get更正日時(), is(DEFAULT_調定日時));
        }

        @Test
        public void 戻り値の算定状態は_設定した値と同じ算定状態を返す() {
            assertThat(sut.get算定状態(), is(算定状態));
        }

        @Test
        public void 戻り値の減免ありは_設定した値と同じ減免ありを返す() {
            assertThat(sut.is減免あり(), is(減免あり));
        }

        @Test
        public void 戻り値の徴収猶予ありは_設定した値と同じ徴収猶予ありを返す() {
            assertThat(sut.is徴収猶予あり(), is(徴収猶予あり));
        }

        @Test
        public void 戻り値の氏名は_設定した値と同じ氏名を返す() {
            assertThat(sut.氏名(), is(氏名));
        }
    }
}
