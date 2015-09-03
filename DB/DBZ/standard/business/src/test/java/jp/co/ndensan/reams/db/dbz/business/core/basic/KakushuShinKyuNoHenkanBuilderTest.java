/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7028KakushuShinKyuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private static HihokenshaNo 被保険者番号;
    private static RString 番号区分;
    private static RString 旧番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号;
        番号区分 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_番号区分;
        旧番号 = DbT7028KakushuShinKyuNoHenkanEntityGenerator.DEFAULT_旧番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KakushuShinKyuNoHenkanBuilder sut;
        private static KakushuShinKyuNoHenkan business;

        @Before
        public void setUp() {
            KakushuShinKyuNoHenkanEntity = new DbT7028KakushuShinKyuNoHenkanEntity();
            KakushuShinKyuNoHenkanEntity.setHihokenshaNo(被保険者番号);
            KakushuShinKyuNoHenkanEntity.setNoKubun(番号区分);
            KakushuShinKyuNoHenkanEntity.setKyuNo(旧番号);

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
