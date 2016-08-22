/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 被保険者番号のエンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaNoEntity
        extends DbTableEntityBase<HihokenshaNoEntity> implements IDbAccessable {

    private HihokenshaNo hihokenshaNo;
    private RString idoShubetsu;

    /**
     * HihokenshaNoEntity のコンストラクタです。
     */
    public HihokenshaNoEntity() {
        hihokenshaNo = HihokenshaNo.EMPTY;
        idoShubetsu = RString.EMPTY;
    }

    /**
     * HihokenshaNoEntityのコンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public HihokenshaNoEntity(HihokenshaNo 被保険者番号) {
        this.hihokenshaNo = 被保険者番号;
        idoShubetsu = RString.EMPTY;
    }

    /**
     * HihokenshaNoEntityのコンストラクタです。
     *
     * @param hihokenshaNo HihokenshaNo
     * @param idoShubetsu RString
     */
    public HihokenshaNoEntity(HihokenshaNo hihokenshaNo, RString idoShubetsu) {
        this.hihokenshaNo = hihokenshaNo;
        this.idoShubetsu = idoShubetsu;
    }
}
