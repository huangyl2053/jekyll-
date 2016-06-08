/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan;

import jp.co.ndensan.reams.db.dbx.testhelper.helper.CSVDataUtilForUseSession;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7069KaigoToiawasesakiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7069KaigoToiawasesakiDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link KaigoTextHenkanRuleCreator}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoTextHenkanRuleCreatorTest extends DbzTestDacBase {

    private static DbT7069KaigoToiawasesakiDac dac;
    private static final SubGyomuCode DBAサブ業務コード = SubGyomuCode.DBA介護資格;
    private static final ReportId ダミー帳票分類ID = new ReportId(new RString("000000001"));
    private static ITextHenkanRule sut;

    @BeforeClass
    public static void test() {
        dac = InstanceProvider.create(DbT7069KaigoToiawasesakiDac.class);
    }

    public static class createRuleテスト extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.deleteData();
            TestSupport.insert(
                    DBAサブ業務コード,
                    ダミー帳票分類ID);
            sut = KaigoTextHenkanRuleCreator.createRule(DBAサブ業務コード, ダミー帳票分類ID);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のサブ業務コードにnullを指定した場合_NullPointerExceptionが発生する() {
            KaigoTextHenkanRuleCreator.createRule(null, ReportId.EMPTY);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の帳票IDにnullを指定した場合_NullPointerExceptionが発生する() {
            KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBZ介護共通, null);
        }

        @Test
        public void 変換タグ_郵便番号_の確認() {
            RString test = new RString("<郵便番号>");
            assertThat(sut.editText(test), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_郵便番号.value()));
        }

        @Test
        public void 変換タグ_所在地_の確認() {
            RString test = new RString("<所在地>");
            assertThat(sut.editText(test), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_所在地));
        }

        @Test
        public void 変換タグ_庁舎名_の確認() {
            RString test = new RString("<庁舎名>");
            assertThat(sut.editText(test), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_庁舎名));
        }

        @Test
        public void 変換タグ_電話番号_の確認() {
            RString test = new RString("<電話番号>");
            assertThat(sut.editText(test), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_電話番号.value()));
        }

        @Test
        public void 変換タグ_内線番号_の確認() {
            RString test = new RString("<内線番号>");
            assertThat(sut.editText(test), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_内線番号));
        }

        @Test
        public void 変換タグ_部署名_の確認() {
            RString test = new RString("<部署名>");
            assertThat(sut.editText(test), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_部署名));
        }

        @Test
        public void 変換タグ_担当者名_の確認() {
            RString test = new RString("<担当者名>");
            assertThat(sut.editText(test), is(DbT7069KaigoToiawasesakiEntityGenerator.DEFAULT_担当者名));
        }

        @Test
        public void 変換タグ_当年度_の確認() {
            RString test = new RString("<当年度>");
            RString expect = RDate.getNowDate().getNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
            assertThat(sut.editText(test), is(expect));
        }

        @Test
        public void 変換タグ_翌年度_の確認() {
            RString test = new RString("<翌年度>");
            RString expect = RDate.getNowDate().getNendo().plusYear(1).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
            assertThat(sut.editText(test), is(expect));
        }
    }

    private static class TestSupport {

        public static void insert(
                SubGyomuCode サブ業務コード,
                ReportId 帳票分類ID) {
            DbT7069KaigoToiawasesakiEntity entity = DbT7069KaigoToiawasesakiEntityGenerator.createDbT7069KaigoToiawasesakiEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setChohyoBunruiID(帳票分類ID);
            dac.save(entity);
        }

        public static void deleteData() {
            CSVDataUtilForUseSession utilForUseSession = new CSVDataUtilForUseSession();
            utilForUseSession.clearTable(sqlSession, DbT7069KaigoToiawasesakiEntity.TABLE_NAME.toString());
        }
    }
}
