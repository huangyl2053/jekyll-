/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiTokuteiSinryohiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiTokuteiSinryohiBuilderTest extends DbcTestBase {

    private static DbT3020KyufujissekiTokuteiSinryohiEntity KyufujissekiTokuteiSinryohiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyufujissekiTokuteiSinryohiBuilder sut;
        private static KyufujissekiTokuteiSinryohi business;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryohiEntity = new DbT3020KyufujissekiTokuteiSinryohiEntity();
            KyufujissekiTokuteiSinryohiEntity.setXXX(主キー名1);
            KyufujissekiTokuteiSinryohiEntity.setXXX(主キー名2);

            business = new KyufujissekiTokuteiSinryohi(KyufujissekiTokuteiSinryohiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の特定診療情報レコード順次番号は_設定した値と同じ特定診療情報レコード順次番号を返す() {
            business = sut.set特定診療情報レコード順次番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_特定診療情報レコード順次番号).build();
            assertThat(business.get特定診療情報レコード順次番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_特定診療情報レコード順次番号));
        }

        @Test
        public void 戻り値の傷病名は_設定した値と同じ傷病名を返す() {
            business = sut.set傷病名(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_傷病名).build();
            assertThat(business.get傷病名(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_傷病名));
        }

        @Test
        public void 戻り値の保険・指導管理料等は_設定した値と同じ保険・指導管理料等を返す() {
            business = sut.set保険・指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・指導管理料等).build();
            assertThat(business.get保険・指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・指導管理料等));
        }

        @Test
        public void 戻り値の保険・単純エックス線は_設定した値と同じ保険・単純エックス線を返す() {
            business = sut.set保険・単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・単純エックス線).build();
            assertThat(business.get保険・単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・単純エックス線));
        }

        @Test
        public void 戻り値の保険・リハビリテーションは_設定した値と同じ保険・リハビリテーションを返す() {
            business = sut.set保険・リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・リハビリテーション).build();
            assertThat(business.get保険・リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・リハビリテーション));
        }

        @Test
        public void 戻り値の保険・精神科専門療法は_設定した値と同じ保険・精神科専門療法を返す() {
            business = sut.set保険・精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・精神科専門療法).build();
            assertThat(business.get保険・精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・精神科専門療法));
        }

        @Test
        public void 戻り値の保険・合計単位数は_設定した値と同じ保険・合計単位数を返す() {
            business = sut.set保険・合計単位数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・合計単位数).build();
            assertThat(business.get保険・合計単位数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険・合計単位数));
        }

        @Test
        public void 戻り値の公費１・指導管理料等は_設定した値と同じ公費１・指導管理料等を返す() {
            business = sut.set公費１・指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・指導管理料等).build();
            assertThat(business.get公費１・指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・指導管理料等));
        }

        @Test
        public void 戻り値の公費１・単純エックス線は_設定した値と同じ公費１・単純エックス線を返す() {
            business = sut.set公費１・単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・単純エックス線).build();
            assertThat(business.get公費１・単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・単純エックス線));
        }

        @Test
        public void 戻り値の公費１・リハビリテーションは_設定した値と同じ公費１・リハビリテーションを返す() {
            business = sut.set公費１・リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・リハビリテーション).build();
            assertThat(business.get公費１・リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・リハビリテーション));
        }

        @Test
        public void 戻り値の公費１・精神科専門療法は_設定した値と同じ公費１・精神科専門療法を返す() {
            business = sut.set公費１・精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・精神科専門療法).build();
            assertThat(business.get公費１・精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・精神科専門療法));
        }

        @Test
        public void 戻り値の公費１・合計単位数は_設定した値と同じ公費１・合計単位数を返す() {
            business = sut.set公費１・合計単位数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・合計単位数).build();
            assertThat(business.get公費１・合計単位数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１・合計単位数));
        }

        @Test
        public void 戻り値の公費２・指導管理料等は_設定した値と同じ公費２・指導管理料等を返す() {
            business = sut.set公費２・指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・指導管理料等).build();
            assertThat(business.get公費２・指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・指導管理料等));
        }

        @Test
        public void 戻り値の公費２・単純エックス線は_設定した値と同じ公費２・単純エックス線を返す() {
            business = sut.set公費２・単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・単純エックス線).build();
            assertThat(business.get公費２・単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・単純エックス線));
        }

        @Test
        public void 戻り値の公費２・リハビリテーションは_設定した値と同じ公費２・リハビリテーションを返す() {
            business = sut.set公費２・リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・リハビリテーション).build();
            assertThat(business.get公費２・リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・リハビリテーション));
        }

        @Test
        public void 戻り値の公費２・精神科専門療法は_設定した値と同じ公費２・精神科専門療法を返す() {
            business = sut.set公費２・精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・精神科専門療法).build();
            assertThat(business.get公費２・精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・精神科専門療法));
        }

        @Test
        public void 戻り値の公費２・合計単位数は_設定した値と同じ公費２・合計単位数を返す() {
            business = sut.set公費２・合計単位数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・合計単位数).build();
            assertThat(business.get公費２・合計単位数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２・合計単位数));
        }

        @Test
        public void 戻り値の公費３・指導管理料等は_設定した値と同じ公費３・指導管理料等を返す() {
            business = sut.set公費３・指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・指導管理料等).build();
            assertThat(business.get公費３・指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・指導管理料等));
        }

        @Test
        public void 戻り値の公費３・単純エックス線は_設定した値と同じ公費３・単純エックス線を返す() {
            business = sut.set公費３・単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・単純エックス線).build();
            assertThat(business.get公費３・単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・単純エックス線));
        }

        @Test
        public void 戻り値の公費３・リハビリテーションは_設定した値と同じ公費３・リハビリテーションを返す() {
            business = sut.set公費３・リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・リハビリテーション).build();
            assertThat(business.get公費３・リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・リハビリテーション));
        }

        @Test
        public void 戻り値の公費３・精神科専門療法は_設定した値と同じ公費３・精神科専門療法を返す() {
            business = sut.set公費３・精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・精神科専門療法).build();
            assertThat(business.get公費３・精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・精神科専門療法));
        }

        @Test
        public void 戻り値の公費３・合計単位数は_設定した値と同じ公費３・合計単位数を返す() {
            business = sut.set公費３・合計単位数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・合計単位数).build();
            assertThat(business.get公費３・合計単位数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３・合計単位数));
        }

        @Test
        public void 戻り値の摘要１は_設定した値と同じ摘要１を返す() {
            business = sut.set摘要１(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１).build();
            assertThat(business.get摘要１(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１));
        }

        @Test
        public void 戻り値の摘要２は_設定した値と同じ摘要２を返す() {
            business = sut.set摘要２(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要２).build();
            assertThat(business.get摘要２(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要２));
        }

        @Test
        public void 戻り値の摘要３は_設定した値と同じ摘要３を返す() {
            business = sut.set摘要３(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要３).build();
            assertThat(business.get摘要３(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要３));
        }

        @Test
        public void 戻り値の摘要４は_設定した値と同じ摘要４を返す() {
            business = sut.set摘要４(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要４).build();
            assertThat(business.get摘要４(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要４));
        }

        @Test
        public void 戻り値の摘要５は_設定した値と同じ摘要５を返す() {
            business = sut.set摘要５(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要５).build();
            assertThat(business.get摘要５(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要５));
        }

        @Test
        public void 戻り値の摘要６は_設定した値と同じ摘要６を返す() {
            business = sut.set摘要６(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要６).build();
            assertThat(business.get摘要６(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要６));
        }

        @Test
        public void 戻り値の摘要７は_設定した値と同じ摘要７を返す() {
            business = sut.set摘要７(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要７).build();
            assertThat(business.get摘要７(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要７));
        }

        @Test
        public void 戻り値の摘要８は_設定した値と同じ摘要８を返す() {
            business = sut.set摘要８(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要８).build();
            assertThat(business.get摘要８(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要８));
        }

        @Test
        public void 戻り値の摘要９は_設定した値と同じ摘要９を返す() {
            business = sut.set摘要９(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要９).build();
            assertThat(business.get摘要９(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要９));
        }

        @Test
        public void 戻り値の摘要１０は_設定した値と同じ摘要１０を返す() {
            business = sut.set摘要１０(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１０).build();
            assertThat(business.get摘要１０(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１０));
        }

        @Test
        public void 戻り値の摘要１１は_設定した値と同じ摘要１１を返す() {
            business = sut.set摘要１１(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１１).build();
            assertThat(business.get摘要１１(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１１));
        }

        @Test
        public void 戻り値の摘要１２は_設定した値と同じ摘要１２を返す() {
            business = sut.set摘要１２(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１２).build();
            assertThat(business.get摘要１２(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１２));
        }

        @Test
        public void 戻り値の摘要１３は_設定した値と同じ摘要１３を返す() {
            business = sut.set摘要１３(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１３).build();
            assertThat(business.get摘要１３(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１３));
        }

        @Test
        public void 戻り値の摘要１４は_設定した値と同じ摘要１４を返す() {
            business = sut.set摘要１４(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１４).build();
            assertThat(business.get摘要１４(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１４));
        }

        @Test
        public void 戻り値の摘要１５は_設定した値と同じ摘要１５を返す() {
            business = sut.set摘要１５(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１５).build();
            assertThat(business.get摘要１５(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１５));
        }

        @Test
        public void 戻り値の摘要１６は_設定した値と同じ摘要１６を返す() {
            business = sut.set摘要１６(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１６).build();
            assertThat(business.get摘要１６(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１６));
        }

        @Test
        public void 戻り値の摘要１７は_設定した値と同じ摘要１７を返す() {
            business = sut.set摘要１７(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１７).build();
            assertThat(business.get摘要１７(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１７));
        }

        @Test
        public void 戻り値の摘要１８は_設定した値と同じ摘要１８を返す() {
            business = sut.set摘要１８(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１８).build();
            assertThat(business.get摘要１８(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１８));
        }

        @Test
        public void 戻り値の摘要１９は_設定した値と同じ摘要１９を返す() {
            business = sut.set摘要１９(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１９).build();
            assertThat(business.get摘要１９(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１９));
        }

        @Test
        public void 戻り値の摘要２０は_設定した値と同じ摘要２０を返す() {
            business = sut.set摘要２０(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要２０).build();
            assertThat(business.get摘要２０(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要２０));
        }

        @Test
        public void 戻り値の後・保険・指導管理料等は_設定した値と同じ後・保険・指導管理料等を返す() {
            business = sut.set後・保険・指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・保険・指導管理料等).build();
            assertThat(business.get後・保険・指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・保険・指導管理料等));
        }

        @Test
        public void 戻り値の後・保険・単純エックス線は_設定した値と同じ後・保険・単純エックス線を返す() {
            business = sut.set後・保険・単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・保険・単純エックス線).build();
            assertThat(business.get後・保険・単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・保険・単純エックス線));
        }

        @Test
        public void 戻り値の後・保険・リハビリテーションは_設定した値と同じ後・保険・リハビリテーションを返す() {
            business = sut.set後・保険・リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・保険・リハビリテーション).build();
            assertThat(business.get後・保険・リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・保険・リハビリテーション));
        }

        @Test
        public void 戻り値の後・保険・精神科専門療法は_設定した値と同じ後・保険・精神科専門療法を返す() {
            business = sut.set後・保険・精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・保険・精神科専門療法).build();
            assertThat(business.get後・保険・精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・保険・精神科専門療法));
        }

        @Test
        public void 戻り値の後・公費１・指導管理料等は_設定した値と同じ後・公費１・指導管理料等を返す() {
            business = sut.set後・公費１・指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費１・指導管理料等).build();
            assertThat(business.get後・公費１・指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費１・指導管理料等));
        }

        @Test
        public void 戻り値の後・公費１・単純エックス線は_設定した値と同じ後・公費１・単純エックス線を返す() {
            business = sut.set後・公費１・単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費１・単純エックス線).build();
            assertThat(business.get後・公費１・単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費１・単純エックス線));
        }

        @Test
        public void 戻り値の後・公費１・リハビリテーションは_設定した値と同じ後・公費１・リハビリテーションを返す() {
            business = sut.set後・公費１・リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費１・リハビリテーション).build();
            assertThat(business.get後・公費１・リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費１・リハビリテーション));
        }

        @Test
        public void 戻り値の後・公費１・精神科専門療法は_設定した値と同じ後・公費１・精神科専門療法を返す() {
            business = sut.set後・公費１・精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費１・精神科専門療法).build();
            assertThat(business.get後・公費１・精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費１・精神科専門療法));
        }

        @Test
        public void 戻り値の後・公費２・指導管理料等は_設定した値と同じ後・公費２・指導管理料等を返す() {
            business = sut.set後・公費２・指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費２・指導管理料等).build();
            assertThat(business.get後・公費２・指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費２・指導管理料等));
        }

        @Test
        public void 戻り値の後・公費２・単純エックス線は_設定した値と同じ後・公費２・単純エックス線を返す() {
            business = sut.set後・公費２・単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費２・単純エックス線).build();
            assertThat(business.get後・公費２・単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費２・単純エックス線));
        }

        @Test
        public void 戻り値の後・公費２・リハビリテーションは_設定した値と同じ後・公費２・リハビリテーションを返す() {
            business = sut.set後・公費２・リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費２・リハビリテーション).build();
            assertThat(business.get後・公費２・リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費２・リハビリテーション));
        }

        @Test
        public void 戻り値の後・公費２・精神科専門療法は_設定した値と同じ後・公費２・精神科専門療法を返す() {
            business = sut.set後・公費２・精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費２・精神科専門療法).build();
            assertThat(business.get後・公費２・精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費２・精神科専門療法));
        }

        @Test
        public void 戻り値の後・公費３・指導管理料等は_設定した値と同じ後・公費３・指導管理料等を返す() {
            business = sut.set後・公費３・指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費３・指導管理料等).build();
            assertThat(business.get後・公費３・指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費３・指導管理料等));
        }

        @Test
        public void 戻り値の後・公費３・単純エックス線は_設定した値と同じ後・公費３・単純エックス線を返す() {
            business = sut.set後・公費３・単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費３・単純エックス線).build();
            assertThat(business.get後・公費３・単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費３・単純エックス線));
        }

        @Test
        public void 戻り値の後・公費３・リハビリテーションは_設定した値と同じ後・公費３・リハビリテーションを返す() {
            business = sut.set後・公費３・リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費３・リハビリテーション).build();
            assertThat(business.get後・公費３・リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費３・リハビリテーション));
        }

        @Test
        public void 戻り値の後・公費３・精神科専門療法は_設定した値と同じ後・公費３・精神科専門療法を返す() {
            business = sut.set後・公費３・精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費３・精神科専門療法).build();
            assertThat(business.get後・公費３・精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後・公費３・精神科専門療法));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_取込年月));
        }

    }
}
