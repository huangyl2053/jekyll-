/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFrom2009ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 自己負担証明書_2009年以降Editorです。
 *
 * @reamsid_L DBC-4810-040 kanghongsong
 */
public class JikoFutangakushomeishoFrom2009BodyEditor implements IJikoFutangakushomeishoFrom2009Editor {

    private final Decimal 自己負担額;
    private final Decimal 単70_74自己負担額;
    private final RString 摘要;

    /**
     * インスタンスを生成します。
     *
     * @param 自己負担額 Decimal
     * @param 単70_74自己負担額 Decimal
     * @param 摘要 RString
     */
    protected JikoFutangakushomeishoFrom2009BodyEditor(Decimal 自己負担額, Decimal 単70_74自己負担額, RString 摘要) {
        this.自己負担額 = 自己負担額;
        this.単70_74自己負担額 = 単70_74自己負担額;
        this.摘要 = 摘要;
    }

    @Override
    public JikoFutangakushomeishoFrom2009ReportSource edit(JikoFutangakushomeishoFrom2009ReportSource source) {
        source.listJikoFutanGakuIchiran_1 = toRString(自己負担額);
        source.listJikoFutanGakuIchiran_2 = toRString(単70_74自己負担額);
        source.listJikoFutanGakuIchiran_3 = 摘要;
        return source;
    }

    private RString toRString(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        }
        return new RString(Decimal.ZERO.toString());
    }
}
