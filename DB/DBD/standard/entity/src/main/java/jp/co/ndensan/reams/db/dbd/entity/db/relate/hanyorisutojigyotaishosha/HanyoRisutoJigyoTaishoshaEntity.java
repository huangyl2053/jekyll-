/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojigyotaishosha;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(事業対象者)のRelateEntityクラスです。
 *
 * @reamsid_L DBD-5080-030 mawy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoRisutoJigyoTaishoshaEntity {

    private RString 被保険者台帳管理_市町村コード;
    private RString 識別コード;
    private int 履歴番号;
    private RString 二次予防事業対象者_被保険者番号;
    private int 二次予防事業対象者_履歴番号;
    private FlexibleDate 二次予防事業対象者_適用開始年月日;
    private FlexibleDate 二次予防事業対象者_適用終了年月日;
    private FlexibleDate 二次予防事業対象者_チェックリスト実施日;
    private FlexibleDate 二次予防事業対象者_決定年月日;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private UaFt250FindAtesakiEntity atesakiEntity;
}
