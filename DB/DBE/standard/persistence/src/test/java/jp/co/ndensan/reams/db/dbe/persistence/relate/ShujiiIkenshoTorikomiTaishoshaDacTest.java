/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

//import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
//import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;
//import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5001NinteiShinseiJohoEntityMock;
//import jp.co.ndensan.reams.db.dbe.entity.helper.NinteiShinchokuJohoMock;
//import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.NinteiShinchokuJohoDacMock;
//import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.NinteiShinseiJohoDacMock;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
//import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
//import static org.junit.Assert.assertThat;
//import static org.hamcrest.CoreMatchers.is;
//import org.junit.BeforeClass;

/**
 * 主治医意見書取込対象者Dacのテストクラスです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoTorikomiTaishoshaDacTest extends DbeTestDacBase {
    // TODO N8187 久保田英男
    // NinteiShinchokuJoho の市町村コードのDBカラム名と、DB項目定義クラスの市町村コード名が異なっているためinsertできない。
    // カラム名が解決したら試験予定 2014年4月末
//
//    private static ShujiiIkenshoTorikomiTaishoshaDac sut;
//    private static NinteiShinchokuJohoDacMock ninteiShinchokuJohoDacMock;
//    private static NinteiShinseiJohoDacMock ninteiShinseiJohoDacMock;
//    private static FlexibleDate 未完了年月日 = new FlexibleDate("00000000");
//    private static FlexibleDate 完了済年月日 = new FlexibleDate("20140101");
//    private static RString 申請書管理番号0001 = new RString("0001");
//    private static RString 申請書管理番号0002 = new RString("0002");
//    private static ShichosonCode 登録あり市町村コード = new ShichosonCode(new RString("001"));
//    private static ShichosonCode 登録なし市町村コード = new ShichosonCode(new RString("001"));
//    private static RString 登録あり支所コード = new RString("0001");
//    private static RString 登録なし支所コード = new RString("0001");
//
//    enum IkenshoShinchoku {
//
//        未依頼,
//        意見書作成依頼済_登録未完了,
//        意見書作成依頼済_登録完了済
//    };
//
//    @BeforeClass
//    public static void setUpClass() {
//        sut = InstanceProvider.create(ShujiiIkenshoTorikomiTaishoshaDac.class);
//        ninteiShinchokuJohoDacMock = InstanceProvider.create(NinteiShinchokuJohoDacMock.class);
//        ninteiShinseiJohoDacMock = InstanceProvider.create(NinteiShinseiJohoDacMock.class);
//    }
//
//    public static class selectAll extends DbeTestDacBase {
//
//        @Test
//        public void selectAll_対象者0件の場合() {
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり市町村コード, 登録あり支所コード));
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録完了済));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり市町村コード, 登録あり支所コード));
//            assertThat(sut.selectAll().size(), is(0));
//        }
//
//        @Test
//        public void selectAll_対象者1件の場合() {
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり市町村コード, 登録あり支所コード));
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり市町村コード, 登録あり支所コード));
//            assertThat(sut.selectAll().size(), is(1));
//        }
//    }
//
//    public static class select市町村コード extends DbeTestDacBase {
//
//        @Test
//        public void select市町村コード_対象者0件の場合() {
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり市町村コード, 登録あり支所コード));
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録完了済));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり市町村コード, 登録あり支所コード));
//            assertThat(sut.select市町村コード(登録あり市町村コード).size(), is(0));
//        }
//
//        @Test
//        public void select市町村コード_対象者1件_市町村コード一致0件の場合() {
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり市町村コード, 登録あり支所コード));
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり市町村コード, 登録あり支所コード));
//            assertThat(sut.select市町村コード(登録なし市町村コード).size(), is(0));
//        }
//
//        @Test
//        public void select市町村コード_対象者2件_市町村コード一致1件の場合() {
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.意見書作成依頼済_登録未完了));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録なし市町村コード, 登録なし支所コード));
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.意見書作成依頼済_登録未完了));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり市町村コード, 登録あり支所コード));
//            assertThat(sut.select市町村コード(登録あり市町村コード).size(), is(1));
//        }
//    }
//
//    public static class select市町村コード及び支所コード extends DbeTestDacBase {
//
//        @Test
//        public void select市町村コード及び支所コード_対象者0件の場合() {
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり市町村コード, 登録あり支所コード));
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録完了済));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり市町村コード, 登録あり支所コード));
//            assertThat(sut.select市町村コード及び支所コード(登録あり市町村コード, 登録あり支所コード).size(), is(0));
//        }
//
//        @Test
//        public void select市町村コード及び支所コード_対象者1件_一致0件の場合() {
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.未依頼));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録あり市町村コード, 登録あり支所コード));
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0002, IkenshoShinchoku.意見書作成依頼済_登録未完了));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり市町村コード, 登録あり支所コード));
//            assertThat(sut.select市町村コード及び支所コード(登録なし市町村コード, 登録なし支所コード).size(), is(0));
//        }
//
//        @Test
//        public void select市町村コード及び支所コード_対象者2件_一致1件の場合() {
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.意見書作成依頼済_登録未完了));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0001, 登録なし市町村コード, 登録なし支所コード));
//            ninteiShinchokuJohoDacMock.insert(create認定進捗情報Entity(申請書管理番号0001, IkenshoShinchoku.意見書作成依頼済_登録未完了));
//            ninteiShinseiJohoDacMock.insert(create認定申請情報Entity(申請書管理番号0002, 登録あり市町村コード, 登録あり支所コード));
//            assertThat(sut.select市町村コード及び支所コード(登録あり市町村コード, 登録あり支所コード).size(), is(1));
//        }
//    }
//
//    private static DbT5005NinteiShinchokuJohoEntity create認定進捗情報Entity(RString 申請書管理番号, IkenshoShinchoku 調査進捗) {
//        DbT5005NinteiShinchokuJohoEntity entity = NinteiShinchokuJohoMock.create認定進捗情報Entity();
//        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
//        switch (調査進捗) {
//            case 未依頼:
//                entity.setIkenshoSakuseiIraiKanryoYMD(未完了年月日);
//                entity.setIkenshoTorokuKanryoYMD(未完了年月日);
//                break;
//            case 意見書作成依頼済_登録未完了:
//                entity.setIkenshoSakuseiIraiKanryoYMD(完了済年月日);
//                entity.setIkenshoTorokuKanryoYMD(未完了年月日);
//                break;
//            case 意見書作成依頼済_登録完了済:
//                entity.setIkenshoSakuseiIraiKanryoYMD(完了済年月日);
//                entity.setIkenshoTorokuKanryoYMD(完了済年月日);
//                break;
//        }
//        return entity;
//    }
//
//    private static DbT5001NinteiShinseiJohoEntity create認定申請情報Entity(RString 申請書管理番号, ShichosonCode 市町村コード, RString 支所コード) {
//        DbT5001NinteiShinseiJohoEntity entity = DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance();
//        entity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
//        entity.setShichosonCode(市町村コード);
//        entity.setShishoCode(支所コード);
//        return entity;
//    }
}
