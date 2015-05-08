/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.SeiDoitsuShogaiEditorBase;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4EditData;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.SeiDoitsuShogaiEditorBase}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class SeiDoitsuShogaiEditorBaseTest {

    private static IHihokenshashoCommonEditData target;
    private static SeiDoitsuShogaiEditorBase sut;
    private static HihokenshashoModel model;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡された場合_NullPointerExceptionが発生する() {
            sut = new SeiDoitsuShogaiEditorBase(null);
            fail();
        }
    }

    public static class set性同一障害考慮 extends DbzTestBase {

        private final RString seiShogaiTextUpper = new RString("3枚目の");
        private final RString seiShogaiTextLower = new RString("下段参照");
        private final RString kosekiGenderTextUpper = new RString("戸籍上の");
        private final RString kosekiGenderTextLower = new RString("性別：");

        @Before
        public void setUp() {
            target = createTarget();
        }

        @Test
        public void 性同一障害の考慮がなされる場合_SeiShogai1に_3枚目の_と設定される() {
            model = createMockModel(Gender.FEMALE, seiDoitsuKoryo.有り);
            sut = new SeiDoitsuShogaiEditorBase(model);
            sut.set性同一障害考慮(target);
            assertThat(target.getSeiShogai1(), is(seiShogaiTextUpper));
        }

        @Test
        public void 性同一障害の考慮がなされる場合_SeiShogai2に_下段参照_と設定される() {
            model = createMockModel(Gender.FEMALE, seiDoitsuKoryo.有り);
            sut = new SeiDoitsuShogaiEditorBase(model);
            sut.set性同一障害考慮(target);
            assertThat(target.getSeiShogai2(), is(seiShogaiTextLower));
        }

        @Test
        public void 性同一障害の考慮がなされる場合_KosekiSeibetsu1に_戸籍上の_と設定される() {
            model = createMockModel(Gender.FEMALE, seiDoitsuKoryo.有り);
            sut = new SeiDoitsuShogaiEditorBase(model);
            sut.set性同一障害考慮(target);
            assertThat(target.getKosekiSeibetsu1(), is(kosekiGenderTextUpper));
        }

        @Test
        public void 性同一障害の考慮がなされ_かつ性別が男である場合_KosekiSeibetsu2に性別が男であることが設定される() {
            model = createMockModel(Gender.MALE, seiDoitsuKoryo.有り);
            sut = new SeiDoitsuShogaiEditorBase(model);
            sut.set性同一障害考慮(target);
            assertThat(target.getKosekiSeibetsu2(), is(kosekiGenderTextLower.concat(Gender.MALE.getCommonName())));
        }

        @Test
        public void 性同一障害の考慮がなされ_かつ性別が女である場合_KosekiSeibetsu2に性別が女であることが設定される() {
            model = createMockModel(Gender.FEMALE, seiDoitsuKoryo.有り);
            sut = new SeiDoitsuShogaiEditorBase(model);
            sut.set性同一障害考慮(target);
            assertThat(target.getKosekiSeibetsu2(), is(kosekiGenderTextLower.concat(Gender.FEMALE.getCommonName())));
        }

        @Test
        public void 性同一障害の考慮がされない場合_SeiShogai1は何も設定されない() {
            model = createMockModel(Gender.FEMALE, seiDoitsuKoryo.無し);
            sut = new SeiDoitsuShogaiEditorBase(model);
            sut.set性同一障害考慮(target);
            assertThat(target.getSeiShogai1(), is(nullValue()));
        }

        @Test
        public void 性同一障害の考慮がされない場合_SeiShogai2は何も設定されない() {
            model = createMockModel(Gender.FEMALE, seiDoitsuKoryo.無し);
            sut = new SeiDoitsuShogaiEditorBase(model);
            sut.set性同一障害考慮(target);
            assertThat(target.getSeiShogai2(), is(nullValue()));
        }

        @Test
        public void 性同一障害の考慮がされない場合_KosekiSeibetsu1は何も設定されない() {
            model = createMockModel(Gender.FEMALE, seiDoitsuKoryo.無し);
            sut = new SeiDoitsuShogaiEditorBase(model);
            sut.set性同一障害考慮(target);
            assertThat(target.getKosekiSeibetsu1(), is(nullValue()));
        }

        @Test
        public void 性同一障害の考慮がされない場合_KosekiSeibetsu2は何も設定されない() {
            model = createMockModel(Gender.MALE, seiDoitsuKoryo.無し);
            sut = new SeiDoitsuShogaiEditorBase(model);
            sut.set性同一障害考慮(target);
            assertThat(target.getKosekiSeibetsu2(), is(nullValue()));
        }

        private HihokenshashoModel createMockModel(Gender gender, seiDoitsuKoryo 考慮) {
            IKojin kojin = mock(IKojin.class);
            when(kojin.get性別()).thenReturn(gender);
            HihokenshaShikakuHakkoModel shikakuhakko = mock(HihokenshaShikakuHakkoModel.class);
            when(shikakuhakko.is性同一障害用()).thenReturn(考慮.value);
            HihokenshashoModel hihokenshashoModel = mock(HihokenshashoModel.class);
            when(hihokenshashoModel.getKojinJoho()).thenReturn(kojin);
            when(hihokenshashoModel.getShikakuHakko()).thenReturn(shikakuhakko);
            return hihokenshashoModel;
        }
    }

    private enum seiDoitsuKoryo {

        有り(true),
        無し(false);
        private final boolean value;

        private seiDoitsuKoryo(boolean value) {
            this.value = value;
        }
    }

    private static IHihokenshashoCommonEditData createTarget() {
        HihokenshashoA4 a4 = new HihokenshashoA4();
        return new HihokenshashoA4EditData(a4);
    }

}
