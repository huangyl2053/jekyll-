/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author liangbc
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuJohoEntity {

    private List<DbT1001HihokenshaDaichoEntity> dbt1001Entitys;
    private List<ShikibetsuCode> shikibetsucode;
}
