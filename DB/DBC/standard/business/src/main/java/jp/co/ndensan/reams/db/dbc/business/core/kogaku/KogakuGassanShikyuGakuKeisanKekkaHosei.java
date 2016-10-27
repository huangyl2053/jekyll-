/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogaku;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuGakuKeisanKekkaIdentifier;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給額計算結果リストです。
 *
 * @reamsid_L DBC-2030-010 huzongcheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyuGakuKeisanKekkaHosei implements Serializable {

    private List<KogakuGassanShikyuGakuKeisanKekkaRelate> 高額合算支給額計算結果データ;

    /**
     * 高額合算申請書取得のメソッドです。
     *
     * @param identifier KogakuGassanShinseishoIdentifier
     * @return KogakuGassanShinseishoResult
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelate get高額合算支給額計算結果(KogakuGassanShikyuGakuKeisanKekkaIdentifier identifier) {
        if (this.高額合算支給額計算結果データ == null) {
            return null;
        }
        for (KogakuGassanShikyuGakuKeisanKekkaRelate item : this.高額合算支給額計算結果データ) {
            if (item.identifier().toString().equals(identifier.toString())) {
                return item;
            }
        }
        return null;
    }
}
