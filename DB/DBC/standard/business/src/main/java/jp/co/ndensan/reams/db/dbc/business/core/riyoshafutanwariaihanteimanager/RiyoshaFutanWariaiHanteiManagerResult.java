/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihanteimanager;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMNK2001_利用者負担割合判定（service）
 *
 * @reamsid_L DBC-5010-040 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanWariaiHanteiManagerResult {

    private DbT3113RiyoshaFutanWariaiEntity 利用者負担割合entity;
    private List<DbT3114RiyoshaFutanWariaiMeisaiEntity> 利用者負担割合明細list;
    private List<DbT3115RiyoshaFutanWariaiKonkyoEntity> 利用者負担割合根拠list;
    private RString 判定区分;
    private boolean 生活保護受給者判定;

}
