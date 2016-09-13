/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehisofuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout.KogakuServicehiHanteiIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehisofuichiran.KogakuServicehiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200019_高額介護サービス費給付判定結果送付一覧表 のReportクラスです。
 *
 * @reamsid_L DBC-2610-040 qinzhen
 */
public class KogakuServicehiSofuIchiranReport extends Report<KogakuServicehiSofuIchiranSource> {

    private final List<RString> 並び順リスト;
    private final List<RString> 改頁リスト;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private final int 連番;
    private final KogakuServicehiHanteiIchiranhyoTaisyoEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuServicehiHanteiIchiranhyoTaisyoEntity
     * @param 並び順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     */
    public KogakuServicehiSofuIchiranReport(KogakuServicehiHanteiIchiranhyoTaisyoEntity entity, List<RString> 並び順リスト,
            List<RString> 改頁リスト, FlexibleYearMonth 処理年月, RDateTime 作成日時, int 連番) {
        this.entity = entity;
        this.並び順リスト = 並び順リスト;
        this.改頁リスト = 改頁リスト;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuServicehiSofuIchiranSource> writer) {

        IKogakuServicehiSofuIchiranEditor editor = new KogakuServicehiSofuIchiranEditor(entity, 並び順リスト, 改頁リスト, 処理年月, 作成日時, 連番);

        IKogakuServicehiSofuIchiranBuilder builder = new KogakuServicehiSofuIchiranBuilder(editor);

        writer.writeLine(builder);

    }
}
