/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonshishomaster.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoseiShichosonMasterBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterBuilderTest extends DbzTestBase {

    private static DbT7051KoseiShichosonMasterEntity KoseiShichosonMasterEntity;
    private static RString 市町村識別ID;

    @BeforeClass
    public static void setUpClass() {

        市町村識別ID = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;

    }

    @Ignore
    public static class KoseiShichosonShishoMasterテスト extends DbzTestBase {

        private static KoseiShichosonMasterBuilder sut;
        private static KoseiShichosonMaster business;
        private static KoseiShichosonShishoMaster seishinTechoNini;

        @Before
        public void setUp() {

            business = new KoseiShichosonMaster(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID);
            seishinTechoNini = new KoseiShichosonShishoMaster(
                    DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村コード,
                    DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード);
            sut = business.createBuilderForEdit();
        }

        @Test
        public void 構成市町村マスタに紐づくことが可能な子テーブル情報をsetSeishinTechoNiniで設定した場合_設定済みの子テーブル情報が返る() {
            business = sut.setKoseiShichosonShishoMaster(seishinTechoNini).build();
            assertThat(business.getKoseiShichosonShishoMasterList().size(), is(1));
        }
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KoseiShichosonMasterBuilder sut;
        private static KoseiShichosonMaster business;

        @Before
        public void setUp() {
            KoseiShichosonMasterEntity = new DbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMasterEntity.setShichosonShokibetsuID(市町村識別ID);

            KoseiShichosonMasterRelateEntity entity = new KoseiShichosonMasterRelateEntity();
            entity.set構成市町村マスタEntity(KoseiShichosonMasterEntity);
            business = new KoseiShichosonMaster(entity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の国保連広域内市町村番号は_設定した値と同じ国保連広域内市町村番号を返す() {
            business = sut.set国保連広域内市町村番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_国保連広域内市町村番号).build();
            assertThat(business.get国保連広域内市町村番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_国保連広域内市町村番号));
        }

        @Test
        public void 戻り値の市町村名称は_設定した値と同じ市町村名称を返す() {
            business = sut.set市町村名称(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村名称).build();
            assertThat(business.get市町村名称(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村名称));
        }

        @Test
        public void 戻り値の都道府県名称は_設定した値と同じ都道府県名称を返す() {
            business = sut.set都道府県名称(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_都道府県名称).build();
            assertThat(business.get都道府県名称(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_都道府県名称));
        }

        @Test
        public void 戻り値の郡名称は_設定した値と同じ郡名称を返す() {
            business = sut.set郡名称(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郡名称).build();
            assertThat(business.get郡名称(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郡名称));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            business = sut.set郵便番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(business.get郵便番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            business = sut.set住所(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_住所).build();
            assertThat(business.get住所(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            business = sut.set電話番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_電話番号).build();
            assertThat(business.get電話番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値の最優先地区コードは_設定した値と同じ最優先地区コードを返す() {
            business = sut.set最優先地区コード(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_最優先地区コード).build();
            assertThat(business.get最優先地区コード(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_最優先地区コード));
        }

        @Test
        public void 戻り値の帳票用都道府県名称表示有無は_設定した値と同じ帳票用都道府県名称表示有無を返す() {
            business = sut.set帳票用都道府県名称表示有無(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用都道府県名称表示有無).build();
            assertThat(business.get帳票用都道府県名称表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用都道府県名称表示有無));
        }

        @Test
        public void 戻り値の帳票用郡名称表示有無は_設定した値と同じ帳票用郡名称表示有無を返す() {
            business = sut.set帳票用郡名称表示有無(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用郡名称表示有無).build();
            assertThat(business.get帳票用郡名称表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用郡名称表示有無));
        }

        @Test
        public void 戻り値の帳票用市町村名称表示有無は_設定した値と同じ帳票用市町村名称表示有無を返す() {
            business = sut.set帳票用市町村名称表示有無(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用市町村名称表示有無).build();
            assertThat(business.get帳票用市町村名称表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用市町村名称表示有無));
        }

        @Test
        public void 戻り値の帳票用住所編集方法は_設定した値と同じ帳票用住所編集方法を返す() {
            business = sut.set帳票用住所編集方法(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用住所編集方法).build();
            assertThat(business.get帳票用住所編集方法(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用住所編集方法));
        }

        @Test
        public void 戻り値の帳票用方書表示有無は_設定した値と同じ帳票用方書表示有無を返す() {
            business = sut.set帳票用方書表示有無(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用方書表示有無).build();
            assertThat(business.get帳票用方書表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_帳票用方書表示有無));
        }

        @Test
        public void 戻り値の外国人氏名表示方法は_設定した値と同じ外国人氏名表示方法を返す() {
            business = sut.set外国人氏名表示方法(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_外国人氏名表示方法).build();
            assertThat(business.get外国人氏名表示方法(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_外国人氏名表示方法));
        }

        @Test
        public void 戻り値の老人保健市町村番号は_設定した値と同じ老人保健市町村番号を返す() {
            business = sut.set老人保健市町村番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_老人保健市町村番号).build();
            assertThat(business.get老人保健市町村番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_老人保健市町村番号));
        }

        @Test
        public void 戻り値の老人保健受給者番号体系は_設定した値と同じ老人保健受給者番号体系を返す() {
            business = sut.set老人保健受給者番号体系(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_老人保健受給者番号体系).build();
            assertThat(business.get老人保健受給者番号体系(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_老人保健受給者番号体系));
        }

        @Test
        public void 戻り値の特徴分配集約は_設定した値と同じ特徴分配集約を返す() {
            business = sut.set特徴分配集約(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_特徴分配集約).build();
            assertThat(business.get特徴分配集約(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_特徴分配集約));
        }

        @Test
        public void 戻り値の移行日は_設定した値と同じ移行日を返す() {
            business = sut.set移行日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_移行日).build();
            assertThat(business.get移行日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_移行日));
        }

        @Test
        public void 戻り値の加入日は_設定した値と同じ加入日を返す() {
            business = sut.set加入日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_加入日).build();
            assertThat(business.get加入日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_加入日));
        }

        @Test
        public void 戻り値の離脱日は_設定した値と同じ離脱日を返す() {
            business = sut.set離脱日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_離脱日).build();
            assertThat(business.get離脱日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_離脱日));
        }

        @Test
        public void 戻り値の合併旧市町村区分は_設定した値と同じ合併旧市町村区分を返す() {
            business = sut.set合併旧市町村区分(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併旧市町村区分).build();
            assertThat(business.get合併旧市町村区分(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併旧市町村区分));
        }

        @Test
        public void 戻り値の合併旧市町村表示有無は_設定した値と同じ合併旧市町村表示有無を返す() {
            business = sut.set合併旧市町村表示有無(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併旧市町村表示有無).build();
            assertThat(business.get合併旧市町村表示有無(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併旧市町村表示有無));
        }

        @Test
        public void 戻り値の合併情報地域番号は_設定した値と同じ合併情報地域番号を返す() {
            business = sut.set合併情報地域番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併情報地域番号).build();
            assertThat(business.get合併情報地域番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_合併情報地域番号));
        }

        @Test
        public void 戻り値の運用保険者番号は_設定した値と同じ運用保険者番号を返す() {
            business = sut.set運用保険者番号(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用保険者番号).build();
            assertThat(business.get運用保険者番号(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用保険者番号));
        }

        @Test
        public void 戻り値の運用開始日は_設定した値と同じ運用開始日を返す() {
            business = sut.set運用開始日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用開始日).build();
            assertThat(business.get運用開始日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用開始日));
        }

        @Test
        public void 戻り値の運用終了日は_設定した値と同じ運用終了日を返す() {
            business = sut.set運用終了日(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用終了日).build();
            assertThat(business.get運用終了日(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用終了日));
        }

        @Test
        public void 戻り値の運用形態区分は_設定した値と同じ運用形態区分を返す() {
            business = sut.set運用形態区分(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用形態区分).build();
            assertThat(business.get運用形態区分(), is(DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_運用形態区分));
        }

    }
}
