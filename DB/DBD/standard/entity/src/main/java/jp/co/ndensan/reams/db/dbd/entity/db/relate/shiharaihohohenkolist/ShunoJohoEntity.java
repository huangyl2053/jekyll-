/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4023JikoKisambiKanriEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author liangbc
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJohoEntity {

    private DbT2002FukaEntity dbt2002Entity;
    private List<KibetsuEntity> dbt2003Entitys;
    private List<UrT0705ChoteiKyotsuEntity> urt0705Entitys;
    private List<DbT4023JikoKisambiKanriEntity> dbt4023Entitys;
}
