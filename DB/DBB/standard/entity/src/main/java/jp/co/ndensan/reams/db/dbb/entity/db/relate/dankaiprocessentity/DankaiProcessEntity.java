/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaiprocessentity;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hihokenxiataixiou.HihokenshaTaihoTemp;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tukibeturanku.TsukibetsuRankTemp;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 段階情報取得Entityクラスです。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaiProcessEntity extends DbTableEntityBase<DankaiProcessEntity> implements IDbAccessable {

    private HihokenshaTaihoTemp 被保険者対象Temp;
    private TsukibetsuRankTemp 月別Temp;
    private SetaiShotokuEntity 世帯員所得情報Temp;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者;
    private UrT0526SeikatsuHogoFujoShuruiEntity 生活保護扶助種類;
    private DbT7006RoreiFukushiNenkinJukyushaEntity 老齢の情報;
}
