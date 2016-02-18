/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinseiikkatushinsa;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 未審査支給申請情報用クラスです。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MiShinsaSikyuShinsei implements Serializable {

    private final DbT3034ShokanShinseiEntity dbt3034entity;
    private final ShikibetsuCode 識別コード;
    private final AtenaMeisho 氏名;

    public MiShinsaSikyuShinsei() {
        this.dbt3034entity = new DbT3034ShokanShinseiEntity();
        this.識別コード = new ShikibetsuCode("");
        this.氏名 = new AtenaMeisho("");
    }

    /**
     * コンストラクタです。
     *
     * @param dbt3034entity
     * @param 識別コード
     * @param 氏名
     */
    public MiShinsaSikyuShinsei(DbT3034ShokanShinseiEntity dbt3034entity,
            ShikibetsuCode 識別コード,
            AtenaMeisho 氏名) {
        this.dbt3034entity = dbt3034entity;
        this.識別コード = 識別コード;
        this.氏名 = 氏名;
    }
}
