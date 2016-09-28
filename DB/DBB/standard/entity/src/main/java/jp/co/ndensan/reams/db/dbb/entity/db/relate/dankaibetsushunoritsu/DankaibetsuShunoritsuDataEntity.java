/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 収納宛名データを取得Entityクラスです。
 *
 * @reamsid_L DBB-1630-020 tianshuai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibetsuShunoritsuDataEntity implements Serializable {

    private TotalShunyuDataEntity 収入情報取得PSM;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private DbT2002FukaEntity 介護賦課;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
    private JukyushaKyufujissekiCountEntity 受給者給付COUNT;
}
