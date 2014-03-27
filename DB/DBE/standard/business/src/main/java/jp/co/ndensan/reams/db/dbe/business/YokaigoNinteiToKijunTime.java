/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一時判定における、要介護認定等基準時間の情報を持つクラスです。
 *
 * @author n8178 城間篤人
 */
public class YokaigoNinteiToKijunTime {

    private final int 基準時間;
    private final int 基準時間_食事;
    private final int 基準時間_排泄;
    private final int 基準時間_移動;
    private final int 基準時間_清潔保持;
    private final int 基準時間_間接ケア;
    private final int 基準時間_BPSD関連;
    private final int 基準時間_機能訓練;
    private final int 基準時間_医療関連;
    private final int 基準時間_認知症加算;

    /**
     * 引数から各基準時間を受け取り、インスタンスを生成します。
     *
     * @param 基準時間 基準時間
     * @param 基準時間_食事 食事基準時間
     * @param 基準時間_排泄 排泄基準時間
     * @param 基準時間_移動 移動基準時間
     * @param 基準時間_清潔保持 清潔保持基準時間
     * @param 基準時間_間接ケア 間接ケア基準時間
     * @param 基準時間_BPSD関連 BPSD関連基準時間
     * @param 基準時間_機能訓練 機能訓練基準時間
     * @param 基準時間_医療関連 医療関連基準時間
     * @param 基準時間_認知症加算 認知症加算基準時間
     * @throws IllegalArgumentException いずれかの引数に、0より小さいの値が渡されたとき
     */
    public YokaigoNinteiToKijunTime(int 基準時間, int 基準時間_食事, int 基準時間_排泄, int 基準時間_移動,
            int 基準時間_清潔保持, int 基準時間_間接ケア, int 基準時間_BPSD関連, int 基準時間_機能訓練,
            int 基準時間_医療関連, int 基準時間_認知症加算) throws IllegalArgumentException {
        RString エラー表示 = new RString("0以上");
        check0以下(基準時間, Messages.E00013.replace("基準時間", エラー表示.toString()).getMessage());
        check0以下(基準時間_食事, Messages.E00013.replace("食事基準時間", エラー表示.toString()).getMessage());
        check0以下(基準時間_排泄, Messages.E00013.replace("排泄基準時間", エラー表示.toString()).getMessage());
        check0以下(基準時間_移動, Messages.E00013.replace("移動基準時間", エラー表示.toString()).getMessage());
        check0以下(基準時間_清潔保持, Messages.E00013.replace("清潔保持基準時間", エラー表示.toString()).getMessage());
        check0以下(基準時間_間接ケア, Messages.E00013.replace("間接ケア基準時間", エラー表示.toString()).getMessage());
        check0以下(基準時間_BPSD関連, Messages.E00013.replace("BPSD関連基準時間", エラー表示.toString()).getMessage());
        check0以下(基準時間_機能訓練, Messages.E00013.replace("機能訓練基準時間", エラー表示.toString()).getMessage());
        check0以下(基準時間_医療関連, Messages.E00013.replace("医療関連基準時間", エラー表示.toString()).getMessage());
        check0以下(基準時間_認知症加算, Messages.E00013.replace("認知症加算基準時間", エラー表示.toString()).getMessage());

        this.基準時間 = 基準時間;
        this.基準時間_食事 = 基準時間_食事;
        this.基準時間_排泄 = 基準時間_排泄;
        this.基準時間_移動 = 基準時間_移動;
        this.基準時間_清潔保持 = 基準時間_清潔保持;
        this.基準時間_間接ケア = 基準時間_間接ケア;
        this.基準時間_BPSD関連 = 基準時間_BPSD関連;
        this.基準時間_機能訓練 = 基準時間_機能訓練;
        this.基準時間_医療関連 = 基準時間_医療関連;
        this.基準時間_認知症加算 = 基準時間_認知症加算;
    }

    private int check0以下(int check対象, String エラーメッセージ) {
        if (check対象 < 0) {
            throw new IllegalArgumentException(エラーメッセージ);
        }
        return check対象;
    }

    /**
     * 基準時間を返します。
     *
     * @return 基準時間
     */
    public int get基準時間() {
        return 基準時間;
    }

    /**
     * 食事基準時間を返します。
     *
     * @return 食事基準時間
     */
    public int get食事基準時間() {
        return 基準時間_食事;
    }

    /**
     * 排泄基準時間を返します。
     *
     * @return 排泄基準時間
     */
    public int get排泄基準時間() {
        return 基準時間_排泄;
    }

    /**
     * 移動基準時間を返します。
     *
     * @return 移動基準時間
     */
    public int get移動基準時間() {
        return 基準時間_移動;
    }

    /**
     * 清潔保持基準時間を返します。
     *
     * @return 清潔保持基準時間
     */
    public int get清潔保持基準時間() {
        return 基準時間_清潔保持;
    }

    /**
     * 間接ケア基準時間を返します。
     *
     * @return 間接ケア基準時間
     */
    public int get間接ケア基準時間() {
        return 基準時間_間接ケア;
    }

    /**
     * BPSD関連基準時間を返します。
     *
     * @return BPSD関連基準時間
     */
    public int getBPSD関連基準時間() {
        return 基準時間_BPSD関連;
    }

    /**
     * 機能訓練基準時間を返します。
     *
     * @return 機能訓練基準時間
     */
    public int get機能訓練基準時間() {
        return 基準時間_機能訓練;
    }

    /**
     * 医療関連基準時間を返します。
     *
     * @return 医療関連基準時間
     */
    public int get医療関連基準時間() {
        return 基準時間_医療関連;
    }

    /**
     * 認知症加算基準時間を返します。
     *
     * @return 認知症加算基準時間
     */
    public int get認知症加算基準時間() {
        return 基準時間_認知症加算;
    }
}
