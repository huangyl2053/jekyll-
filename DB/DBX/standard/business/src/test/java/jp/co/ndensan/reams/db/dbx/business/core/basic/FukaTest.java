/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

//import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link Fuka}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class FukaTest extends DbxTestBase {

    private static DbT2002FukaEntity FukaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調停年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調停年度 = DbT2002FukaEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2002FukaEntityGenerator.DEFAULT_賦課年度;
    }

    public static class 主キーコンストラクタテスト extends DbxTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            FukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            FukaEntity.setChoteiNendo(調停年度);
            FukaEntity.setFukaNendo(賦課年度);
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

    public static class Entityコンストラクタテスト extends DbxTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            FukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            FukaEntity.setChoteiNendo(調停年度);
            FukaEntity.setFukaNendo(賦課年度);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new Fuka(null);
        }

        @Test
        public void 指定したDbT2002FukaEntityのキー情報を識別子が持つ() {

            sut = new Fuka(FukaEntity);
            assertThat(sut.identifier().get調定年度(), is(調停年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
        }
    }

    public static class getterテスト extends DbxTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            FukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            FukaEntity.setChoteiNendo(調停年度);
            FukaEntity.setFukaNendo(賦課年度);

            sut = new Fuka(FukaEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(FukaEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(FukaEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(FukaEntity.getTsuchishoNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(FukaEntity.getRirekiNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(FukaEntity.getHihokenshaNo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(FukaEntity.getShikibetsuCode()));
        }

        @Test
        public void get世帯コードは_entityが持つ世帯コードを返す() {
            assertThat(sut.get世帯コード(), is(FukaEntity.getSetaiCode()));
        }

        @Test
        public void get世帯員数は_entityが持つ世帯員数を返す() {
            assertThat(sut.get世帯員数(), is(FukaEntity.getSetaiInsu()));
        }

        @Test
        public void get資格取得日は_entityが持つ資格取得日を返す() {
            assertThat(sut.get資格取得日(), is(FukaEntity.getShikakuShutokuYMD()));
        }

        @Test
        public void get資格取得事由は_entityが持つ資格取得事由を返す() {
            assertThat(sut.get資格取得事由().toRString(), is(FukaEntity.getShikakuShutokuJiyu()));
        }

        @Test
        public void get資格喪失日は_entityが持つ資格喪失日を返す() {
            assertThat(sut.get資格喪失日(), is(FukaEntity.getShikakuSoshitsuYMD()));
        }

        @Test
        public void get資格喪失事由は_entityが持つ資格喪失事由を返す() {
            assertThat(sut.get資格喪失事由().toRString(), is(FukaEntity.getShikakuSoshitsuJiyu()));
        }

        @Test
        public void get生活保護扶助種類は_entityが持つ生活保護扶助種類を返す() {
            assertThat(sut.get生活保護扶助種類().toRString(), is(FukaEntity.getSeihofujoShurui()));
        }

        @Test
        public void get生保開始日は_entityが持つ生保開始日を返す() {
            assertThat(sut.get生保開始日(), is(FukaEntity.getSeihoKaishiYMD()));
        }

        @Test
        public void get生保廃止日は_entityが持つ生保廃止日を返す() {
            assertThat(sut.get生保廃止日(), is(FukaEntity.getSeihoHaishiYMD()));
        }

        @Test
        public void get老年開始日は_entityが持つ老年開始日を返す() {
            assertThat(sut.get老年開始日(), is(FukaEntity.getRonenKaishiYMD()));
        }

        @Test
        public void get老年廃止日は_entityが持つ老年廃止日を返す() {
            assertThat(sut.get老年廃止日(), is(FukaEntity.getRonenHaishiYMD()));
        }

        @Test
        public void get賦課期日は_entityが持つ賦課期日を返す() {
            assertThat(sut.get賦課期日(), is(FukaEntity.getFukaYMD()));
        }

        @Test
        public void get課税区分は_entityが持つ課税区分を返す() {
            assertThat(sut.get課税区分().get名称(), is(FukaEntity.getKazeiKubun()));
        }

        @Test
        public void get世帯課税区分は_entityが持つ世帯課税区分を返す() {
            assertThat(sut.get世帯課税区分().get名称(), is(FukaEntity.getSetaikazeiKubun()));
        }

        @Test
        public void get合計所得金額は_entityが持つ合計所得金額を返す() {
            assertThat(sut.get合計所得金額(), is(FukaEntity.getGokeiShotokuGaku()));
        }

        @Test
        public void get公的年金収入額は_entityが持つ公的年金収入額を返す() {
            assertThat(sut.get公的年金収入額(), is(FukaEntity.getNenkinShunyuGaku()));
        }

        @Test
        public void get保険料段階は_entityが持つ保険料段階を返す() {
            assertThat(sut.get保険料段階(), is(FukaEntity.getHokenryoDankai()));
        }

        @Test
        public void get保険料算定段階1は_entityが持つ保険料算定段階1を返す() {
            assertThat(sut.get保険料算定段階1(), is(FukaEntity.getHokenryoDankai1()));
        }

        @Test
        public void get算定年額保険料1は_entityが持つ算定年額保険料1を返す() {
            assertThat(sut.get算定年額保険料1(), is(FukaEntity.getNengakuHokenryo1()));
        }

        @Test
        public void get月割開始年月1は_entityが持つ月割開始年月1を返す() {
            assertThat(sut.get月割開始年月1(), is(FukaEntity.getTsukiwariStartYM1()));
        }

        @Test
        public void get月割終了年月1は_entityが持つ月割終了年月1を返す() {
            assertThat(sut.get月割終了年月1(), is(FukaEntity.getTsukiwariEndYM1()));
        }

        @Test
        public void get保険料算定段階2は_entityが持つ保険料算定段階2を返す() {
            assertThat(sut.get保険料算定段階2(), is(FukaEntity.getHokenryoDankai2()));
        }

        @Test
        public void get算定年額保険料2は_entityが持つ算定年額保険料2を返す() {
            assertThat(sut.get算定年額保険料2(), is(FukaEntity.getNengakuHokenryo2()));
        }

        @Test
        public void get月割開始年月2は_entityが持つ月割開始年月2を返す() {
            assertThat(sut.get月割開始年月2(), is(FukaEntity.getTsukiwariStartYM2()));
        }

        @Test
        public void get月割終了年月2は_entityが持つ月割終了年月2を返す() {
            assertThat(sut.get月割終了年月2(), is(FukaEntity.getTsukiwariEndYM2()));
        }

        @Test
        public void get調定日時は_entityが持つ調定日時を返す() {
            assertThat(sut.get調定日時(), is(FukaEntity.getChoteiNichiji()));
        }

        @Test
        public void get調定事由1は_entityが持つ調定事由1を返す() {
            assertThat(sut.get調定事由1().toRString(), is(FukaEntity.getChoteiJiyu1()));
        }

        @Test
        public void get調定事由2は_entityが持つ調定事由2を返す() {
            assertThat(sut.get調定事由2().toRString(), is(FukaEntity.getChoteiJiyu2()));
        }

        @Test
        public void get調定事由3は_entityが持つ調定事由3を返す() {
            assertThat(sut.get調定事由3().toRString(), is(FukaEntity.getChoteiJiyu3()));
        }

        @Test
        public void get調定事由4は_entityが持つ調定事由4を返す() {
            assertThat(sut.get調定事由4().toRString(), is(FukaEntity.getChoteiJiyu4()));
        }

        @Test
        public void get更正月は_entityが持つ更正月を返す() {
            assertThat(sut.get更正月(), is(FukaEntity.getKoseiM()));
        }

        @Test
        public void get減免前介護保険料_年額は_entityが持つ減免前介護保険料_年額を返す() {
            assertThat(sut.get減免前介護保険料_年額(), is(FukaEntity.getGemmenMaeHokenryo())
            );
        }

        @Test
        public void get減免額は_entityが持つ減免額を返す() {
            assertThat(sut.get減免額(), is(FukaEntity.getGemmenGaku()));
        }

        @Test
        public void get確定介護保険料_年額は_entityが持つ確定介護保険料_年額を返す() {
            assertThat(sut.get確定介護保険料_年額(), is(FukaEntity.getKakuteiHokenryo())
            );
        }

        @Test
        public void get保険料段階_仮算定時は_entityが持つ保険料段階_仮算定時を返す() {
            assertThat(sut.get保険料段階_仮算定時(), is(FukaEntity.getHokenryoDankaiKarisanntei())
            );
        }

        @Test
        public void get徴収方法履歴番号は_entityが持つ徴収方法履歴番号を返す() {
            assertThat(sut.get徴収方法履歴番号(), is(FukaEntity.getChoshuHohoRirekiNo()));
        }

        @Test
        public void get異動基準日時は_entityが持つ異動基準日時を返す() {
            assertThat(sut.get異動基準日時(), is(FukaEntity.getIdoKijunNichiji()));
        }

        @Test
        public void get口座区分は_entityが持つ口座区分を返す() {
            assertThat(sut.get口座区分(), is(FukaEntity.getKozaKubun()));
        }

        @Test
        public void get境界層区分は_entityが持つ境界層区分を返す() {
            assertThat(sut.get境界層区分().toRString(), is(FukaEntity.getKyokaisoKubun()));
        }

        @Test
        public void get職権区分は_entityが持つ職権区分を返す() {
            assertThat(sut.get職権区分(), is(FukaEntity.getShokkenKubun()));
        }

        @Test
        public void get賦課市町村コードは_entityが持つ賦課市町村コードを返す() {
            assertThat(sut.get賦課市町村コード(), is(FukaEntity.getFukaShichosonCode()));
        }
    }

    public static class toEntityテスト extends DbxTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            FukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            FukaEntity.setChoteiNendo(調停年度);
            FukaEntity.setFukaNendo(賦課年度);

            sut = new Fuka(FukaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(FukaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbxTestBase {

        private static Fuka sut;

        @Before
        public void setUp() {
            FukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            FukaEntity.setChoteiNendo(調停年度);
            FukaEntity.setFukaNendo(賦課年度);

            sut = new Fuka(FukaEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbxTestBase {

        private static Fuka sut;
        private static Fuka result;

        @Before
        public void setUp() {
            FukaEntity = DbT2002FukaEntityGenerator.createDbT2002FukaEntity();
            FukaEntity.setChoteiNendo(調停年度);
            FukaEntity.setFukaNendo(賦課年度);

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
            FukaEntity.setState(parentState);
            return new Fuka(FukaEntity);
        }
    }
}
