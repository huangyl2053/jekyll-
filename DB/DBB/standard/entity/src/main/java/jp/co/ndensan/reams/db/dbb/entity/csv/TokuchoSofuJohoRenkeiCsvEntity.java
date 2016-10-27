/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokuchoSofuJohoRenkeiCsvEntity {

    @FldField(order = 6, length = 6)
    private RString ファイル格納件数;
    @FldField(order = 7, length = 42)
    private RString ファイル管理予備;

    /**
     * コンストラクタです。
     *
     * @param ファイル格納件数 RString
     * @param ファイル管理予備 RString
     */
    public TokuchoSofuJohoRenkeiCsvEntity(RString ファイル格納件数, RString ファイル管理予備) {
        this.ファイル格納件数 = ファイル格納件数;
        this.ファイル管理予備 = ファイル管理予備;
    }

}
