/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.helper.DbT3036ShokanHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
import org.junit.Ignore;

/**
 * {@link ShokanHanteiKekka}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanHanteiKekkaTest extends DbcTestBase {

    private static DbT3036ShokanHanteiKekkaEntity ShokanHanteiKekkaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3036ShokanHanteiKekkaEntityGenerator.DEFAULT_整理番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanHanteiKekka sut;

        @Before
        public void setUp() {
            ShokanHanteiKekkaEntity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            ShokanHanteiKekkaEntity.setHiHokenshaNo(主キー名1);
            ShokanHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanHanteiKekka(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanHanteiKekka(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3036ShokanHanteiKekkaEntityにセットされている() {
            sut = new ShokanHanteiKekka(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanHanteiKekkaIdentifierにセットされている() {
            sut = new ShokanHanteiKekka(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanHanteiKekka sut;

        @Before
        public void setUp() {
            ShokanHanteiKekkaEntity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            ShokanHanteiKekkaEntity.setHiHokenshaNo(主キー名1);
            ShokanHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanHanteiKekka(null);
        }

        @Test
        public void 指定したDbT3036ShokanHanteiKekkaEntityのキー情報を識別子が持つ() {

            sut = new ShokanHanteiKekka(ShokanHanteiKekkaEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanHanteiKekka sut;

        @Before
        public void setUp() {
            ShokanHanteiKekkaEntity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            ShokanHanteiKekkaEntity.setHiHokenshaNo(主キー名1);
            ShokanHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanHanteiKekka(ShokanHanteiKekkaEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanHanteiKekkaEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanHanteiKekkaEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanHanteiKekkaEntity.getSeiriNo()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(ShokanHanteiKekkaEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(ShokanHanteiKekkaEntity.getKetteiYMD()));
        }

        @Test
        public void get支給_不支給決定区分は_entityが持つ支給_不支給決定区分を返す() {
            assertThat(sut.get支給_不支給決定区分(), is(ShokanHanteiKekkaEntity.getShikyuHushikyuKetteiKubun()));
        }

        @Test
        public void get支払金額は_entityが持つ支払金額を返す() {
            assertThat(sut.get支払金額(), is(ShokanHanteiKekkaEntity.getShiharaiKingaku()));
        }

        @Test
        public void get支払金額内訳_利用者分は_entityが持つ支払金額内訳_利用者分を返す() {
            assertThat(sut.get支払金額内訳_利用者分(), is(ShokanHanteiKekkaEntity.getShiharaiKingakuUchiwakeRiyoshabun()));
        }

        @Test
        public void get決定一覧取込年月は_entityが持つ決定一覧取込年月を返す() {
            assertThat(sut.get決定一覧取込年月(), is(ShokanHanteiKekkaEntity.getKetteiIchiranTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanHanteiKekka sut;

        @Before
        public void setUp() {
            ShokanHanteiKekkaEntity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            ShokanHanteiKekkaEntity.setHiHokenshaNo(主キー名1);
            ShokanHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanHanteiKekka(ShokanHanteiKekkaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanHanteiKekkaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanHanteiKekka sut;

        @Before
        public void setUp() {
            ShokanHanteiKekkaEntity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            ShokanHanteiKekkaEntity.setHiHokenshaNo(主キー名1);
            ShokanHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanHanteiKekka(ShokanHanteiKekkaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanHanteiKekka sut;
        private static ShokanHanteiKekka result;

        @Before
        public void setUp() {
            ShokanHanteiKekkaEntity = DbT3036ShokanHanteiKekkaEntityGenerator.createDbT3036ShokanHanteiKekkaEntity();
            ShokanHanteiKekkaEntity.setHiHokenshaNo(主キー名1);
            ShokanHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanHanteiKekkaが保持するDbT3036ShokanHanteiKekkaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanHanteiKekkaが保持するDbT3036ShokanHanteiKekkaEntityのEntityDataStateがDeletedに指定されたShokanHanteiKekkaが返る() {
            sut = TestSupport.setStateShokanHanteiKekka(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanHanteiKekkaが保持するDbT3036ShokanHanteiKekkaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanHanteiKekkaが保持するDbT3036ShokanHanteiKekkaEntityのEntityDataStateがDeletedに指定されたShokanHanteiKekkaが返る() {
            sut = TestSupport.setStateShokanHanteiKekka(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanHanteiKekkaが保持するDbT3036ShokanHanteiKekkaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanHanteiKekkaが保持するDbT3036ShokanHanteiKekkaEntityのEntityDataStateがDeletedに指定されたShokanHanteiKekkaが返る() {
            sut = TestSupport.setStateShokanHanteiKekka(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanHanteiKekkaが保持するDbT3036ShokanHanteiKekkaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanHanteiKekka(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanHanteiKekka setStateShokanHanteiKekka(EntityDataState parentState) {
            ShokanHanteiKekkaEntity.setState(parentState);
            return new ShokanHanteiKekka(ShokanHanteiKekkaEntity);
        }
    }
}
