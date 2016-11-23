/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5010001;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のEntity生成します。
 *
 * @reamsid_L DBD-2030-010 x_youyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaDataMobileEntity {

    private RString 申請書管理番号;
    private RString 厚労省IF識別コード;
    private RString 厚労省認定ソフトのバージョン;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private FlexibleDate 認定申請年月日;
    private RString 認定申請区分申請時コード;
    private RString 認定申請区分申請時;
    private RString 被保険者氏名;
    private RString 被保険者氏名カナ;
    private FlexibleDate 生年月日;
    private RString 年齢;
    private RString 性別;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
    private RString 保険者名;
    private FlexibleDate 認定調査依頼完了年月日;
    private RString 認定調査依頼履歴番号;
    private RString 認定調査委託先コード;
    private RString 調査委託先;
    private RString 委託先の事業者名称カナ;
    private RString 委託先の郵便番号;
    private RString 委託先の住所;
    private RString 委託先の電話番号;
    private RString 委託先のFAX番号;
    private RString 委託先の代表者名;
    private RString 委託先の代表者名カナ;
    private RString 委託先の調査委託区分;
    private boolean 委託先の特定調査員表示フラグ;
    private RString 委託先の割付定員;
    private RString 委託先の割付地区;
    private boolean 委託先の自動割付;
    private RString 委託先の機関の区分;
    private RString 認定調査員コード;
    private RString 調査員氏名;
    private RString 調査員の調査員氏名カナ;
    private RString 調査員の性別;
    private RString 調査員の調査員資格;
    private RString 調査員の地区コード;
    private RString 調査員の調査可能人数月;
    private RString 調査員の郵便番号;
    private RString 調査員の住所;
    private RString 調査員の電話番号;
    private RString 調査員のFAX番号;
    private RString 調査員の所属機関名称;
    private RString 概況特記テキストイメージ区分コード;
    private RString 概況特記テキストイメージ区分;
    private RString 認定調査依頼区分コード;
    private RString 認定調査依頼区分;
    private RString 認定調査回数;
    private FlexibleDate 認定調査実施年月日;
    private FlexibleDate 認定調査受領年月日;
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
    private FlexibleDate 認定調査特記事項受付年月日;
    private FlexibleDate 認定調査特記事項受領年月日;
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

}
