/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請情報ファイルEntity(厚労省)です。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiJohoKouroushouCsvEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 5, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 6, name = "認定申請日")
    private RString 認定申請日;
    @CsvField(order = 7, name = "主キー補助項目")
    private RString 主キー補助項目;
    @CsvField(order = 8, name = "申請区分(法令)コード")
    private RString 申請区分コード_法令;
    @CsvField(order = 9, name = "申請区分(申請時)コード")
    private RString 申請区分コード_申請時;
    @CsvField(order = 10, name = "取下区分コード")
    private RString 取下区分コード;
    @CsvField(order = 11, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 12, name = "申請代行区分コード")
    private RString 申請代行区分コード;
    @CsvField(order = 13, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 14, name = "年齢")
    private RString 年齢;
    @CsvField(order = 15, name = "性別")
    private RString 性別;
    @CsvField(order = 16, name = "氏名(カナ)")
    private RString 氏名_カナ;
    @CsvField(order = 17, name = "氏名")
    private RString 氏名;
    @CsvField(order = 18, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 19, name = "住所")
    private RString 住所;
    @CsvField(order = 20, name = "本人連絡先1")
    private RString 本人連絡先1;
    @CsvField(order = 21, name = "病院･施設等の名称")
    private RString 病院_施設等の名称;
    @CsvField(order = 22, name = "病院･施設等の住所")
    private RString 病院_施設等の住所;
    @CsvField(order = 23, name = "前回の審査会結果")
    private RString 前回の審査会結果;
    @CsvField(order = 24, name = "前回の認定有効開始期間")
    private RString 前回の認定有効開始期間;
    @CsvField(order = 25, name = "前回の認定有効終了期間")
    private RString 前回の認定有効終了期間;
    @CsvField(order = 26, name = "主治医医療機関コード")
    private RString 主治医医療機関コード;
    @CsvField(order = 27, name = "主治医番号")
    private RString 主治医番号;
    @CsvField(order = 28, name = "意見書依頼日")
    private RString 意見書依頼日;
    @CsvField(order = 29, name = "意見書入手日")
    private RString 意見書入手日;
    @CsvField(order = 30, name = "意見書短期記憶")
    private RString 意見書短期記憶;
    @CsvField(order = 31, name = "意見書認知能力")
    private RString 意見書認知能力;
    @CsvField(order = 32, name = "意見書伝達能力")
    private RString 意見書伝達能力;
    @CsvField(order = 33, name = "意見書食事")
    private RString 意見書食事;
    @CsvField(order = 34, name = "認知症高齢者の日常生活自立度")
    private RString 日常生活自立度;
    @CsvField(order = 35, name = "前回結果 麻痺(左-上肢)")
    private RString 麻痺_左_上肢;
    @CsvField(order = 36, name = "前回結果 麻痺(右-上肢)")
    private RString 麻痺_右_上肢;
    @CsvField(order = 37, name = "前回結果 麻痺(左-下肢)")
    private RString 麻痺_左_下肢;
    @CsvField(order = 38, name = "前回結果 麻痺(右-下肢)")
    private RString 麻痺_右_下肢;
    @CsvField(order = 39, name = "前回結果 麻痺(その他)")
    private RString 麻痺_その他;
    @CsvField(order = 40, name = "前回結果 拘縮(肩関節)")
    private RString 拘縮_肩関節;
    @CsvField(order = 41, name = "前回結果 拘縮(股関節)")
    private RString 拘縮_股関節;
    @CsvField(order = 42, name = "前回結果 拘縮(膝関節)")
    private RString 拘縮_膝関節;
    @CsvField(order = 43, name = "前回結果 拘縮(その他)")
    private RString 拘縮_その他;
    @CsvField(order = 44, name = "前回結果 寝返り")
    private RString 寝返り;
    @CsvField(order = 45, name = "前回結果 起き上がり")
    private RString 起き上がり;
    @CsvField(order = 46, name = "前回結果 座位保持")
    private RString 座位保持;
    @CsvField(order = 47, name = "前回結果 両足での立位")
    private RString 両足での立位;
    @CsvField(order = 48, name = "前回結果 歩行")
    private RString 歩行;
    @CsvField(order = 49, name = "前回結果 立ち上がり")
    private RString 立ち上がり;
    @CsvField(order = 50, name = "前回結果 片足での立位")
    private RString 片足での立位;
    @CsvField(order = 51, name = "前回結果 洗身")
    private RString 洗身;
    @CsvField(order = 52, name = "前回結果 つめ切り")
    private RString つめ切り;
    @CsvField(order = 53, name = "前回結果 視力")
    private RString 視力;
    @CsvField(order = 54, name = "前回結果 聴力")
    private RString 聴力;
    @CsvField(order = 55, name = "前回結果 移乗")
    private RString 移乗;
    @CsvField(order = 56, name = "前回結果 移動")
    private RString 移動;
    @CsvField(order = 57, name = "前回結果 えん下")
    private RString えん下;
    @CsvField(order = 58, name = "前回結果 食事摂取")
    private RString 食事摂取;
    @CsvField(order = 59, name = "前回結果 排尿")
    private RString 排尿;
    @CsvField(order = 60, name = "前回結果 排便")
    private RString 排便;
    @CsvField(order = 61, name = "前回結果 口腔清潔")
    private RString 口腔清潔;
    @CsvField(order = 62, name = "前回結果 洗顔")
    private RString 洗顔;
    @CsvField(order = 63, name = "前回結果 整髪")
    private RString 整髪;
    @CsvField(order = 64, name = "前回結果 上衣の着脱")
    private RString 上衣の着脱;
    @CsvField(order = 65, name = "前回結果 ズボン等の着脱")
    private RString ズボン等の着脱;
    @CsvField(order = 66, name = "前回結果 外出頻度")
    private RString 外出頻度;
    @CsvField(order = 67, name = "前回結果 意思の伝達")
    private RString 意思の伝達;
    @CsvField(order = 68, name = "前回結果 毎日の日課を理解")
    private RString 毎日の日課を理解;
    @CsvField(order = 69, name = "前回結果 生年月日をいう")
    private RString 生年月日をいう;
    @CsvField(order = 70, name = "前回結果 短期記憶")
    private RString 短期記憶;
    @CsvField(order = 71, name = "前回結果 自分の名前をいう")
    private RString 自分の名前をいう;
    @CsvField(order = 72, name = "前回結果 今の季節を理解")
    private RString 今の季節を理解;
    @CsvField(order = 73, name = "前回結果 場所の理解")
    private RString 場所の理解;
    @CsvField(order = 74, name = "前回結果 常時の徘徊")
    private RString 常時の徘徊;
    @CsvField(order = 75, name = "前回結果 外出して戻れない")
    private RString 外出して戻れない;
    @CsvField(order = 76, name = "前回結果 被害的")
    private RString 被害的;
    @CsvField(order = 77, name = "前回結果 作話")
    private RString 作話;
    @CsvField(order = 78, name = "前回結果 感情が不安定")
    private RString 感情が不安定;
    @CsvField(order = 79, name = "前回結果 昼夜逆転")
    private RString 昼夜逆転;
    @CsvField(order = 80, name = "前回結果 同じ話をする")
    private RString 同じ話をする;
    @CsvField(order = 81, name = "前回結果 大声をだす")
    private RString 大声をだす;
    @CsvField(order = 82, name = "前回結果 介護に抵抗")
    private RString 介護に抵抗;
    @CsvField(order = 83, name = "前回結果 落ち着きなし")
    private RString 落ち着きなし;
    @CsvField(order = 84, name = "前回結果 一人で出たがる")
    private RString 一人で出たがる;
    @CsvField(order = 85, name = "前回結果 収集癖")
    private RString 収集癖;
    @CsvField(order = 86, name = "前回結果 物や衣類を壊す")
    private RString 物や衣類を壊す;
    @CsvField(order = 87, name = "前回結果 ひどい物忘れ")
    private RString ひどい物忘れ;
    @CsvField(order = 88, name = "前回結果 独り言･独り笑い")
    private RString 独り言_独り笑い;
    @CsvField(order = 89, name = "前回結果 自分勝手に行動する")
    private RString 自分勝手に行動する;
    @CsvField(order = 90, name = "前回結果 話がまとまらない")
    private RString 話がまとまらない;
    @CsvField(order = 91, name = "前回結果 薬の内服")
    private RString 薬の内服;
    @CsvField(order = 92, name = "前回結果 金銭の管理")
    private RString 金銭の管理;
    @CsvField(order = 93, name = "前回結果 日常の意思決定")
    private RString 日常の意思決定;
    @CsvField(order = 94, name = "前回結果 集団への不適応")
    private RString 集団への不適応;
    @CsvField(order = 95, name = "前回結果 買い物")
    private RString 買い物;
    @CsvField(order = 96, name = "前回結果 簡単な調理")
    private RString 簡単な調理;
    @CsvField(order = 97, name = "前回結果 点滴管理")
    private RString 点滴管理;
    @CsvField(order = 98, name = "前回結果 中心静脈栄養")
    private RString 中心静脈栄養;
    @CsvField(order = 99, name = "前回結果 透析")
    private RString 透析;
    @CsvField(order = 100, name = "前回結果 ストーマの処置")
    private RString ストーマの処置;
    @CsvField(order = 101, name = "前回結果 酸素療法")
    private RString 酸素療法;
    @CsvField(order = 102, name = "前回結果 レスピレーター")
    private RString レスピレーター;
    @CsvField(order = 103, name = "前回結果 気管切開の処置")
    private RString 気管切開の処置;
    @CsvField(order = 104, name = "前回結果 疼痛の看護")
    private RString 疼痛の看護;
    @CsvField(order = 105, name = "前回結果 経管栄養")
    private RString 経管栄養;
    @CsvField(order = 106, name = "前回結果 モニター測定")
    private RString モニター測定;
    @CsvField(order = 107, name = "前回結果 じょくそうの処置")
    private RString じょくそうの処置;
    @CsvField(order = 108, name = "前回結果 カテーテル")
    private RString カテーテル;
    @CsvField(order = 109, name = "前回結果 障害高齢者自立度")
    private RString 障害高齢者自立度;
    @CsvField(order = 110, name = "前回結果 認知症高齢者自立度")
    private RString 認知症高齢者自立度;
    @CsvField(order = 111, name = "前回結果 一次判定結果")
    private RString 一次判定結果;
    @CsvField(order = 112, name = "前回結果 一次判定結果(認知症加算)")
    private RString 一次判定結果_認知症加算;
    @CsvField(order = 113, name = "前回結果 要介護認定等基準時間")
    private RString 基準時間;
    @CsvField(order = 114, name = "前回結果 要介護認定等基準時間(食事)")
    private RString 基準時間_食事;
    @CsvField(order = 115, name = "前回結果 要介護認定等基準時間(排泄)")
    private RString 基準時間_排泄;
    @CsvField(order = 116, name = "前回結果 要介護認定等基準時間(移動)")
    private RString 基準時間_移動;
    @CsvField(order = 117, name = "前回結果 要介護認定等基準時間(清潔保持)")
    private RString 基準時間_清潔保持;
    @CsvField(order = 118, name = "前回結果 要介護認定等基準時間(間接ケア)")
    private RString 基準時間_間接ケア;
    @CsvField(order = 119, name = "前回結果 要介護認定等基準時間(BPSD 関連)")
    private RString 基準時間_BPSD_関連;
    @CsvField(order = 120, name = "前回結果 要介護認定等基準時間(機能訓練)")
    private RString 基準時間_機能訓練;
    @CsvField(order = 121, name = "前回結果 要介護認定等基準時間(医療関連)")
    private RString 基準時間_医療関連;
    @CsvField(order = 122, name = "前回結果 要介護認定等基準時間(認知症加算)")
    private RString 基準時間_認知症加算;
    @CsvField(order = 123, name = "前回結果 中間評価項目得点 第1群")
    private RString 中間評価項目得点_第1群;
    @CsvField(order = 124, name = "前回結果 中間評価項目得点 第2群")
    private RString 中間評価項目得点_第2群;
    @CsvField(order = 125, name = "前回結果 中間評価項目得点 第3群")
    private RString 中間評価項目得点_第3群;
    @CsvField(order = 126, name = "前回結果 中間評価項目得点 第4群")
    private RString 中間評価項目得点_第4群;
    @CsvField(order = 127, name = "前回結果 中間評価項目得点 第5群")
    private RString 中間評価項目得点_第5群;
    @CsvField(order = 128, name = "前回結果 一次判定警告コード")
    private RString 一次判定警告コード;
    @CsvField(order = 129, name = "前回結果 状態の安定性")
    private RString 状態の安定性;
    @CsvField(order = 130, name = "前回結果 認知症自立度Ⅱ以上の蓋然性")
    private RString 認知症自立度Ⅱ以上の蓋然性;
    @CsvField(order = 131, name = "前回結果 認知機能及び状態安定性から推定される給付区分")
    private RString 認知機能及び状態安定性から推定される給付区分;
    @CsvField(order = 132, name = "前回結果 申請日")
    private RString 申請日;
    @CsvField(order = 133, name = "前回結果 二次判定日")
    private RString 二次判定日;
    @CsvField(order = 134, name = "前回結果 現在のサービス区分コード")
    private RString 現在のサービス区分コード;
    @CsvField(order = 135, name = "前回結果 現在の状況")
    private RString 現在の状況;
    @CsvField(order = 136, name = "前回結果 訪問介護(ホームヘルプサービス)")
    private RString 訪問介護_ホームヘルプサービス;
    @CsvField(order = 137, name = "前回結果 訪問入浴介護")
    private RString 訪問入浴介護;
    @CsvField(order = 138, name = "前回結果 訪問看護")
    private RString 訪問看護;
    @CsvField(order = 139, name = "前回結果 訪問リハビリテーション")
    private RString 訪問リハビリテーション;
    @CsvField(order = 140, name = "前回結果 居宅療養管理指導")
    private RString 居宅療養管理指導;
    @CsvField(order = 141, name = "前回結果 通所介護(デイサービス)")
    private RString 通所介護_デイサービス;
    @CsvField(order = 142, name = "前回結果 通所リハビリテーション")
    private RString 通所リハビリテーション;
    @CsvField(order = 143, name = "前回結果 短期入所生活介護(ショートステイ)")
    private RString 短期入所生活介護_ショートステイ;
    @CsvField(order = 144, name = "前回結果 短期入所療養介護")
    private RString 短期入所療養介護;
    @CsvField(order = 145, name = "前回結果 特定施設入居者生活介護")
    private RString 特定施設入居者生活介護;
    @CsvField(order = 146, name = "前回結果 福祉用具貸与")
    private RString 福祉用具貸与;
    @CsvField(order = 147, name = "前回結果 特定福祉用具販売")
    private RString 特定福祉用具販売;
    @CsvField(order = 148, name = "前回結果 住宅改修(介護給付)")
    private RString 住宅改修_介護給付;
    @CsvField(order = 149, name = "前回結果 夜間対応型訪問介護")
    private RString 夜間対応型訪問介護;
    @CsvField(order = 150, name = "前回結果 認知症対応型通所介護")
    private RString 認知症対応型通所介護;
    @CsvField(order = 151, name = "前回結果 小規模多機能型居宅介護")
    private RString 小規模多機能型居宅介護;
    @CsvField(order = 152, name = "前回結果 認知症対応型共同生活介護(グループホーム)")
    private RString 認知症対応型共同生活介護_グループホーム;
    @CsvField(order = 153, name = "前回結果 地域密着型特定施設入居者生活介護")
    private RString 地域密着型特定施設入居者生活介護;
    @CsvField(order = 154, name = "前回結果 地域密着型介護老人福祉施設入所者生活介護")
    private RString 地域密着型介護老人福祉施設入所者生活介護;
    @CsvField(order = 155, name = "前回結果 定期巡回･随時対応型訪問介護看護")
    private RString 定期巡回_随時対応型訪問介護看護;
    @CsvField(order = 156, name = "前回結果 複合型サービス")
    private RString 複合型サービス;
    @CsvField(order = 157, name = "前回結果 介護予防訪問介護(ホームヘルプサービス)")
    private RString 介護予防訪問介護_ホームヘルプサービス;
    @CsvField(order = 158, name = "前回結果 介護予防訪問入浴介護")
    private RString 介護予防訪問入浴介護;
    @CsvField(order = 159, name = "前回結果 介護予防訪問看護")
    private RString 介護予防訪問看護;
    @CsvField(order = 160, name = "前回結果 介護予防訪問リハビリテーション")
    private RString 介護予防訪問リハビリテーション;
    @CsvField(order = 161, name = "前回結果 介護予防居宅療養管理指導")
    private RString 介護予防居宅療養管理指導;
    @CsvField(order = 162, name = "前回結果 介護予防通所介護(デイサービス)")
    private RString 介護予防通所介護_デイサービス;
    @CsvField(order = 163, name = "前回結果 介護予防通所リハビリテーション")
    private RString 介護予防通所リハビリテーション;
    @CsvField(order = 164, name = "前回結果 介護予防短期入所生活介護(ショートステイ)")
    private RString 介護予防短期入所生活介護_ショートステイ;
    @CsvField(order = 165, name = "前回結果 介護予防短期入所療養介護")
    private RString 介護予防短期入所療養介護;
    @CsvField(order = 166, name = "前回結果 介護予防特定施設入居者生活介護")
    private RString 介護予防特定施設入居者生活介護;
    @CsvField(order = 167, name = "前回結果 介護予防福祉用具貸与")
    private RString 介護予防福祉用具貸与;
    @CsvField(order = 168, name = "前回結果 特定介護予防福祉用具販売")
    private RString 特定介護予防福祉用具販売;
    @CsvField(order = 169, name = "前回結果 住宅改修(予防給付)")
    private RString 住宅改修_予防給付;
    @CsvField(order = 170, name = "前回結果 介護予防認知症対応型通所介護")
    private RString 介護予防認知症対応型通所介護;
    @CsvField(order = 171, name = "前回結果 介護予防小規模多機能型居宅介護")
    private RString 介護予防小規模多機能型居宅介護;
    @CsvField(order = 172, name = "前回結果 介護予防認知症対応型共同生活介護(グループホーム)")
    private RString 介護予防認知症対応型共同生活介護_グループホーム;
    @CsvField(order = 173, name = "前回識別コード")
    private RString 前回識別コード;
    @CsvField(order = 174, name = "コメント等")
    private RString コメント等;
    private int 項目数;
}
