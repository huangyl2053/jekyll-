/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyukettei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuKetteiChohyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanbaraishikyuketteishaichiran.ShokanbaraiShikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払支給決定者一覧表帳票Report
 *
 * @reamsid_L DBC-0980-480 sunhui
 */
public class ShokanbaraiShikyuKetteishaIchiranReport extends Report<ShokanbaraiShikyuKetteishaIchiranSource> {

    private final List<ShokanShikyuKetteiChohyoEntity> 帳票出力対象データリスト;
    private final List<RString> 住所List;
    private final Map<RString, RString> 出力順Map;
    private final List<RString> 改頁リスト;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データリスト List<ShokanShikyuKetteiChohyoEntity>
     * @param 住所List List<RString>
     * @param 出力順Map Map<RString, RString>
     * @param 改頁リスト List<RString>
     * @param 作成日時 RDateTime
     *
     */
    public ShokanbaraiShikyuKetteishaIchiranReport(List<ShokanShikyuKetteiChohyoEntity> 帳票出力対象データリスト,
            List<RString> 住所List, Map<RString, RString> 出力順Map, List<RString> 改頁リスト, RDateTime 作成日時) {
        this.帳票出力対象データリスト = 帳票出力対象データリスト;
        this.住所List = 住所List;
        this.出力順Map = 出力順Map;
        this.改頁リスト = 改頁リスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShokanbaraiShikyuKetteishaIchiranSource> writer) {
        if (null == 帳票出力対象データリスト || 帳票出力対象データリスト.isEmpty()) {
            return;
        }
        for (int i = 0; i < 帳票出力対象データリスト.size(); i++) {
            IShokanbaraiShikyuKetteishaIchiranEditor headerEditor
                    = new ShokanbaraiShikyuKetteishaIchiranHeaderEditor(帳票出力対象データリスト.get(i),
                            出力順Map, 改頁リスト, 作成日時);
            IShokanbaraiShikyuKetteishaIchiranEditor bodyEditor
                    = new ShokanbaraiShikyuKetteishaIchiranBodyEditor(帳票出力対象データリスト.get(i),
                            住所List.get(i));
            IShokanbaraiShikyuKetteishaIchiranBuilder builder
                    = new ShokanbaraiShikyuKetteishaIchiranBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
