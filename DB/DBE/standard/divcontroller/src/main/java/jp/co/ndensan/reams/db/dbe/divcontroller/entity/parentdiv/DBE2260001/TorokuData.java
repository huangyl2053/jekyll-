/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * イメージ取込み（規定・規定外）CSVファイルの項目のクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorokuData implements Serializable {

    private static final long serialVersionUID = 5345660945759531003L;

    private int 項目数;
    private RString OK_NG;
    @CsvField(order = 1, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 2, name = "申請日")
    private RString 申請日;
    @CsvField(order = 3, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 4, name = "同意の有無")
    private RString 同意の有無;
    @CsvField(order = 5, name = "最終診察日")
    private RString 最終診察日;
    @CsvField(order = 6, name = "記入日")
    private RString 記入日;
    @CsvField(order = 7, name = "受領日")
    private RString 受領日;
    @CsvField(order = 8, name = "意見書作成回数")
    private RString 意見書作成回数;
    @CsvField(order = 9, name = "他科受信の有無")
    private RString 他科受信の有無;
    @CsvField(order = 10, name = "内科")
    private RString 内科;
    @CsvField(order = 11, name = "皮膚科")
    private RString 皮膚科;
    @CsvField(order = 12, name = "リハビリテーション科")
    private RString リハビリテーション科;
    @CsvField(order = 13, name = "精神科")
    private RString 精神科;
    @CsvField(order = 14, name = "泌尿器科")
    private RString 泌尿器科;
    @CsvField(order = 15, name = "歯科")
    private RString 歯科;
    @CsvField(order = 16, name = "外科")
    private RString 外科;
    @CsvField(order = 17, name = "婦人科")
    private RString 婦人科;
    @CsvField(order = 18, name = "その他受診科の有無")
    private RString その他受診科の有無;
    @CsvField(order = 19, name = "整形外科")
    private RString 整形外科;
    @CsvField(order = 20, name = "眼科")
    private RString 眼科;
    @CsvField(order = 21, name = "脳神経外科")
    private RString 脳神経外科;
    @CsvField(order = 22, name = "耳鼻咽喉科")
    private RString 耳鼻咽喉科;
    @CsvField(order = 23, name = "発症年月日1")
    private RString 発症年月日1;
    @CsvField(order = 24, name = "発症年月日2")
    private RString 発症年月日2;
    @CsvField(order = 25, name = "発症年月日3")
    private RString 発症年月日3;
    @CsvField(order = 26, name = "症状の安定性")
    private RString 症状の安定性;
    @CsvField(order = 27, name = "点滴の管理")
    private RString 点滴の管理;
    @CsvField(order = 28, name = "ストーマの処置")
    private RString ストーマの処置;
    @CsvField(order = 29, name = "気管切開の処置")
    private RString 気管切開の処置;
    @CsvField(order = 30, name = "中心静脈栄養")
    private RString 中心静脈栄養;
    @CsvField(order = 31, name = "酸素療法")
    private RString 酸素療法;
    @CsvField(order = 32, name = "疼痛の看護")
    private RString 疼痛の看護;
    @CsvField(order = 33, name = "透折")
    private RString 透折;
    @CsvField(order = 34, name = "レスピレーター")
    private RString レスピレーター;
    @CsvField(order = 35, name = "経管栄養")
    private RString 経管栄養;
    @CsvField(order = 36, name = "モニター測定")
    private RString モニター測定;
    @CsvField(order = 37, name = "褥痩の処置")
    private RString 褥痩の処置;
    @CsvField(order = 38, name = "カテーテル")
    private RString カテーテル;
    @CsvField(order = 39, name = "障害高齢者の自立度")
    private RString 障害高齢者の自立度;
    @CsvField(order = 40, name = "認知症高齢者の自立度")
    private RString 認知症高齢者の自立度;
    @CsvField(order = 41, name = "短期記憶")
    private RString 短期記憶;
    @CsvField(order = 42, name = "認知能力")
    private RString 認知能力;
    @CsvField(order = 43, name = "伝達能力")
    private RString 伝達能力;
    @CsvField(order = 44, name = "問題行動の有無")
    private RString 問題行動の有無;
    @CsvField(order = 45, name = "幻視_幻聴")
    private RString 幻視_幻聴;
    @CsvField(order = 46, name = "火の不始末")
    private RString 火の不始末;
    @CsvField(order = 47, name = "妄想")
    private RString 妄想;
    @CsvField(order = 48, name = "不潔行為")
    private RString 不潔行為;
    @CsvField(order = 49, name = "昼夜逆転")
    private RString 昼夜逆転;
    @CsvField(order = 50, name = "異食行動")
    private RString 異食行動;
    @CsvField(order = 51, name = "暴言")
    private RString 暴言;
    @CsvField(order = 52, name = "性的問題行動")
    private RString 性的問題行動;
    @CsvField(order = 53, name = "暴行")
    private RString 暴行;
    @CsvField(order = 54, name = "その他")
    private RString その他;
    @CsvField(order = 55, name = "介護への抵抗")
    private RString 介護への抵抗;
    @CsvField(order = 56, name = "徘徊")
    private RString 徘徊;
    @CsvField(order = 57, name = "精神_神経症状")
    private RString 精神_神経症状;
    @CsvField(order = 58, name = "専門科医受診")
    private RString 専門科医受診;
    @CsvField(order = 59, name = "利き腕")
    private RString 利き腕;
    @CsvField(order = 60, name = "過去6ヶ月の体重の変化")
    private RString 過去6ヶ月の体重の変化;
    @CsvField(order = 61, name = "四肢欠損")
    private RString 四肢欠損;
    @CsvField(order = 62, name = "麻痺")
    private RString 麻痺;
    @CsvField(order = 63, name = "麻痺_右上肢")
    private RString 麻痺_右上肢;
    @CsvField(order = 64, name = "麻痺_右上肢_程度")
    private RString 麻痺_右上肢_程度;
    @CsvField(order = 65, name = "麻痺_右下肢")
    private RString 麻痺_右下肢;
    @CsvField(order = 66, name = "麻痺_右下肢_程度")
    private RString 麻痺_右下肢_程度;
    @CsvField(order = 67, name = "麻痺_左上肢")
    private RString 麻痺_左上肢;
    @CsvField(order = 68, name = "麻痺_左上肢_程度")
    private RString 麻痺_左上肢_程度;
    @CsvField(order = 69, name = "麻痺_左下肢")
    private RString 麻痺_左下肢;
    @CsvField(order = 70, name = "麻痺_左下肢_程度")
    private RString 麻痺_左下肢_程度;
    @CsvField(order = 71, name = "麻痺_その他")
    private RString 麻痺_その他;
    @CsvField(order = 72, name = "麻痺_その他_程度")
    private RString 麻痺_その他_程度;
    @CsvField(order = 73, name = "筋力低下")
    private RString 筋力低下;
    @CsvField(order = 74, name = "筋力低下_程度")
    private RString 筋力低下_程度;
    @CsvField(order = 75, name = "間接の拘縮")
    private RString 間接の拘縮;
    @CsvField(order = 76, name = "間接の拘縮_程度")
    private RString 間接の拘縮_程度;
    @CsvField(order = 77, name = "間接の痛み")
    private RString 間接の痛み;
    @CsvField(order = 78, name = "間接の痛み_程度")
    private RString 間接の痛み_程度;
    @CsvField(order = 79, name = "失調_不随意運動")
    private RString 失調_不随意運動;
    @CsvField(order = 80, name = "上肢_右")
    private RString 上肢_右;
    @CsvField(order = 81, name = "上肢_左")
    private RString 上肢_左;
    @CsvField(order = 82, name = "下肢_右")
    private RString 下肢_右;
    @CsvField(order = 83, name = "下肢_左")
    private RString 下肢_左;
    @CsvField(order = 84, name = "体幹_右")
    private RString 体幹_右;
    @CsvField(order = 85, name = "体幹_左")
    private RString 体幹_左;
    @CsvField(order = 86, name = "褥痩")
    private RString 褥痩;
    @CsvField(order = 87, name = "褥痩_程度_")
    private RString 褥痩_程度;
    @CsvField(order = 88, name = "その他皮膚疾患")
    private RString その他皮膚疾患;
    @CsvField(order = 89, name = "その他皮膚疾患_程度")
    private RString その他皮膚疾患_程度;
    @CsvField(order = 90, name = "屋外歩行")
    private RString 屋外歩行;
    @CsvField(order = 91, name = "車いすの使用")
    private RString 車いすの使用;
    @CsvField(order = 92, name = "歩行補助具_装具の使用")
    private RString 歩行補助具_装具の使用;
    @CsvField(order = 93, name = "歩行補助具_装具の使用_屋外")
    private RString 歩行補助具_装具の使用_屋外;
    @CsvField(order = 94, name = "歩行補助具_装具の使用_屋内")
    private RString 歩行補助具_装具の使用_屋内;
    @CsvField(order = 95, name = "食事行為")
    private RString 食事行為;
    @CsvField(order = 96, name = "現在の栄養状況")
    private RString 現在の栄養状況;
    @CsvField(order = 97, name = "尿失禁")
    private RString 尿失禁;
    @CsvField(order = 98, name = "転倒_骨折")
    private RString 転倒_骨折;
    @CsvField(order = 99, name = "移動能力の低下")
    private RString 移動能力の低下;
    @CsvField(order = 100, name = "褥瘡")
    private RString 褥瘡;
    @CsvField(order = 101, name = "心肺機能の低下")
    private RString 心肺機能の低下;
    @CsvField(order = 102, name = "閉じこもり")
    private RString 閉じこもり;
    @CsvField(order = 103, name = "意欲低下")
    private RString 意欲低下;
    @CsvField(order = 104, name = "高い病態_徘徊")
    private RString 高い病態_徘徊;
    @CsvField(order = 105, name = "低栄養")
    private RString 低栄養;
    @CsvField(order = 106, name = "摂食_嚥下機能低下")
    private RString 摂食_嚥下機能低下;
    @CsvField(order = 107, name = "脱水")
    private RString 脱水;
    @CsvField(order = 108, name = "易感染症")
    private RString 易感染症;
    @CsvField(order = 109, name = "がん等による疼痛")
    private RString がん等による疼痛;
    @CsvField(order = 110, name = "高い病態_その他")
    private RString 高い病態_その他;
    @CsvField(order = 111, name = "予後の見通し")
    private RString 予後の見通し;
    @CsvField(order = 112, name = "訪問診療")
    private RString 訪問診療;
    @CsvField(order = 113, name = "訪問看護")
    private RString 訪問看護;
    @CsvField(order = 114, name = "相談_支援")
    private RString 相談_支援;
    @CsvField(order = 115, name = "訪問歯科診療")
    private RString 訪問歯科診療;
    @CsvField(order = 116, name = "訪問薬剤管理指導")
    private RString 訪問薬剤管理指導;
    @CsvField(order = 117, name = "訪問リハビリテーション")
    private RString 訪問リハビリテーション;
    @CsvField(order = 118, name = "短期入所療養介護")
    private RString 短期入所療養介護;
    @CsvField(order = 119, name = "訪問歯科衛生指導")
    private RString 訪問歯科衛生指導;
    @CsvField(order = 120, name = "訪問栄養食事指導")
    private RString 訪問栄養食事指導;
    @CsvField(order = 121, name = "通所リハビリテーション")
    private RString 通所リハビリテーション;
    @CsvField(order = 122, name = "その他の医療系サービス")
    private RString その他の医療系サービス;
    @CsvField(order = 123, name = "訪問診療_必要性")
    private RString 訪問診療_必要性;
    @CsvField(order = 124, name = "訪問看護_必要性")
    private RString 訪問看護_必要性;
    @CsvField(order = 125, name = "相談_支援_必要性")
    private RString 相談_支援_必要性;
    @CsvField(order = 126, name = "訪問歯科診療_必要性")
    private RString 訪問歯科診療_必要性;
    @CsvField(order = 127, name = "訪問薬剤管理指導_必要性")
    private RString 訪問薬剤管理指導_必要性;
    @CsvField(order = 128, name = "訪問リハビリテーション_必要性")
    private RString 訪問リハビリテーション_必要性;
    @CsvField(order = 129, name = "短期入所療養介護_必要性")
    private RString 短期入所療養介護_必要性;
    @CsvField(order = 130, name = "訪問歯科衛生指導_必要性")
    private RString 訪問歯科衛生指導_必要性;
    @CsvField(order = 131, name = "訪問栄養食事指導_必要性")
    private RString 訪問栄養食事指導_必要性;
    @CsvField(order = 132, name = "通所リハビリテーション_必要性")
    private RString 通所リハビリテーション_必要性;
    @CsvField(order = 133, name = "その他の医療系サービス_必要性")
    private RString その他の医療系サービス_必要性;
    @CsvField(order = 134, name = "血圧")
    private RString 血圧;
    @CsvField(order = 135, name = "移動")
    private RString 移動;
    @CsvField(order = 136, name = "摂食")
    private RString 摂食;
    @CsvField(order = 137, name = "運動")
    private RString 運動;
    @CsvField(order = 138, name = "嚥下")
    private RString 嚥下;
    @CsvField(order = 139, name = "感染症")
    private RString 感染症;
    @CsvField(order = 140, name = "主治医への結果連絡")
    private RString 主治医への結果連絡;

    private RString t5101_証記載保険者番号;
    private RString t5101_被保険者番号;
    private RString t5101_被保険者氏名;
    private RString t5101_認定申請年月日;
    private RString t7051_市町村名称;
    private RString t5101_申請書管理番号;
    private RString t5115_イメージ共有ファイルID;
    private RString t5912_主治医コード;
    private RString t5912_主治医氏名;
    private RString t5911_主治医医療機関コード;
    private RString t5911_医療機関名称;
    private RString t5101_厚労省IF識別コード;
    private RString t5301_主治医意見書作成依頼年月日;
    private RString t5301_主治医意見書依頼区分;
    private RString t5301_主治医医療機関コード;
    private RString t5301_主治医コード;
    private int t5301_主治医意見書作成依頼履歴番号;
    private boolean t5101_施設入所の有無;
}
