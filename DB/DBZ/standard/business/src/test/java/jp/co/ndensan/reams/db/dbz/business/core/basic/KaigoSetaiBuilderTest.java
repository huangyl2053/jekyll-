/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator;
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
 * {@link KaigoSetaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoSetaiBuilderTest extends DbzTestBase {

    private static DbT7014KaigoSetaiEntity KaigoSetaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KaigoSetaiBuilder sut;
        private static KaigoSetai business;

        @Before
        public void setUp() {
            KaigoSetaiEntity = new DbT7014KaigoSetaiEntity();
            KaigoSetaiEntity.setXXX(主キー名1);
            KaigoSetaiEntity.setXXX(主キー名2);

            business = new KaigoSetai(KaigoSetaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7014KaigoSetaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の管理識別区分は_設定した値と同じ管理識別区分を返す() {
            business = sut.set管理識別区分(DbT7014KaigoSetaiEntityGenerator.DEFAULT_管理識別区分).build();
            assertThat(business.get管理識別区分(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_管理識別区分));
        }

        @Test
        public void 戻り値の世帯把握基準年月日は_設定した値と同じ世帯把握基準年月日を返す() {
            business = sut.set世帯把握基準年月日(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯把握基準年月日).build();
            assertThat(business.get世帯把握基準年月日(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯把握基準年月日));
        }

        @Test
        public void 戻り値の世帯員管理連番は_設定した値と同じ世帯員管理連番を返す() {
            business = sut.set世帯員管理連番(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員管理連番).build();
            assertThat(business.get世帯員管理連番(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員管理連番));
        }

        @Test
        public void 戻り値の世帯員識別コードは_設定した値と同じ世帯員識別コードを返す() {
            business = sut.set世帯員識別コード(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員識別コード).build();
            assertThat(business.get世帯員識別コード(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員識別コード));
        }

        @Test
        public void 戻り値の本人区分は_設定した値と同じ本人区分を返す() {
            business = sut.set本人区分(DbT7014KaigoSetaiEntityGenerator.DEFAULT_本人区分).build();
            assertThat(business.get本人区分(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_本人区分));
        }

        @Test
        public void 戻り値の課税年度は_設定した値と同じ課税年度を返す() {
            business = sut.set課税年度(DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税年度).build();
            assertThat(business.get課税年度(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税年度));
        }

        @Test
        public void 戻り値の課税非課税区分は_設定した値と同じ課税非課税区分を返す() {
            business = sut.set課税非課税区分(DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税非課税区分).build();
            assertThat(business.get課税非課税区分(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税非課税区分));
        }

        @Test
        public void 戻り値の合計所得金額は_設定した値と同じ合計所得金額を返す() {
            business = sut.set合計所得金額(DbT7014KaigoSetaiEntityGenerator.DEFAULT_合計所得金額).build();
            assertThat(business.get合計所得金額(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_合計所得金額));
        }

        @Test
        public void 戻り値の課税年金収入額は_設定した値と同じ課税年金収入額を返す() {
            business = sut.set課税年金収入額(DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税年金収入額).build();
            assertThat(business.get課税年金収入額(), is(DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税年金収入額));
        }

    }
}
