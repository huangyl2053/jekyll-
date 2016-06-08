/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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

/**
 * {@link JigyoHokokuTokeiData}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JigyoHokokuTokeiDataTest extends DbuTestBase {

    private static DbT7021JigyoHokokuTokeiDataEntity JigyoHokokuTokeiDataEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 主キー名1;
    private static RString 主キー名2;
    private static FlexibleYear 主キー名3;
    private static RString 主キー名4;
    private static RString 主キー名5;
    private static LasdecCode 主キー名6;
    private static Code 主キー名7;
    private static Code 主キー名8;
    private static Code 主キー名9;
    private static Decimal 主キー名10;
    private static Decimal 主キー名11;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
        主キー名2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
        主キー名3 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年;
        主キー名4 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月;
        主キー名5 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分;
        主キー名6 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード;
        主キー名7 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号;
        主キー名8 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号;
        主キー名9 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位;
        主キー名10 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号;
        主キー名11 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号;
    }

    public static class 主キーコンストラクタテスト extends DbuTestBase {

        private static JigyoHokokuTokeiData sut;

        @Before
        public void setUp() {
            JigyoHokokuTokeiDataEntity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            JigyoHokokuTokeiDataEntity.setHokokuYSeireki(主キー名1);
            JigyoHokokuTokeiDataEntity.setHokokuM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名3がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名4がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名5がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名6がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名7がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名8がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名9がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名10がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名11がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoHokokuTokeiData(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
        }

        @Test
        public void 指定したキーが保持するDbT7021JigyoHokokuTokeiDataEntityにセットされている() {
            sut = new JigyoHokokuTokeiData(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
            assertThat(sut.get報告年(), is(主キー名1));
            assertThat(sut.get報告月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJigyoHokokuTokeiDataIdentifierにセットされている() {
            sut = new JigyoHokokuTokeiData(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9, 主キー名10, 主キー名11);
            assertThat(sut.identifier().get報告年(), is(主キー名1));
            assertThat(sut.identifier().get報告月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbuTestBase {

        private static JigyoHokokuTokeiData sut;

        @Before
        public void setUp() {
            JigyoHokokuTokeiDataEntity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            JigyoHokokuTokeiDataEntity.setHokokuYSeireki(主キー名1);
            JigyoHokokuTokeiDataEntity.setHokokuM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JigyoHokokuTokeiData(null);
        }

        @Test
        public void 指定したDbT7021JigyoHokokuTokeiDataEntityのキー情報を識別子が持つ() {

            sut = new JigyoHokokuTokeiData(JigyoHokokuTokeiDataEntity);

            assertThat(sut.identifier().get報告年(), is(主キー名1));
            assertThat(sut.identifier().get報告月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbuTestBase {

        private static JigyoHokokuTokeiData sut;

        @Before
        public void setUp() {
            JigyoHokokuTokeiDataEntity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            JigyoHokokuTokeiDataEntity.setHokokuYSeireki(主キー名1);
            JigyoHokokuTokeiDataEntity.setHokokuM(主キー名2);

            sut = new JigyoHokokuTokeiData(JigyoHokokuTokeiDataEntity);
        }

        @Test
        public void get報告年は_entityが持つ報告年を返す() {
            assertThat(sut.get報告年(), is(JigyoHokokuTokeiDataEntity.getHokokuYSeireki()));
        }

        @Test
        public void get報告月は_entityが持つ報告月を返す() {
            assertThat(sut.get報告月(), is(JigyoHokokuTokeiDataEntity.getHokokuM()));
        }

        @Test
        public void get集計対象年は_entityが持つ集計対象年を返す() {
            assertThat(sut.get集計対象年(), is(JigyoHokokuTokeiDataEntity.getShukeiTaishoYSeireki()));
        }

        @Test
        public void get集計対象月は_entityが持つ集計対象月を返す() {
            assertThat(sut.get集計対象月(), is(JigyoHokokuTokeiDataEntity.getShukeiTaishoM()));
        }

        @Test
        public void get統計対象区分は_entityが持つ統計対象区分を返す() {
            assertThat(sut.get統計対象区分(), is(JigyoHokokuTokeiDataEntity.getToukeiTaishoKubun()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(JigyoHokokuTokeiDataEntity.getShichosonCode()));
        }

        @Test
        public void get表番号は_entityが持つ表番号を返す() {
            assertThat(sut.get表番号(), is(JigyoHokokuTokeiDataEntity.getHyoNo()));
        }

        @Test
        public void get集計番号は_entityが持つ集計番号を返す() {
            assertThat(sut.get集計番号(), is(JigyoHokokuTokeiDataEntity.getShukeiNo()));
        }

        @Test
        public void get集計単位は_entityが持つ集計単位を返す() {
            assertThat(sut.get集計単位(), is(JigyoHokokuTokeiDataEntity.getShukeiTani()));
        }

        @Test
        public void get縦番号は_entityが持つ縦番号を返す() {
            assertThat(sut.get縦番号(), is(JigyoHokokuTokeiDataEntity.getTateNo()));
        }

        @Test
        public void get横番号は_entityが持つ横番号を返す() {
            assertThat(sut.get横番号(), is(JigyoHokokuTokeiDataEntity.getYokoNo()));
        }

        @Test
        public void get集計結果値は_entityが持つ集計結果値を返す() {
            assertThat(sut.get集計結果値(), is(JigyoHokokuTokeiDataEntity.getShukeiKekkaAtai()));
        }

        @Test
        public void get集計項目名称は_entityが持つ集計項目名称を返す() {
            assertThat(sut.get集計項目名称(), is(JigyoHokokuTokeiDataEntity.getShukeiKomokuMeisho()));
        }

        @Test
        public void get縦項目コードは_entityが持つ縦項目コードを返す() {
            assertThat(sut.get縦項目コード(), is(JigyoHokokuTokeiDataEntity.getTateKomokuCode()));
        }

        @Test
        public void get横項目コードは_entityが持つ横項目コードを返す() {
            assertThat(sut.get横項目コード(), is(JigyoHokokuTokeiDataEntity.getYokoKomokuCode()));
        }
    }

    public static class toEntityテスト extends DbuTestBase {

        private static JigyoHokokuTokeiData sut;

        @Before
        public void setUp() {
            JigyoHokokuTokeiDataEntity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            JigyoHokokuTokeiDataEntity.setHokokuYSeireki(主キー名1);
            JigyoHokokuTokeiDataEntity.setHokokuM(主キー名2);

            sut = new JigyoHokokuTokeiData(JigyoHokokuTokeiDataEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JigyoHokokuTokeiDataEntity));
        }
    }

//    public static class SerializationProxyテスト extends DbuTestBase {
//        private static JigyoHokokuTokeiData sut;
//        @Before
//        public void setUp() {
//            JigyoHokokuTokeiDataEntity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
//            JigyoHokokuTokeiDataEntity.setHokokuYSeireki(主キー名1);
//            JigyoHokokuTokeiDataEntity.setHokokuM(主キー名2);
//            sut = new JigyoHokokuTokeiData(JigyoHokokuTokeiDataEntity);
//        }
//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(IsSerializable.serializable()));
//        }
//    }
    public static class deletedテスト extends DbuTestBase {

        private static JigyoHokokuTokeiData sut;
        private static JigyoHokokuTokeiData result;

        @Before
        public void setUp() {
            JigyoHokokuTokeiDataEntity = DbT7021JigyoHokokuTokeiDataEntityGenerator.createDbT7021JigyoHokokuTokeiDataEntity();
            JigyoHokokuTokeiDataEntity.setHokokuYSeireki(主キー名1);
            JigyoHokokuTokeiDataEntity.setHokokuM(主キー名2);

        }

        @Test
        public void JigyoHokokuTokeiDataが保持するDbT7021JigyoHokokuTokeiDataEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJigyoHokokuTokeiDataが保持するDbT7021JigyoHokokuTokeiDataEntityのEntityDataStateがDeletedに指定されたJigyoHokokuTokeiDataが返る() {
            sut = TestSupport.setStateJigyoHokokuTokeiData(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JigyoHokokuTokeiDataが保持するDbT7021JigyoHokokuTokeiDataEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJigyoHokokuTokeiDataが保持するDbT7021JigyoHokokuTokeiDataEntityのEntityDataStateがDeletedに指定されたJigyoHokokuTokeiDataが返る() {
            sut = TestSupport.setStateJigyoHokokuTokeiData(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JigyoHokokuTokeiDataが保持するDbT7021JigyoHokokuTokeiDataEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJigyoHokokuTokeiDataが保持するDbT7021JigyoHokokuTokeiDataEntityのEntityDataStateがDeletedに指定されたJigyoHokokuTokeiDataが返る() {
            sut = TestSupport.setStateJigyoHokokuTokeiData(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JigyoHokokuTokeiDataが保持するDbT7021JigyoHokokuTokeiDataEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJigyoHokokuTokeiData(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JigyoHokokuTokeiData setStateJigyoHokokuTokeiData(EntityDataState parentState) {
            JigyoHokokuTokeiDataEntity.setState(parentState);
            return new JigyoHokokuTokeiData(JigyoHokokuTokeiDataEntity);
        }
    }
}
