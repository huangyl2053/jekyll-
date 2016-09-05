/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070.DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;

/**
 * 送付ファイル作成エンティティのクラスです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKeisanKekkaRenrakuJohoRelateEntity {

    private DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity 高額合算支給額計算結果一時;
    private DbWT1001HihokenshaTempEntity 被保険者一時;
    private List<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> 高額合算支給額計算結果明細リスト;

    /**
     * コンストラクタです。
     */
    public KogakuGassanKeisanKekkaRenrakuJohoRelateEntity() {
        高額合算支給額計算結果一時 = new DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity();
        被保険者一時 = new DbWT1001HihokenshaTempEntity();
        高額合算支給額計算結果明細リスト = new ArrayList<>();
    }
}
