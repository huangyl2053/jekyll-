/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.NushiJuminJohoResult;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.SetaiInn;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyo.ShotokuShokaihyoTateSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBPR51002_所得照会票のクラスです。
 *
 * @reamsid_L DBB-1710-030 xuhao
 */
public class ShotokuShokaihyoTateReport extends Report<ShotokuShokaihyoTateSource> {

    private final NushiJuminJohoResult 所得照会票;
    private final NinshoshaSource sourceBuilder;
    private final RString 文書タイトル;
    private final RString 送付先担当課名称;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param 所得照会票 NushiJuminJohoResult
     * @param sourceBuilder NinshoshaSource
     * @param 文書タイトル RString
     * @param 送付先担当課名称 RString
     */
    public ShotokuShokaihyoTateReport(NushiJuminJohoResult 所得照会票,
            NinshoshaSource sourceBuilder,
            RString 文書タイトル,
            RString 送付先担当課名称) {
        this.所得照会票 = 所得照会票;
        this.sourceBuilder = sourceBuilder;
        this.文書タイトル = 文書タイトル;
        this.送付先担当課名称 = 送付先担当課名称;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShotokuShokaihyoTateSource> reportSourceWriter) {
        List<List<SetaiInn>> 世帯員リスト = createList(所得照会票.get世帯員リスト(), INT_4);
        for (int i = INT_0; i < 世帯員リスト.size(); i++) {
            所得照会票.set世帯員リスト(世帯員リスト.get(i));
            IShotokuShokaihyoTateEditor editor = new ShotokuShokaihyoTateEditor(所得照会票, sourceBuilder,
                    文書タイトル, 送付先担当課名称);
            IShotokuShokaihyoTateBuilder builder = new ShotokuShokaihyoTateBuilder(editor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private static List<List<SetaiInn>> createList(List<SetaiInn> targe, int size) {
        List<List<SetaiInn>> listArr = new ArrayList<>();
        int arrSize = targe.size() % size == INT_0 ? targe.size() / size : targe.size() / size + INT_1;
        for (int i = INT_0; i < arrSize; i++) {
            List<SetaiInn> sub = new ArrayList<>();
            for (int j = i * size; j <= size * (i + INT_1) - INT_1; j++) {
                if (j <= targe.size() - INT_1) {
                    sub.add(targe.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }

}
