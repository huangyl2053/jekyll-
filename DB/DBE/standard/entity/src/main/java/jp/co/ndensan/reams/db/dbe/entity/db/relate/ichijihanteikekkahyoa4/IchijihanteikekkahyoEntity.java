/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定結果Entity。
 *
 * @reamsid_L DBE-0230-060 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchijihanteikekkahyoEntity {

    private RString タイトル;
    private RString 作成日_元号;
    private RString 作成日_年;
    private RString 作成日_月;
    private RString 作成日_日;
    private RString 申請日_元号;
    private RString 申請日_年;
    private RString 申請日_月;
    private RString 申請日_日;
    private RString 調査日_元号;
    private RString 調査日_年;
    private RString 調査日_月;
    private RString 調査日_日;
    private RString 審査日_元号;
    private RString 審査日_年;
    private RString 審査日_月;
    private RString 審査日_日;
    private RString 合議体番号;
    private RString 審査順;
    private RString 被保険者区分;
    private RString 申請区分;
    private RString 年齢;
    private RString 性別;
    private RString 現在の状況;
    private RString 前々回要介護度;
    private RString 前々回認定有効期間;
    private RString 前々回認定有効期間開始年月日;
    private RString 前々回認定有効期間終了年月日;
    private RString 前回要介護度;
    private RString 前回認定有効期間;
    private RString 前回認定有効期間開始年月日;
    private RString 前回認定有効期間終了年月日;
    private RString 前回認定日;
    private RString 前回状態像;
    private RString 管理番号;
    private RString 氏名;
    private RString 被保険者番号;
    private RString 保険者番号;
    private RString 所属;
    private RString 市町村名;
    private RString 事業者番号;
    private RString 事業者名;
    private RString 認定調査員番号;
    private RString 認定調査員氏名;
    private RString 認定調査員資格;
    private RString 医療機関番号;
    private RString 医療機関名称;
    private RString 主治医番号;
    private RString 主治医氏名;
    private RString 一次判定結果;
    private RString 二次判定結果;
    private RString 認定有効期間;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString 特定疾病名;
    private RString 状態像名称;
    private RString 要介護認定等基準時間;
    private RString 要介護認定等基準時間イメージ;
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
    private RString 中間評価項目得点第1群;
    private RString 中間評価項目得点第2群;
    private RString 中間評価項目得点第3群;
    private RString 中間評価項目得点第4群;
    private RString 中間評価項目得点第5群;
    private List<RString> 高齢者自立度リスト;
    private RString 認定調査結果認知症高齢者自立度;
    private RString 意見書認知症高齢者自立度;
    private RString 認知症自立度Ⅱ以上の蓋然性;
    private RString 状態の安定性;
    private RString 給付区分;
    private RString 現在のサービス利用状況名;
    private RString サービス名称1;
    private RString サービス名称2;
    private RString サービス名称3;
    private RString サービス名称4;
    private RString サービス名称5;
    private RString サービス名称6;
    private RString サービス名称7;
    private RString サービス名称8;
    private RString サービス名称9;
    private RString サービス名称10;
    private RString サービス名称11;
    private RString サービス名称12;
    private RString サービス名称13;
    private RString サービス名称14;
    private RString サービス名称15;
    private RString サービス名称16;
    private RString サービス名称17;
    private RString サービス名称18;
    private RString サービス名称19;
    private RString サービス名称20;
    private RString サービス名称21;
    private RString サービス回数1;
    private RString サービス回数2;
    private RString サービス回数3;
    private RString サービス回数4;
    private RString サービス回数5;
    private RString サービス回数6;
    private RString サービス回数7;
    private RString サービス回数8;
    private RString サービス回数9;
    private RString サービス回数10;
    private RString サービス回数11;
    private RString サービス回数12;
    private RString サービス回数13;
    private RString サービス回数14;
    private RString サービス回数15;
    private RString サービス回数16;
    private RString サービス回数17;
    private RString サービス回数18;
    private RString サービス回数19;
    private RString サービス回数20;
    private RString サービス回数21;
    private List<RString> 主治医意見書項目1リスト;
    private List<RString> 主治医意見書項目2リスト;
    private List<RString> 主治医意見書項目3リスト;
    private List<RString> 主治医意見書項目4リスト;
    private List<RString> 身体機能_起居動作リスト;
    private List<RString> 生活機能リスト;
    private List<RString> 認知機能リスト;
    private List<RString> 精神_行動障害リスト;
    private List<RString> 社会生活への適応リスト;
    private List<RString> 特別な医療1リスト;
    private List<RString> 特別な医療2リスト;
    private List<RString> 日常生活自立度リスト;
    private List<RString> 身体機能_起居動作1リスト;
    private List<RString> 身体機能_起居動作2リスト;
    private List<RString> 身体機能_起居動作3リスト;
    private List<RString> 身体機能_起居動作4リスト;
    private List<RString> 生活機能1リスト;
    private List<RString> 生活機能2リスト;
    private List<RString> 生活機能3リスト;
    private List<RString> 生活機能4リスト;
    private List<RString> 認知機能1リスト;
    private List<RString> 認知機能2リスト;
    private List<RString> 認知機能3リスト;
    private List<RString> 認知機能4リスト;
    private List<RString> 精神_行動障害1リスト;
    private List<RString> 精神_行動障害2リスト;
    private List<RString> 精神_行動障害3リスト;
    private List<RString> 精神_行動障害4リスト;
    private List<RString> 社会生活への適応1リスト;
    private List<RString> 社会生活への適応2リスト;
    private List<RString> 社会生活への適応3リスト;
    private List<RString> 社会生活への適応4リスト;
    private List<RString> 特別な医療3_1リスト;
    private List<RString> 特別な医療3_2リスト;
    private List<RString> 特別な医療4_1リスト;
    private List<RString> 特別な医療4_2リスト;
    private RString 厚労省IF識別コード;
    private RString 前回厚労省IF識別コード;
}
