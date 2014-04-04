/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenShurui;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定審査会意見を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiShinsakaiIken {

    private final ShinsakaiKaisaiNo 審査会開催番号;
    private final ShinsakaiIkenShurui 審査会意見種類;
    private final RString 審査会意見;
    private final RString 審査会メモ;

    /**
     * インスタンスを生成します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会意見種類 審査会意見種類
     * @param 審査会意見 審査会意見
     * @param 審査会メモ 審査会メモ
     */
    public NinteiShinsakaiIken(
            ShinsakaiKaisaiNo 審査会開催番号,
            ShinsakaiIkenShurui 審査会意見種類,
            RString 審査会意見,
            RString 審査会メモ) {
        this.審査会開催番号 = 審査会開催番号;
        this.審査会意見種類 = 審査会意見種類;
        this.審査会意見 = 審査会意見;
        this.審査会メモ = 審査会メモ;
    }

    /**
     * 審査会開催番号を返します。
     *
     * @return 審査会開催番号
     */
    public ShinsakaiKaisaiNo get審査会開催番号() {
        return 審査会開催番号;
    }

    /**
     * 審査会意見種類を返します。
     *
     * @return 審査会意見種類
     */
    public ShinsakaiIkenShurui get審査会意見種類() {
        return 審査会意見種類;
    }

    /**
     * 審査会意見を返します。
     *
     * @return 審査会意見
     */
    public RString get審査会意見() {
        return 審査会意見;
    }

    /**
     * 審査会メモを返します。
     *
     * @return 審査会メモ
     */
    public RString get審査会メモ() {
        return 審査会メモ;
    }
}
