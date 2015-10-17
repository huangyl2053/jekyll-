/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {@link KogakuGassanJikoFutanGakuMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanJikoFutanGakuMeisaiTest extends DbcTestBase {

    private static DbT3071KogakuGassanJikoFutanGakuMeisaiEntity KogakuGassanJikoFutanGakuMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYear 主キー名2;
    private static HokenshaNo 主キー名3;
    private static RString 主キー名4;
    private static RString 主キー名5;
    private static Decimal 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象年度;
        主キー名3 = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_保険者番号;
        主キー名4 = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_支給申請書整理番号;
        主キー名5 = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_対象月;
        主キー名6 = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGakuMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuMeisaiEntity = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
            KogakuGassanJikoFutanGakuMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuMeisaiEntity.setTaishoNendo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanJikoFutanGakuMeisai(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanJikoFutanGakuMeisai(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3071KogakuGassanJikoFutanGakuMeisaiEntityにセットされている() {
            sut = new KogakuGassanJikoFutanGakuMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get対象年度(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuGassanJikoFutanGakuMeisaiIdentifierにセットされている() {
            sut = new KogakuGassanJikoFutanGakuMeisai(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGakuMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuMeisaiEntity = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
            KogakuGassanJikoFutanGakuMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuMeisaiEntity.setTaishoNendo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuGassanJikoFutanGakuMeisai(null);
        }

        @Test
        public void 指定したDbT3071KogakuGassanJikoFutanGakuMeisaiEntityのキー情報を識別子が持つ() {

            sut = new KogakuGassanJikoFutanGakuMeisai(KogakuGassanJikoFutanGakuMeisaiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGakuMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuMeisaiEntity = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
            KogakuGassanJikoFutanGakuMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuMeisaiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanJikoFutanGakuMeisai(KogakuGassanJikoFutanGakuMeisaiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年度は_entityが持つ対象年度を返す() {
            assertThat(sut.get対象年度(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getTaishoNendo()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getHokenshaNo()));
        }

        @Test
        public void get支給申請書整理番号は_entityが持つ支給申請書整理番号を返す() {
            assertThat(sut.get支給申請書整理番号(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getShikyuShinseishoSeiriNo()));
        }

        @Test
        public void get対象月は_entityが持つ対象月を返す() {
            assertThat(sut.get対象月(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getTaishoM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getRirekiNo()));
        }

        @Test
        public void get自己負担額は_entityが持つ自己負担額を返す() {
            assertThat(sut.get自己負担額(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getJikoFutanGaku()));
        }

        @Test
        public void get70_74自己負担額_内数は_entityが持つ70_74自己負担額_内数を返す() {
            assertThat(sut.get70_74自己負担額_内数(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getUchisu_70_74JikoFutanGaku()));
        }

        @Test
        public void get70未満高額支給額は_entityが持つ70未満高額支給額を返す() {
            assertThat(sut.get70未満高額支給額(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getUnder_70KogakuShikyuGaku()));
        }

        @Test
        public void get70_74高額支給額は_entityが持つ70_74高額支給額を返す() {
            assertThat(sut.get70_74高額支給額(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getOver_70_74KogakuShikyuGaku()));
        }

        @Test
        public void get摘要は_entityが持つ摘要を返す() {
            assertThat(sut.get摘要(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getTekiyo()));
        }

        @Test
        public void get補正済_自己負担額は_entityが持つ補正済_自己負担額を返す() {
            assertThat(sut.get補正済_自己負担額(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getSumi_JikoFutanGaku()));
        }

        @Test
        public void get補正済_70_74自己負担額_内数は_entityが持つ補正済_70_74自己負担額_内数を返す() {
            assertThat(sut.get補正済_70_74自己負担額_内数(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getSumi_70_74JikoFutanGaku()));
        }

        @Test
        public void get補正済_70未満高額支給額は_entityが持つ補正済_70未満高額支給額を返す() {
            assertThat(sut.get補正済_70未満高額支給額(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getSumi_under_70KogakuShikyuGaku()));
        }

        @Test
        public void get補正済_70_74高額支給額は_entityが持つ補正済_70_74高額支給額を返す() {
            assertThat(sut.get補正済_70_74高額支給額(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getSumi_70_74KogakuShikyuGaku()));
        }

        @Test
        public void get補正済_摘要は_entityが持つ補正済_摘要を返す() {
            assertThat(sut.get補正済_摘要(), is(KogakuGassanJikoFutanGakuMeisaiEntity.getSumi_Tekiyo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGakuMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuMeisaiEntity = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
            KogakuGassanJikoFutanGakuMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuMeisaiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanJikoFutanGakuMeisai(KogakuGassanJikoFutanGakuMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuGassanJikoFutanGakuMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGakuMeisai sut;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuMeisaiEntity = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
            KogakuGassanJikoFutanGakuMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuMeisaiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanJikoFutanGakuMeisai(KogakuGassanJikoFutanGakuMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuGassanJikoFutanGakuMeisai sut;
        private static KogakuGassanJikoFutanGakuMeisai result;

        @Before
        public void setUp() {
            KogakuGassanJikoFutanGakuMeisaiEntity = DbT3071KogakuGassanJikoFutanGakuMeisaiEntityGenerator.createDbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
            KogakuGassanJikoFutanGakuMeisaiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanJikoFutanGakuMeisaiEntity.setTaishoNendo(主キー名2);

        }

        @Test
        public void KogakuGassanJikoFutanGakuMeisaiが保持するDbT3071KogakuGassanJikoFutanGakuMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuGassanJikoFutanGakuMeisaiが保持するDbT3071KogakuGassanJikoFutanGakuMeisaiEntityのEntityDataStateがDeletedに指定されたKogakuGassanJikoFutanGakuMeisaiが返る() {
            sut = TestSupport.setStateKogakuGassanJikoFutanGakuMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanJikoFutanGakuMeisaiが保持するDbT3071KogakuGassanJikoFutanGakuMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuGassanJikoFutanGakuMeisaiが保持するDbT3071KogakuGassanJikoFutanGakuMeisaiEntityのEntityDataStateがDeletedに指定されたKogakuGassanJikoFutanGakuMeisaiが返る() {
            sut = TestSupport.setStateKogakuGassanJikoFutanGakuMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanJikoFutanGakuMeisaiが保持するDbT3071KogakuGassanJikoFutanGakuMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuGassanJikoFutanGakuMeisaiが保持するDbT3071KogakuGassanJikoFutanGakuMeisaiEntityのEntityDataStateがDeletedに指定されたKogakuGassanJikoFutanGakuMeisaiが返る() {
            sut = TestSupport.setStateKogakuGassanJikoFutanGakuMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuGassanJikoFutanGakuMeisaiが保持するDbT3071KogakuGassanJikoFutanGakuMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuGassanJikoFutanGakuMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuGassanJikoFutanGakuMeisai setStateKogakuGassanJikoFutanGakuMeisai(EntityDataState parentState) {
            KogakuGassanJikoFutanGakuMeisaiEntity.setState(parentState);
            return new KogakuGassanJikoFutanGakuMeisai(KogakuGassanJikoFutanGakuMeisaiEntity);
        }
    }
}
