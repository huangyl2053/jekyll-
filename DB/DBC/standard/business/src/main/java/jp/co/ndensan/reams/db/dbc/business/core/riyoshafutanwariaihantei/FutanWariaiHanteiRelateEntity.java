/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SeikatsuHogoGaitoJohoTempEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * ビジネス設計_DBCMNK1002_利用者負担割合判定（共通）の負担割合判定情報エンティティです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiHanteiRelateEntity implements Serializable {

    private HanteiTaishoshaTempEntity 判定対象者Temp;
    private SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp;
    private List<SetaiinShotoku> 介護所得情報;
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

    /**
     * 負担割合判定情報 のコンストラクタです。
     *
     * @param 判定対象者Temp HanteiTaishoshaTempEntity
     * @param 生活保護該当情報Temp SeikatsuHogoGaitoJohoTempEntity
     * @param 介護所得情報 List<SetaiinShotoku>
     * @param 判定基準日 FlexibleDate
     */
    public FutanWariaiHanteiRelateEntity(
            HanteiTaishoshaTempEntity 判定対象者Temp,
            SeikatsuHogoGaitoJohoTempEntity 生活保護該当情報Temp,
            List<SetaiinShotoku> 介護所得情報,
            FlexibleDate 判定基準日) {
        this.判定対象者Temp = 判定対象者Temp;
        this.生活保護該当情報Temp = 生活保護該当情報Temp;
        this.介護所得情報 = 介護所得情報;
        this.判定基準日 = 判定基準日;
    }
}
