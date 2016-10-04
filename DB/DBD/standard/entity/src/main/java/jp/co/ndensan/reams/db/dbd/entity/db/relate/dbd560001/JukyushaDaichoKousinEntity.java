/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd560001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳更新対象データEntityです。
 *
 * @reamsid_L DBD-2120-020 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaDaichoKousinEntity {

    private RString 履歴番号;
    private HihokenshaNo 被保険者番号;
    private RString 受給申請事由;
    private ShinseishoKanriNo 申請書管理番号;
    private FlexibleDate 審査会依頼年月日;

}
