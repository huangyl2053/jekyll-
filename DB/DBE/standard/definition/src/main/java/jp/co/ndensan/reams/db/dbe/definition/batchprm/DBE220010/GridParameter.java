/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼書一括発行のパラメータクラスです。
 *
 * @reamsid_L DBE-0080-160 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class GridParameter {

    private RString ninteichosaItakusakiCode;
    private RString ninteiChosainCode;
    private RString shoKisaiHokenshaNo;
    private RString shujiiIryoKikanCode;
    private RString ishiNo;
}
