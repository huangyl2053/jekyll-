/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5190NinteiSoshinzumiMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5190NinteiSoshinzumiMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiSoshinzumiMasterBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiSoshinzumiMasterBuilderTest extends DbeTestBase {

    private static DbT5190NinteiSoshinzumiMasterEntity NinteiSoshinzumiMasterEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_申請書管理番号;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static NinteiSoshinzumiMasterBuilder sut;
        private static NinteiSoshinzumiMaster business;

        @Before
        public void setUp() {
            NinteiSoshinzumiMasterEntity = new DbT5190NinteiSoshinzumiMasterEntity();

            business = new NinteiSoshinzumiMaster(NinteiSoshinzumiMasterEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の同一連番は_設定した値と同じ同一連番を返す() {
            business = sut.set同一連番(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_同一連番).build();
            assertThat(business.get同一連番(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_同一連番));
        }

        @Test
        public void 戻り値の引き渡しフラグは_設定した値と同じ引き渡しフラグを返す() {
            business = sut.set引き渡しフラグ(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_引き渡しフラグ).build();
            assertThat(business.is引き渡しフラグ(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_引き渡しフラグ));
        }

        @Test
        public void 戻り値の引き渡し日時は_設定した値と同じ引き渡し日時を返す() {
            business = sut.set引き渡し日時(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_引き渡し日時).build();
            assertThat(business.get引き渡し日時(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_引き渡し日時));
        }

        @Test
        public void 戻り値の引き渡し解除日時は_設定した値と同じ引き渡し解除日時を返す() {
            business = sut.set引き渡し解除日時(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_引き渡し解除日時).build();
            assertThat(business.get引き渡し解除日時(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_引き渡し解除日時));
        }

        @Test
        public void 戻り値の引き渡しカウントは_設定した値と同じ引き渡しカウントを返す() {
            business = sut.set引き渡しカウント(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_引き渡しカウント).build();
            assertThat(business.get引き渡しカウント(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_引き渡しカウント));
        }

        @Test
        public void 戻り値の取り込み日時は_設定した値と同じ取り込み日時を返す() {
            business = sut.set取り込み日時(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_取り込み日時).build();
            assertThat(business.get取り込み日時(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_取り込み日時));
        }

        @Test
        public void 戻り値の再送付区分は_設定した値と同じ再送付区分を返す() {
            business = sut.set再送付区分(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_再送付区分).build();
            assertThat(business.get再送付区分(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_再送付区分));
        }

        @Test
        public void 戻り値の再調査送付区分は_設定した値と同じ再調査送付区分を返す() {
            business = sut.set再調査送付区分(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_再調査送付区分).build();
            assertThat(business.get再調査送付区分(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_再調査送付区分));
        }

        @Test
        public void 戻り値の再意見書送付区分は_設定した値と同じ再意見書送付区分を返す() {
            business = sut.set再意見書送付区分(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_再意見書送付区分).build();
            assertThat(business.get再意見書送付区分(), is(DbT5190NinteiSoshinzumiMasterEntityGenerator.DEFAULT_再意見書送付区分));
        }

    }
}
