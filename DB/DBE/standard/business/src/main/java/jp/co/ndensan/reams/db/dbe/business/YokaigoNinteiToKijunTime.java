/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 一時判定における、要介護認定等基準時間の情報を持つクラスです。
 *
 * @author n8178 城間篤人
 */
public class YokaigoNinteiToKijunTime {

    private final int 基準時間;
    private final int 食事基準時間;
    private final int 排泄基準時間;
    private final int 移動基準時間;
    private final int 清潔保持基準時間;
    private final int 間接ケア基準時間;
    private final int BPSD関連基準時間;
    private final int 機能訓練基準時間;
    private final int 医療関連基準時間;
    private final int 認知症加算基準時間;

    /**
     * 引数から各基準時間を受け取り、インスタンスを生成します。
     *
     * @param 基準時間 基準時間
     * @param 食事基準時間 食事基準時間
     * @param 排泄基準時間 排泄基準時間
     * @param 移動基準時間 移動基準時間
     * @param 清潔保持基準時間 清潔保持基準時間
     * @param 間接ケア基準時間 間接ケア基準時間
     * @param BPSD関連基準時間 BPSD関連基準時間
     * @param 機能訓練基準時間 機能訓練基準時間
     * @param 医療関連基準時間 医療関連基準時間
     * @param 認知症加算基準時間 認知症加算基準時間
     * @throws IllegalArgumentException いずれかの引数に、0より小さいの値が渡されたとき
     */
    public YokaigoNinteiToKijunTime(int 基準時間, int 食事基準時間, int 排泄基準時間, int 移動基準時間,
            int 清潔保持基準時間, int 間接ケア基準時間, int BPSD関連基準時間, int 機能訓練基準時間,
            int 医療関連基準時間, int 認知症加算基準時間) throws IllegalArgumentException {
        check0以下(基準時間, Messages.E00013.replace("基準時間", "0以上").getMessage());
        check0以下(食事基準時間, Messages.E00013.replace("食事基準時間", "0以上").getMessage());
        check0以下(排泄基準時間, Messages.E00013.replace("排泄基準時間", "0以上").getMessage());
        check0以下(移動基準時間, Messages.E00013.replace("移動基準時間", "0以上").getMessage());
        check0以下(清潔保持基準時間, Messages.E00013.replace("清潔保持基準時間", "0以上").getMessage());
        check0以下(間接ケア基準時間, Messages.E00013.replace("間接ケア基準時間", "0以上").getMessage());
        check0以下(BPSD関連基準時間, Messages.E00013.replace("BPSD関連基準時間", "0以上").getMessage());
        check0以下(機能訓練基準時間, Messages.E00013.replace("機能訓練基準時間", "0以上").getMessage());
        check0以下(医療関連基準時間, Messages.E00013.replace("医療関連基準時間", "0以上").getMessage());
        check0以下(認知症加算基準時間, Messages.E00013.replace("認知症加算基準時間", "0以上").getMessage());

        this.基準時間 = 基準時間;
        this.食事基準時間 = 食事基準時間;
        this.排泄基準時間 = 排泄基準時間;
        this.移動基準時間 = 移動基準時間;
        this.清潔保持基準時間 = 清潔保持基準時間;
        this.間接ケア基準時間 = 間接ケア基準時間;
        this.BPSD関連基準時間 = BPSD関連基準時間;
        this.機能訓練基準時間 = 機能訓練基準時間;
        this.医療関連基準時間 = 医療関連基準時間;
        this.認知症加算基準時間 = 認知症加算基準時間;
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
        return 食事基準時間;
    }

    /**
     * 排泄基準時間を返します。
     *
     * @return 排泄基準時間
     */
    public int get排泄基準時間() {
        return 排泄基準時間;
    }

    /**
     * 移動基準時間を返します。
     *
     * @return 移動基準時間
     */
    public int get移動基準時間() {
        return 移動基準時間;
    }

    /**
     * 清潔保持基準時間を返します。
     *
     * @return 清潔保持基準時間
     */
    public int get清潔保持基準時間() {
        return 清潔保持基準時間;
    }

    /**
     * 間接ケア基準時間を返します。
     *
     * @return 間接ケア基準時間
     */
    public int get間接ケア基準時間() {
        return 間接ケア基準時間;
    }

    /**
     * BPSD関連基準時間を返します。
     *
     * @return BPSD関連基準時間
     */
    public int getBPSD関連基準時間() {
        return BPSD関連基準時間;
    }

    /**
     * 機能訓練基準時間を返します。
     *
     * @return 機能訓練基準時間
     */
    public int get機能訓練基準時間() {
        return 機能訓練基準時間;
    }

    /**
     * 医療関連基準時間を返します。
     *
     * @return 医療関連基準時間
     */
    public int get医療関連基準時間() {
        return 医療関連基準時間;
    }

    /**
     * 認知症加算基準時間を返します。
     *
     * @return 認知症加算基準時間
     */
    public int get認知症加算基準時間() {
        return 認知症加算基準時間;
    }
}
