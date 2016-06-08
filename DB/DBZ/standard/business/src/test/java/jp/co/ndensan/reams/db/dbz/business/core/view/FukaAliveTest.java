/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV2002FukaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaAlive}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class FukaAliveTest extends DbzTestBase {

    private static DbV2002FukaEntity FukaAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調定年度 = DbV2002FukaEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbV2002FukaEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbV2002FukaEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbV2002FukaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static FukaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaAliveEntity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー型1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new FukaAlive(null, 賦課年度, 通知書番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー型2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new FukaAlive(調定年度, null, 通知書番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー型3がnullである場合に_NullPointerExceptionが発生する() {
            sut = new FukaAlive(調定年度, 賦課年度, null, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbV2002FukaEntityにセットされている() {
            sut = new FukaAlive(調定年度, 賦課年度, 通知書番号, 履歴番号);
            assertThat(sut.get調定年度(), is(調定年度));
            assertThat(sut.get賦課年度(), is(賦課年度));
            assertThat(sut.get通知書番号(), is(通知書番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するFukaAliveIdentifierにセットされている() {
            sut = new FukaAlive(調定年度, 賦課年度, 通知書番号, 履歴番号);
            // TODO
//            assertThat(sut.identifier().getXXX(), is(調定年度));
//            assertThat(sut.identifier().getXXX(), is(賦課年度));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static FukaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaAliveEntity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new FukaAlive(null);
        }

        @Test
        public void 指定したDbV2002FukaEntityのキー情報を識別子が持つ() {

            sut = new FukaAlive(FukaAliveEntity);

            // TODO
//            assertThat(sut.identifier().getXXX(), is(調定年度));
//            assertThat(sut.identifier().getXXX(), is(賦課年度));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static FukaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaAliveEntity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();

            sut = new FukaAlive(FukaAliveEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(FukaAliveEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(FukaAliveEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(FukaAliveEntity.getTsuchishoNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(FukaAliveEntity.getRirekiNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(FukaAliveEntity.getHihokenshaNo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(FukaAliveEntity.getShikibetsuCode()));
        }

        @Test
        public void get世帯コードは_entityが持つ世帯コードを返す() {
            assertThat(sut.get世帯コード(), is(FukaAliveEntity.getSetaiCode()));
        }

        @Test
        public void get世帯員数は_entityが持つ世帯員数を返す() {
            assertThat(sut.get世帯員数(), is(FukaAliveEntity.getSetaiInsu()));
        }

        @Test
        public void get資格取得日は_entityが持つ資格取得日を返す() {
            assertThat(sut.get資格取得日(), is(FukaAliveEntity.getShikakuShutokuYMD()));
        }

        @Test
        public void get資格取得事由は_entityが持つ資格取得事由を返す() {
            assertThat(sut.get資格取得事由(), is(FukaAliveEntity.getShikakuShutokuJiyu()));
        }

        @Test
        public void get資格喪失日は_entityが持つ資格喪失日を返す() {
            assertThat(sut.get資格喪失日(), is(FukaAliveEntity.getShikakuSoshitsuYMD()));
        }

        @Test
        public void get資格喪失事由は_entityが持つ資格喪失事由を返す() {
            assertThat(sut.get資格喪失事由(), is(FukaAliveEntity.getShikakuSoshitsuJiyu()));
        }

        @Test
        public void get生活保護扶助種類は_entityが持つ生活保護扶助種類を返す() {
            assertThat(sut.get生活保護扶助種類(), is(FukaAliveEntity.getSeihofujoShurui()));
        }

        @Test
        public void get生保開始日は_entityが持つ生保開始日を返す() {
            assertThat(sut.get生保開始日(), is(FukaAliveEntity.getSeihoKaishiYMD()));
        }

        @Test
        public void get生保廃止日は_entityが持つ生保廃止日を返す() {
            assertThat(sut.get生保廃止日(), is(FukaAliveEntity.getSeihoHaishiYMD()));
        }

        @Test
        public void get老年開始日は_entityが持つ老年開始日を返す() {
            assertThat(sut.get老年開始日(), is(FukaAliveEntity.getRonenKaishiYMD()));
        }

        @Test
        public void get老年廃止日は_entityが持つ老年廃止日を返す() {
            assertThat(sut.get老年廃止日(), is(FukaAliveEntity.getRonenHaishiYMD()));
        }

        @Test
        public void get賦課期日は_entityが持つ賦課期日を返す() {
            assertThat(sut.get賦課期日(), is(FukaAliveEntity.getFukaYMD()));
        }

        @Test
        public void get課税区分は_entityが持つ課税区分を返す() {
            assertThat(sut.get課税区分(), is(FukaAliveEntity.getKazeiKubun()));
        }

        @Test
        public void get世帯課税区分は_entityが持つ世帯課税区分を返す() {
            assertThat(sut.get世帯課税区分(), is(FukaAliveEntity.getSetaikazeiKubun()));
        }

        @Test
        public void get合計所得金額は_entityが持つ合計所得金額を返す() {
            assertThat(sut.get合計所得金額(), is(FukaAliveEntity.getGokeiShotokuGaku()));
        }

        @Test
        public void get公的年金収入額は_entityが持つ公的年金収入額を返す() {
            assertThat(sut.get公的年金収入額(), is(FukaAliveEntity.getNenkinShunyuGaku()));
        }

        @Test
        public void get保険料段階は_entityが持つ保険料段階を返す() {
            assertThat(sut.get保険料段階(), is(FukaAliveEntity.getHokenryoDankai()));
        }

        @Test
        public void get保険料算定段階1は_entityが持つ保険料算定段階1を返す() {
            assertThat(sut.get保険料算定段階1(), is(FukaAliveEntity.getHokenryoDankai1()));
        }

        @Test
        public void get算定年額保険料1は_entityが持つ算定年額保険料1を返す() {
            assertThat(sut.get算定年額保険料1(), is(FukaAliveEntity.getNengakuHokenryo1()));
        }

        @Test
        public void get月割開始年月1は_entityが持つ月割開始年月1を返す() {
            assertThat(sut.get月割開始年月1(), is(FukaAliveEntity.getTsukiwariStartYM1()));
        }

        @Test
        public void get月割終了年月1は_entityが持つ月割終了年月1を返す() {
            assertThat(sut.get月割終了年月1(), is(FukaAliveEntity.getTsukiwariEndYM1()));
        }

        @Test
        public void get保険料算定段階2は_entityが持つ保険料算定段階2を返す() {
            assertThat(sut.get保険料算定段階2(), is(FukaAliveEntity.getHokenryoDankai2()));
        }

        @Test
        public void get算定年額保険料2は_entityが持つ算定年額保険料2を返す() {
            assertThat(sut.get算定年額保険料2(), is(FukaAliveEntity.getNengakuHokenryo2()));
        }

        @Test
        public void get月割開始年月2は_entityが持つ月割開始年月2を返す() {
            assertThat(sut.get月割開始年月2(), is(FukaAliveEntity.getTsukiwariStartYM2()));
        }

        @Test
        public void get月割終了年月2は_entityが持つ月割終了年月2を返す() {
            assertThat(sut.get月割終了年月2(), is(FukaAliveEntity.getTsukiwariEndYM2()));
        }

        @Test
        public void get調定日時は_entityが持つ調定日時を返す() {
            assertThat(sut.get調定日時(), is(FukaAliveEntity.getChoteiNichiji()));
        }

        @Test
        public void get調定事由1は_entityが持つ調定事由1を返す() {
            assertThat(sut.get調定事由1(), is(FukaAliveEntity.getChoteiJiyu1()));
        }

        @Test
        public void get調定事由2は_entityが持つ調定事由2を返す() {
            assertThat(sut.get調定事由2(), is(FukaAliveEntity.getChoteiJiyu2()));
        }

        @Test
        public void get調定事由3は_entityが持つ調定事由3を返す() {
            assertThat(sut.get調定事由3(), is(FukaAliveEntity.getChoteiJiyu3()));
        }

        @Test
        public void get調定事由4は_entityが持つ調定事由4を返す() {
            assertThat(sut.get調定事由4(), is(FukaAliveEntity.getChoteiJiyu4()));
        }

        @Test
        public void get更正月は_entityが持つ更正月を返す() {
            assertThat(sut.get更正月(), is(FukaAliveEntity.getKoseiM()));
        }

        @Test
        public void get減免前介護保険料_年額は_entityが持つ減免前介護保険料_年額を返す() {
            assertThat(sut.get減免前介護保険料_年額(), is(FukaAliveEntity.getGemmenMaeHokenryo()));
        }

        @Test
        public void get減免額は_entityが持つ減免額を返す() {
            assertThat(sut.get減免額(), is(FukaAliveEntity.getGemmenGaku()));
        }

        @Test
        public void get確定介護保険料_年額は_entityが持つ確定介護保険料_年額を返す() {
            assertThat(sut.get確定介護保険料_年額(), is(FukaAliveEntity.getKakuteiHokenryo()));
        }

        @Test
        public void get保険料段階_仮算定時は_entityが持つ保険料段階_仮算定時を返す() {
            assertThat(sut.get保険料段階_仮算定時(), is(FukaAliveEntity.getHokenryoDankaiKarisanntei()));
        }

        @Test
        public void get徴収方法履歴番号は_entityが持つ徴収方法履歴番号を返す() {
            assertThat(sut.get徴収方法履歴番号(), is(FukaAliveEntity.getChoshuHohoRirekiNo()));
        }

        @Test
        public void get異動基準日時は_entityが持つ異動基準日時を返す() {
            assertThat(sut.get異動基準日時(), is(FukaAliveEntity.getIdoKijunNichiji()));
        }

        @Test
        public void get口座区分は_entityが持つ口座区分を返す() {
            assertThat(sut.get口座区分(), is(FukaAliveEntity.getKozaKubun()));
        }

        @Test
        public void get境界層区分は_entityが持つ境界層区分を返す() {
            assertThat(sut.get境界層区分(), is(FukaAliveEntity.getKyokaisoKubun()));
        }

        @Test
        public void get職権区分は_entityが持つ職権区分を返す() {
            assertThat(sut.get職権区分(), is(FukaAliveEntity.getShokkenKubun()));
        }

        @Test
        public void get賦課市町村コードは_entityが持つ賦課市町村コードを返す() {
            assertThat(sut.get賦課市町村コード(), is(FukaAliveEntity.getFukaShichosonCode()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static FukaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaAliveEntity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();

            sut = new FukaAlive(FukaAliveEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(FukaAliveEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static FukaAlive sut;

        @BeforeClass
        public static void setUpClass() {
            FukaAliveEntity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();

            sut = new FukaAlive(FukaAliveEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static FukaAlive sut;
        private static FukaAlive result;

        @BeforeClass
        public static void setUpClass() {
            FukaAliveEntity = DbV2002FukaEntityGenerator.createDbV2002FukaEntity();

        }

        @Test
        public void FukaAliveが保持するDbV2002FukaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりFukaAliveが保持するDbV2002FukaEntityのEntityDataStateがDeletedに指定されたFukaAliveが返る() {
            sut = TestSupport.setStateFukaAlive(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void FukaAliveが保持するDbV2002FukaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりFukaAliveが保持するDbV2002FukaEntityのEntityDataStateがDeletedに指定されたFukaAliveが返る() {
            sut = TestSupport.setStateFukaAlive(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void FukaAliveが保持するDbV2002FukaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりFukaAliveが保持するDbV2002FukaEntityのEntityDataStateがDeletedに指定されたFukaAliveが返る() {
            sut = TestSupport.setStateFukaAlive(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void FukaAliveが保持するDbV2002FukaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateFukaAlive(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static FukaAlive setStateFukaAlive(EntityDataState parentState) {
            FukaAliveEntity.setState(parentState);
            return new FukaAlive(FukaAliveEntity);
        }
    }
}
