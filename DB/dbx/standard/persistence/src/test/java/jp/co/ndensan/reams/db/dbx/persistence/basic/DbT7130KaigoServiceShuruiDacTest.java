/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoServiceBunruiCode;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.contains;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護サービス種類テーブルにアクセスするクラスのテストクラスです。
 *
 * @author LDNS 梁百川
 */
@RunWith(Enclosed.class)
public class DbT7130KaigoServiceShuruiDacTest extends DbxTestDacBase {

    private static DbT7130KaigoServiceShuruiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
    }

    public static class selectListのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert();
        }

        @Test
        public void LDNS_引数を設定した場合_selectListは_サイズが１のリストを返す() {
            ITrueFalseCriteria criteria = contains(DbT7130KaigoServiceShurui.serviceShuruiCd, new KaigoServiceShuruiCode("01").toString());
            assertThat(sut.selectList(criteria).size(), is(1));
        }
    }

    public static class insertOrUpdateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert();
        }

        @Test
        public void LDNS_updateの場合_insertOrUpdateは_１を返す() {
            DbT7130KaigoServiceShuruiEntity entity = TestSupport.createDbT7130KaigoServiceShurui();
            entity.setServiceShuruiMeisho(new RString("サービス種類名称1"));
            assertThat(sut.insertOrUpdate(entity), is(1));
        }

        @Test
        public void LDNS_insertの場合_insertOrUpdateは_１を返す() {
            DbT7130KaigoServiceShuruiEntity entity = TestSupport.createDbT7130KaigoServiceShurui();
            entity.setServiceShuruiCd(new KaigoServiceShuruiCode("02"));
            assertThat(sut.insertOrUpdate(entity), is(1));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert();
        }

        @Test
        public void LDNS_引数を設定した場合_deleteは_１を返す() {
            DbT7130KaigoServiceShuruiEntity entity = TestSupport.createDbT7130KaigoServiceShurui();
            assertThat(sut.delete(entity), is(1));
        }

    }

    private static class TestSupport {

        public static DbT7130KaigoServiceShuruiEntity createDbT7130KaigoServiceShurui() {
            DbT7130KaigoServiceShuruiEntity entity = new DbT7130KaigoServiceShuruiEntity();
            entity.setServiceShuruiCd(new KaigoServiceShuruiCode("01"));
            entity.setTeikyoKaishiYM(new FlexibleYearMonth("201304"));
            entity.setTeikyoshuryoYM(new FlexibleYearMonth("201305"));
            entity.setServiceShuruiMeisho(new RString("サービス種類名称"));
            entity.setServiceShuruiRyakusho(new RString("サービス種類略称"));
            entity.setServiceBunrruicode(new KaigoServiceBunruiCode(new RString("001")));
            return entity;
        }

        public static void insert() {
            DbT7130KaigoServiceShuruiEntity entity = createDbT7130KaigoServiceShurui();
            sut.insert(entity);
        }

        public static void deleteData() {
            CSVDataUtilForUseSession utilForUseSession = new CSVDataUtilForUseSession();
            utilForUseSession.clearTable(sqlSession, DbT7130KaigoServiceShuruiEntity.TABLE_NAME.toString());
        }
    }

}
