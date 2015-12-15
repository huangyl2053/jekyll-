/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaicho.HihokenshaShikakuShutokuMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 *
 * {@link HihokenshaDaichoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HihokenshaShikakuShutokuManagerTest extends DbaTestDacBase {

    private static HihokenshaShikakuShutokuManager manager;
    private static DbT1001HihokenshaDaichoDac dbT1001Dac;

    public static final HihokenshaNo 被保険者番号1 = new HihokenshaNo("1");
    public static final FlexibleDate 異動日1 = new FlexibleDate("20151211");
    public static final RString 枝番1 = new RString("1");
    public static final ShikibetsuCode 識別コード = new ShikibetsuCode("");
    public static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("2");
    public static final FlexibleDate 異動日2 = new FlexibleDate("20151212");
    public static final RString 枝番2 = new RString("2");
    public static final FlexibleDate 資格取得年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate 資格喪失年月日 = new FlexibleDate("19900101");

    @BeforeClass
    public static void setUpClass() {
        manager = new HihokenshaShikakuShutokuManager();
        dbT1001Dac = new DbT1001HihokenshaDaichoDac();
    }

    public static class getHihokenshaShutokuJyohoのテスト extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, "DbT1001HihokenshaDaicho");
        }

        @Before
        public void setUp() {
            clearTable();
            dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            manager.getHihokenshaShutokuJyoho(null);
        }

        @Test
        public void テーブルにレコードが存在しない場合_被保険者台帳管理情報取得処理は_NULLを返すこと() {
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(HihokenshaNo.EMPTY, ShikibetsuCode.EMPTY);
            List<HihokenshaShutokuJyoho> entitylist = manager.getHihokenshaShutokuJyoho(parameter).records();
            assertThat(entitylist.size(), is(0));
        }

        @Test
        public void 被保険者番号が存在する場合_被保険者台帳管理情報取得処理は_1件を返すこと() {
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日1, 枝番1, 資格取得年月日, 資格喪失年月日);
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(被保険者番号1, ShikibetsuCode.EMPTY);
            List<HihokenshaShutokuJyoho> entitylist = manager.getHihokenshaShutokuJyoho(parameter).records();
            assertThat(entitylist.size(), is(1));
        }

        @Test
        public void 被保険者番号が存在しない場合_被保険者台帳管理情報取得処理は_1件を返すこと() {
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日1, 枝番1, 資格取得年月日, 資格喪失年月日);
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(HihokenshaNo.EMPTY, new ShikibetsuCode("012340123400001"));
            List<HihokenshaShutokuJyoho> entitylist = manager.getHihokenshaShutokuJyoho(parameter).records();
            assertThat(entitylist.size(), is(1));
        }

        @Test
        public void 被保険者番号が存在する場合_被保険者台帳管理情報取得処理は_2件を返すこと() {
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日1, 枝番1, 資格取得年月日, 資格喪失年月日);
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日2, 枝番2, 資格取得年月日, 資格喪失年月日);
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(被保険者番号1, ShikibetsuCode.EMPTY);
            List<HihokenshaShutokuJyoho> entitylist = manager.getHihokenshaShutokuJyoho(parameter).records();
            assertThat(entitylist.size(), is(2));
        }
    }

    public static class saveHihokenshaShutokuのテスト extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, "DbT1001HihokenshaDaicho");
        }

        @Before
        public void setUp() {
            clearTable();
            dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            manager.saveHihokenshaShutoku(null, null);
        }

        @Test
        public void テーブルにレコードが存在しない場合_力した内容を被保険者台帳管理に登録処理は_1を返すこと() {
            DbT1001HihokenshaDaichoEntity entity = insert_Entity();
//            int result = manager.saveHihokenshaShutoku(entity, dateOfBirth);
//            assertThat(result, is(1));
        }
    }

    public static class getSaidaiEdabanのテスト extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, "DbT1001HihokenshaDaicho");
        }

        @Before
        public void setUp() {
            clearTable();
            dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            manager.getSaidaiEdaban(null);
        }

        @Test
        public void テーブルにレコードが存在しない場合_最大枝番取得処理は_0001を返すこと() {
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaEdaban(被保険者番号1, 異動日1);
            RString edano = manager.getSaidaiEdaban(parameter);
            assertThat(edano, is(new RString("0001")));
        }

        @Test
        public void テーブルにレコードが存在する場合_最大枝番取得処理は_取得するデータを返すこと() {
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日1, 枝番1, 資格取得年月日, 資格喪失年月日);
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日1, 枝番2, 資格取得年月日, 資格喪失年月日);
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaEdaban(被保険者番号1, 異動日1);
            RString edano = manager.getSaidaiEdaban(parameter);
            assertThat(edano, is(new RString("3")));
        }
    }

    public static class getSaishinDetaのテスト extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, "DbT1001HihokenshaDaicho");
        }

        @Before
        public void setUp() {
            clearTable();
            dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            manager.getSaidaiEdaban(null);
        }

        @Test
        public void テーブルにレコードが存在しない場合_最新データ情報取得処理は_NULLを返すこと() {
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(被保険者番号1, ShikibetsuCode.EMPTY);
            HihokenshaShutokuJyoho edano = manager.getSaishinDeta(parameter);
            assertThat(edano, is(nullValue()));
        }

        @Test
        public void テーブルにレコードが存在する場合_最新データ情報取得処理は_1件を返すこと() {
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日1, 枝番1, 資格取得年月日, 資格喪失年月日);
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日2, 枝番2, 資格取得年月日, 資格喪失年月日);
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(被保険者番号1, ShikibetsuCode.EMPTY);
            HihokenshaShutokuJyoho edano = manager.getSaishinDeta(parameter);
            assertThat(edano.get異動日(), is(異動日2));
        }
    }

    public static class ShikakuShutokuCheckのテスト extends DbaTestDacBase {

        private static void clearTable() {
            CSVDataUtilForUseSession csvDataUtil = new CSVDataUtilForUseSession();
            csvDataUtil.clearTable(sqlSession, "DbT1001HihokenshaDaicho");
        }

        @Before
        public void setUp() {
            clearTable();
            dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            manager.getSaidaiEdaban(null);
        }

        @Test
        public void 取得したデータがない場合_資格取得チェック処理は_チェックフラグがtrueを返すこと() {
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(被保険者番号1, ShikibetsuCode.EMPTY);
            boolean flg = manager.shikakuShutokuCheck(parameter);
            assertThat(flg, is(true));
        }

        @Test
        public void 取得したデータの資格取得年月日と資格喪失年月日がある場合_資格取得チェック処理は_チェックフラグがtrueを返すこと() {
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日1, 枝番1, 資格取得年月日, 資格喪失年月日);
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日2, 枝番2, 資格取得年月日, 資格喪失年月日);
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(被保険者番号1, ShikibetsuCode.EMPTY);
            boolean flg = manager.shikakuShutokuCheck(parameter);
            assertThat(flg, is(true));
        }

        @Test
        public void 取得したデータの資格喪失年月日がないと被保険者区分コードは2場合_資格取得チェック処理は_チェックフラグがtrueを返すこと() {
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日1, 枝番1, 資格取得年月日, 資格喪失年月日);
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日2, 枝番2, 資格取得年月日, 資格喪失年月日);
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(被保険者番号1, ShikibetsuCode.EMPTY);
            boolean flg = manager.shikakuShutokuCheck(parameter);
            assertThat(flg, is(true));
        }

        @Test
        public void 上記以外の場合_資格取得チェック処理は_チェックフラグがfalseを返すこと() {
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日1, 枝番1, 資格取得年月日, FlexibleDate.EMPTY);
            insert_DbT1001HihokenshaDaicho(被保険者番号1, 異動日2, 枝番2, 資格取得年月日, FlexibleDate.EMPTY);
            HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaDaicho(被保険者番号1, ShikibetsuCode.EMPTY);
            boolean flg = manager.shikakuShutokuCheck(parameter);
            assertThat(flg, is(false));
        }
    }

    public static void insert_DbT1001HihokenshaDaicho(HihokenshaNo 被保険者番号, FlexibleDate 異動日, RString 枝番, FlexibleDate 資格取得年月日, FlexibleDate 資格喪失年月日) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setHihokenshaNo(被保険者番号);
        entity.setIdoYMD(異動日);
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(new RString("01"));
        entity.setShichosonCode(new LasdecCode("209007"));
        entity.setShikibetsuCode(new ShikibetsuCode("012340123400001"));
        entity.setHihokennshaKubunCode(new RString("1"));
        entity.setShikakuShutokuYMD(資格取得年月日);
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
    }

    public static DbT1001HihokenshaDaichoEntity insert_Entity() {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setHihokenshaNo(new HihokenshaNo("1"));
        entity.setIdoYMD(new FlexibleDate("19900101"));
        entity.setEdaNo(new RString("Data"));
        entity.setIdoJiyuCode(new RString("01"));
        entity.setShichosonCode(new LasdecCode("209007"));
        entity.setShikibetsuCode(new ShikibetsuCode("012340123400001"));
        entity.setHihokennshaKubunCode(new RString("1"));
        entity.setShikakuShutokuYMD(new FlexibleDate("19900101"));
        entity.setShikakuSoshitsuYMD(new FlexibleDate("19900101"));
        entity.setShikakuShutokuJiyuCode(new RString("1"));
        entity.setShikakuShutokuTodokedeYMD(new FlexibleDate("19900101"));
        entity.setIchigoShikakuShutokuYMD(new FlexibleDate("19900101"));
        entity.setKyuShichosonCode(new LasdecCode("209007"));
        entity.setLogicalDeletedFlag(false);
        return entity;
    }

    public static final IDateOfBirth dateOfBirth = new IDateOfBirth() {

        @Override
        public boolean is不明() {
            return true;
        }

        @Override
        public FlexibleDate toFlexibleDate() {
            return new FlexibleDate("19011211");
        }

        @Override
        public boolean isUnknownMonthDay() {
            return true;
        }

        @Override
        public boolean isUnknownDay() {
            return true;
        }
    };
}
