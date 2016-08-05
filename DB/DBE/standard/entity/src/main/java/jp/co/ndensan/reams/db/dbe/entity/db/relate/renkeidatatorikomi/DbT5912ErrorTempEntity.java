package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 主治医情報エラー一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbT5912ErrorTempEntity extends DbTableEntityBase<DbT5912ErrorTempEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString シーケンシャル番号;
    @TempTableColumnOrder(2)
    private RString 機能コード;
    @TempTableColumnOrder(3)
    private RString 識別コード;
    @TempTableColumnOrder(4)
    private RString 医療機関コード;
    @TempTableColumnOrder(5)
    private RString 主治医コード;
    @TempTableColumnOrder(6)
    private RString 主治医名称;
    @TempTableColumnOrder(7)
    private boolean 状況;
    @TempTableColumnOrder(8)
    private RString 主治医名称カナ;
    @TempTableColumnOrder(9)
    private RString エラー内容;

}
