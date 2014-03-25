/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼の督促情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoSakuseiTokusoku {

    private final FlexibleDate 意見書作成督促年月日;
    private final IkenshoSakuseiTokusokuHoho 意見書作成督促方法;
    private final int 意見書作成督促回数;
    private final RString 意見書作成督促メモ;

    /**
     * インスタンスを生成します。
     *
     * @param 意見書作成督促年月日 意見書作成督促年月日
     * @param 意見書作成督促方法 意見書作成督促方法
     * @param 意見書作成督促回数 意見書作成督促回数
     * @param 意見書作成督促メモ 意見書作成督促メモ
     */
    public ShujiiIkenshoSakuseiTokusoku(
            FlexibleDate 意見書作成督促年月日,
            IkenshoSakuseiTokusokuHoho 意見書作成督促方法,
            int 意見書作成督促回数,
            RString 意見書作成督促メモ) {
        this.意見書作成督促年月日 = 意見書作成督促年月日;
        this.意見書作成督促方法 = 意見書作成督促方法;
        this.意見書作成督促回数 = 意見書作成督促回数;
        this.意見書作成督促メモ = 意見書作成督促メモ;
    }

    /**
     * 意見書作成督促年月日を返します。
     *
     * @return 意見書作成督促年月日
     */
    public FlexibleDate get意見書作成督促年月日() {
        return 意見書作成督促年月日;
    }

    /**
     * 意見書作成督促方法を返します。
     *
     * @return 意見書作成督促方法
     */
    public IkenshoSakuseiTokusokuHoho get意見書作成督促方法() {
        return 意見書作成督促方法;
    }

    /**
     * 意見書作成督促回数を返します。
     *
     * @return 意見書作成督促回数
     */
    public int get意見書作成督促回数() {
        return 意見書作成督促回数;
    }

    /**
     * 意見書作成督促メモを返します。
     *
     * @return 意見書作成督促メモ
     */
    public RString get意見書作成督促メモ() {
        return 意見書作成督促メモ;
    }
}
