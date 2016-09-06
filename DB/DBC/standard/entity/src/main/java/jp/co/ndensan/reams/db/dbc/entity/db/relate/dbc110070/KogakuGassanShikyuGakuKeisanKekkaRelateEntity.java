/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;

/**
 * 高額合算支給額計算結果エンティティクラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyuGakuKeisanKekkaRelateEntity {

    private DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity 高額合算支給額計算結果;
    private List<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> 高額合算支給額計算結果明細リスト;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShikyuGakuKeisanKekkaRelateEntity() {
        高額合算支給額計算結果 = new DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
        高額合算支給額計算結果明細リスト = new ArrayList<>();
    }
}
