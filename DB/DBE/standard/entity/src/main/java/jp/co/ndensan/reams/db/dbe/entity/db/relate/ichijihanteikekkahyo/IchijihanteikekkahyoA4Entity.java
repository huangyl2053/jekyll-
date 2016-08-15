/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用一次判定結果票A4のEntityクラスです。
 *
 * @reamsid_L DBE-0150-300 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchijihanteikekkahyoA4Entity {

    private RString 合議体番号;
    private RString 審査順;
    private RString 被保険者区分;
    private RString 申請区分;
    private RString 年齢;
    private RString 性別;
    private RString 現在の状況;
    private RString 前々回要介護度;
    private RString 前々回認定有効期間;
    private FlexibleDate 前々回認定有効期間開始年月日;
    private FlexibleDate 前々回認定有効期間終了年月日;
    private RString 前回要介護度;
    private RString 前回認定有効期間;
    private FlexibleDate 前回認定有効期間開始年月日;
    private FlexibleDate 前回認定有効期間終了年月日;
    private FlexibleDate 前回認定日;
    private RString 前回状態像;
    private RString 管理番号;
    private FlexibleDate 審査会資料作成年月日;
    private FlexibleDate 今回認定申請年月日;
    private FlexibleDate 今回認定調査実施年月日;
    private FlexibleDate 今回認定審査年月日;
    private RString 被保険者氏名;
    private RString 被保険者番号;
    private RString 保険者番号;
    private RString 支所名;
    private RString 市町村名;
    private RString 事業者番号;
    private RString 事業者名;
    private RString 認定調査員番号;
    private RString 認定調査員氏名;
    private RString 調査員資格;
    private RString 医療機関番号;
    private RString 医療機関名称;
    private RString 主治医番号;
    private RString 主治医氏名;
    private RString 一次判定結果;
    private RString 特定疾病名;
    private RString 状態像名称;
    private RString 要介護認定等基準時間;
    private RString 基準時間の積み上げグラフ;
    private RString 要介護認定等基準時間_食事;
    private RString 要介護認定等基準時間_排泄;
    private RString 要介護認定等基準時間_移動;
    private RString 要介護認定等基準時間_清潔保持;
    private RString 要介護認定等基準時間_間接;
    private RString 要介護認定等基準時間_BPSD関連;
    private RString 要介護認定等基準時間_機能訓練;
    private RString 要介護認定等基準時間_医療関連;
    private RString 要介護認定等基準時間_認知症加算;
    private RString 警告コード;
    private List<TyukanHyouka> 中間評価リスト;
    private List<NitijouSeikatsu> 日常生活自立度リスト;
    private RString 認定調査結果認知症高齢者自立度;
    private RString 意見書認知症高齢者自立度;
    private RString 認知症自立度Ⅱ以上の蓋然性;
    private RString 状態の安定性;
    private RString 給付区分;
    private RString sabisuKubun;
    private RString sabisuName1;
    private RString sabisuKaisu1;
    private RString sabisuName2;
    private RString sabisuKaisu2;
    private RString sabisuName3;
    private RString sabisuKaisu3;
    private RString sabisuName4;
    private RString sabisuKaisu4;
    private RString sabisuName5;
    private RString sabisuKaisu5;
    private RString sabisuName6;
    private RString sabisuKaisu6;
    private RString sabisuName7;
    private RString sabisuKaisu7;
    private RString sabisuName8;
    private RString sabisuKaisu8;
    private RString sabisuName9;
    private RString sabisuKaisu9;
    private RString sabisuName10;
    private RString sabisuKaisu10;
    private RString sabisuName11;
    private RString sabisuKaisu11;
    private RString sabisuName12;
    private RString sabisuKaisu12;
    private RString sabisuName13;
    private RString sabisuKaisu13;
    private RString sabisuName14;
    private RString sabisuKaisu14;
    private RString sabisuName15;
    private RString sabisuKaisu15;
    private RString sabisuName16;
    private RString sabisuKaisu16;
    private RString sabisuName17;
    private RString sabisuKaisu17;
    private RString sabisuName18;
    private RString sabisuKaisu18;
    private RString sabisuName19;
    private RString sabisuKaisu19;
    private RString sabisuName20;
    private RString sabisuKaisu20;
    private RString sabisuName21;
    private RString sabisuKaisu21;
    private List<RString> 特記リスト１;
    private List<TiyosaKekka> 第１群リスト;
    private List<RString> 特記リスト２;
    private List<TiyosaKekka> 第２群リスト;
    private List<RString> 特記リスト３;
    private List<TiyosaKekka> 第３群リスト;
    private List<RString> 特記リスト４;
    private List<TiyosaKekka> 第４群リスト;
    private List<RString> 特記リスト５;
    private List<TiyosaKekka> 第５群リスト;
    private List<RString> 特記リスト６;
    private List<TiyosaKekka> 特別な医療リスト１;
    private List<RString> 特記リスト７;
    private List<TiyosaKekka> 特別な医療リスト２;
    private List<TiyosaKekka> 主治医意見書;
    private RString 申請書管理番号;

}
