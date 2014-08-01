/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IMinashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Minashi2GoHihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IMinashi2GoshaDaichoDac;
import jp.co.ndensan.reams.db.dbe.realservice.search.Minashi2GoshaDaichoSearchItem;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ur.urz.realservice.search.BooleanOperator;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 *
 * @author N8211 田辺 紘一
 */
@RunWith(Enclosed.class)
public class Minashi2GoshaDaichoFinderTest {

    private static ISearchCondition condition;
    private static IMinashi2GoshaDaichoDac dac;
    private static LasdecCode 市町村コード;
    private static ShikibetsuCode 識別コード;
    private static KaigoHihokenshaNo 被保険者番号;
    private static int 履歴番号;
    private static Minashi2GoHihokenshaKubun 被保険者区分コード;
    private static FlexibleDate みなし2号登録年月日;
    private static FlexibleDate みなし2号解除年月日;

    @BeforeClass
    public static void setUpBeforeClass() {

        市町村コード = new LasdecCode("123456");
        識別コード = new ShikibetsuCode("123456789012345");
        被保険者番号 = new KaigoHihokenshaNo(new RString("1234567890"));
        履歴番号 = 1;
        被保険者区分コード = Minashi2GoHihokenshaKubun.みなし2号;
        みなし2号登録年月日 = new FlexibleDate("20140101");
        みなし2号解除年月日 = new FlexibleDate("20140101");
    }

    public static class getみなし2号者台帳のテスト extends DbeTestBase {

        @Test
        public void Dacから1件の有効な検索結果を取得できたとき_1件の要素を持つ_みなし2号台帳が返る() {
            Minashi2GoshaDaichoFinder sut = new Minashi2GoshaDaichoFinder(createMock(), null);

            INewSearchCondition 被保険者番号検索値 = SearchConditionFactory.condition(Minashi2GoshaDaichoSearchItem.被保番号, StringOperator.完全一致, 被保険者番号.value());
            condition = 被保険者番号検索値;

            List<IMinashi2GoshaDaicho> result = sut.getみなし2号者台帳(condition);

            assertThat(result.size(), is(1));
        }

        private DbT1012Minashi2GoshaDaichoEntity createEntity() {

            DbT1012Minashi2GoshaDaichoEntity entity = new DbT1012Minashi2GoshaDaichoEntity();

            entity.setShichosonCode(市町村コード);
            entity.setShikibetsuCode(識別コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            entity.setHihokenshaKubunCode(被保険者区分コード.getみなし2号区分());
            entity.setMinashi2GoshaTorokuYMD(みなし2号登録年月日);
            entity.setMinashi2GoshaKaijoYMD(みなし2号解除年月日);
            return entity;
        }

        private List<DbT1012Minashi2GoshaDaichoEntity> createEntityList(int 件数) {

            List<DbT1012Minashi2GoshaDaichoEntity> list = new ArrayList<>();
            for (int i = 0; i < 件数; i++) {
                list.add(createEntity());
            }

            return list;
        }

        private IMinashi2GoshaDaichoDac createMock() {
            IMinashi2GoshaDaichoDac dac = mock(IMinashi2GoshaDaichoDac.class);
            when(dac.select(any(ITrueFalseCriteria.class))).thenReturn(createEntityList(1));
            return dac;
        }
    }
}
