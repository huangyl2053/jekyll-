/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * DbT3115SakuseiEntityのエンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbT3115SakuseiEntity
        extends DbTableEntityBase<DbT3115SakuseiEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo 被保険者番号;
    @PrimaryKey
    private FlexibleYear 年度;
    private int 履歴番号;
    @PrimaryKey
    private HihokenshaNo 世帯員被保険者番号;
    private Decimal 元履歴番号;
}
