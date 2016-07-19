/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.testhelper.DbTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IDbT2001ChoshuHohoMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class IDbT2001ChoshuHohoMapperTest extends DbxTestDacBase {

    private static DbT2001ChoshuHohoEntity entity;
    private static DbTestHelper dbTestHelper;
    private static DbT2001ChoshuHohoDac dac;
    private static IDbT2001ChoshuHohoMapper sut;

    @BeforeClass
    public static void setUpClass() {
        DbxTestDacBase.setUpClassInternal();
        dbTestHelper = new DbTestHelper();
    }

    public static class getEntityメソッドTest extends DbxTestDacBase {

        @Before
        public void setUp() {
            dbTestHelper.truncateTable(sqlSession, DbT2001ChoshuHohoEntity.TABLE_NAME);
            dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
            sut = sqlSession.getMapper(IDbT2001ChoshuHohoMapper.class);
            entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            dac.save(entity);
        }

        @Test
        public void 正しくinsertDantaiCdされている() {
            assertThat(sut.getEntity().getInsertDantaiCd(), is(entity.getInsertDantaiCd()));
        }

        @Test
        public void 正しくisDeletedされている() {
            assertThat(sut.getEntity().getIsDeleted(), is(entity.getIsDeleted()));
        }

        @Test
        public void 正しく賦課年度されている() {
            assertThat(sut.getEntity().getFukaNendo(), is(entity.getFukaNendo()));
        }

        @Test
        public void 正しく被保険者番号されている() {
            assertThat(sut.getEntity().getHihokenshaNo(), is(entity.getHihokenshaNo()));
        }

        @Test
        public void 正しく履歴番号されている() {
            assertThat(sut.getEntity().getRirekiNo(), is(entity.getRirekiNo()));
        }

        @Test
        public void 正しく徴収方法4月されている() {
            assertThat(sut.getEntity().getChoshuHoho4gatsu(), is(entity.getChoshuHoho4gatsu()));
        }

        @Test
        public void 正しく徴収方法5月されている() {
            assertThat(sut.getEntity().getChoshuHoho5gatsu(), is(entity.getChoshuHoho5gatsu()));
        }

        @Test
        public void 正しく徴収方法6月されている() {
            assertThat(sut.getEntity().getChoshuHoho6gatsu(), is(entity.getChoshuHoho6gatsu()));
        }

        @Test
        public void 正しく徴収方法7月されている() {
            assertThat(sut.getEntity().getChoshuHoho7gatsu(), is(entity.getChoshuHoho7gatsu()));
        }

        @Test
        public void 正しく徴収方法8月されている() {
            assertThat(sut.getEntity().getChoshuHoho8gatsu(), is(entity.getChoshuHoho8gatsu()));
        }

        @Test
        public void 正しく徴収方法9月されている() {
            assertThat(sut.getEntity().getChoshuHoho9gatsu(), is(entity.getChoshuHoho9gatsu()));
        }

        @Test
        public void 正しく徴収方法10月されている() {
            assertThat(sut.getEntity().getChoshuHoho10gatsu(), is(entity.getChoshuHoho10gatsu()));
        }

        @Test
        public void 正しく徴収方法11月されている() {
            assertThat(sut.getEntity().getChoshuHoho11gatsu(), is(entity.getChoshuHoho11gatsu()));
        }

        @Test
        public void 正しく徴収方法12月されている() {
            assertThat(sut.getEntity().getChoshuHoho12gatsu(), is(entity.getChoshuHoho12gatsu()));
        }

        @Test
        public void 正しく徴収方法1月されている() {
            assertThat(sut.getEntity().getChoshuHoho1gatsu(), is(entity.getChoshuHoho1gatsu()));
        }

        @Test
        public void 正しく徴収方法2月されている() {
            assertThat(sut.getEntity().getChoshuHoho2gatsu(), is(entity.getChoshuHoho2gatsu()));
        }

        @Test
        public void 正しく徴収方法3月されている() {
            assertThat(sut.getEntity().getChoshuHoho3gatsu(), is(entity.getChoshuHoho3gatsu()));
        }

        @Test
        public void 正しく徴収方法翌4月されている() {
            assertThat(sut.getEntity().getChoshuHohoYoku4gatsu(), is(entity.getChoshuHohoYoku4gatsu()));
        }

        @Test
        public void 正しく徴収方法翌5月されている() {
            assertThat(sut.getEntity().getChoshuHohoYoku5gatsu(), is(entity.getChoshuHohoYoku5gatsu()));
        }

        @Test
        public void 正しく徴収方法翌6月されている() {
            assertThat(sut.getEntity().getChoshuHohoYoku6gatsu(), is(entity.getChoshuHohoYoku6gatsu()));
        }

        @Test
        public void 正しく徴収方法翌7月されている() {
            assertThat(sut.getEntity().getChoshuHohoYoku7gatsu(), is(entity.getChoshuHohoYoku7gatsu()));
        }

        @Test
        public void 正しく徴収方法翌8月されている() {
            assertThat(sut.getEntity().getChoshuHohoYoku8gatsu(), is(entity.getChoshuHohoYoku8gatsu()));
        }

        @Test
        public void 正しく徴収方法翌9月されている() {
            assertThat(sut.getEntity().getChoshuHohoYoku9gatsu(), is(entity.getChoshuHohoYoku9gatsu()));
        }

        @Test
        public void 正しく仮徴収基礎年金番号されている() {
            assertThat(sut.getEntity().getKariNenkinNo(), is(entity.getKariNenkinNo()));
        }

        @Test
        public void 正しく仮徴収年金コードされている() {
            assertThat(sut.getEntity().getKariNenkinCode(), is(entity.getKariNenkinCode()));
        }

        @Test
        public void 正しく仮徴収捕捉月されている() {
            assertThat(sut.getEntity().getKariHosokuM(), is(entity.getKariHosokuM()));
        }

        @Test
        public void 正しく本徴収基礎年金番号されている() {
            assertThat(sut.getEntity().getHonNenkinNo(), is(entity.getHonNenkinNo()));
        }

        @Test
        public void 正しく本徴収年金コードされている() {
            assertThat(sut.getEntity().getHonNenkinCode(), is(entity.getHonNenkinCode()));
        }

        @Test
        public void 正しく本徴収捕捉月されている() {
            assertThat(sut.getEntity().getHonHosokuM(), is(entity.getHonHosokuM()));
        }

        @Test
        public void 正しく翌年度仮徴収基礎年金番号されている() {
            assertThat(sut.getEntity().getYokunendoKariNenkinNo(), is(entity.getYokunendoKariNenkinNo()));
        }

        @Test
        public void 正しく翌年度仮徴収年金コードされている() {
            assertThat(sut.getEntity().getYokunendoKariNenkinCode(), is(entity.getYokunendoKariNenkinCode()));
        }

        @Test
        public void 正しく翌年度仮徴収捕捉月されている() {
            assertThat(sut.getEntity().getYokunendoKariHosokuM(), is(entity.getYokunendoKariHosokuM()));
        }

        @Test
        public void 正しく依頼情報送付済みフラグされている() {
            assertThat(sut.getEntity().getIraiSohuzumiFlag(), is(entity.getIraiSohuzumiFlag()));
        }

        @Test
        public void 正しく追加依頼情報送付済みフラグされている() {
            assertThat(sut.getEntity().getTsuikaIraiSohuzumiFlag(), is(entity.getTsuikaIraiSohuzumiFlag()));
        }

        @Test
        public void 正しく特別徴収停止日時されている() {
            assertThat(sut.getEntity().getTokuchoTeishiNichiji(), is(entity.getTokuchoTeishiNichiji()));
        }

        @Test
        public void 正しく特別徴収停止事由コードされている() {
            assertThat(sut.getEntity().getTokuchoTeishiJiyuCode(), is(entity.getTokuchoTeishiJiyuCode()));
        }

    }

}
