/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
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
 * {@link DbT7051KoseiShichosonMasterDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7051KoseiShichosonMasterDacTest extends DbzTestDacBase {

    private static final RString キー_01 = RString.EMPTY;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7051KoseiShichosonMasterDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村識別IDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_市町村識別ID);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7051KoseiShichosonMasterEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村識別ID);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7051KoseiShichosonMasterEntity insertedRecord = sut.selectByKey(
                    DEFAULT_市町村識別ID);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 構成市町村マスタが存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 構成市町村マスタが存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 構成市町村マスタエンティティを渡すと_insertは_構成市町村マスタを追加する() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村識別ID), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
        }

        @Test
        public void 構成市町村マスタエンティティを渡すと_updateは_構成市町村マスタを更新する() {
            DbT7051KoseiShichosonMasterEntity updateRecord = sut.selectByKey(
                    DEFAULT_市町村識別ID);
            updateRecord.setGunMeisho(new RString("郡名称"));

            sut.save(updateRecord);

            DbT7051KoseiShichosonMasterEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村識別ID);

            assertThat(updateRecord.getGunMeisho(), is(updatedRecord.getGunMeisho()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
        }

        @Test
        public void 構成市町村マスタエンティティを渡すと_deleteは_構成市町村マスタを削除する() {
            DbT7051KoseiShichosonMasterEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村識別ID);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村識別ID), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 市町村識別ID) {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(市町村識別ID);
            sut.save(entity);
        }
    }
}
