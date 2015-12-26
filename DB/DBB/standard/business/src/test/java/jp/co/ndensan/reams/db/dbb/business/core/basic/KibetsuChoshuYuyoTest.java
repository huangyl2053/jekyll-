/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
//import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
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
 * {@link KibetsuChoshuYuyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KibetsuChoshuYuyoTest extends DbbTestBase {

    private static DbT2007KibetsuChoshuYuyoEntity KibetsuChoshuYuyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static Decimal 履歴番号;
    private static RString 徴収方法;
    private static int 期;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        調定年度 = DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static KibetsuChoshuYuyo sut;

        @Before
        public void setUp() {
            KibetsuChoshuYuyoEntity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            KibetsuChoshuYuyoEntity.setChoteiNendo(調定年度);
            KibetsuChoshuYuyoEntity.setFukaNendo(賦課年度);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KibetsuChoshuYuyo(null, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KibetsuChoshuYuyo(調定年度, null, 通知書番号, 履歴番号, 徴収方法, 期);
        }

        @Test
        public void 指定したキーが保持するDbT2007KibetsuChoshuYuyoEntityにセットされている() {
            sut = new KibetsuChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
            assertThat(sut.get調定年度(), is(調定年度));
            assertThat(sut.get賦課年度(), is(賦課年度));
        }

        @Test
        public void 指定したキーが保持するKibetsuChoshuYuyoIdentifierにセットされている() {
            sut = new KibetsuChoshuYuyo(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期);
            assertThat(sut.identifier().get調定年度(), is(調定年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static KibetsuChoshuYuyo sut;

        @Before
        public void setUp() {
            KibetsuChoshuYuyoEntity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            KibetsuChoshuYuyoEntity.setChoteiNendo(調定年度);
            KibetsuChoshuYuyoEntity.setFukaNendo(賦課年度);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KibetsuChoshuYuyo(null);
        }

        @Test
        public void 指定したDbT2007KibetsuChoshuYuyoEntityのキー情報を識別子が持つ() {

            sut = new KibetsuChoshuYuyo(KibetsuChoshuYuyoEntity);

            assertThat(sut.identifier().get調定年度(), is(調定年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static KibetsuChoshuYuyo sut;

        @Before
        public void setUp() {
            KibetsuChoshuYuyoEntity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            KibetsuChoshuYuyoEntity.setChoteiNendo(調定年度);
            KibetsuChoshuYuyoEntity.setFukaNendo(賦課年度);

            sut = new KibetsuChoshuYuyo(KibetsuChoshuYuyoEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(KibetsuChoshuYuyoEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(KibetsuChoshuYuyoEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(KibetsuChoshuYuyoEntity.getTsuchishoNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KibetsuChoshuYuyoEntity.getRirekiNo()));
        }

        @Test
        public void get徴収方法は_entityが持つ徴収方法を返す() {
            assertThat(sut.get徴収方法(), is(KibetsuChoshuYuyoEntity.getChoshuHoho()));
        }

        @Test
        public void get期は_entityが持つ期を返す() {
            assertThat(sut.get期(), is(KibetsuChoshuYuyoEntity.getKi()));
        }

        @Test
        public void get徴収猶予開始日は_entityが持つ徴収猶予開始日を返す() {
            assertThat(sut.get徴収猶予開始日(), is(KibetsuChoshuYuyoEntity.getYuyoStartYMD()));
        }

        @Test
        public void get徴収猶予終了日は_entityが持つ徴収猶予終了日を返す() {
            assertThat(sut.get徴収猶予終了日(), is(KibetsuChoshuYuyoEntity.getYuyoEndYMD()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static KibetsuChoshuYuyo sut;

        @Before
        public void setUp() {
            KibetsuChoshuYuyoEntity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            KibetsuChoshuYuyoEntity.setChoteiNendo(調定年度);
            KibetsuChoshuYuyoEntity.setFukaNendo(賦課年度);

            sut = new KibetsuChoshuYuyo(KibetsuChoshuYuyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KibetsuChoshuYuyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static KibetsuChoshuYuyo sut;

        @Before
        public void setUp() {
            KibetsuChoshuYuyoEntity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            KibetsuChoshuYuyoEntity.setChoteiNendo(調定年度);
            KibetsuChoshuYuyoEntity.setFukaNendo(賦課年度);

            sut = new KibetsuChoshuYuyo(KibetsuChoshuYuyoEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static KibetsuChoshuYuyo sut;
        private static KibetsuChoshuYuyo result;

        @Before
        public void setUp() {
            KibetsuChoshuYuyoEntity = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            KibetsuChoshuYuyoEntity.setChoteiNendo(調定年度);
            KibetsuChoshuYuyoEntity.setFukaNendo(賦課年度);

        }

        @Test
        public void KibetsuChoshuYuyoが保持するDbT2007KibetsuChoshuYuyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKibetsuChoshuYuyoが保持するDbT2007KibetsuChoshuYuyoEntityのEntityDataStateがDeletedに指定されたKibetsuChoshuYuyoが返る() {
            sut = TestSupport.setStateKibetsuChoshuYuyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KibetsuChoshuYuyoが保持するDbT2007KibetsuChoshuYuyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKibetsuChoshuYuyoが保持するDbT2007KibetsuChoshuYuyoEntityのEntityDataStateがDeletedに指定されたKibetsuChoshuYuyoが返る() {
            sut = TestSupport.setStateKibetsuChoshuYuyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KibetsuChoshuYuyoが保持するDbT2007KibetsuChoshuYuyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKibetsuChoshuYuyoが保持するDbT2007KibetsuChoshuYuyoEntityのEntityDataStateがDeletedに指定されたKibetsuChoshuYuyoが返る() {
            sut = TestSupport.setStateKibetsuChoshuYuyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KibetsuChoshuYuyoが保持するDbT2007KibetsuChoshuYuyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKibetsuChoshuYuyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KibetsuChoshuYuyo setStateKibetsuChoshuYuyo(EntityDataState parentState) {
            KibetsuChoshuYuyoEntity.setState(parentState);
            return new KibetsuChoshuYuyo(KibetsuChoshuYuyoEntity);
        }
    }
}
