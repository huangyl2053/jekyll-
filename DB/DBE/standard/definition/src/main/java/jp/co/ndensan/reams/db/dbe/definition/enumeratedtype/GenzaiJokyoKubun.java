package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 要介護認定の現在の状況を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum GenzaiJokyoKubun {

    /**
     * 現在の状況が「居宅（施設利用なし）」であることを表します。
     */
    居宅(1),
    /**
     * 現在の状況が「指定介護老人福祉施設」であることを表します。
     */
    指定介護老人福祉施設(2),
    /**
     * 現在の状況が「介護老人保健施設」であることを表します。
     */
    介護老人保健施設(3),
    /**
     * 現在の状況が「指定介護療養型医療施設」であることを表します。
     */
    指定介護療養型医療施設(4),
    /**
     * 現在の状況が「認知症対応型共同生活適用施設（グループホーム）」であることを表します。
     */
    認知症対応型共同生活適用施設(5),
    /**
     * 現在の状況が「特定施設入所者生活介護適用施設（ケアハウス）」であることを表します。
     */
    特定施設入所者生活介護適用施設(6),
    /**
     * 現在の状況が「医療機関（医療保険適用療養病床）」であることを表します。
     */
    医療機関_医療保険適用療養病床(7),
    /**
     * 現在の状況が「医療機関（療養病床以外）」であることを表します。
     */
    医療機関_療養病床以外(8),
    /**
     * 現在の状況が「その他の施設」であることを表します。
     */
    その他の施設(9);
    private final int code;

    private GenzaiJokyoKubun(int code) {
        this.code = code;
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return new RString(Integer.toString(this.code));
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     */
    public static GenzaiJokyoKubun toValue(RString code) {
        for (GenzaiJokyoKubun data : GenzaiJokyoKubun.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        return null;
    }
}
