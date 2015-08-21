/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会意見種類を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShinsakaiIkenType {

    /**
     * 介護サービス種類が「必要な療養への意見」であることを表します。<br />
     * コード : 1
     */
    必要な療養への意見("1"),
    /**
     * 介護サービス種類が「有効期間への意見」であることを表します。<br />
     * コード : 2
     */
    有効期間への意見("2"),
    /**
     * 介護サービス種類が「サービス利用への意見」であることを表します。<br />
     * コード : 3
     */
    サービス利用への意見("3");
    private final RString code;

    private ShinsakaiIkenType(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     */
    public static ShinsakaiIkenType toValue(RString code) {
        for (ShinsakaiIkenType data : ShinsakaiIkenType.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する介護認定審査会意見種類").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する介護認定審査会意見種類").getMessage());
    }
}
