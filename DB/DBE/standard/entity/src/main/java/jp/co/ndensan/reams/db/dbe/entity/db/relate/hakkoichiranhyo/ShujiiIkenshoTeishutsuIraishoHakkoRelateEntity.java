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
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity {

    private RString 申請書管理番号;
    private RString 証記載保険者番号;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 被保険者番号;
    private RString 年齢;
    private RString 住所;
    private RString 生年月日;
    private RString 性別;
    private RString 郵便番号;
    private RString 認定申請年月日;
    private RString 電話番号;
    private RString 主治医医療機関コード;
    private RString 主治医コード;
    private RString 医療機関住所;
    private RString 医療機関電話番号;
    private RString 医療機関FAX番号;
    private RString 医療機関郵便番号;
    private RString 医療機関名称;
    private RString 代表者名;
    private RString 主治医意見書依頼区分;
    private FlexibleDate 主治医意見書作成期限年月日;
    private RString 在宅施設区分;
    private FlexibleDate 主治医意見書作成依頼年月日;
    private RString 認定申請区分申請時コード;
    private RString 意見書作成回数区分;
    private RString 主治医意見書記入年月日;
    private RString 主治医意見書読取年月日;
    private RString 主治医氏名;
    private RString 保険者名;
    private RString 主治医意見書別途診療費;
    private RString 主治医意見書報酬支払年月日;
    private int 最大依頼履歴番号;
    private RString 直近区分;
}
