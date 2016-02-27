/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairaijoho;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;

/**
 * {NinteichosaIraiJohoRelateEntity}です。
 */
@lombok.Getter
@lombok.Setter
public class NinteichosaIraiJohoRelateEntity {

    /**
     * -- GETTER -- 認定調査依頼情報EntityListを返します。
     *
     * @return 認定調査依頼情報EntityList -- SETTER -- 認定調査依頼情報EntityListを設定します。
     *
     * @param 認定調査依頼情報EntityList 認定調査依頼情報EntityList
     */
    private DbT5201NinteichosaIraiJohoEntity 認定調査依頼情報Entity;

    /**
     * コンストラクタです。
     */
    public NinteichosaIraiJohoRelateEntity() {
        認定調査依頼情報Entity = new DbT5201NinteichosaIraiJohoEntity();

    }

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * NinteiShinseiJohoEntityが持つ{@link xxxxxxEntity}と{@link xxxxxxEntity}と<br/> {@link xxxxxxEntity}のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.認定調査依頼情報Entity.initializeMd5();

    }
}
