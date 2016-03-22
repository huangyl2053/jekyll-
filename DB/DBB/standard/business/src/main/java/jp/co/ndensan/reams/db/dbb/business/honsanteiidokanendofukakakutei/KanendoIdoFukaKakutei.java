/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.honsanteiidokanendofukakakutei;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidofukakakutei.KanendoIdoFukaKakuteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 *
 * 異動賦課対象取得用ビジネスです
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanendoIdoFukaKakutei {

    private KanendoIdoFukaKakuteiEntity fukaKakuteiEntity;
    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private int 履歴番号;

    /**
     * 異動賦課対象取得用ビジネスです
     */
    public KanendoIdoFukaKakutei() {
    }

    /**
     * 異動賦課対象取得用ビジネスです
     *
     * @param entity KanendoIdoFukaKakuteiEntity
     */
    public KanendoIdoFukaKakutei(KanendoIdoFukaKakuteiEntity entity) {
        this.fukaKakuteiEntity = entity;
    }
}
