/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka;

import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書（オルカ）のBusinessクラスです。
 *
 * @reamsid_L DBE-1600-020 lishengli
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshokinyuyoshiBusiness {

    private RString タイムスタンプ;
    private FlexibleDate 記入日;
    private RString 事業所番号;
    private FlexibleDate 送付日;
    private RString 依頼番号;
    private RString 保険者番号;
    private RString 保険者名称;
    private RString 被保険者番号;
    private FlexibleDate 申請日;
    private FlexibleDate 作成依頼日;
    private RString 患者名;
    private RString 患者名かな;
    private FlexibleDate 生年月日;
    private RString 患者_年齢;
    private RString 性別;
    private RString 郵便番号;
    private RString 住所;
    private RString 連絡先電話番号;
    private boolean 同意の有無;
    private RString 医師氏名;
    private RString 医師番号;
    private RString 医療機関名;
    private YubinNo 医療機関郵便番号;
    private RString 医療機関所在地;
    private RString 医療機関電話番号;
    private RString 医療機関FAX番号;
    private FlexibleDate 最終診察日;
    private RString 意見書作成回数;
    private RString 種別;
    private boolean 他科受診有無;
    private RString 他科名;
    private RString その他の他科名;
    private RString 診断名1;
    private FlexibleDate 発症年月日1;
    private RString 診断名2;
    private FlexibleDate 発症年月日2;
    private RString 診断名3;
    private FlexibleDate 発症年月日3;
    private RString 症状安定性;
    private RString 症状不安定時の具体的状況;
    private RString 経過及び治療内容;
    private RString 処置内容;
    private RString 特別な対応;
    private RString 失禁への対応;
    private RString 寝たきり度;
    private RString 認知症高齢者の日常生活自立度;
    private RString 短期記憶;
    private RString 認知能力;
    private RString 伝達能力;
    private RString 周辺症状有無;
    private RString 周辺症状詳細;
    private RString その他の周辺症状;
    private RString 精神神経症状有無;
    private RString 精神神経症状名;
    private RString 専門医受診有無;
    private RString 専門医受診科名;
    private RString 利き腕;
    private RString 身長;
    private RString 体重;
    private RString 体重の変化;
    private RString 四肢欠損;
    private RString 四肢欠損部位;
    private RString 麻痺;
    private RString 麻痺右上肢;
    private RString 麻痺右上肢程度;
    private RString 麻痺左上肢;
    private RString 麻痺左上肢程度;
    private RString 麻痺右下肢;
    private RString 麻痺右下肢程度;
    private RString 麻痺左下肢;
    private RString 麻痺左下肢程度;
    private RString 麻痺その他;
    private RString 麻痺その他部位;
    private RString 麻痺その他程度;
    private RString 筋力低下;
    private RString 筋力低下部位;
    private RString 筋力低下程度;
    private RString 関節拘縮;
    private RString 関節拘縮部位;
    private RString 関節拘縮程度;
    private RString 関節痛み;
    private RString 関節痛み部位;
    private RString 関節痛み程度;
    private RString 失調不随意運動;
    private RString 失調不随意運動上肢;
    private RString 失調不随意運動下肢;
    private RString 体幹;
    private RString 褥瘡;
    private RString 褥瘡部位;
    private RString 褥瘡程度;
    private RString その他皮膚疾患;
    private RString その他皮膚疾患部;
    private RString その他皮膚疾程度;
    private RString 屋外歩行;
    private RString 車いすの使用;
    private RString 歩行補助具_装具の使用;
    private RString 食事行為;
    private RString 現在の栄養状態;
    private RString 栄養_食生活上の留意点;
    private RString 発生可能性状態;
    private RString その他の状態名;
    private RString 対処方針内容;
    private RString サービス利用による生活機能の維持_改善の見通し;
    private RString 医学的管理の必要性;
    private RString その他の医学的管理;
    private RString サービス提供血圧;
    private RString サービス提供血圧留意事項;
    private RString サービス提供摂食;
    private RString サービス提供摂食留意事項;
    private RString サービス提供嚥下;
    private RString サービス提供嚥下留意事項;
    private RString サービス提供移動;
    private RString サービス提供移動留意事項;
    private RString サービス提供運動;
    private RString サービス提供運動留意事項;
    private RString サービス提供その他の留意事項;
    private RString 感染症有無;
    private RString 感染症名;
    private RString その他特記事項;
}
