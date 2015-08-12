/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7054KanrenHihokenshaNoEntityGenerator;
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
 * {@link KanrenHihokenshaNoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KanrenHihokenshaNoBuilderTest extends DbzTestBase {

    private static DbT7054KanrenHihokenshaNoEntity KanrenHihokenshaNoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KanrenHihokenshaNoBuilder sut;
        private static KanrenHihokenshaNo business;

        @Before
        public void setUp() {
            KanrenHihokenshaNoEntity = new DbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNoEntity.setXXX(主キー名1);
            KanrenHihokenshaNoEntity.setXXX(主キー名2);

            business = new KanrenHihokenshaNo(KanrenHihokenshaNoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の最新被保険者番号は_設定した値と同じ最新被保険者番号を返す() {
            business = sut.set最新被保険者番号(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_最新被保険者番号).build();
            assertThat(business.get最新被保険者番号(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_最新被保険者番号));
        }

        @Test
        public void 戻り値の旧被保険者番号は_設定した値と同じ旧被保険者番号を返す() {
            business = sut.set旧被保険者番号(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_旧被保険者番号).build();
            assertThat(business.get旧被保険者番号(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_旧被保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_識別コード));
        }

    }
}
