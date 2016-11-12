/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 処理結果確認リスト一時テーブルのEntityクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class DbWT1514ShoriKekkaKakuninListEntity extends DbTableEntityBase<DbWT1514ShoriKekkaKakuninListEntity> implements IDbAccessable {

    @PrimaryKey
    private RString errorKubun;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
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
    private RString hihokenshaShimei;
    private RString biko;
}
