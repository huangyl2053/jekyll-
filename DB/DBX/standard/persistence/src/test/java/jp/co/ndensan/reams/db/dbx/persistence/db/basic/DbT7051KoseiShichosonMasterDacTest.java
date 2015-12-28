/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
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
 * {@link DbT7051KoseiShichosonMasterDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7051KoseiShichosonMasterDacTest extends DbxTestDacBase {

    private static final RString キー_01 = new RString("01");
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7051KoseiShichosonMasterDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    public static class selectBy市町村識別ID extends DbxTestDacBase {

        DbT7051KoseiShichosonMasterEntity entity;

        @Before
        public void setUP() {
            entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
        }

        @Test(expected = NullPointerException.class)
        public void selectBy市町村識別IDは_市町村識別IDがnullの場合_NullPointerExceptionを発生させる() {
            sut.selectBy市町村識別ID(null);
        }

        @Test
        public void selectBy市町村識別IDは_指定の市町村識別IDを持ち_isDeletedがfalseの構成市町村情報が存在する場合_要素を持ったListを返却する() {
            entity.setIsDeleted(false);
            sut.save(entity);
            assertThat(sut.selectBy市町村識別ID(entity.getShichosonShokibetsuID()).isEmpty(), is(false));
        }

        @Test
        public void selectBy市町村識別IDは_指定の市町村識別IDを持ちつつも_isDeletedがfalseの構成市町村情報しか存在しない場合_空のListを返却する() {
            entity.setIsDeleted(true);
            sut.save(entity);
            assertThat(sut.selectBy市町村識別ID(entity.getShichosonShokibetsuID()).isEmpty(), is(true));
        }
    }

    public static class selectByKeyのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(キー_01);
            TestSupport.insert(キー_02);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村識別IDがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(null);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            DbT7051KoseiShichosonMasterEntity insertedRecord = sut.selectByKey(キー_01);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            DbT7051KoseiShichosonMasterEntity insertedRecord = sut.selectByKey(キー_03);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectZenShichosonJohoContainingKyuShichosonのテスト extends DbxTestDacBase {

        @Test
        public void selectZenShichosonJohoContainingKyuShichosonは_合併旧市町村区分に係らず_全件を返す_混在() {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(キー_01);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.合併旧市町村.code());
            TestSupport.insert(entity);
            entity.setShichosonShokibetsuID(キー_02);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.構成市町村.code());
            TestSupport.insert(entity);
            assertThat(sut.selectZenShichosonJohoContainingKyuShichoson().size(), is(2));
        }

        @Test
        public void selectZenShichosonJohoContainingKyuShichosonは_合併旧市町村区分に係らず_全件を返す_合併旧市町村のみ() {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(キー_01);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.合併旧市町村.code());
            TestSupport.insert(entity);
            entity.setShichosonShokibetsuID(キー_02);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.合併旧市町村.code());
            TestSupport.insert(entity);
            assertThat(sut.selectZenShichosonJohoContainingKyuShichoson().size(), is(2));
        }

        @Test
        public void selectZenShichosonJohoContainingKyuShichosonは_合併旧市町村区分に係らず_全件を返す_構成市町村のみ() {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(キー_01);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.構成市町村.code());
            TestSupport.insert(entity);
            entity.setShichosonShokibetsuID(キー_02);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.構成市町村.code());
            TestSupport.insert(entity);
            assertThat(sut.selectZenShichosonJohoContainingKyuShichoson().size(), is(2));
        }

        @Test
        public void selectZenShichosonJohoContainingKyuShichosonは_構成市町村マスタにデータが存在しない場合_空のリストを返す() {
            assertThat(sut.selectZenShichosonJohoContainingKyuShichoson().size(), is(0));
        }
    }

    public static class selectPresenceShichosonJohoのテスト extends DbxTestDacBase {

        @Test
        public void selectPresenceShichosonJohoは_構成市町村のみを返す_混在() {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(キー_01);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.合併旧市町村.code());
            TestSupport.insert(entity);
            entity.setShichosonShokibetsuID(キー_02);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.構成市町村.code());
            TestSupport.insert(entity);
            assertThat(sut.selectPresenceShichosonJoho().size(), is(1));
        }

        @Test
        public void selectPresenceShichosonJohoは_構成市町村のみを返す_合併旧市町村のみのため結果0件() {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(キー_01);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.合併旧市町村.code());
            TestSupport.insert(entity);
            entity.setShichosonShokibetsuID(キー_02);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.合併旧市町村.code());
            TestSupport.insert(entity);
            assertThat(sut.selectPresenceShichosonJoho().size(), is(0));
        }

        @Test
        public void selectPresenceShichosonJohoは_構成市町村のみを返す_構成市町村のみ() {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(キー_01);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.構成市町村.code());
            TestSupport.insert(entity);
            entity.setShichosonShokibetsuID(キー_02);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.構成市町村.code());
            TestSupport.insert(entity);
            assertThat(sut.selectPresenceShichosonJoho().size(), is(2));
        }

        @Test
        public void selectZenShichosonJohoContainingKyuShichosonは_構成市町村マスタにデータが存在しない場合_空のリストを返す() {
            assertThat(sut.selectPresenceShichosonJoho().size(), is(0));
        }
    }

    public static class insertのテスト extends DbxTestDacBase {

        @Test
        public void saveは_生成直後の構成市町村マスタエンティティを渡すと_構成市町村マスタを追加する() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村識別ID), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(DEFAULT_市町村識別ID);
        }

        @Test
        public void saveは_構成市町村マスタエンティティを渡すと_構成市町村マスタを更新する() {
            DbT7051KoseiShichosonMasterEntity updateRecord = sut.selectByKey(DEFAULT_市町村識別ID);
            updateRecord.setTyohyoKatagakiHyojiUmu(new RString("1"));

            sut.save(updateRecord);

            DbT7051KoseiShichosonMasterEntity updatedRecord = sut.selectByKey(
                    DEFAULT_市町村識別ID);

            assertThat(updateRecord.getTyohyoKatagakiHyojiUmu(), is(updatedRecord.getTyohyoKatagakiHyojiUmu()));
        }
    }

    public static class deleteのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_市町村識別ID);
        }

        @Test
        public void saveは_EntityDataStateがDeletedの_構成市町村マスタエンティティを渡すと_構成市町村マスタを削除する() {
            DbT7051KoseiShichosonMasterEntity deletedEntity = sut.selectByKey(
                    DEFAULT_市町村識別ID);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_市町村識別ID), is(nullValue()));
        }
    }

    public static class selectKyuShichosonByChikiNoOneDigitのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(キー_01);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.合併旧市町村.code());
            entity.setGappeiChiikiNo(new RString("11"));
            TestSupport.insert(entity);
            entity.setShichosonShokibetsuID(キー_02);
            entity.setGappeiChiikiNo(new RString("12"));
            TestSupport.insert(entity);
            entity.setGappeiKyuShichosonKubun(GappeiKyuShichosonKubun.構成市町村.code());
            entity.setShichosonShokibetsuID(キー_03);
            entity.setGappeiChiikiNo(new RString("13"));
            TestSupport.insert(entity);
        }

        @Test
        public void selectKyuShichosonByChikiNoOneDigitは_合併旧市町村で_合併地域番号の1桁目が引数の1桁目と一致する要素をすべて返却する() {
            assertThat(sut.selectKyuShichosonByChikiNoOneDigit(new RString("1x")).size(), is(2));
        }

        @Test
        public void selectKyuShichosonByChikiNoOneDigitは_該当する要素が無い時_空のListを返す() {
            assertThat(sut.selectKyuShichosonByChikiNoOneDigit(new RString("2x")).size(), is(0));
        }
    }

    private static class TestSupport {

        public static void insert(
                RString 市町村識別ID) {
            DbT7051KoseiShichosonMasterEntity entity = DbT7051KoseiShichosonMasterEntityGenerator.createDbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(市町村識別ID);
            sut.save(entity);
        }

        public static void insert(DbT7051KoseiShichosonMasterEntity entity) {
            sut.save(entity);
        }

        private TestSupport() {
        }
    }
}
