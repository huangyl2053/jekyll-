/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_処理日時;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_受給者異動事由;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動区分コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_異動年月日;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.DEFAULT_証記載保険者番号;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac}のテストです。
 *
 * @author LDNS 鄭雪双
 */
@RunWith(Enclosed.class)
public class DbT3002KyodoShoriyoJukyushaIdoKihonSofuDacTest extends DbzTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static final FlexibleDate 異動年月日20140401 = new FlexibleDate("20140401");
    private static final FlexibleDate 異動年月日20140403 = new FlexibleDate("20140403");
    private static DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    異動年月日20140401,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 異動年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    null,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 異動区分コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    null,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 受給者異動事由がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    null,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    null,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    null,
                    DEFAULT_処理日時);
        }

        @Test(expected = NullPointerException.class)
        public void 処理日時がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity insertedRecord = sut.selectByKey(
                    異動年月日20140403,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 共同処理用受給者異動基本送付が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            TestSupport.insert(
                    異動年月日20140401,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 共同処理用受給者異動基本送付が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 共同処理用受給者異動基本送付エンティティを渡すと_insertは_共同処理用受給者異動基本送付を追加する() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

            assertThat(sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 共同処理用受給者異動基本送付エンティティを渡すと_updateは_共同処理用受給者異動基本送付を更新する() {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity updateRecord = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            // TODO 主キー以外の項目を変更してください
//            updateRecord.set変更したい項目(75);

            sut.update(updateRecord);

            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);

//            assertThat(updateRecord.get変更したい項目(), is(updatedRecord.get変更したい項目()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時);
        }

        @Test
        public void 共同処理用受給者異動基本送付エンティティを渡すと_deleteは_共同処理用受給者異動基本送付を削除する() {
            sut.delete(sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時));
            assertThat(sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_処理日時), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleDate 異動年月日,
                RString 異動区分コード,
                RString 受給者異動事由,
                HokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                YMDHMS 処理日時) {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            entity.setIdoYMD(異動年月日);
            entity.setIdoKubunCode(異動区分コード);
            entity.setJukyushaIdoJiyu(受給者異動事由);
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setShoriTimestamp(処理日時);
            sut.insert(entity);
        }
    }
}
