/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 厚生労働省IFコード　02Aに対応した列挙体
 */
public enum ServiceJokyoFlag02A implements IServiceJokyoFlag {

    /**
     * 厚生労働省IFコードが 02A のときの 住宅改修 の各設定値
     */
    住宅改修(1, "住宅改修");

    private final int 連番;
    private final RString 名称;

    private ServiceJokyoFlag02A(int remban, String name) {
        this.連番 = remban;
        this.名称 = new RString(name);
    }

    /**
     * このEnum内での連番を返します
     *
     * @return Enum内での連番
     */
    @Override
    public int get連番() {
        return this.連番;
    }

    /**
     * 選択された要素の帳票上でのラベル名を返します。
     *
     * @return 帳票上のラベル名
     */
    @Override
    public RString get名称() {
        return this.名称;
    }
}
