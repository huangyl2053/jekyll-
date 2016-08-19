/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績一時TBL
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1111KyufuJissekiTempEntity {

    private int 連番;
    private RString 交換情報識別番号;
    private NyuryokuShikibetsuNo 入力識別番号;
    private RString レコード種別コード;
    private RString 給付実績情報作成区分コード;
    private FlexibleYearMonth サービス提供年月;
    private RString 給付実績区分;
    private JigyoshaNo 事業所番号;
    private RString 整理番号;
    private int 件数_H1;
    private int 件数_D1;
    private int 件数_DD;
    private int 件数_D2;
    private int 件数_DC;
    private int 件数_D3;
    private int 件数_D4;
    private int 件数_D5;
    private int 件数_D6;
    private int 件数_D7;
    private int 件数_D8;
    private int 件数_DE;
    private int 件数_T1;
    private int 件数_D9;
    private int 件数_DA;
    private int 件数_DB;
    private RString 警告区分コード;
    private HokenshaNo コントロールレコード保険者番号;
    private RString コントロールレコード保険者名;
    private RString 事業者名称;
    private RString 入力識別名称;

}
