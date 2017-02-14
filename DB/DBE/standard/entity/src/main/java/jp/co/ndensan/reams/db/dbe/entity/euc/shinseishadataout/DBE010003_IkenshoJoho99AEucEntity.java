/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書情報99AのCSV用Entityです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBE010003_IkenshoJoho99AEucEntity {

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
    @CsvField(order = 23, name = "（申請時）医療機関コード")
    private RString 申請時_医療機関コード;
    @CsvField(order = 24, name = "（申請時）医療機関名称")
    private RString 申請時_医療機関名称;
    @CsvField(order = 25, name = "（申請時）主治医コード")
    private RString 申請時_主治医コード;
    @CsvField(order = 26, name = "（申請時）主治医名")
    private RString 申請時_主治医名;
    @CsvField(order = 27, name = "依頼区分コード")
    private RString 依頼区分コード;
    @CsvField(order = 28, name = "依頼区分")
    private RString 依頼区分;
    @CsvField(order = 29, name = "（依頼時）医療機関コード")
    private RString 依頼時_医療機関コード;
    @CsvField(order = 30, name = "（依頼時）医療機関名称")
    private RString 依頼時_医療機関名称;
    @CsvField(order = 31, name = "（依頼時）主治医コード")
    private RString 依頼時_主治医コード;
    @CsvField(order = 32, name = "（依頼時）主治医名")
    private RString 依頼時_主治医名;
    @CsvField(order = 33, name = "（依頼時）医師区分コード")
    private RString 依頼時_医師区分コード;
    @CsvField(order = 34, name = "（依頼時）医師区分")
    private RString 依頼時_医師区分;
    @CsvField(order = 35, name = "（入手時）医療機関コード")
    private RString 入手時_医療機関コード;
    @CsvField(order = 36, name = "（入手時）医療機関名称")
    private RString 入手時_医療機関名称;
    @CsvField(order = 37, name = "（入手時）主治医コード")
    private RString 入手時_主治医コード;
    @CsvField(order = 38, name = "（入手時）主治医名")
    private RString 入手時_主治医名;
    @CsvField(order = 39, name = "受領日")
    private RString 受領日;
    @CsvField(order = 40, name = "記入日")
    private RString 記入日;
    @CsvField(order = 41, name = "読取日")
    private RString 読取日;
    @CsvField(order = 42, name = "最終診療日")
    private RString 最終診療日;
    @CsvField(order = 43, name = "意見書同意")
    private RString 意見書同意;
    @CsvField(order = 44, name = "意見書作成回数区分コード")
    private RString 意見書作成回数区分コード;
    @CsvField(order = 45, name = "意見書作成回数区分")
    private RString 意見書作成回数区分;
    @CsvField(order = 46, name = "在宅／施設区分コード")
    private RString 在宅or施設区分コード;
    @CsvField(order = 47, name = "在宅／施設区分")
    private RString 在宅or施設区分;
    @CsvField(order = 48, name = "他科受診の有無")
    private RString 他科受診の有無;
    @CsvField(order = 49, name = "内科受診の有無")
    private RString 内科受診の有無;
    @CsvField(order = 50, name = "精神科受診の有無")
    private RString 精神科受診の有無;
    @CsvField(order = 51, name = "外科受診の有無")
    private RString 外科受診の有無;
    @CsvField(order = 52, name = "整形外科受診の有無")
    private RString 整形外科受診の有無;
    @CsvField(order = 53, name = "脳神経外科受診の有無")
    private RString 脳神経外科受診の有無;
    @CsvField(order = 54, name = "皮膚科受診の有無")
    private RString 皮膚科受診の有無;
    @CsvField(order = 55, name = "泌尿器科受診の有無")
    private RString 泌尿器科受診の有無;
    @CsvField(order = 56, name = "婦人科受診の有無")
    private RString 婦人科受診の有無;
    @CsvField(order = 57, name = "耳鼻咽喉科受診の有無")
    private RString 耳鼻咽喉科受診の有無;
    @CsvField(order = 58, name = "リハビリテーション科受診の有無")
    private RString リハビリテーション科受診の有無;
    @CsvField(order = 59, name = "歯科受診の有無")
    private RString 歯科受診の有無;
    @CsvField(order = 60, name = "眼科受診の有無")
    private RString 眼科受診の有無;
    @CsvField(order = 61, name = "その他受診科の有無")
    private RString その他受診科の有無;
    @CsvField(order = 62, name = "その他受診科名")
    private RString その他受診科名;
    @CsvField(order = 63, name = "診断名１")
    private RString 診断名１;
    @CsvField(order = 64, name = "発症日１")
    private RString 発症日１;
    @CsvField(order = 65, name = "診断名２")
    private RString 診断名２;
    @CsvField(order = 66, name = "発症日２")
    private RString 発症日２;
    @CsvField(order = 67, name = "診断名３")
    private RString 診断名３;
    @CsvField(order = 68, name = "発症日３")
    private RString 発症日３;
    @CsvField(order = 69, name = "症状としての安定性コード")
    private RString 症状としての安定性コード;
    @CsvField(order = 70, name = "症状としての安定性")
    private RString 症状としての安定性;
    @CsvField(order = 71, name = "不安定状況")
    private RString 不安定状況;
    @CsvField(order = 72, name = "治療内容")
    private RString 治療内容;
    @CsvField(order = 73, name = "予後の見通し")
    private RString 予後の見通し;
    @CsvField(order = 74, name = "点滴の管理")
    private RString 点滴の管理;
    @CsvField(order = 75, name = "中心静脈栄養")
    private RString 中心静脈栄養;
    @CsvField(order = 76, name = "透析")
    private RString 透析;
    @CsvField(order = 77, name = "ストーマの処置")
    private RString ストーマの処置;
    @CsvField(order = 78, name = "酸素療法")
    private RString 酸素療法;
    @CsvField(order = 79, name = "レスピレーター")
    private RString レスピレーター;
    @CsvField(order = 80, name = "気管切開の処置")
    private RString 気管切開の処置;
    @CsvField(order = 81, name = "疼痛の看護")
    private RString 疼痛の看護;
    @CsvField(order = 82, name = "経管栄養")
    private RString 経管栄養;
    @CsvField(order = 83, name = "モニター測定")
    private RString モニター測定;
    @CsvField(order = 84, name = "じょくそうの処置")
    private RString じょくそうの処置;
    @CsvField(order = 85, name = "カテーテル")
    private RString カテーテル;
    @CsvField(order = 86, name = "寝たきり度")
    private RString 寝たきり度;
    @CsvField(order = 87, name = "認知症高齢者の日常生活自立度")
    private RString 認知症高齢者の日常生活自立度;
    @CsvField(order = 88, name = "短期記憶")
    private RString 短期記憶;
    @CsvField(order = 89, name = "認知能力")
    private RString 認知能力;
    @CsvField(order = 90, name = "伝達能力")
    private RString 伝達能力;
    @CsvField(order = 91, name = "食事")
    private RString 食事;
    @CsvField(order = 92, name = "認知症の周辺症状")
    private RString 認知症の周辺症状;
    @CsvField(order = 93, name = "幻視・幻聴")
    private RString 幻視_幻聴;
    @CsvField(order = 94, name = "妄想")
    private RString 妄想;
    @CsvField(order = 95, name = "昼夜逆転")
    private RString 昼夜逆転;
    @CsvField(order = 96, name = "暴言")
    private RString 暴言;
    @CsvField(order = 97, name = "暴行")
    private RString 暴行;
    @CsvField(order = 98, name = "介護への抵抗")
    private RString 介護への抵抗;
    @CsvField(order = 99, name = "徘徊_問題行動")
    private RString 徘徊_問題行動;
    @CsvField(order = 100, name = "火の不始末")
    private RString 火の不始末;
    @CsvField(order = 101, name = "不潔行為")
    private RString 不潔行為;
    @CsvField(order = 102, name = "異食行動")
    private RString 異食行動;
    @CsvField(order = 103, name = "性的問題行動")
    private RString 性的問題行動;
    @CsvField(order = 104, name = "その他")
    private RString その他;
    @CsvField(order = 105, name = "その他_症状")
    private RString その他_症状;
    @CsvField(order = 106, name = "その他の精神・神経症状")
    private RString その他の精神_神経症状;
    @CsvField(order = 107, name = "その他の精神・その他の精神・神経症状名")
    private RString その他の精神_神経症状名;
    @CsvField(order = 108, name = "専門医受診の有無")
    private RString 専門医受診の有無;
    @CsvField(order = 109, name = "専門医受診の有無_詳細")
    private RString 専門医受診の有無_詳細;
    @CsvField(order = 110, name = "利き腕")
    private RString 利き腕;
    @CsvField(order = 111, name = "身長")
    private RString 身長;
    @CsvField(order = 112, name = "体重")
    private RString 体重;
    @CsvField(order = 113, name = "四肢欠損")
    private RString 四肢欠損;
    @CsvField(order = 114, name = "四肢欠損_部位")
    private RString 四肢欠損_部位;
    @CsvField(order = 115, name = "四肢欠損　程度")
    private RString 四肢欠損_程度;
    @CsvField(order = 116, name = "麻痺")
    private RString 麻痺;
    @CsvField(order = 117, name = "麻痺_部位")
    private RString 麻痺_部位;
    @CsvField(order = 118, name = "麻痺　程度")
    private RString 麻痺_程度;
    @CsvField(order = 119, name = "筋力の低下")
    private RString 筋力の低下;
    @CsvField(order = 120, name = "筋力の低下_部位")
    private RString 筋力の低下_部位;
    @CsvField(order = 121, name = "筋力の低下　程度")
    private RString 筋力の低下_程度;
    @CsvField(order = 122, name = "じょくそう")
    private RString じょくそう;
    @CsvField(order = 123, name = "じょくそう_部位")
    private RString じょくそう_部位;
    @CsvField(order = 124, name = "じょくそう_程度")
    private RString じょくそう_程度;
    @CsvField(order = 125, name = "その他の皮膚疾患")
    private RString その他の皮膚疾患;
    @CsvField(order = 126, name = "その他の皮膚疾患_部位")
    private RString その他の皮膚疾患_部位;
    @CsvField(order = 127, name = "その他の皮膚疾患　程度")
    private RString その他の皮膚疾患_程度;
    @CsvField(order = 128, name = "関節の拘縮")
    private RString 関節の拘縮;
    @CsvField(order = 129, name = "関節の拘縮_肩関節_右")
    private RString 関節の拘縮_肩関節_右;
    @CsvField(order = 130, name = "関節の拘縮_肩関節_左")
    private RString 関節の拘縮_肩関節_左;
    @CsvField(order = 131, name = "関節の拘縮_股関節_右")
    private RString 関節の拘縮_股関節_右;
    @CsvField(order = 132, name = "関節の拘縮_股関節_左")
    private RString 関節の拘縮_股関節_左;
    @CsvField(order = 133, name = "関節の拘縮_肘関節_右")
    private RString 関節の拘縮_肘関節_右;
    @CsvField(order = 134, name = "関節の拘縮_肘関節_左")
    private RString 関節の拘縮_肘関節_左;
    @CsvField(order = 135, name = "関節の拘縮_膝関節_右")
    private RString 関節の拘縮_膝関節_右;
    @CsvField(order = 136, name = "関節の拘縮_膝関節_左")
    private RString 関節の拘縮_膝関節_左;
    @CsvField(order = 137, name = "失調・不随意運動")
    private RString 失調_不随意運動;
    @CsvField(order = 138, name = "失調・不随意運動_上肢_右")
    private RString 失調_不随意運動_上肢_右;
    @CsvField(order = 139, name = "失調・不随意運動_上肢_左")
    private RString 失調_不随意運動_上肢_左;
    @CsvField(order = 140, name = "失調・不随意運動_体幹_右")
    private RString 失調_不随意運動_体幹_右;
    @CsvField(order = 141, name = "失調・不随意運動_体幹_左")
    private RString 失調_不随意運動_体幹_左;
    @CsvField(order = 142, name = "失調・不随意運動_下肢_右")
    private RString 失調_不随意運動_下肢_右;
    @CsvField(order = 143, name = "失調・不随意運動_下肢_左")
    private RString 失調_不随意運動_下肢_左;
    @CsvField(order = 144, name = "尿失禁")
    private RString 尿失禁;
    @CsvField(order = 145, name = "転倒・骨折")
    private RString 転倒_骨折;
    @CsvField(order = 146, name = "徘徊_可能性が高い病態")
    private RString 徘徊_可能性が高い病態;
    @CsvField(order = 147, name = "褥瘡")
    private RString 褥瘡;
    @CsvField(order = 148, name = "嚥下性肺炎")
    private RString 嚥下性肺炎;
    @CsvField(order = 149, name = "腸閉塞")
    private RString 腸閉塞;
    @CsvField(order = 150, name = "易感染性")
    private RString 易感染性;
    @CsvField(order = 151, name = "心肺機能の低下")
    private RString 心肺機能の低下;
    @CsvField(order = 152, name = "がん等による疼痛")
    private RString がん等による疼痛;
    @CsvField(order = 153, name = "脱水")
    private RString 脱水;
    @CsvField(order = 154, name = "病態_その他")
    private RString 病態_その他;
    @CsvField(order = 155, name = "病態_その他_詳細")
    private RString 病態_その他_詳細;
    @CsvField(order = 156, name = "病態_対処方針")
    private RString 病態_対処方針;
    @CsvField(order = 157, name = "訪問診療")
    private RString 訪問診療;
    @CsvField(order = 158, name = "訪問診療_必要性")
    private RString 訪問診療_必要性;
    @CsvField(order = 159, name = "訪問看護")
    private RString 訪問看護;
    @CsvField(order = 160, name = "訪問看護_必要性")
    private RString 訪問看護_必要性;
    @CsvField(order = 161, name = "訪問リハビリテーション")
    private RString 訪問リハビリテーション;
    @CsvField(order = 162, name = "訪問リハビリテーション_必要性")
    private RString 訪問リハビリテーション_必要性;
    @CsvField(order = 163, name = "通所リハビリテーション")
    private RString 通所リハビリテーション;
    @CsvField(order = 164, name = "通所リハビリテーション_必要性")
    private RString 通所リハビリテーション_必要性;
    @CsvField(order = 165, name = "短期入所療養介護")
    private RString 短期入所療養介護;
    @CsvField(order = 166, name = "短期入所療養介護_必要性")
    private RString 短期入所療養介護_必要性;
    @CsvField(order = 167, name = "訪問歯科診療")
    private RString 訪問歯科診療;
    @CsvField(order = 168, name = "訪問歯科診療_必要性")
    private RString 訪問歯科診療_必要性;
    @CsvField(order = 169, name = "訪問歯科衛生指導")
    private RString 訪問歯科衛生指導;
    @CsvField(order = 170, name = "訪問歯科衛生指導_必要性")
    private RString 訪問歯科衛生指導_必要性;
    @CsvField(order = 171, name = "訪問薬剤管理指導")
    private RString 訪問薬剤管理指導;
    @CsvField(order = 172, name = "訪問薬剤管理指導_必要性")
    private RString 訪問薬剤管理指導_必要性;
    @CsvField(order = 173, name = "訪問栄養食事指導")
    private RString 訪問栄養食事指導;
    @CsvField(order = 174, name = "訪問栄養食事指導_必要性")
    private RString 訪問栄養食事指導_必要性;
    @CsvField(order = 175, name = "その他の医療系のサービス")
    private RString その他の医療系のサービス;
    @CsvField(order = 176, name = "その他の医療系のサービス_詳細")
    private RString その他の医療系のサービス_詳細;
    @CsvField(order = 177, name = "その他の医療系のサービス_必要性")
    private RString その他の医療系のサービス_必要性;
    @CsvField(order = 178, name = "介護サービスの留意事項_血圧")
    private RString 介護サービスの留意事項_血圧;
    @CsvField(order = 179, name = "介護サービスの留意事項_血圧_詳細")
    private RString 介護サービスの留意事項_血圧_詳細;
    @CsvField(order = 180, name = "介護サービスの留意事項_嚥下")
    private RString 介護サービスの留意事項_嚥下;
    @CsvField(order = 181, name = "介護サービスの留意事項_嚥下_詳細")
    private RString 介護サービスの留意事項_嚥下_詳細;
    @CsvField(order = 182, name = "介護サービスの留意事項_摂食")
    private RString 介護サービスの留意事項_摂食;
    @CsvField(order = 183, name = "介護サービスの留意事項_摂食_詳細")
    private RString 介護サービスの留意事項_摂食_詳細;
    @CsvField(order = 184, name = "介護サービスの留意事項_移動")
    private RString 介護サービスの留意事項_移動;
    @CsvField(order = 185, name = "介護サービスの留意事項_移動_詳細")
    private RString 介護サービスの留意事項_移動_詳細;
    @CsvField(order = 186, name = "介護サービスの留意事項_その他")
    private RString 介護サービスの留意事項_その他;
    @CsvField(order = 187, name = "感染症の有無")
    private RString 感染症の有無;
    @CsvField(order = 188, name = "感染症の有無_詳細")
    private RString 感染症の有無_詳細;
    @CsvField(order = 189, name = "特記事項")
    private RString 特記事項;
    @CsvField(order = 190, name = "二次判定結果の連絡確認")
    private RString 二次判定結果の連絡確認;
    @CsvField(order = 191, name = "意見書メモ")
    private RString 意見書メモ;
}
