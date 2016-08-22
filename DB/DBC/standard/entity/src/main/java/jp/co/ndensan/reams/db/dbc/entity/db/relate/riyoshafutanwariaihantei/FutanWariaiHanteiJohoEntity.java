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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * ビジネス設計_DBCMNK1002_利用者負担割合判定（共通）の負担割合判定情報エンティティです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiHanteiJohoEntity implements Cloneable, Serializable {

    private HanteiTaishoshaTempEntity 判定対象者;
    private List<SeikatsuHogoGaitoJohoTempEntity> 生活保護該当情報;
    private List<SetainJohoRelateEntity> 世帯員情報Entity;
    private FlexibleDate 判定基準日;

    /**
     * 負担割合判定情報 のコンストラクタです。
     */
    public FutanWariaiHanteiJohoEntity() {
        判定対象者 = new HanteiTaishoshaTempEntity();
        生活保護該当情報 = new ArrayList<>();
        判定基準日 = FlexibleDate.EMPTY;
        世帯員情報Entity = new ArrayList<>();
    }

    /**
     * 負担割合判定情報 のコンストラクタです。
     *
     * @param 判定対象者 HanteiTaishoshaTempEntity
     * @param 生活保護該当情報 List<SeikatsuHogoGaitoJohoTempEntity>
     * @param 世帯員情報Entity List<SetainJohoRelateEntity>
     * @param 判定基準日 FlexibleDate
     */
    public FutanWariaiHanteiJohoEntity(
            HanteiTaishoshaTempEntity 判定対象者,
            List<SeikatsuHogoGaitoJohoTempEntity> 生活保護該当情報,
            List<SetainJohoRelateEntity> 世帯員情報Entity,
            FlexibleDate 判定基準日) {
        this.判定対象者 = 判定対象者;
        this.生活保護該当情報 = 生活保護該当情報;
        this.世帯員情報Entity = 世帯員情報Entity;
        this.判定基準日 = 判定基準日;
    }

}
