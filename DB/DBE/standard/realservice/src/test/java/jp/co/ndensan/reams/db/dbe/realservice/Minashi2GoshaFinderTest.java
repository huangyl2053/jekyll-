/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IMinashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.business.Minashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.business.Minashi2GoshaList;
import jp.co.ndensan.reams.db.dbe.realservice.search.Minashi2GoshaDaichoSearchItem;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.jukikojin.IJukiKojin;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.IJuminKihonDaichoSearchKey;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.JuminKihonDaichoSearchKeyBuilder;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IJukiKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * みなし2号者Finderのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class Minashi2GoshaFinderTest {

    private static Minashi2GoshaFinder sut;

    private static ISearchCondition condition;
    private static LasdecCode 市町村コード;
    private static ShikibetsuCode 識別コード;
    private static KaigoHihokenshaNo 被保険者番号;
    private static YMDHMS 処理日時;
    private static ShoKisaiHokenshaNo 証記載保険者番号;
    private static HihokenshaKubun 被保険者区分コード;
    private static FlexibleDate みなし2号登録年月日;
    private static FlexibleDate みなし2号解除年月日;

    @BeforeClass
    public static void setUpBeforeClass() {

        市町村コード = new LasdecCode("123456");
        証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("123456"));
        識別コード = new ShikibetsuCode("012345678900001");
        被保険者番号 = new KaigoHihokenshaNo(new RString("1234567890"));
        処理日時 = new YMDHMS("20081106010101");
        被保険者区分コード = new HihokenshaKubun(new Code("1"), new RString("みなし2号"));
        みなし2号登録年月日 = new FlexibleDate("20140101");
        みなし2号解除年月日 = new FlexibleDate("20140101");
    }

    public static class Getみなし2号者List extends DbeTestBase {

        @Test
        public void みなし2号台帳Finderが3件の情報を取得できたとき_3件の要素を持つみなし2号者Listが返る() {
            INewSearchCondition 市町村コード検索条件 = SearchConditionFactory
                    .condition(Minashi2GoshaDaichoSearchItem.市町村コード, StringOperator.完全一致, 市町村コード.value());

            condition = 市町村コード検索条件;

            sut = new Minashi2GoshaFinder(createMinashiFinderMock(3), createKojinFinderMock());
            Minashi2GoshaList result = sut.getみなし2号者List(condition);
            assertThat(result.size(), is(3));
        }

    }

    private static Minashi2GoshaDaichoFinder createMinashiFinderMock(int 件数) {
        List<IMinashi2GoshaDaicho> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            Minashi2GoshaDaicho daicho = mock(Minashi2GoshaDaicho.class);
            when(daicho.get市町村コード()).thenReturn(市町村コード);
            when(daicho.get識別コード()).thenReturn(識別コード);
            list.add(daicho);
        }

        Minashi2GoshaDaichoFinder minashiFinder = mock(Minashi2GoshaDaichoFinder.class);
        when(minashiFinder.getみなし2号者台帳(any(ISearchCondition.class))).thenReturn(list);
        return minashiFinder;
    }

    private static IJukiKojinFinder createKojinFinderMock() {
        IJukiKojin kojin1 = mock(IJukiKojin.class);
        when(kojin1.get識別コード()).thenReturn(識別コード);

        IJukiKojinFinder kojinFinder = mock(IJukiKojinFinder.class);
        IJuminKihonDaichoSearchKey searchKey = createSearchKey(識別コード);
        when(kojinFinder.find住基個人(searchKey)).thenReturn(kojin1);
        return kojinFinder;
    }

    private static IJuminKihonDaichoSearchKey createSearchKey(ShikibetsuCode shikibetsuCode) {
        return new JuminKihonDaichoSearchKeyBuilder(GyomuCode.DB介護保険).set識別コード(shikibetsuCode).build();
    }

}
