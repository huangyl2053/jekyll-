/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 審査会が休会したか否かを表します。
 *
 * @author n8178 城間篤人
 */
public enum ShinsakaiKyukaiKubun {

    /**
     * 休会を表します。
     */
    休会(true),
    /**
     * 開催されたことを表します。
     */
    開催(false);
    private boolean 休会フラグ;

    private ShinsakaiKyukaiKubun(boolean 休会フラグ) {
        this.休会フラグ = 休会フラグ;
    }

    /**
     * 休会か否かを返します。
     *
     * @return 休会ならtrue
     */
    public boolean is休会() {
        return 休会フラグ;
    }

    /**
     * 休会か否かを表すフラグを受け取り、対応した審査会休会区分を返します。
     *
     * @param 休会フラグ 休会フラグ
     * @return 対応した審査会休会区分
     */
    public static ShinsakaiKyukaiKubun toValue(boolean 休会フラグ) {
        if (休会フラグ) {
            return 休会;
        }
        return 開催;
    }
}
