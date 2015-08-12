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
 * {@link NijiYoboCheckListHanteiKekkaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboCheckListHanteiKekkaBuilderTest extends DbcTestBase {

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

    public static class getterSetterTest extends FdaTestBase {

        private static NijiYoboCheckListHanteiKekkaBuilder sut;
        private static NijiYoboCheckListHanteiKekka business;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = new DbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名1);
            NijiYoboCheckListHanteiKekkaEntity.setXXX(主キー名2);

            business = new NijiYoboCheckListHanteiKekka(NijiYoboCheckListHanteiKekkaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            business = sut.set受付年月日(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日).build();
            assertThat(business.get受付年月日(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の点数・生活機能全般は_設定した値と同じ点数・生活機能全般を返す() {
            business = sut.set点数・生活機能全般(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・生活機能全般).build();
            assertThat(business.get点数・生活機能全般(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・生活機能全般));
        }

        @Test
        public void 戻り値の点数・運動器機能は_設定した値と同じ点数・運動器機能を返す() {
            business = sut.set点数・運動器機能(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・運動器機能).build();
            assertThat(business.get点数・運動器機能(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・運動器機能));
        }

        @Test
        public void 戻り値の点数・栄養は_設定した値と同じ点数・栄養を返す() {
            business = sut.set点数・栄養(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・栄養).build();
            assertThat(business.get点数・栄養(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・栄養));
        }

        @Test
        public void 戻り値の点数・口腔は_設定した値と同じ点数・口腔を返す() {
            business = sut.set点数・口腔(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・口腔).build();
            assertThat(business.get点数・口腔(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・口腔));
        }

        @Test
        public void 戻り値の点数・閉じこもりは_設定した値と同じ点数・閉じこもりを返す() {
            business = sut.set点数・閉じこもり(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・閉じこもり).build();
            assertThat(business.get点数・閉じこもり(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・閉じこもり));
        }

        @Test
        public void 戻り値の点数・認知能力は_設定した値と同じ点数・認知能力を返す() {
            business = sut.set点数・認知能力(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・認知能力).build();
            assertThat(business.get点数・認知能力(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・認知能力));
        }

        @Test
        public void 戻り値の点数・うつは_設定した値と同じ点数・うつを返す() {
            business = sut.set点数・うつ(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・うつ).build();
            assertThat(business.get点数・うつ(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数・うつ));
        }

        @Test
        public void 戻り値の支援必要性・生活機能全般は_設定した値と同じ支援必要性・生活機能全般を返す() {
            business = sut.set支援必要性・生活機能全般(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・生活機能全般).build();
            assertThat(business.get支援必要性・生活機能全般(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・生活機能全般));
        }

        @Test
        public void 戻り値の支援必要性・運動器機能は_設定した値と同じ支援必要性・運動器機能を返す() {
            business = sut.set支援必要性・運動器機能(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・運動器機能).build();
            assertThat(business.get支援必要性・運動器機能(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・運動器機能));
        }

        @Test
        public void 戻り値の支援必要性・栄養は_設定した値と同じ支援必要性・栄養を返す() {
            business = sut.set支援必要性・栄養(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・栄養).build();
            assertThat(business.get支援必要性・栄養(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・栄養));
        }

        @Test
        public void 戻り値の支援必要性・口腔は_設定した値と同じ支援必要性・口腔を返す() {
            business = sut.set支援必要性・口腔(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・口腔).build();
            assertThat(business.get支援必要性・口腔(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・口腔));
        }

        @Test
        public void 戻り値の支援必要性・閉じこもりは_設定した値と同じ支援必要性・閉じこもりを返す() {
            business = sut.set支援必要性・閉じこもり(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・閉じこもり).build();
            assertThat(business.get支援必要性・閉じこもり(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・閉じこもり));
        }

        @Test
        public void 戻り値の支援必要性・認知能力は_設定した値と同じ支援必要性・認知能力を返す() {
            business = sut.set支援必要性・認知能力(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・認知能力).build();
            assertThat(business.get支援必要性・認知能力(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・認知能力));
        }

        @Test
        public void 戻り値の支援必要性・うつは_設定した値と同じ支援必要性・うつを返す() {
            business = sut.set支援必要性・うつ(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・うつ).build();
            assertThat(business.get支援必要性・うつ(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性・うつ));
        }

        @Test
        public void 戻り値の二次予防・主観的健康感は_設定した値と同じ二次予防・主観的健康感を返す() {
            business = sut.set二次予防・主観的健康感(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_二次予防・主観的健康感).build();
            assertThat(business.get二次予防・主観的健康感(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_二次予防・主観的健康感));
        }

    }
}
