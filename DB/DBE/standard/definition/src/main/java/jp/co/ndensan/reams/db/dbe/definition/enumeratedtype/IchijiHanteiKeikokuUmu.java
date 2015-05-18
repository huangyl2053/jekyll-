/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定警告の有無を表す区分です。
 *
 * @author n8178 城間篤人
 */
public enum IchijiHanteiKeikokuUmu {

    /**
     * 警告有りであることを表します。
     */
    警告有り("1"),
    /**
     * 警告無しであることを表します。
     */
    警告無し("0");
    private final RString 警告有無区分コード;

    private IchijiHanteiKeikokuUmu(String 警告有無区分コード) {
        this.警告有無区分コード = new RString(警告有無区分コード);
    }

    /**
     * 警告が出ているか否かを返します。
     *
     * @return 警告有りならtrue
     */
    public boolean is警告有り() {
        return "1".equals(警告有無区分コード.toString());
    }

    /**
     * 警告の有無を表す文字列を返します。
     *
     * @return 警告有無区分コード
     */
    public RString get警告有無区分コード() {
        return 警告有無区分コード;
    }

    /**
     * 引数から警告有無区分コードを指定し、対応する警告有無区分を返します。<br/>
     * 引数に対応する警告有無区分が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param 警告有無区分コード 警告有無区分コード
     * @return 対応する警告有無区分
     * @throws IllegalArgumentException 対応する警告有無区分が存在しない場合
     */
    public static IchijiHanteiKeikokuUmu toValue(RString 警告有無区分コード) throws IllegalArgumentException {
        for (IchijiHanteiKeikokuUmu 警告有無区分 : values()) {
            if (警告有無区分.get警告有無区分コード().equals(警告有無区分コード)) {
                return 警告有無区分;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する警告有無区分").evaluate());
    }
}
