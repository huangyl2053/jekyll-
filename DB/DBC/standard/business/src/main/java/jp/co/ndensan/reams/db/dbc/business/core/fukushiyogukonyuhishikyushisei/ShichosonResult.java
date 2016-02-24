/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.ShichosonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村entity結果
 */
public class ShichosonResult implements Serializable {

    private final ShichosonEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 市町村entity
     */
    public ShichosonResult(ShichosonEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を取得する。
     *
     * @return ShoKisaiHokenshaNo 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return this.entity.get証記載保険者番号();
    }

    /**
     * 市町村名称を取得する。
     *
     * @return RString 証記載保険者番号
     */
    public RString get市町村名称() {
        return this.entity.get市町村名称();
    }
}
