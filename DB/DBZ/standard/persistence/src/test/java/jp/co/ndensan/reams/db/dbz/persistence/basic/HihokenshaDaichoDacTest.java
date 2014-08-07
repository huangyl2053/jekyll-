/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.DbT1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * HihokenshaDaichoDacのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoDacTest extends DbzTestDacBase {

    private static HihokenshaDaichoDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(HihokenshaDaichoDac.class);
    }

    public static class Insert extends DbzTestDacBase {

        DbT1001HihokenshaDaichoEntity entity;

        @Before
        public void setUp() {
            entity = DbT1001HihokenshaDaichoEntityMock.create();
        }

        @Test
        public void insertは_成功したとき_1を返す() {
            int result = sut.insert(entity);
            assertThat(result, is(1));
        }
    }

    @RunWith(Enclosed.class)
    public static class Select extends DbzTestDacBase {

        public static class select_LasdecCode extends DbzTestDacBase {

            private final LasdecCode code1 = new LasdecCode(new RString("111111"));
            private final LasdecCode code2 = new LasdecCode(new RString("222222"));
            private final LasdecCode code3 = new LasdecCode(new RString("333333"));

            @Before
            public void setUp() {
                initializeTable();
            }

            @Test
            public void LasecCodeによるselectを用いて_あるLasdecCodeで検索したとき_検索結果のLasdecCodeは_検索条件のものと一致する() {
                List<DbT1001HihokenshaDaichoEntity> result = sut.selectAll(code1);
                assertThat(result.get(0).getShichosonCode(), is(code1));
            }

            @Test
            public void LasecCodeによるselectを用いて_DB上3件存在するLasecCodeで検索したとき_検索結果のListのsizeは3を返す() {
                List<DbT1001HihokenshaDaichoEntity> result = sut.selectAll(code1);
                assertThat(result.size(), is(3));
            }

            private void initializeTable() {
                YMDHMS shoriTimeStamp = new YMDHMS("20110912012345");
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code1, new KaigoHihokenshaNo(new RString("1234567890")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code1, new KaigoHihokenshaNo(new RString("1234567891")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code1, new KaigoHihokenshaNo(new RString("1234567892")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code2, new KaigoHihokenshaNo(new RString("1234567893")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code2, new KaigoHihokenshaNo(new RString("1234567894")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock.
                        createWithKey(code3, new KaigoHihokenshaNo(new RString("1234567895")), shoriTimeStamp));
            }
        }

        @RunWith(Enclosed.class)
        public static class selectAll_ITrueFalseCriteria extends DbzTestDacBase {

            private static final LasdecCode code_111111 = new LasdecCode(new RString("111111"));
            private static final LasdecCode code_222222 = new LasdecCode(new RString("222222"));
            private static final LasdecCode code_333333 = new LasdecCode(new RString("333333"));
            private static final KaigoHihokenshaNo hihokenshaNo_1234567890 = new KaigoHihokenshaNo(new RString("1234567890"));

            public static class LasdecCodeに111111_KaigoHihokenshaNoに1234567890を検索条件として指定した場合 extends DbzTestDacBase {

                private ITrueFalseCriteria criteria;

                @Before
                public void setUp() {
                    initializeTable();
                    criteria = and(eq(shichosonCode, code_111111), eq(hihokenshaNo, hihokenshaNo_1234567890));
                }

                @Test
                public void LasdecCodeによるselectを用いて_あるLasdecCodeで検索したとき_検索結果のLasdecCodeは_検索条件のものと一致する() {
                    List<DbT1001HihokenshaDaichoEntity> result = sut.selectAll(criteria);
                    assertThat(result.get(0).getShichosonCode(), is(code_111111));
                }

                @Test
                public void LasdecCodeによるselectを用いて_あるhihokenshaNoで検索したとき_検索結果のhihokenshaNoは_検索条件のものと一致する() {
                    List<DbT1001HihokenshaDaichoEntity> result = sut.selectAll(criteria);
                    assertThat(result.get(0).getHihokenshaNo(), is(hihokenshaNo_1234567890));
                }

                @Test
                public void 指定した検索条件に合致する被保険者台帳情報は_1件になる() {
                    List<DbT1001HihokenshaDaichoEntity> result = sut.selectAll(criteria);
                    assertThat(result.size(), is(1));
                }
            }

            private static void initializeTable() {
                YMDHMS shoriTimeStamp = new YMDHMS("20110912012345");
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code_111111, new KaigoHihokenshaNo(new RString("1234567890")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code_111111, new KaigoHihokenshaNo(new RString("1234567891")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code_111111, new KaigoHihokenshaNo(new RString("1234567892")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code_222222, new KaigoHihokenshaNo(new RString("1234567893")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock
                        .createWithKey(code_222222, new KaigoHihokenshaNo(new RString("1234567894")), shoriTimeStamp));
                sut.insert(DbT1001HihokenshaDaichoEntityMock.
                        createWithKey(code_333333, new KaigoHihokenshaNo(new RString("1234567895")), shoriTimeStamp));
            }
        }

        public static class selectLatestOfPerson_shikibetsuCode extends DbzTestDacBase {

            private LasdecCode lasdecCode;
            private ShikibetsuCode shikibetsuCode;
            private FlexibleDate latestDate;

            @Before
            public void setUp() {
                initializeTable();
            }

            @Test
            public void selectLatestOfPerson_LasdecCodeAndShikibetsuCode版は_ある個人に対する_直近の情報を取得する() {
                DbT1001HihokenshaDaichoEntity result = sut.selectLatestOfPerson(lasdecCode, shikibetsuCode);
                assertThat(result.getShikakuShutokuYMD(), is(latestDate));
            }

            private void initializeTable() {
                lasdecCode = new LasdecCode(new RString("111111"));
                shikibetsuCode = new ShikibetsuCode("1234567890");
                latestDate = new FlexibleDate("20140302");

                sut.insert(createEntityFrom(toYMDHMS(latestDate), latestDate));
                FlexibleDate oneYearAgo = latestDate.minusYear(1);
                sut.insert(createEntityFrom(toYMDHMS(oneYearAgo), oneYearAgo));
                FlexibleDate twoYearAgo = latestDate.minusYear(2);
                sut.insert(createEntityFrom(toYMDHMS(twoYearAgo), twoYearAgo));
            }

            private DbT1001HihokenshaDaichoEntity createEntityFrom(YMDHMS 処理日時, FlexibleDate 資格取得年月日) {
                DbT1001HihokenshaDaichoEntity entity;
                entity = DbT1001HihokenshaDaichoEntityMock.createWithKey(lasdecCode, shikibetsuCode, 処理日時);
                entity.setShikakuShutokuYMD(資格取得年月日);
                return entity;
            }
        }

        public static class selectLatestOfPerson_hihokenshaNo extends DbzTestDacBase {

            private LasdecCode lasdecCode;
            private ShikibetsuCode shikibetsuCode;
            private YMDHMS latestShoriTimeDate;
            private KaigoHihokenshaNo hihokenshaNo;

            @Before
            public void setUp() {
                initializeTable();
            }

            @Test
            public void selectLatestOfPerson_LasdecCodeAndKaigoHihokenshaNo版は_ある個人に対する_直近の情報を取得する() {
                DbT1001HihokenshaDaichoEntity result = sut.selectLatestOfPerson(lasdecCode, hihokenshaNo);
                assertThat(result.getShoriTimestamp(), is(this.latestShoriTimeDate));
            }

            private void initializeTable() {
                this.lasdecCode = new LasdecCode(new RString("111111"));
                this.shikibetsuCode = new ShikibetsuCode("1234567890");
                this.hihokenshaNo = new KaigoHihokenshaNo(new RString("0987654321"));
                FlexibleDate latestDate = new FlexibleDate("20140302");

                this.latestShoriTimeDate = toYMDHMS(latestDate);
                sut.insert(createEntityFrom(latestShoriTimeDate, latestDate));
                FlexibleDate oneYearAgo = latestDate.minusYear(1);
                sut.insert(createEntityFrom(toYMDHMS(oneYearAgo), oneYearAgo));
                FlexibleDate twoYearAgo = latestDate.minusYear(2);
                sut.insert(createEntityFrom(toYMDHMS(twoYearAgo), twoYearAgo));
            }

            private DbT1001HihokenshaDaichoEntity createEntityFrom(YMDHMS 処理日時, FlexibleDate 資格取得年月日) {
                DbT1001HihokenshaDaichoEntity entity;
                entity = DbT1001HihokenshaDaichoEntityMock.createWithKey(lasdecCode, shikibetsuCode, 処理日時);
                entity.setHihokenshaNo(this.hihokenshaNo);
                entity.setShikakuShutokuYMD(資格取得年月日);
                return entity;
            }
        }

        public static class selectFromKey extends DbzTestDacBase {

            private YMDHMS shoriTimestamp;
            private LasdecCode lasdecCode;
            private ShikibetsuCode shikibetsuCode;

            @Before
            public void setUp() {
                initializeTable();
            }

            @Test
            public void selectFromKeyの検索結果に含まれる要素は_検索条件と一致する() {
                DbT1001HihokenshaDaichoEntity result = sut.selectFromKey(lasdecCode, shikibetsuCode, shoriTimestamp);
                assertThat(result.getShichosonCode(), is(lasdecCode));
                assertThat(result.getShikibetsuCode(), is(shikibetsuCode));
                assertThat(result.getShoriTimestamp(), is(shoriTimestamp));
            }

            private void initializeTable() {
                insertWithSpecifiedKey();
            }

            private void insertWithSpecifiedKey() {
                lasdecCode = new LasdecCode(new RString("111111"));
                shikibetsuCode = new ShikibetsuCode("1234567890");
                shoriTimestamp = new YMDHMS("20140402172000");
                sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(lasdecCode, shikibetsuCode, shoriTimestamp));
            }
        }
    }

    public static class Delete extends DbzTestDacBase {

        private YMDHMS shoriTimestamp;
        private LasdecCode lasdecCode;
        private ShikibetsuCode shikibetsuCode;

        @Before
        public void setUp() {
            initializeTable();
        }

        @Test
        public void deleteは_成功したとき_1を返す() {
            DbT1001HihokenshaDaichoEntity selected = sut.selectFromKey(lasdecCode, shikibetsuCode, shoriTimestamp);
            int result = sut.delete(selected);
            assertThat(result, is(1));
        }

        @Test
        public void deleteは_同じ条件での検索結果に影響し_deleteしたEntityは検索できない() {
            DbT1001HihokenshaDaichoEntity selected = sut.selectFromKey(lasdecCode, shikibetsuCode, shoriTimestamp);
            sut.delete(selected);
            assertThat(sut.selectFromKey(lasdecCode, shikibetsuCode, shoriTimestamp), is(nullValue()));
        }

        private void initializeTable() {
            insertWithSpecifiedKey();
        }

        private void insertWithSpecifiedKey() {
            lasdecCode = new LasdecCode(new RString("111111"));
            shikibetsuCode = new ShikibetsuCode("1234567890");
            shoriTimestamp = new YMDHMS("20140402172000");
            sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(lasdecCode, shikibetsuCode, shoriTimestamp));
        }
    }

    private static YMDHMS toYMDHMS(FlexibleDate date) {
        return new YMDHMS(date.toString() + "000000");
    }
}
