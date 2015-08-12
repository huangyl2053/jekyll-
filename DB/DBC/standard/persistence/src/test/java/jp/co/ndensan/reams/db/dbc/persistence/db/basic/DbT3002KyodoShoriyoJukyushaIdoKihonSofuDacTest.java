/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator;
import static jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT3002KyodoShoriyoJukyushaIdoKihonSofuDacTest extends DbcTestDacBase {

    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT3002KyodoShoriyoJukyushaIdoKihonSofuDac.class);
    }

    public static class selectByKeyのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 異動年月日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 異動区分コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 受給者異動事由がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity insertedRecord = sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbcTestDacBase {

        @Test
        public void 共同処理用受給者異動基本送付が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 共同処理用受給者異動基本送付が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbcTestDacBase {

        @Test
        public void 共同処理用受給者異動基本送付エンティティを渡すと_insertは_共同処理用受給者異動基本送付を追加する() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);

            assertThat(sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 共同処理用受給者異動基本送付エンティティを渡すと_updateは_共同処理用受給者異動基本送付を更新する() {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity updateRecord = sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            updateRecord.setAddress(new RString("test"));

            sut.save(updateRecord);

            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity updatedRecord = sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);

            assertThat(updateRecord.getAddress(), is(updatedRecord.getAddress()));
        }
    }

    public static class deleteのテスト extends DbcTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
        }

        @Test
        public void 共同処理用受給者異動基本送付エンティティを渡すと_deleteは_共同処理用受給者異動基本送付を削除する() {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity deletedEntity = sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_異動年月日,
                    DEFAULT_異動区分コード,
                    DEFAULT_受給者異動事由,
                    DEFAULT_証記載保険者番号,
                    DEFAULT_被保険者番号,
                    DEFAULT_履歴番号), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                FlexibleDate 異動年月日,
                RString 異動区分コード,
                RString 受給者異動事由,
                HokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                Decimal 履歴番号) {
            DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity = DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator.createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
            entity.setIdoYMD(異動年月日);
            entity.setIdoKubunCode(異動区分コード);
            entity.setJukyushaIdoJiyu(受給者異動事由);
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            sut.save(entity);
        }
    }
}
