/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.sikakuidouteisei;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashikakuteisei.IryoHokenJoho;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashikakuteisei.RoreiFukushiJoho;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 資格情報のビジネスクラスです。
 *
 * @reamsid_L DBA-0521-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SikakuIdouTeiseiJoho implements Serializable {

    private List<IryoHokenJoho> iryoHokenJohoList;
    private List<RoreiFukushiJoho> roreiFukushiJohoList;

    /**
     * コンストラクタです。
     */
    public SikakuIdouTeiseiJoho() {
    }
}
