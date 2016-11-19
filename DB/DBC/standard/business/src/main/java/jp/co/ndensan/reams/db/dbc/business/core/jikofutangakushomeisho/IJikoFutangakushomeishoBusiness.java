/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jikofutangakushomeisho;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 自己負担額証明書作成のBusinessクラスです。
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IJikoFutangakushomeishoBusiness implements Serializable {

    private List<KogakuGassanShinSeisho> kogakuGassanShinseishoList;

    /**
     * コンストラクタです。
     */
    public IJikoFutangakushomeishoBusiness() {
    }
}
