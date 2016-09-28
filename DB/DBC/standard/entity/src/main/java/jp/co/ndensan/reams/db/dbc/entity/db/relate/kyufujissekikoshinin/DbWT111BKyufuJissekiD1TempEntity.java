/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績D1一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT111BKyufuJissekiD1TempEntity {

    private RString 連番;
    private RString レコード番号;
    private RString 交換情報識別番号;
    private RString 入力識別番号;
    private RString レコード種別コード;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 通し番号;
    private RString サービス種類コード;
    private RString サービス項目コード;
    private RString 単位数;
    private RString 日数_回数;
    private RString 公費１対象日数_回数;
    private RString 公費２対象日数_回数;
    private RString 公費３対象日数_回数;
    private RString サービス単位数;
    private RString 公費１対象サービス単位数;
    private RString 公費２対象サービス単位数;
    private RString 公費３対象サービス単位数;
    private RString 摘要;
    private RString 後_単位数;
    private RString 後_日数_回数;
    private RString 後_公費１対象日数_回数;
    private RString 後_公費２対象日数_回数;
    private RString 後_公費３対象日数_回数;
    private RString 後_サービス単位数;
    private RString 後_公費１対象サービス単位数;
    private RString 後_公費２対象サービス単位数;
    private RString 後_公費３対象サービス単位数;
    private RString 再審査回数;
    private RString 過誤回数;
    private RString 審査年月;
    private RString 整理番号;
    private RString 取込年月;
}
