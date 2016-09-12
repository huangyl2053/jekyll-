/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;

/**
 * 賦課計算(資格喪失)Entityです
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuFukaResultEntity {

    private DbT1001HihokenshaDaichoEntity 資格喪失Entity;
    private FukaJohoRelateEntity 賦課情報Entity;
    private DbT2001ChoshuHohoEntity 徴収方法Entity;
    private KozaRelateEntity 口座Entity;
    private List<SetaiShotokuEntity> 世帯員所得情報List;
    private List<SeikatsuHogoJukyushaRelateEntity> 生保の情報List;
    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢の情報List;
    private List<KyokaisoGaitoshaEntity> 境界層の情報List;
    private List<HihokenChoshuRelateEntity> 特別徴収停止List;
    private List<ShikakuShutokuTempEntity> 資格取得List;
    private KozaIdoEntity 口座異動Entity;
}
