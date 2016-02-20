/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5105NinteiKanryoJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiKanryoJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiKanryoJohoBuilderTest extends DbeTestBase {

    private static DbT5105NinteiKanryoJohoEntity NinteiKanryoJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    //private static 主キー型1 主キー名1;
    //private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        //主キー名1 = DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_主キー名1;
        //主キー名2 = DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static NinteiKanryoJohoBuilder sut;
        private static NinteiKanryoJoho business;

        @Before
        public void setUp() {
            NinteiKanryoJohoEntity = new DbT5105NinteiKanryoJohoEntity();

            business = new NinteiKanryoJoho(NinteiKanryoJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の認定申請情報登録完了年月日は_設定した値と同じ認定申請情報登録完了年月日を返す() {
            business = sut.set認定申請情報登録完了年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定申請情報登録完了年月日).build();
            assertThat(business.get認定申請情報登録完了年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定申請情報登録完了年月日));
        }

        @Test
        public void 戻り値の認定調査依頼完了年月日は_設定した値と同じ認定調査依頼完了年月日を返す() {
            business = sut.set認定調査依頼完了年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定調査依頼完了年月日).build();
            assertThat(business.get認定調査依頼完了年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定調査依頼完了年月日));
        }

        @Test
        public void 戻り値の認定調査完了年月日は_設定した値と同じ認定調査完了年月日を返す() {
            business = sut.set認定調査完了年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定調査完了年月日).build();
            assertThat(business.get認定調査完了年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定調査完了年月日));
        }

        @Test
        public void 戻り値の主治医意見書作成依頼完了年月日は_設定した値と同じ主治医意見書作成依頼完了年月日を返す() {
            business = sut.set主治医意見書作成依頼完了年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_主治医意見書作成依頼完了年月日).build();
            assertThat(business.get主治医意見書作成依頼完了年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_主治医意見書作成依頼完了年月日));
        }

        @Test
        public void 戻り値の主治医意見書登録完了年月日は_設定した値と同じ主治医意見書登録完了年月日を返す() {
            business = sut.set主治医意見書登録完了年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_主治医意見書登録完了年月日).build();
            assertThat(business.get主治医意見書登録完了年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_主治医意見書登録完了年月日));
        }

        @Test
        public void 戻り値の要介護認定一次判定完了年月日は_設定した値と同じ要介護認定一次判定完了年月日を返す() {
            business = sut.set要介護認定一次判定完了年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_要介護認定一次判定完了年月日).build();
            assertThat(business.get要介護認定一次判定完了年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_要介護認定一次判定完了年月日));
        }

        @Test
        public void 戻り値のマスキング完了年月日は_設定した値と同じマスキング完了年月日を返す() {
            business = sut.setマスキング完了年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_マスキング完了年月日).build();
            assertThat(business.getマスキング完了年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_マスキング完了年月日));
        }

        @Test
        public void 戻り値の認定審査会割当完了年月日は_設定した値と同じ認定審査会割当完了年月日を返す() {
            business = sut.set認定審査会割当完了年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定審査会割当完了年月日).build();
            assertThat(business.get認定審査会割当完了年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定審査会割当完了年月日));
        }

        @Test
        public void 戻り値の認定審査会完了年月日は_設定した値と同じ認定審査会完了年月日を返す() {
            business = sut.set認定審査会完了年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定審査会完了年月日).build();
            assertThat(business.get認定審査会完了年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_認定審査会完了年月日));
        }

        @Test
        public void 戻り値のセンター送信年月日は_設定した値と同じセンター送信年月日を返す() {
            business = sut.setセンター送信年月日(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_センター送信年月日).build();
            assertThat(business.getセンター送信年月日(), is(DbT5105NinteiKanryoJohoEntityGenerator.DEFAULT_センター送信年月日));
        }

    }
}
