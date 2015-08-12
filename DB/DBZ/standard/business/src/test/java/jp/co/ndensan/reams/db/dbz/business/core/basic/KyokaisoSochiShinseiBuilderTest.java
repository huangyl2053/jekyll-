/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinseiBuilder;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1013KyokaisoSochiShinseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyokaisoSochiShinseiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyokaisoSochiShinseiBuilderTest extends DbzTestBase {

    private static DbT1013KyokaisoSochiShinseiEntity KyokaisoSochiShinseiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KyokaisoSochiShinseiBuilder sut;
        private static KyokaisoSochiShinsei business;

        @Before
        public void setUp() {
            KyokaisoSochiShinseiEntity = new DbT1013KyokaisoSochiShinseiEntity();
            KyokaisoSochiShinseiEntity.setHihokenshaNo(被保険者番号);
            KyokaisoSochiShinseiEntity.setRirekiNo(履歴番号);

            business = new KyokaisoSochiShinsei(KyokaisoSochiShinseiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の申請年月日は_設定した値と同じ申請年月日を返す() {
            business = sut.set申請年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請年月日).build();
            assertThat(business.get申請年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請年月日));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の申請_廃止区分は_設定した値と同じ申請_廃止区分を返す() {
            business = sut.set申請_廃止区分(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請廃止区分
            ).build();
            assertThat(business.get申請_廃止区分(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請廃止区分
            ));
        }

        @Test
        public void 戻り値の申請_廃止年月日は_設定した値と同じ申請_廃止年月日を返す() {
            business = sut.set申請_廃止年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請廃止年月日
            ).build();
            assertThat(business.get申請_廃止年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_申請廃止年月日
            ));
        }

        @Test
        public void 戻り値の保護不要根拠減額金額は_設定した値と同じ保護不要根拠減額金額を返す() {
            business = sut.set保護不要根拠減額金額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_保護不要根拠減額金額).build();
            assertThat(business.get保護不要根拠減額金額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_保護不要根拠減額金額));
        }

        @Test
        public void 戻り値の境界層証明書交付年月日は_設定した値と同じ境界層証明書交付年月日を返す() {
            business = sut.set境界層証明書交付年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_境界層証明書交付年月日).build();
            assertThat(business.get境界層証明書交付年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_境界層証明書交付年月日));
        }

        @Test
        public void 戻り値の給付額減額取消_減額自己負担月額は_設定した値と同じ給付額減額取消_減額自己負担月額を返す() {
            business = sut.set給付額減額取消_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_給付額減額取消減額自己負担月額
            ).build();
            assertThat(business.get給付額減額取消_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_給付額減額取消減額自己負担月額
            ));
        }

        @Test
        public void 戻り値の居住費軽減_減額自己負担月額は_設定した値と同じ居住費軽減_減額自己負担月額を返す() {
            business = sut.set居住費軽減_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_居住費軽減減額自己負担月額
            ).build();
            assertThat(business.get居住費軽減_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_居住費軽減減額自己負担月額
            ));
        }

        @Test
        public void 戻り値の居住費軽減_負担限度額段階コードは_設定した値と同じ居住費軽減_負担限度額段階コードを返す() {
            business = sut.set居住費軽減_負担限度額段階コード(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_居住費軽減負担限度額段階コード
            ).build();
            assertThat(business.get居住費軽減_負担限度額段階コード(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_居住費軽減負担限度額段階コード
            ));
        }

        @Test
        public void 戻り値の食費軽減_減額自己負担月額は_設定した値と同じ食費軽減_減額自己負担月額を返す() {
            business = sut.set食費軽減_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_食費軽減減額自己負担月額
            ).build();
            assertThat(business.get食費軽減_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_食費軽減減額自己負担月額
            ));
        }

        @Test
        public void 戻り値の食費軽減_負担限度額段階コードは_設定した値と同じ食費軽減_負担限度額段階コードを返す() {
            business = sut.set食費軽減_負担限度額段階コード(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_食費軽減負担限度額段階コード
            ).build();
            assertThat(business.get食費軽減_負担限度額段階コード(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_食費軽減負担限度額段階コード
            ));
        }

        @Test
        public void 戻り値の利用者負担世帯合算額_減額自己負担月額は_設定した値と同じ利用者負担世帯合算額_減額自己負担月額を返す() {
            business = sut.set利用者負担世帯合算額_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_利用者負担世帯合算額減額自己負担月額).build();
            assertThat(business.get利用者負担世帯合算額_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_利用者負担世帯合算額減額自己負担月額
            ));
        }

        @Test
        public void 戻り値の保険料減額_減額自己負担月額は_設定した値と同じ保険料減額DbzTestBase減額自己負担月額を返す() {
            business = sut.set保険料減額_減額自己負担月額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_保険料減額減額自己負担月額
            ).build();
            assertThat(business.get保険料減額_減額自己負担月額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_保険料減額減額自己負担月額
            )
            );
        }

        @Test
        public void 戻り値の減額自己負担月額合計額は_設定した値と同じ減額自己負担月額合計額を返す() {
            business = sut.set減額自己負担月額合計額(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_減額自己負担月額合計額).build();
            assertThat(business.get減額自己負担月額合計額(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_減額自己負担月額合計額));
        }

        @Test
        public void 戻り値の境界層措置決定年月日は_設定した値と同じ境界層措置決定年月日を返す() {
            business = sut.set境界層措置決定年月日(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_境界層措置決定年月日).build();
            assertThat(business.get境界層措置決定年月日(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_境界層措置決定年月日));
        }

        @Test
        public void 戻り値の措置該当_非該当区分は_設定した値と同じ措置該当非該当区分を返す() {
            business = sut.set措置該当_非該当区分(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_措置該当非該当区分
            ).build();
            assertThat(business.get措置該当_非該当区分(), is(DbT1013KyokaisoSochiShinseiEntityGenerator.DEFAULT_措置該当非該当区分
            )
            );
        }

    }
}
