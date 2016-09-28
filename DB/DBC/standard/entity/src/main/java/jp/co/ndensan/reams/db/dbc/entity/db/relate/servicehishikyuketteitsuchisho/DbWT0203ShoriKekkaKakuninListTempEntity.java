/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 処理結果確認リスト一時TBL作成する用エンティティクラスです。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT0203ShoriKekkaKakuninListTempEntity extends DbTableEntityBase<DbWT0203ShoriKekkaKakuninListTempEntity>
        implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private RString errorKubun;
    @PrimaryKey
    @TempTableColumnOrder(2)
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    @TempTableColumnOrder(3)
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    @TempTableColumnOrder(4)
    private RString key1;
    @PrimaryKey
    @TempTableColumnOrder(5)
    private RString key2;
    @PrimaryKey
    @TempTableColumnOrder(6)
    private RString key3;
    @PrimaryKey
    @TempTableColumnOrder(7)
    private RString key4;
    @PrimaryKey
    @TempTableColumnOrder(8)
    private RString key5;
    @TempTableColumnOrder(9)
    private RString hihokenshaShimei;
    @TempTableColumnOrder(10)
    private RString biko;

}
