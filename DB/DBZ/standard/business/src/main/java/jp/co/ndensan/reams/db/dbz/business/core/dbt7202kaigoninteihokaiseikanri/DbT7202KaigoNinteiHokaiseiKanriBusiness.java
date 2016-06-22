/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.dbt7202kaigoninteihokaiseikanri;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定法改正管理のBusinessです。
 *
 * @reamsid_L DBZ-1300-080 yaodongsheng
 */
public class DbT7202KaigoNinteiHokaiseiKanriBusiness {

    private final DbT7202KaigoNinteiHokaiseiKanriEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 申請履歴情報Entity
     */
    public DbT7202KaigoNinteiHokaiseiKanriBusiness(DbT7202KaigoNinteiHokaiseiKanriEntity entity) {
        this.entity = entity;
    }

    /**
     * 法改正施行年月日を取得します。
     *
     * @return 法改正施行年月日
     */
    public FlexibleDate get法改正施行年月日() {
        return entity.getHokaiseiShikoYMD();
    }

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

}
