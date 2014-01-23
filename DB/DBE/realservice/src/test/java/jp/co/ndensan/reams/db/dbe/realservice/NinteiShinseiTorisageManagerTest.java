/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisageTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.NinteishinseiTorisageTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * 介護認定申請を取り下げる際の情報を管理するクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiShinseiTorisageManagerTest extends TestBase {

    private static ShinseishoKanriNo 申請書管理No = new ShinseishoKanriNo(new RString("0123"));
    private static ShichosonCode 市町村Code = new ShichosonCode(new RString("A012"));
    private static HihokenshaNo 被保険者No = new HihokenshaNo(new RString("DB0001"));
    private static FlexibleDate 認定申請年月日 = new FlexibleDate(new RString("20120101"));
    private static RString 認定申請区分コード_申請時 = new RString("0001");
    private static TorisageKubun 取下げ区分 = TorisageKubun.区分変更却下;
    private static RString 取下げ理由 = new RString("とりさげ");
    private static FlexibleDate 取下げ年月日 = new FlexibleDate(new RString("20120101"));
    private static ShinsaKeizokuKubun 審査継続区分 = ShinsaKeizokuKubun.継続しない;
    private static Range<FlexibleDate> 年月日範囲 = new Range(new FlexibleDate(new RString("20110101")), new FlexibleDate(new RString("20130101")));
    private static NinteiShinseiTorisageTaishosha 認定申請取下げ対象 = create認定申請取下げ対象();
    private static NinteiShinseiTorisageManager sut = new NinteiShinseiTorisageManager(createMockDac());

    public static class get認定申請取下げ対象者のテスト {

        @Test
        public void 指定した申請書管理番号を持つ_認定申請取下げ対象者クラスが取得できる() {

            申請書管理No = new ShinseishoKanriNo(new RString("0123"));
            sut = new NinteiShinseiTorisageManager(createMockDac());
            NinteiShinseiTorisageTaishosha result = sut.get認定申請取下げ対象者(null);
            assertThat(result.get申請書管理No(), is(申請書管理No));
        }
    }

    public static class get認定申請取下げ対象者全件のテスト {

        @Test
        public void 指定した認定申請年月日範囲に合致する認定申請取下げ対象者を_3件持つリストを取得できる() {
            sut = new NinteiShinseiTorisageManager(createMockDac());
            List<NinteiShinseiTorisageTaishosha> results = sut.get認定申請取下げ対象者全件(市町村Code, 年月日範囲);
            assertThat(results.size(), is(3));
        }
    }

    public static class get認定申請取下げ者のテスト {

        @Test
        public void 指定した取下げ年月日範囲に合致する認定申請取下げ者を_2件持つリストを取得できる() {
            sut = new NinteiShinseiTorisageManager(createMockDac());
            List<NinteiShinseiTorisageTaishosha> results = sut.get認定申請取下げ者(市町村Code, 年月日範囲);
            assertThat(results.size(), is(2));
        }
    }

    public static class saveのテスト {

        @Test
        public void 引数から受け取った情報を更新できたとき_saveメソッドから1が返る() {
            sut = new NinteiShinseiTorisageManager(createMockDac());
            assertThat(sut.save(認定申請取下げ対象), is(1));
        }
    }

    private static INinteiShinseiJohoDac createMockDac() {
        INinteiShinseiJohoDac mockDac = mock(INinteiShinseiJohoDac.class);
        when(mockDac.select(any(ShinseishoKanriNo.class))).thenReturn(create認定申請情報Entity());
        when(mockDac.selectAllBy認定申請年月日(any(ShichosonCode.class), any(Range.class))).thenReturn(create認定申請情報EntityList(3));
        when(mockDac.selectAllBy取下げ年月日(any(ShichosonCode.class), any(Range.class))).thenReturn(create認定申請情報EntityList(2));
        when(mockDac.update(any(DbT5001NinteiShinseiJohoEntity.class))).thenReturn(1);
        return mockDac;
    }

    private static DbT5001NinteiShinseiJohoEntity create認定申請情報Entity() {
        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
        entity.setShinseishoKanriNo(申請書管理No);
        entity.setShichosonCode(市町村Code);
        entity.setHihokenshaNo(被保険者No);
        entity.setNinteiShinseiYMD(認定申請年月日);
        entity.setNinteiShinseiShinseijiKubunCode(認定申請区分コード_申請時);
        entity.setTorisageKubunCode(取下げ区分);
        entity.setTorisageRiyu(取下げ理由);
        entity.setTorisageYMD(取下げ年月日);
        entity.setShinsaKeizokuKubun(審査継続区分);
        return entity;
    }

    private static List<DbT5001NinteiShinseiJohoEntity> create認定申請情報EntityList(int 件数) {
        if (件数 < 0) {
            return Collections.EMPTY_LIST;
        }

        List<DbT5001NinteiShinseiJohoEntity> entities = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            entities.add(create認定申請情報Entity());
        }
        return entities;
    }

    private static NinteiShinseiTorisageTaishosha create認定申請取下げ対象() {
        return NinteishinseiTorisageTaishoshaMapper.to認定申請取下げ対象者(create認定申請情報Entity());
    }
}
