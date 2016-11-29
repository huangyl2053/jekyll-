/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanMeisai;
import jp.co.ndensan.reams.db.dbc.entity.report.jikofutangakushomeisho.JikoFutangakushomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 自己負担証明書のReportです。
 *
 * @reamsid_L DBC-4810-030 sunhaidi
 */
public class JikoFutangakushomeishoReport extends Report<JikoFutangakushomeishoReportSource> {

    private final JikoFutangakushomeishoData data;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param data 自己負担証明書
     *
     */
    public JikoFutangakushomeishoReport(JikoFutangakushomeishoData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JikoFutangakushomeishoReportSource> reportSourceWriter) {
        List<KogakuGassanMeisai> 明細List = data.get高額合算データ().get明細List();

        for (KogakuGassanMeisai kogakuGassanMeisai : 明細List) {
            JikoFutangakushomeishoBodyEditor bodyEditor = new JikoFutangakushomeishoBodyEditor(kogakuGassanMeisai.get自己負担額(),
                    kogakuGassanMeisai.get単70_74自己負担額_内数(),
                    kogakuGassanMeisai.get摘要());

            JikoFutangakushomeishoHeaderEditor headerEditor = new JikoFutangakushomeishoHeaderEditor(data);
            CompSofubutsuAtesakiEditor atesakiEditor = new CompSofubutsuAtesakiEditor(data.get宛先情報());
            CompNinshoshaEditor compNinshoshaEditor = new CompNinshoshaEditor(data.get認証者情報());
            IJikoFutangakushomeishoBuilder builder = new JikoFutangakushomeishoBuilder(headerEditor,
                    bodyEditor,
                    atesakiEditor,
                    compNinshoshaEditor
            );
            reportSourceWriter.writeLine(builder);
        }

        JikoFutangakushomeishoBodyEditor bodyEditor = new JikoFutangakushomeishoBodyEditor(data.get高額合算データ().get合計_自己負担額(),
                data.get高額合算データ().get合計_70_74自己負担額_内訳(),
                RString.EMPTY);
        JikoFutangakushomeishoHeaderEditor headerEditor = new JikoFutangakushomeishoHeaderEditor(data);
        CompSofubutsuAtesakiEditor atesakiEditor = new CompSofubutsuAtesakiEditor(data.get宛先情報());
        CompNinshoshaEditor compNinshoshaEditor = new CompNinshoshaEditor(data.get認証者情報());
        IJikoFutangakushomeishoBuilder builder = new JikoFutangakushomeishoBuilder(headerEditor,
                bodyEditor,
                atesakiEditor,
                compNinshoshaEditor
        );
        reportSourceWriter.writeLine(builder);
    }
}
