/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績明細Entityクラスです。
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class KyuhuJissekiMeisai {

    private RString サービス種類コード;
    private RString サービス項目コード;
    private RString サービス名称;
    private int 単位数;
    private int 日数回数;
    private int サービス単位数;

}
