/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.kyotsu.ChoteiJiyu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.definition.core.code.FujoShuruiCodeValue;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link Fuka}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaTest extends DbbTestBase {

    private static DbT2002FukaEntity fukaEntity;
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調停年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
        調停年度 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbT2002FukaEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbT2002FukaEntityGenerator.DEFAULT_履歴番号;

    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            fukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            fukaEntity.setChoteiNendo(調停年度);
            fukaEntity.setFukaNendo(賦課年度);
            fukaEntity.setTsuchishoNo(通知書番号);
            fukaEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Fuka(null, 賦課年度, 通知書番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Fuka(調停年度, null, 通知書番号, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT2002FukaEntityにセットされている() {
            sut = new Fuka(調停年度, 賦課年度, 通知書番号, 履歴番号);
            assertThat(sut.get調定年度(), is(調停年度));
            assertThat(sut.get賦課年度(), is(賦課年度));
        }

        @Test
        public void 指定したキーが保持するFukaIdentifierにセットされている() {
            sut = new Fuka(調停年度, 賦課年度, 通知書番号, 履歴番号);
            assertThat(sut.identifier().get調定年度(), is(調停年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            fukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            fukaEntity.setChoteiNendo(調停年度);
            fukaEntity.setFukaNendo(賦課年度);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new Fuka(null);
        }

        @Test
        public void 指定したDbT2002FukaEntityのキー情報を識別子が持つ() {

            sut = new Fuka(fukaEntity);
            assertThat(sut.identifier().get調定年度(), is(調停年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            fukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            fukaEntity.setChoteiNendo(調停年度);
            fukaEntity.setFukaNendo(賦課年度);

            sut = new Fuka(fukaEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(fukaEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(fukaEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(fukaEntity.getTsuchishoNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(fukaEntity.getRirekiNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(fukaEntity.getHihokenshaNo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(fukaEntity.getShikibetsuCode()));
        }

        @Test
        public void get世帯コードは_entityが持つ世帯コードを返す() {
            assertThat(sut.get世帯コード(), is(fukaEntity.getSetaiCode()));
        }

        @Test
        public void get世帯員数は_entityが持つ世帯員数を返す() {
            assertThat(sut.get世帯員数(), is(fukaEntity.getSetaiInsu()));
        }

        @Test
        public void get資格取得日は_entityが持つ資格取得日を返す() {
            assertThat(sut.get資格取得日(), is(fukaEntity.getShikakuShutokuYMD()));
        }

        @Test
        public void get資格取得事由は_entityが持つ資格取得事由を返す() {
            assertThat(sut.get資格取得事由(), is(new KaigoShikakuShutokuJiyu(fukaEntity.getShikakuShutokuJiyu())));
        }

        @Test
        public void get資格喪失日は_entityが持つ資格喪失日を返す() {
            assertThat(sut.get資格喪失日(), is(fukaEntity.getShikakuSoshitsuYMD()));
        }

        @Test
        public void get資格喪失事由は_entityが持つ資格喪失事由を返す() {
            assertThat(sut.get資格喪失事由(), is(new KaigoShikakuSoshitsuJiyu(fukaEntity.getShikakuSoshitsuJiyu())));
        }

        @Test
        public void get生活保護扶助種類は_entityが持つ生活保護扶助種類を返す() {
            assertThat(sut.get生活保護扶助種類(), is(new FujoShuruiCodeValue(fukaEntity.getSeihofujoShurui())));
        }

        @Test
        public void get生保開始日は_entityが持つ生保開始日を返す() {
            assertThat(sut.get生保開始日(), is(fukaEntity.getSeihoKaishiYMD()));
        }

        @Test
        public void get生保廃止日は_entityが持つ生保廃止日を返す() {
            assertThat(sut.get生保廃止日(), is(fukaEntity.getSeihoHaishiYMD()));
        }

        @Test
        public void get老年開始日は_entityが持つ老年開始日を返す() {
            assertThat(sut.get老年開始日(), is(fukaEntity.getRonenKaishiYMD()));
        }

        @Test
        public void get老年廃止日は_entityが持つ老年廃止日を返す() {
            assertThat(sut.get老年廃止日(), is(fukaEntity.getRonenHaishiYMD()));
        }

        @Test
        public void get賦課期日は_entityが持つ賦課期日を返す() {
            assertThat(sut.get賦課期日(), is(fukaEntity.getFukaYMD()));
        }

        @Test
        public void get課税区分は_entityが持つ課税区分を返す() {
            assertThat(sut.get課税区分().code(), is(fukaEntity.getKazeiKubun()));
        }

        @Test
        public void get世帯課税区分は_entityが持つ世帯課税区分を返す() {
            assertThat(sut.get世帯課税区分().code(), is(fukaEntity.getSetaikazeiKubun()));
        }

        @Test
        public void get合計所得金額は_entityが持つ合計所得金額を返す() {
            assertThat(sut.get合計所得金額(), is(fukaEntity.getGokeiShotokuGaku()));
        }

        @Test
        public void get公的年金収入額は_entityが持つ公的年金収入額を返す() {
            assertThat(sut.get公的年金収入額(), is(fukaEntity.getNenkinShunyuGaku()));
        }

        @Test
        public void get保険料段階は_entityが持つ保険料段階を返す() {
            assertThat(sut.get保険料段階(), is(fukaEntity.getHokenryoDankai()));
        }

        @Test
        public void get保険料算定段階1は_entityが持つ保険料算定段階1を返す() {
            assertThat(sut.get保険料算定段階1(), is(fukaEntity.getHokenryoDankai1()));
        }

        @Test
        public void get算定年額保険料1は_entityが持つ算定年額保険料1を返す() {
            assertThat(sut.get算定年額保険料1(), is(fukaEntity.getNengakuHokenryo1()));
        }

        @Test
        public void get月割開始年月1は_entityが持つ月割開始年月1を返す() {
            assertThat(sut.get月割開始年月1(), is(fukaEntity.getTsukiwariStartYM1()));
        }

        @Test
        public void get月割終了年月1は_entityが持つ月割終了年月1を返す() {
            assertThat(sut.get月割終了年月1(), is(fukaEntity.getTsukiwariEndYM1()));
        }

        @Test
        public void get保険料算定段階2は_entityが持つ保険料算定段階2を返す() {
            assertThat(sut.get保険料算定段階2(), is(fukaEntity.getHokenryoDankai2()));
        }

        @Test
        public void get算定年額保険料2は_entityが持つ算定年額保険料2を返す() {
            assertThat(sut.get算定年額保険料2(), is(fukaEntity.getNengakuHokenryo2()));
        }

        @Test
        public void get月割開始年月2は_entityが持つ月割開始年月2を返す() {
            assertThat(sut.get月割開始年月2(), is(fukaEntity.getTsukiwariStartYM2()));
        }

        @Test
        public void get月割終了年月2は_entityが持つ月割終了年月2を返す() {
            assertThat(sut.get月割終了年月2(), is(fukaEntity.getTsukiwariEndYM2()));
        }

        @Test
        public void get調定日時は_entityが持つ調定日時を返す() {
            assertThat(sut.get調定日時(), is(fukaEntity.getChoteiTimestamp()));
        }

        @Test
        public void get調定事由1は_entityが持つ調定事由1を返す() {
            assertThat(sut.get調定事由1(), is(new ChoteiJiyu(fukaEntity.getChoteiJiyu1())));
        }

        @Test
        public void get調定事由2は_entityが持つ調定事由2を返す() {
            assertThat(sut.get調定事由2(), is(new ChoteiJiyu(fukaEntity.getChoteiJiyu2())));
        }

        @Test
        public void get調定事由3は_entityが持つ調定事由3を返す() {
            assertThat(sut.get調定事由3(), is(new ChoteiJiyu(fukaEntity.getChoteiJiyu3())));
        }

        @Test
        public void get調定事由4は_entityが持つ調定事由4を返す() {
            assertThat(sut.get調定事由4(), is(new ChoteiJiyu(fukaEntity.getChoteiJiyu4())));
        }

        @Test
        public void get更正月は_entityが持つ更正月を返す() {
            assertThat(sut.get更正月(), is(fukaEntity.getKoseiM()));
        }

        @Test
        public void get減免前介護保険料_年額は_entityが持つ減免前介護保険料_年額を返す() {
            assertThat(sut.get減免前介護保険料_年額(), is(fukaEntity.getGemmenMaeHokenryo())
            );
        }

        @Test
        public void get減免額は_entityが持つ減免額を返す() {
            assertThat(sut.get減免額(), is(fukaEntity.getGemmenGaku()));
        }

        @Test
        public void get確定介護保険料_年額は_entityが持つ確定介護保険料_年額を返す() {
            assertThat(sut.get確定介護保険料_年額(), is(fukaEntity.getKakuteiHokenryo())
            );
        }

        @Test
        public void get保険料段階_仮算定時は_entityが持つ保険料段階_仮算定時を返す() {
            assertThat(sut.get保険料段階_仮算定時(), is(fukaEntity.getHokenryoDankaiKarisanntei())
            );
        }

        @Test
        public void get徴収方法履歴番号は_entityが持つ徴収方法履歴番号を返す() {
            assertThat(sut.get徴収方法履歴番号(), is(fukaEntity.getChoshuHohoRirekiNo()));
        }

        @Test
        public void get異動基準日時は_entityが持つ異動基準日時を返す() {
            assertThat(sut.get異動基準日時(), is(fukaEntity.getIdoKijunTimestamp()));
        }

        @Test
        public void get口座区分は_entityが持つ口座区分を返す() {
            assertThat(sut.get口座区分(), is(fukaEntity.getKozaKubun()));
        }

        @Test
        public void get境界層区分は_entityが持つ境界層区分を返す() {
            assertThat(sut.get境界層区分().getCode(), is(fukaEntity.getKyokaisoKubun()));
        }

        @Test
        public void get職権区分は_entityが持つ職権区分を返す() {
            assertThat(sut.get職権区分(), is(fukaEntity.getShokkenKubun()));
        }

        @Test
        public void get賦課市町村コードは_entityが持つ賦課市町村コードを返す() {
            assertThat(sut.get賦課市町村コード(), is(fukaEntity.getFukaShichosonCode()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            fukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            fukaEntity.setChoteiNendo(調停年度);
            fukaEntity.setFukaNendo(賦課年度);

            sut = new Fuka(fukaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(fukaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            fukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            fukaEntity.setChoteiNendo(調停年度);
            fukaEntity.setFukaNendo(賦課年度);

            sut = new Fuka(fukaEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static Fuka sut;
        private static Fuka result;

        @Before
        public void setUp() {
            fukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            fukaEntity.setChoteiNendo(調停年度);
            fukaEntity.setFukaNendo(賦課年度);

        }

        @Test
        public void Fukaが保持するDbT2002FukaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりFukaが保持するDbT2002FukaEntityのEntityDataStateがDeletedに指定されたFukaが返る() {
            sut = TestSupport.setStateFuka(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Fukaが保持するDbT2002FukaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりFukaが保持するDbT2002FukaEntityのEntityDataStateがDeletedに指定されたFukaが返る() {
            sut = TestSupport.setStateFuka(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Fukaが保持するDbT2002FukaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりFukaが保持するDbT2002FukaEntityのEntityDataStateがDeletedに指定されたFukaが返る() {
            sut = TestSupport.setStateFuka(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void Fukaが保持するDbT2002FukaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateFuka(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static Fuka setStateFuka(EntityDataState parentState) {
            fukaEntity.setState(parentState);
            return new Fuka(fukaEntity);
        }
    }
}
