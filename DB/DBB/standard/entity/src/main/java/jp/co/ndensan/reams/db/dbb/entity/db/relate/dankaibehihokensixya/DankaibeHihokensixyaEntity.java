/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibehihokensixya;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 段階別被保険者数一覧。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibeHihokensixyaEntity extends DbTableEntityBase<DankaibeHihokensixyaEntity> implements IDbAccessable {

    private RString 市町村コード;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;
    private FlexibleDate 賦課基準日;
    private RString 保険者設定段階;
    private RString 標準設定段階;
    private Decimal 合計所得金額;
    private Decimal 年金収入額;
    private FlexibleDate 生保開始日;
    private FlexibleDate 生保終了日;
    private FlexibleDate 老年開始日;
    private FlexibleDate 老年終了日;
}
