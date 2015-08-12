/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.testhelper.DbcTestBase;
import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
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
 * {@link NijiYoboCheckListHanteiKekka}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboCheckListHanteiKekkaTest extends DbcTestBase {

    private static DbT3103NijiYoboCheckListHanteiKekkaEntity NijiYoboCheckListHanteiKekkaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名1);
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboCheckListHanteiKekka(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboCheckListHanteiKekka(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3103NijiYoboCheckListHanteiKekkaEntityにセットされている() {
            sut = new NijiYoboCheckListHanteiKekka(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するNijiYoboCheckListHanteiKekkaIdentifierにセットされている() {
            sut = new NijiYoboCheckListHanteiKekka(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名1);
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NijiYoboCheckListHanteiKekka(null);
        }

        @Test
        public void 指定したDbT3103NijiYoboCheckListHanteiKekkaEntityのキー情報を識別子が持つ() {

            sut = new NijiYoboCheckListHanteiKekka(NijiYoboCheckListHanteiKekkaEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名1);
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名2);

            sut = new NijiYoboCheckListHanteiKekka(NijiYoboCheckListHanteiKekkaEntity);
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(NijiYoboCheckListHanteiKekkaEntity.getShikibetsuCode()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(NijiYoboCheckListHanteiKekkaEntity.getHihokenshaNo()));
        }

        @Test
        public void get受付年月日は_entityが持つ受付年月日を返す() {
            assertThat(sut.get受付年月日(), is(NijiYoboCheckListHanteiKekkaEntity.getUketsukeYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(NijiYoboCheckListHanteiKekkaEntity.getRirekiNo()));
        }

        @Test
        public void get点数・生活機能全般は_entityが持つ点数・生活機能全般を返す() {
            assertThat(sut.get点数・生活機能全般(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_SeikatsuKinoZenpan()));
        }

        @Test
        public void get点数・運動器機能は_entityが持つ点数・運動器機能を返す() {
            assertThat(sut.get点数・運動器機能(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_UndokiKino()));
        }

        @Test
        public void get点数・栄養は_entityが持つ点数・栄養を返す() {
            assertThat(sut.get点数・栄養(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_Eiyo()));
        }

        @Test
        public void get点数・口腔は_entityが持つ点数・口腔を返す() {
            assertThat(sut.get点数・口腔(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_Koku()));
        }

        @Test
        public void get点数・閉じこもりは_entityが持つ点数・閉じこもりを返す() {
            assertThat(sut.get点数・閉じこもり(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_Tojikomori()));
        }

        @Test
        public void get点数・認知能力は_entityが持つ点数・認知能力を返す() {
            assertThat(sut.get点数・認知能力(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_NinchiNoryoku()));
        }

        @Test
        public void get点数・うつは_entityが持つ点数・うつを返す() {
            assertThat(sut.get点数・うつ(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_Utsu()));
        }

        @Test
        public void get支援必要性・生活機能全般は_entityが持つ支援必要性・生活機能全般を返す() {
            assertThat(sut.get支援必要性・生活機能全般(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_SeikatsuKinoZenpan()));
        }

        @Test
        public void get支援必要性・運動器機能は_entityが持つ支援必要性・運動器機能を返す() {
            assertThat(sut.get支援必要性・運動器機能(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_UndokiKino()));
        }

        @Test
        public void get支援必要性・栄養は_entityが持つ支援必要性・栄養を返す() {
            assertThat(sut.get支援必要性・栄養(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_Eiyo()));
        }

        @Test
        public void get支援必要性・口腔は_entityが持つ支援必要性・口腔を返す() {
            assertThat(sut.get支援必要性・口腔(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_Koku()));
        }

        @Test
        public void get支援必要性・閉じこもりは_entityが持つ支援必要性・閉じこもりを返す() {
            assertThat(sut.get支援必要性・閉じこもり(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_Tojikomori()));
        }

        @Test
        public void get支援必要性・認知能力は_entityが持つ支援必要性・認知能力を返す() {
            assertThat(sut.get支援必要性・認知能力(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_NinchiNoryoku()));
        }

        @Test
        public void get支援必要性・うつは_entityが持つ支援必要性・うつを返す() {
            assertThat(sut.get支援必要性・うつ(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_Utsu()));
        }

        @Test
        public void get二次予防・主観的健康感は_entityが持つ二次予防・主観的健康感を返す() {
            assertThat(sut.get二次予防・主観的健康感(), is(NijiYoboCheckListHanteiKekkaEntity.getNijiYobo_ShukantekiKenkouKan()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名1);
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名2);

            sut = new NijiYoboCheckListHanteiKekka(NijiYoboCheckListHanteiKekkaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NijiYoboCheckListHanteiKekkaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名1);
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名2);

            sut = new NijiYoboCheckListHanteiKekka(NijiYoboCheckListHanteiKekkaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;
        private static NijiYoboCheckListHanteiKekka result;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名1);
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名2);

        }

        @Test
        public void NijiYoboCheckListHanteiKekkaが保持するDbT3103NijiYoboCheckListHanteiKekkaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNijiYoboCheckListHanteiKekkaが保持するDbT3103NijiYoboCheckListHanteiKekkaEntityのEntityDataStateがDeletedに指定されたNijiYoboCheckListHanteiKekkaが返る() {
            sut = TestSupport.setStateNijiYoboCheckListHanteiKekka(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboCheckListHanteiKekkaが保持するDbT3103NijiYoboCheckListHanteiKekkaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNijiYoboCheckListHanteiKekkaが保持するDbT3103NijiYoboCheckListHanteiKekkaEntityのEntityDataStateがDeletedに指定されたNijiYoboCheckListHanteiKekkaが返る() {
            sut = TestSupport.setStateNijiYoboCheckListHanteiKekka(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NijiYoboCheckListHanteiKekkaが保持するDbT3103NijiYoboCheckListHanteiKekkaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNijiYoboCheckListHanteiKekkaが保持するDbT3103NijiYoboCheckListHanteiKekkaEntityのEntityDataStateがDeletedに指定されたNijiYoboCheckListHanteiKekkaが返る() {
            sut = TestSupport.setStateNijiYoboCheckListHanteiKekka(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NijiYoboCheckListHanteiKekkaが保持するDbT3103NijiYoboCheckListHanteiKekkaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNijiYoboCheckListHanteiKekka(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NijiYoboCheckListHanteiKekka setStateNijiYoboCheckListHanteiKekka(EntityDataState parentState) {
            NijiYoboCheckListHanteiKekkaEntity.setState(parentState);
            return new NijiYoboCheckListHanteiKekka(NijiYoboCheckListHanteiKekkaEntity);
        }
    }
}
