/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.serviceRiyohyoBeppyo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.ServiceTypeTotal;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TankiRiyoNissuResult;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.TeikyohyoBeppyoEntityResult;
import jp.co.ndensan.reams.db.dbc.entity.report.source.serviceRiyohyoBeppyo.ServiceRiyohyoBeppyoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC0150011_1_サービス提供票別表Reportのインターフェースクラスです。
 *
 * @reamsid_L DBC-5100-030 tianshuai
 */
public class ServiceRiyohyoBeppyoReport extends Report<ServiceRiyohyoBeppyoSource> {

    private final Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 帳票情報マップ;
    private final TeikyohyoBeppyoEntityResult 帳票ヘッダー;
    private final KyufuJikoSakuseiEntityResult 合計情報;
    private final FlexibleDate 作成日時;
    private final FlexibleYearMonth 利用年月;
    private final List<ServiceTypeTotal> 種類別支給限度情報;
    private final List<TankiRiyoNissuResult> 短期入所情報;
    private static final int INT_15 = 15;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報マップ 帳票情報マップ
     * @param 合計情報 合計情報
     * @param 帳票ヘッダー 帳票ヘッダー
     * @param 作成日時 作成日時
     * @param 利用年月 利用年月
     * @param 種類別支給限度情報 種類別支給限度情報
     * @param 短期入所情報 短期入所情報
     */
    public ServiceRiyohyoBeppyoReport(Map<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> 帳票情報マップ,
            KyufuJikoSakuseiEntityResult 合計情報,
            TeikyohyoBeppyoEntityResult 帳票ヘッダー,
            FlexibleDate 作成日時,
            FlexibleYearMonth 利用年月,
            List<ServiceTypeTotal> 種類別支給限度情報,
            List<TankiRiyoNissuResult> 短期入所情報) {
        this.帳票情報マップ = 帳票情報マップ;
        this.合計情報 = 合計情報;
        this.帳票ヘッダー = 帳票ヘッダー;
        this.作成日時 = 作成日時;
        this.利用年月 = 利用年月;
        this.種類別支給限度情報 = 種類別支給限度情報;
        this.短期入所情報 = 短期入所情報;
    }

    @Override
    public void writeBy(ReportSourceWriter<ServiceRiyohyoBeppyoSource> reportSourceWriter) {
        int 総ページ数 = 0;
        int loopSize = 0;
        boolean is最後事業者 = Boolean.FALSE;
        for (Map.Entry<JigyoshaNo, List<KyufuJikoSakuseiEntityResult>> entry : 帳票情報マップ.entrySet()) {
            loopSize++;
            is最後事業者 = 帳票情報マップ.size() == loopSize;
            総ページ数 = doPrint(reportSourceWriter, get提供票別表リスト変換後(entry.getValue()),
                    総ページ数, is最後事業者);
        }
    }

    private int doPrint(ReportSourceWriter<ServiceRiyohyoBeppyoSource> reportSourceWriter,
            List<KyufuJikoSakuseiEntityResult> サービス提供票別表リスト, int 総ページ数, boolean is最後事業者) {
        int maxSize = 0;
        if (サービス提供票別表リスト == null || サービス提供票別表リスト.isEmpty()) {
            return 総ページ数;
        } else {
            maxSize = サービス提供票別表リスト.size();
        }
        if (種類別支給限度情報 == null || 種類別支給限度情報.isEmpty()) {
            maxSize = サービス提供票別表リスト.size();
        } else {
            maxSize = 種類別支給限度情報.size() > サービス提供票別表リスト.size() && is最後事業者
                    ? 種類別支給限度情報.size() : maxSize;
        }
        int loopSize = (int) (Math.ceil((double) maxSize / (double) INT_15));
        for (int i = 0; i < loopSize; i++) {
            総ページ数++;
            List<KyufuJikoSakuseiEntityResult> loopKyufuJikoSakuseiList = new ArrayList<>();
            List<ServiceTypeTotal> loopServiceTypeTotalList = new ArrayList<>();
            for (int j = 1; j <= INT_15; j++) {
                if ((INT_15 * i) + j <= サービス提供票別表リスト.size()) {
                    loopKyufuJikoSakuseiList.add(サービス提供票別表リスト.get((INT_15 * i) + j - 1));
                }
                if (j <= 種類別支給限度情報.size() - (総ページ数 - 1) * INT_15) {
                    loopServiceTypeTotalList.add(種類別支給限度情報.get(j + (総ページ数 - 1) * INT_15 - 1));
                }
            }
            boolean isサービス提供票最後ページ出力 = (i + 1) * INT_15 >= サービス提供票別表リスト.size()
                    && i * INT_15 < サービス提供票別表リスト.size() && is最後事業者;
            boolean is種類別支給限度管理出力 = !loopServiceTypeTotalList.isEmpty();
            boolean is種類別支給限度管理最後ページ出力 = 総ページ数 * INT_15 >= 種類別支給限度情報.size()
                    && (総ページ数 - 1) * INT_15 < 種類別支給限度情報.size();
            boolean is短期入所利用日数出力 = (i + 1) == loopSize && is最後事業者;
            Decimal 種類超過単位数合計 = Decimal.ZERO;
            if (is種類別支給限度管理最後ページ出力) {
                種類超過単位数合計 = get種類超過単位数合計();
            }
            IServiceRiyohyoBeppyoHeaderEditor editorHeader = new ServiceRiyohyoBeppyoHeaderEditor(帳票ヘッダー,
                    作成日時,
                    利用年月,
                    総ページ数);
            IServiceRiyohyoBeppyoBodyEditor editorBody = new ServiceRiyohyoBeppyoBodyEditor(loopKyufuJikoSakuseiList,
                    loopServiceTypeTotalList,
                    合計情報,
                    短期入所情報,
                    isサービス提供票最後ページ出力,
                    is種類別支給限度管理出力,
                    is種類別支給限度管理最後ページ出力,
                    is短期入所利用日数出力,
                    種類超過単位数合計);
            IServiceRiyohyoBeppyoBuilder builder = new ServiceRiyohyoBeppyoBuilder(editorHeader, editorBody);
            reportSourceWriter.writeLine(builder);
        }
        return 総ページ数;
    }

    private Decimal get種類超過単位数合計() {
        Decimal 種類超過単位数合計 = Decimal.ZERO;
        for (ServiceTypeTotal serviceTypeTotal : this.種類別支給限度情報) {
            種類超過単位数合計 = 種類超過単位数合計.add(serviceTypeTotal.get限度超過単位数());
        }
        return 種類超過単位数合計;
    }

    private List<KyufuJikoSakuseiEntityResult> get提供票別表リスト変換後(List<KyufuJikoSakuseiEntityResult> 提供票別表リスト) {
        List<KyufuJikoSakuseiEntityResult> resultList = new ArrayList<>();
        if (提供票別表リスト == null || 提供票別表リスト.isEmpty()) {
            return resultList;
        }
        KyufuJikoSakuseiEntityResult 合計Entity = 提供票別表リスト.get(0);
        提供票別表リスト.remove(0);
        提供票別表リスト.add(合計Entity);
        return 提供票別表リスト;
    }
}
