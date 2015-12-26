/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonshishomaster.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonshishomaster.KoseiShichosonShishoMasterIdentifier;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoseiShichosonMaster}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterTest extends DbzTestBase {

    private static DbT7051KoseiShichosonMasterEntity KoseiShichosonMasterEntity;

    private static RString 市町村識別ID;

    @BeforeClass
    public static void setUpClass() {

        市町村識別ID = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KoseiShichosonMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonMasterEntity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMasterEntity.setShichosonShokibetsuID(市町村識別ID);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoseiShichosonMaster((RString) null);
        }

        @Test
        public void 指定したキーが保持するDbT7051KoseiShichosonMasterEntityにセットされている() {
            sut = new KoseiShichosonMaster(市町村識別ID);
            assertThat(sut.get市町村識別ID(), is(市町村識別ID));
        }

        @Test
        public void 指定したキーが保持するKoseiShichosonMasterIdentifierにセットされている() {
            sut = new KoseiShichosonMaster(市町村識別ID);
            assertThat(sut.identifier().get市町村識別ID(), is(市町村識別ID));
        }

        @Test
        public void 空のKoseiShichosonShishoMasterリストがセットされている() {
            sut = new KoseiShichosonMaster(市町村識別ID);
            assertThat(sut.getKoseiShichosonShishoMasterList().size(), is(0));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KoseiShichosonMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonMasterEntity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMasterEntity.setShichosonShokibetsuID(市町村識別ID);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KoseiShichosonMaster((KoseiShichosonMasterRelateEntity) null);
        }

        @Test
        public void 指定したDbT7051KoseiShichosonMasterEntityのキー情報を識別子が持つ() {

            KoseiShichosonMasterRelateEntity entity = new KoseiShichosonMasterRelateEntity();
            entity.set構成市町村マスタEntity(KoseiShichosonMasterEntity);
            sut = new KoseiShichosonMaster(entity);

            assertThat(sut.identifier().get市町村識別ID(), is(市町村識別ID));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KoseiShichosonMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonMasterEntity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMasterEntity.setShichosonShokibetsuID(市町村識別ID);

            KoseiShichosonMasterRelateEntity entity = new KoseiShichosonMasterRelateEntity();
            entity.set構成市町村マスタEntity(KoseiShichosonMasterEntity);
            sut = new KoseiShichosonMaster(entity);
        }

        @Test
        public void get市町村識別IDは_entityが持つ市町村識別IDを返す() {
            assertThat(sut.get市町村識別ID(), is(KoseiShichosonMasterEntity.getShichosonShokibetsuID()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(KoseiShichosonMasterEntity.getShichosonCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KoseiShichosonMasterEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get国保連広域内市町村番号は_entityが持つ国保連広域内市町村番号を返す() {
            assertThat(sut.get国保連広域内市町村番号(), is(KoseiShichosonMasterEntity.getKokuhorenKoikiShichosonNo()));
        }

        @Test
        public void get市町村名称は_entityが持つ市町村名称を返す() {
            assertThat(sut.get市町村名称(), is(KoseiShichosonMasterEntity.getShichosonMeisho()));
        }

        @Test
        public void get都道府県名称は_entityが持つ都道府県名称を返す() {
            assertThat(sut.get都道府県名称(), is(KoseiShichosonMasterEntity.getTodofukenMeisho()));
        }

        @Test
        public void get郡名称は_entityが持つ郡名称を返す() {
            assertThat(sut.get郡名称(), is(KoseiShichosonMasterEntity.getGunMeisho()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(KoseiShichosonMasterEntity.getYubinNo()));
        }

        @Test
        public void get住所は_entityが持つ住所を返す() {
            assertThat(sut.get住所(), is(KoseiShichosonMasterEntity.getJusho()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(KoseiShichosonMasterEntity.getTelNo()));
        }

        @Test
        public void get最優先地区コードは_entityが持つ最優先地区コードを返す() {
            assertThat(sut.get最優先地区コード(), is(KoseiShichosonMasterEntity.getYusenChikuCode()));
        }

        @Test
        public void get帳票用都道府県名称表示有無は_entityが持つ帳票用都道府県名称表示有無を返す() {
            assertThat(sut.get帳票用都道府県名称表示有無(), is(KoseiShichosonMasterEntity.getTyohyoTodoufukenHyojiUmu()));
        }

        @Test
        public void get帳票用郡名称表示有無は_entityが持つ帳票用郡名称表示有無を返す() {
            assertThat(sut.get帳票用郡名称表示有無(), is(KoseiShichosonMasterEntity.getTyohyoGunHyojiUmu()));
        }

        @Test
        public void get帳票用市町村名称表示有無は_entityが持つ帳票用市町村名称表示有無を返す() {
            assertThat(sut.get帳票用市町村名称表示有無(), is(KoseiShichosonMasterEntity.getTyohyoShichosonHyojiUmu()));
        }

        @Test
        public void get帳票用住所編集方法は_entityが持つ帳票用住所編集方法を返す() {
            assertThat(sut.get帳票用住所編集方法(), is(KoseiShichosonMasterEntity.getTyohyoJushoHenshuHouhou()));
        }

        @Test
        public void get帳票用方書表示有無は_entityが持つ帳票用方書表示有無を返す() {
            assertThat(sut.get帳票用方書表示有無(), is(KoseiShichosonMasterEntity.getTyohyoKatagakiHyojiUmu()));
        }

        @Test
        public void get外国人氏名表示方法は_entityが持つ外国人氏名表示方法を返す() {
            assertThat(sut.get外国人氏名表示方法(), is(KoseiShichosonMasterEntity.getGaikokujinHyojiHouhou()));
        }

        @Test
        public void get老人保健市町村番号は_entityが持つ老人保健市町村番号を返す() {
            assertThat(sut.get老人保健市町村番号(), is(KoseiShichosonMasterEntity.getRojinhokenShichosonNo()));
        }

        @Test
        public void get老人保健受給者番号体系は_entityが持つ老人保健受給者番号体系を返す() {
            assertThat(sut.get老人保健受給者番号体系(), is(KoseiShichosonMasterEntity.getRokenJukyushaNoTaikei()));
        }

        @Test
        public void get特徴分配集約は_entityが持つ特徴分配集約を返す() {
            assertThat(sut.get特徴分配集約(), is(KoseiShichosonMasterEntity.getTokuchoBunpaishuyaku()));
        }

        @Test
        public void get移行日は_entityが持つ移行日を返す() {
            assertThat(sut.get移行日(), is(KoseiShichosonMasterEntity.getIkoYMD()));
        }

        @Test
        public void get加入日は_entityが持つ加入日を返す() {
            assertThat(sut.get加入日(), is(KoseiShichosonMasterEntity.getKanyuYMD()));
        }

        @Test
        public void get離脱日は_entityが持つ離脱日を返す() {
            assertThat(sut.get離脱日(), is(KoseiShichosonMasterEntity.getRidatsuYMD()));
        }

        @Test
        public void get合併旧市町村区分は_entityが持つ合併旧市町村区分を返す() {
            assertThat(sut.get合併旧市町村区分(), is(KoseiShichosonMasterEntity.getGappeiKyuShichosonKubun()));
        }

        @Test
        public void get合併旧市町村表示有無は_entityが持つ合併旧市町村表示有無を返す() {
            assertThat(sut.get合併旧市町村表示有無(), is(KoseiShichosonMasterEntity.getGappeiKyuShichosonHyojiUmu()));
        }

        @Test
        public void get合併情報地域番号は_entityが持つ合併情報地域番号を返す() {
            assertThat(sut.get合併情報地域番号(), is(KoseiShichosonMasterEntity.getGappeiChiikiNo()));
        }

        @Test
        public void get運用保険者番号は_entityが持つ運用保険者番号を返す() {
            assertThat(sut.get運用保険者番号(), is(KoseiShichosonMasterEntity.getUnyoHokenshaNo()));
        }

        @Test
        public void get運用開始日は_entityが持つ運用開始日を返す() {
            assertThat(sut.get運用開始日(), is(KoseiShichosonMasterEntity.getUnyoKaishiYMD()));
        }

        @Test
        public void get運用終了日は_entityが持つ運用終了日を返す() {
            assertThat(sut.get運用終了日(), is(KoseiShichosonMasterEntity.getUnyoShuryoYMD()));
        }

        @Test
        public void get運用形態区分は_entityが持つ運用形態区分を返す() {
            assertThat(sut.get運用形態区分(), is(KoseiShichosonMasterEntity.getUnyoKeitaiKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KoseiShichosonMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonMasterEntity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMasterEntity.setShichosonShokibetsuID(市町村識別ID);

            KoseiShichosonMasterRelateEntity entity = new KoseiShichosonMasterRelateEntity();
            entity.set構成市町村マスタEntity(KoseiShichosonMasterEntity);
            sut = new KoseiShichosonMaster(entity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KoseiShichosonMasterEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KoseiShichosonMaster sut;

        @Before
        public void setUp() {
            KoseiShichosonMasterEntity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMasterEntity.setShichosonShokibetsuID(市町村識別ID);

            KoseiShichosonMasterRelateEntity entity = new KoseiShichosonMasterRelateEntity();
            entity.set構成市町村マスタEntity(KoseiShichosonMasterEntity);
            sut = new KoseiShichosonMaster(entity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KoseiShichosonMaster sut;
        private static KoseiShichosonMaster result;

        @Before
        public void setUp() {
            KoseiShichosonMasterEntity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMasterEntity.setShichosonShokibetsuID(市町村識別ID);

        }

        @Test
        public void KoseiShichosonMasterが保持するDbT7051KoseiShichosonMasterEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKoseiShichosonMasterが保持するDbT7051KoseiShichosonMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonMaster(EntityDataState.Unchanged, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoseiShichosonMasterが保持するDbT7051KoseiShichosonMasterEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKoseiShichosonMasterが保持するDbT7051KoseiShichosonMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonMaster(EntityDataState.Modified, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoseiShichosonMasterが保持するDbT7051KoseiShichosonMasterEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKoseiShichosonMasterが保持するDbT7051KoseiShichosonMasterEntityのEntityDataStateがDeletedに指定されたKoseiShichosonMasterが返る() {
            sut = TestSupport.setStateKoseiShichosonMaster(EntityDataState.Deleted, EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KoseiShichosonMasterが保持するDbT7051KoseiShichosonMasterEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKoseiShichosonMaster(EntityDataState.Added, EntityDataState.Unchanged);
            result = sut.deleted();
        }

        @Test
        public void KoseiShichosonMasterが保持するKoseiShichosonShishoMasterで保持するEntityのEntityDataStateがUnchangedであった場合_deletedメソッド_によりEntityDataStateがDeletedとなる() {
            sut = TestSupport.setStateKoseiShichosonMaster(EntityDataState.Unchanged, EntityDataState.Unchanged);
            result = sut.deleted();
            for (KoseiShichosonShishoMaster seishinTechoNini : result.getKoseiShichosonShishoMasterList()) {
                assertThat(seishinTechoNini.toEntity().getState(), is(EntityDataState.Deleted));
            }
        }
    }

    @Ignore
    public static class getKoseiShichosonShishoMasterテスト extends DbzTestBase {

        private static KoseiShichosonMaster sut;
        private static KoseiShichosonShishoMaster resultKoseiShichosonShishoMaster;
        private static KoseiShichosonShishoMasterIdentifier techoNiniId;

        @Before
        public void setUp() {
            KoseiShichosonMasterEntity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            KoseiShichosonMasterEntity.setShichosonShokibetsuID(市町村識別ID);

        }

        @Test
        public void 指定の識別子に該当するKoseiShichosonShishoMasterが存在する場合_getKoseiShichosonShishoMaster_は該当のShokyakuShisanGaichoを返す() {
            sut = TestSupport.createKoseiShichosonMaster();
            techoNiniId = new KoseiShichosonShishoMasterIdentifier(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード, DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード);
            resultKoseiShichosonShishoMaster = sut.getKoseiShichosonShishoMaster(techoNiniId);
            assertThat(resultKoseiShichosonShishoMaster.identifier(), is(techoNiniId));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 指定の識別子に該当するKoseiShichosonShishoMasterが存在しない場合_getKoseiShichosonShishoMaster_はIllegalArgumentExceptionを返す() {
            sut = TestSupport.createKoseiShichosonMaster();
            techoNiniId = new KoseiShichosonShishoMasterIdentifier(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード, DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード);
            resultKoseiShichosonShishoMaster = sut.getKoseiShichosonShishoMaster(techoNiniId);
        }
    }

    private static class TestSupport {

        private static DbT7052KoseiShichosonShishoMasterEntity techoNiniEntity_1;
        private static DbT7052KoseiShichosonShishoMasterEntity techoNiniEntity_2;

        public static KoseiShichosonMaster setStateKoseiShichosonMaster(EntityDataState parentState, EntityDataState childState) {
            KoseiShichosonMasterRelateEntity relateEntity = new KoseiShichosonMasterRelateEntity();
            KoseiShichosonMasterEntity.setState(parentState);
            relateEntity.set構成市町村マスタEntity(KoseiShichosonMasterEntity);
            List<DbT7052KoseiShichosonShishoMasterEntity> niniEntityList = new ArrayList<>();

            techoNiniEntity_1 = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            techoNiniEntity_1.setShichosonCode(KoseiShichosonMasterEntity.getShichosonCode());
            techoNiniEntity_1.setShishoCode(new ShishoCode("値１"));
            techoNiniEntity_1.setState(childState);
            techoNiniEntity_2 = techoNiniEntity_1.clone();
            techoNiniEntity_2.setShishoCode(new ShishoCode("値２"));
            niniEntityList.add(techoNiniEntity_1);
            niniEntityList.add(techoNiniEntity_2);
            relateEntity.set構成市町村支所マスタEntity(niniEntityList);

            return new KoseiShichosonMaster(relateEntity);
        }

        public static KoseiShichosonMaster createKoseiShichosonMaster() {
            KoseiShichosonMasterRelateEntity relateEntity = new KoseiShichosonMasterRelateEntity();
            relateEntity.set構成市町村マスタEntity(KoseiShichosonMasterEntity);

            List<DbT7052KoseiShichosonShishoMasterEntity> niniEntityList = new ArrayList<>();
            techoNiniEntity_1 = DbT7052KoseiShichosonShishoMasterEntityGenerator.createDbT7052KoseiShichosonShishoMasterEntity();
            techoNiniEntity_1.setShichosonCode(KoseiShichosonMasterEntity.getShichosonCode());
            niniEntityList.add(techoNiniEntity_1);
            relateEntity.set構成市町村支所マスタEntity(niniEntityList);

            return new KoseiShichosonMaster(relateEntity);
        }

    }
}
