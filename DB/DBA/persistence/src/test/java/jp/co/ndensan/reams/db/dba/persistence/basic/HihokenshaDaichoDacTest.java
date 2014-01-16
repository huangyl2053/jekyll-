/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.basic;

import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceCreator;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoDacTest extends TestDacBase {

    private static IHihokenshaDaichoDac sut;

    static {
        setDummyControlData("DB");
    }

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceCreator.create(IHihokenshaDaichoDac.class);
    }

    public static class テストしたいメソッド名 extends TestDacBase {

        @Override
        protected void setUp() {
            // 各テストケースの実行前の処理を記述します。
            // 必要ない場合は消去してください。
            // TestBaseを継承すると、このsetUpメソッドの処理の前にダミーの団体コードと
            // ControlDataが作成されます。
        }

        @Test
        public void このような条件の時_このメソッドは_このような結果を返す() {
        }

        @Override
        protected void tearDown() {
            // 各テストケースの実行後の処理を記述します。
            // 必要ない場合は消去してください。
        }
    }
}
