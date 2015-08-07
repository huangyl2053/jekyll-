/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7028KakushuShinKyuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KakushuShinKyuNoHenkanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KakushuShinKyuNoHenkanBuilderTest extends DbzTestBase {

    private static DbT7028KakushuShinKyuNoHenkanEntity KakushuShinKyuNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KakushuShinKyuNoHenkanBuilder sut;
        private static KakushuShinKyuNoHenkan business;

        @Before
        public void setUp() {
            KakushuShinKyuNoHenkanEntity = new DbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkanEntity.setXXX(主キー名1);
            KakushuShinKyuNoHenkanEntity.setXXX(主キー名2);

            business = new KakushuShinKyuNoHenkan(KakushuShinKyuNoHenkanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の番号区分は_設定した値と同じ番号区分を返す() {
            business = sut.set番号区分(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分).build();
            assertThat(business.get番号区分(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分));
        }

        @Test
        public void 戻り値の新番号は_設定した値と同じ新番号を返す() {
            business = sut.set新番号(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_新番号).build();
            assertThat(business.get新番号(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_新番号));
        }

        @Test
        public void 戻り値の旧番号は_設定した値と同じ旧番号を返す() {
            business = sut.set旧番号(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号).build();
            assertThat(business.get旧番号(), is(DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号));
        }

    }
}
