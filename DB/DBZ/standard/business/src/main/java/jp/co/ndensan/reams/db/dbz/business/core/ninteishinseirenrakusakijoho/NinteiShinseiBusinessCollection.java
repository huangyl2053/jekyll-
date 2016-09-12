/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 認定申請連絡先情報のビジネスコレクションクラスです。
 *
 * @reamsid_L DBZ-1300-100 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiBusinessCollection implements Serializable {

    private static final long serialVersionUID = 8959145199481894810L;
    private List<RenrakusakiJoho> dbdBusiness;

}
