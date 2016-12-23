package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 送信データを作成する対象者の一時テーブルです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class SoshinDataSakuseiTaishoshaTempEntity extends DbTableEntityBase<SoshinDataSakuseiTaishoshaTempEntity> implements IDbAccessable {

    /**
     * 送信データを作成する対象者の一時テーブルのテーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("SoshinDataSakuseiTaishoshaTemp"));
    }
    @PrimaryKey
    @TempTableColumnOrder(1)
    private ShinseishoKanriNo shinseishoKanriNo;
    @TempTableColumnOrder(2)
    private ShinseishoKanriNo zenkaiShinseishoKanriNo;
}
