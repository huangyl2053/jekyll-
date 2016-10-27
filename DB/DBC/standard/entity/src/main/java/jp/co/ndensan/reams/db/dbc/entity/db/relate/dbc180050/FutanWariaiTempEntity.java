/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(一時表：負担割合情報Temp)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiTempEntity extends DbTableEntityBase<FutanWariaiTempEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo 被保険者番号;
    @PrimaryKey
    private FlexibleYear 年度;
    private RString 給付率01;
    private RString 給付率02;
    private RString 給付率03;
    private RString 給付率04;
    private RString 給付率05;
    private RString 給付率06;
    private RString 給付率07;
    private RString 給付率08;
    private RString 給付率09;
    private RString 給付率10;
    private RString 給付率11;
    private RString 給付率12;
}
