/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetainJohoTempEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2512KaigoShotokuNewestEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 判定対象者TempEntity作成のエンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteiTaishoshaDaichoEntity
        extends DbTableEntityBase<HanteiTaishoshaDaichoEntity> implements IDbAccessable {

    private SetainJohoTempEntity 追加判定対象者;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private List<DbV2512KaigoShotokuNewestEntity> 介護所得;
    private List<DbT4001JukyushaDaichoEntity> 受給者台帳;
    private List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者;

    /**
     * 判定対象者台帳エンティティのコンストラクタです。
     */
    public HanteiTaishoshaDaichoEntity() {
        追加判定対象者 = new SetainJohoTempEntity();
        被保険者台帳 = new DbT1001HihokenshaDaichoEntity();
        宛名 = new UaFt200FindShikibetsuTaishoEntity();
        介護所得 = new ArrayList<>();
        受給者台帳 = new ArrayList<>();
        総合事業対象者 = new ArrayList<>();
    }
}
