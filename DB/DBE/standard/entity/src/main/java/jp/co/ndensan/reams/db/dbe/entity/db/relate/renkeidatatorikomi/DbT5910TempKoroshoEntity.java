package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 認定調査委託先情報一時テーブル（厚労省）のエンティティクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbT5910TempKoroshoEntity extends DbTableEntityBase<DbT5910TempKoroshoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString シーケンシャル番号;
    @TempTableColumnOrder(2)
    private RString 機能コード;
    @TempTableColumnOrder(3)
    private RString 識別コード;
    @TempTableColumnOrder(4)
    private RString 委託先コード;
    @TempTableColumnOrder(5)
    private RString 委託先名称;
    @TempTableColumnOrder(6)
    private RString 郵便番号;
    @TempTableColumnOrder(7)
    private RString 住所;
    @TempTableColumnOrder(8)
    private RString 電話番号;
    @TempTableColumnOrder(9)
    private RString 状況;
    @TempTableColumnOrder(10)
    private RString 委託区分コード;
}
