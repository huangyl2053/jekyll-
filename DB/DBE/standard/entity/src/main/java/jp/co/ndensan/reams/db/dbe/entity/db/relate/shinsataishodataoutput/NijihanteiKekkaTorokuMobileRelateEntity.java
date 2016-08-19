/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 二次判定結果登録用データ（モバイル）のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NijihanteiKekkaTorokuMobileRelateEntity {

    private RString 介護認定審査会開催番号;
    private RString 合議体番号;
    private RString 介護認定審査会開催年月日;
    private RString 介護認定審査会開始時刻;
    private RString 介護認定審査会終了時刻;
    private RString 介護認定審査会開催場所コード;
    private RString 所要時間合計;
    private RString 介護認定審査会実施人数;
    private RString 介護認定審査会審査順;
    private RString 判定結果コード;
    private RString 二次判定年月日;
    private RString 二次判定要介護状態区分コード;
    private RString 二次判定認定有効期間;
    private RString 二次判定認定有効開始年月日;
    private RString 二次判定認定有効終了年月日;
    private RString 介護認定審査会意見;
    private RString 一次判定結果変更理由;
    private RString 要介護状態像例コード;
    private RString 認定審査会意見種類;
    private RString 審査会メモ;
    private RString 二次判定結果入力方法;
    private RString 二次判定結果入力年月日;
    private RString 認定申請区分法令コード;
    private RString 要介護認定1_5次判定年月日;
    private RString 要介護認定1_5次判定結果コード;
    private RString 要介護認定1_5次判定結果コード認知症加算;
    private RString 要介護認定等基準時間;
    private RString 要介護認定等基準時間食事;
    private RString 要介護認定等基準時間排泄;
    private RString 要介護認定等基準時間移動;
    private RString 要介護認定等基準時間清潔保持;
    private RString 要介護認定等基準時間間接ケア;
    private RString 要介護認定等基準時間BPSD関連;
    private RString 要介護認定等基準時間機能訓練;
    private RString 要介護認定等基準時間医療関連;
    private RString 要介護認定等基準時間認知症加算;
    private RString 中間評価項目得点第1群;
    private RString 中間評価項目得点第2群;
    private RString 中間評価項目得点第3群;
    private RString 中間評価項目得点第4群;
    private RString 中間評価項目得点第5群;
    private RString 要介護認定1_5次判定警告コード;
    private RString 要介護認定状態の安定性コード;
    private RString 認知症自立度Ⅱ以上の蓋然性;
    private RString 認知機能及び状態安定性から推定される給付区分コード;
    private RString 申請書管理番号;
    private RString 厚労省IF識別コード;
    private RString 厚労省認定ソフトのバージョン;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 認定申請年月日;
    private RString 認定申請区分申請時コード;
    private RString 認定申請区分申請時;
    private RString 被保険者氏名;
    private RString 被保険者氏名カナ;
    private RString 生年月日;
    private RString 年齢;
    private RString 性別;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
    private RString 保険者名;
    private RString 一次判定年月日;
    private RString 要介護認定一次判定結果コード;
    private RString 認定調査依頼完了年月日;
    private RString 認定調査依頼履歴番号;
    private RString 認定調査委託先コード;
    private RString 調査委託先;
    private RString 認定調査員コード;
    private RString 調査員氏名;
    private RString 概況特記テキストイメージ区分コード;
    private RString 概況特記テキストイメージ区分;
    private RString 認定調査依頼区分コード;
    private RString 認定調査依頼区分;
    private RString 認定調査回数;
    private RString 認定調査実施年月日;
    private RString 認定調査受領年月日;
    private RString 認定調査区分コード;
    private RString 認定調査区分;
    private RString 認定調査実施場所コード;
    private RString 認定調査実施場所;
    private RString 認定調査実施場所名称;
    private RString 認定調査サービス区分コード;
    private RString 認定調査サービス区分;
    private RString 利用施設名;
    private RString 利用施設住所;
    private RString 利用施設電話番号;
    private RString 利用施設郵便番号;
    private RString 特記;
    private RString 認定調査特記事項受付年月日;
    private RString 認定調査特記事項受領年月日;
    private RString 住宅改修改修箇所;
    private RString 市町村特別給付サービス種類名;
    private RString 介護保険給付以外の在宅サービス種類名;
    private RString 概況特記事項主訴;
    private RString 概況特記事項家族状況;
    private RString 概況特記事項居住環境;
    private RString 概況特記事項機器器械;
    private RString 認定調査特記事項番号;
    private RString 認定調査特記事項連番;
    private RString 原本マスク区分コード;
    private RString 原本マスク区分;
    private RString 特記事項;
    private RString サービスの状況連番;
    private RString サービスの状況;
    private RString サービスの状況フラグ連番;
    private RString サービスの状況フラグ;
    private RString 記入項目連番;
    private RString サービスの状況記入;
    private RString 施設利用連番;
    private RString 施設利用フラグ;
    private RString 認定調査認知症高齢者の日常生活自立度コード;
    private RString 認定調査認知症高齢者の日常生活自立度;
    private RString 認定調査障害高齢者の日常生活自立度コード;
    private RString 認定調査障害高齢者の日常生活自立度;
    private RString 調査項目連番;
    private RString 調査項目文言;
    private RString 内容;
    private RString イメージ共有ファイルID;
}
