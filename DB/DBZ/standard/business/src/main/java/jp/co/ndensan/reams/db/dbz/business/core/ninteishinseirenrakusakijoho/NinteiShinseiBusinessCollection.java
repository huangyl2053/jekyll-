/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.ninteishinseirenrakusakikihon.NinteiShinseiRenrakusakiKihon;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 認定申請連絡先情報のビジネスコレクションクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiBusinessCollection implements Serializable{
    
     SubGyomuCode hdnDatabaseSubGyomuCode;
     ShinseishoKanriNo shinseishoKanriNo;
     List<NinteiShinseiRenrakusakiKihon> dbeBusiness;
     List<RenrakusakiJoho> dbdBusiness;
    
}
