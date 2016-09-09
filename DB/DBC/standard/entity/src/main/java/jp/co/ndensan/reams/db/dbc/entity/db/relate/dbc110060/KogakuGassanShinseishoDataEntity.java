/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;

/**
 * 高額合算支給申請書情報作成の送付対象データエンティティクラスです。
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseishoDataEntity implements Serializable {

    private int rowNum;
    private DbT3068KogakuGassanShinseishoEntity 高額合算申請書Entity;

}
