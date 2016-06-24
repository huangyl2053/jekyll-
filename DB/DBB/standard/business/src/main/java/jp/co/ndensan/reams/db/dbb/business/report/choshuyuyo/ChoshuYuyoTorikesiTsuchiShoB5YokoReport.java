/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.choshuyuyo.KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険料徴収猶予取消通知書 B5横タイプreportするクラスです。
 *
 * @reamsid_L DBB-0740-070 chenaoqi
 */
public class ChoshuYuyoTorikesiTsuchiShoB5YokoReport extends Report<KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource> {

    private final RString 文書番号;
    private final ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報;
    private final RString 通知書定型文;
    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;
    private final NinshoshaSource sourceBuilder;
    private final HyojiCodes 表示コード;
    private final List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間リスト;
    private final List<RString> 期別納期リスト;
    private final List<RString> 随時リスト;
    private final EditedAtesaki 編集後宛先;
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_FOURTEEN = 14;

    /**
     * コンストラクタです。
     *
     * @param 文書番号 RString
     * @param 徴収猶予取消通知書情報 ChoshuYuyoTorikesiTsuchiShoJoho
     * @param 通知書定型文 RString
     * @param 介護問合せ先ソースビルダー IKaigoToiawasesakiSourceBuilder
     * @param sourceBuilder NinshoshaSource
     * @param 期別徴収猶予期間リスト List<KibetsuChoshyuYuyoKikan>
     * @param 表示コード HyojiCodes
     * @param 期別納期リスト List<RString>
     * @param 随時リスト List<RString>
     * @param 編集後宛先 EditedAtesaki
     */
    public ChoshuYuyoTorikesiTsuchiShoB5YokoReport(
            RString 文書番号,
            ChoshuYuyoTorikesiTsuchiShoJoho 徴収猶予取消通知書情報,
            RString 通知書定型文,
            IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー,
            NinshoshaSource sourceBuilder,
            HyojiCodes 表示コード,
            List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間リスト,
            List<RString> 期別納期リスト,
            List<RString> 随時リスト,
            EditedAtesaki 編集後宛先) {

        this.文書番号 = 文書番号;
        this.徴収猶予取消通知書情報 = 徴収猶予取消通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
        this.sourceBuilder = sourceBuilder;
        this.表示コード = 表示コード;
        this.期別徴収猶予期間リスト = 期別徴収猶予期間リスト;
        this.期別納期リスト = 期別納期リスト;
        this.随時リスト = 随時リスト;
        this.編集後宛先 = 編集後宛先;
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource> writer) {
        for (int i = INDEX_ZERO; i < INDEX_FOURTEEN; i++) {
            IChoshuYuyoTorikesiTsuchiShoB5YokoEditor editor = new ChoshuYuyoTorikesiTsuchiShoB5YokoEditor(
                    文書番号,
                    徴収猶予取消通知書情報,
                    通知書定型文,
                    介護問合せ先ソースビルダー,
                    sourceBuilder,
                    表示コード,
                    期別徴収猶予期間リスト,
                    期別納期リスト,
                    随時リスト,
                    編集後宛先, i);
            IChoshuYuyoTorikesiTsuchiShoB5YokoBuilder builder = new ChoshuYuyoTorikesiTsuchiShoB5YokoBuilder(editor);
            writer.writeLine(builder);
        }
    }
}
