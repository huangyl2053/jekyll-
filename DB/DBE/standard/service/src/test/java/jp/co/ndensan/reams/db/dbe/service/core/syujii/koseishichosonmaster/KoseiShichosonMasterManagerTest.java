/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.syujii.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbe.business.core.syujii.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5911ShujiiIryoKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbe.service.core.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link KoseiShichosonMasterManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterManagerTest extends DbeTestDacBase {

    private static MapperProvider provider;
    private static DbT5051KoseiShichosonMasterDac dac;
    private static KoseiShichosonMasterManager sut;
    private static ShujiiIryoKikanJohoManager 主治医医療機関情報Manager;

    @BeforeClass
    public static void test() {
        provider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT5051KoseiShichosonMasterDac.class);
        主治医医療機関情報Manager = InstanceProvider.create(ShujiiIryoKikanJohoManager.class);
        sut = new KoseiShichosonMasterManager(provider, dac, 主治医医療機関情報Manager);
    }

    public static class createInstanceのテスト extends DbeTestDacBase {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            KoseiShichosonMasterManager result = KoseiShichosonMasterManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            KoseiShichosonMasterManager result = KoseiShichosonMasterManager.createInstance();
            assertThat(result, instanceOf(KoseiShichosonMasterManager.class));
        }
    }

    public static class get構成市町村マスタ extends DbeTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get構成市町村マスタ(null);
        }

        @Test
        public void 検索結果がnullの場合() {

            RString 市町村識別ID = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;

            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(市町村識別ID);
            KoseiShichosonMaster result = sut.get構成市町村マスタ(構成市町村マスタ検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {

            RString 市町村識別ID = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(市町村識別ID);
            sut.save(構成市町村マスタ);

            KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件 = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(市町村識別ID);
            KoseiShichosonMaster result = sut.get構成市町村マスタ(構成市町村マスタ検索条件);

            assertThat(result, is(notNullValue()));
        }
    }

//
//    public static class save構成市町村マスタ extends DbeTestBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//// 構成市町村マスタ
//            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);
//            when(主治医医療機関情報Manager.save主治医医療機関情報(any(ShujiiIryoKikanJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
//            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1, 主キー2);
//
//            assertThat(sut.save(構成市町村マスタ)
//                    , is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 構成市町村マスタ
//            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);
//            when(主治医医療機関情報Manager.save主治医医療機関情報(any(ShujiiIryoKikanJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
//            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1, 主キー2);
//
//            assertThat(sut.save(構成市町村マスタ)
//                    , is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
//// 構成市町村マスタ
//            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);
//            when(主治医医療機関情報Manager.save主治医医療機関情報(any(ShujiiIryoKikanJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
//            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1, 主キー2);
//            構成市町村マスタ = TestSupport.initializeSeishinTecho(構成市町村マスタ);
//            構成市町村マスタ = TestSupport.modifiedKoseiShichosonMaster(構成市町村マスタ);
//
//            assertThat(sut.save(構成市町村マスタ)
//                    , is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 構成市町村マスタ
//            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);
//            when(主治医医療機関情報Manager.save主治医医療機関情報(any(ShujiiIryoKikanJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
//            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1, 主キー2);
//            構成市町村マスタ = TestSupport.initializeSeishinTecho(構成市町村マスタ);
//            構成市町村マスタ = TestSupport.modifiedKoseiShichosonMaster(構成市町村マスタ);
//
//            assertThat(sut.save(構成市町村マスタ)
//                    , is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//// 構成市町村マスタ
//            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);
//            when(主治医医療機関情報Manager.save主治医医療機関情報(any(ShujiiIryoKikanJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
//            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1, 主キー2);
//            構成市町村マスタ = TestSupport.initializeKoseiShichosonMaster(構成市町村マスタ);
//            構成市町村マスタ = 構成市町村マスタ.deleted();
//
//            assertThat(sut.save(構成市町村マスタ)
//                    , is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 構成市町村マスタ
//            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);
//            when(主治医医療機関情報Manager.save主治医医療機関情報(any(ShujiiIryoKikanJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
//            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1, 主キー2);
//            構成市町村マスタ = TestSupport.initializeKoseiShichosonMaster(構成市町村マスタ);
//            構成市町村マスタ = 構成市町村マスタ.deleted();
//
//            assertThat(sut.save(構成市町村マスタ)
//                    , is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 構成市町村マスタ
//            when(dac.save(any(DbT5051KoseiShichosonMasterEntity.class))).thenReturn(1);
//            when(主治医医療機関情報Manager.save主治医医療機関情報(any(ShujiiIryoKikanJoho.class))).thenReturn(1);
//
//    主キー型1 主キー1 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_主キー2;
//            KoseiShichosonMaster 構成市町村マスタ = TestSupport.createKoseiShichosonMaster(主キー1, 主キー2);
//            構成市町村マスタ = TestSupport.initializeKoseiShichosonMaster(構成市町村マスタ);
//
//            assertThat(sut.save(構成市町村マスタ)
//                    , is(false));
//        }
//    }
    private static class TestSupport {

        public static KoseiShichosonMaster createKoseiShichosonMaster(RString shichosonShokibetsuID) {
            KoseiShichosonMaster 構成市町村マスタ = new KoseiShichosonMaster(shichosonShokibetsuID);
            return 構成市町村マスタ.createBuilderForEdit()
                    .set市町村コード(new LasdecCode("123456"))
                    .set証記載保険者番号(new ShoKisaiHokenshaNo("123456"))
                    .set市町村名称(new RString("1"))
                    .set帳票用都道府県名称表示有無(new RString("1"))
                    .set帳票用郡名称表示有無(new RString("1"))
                    .set帳票用市町村名称表示有無(new RString("1"))
                    .set帳票用住所編集方法(new RString("1"))
                    .set帳票用方書表示有無(new RString("1"))
                    .set外国人氏名表示方法(new RString("1"))
                    .set加入日(new FlexibleDate("20150402"))
                    .set運用開始日(new FlexibleDate("20150402"))
                    .set運用終了日(new FlexibleDate("20150402"))
                    .set運用形態区分(new RString("1"))
                    .set運用保険者番号(new ShoKisaiHokenshaNo("123456"))
                    // 主治医医療機関情報
                    .setShujiiIryoKikanJoho(createShujiiIryoKikanJoho())
                    .build();
        }

// 主治医医療機関情報
        private static ShujiiIryoKikanJoho createShujiiIryoKikanJoho() {
            ShujiiIryoKikanJohoRelateEntity entity = new ShujiiIryoKikanJohoRelateEntity();
            entity.set主治医医療機関情報Entity(DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity());
            return new ShujiiIryoKikanJoho(entity);
        }
//
//        public static KoseiShichosonMaster initializeKoseiShichosonMaster(KoseiShichosonMaster 構成市町村マスタ) {
//
//            DbT5051KoseiShichosonMasterEntity techoEntity = 構成市町村マスタ.toEntity();
//
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            List<ShujiiIryoKikanJohoEntity> ShujiiIryoKikanJohoEntityList = new ArrayList<>();
//            List<ShujiiIryoKikanJoho> 主治医医療機関情報リスト = XXX.getShujiiIryoKikanJohoList();
//            for (ShujiiIryoKikanJoho 主治医医療機関情報 : 主治医医療機関情報リスト) {
//                ShujiiIryoKikanJohoEntityList.add(主治医医療機関情報.toEntity());
//            }
//
//            KoseiShichosonMasterEntity relateEntity = new KoseiShichosonMasterEntity();
//            relateEntity.set構成市町村マスタEntity(techoEntity);
//            relateEntity.set主治医医療機関情報Entity(ShujiiIryoKikanJohoEntityList);
//            relateEntity.initializeMd5ToEntities();
//
//// 構成市町村マスタ
//            return new KoseiShichosonMaster(relateEntity);
//        }
//
//        public static KoseiShichosonMaster modifiedKoseiShichosonMaster(KoseiShichosonMaster 構成市町村マスタ) {
//
//// 主治医医療機関情報
//            ShujiiIryoKikanJohoBuilder ShujiiIryoKikanJohoBuilder = XXX.getShujiiIryoKikanJohoList().get(0).createBuilderForEdit();
//            ShujiiIryoKikanJoho ShujiiIryoKikanJoho = ShujiiIryoKikanJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            XXX = XXX.createBuilderForEdit()
//                    .set交付備考(new RString("交付備考を変更"))  // TODO 任意項目の値を変更してください。
//// 主治医医療機関情報
//                    .setShujiiIryoKikanJoho(ShujiiIryoKikanJoho)
//                    .build();
//            return XXX.modified();
//        }
    }
}
