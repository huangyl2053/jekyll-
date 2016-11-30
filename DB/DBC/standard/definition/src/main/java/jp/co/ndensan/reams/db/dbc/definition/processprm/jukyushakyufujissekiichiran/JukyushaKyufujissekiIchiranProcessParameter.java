/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績一覧表 のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-3070-030 dangjingjing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKyufujissekiIchiranProcessParameter implements IBatchProcessParameter {

    private RString 対象年月;
    private RString 年月範囲_開始;
    private RString 年月範囲_終了;
    private RString 被保険者番号_開始;
    private RString 被保険者番号_終了;
    private RString 給付実績区分;
    private RString すべて選択;
    private RString 要介護1;
    private RString 要介護2;
    private RString 要介護3;
    private RString 要介護4;
    private RString 要介護5;
    private RString 要支援1;
    private RString 要支援2;
    private RString 事業対象者;
    private RString 経過的要介護;
    private RString 自立;
    private RString 訪問通所他;
    private RString 短期入所生活介護;
    private RString 短期入所療養介護_老健施設;
    private RString 短期入所療養介護_医療施設;
    private RString 認知症対応型共同生活;
    private RString 特定施設入居者生活介護;
    private RString 認知症対応型共同生活_短期;
    private RString 特定施設入居生活介護_短期;
    private RString 居宅介護支援;
    private RString 介護老人福祉施設サービス;
    private RString 介護老人保健施設サービス;
    private RString 介護療養型医療施設サービス;
    private RString 特定福祉用具販売費;
    private RString 住宅改修費;
    private RString 高額介護サービス費;
    private RString 予防訪問通所他;
    private RString 予防短期入所生活介護;
    private RString 予防短期入所療養介護_老健施設;
    private RString 予防短期入所療養介護_医療施設;
    private RString 予防認知症対応型共同生活;
    private RString 予防特定施設入居者生活介護;
    private RString 予防認知症対応型共同生活_短期;
    private RString 予防支援;
    private RString 予防特定福祉用具販売費;
    private RString 予防住宅改修費;
    private RString 介護予防_生活支援_経過;
    private RString 経過措置ケアマネジメント;
    private RString 介護予防_生活支援総合事業;
    private RString 総合事業ケアマネジメント;
    private RString 旧措置特定有無;
    private RString 老人保健市町村番号有無;
    private RString 老人保健市町村番号有_開始;
    private RString 老人保健市町村番号有_終了;
    private RString 老人保健受給者番号有無;
    private RString 老人保健受給者番号有_開始;
    private RString 老人保健受給者番号有_終了;
    private RString 公費負担者番号;
    private RString 公費受給者番号;
    private RString 事業者番号_開始;
    private RString 事業者番号_終了;
    private RString 計画作成事業者番号;
    private RString 給付率区分;
    private RString 給付率;
    private long 出力順ID;
    private RString psmShikibetsuTaisho;
    private List 給付実績区分List;

    /**
     * コンストラクタ
     *
     * @param 対象年月 対象年月
     * @param 年月範囲_開始 年月範囲_開始
     * @param 年月範囲_終了 年月範囲_終了
     * @param 被保険者番号_開始 被保険者番号_開始
     * @param 被保険者番号_終了 被保険者番号_終了
     * @param 給付実績区分 給付実績区分
     * @param すべて選択 すべて選択
     * @param 要介護1 要介護1
     * @param 要介護2 要介護2
     * @param 要介護3 要介護3
     * @param 要介護4 要介護4
     * @param 要介護5 要介護5
     * @param 要支援1 要支援1
     * @param 要支援2 要支援2
     * @param 事業対象者 事業対象者
     * @param 経過的要介護 経過的要介護
     * @param 自立 自立
     * @param 訪問通所他 訪問通所他
     * @param 短期入所生活介護 短期入所生活介護
     * @param 短期入所療養介護_老健施設 短期入所療養介護_老健施設
     * @param 短期入所療養介護_医療施設 短期入所療養介護_医療施設
     * @param 認知症対応型共同生活 認知症対応型共同生活
     * @param 特定施設入居者生活介護 特定施設入居者生活介護
     * @param 認知症対応型共同生活_短期 認知症対応型共同生活_短期
     * @param 特定施設入居生活介護_短期 特定施設入居生活介護_短期
     * @param 居宅介護支援 居宅介護支援
     * @param 介護老人福祉施設サービス 介護老人福祉施設サービス
     * @param 介護老人保健施設サービス 介護老人保健施設サービス
     * @param 介護療養型医療施設サービス 介護療養型医療施設サービス
     * @param 特定福祉用具販売費 特定福祉用具販売費
     * @param 住宅改修費 住宅改修費
     * @param 高額介護サービス費 高額介護サービス費
     * @param 予防訪問通所他 予防訪問通所他
     * @param 予防短期入所生活介護 予防短期入所生活介護
     * @param 予防短期入所療養介護_老健施設 予防短期入所療養介護_老健施設
     * @param 予防短期入所療養介護_医療施設 予防短期入所療養介護_医療施設
     * @param 予防認知症対応型共同生活 予防認知症対応型共同生活
     * @param 予防特定施設入居者生活介護 予防特定施設入居者生活介護
     * @param 予防認知症対応型共同生活_短期 予防認知症対応型共同生活_短期
     * @param 予防支援 予防支援
     * @param 予防特定福祉用具販売費 予防特定福祉用具販売費
     * @param 予防住宅改修費 予防住宅改修費
     * @param 介護予防_生活支援_経過 介護予防_生活支援_経過
     * @param 経過措置ケアマネジメント 経過措置ケアマネジメント
     * @param 介護予防_生活支援総合事業 介護予防_生活支援総合事業
     * @param 総合事業ケアマネジメント 総合事業ケアマネジメント
     * @param 旧措置特定有無 旧措置特定有無
     * @param 老人保健市町村番号有無 老人保健市町村番号有無
     * @param 老人保健市町村番号有_開始 老人保健市町村番号有_開始
     * @param 老人保健市町村番号有_終了 老人保健市町村番号有_終了
     * @param 老人保健受給者番号有無 老人保健受給者番号有無
     * @param 老人保健受給者番号有_開始 老人保健受給者番号有_開始
     * @param 老人保健受給者番号有_終了 老人保健受給者番号有_終了
     * @param 公費負担者番号 公費負担者番号
     * @param 公費受給者番号 公費受給者番号
     * @param 事業者番号_開始 事業者番号_開始
     * @param 事業者番号_終了 事業者番号_終了
     * @param 計画作成事業者番号 計画作成事業者番号
     * @param 給付率区分 給付率区分
     * @param 給付率 給付率
     * @param 出力順ID 出力順ID
     */
    public JukyushaKyufujissekiIchiranProcessParameter(RString 対象年月,
            RString 年月範囲_開始,
            RString 年月範囲_終了,
            RString 被保険者番号_開始,
            RString 被保険者番号_終了,
            RString 給付実績区分,
            RString すべて選択,
            RString 要介護1,
            RString 要介護2,
            RString 要介護3,
            RString 要介護4,
            RString 要介護5,
            RString 要支援1,
            RString 要支援2,
            RString 事業対象者,
            RString 経過的要介護,
            RString 自立,
            RString 訪問通所他,
            RString 短期入所生活介護,
            RString 短期入所療養介護_老健施設,
            RString 短期入所療養介護_医療施設,
            RString 認知症対応型共同生活,
            RString 特定施設入居者生活介護,
            RString 認知症対応型共同生活_短期,
            RString 特定施設入居生活介護_短期,
            RString 居宅介護支援,
            RString 介護老人福祉施設サービス,
            RString 介護老人保健施設サービス,
            RString 介護療養型医療施設サービス,
            RString 特定福祉用具販売費,
            RString 住宅改修費,
            RString 高額介護サービス費,
            RString 予防訪問通所他,
            RString 予防短期入所生活介護,
            RString 予防短期入所療養介護_老健施設,
            RString 予防短期入所療養介護_医療施設,
            RString 予防認知症対応型共同生活,
            RString 予防特定施設入居者生活介護,
            RString 予防認知症対応型共同生活_短期,
            RString 予防支援,
            RString 予防特定福祉用具販売費,
            RString 予防住宅改修費,
            RString 介護予防_生活支援_経過,
            RString 経過措置ケアマネジメント,
            RString 介護予防_生活支援総合事業,
            RString 総合事業ケアマネジメント,
            RString 旧措置特定有無,
            RString 老人保健市町村番号有無,
            RString 老人保健市町村番号有_開始,
            RString 老人保健市町村番号有_終了,
            RString 老人保健受給者番号有無,
            RString 老人保健受給者番号有_開始,
            RString 老人保健受給者番号有_終了,
            RString 公費負担者番号,
            RString 公費受給者番号,
            RString 事業者番号_開始,
            RString 事業者番号_終了,
            RString 計画作成事業者番号,
            RString 給付率区分,
            RString 給付率,
            long 出力順ID) {
        this.対象年月 = 対象年月;
        this.年月範囲_開始 = 年月範囲_開始;
        this.年月範囲_終了 = 年月範囲_終了;
        this.被保険者番号_開始 = 被保険者番号_開始;
        this.被保険者番号_終了 = 被保険者番号_終了;
        this.給付実績区分 = 給付実績区分;
        this.すべて選択 = すべて選択;
        this.要介護1 = 要介護1;
        this.要介護2 = 要介護2;
        this.要介護3 = 要介護3;
        this.要介護4 = 要介護4;
        this.要介護5 = 要介護5;
        this.要支援1 = 要支援1;
        this.要支援2 = 要支援2;
        this.事業対象者 = 事業対象者;
        this.経過的要介護 = 経過的要介護;
        this.自立 = 自立;
        this.訪問通所他 = 訪問通所他;
        this.短期入所生活介護 = 短期入所生活介護;
        this.短期入所療養介護_老健施設 = 短期入所療養介護_老健施設;
        this.短期入所療養介護_医療施設 = 短期入所療養介護_医療施設;
        this.認知症対応型共同生活 = 認知症対応型共同生活;
        this.特定施設入居者生活介護 = 特定施設入居者生活介護;
        this.認知症対応型共同生活_短期 = 認知症対応型共同生活_短期;
        this.特定施設入居生活介護_短期 = 特定施設入居生活介護_短期;
        this.居宅介護支援 = 居宅介護支援;
        this.介護老人福祉施設サービス = 介護老人福祉施設サービス;
        this.介護老人保健施設サービス = 介護老人保健施設サービス;
        this.介護療養型医療施設サービス = 介護療養型医療施設サービス;
        this.特定福祉用具販売費 = 特定福祉用具販売費;
        this.住宅改修費 = 住宅改修費;
        this.高額介護サービス費 = 高額介護サービス費;
        this.予防訪問通所他 = 予防訪問通所他;
        this.予防短期入所生活介護 = 予防短期入所生活介護;
        this.予防短期入所療養介護_老健施設 = 予防短期入所療養介護_老健施設;
        this.予防短期入所療養介護_医療施設 = 予防短期入所療養介護_医療施設;
        this.予防認知症対応型共同生活 = 予防認知症対応型共同生活;
        this.予防特定施設入居者生活介護 = 予防特定施設入居者生活介護;
        this.予防認知症対応型共同生活_短期 = 予防認知症対応型共同生活_短期;
        this.予防支援 = 予防支援;
        this.予防特定福祉用具販売費 = 予防特定福祉用具販売費;
        this.予防住宅改修費 = 予防住宅改修費;
        this.介護予防_生活支援_経過 = 介護予防_生活支援_経過;
        this.経過措置ケアマネジメント = 経過措置ケアマネジメント;
        this.介護予防_生活支援総合事業 = 介護予防_生活支援総合事業;
        this.総合事業ケアマネジメント = 総合事業ケアマネジメント;
        this.旧措置特定有無 = 旧措置特定有無;
        this.老人保健市町村番号有無 = 老人保健市町村番号有無;
        this.老人保健市町村番号有_開始 = 老人保健市町村番号有_開始;
        this.老人保健市町村番号有_終了 = 老人保健市町村番号有_終了;
        this.老人保健受給者番号有無 = 老人保健受給者番号有無;
        this.老人保健受給者番号有_開始 = 老人保健受給者番号有_開始;
        this.老人保健受給者番号有_終了 = 老人保健受給者番号有_終了;
        this.公費負担者番号 = 公費負担者番号;
        this.公費受給者番号 = 公費受給者番号;
        this.事業者番号_開始 = 事業者番号_開始;
        this.事業者番号_終了 = 事業者番号_終了;
        this.計画作成事業者番号 = 計画作成事業者番号;
        this.給付率区分 = 給付率区分;
        this.給付率 = 給付率;
        this.出力順ID = 出力順ID;
    }

    /**
     * コンストラクタです。
     *
     * @param 対象年月 対象年月
     * @param 年月範囲_開始 年月範囲_開始
     * @param 年月範囲_終了 年月範囲_終了
     * @param 被保険者番号_開始 被保険者番号_開始
     * @param 被保険者番号_終了 被保険者番号_終了
     * @param 給付実績区分 給付実績区分
     * @param すべて選択 すべて選択
     * @param 要介護1 要介護1
     * @param 要介護2 要介護2
     * @param 要介護3 要介護3
     * @param 要介護4 要介護4
     * @param 要介護5 要介護5
     * @param 要支援1 要支援1
     * @param 要支援2 要支援2
     * @param 事業対象者 事業対象者
     * @param 経過的要介護 経過的要介護
     * @param 自立 自立
     * @param 訪問通所他 訪問通所他
     * @param 短期入所生活介護 短期入所生活介護
     * @param 短期入所療養介護_老健施設 短期入所療養介護_老健施設
     * @param 短期入所療養介護_医療施設 短期入所療養介護_医療施設
     * @param 認知症対応型共同生活 認知症対応型共同生活
     * @param 特定施設入居者生活介護 特定施設入居者生活介護
     * @param 認知症対応型共同生活_短期 認知症対応型共同生活_短期
     * @param 特定施設入居生活介護_短期 特定施設入居生活介護_短期
     * @param 居宅介護支援 居宅介護支援
     * @param 介護老人福祉施設サービス 介護老人福祉施設サービス
     * @param 介護老人保健施設サービス 介護老人保健施設サービス
     * @param 介護療養型医療施設サービス 介護療養型医療施設サービス
     * @param 特定福祉用具販売費 特定福祉用具販売費
     * @param 住宅改修費 住宅改修費
     * @param 高額介護サービス費 高額介護サービス費
     * @param 予防訪問通所他 予防訪問通所他
     * @param 予防短期入所生活介護 予防短期入所生活介護
     * @param 予防短期入所療養介護_老健施設 予防短期入所療養介護_老健施設
     * @param 予防短期入所療養介護_医療施設 予防短期入所療養介護_医療施設
     * @param 予防認知症対応型共同生活 予防認知症対応型共同生活
     * @param 予防特定施設入居者生活介護 予防特定施設入居者生活介護
     * @param 予防認知症対応型共同生活_短期 予防認知症対応型共同生活_短期
     * @param 予防支援 予防支援
     * @param 予防特定福祉用具販売費 予防特定福祉用具販売費
     * @param 予防住宅改修費 予防住宅改修費
     * @param 介護予防_生活支援_経過 介護予防_生活支援_経過
     * @param 経過措置ケアマネジメント 経過措置ケアマネジメント
     * @param 介護予防_生活支援総合事業 介護予防_生活支援総合事業
     * @param 総合事業ケアマネジメント 総合事業ケアマネジメント
     * @param 旧措置特定有無 旧措置特定有無
     * @param 老人保健市町村番号有無 老人保健市町村番号有無
     * @param 老人保健市町村番号有_開始 老人保健市町村番号有_開始
     * @param 老人保健市町村番号有_終了 老人保健市町村番号有_終了
     * @param 老人保健受給者番号有無 老人保健受給者番号有無
     * @param 老人保健受給者番号有_開始 老人保健受給者番号有_開始
     * @param 老人保健受給者番号有_終了 老人保健受給者番号有_終了
     * @param 公費負担者番号 公費負担者番号
     * @param 公費受給者番号 公費受給者番号
     * @param 事業者番号_開始 事業者番号_開始
     * @param 事業者番号_終了 事業者番号_終了
     * @param 計画作成事業者番号 計画作成事業者番号
     * @param 給付率区分 給付率区分
     * @param 給付率 給付率
     * @param 出力順ID 出力順ID
     * @return JukyushaKyufujissekiIchiranProcessParameter
     */
    public static JukyushaKyufujissekiIchiranProcessParameter createJukyushaKyufujissekiIchiranProcessParameter(
            RString 対象年月,
            RString 年月範囲_開始,
            RString 年月範囲_終了,
            RString 被保険者番号_開始,
            RString 被保険者番号_終了,
            RString 給付実績区分,
            RString すべて選択,
            RString 要介護1,
            RString 要介護2,
            RString 要介護3,
            RString 要介護4,
            RString 要介護5,
            RString 要支援1,
            RString 要支援2,
            RString 事業対象者,
            RString 経過的要介護,
            RString 自立,
            RString 訪問通所他,
            RString 短期入所生活介護,
            RString 短期入所療養介護_老健施設,
            RString 短期入所療養介護_医療施設,
            RString 認知症対応型共同生活,
            RString 特定施設入居者生活介護,
            RString 認知症対応型共同生活_短期,
            RString 特定施設入居生活介護_短期,
            RString 居宅介護支援,
            RString 介護老人福祉施設サービス,
            RString 介護老人保健施設サービス,
            RString 介護療養型医療施設サービス,
            RString 特定福祉用具販売費,
            RString 住宅改修費,
            RString 高額介護サービス費,
            RString 予防訪問通所他,
            RString 予防短期入所生活介護,
            RString 予防短期入所療養介護_老健施設,
            RString 予防短期入所療養介護_医療施設,
            RString 予防認知症対応型共同生活,
            RString 予防特定施設入居者生活介護,
            RString 予防認知症対応型共同生活_短期,
            RString 予防支援,
            RString 予防特定福祉用具販売費,
            RString 予防住宅改修費,
            RString 介護予防_生活支援_経過,
            RString 経過措置ケアマネジメント,
            RString 介護予防_生活支援総合事業,
            RString 総合事業ケアマネジメント,
            RString 旧措置特定有無,
            RString 老人保健市町村番号有無,
            RString 老人保健市町村番号有_開始,
            RString 老人保健市町村番号有_終了,
            RString 老人保健受給者番号有無,
            RString 老人保健受給者番号有_開始,
            RString 老人保健受給者番号有_終了,
            RString 公費負担者番号,
            RString 公費受給者番号,
            RString 事業者番号_開始,
            RString 事業者番号_終了,
            RString 計画作成事業者番号,
            RString 給付率区分,
            RString 給付率,
            long 出力順ID) {
        return new JukyushaKyufujissekiIchiranProcessParameter(対象年月,
                年月範囲_開始,
                年月範囲_終了,
                被保険者番号_開始,
                被保険者番号_終了,
                給付実績区分,
                すべて選択,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                要支援1,
                要支援2,
                事業対象者,
                経過的要介護,
                自立,
                訪問通所他,
                短期入所生活介護,
                短期入所療養介護_老健施設,
                短期入所療養介護_医療施設,
                認知症対応型共同生活,
                特定施設入居者生活介護,
                認知症対応型共同生活_短期,
                特定施設入居生活介護_短期,
                居宅介護支援,
                介護老人福祉施設サービス,
                介護老人保健施設サービス,
                介護療養型医療施設サービス,
                特定福祉用具販売費,
                住宅改修費,
                高額介護サービス費,
                予防訪問通所他,
                予防短期入所生活介護,
                予防短期入所療養介護_老健施設,
                予防短期入所療養介護_医療施設,
                予防認知症対応型共同生活,
                予防特定施設入居者生活介護,
                予防認知症対応型共同生活_短期,
                予防支援,
                予防特定福祉用具販売費,
                予防住宅改修費,
                介護予防_生活支援_経過,
                経過措置ケアマネジメント,
                介護予防_生活支援総合事業,
                総合事業ケアマネジメント,
                旧措置特定有無,
                老人保健市町村番号有無,
                老人保健市町村番号有_開始,
                老人保健市町村番号有_終了,
                老人保健受給者番号有無,
                老人保健受給者番号有_開始,
                老人保健受給者番号有_終了,
                公費負担者番号,
                公費受給者番号,
                事業者番号_開始,
                事業者番号_終了,
                計画作成事業者番号,
                給付率区分,
                給付率,
                出力順ID);
    }

    /**
     * 受給者給付実績一覧表のMybaticParameter作成する。
     *
     * @param 出力順 出力順
     * @return JukyushaKyufujissekiIchiranMybatisParameter
     */
    public JukyushaKyufujissekiIchiranMybatisParameter toJukyushaKyufujissekiIchiranMybatisParameter(RString 出力順) {
        return JukyushaKyufujissekiIchiranMybatisParameter.createSelectByKeyParam(対象年月,
                年月範囲_開始,
                年月範囲_終了,
                被保険者番号_開始,
                被保険者番号_終了,
                給付実績区分,
                すべて選択,
                要介護1,
                要介護2,
                要介護3,
                要介護4,
                要介護5,
                要支援1,
                要支援2,
                事業対象者,
                経過的要介護,
                自立,
                訪問通所他,
                短期入所生活介護,
                短期入所療養介護_老健施設,
                短期入所療養介護_医療施設,
                認知症対応型共同生活,
                特定施設入居者生活介護,
                認知症対応型共同生活_短期,
                特定施設入居生活介護_短期,
                居宅介護支援,
                介護老人福祉施設サービス,
                介護老人保健施設サービス,
                介護療養型医療施設サービス,
                特定福祉用具販売費,
                住宅改修費,
                高額介護サービス費,
                予防訪問通所他,
                予防短期入所生活介護,
                予防短期入所療養介護_老健施設,
                予防短期入所療養介護_医療施設,
                予防認知症対応型共同生活,
                予防特定施設入居者生活介護,
                予防認知症対応型共同生活_短期,
                予防支援,
                予防特定福祉用具販売費,
                予防住宅改修費,
                介護予防_生活支援_経過,
                経過措置ケアマネジメント,
                介護予防_生活支援総合事業,
                総合事業ケアマネジメント,
                旧措置特定有無,
                老人保健市町村番号有無,
                老人保健市町村番号有_開始,
                老人保健市町村番号有_終了,
                老人保健受給者番号有無,
                老人保健受給者番号有_開始,
                老人保健受給者番号有_終了,
                公費負担者番号,
                公費受給者番号,
                事業者番号_開始,
                事業者番号_終了,
                計画作成事業者番号,
                給付率区分,
                給付率,
                出力順,
                psmShikibetsuTaisho, 給付実績区分List);
    }
}
