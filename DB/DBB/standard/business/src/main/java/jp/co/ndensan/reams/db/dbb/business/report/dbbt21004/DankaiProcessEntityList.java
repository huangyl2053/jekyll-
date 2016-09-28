/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbt21004;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hihokenxiataixiou.HihokenshaTaihoTemp;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tukibeturanku.TsukibetsuRankTemp;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyusha;

/**
 * 段階情報取得EntityListクラスです。。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaiProcessEntityList {

    private HihokenshaTaihoTemp 被保険者対象Temp;
    private TsukibetsuRankTemp 月別Temp;
    private List<SetaiShotokuEntity> 世帯員所得情報Temp;
    private List<SeikatsuHogoJukyusha> 生保の情報;
    private List<RoreiFukushiNenkinJukyusha> 老齢の情報;
}
