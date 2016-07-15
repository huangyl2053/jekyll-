/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力用認定調査実績集計表Builderクラスです。
 *
 * @reamsid_L DBE-1691-020 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoJissekiIchiranRelateEntity {

    private RString 証記載保険者番号;
    private RString 調査委託先コード;
    private RString 事業者名称;
    private RString 調査員コード;
    private RString 調査員氏名;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 認定調査実施年月日;
    private RString 認定調査区分コード;
    private RString 認定調査実施場所名称;
    private RString 認定調査依頼区分コード;
    private RString 申請書管理番号;
    private RString 認定調査依頼履歴番号;

}
