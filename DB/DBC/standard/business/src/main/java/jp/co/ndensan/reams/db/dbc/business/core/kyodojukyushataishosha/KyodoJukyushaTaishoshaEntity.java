/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 対象者一覧情報
 *
 * @reamsid_L DBC-1951-050 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoJukyushaTaishoshaEntity implements Serializable {

    private FlexibleDate 異動日;
    private FlexibleYearMonth 対象年月;
    private HihokenshaNo 被保番号;
    private RString 被保険者氏名;
    private int 履歴番号;
    private boolean 論理削除フラグ;

}
