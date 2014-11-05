/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.gappei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村のモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiShichosonModel implements Serializable, IGappeiShichoson {

    private final DbT7056GappeiShichosonEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT7056GappeiShichosonEntity
     */
    public GappeiShichosonModel(DbT7056GappeiShichosonEntity entity) {
        this.entity = entity;
    }

    @Override
    public FlexibleDate get合併日() {
        return entity.getGappeiYMD();
    }

    @Override
    public RString get地域番号() {
        return entity.getChiikiNo();
    }

    @Override
    public RString get旧市町村コード() {
        return entity.getKyuShichosonCode();
    }

    @Override
    public FlexibleDate get運用開始日() {
        return entity.getUnyoKaishiYMD();
    }

    @Override
    public FlexibleDate get運用終了日() {
        return entity.getUnyoShuryoYMD();
    }

    @Override
    public ShoKisaiHokenshaNo get旧保険者番号() {
        return entity.getKyuHokenshaNo();
    }

    @Override
    public RString get旧市町村名称() {
        return entity.getKyuShichosonMeisho();
    }

    @Override
    public RString get都道府県名称() {
        return entity.getTodofukenMeisho();
    }

    @Override
    public RString get郡名称() {
        return entity.getGunMeisho();
    }

    @Override
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    @Override
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    @Override
    public RString get老人保健市町村番号() {
        return entity.getRojinhokenShichosonNo();
    }

    @Override
    public RString get老人保健受給者番号体系() {
        return entity.getRokenJukyushaNoTaikei();
    }

    @Override
    public RString get表示有無() {
        return entity.getHyojiUmu();
    }

    /**
     * DbT7056GappeiShichosonEntityを返します。
     *
     * @return DbT7056GappeiShichosonEntity DbT7056GappeiShichosonEntity
     */
    public DbT7056GappeiShichosonEntity getDbT7056GappeiShichoson() {
        return entity;
    }
}
