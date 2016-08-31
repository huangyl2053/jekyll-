/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanjikofutangakukeisankekkaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanjikofutangakukeisankekkaichiran.GassanJikofutangakuKeisanKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN62006_高額合算自己負担額計算結果一覧表Reportクラスです。
 *
 * @reamsid_L DBC-2060-040 surun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class GassanJikofutangakuKeisanKekkaIchiranReport extends
        Report<GassanJikofutangakuKeisanKekkaIchiranSource> {

    private final GassanJikofutangakuKeisanKekkaIchiranEntity 高額合算自己負担額計算結果一覧表;
    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final YMDHMS 作成日時;
    private final RString 出力順1;
    private final RString 出力順2;
    private final RString 出力順3;
    private final RString 出力順4;
    private final RString 出力順5;
    private final RString 改頁1;
    private final RString 改頁2;
    private final RString 改頁3;
    private final RString 改頁4;
    private final RString 改頁5;

    /**
     * コンストラクタです
     *
     * @param 高額合算自己負担額計算結果一覧表 GassanJikofutangakuKeisanKekkaIchiranEntity
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 作成日時 YMDHMS
     * @param 出力順1 RString
     * @param 出力順2 RString
     * @param 出力順3 RString
     * @param 出力順4 RString
     * @param 出力順5 RString
     * @param 改頁1 RString
     * @param 改頁2 RString
     * @param 改頁3 RString
     * @param 改頁4 RString
     * @param 改頁5 RString
     */
    public GassanJikofutangakuKeisanKekkaIchiranReport(GassanJikofutangakuKeisanKekkaIchiranEntity 高額合算自己負担額計算結果一覧表,
            LasdecCode 市町村コード, RString 市町村名称, YMDHMS 作成日時, RString 出力順1, RString 出力順2, RString 出力順3,
            RString 出力順4, RString 出力順5, RString 改頁1, RString 改頁2, RString 改頁3, RString 改頁4, RString 改頁5) {
        this.高額合算自己負担額計算結果一覧表 = 高額合算自己負担額計算結果一覧表;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.作成日時 = 作成日時;
        this.出力順1 = 出力順1;
        this.出力順2 = 出力順2;
        this.出力順3 = 出力順3;
        this.出力順4 = 出力順4;
        this.出力順5 = 出力順5;
        this.改頁1 = 改頁1;
        this.改頁2 = 改頁2;
        this.改頁3 = 改頁3;
        this.改頁4 = 改頁4;
        this.改頁5 = 改頁5;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJikofutangakuKeisanKekkaIchiranSource> writer) {
        IGassanJikofutangakuKeisanKekkaIchiranEditor editor = new GassanJikofutangakuKeisanKekkaIchiranEditor(高額合算自己負担額計算結果一覧表,
                市町村コード, 市町村名称, 作成日時, 出力順1, 出力順2, 出力順3, 出力順4, 出力順5, 改頁1, 改頁2, 改頁3, 改頁4, 改頁5);
        IGassanJikofutangakuKeisanKekkaIchiranBuilder builder = new GassanJikofutangakuKeisanKekkaIchiranBuilder(editor);
        writer.writeLine(builder);
    }

}
