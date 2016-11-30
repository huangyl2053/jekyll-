/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-3080-030 xuyongchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKyufujissekiDaichoMybatisParameter implements IMyBatisParameter {

    private final RString 対象年月;
    private final RString 年月範囲_開始;
    private final RString 年月範囲_終了;
    private final RString 被保険者番号_開始;
    private final RString 被保険者番号_終了;
    private final RString 給付実績区分;
    private final RString すべて選択;
    private final RString 要介護1;
    private final RString 要介護2;
    private final RString 要介護3;
    private final RString 要介護4;
    private final RString 要介護5;
    private final RString 要支援1;
    private final RString 要支援2;
    private final RString 事業対象者;
    private final RString 経過的要介護;
    private final RString 自立;
    private final RString 訪問通所他;
    private final RString 短期入所生活介護;
    private final RString 短期入所療養介護_老健施設;
    private final RString 短期入所療養介護_医療施設;
    private final RString 認知症対応型共同生活;
    private final RString 特定施設入居者生活介護;
    private final RString 認知症対応型共同生活_短期;
    private final RString 特定施設入居生活介護_短期;
    private final RString 居宅介護支援;
    private final RString 介護老人福祉施設サービス;
    private final RString 介護老人保健施設サービス;
    private final RString 介護療養型医療施設サービス;
    private final RString 特定福祉用具販売費;
    private final RString 住宅改修費;
    private final RString 高額介護サービス費;
    private final RString 予防訪問通所他;
    private final RString 予防短期入所生活介護;
    private final RString 予防短期入所療養介護_老健施設;
    private final RString 予防短期入所療養介護_医療施設;
    private final RString 予防認知症対応型共同生活;
    private final RString 予防特定施設入居者生活介護;
    private final RString 予防認知症対応型共同生活_短期;
    private final RString 予防支援;
    private final RString 予防特定福祉用具販売費;
    private final RString 予防住宅改修費;
    private final RString 介護予防_生活支援_経過;
    private final RString 経過措置ケアマネジメント;
    private final RString 介護予防_生活支援総合事業;
    private final RString 総合事業ケアマネジメント;
    private final RString 旧措置特定有無;
    private final RString 老人保健市町村番号有無;
    private final RString 老人保健市町村番号有_開始;
    private final RString 老人保健市町村番号有_終了;
    private final RString 老人保健受給者番号有無;
    private final RString 老人保健受給者番号有_開始;
    private final RString 老人保健受給者番号有_終了;
    private final RString 公費負担者番号;
    private final RString 公費受給者番号;
    private final RString 事業者番号_開始;
    private final RString 事業者番号_終了;
    private final RString 計画作成事業者番号;
    private final RString 給付率区分;
    private final RString 給付率;
    private final long 出力順ID;
    private final RString psmShikibetsuTaisho;
    private final boolean 対象年月flag;
    private final boolean 給付実績区分flag;
    private final boolean 給付実績区分flag1;
    private final boolean すべて選択flag;
    private final boolean 要介護1flag;
    private final boolean 要介護2flag;
    private final boolean 要介護3flag;
    private final boolean 要介護4flag;
    private final boolean 要介護5flag;
    private final boolean 要支援1flag;
    private final boolean 要支援2flag;
    private final boolean 経過的要介護flag;
    private final boolean 事業対象者flag;
    private final boolean 自立flag;
    private final boolean 訪問通所他flag;
    private final boolean 短期入所生活介護flag;
    private final boolean 短期入所療養介護_老健施設flag;
    private final boolean 短期入所療養介護_医療施設flag;
    private final boolean 認知症対応型共同生活flag;
    private final boolean 特定施設入居者生活介護flag;
    private final boolean 認知症対応型共同生活_短期flag;
    private final boolean 特定施設入居生活介護_短期flag;
    private final boolean 居宅介護支援flag;
    private final boolean 介護老人福祉施設サービスflag;
    private final boolean 介護老人保健施設サービスflag;
    private final boolean 介護療養型医療施設サービスflag;
    private final boolean 特定福祉用具販売費flag;
    private final boolean 住宅改修費flag;
    private final boolean 高額介護サービス費flag;
    private final boolean 予防訪問通所他flag;
    private final boolean 予防短期入所生活介護flag;
    private final boolean 予防短期入所療養介護_老健施設flag;
    private final boolean 予防短期入所療養介護_医療施設flag;
    private final boolean 予防認知症対応型共同生活flag;
    private final boolean 予防特定施設入居者生活介護flag;
    private final boolean 予防認知症対応型共同生活_短期flag;
    private final boolean 予防支援flag;
    private final boolean 予防特定福祉用具販売費flag;
    private final boolean 予防住宅改修費flag;
    private final boolean 介護予防_生活支援_経過flag;
    private final boolean 経過措置ケアマネジメントflag;
    private final boolean 介護予防_生活支援総合事業flag;
    private final boolean 総合事業ケアマネジメントflag;
    private final boolean 旧措置特定有無flag;
    private final boolean 旧措置特定有無flag1;
    private final boolean 老人保健市町村番号有無flag;
    private final boolean 老人保健市町村番号有無flag1;
    private final boolean 老人保健受給者番号有無flag;
    private final boolean 老人保健受給者番号有無flag1;
    private final boolean 公費負担者番号flag;
    private final boolean 公費受給者番号flag;
    private final boolean 事業者番号flag;
    private final boolean 計画作成事業者番号flag;
    private final boolean 給付率区分flag1;
    private final boolean 給付率区分flag2;
    private final boolean 給付率区分flag3;
    private final boolean 給付率flag;

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
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 対象年月flag 対象年月flag
     * @param 給付実績区分flag 給付実績区分flag
     * @param 給付実績区分flag1 給付実績区分flag1
     * @param すべて選択flag すべて選択flag
     * @param 要介護1flag 要介護1flag
     * @param 要介護2flag 要介護2flag
     * @param 要介護3flag 要介護3flag
     * @param 要介護4flag 要介護4flag
     * @param 要介護5flag 要介護5flag
     * @param 要支援1flag 要支援1flag
     * @param 要支援2flag 要支援2flag
     * @param 経過的要介護flag 経過的要介護flag
     * @param 事業対象者flag 事業対象者flag
     * @param 訪問通所他flag 訪問通所他flag
     * @param 短期入所生活介護flag 短期入所生活介護flag
     * @param 短期入所療養介護_老健施設flag 短期入所療養介護_老健施設flag
     * @param 短期入所療養介護_医療施設flag 短期入所療養介護_医療施設flag
     * @param 認知症対応型共同生活flag 認知症対応型共同生活flag
     * @param 特定施設入居者生活介護flag 特定施設入居者生活介護flag
     * @param 認知症対応型共同生活_短期flag 認知症対応型共同生活_短期flag
     * @param 特定施設入居生活介護_短期flag 特定施設入居生活介護_短期flag
     * @param 居宅介護支援flag 居宅介護支援flag
     * @param 介護老人福祉施設サービスflag 介護老人福祉施設サービスflag
     * @param 介護老人保健施設サービスflag 介護老人保健施設サービスflag
     * @param 介護療養型医療施設サービスflag 介護療養型医療施設サービスflag
     * @param 特定福祉用具販売費flag 特定福祉用具販売費flag
     * @param 住宅改修費flag 住宅改修費flag
     * @param 高額介護サービス費flag 高額介護サービス費flag
     * @param 予防訪問通所他flag 予防訪問通所他flag
     * @param 予防短期入所生活介護flag 予防短期入所生活介護flag
     * @param 予防短期入所療養介護_老健施設flag 予防短期入所療養介護_老健施設flag
     * @param 予防短期入所療養介護_医療施設flag 予防短期入所療養介護_医療施設flag
     * @param 予防認知症対応型共同生活flag 予防認知症対応型共同生活flag
     * @param 予防特定施設入居者生活介護flag 予防特定施設入居者生活介護flag
     * @param 予防認知症対応型共同生活_短期flag 予防認知症対応型共同生活_短期flag
     * @param 予防支援flag 予防支援flag
     * @param 予防特定福祉用具販売費flag 予防特定福祉用具販売費flag
     * @param 予防住宅改修費flag 予防住宅改修費flag
     * @param 介護予防_生活支援_経過flag 介護予防_生活支援_経過flag
     * @param 経過措置ケアマネジメントflag 経過措置ケアマネジメントflag
     * @param 介護予防_生活支援総合事業flag 介護予防_生活支援総合事業flag
     * @param 総合事業ケアマネジメントflag 総合事業ケアマネジメントflag
     * @param 旧措置特定有無flag 旧措置特定有無flag
     * @param 旧措置特定有無flag1 旧措置特定有無flag1
     * @param 老人保健市町村番号有無flag 老人保健市町村番号有無flag
     * @param 老人保健市町村番号有無flag1 老人保健市町村番号有無flag1
     * @param 老人保健受給者番号有無flag 老人保健受給者番号有無flag
     * @param 老人保健受給者番号有無flag1 老人保健受給者番号有無flag1
     * @param 公費負担者番号flag 公費負担者番号flag
     * @param 公費受給者番号flag 公費受給者番号flag
     * @param 事業者番号flag 事業者番号flag
     * @param 計画作成事業者番号flag 計画作成事業者番号flag
     * @param 給付率区分flag1 給付率区分flag1
     * @param 給付率区分flag2 給付率区分flag2
     * @param 給付率区分flag3 給付率区分flag3
     * @param 給付率flag 給付率flag
     * @param 自立flag boolean
     */
    protected JukyushaKyufujissekiDaichoMybatisParameter(RString 対象年月,
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
            long 出力順ID,
            RString psmShikibetsuTaisho,
            boolean 対象年月flag,
            boolean 給付実績区分flag,
            boolean 給付実績区分flag1,
            boolean すべて選択flag,
            boolean 要介護1flag,
            boolean 要介護2flag,
            boolean 要介護3flag,
            boolean 要介護4flag,
            boolean 要介護5flag,
            boolean 要支援1flag,
            boolean 要支援2flag,
            boolean 経過的要介護flag,
            boolean 事業対象者flag,
            boolean 自立flag,
            boolean 訪問通所他flag,
            boolean 短期入所生活介護flag,
            boolean 短期入所療養介護_老健施設flag,
            boolean 短期入所療養介護_医療施設flag,
            boolean 認知症対応型共同生活flag,
            boolean 特定施設入居者生活介護flag,
            boolean 認知症対応型共同生活_短期flag,
            boolean 特定施設入居生活介護_短期flag,
            boolean 居宅介護支援flag,
            boolean 介護老人福祉施設サービスflag,
            boolean 介護老人保健施設サービスflag,
            boolean 介護療養型医療施設サービスflag,
            boolean 特定福祉用具販売費flag,
            boolean 住宅改修費flag,
            boolean 高額介護サービス費flag,
            boolean 予防訪問通所他flag,
            boolean 予防短期入所生活介護flag,
            boolean 予防短期入所療養介護_老健施設flag,
            boolean 予防短期入所療養介護_医療施設flag,
            boolean 予防認知症対応型共同生活flag,
            boolean 予防特定施設入居者生活介護flag,
            boolean 予防認知症対応型共同生活_短期flag,
            boolean 予防支援flag,
            boolean 予防特定福祉用具販売費flag,
            boolean 予防住宅改修費flag,
            boolean 介護予防_生活支援_経過flag,
            boolean 経過措置ケアマネジメントflag,
            boolean 介護予防_生活支援総合事業flag,
            boolean 総合事業ケアマネジメントflag,
            boolean 旧措置特定有無flag,
            boolean 旧措置特定有無flag1,
            boolean 老人保健市町村番号有無flag,
            boolean 老人保健市町村番号有無flag1,
            boolean 老人保健受給者番号有無flag,
            boolean 老人保健受給者番号有無flag1,
            boolean 公費負担者番号flag,
            boolean 公費受給者番号flag,
            boolean 事業者番号flag,
            boolean 計画作成事業者番号flag,
            boolean 給付率区分flag1,
            boolean 給付率区分flag2,
            boolean 給付率区分flag3,
            boolean 給付率flag) {
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
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.対象年月flag = 対象年月flag;
        this.給付実績区分flag = 給付実績区分flag;
        this.給付実績区分flag1 = 給付実績区分flag1;
        this.すべて選択flag = すべて選択flag;
        this.要介護1flag = 要介護1flag;
        this.要介護2flag = 要介護2flag;
        this.要介護3flag = 要介護3flag;
        this.要介護4flag = 要介護4flag;
        this.要介護5flag = 要介護5flag;
        this.要支援1flag = 要支援1flag;
        this.要支援2flag = 要支援2flag;
        this.経過的要介護flag = 経過的要介護flag;
        this.事業対象者flag = 事業対象者flag;
        this.自立flag = 自立flag;
        this.訪問通所他flag = 訪問通所他flag;
        this.短期入所生活介護flag = 短期入所生活介護flag;
        this.短期入所療養介護_老健施設flag = 短期入所療養介護_老健施設flag;
        this.短期入所療養介護_医療施設flag = 短期入所療養介護_医療施設flag;
        this.認知症対応型共同生活flag = 認知症対応型共同生活flag;
        this.特定施設入居者生活介護flag = 特定施設入居者生活介護flag;
        this.認知症対応型共同生活_短期flag = 認知症対応型共同生活_短期flag;
        this.特定施設入居生活介護_短期flag = 特定施設入居生活介護_短期flag;
        this.居宅介護支援flag = 居宅介護支援flag;
        this.介護老人福祉施設サービスflag = 介護老人福祉施設サービスflag;
        this.介護老人保健施設サービスflag = 介護老人保健施設サービスflag;
        this.介護療養型医療施設サービスflag = 介護療養型医療施設サービスflag;
        this.特定福祉用具販売費flag = 特定福祉用具販売費flag;
        this.住宅改修費flag = 住宅改修費flag;
        this.高額介護サービス費flag = 高額介護サービス費flag;
        this.予防訪問通所他flag = 予防訪問通所他flag;
        this.予防短期入所生活介護flag = 予防短期入所生活介護flag;
        this.予防短期入所療養介護_老健施設flag = 予防短期入所療養介護_老健施設flag;
        this.予防短期入所療養介護_医療施設flag = 予防短期入所療養介護_医療施設flag;
        this.予防認知症対応型共同生活flag = 予防認知症対応型共同生活flag;
        this.予防特定施設入居者生活介護flag = 予防特定施設入居者生活介護flag;
        this.予防認知症対応型共同生活_短期flag = 予防認知症対応型共同生活_短期flag;
        this.予防支援flag = 予防支援flag;
        this.予防特定福祉用具販売費flag = 予防特定福祉用具販売費flag;
        this.予防住宅改修費flag = 予防住宅改修費flag;
        this.介護予防_生活支援_経過flag = 介護予防_生活支援_経過flag;
        this.経過措置ケアマネジメントflag = 経過措置ケアマネジメントflag;
        this.介護予防_生活支援総合事業flag = 介護予防_生活支援総合事業flag;
        this.総合事業ケアマネジメントflag = 総合事業ケアマネジメントflag;
        this.旧措置特定有無flag = 旧措置特定有無flag;
        this.旧措置特定有無flag1 = 旧措置特定有無flag1;
        this.老人保健市町村番号有無flag = 老人保健市町村番号有無flag;
        this.老人保健市町村番号有無flag1 = 老人保健市町村番号有無flag1;
        this.老人保健受給者番号有無flag = 老人保健受給者番号有無flag;
        this.老人保健受給者番号有無flag1 = 老人保健受給者番号有無flag1;
        this.公費負担者番号flag = 公費負担者番号flag;
        this.公費受給者番号flag = 公費受給者番号flag;
        this.事業者番号flag = 事業者番号flag;
        this.計画作成事業者番号flag = 計画作成事業者番号flag;
        this.給付率区分flag1 = 給付率区分flag1;
        this.給付率区分flag2 = 給付率区分flag2;
        this.給付率区分flag3 = 給付率区分flag3;
        this.給付率flag = 給付率flag;
    }

    /**
     * キー検索用のパラメータを生成します。
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
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return JukyushaKyufujissekiDaichoMybatisParameter
     */
    public static JukyushaKyufujissekiDaichoMybatisParameter createParam(
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
            long 出力順ID,
            RString psmShikibetsuTaisho) {
        boolean 旧措置特定有無flag = false;
        boolean 旧措置特定有無flag1 = false;
        if (new RString("2").equals(旧措置特定有無)) {
            旧措置特定有無flag = true;
        } else if (new RString("3").equals(旧措置特定有無)) {
            旧措置特定有無flag1 = true;
        }
        boolean 老人保健市町村番号有無flag = false;
        boolean 老人保健市町村番号有無flag1 = false;
        if (new RString("2").equals(老人保健市町村番号有無)) {
            老人保健市町村番号有無flag = true;
        } else if (new RString("3").equals(老人保健市町村番号有無)) {
            老人保健市町村番号有無flag1 = true;
        }
        boolean 老人保健受給者番号有無flag = false;
        boolean 老人保健受給者番号有無flag1 = false;
        if (new RString("2").equals(老人保健受給者番号有無)) {
            老人保健受給者番号有無flag = true;
        } else if (new RString("3").equals(老人保健受給者番号有無)) {
            老人保健受給者番号有無flag1 = true;
        }
        boolean すべてflag = true;
        if (new RString("1").equals(要介護1)
                || new RString("1").equals(要介護2)
                || new RString("1").equals(要介護3)
                || new RString("1").equals(要介護4)
                || new RString("1").equals(要介護5)
                || new RString("1").equals(要支援1)
                || new RString("1").equals(要支援2)
                || new RString("1").equals(経過的要介護)
                || new RString("1").equals(事業対象者)) {
            すべてflag = false;
        }
        return new JukyushaKyufujissekiDaichoMybatisParameter(対象年月, 年月範囲_開始, 年月範囲_終了, 被保険者番号_開始, 被保険者番号_終了,
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
                出力順ID,
                psmShikibetsuTaisho,
                new RString("1").equals(対象年月),
                new RString("1").equals(給付実績区分),
                new RString("2").equals(給付実績区分),
                すべてflag,
                new RString("1").equals(要介護1),
                new RString("1").equals(要介護2),
                new RString("1").equals(要介護3),
                new RString("1").equals(要介護4),
                new RString("1").equals(要介護5),
                new RString("1").equals(要支援1),
                new RString("1").equals(要支援2),
                new RString("1").equals(経過的要介護),
                new RString("1").equals(事業対象者),
                new RString("1").equals(自立),
                new RString("1").equals(訪問通所他),
                new RString("1").equals(短期入所生活介護),
                new RString("1").equals(短期入所療養介護_老健施設),
                new RString("1").equals(短期入所療養介護_医療施設),
                new RString("1").equals(認知症対応型共同生活),
                new RString("1").equals(特定施設入居者生活介護),
                new RString("1").equals(認知症対応型共同生活_短期),
                new RString("1").equals(特定施設入居生活介護_短期),
                new RString("1").equals(居宅介護支援),
                new RString("1").equals(介護老人福祉施設サービス),
                new RString("1").equals(介護老人保健施設サービス),
                new RString("1").equals(介護療養型医療施設サービス),
                new RString("1").equals(特定福祉用具販売費),
                new RString("1").equals(住宅改修費),
                new RString("1").equals(高額介護サービス費),
                new RString("1").equals(予防訪問通所他),
                new RString("1").equals(予防短期入所生活介護),
                new RString("1").equals(予防短期入所療養介護_老健施設),
                new RString("1").equals(予防短期入所療養介護_医療施設),
                new RString("1").equals(予防認知症対応型共同生活),
                new RString("1").equals(予防特定施設入居者生活介護),
                new RString("1").equals(予防認知症対応型共同生活_短期),
                new RString("1").equals(予防支援),
                new RString("1").equals(予防特定福祉用具販売費),
                new RString("1").equals(予防住宅改修費),
                new RString("1").equals(介護予防_生活支援_経過),
                new RString("1").equals(経過措置ケアマネジメント),
                new RString("1").equals(介護予防_生活支援総合事業),
                new RString("1").equals(総合事業ケアマネジメント),
                旧措置特定有無flag,
                旧措置特定有無flag1,
                老人保健市町村番号有無flag,
                老人保健市町村番号有無flag1,
                老人保健受給者番号有無flag,
                老人保健受給者番号有無flag1,
                !RString.isNullOrEmpty(公費負担者番号),
                !RString.isNullOrEmpty(公費受給者番号),
                !RString.isNullOrEmpty(事業者番号_開始) && !RString.isNullOrEmpty(事業者番号_終了),
                !RString.isNullOrEmpty(計画作成事業者番号),
                new RString("1").equals(給付率区分),
                new RString("2").equals(給付率区分),
                new RString("3").equals(給付率区分),
                !RString.isNullOrEmpty(給付率));
    }
}
