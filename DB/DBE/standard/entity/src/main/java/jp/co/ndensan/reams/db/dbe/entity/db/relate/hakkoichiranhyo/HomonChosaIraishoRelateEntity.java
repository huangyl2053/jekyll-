/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問調査依頼書発行のRelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HomonChosaIraishoRelateEntity {

    private RString 申請書管理番号;
    private RString 被保険者番号;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 被保険者住所;
    private RString 生年月日;
    private RString 性別コード;
    private RString 被保険者住所_郵便番号;
    private RString 被保険者電話番号;
    private RString 要介護認定_更新申請日;
    private RString 申請区分コード;
    private RString 訪問調査先住所;
    private RString 訪問調査先電話番号;
    private RString 訪問調査先名称;
    private RString 訪問調査先住所_郵便番号;
    private RString 事業者番号;
    private RString 調査員名;
    private int 最大依頼履歴番号;
    private FlexibleDate 認定調査依頼年月日;
    private FlexibleDate 要介護認定調査表提出期限;
}
