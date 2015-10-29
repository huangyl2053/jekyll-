/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link NijiYoboCheckListHanteiKekka}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class NijiYoboCheckListHanteiKekkaTest extends DbcTestBase {

    private static DbT3103NijiYoboCheckListHanteiKekkaEntity NijiYoboCheckListHanteiKekkaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleDate 受付年月日;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード;
        被保険者番号 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
        受付年月日 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日;
        履歴番号 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setShikibetsuCode(識別コード);
            NijiYoboCheckListHanteiKekkaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboCheckListHanteiKekkaEntity.setUketsukeYMD(受付年月日);
            NijiYoboCheckListHanteiKekkaEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 識別コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboCheckListHanteiKekka(null, 被保険者番号, 受付年月日, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NijiYoboCheckListHanteiKekka(識別コード, null, 受付年月日, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT3103NijiYoboCheckListHanteiKekkaEntityにセットされている() {
            sut = new NijiYoboCheckListHanteiKekka(識別コード, 被保険者番号, 受付年月日, 履歴番号);
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void 指定したキーが保持するNijiYoboCheckListHanteiKekkaIdentifierにセットされている() {
            sut = new NijiYoboCheckListHanteiKekka(識別コード, 被保険者番号, 受付年月日, 履歴番号);
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get受付年月日(), is(受付年月日));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setShikibetsuCode(識別コード);
            NijiYoboCheckListHanteiKekkaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboCheckListHanteiKekkaEntity.setUketsukeYMD(受付年月日);
            NijiYoboCheckListHanteiKekkaEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NijiYoboCheckListHanteiKekka(null);
        }

        @Test
        public void 指定したDbT3103NijiYoboCheckListHanteiKekkaEntityのキー情報を識別子が持つ() {

            sut = new NijiYoboCheckListHanteiKekka(NijiYoboCheckListHanteiKekkaEntity);

            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get受付年月日(), is(受付年月日));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setShikibetsuCode(識別コード);
            NijiYoboCheckListHanteiKekkaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboCheckListHanteiKekkaEntity.setUketsukeYMD(受付年月日);
            NijiYoboCheckListHanteiKekkaEntity.setRirekiNo(履歴番号);

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
        public void get点数_生活機能全般は_entityが持つ点数_生活機能全般を返す() {
            assertThat(sut.get点数_生活機能全般(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_SeikatsuKinoZenpan()));
        }

        @Test
        public void get点数_運動器機能は_entityが持つ点数_運動器機能を返す() {
            assertThat(sut.get点数_運動器機能(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_UndokiKino()));
        }

        @Test
        public void get点数_栄養は_entityが持つ点数_栄養を返す() {
            assertThat(sut.get点数_栄養(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_Eiyo()));
        }

        @Test
        public void get点数_口腔は_entityが持つ点数_口腔を返す() {
            assertThat(sut.get点数_口腔(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_Koku()));
        }

        @Test
        public void get点数_閉じこもりは_entityが持つ点数_閉じこもりを返す() {
            assertThat(sut.get点数_閉じこもり(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_Tojikomori()));
        }

        @Test
        public void get点数_認知能力は_entityが持つ点数_認知能力を返す() {
            assertThat(sut.get点数_認知能力(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_NinchiNoryoku()));
        }

        @Test
        public void get点数_うつは_entityが持つ点数_うつを返す() {
            assertThat(sut.get点数_うつ(), is(NijiYoboCheckListHanteiKekkaEntity.getTensu_Utsu()));
        }

        @Test
        public void get支援必要性_生活機能全般は_entityが持つ支援必要性_生活機能全般を返す() {
            assertThat(sut.get支援必要性_生活機能全般(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_SeikatsuKinoZenpan()));
        }

        @Test
        public void get支援必要性_運動器機能は_entityが持つ支援必要性_運動器機能を返す() {
            assertThat(sut.get支援必要性_運動器機能(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_UndokiKino()));
        }

        @Test
        public void get支援必要性_栄養は_entityが持つ支援必要性_栄養を返す() {
            assertThat(sut.get支援必要性_栄養(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_Eiyo()));
        }

        @Test
        public void get支援必要性_口腔は_entityが持つ支援必要性_口腔を返す() {
            assertThat(sut.get支援必要性_口腔(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_Koku()));
        }

        @Test
        public void get支援必要性_閉じこもりは_entityが持つ支援必要性_閉じこもりを返す() {
            assertThat(sut.get支援必要性_閉じこもり(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_Tojikomori()));
        }

        @Test
        public void get支援必要性_認知能力は_entityが持つ支援必要性_認知能力を返す() {
            assertThat(sut.get支援必要性_認知能力(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_NinchiNoryoku()));
        }

        @Test
        public void get支援必要性_うつは_entityが持つ支援必要性_うつを返す() {
            assertThat(sut.get支援必要性_うつ(), is(NijiYoboCheckListHanteiKekkaEntity.getShien_Utsu()));
        }

        @Test
        public void get二次予防_主観的健康感は_entityが持つ二次予防_主観的健康感を返す() {
            assertThat(sut.get二次予防_主観的健康感(), is(NijiYoboCheckListHanteiKekkaEntity.getNijiYobo_ShukantekiKenkouKan()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekka sut;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setShikibetsuCode(識別コード);
            NijiYoboCheckListHanteiKekkaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboCheckListHanteiKekkaEntity.setUketsukeYMD(受付年月日);
            NijiYoboCheckListHanteiKekkaEntity.setRirekiNo(履歴番号);

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
            NijiYoboCheckListHanteiKekkaEntity.setShikibetsuCode(識別コード);
            NijiYoboCheckListHanteiKekkaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboCheckListHanteiKekkaEntity.setUketsukeYMD(受付年月日);
            NijiYoboCheckListHanteiKekkaEntity.setRirekiNo(履歴番号);

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
            NijiYoboCheckListHanteiKekkaEntity.setShikibetsuCode(識別コード);
            NijiYoboCheckListHanteiKekkaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboCheckListHanteiKekkaEntity.setUketsukeYMD(受付年月日);
            NijiYoboCheckListHanteiKekkaEntity.setRirekiNo(履歴番号);

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
