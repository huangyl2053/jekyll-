/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.TsukibetsuFutanWariaiTempEntity;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * FutanWariaiRelateEntityエンティティのクラスです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiRelateEntity
        extends DbTableEntityBase<FutanWariaiRelateEntity> implements IDbAccessable {

    private RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細;
    private List<TsukibetsuFutanWariaiTempEntity> 月別負担割合新;
    private List<TsukibetsuFutanWariaiTempEntity> 月別負担割合現;

    /**
     * FutanWariaiRelateEntityのインターフェースクラスです。
     */
    public FutanWariaiRelateEntity() {
        月別負担割合新 = new ArrayList<>();
        月別負担割合現 = new ArrayList<>();
    }

}
