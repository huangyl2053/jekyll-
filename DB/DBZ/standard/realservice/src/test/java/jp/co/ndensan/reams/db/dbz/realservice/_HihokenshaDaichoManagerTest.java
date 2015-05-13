/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.ShikakuShutoku;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.DbT1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.business.mapper.HihokenshaShikakuMapper;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.persistence.basic.HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.realservice.search.HihokenshaSearchItem;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * HihokenshaDaichoManagerのテストです。
 *
 * @deprecated
 * jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho.HihokenshaDaichoManagerTestを使用してください。
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class _HihokenshaDaichoManagerTest extends DbzTestBase {

    public static class save extends DbzTestBase {

        private _HihokenshaDaichoManager sut;
        private HihokenshaDaichoDac dac;
        private IHihokenshaShikaku shikaku;

        @Before
        public void setUp() {
            dac = mock(HihokenshaDaichoDac.class);
            sut = new _HihokenshaDaichoManager(dac, HihokenshaNoSaibanService.forTestType(new RString("1234567890")));
            shikaku = new HihokenshaShikaku.Builder(new LasdecCode("123456"), new ShikibetsuCode("1234567890"),
                    new YMDHMS("20110912012345"),
                    new HihokenshaKubun(new Code("1"), new RString("第1号")), FlexibleDate.MAX, ShikakuShutoku.NOTHING)
                    .build();
        }

        @Test
        public void saveは_dacによる更新結果が1件以上のとき_trueを返す() {
            when(dac.insert(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(1);
            assertThat(sut.save(shikaku), is(true));
        }

        @Test
        public void saveは_dacによる更新結果が0件のとき_falseを返す() {
            when(dac.insert(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(0);
            assertThat(sut.save(shikaku), is(false));
        }
    }

    public static class remove extends DbzTestBase {

        private _HihokenshaDaichoManager sut;
        private HihokenshaDaichoDac dac;
        private IHihokenshaShikaku shikaku;

        @Before
        public void setUp() {
            dac = mock(HihokenshaDaichoDac.class);
            sut = new _HihokenshaDaichoManager(dac, HihokenshaNoSaibanService.forTestType(new RString("1234567890")));
            shikaku = new HihokenshaShikaku.Builder(new LasdecCode("123456"), new ShikibetsuCode("1234567890"),
                    new YMDHMS("20110912012345"),
                    new HihokenshaKubun(new Code("1"), new RString("第1号")), FlexibleDate.MAX, ShikakuShutoku.NOTHING)
                    .build();
        }

        @Test
        public void removeは_dacによる更新結果が1件以上のとき_trueを返す() {
            when(dac.delete(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(1);
            assertThat(sut.remove(shikaku), is(true));
        }

        @Test
        public void removeは_dacによる更新結果が0件のとき_falseを返す() {
            when(dac.delete(any(DbT1001HihokenshaDaichoEntity.class))).thenReturn(0);
            assertThat(sut.save(shikaku), is(false));
        }
    }

    @RunWith(Enclosed.class)
    public static class get extends DbzTestBase {

        private static HihokenshaDaichoDac dac;
        private static final LasdecCode lasdecCode = new LasdecCode("123456");
        private static final ShikibetsuCode shikibetsuCode = new ShikibetsuCode("1234567890");
        private static final YMDHMS shoriTimestamp = new YMDHMS("20140417095900");
        private static final HihokenshaNo hihokenshaNo = new HihokenshaNo(new RString("1562483169"));
        private static IHihokenshaShikaku shikaku;
        private static _HihokenshaDaichoManager sut;

        @BeforeClass
        public static void setUpClass() {
            DbT1001HihokenshaDaichoEntity entity = createEntity(lasdecCode, shikibetsuCode, shoriTimestamp);
            entity.setHihokenshaNo(hihokenshaNo);
            shikaku = HihokenshaShikakuMapper.toHihokenshaShikaku(entity);

            dac = mock(HihokenshaDaichoDac.class);
            when(dac.selectLatestOfPerson(lasdecCode, shikibetsuCode))
                    .thenReturn(entity);
            when(dac.selectLatestOfPerson(lasdecCode, hihokenshaNo))
                    .thenReturn(entity);
            when(dac.selectLatestOfPerson(lasdecCode, shikibetsuCode))
                    .thenReturn(entity);

            sut = new _HihokenshaDaichoManager(dac, HihokenshaNoSaibanService.forTestType(new RString("1234567890")));
        }

        public static class get直近被保険者資格_ShikibetsuCode版 extends DbzTestBase {

            @Test
            public void get直近被保険者資格_ShikibetsuCode版_の結果は_同じ条件のHihokenshaDaichoDac$selectLatestOfPersonの結果をHihokenshaShikakuMapperで変換したものと_市町村コードが一致する() {
                IHihokenshaShikaku result = sut.get直近被保険者資格(lasdecCode, shikibetsuCode);
                assertThat(result.get市町村コード(), is(shikaku.get市町村コード()));
            }

            @Test
            public void get直近被保険者資格_ShikibetsuCode版_の結果は_同じ条件のHihokenshaDaichoDac$selectLatestOfPersonの結果をHihokenshaShikakuMapperで変換したものと_識別コードが一致する() {
                IHihokenshaShikaku result = sut.get直近被保険者資格(lasdecCode, shikibetsuCode);
                assertThat(result.get識別コード(), is(shikaku.get識別コード()));
            }

            @Test
            public void get直近被保険者資格_ShikibetsuCode版_の結果は_同じ条件のHihokenshaDaichoDac$selectLatestOfPersonの結果をHihokenshaShikakuMapperで変換したものと_被保険者台帳登録日時が一致する() {
                IHihokenshaShikaku result = sut.get直近被保険者資格(lasdecCode, shikibetsuCode);
                assertThat(result.get処理日時(), is(shikaku.get処理日時()));
            }

            @Test
            public void get直近被保険者資格_ShikibetsuCode版_は_検索結果が得られないとき_nullを返す() {
                IHihokenshaShikaku result = sut.get直近被保険者資格(lasdecCode, new ShikibetsuCode("9876543210"));
                assertThat(result, is(nullValue()));
            }
        }

        public static class get直近被保険者資格_KaigoHihokenshaNo版 extends DbzTestBase {

            @Test
            public void get直近被保険者資格_KaigoHihokenshaNo版_の結果は_同じ条件のHihokenshaDaichoDac$selectLatestOfPersonの結果をHihokenshaShikakuMapperで変換したものと_市町村コードが一致する() {
                IHihokenshaShikaku result = sut.get直近被保険者資格(lasdecCode, hihokenshaNo);
                assertThat(result.get市町村コード(), is(shikaku.get市町村コード()));
            }

            @Test
            public void get直近被保険者資格_KaigoHihokenshaNo版_の結果は_同じ条件のHihokenshaDaichoDac$selectLatestOfPersonの結果をHihokenshaShikakuMapperで変換したものと_識別コードが一致する() {
                IHihokenshaShikaku result = sut.get直近被保険者資格(lasdecCode, hihokenshaNo);
                assertThat(result.get識別コード(), is(shikaku.get識別コード()));
            }

            @Test
            public void get直近被保険者資格_KaigoHihokenshaNo版_の結果は_同じ条件のHihokenshaDaichoDac$selectLatestOfPersonの結果をHihokenshaShikakuMapperで変換したものと_被保険者台帳登録日時が一致する() {
                IHihokenshaShikaku result = sut.get直近被保険者資格(lasdecCode, hihokenshaNo);
                assertThat(result.get処理日時(), is(shikaku.get処理日時()));
            }

            @Test
            public void get直近被保険者資格_KaigoHihokenshaNo版_は_検索結果が得られないとき_nullを返す() {
                IHihokenshaShikaku result = sut.get直近被保険者資格(lasdecCode, new HihokenshaNo(new RString("9876543210")));
                assertThat(result, is(nullValue()));
            }
        }

        public static class get被保険者資格 extends DbzTestBase {

            @Test
            public void get被保険者資格の結果は_同じ条件のHihokenshaDaichoDac$selectFromKeyの結果をHihokenshaShikakuMapperで変換したものと_市町村コードが一致する() {
                IHihokenshaShikaku result = sut.get被保険者資格(lasdecCode, shikibetsuCode);
                assertThat(result.get市町村コード(), is(shikaku.get市町村コード()));
            }

            @Test
            public void get被保険者資格の結果は_同じ条件のHihokenshaDaichoDac$selectFromKeyの結果をHihokenshaShikakuMapperで変換したものと_識別コードが一致する() {
                IHihokenshaShikaku result = sut.get被保険者資格(lasdecCode, shikibetsuCode);
                assertThat(result.get識別コード(), is(shikaku.get識別コード()));
            }

            @Test
            public void get被保険者資格の結果は_同じ条件のHihokenshaDaichoDac$selectFromKeyの結果をHihokenshaShikakuMapperで変換したものと_被保険者台帳登録日時が一致する() {
                IHihokenshaShikaku result = sut.get被保険者資格(lasdecCode, shikibetsuCode);
                assertThat(result.get処理日時(), is(shikaku.get処理日時()));
            }

            @Test
            public void get被保険者資格は_検索結果が得られないとき_nullを返す() {
                IHihokenshaShikaku result = sut.get被保険者資格(lasdecCode, new ShikibetsuCode("9876543210"));
                assertThat(result, is(nullValue()));
            }
        }

        public static class get被保険者資格ListOf_市町村コード指定 extends DbzTestBase {

            List<DbT1001HihokenshaDaichoEntity> entities;

            @Before
            public void setUp() {
                entities = new ArrayList<>();
                entities.add(createEntity(lasdecCode, shikibetsuCode, shoriTimestamp));
                entities.add(createEntity(lasdecCode, new ShikibetsuCode("9876543210"), shoriTimestamp));
                entities.add(createEntity(lasdecCode, new ShikibetsuCode("0987654321"), shoriTimestamp));
                when(dac.selectAll()).thenReturn(entities);
            }

            @Test
            public void get被保険者資格ListOfの結果は_同じ条件のHihokenshaDaichoDac$selectの結果と_listのサイズが一致する() {
                List<IHihokenshaShikaku> result = sut.get被保険者資格ListOf(lasdecCode);
                assertThat(result.size(), is(entities.size()));
            }

            @Test
            public void get被保険者資格ListOfの結果はすべて_HihokenshaDaichoDac$selectの検索条件と_市町村コードが一致する() {
                List<IHihokenshaShikaku> result = sut.get被保険者資格ListOf(lasdecCode);
                assertThat(result.get(0).get市町村コード(), is(lasdecCode));
                assertThat(result.get(1).get市町村コード(), is(lasdecCode));
                assertThat(result.get(2).get市町村コード(), is(lasdecCode));
            }

            @Test
            public void get被保険者資格ListOfは_検索結果が得られないとき_Collections$EMPTY_LIST_を返す() {
                List<IHihokenshaShikaku> result = sut.get被保険者資格ListOf(new LasdecCode("666666"));
                assertThat(result, is(Collections.EMPTY_LIST));
            }
        }

        public static class get被保険者資格ListOf_検索条件指定 extends DbzTestBase {

            List<DbT1001HihokenshaDaichoEntity> entities;
            ISearchCondition condition;

            @Before
            public void setUp() {
                INewSearchCondition lasdecCodeCriteria = SearchConditionFactory.condition(HihokenshaSearchItem.市町村コード,
                        StringOperator.完全一致, lasdecCode.getColumnValue());
                INewSearchCondition hihokenshaNoCriteria = SearchConditionFactory.condition(HihokenshaSearchItem.被保険者番号,
                        StringOperator.完全一致, hihokenshaNo.getColumnValue());
                condition = hihokenshaNoCriteria.and(lasdecCodeCriteria);

                entities = new ArrayList<>();
                entities.add(createEntity(lasdecCode, hihokenshaNo, shoriTimestamp));
                when(dac.selectAll()).thenReturn(entities);
            }

            @Test
            public void get被保険者資格ListOfの結果は_同じ条件のHihokenshaDaichoDac$selectの結果と_listのサイズが一致する() {
                List<IHihokenshaShikaku> result = sut.get被保険者資格ListOf(condition);
                assertThat(result.size(), is(entities.size()));
            }

            @Test
            public void get被保険者資格ListOfの結果はすべて_HihokenshaDaichoDac$selectの検索条件と_市町村コードが一致する() {
                List<IHihokenshaShikaku> result = sut.get被保険者資格ListOf(condition);
                assertThat(result.get(0).get市町村コード(), is(lasdecCode));
            }

            @Test
            public void get被保険者資格ListOfの結果はすべて_HihokenshaDaichoDac$selectの検索条件と_被保険者番号が一致する() {
                List<IHihokenshaShikaku> result = sut.get被保険者資格ListOf(condition);
                assertThat(result.get(0).get被保険者番号(), is(hihokenshaNo));
            }

            @Test
            public void get被保険者資格ListOfは_検索結果が得られないとき_Collections$EMPTY_LIST_を返す() {
                List<IHihokenshaShikaku> result = sut.get被保険者資格ListOf(new LasdecCode("666666"));
                assertThat(result, is(Collections.EMPTY_LIST));
            }
        }

        private static DbT1001HihokenshaDaichoEntity createEntity(LasdecCode lasdecCode,
                ShikibetsuCode shikibetsuCode, YMDHMS shoriTimestamp) {
            DbT1001HihokenshaDaichoEntity entity
                    = DbT1001HihokenshaDaichoEntityMock.getSpiedInstance();
            entity.setShichosonCode(lasdecCode);
            entity.setShikibetsuCode(shikibetsuCode);
            entity.setShoriTimestamp(ShoriTimestamp.of(shoriTimestamp));
            return entity;
        }

        private static DbT1001HihokenshaDaichoEntity createEntity(LasdecCode lasdecCode,
                HihokenshaNo hihokenshaNo, YMDHMS shoriTimestamp) {
            DbT1001HihokenshaDaichoEntity entity
                    = DbT1001HihokenshaDaichoEntityMock.getSpiedInstance();
            entity.setShichosonCode(lasdecCode);
            entity.setHihokenshaNo(hihokenshaNo);
            entity.setShoriTimestamp(ShoriTimestamp.of(shoriTimestamp));
            return entity;
        }
    }
}
