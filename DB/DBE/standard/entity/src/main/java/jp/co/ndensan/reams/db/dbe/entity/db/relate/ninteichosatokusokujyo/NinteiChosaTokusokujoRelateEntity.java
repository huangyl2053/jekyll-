/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査督促状データ用のEntityクラスです。
 */
@Getter
@Setter
public class NinteiChosaTokusokujoRelateEntity {

    private DbT5101NinteiShinseiJohoEntity 認定申請情報;
    private AtenaKikan 宛名機関;

    /**
     * デフォルトコンストラクタです。
     */
    public NinteiChosaTokusokujoRelateEntity() {
        this.認定申請情報 = new DbT5101NinteiShinseiJohoEntity();
        this.宛名機関 = new AtenaKikan();
    }
}
