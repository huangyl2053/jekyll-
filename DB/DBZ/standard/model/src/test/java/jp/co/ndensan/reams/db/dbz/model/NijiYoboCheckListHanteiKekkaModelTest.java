/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NijiYoboCheckListHanteiKekkaModel}のテストクラスです。
 *
 * @author LDNS 宋昕沢
 */
@RunWith(Enclosed.class)
public class NijiYoboCheckListHanteiKekkaModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static NijiYoboCheckListHanteiKekkaModel sut;

        @BeforeClass
        public static void test() {
            sut = new NijiYoboCheckListHanteiKekkaModel();
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            sut.set識別コード(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード);
            assertThat(sut.get識別コード(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            sut.set被保険者番号(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号);
            assertThat(sut.get被保険者番号(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の受付年月日は_設定した値と同じ受付年月日を返す() {
            sut.set受付年月日(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日);
            assertThat(sut.get受付年月日(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日));
        }

        @Test
        public void 戻り値の処理日時は_設定した値と同じ処理日時を返す() {
            sut.set処理日時(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_処理日時);
            assertThat(sut.get処理日時(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_処理日時));
        }

        @Test
        public void 戻り値の点数_生活機能全般は_設定した値と同じ点数_生活機能全般を返す() {
            sut.set点数_生活機能全般(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_生活機能全般);
            assertThat(sut.get点数_生活機能全般(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_生活機能全般));
        }

        @Test
        public void 戻り値の点数_運動器機能は_設定した値と同じ点数_運動器機能を返す() {
            sut.set点数_運動器機能(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_運動器機能);
            assertThat(sut.get点数_運動器機能(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_運動器機能));
        }

        @Test
        public void 戻り値の点数_栄養は_設定した値と同じ点数_栄養を返す() {
            sut.set点数_栄養(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_栄養);
            assertThat(sut.get点数_栄養(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_栄養));
        }

        @Test
        public void 戻り値の点数_口腔は_設定した値と同じ点数_口腔を返す() {
            sut.set点数_口腔(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_口腔);
            assertThat(sut.get点数_口腔(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_口腔));
        }

        @Test
        public void 戻り値の点数_閉じこもりは_設定した値と同じ点数_閉じこもりを返す() {
            sut.set点数_閉じこもり(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_閉じこもり);
            assertThat(sut.get点数_閉じこもり(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_閉じこもり));
        }

        @Test
        public void 戻り値の点数_認知能力は_設定した値と同じ点数_認知能力を返す() {
            sut.set点数_認知能力(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_認知能力);
            assertThat(sut.get点数_認知能力(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_認知能力));
        }

        @Test
        public void 戻り値の点数_うつは_設定した値と同じ点数_うつを返す() {
            sut.set点数_うつ(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_うつ);
            assertThat(sut.get点数_うつ(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_点数_うつ));
        }

        @Test
        public void 戻り値の支援必要性_生活機能全般は_設定した値と同じ支援必要性_生活機能全般を返す() {
            sut.set支援必要性_生活機能全般(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_生活機能全般);
            assertThat(sut.get支援必要性_生活機能全般(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_生活機能全般));
        }

        @Test
        public void 戻り値の支援必要性_運動器機能は_設定した値と同じ支援必要性_運動器機能を返す() {
            sut.set支援必要性_運動器機能(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_運動器機能);
            assertThat(sut.get支援必要性_運動器機能(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_運動器機能));
        }

        @Test
        public void 戻り値の支援必要性_栄養は_設定した値と同じ支援必要性_栄養を返す() {
            sut.set支援必要性_栄養(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_栄養);
            assertThat(sut.get支援必要性_栄養(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_栄養));
        }

        @Test
        public void 戻り値の支援必要性_口腔は_設定した値と同じ支援必要性_口腔を返す() {
            sut.set支援必要性_口腔(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_口腔);
            assertThat(sut.get支援必要性_口腔(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_口腔));
        }

        @Test
        public void 戻り値の支援必要性_閉じこもりは_設定した値と同じ支援必要性_閉じこもりを返す() {
            sut.set支援必要性_閉じこもり(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_閉じこもり);
            assertThat(sut.get支援必要性_閉じこもり(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_閉じこもり));
        }

        @Test
        public void 戻り値の支援必要性_認知能力は_設定した値と同じ支援必要性_認知能力を返す() {
            sut.set支援必要性_認知能力(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_認知能力);
            assertThat(sut.get支援必要性_認知能力(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_認知能力));
        }

        @Test
        public void 戻り値の支援必要性_うつは_設定した値と同じ支援必要性_うつを返す() {
            sut.set支援必要性_うつ(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_うつ);
            assertThat(sut.get支援必要性_うつ(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_支援必要性_うつ));
        }

        @Test
        public void 戻り値の二次予防_主観的健康感は_設定した値と同じ二次予防_主観的健康感を返す() {
            sut.set二次予防_主観的健康感(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_二次予防_主観的健康感);
            assertThat(sut.get二次予防_主観的健康感(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_二次予防_主観的健康感));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            NijiYoboCheckListHanteiKekkaModel sut = new NijiYoboCheckListHanteiKekkaModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        @Test
        public void 状態Modifinedの取得確認() {
            NijiYoboCheckListHanteiKekkaModel sut = new NijiYoboCheckListHanteiKekkaModel();
            sut.setEntity(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity());

            sut.getEntity().initializeMd5();

            // TODO 主キー以外の項目を変更してください
//            sut.getEntity().setXXX(new XXX());
//            assertThat(sut.getState(), is(EntityDataState.Modified));
        }

        @Test
        public void 状態Unchangedの取得確認() {
            NijiYoboCheckListHanteiKekkaModel sut = new NijiYoboCheckListHanteiKekkaModel();
            sut.setEntity(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            NijiYoboCheckListHanteiKekkaModel sut = new NijiYoboCheckListHanteiKekkaModel();
            sut.setEntity(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
