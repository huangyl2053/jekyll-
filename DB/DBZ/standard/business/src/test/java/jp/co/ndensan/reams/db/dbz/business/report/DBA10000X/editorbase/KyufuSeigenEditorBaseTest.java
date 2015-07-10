/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4EditData;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.IryoKikanAndJigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.KyotakuJigyoshaRirekiPrintType;
import jp.co.ndensan.reams.db.dbz.definition.util.Lists;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.KyufuSeigenEditorBase}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KyufuSeigenEditorBaseTest {

    private static KyufuSeigenEditorBase sut;
    private static IHihokenshashoCommonEditData target;
    private static HihokenshashoModel hihokenshasho;
    private static HihokenshashoPrintConfig printConfig;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 被保険者証Modelにnullが渡されたとき_NullPointerExceptionが発生する() {
            hihokenshasho = null;
            printConfig = mock(HihokenshashoPrintConfig.class);
            sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者証表示方法コンフィグが渡されたとき_NullPointerExceptionが発生する() {
            hihokenshasho = mock(HihokenshashoModel.class);
            printConfig = null;
            sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
        }
    }

    @RunWith(Enclosed.class)
    public static class set給付制限 extends DbzTestBase {

        private static List<RString> kyufuSeigenNames;
        private static List<RString> kyufuSeigenLongNames;
        private static List<FlexibleDate> kyufuSeigenStartDates;
        private static List<FlexibleDate> kyufuSeigenEndDates;

        private static final int KYUFU_SEIGEN_NAME_LENGTH = 8;
        private static final int KYUFU_SEIGEN_LONG_NAME_LENGTH = 12;

        @BeforeClass
        public static void setUpBeforeClass() {
            target = createTarget();
            kyufuSeigenNames = Lists.newArrayList(new RString("AA100001"), new RString("AA100002"), new RString("AA100003"));
            kyufuSeigenLongNames = Lists.newArrayList(new RString("AA1000010001"), new RString("AA1000020002"), new RString("AA1000030003"));
            kyufuSeigenStartDates = Lists.newArrayList(new FlexibleDate("20130101"), new FlexibleDate("20120101"), new FlexibleDate("20110101"));
            kyufuSeigenEndDates = Lists.newArrayList(new FlexibleDate("20131231"), new FlexibleDate("20121231"), new FlexibleDate("20111231"));

            printConfig = mock(HihokenshashoPrintConfig.class);
        }

        public static class 給付制限1に設定 extends DbzTestBase {

            @Before
            public void setUp() {
                target = createTarget();
            }

            @Test
            public void 給付制限名が8文字以下のとき_Seigen1に給付制限名0番目の文字列の_前半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenNames.get(0).substring(0, KYUFU_SEIGEN_NAME_LENGTH / 2);

                assertThat(target.getSeigen1(), is(answer));
            }

            @Test
            public void 給付制限名が8文字以下のとき_Seigen2に給付制限名0番目の文字列の_後ろ半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenNames.get(0).substring(KYUFU_SEIGEN_NAME_LENGTH / 2, KYUFU_SEIGEN_NAME_LENGTH);

                assertThat(target.getSeigen2(), is(answer));
            }

            @Test
            public void 給付制限名が8文字以下のとき_SeigenLong1には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigenLong1(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以下のとき_SeigenLong2には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigenLong2(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以上のとき_Seigen1には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigen1(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以下のとき_Seigen2には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigen2(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以上のとき_SeigenLong1に給付制限名0番目の文字列の_前半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenLongNames.get(0).substring(0, KYUFU_SEIGEN_LONG_NAME_LENGTH / 2);

                assertThat(target.getSeigenLong1(), is(answer));
            }

            @Test
            public void 給付制限名が8文字以上のとき_SeigenLong2に給付制限名0番目の文字列の_後ろ半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenLongNames.get(0).substring(KYUFU_SEIGEN_LONG_NAME_LENGTH / 2, KYUFU_SEIGEN_LONG_NAME_LENGTH);

                assertThat(target.getSeigenLong2(), is(answer));
            }

            @Test
            public void SeigenSt1に_給付制限開始日0番目が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = toWarekiString(kyufuSeigenStartDates.get(0));

                assertThat(target.getSeigenSt1(), is(answer));
            }

            @Test
            public void SeigenEd1に_給付制限終了日0番目が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = toWarekiString(kyufuSeigenEndDates.get(0));

                assertThat(target.getSeigenEd1(), is(answer));
            }
        }

        public static class 給付制限2に設定 extends DbzTestBase {

            @Before
            public void setUp() {
                target = createTarget();
            }

            @Test
            public void 給付制限名が8文字以下のとき_Seigen3に給付制限名1番目の文字列の_前半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenNames.get(1).substring(0, KYUFU_SEIGEN_NAME_LENGTH / 2);

                assertThat(target.getSeigen3(), is(answer));
            }

            @Test
            public void 給付制限名が8文字以下のとき_Seigen4に給付制限名1番目の文字列の_後ろ半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenNames.get(1).substring(KYUFU_SEIGEN_NAME_LENGTH / 2, KYUFU_SEIGEN_NAME_LENGTH);

                assertThat(target.getSeigen4(), is(answer));
            }

            @Test
            public void 給付制限名が8文字以下のとき_SeigenLong3には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigenLong3(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以下のとき_SeigenLong4には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigenLong4(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以上のとき_Seigen3には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigen3(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以下のとき_Seigen4には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigen4(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以上のとき_SeigenLong3に給付制限名1番目の文字列の_前半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenLongNames.get(1).substring(0, KYUFU_SEIGEN_LONG_NAME_LENGTH / 2);

                assertThat(target.getSeigenLong3(), is(answer));
            }

            @Test
            public void 給付制限名が8文字以上のとき_SeigenLong4に給付制限名1番目の文字列の_後ろ半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenLongNames.get(1).substring(KYUFU_SEIGEN_LONG_NAME_LENGTH / 2, KYUFU_SEIGEN_LONG_NAME_LENGTH);

                assertThat(target.getSeigenLong4(), is(answer));
            }

            @Test
            public void SeigenSt2に_給付制限開始日1番目が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = toWarekiString(kyufuSeigenStartDates.get(1));

                assertThat(target.getSeigenSt2(), is(answer));
            }

            @Test
            public void SeigenEd2に_給付制限終了日1番目が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = toWarekiString(kyufuSeigenEndDates.get(1));

                assertThat(target.getSeigenEd2(), is(answer));
            }

        }

        public static class 給付制限3に設定 extends DbzTestBase {

            @Before
            public void setUp() {
                target = createTarget();
            }

            @Test
            public void 給付制限名が8文字以下のとき_Seigen5に給付制限名2番目の文字列の_前半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenNames.get(2).substring(0, KYUFU_SEIGEN_NAME_LENGTH / 2);

                assertThat(target.getSeigen5(), is(answer));
            }

            @Test
            public void 給付制限名が8文字以下のとき_Seigen6に給付制限名2番目の文字列の_後ろ半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenNames.get(2).substring(KYUFU_SEIGEN_NAME_LENGTH / 2, KYUFU_SEIGEN_NAME_LENGTH);

                assertThat(target.getSeigen6(), is(answer));
            }

            @Test
            public void 給付制限名が8文字以下のとき_SeigenLong5には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigenLong5(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以下のとき_SeigenLong6には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigenLong6(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以上のとき_Seigen5には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigen5(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以下のとき_Seigen6には何も設定されない() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);

                assertThat(target.getSeigen6(), is(nullValue()));
            }

            @Test
            public void 給付制限名が8文字以上のとき_SeigenLong5に給付制限名2番目の文字列の_前半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenLongNames.get(2).substring(0, KYUFU_SEIGEN_LONG_NAME_LENGTH / 2);

                assertThat(target.getSeigenLong5(), is(answer));
            }

            @Test
            public void 給付制限名が8文字以上のとき_SeigenLong2に給付制限名2番目の文字列の_後ろ半分が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenLongNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = kyufuSeigenLongNames.get(2).substring(KYUFU_SEIGEN_LONG_NAME_LENGTH / 2, KYUFU_SEIGEN_LONG_NAME_LENGTH);

                assertThat(target.getSeigenLong6(), is(answer));
            }

            @Test
            public void SeigenSt3に_給付制限開始日2番目が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = toWarekiString(kyufuSeigenStartDates.get(2));

                assertThat(target.getSeigenSt3(), is(answer));
            }

            @Test
            public void SeigenEd3に_給付制限終了日2番目が設定される() {
                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = toWarekiString(kyufuSeigenEndDates.get(2));

                assertThat(target.getSeigenEd3(), is(answer));
            }

            @Test
            public void データが4件以上存在している場合でも_3件目以降は設定されない() {

                kyufuSeigenNames = Lists.newArrayList(new RString("AA100001"), new RString("AA100002"), new RString("AA100003"), new RString("AA100004"));
                kyufuSeigenLongNames = Lists.newArrayList(new RString("AA1000010001"), new RString("AA1000020002"), new RString("AA1000030003"), new RString("AA1000030004"));
                kyufuSeigenStartDates = Lists.newArrayList(new FlexibleDate("20130101"), new FlexibleDate("20120101"), new FlexibleDate("20110101"), new FlexibleDate("20100101"));
                kyufuSeigenEndDates = Lists.newArrayList(new FlexibleDate("20131231"), new FlexibleDate("20121231"), new FlexibleDate("20111231"), new FlexibleDate("20101231"));

                hihokenshasho = createMockModel(kyufuSeigenNames, kyufuSeigenStartDates, kyufuSeigenEndDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set給付制限(target);
                RString answer = toWarekiString(kyufuSeigenStartDates.get(3));

                assertThat(target.getSeigenSt3(), is(not(answer)));
            }

        }

        private static HihokenshashoModel createMockModel(List<RString> kyufuSeigenNames, List<FlexibleDate> kyufuSeigenStartDates, List<FlexibleDate> kyufuSeigenEndDates) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get給付制限内容()).thenReturn(kyufuSeigenNames);
            when(shikakuHakko.get給付制限開始日()).thenReturn(kyufuSeigenStartDates);
            when(shikakuHakko.get給付制限終了日()).thenReturn(kyufuSeigenEndDates);

            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }
    }

    @RunWith(Enclosed.class)
    public static class set居宅介護支援事業者 extends DbzTestBase {

        private static List<RString> kyotakuShienJigyoshaNames;
        private static List<RString> kyotakuShienJigyoshaLongNames;
        private static List<FlexibleDate> kyufuSeigenTodokedeDate;
        private static List<FlexibleDate> kyufuSeigenKaishiDate;

        private static final int KYOTAKU_JIGYOSHA_NAME_STANDARD = 40;

        @BeforeClass
        public static void setUpBeforeClass() {
            kyotakuShienJigyoshaNames = Lists.newArrayList(new RString("居宅支援1センター_012345678901234567890123456789"),
                    new RString("居宅支援2センター_012345678901234567890123456789"), new RString("居宅支援3センター_012345678901234567890123456789"));
            kyotakuShienJigyoshaLongNames = Lists.newArrayList(new RString("居宅支援1センター_0123456789012345678901234567891"),
                    new RString("居宅支援2センター_0123456789012345678901234567892"), new RString("居宅支援2センター_0123456789012345678901234567893"));
            kyufuSeigenTodokedeDate = Lists.newArrayList(new FlexibleDate("20130101"), new FlexibleDate("20120101"), new FlexibleDate("20110101"));
            kyufuSeigenKaishiDate = Lists.newArrayList(new FlexibleDate("20131231"), new FlexibleDate("20121231"), new FlexibleDate("20111231"));

            printConfig = mock(HihokenshashoPrintConfig.class);
        }

        @Before
        public void setUp() {
            target = createTarget();
            printConfig = mock(HihokenshashoPrintConfig.class);
        }

        public static class 居宅介護支援事業者1に設定 extends DbzTestBase {

            @Before
            public void setUp() {
                target = createTarget();
            }

            @Test
            public void 支援事業者名が40文字以下のとき_Gyosha1に支援事業者名0番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaNames.get(0);

                assertThat(target.getGyosha1(), is(answer));
            }

            @Test
            public void 支援事業者名が41文字以上のとき_ItakuGyosha1に支援事業者名0番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaLongNames.get(0);

                assertThat(target.getItakuGyosha1(), is(answer));
            }

            @Test
            public void is届出日の代わりに適用開始日を表示_がtrueのとき_TodokeYmd1に適用開始日0番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.適用開始日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = toWarekiString(kyufuSeigenKaishiDate.get(0));

                assertThat(target.getTodokeYmd1(), is(answer));
            }

            @Test
            public void is届出日の代わりに適用開始日を表示_がfalseのとき_TodokeYmd1に届出日0番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = toWarekiString(kyufuSeigenTodokedeDate.get(0));

                assertThat(target.getTodokeYmd1(), is(answer));
            }
        }

        public static class 居宅介護支援事業者2に設定 extends DbzTestBase {

            @Before
            public void setUp() {
                target = createTarget();
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法が表示のとき_Gyosha2に支援事業者名1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaNames.get(1);

                assertThat(target.getGyosha2(), is(answer));
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法がアスタリスクのとき_Gyosha2に支援事業者名1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.アスタリスク);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaNames.get(1);

                assertThat(target.getGyosha2(), is(answer));
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法がアスタリスクのとき_Gyosha2Asaに支援事業者名1番目の_2倍の文字数のアスタリスクが設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.アスタリスク);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaNames.get(1);

                assertThat(target.getGyosha2Asa().length(), is(answer.length() * 2));
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法が抹消線のとき_Gyosha2Masshoに支援事業者名1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.抹消線);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaNames.get(1);

                assertThat(target.getGyosha2Massho(), is(answer));
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法が非表示のとき_Gyosha2には何も設定されない() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.非表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);

                assertThat(target.getGyosha2(), is(nullValue()));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法が表示のとき_ItakuGyosha2に支援事業者名1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaLongNames.get(1);

                assertThat(target.getItakuGyosha2(), is(answer));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法がアスタリスクのとき_ItakuGyosha2に支援事業者名1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.アスタリスク);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaLongNames.get(1);

                assertThat(target.getItakuGyosha2(), is(answer));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法がアスタリスクのとき_ItakuGyosha2Asaに支援事業者名1番目の_2倍の文字数のアスタリスクが設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.アスタリスク);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaLongNames.get(1);

                assertThat(target.getItakuGyosha2Asa().length(), is(answer.length() * 2));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法が抹消線のとき_ItakuGyosha2Masshoに支援事業者名1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.抹消線);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaLongNames.get(1);

                assertThat(target.getItakuGyosha2Massho(), is(answer));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法が非表示のとき_ItakuGyosha2には何も設定されない() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.非表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);

                assertThat(target.getItakuGyosha2(), is(nullValue()));
            }

            @Test
            public void is届出日の代わりに適用開始日を表示_がtrueのとき_TodokeYmd2に適用開始日1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.適用開始日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = toWarekiString(kyufuSeigenKaishiDate.get(1));

                assertThat(target.getTodokeYmd2(), is(answer));
            }

            @Test
            public void is届出日の代わりに適用開始日を表示_がfalseのとき_TodokeYmd2に届出日1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = toWarekiString(kyufuSeigenTodokedeDate.get(1));

                assertThat(target.getTodokeYmd2(), is(answer));
            }
        }

        public static class 居宅介護支援事業者3に設定 extends DbzTestBase {

            @Before
            public void setUp() {
                target = createTarget();
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法が表示のとき_Gyosha3に支援事業者名2番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaNames.get(2);

                assertThat(target.getGyosha3(), is(answer));
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法がアスタリスクのとき_Gyosha3に支援事業者名2番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.アスタリスク);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaNames.get(2);

                assertThat(target.getGyosha3(), is(answer));
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法がアスタリスクのとき_Gyosha3Asaに支援事業者名2番目の_2倍の文字数のアスタリスクが設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.アスタリスク);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaNames.get(2);

                assertThat(target.getGyosha3Asa().length(), is(answer.length() * 2));
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法が抹消線のとき_Gyosha3Masshoに支援事業者名2番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.抹消線);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaNames.get(2);

                assertThat(target.getGyosha3Massho(), is(answer));
            }

            @Test
            public void 支援事業者名が40文字以下_かつget居宅支援事業者履歴表示方法が非表示のとき_Gyosha3には何も設定されない() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.非表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);

                assertThat(target.getGyosha3(), is(nullValue()));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法が表示のとき_ItakuGyosha3に支援事業者名2番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaLongNames.get(2);

                assertThat(target.getItakuGyosha3(), is(answer));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法がアスタリスクのとき_ItakuGyosha3に支援事業者名2番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.アスタリスク);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaLongNames.get(2);

                assertThat(target.getItakuGyosha3(), is(answer));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法がアスタリスクのとき_ItakuGyosha3Asaに支援事業者名2番目の_2倍の文字数のアスタリスクが設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.アスタリスク);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaLongNames.get(2);

                assertThat(target.getItakuGyosha3Asa().length(), is(answer.length() * 2));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法が抹消線のとき_ItakuGyosha3Masshoに支援事業者名2番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.抹消線);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = kyotakuShienJigyoshaLongNames.get(2);

                assertThat(target.getItakuGyosha3Massho(), is(answer));
            }

            @Test
            public void 支援事業者名が41文字以上_かつget居宅支援事業者履歴表示方法が非表示のとき_ItakuGyosha3には何も設定されない() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.非表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);

                assertThat(target.getItakuGyosha3(), is(nullValue()));
            }

            @Test
            public void is届出日の代わりに適用開始日を表示_がtrueのとき_TodokeYmd2に適用開始日1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.適用開始日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = toWarekiString(kyufuSeigenKaishiDate.get(1));

                assertThat(target.getTodokeYmd2(), is(answer));
            }

            @Test
            public void is届出日の代わりに適用開始日を表示_がfalseのとき_TodokeYmd2に届出日1番目が設定される() {
                hihokenshasho = createMockModel(kyotakuShienJigyoshaLongNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
                printConfig = createMockPrintConfig(DateOfOutputTarget.届出日, KyotakuJigyoshaRirekiPrintType.表示);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set居宅介護支援事業者(target);
                RString answer = toWarekiString(kyufuSeigenTodokedeDate.get(1));

                assertThat(target.getTodokeYmd2(), is(answer));
            }

        }

        @Test
        public void データが4件以上存在している場合でも_3件目以降は設定されない() {
            kyotakuShienJigyoshaNames = Lists.newArrayList(new RString("居宅支援1センター_012345678901234567890123456789"),
                    new RString("居宅支援2センター_012345678901234567890123456789"), new RString("居宅支援3センター_012345678901234567890123456789"),
                    new RString("居宅支援4センター_012345678901234567890123456789"));
            kyotakuShienJigyoshaLongNames = Lists.newArrayList(new RString("居宅支援1センター_0123456789012345678901234567891"),
                    new RString("居宅支援2センター_0123456789012345678901234567892"), new RString("居宅支援3センター_0123456789012345678901234567893"),
                    new RString("居宅支援4センター_0123456789012345678901234567894"));
            kyufuSeigenTodokedeDate = Lists.newArrayList(new FlexibleDate("20130101"), new FlexibleDate("20120101"), new FlexibleDate("20110101"), new FlexibleDate("20100101"));
            kyufuSeigenKaishiDate = Lists.newArrayList(new FlexibleDate("20131231"), new FlexibleDate("20121231"), new FlexibleDate("20111231"), new FlexibleDate("20101231"));

            hihokenshasho = createMockModel(kyotakuShienJigyoshaNames, kyufuSeigenTodokedeDate, kyufuSeigenKaishiDate);
            printConfig = createMockPrintConfig(DateOfOutputTarget.適用開始日, KyotakuJigyoshaRirekiPrintType.表示);
            sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
            sut.set居宅介護支援事業者(target);
            RString answer = kyotakuShienJigyoshaNames.get(4);

            assertThat(target.getGyosha3(), is(not(answer)));
        }

        private static HihokenshashoModel createMockModel(List<RString> kyotakuShienJigyoshaNames, List<FlexibleDate> kyufuSeigenTodokedeDate, List<FlexibleDate> kyufuSeigenKaishiDate) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get支援事業者名称()).thenReturn(kyotakuShienJigyoshaNames);
            when(shikakuHakko.get支援事業者届出日()).thenReturn(kyufuSeigenTodokedeDate);
            when(shikakuHakko.get支援事業者適用開始日()).thenReturn(kyufuSeigenKaishiDate);

            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);

            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }

        private static HihokenshashoPrintConfig createMockPrintConfig(DateOfOutputTarget outputTarget, KyotakuJigyoshaRirekiPrintType rirekiPrintType) {
            HihokenshashoPrintConfig printConfig = mock(HihokenshashoPrintConfig.class);
            when(printConfig.is届出日の代わりに適用開始日を表示()).thenReturn(outputTarget.value);
            when(printConfig.get居宅支援事業者履歴表示方法()).thenReturn(rirekiPrintType);
            return printConfig;
        }

        private enum DateOfOutputTarget {

            適用開始日(true),
            届出日(false);
            private final boolean value;

            private DateOfOutputTarget(boolean value) {
                this.value = value;
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class set介護保険施設等 extends DbzTestBase {

        private static List<RString> shisetsuCodes;
        private static List<RString> iryoShisetsuCodes;
        private static List<RString> shisetsuNames;
        private static List<FlexibleDate> nyushoDates;
        private static List<FlexibleDate> taishoDates;

        private static final RString DAUB_WORD = new RString("*");

        @BeforeClass
        public static void setUpBeforeClass() {

            shisetsuCodes = Lists.newArrayList(new RString("0070000001"), new RString("0070000002"));
            iryoShisetsuCodes = Lists.newArrayList(new RString("0030000001"), new RString("0030000002"));
            shisetsuNames = Lists.newArrayList(new RString("施設1"), new RString("施設2"));
            nyushoDates = Lists.newArrayList(new FlexibleDate("20130101"), new FlexibleDate("20120101"));
            taishoDates = Lists.newArrayList(new FlexibleDate("20131231"), new FlexibleDate("20121231"));

            printConfig = mock(HihokenshashoPrintConfig.class);
        }

        @Before
        public void setUp() {
            target = createTarget();
        }

        public static class 介護保険施設等1に設定 extends DbzTestBase {

            @Before
            public void setUp() {
                target = createTarget();
            }

            @Test
            public void ShisetsuSyu1に_施設コード0件目に対応する施設種類が設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);
                RString answer = IryoKikanAndJigyoshaKubun.toValue(shisetsuCodes.get(0)).getName();

                assertThat(target.getShisetsuSyu1(), is(answer));
            }

            @Test
            public void Shisetsuname1に_施設名称0件目が設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);
                RString answer = shisetsuNames.get(0);

                assertThat(target.getShisetsuname1(), is(answer));
            }

            @Test
            public void Nyushoymd1に_入所日0件目が設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);
                RString answer = toWarekiString(nyushoDates.get(0));

                assertThat(target.getNyushoymd1(), is(answer));
            }

            @Test
            public void Taishoymd1に_退所日0件目が設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);
                RString answer = toWarekiString(taishoDates.get(0));

                assertThat(target.getTaishoymd1(), is(answer));
            }

            @Test
            public void 施設コードに対応する施設種類が医療機関である場合_Nyushochk1にアスタリスクが設定される() {
                hihokenshasho = createMockModel(iryoShisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);

                assertThat(target.getNyushochk1(), is(DAUB_WORD));
            }

            @Test
            public void 施設コードに対応する施設種類が医療機関である場合_Taishochk1にアスタリスクが設定される() {
                hihokenshasho = createMockModel(iryoShisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);

                assertThat(target.getTaishochk1(), is(DAUB_WORD));
            }

            @Test
            public void 施設コードに対応する施設種類が医療機関以外である場合_Nyuinchk1にアスタリスクが設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);

                assertThat(target.getNyuinchk1(), is(DAUB_WORD));
            }

            @Test
            public void 施設コードに対応する施設種類が医療機関である場合_Taiinchk1にアスタリスクが設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);

                assertThat(target.getTaiinchk1(), is(DAUB_WORD));
            }
        }

        public static class 介護保険施設等2に設定 extends DbzTestBase {

            @Before
            public void setUp() {
                target = createTarget();
            }

            @Test
            public void ShisetsuSyu2に_施設コード1件目に対応する施設種類が設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);
                RString answer = IryoKikanAndJigyoshaKubun.toValue(shisetsuCodes.get(1)).getName();

                assertThat(target.getShisetsuSyu2(), is(answer));
            }

            @Test
            public void Shisetsuname2に_施設名称1件目が設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);
                RString answer = shisetsuNames.get(1);

                assertThat(target.getShisetsuname2(), is(answer));
            }

            @Test
            public void Nyushoymd2に_入所日1件目が設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);
                RString answer = toWarekiString(nyushoDates.get(1));

                assertThat(target.getNyushoymd2(), is(answer));
            }

            @Test
            public void Taishoymd2に_退所日1件目が設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);
                RString answer = toWarekiString(taishoDates.get(1));

                assertThat(target.getTaishoymd2(), is(answer));
            }

            @Test
            public void 施設コードに対応する施設種類が医療機関である場合_Nyushochk2にアスタリスクが設定される() {
                hihokenshasho = createMockModel(iryoShisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);

                assertThat(target.getNyushochk2(), is(DAUB_WORD));
            }

            @Test
            public void 施設コードに対応する施設種類が医療機関である場合_Taishochk2にアスタリスクが設定される() {
                hihokenshasho = createMockModel(iryoShisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);

                assertThat(target.getTaishochk2(), is(DAUB_WORD));
            }

            @Test
            public void 施設コードに対応する施設種類が医療機関以外である場合_Nyuinchk2にアスタリスクが設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);

                assertThat(target.getNyuinchk2(), is(DAUB_WORD));
            }

            @Test
            public void 施設コードに対応する施設種類が医療機関である場合_Taiinchk2にアスタリスクが設定される() {
                hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
                sut = new KyufuSeigenEditorBase(hihokenshasho, printConfig);
                sut.set介護保険施設等(target);

                assertThat(target.getTaiinchk2(), is(DAUB_WORD));
            }

        }

        @Test
        public void データが3件以上存在している場合でも_2件目以降は設定されない() {
            shisetsuCodes = Lists.newArrayList(new RString("0070000001"), new RString("0070000002"), new RString("0070000003"));
            shisetsuNames = Lists.newArrayList(new RString("施設1"), new RString("施設2"), new RString("施設3"));
            nyushoDates = Lists.newArrayList(new FlexibleDate("20130101"), new FlexibleDate("20120101"), new FlexibleDate("20110101"));
            taishoDates = Lists.newArrayList(new FlexibleDate("20131231"), new FlexibleDate("20121231"), new FlexibleDate("20111231"));

            hihokenshasho = createMockModel(shisetsuCodes, shisetsuNames, nyushoDates, taishoDates);
            sut = new KyufuSeigenEditorBase(hihokenshasho, null);
            sut.set介護保険施設等(target);
            RString answer = shisetsuNames.get(3);

            assertThat(target.getShisetsuname2(), is(not(answer)));
        }

        private static HihokenshashoModel createMockModel(List<RString> shisetsuCodes, List<RString> shisetsuNames,
                List<FlexibleDate> nyushoDates, List<FlexibleDate> taishoDates) {
            HihokenshaShikakuHakkoModel shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuHakko.get入所施設コード()).thenReturn(shisetsuCodes);
            when(shikakuHakko.get施設名()).thenReturn(shisetsuNames);
            when(shikakuHakko.get施設入所日()).thenReturn(nyushoDates);
            when(shikakuHakko.get施設退所日()).thenReturn(taishoDates);

            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);

            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuHakko);
            return hihokenshashoModel;
        }
    }

    private static IHihokenshashoCommonEditData createTarget() {
        HihokenshashoA4 a4 = new HihokenshashoA4();
        return new HihokenshashoA4EditData(a4);
    }

    private static RString toWarekiString(FlexibleDate date) {
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

}
