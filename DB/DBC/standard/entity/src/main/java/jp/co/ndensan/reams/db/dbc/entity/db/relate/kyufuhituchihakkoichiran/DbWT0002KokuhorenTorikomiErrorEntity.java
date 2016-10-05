/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * バッチ設計書_DBCMN72002_給付費通知書作成(一括)RelateEntityクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT0002KokuhorenTorikomiErrorEntity extends DbTableEntityBase<DbWT0002KokuhorenTorikomiErrorEntity>
        implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private RString エラー区分;
    @PrimaryKey
    @TempTableColumnOrder(2)
    private RString 証記載保険者番号;
    @PrimaryKey
    @TempTableColumnOrder(3)
    private RString 被保険者番号;
    @PrimaryKey
    @TempTableColumnOrder(4)
    private RString キー1;
    @PrimaryKey
    @TempTableColumnOrder(5)
    private RString キー2;
    @PrimaryKey
    @TempTableColumnOrder(6)
    private RString キー3;
    @PrimaryKey
    @TempTableColumnOrder(7)
    private RString キー4;
    @PrimaryKey
    @TempTableColumnOrder(8)
    private RString キー5;
    @PrimaryKey
    @TempTableColumnOrder(9)
    private RString 被保険者カナ氏名;
    @PrimaryKey
    @TempTableColumnOrder(10)
    private RString 被保険者氏名;
    @PrimaryKey
    @TempTableColumnOrder(11)
    private RString 備考;
}
