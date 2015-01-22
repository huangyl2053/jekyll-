/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.report;

import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoSofusakiInfoConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoPrintPosition;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaDaichoFinder;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.IAtesaki;
import jp.co.ndensan.reams.ur.urz.business.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.IZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.realservice.IZenkokuJushoManager;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IAtesakiFinder;
import jp.co.ndensan.reams.ur.urz.realservice.shikibetsutaisho.IKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReamsDonyuDantaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * {@link jp.co.ndensan.reams.db.dba.realservice.report.HihokenshashoPrinter}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoPrinterBaseTest {

    private static HihokenshashoPrinterBase sut;

    public static class getKojin extends DbzTestBase {

        private HihokenshaNo hihokenshaNo;
        private HihokenshaShikakuHakkoModel shikakuHakkoModel;
        private HihokenshashoPrintPosition position;

        @Before
        public void setUp() {
            hihokenshaNo = HihokenshaNo.EMPTY;
            shikakuHakkoModel = mock(HihokenshaShikakuHakkoModel.class);
            position = HihokenshashoPrintPosition.下部;
        }

        @Test
        public void 引数の被保険者台帳Modelが持つ識別コードと_同一の識別コードを持つ個人情報を取得できる() {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode("000010000101234");

            sut = new HihokenshashoPrinterBase(
                    null,
                    createKojinFinder(shikibetsuCode),
                    null, null, null, null
            );

            HihokenshaDaichoModel daicho = mock(HihokenshaDaichoModel.class);
            when(daicho.get識別コード()).thenReturn(shikibetsuCode);

            assertThat(sut.getKojin(daicho).get識別コード(), is(shikibetsuCode));
        }

        private IKojinFinder createKojinFinder(ShikibetsuCode shikibetsuCode) {
            IKojin kojin = mock(IKojin.class);
            when(kojin.get識別コード()).thenReturn(shikibetsuCode);
            IKojinFinder kojinFinder = mock(IKojinFinder.class);
            when(kojinFinder.get個人(GyomuCode.DB介護保険, shikibetsuCode)).thenReturn(kojin);
            return kojinFinder;
        }

    }

    public static class getDaichoModel extends DbzTestBase {

        RString dantaiCode = new RString("123456");
        HihokenshaNo hihoNo = new HihokenshaNo("01233456789");

        @Test
        public void 指定した被保険者番号と_戻り値の被保険者台帳が持つ被保険者番号は_同一になる() {

            sut = new HihokenshashoPrinterBase(
                    null, null,
                    createControlData(dantaiCode),
                    null, null,
                    createHihoDaichoFinder(dantaiCode, hihoNo)
            );

            assertThat(sut.getDaichoModel(hihoNo).get被保険者番号(), is(hihoNo));
        }

        private IUrControlData createControlData(RString dantaiCode) {
            IUrControlData controlData = mock(IUrControlData.class);
            when(controlData.getDonyuDantaiCode()).thenReturn(new ReamsDonyuDantaiCode(dantaiCode));
            return controlData;
        }

        private HihokenshaDaichoFinder createHihoDaichoFinder(RString dantaiCode, HihokenshaNo hihoNo) {
            HihokenshaDaichoModel daicho = mock(HihokenshaDaichoModel.class);
            when(daicho.get被保険者番号()).thenReturn(hihoNo);
            HihokenshaDaichoFinder hihoDaichoFinder = mock(HihokenshaDaichoFinder.class);
            when(hihoDaichoFinder.find直近被保険者台帳(hihoNo)).thenReturn(Optional.of(daicho));
            return hihoDaichoFinder;
        }

    }

    public static class getTsuchishoAtesaki extends DbzTestBase {

        //TODO n8178 城間篤人 TODO解消後にテストを作成する。
        @Test
        public void dummy() {

            sut = new HihokenshashoPrinterBase(
                    createSofusakiInfoConfig(),
                    null, null,
                    createAtesakiFinder(),
                    null, null
            );
        }

        private HihokenshashoSofusakiInfoConfig createSofusakiInfoConfig() {
            HihokenshashoSofusakiInfoConfig config = mock(HihokenshashoSofusakiInfoConfig.class);
            when(config.is世帯主表示有り()).thenReturn(false);
            when(config.is敬称表示有り()).thenReturn(false);
            return config;
        }

        private IAtesakiFinder createAtesakiFinder() {
            IAtesaki atesaki = mock(IAtesaki.class);
            IAtesakiFinder atesakiFinder = mock(IAtesakiFinder.class);
            when(atesakiFinder.get宛先(any(IAtesakiPSMSearchKey.class))).thenReturn(atesaki);
            return atesakiFinder;
        }

    }

    public static class getZenkokuJusho extends DbzTestBase {

        //TODO n8178 城間篤人 TODO解消後にテストを作成する。
        @Test
        public void dummy() {

            sut = new HihokenshashoPrinterBase(
                    null, null, null, null,
                    createZenkokuJushoManager(),
                    null
            );
        }

        private IZenkokuJushoManager createZenkokuJushoManager() {
            IZenkokuJushoItem zenkokuJusho = mock(IZenkokuJushoItem.class);
            IZenkokuJushoManager zenkokuJushoManager = mock(IZenkokuJushoManager.class);
            when(zenkokuJushoManager.get全国住所By全国住所コード(any(ZenkokuJushoCode.class))).thenReturn(zenkokuJusho);
            return zenkokuJushoManager;
        }
    }

}
