/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ認定調査データ出力（モバイル）のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosaDataOutputBatchRelateEntity {

    private RString 申請書管理番号;
    private RString 厚労省IF識別コード;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 認定申請年月日;
    private RString 認定申請区分_申請時_コード;
    private RString 被保険者氏名;
    private RString 被保険者氏名カナ;
    private RString 生年月日;
    private RString 年齢;
    private RString 性別;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
    private RString 認定調査委託先コード;
    private RString 認定調査員コード;
    private RString 市町村名称;
    private RString 認定調査依頼完了年月日;
    private RString 認定調査依頼履歴番号;
    private RString 事業者名称;
    private RString 調査員氏名;
    private RString イメージ区分;
    private RString 認定調査依頼区分コード;
    private RString 認定調査回数;
    private RString 認定調査実施年月日;
    private RString 認定調査受領年月日;
    private RString 認定調査区分コード;
    private RString 認定調査実施場所コード;
    private RString 認定調査実施場所名称;
    private RString サービス区分コード;
    private RString 利用施設名;
    private RString 利用施設住所;
    private RString 利用施設電話番号;
    private RString 利用施設郵便番号;
    private RString 特記;
    private RString 認定調査特記事項受付年月日;
    private RString 認定調査特記事項受領年月日;
    private RString 住宅改修;
    private RString 市町村特別給付サービス種類名;
    private RString 在宅サービス種類名;
    private RString 主訴;
    private RString 家族状況;
    private RString 居住環境;
    private RString 機器_器械;
    private RString 認定調査特記事項番号;
    private RString 認定調査特記事項連番;
    private RString 原本マスク区分;
    private RString 特記事項;
    private RString 状況連番;
    private RString 状況;
    private RString 状況フラグ連番;
    private RString 状況フラグ;
    private RString 記入項目連番;
    private RString 状況記入;
    private RString 施設利用連番;
    private RString 施設利用フラグ;
    private RString 認知症日常生活自立度コード;
    private RString 障害日常生活自立度コード;
    private RString 調査項目連番;
    private RString 調査項目;
}
