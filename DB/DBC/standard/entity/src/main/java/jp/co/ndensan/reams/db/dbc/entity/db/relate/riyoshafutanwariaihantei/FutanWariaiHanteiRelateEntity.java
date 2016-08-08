/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * ビジネス設計_DBCMNK1002_利用者負担割合判定（共通）の負担割合判定情報エンティティです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiHanteiRelateEntity implements Cloneable, Serializable {

    private HanteiTaishoshaTempEntity 判定対象者Temp;
    private SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp;
    private List<DbT2008ShotokuKanriEntity> 介護所得情報;
    private FlexibleDate 判定基準日;

    /**
     * 負担割合判定情報 のコンストラクタです。
     */
    public FutanWariaiHanteiRelateEntity() {
        判定対象者Temp = new HanteiTaishoshaTempEntity();
        生活保護該当情報Temp = new SeikatsuHogoGaitoJohoTempEntity();
        介護所得情報 = new ArrayList<>();
        判定基準日 = FlexibleDate.EMPTY;
    }

}
