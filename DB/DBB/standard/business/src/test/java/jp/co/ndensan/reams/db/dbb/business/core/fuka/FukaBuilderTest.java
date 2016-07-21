/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2003KibetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.FukaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaBuilderTest extends DbbTestBase {

    private static DbT2002FukaEntity fukaEntity;
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static int 履歴番号;
    private static RString 徴収方法;
    private static int 期;

    @BeforeClass
    public static void setUpClass() {
        調定年度 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbT2002FukaEntityGenerator.DEFAULT_履歴番号;
        徴収方法 = DbT2003KibetsuEntityGenerator.DEFAULT_徴収方法;
        期 = DbT2003KibetsuEntityGenerator.DEFAULT_期;
    }

    public static class Kibetsuテスト extends DbbTestBase {

        private static FukaBuilder sut;
        private static Fuka business;
        private static Kibetsu kibetsu;

        @Before
        public void setUp() {
            fukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            fukaEntity.setChoteiNendo(調定年度);
            fukaEntity.setFukaNendo(賦課年度);
            fukaEntity.setTsuchishoNo(通知書番号);
            fukaEntity.setRirekiNo(履歴番号);

            FukaEntity relateEntity = new FukaEntity();
            relateEntity.set介護賦課Entity(fukaEntity);
            business = new Fuka(relateEntity);
            kibetsu = new Kibetsu(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
            sut = business.createBuilderForEdit();
        }

        @Test
        public void 介護賦課に紐づくことが可能な子テーブル情報をsetKibetsuで設定した場合_設定済みの子テーブル情報が返る() {
            business = sut.setKibetsu(kibetsu).build();
            assertThat(business.getKibetsuList().size(), is(1));
        }
    }

    public static class getterSetterTest extends DbbTestBase {

        private static FukaBuilder sut;
        private static Fuka business;

        @Before
        public void setUp() {
            fukaEntity = new DbT2002FukaEntity();
            fukaEntity.setChoteiNendo(調定年度);
            fukaEntity.setFukaNendo(賦課年度);
            fukaEntity.setTsuchishoNo(通知書番号);
            fukaEntity.setRirekiNo(履歴番号);

            FukaEntity relateEntity = new FukaEntity();
            relateEntity.set介護賦課Entity(fukaEntity);
            business = new Fuka(relateEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT2002FukaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT2002FukaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT2002FukaEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT2002FukaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の世帯コードは_設定した値と同じ世帯コードを返す() {
            business = sut.set世帯コード(DbT2002FukaEntityGenerator.DEFAULT_世帯コード).build();
            assertThat(business.get世帯コード(), is(DbT2002FukaEntityGenerator.DEFAULT_世帯コード));
        }

        @Test
        public void 戻り値の世帯員数は_設定した値と同じ世帯員数を返す() {
            business = sut.set世帯員数(DbT2002FukaEntityGenerator.DEFAULT_世帯員数).build();
            assertThat(business.get世帯員数(), is(DbT2002FukaEntityGenerator.DEFAULT_世帯員数));
        }

        @Test
        public void 戻り値の資格取得日は_設定した値と同じ資格取得日を返す() {
            business = sut.set資格取得日(DbT2002FukaEntityGenerator.DEFAULT_資格取得日).build();
            assertThat(business.get資格取得日(), is(DbT2002FukaEntityGenerator.DEFAULT_資格取得日));
        }

        @Test
        public void 戻り値の資格取得事由は_設定した値と同じ資格取得事由を返す() {
            business = sut.set資格取得事由(DbT2002FukaEntityGenerator.DEFAULT_資格取得事由).build();
            assertThat(business.get資格取得事由(), is(DbT2002FukaEntityGenerator.DEFAULT_資格取得事由));
        }

        @Test
        public void 戻り値の資格喪失日は_設定した値と同じ資格喪失日を返す() {
            business = sut.set資格喪失日(DbT2002FukaEntityGenerator.DEFAULT_資格喪失日).build();
            assertThat(business.get資格喪失日(), is(DbT2002FukaEntityGenerator.DEFAULT_資格喪失日));
        }

        @Test
        public void 戻り値の資格喪失事由は_設定した値と同じ資格喪失事由を返す() {
            business = sut.set資格喪失事由(DbT2002FukaEntityGenerator.DEFAULT_資格喪失事由).build();
            assertThat(business.get資格喪失事由(), is(DbT2002FukaEntityGenerator.DEFAULT_資格喪失事由));
        }

        @Test
        public void 戻り値の生活保護扶助種類は_設定した値と同じ生活保護扶助種類を返す() {
            business = sut.set生活保護扶助種類(DbT2002FukaEntityGenerator.DEFAULT_生活保護扶助種類).build();
            assertThat(business.get生活保護扶助種類(), is(DbT2002FukaEntityGenerator.DEFAULT_生活保護扶助種類));
        }

        @Test
        public void 戻り値の生保開始日は_設定した値と同じ生保開始日を返す() {
            business = sut.set生保開始日(DbT2002FukaEntityGenerator.DEFAULT_生保開始日).build();
            assertThat(business.get生保開始日(), is(DbT2002FukaEntityGenerator.DEFAULT_生保開始日));
        }

        @Test
        public void 戻り値の生保廃止日は_設定した値と同じ生保廃止日を返す() {
            business = sut.set生保廃止日(DbT2002FukaEntityGenerator.DEFAULT_生保廃止日).build();
            assertThat(business.get生保廃止日(), is(DbT2002FukaEntityGenerator.DEFAULT_生保廃止日));
        }

        @Test
        public void 戻り値の老年開始日は_設定した値と同じ老年開始日を返す() {
            business = sut.set老年開始日(DbT2002FukaEntityGenerator.DEFAULT_老年開始日).build();
            assertThat(business.get老年開始日(), is(DbT2002FukaEntityGenerator.DEFAULT_老年開始日));
        }

        @Test
        public void 戻り値の老年廃止日は_設定した値と同じ老年廃止日を返す() {
            business = sut.set老年廃止日(DbT2002FukaEntityGenerator.DEFAULT_老年廃止日).build();
            assertThat(business.get老年廃止日(), is(DbT2002FukaEntityGenerator.DEFAULT_老年廃止日));
        }

        @Test
        public void 戻り値の賦課期日は_設定した値と同じ賦課期日を返す() {
            business = sut.set賦課期日(DbT2002FukaEntityGenerator.DEFAULT_賦課期日).build();
            assertThat(business.get賦課期日(), is(DbT2002FukaEntityGenerator.DEFAULT_賦課期日));
        }

        @Test
        public void 戻り値の課税区分は_設定した値と同じ課税区分を返す() {
            business = sut.set課税区分(DbT2002FukaEntityGenerator.DEFAULT_課税区分).build();
            assertThat(business.get課税区分(), is(DbT2002FukaEntityGenerator.DEFAULT_課税区分));
        }

        @Test
        public void 戻り値の世帯課税区分は_設定した値と同じ世帯課税区分を返す() {
            business = sut.set世帯課税区分(DbT2002FukaEntityGenerator.DEFAULT_世帯課税区分).build();
            assertThat(business.get世帯課税区分(), is(DbT2002FukaEntityGenerator.DEFAULT_世帯課税区分));
        }

        @Test
        public void 戻り値の合計所得金額は_設定した値と同じ合計所得金額を返す() {
            business = sut.set合計所得金額(DbT2002FukaEntityGenerator.DEFAULT_合計所得金額).build();
            assertThat(business.get合計所得金額(), is(DbT2002FukaEntityGenerator.DEFAULT_合計所得金額));
        }

        @Test
        public void 戻り値の公的年金収入額は_設定した値と同じ公的年金収入額を返す() {
            business = sut.set公的年金収入額(DbT2002FukaEntityGenerator.DEFAULT_公的年金収入額).build();
            assertThat(business.get公的年金収入額(), is(DbT2002FukaEntityGenerator.DEFAULT_公的年金収入額));
        }

        @Test
        public void 戻り値の保険料段階は_設定した値と同じ保険料段階を返す() {
            business = sut.set保険料段階(DbT2002FukaEntityGenerator.DEFAULT_保険料段階).build();
            assertThat(business.get保険料段階(), is(DbT2002FukaEntityGenerator.DEFAULT_保険料段階));
        }

        @Test
        public void 戻り値の保険料算定段階1は_設定した値と同じ保険料算定段階1を返す() {
            business = sut.set保険料算定段階1(DbT2002FukaEntityGenerator.DEFAULT_保険料算定段階1).build();
            assertThat(business.get保険料算定段階1(), is(DbT2002FukaEntityGenerator.DEFAULT_保険料算定段階1));
        }

        @Test
        public void 戻り値の算定年額保険料1は_設定した値と同じ算定年額保険料1を返す() {
            business = sut.set算定年額保険料1(DbT2002FukaEntityGenerator.DEFAULT_算定年額保険料1).build();
            assertThat(business.get算定年額保険料1(), is(DbT2002FukaEntityGenerator.DEFAULT_算定年額保険料1));
        }

        @Test
        public void 戻り値の月割開始年月1は_設定した値と同じ月割開始年月1を返す() {
            business = sut.set月割開始年月1(DbT2002FukaEntityGenerator.DEFAULT_月割開始年月1).build();
            assertThat(business.get月割開始年月1(), is(DbT2002FukaEntityGenerator.DEFAULT_月割開始年月1));
        }

        @Test
        public void 戻り値の月割終了年月1は_設定した値と同じ月割終了年月1を返す() {
            business = sut.set月割終了年月1(DbT2002FukaEntityGenerator.DEFAULT_月割終了年月1).build();
            assertThat(business.get月割終了年月1(), is(DbT2002FukaEntityGenerator.DEFAULT_月割終了年月1));
        }

        @Test
        public void 戻り値の保険料算定段階2は_設定した値と同じ保険料算定段階2を返す() {
            business = sut.set保険料算定段階2(DbT2002FukaEntityGenerator.DEFAULT_保険料算定段階2).build();
            assertThat(business.get保険料算定段階2(), is(DbT2002FukaEntityGenerator.DEFAULT_保険料算定段階2));
        }

        @Test
        public void 戻り値の算定年額保険料2は_設定した値と同じ算定年額保険料2を返す() {
            business = sut.set算定年額保険料2(DbT2002FukaEntityGenerator.DEFAULT_算定年額保険料2).build();
            assertThat(business.get算定年額保険料2(), is(DbT2002FukaEntityGenerator.DEFAULT_算定年額保険料2));
        }

        @Test
        public void 戻り値の月割開始年月2は_設定した値と同じ月割開始年月2を返す() {
            business = sut.set月割開始年月2(DbT2002FukaEntityGenerator.DEFAULT_月割開始年月2).build();
            assertThat(business.get月割開始年月2(), is(DbT2002FukaEntityGenerator.DEFAULT_月割開始年月2));
        }

        @Test
        public void 戻り値の月割終了年月2は_設定した値と同じ月割終了年月2を返す() {
            business = sut.set月割終了年月2(DbT2002FukaEntityGenerator.DEFAULT_月割終了年月2).build();
            assertThat(business.get月割終了年月2(), is(DbT2002FukaEntityGenerator.DEFAULT_月割終了年月2));
        }

        @Test
        public void 戻り値の調定日時は_設定した値と同じ調定日時を返す() {
            business = sut.set調定日時(DbT2002FukaEntityGenerator.DEFAULT_調定日時).build();
            assertThat(business.get調定日時(), is(DbT2002FukaEntityGenerator.DEFAULT_調定日時));
        }

        @Test
        public void 戻り値の調定事由1は_設定した値と同じ調定事由1を返す() {
            business = sut.set調定事由1(DbT2002FukaEntityGenerator.DEFAULT_調定事由1).build();
            assertThat(business.get調定事由1(), is(DbT2002FukaEntityGenerator.DEFAULT_調定事由1));
        }

        @Test
        public void 戻り値の調定事由2は_設定した値と同じ調定事由2を返す() {
            business = sut.set調定事由2(DbT2002FukaEntityGenerator.DEFAULT_調定事由2).build();
            assertThat(business.get調定事由2(), is(DbT2002FukaEntityGenerator.DEFAULT_調定事由2));
        }

        @Test
        public void 戻り値の調定事由3は_設定した値と同じ調定事由3を返す() {
            business = sut.set調定事由3(DbT2002FukaEntityGenerator.DEFAULT_調定事由3).build();
            assertThat(business.get調定事由3(), is(DbT2002FukaEntityGenerator.DEFAULT_調定事由3));
        }

        @Test
        public void 戻り値の調定事由4は_設定した値と同じ調定事由4を返す() {
            business = sut.set調定事由4(DbT2002FukaEntityGenerator.DEFAULT_調定事由4).build();
            assertThat(business.get調定事由4(), is(DbT2002FukaEntityGenerator.DEFAULT_調定事由4));
        }

        @Test
        public void 戻り値の更正月は_設定した値と同じ更正月を返す() {
            business = sut.set更正月(DbT2002FukaEntityGenerator.DEFAULT_更正月).build();
            assertThat(business.get更正月(), is(DbT2002FukaEntityGenerator.DEFAULT_更正月));
        }

        @Test
        public void 戻り値の減免前介護保険料_年額は_設定した値と同じ減免前介護保険料_年額を返す() {
            business = sut.set減免前介護保険料_年額(DbT2002FukaEntityGenerator.DEFAULT_減免前介護保険料_年額).build();
            assertThat(business.get減免前介護保険料_年額(), is(DbT2002FukaEntityGenerator.DEFAULT_減免前介護保険料_年額));
        }

        @Test
        public void 戻り値の減免額は_設定した値と同じ減免額を返す() {
            business = sut.set減免額(DbT2002FukaEntityGenerator.DEFAULT_減免額).build();
            assertThat(business.get減免額(), is(DbT2002FukaEntityGenerator.DEFAULT_減免額));
        }

        @Test
        public void 戻り値の確定介護保険料_年額は_設定した値と同じ確定介護保険料_年額を返す() {
            business = sut.set確定介護保険料_年額(DbT2002FukaEntityGenerator.DEFAULT_確定介護保険料_年額).build();
            assertThat(business.get確定介護保険料_年額(), is(DbT2002FukaEntityGenerator.DEFAULT_確定介護保険料_年額));
        }

        @Test
        public void 戻り値の保険料段階_仮算定時は_設定した値と同じ保険料段階_仮算定時を返す() {
            business = sut.set保険料段階_仮算定時(DbT2002FukaEntityGenerator.DEFAULT_保険料段階_仮算定時).build();
            assertThat(business.get保険料段階_仮算定時(), is(DbT2002FukaEntityGenerator.DEFAULT_保険料段階_仮算定時));
        }

        @Test
        public void 戻り値の徴収方法履歴番号は_設定した値と同じ徴収方法履歴番号を返す() {
            business = sut.set徴収方法履歴番号(DbT2002FukaEntityGenerator.DEFAULT_徴収方法履歴番号).build();
            assertThat(business.get徴収方法履歴番号(), is(DbT2002FukaEntityGenerator.DEFAULT_徴収方法履歴番号));
        }

        @Test
        public void 戻り値の異動基準日時は_設定した値と同じ異動基準日時を返す() {
            business = sut.set異動基準日時(DbT2002FukaEntityGenerator.DEFAULT_異動基準日時).build();
            assertThat(business.get異動基準日時(), is(DbT2002FukaEntityGenerator.DEFAULT_異動基準日時));
        }

        @Test
        public void 戻り値の口座区分は_設定した値と同じ口座区分を返す() {
            business = sut.set口座区分(DbT2002FukaEntityGenerator.DEFAULT_口座区分).build();
            assertThat(business.get口座区分(), is(DbT2002FukaEntityGenerator.DEFAULT_口座区分));
        }

        @Test
        public void 戻り値の境界層区分は_設定した値と同じ境界層区分を返す() {
            business = sut.set境界層区分(DbT2002FukaEntityGenerator.DEFAULT_境界層区分).build();
            assertThat(business.get境界層区分(), is(DbT2002FukaEntityGenerator.DEFAULT_境界層区分));
        }

        @Test
        public void 戻り値の職権区分は_設定した値と同じ職権区分を返す() {
            business = sut.set職権区分(DbT2002FukaEntityGenerator.DEFAULT_職権区分).build();
            assertThat(business.get職権区分(), is(DbT2002FukaEntityGenerator.DEFAULT_職権区分));
        }

        @Test
        public void 戻り値の賦課市町村コードは_設定した値と同じ賦課市町村コードを返す() {
            business = sut.set賦課市町村コード(DbT2002FukaEntityGenerator.DEFAULT_賦課市町村コード).build();
            assertThat(business.get賦課市町村コード(), is(DbT2002FukaEntityGenerator.DEFAULT_賦課市町村コード));
        }
//
//        @Test
//        public void 戻り値の特徴歳出還付額は_設定した値と同じ特徴歳出還付額を返す() {
//            business = sut.set特徴歳出還付額(DbT2002FukaEntityGenerator.DEFAULT_特徴歳出還付額).build();
//            assertThat(business.get特徴歳出還付額(), is(DbT2002FukaEntityGenerator.DEFAULT_特徴歳出還付額));
//        }
//
//        @Test
//        public void 戻り値の普徴歳出還付額は_設定した値と同じ普徴歳出還付額を返す() {
//            business = sut.set普徴歳出還付額(DbT2002FukaEntityGenerator.DEFAULT_普徴歳出還付額).build();
//            assertThat(business.get普徴歳出還付額(), is(DbT2002FukaEntityGenerator.DEFAULT_普徴歳出還付額));
//        }

    }
}
