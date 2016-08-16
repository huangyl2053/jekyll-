/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査結果取込み（OCR）CSVファイルの項目のクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiTorokuData implements Serializable {

    private static final long serialVersionUID = -7934601159850345035L;
    private int 項目数;
    private RString OK_NG;
    @CsvField(order = 1, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 2, name = "申請日")
    private RString 申請日;
    @CsvField(order = 3, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 4, name = "実施日時")
    private RString 実施日時;
    @CsvField(order = 5, name = "実施場所コード")
    private RString 実施場所コード;
    @CsvField(order = 6, name = "記入者氏名_コード")
    private RString 記入者氏名_コード;
    @CsvField(order = 7, name = "所属機関_コード")
    private RString 所属機関_コード;
    @CsvField(order = 8, name = "現在のサービス区分コード")
    private RString 現在のサービス区分コード;
    @CsvField(order = 9, name = "訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数")
    private RString 訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽの回数;
    @CsvField(order = 10, name = "訪問入浴介護の回数")
    private RString 訪問入浴介護の回数;
    @CsvField(order = 11, name = "訪問看護の回数")
    private RString 訪問看護の回数;
    @CsvField(order = 12, name = "訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数")
    private RString 訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数;
    @CsvField(order = 13, name = "居宅療養管理指導の回数")
    private RString 居宅療養管理指導の回数;
    @CsvField(order = 14, name = "通所看護_ﾃﾞｲｻｰﾋﾞｽの回数")
    private RString 通所看護_ﾃﾞｲｻｰﾋﾞｽの回数;
    @CsvField(order = 15, name = "通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数")
    private RString 通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数;
    @CsvField(order = 16, name = "短期入所生活介護の日数")
    private RString 短期入所生活介護の日数;
    @CsvField(order = 17, name = "短期入所療養介護の日数")
    private RString 短期入所療養介護の日数;
    @CsvField(order = 18, name = "特定施設入所者生活介護の日数")
    private RString 特定施設入所者生活介護の日数;
    @CsvField(order = 19, name = "福祉用具貸与の品目")
    private RString 福祉用具貸与の品目;
    @CsvField(order = 20, name = "福祉用具購入の品目")
    private RString 福祉用具購入の品目;
    @CsvField(order = 21, name = "住宅改修のあり_なし")
    private RString 住宅改修のあり_なし;
    @CsvField(order = 22, name = "夜間対応型訪問介護の日数")
    private RString 夜間対応型訪問介護の日数;
    @CsvField(order = 23, name = "認知症対応型通所介護の日数")
    private RString 認知症対応型通所介護の日数;
    @CsvField(order = 24, name = "小規模多機能型居宅介護の日数")
    private RString 小規模多機能型居宅介護の日数;
    @CsvField(order = 25, name = "認知症対応型共同生活介護の日数")
    private RString 認知症対応型共同生活介護の日数;
    @CsvField(order = 26, name = "地域密着型特定施設入居者生活介護の日数")
    private RString 地域密着型特定施設入居者生活介護の日数;
    @CsvField(order = 27, name = "地域密着型介護老人福祉施設入居者生活介護の日数")
    private RString 地域密着型介護老人福祉施設入居者生活介護の日数;
    @CsvField(order = 28, name = "看護小規模多機能型居宅介護")
    private RString 看護小規模多機能型居宅介護;
    @CsvField(order = 29, name = "定期巡回_随時対応型訪問介護看護")
    private RString 定期巡回_随時対応型訪問介護看護;
    @CsvField(order = 30, name = "施設利用の有無")
    private RString 施設利用の有無;
    @CsvField(order = 31, name = "麻痺_ない")
    private RString 麻痺_ない;
    @CsvField(order = 32, name = "麻痺_左上肢")
    private RString 麻痺_左上肢;
    @CsvField(order = 33, name = "麻痺_右上肢")
    private RString 麻痺_右上肢;
    @CsvField(order = 34, name = "麻痺_左下肢")
    private RString 麻痺_左下肢;
    @CsvField(order = 35, name = "麻痺_右下肢")
    private RString 麻痺_右下肢;
    @CsvField(order = 36, name = "麻痺_その他")
    private RString 麻痺_その他;
    @CsvField(order = 37, name = "拘縮_ない")
    private RString 拘縮_ない;
    @CsvField(order = 38, name = "拘縮_肩関節")
    private RString 拘縮_肩関節;
    @CsvField(order = 39, name = "拘縮_股関節")
    private RString 拘縮_股関節;
    @CsvField(order = 40, name = "拘縮_膝関節")
    private RString 拘縮_膝関節;
    @CsvField(order = 41, name = "拘縮_その他")
    private RString 拘縮_その他;
    @CsvField(order = 42, name = "寝返り")
    private RString 寝返り;
    @CsvField(order = 43, name = "起き上がり")
    private RString 起き上がり;
    @CsvField(order = 44, name = "座位保持")
    private RString 座位保持;
    @CsvField(order = 45, name = "両足での立位")
    private RString 両足での立位;
    @CsvField(order = 46, name = "歩行")
    private RString 歩行;
    @CsvField(order = 47, name = "立ち上がり")
    private RString 立ち上がり;
    @CsvField(order = 48, name = "片足での立位")
    private RString 片足での立位;
    @CsvField(order = 49, name = "洗身")
    private RString 洗身;
    @CsvField(order = 50, name = "つめ切り")
    private RString つめ切り;
    @CsvField(order = 51, name = "視力")
    private RString 視力;
    @CsvField(order = 52, name = "聴力")
    private RString 聴力;
    @CsvField(order = 53, name = "移乗")
    private RString 移乗;
    @CsvField(order = 54, name = "移動")
    private RString 移動;
    @CsvField(order = 55, name = "えん下")
    private RString えん下;
    @CsvField(order = 56, name = "食事摂取")
    private RString 食事摂取;
    @CsvField(order = 57, name = "排尿")
    private RString 排尿;
    @CsvField(order = 58, name = "排便")
    private RString 排便;
    @CsvField(order = 59, name = "口腔清潔")
    private RString 口腔清潔;
    @CsvField(order = 60, name = "洗顔")
    private RString 洗顔;
    @CsvField(order = 61, name = "整髪")
    private RString 整髪;
    @CsvField(order = 62, name = "上衣の着脱")
    private RString 上衣の着脱;
    @CsvField(order = 63, name = "ズボン等の着脱")
    private RString ズボン等の着脱;
    @CsvField(order = 64, name = "外出頻度")
    private RString 外出頻度;
    @CsvField(order = 65, name = "意思の疎通")
    private RString 意思の疎通;
    @CsvField(order = 66, name = "毎日の日課を理解")
    private RString 毎日の日課を理解;
    @CsvField(order = 67, name = "生年月日をいう")
    private RString 生年月日をいう;
    @CsvField(order = 68, name = "短期記憶")
    private RString 短期記憶;
    @CsvField(order = 69, name = "自分の名前をいう")
    private RString 自分の名前をいう;
    @CsvField(order = 70, name = "今の季節を理解")
    private RString 今の季節を理解;
    @CsvField(order = 71, name = "場所の理解")
    private RString 場所の理解;
    @CsvField(order = 72, name = "徘徊")
    private RString 徘徊;
    @CsvField(order = 73, name = "外出して戻れない")
    private RString 外出して戻れない;
    @CsvField(order = 74, name = "被害的")
    private RString 被害的;
    @CsvField(order = 75, name = "作話")
    private RString 作話;
    @CsvField(order = 76, name = "感情が不安定")
    private RString 感情が不安定;
    @CsvField(order = 77, name = "昼夜逆転")
    private RString 昼夜逆転;
    @CsvField(order = 78, name = "同じ話をする")
    private RString 同じ話をする;
    @CsvField(order = 79, name = "大声を出す")
    private RString 大声を出す;
    @CsvField(order = 80, name = "介護に抵抗")
    private RString 介護に抵抗;
    @CsvField(order = 81, name = "落ち着きなし")
    private RString 落ち着きなし;
    @CsvField(order = 82, name = "一人で出たがる")
    private RString 一人で出たがる;
    @CsvField(order = 83, name = "収集癖")
    private RString 収集癖;
    @CsvField(order = 84, name = "物や衣類を壊す")
    private RString 物や衣類を壊す;
    @CsvField(order = 85, name = "ひどい物忘れ")
    private RString ひどい物忘れ;
    @CsvField(order = 86, name = "独り言_独り笑い")
    private RString 独り言_独り笑い;
    @CsvField(order = 87, name = "自分勝手に行動する")
    private RString 自分勝手に行動する;
    @CsvField(order = 88, name = "話がまとまらない")
    private RString 話がまとまらない;
    @CsvField(order = 89, name = "薬の内服")
    private RString 薬の内服;
    @CsvField(order = 90, name = "金銭の管理")
    private RString 金銭の管理;
    @CsvField(order = 91, name = "日常の意思決定")
    private RString 日常の意思決定;
    @CsvField(order = 92, name = "集団への不適応")
    private RString 集団への不適応;
    @CsvField(order = 93, name = "買い物")
    private RString 買い物;
    @CsvField(order = 94, name = "簡単な調理")
    private RString 簡単な調理;
    @CsvField(order = 95, name = "過去14日間に受けた治療_点滴の管理")
    private RString 過去14日間に受けた治療_点滴の管理;
    @CsvField(order = 96, name = "過去14日間に受けた治療_中心静脈栄養")
    private RString 過去14日間に受けた治療_中心静脈栄養;
    @CsvField(order = 97, name = "過去14日間に受けた治療_透折")
    private RString 過去14日間に受けた治療_透折;
    @CsvField(order = 98, name = "過去14日間に受けた治療_ストーマの処理")
    private RString 過去14日間に受けた治療_ストーマの処理;
    @CsvField(order = 99, name = "過去14日間に受けた治療_酸素療法")
    private RString 過去14日間に受けた治療_酸素療法;
    @CsvField(order = 100, name = "過去14日間に受けた治療_レスピレーター")
    private RString 過去14日間に受けた治療_レスピレーター;
    @CsvField(order = 101, name = "過去14日間に受けた治療_気管切開の処理")
    private RString 過去14日間に受けた治療_気管切開の処理;
    @CsvField(order = 102, name = "過去14日間に受けた治療_疼痛")
    private RString 過去14日間に受けた治療_疼痛;
    @CsvField(order = 103, name = "過去14日間に受けた治療_経管栄養")
    private RString 過去14日間に受けた治療_経管栄養;
    @CsvField(order = 104, name = "過去14日間に受けた治療_モニター測定")
    private RString 過去14日間に受けた治療_モニター測定;
    @CsvField(order = 105, name = "過去14日間に受けた治療_じょくそうの処置")
    private RString 過去14日間に受けた治療_じょくそうの処置;
    @CsvField(order = 106, name = "過去14日間に受けた治療_カテーテル")
    private RString 過去14日間に受けた治療_カテーテル;
    @CsvField(order = 107, name = "障害高齢者の日常生活自立度_寝たきり度")
    private RString 障害高齢者の日常生活自立度_寝たきり度;
    @CsvField(order = 108, name = "認知症高齢者の日常生活自立度")
    private RString 認知症高齢者の日常生活自立度;
    @CsvField(order = 109, name = "番号")
    private RString 番号;
    private RString 証記載保険者番号;
    private RString 保険者;
    private RString 申請区分;
    private RString 厚労省IF識別コード;
    private RString 申請書管理番号;
    private int 認定調査依頼履歴番号;
    private RDateTime イメージ共有ファイルID;
    private RString 認定調査委託先コード;
    private RString 認定調査員コード;
    private Code 認定調査依頼区分コード;
    private int 認定調査回数;
}
