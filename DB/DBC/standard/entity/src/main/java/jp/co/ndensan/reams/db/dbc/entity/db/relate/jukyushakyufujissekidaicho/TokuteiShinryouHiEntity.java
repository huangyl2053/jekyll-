/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳の特定診療費Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiShinryouHiEntity {

    private RString 入力識別番号;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 通し番号;
    private RString 順次番号;
    private RString 傷病名;
    private RString 再審査回数;
    private RString 過誤回数;
    private RString 審査年月;
    private RString 識別番号;
    private RString 単位数;
    private RString 後単位数;
    private RString 摘要;
    private RString 回数;
    private RString サービス点数;
    private RString 合計点数;
    private RString 後回数;
    private RString 後サービス点数;
    private RString 後合計点数;
    private RString 公費１回数;
    private RString 公費１サービス点数;
    private RString 公費１合計点数;
    private RString 後公費１回数;
    private RString 後公費１サービス点数;
    private RString 後公費１合計点数;
    private RString 公費２回数;
    private RString 公費２サービス点数;
    private RString 公費２合計点数;
    private RString 後公費２回数;
    private RString 後公費２サービス点数;
    private RString 後公費２合計点数;
    private RString 公費３回数;
    private RString 公費３サービス点数;
    private RString 公費３合計点数;
    private RString 後公費３回数;
    private RString 後公費３サービス点数;
    private RString 後公費３合計点数;

}
