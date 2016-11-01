/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 対象世帯員クラスです
 *
 * @reamsid_L DBC-4630-060 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsTaishoSeitaiyinTempEntity {

    private SetaiShotokuEntity 世帯員所得情報一時;
    private DbV1001HihokenshaDaichoEntity 被保険者台帳管理Newest;
    private UaFt200FindShikibetsuTaishoEntity 宛名情報;

}
