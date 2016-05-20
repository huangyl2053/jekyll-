/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険料徴収猶予決定通知書帳票A4縦タイプReport
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport
        extends Report<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource> {

    private final RString 文書番号;
    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報;
    private final RString 通知書定型文;
    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;
    private final NinshoshaSource sourceBuilder;
    private final HyojiCodes 表示コード;
    private final int index;
    private final EditedAtesaki 編集後宛先;

    /**
     * コンストラクタです
     *
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 通知書定型文 通知書定型文
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     * @param sourceBuilder sourceBuilder
     * @param 表示コード 表示コード
     * @param index index
     * @param 編集後宛先 編集後宛先
     */
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport(RString 文書番号,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー,
            NinshoshaSource sourceBuilder, HyojiCodes 表示コード, int index, EditedAtesaki 編集後宛先) {
        this.文書番号 = 文書番号;
        this.徴収猶予決定通知書情報 = 徴収猶予決定通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
        this.sourceBuilder = sourceBuilder;
        this.表示コード = 表示コード;
        this.index = index;
        this.編集後宛先 = 編集後宛先;
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource> writer) {

        KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor editor
                = new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor(文書番号, 徴収猶予決定通知書情報,
                        通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, index, 編集後宛先);
        IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider builder
                = new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider(editor);
        writer.writeLine(builder);
    }

}
