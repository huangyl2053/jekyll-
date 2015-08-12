/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RiyoshaFutanWariaiMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RiyoshaFutanWariaiMeisaiBuilderTest extends DbcTestBase {

    private static DbT3114RiyoshaFutanWariaiMeisaiEntity RiyoshaFutanWariaiMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static RiyoshaFutanWariaiMeisaiBuilder sut;
        private static RiyoshaFutanWariaiMeisai business;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiMeisaiEntity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
            RiyoshaFutanWariaiMeisaiEntity.setXXX(主キー名1);
            RiyoshaFutanWariaiMeisaiEntity.setXXX(主キー名2);

            business = new RiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の年度は_設定した値と同じ年度を返す() {
            business = sut.set年度(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度).build();
            assertThat(business.get年度(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の枝番号は_設定した値と同じ枝番号を返す() {
            business = sut.set枝番号(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_枝番号).build();
            assertThat(business.get枝番号(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_枝番号));
        }

        @Test
        public void 戻り値の資格区分は_設定した値と同じ資格区分を返す() {
            business = sut.set資格区分(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_資格区分).build();
            assertThat(business.get資格区分(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_資格区分));
        }

        @Test
        public void 戻り値の負担割合区分は_設定した値と同じ負担割合区分を返す() {
            business = sut.set負担割合区分(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_負担割合区分).build();
            assertThat(business.get負担割合区分(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_負担割合区分));
        }

        @Test
        public void 戻り値の有効開始日は_設定した値と同じ有効開始日を返す() {
            business = sut.set有効開始日(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_有効開始日).build();
            assertThat(business.get有効開始日(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_有効開始日));
        }

        @Test
        public void 戻り値の有効終了日は_設定した値と同じ有効終了日を返す() {
            business = sut.set有効終了日(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_有効終了日).build();
            assertThat(business.get有効終了日(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_有効終了日));
        }

        @Test
        public void 戻り値の本人合計所得金額は_設定した値と同じ本人合計所得金額を返す() {
            business = sut.set本人合計所得金額(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_本人合計所得金額).build();
            assertThat(business.get本人合計所得金額(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_本人合計所得金額));
        }

        @Test
        public void 戻り値の世帯１号被保険者数は_設定した値と同じ世帯１号被保険者数を返す() {
            business = sut.set世帯１号被保険者数(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_世帯１号被保険者数).build();
            assertThat(business.get世帯１号被保険者数(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_世帯１号被保険者数));
        }

        @Test
        public void 戻り値の年金収入合計は_設定した値と同じ年金収入合計を返す() {
            business = sut.set年金収入合計(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年金収入合計).build();
            assertThat(business.get年金収入合計(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年金収入合計));
        }

        @Test
        public void 戻り値のその他の合計所得金額合計は_設定した値と同じその他の合計所得金額合計を返す() {
            business = sut.setその他の合計所得金額合計(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_その他の合計所得金額合計).build();
            assertThat(business.getその他の合計所得金額合計(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_その他の合計所得金額合計));
        }

        @Test
        public void 戻り値の更正理由は_設定した値と同じ更正理由を返す() {
            business = sut.set更正理由(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_更正理由).build();
            assertThat(business.get更正理由(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_更正理由));
        }

        @Test
        public void 戻り値の世帯コードは_設定した値と同じ世帯コードを返す() {
            business = sut.set世帯コード(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_世帯コード).build();
            assertThat(business.get世帯コード(), is(DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_世帯コード));
        }

    }
}
