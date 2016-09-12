/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoTateSource;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険料減免決定通知書 A4縦タイプReportクラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
public class GenmenKetteiTsuchiShoTateReport extends Report<KaigoHokenryoGenmenKetteiTsuchishoTateSource> {

    private final KoseiZengoKiwariGaku 更正前後期割額;
    private final RString 随時;
    private final RString 文書番号;
    private final GenmenKetteiTsuchiShoJoho 減免決定通知書情報;
    private final RString 通知書定型文;
    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;
    private final NinshoshaSource sourceBuilder;
    private final HyojiCodes 表示コード;
    private final KaigoSofubutsuAtesakiSource source;

    /**
     * コンストラクタです。
     *
     * @param 更正前後期割額 KoseiZengoKiwariGaku
     * @param 随時 RString
     * @param 文書番号 RString
     * @param 減免決定通知書情報 GenmenKetteiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param sourceBuilder NinshoshaSource
     * @param 表示コード HyojiCodes
     * @param source KaigoSofubutsuAtesakiSource
     */
    public GenmenKetteiTsuchiShoTateReport(KoseiZengoKiwariGaku 更正前後期割額, RString 随時, RString 文書番号,
            GenmenKetteiTsuchiShoJoho 減免決定通知書情報, RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー,
            NinshoshaSource sourceBuilder, HyojiCodes 表示コード, KaigoSofubutsuAtesakiSource source) {
        this.更正前後期割額 = 更正前後期割額;
        this.随時 = 随時;
        this.文書番号 = 文書番号;
        this.減免決定通知書情報 = 減免決定通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
        this.sourceBuilder = sourceBuilder;
        this.表示コード = 表示コード;
        this.source = source;
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryoGenmenKetteiTsuchishoTateSource> writer) {
        IGenmenKetteiTsuchiShoTateEditor editor = new GenmenKetteiTsuchiShoTateEditor(更正前後期割額, 随時, 文書番号, 減免決定通知書情報,
                通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, source);
        IGenmenKetteiTsuchiShoTateBuilder builder = new GenmenKetteiTsuchiShoTateBuilder(editor);
        writer.writeLine(builder);
    }

}
