/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD204010;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist.TargetArea;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist.TargetYearMonth;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd204010.TaishoKyufuJissekiTokuteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd204010.TokuchiJissekiKanriListSakuseiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBDBT00005_特別地域加算軽減実績管理リスト作成バッチパラメタークラスです．
 *
 * @reamsid_L DBD-3880-030 jinge TokuchiJissekiKanriListSakusei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter extends BatchParameterBase {

    private static final String TARGETYEARMONTH = "targetYearMonth";
    private static final String STARTDATE = "startDate";
    private static final String ENDDATE = "endDate";
    private static final String JIGYOSHANO = "jigyoshaNo";
    private static final String TARGETAREA = "targetArea";
    private static final String STARTAREACODE = "startAreaCode";
    private static final String ENDAREACODE = "endAreaCode";
    private static final String LASDECCODE = "lasdecCode";
    private static final String OUTPUTORDER = "outputOrder";
    private static final String REPORTID = "reportId";

    @BatchParameter(key = TARGETYEARMONTH, name = "対象年月")
    private TargetYearMonth 対象年月;
    @BatchParameter(key = STARTDATE, name = "年月範囲の開始")
    private FlexibleYearMonth 年月範囲の開始;
    @BatchParameter(key = ENDDATE, name = "年月範囲の終了")
    private FlexibleYearMonth 年月範囲の終了;
    @BatchParameter(key = JIGYOSHANO, name = "事業者番号")
    private RString 事業者番号;
    @BatchParameter(key = TARGETAREA, name = "地区コード種類")
    private TargetArea 地区コード種類;
    @BatchParameter(key = STARTAREACODE, name = "開始地区コード")
    private RString 開始地区コード;
    @BatchParameter(key = ENDAREACODE, name = "終了地区コード")
    private RString 終了地区コード;
    @BatchParameter(key = LASDECCODE, name = "市町村コード")
    private LasdecCode 市町村コード;
    @BatchParameter(key = OUTPUTORDER, name = "改頁出力順ID")
    private Long 改頁出力順ID;
    @BatchParameter(key = REPORTID, name = "帳票ID")
    private ReportId 帳票ID;

    /**
     * バーチのパラメータを作成します。
     *
     * @return TaishoKyufuJissekiTokuteiProcessParameter
     */
    public TaishoKyufuJissekiTokuteiProcessParameter toTaishoKyufuJissekiTokuteiProcessParameter() {
        return new TaishoKyufuJissekiTokuteiProcessParameter(対象年月, 年月範囲の開始, 年月範囲の終了, 事業者番号);
    }

    /**
     * バーチのパラメータを作成します。
     *
     * @return TokuchiJissekiKanriListSakuseiProcessParameter
     */
    public TokuchiJissekiKanriListSakuseiProcessParameter toTokuchiJissekiKanriListSakuseiProcessParameter() {
        return new TokuchiJissekiKanriListSakuseiProcessParameter(対象年月,
                年月範囲の開始, 年月範囲の終了, 事業者番号, 地区コード種類,
                開始地区コード, 終了地区コード, 市町村コード, 改頁出力順ID, 帳票ID);
    }
}
