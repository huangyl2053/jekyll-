/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2006ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
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
 * {@link ChoshuYuyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoTest extends DbbTestBase {

    private static DbT2006ChoshuYuyoEntity choshuYuyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
    private static FlexibleYear 調定年度;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;
    private static Decimal 履歴番号;
    private static RString 徴収方法;
    private static int 期;

    @BeforeClass
    public static void setUpClass() {
        調定年度 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_調定年度;
        賦課年度 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_賦課年度;
        通知書番号 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_通知書番号;
        履歴番号 = DbT2006ChoshuYuyoEntityGenerator.DEFAULT_履歴番号;
        徴収方法 = DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_徴収方法;
        期 = DbT2007KibetsuChoshuYuyoEntityGenerator.DEFAULT_期;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            choshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            choshuYuyoEntity.setChoteiNendo(調定年度);
            choshuYuyoEntity.setFukaNendo(賦課年度);
            choshuYuyoEntity.setTsuchishoNo(通知書番号);
            choshuYuyoEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChoshuYuyo(null, 調定年度, 通知書番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChoshuYuyo(調定年度, null, 通知書番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名3がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChoshuYuyo(調定年度, 調定年度, null, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名4がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChoshuYuyo(調定年度, 調定年度, 通知書番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT2006ChoshuYuyoEntityにセットされている() {
            sut = new ChoshuYuyo(調定年度, 調定年度, 通知書番号, 履歴番号);
            assertThat(sut.get調定年度(), is(調定年度));
            assertThat(sut.get賦課年度(), is(賦課年度));
            assertThat(sut.get通知書番号(), is(通知書番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するChoshuYuyoIdentifierにセットされている() {
            sut = new ChoshuYuyo(調定年度, 調定年度, 通知書番号, 履歴番号);
            assertThat(sut.identifier().get調定年度(), is(調定年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get通知書番号(), is(通知書番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }

        @Test
        public void 空のKibetsuChoshuYuyoリストがセットされている() {
            sut = new ChoshuYuyo(調定年度, 調定年度, 通知書番号, 履歴番号);
            assertThat(sut.getKibetsuChoshuYuyoList().size(), is(0));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            choshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            choshuYuyoEntity.setChoteiNendo(調定年度);
            choshuYuyoEntity.setFukaNendo(賦課年度);
            choshuYuyoEntity.setTsuchishoNo(通知書番号);
            choshuYuyoEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したChoshuYuyoEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChoshuYuyo(null);
        }

        @Test
        public void 指定したChoshuYuyoRelateEntityの保持するDbT2006ChoshuYuyoEntityのキー情報を識別子が持つ() {
            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(choshuYuyoEntity);
            sut = new ChoshuYuyo(relateEntity);

            assertThat(sut.identifier().get調定年度(), is(調定年度));
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get通知書番号(), is(通知書番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したChoshuYuyoRelateEntityの保持するDbT2007KibetsuChoshuYuyoEntityがKibetsuChoshuYuyoリストにセットされている() {
            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(choshuYuyoEntity);
            relateEntity.set介護期別徴収猶予Entity(Arrays.asList((DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity())));
            sut = new ChoshuYuyo(relateEntity);
            assertThat(sut.getKibetsuChoshuYuyoList().size(), is(1));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            choshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            choshuYuyoEntity.setChoteiNendo(調定年度);
            choshuYuyoEntity.setFukaNendo(賦課年度);
            choshuYuyoEntity.setTsuchishoNo(通知書番号);
            choshuYuyoEntity.setRirekiNo(履歴番号);

            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(choshuYuyoEntity);
            sut = new ChoshuYuyo(relateEntity);
        }

        @Test
        public void get調定年度は_entityが持つ調定年度を返す() {
            assertThat(sut.get調定年度(), is(choshuYuyoEntity.getChoteiNendo()));
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(choshuYuyoEntity.getFukaNendo()));
        }

        @Test
        public void get通知書番号は_entityが持つ通知書番号を返す() {
            assertThat(sut.get通知書番号(), is(choshuYuyoEntity.getTsuchishoNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(choshuYuyoEntity.getRirekiNo()));
        }

        @Test
        public void get徴収猶予申請年月日は_entityが持つ徴収猶予申請年月日を返す() {
            assertThat(sut.get徴収猶予申請年月日(), is(choshuYuyoEntity.getShinseiYMD()));
        }

        @Test
        public void get徴収猶予決定年月日は_entityが持つ徴収猶予決定年月日を返す() {
            assertThat(sut.get徴収猶予決定年月日(), is(choshuYuyoEntity.getKetteiYMD()));
        }

        @Test
        public void get徴収猶予取消年月日は_entityが持つ徴収猶予取消年月日を返す() {
            assertThat(sut.get徴収猶予取消年月日(), is(choshuYuyoEntity.getTorikeshiYMD()));
        }

        @Test
        public void get徴収猶予状態区分は_entityが持つ徴収猶予状態区分を返す() {
            assertThat(sut.get徴収猶予状態区分(), is(choshuYuyoEntity.getJotaiKubun()));
        }

        @Test
        public void get徴収猶予作成区分は_entityが持つ徴収猶予作成区分を返す() {
            assertThat(sut.get徴収猶予作成区分(), is(choshuYuyoEntity.getSakuseiKubun()));
        }

        @Test
        public void get申請事由は_entityが持つ申請事由を返す() {
            assertThat(sut.get申請事由(), is(choshuYuyoEntity.getShinseiJiyu()));
        }

        @Test
        public void get徴収猶予種類コードは_entityが持つ徴収猶予種類コードを返す() {
            assertThat(sut.get徴収猶予種類コード(), is(choshuYuyoEntity.getYuyoJiyuCode()));
        }

        @Test
        public void get徴収猶予事由は_entityが持つ徴収猶予事由を返す() {
            assertThat(sut.get徴収猶予事由(), is(choshuYuyoEntity.getYuyoJiyu()));
        }

        @Test
        public void get徴収猶予取消種類コードは_entityが持つ徴収猶予取消種類コードを返す() {
            assertThat(sut.get徴収猶予取消種類コード(), is(choshuYuyoEntity.getYuyoTorikeshiJiyuCode()));
        }

        @Test
        public void get徴収猶予取消事由は_entityが持つ徴収猶予取消事由を返す() {
            assertThat(sut.get徴収猶予取消事由(), is(choshuYuyoEntity.getYuyoTorikeshiJiyu()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            choshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            choshuYuyoEntity.setChoteiNendo(調定年度);
            choshuYuyoEntity.setFukaNendo(賦課年度);
            choshuYuyoEntity.setTsuchishoNo(通知書番号);
            choshuYuyoEntity.setRirekiNo(履歴番号);

            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(choshuYuyoEntity);
            sut = new ChoshuYuyo(relateEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(choshuYuyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static ChoshuYuyo sut;

        @Before
        public void setUp() {
            choshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            choshuYuyoEntity.setChoteiNendo(調定年度);
            choshuYuyoEntity.setFukaNendo(賦課年度);
            choshuYuyoEntity.setTsuchishoNo(通知書番号);
            choshuYuyoEntity.setRirekiNo(履歴番号);

            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(choshuYuyoEntity);
            sut = new ChoshuYuyo(relateEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static ChoshuYuyo sut;
        private static ChoshuYuyo result;

        @Before
        public void setUp() {
            choshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            choshuYuyoEntity.setChoteiNendo(調定年度);
            choshuYuyoEntity.setFukaNendo(賦課年度);
            choshuYuyoEntity.setTsuchishoNo(通知書番号);
            choshuYuyoEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void ChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがDeletedに指定されたChoshuYuyoが返る() {
            sut = TestSupport.setStateChoshuYuyo(EntityDataState.Unchanged, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがDeletedに指定されたChoshuYuyoが返る() {
            sut = TestSupport.setStateChoshuYuyo(EntityDataState.Modified, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがDeletedに指定されたChoshuYuyoが返る() {
            sut = TestSupport.setStateChoshuYuyo(EntityDataState.Deleted, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChoshuYuyoが保持するDbT2006ChoshuYuyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChoshuYuyo(EntityDataState.Added, EntityDataState.Unchanged);
            result = sut.deleted();
        }

        @Test
        public void ChoshuYuyoが保持するkibetsuChoshuYuoで保持するEntityのEntityDataStateがUnchangedであった場合_deletedメソッド_によりEntityDataStateがDeletedとなる() {
            sut = TestSupport.setStateChoshuYuyo(EntityDataState.Unchanged, EntityDataState.Unchanged);
            result = sut.deleted();
            for (KibetsuChoshuYuyo kibetsuChoshuYuo : result.getKibetsuChoshuYuyoList()) {
                assertThat(kibetsuChoshuYuo.toEntity().getState(), is(EntityDataState.Deleted));
            }
        }

    }

    public static class getKibetsuChoshuYuoテスト extends DbbTestBase {

        private static ChoshuYuyo sut;
        private static KibetsuChoshuYuyo kibetsuChoshuYuyo;
        private static int 期_1;
        private static int 期_2;
        private static int 期_3;
        private static KibetsuChoshuYuyoIdentifier kibetsuId;

        @Before
        public void setUp() {
            choshuYuyoEntity = DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity();
            choshuYuyoEntity.setChoteiNendo(調定年度);
            choshuYuyoEntity.setFukaNendo(賦課年度);
            choshuYuyoEntity.setTsuchishoNo(通知書番号);
            choshuYuyoEntity.setRirekiNo(履歴番号);

            期_1 = 1;
            期_2 = 2;
            期_3 = 3;
        }

        @Test
        public void 指定の識別子に該当するkibetsuChoshuYuyoが存在する場合_getkibetsuChoshuYuyo_は該当のKibetsuChoshuYuyoを返す() {
            sut = TestSupport.createChoshuYuyo(期_1, 期_2, 期_3);
            kibetsuId = new KibetsuChoshuYuyoIdentifier(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 期_3);
            kibetsuChoshuYuyo = sut.getKibetsuChoshuYuyo(kibetsuId);
            assertThat(kibetsuChoshuYuyo.identifier(), is(kibetsuId));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定の識別子に該当するKibetsuChoshuYuyoが存在しない場合_getKibetsuChoshuYuyo_はIllegalArgumentExceptionを返す() {
            sut = TestSupport.createChoshuYuyo(期_1, 期_2, 期_3);
            kibetsuId = new KibetsuChoshuYuyoIdentifier(調定年度, 賦課年度, 通知書番号, 履歴番号, 徴収方法, 4);
            kibetsuChoshuYuyo = sut.getKibetsuChoshuYuyo(kibetsuId);
        }
    }

    private static class TestSupport {

        private static DbT2007KibetsuChoshuYuyoEntity techoNiniEntity_1;
        private static DbT2007KibetsuChoshuYuyoEntity techoNiniEntity_2;
        private static DbT2007KibetsuChoshuYuyoEntity techoNiniEntity_3;

        public static ChoshuYuyo setStateChoshuYuyo(EntityDataState parentState, EntityDataState childState) {
            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            choshuYuyoEntity.setState(parentState);
            relateEntity.set介護賦課徴収猶予Entity(choshuYuyoEntity);

            List<DbT2007KibetsuChoshuYuyoEntity> niniEntityList = new ArrayList<>();
            techoNiniEntity_1 = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            techoNiniEntity_1.setChoteiNendo(調定年度);
            techoNiniEntity_1.setFukaNendo(賦課年度);
            techoNiniEntity_1.setTsuchishoNo(通知書番号);
            techoNiniEntity_1.setRirekiNo(履歴番号);
            techoNiniEntity_1.setKi(1);
            techoNiniEntity_1.setState(childState);
            techoNiniEntity_2 = techoNiniEntity_1.clone();
            techoNiniEntity_2.setKi(2);
            niniEntityList.add(techoNiniEntity_1);
            niniEntityList.add(techoNiniEntity_2);
            relateEntity.set介護期別徴収猶予Entity(niniEntityList);

            return new ChoshuYuyo(relateEntity);
        }

        public static ChoshuYuyo createChoshuYuyo(
                int 期_1,
                int 期_2,
                int 期_3
        ) {
            ChoshuYuyoEntity relateEntity = new ChoshuYuyoEntity();
            relateEntity.set介護賦課徴収猶予Entity(choshuYuyoEntity);

            List<DbT2007KibetsuChoshuYuyoEntity> niniEntityList = new ArrayList<>();
            techoNiniEntity_1 = DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity();
            techoNiniEntity_1.setKi(期_1);
            techoNiniEntity_1.setChoteiNendo(choshuYuyoEntity.getChoteiNendo());
            techoNiniEntity_1.setFukaNendo(choshuYuyoEntity.getFukaNendo());
            techoNiniEntity_1.setTsuchishoNo(choshuYuyoEntity.getTsuchishoNo());
            techoNiniEntity_1.setRirekiNo(choshuYuyoEntity.getRirekiNo());
            techoNiniEntity_2 = techoNiniEntity_1.clone();
            techoNiniEntity_2.setKi(期_2);
            techoNiniEntity_3 = techoNiniEntity_1.clone();
            techoNiniEntity_3.setKi(期_3);
            niniEntityList.add(techoNiniEntity_1);
            niniEntityList.add(techoNiniEntity_2);
            niniEntityList.add(techoNiniEntity_3);
            relateEntity.set介護期別徴収猶予Entity(niniEntityList);

            return new ChoshuYuyo(relateEntity);
        }
    }
}
