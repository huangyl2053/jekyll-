/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.niteicyosaichiran;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;

/**
 * 認定調査データ取込（モバイル）RelateEntityクラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosahyoGaikyoChosaRelateEntity implements Serializable {

    private List<DbT5211NinteichosahyoChosaItemEntity> 基本調査調査項目;
    private List<DbT5202NinteichosahyoGaikyoChosaEntity> 概況調査;
    private List<DbT5206GaikyoTokkiEntity> 概況特記;
    private List<DbT5203NinteichosahyoKihonChosaEntity> 基本調査;
    private List<DbT5209NinteichosahyoKinyuItemEntity> 記入項目;
    private List<DbT5207NinteichosahyoServiceJokyoEntity> 概況調査サービスの状況;
    private List<DbT5208NinteichosahyoServiceJokyoFlagEntity> 概況調査サービスの状況フラグ;
    private List<DbT5210NinteichosahyoShisetsuRiyoEntity> 概況調査施設利用;
    private List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報;
}
