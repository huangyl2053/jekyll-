/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査票情報99AのCSV用Entityです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBE010002_ChosahyoJoho99AEucEntity {

    @CsvField(order = 1, name = "申請書管理番号")
    private RString 申請書管理番号;
    @CsvField(order = 2, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 3, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 4, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 5, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 6, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 7, name = "性別")
    private RString 性別;
    @CsvField(order = 8, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 9, name = "年齢")
    private RString 年齢;
    @CsvField(order = 10, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 11, name = "被保険者区分")
    private RString 被保険者区分;
    @CsvField(order = 12, name = "２号特定疾病コード")
    private RString _２号特定疾病コード;
    @CsvField(order = 13, name = "２号特定疾病名")
    private RString _２号特定疾病名;
    @CsvField(order = 14, name = "申請日")
    private RString 申請日;
    @CsvField(order = 15, name = "申請書区分コード")
    private RString 申請書区分コード;
    @CsvField(order = 16, name = "申請書区分")
    private RString 申請書区分;
    @CsvField(order = 17, name = "申請区分（法令）コード")
    private RString 申請区分_法令_コード;
    @CsvField(order = 18, name = "申請区分（法令）")
    private RString 申請区分_法令;
    @CsvField(order = 19, name = "申請区分（申請時）コード")
    private RString 申請区分_申請時_コード;
    @CsvField(order = 20, name = "申請区分（申請時）")
    private RString 申請区分_申請時;
    @CsvField(order = 21, name = "処理状態区分コード")
    private RString 処理状態区分コード;
    @CsvField(order = 22, name = "処理状態区分")
    private RString 処理状態区分;
    @CsvField(order = 23, name = "（申請時）調査委託先コード")
    private RString 申請時_調査委託先コード;
    @CsvField(order = 24, name = "（申請時）調査委託先名称")
    private RString 申請時_調査委託先名称;
    @CsvField(order = 25, name = "（申請時）調査員コード")
    private RString 申請時_調査員コード;
    @CsvField(order = 26, name = "（申請時）調査員名")
    private RString 申請時_調査員名;
    @CsvField(order = 27, name = "依頼区分コード")
    private RString 依頼区分コード;
    @CsvField(order = 28, name = "依頼区分")
    private RString 依頼区分;
    @CsvField(order = 29, name = "（依頼時）調査委託先コード")
    private RString 依頼時_調査委託先コード;
    @CsvField(order = 30, name = "（依頼時）調査委託先名称")
    private RString 依頼時_調査委託先名称;
    @CsvField(order = 31, name = "（依頼時）調査員コード")
    private RString 依頼時_調査員コード;
    @CsvField(order = 32, name = "（依頼時）調査員名")
    private RString 依頼時_調査員名;
    @CsvField(order = 33, name = "（入手時）調査委託先コード")
    private RString 入手時_調査委託先コード;
    @CsvField(order = 34, name = "（入手時）調査委託先名称")
    private RString 入手時_調査委託先名称;
    @CsvField(order = 35, name = "（入手時）調査員コード")
    private RString 入手時_調査員コード;
    @CsvField(order = 36, name = "（入手時）調査員名")
    private RString 入手時_調査員名;
    @CsvField(order = 37, name = "調査回数")
    private RString 調査回数;
    @CsvField(order = 38, name = "調査実施日")
    private RString 調査実施日;
    @CsvField(order = 39, name = "受領日")
    private RString 受領日;
    @CsvField(order = 40, name = "調査区分コード")
    private RString 調査区分コード;
    @CsvField(order = 41, name = "調査区分")
    private RString 調査区分;
    @CsvField(order = 42, name = "実施場所コード")
    private RString 実施場所コード;
    @CsvField(order = 43, name = "実施場所")
    private RString 実施場所;
    @CsvField(order = 44, name = "実施場所名称")
    private RString 実施場所名称;
    @CsvField(order = 45, name = "サービス区分コード")
    private RString サービス区分コード;
    @CsvField(order = 46, name = "サービス区分")
    private RString サービス区分;
    @CsvField(order = 47, name = "訪問介護")
    private RString 訪問介護;
    @CsvField(order = 48, name = "訪問入浴介護")
    private RString 訪問入浴介護;
    @CsvField(order = 49, name = "訪問看護")
    private RString 訪問看護;
    @CsvField(order = 50, name = "訪問リハビリ")
    private RString 訪問リハビリ;
    @CsvField(order = 51, name = "居宅療養管理指導")
    private RString 居宅療養管理指導;
    @CsvField(order = 52, name = "通所介護")
    private RString 通所介護;
    @CsvField(order = 53, name = "通所リハビリ")
    private RString 通所リハビリ;
    @CsvField(order = 54, name = "福祉用具貸与")
    private RString 福祉用具貸与;
    @CsvField(order = 55, name = "短期入所生活介護")
    private RString 短期入所生活介護;
    @CsvField(order = 56, name = "短期入所療養介護")
    private RString 短期入所療養介護;
    @CsvField(order = 57, name = "認知症対応型共同生活介護")
    private RString 認知症対応型共同生活介護;
    @CsvField(order = 58, name = "特定施設入所者生活介護")
    private RString 特定施設入所者生活介護;
    @CsvField(order = 59, name = "福祉用具購入")
    private RString 福祉用具購入;
    @CsvField(order = 60, name = "住宅改修")
    private RString 住宅改修;
    @CsvField(order = 61, name = "市町村特別給付")
    private RString 市町村特別給付;
    @CsvField(order = 62, name = "介護保険給付外の在宅サービス")
    private RString 介護保険給付外の在宅サービス;
    @CsvField(order = 63, name = "現在の状況コード")
    private RString 現在の状況コード;
    @CsvField(order = 64, name = "現在の状況")
    private RString 現在の状況;
    @CsvField(order = 65, name = "利用施設名")
    private RString 利用施設名;
    @CsvField(order = 66, name = "特記事項")
    private RString 特記事項;
    @CsvField(order = 67, name = "麻痺等_左上肢")
    private RString 麻痺等_左上肢;
    @CsvField(order = 68, name = "麻痺等_右上肢")
    private RString 麻痺等_右上肢;
    @CsvField(order = 69, name = "麻痺等_左下肢")
    private RString 麻痺等_左下肢;
    @CsvField(order = 70, name = "麻痺等_右下肢")
    private RString 麻痺等_右下肢;
    @CsvField(order = 71, name = "麻痺等_その他")
    private RString 麻痺等_その他;
    @CsvField(order = 72, name = "拘縮_肩関節")
    private RString 拘縮_肩関節;
    @CsvField(order = 73, name = "拘縮_肘関節")
    private RString 拘縮_肘関節;
    @CsvField(order = 74, name = "拘縮_股関節")
    private RString 拘縮_股関節;
    @CsvField(order = 75, name = "拘縮_膝関節")
    private RString 拘縮_膝関節;
    @CsvField(order = 76, name = "拘縮_足関節")
    private RString 拘縮_足関節;
    @CsvField(order = 77, name = "拘縮_その他")
    private RString 拘縮_その他;
    @CsvField(order = 78, name = "寝返り")
    private RString 寝返り;
    @CsvField(order = 79, name = "起き上がり")
    private RString 起き上がり;
    @CsvField(order = 80, name = "座位保持")
    private RString 座位保持;
    @CsvField(order = 81, name = "非接地座位保持")
    private RString 非接地座位保持;
    @CsvField(order = 82, name = "両足での立位")
    private RString 両足での立位;
    @CsvField(order = 83, name = "歩行")
    private RString 歩行;
    @CsvField(order = 84, name = "移乗")
    private RString 移乗;
    @CsvField(order = 85, name = "立ち上がり")
    private RString 立ち上がり;
    @CsvField(order = 86, name = "片足での立位")
    private RString 片足での立位;
    @CsvField(order = 87, name = "浴槽の出入り")
    private RString 浴槽の出入り;
    @CsvField(order = 88, name = "洗身")
    private RString 洗身;
    @CsvField(order = 89, name = "じょくそう")
    private RString じょくそう;
    @CsvField(order = 90, name = "他の皮膚疾患")
    private RString 他の皮膚疾患;
    @CsvField(order = 91, name = "片手胸元上げ")
    private RString 片手胸元上げ;
    @CsvField(order = 92, name = "えん下")
    private RString えん下;
    @CsvField(order = 93, name = "尿意")
    private RString 尿意;
    @CsvField(order = 94, name = "便意")
    private RString 便意;
    @CsvField(order = 95, name = "排尿後の後始末")
    private RString 排尿後の後始末;
    @CsvField(order = 96, name = "排便後の後始末")
    private RString 排便後の後始末;
    @CsvField(order = 97, name = "食事摂取")
    private RString 食事摂取;
    @CsvField(order = 98, name = "口腔清潔")
    private RString 口腔清潔;
    @CsvField(order = 99, name = "洗顔")
    private RString 洗顔;
    @CsvField(order = 100, name = "整髪")
    private RString 整髪;
    @CsvField(order = 101, name = "つめ切り")
    private RString つめ切り;
    @CsvField(order = 102, name = "ボタンのかけはずし")
    private RString ボタンのかけはずし;
    @CsvField(order = 103, name = "上衣の着脱")
    private RString 上衣の着脱;
    @CsvField(order = 104, name = "ズボン等の着脱")
    private RString ズボン等の着脱;
    @CsvField(order = 105, name = "靴下の着脱")
    private RString 靴下の着脱;
    @CsvField(order = 106, name = "居室の掃除")
    private RString 居室の掃除;
    @CsvField(order = 107, name = "薬の内服")
    private RString 薬の内服;
    @CsvField(order = 108, name = "金銭の管理")
    private RString 金銭の管理;
    @CsvField(order = 109, name = "ひどい物忘れ")
    private RString ひどい物忘れ;
    @CsvField(order = 110, name = "周囲への無関心")
    private RString 周囲への無関心;
    @CsvField(order = 111, name = "視力")
    private RString 視力;
    @CsvField(order = 112, name = "聴力")
    private RString 聴力;
    @CsvField(order = 113, name = "意思の伝達")
    private RString 意思の伝達;
    @CsvField(order = 114, name = "指示への反応")
    private RString 指示への反応;
    @CsvField(order = 115, name = "毎日の日課を理解")
    private RString 毎日の日課を理解;
    @CsvField(order = 116, name = "生年月日をいう")
    private RString 生年月日をいう;
    @CsvField(order = 117, name = "短期記憶")
    private RString 短期記憶;
    @CsvField(order = 118, name = "自分の名前をいう")
    private RString 自分の名前をいう;
    @CsvField(order = 119, name = "今の季節を理解")
    private RString 今の季節を理解;
    @CsvField(order = 120, name = "場所の理解")
    private RString 場所の理解;
    @CsvField(order = 121, name = "被害的")
    private RString 被害的;
    @CsvField(order = 122, name = "作話")
    private RString 作話;
    @CsvField(order = 123, name = "幻視幻聴")
    private RString 幻視幻聴;
    @CsvField(order = 124, name = "感情が不安定")
    private RString 感情が不安定;
    @CsvField(order = 125, name = "昼夜逆転")
    private RString 昼夜逆転;
    @CsvField(order = 126, name = "暴言暴行")
    private RString 暴言暴行;
    @CsvField(order = 127, name = "同じ話をする")
    private RString 同じ話をする;
    @CsvField(order = 128, name = "大声をだす")
    private RString 大声をだす;
    @CsvField(order = 129, name = "介護に抵抗")
    private RString 介護に抵抗;
    @CsvField(order = 130, name = "常時の徘徊")
    private RString 常時の徘徊;
    @CsvField(order = 131, name = "落ち着きなし")
    private RString 落ち着きなし;
    @CsvField(order = 132, name = "外出して戻れない")
    private RString 外出して戻れない;
    @CsvField(order = 133, name = "一人で出たがる")
    private RString 一人で出たがる;
    @CsvField(order = 134, name = "収集癖")
    private RString 収集癖;
    @CsvField(order = 135, name = "火の不始末")
    private RString 火の不始末;
    @CsvField(order = 136, name = "物や衣類を壊す")
    private RString 物や衣類を壊す;
    @CsvField(order = 137, name = "不潔行為")
    private RString 不潔行為;
    @CsvField(order = 138, name = "異食行動")
    private RString 異食行動;
    @CsvField(order = 139, name = "性的迷惑行為")
    private RString 性的迷惑行為;
    @CsvField(order = 140, name = "点滴の管理")
    private RString 点滴の管理;
    @CsvField(order = 141, name = "中心静脈栄養")
    private RString 中心静脈栄養;
    @CsvField(order = 142, name = "透析")
    private RString 透析;
    @CsvField(order = 143, name = "ストーマ")
    private RString ストーマ;
    @CsvField(order = 144, name = "酸素療法")
    private RString 酸素療法;
    @CsvField(order = 145, name = "レスピレーター")
    private RString レスピレーター;
    @CsvField(order = 146, name = "気管切開の処置")
    private RString 気管切開の処置;
    @CsvField(order = 147, name = "疼痛の看護")
    private RString 疼痛の看護;
    @CsvField(order = 148, name = "経管栄養")
    private RString 経管栄養;
    @CsvField(order = 149, name = "モニター測定")
    private RString モニター測定;
    @CsvField(order = 150, name = "じょくそうの処置")
    private RString じょくそうの処置;
    @CsvField(order = 151, name = "カテーテル")
    private RString カテーテル;
    @CsvField(order = 152, name = "障害高齢者の日常生活自立度コード")
    private RString 障害高齢者の日常生活自立度コード;
    @CsvField(order = 153, name = "障害高齢者の日常生活自立度")
    private RString 障害高齢者の日常生活自立度;
    @CsvField(order = 154, name = "認知症高齢者の日常生活自立度コード")
    private RString 認知症高齢者の日常生活自立度コード;
    @CsvField(order = 155, name = "認知症高齢者の日常生活自立度")
    private RString 認知症高齢者の日常生活自立度;
    @CsvField(order = 156, name = "判定区分コード")
    private RString 判定区分コード;
    @CsvField(order = 157, name = "判定区分")
    private RString 判定区分;
    @CsvField(order = 158, name = "一次判定日")
    private RString 一次判定日;
    @CsvField(order = 159, name = "一次判定結果コード")
    private RString 一次判定結果コード;
    @CsvField(order = 160, name = "一次判定結果")
    private RString 一次判定結果;
    @CsvField(order = 161, name = "一次判定結果コード（認知症加算）")
    private RString 一次判定結果コード_認知症加算;
    @CsvField(order = 162, name = "一次判定結果（認知症加算）")
    private RString 一次判定結果_認知症加算;
    @CsvField(order = 163, name = "要介護認定基準時間")
    private RString 要介護認定基準時間;
    @CsvField(order = 164, name = "要基準時間（食事）")
    private RString 要基準時間_食事;
    @CsvField(order = 165, name = "要基準時間（排泄）")
    private RString 要基準時間_排泄;
    @CsvField(order = 166, name = "要基準時間（移動）")
    private RString 要基準時間_移動;
    @CsvField(order = 167, name = "要基準時間（清潔保持）")
    private RString 要基準時間_清潔保持;
    @CsvField(order = 168, name = "要基準時間（間接ケア）")
    private RString 要基準時間_間接ケア;
    @CsvField(order = 169, name = "要基準時間（BPSD問題）")
    private RString 要基準時間_BPSD問題;
    @CsvField(order = 170, name = "要基準時間（機能訓練）")
    private RString 要基準時間_機能訓練;
    @CsvField(order = 171, name = "要基準時間（医療関連）")
    private RString 要基準時間_医療関連;
    @CsvField(order = 172, name = "要基準時間（認知症加算）")
    private RString 要基準時間_認知症加算;
    @CsvField(order = 173, name = "中間評価項目得点第１群")
    private RString 中間評価項目得点第１群;
    @CsvField(order = 174, name = "中間評価項目得点第２群")
    private RString 中間評価項目得点第２群;
    @CsvField(order = 175, name = "中間評価項目得点第３群")
    private RString 中間評価項目得点第３群;
    @CsvField(order = 176, name = "中間評価項目得点第４群")
    private RString 中間評価項目得点第４群;
    @CsvField(order = 177, name = "中間評価項目得点第５群")
    private RString 中間評価項目得点第５群;
    @CsvField(order = 178, name = "一次判定警告コード")
    private RString 一次判定警告コード;
    @CsvField(order = 179, name = "状態の安定性コード")
    private RString 状態の安定性コード;
    @CsvField(order = 180, name = "状態の安定性")
    private RString 状態の安定性;
    @CsvField(order = 181, name = "認知症自立度Ⅱ以上の蓋然性")
    private RString 認知症自立度Ⅱ以上の蓋然性;
    @CsvField(order = 182, name = "給付区分コード")
    private RString 給付区分コード;
    @CsvField(order = 183, name = "給付区分")
    private RString 給付区分;
}
