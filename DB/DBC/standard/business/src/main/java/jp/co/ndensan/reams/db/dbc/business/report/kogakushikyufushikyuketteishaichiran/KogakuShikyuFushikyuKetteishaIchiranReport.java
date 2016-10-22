/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiChohyoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufukettei.KogakuShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス費支給（不支給）決定者一覧表帳票Report
 *
 * @reamsid_L DBC-0980-500 surun
 */
public class KogakuShikyuFushikyuKetteishaIchiranReport extends Report<KogakuShikyuFushikyuKetteishaIchiranSource> {

    private final List<KogakuKyufuKetteiChohyoDataEntity> 帳票出力対象データリスト;
    private final List<RString> 住所List;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final RDateTime 作成日時;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データリスト List<KogakuKyufuKetteiChohyoDataEntity>
     * @param 住所List List<RString>
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 作成日時 RDateTime
     */
    public KogakuShikyuFushikyuKetteishaIchiranReport(List<KogakuKyufuKetteiChohyoDataEntity> 帳票出力対象データリスト,
            List<RString> 住所List, List<RString> 出力項目リスト, List<RString> 改頁項目リスト, RDateTime 作成日時) {
        this.帳票出力対象データリスト = 帳票出力対象データリスト;
        this.住所List = 住所List;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.作成日時 = 作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuShikyuFushikyuKetteishaIchiranSource> writer) {
        for (int i = 0; i < 帳票出力対象データリスト.size(); i++) {
            IKogakuShikyuFushikyuKetteishaIchiranEditor headerEditor
                    = new KogakuShikyuFushikyuKetteishaIchiranHeaderEditor(帳票出力対象データリスト.get(i),
                            出力項目リスト, 改頁項目リスト, 作成日時);
            IKogakuShikyuFushikyuKetteishaIchiranEditor bodyEditor
                    = new KogakuShikyuFushikyuKetteishaIchiranBodyEditor(帳票出力対象データリスト.get(i),
                            住所List.get(i));
            IKogakuShikyuFushikyuKetteishaIchiranBuilder builder
                    = new KogakuShikyuFushikyuKetteishaIchiranBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

}
