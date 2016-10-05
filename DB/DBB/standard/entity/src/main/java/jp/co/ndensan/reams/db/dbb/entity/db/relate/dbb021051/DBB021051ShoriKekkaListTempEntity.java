package jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）の一時表エンティティです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBB021051ShoriKekkaListTempEntity
        extends DbTableEntityBase<DBB021051ShoriKekkaListTempEntity> implements IDbAccessable {

    private RString エラー区分;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString キー1;
    private RString キー2;
    private RString キー3;
    private RString キー4;
    private RString キー5;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private RString 備考;

}
