/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.KogakuGassanJikofutangaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.GassanJikofutangakuShomeishoTorikomiIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoDateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200034_高額合算自己負担額証明書情報取込一覧表 Report
 *
 * @reamsid_L DBC-2640-030 zhengshenlei
 */
public class KogakuGassanJikofutangakuShomeiReport extends Report<GassanJikofutangakuShomeishoTorikomiIchiranSource> {

    private final KogakuGassanJikofutangakuShomeishoDateEntity entity;
    private final FlexibleYearMonth 処理年月;
    private final List<RString> 改頁項目List;
    private final List<RString> 出力順リスト;
    private final RDateTime システム日時;
    private final int 連番;
    private final RString 保険者番号;
    private final RString 保険者名称;

    /**
     * インスタンスを生成します。
     *
     * @param 処理年月 FlexibleYearMonth
     * @param entity ChohyoShutsuryokuTaishoDateEntity
     * @param 改頁項目List List<RString>
     * @param 出力順リスト List<RString>
     * @param システム日時 RDateTime
     * @param 連番 int
     * @param 保険者番号 RString
     * @param 保険者名称 RString
     */
    public KogakuGassanJikofutangakuShomeiReport(
            FlexibleYearMonth 処理年月,
            KogakuGassanJikofutangakuShomeishoDateEntity entity,
            List<RString> 改頁項目List,
            List<RString> 出力順リスト,
            RDateTime システム日時,
            int 連番,
            RString 保険者番号,
            RString 保険者名称) {
        this.処理年月 = 処理年月;
        this.entity = entity;
        this.改頁項目List = 改頁項目List;
        this.出力順リスト = 出力順リスト;
        this.システム日時 = システム日時;
        this.連番 = 連番;
        this.保険者番号 = 保険者番号;
        this.保険者名称 = 保険者名称;
    }

    @Override
    public void writeBy(ReportSourceWriter<GassanJikofutangakuShomeishoTorikomiIchiranSource> reportSourceWriter) {
        IKogakuGassanJikofutangakuShomeiEditor editor
                = new KogakuGassanJikofutangakuShomeiEditor(処理年月, entity, 改頁項目List, 出力順リスト, システム日時, 連番, 保険者番号, 保険者名称);
        IKogakuGassanJikofutangakuShomeiBuilder builder
                = new KogakuGassanJikofutangakuShomeiBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
