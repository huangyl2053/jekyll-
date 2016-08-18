/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2920001;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼情報データ受取（オルカ）のCSVEntityクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IraiJohoDataTorikomiCsvEntity implements Serializable {

    @CsvField(order = 1, name = "バージョン")
    private RString バージョン;
    @CsvField(order = 2, name = "ソフト名")
    private RString ソフト名;
    @CsvField(order = 3, name = "タイムスタンプ")
    private RString タイムスタンプ;
    @CsvField(order = 4, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 5, name = "保険者名称")
    private RString 保険者名称;
    @CsvField(order = 6, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 7, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 8, name = "申請日")
    private RString 申請日;
    @CsvField(order = 9, name = "作成依頼日")
    private RString 作成依頼日;
    @CsvField(order = 10, name = "送付日")
    private RString 送付日;
    @CsvField(order = 11, name = "依頼番号")
    private RString 依頼番号;
    @CsvField(order = 12, name = "医師番号")
    private RString 医師番号;
    @CsvField(order = 13, name = "種別")
    private RString 種別;
    @CsvField(order = 14, name = "記入日")
    private RString 記入日;
    @CsvField(order = 15, name = "患者名")
    private RString 患者名;
    @CsvField(order = 16, name = "患者名かな")
    private RString 患者名かな;
    @CsvField(order = 17, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 18, name = "患者_年齢")
    private RString 患者_年齢;
    @CsvField(order = 19, name = "性別")
    private RString 性別;
    @CsvField(order = 20, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 21, name = "住所")
    private RString 住所;
    @CsvField(order = 22, name = "連絡先電話番号")
    private RString 連絡先電話番号;
    @CsvField(order = 23, name = "医師氏名")
    private RString 医師氏名;
    @CsvField(order = 24, name = "医療機関名")
    private RString 医療機関名;
    @CsvField(order = 25, name = "医療機関郵便番号")
    private RString 医療機関郵便番号;
    @CsvField(order = 26, name = "医療機関所在地")
    private RString 医療機関所在地;
    @CsvField(order = 27, name = "医療機関電話番号")
    private RString 医療機関電話番号;
    @CsvField(order = 28, name = "医療機関FAX番号")
    private RString 医療機関FAX番号;
    @CsvField(order = 29, name = "同意の有無")
    private RString 同意の有無;
    @CsvField(order = 30, name = "最終診察日")
    private RString 最終診察日;
    @CsvField(order = 31, name = "意見書作成回数")
    private RString 意見書作成回数;
    @CsvField(order = 32, name = "他科受診有無")
    private RString 他科受診有無;
    @CsvField(order = 33, name = "他科名")
    private RString 他科名;
    @CsvField(order = 34, name = "その他の他科名")
    private RString その他の他科名;
    @CsvField(order = 35, name = "診断名1")
    private RString 診断名1;
    @CsvField(order = 36, name = "発症年月日1")
    private RString 発症年月日1;
    @CsvField(order = 37, name = "診断名2")
    private RString 診断名2;
    @CsvField(order = 38, name = "発症年月日2")
    private RString 発症年月日2;
    @CsvField(order = 39, name = "診断名3")
    private RString 診断名3;
    @CsvField(order = 40, name = "発症年月日3")
    private RString 発症年月日3;
    @CsvField(order = 41, name = "症状安定性")
    private RString 症状安定性;
    @CsvField(order = 42, name = "症状不安定時の具体的状況")
    private RString 症状不安定時の具体的状況;
    @CsvField(order = 43, name = "経過及び治療内容")
    private RString 経過及び治療内容;
    @CsvField(order = 44, name = "処置内容")
    private RString 処置内容;
    @CsvField(order = 45, name = "特別な対応")
    private RString 特別な対応;
    @CsvField(order = 46, name = "失禁への対応")
    private RString 失禁への対応;
    @CsvField(order = 47, name = "寝たきり度")
    private RString 寝たきり度;
    @CsvField(order = 48, name = "認知症高齢者の日常生活自立度")
    private RString 認知症高齢者の日常生活自立度;
    @CsvField(order = 49, name = "短期記憶")
    private RString 短期記憶;
    @CsvField(order = 50, name = "認知能力")
    private RString 認知能力;
    @CsvField(order = 51, name = "伝達能力")
    private RString 伝達能力;
    @CsvField(order = 52, name = "周辺症状有無")
    private RString 周辺症状有無;
    @CsvField(order = 53, name = "周辺症状詳細")
    private RString 周辺症状詳細;
    @CsvField(order = 54, name = "その他の周辺症状")
    private RString その他の周辺症状;
    @CsvField(order = 55, name = "精神神経症状有無")
    private RString 精神神経症状有無;
    @CsvField(order = 56, name = "精神神経症状名")
    private RString 精神神経症状名;
    @CsvField(order = 57, name = "専門医受診有無")
    private RString 専門医受診有無;
    @CsvField(order = 58, name = "専門医受診科名")
    private RString 専門医受診科名;
    @CsvField(order = 59, name = "利き腕")
    private RString 利き腕;
    @CsvField(order = 60, name = "身長")
    private RString 身長;
    @CsvField(order = 61, name = "体重")
    private RString 体重;
    @CsvField(order = 62, name = "体重の変化")
    private RString 体重の変化;
    @CsvField(order = 63, name = "四肢欠損")
    private RString 四肢欠損;
    @CsvField(order = 64, name = "四肢欠損部位")
    private RString 四肢欠損部位;
    @CsvField(order = 65, name = "麻痺")
    private RString 麻痺;
    @CsvField(order = 66, name = "麻痺右上肢")
    private RString 麻痺右上肢;
    @CsvField(order = 67, name = "麻痺右上肢程度")
    private RString 麻痺右上肢程度;
    @CsvField(order = 68, name = "麻痺左上肢")
    private RString 麻痺左上肢;
    @CsvField(order = 69, name = "麻痺左上肢程度")
    private RString 麻痺左上肢程度;
    @CsvField(order = 70, name = "麻痺右下肢")
    private RString 麻痺右下肢;
    @CsvField(order = 71, name = "麻痺右下肢程度")
    private RString 麻痺右下肢程度;
    @CsvField(order = 72, name = "麻痺左下肢")
    private RString 麻痺左下肢;
    @CsvField(order = 73, name = "麻痺左下肢程度")
    private RString 麻痺左下肢程度;
    @CsvField(order = 74, name = "麻痺その他")
    private RString 麻痺その他;
    @CsvField(order = 75, name = "麻痺その他部位")
    private RString 麻痺その他部位;
    @CsvField(order = 76, name = "麻痺その他程度")
    private RString 麻痺その他程度;
    @CsvField(order = 77, name = "筋力低下")
    private RString 筋力低下;
    @CsvField(order = 78, name = "筋力低下部位")
    private RString 筋力低下部位;
    @CsvField(order = 79, name = "筋力低下程度")
    private RString 筋力低下程度;
    @CsvField(order = 80, name = "関節拘縮")
    private RString 関節拘縮;
    @CsvField(order = 81, name = "関節拘縮部位")
    private RString 関節拘縮部位;
    @CsvField(order = 82, name = "関節拘縮程度")
    private RString 関節拘縮程度;
    @CsvField(order = 83, name = "関節痛み")
    private RString 関節痛み;
    @CsvField(order = 84, name = "関節痛み部位")
    private RString 関節痛み部位;
    @CsvField(order = 85, name = "関節痛み程度")
    private RString 関節痛み程度;
    @CsvField(order = 86, name = "失調不随意運動")
    private RString 失調不随意運動;
    @CsvField(order = 87, name = "失調不随意運動上肢")
    private RString 失調不随意運動上肢;
    @CsvField(order = 88, name = "失調不随意運動下肢")
    private RString 失調不随意運動下肢;
    @CsvField(order = 89, name = "体幹")
    private RString 体幹;
    @CsvField(order = 90, name = "褥瘡")
    private RString 褥瘡;
    @CsvField(order = 91, name = "褥瘡部位")
    private RString 褥瘡部位;
    @CsvField(order = 92, name = "褥瘡程度")
    private RString 褥瘡程度;
    @CsvField(order = 93, name = "その他皮膚疾患")
    private RString その他皮膚疾患;
    @CsvField(order = 94, name = "その他皮膚疾患部")
    private RString その他皮膚疾患部;
    @CsvField(order = 95, name = "その他皮膚疾程度")
    private RString その他皮膚疾程度;
    @CsvField(order = 96, name = "屋外歩行")
    private RString 屋外歩行;
    @CsvField(order = 97, name = "車いすの使用")
    private RString 車いすの使用;
    @CsvField(order = 98, name = "歩行補助具_装具の使用")
    private RString 歩行補助具_装具の使用;
    @CsvField(order = 99, name = "食事行為")
    private RString 食事行為;
    @CsvField(order = 100, name = "現在の栄養状態")
    private RString 現在の栄養状態;
    @CsvField(order = 101, name = "栄養_食生活上の留意点")
    private RString 栄養_食生活上の留意点;
    @CsvField(order = 102, name = "発生可能性状態")
    private RString 発生可能性状態;
    @CsvField(order = 103, name = "その他の状態名")
    private RString その他の状態名;
    @CsvField(order = 104, name = "対処方針内容")
    private RString 対処方針内容;
    @CsvField(order = 105, name = "サービス利用による生活機能の維持_改善の見通し")
    private RString サービス利用による生活機能の維持_改善の見通し;
    @CsvField(order = 106, name = "医学的管理の必要性")
    private RString 医学的管理の必要性;
    @CsvField(order = 107, name = "その他の医学的管理")
    private RString その他の医学的管理;
    @CsvField(order = 108, name = "サービス提供血圧")
    private RString サービス提供血圧;
    @CsvField(order = 109, name = "サービス提供血圧留意事項")
    private RString サービス提供血圧留意事項;
    @CsvField(order = 110, name = "サービス提供摂食")
    private RString サービス提供摂食;
    @CsvField(order = 111, name = "サービス提供摂食留意事項")
    private RString サービス提供摂食留意事項;
    @CsvField(order = 112, name = "サービス提供嚥下")
    private RString サービス提供嚥下;
    @CsvField(order = 113, name = "サービス提供嚥下留意事項")
    private RString サービス提供嚥下留意事項;
    @CsvField(order = 114, name = "サービス提供移動")
    private RString サービス提供移動;
    @CsvField(order = 115, name = "サービス提供移動留意事項")
    private RString サービス提供移動留意事項;
    @CsvField(order = 116, name = "サービス提供運動")
    private RString サービス提供運動;
    @CsvField(order = 117, name = "サービス提供運動留意事項")
    private RString サービス提供運動留意事項;
    @CsvField(order = 118, name = "サービス提供その他の留意事項")
    private RString サービス提供その他の留意事項;
    @CsvField(order = 119, name = "感染症有無")
    private RString 感染症有無;
    @CsvField(order = 120, name = "感染症名")
    private RString 感染症名;
    @CsvField(order = 121, name = "その他特記事項")
    private RString その他特記事項;
}
