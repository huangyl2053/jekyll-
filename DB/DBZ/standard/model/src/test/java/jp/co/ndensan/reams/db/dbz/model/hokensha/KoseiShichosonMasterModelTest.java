/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hokensha;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ForeignersNameOutput;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TopPriorityArea;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GappeiKyuShichosonHyoji;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.RokenJukyushaNoTaikei;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.UnyoKeitaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.GappeiChiikiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.KokuhorenKoikiShichosonNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.RokenShichosonNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoseiShichosonMasterModel}のテストクラスです。
 *
 * @author LDNS 宋文娟
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterModelTest extends DbzTestBase {

    public static class getterSetterTest extends DbzTestBase {

        private static KoseiShichosonMasterModel sut;

        @BeforeClass
        public static void test() {
            sut = new KoseiShichosonMasterModel();
        }

        @Test
        public void 戻り値の市町村識別IDは_設定した値と同じ市町村識別IDを返す() {
            ShichosonShikibetsuID id = new ShichosonShikibetsuID(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID);
            sut.set市町村識別ID(id);
            assertThat(sut.get市町村識別ID(), is(id));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            sut.set市町村コード(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村コード);
            assertThat(sut.get市町村コード(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            sut.set証記載保険者番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_証記載保険者番号);
            assertThat(sut.get証記載保険者番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の国保連広域内市町村番号は_設定した値と同じ国保連広域内市町村番号を返す() {
            KokuhorenKoikiShichosonNo no = new KokuhorenKoikiShichosonNo(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_国保連広域内市町村番号);
            sut.set国保連広域内市町村番号(no);
            assertThat(sut.get国保連広域内市町村番号(), is(no));
        }

        @Test
        public void 戻り値の市町村名称は_設定した値と同じ市町村名称を返す() {
            sut.set市町村名称(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村名称);
            assertThat(sut.get市町村名(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村名称));
        }

        @Test
        public void 戻り値の都道府県名称は_設定した値と同じ都道府県名称を返す() {
            sut.set都道府県名称(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_都道府県名称);
            assertThat(sut.get都道府県名(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_都道府県名称));
        }

        @Test
        public void 戻り値の郡名称は_設定した値と同じ郡名称を返す() {
            sut.set郡名称(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郡名称);
            assertThat(sut.get郡名(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郡名称));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            sut.set郵便番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郵便番号);
            assertThat(sut.get郵便番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            sut.set住所(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_住所);
            assertThat(sut.get住所(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            sut.set電話番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_電話番号);
            assertThat(sut.get電話番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値の最優先地区は_設定した値と同じ最優先地区を返す() {
            sut.set最優先地区(TopPriorityArea.地区コード１);
            assertThat(sut.get最優先地区(), is(TopPriorityArea.地区コード１));
        }

        @Test
        public void 戻り値の都道府県名印字有無は_設定した値と同じ都道府県名印字有無を返す() {
            sut.set都道府県名印字有無(TodofukenNamePrint.印字しない);
            assertThat(sut.get都道府名印字有無(), is(TodofukenNamePrint.印字しない));
        }

        @Test
        public void 戻り値の郡名印字有無は_設定した値と同じ郡名印字有無を返す() {
            sut.set郡名印字有無(GunNamePrint.印字する);
            assertThat(sut.get群名印字有無(), is(GunNamePrint.印字する));
        }

        @Test
        public void 戻り値の市町村名印字有無は_設定した値と同じ市町村名印字有無を返す() {
            sut.set市町村名印字有無(ShichosonNamePrint.印字する);
            assertThat(sut.get市町村名印字有無(), is(ShichosonNamePrint.印字する));
        }

        @Test
        public void 戻り値の帳票用住所編集方法は_設定した値と同じ帳票用住所編集方法を返す() {
//            sut.set住所編集方法(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用住所編集方法);
//            assertThat(sut.get印字住所編集方法(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用住所編集方法));
        }

        @Test
        public void 戻り値の方書印字有無は_設定した値と同じ方書印字有無を返す() {
            sut.set方書印字有無(KatagakiPrint.印字する);
            assertThat(sut.get方書印字有無(), is(KatagakiPrint.印字する));
        }

        @Test
        public void 戻り値の外国人氏名表示方法は_設定した値と同じ外国人氏名表示方法を返す() {
            sut.set外国人氏名表示方法(ForeignersNameOutput.正式名);
            assertThat(sut.get外国人氏名表示方法(), is(ForeignersNameOutput.正式名));
        }

        @Test
        public void 戻り値の老人保健市町村番号は_設定した値と同じ老人保健市町村番号を返す() {
            RokenShichosonNo no = new RokenShichosonNo(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_老人保健市町村番号);
            sut.set老人保健市町村番号(no);
            assertThat(sut.get老人保健市町村番号(), is(no));
        }

        @Test
        public void 戻り値の老人保健受給者番号体系は_設定した値と同じ老人保健受給者番号体系を返す() {
            sut.set老人保健受給者番号体系(RokenJukyushaNoTaikei.住民コード);
            assertThat(sut.get老人保健受給者番号体系(), is(RokenJukyushaNoTaikei.住民コード));
        }

        @Test
        public void 戻り値の移行日は_設定した値と同じ移行日を返す() {
            sut.set移行日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_移行日);
            assertThat(sut.get移行日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_移行日));
        }

        @Test
        public void 戻り値の加入日は_設定した値と同じ加入日を返す() {
            sut.set加入日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_加入日);
            assertThat(sut.get加入日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_加入日));
        }

        @Test
        public void 戻り値の離脱日は_設定した値と同じ離脱日を返す() {
            sut.set離脱日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_離脱日);
            assertThat(sut.get離脱日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_離脱日));
        }

        @Test
        public void 戻り値の合併旧市町村区分は_設定した値と同じ合併旧市町村区分を返す() {
            sut.set合併旧市町村区分(GappeiKyuShichosonKubun.合併旧市町村);
            assertThat(sut.get合併旧市町村区分(), is(GappeiKyuShichosonKubun.合併旧市町村));
        }

        @Test
        public void 戻り値の合併旧市町村表示有無は_設定した値と同じ合併旧市町村表示有無を返す() {
            sut.set合併旧市町村表示有無(GappeiKyuShichosonHyoji.表示しない);
            assertThat(sut.get合併旧市町村表示有無(), is(GappeiKyuShichosonHyoji.表示しない));
        }

        @Test
        public void 戻り値の合併地域番号は_設定した値と同じ合併地域番号を返す() {
            GappeiChiikiNo no = new GappeiChiikiNo(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併情報リンク番号);
            sut.set合併地域番号(no);
            assertThat(sut.get合併地域番号(), is(no));
        }

        @Test
        public void 戻り値の運用保険者番号は_設定した値と同じ運用保険者番号を返す() {
            sut.set運用保険者番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用保険者番号);
            assertThat(sut.get運用保険者番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用保険者番号));
        }

        @Test
        public void 戻り値の運用開始日は_設定した値と同じ運用開始日を返す() {
            sut.set運用開始日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用開始日);
            assertThat(sut.get運用開始日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用開始日));
        }

        @Test
        public void 戻り値の運用終了日は_設定した値と同じ運用終了日を返す() {
            sut.set運用終了日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用終了日);
            assertThat(sut.get運用終了日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用終了日));
        }

        @Test
        public void 戻り値の運用形態区分は_設定した値と同じ運用形態区分を返す() {
            sut.set運用形態区分(UnyoKeitaiKubun.一部事務組合);
            assertThat(sut.get運用形態区分(), is(UnyoKeitaiKubun.一部事務組合));
        }
    }

    public static class getStateTest extends DbzTestBase {

        @Test
        public void 状態Addedの取得確認() {
            KoseiShichosonMasterModel sut = new KoseiShichosonMasterModel();

            assertThat(sut.getState(), is(EntityDataState.Added));
        }

        // @Test
        // public void 状態Modifinedの取得確認() {
        // KoseiShichosonMasterModel sut = new KoseiShichosonMasterModel();
        //sut.setEntity(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());
        // sut.getEntity().initializeMd5();
        // TODO主キー以外の項目を変更してください
        //sut.getEntity().setXXX(new XXX());
        //assertThat(sut.getState(), is(EntityDataState.Modified));
        //}
        @Test
        public void 状態Unchangedの取得確認() {
            KoseiShichosonMasterModel sut = new KoseiShichosonMasterModel();
            sut.setEntity(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());

            sut.getEntity().initializeMd5();

            assertThat(sut.getState(), is(EntityDataState.Unchanged));
        }

        @Test
        public void 状態Deletedの取得確認() {
            KoseiShichosonMasterModel sut = new KoseiShichosonMasterModel();
            sut.setEntity(DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity());

            sut.getEntity().initializeMd5();

            sut.setDeletedState(true);

            assertThat(sut.getState(), is(EntityDataState.Deleted));
        }
    }
}
