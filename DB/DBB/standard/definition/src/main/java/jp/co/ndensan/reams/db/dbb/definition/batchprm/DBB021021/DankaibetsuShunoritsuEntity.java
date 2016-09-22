/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021021;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料段階別収納率一覧表作成のバッチパラメタークラスです。
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibetsuShunoritsuEntity {

    private RString 市町村コード;
    private RString 市町村名称;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード RString
     * @param 市町村名称 RString
     */
    public DankaibetsuShunoritsuEntity(RString 市町村コード, RString 市町村名称) {
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
    }
}
