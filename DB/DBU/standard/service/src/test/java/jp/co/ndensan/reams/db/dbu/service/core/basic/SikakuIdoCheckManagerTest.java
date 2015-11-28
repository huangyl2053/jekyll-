/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package jp.co.ndensan.reams.db.dba.business;
package jp.co.ndensan.reams.db.dbu.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.entity.SikakuKikan;
import jp.co.ndensan.reams.db.dbu.definition.core.entity.Tasichoson;
import jp.co.ndensan.reams.db.dbu.definition.core.entity.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbu.definition.core.entity.TokusoRireki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoJogaiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * { link SikakuIdoCheckManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SikakuIdoCheckManagerTest extends DbaTestDacBase {

    private static SikakuIdoCheckManager sikakuIdoCheckManager;
    private static DbT1001HihokenshaDaichoDac hihokenshaDaiDac;
    private static DbT1002TekiyoJogaishaDac tekiyoJogaishaDac;
    private static DbT1003TashichosonJushochiTokureiDac tashichosonJushochiTokureiDac;

    public SikakuIdoCheckManagerTest() {

    }

    public static class sikakuKikanRirekiChofukuCheck extends DbaTestDacBase {

        private static final List<SikakuKikan> sikakuKikanList = new ArrayList<>();
        private static final List<SikakuKikan> 重複sikakuKikanList = new ArrayList<>();

        @BeforeClass
        public static void setUp() {
            sikakuIdoCheckManager = InstanceProvider.create(SikakuIdoCheckManager.class);

            sikakuKikanList.add(new SikakuKikan(new FlexibleDate("20140102"), new FlexibleDate("20140208"), new FlexibleDate("20140101"), RString.EMPTY));
            sikakuKikanList.add(new SikakuKikan(new FlexibleDate("20140302"), new FlexibleDate("20140408"), new FlexibleDate("20140102"), RString.EMPTY));
            sikakuKikanList.add(new SikakuKikan(new FlexibleDate("20140502"), new FlexibleDate("20140608"), new FlexibleDate("20140103"), RString.EMPTY));
            sikakuKikanList.add(new SikakuKikan(new FlexibleDate("20140702"), new FlexibleDate("20140808"), new FlexibleDate("20140104"), RString.EMPTY));

            重複sikakuKikanList.add(new SikakuKikan(new FlexibleDate("20140102"), new FlexibleDate("20140208"), new FlexibleDate("20140101"), RString.EMPTY));
            重複sikakuKikanList.add(new SikakuKikan(new FlexibleDate("20140302"), new FlexibleDate("20140408"), new FlexibleDate("20140102"), RString.EMPTY));
            重複sikakuKikanList.add(new SikakuKikan(new FlexibleDate("20140502"), new FlexibleDate("20140608"), new FlexibleDate("20140103"), RString.EMPTY));
            重複sikakuKikanList.add(new SikakuKikan(new FlexibleDate("20140702"), new FlexibleDate("20140808"), new FlexibleDate("20140104"), RString.EMPTY));
            重複sikakuKikanList.add(new SikakuKikan(new FlexibleDate("20140801"), new FlexibleDate("20140908"), new FlexibleDate("20140105"), RString.EMPTY));

        }

        @Test
        public void 資格期間の履歴重複しないの場合() {
            RString result = sikakuIdoCheckManager.sikakuKikanRirekiChofukuCheck(sikakuKikanList);
            assertThat(result, is(new RString("")));
        }

        @Test
        public void 資格期間の履歴重複の場合() {
            RString result = sikakuIdoCheckManager.sikakuKikanRirekiChofukuCheck(重複sikakuKikanList);
            assertThat(result, is(new RString("DBAE00004")));
        }
    }

    public static class tokusouTanoKikanChofukuCheck extends DbaTestDacBase {

        private static final List<TokusoRireki> tokusoRirekiLis = new ArrayList<>();

        @BeforeClass
        public static void setUp() {
            TestSupport.deleteData();

            sikakuIdoCheckManager = InstanceProvider.create(SikakuIdoCheckManager.class);
            hihokenshaDaiDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
            tekiyoJogaishaDac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
            tashichosonJushochiTokureiDac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);

            tokusoRirekiLis.add(new TokusoRireki(new FlexibleDate("20140102"), new FlexibleDate("20140208"), new FlexibleDate("20140101"), RString.EMPTY));
            tokusoRirekiLis.add(new TokusoRireki(new FlexibleDate("20140302"), new FlexibleDate("20140408"), new FlexibleDate("20140102"), RString.EMPTY));
            tokusoRirekiLis.add(new TokusoRireki(new FlexibleDate("20140502"), new FlexibleDate("20140608"), new FlexibleDate("20140103"), RString.EMPTY));
            tokusoRirekiLis.add(new TokusoRireki(new FlexibleDate("20140702"), new FlexibleDate("20140808"), new FlexibleDate("20140104"), RString.EMPTY));
        }

        @Test
        public void 得喪履歴と他の期間の重複しないの場合() {
            DbT1002TekiyoJogaishaEntity entity = new DbT1002TekiyoJogaishaEntity();
            entity.setShikibetsuCode(new ShikibetsuCode("000001"));
            entity.setTekiyoYMD(new FlexibleDate("20140902"));
            entity.setKaijoYMD(new FlexibleDate("20141010"));
            entity.setShichosonCode(new LasdecCode("000001"));
            entity.setTekiyoJogaiTekiyoJiyuCode(new KaigoJogaiTekiyoJiyu(new RString("00")));
            entity.setIdoYMD(FlexibleDate.MAX);
            entity.setEdaNo(RString.EMPTY);
            entity.setIdoJiyuCode(RString.EMPTY);
            tekiyoJogaishaDac.save(entity);
            RString result = sikakuIdoCheckManager.tokusouTanoKikanChofukuCheck(tokusoRirekiLis, new ShikibetsuCode("000001"));
            assertThat(result, is(new RString("")));
        }

        @Test
        public void 得喪履歴と他の期間の重複の場合() {
            DbT1002TekiyoJogaishaEntity entity = new DbT1002TekiyoJogaishaEntity();
            entity.setShikibetsuCode(new ShikibetsuCode("000002"));
            entity.setTekiyoYMD(new FlexibleDate("20140802"));
            entity.setKaijoYMD(new FlexibleDate("20141010"));
            entity.setShichosonCode(new LasdecCode("000002"));
            entity.setTekiyoJogaiTekiyoJiyuCode(new KaigoJogaiTekiyoJiyu(new RString("00")));
            entity.setIdoYMD(FlexibleDate.MAX);
            entity.setEdaNo(RString.EMPTY);
            entity.setIdoJiyuCode(RString.EMPTY);
            tekiyoJogaishaDac.save(entity);
            DbT1003TashichosonJushochiTokureiEntity entity1 = new DbT1003TashichosonJushochiTokureiEntity();
            entity1.setShikibetsuCode(new ShikibetsuCode("000002"));
            entity1.setTekiyoYMD(new FlexibleDate("20140802"));
            entity1.setKaijoYMD(new FlexibleDate("20141010"));
            entity1.setShichosonCode(new LasdecCode("000002"));
            entity1.setIdoYMD(FlexibleDate.MAX);
            entity1.setEdaNo(RString.EMPTY);
            entity1.setIdoJiyuCode(RString.EMPTY);
            entity1.setTekiyoJiyuCode(new KaigoTatokuTekiyoJiyu(new RString("00")));
            tashichosonJushochiTokureiDac.save(entity1);
            RString result = sikakuIdoCheckManager.tokusouTanoKikanChofukuCheck(tokusoRirekiLis, new ShikibetsuCode("000002"));
            assertThat(result, is(new RString("DBAE00005")));
        }

    }

    public static class tekiyoJogaishaChofukuCheck extends DbaTestDacBase {

        private static final List<TekiyoJogaisha> tekiyoJogaishaList = new ArrayList<>();

        @BeforeClass
        public static void setUp() {
            TestSupport.deleteData();

            sikakuIdoCheckManager = InstanceProvider.create(SikakuIdoCheckManager.class);
            hihokenshaDaiDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
            tekiyoJogaishaDac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
            tashichosonJushochiTokureiDac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);

            tekiyoJogaishaList.add(new TekiyoJogaisha(new FlexibleDate("20140102"), new FlexibleDate("20140208"), new FlexibleDate("20140101"), RString.EMPTY));
            tekiyoJogaishaList.add(new TekiyoJogaisha(new FlexibleDate("20140302"), new FlexibleDate("20140408"), new FlexibleDate("20140102"), RString.EMPTY));
            tekiyoJogaishaList.add(new TekiyoJogaisha(new FlexibleDate("20140502"), new FlexibleDate("20140608"), new FlexibleDate("20140103"), RString.EMPTY));
            tekiyoJogaishaList.add(new TekiyoJogaisha(new FlexibleDate("20140702"), new FlexibleDate("20140808"), new FlexibleDate("20140104"), RString.EMPTY));
        }

        @Test
        public void 適用除外者適用解除履歴と他の期間の重複しないの場合() {
            DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
            entity.setShikibetsuCode(new ShikibetsuCode("000001"));
            entity.setShikakuShutokuYMD(new FlexibleDate("20140902"));
            entity.setShikakuSoshitsuYMD(new FlexibleDate("20141010"));
            entity.setShichosonCode(new LasdecCode("000001"));
            entity.setHihokenshaNo(new HihokenshaNo(new RString("000001")));
            entity.setShikakuShutokuJiyuCode(new KaigoShikakuShutokuJiyu(new RString("00")));
            entity.setHihokennshaKubunCode(new RString("1"));
            entity.setIdoYMD(FlexibleDate.MAX);
            entity.setEdaNo(RString.EMPTY);
            entity.setIdoJiyuCode(RString.EMPTY);
            hihokenshaDaiDac.save(entity);
            RString result = sikakuIdoCheckManager.tekiyoJogaishaChofukuCheck(tekiyoJogaishaList, new ShikibetsuCode("000001"));
            assertThat(result, is(new RString("")));
        }

        @Test
        public void 適用除外者適用解除履歴と他の期間の重複の場合() {
            DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
            entity.setShikibetsuCode(new ShikibetsuCode("000002"));
            entity.setShikakuShutokuYMD(new FlexibleDate("20140502"));
            entity.setShikakuSoshitsuYMD(new FlexibleDate("20141010"));
            entity.setShichosonCode(new LasdecCode("000002"));
            entity.setHihokenshaNo(new HihokenshaNo(new RString("000002")));
            entity.setShikakuShutokuJiyuCode(new KaigoShikakuShutokuJiyu(new RString("00")));
            entity.setHihokennshaKubunCode(new RString("1"));
            entity.setIdoYMD(FlexibleDate.MAX);
            entity.setEdaNo(RString.EMPTY);
            entity.setIdoJiyuCode(RString.EMPTY);
            //entity.setIdoYMD(FlexibleDate.getNowDate());
            hihokenshaDaiDac.save(entity);
            DbT1003TashichosonJushochiTokureiEntity entity1 = new DbT1003TashichosonJushochiTokureiEntity();
            entity1.setShikibetsuCode(new ShikibetsuCode("000002"));
            entity1.setTekiyoYMD(new FlexibleDate("20140502"));
            entity1.setKaijoYMD(new FlexibleDate("20141010"));
            entity1.setShichosonCode(new LasdecCode("000002"));
            entity1.setIdoYMD(FlexibleDate.MAX);
            entity1.setEdaNo(RString.EMPTY);
            entity1.setIdoJiyuCode(RString.EMPTY);
            entity1.setTekiyoJiyuCode(new KaigoTatokuTekiyoJiyu(new RString("00")));
            tashichosonJushochiTokureiDac.save(entity1);

            RString result = sikakuIdoCheckManager.tekiyoJogaishaChofukuCheck(tekiyoJogaishaList, new ShikibetsuCode("000002"));
            assertThat(result, is(new RString("DBAE00005")));
        }

    }

    public static class tasichosonTokureiChofukuCheck extends DbaTestDacBase {

        private static final List<Tasichoson> tasichosonList = new ArrayList<>();

        @BeforeClass
        public static void setUp() {
            TestSupport.deleteData();

            sikakuIdoCheckManager = InstanceProvider.create(SikakuIdoCheckManager.class);
            hihokenshaDaiDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
            tekiyoJogaishaDac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
            tashichosonJushochiTokureiDac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);

            tasichosonList.add(new Tasichoson(new FlexibleDate("20140102"), new FlexibleDate("20140208"), new FlexibleDate("20140101"), RString.EMPTY));
            tasichosonList.add(new Tasichoson(new FlexibleDate("20140302"), new FlexibleDate("20140408"), new FlexibleDate("20140102"), RString.EMPTY));
            tasichosonList.add(new Tasichoson(new FlexibleDate("20140502"), new FlexibleDate("20140608"), new FlexibleDate("20140103"), RString.EMPTY));
            tasichosonList.add(new Tasichoson(new FlexibleDate("20140702"), new FlexibleDate("20140808"), new FlexibleDate("20140104"), RString.EMPTY));
        }

        @Test
        public void 他市町村住所地特例適用解除履歴と他の期間の重複しないの場合() {
            DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
            entity.setShikibetsuCode(new ShikibetsuCode("000001"));
            entity.setShikakuShutokuYMD(new FlexibleDate("20140902"));
            entity.setShikakuSoshitsuYMD(new FlexibleDate("20141010"));
            entity.setShichosonCode(new LasdecCode("000001"));
            entity.setHihokenshaNo(new HihokenshaNo(new RString("000001")));
            entity.setShikakuShutokuJiyuCode(new KaigoShikakuShutokuJiyu(new RString("00")));
            entity.setHihokennshaKubunCode(new RString("1"));
            entity.setIdoYMD(FlexibleDate.MAX);
            entity.setEdaNo(RString.EMPTY);
            entity.setIdoJiyuCode(RString.EMPTY);
            hihokenshaDaiDac.save(entity);
            RString result = sikakuIdoCheckManager.tasichosonTokureiChofukuCheck(tasichosonList, new ShikibetsuCode("000001"));
            assertThat(result, is(new RString("")));
        }

        @Test
        public void 他市町村住所地特例適用解除履歴と他の期間の重複の場合() {
            DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
            entity.setShikibetsuCode(new ShikibetsuCode("000002"));
            entity.setShikakuShutokuYMD(new FlexibleDate("20140502"));
            entity.setShikakuSoshitsuYMD(new FlexibleDate("20141010"));
            entity.setShichosonCode(new LasdecCode("000002"));
            entity.setHihokenshaNo(new HihokenshaNo(new RString("000002")));
            entity.setShikakuShutokuJiyuCode(new KaigoShikakuShutokuJiyu(new RString("00")));
            entity.setHihokennshaKubunCode(new RString("1"));
            entity.setIdoYMD(FlexibleDate.MAX);
            entity.setEdaNo(RString.EMPTY);
            entity.setIdoJiyuCode(RString.EMPTY);
            hihokenshaDaiDac.save(entity);
            DbT1002TekiyoJogaishaEntity entity1 = new DbT1002TekiyoJogaishaEntity();
            entity1.setShikibetsuCode(new ShikibetsuCode("000002"));
            entity1.setTekiyoYMD(new FlexibleDate("20140502"));
            entity1.setKaijoYMD(new FlexibleDate("20141010"));
            entity1.setShichosonCode(new LasdecCode("000002"));
            entity1.setTekiyoJogaiTekiyoJiyuCode(new KaigoJogaiTekiyoJiyu(new RString("00")));
            entity1.setIdoYMD(FlexibleDate.MAX);
            entity1.setEdaNo(RString.EMPTY);
            entity1.setIdoJiyuCode(RString.EMPTY);
            tekiyoJogaishaDac.save(entity1);
            RString result = sikakuIdoCheckManager.tasichosonTokureiChofukuCheck(tasichosonList, new ShikibetsuCode("000002"));
            assertThat(result, is(new RString("DBAE00005")));
        }

    }

    private static class TestSupport {

        public static void deleteData() {
            CSVDataUtilForUseSession utilForUseSession = new CSVDataUtilForUseSession();
            utilForUseSession.clearTable(sqlSession, DbT1001HihokenshaDaichoEntity.TABLE_NAME.toString());
            utilForUseSession.clearTable(sqlSession, DbT1002TekiyoJogaishaEntity.TABLE_NAME.toString());
            utilForUseSession.clearTable(sqlSession, DbT1003TashichosonJushochiTokureiEntity.TABLE_NAME.toString());
        }

    }
}
