/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3020KyufujissekiTokuteiSinryohiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufujissekiTokuteiSinryohiModel}のテストクラスです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class KyufujissekiTokuteiSinryohiModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KyufujissekiTokuteiSinryohiModel sut;

        @BeforeClass
        public static void test() {
            sut = new KyufujissekiTokuteiSinryohiModel();
        }

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            sut.set交換情報識別番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_交換情報識別番号);
            assertThat(sut.get交換情報識別番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            sut.set入力識別番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_入力識別番号);
            assertThat(sut.get入力識別番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            sut.setレコード種別コード(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_レコード種別コード);
            assertThat(sut.getレコード種別コード(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            sut.setサービス提供年月(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_サービス提供年月);
            assertThat(sut.getサービス提供年月(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            sut.set事業所番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_事業所番号);
            assertThat(sut.get事業所番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            sut.set通し番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_通し番号);
            assertThat(sut.get通し番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の特定診療情報レコード順次番号は_設定した値と同じ特定診療情報レコード順次番号を返す() {
            sut.set特定診療情報レコード順次番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_特定診療情報レコード順次番号);
            assertThat(sut.get特定診療情報レコード順次番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_特定診療情報レコード順次番号));
        }

        @Test
        public void 戻り値の傷病名は_設定した値と同じ傷病名を返す() {
            sut.set傷病名(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_傷病名);
            assertThat(sut.get傷病名(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_傷病名));
        }

        @Test
        public void 戻り値の保険_指導管理料等は_設定した値と同じ保険_指導管理料等を返す() {
            sut.set保険_指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_指導管理料等);
            assertThat(sut.get保険_指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_指導管理料等));
        }

        @Test
        public void 戻り値の保険_単純エックス線は_設定した値と同じ保険_単純エックス線を返す() {
            sut.set保険_単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_単純エックス線);
            assertThat(sut.get保険_単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_単純エックス線));
        }

        @Test
        public void 戻り値の保険_リハビリテーションは_設定した値と同じ保険_リハビリテーションを返す() {
            sut.set保険_リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_リハビリテーション);
            assertThat(sut.get保険_リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_リハビリテーション));
        }

        @Test
        public void 戻り値の保険_精神科専門療法は_設定した値と同じ保険_精神科専門療法を返す() {
            sut.set保険_精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_精神科専門療法);
            assertThat(sut.get保険_精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_精神科専門療法));
        }

        @Test
        public void 戻り値の保険_合計単位数は_設定した値と同じ保険_合計単位数を返す() {
            sut.set保険_合計単位数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_合計単位数);
            assertThat(sut.get保険_合計単位数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_保険_合計単位数));
        }

        @Test
        public void 戻り値の公費１_指導管理料等は_設定した値と同じ公費１_指導管理料等を返す() {
            sut.set公費１_指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_指導管理料等);
            assertThat(sut.get公費１_指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_指導管理料等));
        }

        @Test
        public void 戻り値の公費１_単純エックス線は_設定した値と同じ公費１_単純エックス線を返す() {
            sut.set公費１_単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_単純エックス線);
            assertThat(sut.get公費１_単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_単純エックス線));
        }

        @Test
        public void 戻り値の公費１_リハビリテーションは_設定した値と同じ公費１_リハビリテーションを返す() {
            sut.set公費１_リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_リハビリテーション);
            assertThat(sut.get公費１_リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_リハビリテーション));
        }

        @Test
        public void 戻り値の公費１_精神科専門療法は_設定した値と同じ公費１_精神科専門療法を返す() {
            sut.set公費１_精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_精神科専門療法);
            assertThat(sut.get公費１_精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_精神科専門療法));
        }

        @Test
        public void 戻り値の公費１_合計単位数は_設定した値と同じ公費１_合計単位数を返す() {
            sut.set公費１_合計単位数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_合計単位数);
            assertThat(sut.get公費１_合計単位数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費１_合計単位数));
        }

        @Test
        public void 戻り値の公費２_指導管理料等は_設定した値と同じ公費２_指導管理料等を返す() {
            sut.set公費２_指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_指導管理料等);
            assertThat(sut.get公費２_指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_指導管理料等));
        }

        @Test
        public void 戻り値の公費２_単純エックス線は_設定した値と同じ公費２_単純エックス線を返す() {
            sut.set公費２_単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_単純エックス線);
            assertThat(sut.get公費２_単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_単純エックス線));
        }

        @Test
        public void 戻り値の公費２_リハビリテーションは_設定した値と同じ公費２_リハビリテーションを返す() {
            sut.set公費２_リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_リハビリテーション);
            assertThat(sut.get公費２_リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_リハビリテーション));
        }

        @Test
        public void 戻り値の公費２_精神科専門療法は_設定した値と同じ公費２_精神科専門療法を返す() {
            sut.set公費２_精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_精神科専門療法);
            assertThat(sut.get公費２_精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_精神科専門療法));
        }

        @Test
        public void 戻り値の公費２_合計単位数は_設定した値と同じ公費２_合計単位数を返す() {
            sut.set公費２_合計単位数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_合計単位数);
            assertThat(sut.get公費２_合計単位数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費２_合計単位数));
        }

        @Test
        public void 戻り値の公費３_指導管理料等は_設定した値と同じ公費３_指導管理料等を返す() {
            sut.set公費３_指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_指導管理料等);
            assertThat(sut.get公費３_指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_指導管理料等));
        }

        @Test
        public void 戻り値の公費３_単純エックス線は_設定した値と同じ公費３_単純エックス線を返す() {
            sut.set公費３_単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_単純エックス線);
            assertThat(sut.get公費３_単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_単純エックス線));
        }

        @Test
        public void 戻り値の公費３_リハビリテーションは_設定した値と同じ公費３_リハビリテーションを返す() {
            sut.set公費３_リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_リハビリテーション);
            assertThat(sut.get公費３_リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_リハビリテーション));
        }

        @Test
        public void 戻り値の公費３_精神科専門療法は_設定した値と同じ公費３_精神科専門療法を返す() {
            sut.set公費３_精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_精神科専門療法);
            assertThat(sut.get公費３_精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_精神科専門療法));
        }

        @Test
        public void 戻り値の公費３_合計単位数は_設定した値と同じ公費３_合計単位数を返す() {
            sut.set公費３_合計単位数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_合計単位数);
            assertThat(sut.get公費３_合計単位数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_公費３_合計単位数));
        }

        @Test
        public void 戻り値の摘要１は_設定した値と同じ摘要１を返す() {
            sut.set摘要１(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１);
            assertThat(sut.get摘要１(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１));
        }

        @Test
        public void 戻り値の摘要２は_設定した値と同じ摘要２を返す() {
            sut.set摘要２(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要２);
            assertThat(sut.get摘要２(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要２));
        }

        @Test
        public void 戻り値の摘要３は_設定した値と同じ摘要３を返す() {
            sut.set摘要３(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要３);
            assertThat(sut.get摘要３(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要３));
        }

        @Test
        public void 戻り値の摘要４は_設定した値と同じ摘要４を返す() {
            sut.set摘要４(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要４);
            assertThat(sut.get摘要４(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要４));
        }

        @Test
        public void 戻り値の摘要５は_設定した値と同じ摘要５を返す() {
            sut.set摘要５(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要５);
            assertThat(sut.get摘要５(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要５));
        }

        @Test
        public void 戻り値の摘要６は_設定した値と同じ摘要６を返す() {
            sut.set摘要６(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要６);
            assertThat(sut.get摘要６(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要６));
        }

        @Test
        public void 戻り値の摘要７は_設定した値と同じ摘要７を返す() {
            sut.set摘要７(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要７);
            assertThat(sut.get摘要７(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要７));
        }

        @Test
        public void 戻り値の摘要８は_設定した値と同じ摘要８を返す() {
            sut.set摘要８(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要８);
            assertThat(sut.get摘要８(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要８));
        }

        @Test
        public void 戻り値の摘要９は_設定した値と同じ摘要９を返す() {
            sut.set摘要９(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要９);
            assertThat(sut.get摘要９(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要９));
        }

        @Test
        public void 戻り値の摘要１０は_設定した値と同じ摘要１０を返す() {
            sut.set摘要１０(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１０);
            assertThat(sut.get摘要１０(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１０));
        }

        @Test
        public void 戻り値の摘要１１は_設定した値と同じ摘要１１を返す() {
            sut.set摘要１１(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１１);
            assertThat(sut.get摘要１１(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１１));
        }

        @Test
        public void 戻り値の摘要１２は_設定した値と同じ摘要１２を返す() {
            sut.set摘要１２(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１２);
            assertThat(sut.get摘要１２(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１２));
        }

        @Test
        public void 戻り値の摘要１３は_設定した値と同じ摘要１３を返す() {
            sut.set摘要１３(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１３);
            assertThat(sut.get摘要１３(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１３));
        }

        @Test
        public void 戻り値の摘要１４は_設定した値と同じ摘要１４を返す() {
            sut.set摘要１４(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１４);
            assertThat(sut.get摘要１４(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１４));
        }

        @Test
        public void 戻り値の摘要１５は_設定した値と同じ摘要１５を返す() {
            sut.set摘要１５(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１５);
            assertThat(sut.get摘要１５(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１５));
        }

        @Test
        public void 戻り値の摘要１６は_設定した値と同じ摘要１６を返す() {
            sut.set摘要１６(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１６);
            assertThat(sut.get摘要１６(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１６));
        }

        @Test
        public void 戻り値の摘要１７は_設定した値と同じ摘要１７を返す() {
            sut.set摘要１７(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１７);
            assertThat(sut.get摘要１７(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１７));
        }

        @Test
        public void 戻り値の摘要１８は_設定した値と同じ摘要１８を返す() {
            sut.set摘要１８(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１８);
            assertThat(sut.get摘要１８(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１８));
        }

        @Test
        public void 戻り値の摘要１９は_設定した値と同じ摘要１９を返す() {
            sut.set摘要１９(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１９);
            assertThat(sut.get摘要１９(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要１９));
        }

        @Test
        public void 戻り値の摘要２０は_設定した値と同じ摘要２０を返す() {
            sut.set摘要２０(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要２０);
            assertThat(sut.get摘要２０(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_摘要２０));
        }

        @Test
        public void 戻り値の後_保険_指導管理料等は_設定した値と同じ後_保険_指導管理料等を返す() {
            sut.set後_保険_指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_保険_指導管理料等);
            assertThat(sut.get後_保険_指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_保険_指導管理料等));
        }

        @Test
        public void 戻り値の後_保険_単純エックス線は_設定した値と同じ後_保険_単純エックス線を返す() {
            sut.set後_保険_単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_保険_単純エックス線);
            assertThat(sut.get後_保険_単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_保険_単純エックス線));
        }

        @Test
        public void 戻り値の後_保険_リハビリテーションは_設定した値と同じ後_保険_リハビリテーションを返す() {
            sut.set後_保険_リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_保険_リハビリテーション);
            assertThat(sut.get後_保険_リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_保険_リハビリテーション));
        }

        @Test
        public void 戻り値の後_保険_精神科専門療法は_設定した値と同じ後_保険_精神科専門療法を返す() {
            sut.set後_保険_精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_保険_精神科専門療法);
            assertThat(sut.get後_保険_精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_保険_精神科専門療法));
        }

        @Test
        public void 戻り値の後_公費１_指導管理料等は_設定した値と同じ後_公費１_指導管理料等を返す() {
            sut.set後_公費１_指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費１_指導管理料等);
            assertThat(sut.get後_公費１_指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費１_指導管理料等));
        }

        @Test
        public void 戻り値の後_公費１_単純エックス線は_設定した値と同じ後_公費１_単純エックス線を返す() {
            sut.set後_公費１_単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費１_単純エックス線);
            assertThat(sut.get後_公費１_単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費１_単純エックス線));
        }

        @Test
        public void 戻り値の後_公費１_リハビリテーションは_設定した値と同じ後_公費１_リハビリテーションを返す() {
            sut.set後_公費１_リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費１_リハビリテーション);
            assertThat(sut.get後_公費１_リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費１_リハビリテーション));
        }

        @Test
        public void 戻り値の後_公費１_精神科専門療法は_設定した値と同じ後_公費１_精神科専門療法を返す() {
            sut.set後_公費１_精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費１_精神科専門療法);
            assertThat(sut.get後_公費１_精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費１_精神科専門療法));
        }

        @Test
        public void 戻り値の後_公費２_指導管理料等は_設定した値と同じ後_公費２_指導管理料等を返す() {
            sut.set後_公費２_指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費２_指導管理料等);
            assertThat(sut.get後_公費２_指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費２_指導管理料等));
        }

        @Test
        public void 戻り値の後_公費２_単純エックス線は_設定した値と同じ後_公費２_単純エックス線を返す() {
            sut.set後_公費２_単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費２_単純エックス線);
            assertThat(sut.get後_公費２_単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費２_単純エックス線));
        }

        @Test
        public void 戻り値の後_公費２_リハビリテーションは_設定した値と同じ後_公費２_リハビリテーションを返す() {
            sut.set後_公費２_リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費２_リハビリテーション);
            assertThat(sut.get後_公費２_リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費２_リハビリテーション));
        }

        @Test
        public void 戻り値の後_公費２_精神科専門療法は_設定した値と同じ後_公費２_精神科専門療法を返す() {
            sut.set後_公費２_精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費２_精神科専門療法);
            assertThat(sut.get後_公費２_精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費２_精神科専門療法));
        }

        @Test
        public void 戻り値の後_公費３_指導管理料等は_設定した値と同じ後_公費３_指導管理料等を返す() {
            sut.set後_公費３_指導管理料等(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費３_指導管理料等);
            assertThat(sut.get後_公費３_指導管理料等(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費３_指導管理料等));
        }

        @Test
        public void 戻り値の後_公費３_単純エックス線は_設定した値と同じ後_公費３_単純エックス線を返す() {
            sut.set後_公費３_単純エックス線(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費３_単純エックス線);
            assertThat(sut.get後_公費３_単純エックス線(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費３_単純エックス線));
        }

        @Test
        public void 戻り値の後_公費３_リハビリテーションは_設定した値と同じ後_公費３_リハビリテーションを返す() {
            sut.set後_公費３_リハビリテーション(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費３_リハビリテーション);
            assertThat(sut.get後_公費３_リハビリテーション(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費３_リハビリテーション));
        }

        @Test
        public void 戻り値の後_公費３_精神科専門療法は_設定した値と同じ後_公費３_精神科専門療法を返す() {
            sut.set後_公費３_精神科専門療法(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費３_精神科専門療法);
            assertThat(sut.get後_公費３_精神科専門療法(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_後_公費３_精神科専門療法));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            sut.set再審査回数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_再審査回数);
            assertThat(sut.get再審査回数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            sut.set過誤回数(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_過誤回数);
            assertThat(sut.get過誤回数(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            sut.set審査年月(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_審査年月);
            assertThat(sut.get審査年月(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            sut.set整理番号(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_整理番号);
            assertThat(sut.get整理番号(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            sut.set取込年月(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_取込年月);
            assertThat(sut.get取込年月(), is(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_取込年月));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KyufujissekiTokuteiSinryohiModel sut = new KyufujissekiTokuteiSinryohiModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            KyufujissekiTokuteiSinryohiModel sut = new KyufujissekiTokuteiSinryohiModel();
            sut.setEntity(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.createDbT3020KyufujissekiTokuteiSinryohiEntity());

            sut.getEntity().initializeMd5();

            // 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            KyufujissekiTokuteiSinryohiModel sut = new KyufujissekiTokuteiSinryohiModel();
            sut.setEntity(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.createDbT3020KyufujissekiTokuteiSinryohiEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KyufujissekiTokuteiSinryohiModel sut = new KyufujissekiTokuteiSinryohiModel();
            sut.setEntity(DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.createDbT3020KyufujissekiTokuteiSinryohiEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
