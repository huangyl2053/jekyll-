/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo.KibetsuChoshyuYuyoKikan;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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

    private final RDate 発行日;
    private final RString 文書番号;
    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報;
    private final RString 通知書定型文;
    private final IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー;
    private final NinshoshaSource sourceBuilder;
    private final HyojiCodes 表示コード;
    private final List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間List;
    private final List<RString> 随時リスト;
    private final EditedAtesaki 編集後宛先;
    private final int index;

    /**
     * コンストラクタです
     *
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 通知書定型文 通知書定型文
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     * @param sourceBuilder sourceBuilder
     * @param 表示コード 表示コード
     * @param 期別徴収猶予期間List 期別徴収猶予期間List
     * @param 随時リスト 随時リスト
     * @param 編集後宛先 編集後宛先
     * @param index index
     */
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport(RDate 発行日, RString 文書番号,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー,
            NinshoshaSource sourceBuilder, HyojiCodes 表示コード, List<KibetsuChoshyuYuyoKikan> 期別徴収猶予期間List,
            List<RString> 随時リスト, EditedAtesaki 編集後宛先, int index) {
        this.発行日 = 発行日;
        this.文書番号 = 文書番号;
        this.徴収猶予決定通知書情報 = 徴収猶予決定通知書情報;
        this.通知書定型文 = 通知書定型文;
        this.介護問合せ先ソースビルダー = 介護問合せ先ソースビルダー;
        this.sourceBuilder = sourceBuilder;
        this.表示コード = 表示コード;
        this.期別徴収猶予期間List = 期別徴収猶予期間List;
        this.随時リスト = 随時リスト;
        this.編集後宛先 = 編集後宛先;
        this.index = index;
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource> writer) {

        ReiyaA4Editor reiyaA4Editor = new ReiyaA4Editor(文書番号, 徴収猶予決定通知書情報,
                表示コード, 通知書定型文, 期別徴収猶予期間List, 随時リスト, index);
        CompNinshoshaA4Editor compNinshoshaA4Editor = new CompNinshoshaA4Editor(sourceBuilder);
        CompKaigoToiawasesakiA4Editor compKaigoToiawasesakiA4Editor
                = new CompKaigoToiawasesakiA4Editor(介護問合せ先ソースビルダー);
        CompSofubutsuAtesakiA4Editor compSofubutsuAtesakiA4Editor = new CompSofubutsuAtesakiA4Editor(編集後宛先);
        IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider builder
                = new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider(
                        reiyaA4Editor, compNinshoshaA4Editor, compKaigoToiawasesakiA4Editor, compSofubutsuAtesakiA4Editor);
        writer.writeLine(builder);
    }

}
