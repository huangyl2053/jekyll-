/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 一次判定で使用される要介護認定等基準時間の項目グループです。
 *
 * @author n8178 城間篤人
 */
public enum YokaigoNinteiKijunTimeItemGroup {

    /**
     * 基準時間の項目です
     */
    基準時間,
    /**
     * 基準時間（食事）の項目です
     */
    基準時間_食事,
    /**
     * 基準時間（排泄）の項目です
     */
    基準時間_排泄,
    /**
     * 基準時間（移動）の項目です
     */
    基準時間_移動,
    /**
     * 基準時間（清潔保持）の項目です
     */
    基準時間_清潔保持,
    /**
     * 基準時間（間接ケア）の項目です
     */
    基準時間_間接ケア,
    /**
     * 基準時間（BPSD関連）の項目です
     */
    基準時間_BPSD関連,
    /**
     * 基準時間（機能訓練）の項目です
     */
    基準時間_機能訓練,
    /**
     * 基準時間（医療関連）の項目です
     */
    基準時間_医療関連,
    /**
     * 基準時間（認知症加算）の項目です
     */
    基準時間_認知症加算;
}
