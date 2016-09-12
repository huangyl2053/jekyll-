/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist;

import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT0701ShunyuEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT1018TokusokuHakkoRirekiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法変更管理リストのEntityです。
 *
 * @reamsid_L DBD-3630-050 liangbc
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HenkouJohoEntity {

    private HihokenshaNo hihokenshaNo;
    private DbT4001JukyushaDaichoEntity dbt4001Entity;
    private List<ShikakuJohoEntity> shikakuJohoEntitys;
    private List<ShunoJohoEntity> shunoJohoEntity;
    private List<DbT4001JukyushaDaichoEntity> dbt4001Entitys;
    private List<CaT1018TokusokuHakkoRirekiEntity> cat1018Entitys;
    private List<CaT0701ShunyuEntity> cat0701Entitys;
    private List<UaFt200FindShikibetsuTaishoEntity> uaft200Entitys;
}
