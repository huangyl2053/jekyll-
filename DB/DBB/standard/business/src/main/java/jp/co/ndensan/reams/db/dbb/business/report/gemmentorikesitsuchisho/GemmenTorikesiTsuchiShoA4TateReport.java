/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmentorikesitsuchisho.KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険料減免取消通知書 A4縦タイプReportするクラスです。
 *
 * @reamsid_L DBB-0740-060 chenaoqi
 */
public class GemmenTorikesiTsuchiShoA4TateReport extends Report<KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource> {

    private final RString 文書番号;
    private final GemmenTorikesiTsuchiShoJoho 減免取消通知書情報;
    private final RString 通知書定型文;
    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;
    private final NinshoshaSource sourceBuilder;
    private final HyojiCodes 表示コード;
    private final List<KoseiZengoKiwariGaku> 更正前後期割額リスト;
    private final List<RString> 随時リスト;
    private final EditedAtesaki 編集後宛先;
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_FOURTEEN = 14;

    /**
     * コンストラクタです。
     *
     * @param 文書番号 RString
     * @param 減免取消通知書情報 GemmenTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param sourceBuilder NinshoshaSource
     * @param 表示コード HyojiCodes
     * @param 更正前後期割額リスト List<KoseiZengoKiwariGaku>
     * @param 随時リスト List<RString>
     * @param 編集後宛先 EditedAtesaki
     */
    public GemmenTorikesiTsuchiShoA4TateReport(
            RString 文書番号,
            GemmenTorikesiTsuchiShoJoho 減免取消通知書情報,
            RString 通知書定型文,
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー,
            NinshoshaSource sourceBuilder,
            HyojiCodes 表示コード,
            List<KoseiZengoKiwariGaku> 更正前後期割額リスト,
            List<RString> 随時リスト,
            EditedAtesaki 編集後宛先) {

        this.文書番号 = 文書番号;
        this.減免取消通知書情報 = 減免取消通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
        this.sourceBuilder = sourceBuilder;
        this.表示コード = 表示コード;
        this.更正前後期割額リスト = 更正前後期割額リスト;
        this.随時リスト = 随時リスト;
        this.編集後宛先 = 編集後宛先;
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource> writer) {
        for (int i = INDEX_ZERO; i < INDEX_FOURTEEN; i++) {
            IGemmenTorikesiTsuchiShoA4TateEditor editor = new GemmenTorikesiTsuchiShoA4TateEditor(
                    文書番号,
                    減免取消通知書情報,
                    通知書定型文,
                    介護問合せ先ソースビルダー,
                    sourceBuilder,
                    表示コード,
                    更正前後期割額リスト,
                    随時リスト,
                    編集後宛先, i);
            IGemmenTorikesiTsuchiShoA4TateBuilder builder = new GemmenTorikesiTsuchiShoA4TateBuilder(editor);
            writer.writeLine(builder);
        }
    }

}
