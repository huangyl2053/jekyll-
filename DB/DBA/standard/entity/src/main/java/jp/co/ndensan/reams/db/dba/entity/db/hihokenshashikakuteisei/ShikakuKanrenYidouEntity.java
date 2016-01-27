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
 * 資格関連異動入力情報（List<資格関連異動Entity>）
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuKanrenYidouEntity {

    private RString 状態;
    private FlexibleDate 変更日;
    private FlexibleDate 変更届出日;
    private RString 変更事由コード;
    private RString 所在保険者;
    private RString 措置元保険者;
    private HokenshaNo 旧保険者;
}
