/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他住特施設連絡票データEntity
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TatokuKanrenChohyoRenrakuhyoEntity {

    private RString 保険者郵便番号;
    private RString 文書番号;
    private RString 保険者住所;
    private RString 発行年月日;
    private RString 保険者名;
    private RString 保険者名敬称;
    private RString 担当部署名;
    private RString 担当部署名敬称;
    private RString バーコード情報;
    private RString 見出し;

    private RString 被保険者番号１;
    private RString 被保険者番号２;
    private RString 被保険者番号３;
    private RString 被保険者番号４;
    private RString 被保険者番号５;
    private RString 被保険者番号６;
    private RString 被保険者番号７;
    private RString 被保険者番号８;
    private RString 被保険者番号９;
    private RString 被保険者番号１０;
    private RString 対象者名カナ;
    private RString 対象者名;
    private RString 誕生日;
    private RString 性別;
    private RString 郵便番号;
    private RString 住所;
    private FlexibleDate 転入年月日;
    private FlexibleDate 入所年月日;
    private RString 施設名称;
    private RString 施設電話番号;
    private RString 施設FAX番号;
    private RString 施設郵便番号;
    private RString 施設住所;
    private RString 電子公印;
    private RString 証明発行日;
    private RString 首長名;
    private RString 市町村名;
    private RString 公印省略;

}
