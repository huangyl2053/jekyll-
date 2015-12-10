/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.hihousyosai;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihousyosai.HihousyosaiFinderParameter;
import jp.co.ndensan.reams.db.dba.service.core.hihousyosai.HihousyosaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
 * {@link HihousyosaiFinder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HihousyosaiFinderTest extends DbaTestDacBase {

    private static HihousyosaiFinder sut;
    private static DbT7051KoseiShichosonMasterDac dbT7051Dac;
    private static DbT1001HihokenshaDaichoDac dbT1001dac;

    public static final RString 市町村識別ID = new RString("00");
    public static final FlexibleDate 加入日 = new FlexibleDate("20140402");
    public static final FlexibleDate 離脱日 = new FlexibleDate("20150402");

    private static final HihokenshaNo 被保険者番号 = new HihokenshaNo("0");
    private static final FlexibleDate 異動日 = new FlexibleDate("20151118");
    private static final RString 枝番 = new RString("0000");

    private static final RString enum0 = new RString("0");
    private static final RString enum1 = new RString("1");

    @BeforeClass
    public static void setUpClass() {
        DbaTestDacBase.setUpClass();
        sut = new HihousyosaiFinder();
        dbT7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        dbT1001dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);

    }

    public static class 所在保険者リスト情報取得のテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            dbT7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
            insert_DbT7051KoseiShichosonMaster(市町村識別ID, 加入日, 離脱日);

        }

        @Test
        public void テーブルにレコードが存在しない場合_構成市町村情報取得は_NULLを返すこと() throws Exception {
            sut.getKoseiShichosonMasterList(new RDate(""));
        }

        @Test
        public void テーブルにレコードが存在する場合_構成市町村情報取得はは_１件を返すこと() throws Exception {
            insert_DbT7051KoseiShichosonMaster(市町村識別ID, 加入日, 離脱日);
            List<KoseiShichosonMaster> entityList = sut.getKoseiShichosonMasterList(new RDate("20150102"));
            assertThat(entityList.size(), is(1));
        }

    }

    public static class 得喪操作情報取得のテスト extends DbaTestDacBase {

        @Before
        public void setUp() {
            dbT1001dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        }

        @Test
        public void 取得されたデータがない場合_NULLを返返して() throws Exception {
            HihousyosaiFinderParameter parameter = HihousyosaiFinderParameter.createHihousyosaiFinderParameter(
                    new HihokenshaNo(""),
                    new FlexibleDate(""),
                    new RString(""));
            sut.getTokusouJoho(parameter);
        }

        @Test
        public void 検索結果が存在する場合_get被保険者番号を返して() {
            HihousyosaiFinderParameter parameter = HihousyosaiFinderParameter.createHihousyosaiFinderParameter(
                    new HihokenshaNo("0"),
                    new FlexibleDate("20151118"),
                    new RString("0000"));
            insert_DbT1001HihokenshaDaicho(被保険者番号, 異動日, 枝番);
            HihokenshaDaicho Hihokensha = sut.getTokusouJoho(parameter);
            assertThat(Hihokensha.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void 検索結果が同じでない_NULLを返して() {
            insert_DbT1001HihokenshaDaicho(被保険者番号, 異動日, 枝番);
            HihousyosaiFinderParameter parameter = HihousyosaiFinderParameter.createHihousyosaiFinderParameter(
                    new HihokenshaNo("1"),
                    new FlexibleDate("20151118"),
                    new RString("0000"));
            HihokenshaDaicho Hihokensha = sut.getTokusouJoho(parameter);
            assertThat(Hihokensha, is(nullValue()));
        }

    }

    public static class 被保区分リスト情報取得のテスト extends DbaTestDacBase {

        @Test
        public void 取得されたデータが存在しない場合_Enumクラス異常を返返して() throws Exception {
            List<ShikakuKubun> enumList = sut.getHihokubunList(enum0);
            assertThat(enumList.size(), is(0));
        }

        @Test
        public void 取得されたデータが存在する場合_１件を返返して() throws Exception {
            List<ShikakuKubun> enumList = sut.getHihokubunList(enum1);
            assertThat(enumList.size(), is(1));
        }
    }

    private static void insert_DbT7051KoseiShichosonMaster(
            RString 市町村識別ID,
            FlexibleDate 加入日,
            FlexibleDate 離脱日) {
        DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
        entity.setShichosonShokibetsuID(市町村識別ID);
        entity.setShichosonCode(new LasdecCode("123456"));
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo("123456"));
        entity.setShichosonMeisho(new RString("1"));
        entity.setTyohyoTodoufukenHyojiUmu(new RString("1"));
        entity.setTyohyoGunHyojiUmu(new RString("1"));
        entity.setTyohyoShichosonHyojiUmu(new RString("1"));
        entity.setTyohyoJushoHenshuHouhou(new RString("1"));
        entity.setTyohyoKatagakiHyojiUmu(new RString("1"));
        entity.setGaikokujinHyojiHouhou(new RString("1"));
        entity.setKanyuYMD(加入日);
        entity.setRidatsuYMD(離脱日);
        entity.setUnyoHokenshaNo(new ShoKisaiHokenshaNo("123456"));
        entity.setUnyoKaishiYMD(new FlexibleDate("20150402"));
        entity.setUnyoShuryoYMD(new FlexibleDate("20150402"));
        entity.setUnyoKeitaiKubun(new RString("1"));
        dbT7051Dac.save(entity);
    }

    private static void insert_DbT1001HihokenshaDaicho(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) {

        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setHihokenshaNo(被保険者番号);
        entity.setIdoYMD(異動日);
        entity.setEdaNo(枝番);
        entity.setIdoJiyuCode(new RString("01"));
        entity.setShichosonCode(new LasdecCode("209007"));
        entity.setShikibetsuCode(new ShikibetsuCode("01"));
        entity.setHihokennshaKubunCode(new RString("0"));
        dbT1001dac.save(entity);
    }

}
