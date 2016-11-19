/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳バッチ用パラメータクラスです
 *
 * @reamsid_L DBC-3080-030 xuyongchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC140010_JukyushaKyufujissekiDaichoParameter extends BatchParameterBase {

    private static final String KEY_TAISH_YM = "対象年月";
    private static final String KEY_RANGE_YM = "年月範囲_開始";
    private static final String KEY_RANGE_YM_SY = "年月範囲_終了";
    private static final String KEY_HI_HOKENSHA_NO_KS = "被保険者番号_開始";
    private static final String KEY_HI_HOKENSHA_NO_SY = "被保険者番号_終了";
    private static final String KEY_K_JISEKI_KUBUN = "給付実績区分";
    private static final String KEY_SUBETE_SENTAKU = "すべて選択";
    private static final String KEY_YOU_KAIGO1 = "要介護1";
    private static final String KEY_YOU_KAIGO2 = "要介護2";
    private static final String KEY_YOU_KAIGO3 = "要介護3";
    private static final String KEY_YOU_KAIGO4 = "要介護4";
    private static final String KEY_YOU_KAIGO5 = "要介護5";
    private static final String KEY_YOU_SHIEN1 = "要支援1";
    private static final String KEY_YOU_SHIEN2 = "要支援2";
    private static final String KEY_ZIGYOU_TAISHOUSHA = "事業対象者";
    private static final String KEY_KEIKATEKI_YOU_KAIGO = "経過的要介護";
    private static final String KEY_ZIRITU = "自立";
    private static final String KEY_HOMO_TUSHO_HOKA = "訪問通所他";
    private static final String KEY_TAKI_NYUSHO_SEIKATU_KAIGO = "短期入所生活介護";
    private static final String KEY_TAKI_NYUSHO_RS = "短期入所療養介護_老健施設";
    private static final String KEY_TAKI_NYUSHO_IS = "短期入所療養介護_医療施設";
    private static final String KEY_N_T_K_SEIKATU = "認知症対応型共同生活";
    private static final String KEY_T_S_N_S_KAIGO = "特定施設入居者生活介護";
    private static final String KEY_N_T_K_SEIKATU_TAKI = "認知症対応型共同生活_短期";
    private static final String KEY_T_S_N_S_KAIGO_TAKI = "特定施設入居生活介護_短期";
    private static final String KEY_K_K_SHIEN = "居宅介護支援";
    private static final String KEY_K_R_HUKU_SHISETU_ｻｰﾋﾞｽ = "介護老人福祉施設サービス";
    private static final String KEY_K_R_HOKEN_SHISETU_ｻｰﾋﾞｽ = "介護老人保健施設サービス";
    private static final String KEY_K_R_I_SHISETU_ｻｰﾋﾞｽ = "介護療養型医療施設サービス";
    private static final String KEY_T_H_Y_HANBAIHI = "特定福祉用具販売費";
    private static final String KEY_J_KAISHUHI = "住宅改修費";
    private static final String KEY_K_KAIGO_ｻｰﾋﾞｽ_HI = "高額介護サービス費";
    private static final String KEY_Y_H_TUSHO_HOKA = "予防訪問通所他";
    private static final String KEY_Y_T_N_S_KAIGO = "予防短期入所生活介護";
    private static final String KEY_Y_T_N_R_KAIGO_RKS = "予防短期入所療養介護_老健施設";
    private static final String KEY_Y_T_N_R_KAIGO_IYS = "予防短期入所療養介護_医療施設";
    private static final String KEY_Y_N_T_K_SEIKATU = "予防認知症対応型共同生活";
    private static final String KEY_Y_T_S_N_S_KAIGO = "予防特定施設入居者生活介護";
    private static final String KEY_Y_N_T_K_SEIKATU_TANKI = "予防認知症対応型共同生活_短期";
    private static final String KEY_YONOU_SHIEN = "予防支援";
    private static final String KEY_Y_T_H_Y_HANBAI_HI = "予防特定福祉用具販売費";
    private static final String KEY_Y_J_KAISHUHI = "予防住宅改修費";
    private static final String KEY_K_Y_S_S_KEIKA = "介護予防_生活支援_経過";
    private static final String KEY_K_S_K_ﾏﾈｼﾞﾒﾝﾄ = "経過措置ケアマネジメント";
    private static final String KEY_K_Y_S_S_S_ZIGYOU = "介護予防_生活支援総合事業";
    private static final String KEY_S_Z_KEA_ﾏﾈｼﾞﾒﾝﾄ = "総合事業ケアマネジメント";
    private static final String KEY_K_T_UMU = "旧措置特定有無";
    private static final String KEY_R_H_S_NO_UMU = "老人保健市町村番号有無";
    private static final String KEY_R_H_S_NO_YU_KAISHI = "老人保健市町村番号有_開始";
    private static final String KEY_R_H_S_NO_YU_SHURYOU = "老人保健市町村番号有_終了";
    private static final String KEY_R_H_J_NO_UMU = "老人保健受給者番号有無";
    private static final String KEY_R_H_J_NO_YU_KAISHI = "老人保健受給者番号有_開始";
    private static final String KEY_R_H_J_NO_YU_SHURYOU = "老人保健受給者番号有_終了";
    private static final String KEY_K_HUTANSHA_NO = "公費負担者番号";
    private static final String KEY_K_JUKYUSHA_NO = "公費受給者番号";
    private static final String KEY_Z_NO_KAISHI = "事業者番号_開始";
    private static final String KEY_Z_NO_SHURYOU = "事業者番号_終了";
    private static final String KEY_K_S_ZIGYOUSHA_NO = "計画作成事業者番号";
    private static final String KEY_K_RITU_KUBUN = "給付率区分";
    private static final String KEY_KYUHU_RITU = "給付率";
    private static final String KEY_SHUTURYOKU_JUN_ID = "出力順ID";

    @BatchParameter(key = KEY_TAISH_YM, name = "対象年月")
    private RString 対象年月;
    @BatchParameter(key = KEY_RANGE_YM, name = "年月範囲_開始")
    private RString 年月範囲_開始;
    @BatchParameter(key = KEY_RANGE_YM_SY, name = "年月範囲_終了")
    private RString 年月範囲_終了;
    @BatchParameter(key = KEY_HI_HOKENSHA_NO_KS, name = "被保険者番号_開始")
    private RString 被保険者番号_開始;
    @BatchParameter(key = KEY_HI_HOKENSHA_NO_SY, name = "被保険者番号_終了")
    private RString 被保険者番号_終了;
    @BatchParameter(key = KEY_K_JISEKI_KUBUN, name = "給付実績区分")
    private RString 給付実績区分;
    @BatchParameter(key = KEY_SUBETE_SENTAKU, name = "すべて選択")
    private RString すべて選択;
    @BatchParameter(key = KEY_YOU_KAIGO1, name = "要介護1")
    private RString 要介護1;
    @BatchParameter(key = KEY_YOU_KAIGO2, name = "要介護2")
    private RString 要介護2;
    @BatchParameter(key = KEY_YOU_KAIGO3, name = "要介護3")
    private RString 要介護3;
    @BatchParameter(key = KEY_YOU_KAIGO4, name = "要介護4")
    private RString 要介護4;
    @BatchParameter(key = KEY_YOU_KAIGO5, name = "要介護5")
    private RString 要介護5;
    @BatchParameter(key = KEY_YOU_SHIEN1, name = "要支援1")
    private RString 要支援1;
    @BatchParameter(key = KEY_YOU_SHIEN2, name = "要支援2")
    private RString 要支援2;
    @BatchParameter(key = KEY_ZIGYOU_TAISHOUSHA, name = "事業対象者")
    private RString 事業対象者;
    @BatchParameter(key = KEY_KEIKATEKI_YOU_KAIGO, name = "経過的要介護")
    private RString 経過的要介護;
    @BatchParameter(key = KEY_ZIRITU, name = "自立")
    private RString 自立;
    @BatchParameter(key = KEY_HOMO_TUSHO_HOKA, name = "訪問通所他")
    private RString 訪問通所他;
    @BatchParameter(key = KEY_TAKI_NYUSHO_SEIKATU_KAIGO, name = "短期入所生活介護")
    private RString 短期入所生活介護;
    @BatchParameter(key = KEY_TAKI_NYUSHO_RS, name = "短期入所療養介護_老健施設")
    private RString 短期入所療養介護_老健施設;
    @BatchParameter(key = KEY_TAKI_NYUSHO_IS, name = "短期入所療養介護_医療施設")
    private RString 短期入所療養介護_医療施設;
    @BatchParameter(key = KEY_N_T_K_SEIKATU, name = "認知症対応型共同生活")
    private RString 認知症対応型共同生活;
    @BatchParameter(key = KEY_T_S_N_S_KAIGO, name = "特定施設入居者生活介護")
    private RString 特定施設入居者生活介護;
    @BatchParameter(key = KEY_N_T_K_SEIKATU_TAKI, name = "認知症対応型共同生活_短期")
    private RString 認知症対応型共同生活_短期;
    @BatchParameter(key = KEY_T_S_N_S_KAIGO_TAKI, name = "特定施設入居生活介護_短期")
    private RString 特定施設入居生活介護_短期;
    @BatchParameter(key = KEY_K_K_SHIEN, name = "居宅介護支援")
    private RString 居宅介護支援;
    @BatchParameter(key = KEY_K_R_HUKU_SHISETU_ｻｰﾋﾞｽ, name = "介護老人福祉施設サービス")
    private RString 介護老人福祉施設サービス;
    @BatchParameter(key = KEY_K_R_HOKEN_SHISETU_ｻｰﾋﾞｽ, name = "介護老人保健施設サービス")
    private RString 介護老人保健施設サービス;
    @BatchParameter(key = KEY_K_R_I_SHISETU_ｻｰﾋﾞｽ, name = "介護療養型医療施設サービス")
    private RString 介護療養型医療施設サービス;
    @BatchParameter(key = KEY_T_H_Y_HANBAIHI, name = "特定福祉用具販売費")
    private RString 特定福祉用具販売費;
    @BatchParameter(key = KEY_J_KAISHUHI, name = "住宅改修費")
    private RString 住宅改修費;
    @BatchParameter(key = KEY_K_KAIGO_ｻｰﾋﾞｽ_HI, name = "高額介護サービス費")
    private RString 高額介護サービス費;
    @BatchParameter(key = KEY_Y_H_TUSHO_HOKA, name = "予防訪問通所他")
    private RString 予防訪問通所他;
    @BatchParameter(key = KEY_Y_T_N_S_KAIGO, name = "予防短期入所生活介護")
    private RString 予防短期入所生活介護;
    @BatchParameter(key = KEY_Y_T_N_R_KAIGO_RKS, name = "予防短期入所療養介護_老健施設")
    private RString 予防短期入所療養介護_老健施設;
    @BatchParameter(key = KEY_Y_T_N_R_KAIGO_IYS, name = "予防短期入所療養介護_医療施設")
    private RString 予防短期入所療養介護_医療施設;
    @BatchParameter(key = KEY_Y_N_T_K_SEIKATU, name = "予防認知症対応型共同生活")
    private RString 予防認知症対応型共同生活;
    @BatchParameter(key = KEY_Y_T_S_N_S_KAIGO, name = "予防特定施設入居者生活介護")
    private RString 予防特定施設入居者生活介護;
    @BatchParameter(key = KEY_Y_N_T_K_SEIKATU_TANKI, name = "予防認知症対応型共同生活_短期")
    private RString 予防認知症対応型共同生活_短期;
    @BatchParameter(key = KEY_YONOU_SHIEN, name = "予防支援")
    private RString 予防支援;
    @BatchParameter(key = KEY_Y_T_H_Y_HANBAI_HI, name = "予防特定福祉用具販売費")
    private RString 予防特定福祉用具販売費;
    @BatchParameter(key = KEY_Y_J_KAISHUHI, name = "予防住宅改修費")
    private RString 予防住宅改修費;
    @BatchParameter(key = KEY_K_Y_S_S_KEIKA, name = "介護予防_生活支援_経過")
    private RString 介護予防_生活支援_経過;
    @BatchParameter(key = KEY_K_S_K_ﾏﾈｼﾞﾒﾝﾄ, name = "経過措置ケアマネジメント")
    private RString 経過措置ケアマネジメント;
    @BatchParameter(key = KEY_K_Y_S_S_S_ZIGYOU, name = "介護予防_生活支援総合事業")
    private RString 介護予防_生活支援総合事業;
    @BatchParameter(key = KEY_S_Z_KEA_ﾏﾈｼﾞﾒﾝﾄ, name = "総合事業ケアマネジメント")
    private RString 総合事業ケアマネジメント;
    @BatchParameter(key = KEY_K_T_UMU, name = "旧措置特定有無")
    private RString 旧措置特定有無;
    @BatchParameter(key = KEY_R_H_S_NO_UMU, name = "老人保健市町村番号有無")
    private RString 老人保健市町村番号有無;
    @BatchParameter(key = KEY_R_H_S_NO_YU_KAISHI, name = "老人保健市町村番号有_開始")
    private RString 老人保健市町村番号有_開始;
    @BatchParameter(key = KEY_R_H_S_NO_YU_SHURYOU, name = "老人保健市町村番号有_終了")
    private RString 老人保健市町村番号有_終了;
    @BatchParameter(key = KEY_R_H_J_NO_UMU, name = "老人保健受給者番号有無")
    private RString 老人保健受給者番号有無;
    @BatchParameter(key = KEY_R_H_J_NO_YU_KAISHI, name = "老人保健受給者番号有_開始")
    private RString 老人保健受給者番号有_開始;
    @BatchParameter(key = KEY_R_H_J_NO_YU_SHURYOU, name = "老人保健受給者番号有_終了")
    private RString 老人保健受給者番号有_終了;
    @BatchParameter(key = KEY_K_HUTANSHA_NO, name = "公費負担者番号")
    private RString 公費負担者番号;
    @BatchParameter(key = KEY_K_JUKYUSHA_NO, name = "公費受給者番号")
    private RString 公費受給者番号;
    @BatchParameter(key = KEY_Z_NO_KAISHI, name = "事業者番号_開始")
    private RString 事業者番号_開始;
    @BatchParameter(key = KEY_Z_NO_SHURYOU, name = "事業者番号_終了")
    private RString 事業者番号_終了;
    @BatchParameter(key = KEY_K_S_ZIGYOUSHA_NO, name = "計画作成事業者番号")
    private RString 計画作成事業者番号;
    @BatchParameter(key = KEY_K_RITU_KUBUN, name = "給付率区分")
    private RString 給付率区分;
    @BatchParameter(key = KEY_KYUHU_RITU, name = "給付率")
    private RString 給付率;
    @BatchParameter(key = KEY_SHUTURYOKU_JUN_ID, name = "出力順ID")
    private long 出力順ID;

    /**
     * コンストラクタです。
     */
    public DBC140010_JukyushaKyufujissekiDaichoParameter() {
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
     */
    public DBC140010_JukyushaKyufujissekiDaichoParameter(RString 対象年月,
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
     * processのパラメータを生成します。
     *
     * @return JukyushaKyufujissekiDaichoProcessParameter
     */
    public JukyushaKyufujissekiDaichoProcessParameter toJukyushaKyufujissekiDaichoProcessParameter() {
        return new JukyushaKyufujissekiDaichoProcessParameter(対象年月,
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
                公費負担者番号, 公費受給者番号,
                事業者番号_開始,
                事業者番号_終了,
                計画作成事業者番号,
                給付率区分,
                給付率,
                出力順ID);
    }

}
