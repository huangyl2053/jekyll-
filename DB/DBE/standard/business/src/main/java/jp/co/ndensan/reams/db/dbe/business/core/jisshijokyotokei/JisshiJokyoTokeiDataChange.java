/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jisshijokyotokei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 実施状況統計情報の一覧データのクラスです。
 *
 * @reamsid_L DBE-1450-040 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JisshiJokyoTokeiDataChange {

    private final RString listJisshiTokei1;
    private final RString listJisshiTokei2;
    private final RString listJisshiTokei3;
    private final RString listJisshiTokei4;
    private final RString listJisshiTokei5;

    /**
     * コンストラクタです。
     *
     * @param listJisshiTokei1 帳票一覧1行目
     * @param listJisshiTokei2 帳票一覧2行目
     * @param listJisshiTokei3 帳票一覧3行目
     * @param listJisshiTokei4 帳票一覧4行目
     * @param listJisshiTokei5 帳票一覧5行目
     */
    public JisshiJokyoTokeiDataChange(RString listJisshiTokei1,
            RString listJisshiTokei2,
            RString listJisshiTokei3,
            RString listJisshiTokei4,
            RString listJisshiTokei5) {
        this.listJisshiTokei1 = listJisshiTokei1;
        this.listJisshiTokei2 = listJisshiTokei2;
        this.listJisshiTokei3 = listJisshiTokei3;
        this.listJisshiTokei4 = listJisshiTokei4;
        this.listJisshiTokei5 = listJisshiTokei5;
    }

}
