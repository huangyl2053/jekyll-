/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200088_基準収入額適用申請書一覧表 Reportクラスです。
 *
 * @reamsid_L DBC-4640-060 lijian
 */
public class KijunShunyugakuTekiyoShinseishoHakkoIchiranReport extends Report<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> {

    private final KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 発行対象者;
    private final RString 保険者番号;
    private final RString 保険者名称;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;
    private final FlexibleYear 年度;

    /**
     * コンストラクタです。
     *
     * @param 発行対象者 KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity
     * @param 市町村番号 RString
     * @param 市町村名 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年度 FlexibleYear
     */
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranReport(
            KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 発行対象者,
            RString 市町村番号,
            RString 市町村名,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYear 処理年度) {
        this.発行対象者 = 発行対象者;
        this.保険者番号 = 市町村番号;
        this.保険者名称 = 市町村名;
        this.出力順リスト = 出力順リスト;
        this.改頁リスト = 改頁リスト;
        this.年度 = 処理年度;
    }

    @Override
    public void writeBy(ReportSourceWriter<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> writer) {
        writeLine(writer, 発行対象者, 保険者番号, 保険者名称, 出力順リスト, 改頁リスト, 年度);
    }

    private void writeLine(ReportSourceWriter<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> writer,
            KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 発行対象者,
            RString 保険者番号,
            RString 保険者名称,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYear 年度) {

        IKijunShunyugakuTekiyoShinseishoHakkoIchiranEditor editor
                = new KijunShunyugakuTekiyoShinseishoHakkoIchiranEditor(発行対象者, 保険者番号, 保険者名称, 出力順リスト, 改頁リスト, 年度);

        IKijunShunyugakuTekiyoShinseishoHakkoIchiranBuilder builder = new KijunShunyugakuTekiyoShinseishoHakkoIchiranBuilder(editor);
        writer.writeLine(builder);

    }

}
