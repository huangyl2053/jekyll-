/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 被保険者台帳ビューのデータアクセスクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoViewDacTest extends DbzTestDacBase {

    private static HihokenshaDaichoViewDac sut;
    private static HihokenshaDaichoDac dac;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(HihokenshaDaichoViewDac.class);
        dac = InstanceProvider.create(HihokenshaDaichoDac.class);
    }

    public static class selectBy被保険者番号 extends DbzTestDacBase {

        private final HihokenshaNo 被保険者番号_該当0件 = new HihokenshaNo("9999999999");
        private final HihokenshaNo 被保険者番号_該当1件 = new HihokenshaNo("0000000001");
        private final HihokenshaNo 被保険者番号_該当2件 = new HihokenshaNo("0000000002");

        @Before
        public void setup() {
            initializeEntityData();
        }

        @Test
        public void 被保険者番号に該当する被保険者台帳ビューが0件の時_selectBy被保険者番号は_0件の情報を返す() {
            assertThat(sut.selectBy被保険者番号(被保険者番号_該当0件).size(), is(0));
        }

        @Test
        public void 被保険者番号に該当する被保険者台帳ビューが1件の時_selectBy被保険者番号は_1件の情報を返す() {
            assertThat(sut.selectBy被保険者番号(被保険者番号_該当1件).size(), is(1));
        }

        @Test
        public void 被保険者番号に該当する被保険者台帳ビューが2件の時_selectBy被保険者番号は_2件の情報を返す() {
            assertThat(sut.selectBy被保険者番号(被保険者番号_該当2件).size(), is(2));
        }
    }

    public static class selectByAny市町村コード extends DbzTestDacBase {

        private final LasdecCode 市町村コード_該当0件 = new LasdecCode(new RString("999999"));
        private final LasdecCode 市町村コード_該当1件 = new LasdecCode(new RString("000001"));
        private final LasdecCode 措置元市町村コード_該当1件 = new LasdecCode(new RString("000002"));
        private final LasdecCode 市町村コード_該当2件 = new LasdecCode(new RString("000003"));
        private final HihokenshaNo 被保険者番号_指定なし = null;
        private final HihokenshaNo 被保険者番号_内該当0件 = new HihokenshaNo("0000000001");
        private final HihokenshaNo 被保険者番号_内該当1件 = new HihokenshaNo("0000000002");

        @Before
        public void setup() {
            initializeEntityData();
        }

        @Test
        public void 市町村コードに該当する被保険者台帳ビューが0件の時_selectByAny市町村コードは_0件の情報を返す() {
            assertThat(sut.selectByAny市町村コード(市町村コード_該当0件, 被保険者番号_指定なし).size(), is(0));
        }

        @Test
        public void 市町村コードに該当する被保険者台帳ビューが1件の時_selectByAny市町村コードは_1件の情報を返す() {
            assertThat(sut.selectByAny市町村コード(市町村コード_該当1件, 被保険者番号_指定なし).size(), is(1));
        }

        @Test
        public void 措置元市町村コードに該当する被保険者台帳ビューが1件の時_selectByAny市町村コードは_1件の情報を返す() {
            assertThat(sut.selectByAny市町村コード(措置元市町村コード_該当1件, 被保険者番号_指定なし).size(), is(1));
        }

        @Test
        public void 市町村コードに該当する被保険者台帳ビューが2件の時_selectByAny市町村コードは_2件の情報を返す() {
            assertThat(sut.selectByAny市町村コード(市町村コード_該当2件, 被保険者番号_指定なし).size(), is(2));
        }

        @Test
        public void 市町村コードと被保険者番号に該当する被保険者台帳ビューが0件の時_selectByAny市町村コードは_0件の情報を返す() {
            assertThat(sut.selectByAny市町村コード(市町村コード_該当2件, 被保険者番号_内該当0件).size(), is(0));
        }

        @Test
        public void 市町村コードと被保険者番号に該当する被保険者台帳ビューが1件の時_selectByAny市町村コードは_1件の情報を返す() {
            assertThat(sut.selectByAny市町村コード(市町村コード_該当2件, 被保険者番号_内該当1件).size(), is(1));
        }
    }

    public static class selectBy市町村コード extends DbzTestDacBase {

        private final LasdecCode 市町村コード_該当0件 = new LasdecCode(new RString("999999"));
        private final LasdecCode 市町村コード_該当1件 = new LasdecCode(new RString("000001"));
        private final LasdecCode 市町村コード_該当2件 = new LasdecCode(new RString("000004"));
        private final HihokenshaNo 被保険者番号_指定なし = null;
        private final HihokenshaNo 被保険者番号_内該当0件 = new HihokenshaNo("0000000001");
        private final HihokenshaNo 被保険者番号_内該当1件 = new HihokenshaNo("0000000004");

        @Before
        public void setup() {
            initializeEntityData();
        }

        @Test
        public void 市町村コードに該当する被保険者台帳ビューが0件の時_selectBy市町村コードは_0件の情報を返す() {
            assertThat(sut.selectBy市町村コード(市町村コード_該当0件, 被保険者番号_指定なし).size(), is(0));
        }

        @Test
        public void 市町村コードに該当する被保険者台帳ビューが1件の時_selectBy市町村コードは_1件の情報を返す() {
            assertThat(sut.selectBy市町村コード(市町村コード_該当1件, 被保険者番号_指定なし).size(), is(1));
        }

        @Test
        public void 市町村コードに該当する被保険者台帳ビューが2件の時_selectBy市町村コードは_2件の情報を返す() {
            assertThat(sut.selectBy市町村コード(市町村コード_該当2件, 被保険者番号_指定なし).size(), is(2));
        }

        @Test
        public void 市町村コードと被保険者番号に該当する被保険者台帳ビューが0件の時_selectBy市町村コードは_0件の情報を返す() {
            assertThat(sut.selectBy市町村コード(市町村コード_該当2件, 被保険者番号_内該当0件).size(), is(0));
        }

        @Test
        public void 市町村コードと被保険者番号に該当する被保険者台帳ビューが1件の時_selectBy市町村コードは_1件の情報を返す() {
            assertThat(sut.selectBy市町村コード(市町村コード_該当2件, 被保険者番号_内該当1件).size(), is(1));
        }
    }

    public static class selectBy広住特措置元市町村コード extends DbzTestDacBase {

        private final LasdecCode 広住特措置元市町村コード_該当0件 = new LasdecCode(new RString("999999"));
        private final LasdecCode 広住特措置元市町村コード_該当1件 = new LasdecCode(new RString("000002"));
        private final LasdecCode 広住特措置元市町村コード_該当2件 = new LasdecCode(new RString("000005"));
        private final HihokenshaNo 被保険者番号_指定なし = null;
        private final HihokenshaNo 被保険者番号_内該当0件 = new HihokenshaNo("0000000002");
        private final HihokenshaNo 被保険者番号_内該当1件 = new HihokenshaNo("0000000005");

        @Before
        public void setup() {
            initializeEntityData();
        }

        @Test
        public void 広住特措置元市町村コードに該当する被保険者台帳ビューが0件の時_selectBy広住特措置元市町村コードは_0件の情報を返す() {
            assertThat(sut.selectBy広住特措置元市町村コード(広住特措置元市町村コード_該当0件, 被保険者番号_指定なし).size(), is(0));
        }

        @Test
        public void 広住特措置元市町村コードに該当する被保険者台帳ビューが1件の時_selectBy広住特措置元市町村コードは_1件の情報を返す() {
            assertThat(sut.selectBy広住特措置元市町村コード(広住特措置元市町村コード_該当1件, 被保険者番号_指定なし).size(), is(1));
        }

        @Test
        public void 広住特措置元市町村コードに該当する被保険者台帳ビューが2件の時_selectBy広住特措置元市町村コードは_2件の情報を返す() {
            assertThat(sut.selectBy広住特措置元市町村コード(広住特措置元市町村コード_該当2件, 被保険者番号_指定なし).size(), is(2));
        }

        @Test
        public void 広住特措置元市町村コードと被保険者番号に該当する被保険者台帳ビューが0件の時_selectBy広住特措置元市町村コードは_0件の情報を返す() {
            assertThat(sut.selectBy広住特措置元市町村コード(広住特措置元市町村コード_該当2件, 被保険者番号_内該当0件).size(), is(0));
        }

        @Test
        public void 広住特措置元市町村コードと被保険者番号に該当する被保険者台帳ビューが1件の時_selectBy広住特措置元市町村コードは_1件の情報を返す() {
            assertThat(sut.selectBy広住特措置元市町村コード(広住特措置元市町村コード_該当2件, 被保険者番号_内該当1件).size(), is(1));
        }
    }

    private static void initializeEntityData() {
        dac.insert(createEntity("000001", "0000000001", "20140101010101", "000000"));
        dac.insert(createEntity("000000", "0000000002", "20140202020202", "000002"));
        dac.insert(createEntity("000003", "0000000002", "20140303030303", "000000"));
        dac.insert(createEntity("000000", "0000000003", "20140404040404", "000003"));
        dac.insert(createEntity("000004", "0000000004", "20140505050505", "000000"));
        dac.insert(createEntity("000000", "0000000004", "20140606060606", "000005"));
        dac.insert(createEntity("000004", "0000000005", "20140707070707", "000000"));
        dac.insert(createEntity("000000", "0000000005", "20140808080808", "000005"));

    }

    private static DbT1001HihokenshaDaichoEntity createEntity(String 市町村コード, String 被保険者番号, String 処理日時, String 措置元市町村コード) {
        DbT1001HihokenshaDaichoEntity entity = new DbT1001HihokenshaDaichoEntity();
        entity.setShichosonCode(new LasdecCode(市町村コード));
        entity.setHihokenshaNo(new HihokenshaNo(new RString(被保険者番号)));
        entity.setShoriTimestamp(new YMDHMS(処理日時));
        entity.setShikibetsuCode(new ShikibetsuCode("000000000000001"));
        entity.setShikakuShutokuJiyuCode(new RString("01"));
        entity.setShikakuShutokuYMD(FlexibleDate.MIN);
        entity.setHihokennshaKubunCode(new RString("1"));
        entity.setKoikinaiTokureiSochimotoShichosonCode(new LasdecCode((措置元市町村コード)));
        return entity;
    }
}
