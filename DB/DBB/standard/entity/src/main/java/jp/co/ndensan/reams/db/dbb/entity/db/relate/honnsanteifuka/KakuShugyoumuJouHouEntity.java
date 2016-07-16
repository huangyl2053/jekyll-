/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 各種業務情報のクラス
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KakuShugyoumuJouHouEntity {

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private FlexibleDate fukaYMD;
    private FukaJohoRelateEntity 賦課の情報;
    private DbT1001HihokenshaDaichoEntity 資格の情報;
    private KuBunnGaTsurakuTempEntity 月別ランク;
    private List<SetaiShotokuEntity> 世帯員所得情報;
    private DbT2001ChoshuHohoEntity 徴収方法の情報;
    private List<SeikatsuHogoJukyushaRelateEntity> 生保の情報;
    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢の情報;
    private List<KyokaisoGaitoshaEntity> 境界層の情報;
    private List<KozaRelateEntity> 口座;
}
