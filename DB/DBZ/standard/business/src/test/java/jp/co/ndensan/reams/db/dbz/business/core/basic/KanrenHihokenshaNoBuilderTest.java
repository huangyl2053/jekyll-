/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7054KanrenHihokenshaNoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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
    private static ShoKisaiHokenshaNo 証記載保険者番号;
    private static HihokenshaNo 最新被保険者番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        証記載保険者番号 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_証記載保険者番号;
        最新被保険者番号 = DbT7054KanrenHihokenshaNoEntityGenerator.DEFAULT_最新被保険者番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KanrenHihokenshaNoBuilder sut;
        private static KanrenHihokenshaNo business;

        @Before
        public void setUp() {
            KanrenHihokenshaNoEntity = new DbT7054KanrenHihokenshaNoEntity();
            KanrenHihokenshaNoEntity.setShoKisaiHokenshaNo(証記載保険者番号);
            KanrenHihokenshaNoEntity.setSaishinHihokenshaNo(最新被保険者番号);

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
