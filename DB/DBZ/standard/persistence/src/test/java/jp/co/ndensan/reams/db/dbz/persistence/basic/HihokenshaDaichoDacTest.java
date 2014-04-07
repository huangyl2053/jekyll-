/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.DbT1001HihokenshaDaichoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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

        public static class FromLasdecCode extends DbzTestDacBase {

            private LasdecCode code1 = new LasdecCode("111111");
            private LasdecCode code2 = new LasdecCode("222222");
            private LasdecCode code3 = new LasdecCode("333333");

            @Before
            public void setUp() {
                initializeTable();
            }

            @Test
            public void LasecCodeによるselectを用いて_あるLasdecCodeで検索したとき_検索結果のLasdecCodeは_検索条件のものと一致する() {
                List<DbT1001HihokenshaDaichoEntity> result = sut.select(code1);
                assertThat(result.get(0).getShichosonCode(), is(code1));
            }

            @Test
            public void LasecCodeによるselectを用いて_DB上3件存在するLasecCodeで検索したとき_検索結果のListのsizeは3を返す() {
                List<DbT1001HihokenshaDaichoEntity> result = sut.select(code1);
                assertThat(result.size(), is(3));
            }

            private void initializeTable() {
                sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(code1, new ShikibetsuCode("1234567890"), RDateTime.now()));
                sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(code1, new ShikibetsuCode("1234567891"), RDateTime.now()));
                sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(code1, new ShikibetsuCode("1234567892"), RDateTime.now()));
                sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(code2, new ShikibetsuCode("1234567893"), RDateTime.now()));
                sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(code2, new ShikibetsuCode("1234567894"), RDateTime.now()));
                sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(code3, new ShikibetsuCode("1234567895"), RDateTime.now()));
            }
        }

        public static class selectLatestOfPerson extends DbzTestDacBase {

            private LasdecCode shichosonCode;
            private ShikibetsuCode shikibetsuCode;
            private FlexibleDate latestDate;

            @Before
            public void setUp() {
                initializeTable();
            }

            @Test
            public void selectLatestOfPersonは_ある個人に対する_直近の情報を取得する() {
                DbT1001HihokenshaDaichoEntity result = sut.selectLatestOfPerson(shichosonCode, shikibetsuCode);
                assertThat(result.getShikakuShutokuYMD(), is(latestDate));
            }

            private void initializeTable() {
                shichosonCode = new LasdecCode("111111");
                shikibetsuCode = new ShikibetsuCode("1234567890");
                latestDate = new FlexibleDate("20140302");

                sut.insert(createEntityFrom(toRDateTime(latestDate), latestDate));
                FlexibleDate oneYearAgo = latestDate.minusYear(1);
                sut.insert(createEntityFrom(toRDateTime(oneYearAgo), oneYearAgo));
                FlexibleDate twoYearAgo = latestDate.minusYear(2);
                sut.insert(createEntityFrom(toRDateTime(twoYearAgo), twoYearAgo));
            }

            private RDateTime toRDateTime(FlexibleDate date) {
                int year = date.getYearValue();
                int month = date.getMonthValue();
                int day = date.getDayValue();
                return RDateTime.of(year, month, day, 0, 0);
            }

            private DbT1001HihokenshaDaichoEntity createEntityFrom(RDateTime 処理日時, FlexibleDate 資格取得年月日) {
                DbT1001HihokenshaDaichoEntity entity;
                entity = DbT1001HihokenshaDaichoEntityMock.createWithKey(shichosonCode, shikibetsuCode, 処理日時);
                entity.setShikakuShutokuYMD(資格取得年月日);
                return entity;
            }
        }

        public static class selectFromKey extends DbzTestDacBase {

            private RDateTime shoriTimestamp;
            private LasdecCode shichosonCode;
            private ShikibetsuCode shikibetsuCode;

            @Before
            public void setUp() {
                initializeTable();
            }

            @Test
            public void selectFromKeyの検索結果に含まれる要素は_検索条件と一致する() {
                DbT1001HihokenshaDaichoEntity result = sut.selectFromKey(shichosonCode, shikibetsuCode, shoriTimestamp);
                assertThat(result.getShichosonCode(), is(shichosonCode));
                assertThat(result.getShikibetsuCode(), is(shikibetsuCode));
                assertThat(result.getShoriTimestamp(), is(shoriTimestamp));
            }

            private void initializeTable() {
                insertWithSpecifiedKey();
            }

            private void insertWithSpecifiedKey() {
                shichosonCode = new LasdecCode("111111");
                shikibetsuCode = new ShikibetsuCode("1234567890");
                shoriTimestamp = RDateTime.of(2014, 4, 2, 17, 20);
                sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(shichosonCode, shikibetsuCode, shoriTimestamp));
            }
        }
    }

    public static class Delete extends DbzTestDacBase {

        private RDateTime shoriTimestamp;
        private LasdecCode shichosonCode;
        private ShikibetsuCode shikibetsuCode;

        @Before
        public void setUp() {
            initializeTable();
        }

        @Test
        public void deleteは_成功したとき_1を返す() {
            DbT1001HihokenshaDaichoEntity selected = sut.selectFromKey(shichosonCode, shikibetsuCode, shoriTimestamp);
            int result = sut.delete(selected);
            assertThat(result, is(1));
        }

        @Test
        public void deleteは_同じ条件での検索結果に影響し_deleteしたEntityは検索できない() {
            DbT1001HihokenshaDaichoEntity selected = sut.selectFromKey(shichosonCode, shikibetsuCode, shoriTimestamp);
            sut.delete(selected);
            assertThat(sut.selectFromKey(shichosonCode, shikibetsuCode, shoriTimestamp), is(nullValue()));
        }

        private void initializeTable() {
            insertWithSpecifiedKey();
        }

        private void insertWithSpecifiedKey() {
            shichosonCode = new LasdecCode("111111");
            shikibetsuCode = new ShikibetsuCode("1234567890");
            shoriTimestamp = RDateTime.of(2014, 4, 2, 17, 20);
            sut.insert(DbT1001HihokenshaDaichoEntityMock.createWithKey(shichosonCode, shikibetsuCode, shoriTimestamp));
        }
    }
}
