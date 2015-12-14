/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteishinseijoho;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5101NinteiShinseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteishinseijoho.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link NinteiShinseiJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiShinseiJohoManagerTest extends DbeTestDacBase {

    private static DbT5101NinteiShinseiJohoDac dac;
    private static NinteiShinseiJohoManager sut;

    private static final ShinseishoKanriNo 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号;
    private static final ShinseishoKanriNo 主キー2 = new ShinseishoKanriNo("900000");

    @BeforeClass
    public static void test() {

        dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
    }

    public static class get要介護認定申請情報 extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut = NinteiShinseiJohoManager.createInstance();
            TestSupport.clearTable();
            TestSupport.insertDbT5101(主キー1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get要介護認定申請情報(null);
        }

        @Test
        public void 検索結果がnullの場合() {

            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectByKeyParam(主キー2);
            NinteiShinseiJoho result = sut.get要介護認定申請情報(要介護認定申請情報検索条件);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            NinteiShinseiJohoEntity entity = new NinteiShinseiJohoEntity();
            entity.set要介護認定申請情報Entity(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());

            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectByKeyParam(主キー1);
            NinteiShinseiJoho result = sut.get要介護認定申請情報(要介護認定申請情報検索条件);

            assertThat(result.get申請書管理番号().getColumnValue(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号.getColumnValue()));
        }
    }

    public static class get要介護認定申請情報リストBy主キー1 extends DbeTestDacBase {

        @Before
        public void setUp() {
            sut = NinteiShinseiJohoManager.createInstance();
            TestSupport.clearTable();
            TestSupport.insertDbT5101(主キー1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get要介護認定申請情報リストBy主キー1(null);
        }

        @Test
        public void 検索結果が空の場合() {
            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectByKeyParam(主キー2);
            List<NinteiShinseiJoho> result = sut.get要介護認定申請情報リストBy主キー1(要介護認定申請情報検索条件);

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            NinteiShinseiJohoEntity entity = new NinteiShinseiJohoEntity();
            entity.set要介護認定申請情報Entity(DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity());

            List<NinteiShinseiJohoEntity> entityList = Arrays.asList(entity);

            NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件 = NinteiShinseiJohoMapperParameter.createSelectByKeyParam(主キー1);
            List<NinteiShinseiJoho> result = sut.get要介護認定申請情報リストBy主キー1(要介護認定申請情報検索条件);

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get申請書管理番号().getColumnValue(), is(DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号.getColumnValue()));
        }
    }

//    public static class save要介護認定申請情報 extends DbeTestDacBase {
//
//        @Test
//        public void insertに成功すると_trueが返る() {
//            ShinseishoKanriNo 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_申請書管理番号;
//            int 主キー2 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
//            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(要介護認定申請情報), is(true));
//        }
//
//        @Test
//        public void insertに失敗すると_falseが返る() {
//            主キー型1 主キー1 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー1;
//            主キー型2 主キー2 = DbT5101NinteiShinseiJohoEntityGenerator.DEFAULT_主キー2;
//            NinteiShinseiJoho 要介護認定申請情報 = TestSupport.createNinteiShinseiJoho(主キー1, 主キー2);
//
//            assertThat(sut.save(要介護認定申請情報), is(false));
//        }
//
//        @Test
//        public void updateに成功すると_trueが返る() {
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

        public static NinteiShinseiJoho createNinteiShinseiJoho(ShinseishoKanriNo 主キー1, int 主キー2) {
            NinteiShinseiJoho 要介護認定申請情報 = new NinteiShinseiJoho(主キー1);
            return 要介護認定申請情報.createBuilderForEdit()
                    .setNinteichosaIraiJoho(createNinteichosaIraiJoho(主キー1, 主キー2))
                    .build();
        }

        private static NinteichosaIraiJoho createNinteichosaIraiJoho(ShinseishoKanriNo 主キー1, int 主キー2) {
            return new NinteichosaIraiJoho(
                    主キー1, 主キー2);
        }

        public static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, DbT5101NinteiShinseiJohoEntity.TABLE_NAME.toString());
        }

        public static void insertDbT5101(
                ShinseishoKanriNo 主キー1) {
            DbT5101NinteiShinseiJohoEntity entity = DbT5101NinteiShinseiJohoEntityGenerator.createDbT5101NinteiShinseiJohoEntity();
            entity.setShinseishoKanriNo(主キー1);
            entity.setState(EntityDataState.Added);
            dac.insert(entity);
        }

//        public static NinteiShinseiJoho initializeNinteiShinseiJoho(NinteiShinseiJoho 要介護認定申請情報) {
//
//            DbT5101NinteiShinseiJohoEntity techoEntity = 要介護認定申請情報.toEntity();
//
//            List<NinteichosaIraiJohoEntity> ninteichosaIraiJohoEntityList = new ArrayList<>();
//            List<NinteichosaIraiJoho> 認定調査依頼情報リスト = 要介護認定申請情報.getNinteichosaIraiJohoList();
//            for (NinteichosaIraiJoho 認定調査依頼情報 : 認定調査依頼情報リスト) {
//                ninteichosaIraiJohoEntityList.add(認定調査依頼情報.toEntity());
//            }
//
//            NinteiShinseiJohoEntity relateEntity = new NinteiShinseiJohoEntity();
//            relateEntity.set要介護認定申請情報Entity(techoEntity);
//            relateEntity.set認定調査依頼情報Entity(ninteichosaIraiJohoEntityList);
//            relateEntity.initializeMd5ToEntities();
//
//            return new NinteiShinseiJoho(relateEntity);
//        }
//
//        public static NinteiShinseiJoho modifiedNinteiShinseiJoho(NinteiShinseiJoho 要介護認定申請情報) {
//
//            NinteichosaIraiJohoBuilder NinteichosaIraiJohoBuilder = XXX.getNinteichosaIraiJohoList().get(0).createBuilderForEdit();
//            NinteichosaIraiJoho NinteichosaIraiJoho = NinteichosaIraiJohoBuilder.set任意項目1(new RString("任意項目1を変更")).build();
//            XXX = XXX.createBuilderForEdit()
//                    .set交付備考(new RString("交付備考を変更"))
//                    .setNinteichosaIraiJoho(NinteichosaIraiJoho)
//                    .build();
//            return XXX.modified();
//        }
    }
}
