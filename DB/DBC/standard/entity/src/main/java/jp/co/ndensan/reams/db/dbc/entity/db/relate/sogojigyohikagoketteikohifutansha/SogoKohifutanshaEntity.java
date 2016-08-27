/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteikohifutansha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 総合事業費過誤決定通知書情報取込（公費負担者分）一覧表用entity。
 *
 * @reamsid_L DBC-2810-030 chenjie
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogoKohifutanshaEntity implements Serializable {

    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 証記載保険者名;
    private FlexibleYearMonth 取扱年月;
    private JigyoshaNo 事業所番号;
    private RString 事業所名;
    private RString 公費受給者番号;
    private RString 宛名名称;
    private ShoKisaiHokenshaNo 公費証記載保険者番号;
    private HihokenshaNo 登録被保険者番号;
    private FlexibleYearMonth サービ提供年月;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Code 過誤申立事由コード;
    private RString 過誤申立事由;
    private Decimal 単位数;
    private Decimal 保険者負担額;
    private RString 識別コード;
    private Decimal 介護給付費件数;
    private Decimal 介護給付費単位数;
    private Decimal 介護給付費保険者負担額;

}
