
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuProcess;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranentity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchProcessTestHelper;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ycb
 */
public class KaigoHokenryogakuProcessTest extends DbbTestDacBase {

    private KaigoHokenryogakuProcess pro;
    private static final RString PARAMETER_EDITEDKAR = new RString("編集後本算定通知書共通情報");
    private static final RString PARAMETER_NONYUTSUCHPATAMETER = new RString("バッチパラメータ");
    private static final RString PARAMETER_PRINTTIMPSTAMP = new RString("帳票作成日時");
    private static final RString PARAMETER_TITLE = new RString("タイトル");

    @Before
    public void setUp() {
        pro = new KaigoHokenryogakuProcess();
    }

    @Test
    public void printTest() {

        RString タイトル = new RString("介護保険料額変更通知書発行一覧表");
        RString 帳票作成日時 = new RString("11110403");
        NonyuTsuchIchiranBatchParameter n = new NonyuTsuchIchiranBatchParameter();
        n.set出力期(new RString("1"));
        n.set調定年度(new RString("1990"));
        n.set賦課年度(new RString("1991"));
        List<NonyuTsuchIchiranentity> 出力帳票entity = new ArrayList<>();
        NonyuTsuchIchiranentity s1 = new NonyuTsuchIchiranentity();
        s1.set帳票ID(new ReportId("1"));
        s1.set帳票分類ID(new ReportId("11"));
        s1.set帳票名(new RString("111"));
        s1.set改頁出力順ID(new RString("改頁出力順1"));
        NonyuTsuchIchiranentity s2 = new NonyuTsuchIchiranentity();
        s2.set帳票ID(new ReportId("2"));
        s2.set帳票分類ID(new ReportId("22"));
        s2.set帳票名(new RString("222"));
        s2.set改頁出力順ID(new RString("改頁出力順2"));
        NonyuTsuchIchiranentity s3 = new NonyuTsuchIchiranentity();
        s3.set帳票ID(new ReportId("3"));
        s3.set帳票分類ID(new ReportId("33"));
        s3.set帳票名(new RString("333"));
        s3.set改頁出力順ID(new RString("改頁出力順3"));
        NonyuTsuchIchiranentity s4 = new NonyuTsuchIchiranentity();
        s4.set帳票ID(new ReportId("4"));
        s4.set帳票分類ID(new ReportId("44"));
        s4.set帳票名(new RString("444"));
        s4.set改頁出力順ID(new RString("改頁出力順4"));
        NonyuTsuchIchiranentity s5 = new NonyuTsuchIchiranentity();
        s5.set帳票ID(new ReportId("5"));
        s5.set帳票分類ID(new ReportId("55"));
        s5.set帳票名(new RString("555"));
        s5.set改頁出力順ID(new RString("改頁出力順5"));
        出力帳票entity.add(s1);
        出力帳票entity.add(s2);
        出力帳票entity.add(s3);
        出力帳票entity.add(s4);
        出力帳票entity.add(s5);
        n.set出力帳票entity(出力帳票entity);
        IAtesaki iA = mock(IAtesaki.class);
        ChohyoSeigyoKyotsu c = new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, new ReportId(""));
        IName iN = mock(IName.class);
        when(iN.getName()).thenReturn(new AtenaMeisho("宛先名称"));
        when(iA.get宛先名称()).thenReturn(iN);
        IName iN2 = mock(IName.class);
        when(iN2.getName()).thenReturn(new AtenaMeisho("宛先本人名称"));
        when(iA.get宛先本人名称()).thenReturn(iN2);
        IJusho j = mock(IJusho.class);
        when(j.get郵便番号()).thenReturn(new YubinNo("12331"));
        when(j.get住所()).thenReturn(new RString("住所"));
        when(iA.get宛先住所()).thenReturn(j);
        EditedAtesaki d = new EditedAtesaki(iA, c, null, RString.EMPTY);
        IKojin iK = mock(IKojin.class);
        when(iK.get世帯コード()).thenReturn(new SetaiCode("11"));
        EditedKojin ee = new EditedKojin(iK);
        List editelist = new ArrayList<>();
        for (int i = 0; i <= 40; i++) {
            EditedKariSanteiTsuchiShoKyotsu e = new EditedKariSanteiTsuchiShoKyotsu();
            e.set編集後宛先(d);
            e.set編集後個人(ee);
            HyojiCodes h1 = new HyojiCodes();
            h1.set表示コード１(new RString("表示コード１" + i));
            h1.set表示コード２(new RString("表示コード２" + i));
            h1.set表示コード３(new RString("表示コード３" + i));
            h1.set表示コード名１(new RString("表示コード名１" + i));
            h1.set表示コード名２(new RString("表示コード名２" + i));
            h1.set表示コード名３(new RString("表示コード名３" + i));
            e.set表示コード(h1);
            e.set通知書番号(new TsuchishoNo("通知書番号" + i));
            e.set被保険者番号(new HihokenshaNo("被保険者番号" + i));
            e.set更正前保険料段階(new RString("更正前保険料段階" + i));
            e.set更正前確定保険料(new RString("更正前確定保険料" + i));
            e.set更正前徴収方法(new RString("更正前徴収方法" + i));
            e.set更正後生保開始日(new RString("更正後生保開始日" + i));
            e.set更正後生活保護扶助種類(new RString("08"));
            e.set更正後保険料段階(new RString("更正後保険料段階" + i));
            e.set更正後確定保険料(new RString("更正後確定保険料" + i));
            e.set更正後徴収方法(new RString("更正後徴収方法" + i));
            editelist.add(e);
        }
        Map<RString, Object> sqlParameter = new HashMap<>();
        sqlParameter.put(PARAMETER_EDITEDKAR, editelist);
        sqlParameter.put(PARAMETER_NONYUTSUCHPATAMETER, n);
        sqlParameter.put(PARAMETER_PRINTTIMPSTAMP, 帳票作成日時);
        sqlParameter.put(PARAMETER_TITLE, タイトル);
        BatchProcessTestHelper.execute(KaigoHokenryogakuProcess.class, sqlParameter, sqlSession);

    }

}
