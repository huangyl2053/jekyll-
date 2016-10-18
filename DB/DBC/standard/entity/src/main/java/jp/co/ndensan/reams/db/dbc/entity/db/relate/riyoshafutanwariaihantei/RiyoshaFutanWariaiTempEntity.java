/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiKonkyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;

/**
 * 利用者負担割合Tempエンティティのクラスです
 *
 * @reamsid_L DBC-4950-032 fzou
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanWariaiTempEntity {

    List<RiyoshaFutanWariaiMeisaiTempEntity> 利用者負担割合明細情報;

    List<RiyoshaFutanWariaiKonkyoTempEntity> 利用者負担割合根拠情報;
}
