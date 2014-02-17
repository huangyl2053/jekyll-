/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisage;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisageTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 認定申請情報Entityを認定申請取下げ対象者クラスに変換するためのMapperのテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteishinseiTorisageTaishoshaMapperTest extends TestBase {

    public static class to認定申請取下げ対象者のテスト extends TestBase {

        private ShinseishoKanriNo 申請書管理No;
        private ShichosonCode 市町村Code;
        private KaigoHihokenshaNo 被保険者No;
        private FlexibleDate 認定申請年月日;
        private RString 認定申請区分コード_申請時;
        private TorisageKubun 取下げ区分;
        private RString 取下げ理由;
        private FlexibleDate 取下げ年月日;
        private ShinsaKeizokuKubun 審査継続区分;
        private NinteiShinseiTorisageTaishosha sut;

        @Override
        public void setUp() {
            申請書管理No = new ShinseishoKanriNo(new RString("0123"));
            市町村Code = new ShichosonCode(new RString("A012"));
            被保険者No = new KaigoHihokenshaNo(new RString("DB0001"));
            認定申請年月日 = new FlexibleDate(new RString("20120101"));
            認定申請区分コード_申請時 = new RString("0001");
            取下げ区分 = TorisageKubun.区分変更却下;
            取下げ理由 = new RString("とりさげ");
            取下げ年月日 = new FlexibleDate(new RString("20120101"));
            審査継続区分 = ShinsaKeizokuKubun.継続しない;

            sut = NinteishinseiTorisageTaishoshaMapper.to認定申請取下げ対象者(create認定申請情報Entity());

        }

        @Test
        public void get申請書管理Noの結果が_Entityの申請書管理Noと同一になる() {
            assertThat(sut.get申請書管理No(), is(申請書管理No));
        }

        @Test
        public void get市町村コードの結果が_Entityの市町村コードと同一になる() {
            assertThat(sut.get市町村コード(), is(市町村Code));
        }

        @Test
        public void get被保険者番号の結果が_Entityの被保険者番号と同一になる() {
            assertThat(sut.get被保険者番号(), is(被保険者No));
        }

        @Test
        public void get認定申請区分コード_申請時の結果が_Entityの認定申請区分コード_申請時と同一になる() {
            assertThat(sut.get認定申請区分コード_申請時().getColumnValue(), is(認定申請区分コード_申請時));
        }

        @Test
        public void get認定申請年月日の結果が_Entityの認定申請年月日と同一になる() {
            assertThat(sut.get認定申請年月日().toFlexibleDate(), is(認定申請年月日));
        }

        @Test
        public void 認定取下げ情報のget取下げ区分が_Entityの取下げ区分と同一になる() {
            assertThat(sut.get認定申請取下げ().get取下げ区分(), is(取下げ区分));
        }

        @Test
        public void 認定取下げ情報のget取下げ理由が_Entityの取下げ理由と同一になる() {
            assertThat(sut.get認定申請取下げ().get取下げ理由(), is(取下げ理由));
        }

        @Test
        public void 認定取下げ情報のget取下げ年月日が_Entityの取下げ年月日と同一になる() {
            assertThat(sut.get認定申請取下げ().get取下げ年月日().toFlexibleDate(), is(取下げ年月日));
        }

        @Test
        public void 認定取下げ情報のget申請継続区分が_Entityの申請継続区分と同一になる() {
            assertThat(sut.get認定申請取下げ().get申請継続区分(), is(審査継続区分));
        }

        private DbT5001NinteiShinseiJohoEntity create認定申請情報Entity() {
            DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
            entity.setShinseishoKanriNo(申請書管理No);
            entity.setShichosonCode(市町村Code);
            entity.setHihokenshaNo(被保険者No);
            entity.setNinteiShinseiYMD(認定申請年月日);
            entity.setNinteiShinseiShinseijiKubunCode(new Code(認定申請区分コード_申請時));
            entity.setTorisageKubunCode(取下げ区分.get取下げ区分コード());
            entity.setTorisageRiyu(取下げ理由);
            entity.setTorisageYMD(取下げ年月日);
            entity.setShinsaKeizokuKubun(審査継続区分.is継続());
            return entity;
        }
    }

    public static class to認定申請情報Entityのテスト extends TestBase {

        private TorisageKubun 取下げ区分;
        private RString 取下げ理由;
        private FlexibleDate 取下げ年月日;
        private ShinsaKeizokuKubun 審査継続区分;
        private DbT5001NinteiShinseiJohoEntity sut;

        @Override
        public void setUp() {
            取下げ区分 = TorisageKubun.区分変更却下;
            取下げ理由 = new RString("とりさげ");
            取下げ年月日 = new FlexibleDate(new RString("20120101"));
            審査継続区分 = ShinsaKeizokuKubun.継続しない;
            sut = NinteishinseiTorisageTaishoshaMapper.to認定申請情報Entity(createMockEntity(), create認定申請取下げ());
        }

        @Test
        public void 認定申請情報Entityの取下げ区分コードが_認定申請取下げの取下げ区分と同一になる() {
            assertThat(sut.getTorisageKubunCode(), is(取下げ区分.get取下げ区分コード()));
        }

        @Test
        public void 認定申請情報Entityの取下げ理由が_認定申請取下げの取下げ理由と同一になる() {
            assertThat(sut.getTorisageRiyu(), is(取下げ理由));
        }

        @Test
        public void 認定申請情報Entityの取下げ年月日が_認定申請取下げの取下げ年月日と同一になる() {
            assertThat(sut.getTorisageYMD(), is(取下げ年月日));
        }

        @Test
        public void 認定申請情報Entityの審査継続区分が_認定申請取下げの審査継続区分と同一になる() {
            assertThat(sut.getShinsaKeizokuKubun(), is(審査継続区分.is継続()));
        }

        private DbT5001NinteiShinseiJohoEntity createMockEntity() {
            return mock(DbT5001NinteiShinseiJohoEntity.class);
        }

        private NinteiShinseiTorisage create認定申請取下げ() {
            return new NinteiShinseiTorisage(取下げ区分, 取下げ理由, 取下げ年月日.toRDate(), 審査継続区分);
        }
    }
}
