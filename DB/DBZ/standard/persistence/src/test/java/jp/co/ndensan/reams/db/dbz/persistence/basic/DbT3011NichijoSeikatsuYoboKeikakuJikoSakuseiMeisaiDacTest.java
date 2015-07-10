/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_対象年月;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.DEFAULT_識別コード;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final HihokenshaNo 被保険者番号1 = new HihokenshaNo(new RString("1"));
    private static final HihokenshaNo 被保険者番号3 = new HihokenshaNo(new RString("3"));
    private static DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    被保険者番号1,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    null,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    null,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 対象年月がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity insertedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity insertedRecord = sut.selectByKey(
                    被保険者番号3,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 日常生活予防給付計画自己作成明細が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    被保険者番号1,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 日常生活予防給付計画自己作成明細が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 日常生活予防給付計画自己作成明細エンティティを渡すと_insertは_日常生活予防給付計画自己作成明細を追加する() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
        }

        @Test
        public void 日常生活予防給付計画自己作成明細エンティティを渡すと_updateは_日常生活予防給付計画自己作成明細を更新する() {
            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity updateRecord = DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity();
            // TODO 主キー以外の項目を変更してください
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity updatedRecord = sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);

//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時);
        }

        @Test
        public void 日常生活予防給付計画自己作成明細エンティティを渡すと_deleteは_日常生活予防給付計画自己作成明細を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_被保険者番号,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_対象年月,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                HihokenshaNo 被保険者番号,
                HokenshaNo 証記載保険者番号,
                ShikibetsuCode 識別コード,
                FlexibleYearMonth 対象年月,
                YMDHMS 処理日時) {
            DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity entity = DbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntityGenerator.createDbT3011NichijoSeikatsuYoboKeikakuJikoSakuseiMeisaiEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setShikibetsuCode(識別コード);
            entity.setTaishoYM(対象年月);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
