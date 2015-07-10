/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査委員が、審査会に出席したかの区分を表します。
 *
 * @author n8178 城間篤人
 */
public enum ShinsakaiIinShukketsuKubun {

    /**
     * 出席を表す項目です。
     */
    出席("1"),
    /**
     * 欠席を表す項目です。
     */
    欠席("2"),
    /**
     * 遅刻を表す項目です。
     */
    遅刻("3");
    private final RString 出欠区分コード;

    private ShinsakaiIinShukketsuKubun(String 出欠区分コード) {
        this.出欠区分コード = new RString(出欠区分コード);
    }

    /**
     * 出欠区分コードを返します。
     *
     * @return 出欠区分コード
     */
    public RString get出欠区分コード() {
        return 出欠区分コード;
    }

    /**
     * 出欠区分コードを受け取り、対応する出欠区分を返します。
     *
     * @param 出欠区分コード 出欠区分コード
     * @return 対応する出欠区分
     * @throws IllegalArgumentException 対応する出欠区分が存在しないとき
     */
    public static ShinsakaiIinShukketsuKubun toValue(RString 出欠区分コード) throws IllegalArgumentException {
        for (ShinsakaiIinShukketsuKubun 出欠区分 : values()) {
            if (出欠区分.get出欠区分コード().equals(出欠区分コード)) {
                return 出欠区分;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する出欠区分").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する出欠区分").getMessage());
    }
}
