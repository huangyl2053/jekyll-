/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ出力CSVEntityクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterTransmissionCsvEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード ")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 5, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 6, name = "認定申請日")
    private RString 認定申請日;
    @CsvField(order = 7, name = "枝番")
    private RString 枝番;
    @CsvField(order = 8, name = "申請区分法令コード")
    private RString 申請区分法令コード;
    @CsvField(order = 9, name = "申請区分申請時コード")
    private RString 申請区分申請時コード;
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
    @CsvField(order = 15, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 16, name = "被保険者ｶﾅ氏名")
    private RString 被保険者ｶﾅ氏名;
    @CsvField(order = 17, name = "被保険者漢字氏名")
    private RString 被保険者漢字氏名;
    @CsvField(order = 18, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 19, name = "住所")
    private RString 住所;
    @CsvField(order = 20, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 21, name = "病院施設等の名称")
    private RString 病院施設等の名称;
    @CsvField(order = 22, name = "病院施設等の所在地")
    private RString 病院施設等の所在地;
    @CsvField(order = 23, name = "前回の認定審査会結果")
    private RString 前回の認定審査会結果;
    @CsvField(order = 24, name = "前回の認定有効期間開始")
    private RString 前回の認定有効期間開始;
    @CsvField(order = 25, name = "前回の認定有効期間終了")
    private RString 前回の認定有効期間終了;
    @CsvField(order = 26, name = "主治医医療機関番号")
    private RString 主治医医療機関番号;
    @CsvField(order = 27, name = "主治医番号")
    private RString 主治医番号;
    @CsvField(order = 28, name = "意見書依頼日")
    private RString 意見書依頼日;
    @CsvField(order = 29, name = "意見書入手日")
    private RString 意見書入手日;
    @CsvField(order = 30, name = "意見書短期記憶")
    private RString 意見書短期記憶;
    @CsvField(order = 31, name = "意見書「認知能力」")
    private RString 意見書認知能力;
    @CsvField(order = 32, name = "意見書「伝達能力」")
    private RString 意見書伝達能力;
    @CsvField(order = 33, name = "意見書「食事行為」")
    private RString 意見書食事行為;
    @CsvField(order = 34, name = "意見書「認知症高齢者の日常生活自立度」")
    private RString 意見書認知症高齢者の日常生活自立度;
    @CsvField(order = 35, name = "調査依頼日")
    private RString 調査依頼日;
    @CsvField(order = 36, name = "調査実施日")
    private RString 調査実施日;
    @CsvField(order = 37, name = "指定居宅介護支援事業者等番号")
    private RString 指定居宅介護支援事業者等番号;
    @CsvField(order = 38, name = "委託区分")
    private RString 委託区分;
    @CsvField(order = 39, name = "認定調査員番号")
    private RString 認定調査員番号;
    @CsvField(order = 40, name = "認定調査員資格コード")
    private RString 認定調査員資格コード;
    @CsvField(order = 41, name = "一次判定日")
    private RString 一次判定日;
    @CsvField(order = 42, name = "一次判定結果")
    private RString 一次判定結果;
    @CsvField(order = 43, name = "一次判定結果（認知症加算）")
    private RString 一次判定結果認知症加算;
    @CsvField(order = 44, name = "要介護認定等基準時間")
    private RString 要介護認定等基準時間;
    @CsvField(order = 45, name = "要介護認定等基準時間(食事)")
    private RString 要介護認定等基準時間食事;
    @CsvField(order = 46, name = "要介護認定等基準時間(排泄)")
    private RString 要介護認定等基準時間排泄;
    @CsvField(order = 47, name = "要介護認定等基準時間(移動)")
    private RString 要介護認定等基準時間移動;
    @CsvField(order = 48, name = "要介護認定等基準時間(清潔保持)(間接ケア)")
    private RString 要介護認定等基準時間清潔保持;
    @CsvField(order = 49, name = "要介護認定等基準時間(間接ケア)")
    private RString 要介護認定等基準時間間接ケア;
    @CsvField(order = 50, name = "要介護認定等基準時間BPSD関連")
    private RString 要介護認定等基準時間BPSD関連;
    @CsvField(order = 51, name = "要介護認定等基準時間(機能訓練)")
    private RString 要介護認定等基準時間機能訓練;
    @CsvField(order = 52, name = "要介護認定等基準時間(医療関連)")
    private RString 要介護認定等基準時間医療関連;
    @CsvField(order = 53, name = "要介護認定等基準時間(認知症加算)")
    private RString 要介護認定等基準時間認知症加算;
    @CsvField(order = 54, name = "中間評価項目得点第１群")
    private RString 中間評価項目得点第１群;
    @CsvField(order = 55, name = "中間評価項目得点第２群")
    private RString 中間評価項目得点第２群;
    @CsvField(order = 56, name = "中間評価項目得点 第３群")
    private RString 中間評価項目得点第３群;
    @CsvField(order = 57, name = "中間評価項目得点 第４群")
    private RString 中間評価項目得点第４群;
    @CsvField(order = 58, name = "中間評価項目得点 第５群")
    private RString 中間評価項目得点第５群;
    @CsvField(order = 59, name = "一次判定警告（配列）コード")
    private RString 一次判定警告配列コード;
    @CsvField(order = 60, name = "状態の安定性")
    private RString 状態の安定性;
    @CsvField(order = 61, name = "認知症自立度Ⅱ以上の蓋然性")
    private RString 認知症自立度Ⅱ以上の蓋然性;
    @CsvField(order = 62, name = "認知機能及び状態安定性から推定される給付区分")
    private RString 認知機能及び状態安定性から推定される給付区分;
    @CsvField(order = 63, name = "認定審査会資料作成日")
    private RString 認定審査会資料作成日;
    @CsvField(order = 64, name = "認定審査会予定日")
    private RString 認定審査会予定日;
    @CsvField(order = 65, name = "合議体番号")
    private RString 合議体番号;
    @CsvField(order = 66, name = "審査会資料番号")
    private RString 審査会資料番号;
    @CsvField(order = 67, name = "二次判定日")
    private RString 二次判定日;
    @CsvField(order = 68, name = "二次判定結果")
    private RString 二次判定結果;
    @CsvField(order = 69, name = "認定有効期間（開始）")
    private RString 認定有効期間開始;
    @CsvField(order = 70, name = "認定有効期間（終了）")
    private RString 認定有効期間終了;
    @CsvField(order = 71, name = "特定疾病コード")
    private RString 特定疾病コード;
    @CsvField(order = 72, name = "要介護１の場合の状態像")
    private RString 要介護１の場合の状態像;
    @CsvField(order = 73, name = "現在のサービス区分コード")
    private RString 現在のサービス区分コード;
    @CsvField(order = 74, name = "現在の状況")
    private RString 現在の状況;
    @CsvField(order = 75, name = "訪問介護（ホームヘルプサービス）")
    private RString 訪問介護ホームヘルプサービス;
    @CsvField(order = 76, name = "訪問入浴介護")
    private RString 訪問入浴介護;
    @CsvField(order = 77, name = "訪問看護")
    private RString 訪問看護;
    @CsvField(order = 78, name = "訪問リハビリテーション")
    private RString 訪問リハビリテーション;
    @CsvField(order = 79, name = "居宅療養管理指導")
    private RString 居宅療養管理指導;
    @CsvField(order = 80, name = "通所介護（デイサービス）")
    private RString 通所介護デイサービス;
    @CsvField(order = 81, name = "通所リハビリテーション")
    private RString 通所リハビリテーション;
    @CsvField(order = 82, name = "短期入所生活介護（ショートステイ）")
    private RString 短期入所生活介護ショートステイ;
    @CsvField(order = 83, name = "短期入所療養介護")
    private RString 短期入所療養介護;
    @CsvField(order = 84, name = "特定施設入居者生活介護")
    private RString 特定施設入居者生活介護;
    @CsvField(order = 85, name = "福祉用具貸与")
    private RString 福祉用具貸与;
    @CsvField(order = 86, name = "特定福祉用具販売")
    private RString 特定福祉用具販売;
    @CsvField(order = 87, name = "住宅改修（介護給付）")
    private RString 住宅改修介護給付;
    @CsvField(order = 88, name = "夜間対応型訪問介護")
    private RString 夜間対応型訪問介護;
    @CsvField(order = 89, name = "認知症対応型通所介護")
    private RString 認知症対応型通所介護;
    @CsvField(order = 90, name = "小規模多機能型居宅介護")
    private RString 小規模多機能型居宅介護;
    @CsvField(order = 91, name = "認知症対応型共同生活介護グループホーム")
    private RString 認知症対応型共同生活介護グループホーム;
    @CsvField(order = 92, name = "地域密着型特定施設入居者生活介護")
    private RString 地域密着型特定施設入居者生活介護;
    @CsvField(order = 93, name = "地域密着型介護老人福祉施設入所者生活介護")
    private RString 地域密着型介護老人福祉施設入所者生活介護;
    @CsvField(order = 94, name = "定期巡回・随時対応型訪問介護看護")
    private RString 定期巡回随時対応型訪問介護看護;
    @CsvField(order = 95, name = "複合型サービス")
    private RString 複合型サービス;
    @CsvField(order = 96, name = "介護予防訪問介護（ホームヘルプサービス）")
    private RString 介護予防訪問介護ホームヘルプサービス;
    @CsvField(order = 97, name = "介護予防訪問入浴介護")
    private RString 介護予防訪問入浴介護;
    @CsvField(order = 98, name = "介護予防訪問看護")
    private RString 介護予防訪問看護;
    @CsvField(order = 99, name = "介護予防訪問リハビリテーション")
    private RString 介護予防訪問リハビリテーション;
    @CsvField(order = 100, name = "介護予防居宅療養管理指導")
    private RString 介護予防居宅療養管理指導;
    @CsvField(order = 101, name = "介護予防通所介護（デイサービス）")
    private RString 介護予防通所介護デイサービス;
    @CsvField(order = 102, name = "介護予防短期入所生活介護（ショートステイ）")
    private RString 介護予防短期入所生活介護ショートステイ;
    @CsvField(order = 103, name = "介護予防通所リハビリテーション")
    private RString 介護予防通所リハビリテーション;
    @CsvField(order = 104, name = "介護予防短期入所療養介護")
    private RString 介護予防短期入所療養介護;
    @CsvField(order = 105, name = "介護予防特定施設入居者生活介護")
    private RString 介護予防特定施設入居者生活介護;
    @CsvField(order = 106, name = "介護予防福祉用具貸与")
    private RString 介護予防福祉用具貸与;
    @CsvField(order = 107, name = "特定介護予防福祉用具販売")
    private RString 特定介護予防福祉用具販売;
    @CsvField(order = 108, name = "住宅改修（予防給付）")
    private RString 住宅改修予防給付;
    @CsvField(order = 109, name = "介護予防認知症対応型通所介護")
    private RString 介護予防認知症対応型通所介護;
    @CsvField(order = 110, name = "介護予防小規模多機能型居宅介護")
    private RString 介護予防小規模多機能型居宅介護;
    @CsvField(order = 111, name = "介護予防認知症対応型共同生活介護（グループホーム）")
    private RString 介護予防認知症対応型共同生活介護グループホーム;
    @CsvField(order = 112, name = "０１麻痺（左-上肢）")
    private RString 麻痺左上肢;
    @CsvField(order = 113, name = "０１麻痺（右-上肢）")
    private RString 麻痺右上肢;
    @CsvField(order = 114, name = "０１麻痺（左-下肢）")
    private RString 麻痺左下肢;
    @CsvField(order = 115, name = "０１麻痺（右-下肢）")
    private RString 麻痺右下肢;
    @CsvField(order = 116, name = "０１麻痺（その他）")
    private RString 麻痺その他;
    @CsvField(order = 117, name = "０１拘縮（肩関節）")
    private RString 拘縮肩関節;
    @CsvField(order = 118, name = "０１拘縮（股関節）")
    private RString 拘縮股関節;
    @CsvField(order = 119, name = "０１拘縮膝関節")
    private RString 拘縮膝関節;
    @CsvField(order = 120, name = "０１拘縮その他")
    private RString 拘縮その他;
    @CsvField(order = 121, name = "０１寝返り")
    private RString 寝返り;
    @CsvField(order = 122, name = "０１起き上がり")
    private RString 起き上がり;
    @CsvField(order = 123, name = "０１座位保持")
    private RString 座位保持;
    @CsvField(order = 124, name = "０１両足での立位")
    private RString 両足での立位;
    @CsvField(order = 125, name = "０１歩行")
    private RString 歩行;
    @CsvField(order = 126, name = "０１立ち上がり")
    private RString 立ち上がり;
    @CsvField(order = 127, name = "０１片足での立位")
    private RString 片足での立位;
    @CsvField(order = 128, name = "０１洗身")
    private RString 洗身;
    @CsvField(order = 129, name = "０１つめ切り")
    private RString つめ切り;
    @CsvField(order = 130, name = "０１視力")
    private RString 視力;
    @CsvField(order = 131, name = "０１聴力")
    private RString 聴力;
    @CsvField(order = 132, name = "０２移乗")
    private RString 移乗;
    @CsvField(order = 133, name = "０２移動")
    private RString 移動;
    @CsvField(order = 134, name = "０２えん下")
    private RString えん下;
    @CsvField(order = 135, name = "０２食事摂取")
    private RString 食事摂取;
    @CsvField(order = 136, name = "０２排尿")
    private RString 排尿;
    @CsvField(order = 137, name = "０２排便")
    private RString 排便;
    @CsvField(order = 138, name = "０２口腔清潔")
    private RString 口腔清潔;
    @CsvField(order = 139, name = "０２洗顔")
    private RString 洗顔;
    @CsvField(order = 140, name = "０２整髪")
    private RString 整髪;
    @CsvField(order = 141, name = "０２上衣の着脱")
    private RString 上衣の着脱;
    @CsvField(order = 142, name = "０２ズボン等の着脱")
    private RString ズボン等の着脱;
    @CsvField(order = 143, name = "０２外出頻度")
    private RString 外出頻度;
    @CsvField(order = 144, name = "０３意思の伝達")
    private RString 意思の伝達;
    @CsvField(order = 145, name = "０３毎日の日課を理解")
    private RString 毎日の日課を理解;
    @CsvField(order = 146, name = "０３生年月日をいう")
    private RString 生年月日をいう;
    @CsvField(order = 147, name = "０３短期記憶")
    private RString 短期記憶;
    @CsvField(order = 148, name = "０３自分の名前をいう")
    private RString 自分の名前をいう;
    @CsvField(order = 149, name = "０３今の季節を理解")
    private RString 今の季節を理解;
    @CsvField(order = 150, name = "０３場所の理解")
    private RString 場所の理解;
    @CsvField(order = 151, name = "０３徘徊")
    private RString 徘徊;
    @CsvField(order = 152, name = "０３外出して戻れない")
    private RString 外出して戻れない;
    @CsvField(order = 153, name = "０４被害的")
    private RString 被害的;
    @CsvField(order = 154, name = "０４作話")
    private RString 作話;
    @CsvField(order = 155, name = "０４感情が不安定")
    private RString 感情が不安定;
    @CsvField(order = 156, name = "０４昼夜逆転")
    private RString 昼夜逆転;
    @CsvField(order = 157, name = "０４同じ話をする")
    private RString 同じ話をする;
    @CsvField(order = 158, name = "０４大声を出す")
    private RString 大声を出す;
    @CsvField(order = 159, name = "０４介護に抵抗")
    private RString 介護に抵抗;
    @CsvField(order = 160, name = "０４落ち着きなし")
    private RString 落ち着きなし;
    @CsvField(order = 161, name = "０４一人で出たがる")
    private RString 一人で出たがる;
    @CsvField(order = 162, name = "０４収集癖")
    private RString 収集癖;
    @CsvField(order = 163, name = "０４物や衣類を壊す")
    private RString 物や衣類を壊す;
    @CsvField(order = 164, name = "０４ひどい物忘れ")
    private RString ひどい物忘れ;
    @CsvField(order = 165, name = "０４独り言_独り笑い")
    private RString 独り言独り笑い;
    @CsvField(order = 166, name = "０４自分勝手に行動する")
    private RString 自分勝手に行動する;
    @CsvField(order = 167, name = "０４話がまとまらない")
    private RString 話がまとまらない;
    @CsvField(order = 168, name = "０５薬の内服")
    private RString 薬の内服;
    @CsvField(order = 169, name = "０５金銭の管理")
    private RString 金銭の管理;
    @CsvField(order = 170, name = "０５日常の意思決定")
    private RString 日常の意思決定;
    @CsvField(order = 171, name = "０５集団への不適応")
    private RString 集団への不適応;
    @CsvField(order = 172, name = "０５買い物")
    private RString 買い物;
    @CsvField(order = 173, name = "０５簡単な調理")
    private RString 簡単な調理;
    @CsvField(order = 174, name = "点滴の管理")
    private RString 点滴の管理;
    @CsvField(order = 175, name = "中心静脈栄養")
    private RString 中心静脈栄養;
    @CsvField(order = 176, name = "透析")
    private RString 透析;
    @CsvField(order = 177, name = "ストーマの処置")
    private RString ストーマの処置;
    @CsvField(order = 178, name = "酸素療法")
    private RString 酸素療法;
    @CsvField(order = 179, name = "レスピレーター")
    private RString レスピレーター;
    @CsvField(order = 180, name = "気管切開の処置")
    private RString 気管切開の処置;
    @CsvField(order = 181, name = "疼痛の看護")
    private RString 疼痛の看護;
    @CsvField(order = 182, name = "経管栄養")
    private RString 経管栄養;
    @CsvField(order = 183, name = "モニター測定")
    private RString モニター測定;
    @CsvField(order = 184, name = "じょくそうの処置")
    private RString じょくそうの処置;
    @CsvField(order = 185, name = "カテーテル")
    private RString カテーテル;
    @CsvField(order = 186, name = "障害高齢者自立度")
    private RString 障害高齢者自立度;
    @CsvField(order = 187, name = "認知症高齢者自立度")
    private RString 認知症高齢者自立度;
    @CsvField(order = 188, name = "前回結果０１麻痺_左-上肢")
    private RString 前回結果_麻痺左上肢;
    @CsvField(order = 189, name = "前回結果０１麻痺_右-上肢")
    private RString 前回結果_麻痺右上肢;
    @CsvField(order = 190, name = "前回結果０１麻痺_左-下肢")
    private RString 前回結果_麻痺左下肢;
    @CsvField(order = 191, name = "前回結果０１麻痺_右-下肢")
    private RString 前回結果_麻痺右下肢;
    @CsvField(order = 192, name = "前回結果０１麻痺_その他")
    private RString 前回結果_麻痺その他;
    @CsvField(order = 193, name = "前回結果０１拘縮_肩関節")
    private RString 前回結果_拘縮肩関節;
    @CsvField(order = 194, name = "前回結果０１拘縮_股関節")
    private RString 前回結果_拘縮股関節;
    @CsvField(order = 195, name = "前回結果０１拘縮_膝関節")
    private RString 前回結果_拘縮膝関節;
    @CsvField(order = 196, name = "前回結果０１拘縮_その他")
    private RString 前回結果_拘縮その他;
    @CsvField(order = 197, name = "前回結果０１寝返り")
    private RString 前回結果_寝返り;
    @CsvField(order = 198, name = "前回結果０１起き上がり")
    private RString 前回結果_起き上がり;
    @CsvField(order = 199, name = "前回結果０１座位保持")
    private RString 前回結果_座位保持;
    @CsvField(order = 200, name = "前回結果０１両足での立位")
    private RString 前回結果_両足での立位;
    @CsvField(order = 201, name = "前回結果０１歩行")
    private RString 前回結果_歩行;
    @CsvField(order = 202, name = "前回結果０１立ち上がり")
    private RString 前回結果_立ち上がり;
    @CsvField(order = 203, name = "前回結果０１片足での立位")
    private RString 前回結果_片足での立位;
    @CsvField(order = 204, name = "前回結果０１洗身")
    private RString 前回結果_洗身;
    @CsvField(order = 205, name = "前回結果０１つめ切り")
    private RString 前回結果_つめ切り;
    @CsvField(order = 206, name = "前回結果０１視力")
    private RString 前回結果_視力;
    @CsvField(order = 207, name = "前回結果０１聴力")
    private RString 前回結果_聴力;
    @CsvField(order = 208, name = "前回結果０２移乗")
    private RString 前回結果_移乗;
    @CsvField(order = 209, name = "前回結果０２移動")
    private RString 前回結果_移動;
    @CsvField(order = 210, name = "前回結果０２えん下")
    private RString 前回結果_えん下;
    @CsvField(order = 211, name = "前回結果０２食事摂取")
    private RString 前回結果_食事摂取;
    @CsvField(order = 212, name = "前回結果０２排尿")
    private RString 前回結果_排尿;
    @CsvField(order = 213, name = "前回結果０２排便")
    private RString 前回結果_排便;
    @CsvField(order = 214, name = "前回結果０２口腔清潔")
    private RString 前回結果_口腔清潔;
    @CsvField(order = 215, name = "前回結果０２洗顔")
    private RString 前回結果_洗顔;
    @CsvField(order = 216, name = "前回結果０２整髪")
    private RString 前回結果_整髪;
    @CsvField(order = 217, name = "前回結果０２上衣の着脱")
    private RString 前回結果_上衣の着脱;
    @CsvField(order = 218, name = "前回結果０２ズボン等の着脱")
    private RString 前回結果_ズボン等の着脱;
    @CsvField(order = 219, name = "前回結果０２外出頻度")
    private RString 前回結果_外出頻度;
    @CsvField(order = 220, name = "前回結果０３意思の伝達")
    private RString 前回結果_意思の伝達;
    @CsvField(order = 221, name = "前回結果０３毎日の日課を理解")
    private RString 前回結果_毎日の日課を理解;
    @CsvField(order = 222, name = "前回結果０３生年月日をいう")
    private RString 前回結果_生年月日をいう;
    @CsvField(order = 223, name = "前回結果０３短期記憶")
    private RString 前回結果_短期記憶;
    @CsvField(order = 224, name = "前回結果０３自分の名前をいう")
    private RString 前回結果_自分の名前をいう;
    @CsvField(order = 225, name = "前回結果０３今の季節を理解")
    private RString 前回結果_今の季節を理解;
    @CsvField(order = 226, name = "前回結果０３場所の理解")
    private RString 前回結果_場所の理解;
    @CsvField(order = 227, name = "前回結果０３徘徊")
    private RString 前回結果_徘徊;
    @CsvField(order = 228, name = "前回結果０３外出して戻れない")
    private RString 前回結果_外出して戻れない;
    @CsvField(order = 229, name = "前回結果０４被害的")
    private RString 前回結果_被害的;
    @CsvField(order = 230, name = "前回結果０４作話")
    private RString 前回結果_作話;
    @CsvField(order = 231, name = "前回結果０４感情が不安定")
    private RString 前回結果_感情が不安定;
    @CsvField(order = 232, name = "前回結果０４昼夜逆転")
    private RString 前回結果_昼夜逆転;
    @CsvField(order = 233, name = "前回結果０４同じ話をする")
    private RString 前回結果_同じ話をする;
    @CsvField(order = 234, name = "前回結果０４大声を出す")
    private RString 前回結果_大声を出す;
    @CsvField(order = 235, name = "前回結果０４介護に抵抗")
    private RString 前回結果_介護に抵抗;
    @CsvField(order = 236, name = "前回結果０４落ち着きなし")
    private RString 前回結果_落ち着きなし;
    @CsvField(order = 237, name = "前回結果０４一人で出たがる")
    private RString 前回結果_一人で出たがる;
    @CsvField(order = 238, name = "前回結果０４収集癖")
    private RString 前回結果_収集癖;
    @CsvField(order = 239, name = "前回結果０４物や衣類を壊す")
    private RString 前回結果_物や衣類を壊す;
    @CsvField(order = 240, name = "前回結果０４ひどい物忘れ")
    private RString 前回結果_ひどい物忘れ;
    @CsvField(order = 241, name = "前回結果０４独り言_独り笑い")
    private RString 前回結果_独り言独り笑い;
    @CsvField(order = 242, name = "前回結果０４自分勝手に行動する")
    private RString 前回結果_自分勝手に行動する;
    @CsvField(order = 243, name = "前回結果０４話がまとまらない")
    private RString 前回結果_話がまとまらない;
    @CsvField(order = 244, name = "前回結果０５薬の内服")
    private RString 前回結果_薬の内服;
    @CsvField(order = 245, name = "前回結果０５金銭の管理")
    private RString 前回結果_金銭の管理;
    @CsvField(order = 246, name = "前回結果０５日常の意思決定")
    private RString 前回結果_日常の意思決定;
    @CsvField(order = 247, name = "前回結果０５集団への不適応")
    private RString 前回結果_集団への不適応;
    @CsvField(order = 248, name = "前回結果０５買い物")
    private RString 前回結果_買い物;
    @CsvField(order = 249, name = "前回結果０５簡単な調理")
    private RString 前回結果_簡単な調理;
    @CsvField(order = 250, name = "前回結果点滴の管理")
    private RString 前回結果_点滴の管理;
    @CsvField(order = 251, name = "前回結果中心静脈栄養")
    private RString 前回結果_中心静脈栄養;
    @CsvField(order = 252, name = "前回結果透析")
    private RString 前回結果_透析;
    @CsvField(order = 253, name = "前回結果ストーマの処置")
    private RString 前回結果_ストーマの処置;
    @CsvField(order = 254, name = "前回結果酸素療法")
    private RString 前回結果_酸素療法;
    @CsvField(order = 255, name = "前回結果レスピレーター")
    private RString 前回結果_レスピレーター;
    @CsvField(order = 256, name = "前回結果気管切開の処置")
    private RString 前回結果_気管切開の処置;
    @CsvField(order = 257, name = "前回結果疼痛の看護")
    private RString 前回結果_疼痛の看護;
    @CsvField(order = 258, name = "前回結果経管栄養")
    private RString 前回結果_経管栄養;
    @CsvField(order = 259, name = "前回結果モニター測定")
    private RString 前回結果_モニター測定;
    @CsvField(order = 260, name = "前回結果じょくそうの処置")
    private RString 前回結果_じょくそうの処置;
    @CsvField(order = 261, name = "前回結果カテーテル")
    private RString 前回結果_カテーテル;
    @CsvField(order = 262, name = "前回結果障害高齢者自立度")
    private RString 前回結果_障害高齢者自立度;
    @CsvField(order = 263, name = "前回結果認知症高齢者自立度")
    private RString 前回結果_認知症高齢者自立度;
    @CsvField(order = 264, name = "前回結果一次判定結果")
    private RString 前回結果_一次判定結果;
    @CsvField(order = 265, name = "前回結果一次判定結果_認知症加算")
    private RString 前回結果_一次判定結果認知症加算;
    @CsvField(order = 266, name = "前回結果要介護認定等基準時間")
    private RString 前回結果_要介護認定等基準時間;
    @CsvField(order = 267, name = "前回結果要介護認定等基準時間食事")
    private RString 前回結果_要介護認定等基準時間食事;
    @CsvField(order = 268, name = "前回結果要介護認定等基準時間排泄")
    private RString 前回結果_要介護認定等基準時間排泄;
    @CsvField(order = 269, name = "前回結果要介護認定等基準時間移動")
    private RString 前回結果_要介護認定等基準時間移動;
    @CsvField(order = 270, name = "前回結果要介護認定等基準時間清潔保持")
    private RString 前回結果_要介護認定等基準時間清潔保持;
    @CsvField(order = 271, name = "前回結果要介護認定等基準時間間接ケア")
    private RString 前回結果_要介護認定等基準時間間接ケア;
    @CsvField(order = 272, name = "前回結果要介護認定等基準時間BPSD関連")
    private RString 前回結果_要介護認定等基準時間BPSD_関連;
    @CsvField(order = 273, name = "前回結果要介護認定等基準時間機能訓練")
    private RString 前回結果_要介護認定等基準時間機能訓練;
    @CsvField(order = 274, name = "前回結果要介護認定等基準時間医療関連")
    private RString 前回結果_要介護認定等基準時間医療関連;
    @CsvField(order = 275, name = "前回結果要介護認定等基準時間認知症加算")
    private RString 前回結果_要介護認定等基準時間認知症加算;
    @CsvField(order = 276, name = "前回結果中間評価項目得点第１群")
    private RString 前回結果_中間評価項目得点_第１群;
    @CsvField(order = 277, name = "前回結果中間評価項目得点第２群")
    private RString 前回結果_中間評価項目得点_第２群;
    @CsvField(order = 278, name = "前回結果中間評価項目得点第３群")
    private RString 前回結果_中間評価項目得点_第３群;
    @CsvField(order = 279, name = "前回結果中間評価項目得点第４群")
    private RString 前回結果_中間評価項目得点_第４群;
    @CsvField(order = 280, name = "前回結果中間評価項目得点第５群")
    private RString 前回結果_中間評価項目得点_第５群;
    @CsvField(order = 281, name = "前回結果一次判定警告コード")
    private RString 前回結果_一次判定警告コード;
    @CsvField(order = 282, name = "前回結果状態の安定性")
    private RString 前回結果_状態の安定性;
    @CsvField(order = 283, name = "前回結果認知症自立度Ⅱ以上の蓋然性")
    private RString 前回結果_認知症自立度Ⅱ以上の蓋然性;
    @CsvField(order = 284, name = "前回結果認知機能及び状態安定性から推定される給付区分")
    private RString 前回結果_認知機能及び状態安定性から推定される給付区分;
    @CsvField(order = 285, name = "前回結果申請日")
    private RString 前回結果_申請日;
    @CsvField(order = 286, name = "前回結果二次判定日")
    private RString 前回結果_二次判定日;
    @CsvField(order = 287, name = "前回結果現在のサービス区分コード")
    private RString 前回結果_現在のサービス区分コード;
    @CsvField(order = 288, name = "前回結果現在の状況")
    private RString 前回結果_現在の状況;
    @CsvField(order = 289, name = "前回結果訪問介護_ホームヘルプサービス")
    private RString 前回結果_訪問介護ホームヘルプサービス;
    @CsvField(order = 290, name = "前回結果訪問入浴介護")
    private RString 前回結果_訪問入浴介護;
    @CsvField(order = 291, name = "前回結果訪問看護")
    private RString 前回結果_訪問看護;
    @CsvField(order = 292, name = "前回結果訪問リハビリテーション")
    private RString 前回結果_訪問リハビリテーション;
    @CsvField(order = 293, name = "前回結果居宅療養管理指導")
    private RString 前回結果_居宅療養管理指導;
    @CsvField(order = 294, name = "前回結果通所介護_デイサービス")
    private RString 前回結果_通所介護デイサービス;
    @CsvField(order = 295, name = "前回結果通所リハビリテーション")
    private RString 前回結果_通所リハビリテーション;
    @CsvField(order = 296, name = "前回結果短期入所生活介護_ショートステイ")
    private RString 前回結果_短期入所生活介護ショートステイ;
    @CsvField(order = 297, name = "前回結果短期入所療養介護")
    private RString 前回結果_短期入所療養介護;
    @CsvField(order = 298, name = "前回結果特定施設入居者生活介護")
    private RString 前回結果_特定施設入居者生活介護;
    @CsvField(order = 299, name = "前回結果福祉用具貸与")
    private RString 前回結果_福祉用具貸与;
    @CsvField(order = 300, name = "前回結果特定福祉用具販売")
    private RString 前回結果_特定福祉用具販売;
    @CsvField(order = 301, name = "前回結果住宅改修_介護給付")
    private RString 前回結果_住宅改修介護給付;
    @CsvField(order = 302, name = "前回結果夜間対応型訪問介護")
    private RString 前回結果_夜間対応型訪問介護;
    @CsvField(order = 303, name = "前回結果認知症対応型通所介護")
    private RString 前回結果_認知症対応型通所介護;
    @CsvField(order = 304, name = "前回結果小規模多機能型居宅介護")
    private RString 前回結果_小規模多機能型居宅介護;
    @CsvField(order = 305, name = "前回結果認知症対応型共同生活介護_グループホーム")
    private RString 前回結果_認知症対応型共同生活介護グループホーム;
    @CsvField(order = 306, name = "前回結果地域密着型特定施設入居者生活介護")
    private RString 前回結果_地域密着型特定施設入居者生活介護;
    @CsvField(order = 307, name = "前回結果地域密着型介護老人福祉施設入所者生活介護")
    private RString 前回結果_地域密着型介護老人福祉施設入所者生活介護;
    @CsvField(order = 308, name = "前回結果定期巡回_随時対応型訪問介護看護")
    private RString 前回結果_定期巡回随時対応型訪問介護看護;
    @CsvField(order = 309, name = "前回結果複合型サービス")
    private RString 前回結果_複合型サービス;
    @CsvField(order = 310, name = "前回結果介護予防訪問介護_ホームヘルプサービス")
    private RString 前回結果_介護予防訪問介護ホームヘルプサービス;
    @CsvField(order = 311, name = "前回結果介護予防訪問入浴介護")
    private RString 前回結果_介護予防訪問入浴介護;
    @CsvField(order = 312, name = "前回結果介護予防訪問看護")
    private RString 前回結果_介護予防訪問看護;
    @CsvField(order = 313, name = "前回結果介護予防訪問リハビリテーション")
    private RString 前回結果_介護予防訪問リハビリテーション;
    @CsvField(order = 314, name = "前回結果介護予防居宅療養管理指導")
    private RString 前回結果_介護予防居宅療養管理指導;
    @CsvField(order = 315, name = "前回結果介護予防通所介護_デイサービス")
    private RString 前回結果_介護予防通所介護デイサービス;
    @CsvField(order = 316, name = "前回結果介護予防通所リハビリテーション")
    private RString 前回結果_介護予防通所リハビリテーション;
    @CsvField(order = 317, name = "前回結果介護予防短期入所生活介護_ショートステイ")
    private RString 前回結果_介護予防短期入所生活介護ショートステイ;
    @CsvField(order = 318, name = "前回結果介護予防短期入所療養介護")
    private RString 前回結果_介護予防短期入所療養介護;
    @CsvField(order = 319, name = "前回結果介護予防特定施設入居者生活介護")
    private RString 前回結果_介護予防特定施設入居者生活介護;
    @CsvField(order = 320, name = "前回結果介護予防福祉用具貸与")
    private RString 前回結果_介護予防福祉用具貸与;
    @CsvField(order = 321, name = "前回結果特定介護予防福祉用具販売")
    private RString 前回結果_特定介護予防福祉用具販売;
    @CsvField(order = 322, name = "前回結果住宅改修_予防給付")
    private RString 前回結果_住宅改修予防給付;
    @CsvField(order = 323, name = "前回結果介護予防認知症対応型通所介護")
    private RString 前回結果_介護予防認知症対応型通所介護;
    @CsvField(order = 324, name = "前回結果介護予防小規模多機能型居宅介護")
    private RString 前回結果_介護予防小規模多機能型居宅介護;
    @CsvField(order = 325, name = "前回結果介護予防認知症対応型共同生活介護_グループホーム")
    private RString 前回結果_介護予防認知症対応型共同生活介護グループホーム;
    @CsvField(order = 326, name = "前回識別コード")
    private RString 前回識別コード;
    @CsvField(order = 327, name = "認定審査会意見等")
    private RString 認定審査会意見等;
    @CsvField(order = 328, name = "コメント等")
    private RString コメント等;
}
