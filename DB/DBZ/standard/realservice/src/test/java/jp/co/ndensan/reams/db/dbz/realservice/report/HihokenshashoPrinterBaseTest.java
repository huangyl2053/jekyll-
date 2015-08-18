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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaDaichoFinder;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.atesaki.IAtesakiFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.kojin.IKojinFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
                    null, null
            );

            DbT1001HihokenshaDaichoEntity daicho = mock(DbT1001HihokenshaDaichoEntity.class);
            when(daicho.getShikibetsuCode()).thenReturn(shikibetsuCode);

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
                    null, null, null,
                    createHihoDaichoFinder(dantaiCode, hihoNo)
            );

            assertThat(sut.getDaichoModel(hihoNo).getHihokenshaNo(), is(hihoNo));
        }

        private HihokenshaDaichoFinder createHihoDaichoFinder(RString dantaiCode, HihokenshaNo hihoNo) {
            DbT1001HihokenshaDaichoEntity daicho = mock(DbT1001HihokenshaDaichoEntity.class);
            when(daicho.getHihokenshaNo()).thenReturn(hihoNo);
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
                    null,
                    createAtesakiFinder(),
                    null
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

}
