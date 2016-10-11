/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のDBC020080ShoriKekkaTempEntityクラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC020080ShoriKekkaTempEntity
        extends DbTableEntityBase<DBC020080ShoriKekkaTempEntity> implements IDbAccessable {

    /**
     * 処理結果リスト一時テーブルの名称です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("DBC020080ShoriKekkaListTemp");
    }
    @PrimaryKey
    private RString errorKubun;
    @PrimaryKey
    private RString shoHokenshaNo;
    @PrimaryKey
    private RString hihokenshaNo;
    private RString hihokenshaKanaShimei;
    private RString hihokenshaShimei;
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
    private RString errorNaiyo;
    private RString biko;

    /**
     * DBC020080ShoriKekkaTempEntityのコンストラクタです。
     */
    public DBC020080ShoriKekkaTempEntity() {
        errorKubun = RString.EMPTY;
        shoHokenshaNo = RString.EMPTY;
        hihokenshaNo = RString.EMPTY;
        key1 = RString.EMPTY;
        key2 = RString.EMPTY;
        key3 = RString.EMPTY;
        key4 = RString.EMPTY;
        key5 = RString.EMPTY;
    }

}
