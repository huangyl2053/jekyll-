/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link ShokanKinkyuShisetsuRyoyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanKinkyuShisetsuRyoyoTest extends DbcTestBase {

    private static DbT3040ShokanKinkyuShisetsuRyoyoEntity ShokanKinkyuShisetsuRyoyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;
    private static RString 主キー名7;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_明細番号;
        主キー名7 = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_連番;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanKinkyuShisetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanKinkyuShisetsuRyoyoEntity = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.createDbT3040ShokanKinkyuShisetsuRyoyoEntity();
            ShokanKinkyuShisetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanKinkyuShisetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanKinkyuShisetsuRyoyo(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanKinkyuShisetsuRyoyo(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test
        public void 指定したキーが保持するDbT3040ShokanKinkyuShisetsuRyoyoEntityにセットされている() {
            sut = new ShokanKinkyuShisetsuRyoyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanKinkyuShisetsuRyoyoIdentifierにセットされている() {
            sut = new ShokanKinkyuShisetsuRyoyo(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanKinkyuShisetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanKinkyuShisetsuRyoyoEntity = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.createDbT3040ShokanKinkyuShisetsuRyoyoEntity();
            ShokanKinkyuShisetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanKinkyuShisetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanKinkyuShisetsuRyoyo(null);
        }

        @Test
        public void 指定したDbT3040ShokanKinkyuShisetsuRyoyoEntityのキー情報を識別子が持つ() {

            sut = new ShokanKinkyuShisetsuRyoyo(ShokanKinkyuShisetsuRyoyoEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanKinkyuShisetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanKinkyuShisetsuRyoyoEntity = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.createDbT3040ShokanKinkyuShisetsuRyoyoEntity();
            ShokanKinkyuShisetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanKinkyuShisetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanKinkyuShisetsuRyoyo(ShokanKinkyuShisetsuRyoyoEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanKinkyuShisetsuRyoyoEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanKinkyuShisetsuRyoyoEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanKinkyuShisetsuRyoyoEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanKinkyuShisetsuRyoyoEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanKinkyuShisetsuRyoyoEntity.getYoshikiNo()));
        }

        @Test
        public void get明細番号は_entityが持つ明細番号を返す() {
            assertThat(sut.get明細番号(), is(ShokanKinkyuShisetsuRyoyoEntity.getMeisaiNo()));
        }

        @Test
        public void get連番は_entityが持つ連番を返す() {
            assertThat(sut.get連番(), is(ShokanKinkyuShisetsuRyoyoEntity.getRenban()));
        }

        @Test
        public void get緊急時傷病名１は_entityが持つ緊急時傷病名１を返す() {
            assertThat(sut.get緊急時傷病名１(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuShobyoName1()));
        }

        @Test
        public void get緊急時傷病名２は_entityが持つ緊急時傷病名２を返す() {
            assertThat(sut.get緊急時傷病名２(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuShobyoName2()));
        }

        @Test
        public void get緊急時傷病名３は_entityが持つ緊急時傷病名３を返す() {
            assertThat(sut.get緊急時傷病名３(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuShobyoName3()));
        }

        @Test
        public void get緊急時治療開始年月日１は_entityが持つ緊急時治療開始年月日１を返す() {
            assertThat(sut.get緊急時治療開始年月日１(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuChiryoKaishiYMD1()));
        }

        @Test
        public void get緊急時治療開始年月日２は_entityが持つ緊急時治療開始年月日２を返す() {
            assertThat(sut.get緊急時治療開始年月日２(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuChiryoKaishiYMD2()));
        }

        @Test
        public void get緊急時治療開始年月日３は_entityが持つ緊急時治療開始年月日３を返す() {
            assertThat(sut.get緊急時治療開始年月日３(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuChiryoKaishiYMD3()));
        }

        @Test
        public void get往診日数は_entityが持つ往診日数を返す() {
            assertThat(sut.get往診日数(), is(ShokanKinkyuShisetsuRyoyoEntity.getOshinNissu()));
        }

        @Test
        public void get往診医療機関名は_entityが持つ往診医療機関名を返す() {
            assertThat(sut.get往診医療機関名(), is(ShokanKinkyuShisetsuRyoyoEntity.getOshinIryoKikanName()));
        }

        @Test
        public void get通院日数は_entityが持つ通院日数を返す() {
            assertThat(sut.get通院日数(), is(ShokanKinkyuShisetsuRyoyoEntity.getTsuinNissu()));
        }

        @Test
        public void get通院医療機関名は_entityが持つ通院医療機関名を返す() {
            assertThat(sut.get通院医療機関名(), is(ShokanKinkyuShisetsuRyoyoEntity.getTsuinKikanName()));
        }

        @Test
        public void get緊急時治療管理単位数は_entityが持つ緊急時治療管理単位数を返す() {
            assertThat(sut.get緊急時治療管理単位数(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuChiryoKanriTanisu()));
        }

        @Test
        public void get緊急時治療管理日数は_entityが持つ緊急時治療管理日数を返す() {
            assertThat(sut.get緊急時治療管理日数(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuChiryoKanriNissu()));
        }

        @Test
        public void get緊急時治療管理小計は_entityが持つ緊急時治療管理小計を返す() {
            assertThat(sut.get緊急時治療管理小計(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuChiryoKanriSubTotal()));
        }

        @Test
        public void getリハビリテーション単位数は_entityが持つリハビリテーション単位数を返す() {
            assertThat(sut.getリハビリテーション単位数(), is(ShokanKinkyuShisetsuRyoyoEntity.getRehabilitationTanisu()));
        }

        @Test
        public void get処置単位数は_entityが持つ処置単位数を返す() {
            assertThat(sut.get処置単位数(), is(ShokanKinkyuShisetsuRyoyoEntity.getShochiTanisu()));
        }

        @Test
        public void get手術単位数は_entityが持つ手術単位数を返す() {
            assertThat(sut.get手術単位数(), is(ShokanKinkyuShisetsuRyoyoEntity.getShujutsuTanisu()));
        }

        @Test
        public void get麻酔単位数は_entityが持つ麻酔単位数を返す() {
            assertThat(sut.get麻酔単位数(), is(ShokanKinkyuShisetsuRyoyoEntity.getMasuiTanisu()));
        }

        @Test
        public void get放射線治療単位数は_entityが持つ放射線治療単位数を返す() {
            assertThat(sut.get放射線治療単位数(), is(ShokanKinkyuShisetsuRyoyoEntity.getHoshasenChiryoTanisu()));
        }

        @Test
        public void get摘要１は_entityが持つ摘要１を返す() {
            assertThat(sut.get摘要１(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo1()));
        }

        @Test
        public void get摘要２は_entityが持つ摘要２を返す() {
            assertThat(sut.get摘要２(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo2()));
        }

        @Test
        public void get摘要３は_entityが持つ摘要３を返す() {
            assertThat(sut.get摘要３(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo3()));
        }

        @Test
        public void get摘要４は_entityが持つ摘要４を返す() {
            assertThat(sut.get摘要４(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo4()));
        }

        @Test
        public void get摘要５は_entityが持つ摘要５を返す() {
            assertThat(sut.get摘要５(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo5()));
        }

        @Test
        public void get摘要６は_entityが持つ摘要６を返す() {
            assertThat(sut.get摘要６(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo6()));
        }

        @Test
        public void get摘要７は_entityが持つ摘要７を返す() {
            assertThat(sut.get摘要７(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo7()));
        }

        @Test
        public void get摘要８は_entityが持つ摘要８を返す() {
            assertThat(sut.get摘要８(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo8()));
        }

        @Test
        public void get摘要９は_entityが持つ摘要９を返す() {
            assertThat(sut.get摘要９(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo9()));
        }

        @Test
        public void get摘要１０は_entityが持つ摘要１０を返す() {
            assertThat(sut.get摘要１０(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo10()));
        }

        @Test
        public void get摘要１１は_entityが持つ摘要１１を返す() {
            assertThat(sut.get摘要１１(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo11()));
        }

        @Test
        public void get摘要１２は_entityが持つ摘要１２を返す() {
            assertThat(sut.get摘要１２(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo12()));
        }

        @Test
        public void get摘要１３は_entityが持つ摘要１３を返す() {
            assertThat(sut.get摘要１３(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo13()));
        }

        @Test
        public void get摘要１４は_entityが持つ摘要１４を返す() {
            assertThat(sut.get摘要１４(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo14()));
        }

        @Test
        public void get摘要１５は_entityが持つ摘要１５を返す() {
            assertThat(sut.get摘要１５(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo15()));
        }

        @Test
        public void get摘要１６は_entityが持つ摘要１６を返す() {
            assertThat(sut.get摘要１６(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo16()));
        }

        @Test
        public void get摘要１７は_entityが持つ摘要１７を返す() {
            assertThat(sut.get摘要１７(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo17()));
        }

        @Test
        public void get摘要１８は_entityが持つ摘要１８を返す() {
            assertThat(sut.get摘要１８(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo18()));
        }

        @Test
        public void get摘要１９は_entityが持つ摘要１９を返す() {
            assertThat(sut.get摘要１９(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo19()));
        }

        @Test
        public void get摘要２０は_entityが持つ摘要２０を返す() {
            assertThat(sut.get摘要２０(), is(ShokanKinkyuShisetsuRyoyoEntity.getTekiyo20()));
        }

        @Test
        public void get緊急時施設療養費合計単位数は_entityが持つ緊急時施設療養費合計単位数を返す() {
            assertThat(sut.get緊急時施設療養費合計単位数(), is(ShokanKinkyuShisetsuRyoyoEntity.getKinkyuShisetsuRyoyohiTotalTanisu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanKinkyuShisetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanKinkyuShisetsuRyoyoEntity = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.createDbT3040ShokanKinkyuShisetsuRyoyoEntity();
            ShokanKinkyuShisetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanKinkyuShisetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanKinkyuShisetsuRyoyo(ShokanKinkyuShisetsuRyoyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanKinkyuShisetsuRyoyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanKinkyuShisetsuRyoyo sut;

        @Before
        public void setUp() {
            ShokanKinkyuShisetsuRyoyoEntity = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.createDbT3040ShokanKinkyuShisetsuRyoyoEntity();
            ShokanKinkyuShisetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanKinkyuShisetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanKinkyuShisetsuRyoyo(ShokanKinkyuShisetsuRyoyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanKinkyuShisetsuRyoyo sut;
        private static ShokanKinkyuShisetsuRyoyo result;

        @Before
        public void setUp() {
            ShokanKinkyuShisetsuRyoyoEntity = DbT3040ShokanKinkyuShisetsuRyoyoEntityGenerator.createDbT3040ShokanKinkyuShisetsuRyoyoEntity();
            ShokanKinkyuShisetsuRyoyoEntity.setHiHokenshaNo(主キー名1);
            ShokanKinkyuShisetsuRyoyoEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanKinkyuShisetsuRyoyoが保持するDbT3040ShokanKinkyuShisetsuRyoyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanKinkyuShisetsuRyoyoが保持するDbT3040ShokanKinkyuShisetsuRyoyoEntityのEntityDataStateがDeletedに指定されたShokanKinkyuShisetsuRyoyoが返る() {
            sut = TestSupport.setStateShokanKinkyuShisetsuRyoyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanKinkyuShisetsuRyoyoが保持するDbT3040ShokanKinkyuShisetsuRyoyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanKinkyuShisetsuRyoyoが保持するDbT3040ShokanKinkyuShisetsuRyoyoEntityのEntityDataStateがDeletedに指定されたShokanKinkyuShisetsuRyoyoが返る() {
            sut = TestSupport.setStateShokanKinkyuShisetsuRyoyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanKinkyuShisetsuRyoyoが保持するDbT3040ShokanKinkyuShisetsuRyoyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanKinkyuShisetsuRyoyoが保持するDbT3040ShokanKinkyuShisetsuRyoyoEntityのEntityDataStateがDeletedに指定されたShokanKinkyuShisetsuRyoyoが返る() {
            sut = TestSupport.setStateShokanKinkyuShisetsuRyoyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanKinkyuShisetsuRyoyoが保持するDbT3040ShokanKinkyuShisetsuRyoyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanKinkyuShisetsuRyoyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanKinkyuShisetsuRyoyo setStateShokanKinkyuShisetsuRyoyo(EntityDataState parentState) {
            ShokanKinkyuShisetsuRyoyoEntity.setState(parentState);
            return new ShokanKinkyuShisetsuRyoyo(ShokanKinkyuShisetsuRyoyoEntity);
        }
    }
}
