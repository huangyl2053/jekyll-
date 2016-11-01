/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.SetaiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.FukaJohoTempEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0526SeikatsuHogoFujoShuruiEntity;

/**
 * 賦課計算のEntity。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaKeisanEntity {

    private DbT1001HihokenshaDaichoEntity 資格情報;
    private FuchoKarisanteiTempEntity 普徴仮算定抽出;
    private DbT2001ChoshuHohoEntity 徴収方法;
    private FukaJohoTempEntity 介護賦課前年度;
    private SetaiShotokuEntity 世帯員所得情報一時;
    private FukaJohoTempEntity 賦課情報一時;
    private TokuteiKozaRelateEntity 口座Entity;
    private SetaiTempEntity 世帯員所得情報Entity;
    private UrT0508SeikatsuHogoJukyushaEntity 生活保護受給者Entity;
    private UrT0526SeikatsuHogoFujoShuruiEntity 生活保護扶助種類Entity;
    private DbT7006RoreiFukushiNenkinJukyushaEntity 老齢情報Entity;

}
