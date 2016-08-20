/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV2512KaigoShotokuNewestEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 月別判定対象者TempEntity作成のエンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsukibetsuHanteiTaishoshaDaichoEntity
        extends DbTableEntityBase<TsukibetsuHanteiTaishoshaDaichoEntity> implements IDbAccessable {

    private HihokenshaNo 被保険者番号;
    private RString 異動種別;
    private List<DbT1001HihokenshaDaichoEntity> 被保険者台帳;
    private List<DbT4001JukyushaDaichoEntity> 受給者台帳;
    private List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者;
    private List<UaFt200FindShikibetsuTaishoEntity> 宛名;
    private List<DbV2512KaigoShotokuNewestEntity> 介護所得;

    /**
     * TsukibetsuHanteiTaishoshaDaichoEntityのコンストラクタです。
     */
    public TsukibetsuHanteiTaishoshaDaichoEntity() {
        被保険者台帳 = new ArrayList<>();
        受給者台帳 = new ArrayList<>();
        総合事業対象者 = new ArrayList<>();
        宛名 = new ArrayList<>();
        介護所得 = new ArrayList<>();
    }

}
