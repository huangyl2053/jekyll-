/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 算定の基礎1~3の情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SanteiNoKiso {

    private RString 年度;
    private RString 名称;
    private RString 金額;
    private RString 単位;
    private SanteiNoKiso 基礎1;
    private SanteiNoKiso 基礎2;
    private SanteiNoKiso 基礎3;

}
