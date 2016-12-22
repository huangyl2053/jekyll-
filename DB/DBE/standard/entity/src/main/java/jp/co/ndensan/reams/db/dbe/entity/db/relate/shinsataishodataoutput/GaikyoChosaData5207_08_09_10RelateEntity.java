/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;

/**
 * 概況調査データのマッピング用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GaikyoChosaData5207_08_09_10RelateEntity {

    /**
     * コンストラクタです
     */
    public GaikyoChosaData5207_08_09_10RelateEntity() {
        要介護認定申請情報 = new DbT5101NinteiShinseiJohoEntity();
        サービスの状況リスト = new ArrayList<>();
        サービスの状況フラグリスト = new ArrayList<>();
        記入項目リスト = new ArrayList<>();
        施設利用リスト = new ArrayList<>();
    }
    private DbT5101NinteiShinseiJohoEntity 要介護認定申請情報;
    private List<DbT5207NinteichosahyoServiceJokyoEntity> サービスの状況リスト;
    private List<DbT5208NinteichosahyoServiceJokyoFlagEntity> サービスの状況フラグリスト;
    private List<DbT5209NinteichosahyoKinyuItemEntity> 記入項目リスト;
    private List<DbT5210NinteichosahyoShisetsuRiyoEntity> 施設利用リスト;

}
