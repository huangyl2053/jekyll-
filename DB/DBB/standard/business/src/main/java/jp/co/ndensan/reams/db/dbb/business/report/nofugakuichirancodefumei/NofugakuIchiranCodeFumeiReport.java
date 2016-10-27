/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirancodefumei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirandaihyo.NofugakuIchiranSource;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.nofugakudatasakuseitandokushichoson.DbT2016NofugakuJohoTemp;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBRP91003-2_納付額一覧表（識別コード不明分） のReportクラスです。
 *
 * @reamsid_L DBB-1890-050 qinzhen
 */
public class NofugakuIchiranCodeFumeiReport extends Report<NofugakuIchiranSource> {

    private final RString 市町村名称;
    private final List<RString> 改頁項目リスト;
    private final RYear 対象年;
    private final DbT2016NofugakuJohoTemp 納付額情報;
    private final UaFt200FindShikibetsuTaishoEntity 宛名Entity;

    /**
     * コンストラクタです
     *
     * @param 市町村名称 RString
     * @param 改頁項目リスト List<RString>
     * @param 対象年 RYear
     * @param 納付額情報 DbT2016NofugakuJohoTemp
     * @param 宛名Entity UaFt200FindShikibetsuTaishoEntity
     */
    public NofugakuIchiranCodeFumeiReport(RString 市町村名称, List<RString> 改頁項目リスト,
            RYear 対象年, DbT2016NofugakuJohoTemp 納付額情報, UaFt200FindShikibetsuTaishoEntity 宛名Entity) {
        this.市町村名称 = 市町村名称;
        this.改頁項目リスト = 改頁項目リスト;
        this.対象年 = 対象年;
        this.納付額情報 = 納付額情報;
        this.宛名Entity = 宛名Entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<NofugakuIchiranSource> writer) {

        INofugakuIchiranCodeFumeiEditor editor = new NofugakuIchiranCodeFumeiEditor(市町村名称, 改頁項目リスト, 対象年, 納付額情報, 宛名Entity);

        INofugakuIchiranCodeFumeiBuilder builder = new NofugakuIchiranCodeFumeiBuilder(editor);

        writer.writeLine(builder);

    }
}
