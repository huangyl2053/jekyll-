package jp.co.ndensan.reams.db.dbe.entity.db.relate.renkeidatatorikomi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 要介護認定申請情報エラー一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbT5101ErrorTempEntity extends DbTableEntityBase<DbT5101ErrorTempEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString シーケンシャル番号;
    @TempTableColumnOrder(2)
    private RString 機能コード;
    @TempTableColumnOrder(3)
    private RString 識別コード;
    @TempTableColumnOrder(4)
    private RString 保険者番号;
    @TempTableColumnOrder(5)
    private RString 被保険者番号;
    @TempTableColumnOrder(6)
    private RString 認定申請日;
    @TempTableColumnOrder(7)
    private RString 主キー補助項目;
    @TempTableColumnOrder(8)
    private RString 申請種別コード;
    @TempTableColumnOrder(9)
    private RString 申請種別名称;
    @TempTableColumnOrder(10)
    private RString 取下区分コード;
    @TempTableColumnOrder(11)
    private RString 取下区分名称;
    @TempTableColumnOrder(12)
    private RString 被保険者区分コード;
    @TempTableColumnOrder(13)
    private RString 被保険者区分名称;
    @TempTableColumnOrder(14)
    private RString 申請代行区分コード;
    @TempTableColumnOrder(15)
    private RString 申請代行区分名称;
    @TempTableColumnOrder(16)
    private RString 生年月日;
    @TempTableColumnOrder(17)
    private RString 年齢;
    @TempTableColumnOrder(18)
    private RString 性別コード;
    @TempTableColumnOrder(19)
    private RString 性別;
    @TempTableColumnOrder(20)
    private RString 氏名カナ;
    @TempTableColumnOrder(21)
    private RString 氏名;
    @TempTableColumnOrder(22)
    private RString 郵便番号;
    @TempTableColumnOrder(23)
    private RString 住所;
    @TempTableColumnOrder(24)
    private RString エラー内容;
}
