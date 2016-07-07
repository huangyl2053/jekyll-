/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshiharaiuchiwake;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBE622004_主治医意見書作成料支払内訳確認書のBodyEntityです。
 *
 * @reamsid_L DBE-1980-047 xuyongchao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenShiharaiuchiwakeBodyEntity {

    private final RString listShiharaiuchiwake_1;
    private final RString listShiharaiuchiwake_2;
    private final RString listShiharaiuchiwake_3;
    private final RString listShiharaiuchiwake_4;
    private final RString listShiharaiuchiwake_5;

    /**
     * コンストラクタです。
     *
     * @param listShiharaiuchiwake_1 明細番号
     * @param listShiharaiuchiwake_2 被保険者番号
     * @param listShiharaiuchiwake_3 被保険者氏名
     * @param listShiharaiuchiwake_4 内訳住所
     * @param listShiharaiuchiwake_5 金額
     */
    public IkenShiharaiuchiwakeBodyEntity(RString listShiharaiuchiwake_1,
            RString listShiharaiuchiwake_2,
            RString listShiharaiuchiwake_3,
            RString listShiharaiuchiwake_4,
            RString listShiharaiuchiwake_5) {
        this.listShiharaiuchiwake_1 = listShiharaiuchiwake_1;
        this.listShiharaiuchiwake_2 = listShiharaiuchiwake_2;
        this.listShiharaiuchiwake_3 = listShiharaiuchiwake_3;
        this.listShiharaiuchiwake_4 = listShiharaiuchiwake_4;
        this.listShiharaiuchiwake_5 = listShiharaiuchiwake_5;
    }

}
