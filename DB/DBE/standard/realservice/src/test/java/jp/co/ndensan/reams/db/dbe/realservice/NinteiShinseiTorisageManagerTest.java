/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisageTaishosha;
import jp.co.ndensan.reams.db.dbe.business.NinteiShinseiTorisageTaishoshaList;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.mapper.NinteishinseiTorisageTaishoshaMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.INinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private static ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("A01200"));
    private static KaigoHihokenshaNo 被保険者No = new KaigoHihokenshaNo(new RString("1234567890"));
    private static FlexibleDate 認定申請年月日 = new FlexibleDate(new RString("20120101"));
    private static NinteiShinseiKubunShinsei 認定申請区分コード_申請時 = NinteiShinseiKubunShinsei.新規申請;
    private static TorisageKubun 取下げ区分 = TorisageKubun.区分変更却下;
    private static RString 取下げ理由 = new RString("とりさげ");
    private static FlexibleDate 取下げ年月日 = new FlexibleDate(new RString("20120101"));
    private static ShinsaKeizokuKubun 審査継続区分 = ShinsaKeizokuKubun.継続しない;
    private static Range<RDate> 年月日範囲 = new Range(new FlexibleDate(new RString("20110101")), new FlexibleDate(new RString("20130101")));
    private static NinteiShinseiTorisageTaishosha 認定申請取下げ対象 = create認定申請取下げ対象();
    private static NinteiShinseiTorisageManager sut;

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
            NinteiShinseiTorisageTaishoshaList results = sut.get認定申請取下げ対象者全件(証記載保険者番号, 年月日範囲);
            assertThat(results.size(), is(3));
        }
    }

    public static class get認定申請取下げ者のテスト {

        @Test
        public void 指定した取下げ年月日範囲に合致する認定申請取下げ者を_2件持つリストを取得できる() {
            sut = new NinteiShinseiTorisageManager(createMockDac());
            NinteiShinseiTorisageTaishoshaList results = sut.get認定申請取下げ者(証記載保険者番号, 年月日範囲);
            assertThat(results.size(), is(2));
        }
    }

    public static class saveのテスト {

        @Test
        public void 引数から受け取った情報を更新できたとき_saveメソッドからtrueが返る() {
            sut = new NinteiShinseiTorisageManager(createMockDac());
            assertThat(sut.save(認定申請取下げ対象.get申請書管理No(), 認定申請取下げ対象.get認定申請取下げ()), is(true));
        }

        @Test
        public void 引数から受け取った情報を更新できなかったとき_saveメソッドからfalseが返る() {
            sut = new NinteiShinseiTorisageManager(createMockDac_更新に失敗した場合());
            assertThat(sut.save(認定申請取下げ対象.get申請書管理No(), 認定申請取下げ対象.get認定申請取下げ()), is(false));
        }
    }

    private static INinteiShinseiJohoDac createMockDac() {
        INinteiShinseiJohoDac mockDac = mock(INinteiShinseiJohoDac.class);
        when(mockDac.select(any(ShinseishoKanriNo.class))).thenReturn(create認定申請情報Entity());
        when(mockDac.selectAllBy認定申請年月日(any(ShoKisaiHokenshaNo.class), any(Range.class))).thenReturn(create認定申請情報EntityList(3));
        when(mockDac.selectAllBy取下げ年月日(any(ShoKisaiHokenshaNo.class), any(Range.class))).thenReturn(create認定申請情報EntityList(2));
        when(mockDac.insert(any(DbT5001NinteiShinseiJohoEntity.class))).thenReturn(1);
        return mockDac;
    }

    private static INinteiShinseiJohoDac createMockDac_更新に失敗した場合() {
        INinteiShinseiJohoDac mockDac = mock(INinteiShinseiJohoDac.class);
        when(mockDac.select(any(ShinseishoKanriNo.class))).thenReturn(create認定申請情報Entity());
        when(mockDac.selectAllBy認定申請年月日(any(ShoKisaiHokenshaNo.class), any(Range.class))).thenReturn(create認定申請情報EntityList(3));
        when(mockDac.selectAllBy取下げ年月日(any(ShoKisaiHokenshaNo.class), any(Range.class))).thenReturn(create認定申請情報EntityList(2));
        when(mockDac.insert(any(DbT5001NinteiShinseiJohoEntity.class))).thenReturn(0);
        return mockDac;
    }

    private static DbT5001NinteiShinseiJohoEntity create認定申請情報Entity() {
        DbT5001NinteiShinseiJohoEntity entity = new DbT5001NinteiShinseiJohoEntity();
        entity.setShinseishoKanriNo(申請書管理No);
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        entity.setHihokenshaNo(被保険者No);
        entity.setNinteiShinseiYMD(認定申請年月日);
        entity.setNinteiShinseiShinseijiKubunCode(
                new Code(String.valueOf(認定申請区分コード_申請時.コード())));
        entity.setTorisageKubunCode(取下げ区分.get取下げ区分コード());
        entity.setTorisageRiyu(取下げ理由);
        entity.setTorisageYMD(取下げ年月日);
        entity.setShinsaKeizokuKubun(審査継続区分.is継続());
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
