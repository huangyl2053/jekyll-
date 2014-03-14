/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 延期通知発行に対する同意有無を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ConsentToEnkitsuchiHakko {

    /**
     * 延期通知発行に同意することを表します。
     */
    同意(true),
    /**
     * 延期通知発行に同意しないことを表します。
     */
    不同意(false);
    private final boolean is同意;

    private ConsentToEnkitsuchiHakko(boolean is同意) {
        this.is同意 = is同意;
    }

    /**
     * 延期通知発行に同意するかどうかを判定します。
     *
     * @return 同意する場合はtrueを返します。
     */
    public boolean is同意() {
        return this.is同意;
    }

    /**
     * 引数(boolean型)に対応する同意有無(列挙型)を返します。
     *
     * @param is同意 同意有無 (boolean型)
     * @return 同意有無 (列挙型)
     */
    public static ConsentToEnkitsuchiHakko toValue(boolean is同意) {
        return is同意 ? 同意 : 不同意;
    }
}
