/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定データ出力Entityです。
 *
 * @reamsid_L DBE-1610-020 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchijihanteiSumidataIDataShutsuryokuRelateEntity {

    private RString 厚労省IF識別コード;
    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 認定申請年月日;
    private RString 申請区分法令コード;
    private RString 申請区分申請時コード;
    private RString 取下区分コード;
    private RString 被保険者区分コード;
    private RString 申請代行区分コート;
    private RString 生年月日;
    private RString 年齢;
    private RString 性別コード;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
    private RString 施設名;
    private RString 施設住所;
    private RString 前回要介護状態区分コード;
    private RString 前回認定有効期間開始;
    private RString 前回認定有効期間終了;
    private RString 主治医医療機関コード;
    private RString 主治医コード;
    private RString 主治医意見書作成依頼年月日;
    private RString 主治医意見書受領年月日;
    private RString 意見書短期記憶;
    private RString 日常の意思決定を行うための認知能力;
    private RString 自分の意思の伝達能力;
    private RString 食事行為;
    private RString 意見書認知症高齢者自立度;
    private RString 調査依頼日;
    private RString 実施年月日;
    private RString 事業者番号;
    private RString 委託区分;
    private RString 認定調査員コード;
    private RString 調査員資格;
    private RString 一次判定日;
    private RString 一次判定結果;
    private RString 一次判定結果認知症加算;
    private RString 要介護認定等基準時間;
    private RString 要介護認定等基準時間食事;
    private RString 要介護認定等基準時間排泄;
    private RString 要介護認定等基準時間移動;
    private RString 要介護認定等基準時間清潔保持;
    private RString 要介護認定等基準時間間接ケア;
    private RString 要介護認定等基準時間BPSD関連;
    private RString 要介護認定等基準時間機能訓練;
    private RString 要介護認定等基準時間医療関連;
    private RString 要介護認定等基準時間認知症加算;
    private RString 中間評価項目得点第1群;
    private RString 中間評価項目得点第2群;
    private RString 中間評価項目得点第3群;
    private RString 中間評価項目得点第4群;
    private RString 中間評価項目得点第5群;
    private RString 警告コード;
    private RString 状態の安定性;
    private RString 認知症自立度Ⅱ以上の蓋然性;
    private RString 給付区分;
    private RString 審査会資料作成年月日;
    private RString 認定審査会予定年月日;
    private RString 合議体番号;
    private RString 審査会審査順;
    private RString 二次判定年月日;
    private RString 二次判定結果;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString 特定疾病;
    private RString 要介護状態像例コード;
    private RString サービス区分コード;
    private RString 施設利用;
    private RString 障害高齢者自立度日常生活自立度;
    private RString 認知症高齢者自立度日常生活自立度;
    private RString 前回結果障害高齢者自立度日常生活自立度;
    private RString 前回結果認知症高齢者自立度日常生活自立度;
    private RString 前回結果一次判定結果;
    private RString 前回結果一次判定結果認知症加算;
    private RString 前回結果要介護認定等基準時間;
    private RString 前回結果要介護認定等基準時間食事;
    private RString 前回結果要介護認定等基準時間排泄;
    private RString 前回結果要介護認定等基準時間移動;
    private RString 前回結果要介護認定等基準時間清潔保持;
    private RString 前回結果要介護認定等基準時間間接ケア;
    private RString 前回結果要介護認定等基準時間BPSD関連;
    private RString 前回結果要介護認定等基準時間機能訓練;
    private RString 前回結果要介護認定等基準時間医療関連;
    private RString 前回結果要介護認定等基準時間認知症加算;
    private RString 前回結果中間評価項目得点第1群;
    private RString 前回結果中間評価項目得点第2群;
    private RString 前回結果中間評価項目得点第3群;
    private RString 前回結果中間評価項目得点第4群;
    private RString 前回結果中間評価項目得点第5群;
    private RString 前回結果警告コード;
    private RString 前回結果状態の安定性;
    private RString 前回結果認知症自立度Ⅱ以上の蓋然性;
    private RString 前回結果給付区分;
    private RString 前回結果申請日;
    private RString 前回結果二次判定日;
    private RString 前回結果サービス区分コード;
    private RString 前回結果施設利用;
    private RString 予防訪問介護ホームヘルプ;
    private RString 予防訪問入浴介護;
    private RString 予防訪問看護;
    private RString 予防訪問リハビリテーション;
    private RString 予防居宅療養管理指導;
    private RString 予防通所介護デイサービス;
    private RString 予防通所リハビリテーションデイケア;
    private RString 予防短期入所生活介護ショートステイ;
    private RString 予防短期入所療養介護;
    private RString 予防特定施設入居者生活介護;
    private RString 予防福祉用具貸与;
    private RString 予防特定福祉用具販売;
    private RString 予防認知症対応型通所介護;
    private RString 予防小規模多機能型居宅介護;
    private RString 予防認知症対応型共同生活介護グループホーム;
    private RString 住宅改修予防給付;
    private RString 介護訪問介護ホームヘルプ;
    private RString 介護訪問入浴介護;
    private RString 介護訪問看護;
    private RString 介護訪問リハビリテーション;
    private RString 介護居宅療養管理指導;
    private RString 介護通所介護デイサービス;
    private RString 介護通所リハビリテーションデイケア;
    private RString 介護短期入所生活介護ショートステイ;
    private RString 介護短期入所療養介護;
    private RString 介護特定施設入居者生活介護;
    private RString 介護福祉用具貸与;
    private RString 介護特定福祉用具販売;
    private RString 介護夜間対応型訪問介護;
    private RString 介護認知症対応型通所介護;
    private RString 介護小規模多機能型居宅介護;
    private RString 介護認知症対応型共同生活介護グループホーム;
    private RString 介護地域密着型特定施設入居者生活介護;
    private RString 介護地域密着型介護老人福祉施設入所者生活介護;
    private RString 介護定期巡回随時対応型訪問介護看護;
    private RString 介護複合型サービス;
    private RString 住宅改修介護給付;
    private RString 麻痺左上肢;
    private RString 麻痺右上肢;
    private RString 麻痺左下肢;
    private RString 麻痺右下肢;
    private RString 麻痺その他;
    private RString 拘縮肩関節;
    private RString 拘縮股関節;
    private RString 拘縮膝関節;
    private RString 拘縮その他;
    private RString 寝返り;
    private RString 起き上がり;
    private RString 座位保持;
    private RString 両足での立位;
    private RString 歩行;
    private RString 立ち上がり;
    private RString 片足での立位;
    private RString 洗身;
    private RString つめ切り;
    private RString 視力;
    private RString 聴力;
    private RString 移乗;
    private RString 移動;
    private RString えん下;
    private RString 食事摂取;
    private RString 排尿;
    private RString 排便;
    private RString 口腔清潔;
    private RString 洗顔;
    private RString 整髪;
    private RString 上衣の着脱;
    private RString ズボン等の着脱;
    private RString 外出頻度;
    private RString 意思の伝達;
    private RString 毎日の日課を理解;
    private RString 生年月日をいう;
    private RString 短期記憶;
    private RString 自分の名前をいう;
    private RString 今の季節を理解;
    private RString 場所の理解;
    private RString 徘徊;
    private RString 外出して戻れない;
    private RString 被害的;
    private RString 作話;
    private RString 感情が不安定;
    private RString 昼夜逆転;
    private RString 同じ話をする;
    private RString 大声を出す;
    private RString 介護に抵抗;
    private RString 落ち着きなし;
    private RString 一人で出たがる;
    private RString 収集癖;
    private RString 物や衣類を壊す;
    private RString ひどい物忘れ;
    private RString 独り言独り笑い;
    private RString 自分勝手に行動する;
    private RString 話がまとまらない;
    private RString 薬の内服;
    private RString 金銭の管理;
    private RString 日常の意思決定;
    private RString 集団への不適応;
    private RString 買い物;
    private RString 簡単な調理;
    private RString 点滴の管理;
    private RString 中心静脈栄養;
    private RString 透析;
    private RString ストーマの処置;
    private RString 酸素療法;
    private RString レスピレーター;
    private RString 気管切開の処置;
    private RString 疼痛の看護;
    private RString 経管栄養;
    private RString モニター測定;
    private RString じょくそうの処置;
    private RString カテーテル;
    private RString 前回結果麻痺左上肢;
    private RString 前回結果麻痺右上肢;
    private RString 前回結果麻痺左下肢;
    private RString 前回結果麻痺右下肢;
    private RString 前回結果麻痺その他;
    private RString 前回結果拘縮肩関節;
    private RString 前回結果拘縮股関節;
    private RString 前回結果拘縮膝関節;
    private RString 前回結果拘縮その他;
    private RString 前回結果寝返り;
    private RString 前回結果起き上がり;
    private RString 前回結果座位保持;
    private RString 前回結果両足での立位;
    private RString 前回結果歩行;
    private RString 前回結果立ち上がり;
    private RString 前回結果片足での立位;
    private RString 前回結果洗身;
    private RString 前回結果つめ切り;
    private RString 前回結果視力;
    private RString 前回結果聴力;
    private RString 前回結果移乗;
    private RString 前回結果移動;
    private RString 前回結果えん下;
    private RString 前回結果食事摂取;
    private RString 前回結果排尿;
    private RString 前回結果排便;
    private RString 前回結果口腔清潔;
    private RString 前回結果洗顔;
    private RString 前回結果整髪;
    private RString 前回結果上衣の着脱;
    private RString 前回結果ズボン等の着脱;
    private RString 前回結果外出頻度;
    private RString 前回結果意思の伝達;
    private RString 前回結果毎日の日課を理解;
    private RString 前回結果生年月日をいう;
    private RString 前回結果短期記憶;
    private RString 前回結果自分の名前をいう;
    private RString 前回結果今の季節を理解;
    private RString 前回結果場所の理解;
    private RString 前回結果徘徊;
    private RString 前回結果外出して戻れない;
    private RString 前回結果被害的;
    private RString 前回結果作話;
    private RString 前回結果感情が不安定;
    private RString 前回結果昼夜逆転;
    private RString 前回結果同じ話をする;
    private RString 前回結果大声を出す;
    private RString 前回結果介護に抵抗;
    private RString 前回結果落ち着きなし;
    private RString 前回結果一人で出たがる;
    private RString 前回結果収集癖;
    private RString 前回結果物や衣類を壊す;
    private RString 前回結果ひどい物忘れ;
    private RString 前回結果独り言独り笑い;
    private RString 前回結果自分勝手に行動する;
    private RString 前回結果話がまとまらない;
    private RString 前回結果薬の内服;
    private RString 前回結果金銭の管理;
    private RString 前回結果日常の意思決定;
    private RString 前回結果集団への不適応;
    private RString 前回結果買い物;
    private RString 前回結果簡単な調理;
    private RString 前回結果点滴の管理;
    private RString 前回結果中心静脈栄養;
    private RString 前回結果透析;
    private RString 前回結果ストーマの処置;
    private RString 前回結果酸素療法;
    private RString 前回結果レスピレーター;
    private RString 前回結果気管切開の処置;
    private RString 前回結果疼痛の看護;
    private RString 前回結果経管栄養;
    private RString 前回結果モニター測定;
    private RString 前回結果じょくそうの処置;
    private RString 前回結果カテーテル;
    private RString 前回予防訪問介護ホームヘルプ;
    private RString 前回予防訪問入浴介護;
    private RString 前回予防訪問看護;
    private RString 前回予防訪問リハビリテーション;
    private RString 前回予防居宅療養管理指導;
    private RString 前回予防通所介護デイサービス;
    private RString 前回予防通所リハビリテーションデイケア;
    private RString 前回予防短期入所生活介護ショートステイ;
    private RString 前回予防短期入所療養介護;
    private RString 前回予防特定施設入居者生活介護;
    private RString 前回予防福祉用具貸与;
    private RString 前回予防特定福祉用具販売;
    private RString 前回予防認知症対応型通所介護;
    private RString 前回予防小規模多機能型居宅介護;
    private RString 前回予防認知症対応型共同生活介護グループホーム;
    private RString 前回住宅改修予防給付;
    private RString 前回介護訪問介護ホームヘルプ;
    private RString 前回介護訪問入浴介護;
    private RString 前回介護訪問看護;
    private RString 前回介護訪問リハビリテーション;
    private RString 前回介護居宅療養管理指導;
    private RString 前回介護通所介護デイサービス;
    private RString 前回介護通所リハビリテーションデイケア;
    private RString 前回介護短期入所生活介護ショートステイ;
    private RString 前回介護短期入所療養介護;
    private RString 前回介護特定施設入居者生活介護;
    private RString 前回介護福祉用具貸与;
    private RString 前回介護特定福祉用具販売;
    private RString 前回介護夜間対応型訪問介護;
    private RString 前回介護認知症対応型通所介護;
    private RString 前回介護小規模多機能型居宅介護;
    private RString 前回介護認知症対応型共同生活介護グループホーム;
    private RString 前回介護地域密着型特定施設入居者生活介護;
    private RString 前回介護地域密着型介護老人福祉施設入所者生活介護;
    private RString 前回介護定期巡回随時対応型訪問介護看護;
    private RString 前回介護複合型サービス;
    private RString 前回住宅改修介護給付;
    private RString 前回識別コード;
    private RString コメント等;
    private RString 審査会意見;

}
