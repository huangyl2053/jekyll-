/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 処理結果リスト一時TBL項目定義クラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempDbWT0002KokuhorenTorikomiErrorEntity extends DbTableEntityBase<TempDbWT0002KokuhorenTorikomiErrorEntity> implements IDbAccessable {

    @PrimaryKey
    private RString errorKubun;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoHokanehshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString key1;
    @PrimaryKey
    private RString key2;
    @PrimaryKey
    private RString key3;
    @PrimaryKey
    private RString key4;
    @PrimaryKey
    private RString key5;
    private RString hihokenshaKanaShimei;
    private RString hihokenshaShimei;
    private RString biko;
}
