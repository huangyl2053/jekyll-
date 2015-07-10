/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public enum KokuhorenIFShoriJotaiKubun {

    未処理("1"),
    処理中("2"),
    処理済("3"),
    処理無("9");

    private final RString kubun;

    private KokuhorenIFShoriJotaiKubun(String kubun) {
        this.kubun = new RString(kubun);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getKubun() {
        return kubun;
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param kubun コード
     * @return コードに対応する列挙型
     */
    public static KokuhorenIFShoriJotaiKubun toValue(RString kubun) {
        for (KokuhorenIFShoriJotaiKubun data : values()) {
            if (data.getKubun().equals(kubun)) {
                return data;
            }
        }
        return null;
    }
}
