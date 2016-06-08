/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DbT7001FufukuMoshitateDac}のテストです。
 */
@RunWith(Enclosed.class)
public class DbT7001FufukuMoshitateDacTest extends DbzTestDacBase {

    private static final RString キー_01 = RString.EMPTY;
    private static final RString キー_02 = new RString("02");
    private static final RString キー_03 = new RString("03");
    private static DbT7001FufukuMoshitateDac sut;
    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("209007");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final HihokenshaNo DEFAULT_原処分被保険者番号 = new HihokenshaNo("010101");
    public static final FlexibleDate DEFAULT_審査請求届出日 = new FlexibleDate("19900101");
    public static final YubinNo DEFAULT_原処分被保険者郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_原処分被保険者住所 = new AtenaJusho("");
    public static final AtenaMeisho DEFAULT_原処分被保険者氏名 = new AtenaMeisho("");
    public static final TelNo DEFAULT_原処分被保険者電話番号 = new TelNo("08011112222");
    public static final FlexibleDate DEFAULT_原処分被保険者生年月日 = new FlexibleDate("19900101");
    public static final YubinNo DEFAULT_審査請求人郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_審査請求人住所 = new AtenaJusho("");
    public static final AtenaMeisho DEFAULT_審査請求人氏名 = new AtenaMeisho("");
    public static final TelNo DEFAULT_審査請求人電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_被保険者との関係コード = new RString("1");
    public static final YubinNo DEFAULT_代理人郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_代理人住所 = new AtenaJusho("");
    public static final AtenaMeisho DEFAULT_代理人氏名 = new AtenaMeisho("");
    public static final TelNo DEFAULT_代理人電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_処分庁 = new RString("Data");
    public static final FlexibleDate DEFAULT_処分日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_処分種類コード = new RString("2");
    public static final FlexibleDate DEFAULT_処分があったことを知った日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_審査請求の理由 = new RString("Data");
    public static final RString DEFAULT_処分庁教示の有無及び教示の内容 = new RString("Data");
    public static final boolean DEFAULT_添付書類等 = false;
    public static final FlexibleDate DEFAULT_審査請求取下日 = new FlexibleDate("19900101");
    public static final boolean DEFAULT_弁明書登録フラグ = false;
    public static final FlexibleDate DEFAULT_弁明書作成日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_裁決日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_裁決結果 = new RString("Data");
    public static final RString DEFAULT_裁決理由 = new RString("Data");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
    }

    public static class selectByKeyのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test(expected = NullPointerException.class)
        public void 原処分被保険者番号がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test(expected = NullPointerException.class)
        public void 審査請求届出日がnullの場合_selectByKeyは_NullPointerExceptionを発生させる() {
            sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test
        public void 存在する主キーを渡すと_selectByKeyは_該当のエンティティを返す() {
            jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            assertThat(insertedRecord, is(notNullValue()));
        }

        @Test
        public void 存在しない主キーを渡すと_selectByKeyは_nullを返す() {
            jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity insertedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            assertThat(insertedRecord, is(nullValue()));
        }
    }

    public static class selectAllのテスト extends DbzTestDacBase {

        @Test
        public void 不服審査申立情報が存在する場合_selectAllは_全件を返す() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            assertThat(sut.selectAll().size(), is(2));
        }

        @Test
        public void 不服審査申立情報が存在しない場合_selectAllは_空のリストを返す() {
            assertThat(sut.selectAll(), is(Collections.EMPTY_LIST));
        }
    }

    public static class insertのテスト extends DbzTestDacBase {

        @Test
        public void 不服審査申立情報エンティティを渡すと_insertは_不服審査申立情報を追加する() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日), is(notNullValue()));
        }
    }

    public static class updateのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test
        public void 不服審査申立情報エンティティを渡すと_updateは_不服審査申立情報を更新する() {
            jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity updateRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            updateRecord.setDairininShimei(new AtenaMeisho("代理人氏名"));

            sut.save(updateRecord);

            jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity updatedRecord = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);

            assertThat(updateRecord.getDairininShimei(), is(updatedRecord.getDairininShimei()));
        }
    }

    public static class deleteのテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insert(
                    DEFAULT_証記載保険者番号,
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
        }

        @Test
        public void 不服審査申立情報エンティティを渡すと_deleteは_不服審査申立情報を削除する() {
            jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity deletedEntity = sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日);
            deletedEntity.setState(EntityDataState.Deleted);

            sut.save(deletedEntity);

            assertThat(sut.selectByKey(
                    DEFAULT_識別コード,
                    DEFAULT_原処分被保険者番号,
                    DEFAULT_審査請求届出日), is(nullValue()));
        }
    }

    private static class TestSupport {

        public static void insert(
                ShoKisaiHokenshaNo 証記載保険者番号,
                ShikibetsuCode 識別コード,
                HihokenshaNo 原処分被保険者番号,
                FlexibleDate 審査請求届出日) {
            DbT7001FufukuMoshitateEntity entity = new DbT7001FufukuMoshitateEntity();
            entity.setShikibetsuCode(DEFAULT_識別コード);
            entity.setGenshobunsHihokennshaNo(DEFAULT_原処分被保険者番号);
            entity.setShinsaSeikyuTodokedeYMD(DEFAULT_審査請求届出日);
            entity.setShinsaSeikyuninYubinNo(DEFAULT_審査請求人郵便番号);
            entity.setShinsaSeikyuninJusho(DEFAULT_審査請求人住所);
            entity.setShinsaSeikyuninShimei(DEFAULT_審査請求人氏名);
            entity.setShinsaSeikyuninTelNo(DEFAULT_審査請求人電話番号);
            entity.setHihokenshaTonoKankeiCode(DEFAULT_被保険者との関係コード);
            entity.setDairininYubinNo(DEFAULT_代理人郵便番号);
            entity.setDairininJusho(DEFAULT_代理人住所);
            entity.setDairininShimei(DEFAULT_代理人氏名);
            entity.setDairininTelNo(DEFAULT_代理人電話番号);
            entity.setShobunCho(DEFAULT_処分庁);
            entity.setShobunYMD(DEFAULT_処分日);
            entity.setShobunShuruiCode(DEFAULT_処分種類コード);
            entity.setShobunKakuninYMD(DEFAULT_処分があったことを知った日);
            entity.setShinsaSeikyuRiyu(DEFAULT_審査請求の理由);
            entity.setShobunChoKyojiNaiyo(DEFAULT_処分庁教示の有無及び教示の内容);
            entity.setTempuShoruiTo(DEFAULT_添付書類等);
            entity.setShinsaSeikyuTorisageYMD(DEFAULT_審査請求取下日);
            entity.setBemmeishoTorokuFlag(DEFAULT_弁明書登録フラグ);
            entity.setBemmeishoSakuseiYMD(DEFAULT_弁明書作成日);
            entity.setSaiketsuYMD(DEFAULT_裁決日);
            entity.setSaiketsuKekka(DEFAULT_裁決結果);
            entity.setSaiketsuRiyu(DEFAULT_裁決理由);
            sut.save(entity);
        }
    }
}
