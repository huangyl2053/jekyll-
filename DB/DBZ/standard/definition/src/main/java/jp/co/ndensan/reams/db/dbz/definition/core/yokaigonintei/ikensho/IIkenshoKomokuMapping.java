/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目マッピングであることを表します。
 */
public interface IIkenshoKomokuMapping {

    /**
     * コード（連番の文字列）を返します。
     *
     * @return コード
     */
    public RString getコード();

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番();

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString get名称();
}
