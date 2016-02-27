/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1013KyokaisoSochiShinseiEntity;

/**
 * 境界層該当者情報のエンティティクラスです。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyokaisoGaitoRelateEntity {

    private List<DbT1006KyokaisoGaitoshaEntity> 境界層該当者EntityList;
    private List<DbT1013KyokaisoSochiShinseiEntity> 境界層措置申請EntityLsit;
}
