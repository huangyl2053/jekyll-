/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2700011;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護サービスマスタのCSVファイルのエンティティです。
 *
 * @reamsid_L DBC-3400-030 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoServiceNaiyouCsvEntity {

    @CsvField(order = 1, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 2, name = "サービス項目コード")
    private RString サービス項目コード;
    @CsvField(order = 3, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 4, name = "適用開始年月日")
    private RString 適用開始年月日;
    @CsvField(order = 5, name = "適用終了年月日")
    private RString 適用終了年月日;
    @CsvField(order = 6, name = "サービス略称")
    private RString サービス略称;
    @CsvField(order = 7, name = "単位数（合成単位数）")
    private RString 単位数_合成単位数;
    @CsvField(order = 8, name = "単位数識別")
    private RString 単位数識別;
    @CsvField(order = 9, name = "算定単位")
    private RString 算定単位;
    @CsvField(order = 10, name = "きざみ値下限")
    private RString きざみ値下限;
    @CsvField(order = 11, name = "きざみ値上限")
    private RString きざみ値上限;
    @CsvField(order = 12, name = "きざみ幅")
    private RString きざみ幅;
    @CsvField(order = 13, name = "単位")
    private RString 単位;
    @CsvField(order = 14, name = "きざみ単位数")
    private RString きざみ単位数;
    @CsvField(order = 15, name = "合成識別区分")
    private RString 合成識別区分;
    @CsvField(order = 16, name = "定員超過_人員欠如識別区分")
    private RString 定員超過_人員欠如識別区分;
    @CsvField(order = 17, name = "時間延長サービス体制")
    private RString 時間延長サービス体制;
    @CsvField(order = 18, name = "食費_居住費区分")
    private RString 食費_居住費区分;
    @CsvField(order = 19, name = "日常生活活動訓練加算")
    private RString 日常生活活動訓練加算;
    @CsvField(order = 20, name = "運営基準減算算定区分")
    private RString 運営基準減算算定区分;
    @CsvField(order = 21, name = "事業所･施設区分")
    private RString 事業所_施設区分;
    @CsvField(order = 22, name = "人員配置区分")
    private RString 人員配置区分;
    @CsvField(order = 23, name = "非該当")
    private RString 非該当;
    @CsvField(order = 24, name = "経過的要介護")
    private RString 経過的要介護;
    @CsvField(order = 25, name = "要介護１")
    private RString 要介護１;
    @CsvField(order = 26, name = "要介護２")
    private RString 要介護２;
    @CsvField(order = 27, name = "要介護３")
    private RString 要介護３;
    @CsvField(order = 28, name = "要介護４")
    private RString 要介護４;
    @CsvField(order = 29, name = "要介護５")
    private RString 要介護５;
    @CsvField(order = 30, name = "旧措置者")
    private RString 旧措置者;
    @CsvField(order = 31, name = "食事標準負担区分")
    private RString 食事標準負担区分;
    @CsvField(order = 32, name = "身体生活識別区分")
    private RString 身体生活識別区分;
    @CsvField(order = 33, name = "サービス提供内容")
    private RString サービス提供内容;
    @CsvField(order = 34, name = "緊急時治療・所定疾患療養算定区分")
    private RString 緊急時治療_所定疾患療養算定区分;
    @CsvField(order = 35, name = "外泊・他科受診算定区分")
    private RString 外泊_他科受診算定区分;
    @CsvField(order = 36, name = "介護内容区分")
    private RString 介護内容区分;
    @CsvField(order = 37, name = "有資格者区分")
    private RString 有資格者区分;
    @CsvField(order = 38, name = "開始時間")
    private RString 開始時間;
    @CsvField(order = 39, name = "終了時間")
    private RString 終了時間;
    @CsvField(order = 40, name = "基本サービスコード")
    private RString 基本サービスコード;
    @CsvField(order = 41, name = "注加減算コード(1)")
    private RString 注加減算コード1;
    @CsvField(order = 42, name = "注加減算コード(2)")
    private RString 注加減算コード2;
    @CsvField(order = 43, name = "注加減算コード(3)")
    private RString 注加減算コード3;
    @CsvField(order = 44, name = "注加減算コード(4)")
    private RString 注加減算コード4;
    @CsvField(order = 45, name = "注加減算コード(5)")
    private RString 注加減算コード5;
    @CsvField(order = 46, name = "注加減算コード(6)")
    private RString 注加減算コード6;
    @CsvField(order = 47, name = "注加減算コード(7)")
    private RString 注加減算コード7;
    @CsvField(order = 48, name = "注加減算コード(8)")
    private RString 注加減算コード8;
    @CsvField(order = 49, name = "注加減算コード(9)")
    private RString 注加減算コード9;
    @CsvField(order = 50, name = "注加減算コード(10)")
    private RString 注加減算コード10;
    @CsvField(order = 51, name = "予備項目(1)")
    private RString 予備項目1;
    @CsvField(order = 52, name = "予備項目(2)")
    private RString 予備項目2;
    @CsvField(order = 53, name = "予備項目(3)")
    private RString 予備項目3;
    @CsvField(order = 54, name = "栄養士")
    private RString 栄養士;
    @CsvField(order = 55, name = "管理栄養士")
    private RString 管理栄養士;
    @CsvField(order = 56, name = "栄養ケア・マネジメント体制")
    private RString 栄養ケア_マネジメント体制;
    @CsvField(order = 57, name = "居室区分")
    private RString 居室区分;
    @CsvField(order = 58, name = "利用者負担区分")
    private RString 利用者負担区分;
    @CsvField(order = 59, name = "施設類型")
    private RString 施設類型;
    @CsvField(order = 60, name = "種類数加算算定区分")
    private RString 種類数加算算定区分;
    @CsvField(order = 61, name = "加算可能サービスコード(1)")
    private RString 加算可能サービスコード1;
    @CsvField(order = 62, name = "加算可能サービスコード(2)")
    private RString 加算可能サービスコード2;
    @CsvField(order = 63, name = "加算可能サービスコード(3)")
    private RString 加算可能サービスコード3;
    @CsvField(order = 64, name = "加算可能サービスコード(4)")
    private RString 加算可能サービスコード4;
    @CsvField(order = 65, name = "加算可能サービスコード(5)")
    private RString 加算可能サービスコード5;
    @CsvField(order = 66, name = "加算可能サービスコード(6)")
    private RString 加算可能サービスコード6;
    @CsvField(order = 67, name = "加算可能サービスコード(7)")
    private RString 加算可能サービスコード7;
    @CsvField(order = 68, name = "加算可能サービスコード(8)")
    private RString 加算可能サービスコード8;
    @CsvField(order = 69, name = "加算可能サービスコード(9)")
    private RString 加算可能サービスコード9;
    @CsvField(order = 70, name = "加算可能サービスコード(10)")
    private RString 加算可能サービスコード10;
    @CsvField(order = 71, name = "加算可能サービスコード(11)")
    private RString 加算可能サービスコード11;
    @CsvField(order = 72, name = "加算可能サービスコード(12)")
    private RString 加算可能サービスコード12;
    @CsvField(order = 73, name = "加算可能サービスコード(13)")
    private RString 加算可能サービスコード13;
    @CsvField(order = 74, name = "加算可能サービスコード(14)")
    private RString 加算可能サービスコード14;
    @CsvField(order = 75, name = "加算可能サービスコード(15)")
    private RString 加算可能サービスコード15;
    @CsvField(order = 76, name = "加算可能サービスコード(16)")
    private RString 加算可能サービスコード16;
    @CsvField(order = 77, name = "加算可能サービスコード(17)")
    private RString 加算可能サービスコード17;
    @CsvField(order = 78, name = "加算可能サービスコード(18)")
    private RString 加算可能サービスコード18;
    @CsvField(order = 79, name = "加算可能サービスコード(19)")
    private RString 加算可能サービスコード19;
    @CsvField(order = 80, name = "加算可能サービスコード(20)")
    private RString 加算可能サービスコード20;
    @CsvField(order = 81, name = "摘要欄記載条件")
    private RString 摘要欄記載条件;
    @CsvField(order = 82, name = "支給限度額対象区分")
    private RString 支給限度額対象区分;
    @CsvField(order = 83, name = "期間・時期")
    private RString 期間時期;
    @CsvField(order = 84, name = "回数・日数")
    private RString 回数日数;
    @CsvField(order = 85, name = "特別地域加算")
    private RString 特別地域加算;
    @CsvField(order = 86, name = "緊急時訪問看護加算")
    private RString 緊急時訪問看護加算;
    @CsvField(order = 87, name = "特別管理体制")
    private RString 特別管理体制;
    @CsvField(order = 88, name = "機能訓練指導体制")
    private RString 機能訓練指導体制;
    @CsvField(order = 89, name = "食事提供体制")
    private RString 食事提供体制;
    @CsvField(order = 90, name = "入浴介助体制")
    private RString 入浴介助体制;
    @CsvField(order = 91, name = "特別入浴介助体制")
    private RString 特別入浴介助体制;
    @CsvField(order = 92, name = "リハビリテーション機能強化")
    private RString リハビリテーション機能強化;
    @CsvField(order = 93, name = "療養環境基準")
    private RString 療養環境基準;
    @CsvField(order = 94, name = "障害者生活支援体制")
    private RString 障害者生活支援体制;
    @CsvField(order = 95, name = "常勤専従医師配置")
    private RString 常勤専従医師配置;
    @CsvField(order = 96, name = "夜間勤務条件基準")
    private RString 夜間勤務条件基準;
    @CsvField(order = 97, name = "医師配置基準")
    private RString 医師配置基準;
    @CsvField(order = 98, name = "精神科医療養指導")
    private RString 精神科医療養指導;
    @CsvField(order = 99, name = "個別リハビリテーション提供体制")
    private RString 個別リハビリテーション提供体制;
    @CsvField(order = 100, name = "認知症専門棟")
    private RString 認知症専門棟;
    @CsvField(order = 101, name = "食事提供の状況")
    private RString 食事提供の状況;
    @CsvField(order = 102, name = "特別食提供")
    private RString 特別食提供;
    @CsvField(order = 103, name = "送迎体制")
    private RString 送迎体制;
    @CsvField(order = 104, name = "夜間ケア")
    private RString 夜間ケア;
    @CsvField(order = 105, name = "居住費対策")
    private RString 居住費対策;
    @CsvField(order = 106, name = "介護職員欠員")
    private RString 介護職員欠員;
    @CsvField(order = 107, name = "看護職員欠員")
    private RString 看護職員欠員;
    @CsvField(order = 108, name = "介護従業者欠員")
    private RString 介護従業者欠員;
    @CsvField(order = 109, name = "介護支援専門員欠員")
    private RString 介護支援専門員欠員;
    @CsvField(order = 110, name = "医師欠員")
    private RString 医師欠員;
    @CsvField(order = 111, name = "理学療法士（PT）欠員")
    private RString 理学療法士PT欠員;
    @CsvField(order = 112, name = "作業療法士（OT）欠員")
    private RString 作業療法士OT欠員;
    @CsvField(order = 113, name = "言語聴覚士（ＳT）欠員")
    private RString 言語聴覚士ST欠員;
    @CsvField(order = 114, name = "公費番号(1)")
    private RString 公費番号1;
    @CsvField(order = 115, name = "公費番号(2)")
    private RString 公費番号2;
    @CsvField(order = 116, name = "公費番号(3)")
    private RString 公費番号3;
    @CsvField(order = 117, name = "公費番号(4)")
    private RString 公費番号4;
    @CsvField(order = 118, name = "公費番号(5)")
    private RString 公費番号5;
    @CsvField(order = 119, name = "公費番号(6)")
    private RString 公費番号6;
    @CsvField(order = 120, name = "公費番号(7)")
    private RString 公費番号7;
    @CsvField(order = 121, name = "公費番号(8)")
    private RString 公費番号8;
    @CsvField(order = 122, name = "公費番号(9)")
    private RString 公費番号9;
    @CsvField(order = 123, name = "公費番号(10)")
    private RString 公費番号10;
    @CsvField(order = 124, name = "公費番号(11)")
    private RString 公費番号11;
    @CsvField(order = 125, name = "公費番号(12)")
    private RString 公費番号12;
    @CsvField(order = 126, name = "公費番号(13)")
    private RString 公費番号13;
    @CsvField(order = 127, name = "公費番号(14)")
    private RString 公費番号14;
    @CsvField(order = 128, name = "公費番号(15)")
    private RString 公費番号15;
    @CsvField(order = 129, name = "公費番号(16)")
    private RString 公費番号16;
    @CsvField(order = 130, name = "公費番号(17)")
    private RString 公費番号17;
    @CsvField(order = 131, name = "公費番号(18)")
    private RString 公費番号18;
    @CsvField(order = 132, name = "公費番号(19)")
    private RString 公費番号19;
    @CsvField(order = 133, name = "公費番号(20)")
    private RString 公費番号20;
    @CsvField(order = 134, name = "章")
    private RString 章;
    @CsvField(order = 135, name = "部")
    private RString 部;
    @CsvField(order = 136, name = "部枝番")
    private RString 部枝番;
    @CsvField(order = 137, name = "節")
    private RString 節;
    @CsvField(order = 138, name = "項番１")
    private RString 項番１;
    @CsvField(order = 139, name = "項番２")
    private RString 項番２;
    @CsvField(order = 140, name = "経過措置年月日")
    private RString 経過措置年月日;
    @CsvField(order = 141, name = "サービス利用条件")
    private RString サービス利用条件;
    @CsvField(order = 142, name = "利用者取扱件数")
    private RString 利用者取扱件数;
    @CsvField(order = 143, name = "特定事業所集中減算算定区分")
    private RString 特定事業所集中減算算定区分;
    @CsvField(order = 144, name = "外部サービス種類コード")
    private RString 外部サービス種類コード;
    @CsvField(order = 145, name = "大規模事業所")
    private RString 大規模事業所;
    @CsvField(order = 146, name = "要支援１")
    private RString 要支援１;
    @CsvField(order = 147, name = "要支援２")
    private RString 要支援２;
    @CsvField(order = 148, name = "特定事業所加算（訪問介護）")
    private RString 特定事業所加算_訪問介護;
    @CsvField(order = 149, name = "ターミナルケア（看取り介護）体制")
    private RString ターミナルケア_看取り介護_体制;
    @CsvField(order = 150, name = "栄養マネジメント（改善）体制")
    private RString 栄養マネジメント_改善_体制;
    @CsvField(order = 151, name = "口腔機能向上体制")
    private RString 口腔機能向上体制;
    @CsvField(order = 152, name = "若年性認知症ケア体制")
    private RString 若年性認知症ケア体制;
    @CsvField(order = 153, name = "緊急受入体制")
    private RString 緊急受入体制;
    @CsvField(order = 154, name = "夜間看護体制")
    private RString 夜間看護体制;
    @CsvField(order = 155, name = "特定事業所加算（居宅介護支援）")
    private RString 特定事業所加算_居宅介護支援;
    @CsvField(order = 156, name = "ユニットケア体制")
    private RString ユニットケア体制;
    @CsvField(order = 157, name = "重度化対応体制")
    private RString 重度化対応体制;
    @CsvField(order = 158, name = "準ユニットケア体制")
    private RString 準ユニットケア体制;
    @CsvField(order = 159, name = "予備項目(159)")
    private RString 予備項目159;
    @CsvField(order = 160, name = "身体拘束廃止取組")
    private RString 身体拘束廃止取組;
    @CsvField(order = 161, name = "在宅・入所相互利用体制")
    private RString 在宅入所相互利用体制;
    @CsvField(order = 162, name = "運動器機能向上体制")
    private RString 運動器機能向上体制;
    @CsvField(order = 163, name = "事業所評価加算")
    private RString 事業所評価加算;
    @CsvField(order = 164, name = "医療連携体制")
    private RString 医療連携体制;
    @CsvField(order = 165, name = "小規模拠点集合体制")
    private RString 小規模拠点集合体制;
    @CsvField(order = 166, name = "加算可能サービスコード(21)")
    private RString 加算可能サービスコード21;
    @CsvField(order = 167, name = "加算可能サービスコード(22)")
    private RString 加算可能サービスコード22;
    @CsvField(order = 168, name = "加算可能サービスコード(23)")
    private RString 加算可能サービスコード23;
    @CsvField(order = 169, name = "加算可能サービスコード(24)")
    private RString 加算可能サービスコード24;
    @CsvField(order = 170, name = "加算可能サービスコード(25)")
    private RString 加算可能サービスコード25;
    @CsvField(order = 171, name = "加算可能サービスコード(26)")
    private RString 加算可能サービスコード26;
    @CsvField(order = 172, name = "加算可能サービスコード(27)")
    private RString 加算可能サービスコード27;
    @CsvField(order = 173, name = "加算可能サービスコード(28)")
    private RString 加算可能サービスコード28;
    @CsvField(order = 174, name = "加算可能サービスコード(29)")
    private RString 加算可能サービスコード29;
    @CsvField(order = 175, name = "加算可能サービスコード(30)")
    private RString 加算可能サービスコード30;
    @CsvField(order = 176, name = "加算制約条件")
    private RString 加算制約条件;
    @CsvField(order = 177, name = "サービス種別")
    private RString サービス種別;
    @CsvField(order = 178, name = "日割計算用サービスコード識別区分")
    private RString 日割計算用サービスコード識別区分;
    @CsvField(order = 179, name = "予備項目(179)")
    private RString 予備項目179;
    @CsvField(order = 180, name = "認知症ケア加算")
    private RString 認知症ケア加算;
    @CsvField(order = 181, name = "個別機能訓練体制")
    private RString 個別機能訓練体制;
    @CsvField(order = 182, name = "地域密着型サービス報酬識別区分")
    private RString 地域密着型サービス報酬識別区分;
    @CsvField(order = 183, name = "市町村独自加算(1)")
    private RString 市町村独自加算1;
    @CsvField(order = 184, name = "合計単位数(1)")
    private RString 合計単位数1;
    @CsvField(order = 185, name = "市町村独自加算(2)")
    private RString 市町村独自加算2;
    @CsvField(order = 186, name = "合計単位数(2)")
    private RString 合計単位数2;
    @CsvField(order = 187, name = "市町村独自加算(3)")
    private RString 市町村独自加算3;
    @CsvField(order = 188, name = "合計単位数(3)")
    private RString 合計単位数3;
    @CsvField(order = 189, name = "設備基準")
    private RString 設備基準;
    @CsvField(order = 190, name = "療養体制維持特別加算")
    private RString 療養体制維持特別加算;
    @CsvField(order = 191, name = "加算可能サービスコード(31)")
    private RString 加算可能サービスコード31;
    @CsvField(order = 192, name = "加算可能サービスコード(32)")
    private RString 加算可能サービスコード32;
    @CsvField(order = 193, name = "加算可能サービスコード(33)")
    private RString 加算可能サービスコード33;
    @CsvField(order = 194, name = "加算可能サービスコード(34)")
    private RString 加算可能サービスコード34;
    @CsvField(order = 195, name = "加算可能サービスコード(35)")
    private RString 加算可能サービスコード35;
    @CsvField(order = 196, name = "加算可能サービスコード(36)")
    private RString 加算可能サービスコード36;
    @CsvField(order = 197, name = "加算可能サービスコード(37)")
    private RString 加算可能サービスコード37;
    @CsvField(order = 198, name = "加算可能サービスコード(38)")
    private RString 加算可能サービスコード38;
    @CsvField(order = 199, name = "加算可能サービスコード(39)")
    private RString 加算可能サービスコード39;
    @CsvField(order = 200, name = "加算可能サービスコード(40)")
    private RString 加算可能サービスコード40;
    @CsvField(order = 201, name = "加算可能サービスコード(41)")
    private RString 加算可能サービスコード41;
    @CsvField(order = 202, name = "加算可能サービスコード(42)")
    private RString 加算可能サービスコード42;
    @CsvField(order = 203, name = "加算可能サービスコード(43)")
    private RString 加算可能サービスコード43;
    @CsvField(order = 204, name = "加算可能サービスコード(44)")
    private RString 加算可能サービスコード44;
    @CsvField(order = 205, name = "加算可能サービスコード(45)")
    private RString 加算可能サービスコード45;
    @CsvField(order = 206, name = "３級ヘルパー体制")
    private RString ヘルパー体制３級;
    @CsvField(order = 207, name = "小規模事業所加算（地域状況）")
    private RString 小規模事業所加算_地域状況;
    @CsvField(order = 208, name = "小規模事業所加算（規模状況）")
    private RString 小規模事業所加算_規模状況;
    @CsvField(order = 209, name = "サービス提供体制強化加算")
    private RString サービス提供体制強化加算;
    @CsvField(order = 210, name = "認知症短期集中リハビリ実施加算")
    private RString 認知症短期集中リハビリ実施加算;
    @CsvField(order = 211, name = "若年性認知症利用者等受入加算")
    private RString 若年性認知症利用者等受入加算;
    @CsvField(order = 212, name = "看護体制加算")
    private RString 看護体制加算;
    @CsvField(order = 213, name = "夜勤職員配置加算")
    private RString 夜勤職員配置加算;
    @CsvField(order = 214, name = "療養食加算")
    private RString 療養食加算;
    @CsvField(order = 215, name = "予備項目215")
    private RString 予備項目215;
    @CsvField(order = 216, name = "予備項目216")
    private RString 予備項目216;
    @CsvField(order = 217, name = "日常生活継続支援加算")
    private RString 日常生活継続支援加算;
    @CsvField(order = 218, name = "認知症専門ケア加算")
    private RString 認知症専門ケア加算;
    @CsvField(order = 219, name = "２４時間通報対応加算")
    private RString 通報対応加算２４時間;
    @CsvField(order = 220, name = "看護職員配置加算")
    private RString 看護職員配置加算;
    @CsvField(order = 221, name = "夜間ケア加算")
    private RString 夜間ケア加算;
    @CsvField(order = 222, name = "中山間地域等サービス提供加算")
    private RString 中山間地域等サービス提供加算;
    @CsvField(order = 223, name = "市町村独自加算（４）")
    private RString 市町村独自加算4;
    @CsvField(order = 224, name = "合計単位数（４）")
    private RString 合計単位数4;
    @CsvField(order = 225, name = "市町村独自加算（５）")
    private RString 市町村独自加算5;
    @CsvField(order = 226, name = "合計単位数（５）")
    private RString 合計単位数5;
    @CsvField(order = 227, name = "市町村独自加算（６）")
    private RString 市町村独自加算6;
    @CsvField(order = 228, name = "合計単位数（６）")
    private RString 合計単位数6;
    @CsvField(order = 229, name = "市町村独自加算（７）")
    private RString 市町村独自加算7;
    @CsvField(order = 230, name = "合計単位数（７）")
    private RString 合計単位数7;
    @CsvField(order = 231, name = "市町村独自加算（8）")
    private RString 市町村独自加算8;
    @CsvField(order = 232, name = "合計単位数（8）")
    private RString 合計単位数8;
    @CsvField(order = 233, name = "市町村独自加算（9）")
    private RString 市町村独自加算9;
    @CsvField(order = 234, name = "合計単位数（9）")
    private RString 合計単位数9;
    @CsvField(order = 235, name = "市町村独自加算（10）")
    private RString 市町村独自加算10;
    @CsvField(order = 236, name = "合計単位数（10）")
    private RString 合計単位数10;
    @CsvField(order = 237, name = "市町村独自報酬")
    private RString 市町村独自報酬;
    @CsvField(order = 238, name = "上限単位数")
    private RString 上限単位数;
    @CsvField(order = 239, name = "加算可能サービスコード(46)")
    private RString 加算可能サービスコード46;
    @CsvField(order = 240, name = "加算可能サービスコード(47)")
    private RString 加算可能サービスコード47;
    @CsvField(order = 241, name = "加算可能サービスコード(48)")
    private RString 加算可能サービスコード48;
    @CsvField(order = 242, name = "加算可能サービスコード(49)")
    private RString 加算可能サービスコード49;
    @CsvField(order = 243, name = "加算可能サービスコード(50)")
    private RString 加算可能サービスコード50;
    @CsvField(order = 244, name = "加算可能サービスコード(51)")
    private RString 加算可能サービスコード51;
    @CsvField(order = 245, name = "加算可能サービスコード(52)")
    private RString 加算可能サービスコード52;
    @CsvField(order = 246, name = "加算可能サービスコード(53)")
    private RString 加算可能サービスコード53;
    @CsvField(order = 247, name = "加算可能サービスコード(54)")
    private RString 加算可能サービスコード54;
    @CsvField(order = 248, name = "加算可能サービスコード(55)")
    private RString 加算可能サービスコード55;
    @CsvField(order = 249, name = "サービス提供責任者体制の減算")
    private RString サービス提供責任者体制の減算;
    @CsvField(order = 250, name = "緊急短期入所体制確保加算")
    private RString 緊急短期入所体制確保加算;
    @CsvField(order = 251, name = "短期集中個別リハビリ実施加算")
    private RString 短期集中個別リハビリ実施加算;
    @CsvField(order = 252, name = "在宅復帰・在宅療養支援機能加算")
    private RString 在宅復帰_在宅療養支援機能加算;
    @CsvField(order = 253, name = "生活機能向上グループ活動加算")
    private RString 生活機能向上グループ活動加算;
    @CsvField(order = 254, name = "介護職員処遇改善加算")
    private RString 介護職員処遇改善加算;
    @CsvField(order = 255, name = "日中の身体介護２０分未満体制")
    private RString 日中の身体介護２０分未満体制;
    @CsvField(order = 256, name = "同一建物に居住する利用者の減算")
    private RString 同一建物に居住する利用者の減算;
    @CsvField(order = 257, name = "介護職員処遇改善加算単位数")
    private RString 介護職員処遇改善加算単位数;
    @CsvField(order = 258, name = "介護職員処遇改善加算単位数識別")
    private RString 介護職員処遇改善加算単位数識別;
    @CsvField(order = 259, name = "総合事業サービス類型")
    private RString 総合事業サービス類型;
    @CsvField(order = 260, name = "総合事業サービス事業対象者")
    private RString 総合事業サービス事業対象者;
    @CsvField(order = 261, name = "総合事業サービス識別区分")
    private RString 総合事業サービス識別区分;
    @CsvField(order = 262, name = "総合事業サービス内容変更区分")
    private RString 総合事業サービス内容変更区分;
    @CsvField(order = 263, name = "総合事業定率・定額区分")
    private RString 総合事業定率_定額区分;
    @CsvField(order = 264, name = "リハビリマネジメン加算")
    private RString リハビリマネジメン加算;
    @CsvField(order = 265, name = "看護体制強化加算")
    private RString 看護体制強化加算;
    @CsvField(order = 266, name = "短期集中リハビリ実施加算")
    private RString 短期集中リハビリ実施加算;
    @CsvField(order = 267, name = "社会参加支援加算")
    private RString 社会参加支援加算;
    @CsvField(order = 268, name = "認知症加算")
    private RString 認知症加算;
    @CsvField(order = 269, name = "中重度者ケア体制加算")
    private RString 中重度者ケア体制加算;
    @CsvField(order = 270, name = "個別送迎体制強化加算")
    private RString 個別送迎体制強化加算;
    @CsvField(order = 271, name = "入浴介助体制強化加算")
    private RString 入浴介助体制強化加算;
    @CsvField(order = 272, name = "予備項目(272)")
    private RString 予備項目272;
    @CsvField(order = 273, name = "生活行為向上リハビリ実施加算")
    private RString 生活行為向上リハビリ実施加算;
    @CsvField(order = 274, name = "予備項目(274)")
    private RString 予備項目274;
    @CsvField(order = 275, name = "予備項目(275)")
    private RString 予備項目275;
    @CsvField(order = 276, name = "医療連携強化加算")
    private RString 医療連携強化加算;
    @CsvField(order = 277, name = "予備項目(277)")
    private RString 予備項目277;
    @CsvField(order = 278, name = "特定事業所集中減算")
    private RString 特定事業所集中減算;
    @CsvField(order = 279, name = "予備項目(279)")
    private RString 予備項目279;
    @CsvField(order = 280, name = "予備項目(280)")
    private RString 予備項目280;
    @CsvField(order = 281, name = "予備項目(281)")
    private RString 予備項目281;
    @CsvField(order = 282, name = "予備項目(282)")
    private RString 予備項目282;
    @CsvField(order = 283, name = "予備項目(283)")
    private RString 予備項目283;
    @CsvField(order = 284, name = "選択的サービス複数実施加算")
    private RString 選択的サービス複数実施加算;
    @CsvField(order = 285, name = "総合マネジメント体制強化加算")
    private RString 総合マネジメント体制強化加算;
    @CsvField(order = 286, name = "予備項目(286)")
    private RString 予備項目286;
    @CsvField(order = 287, name = "予備項目(287)")
    private RString 予備項目287;
    @CsvField(order = 288, name = "看取り連携体制加算")
    private RString 看取り連携体制加算;
    @CsvField(order = 289, name = "訪問体制強化加算")
    private RString 訪問体制強化加算;
    @CsvField(order = 290, name = "夜間支援体制加算")
    private RString 夜間支援体制加算;
    @CsvField(order = 291, name = "訪問看護体制減算")
    private RString 訪問看護体制減算;
    @CsvField(order = 292, name = "訪問看護体制強化加算")
    private RString 訪問看護体制強化加算;
    @CsvField(order = 293, name = "予備項目(293)")
    private RString 予備項目293;
    @CsvField(order = 294, name = "予備項目(294)")
    private RString 予備項目294;
    @CsvField(order = 295, name = "予備項目(295)")
    private RString 予備項目295;
    @CsvField(order = 296, name = "予備項目(296)")
    private RString 予備項目296;
    @CsvField(order = 297, name = "予備項目(297)")
    private RString 予備項目297;
    @CsvField(order = 298, name = "予備項目(298)")
    private RString 予備項目298;
    @CsvField(order = 299, name = "予備項目(299)")
    private RString 予備項目299;
    @CsvField(order = 300, name = "予備項目(300)")
    private RString 予備項目300;

}
