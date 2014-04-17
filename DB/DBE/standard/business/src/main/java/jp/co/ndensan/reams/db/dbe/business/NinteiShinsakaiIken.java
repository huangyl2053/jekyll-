/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIkenType;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定審査会意見を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiShinsakaiIken {

    // TODO N8156 宮本 康 審査会開催番号だけではなく審査会自体を持たせる。
    private final ShinsakaiKaisaiNo 審査会開催番号;
    private final ShinsakaiIkenType 審査会意見種類;
    private final RString 審査会意見;
    private final RString 審査会メモ;
    private final RString 一次判定結果変更理由;

    /**
     * インスタンスを生成します。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 審査会意見種類 審査会意見種類
     * @param 審査会意見 審査会意見
     * @param 審査会メモ 審査会メモ
     * @param 一次判定結果変更理由 一次判定結果変更理由
     */
    public NinteiShinsakaiIken(
            ShinsakaiKaisaiNo 審査会開催番号,
            ShinsakaiIkenType 審査会意見種類,
            RString 審査会意見,
            RString 審査会メモ,
            RString 一次判定結果変更理由) {
        this.審査会開催番号 = 審査会開催番号;
        this.審査会意見種類 = 審査会意見種類;
        this.審査会意見 = 審査会意見;
        this.審査会メモ = 審査会メモ;
        this.一次判定結果変更理由 = 一次判定結果変更理由;
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
    public ShinsakaiIkenType get審査会意見種類() {
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

    /**
     * 一次判定結果変更理由を返します。
     *
     * @return 一次判定結果変更理由
     */
    public RString get一次判定結果変更理由() {
        return 一次判定結果変更理由;
    }
}
