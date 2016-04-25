/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.honsanteikanendoidononyutsuchishohakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendoikkatsuhakko.HonSanteiIdoKanendoIkkatsuHakkoBatchParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ycb
 */
public class HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranPrintServiceTest extends DbbTestBase {

    public HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranPrintServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of print method, of class HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranPrintService.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報 = new ArrayList<>();
        YMDHMS 調定日時 = new YMDHMS(new RString("20160421160300"));
        HonSanteiIdoKanendoIkkatsuHakkoBatchParameter バッチパラメータ = new HonSanteiIdoKanendoIkkatsuHakkoBatchParameter();
        EditedHonSanteiTsuchiShoKyotsu 共通情報 = new EditedHonSanteiTsuchiShoKyotsu();
        HyojiCodes codes = new HyojiCodes();
        codes.set表示コード名１(new RString("表示コード名１"));
        codes.set表示コード名２(new RString("表示コード名２"));
        codes.set表示コード名３(new RString("表示コード名３"));
        codes.set表示コード１(new RString("表示コード１"));
        codes.set表示コード２(new RString("表示コード２"));
        codes.set表示コード３(new RString("表示コード３"));
        共通情報.set表示コード(codes);
        共通情報.set通知書番号(new TsuchishoNo("123456"));
        共通情報.set保険者番号(new HihokenshaNo("333333"));
        共通情報.set被保険者番号(new HihokenshaNo("111111"));
        共通情報.set編集後個人(null);
        共通情報.set編集後宛先(null);
        編集後本算定通知書共通情報.add(共通情報);
        HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranPrintService instance = new HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranPrintService();
        SourceDataCollection expResult = null;
        SourceDataCollection result = instance.print(編集後本算定通知書共通情報, バッチパラメータ, 調定日時);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
