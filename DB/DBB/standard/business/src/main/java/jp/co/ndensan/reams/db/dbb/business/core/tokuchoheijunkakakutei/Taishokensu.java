/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchoheijunkakakutei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料段階に対する対象件数と対象外件数を格納する
 *
 * @reamsid_L DBB-0830-020 wangkanglei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class Taishokensu {

    private RString 保険料段階;
    private Integer 確定対象件数;
    private Integer 対象外件数;

    /**
     * コンストラクタです。
     */
    public Taishokensu() {
    }

    /**
     * コンストラクタです。
     *
     * @param 保険料段階 RString
     * @param 確定対象件数 Integer
     * @param 対象外件数 Integer
     */
    public Taishokensu(RString 保険料段階, Integer 確定対象件数, Integer 対象外件数) {
        this.保険料段階 = 保険料段階;
        this.確定対象件数 = 確定対象件数;
        this.対象外件数 = 対象外件数;
    }
}
