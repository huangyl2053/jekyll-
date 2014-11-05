/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import java.util.UUID;
//import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.helper.INinteiShinseiJohoDacMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.testhelper.TestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定申請情報Dacのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiShinseiJohoDacTest extends TestDacBase {
//    //TODO n8178 城間篤人
//    //業務固有クラス、enumのマッピングが上手くいかないため未実装。
//    //マッピングができるようになった時点で実装予定 2014年2月末
//
//    private static INinteiShinseiJohoDacMock inserter;
//    private static INinteiShinseiJohoDac sut;
//
//    @BeforeClass
//    public static void setUpClass() {
//        inserter = InstanceCreator.create(INinteiShinseiJohoDacMock.class);
//        sut = InstanceCreator.create(INinteiShinseiJohoDac.class);
//    }
//
//    public static class selectのテスト extends TestDacBase {
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("A00120"));
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20120101"), create認定申請取下げ情報(create年月日("20120101"))));
//        }
//
//        @Test
//        public void 申請書管理番号が1の情報を取得できる() {
//            DbT5001NinteiShinseiJohoEntity result = sut.select(create申請書管理番号("1"));
//            assertThat(result.getShinseishoKanriNo(), is(create申請書管理番号("1")));
//        }
//    }
//
//    public static class selectAllBy認定申請年月日のテスト extends TestDacBase {
//
//        ShoKisaiHokenshaNo 証記載保険者番号;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("A00120"));
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20120101"), create認定申請取下げ情報(create年月日("20150101"))));
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20130101"), create認定申請取下げ情報(create年月日("20150101"))));
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20140101"), create認定申請取下げ情報(create年月日("20150101"))));
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20150101"), create認定申請取下げ情報(create年月日("20150101"))));
//        }
//
//        @Test
//        public void 指定した認定申請年月日の範囲に該当する情報が_2件取得できる() {
//            List<DbT5001NinteiShinseiJohoEntity> results = sut.selectAllBy認定申請年月日(証記載保険者番号, new Range(create年月日("20110101"), create年月日("20130401")));
//            assertThat(results.size(), is(2));
//        }
//    }
//
//    public static class selectAllBy取下げ年月日のテスト extends TestDacBase {
//
//        ShoKisaiHokenshaNo 証記載保険者番号;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("A00120"));
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20150101"), create認定申請取下げ情報(create年月日("20120101"))));
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20150101"), create認定申請取下げ情報(create年月日("20130101"))));
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20150101"), create認定申請取下げ情報(create年月日("20140101"))));
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20150101"), create認定申請取下げ情報(create年月日("20150101"))));
//        }
//
//        @Test
//        public void 指定した取下げ年月日の範囲に該当する情報が_3件取得できる() {
//            List<DbT5001NinteiShinseiJohoEntity> results = sut.selectAllBy認定申請年月日(証記載保険者番号, new Range(create年月日("20130101"), create年月日("20150401")));
//            assertThat(results.size(), is(3));
//        }
//    }
//
//    public static class updateのテスト extends TestDacBase {
//
//        private ShinseishoKanriNo 申請書管理番号;
//        private ShoKisaiHokenshaNo 証記載保険者番号;
//        private TorisageKubun 取下げ区分;
//        private RString 取下げ理由;
//        private FlexibleDate 取下げ年月日;
//        private ShinsaKeizokuKubun 審査継続区分;
//        private NinteiShinseiTorisage 認定申請取下げ;
//        private DbT5001NinteiShinseiJohoEntity 更新用Entity;
//
//        static {
//            setGyomuCD("DB");
//        }
//
//        @Override
//        public void setUp() {
//            取下げ区分 = TorisageKubun.区分変更却下;
//            取下げ理由 = new RString("BBB");
//            取下げ年月日 = create年月日("20120101");
//            審査継続区分 = ShinsaKeizokuKubun.継続する;
//            認定申請取下げ = create認定申請取下げ情報(取下げ区分, 取下げ理由, 取下げ年月日, 審査継続区分);
//
//            更新用Entity = create認定申請情報Entity(create申請書管理番号("1"), new ShoKisaiHokenshaNo(new RString("A00120")), create年月日("19990101"), 認定申請取下げ);
//
//            inserter.insert(create認定申請情報Entity(create申請書管理番号("1"), 証記載保険者番号, create年月日("20150101"),
//                    create認定申請取下げ情報(TorisageKubun.認定申請有効, new RString("AAA"), create年月日("19990101"), ShinsaKeizokuKubun.継続しない)));
//        }
//
//        @Test
//        public void 更新後の取下げ区分が_引数から渡した取下げ区分と同一になる() {
//            int a = sut.update(更新用Entity);
//            assertThat(sut.select(申請書管理番号).getTorisageKubunCode(), is(取下げ区分.get取下げ区分コード()));
//        }
//
//        @Test
//        public void 更新後の取下げ理由が_引数から渡した取下げ理由と同一になる() {
//            int a = sut.update(更新用Entity);
//            assertThat(sut.select(申請書管理番号).getTorisageRiyu(), is(取下げ理由));
//        }
//
//        @Test
//        public void 更新後の取下げ年月日が_引数から渡した取下げ年月日と同一になる() {
//            int a = sut.update(更新用Entity);
//            assertThat(sut.select(申請書管理番号).getTorisageYMD(), is(取下げ年月日));
//        }
//
//        @Test
//        public void 更新後の審査継続区分が_引数から渡した審査継続区分と同一になる() {
//            int a = sut.update(更新用Entity);
//            assertThat(sut.select(申請書管理番号).getShinsaKeizokuKubun(), is(審査継続区分.is継続()));
//        }
//    }
//
//    private static ShinseishoKanriNo create申請書管理番号(String str) {
//        return new ShinseishoKanriNo(new RString(str));
//    }
//
//    private static FlexibleDate create年月日(String str) {
//        return new FlexibleDate(new RString(str));
//    }
//
//    private static DbT5001NinteiShinseiJohoEntity create認定申請情報Entity(ShinseishoKanriNo 申請書管理番号, ShoKisaiHokenshaNo 証記載保険者番号,
//            FlexibleDate 認定申請年月日, NinteiShinseiTorisage 認定申請取下げ情報) {
//        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
//        entity.setInsertDantaiCd(new RString("0001"));
//        entity.setInsertTimestamp(RDateTime.now());
//        entity.setInsertReamsLoginId(new RString(("0001")));
//        entity.setInsertContextId(new UUID(1, 12));
//        entity.setIsDeleted(false);
//        entity.setUpdateCount(0);
//        entity.setLastUpdateTimestamp(RDateTime.now());
//        entity.setLastUpdateReamsLoginId(new RString("0001"));
//        entity.setShinseishoKanriNo(申請書管理番号);
//        entity.setShoKisaiHokenshaNo(証記載保険者番号);
//        entity.setShishoCode(new RString("0001"));
//        entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("0001")));
//        entity.setShikibetsuCode(new RString("0001"));
//        entity.setNinteiShinseiYMD(認定申請年月日);
//        entity.setNinteiShinseiEdabanCode(new RString("0001"));
//        entity.setNinteiShinseiShinseijiKubunCode(new RString("0001"));
//        entity.setNinteiShinseiHoreiKubunCode(1);
//        entity.setNinteiShinseiYukoKubunCode(new RString("0001"));
//        entity.setShienShinseiKubun(new RString("0001"));
//        entity.setShinseiRiyu(new RString("0001"));
//        entity.setZenYokaigoKubunCode(new RString("0001"));
//        entity.setZenYukoKikan(1);
//        entity.setJohoteikyoDouiUmuKubun(false);
//        entity.setNinteichosaIraiRirekiNo(1);
//        entity.setIkenshoIraiRirekiNo(1);
//        entity.setMinashiCode(new RString("0001"));
//        entity.setEnkitsuchiDoiUmuKubun(false);
//        entity.setShisetsuNyushoUmuKubun(false);
//        entity.setSichosonRenrakuJiko(new RString("0001"));
//        entity.setTorisageKubunCode(認定申請取下げ情報.get取下げ区分().get取下げ区分コード());
//        entity.setTorisageRiyu(認定申請取下げ情報.get取下げ理由());
//        entity.setTorisageYMD(認定申請取下げ情報.get取下げ年月日());
//        entity.setShinsaKeizokuKubun(認定申請取下げ情報.get申請継続区分().is継続());
//        return entity;
//    }
//
//    private static NinteiShinseiTorisage create認定申請取下げ情報(TorisageKubun 取下げ区分, RString 取下げ理由,
//            FlexibleDate 取下げ年月日, ShinsaKeizokuKubun 審査継続区分) {
//        return new NinteiShinseiTorisage(取下げ区分, 取下げ理由, 取下げ年月日, 審査継続区分);
//    }
//
//    private static NinteiShinseiTorisage create認定申請取下げ情報(FlexibleDate 年月日) {
//        return new NinteiShinseiTorisage(TorisageKubun.認定申請有効, new RString(""), 年月日, ShinsaKeizokuKubun.継続する);
//    }
}
