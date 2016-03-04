/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書提出依頼書発行RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity {

    private RString 申請書管理番号;
    private RString 被保険者番号;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 年齢;
    private RString 住所;
    private RString 生年月日;
    private RString 性別;
    private RString 郵便番号;
    private RString 認定申請日;
    private RString 申請区分コード;
    private RString 医療機関所在地;
    private RString 医療機関所電話;
    private RString 医療機関所FAX;
    private RString 主治医意見書依頼区分;
    private RString 現在の状況コード;
    private int 最大依頼履歴番号;
    private FlexibleDate 主治医意見書作成依頼年月日;
}
