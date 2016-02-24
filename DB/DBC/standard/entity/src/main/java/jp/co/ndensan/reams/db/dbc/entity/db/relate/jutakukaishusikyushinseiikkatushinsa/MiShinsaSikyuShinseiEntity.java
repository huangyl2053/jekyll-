/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishusikyushinseiikkatushinsa;

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
public class MiShinsaSikyuShinseiEntity implements Cloneable, Serializable {

    private final DbT3034ShokanShinseiEntity dbt3034entity;
    private final ShikibetsuCode 識別コード;
    private final AtenaMeisho 氏名;

    /**
     * コンストラクタです。
     *
     * @param dbt3034entity dbt3034entity
     * @param 識別コード 識別コード
     * @param 氏名 氏名
     */
    public MiShinsaSikyuShinseiEntity(DbT3034ShokanShinseiEntity dbt3034entity,
            ShikibetsuCode 識別コード,
            AtenaMeisho 氏名) {
        this.dbt3034entity = dbt3034entity;
        this.識別コード = 識別コード;
        this.氏名 = 氏名;
    }
}
