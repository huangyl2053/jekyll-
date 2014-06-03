/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 一次判定で使用される要介護認定等合計の項目グループです。
 *
 * @author n8178 城間篤人
 */
public enum YokaigoNinteiKijunTimeItem {

    /**
     * 基準時間の合計を表す項目です。
     */
    合計,
    /**
     * 基準時間（食事）の項目です。
     */
    食事,
    /**
     * 基準時間（排泄）の項目です。
     */
    排泄,
    /**
     * 基準時間（移動）の項目です。
     */
    移動,
    /**
     * 基準時間（清潔保持）の項目です。
     */
    清潔保持,
    /**
     * 基準時間（間接ケア）の項目です。
     */
    間接ケア,
    /**
     * 基準時間（BPSD関連）の項目です。
     */
    BPSD関連,
    /**
     * 基準時間（機能訓練）の項目です。
     */
    機能訓練,
    /**
     * 基準時間（医療関連）の項目です。
     */
    医療関連,
    /**
     * 基準時間（認知症加算）の項目です。
     */
    認知症加算;
}
