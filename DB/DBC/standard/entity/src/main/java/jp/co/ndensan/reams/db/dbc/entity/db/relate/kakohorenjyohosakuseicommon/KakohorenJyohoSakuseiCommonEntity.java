/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kakohorenjyohosakuseicommon;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.hokenja.UrT0507HokenjaEntity;

/**
 * 国保連情報作成共通処理（証記載保険者番号取得）のrelateEntityです。
 *
 * @reamsid_L DBC-2840-031 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KakohorenJyohoSakuseiCommonEntity {

    private HihokenshaTempEntity hihokenshaTempEntity;
    private DbT7026ShinKyuHihokenshaNoHenkanEntity dbT7026Entity;
    private DbT7056GappeiShichosonEntity dbT7056Entity;
    private HihokenshaDaichoEntity hihokenshaDaichoEntity;
    private DbT7051KoseiShichosonMasterEntity dbT7051Entity;
    private DbT7055GappeiJohoEntity dbT7055Entity;
    private UrT0507HokenjaEntity urT0507Entity;
}
