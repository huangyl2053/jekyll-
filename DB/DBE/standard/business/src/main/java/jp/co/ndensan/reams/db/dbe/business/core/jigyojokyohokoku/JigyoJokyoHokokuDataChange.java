/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 実施状況統計情報の一覧データのクラスです。
 *
 * @reamsid_L DBE-1450-100 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoJokyoHokokuDataChange {

    private final RString listJigyojokyoHokoku1;
    private final RString listJigyojokyoHokoku2;
    private final RString listJigyojokyoHokoku3;
    private final RString listJigyojokyoHokoku4;
    private final RString listJigyojokyoHokoku5;
    private final RString listJigyojokyoHokoku6;
    private final RString listJigyojokyoHokoku7;
    private final RString listJigyojokyoHokoku8;
    private final RString listJigyojokyoHokoku9;
    private final RString listJigyojokyoHokoku10;

    /**
     * コンストラクタです。
     *
     * @param listJigyojokyoHokoku1 帳票一覧1行目
     * @param listJigyojokyoHokoku2 帳票一覧2行目
     * @param listJigyojokyoHokoku3 帳票一覧3行目
     * @param listJigyojokyoHokoku4 帳票一覧4行目
     * @param listJigyojokyoHokoku5 帳票一覧5行目
     * @param listJigyojokyoHokoku6 帳票一覧6行目
     * @param listJigyojokyoHokoku7 帳票一覧7行目
     * @param listJigyojokyoHokoku8 帳票一覧8行目
     * @param listJigyojokyoHokoku9 帳票一覧9行目
     * @param listJigyojokyoHokoku10 帳票一覧10行目
     */
    public JigyoJokyoHokokuDataChange(RString listJigyojokyoHokoku1,
            RString listJigyojokyoHokoku2,
            RString listJigyojokyoHokoku3,
            RString listJigyojokyoHokoku4,
            RString listJigyojokyoHokoku5,
            RString listJigyojokyoHokoku6,
            RString listJigyojokyoHokoku7,
            RString listJigyojokyoHokoku8,
            RString listJigyojokyoHokoku9,
            RString listJigyojokyoHokoku10) {
        this.listJigyojokyoHokoku1 = listJigyojokyoHokoku1;
        this.listJigyojokyoHokoku2 = listJigyojokyoHokoku2;
        this.listJigyojokyoHokoku3 = listJigyojokyoHokoku3;
        this.listJigyojokyoHokoku4 = listJigyojokyoHokoku4;
        this.listJigyojokyoHokoku5 = listJigyojokyoHokoku5;
        this.listJigyojokyoHokoku6 = listJigyojokyoHokoku6;
        this.listJigyojokyoHokoku7 = listJigyojokyoHokoku7;
        this.listJigyojokyoHokoku8 = listJigyojokyoHokoku8;
        this.listJigyojokyoHokoku9 = listJigyojokyoHokoku9;
        this.listJigyojokyoHokoku10 = listJigyojokyoHokoku10;

    }

}
