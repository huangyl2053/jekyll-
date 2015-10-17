/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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

    public static class getterSetterTest extends DbcTestBase {

        private static NijiYoboCheckListHanteiKekkaBuilder sut;
        private static NijiYoboCheckListHanteiKekka business;

        @Before
        public void setUp() {
            NijiYoboCheckListHanteiKekkaEntity = new DbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekkaEntity.setShikibetsuCode(識別コード);
            NijiYoboCheckListHanteiKekkaEntity.setHihokenshaNo(被保険者番号);
            NijiYoboCheckListHanteiKekkaEntity.setUketsukeYMD(受付年月日);
            NijiYoboCheckListHanteiKekkaEntity.setRirekiNo(履歴番号);

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
        public void 戻り値の点数_生活機能全般は_設定した値と同じ点数_生活機能全般を返す() {
            business = sut.set点数_生活機能全般(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_生活機能全般).build();
            assertThat(business.get点数_生活機能全般(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_生活機能全般));
        }

        @Test
        public void 戻り値の点数_運動器機能は_設定した値と同じ点数_運動器機能を返す() {
            business = sut.set点数_運動器機能(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_運動器機能).build();
            assertThat(business.get点数_運動器機能(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_運動器機能));
        }

        @Test
        public void 戻り値の点数_栄養は_設定した値と同じ点数_栄養を返す() {
            business = sut.set点数_栄養(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_栄養).build();
            assertThat(business.get点数_栄養(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_栄養));
        }

        @Test
        public void 戻り値の点数_口腔は_設定した値と同じ点数_口腔を返す() {
            business = sut.set点数_口腔(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_口腔).build();
            assertThat(business.get点数_口腔(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_口腔));
        }

        @Test
        public void 戻り値の点数_閉じこもりは_設定した値と同じ点数_閉じこもりを返す() {
            business = sut.set点数_閉じこもり(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_閉じこもり).build();
            assertThat(business.get点数_閉じこもり(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_閉じこもり));
        }

        @Test
        public void 戻り値の点数_認知能力は_設定した値と同じ点数_認知能力を返す() {
            business = sut.set点数_認知能力(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_認知能力).build();
            assertThat(business.get点数_認知能力(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_認知能力));
        }

        @Test
        public void 戻り値の点数_うつは_設定した値と同じ点数_うつを返す() {
            business = sut.set点数_うつ(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_うつ).build();
            assertThat(business.get点数_うつ(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_うつ));
        }

        @Test
        public void 戻り値の支援必要性_生活機能全般は_設定した値と同じ支援必要性_生活機能全般を返す() {
            business = sut.set支援必要性_生活機能全般(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_生活機能全般).build();
            assertThat(business.get支援必要性_生活機能全般(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_生活機能全般));
        }

        @Test
        public void 戻り値の支援必要性_運動器機能は_設定した値と同じ支援必要性_運動器機能を返す() {
            business = sut.set支援必要性_運動器機能(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_運動器機能).build();
            assertThat(business.get支援必要性_運動器機能(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_運動器機能));
        }

        @Test
        public void 戻り値の支援必要性_栄養は_設定した値と同じ支援必要性_栄養を返す() {
            business = sut.set支援必要性_栄養(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_栄養).build();
            assertThat(business.get支援必要性_栄養(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_栄養));
        }

        @Test
        public void 戻り値の支援必要性_口腔は_設定した値と同じ支援必要性_口腔を返す() {
            business = sut.set支援必要性_口腔(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_口腔).build();
            assertThat(business.get支援必要性_口腔(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_口腔));
        }

        @Test
        public void 戻り値の支援必要性_閉じこもりは_設定した値と同じ支援必要性_閉じこもりを返す() {
            business = sut.set支援必要性_閉じこもり(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_閉じこもり).build();
            assertThat(business.get支援必要性_閉じこもり(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_閉じこもり));
        }

        @Test
        public void 戻り値の支援必要性_認知能力は_設定した値と同じ支援必要性_認知能力を返す() {
            business = sut.set支援必要性_認知能力(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_認知能力).build();
            assertThat(business.get支援必要性_認知能力(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_認知能力));
        }

        @Test
        public void 戻り値の支援必要性_うつは_設定した値と同じ支援必要性_うつを返す() {
            business = sut.set支援必要性_うつ(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_うつ).build();
            assertThat(business.get支援必要性_うつ(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_うつ));
        }

        @Test
        public void 戻り値の二次予防_主観的健康感は_設定した値と同じ二次予防_主観的健康感を返す() {
            business = sut.set二次予防_主観的健康感(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_二次予防_主観的健康感).build();
            assertThat(business.get二次予防_主観的健康感(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_二次予防_主観的健康感));
        }

    }
}
