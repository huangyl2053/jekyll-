/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会資料作成特記事項情報取得のRelateエンティティです。
 *
 * @author n3423
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokkijikoIchiranJohoRelateEntity{

    private DbT5205NinteichosahyoTokkijikoEntity 認定調査票特記事項Entity;
    private int maxRemban;
}
