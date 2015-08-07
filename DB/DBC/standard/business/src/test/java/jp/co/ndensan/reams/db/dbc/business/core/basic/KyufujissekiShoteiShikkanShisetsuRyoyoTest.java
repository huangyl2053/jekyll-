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
 * {@link KyufujissekiShoteiShikkanShisetsuRyoyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiShoteiShikkanShisetsuRyoyoTest extends DbcTestBase {

    private static DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity KyufujissekiShoteiShikkanShisetsuRyoyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiShoteiShikkanShisetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity = DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShoteiShikkanShisetsuRyoyo(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiShoteiShikkanShisetsuRyoyo(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityにセットされている() {
            sut = new KyufujissekiShoteiShikkanShisetsuRyoyo(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiShoteiShikkanShisetsuRyoyoIdentifierにセットされている() {
            sut = new KyufujissekiShoteiShikkanShisetsuRyoyo(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiShoteiShikkanShisetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity = DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiShoteiShikkanShisetsuRyoyo(null);
        }

        @Test
        public void 指定したDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiShoteiShikkanShisetsuRyoyo(KyufujissekiShoteiShikkanShisetsuRyoyoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiShoteiShikkanShisetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity = DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名2);

            sut = new KyufujissekiShoteiShikkanShisetsuRyoyo(KyufujissekiShoteiShikkanShisetsuRyoyoEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getToshiNo()));
        }

        @Test
        public void get緊急時施設療養情報レコード順次番号は_entityが持つ緊急時施設療養情報レコード順次番号を返す() {
            assertThat(sut.get緊急時施設療養情報レコード順次番号(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getRecodeJunjiNo()));
        }

        @Test
        public void get緊急時傷病名１は_entityが持つ緊急時傷病名１を返す() {
            assertThat(sut.get緊急時傷病名１(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuShobyoName1()));
        }

        @Test
        public void get緊急時傷病名２は_entityが持つ緊急時傷病名２を返す() {
            assertThat(sut.get緊急時傷病名２(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuShobyoName2()));
        }

        @Test
        public void get緊急時傷病名３は_entityが持つ緊急時傷病名３を返す() {
            assertThat(sut.get緊急時傷病名３(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuShobyoName3()));
        }

        @Test
        public void get緊急時治療開始年月日１は_entityが持つ緊急時治療開始年月日１を返す() {
            assertThat(sut.get緊急時治療開始年月日１(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuChiryoKaishiYMD1()));
        }

        @Test
        public void get緊急時治療開始年月日２は_entityが持つ緊急時治療開始年月日２を返す() {
            assertThat(sut.get緊急時治療開始年月日２(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuChiryoKaishiYMD2()));
        }

        @Test
        public void get緊急時治療開始年月日３は_entityが持つ緊急時治療開始年月日３を返す() {
            assertThat(sut.get緊急時治療開始年月日３(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuChiryoKaishiYMD3()));
        }

        @Test
        public void get往診日数は_entityが持つ往診日数を返す() {
            assertThat(sut.get往診日数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getOshinNissu()));
        }

        @Test
        public void get往診医療機関名は_entityが持つ往診医療機関名を返す() {
            assertThat(sut.get往診医療機関名(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getOshinIryoKikanName()));
        }

        @Test
        public void get通院日数は_entityが持つ通院日数を返す() {
            assertThat(sut.get通院日数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTsuinNissu()));
        }

        @Test
        public void get通院医療機関名は_entityが持つ通院医療機関名を返す() {
            assertThat(sut.get通院医療機関名(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTsuinIryoKikanName()));
        }

        @Test
        public void get緊急時治療管理単位数は_entityが持つ緊急時治療管理単位数を返す() {
            assertThat(sut.get緊急時治療管理単位数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuChiryoKanriTanisu()));
        }

        @Test
        public void get緊急時治療管理日数は_entityが持つ緊急時治療管理日数を返す() {
            assertThat(sut.get緊急時治療管理日数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuChiryoKanriNissu()));
        }

        @Test
        public void get緊急時治療管理小計は_entityが持つ緊急時治療管理小計を返す() {
            assertThat(sut.get緊急時治療管理小計(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuChiryoKanriSubTotal()));
        }

        @Test
        public void getリハビリテーション点数は_entityが持つリハビリテーション点数を返す() {
            assertThat(sut.getリハビリテーション点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getRehabilitationTensu()));
        }

        @Test
        public void get処置点数は_entityが持つ処置点数を返す() {
            assertThat(sut.get処置点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShochiTensu()));
        }

        @Test
        public void get手術点数は_entityが持つ手術点数を返す() {
            assertThat(sut.get手術点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShujutsuTensu()));
        }

        @Test
        public void get麻酔点数は_entityが持つ麻酔点数を返す() {
            assertThat(sut.get麻酔点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getMasuiTensu()));
        }

        @Test
        public void get放射線治療点数は_entityが持つ放射線治療点数を返す() {
            assertThat(sut.get放射線治療点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getHoshasenChiryoTensu()));
        }

        @Test
        public void get摘要１は_entityが持つ摘要１を返す() {
            assertThat(sut.get摘要１(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo1()));
        }

        @Test
        public void get摘要２は_entityが持つ摘要２を返す() {
            assertThat(sut.get摘要２(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo2()));
        }

        @Test
        public void get摘要３は_entityが持つ摘要３を返す() {
            assertThat(sut.get摘要３(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo3()));
        }

        @Test
        public void get摘要４は_entityが持つ摘要４を返す() {
            assertThat(sut.get摘要４(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo4()));
        }

        @Test
        public void get摘要５は_entityが持つ摘要５を返す() {
            assertThat(sut.get摘要５(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo5()));
        }

        @Test
        public void get摘要６は_entityが持つ摘要６を返す() {
            assertThat(sut.get摘要６(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo6()));
        }

        @Test
        public void get摘要７は_entityが持つ摘要７を返す() {
            assertThat(sut.get摘要７(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo7()));
        }

        @Test
        public void get摘要８は_entityが持つ摘要８を返す() {
            assertThat(sut.get摘要８(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo8()));
        }

        @Test
        public void get摘要９は_entityが持つ摘要９を返す() {
            assertThat(sut.get摘要９(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo9()));
        }

        @Test
        public void get摘要１０は_entityが持つ摘要１０を返す() {
            assertThat(sut.get摘要１０(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo10()));
        }

        @Test
        public void get摘要１１は_entityが持つ摘要１１を返す() {
            assertThat(sut.get摘要１１(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo11()));
        }

        @Test
        public void get摘要１２は_entityが持つ摘要１２を返す() {
            assertThat(sut.get摘要１２(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo12()));
        }

        @Test
        public void get摘要１３は_entityが持つ摘要１３を返す() {
            assertThat(sut.get摘要１３(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo13()));
        }

        @Test
        public void get摘要１４は_entityが持つ摘要１４を返す() {
            assertThat(sut.get摘要１４(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo14()));
        }

        @Test
        public void get摘要１５は_entityが持つ摘要１５を返す() {
            assertThat(sut.get摘要１５(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo15()));
        }

        @Test
        public void get摘要１６は_entityが持つ摘要１６を返す() {
            assertThat(sut.get摘要１６(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo16()));
        }

        @Test
        public void get摘要１７は_entityが持つ摘要１７を返す() {
            assertThat(sut.get摘要１７(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo17()));
        }

        @Test
        public void get摘要１８は_entityが持つ摘要１８を返す() {
            assertThat(sut.get摘要１８(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo18()));
        }

        @Test
        public void get摘要１９は_entityが持つ摘要１９を返す() {
            assertThat(sut.get摘要１９(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo19()));
        }

        @Test
        public void get摘要２０は_entityが持つ摘要２０を返す() {
            assertThat(sut.get摘要２０(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTekiyo20()));
        }

        @Test
        public void get緊急時施設療養費合計点数は_entityが持つ緊急時施設療養費合計点数を返す() {
            assertThat(sut.get緊急時施設療養費合計点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKinkyuShisetsuRyoyohiTotalTensu()));
        }

        @Test
        public void get所定疾患施設療養費傷病名１は_entityが持つ所定疾患施設療養費傷病名１を返す() {
            assertThat(sut.get所定疾患施設療養費傷病名１(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShoteiShikkanShisetsuRyoyohiShobyoName1()));
        }

        @Test
        public void get所定疾患施設療養費傷病名２は_entityが持つ所定疾患施設療養費傷病名２を返す() {
            assertThat(sut.get所定疾患施設療養費傷病名２(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShoteiShikkanShisetsuRyoyohiShobyoName2()));
        }

        @Test
        public void get所定疾患施設療養費傷病名３は_entityが持つ所定疾患施設療養費傷病名３を返す() {
            assertThat(sut.get所定疾患施設療養費傷病名３(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShoteiShikkanShisetsuRyoyohiShobyoName3()));
        }

        @Test
        public void get所定疾患施設療養費開始年月日１は_entityが持つ所定疾患施設療養費開始年月日１を返す() {
            assertThat(sut.get所定疾患施設療養費開始年月日１(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShoteiShikkanShisetsuRyoyohiKaishiYMD1()));
        }

        @Test
        public void get所定疾患施設療養費開始年月日２は_entityが持つ所定疾患施設療養費開始年月日２を返す() {
            assertThat(sut.get所定疾患施設療養費開始年月日２(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShoteiShikkanShisetsuRyoyohiKaishiYMD2()));
        }

        @Test
        public void get所定疾患施設療養費開始年月日３は_entityが持つ所定疾患施設療養費開始年月日３を返す() {
            assertThat(sut.get所定疾患施設療養費開始年月日３(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShoteiShikkanShisetsuRyoyohiKaishiYMD3()));
        }

        @Test
        public void get所定疾患施設療養費単位数は_entityが持つ所定疾患施設療養費単位数を返す() {
            assertThat(sut.get所定疾患施設療養費単位数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShoteiShikkanShisetsuRyoyohiTanisu()));
        }

        @Test
        public void get所定疾患施設療養費日数は_entityが持つ所定疾患施設療養費日数を返す() {
            assertThat(sut.get所定疾患施設療養費日数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShoteiShikkanShisetsuRyoyohiNissu()));
        }

        @Test
        public void get所定疾患施設療養費小計は_entityが持つ所定疾患施設療養費小計を返す() {
            assertThat(sut.get所定疾患施設療養費小計(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShoteiShikkanShisetsuRyoyohiSubTotal()));
        }

        @Test
        public void get後・往診日数は_entityが持つ後・往診日数を返す() {
            assertThat(sut.get後・往診日数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoOshinNissu()));
        }

        @Test
        public void get後・通院日数は_entityが持つ後・通院日数を返す() {
            assertThat(sut.get後・通院日数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoTsuinNissu()));
        }

        @Test
        public void get後・緊急時治療管理単位数は_entityが持つ後・緊急時治療管理単位数を返す() {
            assertThat(sut.get後・緊急時治療管理単位数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoKinkyuChiryoKanriTanisu()));
        }

        @Test
        public void get後・緊急時治療管理日数は_entityが持つ後・緊急時治療管理日数を返す() {
            assertThat(sut.get後・緊急時治療管理日数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoKinkyuChiryoKanriNissu()));
        }

        @Test
        public void get後・リハビリテーション点数は_entityが持つ後・リハビリテーション点数を返す() {
            assertThat(sut.get後・リハビリテーション点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoRehabilitationTensu()));
        }

        @Test
        public void get後・処置点数は_entityが持つ後・処置点数を返す() {
            assertThat(sut.get後・処置点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoShochiTensu()));
        }

        @Test
        public void get後・手術点数は_entityが持つ後・手術点数を返す() {
            assertThat(sut.get後・手術点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoShujutsuTensu()));
        }

        @Test
        public void get後・麻酔点数は_entityが持つ後・麻酔点数を返す() {
            assertThat(sut.get後・麻酔点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoMasuiTensu()));
        }

        @Test
        public void get後・放射線治療点数は_entityが持つ後・放射線治療点数を返す() {
            assertThat(sut.get後・放射線治療点数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoHoshasenChiryoTensu()));
        }

        @Test
        public void get後・所定疾患施設療養費単位数は_entityが持つ後・所定疾患施設療養費単位数を返す() {
            assertThat(sut.get後・所定疾患施設療養費単位数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoShoteiShikkanShisetsuRyoyoHiTanisu()));
        }

        @Test
        public void get後・所定疾患施設療養費日数は_entityが持つ後・所定疾患施設療養費日数を返す() {
            assertThat(sut.get後・所定疾患施設療養費日数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getAtoShoteiShikkanShisetsuRyoyoHiNissu()));
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiShoteiShikkanShisetsuRyoyoEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiShoteiShikkanShisetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity = DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名2);

            sut = new KyufujissekiShoteiShikkanShisetsuRyoyo(KyufujissekiShoteiShikkanShisetsuRyoyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiShoteiShikkanShisetsuRyoyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiShoteiShikkanShisetsuRyoyo sut;

        @Before
        public void setUp() {
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity = DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名2);

            sut = new KyufujissekiShoteiShikkanShisetsuRyoyo(KyufujissekiShoteiShikkanShisetsuRyoyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiShoteiShikkanShisetsuRyoyo sut;
        private static KyufujissekiShoteiShikkanShisetsuRyoyo result;

        @Before
        public void setUp() {
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity = DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityGenerator.createDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名1);
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setXXX(主キー名2);

        }

        @Test
        public void KyufujissekiShoteiShikkanShisetsuRyoyoが保持するDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiShoteiShikkanShisetsuRyoyoが保持するDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiShoteiShikkanShisetsuRyoyoが返る() {
            sut = TestSupport.setStateKyufujissekiShoteiShikkanShisetsuRyoyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiShoteiShikkanShisetsuRyoyoが保持するDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiShoteiShikkanShisetsuRyoyoが保持するDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiShoteiShikkanShisetsuRyoyoが返る() {
            sut = TestSupport.setStateKyufujissekiShoteiShikkanShisetsuRyoyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiShoteiShikkanShisetsuRyoyoが保持するDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiShoteiShikkanShisetsuRyoyoが保持するDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityのEntityDataStateがDeletedに指定されたKyufujissekiShoteiShikkanShisetsuRyoyoが返る() {
            sut = TestSupport.setStateKyufujissekiShoteiShikkanShisetsuRyoyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiShoteiShikkanShisetsuRyoyoが保持するDbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiShoteiShikkanShisetsuRyoyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiShoteiShikkanShisetsuRyoyo setStateKyufujissekiShoteiShikkanShisetsuRyoyo(EntityDataState parentState) {
            KyufujissekiShoteiShikkanShisetsuRyoyoEntity.setState(parentState);
            return new KyufujissekiShoteiShikkanShisetsuRyoyo(KyufujissekiShoteiShikkanShisetsuRyoyoEntity);
        }
    }
}
