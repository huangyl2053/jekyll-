/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.hihokenshashikakuteisei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格訂正情報Entity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuTeyiseyiEntity {

    private RString 状態;
    private FlexibleDate 異動日;
    private FlexibleDate 取得日;
    private FlexibleDate 取得届出日;
    private RString 取得事由コード;
    private RString 被保区分コード;
    private RString 所在保険者;
    private RString 措置元保険者;
    private HokenshaNo 旧保険者;
    private FlexibleDate 喪失日;
    private FlexibleDate 喪失届出日;
    private RString 喪失事由コード;
    private FlexibleDate 変更日;
    private FlexibleDate 変更届出日;
    private RString 変更事由コード;
    private FlexibleDate 適用日;
    private FlexibleDate 適用届出日;
    private RString 適用事由コード;
    private FlexibleDate 解除日;
    private FlexibleDate 解除届出日;
    private RString 解除事由コード;
}
