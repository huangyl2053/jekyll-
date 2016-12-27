/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会結果データ取込み（モバイル）の取込みファイル情報です。
 */
public enum ShinsakaiDataName {

    /**
     * 審査会情報
     */
    審査会情報("審査会情報.csv"),
    /**
     * 審査委員情報
     */
    審査委員("審査会委員情報.csv"),
    /**
     * 審査結果
     */
    審査結果("審査会結果.csv");

    private final RString ファイル名称;

    /**
     * コンストラクタです。
     *
     * @param meisho 取込みファイル名称
     */
    private ShinsakaiDataName(String meisho) {
        this.ファイル名称 = new RString(meisho);
    }

    /**
     * 取込み対象ファイル名称を返します。
     *
     * @return ファイル名称
     */
    public RString getファイル名称() {
        return ファイル名称;
    }
}
