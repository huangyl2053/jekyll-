/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.niteicyosaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niteicyosaichiran.NinteichosahyoGaikyoChosaRelateEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
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
 *
 * 認定調査データ取込（モバイル）Businessです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosahyoGaikyoChosaRelateBusiness {

    private final List<NinteichosahyoGaikyoChosa> 認定調査票_概況調査Lsit;
    private final List<GaikyoTokki> 認定調査票_概況特記Lsit;
    private final List<NinteichosahyoChosaItem> 認定調査票基本調査_調査項目Lsit;
    private final List<NinteichosahyoKihonChosa> 認定調査票_基本調査Lsit;
    private final List<NinteichosahyoKinyuItem> 認定調査票概況調査記入項目Lsit;
    private final List<NinteichosahyoServiceJokyo> 認定調査票概況調査サービスの状況Lsit;
    private final List<NinteichosahyoServiceJokyoFlag> 認定調査票概況調査サービスの状況フラグLsit;
    private final List<NinteichosahyoShisetsuRiyo> 認定調査票概況調査施設利用Lsit;
    private final List<NinteichosahyoTokkijiko> 認定調査票_特記情報Lsit;

    /**
     * コンストラクタです。<br/>
     * 認定調査一覧に使用します。
     *
     * @param entity NiTeiCyoSaiChiRanRelateEntity
     */
    public NinteichosahyoGaikyoChosaRelateBusiness(NinteichosahyoGaikyoChosaRelateEntity entity) {

        List<NinteichosahyoGaikyoChosa> chosaList = new ArrayList<>();
        List<GaikyoTokki> tokkiList = new ArrayList<>();
        List<NinteichosahyoChosaItem> chosaItemList = new ArrayList<>();
        List<NinteichosahyoKihonChosa> kihonChosaList = new ArrayList<>();
        List<NinteichosahyoKinyuItem> kinyuItemLsit = new ArrayList<>();
        List<NinteichosahyoServiceJokyo> serviceJokyoLsit = new ArrayList<>();
        List<NinteichosahyoServiceJokyoFlag> serviceJokyoFlagLsit = new ArrayList<>();
        List<NinteichosahyoShisetsuRiyo> shisetsuRiyoLsit = new ArrayList<>();
        List<NinteichosahyoTokkijiko> tokkijikoLsit = new ArrayList<>();
        for (DbT5202NinteichosahyoGaikyoChosaEntity chosaEntity : entity.get概況調査()) {

            chosaEntity.initializeMd5();
            chosaList.add(new NinteichosahyoGaikyoChosa(chosaEntity));
        }
        for (DbT5206GaikyoTokkiEntity tokkiEntity : entity.get概況特記()) {

            tokkiEntity.initializeMd5();
            tokkiList.add(new GaikyoTokki(tokkiEntity));
        }
        for (DbT5211NinteichosahyoChosaItemEntity itemEntity : entity.get基本調査調査項目()) {

            itemEntity.initializeMd5();
            chosaItemList.add(new NinteichosahyoChosaItem(itemEntity));
        }
        for (DbT5203NinteichosahyoKihonChosaEntity chosaEntity : entity.get基本調査()) {

            chosaEntity.initializeMd5();
            kihonChosaList.add(new NinteichosahyoKihonChosa(chosaEntity));
        }
        for (DbT5209NinteichosahyoKinyuItemEntity itemEntity : entity.get記入項目()) {

            itemEntity.initializeMd5();
            kinyuItemLsit.add(new NinteichosahyoKinyuItem(itemEntity));
        }
        for (DbT5207NinteichosahyoServiceJokyoEntity jokyoEntity : entity.get概況調査サービスの状況()) {

            jokyoEntity.initializeMd5();
            serviceJokyoLsit.add(new NinteichosahyoServiceJokyo(jokyoEntity));
        }
        for (DbT5208NinteichosahyoServiceJokyoFlagEntity flagEntity : entity.get概況調査サービスの状況フラグ()) {

            flagEntity.initializeMd5();
            serviceJokyoFlagLsit.add(new NinteichosahyoServiceJokyoFlag(flagEntity));
        }
        for (DbT5210NinteichosahyoShisetsuRiyoEntity riyoEntity : entity.get概況調査施設利用()) {

            riyoEntity.initializeMd5();
            shisetsuRiyoLsit.add(new NinteichosahyoShisetsuRiyo(riyoEntity));
        }
        for (DbT5205NinteichosahyoTokkijikoEntity koEntity : entity.get特記情報()) {

            koEntity.initializeMd5();
            tokkijikoLsit.add(new NinteichosahyoTokkijiko(koEntity));
        }
        this.認定調査票_概況調査Lsit = chosaList;
        this.認定調査票_概況特記Lsit = tokkiList;
        this.認定調査票基本調査_調査項目Lsit = chosaItemList;
        this.認定調査票_基本調査Lsit = kihonChosaList;
        this.認定調査票概況調査記入項目Lsit = kinyuItemLsit;
        this.認定調査票概況調査サービスの状況Lsit = serviceJokyoLsit;
        this.認定調査票概況調査サービスの状況フラグLsit = serviceJokyoFlagLsit;
        this.認定調査票概況調査施設利用Lsit = shisetsuRiyoLsit;
        this.認定調査票_特記情報Lsit = tokkijikoLsit;
    }

}
