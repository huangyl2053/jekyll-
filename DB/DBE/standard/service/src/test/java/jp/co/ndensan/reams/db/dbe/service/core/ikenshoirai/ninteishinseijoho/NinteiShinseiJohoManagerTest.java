/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikenshoirai.ninteishinseijoho;

import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirai.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirai.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikenshoirai.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.helper.DbT5101NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.service.core.ikenshoirai.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5301ShujiiIkenshoIraiJohoEntityGenerator;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {link NinteiShinseiJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiShinseiJohoManagerTest extends DbeTestDacBase {

    private static MapperProvider provider;
    private static DbT5101NinteiShinseiJohoDac dac;
    private static NinteiShinseiJohoManager sut;
    private static ShujiiIkenshoIraiJohoManager 主治医意見書作成依頼情報Manager;

    @BeforeClass
    public static void test() {
        provider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        主治医意見書作成依頼情報Manager = InstanceProvider.create(ShujiiIkenshoIraiJohoManager.class);
        sut = new NinteiShinseiJohoManager(provider, dac, 主治医意見書作成依頼情報Manager);
    }

    public static class createInstanceのテスト extends DbeTestDacBase {

        @Test
        public void createInstanceのテスト_戻り値はnullでない() {
            NinteiShinseiJohoManager result = NinteiShinseiJohoManager.createInstance();
            assertNotNull(result);
        }

        @Test
        public void createInstanceのテスト_クラスのインスタンスが取得できる() {
            NinteiShinseiJohoManager result = NinteiShinseiJohoManager.createInstance();
            assertThat(result, instanceOf(NinteiShinseiJohoManager.class));
        }
    }

    public static class get要介護認定申請情報 extends DbeTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get要介護認定申請情報(null);
        }

        @Test
        public void 検索結果がnullの場合() {
            ShinseishoKanriNo 申請書管理番号 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号;
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectByKeyParam(申請書管理番号);
            NinteiShinseiJoho result = sut.get要介護認定申請情報(要介護認定申請情報検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {

            ShinseishoKanriNo 申請書管理番号 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号;
            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(申請書管理番号);
            sut.save(要介護認定申請情報);

            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectByKeyParam(申請書管理番号);
            NinteiShinseiJoho result = sut.get要介護認定申請情報(要介護認定申請情報検索条件);

            assertThat(result, is(notNullValue()));
        }
    }
//
//    public static class save要介護認定申請情報 extends DbeTestDacBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//// 要介護認定申請情報
//            when(dac.save(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);
//            when(主治医意見書作成依頼情報Manager.save主治医意見書作成依頼情報(any(ShujiiIkenshoIraiJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー2;
//            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(要介護認定申請情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 要介護認定申請情報
//            when(dac.save(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);
//            when(主治医意見書作成依頼情報Manager.save主治医意見書作成依頼情報(any(ShujiiIkenshoIraiJoho.class))).thenReturn(1);
//            主キー型1 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー2;
//            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(要介護認定申請情報), is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
//// 要介護認定申請情報
//            when(dac.save(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);
//            when(主治医意見書作成依頼情報Manager.save主治医意見書作成依頼情報(any(ShujiiIkenshoIraiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー2;
//            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(主キー1, 主キー2);
//            要介護認定申請情報 = TestSupport.initializeSeishinTecho(要介護認定申請情報);
//            要介護認定申請情報 = TestSupport.modifiedNinteiShinseiJoho(要介護認定申請情報);
//
//            assertThat(sut.save(要介護認定申請情報), is(true));
//        }
//
//        @Test
//        public void updateに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 要介護認定申請情報
//            when(dac.save(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);
//            when(主治医意見書作成依頼情報Manager.save主治医意見書作成依頼情報(any(ShujiiIkenshoIraiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー2;
//            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(主キー1, 主キー2);
//            要介護認定申請情報 = TestSupport.initializeSeishinTecho(要介護認定申請情報);
//            要介護認定申請情報 = TestSupport.modifiedNinteiShinseiJoho(要介護認定申請情報);
//
//            assertThat(sut.save(要介護認定申請情報), is(false));
//        }
//
//        @Test
//        public void deleteに成功すると_trueが返る() {
//// 要介護認定申請情報
//            when(dac.save(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);
//            when(主治医意見書作成依頼情報Manager.save主治医意見書作成依頼情報(any(ShujiiIkenshoIraiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー2;
//            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(主キー1, 主キー2);
//            要介護認定申請情報 = TestSupport.initializeNinteiShinseiJoho(要介護認定申請情報);
//            要介護認定申請情報 = 要介護認定申請情報.deleted();
//
//            assertThat(sut.save(要介護認定申請情報), is(true));
//        }
//
//        @Test
//        public void deleteに失敗すると_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 要介護認定申請情報
//            when(dac.save(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);
//            when(主治医意見書作成依頼情報Manager.save主治医意見書作成依頼情報(any(ShujiiIkenshoIraiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー2;
//            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(主キー1, 主キー2);
//            要介護認定申請情報 = TestSupport.initializeNinteiShinseiJoho(要介護認定申請情報);
//            要介護認定申請情報 = 要介護認定申請情報.deleted();
//
//            assertThat(sut.save(要介護認定申請情報), is(false));
//        }
//
//        @Test
//        public void 状態がUnchangedの場合_falseが返る() {
//// TODO 下記のすべての.thenReturn(1)を.thenReturn(0)に変更してください。
//// 要介護認定申請情報
//            when(dac.save(any(DbT5101NinteiShinseiJohoEntity.class))).thenReturn(1);
//            when(主治医意見書作成依頼情報Manager.save主治医意見書作成依頼情報(any(ShujiiIkenshoIraiJoho.class))).thenReturn(1);
//
//            主キー型1 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー2;
//            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(主キー1, 主キー2);
//            要介護認定申請情報 = TestSupport.initializeNinteiShinseiJoho(要介護認定申請情報);
//
//            assertThat(sut.save(要介護認定申請情報), is(false));
//        }
//    }

    private static class TestSupport {

        public static NinteiShinseiJoho createNinteiShinseiJoho(ShinseishoKanriNo 申請書管理番号) {
            NinteiShinseiJoho 要介護認定申請情報 = new NinteiShinseiJoho(申請書管理番号);
            return 要介護認定申請情報.createBuilderForEdit()
                    .set厚労省IF識別コード(new Code("09A"))
                    .set証記載保険者番号(new RString("2"))
                    .set申請年度(new FlexibleYear("2015"))
                    .set被保険者番号(new RString("1"))
                    .set認定申請枝番コード(new EdabanCode("123"))
                    .set認定申請区分_法令_コード(new Code("1"))
                    .set認定申請区分_申請時_コード(new Code("1"))
                    .set被保険者区分コード(new RString("1"))
                    .set生年月日(new FlexibleDate("20140402"))
                    .set被保険者氏名カナ(new AtenaKanaMeisho("アテナカナ"))
                    .set被保険者氏名(new AtenaMeisho("宛名太郎"))
                    .set郵便番号(new YubinNo("3801111"))
                    .set住所(new AtenaJusho("長野市県町"))
                    .set電話番号(new TelNo("1234567890"))
                    .set支所コード(new RString("1"))
                    .setみなし２号等対象フラグ(true)
                    .set広域内転居区分(new Code("1"))
                    .set認定申請有効区分(new Code("1"))
                    .set要介護申請_要支援申請の区分(new RString("1"))
                    .set自動割当除外者区分(new RString("1"))
                    .set情報提供への同意有無(true)
                    .set性別(new Code("1"))
                    // 主治医意見書作成依頼情報
                    .setShujiiIkenshoIraiJoho(createShujiiIkenshoIraiJoho())
                    .build();
        }

// 主治医意見書作成依頼情報
        private static ShujiiIkenshoIraiJoho createShujiiIkenshoIraiJoho() {
            return new ShujiiIkenshoIraiJoho(DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity());
        }

//        public static NinteiShinseiJoho initializeNinteiShinseiJoho(NinteiShinseiJoho 要介護認定申請情報) {
//
//            DbT5101NinteiShinseiJohoEntity techoEntity = 要介護認定申請情報.toEntity();
//
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            List<DbT5301ShujiiIkenshoIraiJohoEntity> ShujiiIkenshoIraiJohoEntityList = new ArrayList<>();
//            List<ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報リスト = XXX.getShujiiIkenshoIraiJohoList();
//            for (ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 : 主治医意見書作成依頼情報リスト) {
//                ShujiiIkenshoIraiJohoEntityList.add(主治医意見書作成依頼情報.toEntity());
//            }
//
//            NinteiShinseiJohoEntity relateEntity = new NinteiShinseiJohoEntity();
//            relateEntity.set要介護認定申請情報Entity(techoEntity);
//            relateEntity.set主治医意見書作成依頼情報Entity(ShujiiIkenshoIraiJohoEntityList);
//            relateEntity.initializeMd5ToEntities();
//
//// 要介護認定申請情報
//            return new NinteiShinseiJoho(relateEntity);
//        }
//
//        public static NinteiShinseiJoho modifiedNinteiShinseiJoho(NinteiShinseiJoho 要介護認定申請情報) {
//
//// 主治医意見書作成依頼情報
//            ShujiiIkenshoIraiJohoBuilder ShujiiIkenshoIraiJohoBuilder = XXX.getShujiiIkenshoIraiJohoList().get(0).createBuilderForEdit();
//            ShujiiIkenshoIraiJoho ShujiiIkenshoIraiJoho = ShujiiIkenshoIraiJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//// TODO 下記のXXX部は本メソッドの引数名に変更してください。
//            XXX = XXX.createBuilderForEdit()
//                    .set交付備考(new RString("交付備考を変更")) // TODO 任意項目の値を変更してください。
//                    // 主治医意見書作成依頼情報
//                    .setShujiiIkenshoIraiJoho(ShujiiIkenshoIraiJoho)
//                    .build();
//            return XXX.modified();
//        }
    }
}
