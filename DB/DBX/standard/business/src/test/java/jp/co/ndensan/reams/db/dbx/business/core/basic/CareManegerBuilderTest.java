/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7064CareManegerEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7064CareManegerEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link CareManegerBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class CareManegerBuilderTest extends DbxTestBase {

    private static DbT7064CareManegerEntity CareManegerEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員番号;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static CareManegerBuilder sut;
        private static CareManeger business;

        @Before
        public void setUp() {
            CareManegerEntity = new DbT7064CareManegerEntity();
            CareManegerEntity.setKaigoShienSenmoninNo(主キー名1);

            business = new CareManeger(CareManegerEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の介護支援専門員番号は_設定した値と同じ介護支援専門員番号を返す() {
            business = sut.set介護支援専門員番号(DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員番号).build();
            assertThat(business.get介護支援専門員番号(), is(DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員番号));
        }

        @Test
        public void 戻り値の介護支援専門員名は_設定した値と同じ介護支援専門員名を返す() {
            business = sut.set介護支援専門員名(DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員名).build();
            assertThat(business.get介護支援専門員名(), is(DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員名));
        }

        @Test
        public void 戻り値の介護支援専門員名カナは_設定した値と同じ介護支援専門員名カナを返す() {
            business = sut.set介護支援専門員名カナ(DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員名カナ).build();
            assertThat(business.get介護支援専門員名カナ(), is(DbT7064CareManegerEntityGenerator.DEFAULT_介護支援専門員名カナ));
        }

        @Test
        public void 戻り値の所属事業者番号は_設定した値と同じ所属事業者番号を返す() {
            business = sut.set所属事業者番号(DbT7064CareManegerEntityGenerator.DEFAULT_所属事業者番号).build();
            assertThat(business.get所属事業者番号(), is(DbT7064CareManegerEntityGenerator.DEFAULT_所属事業者番号));
        }

        @Test
        public void 戻り値の有効開始年月日は_設定した値と同じ有効開始年月日を返す() {
            business = sut.set有効開始年月日(DbT7064CareManegerEntityGenerator.DEFAULT_有効開始年月日).build();
            assertThat(business.get有効開始年月日(), is(DbT7064CareManegerEntityGenerator.DEFAULT_有効開始年月日));
        }

        @Test
        public void 戻り値の有効終了年月日は_設定した値と同じ有効終了年月日を返す() {
            business = sut.set有効終了年月日(DbT7064CareManegerEntityGenerator.DEFAULT_有効終了年月日).build();
            assertThat(business.get有効終了年月日(), is(DbT7064CareManegerEntityGenerator.DEFAULT_有効終了年月日));
        }

    }
}
