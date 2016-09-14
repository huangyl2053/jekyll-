package jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
public class DBB021051TableJohoTempEntity
        extends DbTableEntityBase<DBB021051TableJohoTempEntity> implements IDbAccessable {

    private ShikibetsuCode 識別コード;
    private AtenaKanaMeisho 氏名カナ;
    private RString 市町村コード;
    private AtenaMeisho 氏名;
    private RString wk管内管外区分;
    private YubinNo 郵便番号;
    private RString 住所;
    private RString バーコード住所;
    private AtenaBanchi 番地;
    private Katagaki 方書;
    private RString 行政区;
    private RString 管内管外区分;
    private AtenaMeisho 世帯主名称;
    private RString 代納区分名称;
    private RString 番地コード;
    private GyoseikuCode 行政区コード;
    private ChikuCode 地区コード1;
    private ChikuCode 地区コード2;
    private ChikuCode 地区コード3;
    private SetaiCode 世帯コード;
    private ZenkokuJushoCode 住所コード;
    private HihokenshaNo 被保険者番号;
    private RString 性別;
    private RString 住民種別コード;
    private RString 住民状態コード;
    private RString 現全国地方公共団体コード;
    private FlexibleDate 生年月日;
    private AtenaMeisho 宛名氏名;
    private Katagaki 宛名方書;
}
