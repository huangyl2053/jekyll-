/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.koseishichosonmaster.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村情報を取得。
 *
 * @reamsid_L DBA-0170-020 linghuhang
 */
public class KoseiShichosonMaster {

    private DbT7051KoseiShichosonMasterEntity entity;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonMaster() {
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7051KoseiShichosonMasterEntity
     */
    public KoseiShichosonMaster(DbT7051KoseiShichosonMasterEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString getShichosonMeisho() {
        return entity.getShichosonMeisho();
    }
}
