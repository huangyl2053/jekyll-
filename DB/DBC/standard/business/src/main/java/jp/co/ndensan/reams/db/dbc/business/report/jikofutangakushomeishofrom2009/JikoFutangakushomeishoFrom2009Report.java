/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanMeisai;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFrom2009ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 自己負担証明書_2009年以降のReportです。
 *
 * @reamsid_L DBC-4810-040 kanghongsong
 */
public class JikoFutangakushomeishoFrom2009Report extends Report<JikoFutangakushomeishoFrom2009ReportSource> {

    private final JikoFutangakushomeishoFromData data;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param data 自己負担証明書
     *
     */
    public JikoFutangakushomeishoFrom2009Report(JikoFutangakushomeishoFromData data) {
        this.data = data;
    }

    @Override
    public void writeBy(ReportSourceWriter<JikoFutangakushomeishoFrom2009ReportSource> reportSourceWriter) {
        List<KogakuGassanMeisai> 明細List = data.get高額合算データ().get明細List();
        if (明細List != null) {
            for (KogakuGassanMeisai kogakuGassanMeisai : 明細List) {
                JikoFutangakushomeishoFrom2009BodyEditor bodyEditor = new JikoFutangakushomeishoFrom2009BodyEditor(kogakuGassanMeisai.get自己負担額(),
                        kogakuGassanMeisai.get単70_74自己負担額_内数(),
                        kogakuGassanMeisai.get摘要());

                JikoFutangakushomeishoFrom2009HeaderEditor headerEditor = new JikoFutangakushomeishoFrom2009HeaderEditor(data);
                CompSofubutsuAtesakiEditor atesakiEditor = new CompSofubutsuAtesakiEditor(data.get宛先情報());
                CompNinshoshaEditor compNinshoshaEditor = new CompNinshoshaEditor(data.get認証者情報());
                IJikoFutangakushomeishoFrom2009Builder builder = new JikoFutangakushomeishoFrom2009Builder(headerEditor,
                        bodyEditor,
                        atesakiEditor,
                        compNinshoshaEditor
                );
                reportSourceWriter.writeLine(builder);
            }
        }
        JikoFutangakushomeishoFrom2009BodyEditor bodyEditor = new JikoFutangakushomeishoFrom2009BodyEditor(data.get高額合算データ().get合計_自己負担額(),
                data.get高額合算データ().get合計_70_74自己負担額_内訳(),
                RString.EMPTY);
        JikoFutangakushomeishoFrom2009HeaderEditor headerEditor = new JikoFutangakushomeishoFrom2009HeaderEditor(data);
        CompSofubutsuAtesakiEditor atesakiEditor = new CompSofubutsuAtesakiEditor(data.get宛先情報());
        CompNinshoshaEditor compNinshoshaEditor = new CompNinshoshaEditor(data.get認証者情報());
        IJikoFutangakushomeishoFrom2009Builder builder = new JikoFutangakushomeishoFrom2009Builder(headerEditor,
                bodyEditor,
                atesakiEditor,
                compNinshoshaEditor
        );
        reportSourceWriter.writeLine(builder);
    }
}
