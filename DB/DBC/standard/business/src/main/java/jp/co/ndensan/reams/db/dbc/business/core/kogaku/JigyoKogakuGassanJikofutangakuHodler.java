/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogaku;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuIdentifier;

/**
 * 高額合算自己負担額保持ラスです。
 *
 * @reamsid_L DBC-4800-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoKogakuGassanJikofutangakuHodler implements Serializable {

    private List<JigyoKogakuGassanJikoFutanGaku> 高額合算自己負担額List;

    /**
     * 高額合算自己負担額取得のメソッドです。
     *
     * @param identifier KogakuGassanJikoFutanGakuIdentifier
     * @return JigyoKogakuGassanJikoFutanGaku
     */
    public JigyoKogakuGassanJikoFutanGaku get高額合算申請書(KogakuGassanJikoFutanGakuIdentifier identifier) {
        if (this.高額合算自己負担額List == null) {
            return null;
        }
        for (JigyoKogakuGassanJikoFutanGaku item : this.高額合算自己負担額List) {
            if (item.identifier().toString().equals(identifier.toString())) {
                return item;
            }
        }
        return null;
    }

}
