/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査票情報を定義したEntityクラスです。
 *
 * @reamsid_L DBE-0230-090 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaJohohyoEntity {

    private RString 厚労省IF識別コード;
    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 申請日_元号;
    private RString 申請日_年;
    private RString 申請日_月;
    private RString 申請日_日;
    private RString 作成日_元号;
    private RString 作成日_年;
    private RString 作成日_月;
    private RString 作成日_日;
    private RString 調査日_元号;
    private RString 調査日_年;
    private RString 調査日_月;
    private RString 調査日_日;
    private RString 審査日_元号;
    private RString 審査日_年;
    private RString 審査日_月;
    private RString 審査日_日;
    private RString タイトル;
    private RString 年齢;
    private RString 性別;
    private RString 郵便番号;
    private RString 電話;
    private RString 現住所;
    private RString 家族連絡先郵便番号;
    private RString 家族連絡先電話1;
    private RString 家族連絡先電話2;
    private RString 家族連絡先住所;
    private RString 家族連絡先名;
    private RString 家族連絡先関係;
    private RString 申請区分_申;
    private RString 申請区分_法;
    private RString 二次判定日;
    private RString 一次判定結果;
    private RString 二次判定結果;
    private RString 認定有効時間_月;
    private RString 認定有効時間From;
    private RString 認定有効時間To;
    private RString 状態像コード;
    private RString 特定疾病;
    private RString 審査会意見;
    private RString 前回判定日;
    private RString 前回判定結果;
    private RString 前回判定有効時間_月;
    private RString 前回判定有効時間From;
    private RString 前回判定有効時間To;
    private RString 調査実施日;
    private RString 実施場所コード;
    private RString 実施場所名称;
    private RString 実施場所イメージ;
    private RString 記入者;
    private RString 所属機関;
    private RString 市町村特別給付;
    private RString 市町村特別給付イメージ;
    private RString 介護保険給付外の在宅;
    private RString 介護保険給付外の在宅イメージ;
    private RString 施設利用;
    private RString 施設名;
    private RString 施設名イメージ;
    private RString 施設住所;
    private RString 施設住所イメージ;
    private RString 施設電話;
    private RString 施設電話イメージ;
    private RString 変更事由;
    private List<RString> サービス区分リスト;
    private List<RString> サービス区分リスト_22;
    private List<RString> 日常生活自立度リスト;
    private List<RString> 身体機能1_リスト;
    private List<RString> 身体機能2_リスト;
    private List<RString> 起居動作リスト;
    private List<RString> 認知機能リスト;
    private List<RString> 社会生活リスト;
    private List<RString> 行動障害リスト;
    private List<RString> 生活機能リスト;
    private List<RString> 特別な医療リスト;
    private List<RString> 身の回りリスト_32;
    private List<RString> 麻痺拘縮1_リスト_32;
    private List<RString> 麻痺拘縮2_リスト_32;
    private List<RString> 特別な医療リスト_32;
    private List<RString> 活動参加リスト_32;
    private List<RString> 移動リスト_32;
    private List<RString> 意思疎通リスト_32;
    private List<RString> 問題行動リスト_32;
    private List<RString> サービス区分リスト_32;
    private List<RString> 複雑動作リスト_32;
    private List<RString> 特別介護リスト_32;
    private List<RString> 身の回りリスト_42;
    private List<RString> 麻痺拘縮1_リスト_42;
    private List<RString> 麻痺拘縮2_リスト_42;
    private List<RString> 特別な医療リスト_42;
    private List<RString> 移動リスト_42;
    private List<RString> 意思疎通リスト_42;
    private List<RString> 問題行動リスト_42;
    private List<RString> サービス区分リスト_42;
    private List<RString> 複雑動作リスト_42;
    private List<RString> 特別介護リスト_42;
    private List<RString> 身の回りリスト_52;
    private List<RString> 麻痺拘縮1_リスト_52;
    private List<RString> 麻痺拘縮2_リスト_52;
    private List<RString> 特別な医療リスト_52;
    private List<RString> 移動リスト_52;
    private List<RString> 意思疎通リスト_52;
    private List<RString> 問題行動リスト_52;
    private List<RString> サービス区分リスト_52;
    private List<RString> 複雑動作リスト_52;
    private List<RString> 特別介護リスト_52;
    private RString サービス区分コード;
}
