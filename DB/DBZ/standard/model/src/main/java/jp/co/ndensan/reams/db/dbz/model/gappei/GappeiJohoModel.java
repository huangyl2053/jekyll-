/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.gappei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併情報のモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiJohoModel implements Serializable, IGappeiJoho {

    private final DbT7055GappeiJohoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT7055GappeiJohoEntity
     */
    public GappeiJohoModel(DbT7055GappeiJohoEntity entity) {
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
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    @Override
    public RString get合併種類() {
        return entity.getGappeiShurui();
    }

    @Override
    public ShoKisaiHokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
    }

    @Override
    public FlexibleDate get旧市町村情報付与終了日() {
        return entity.getKyuJohoFuyoToYMD();
    }

    @Override
    public FlexibleDate get国保連データ連携開始日() {
        return entity.getKokuhorenDataFromYMD();
    }

    /**
     * DbT7055GappeiJohoEntityを返します。
     *
     * @return DbT7055GappeiJohoEntity DbT7055GappeiJohoEntity
     */
    public DbT7055GappeiJohoEntity getDbT7055GappeiJoho() {
        return entity;
    }
}
