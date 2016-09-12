/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.iryohokenkanyujokyo;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashikakuteisei.IryoHokenJoho;
import lombok.Getter;
import lombok.Setter;

/**
 * 医療保険加入情報管理のビジネスクラスです。
 *
 * @reamsid_L DBA-1230-010 yaoyahui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IryohokenKanyuJokyoBusiness implements Serializable {

    private List<IryoHokenJoho> iryoHokenJohoList;

    /**
     * コンストラクタです。
     */
    public IryohokenKanyuJokyoBusiness() {
    }
}
