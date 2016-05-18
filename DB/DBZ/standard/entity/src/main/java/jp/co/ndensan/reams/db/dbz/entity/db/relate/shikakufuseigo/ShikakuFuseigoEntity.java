/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakufuseigo;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheckEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 資格不整合一覧情報RelateEntityクラスです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuFuseigoEntity implements Serializable {

    private UaFt200FindShikibetsuTaishoEntity ft200Entity;
    private DbT1014SeigoseiCheckEntity dbt1014Entity;
}
