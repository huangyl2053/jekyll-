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
public class TokuchoSofuJohoRenkeiKanriEntity {

    @FldField(order = 1, length = 5)
    private RString 管理市町村コード;
    @FldField(order = 2, length = 1)
    private RString 管理スペース;
    @FldField(order = 3, length = 3)
    private RString 管理媒体通番;
    @FldField(order = 4, length = 10)
    private RString 管理作成年月日;
    @FldField(order = 5, length = 31)
    private RString 管理予備;

    /**
     * コンストラクタです。
     *
     * @param 管理市町村コード RString
     * @param 管理スペース RString
     * @param 管理媒体通番 RString
     * @param 管理作成年月日 RString
     * @param 管理予備 RString
     */
    public TokuchoSofuJohoRenkeiKanriEntity(RString 管理市町村コード, RString 管理スペース, RString 管理媒体通番, RString 管理作成年月日,
            RString 管理予備) {
        this.管理市町村コード = 管理市町村コード;
        this.管理スペース = 管理スペース;
        this.管理媒体通番 = 管理媒体通番;
        this.管理作成年月日 = 管理作成年月日;
        this.管理予備 = 管理予備;
    }
}
