/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kouhoushajoho;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 候補者情報を取得クラスです。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KouhoushaJohoEntity {

    private UUID 把握処理ID;
    private boolean 更新認定フラグ;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private RString 世帯課税;
    private LasdecCode 市町村コード;
    private boolean 老福;
    private boolean 生保;
    private boolean 旧措置;
    private Code 要介護認定状態区分コード;
    private Code 厚労省IF識別コード;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private RString 利用者負担段階;
    private JigyoshaNo 事業者番号;
    private Decimal 合計所得金額;
    private Decimal 年金収入額;
    private Decimal 非課税年金勘案額;
    private UaFt200FindShikibetsuTaishoEntity entity;
}
