/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他住特施設変更通知書データEntity
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TatokuKanrenChohyoHenkoTsuchishoEntity {

    private RString 保険者郵便番号;
    private RString 文書番号;
    private RString 保険者住所;
    private RString 発行年月日;
    private RString 保険者名;
    private RString 保険者名敬称;
    private RString 担当部署名;
    private RString 担当部署名敬称;
    private RString バーコード情報;
    private RString 見出し１;
    private RString 見出し２;
    private RString 見出し３;
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
    private FlexibleDate 変更年月日;

    private AtenaMeisho 変更前施設名称;
    private TelNo 変更前施設電話番号;
    private TelNo 変更前施設FAX番号;
    private YubinNo 変更前施設郵便番号;
    private RString 変更前施設住所;

    private AtenaMeisho 変更後施設名称;
    private TelNo 変更後施設電話番号;
    private TelNo 変更後施設FAX番号;
    private YubinNo 変更後施設郵便番号;
    private RString 変更後施設住所;

    private RString 電子公印;
    private RString 証明発行日;
    private RString 首長名;
    private RString 市町村名;
    private RString 公印省略;

}
