/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichigojihanteikekkajoho;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定一五次判定結果情報のBusinessクラスです。
 *
 * @reamsid_L DBE-3000-290 chenxiangyu
 */
public class IchiGojiHanteiKekkaJohoBusiness {

    private final IchiGojiHanteiKekkaJohoEntity entity;

    /**
     * 一五次判定結果情報項目を返します。
     *
     * @param entity 一五次判定結果情報RelateEntity
     */
    public IchiGojiHanteiKekkaJohoBusiness(IchiGojiHanteiKekkaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 一五次判定結果情報EntityはNULLの判定です。
     *
     * @return 一五次判定結果情報EntityはNULLが。
     */
    public boolean isEmpty() {
        return entity == null;
    }

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.get厚労省IF識別コード();
    }

    /**
     * 判定年月日を取得します。
     *
     * @return 判定年月日
     */
    public FlexibleDate get判定年月日() {
        return entity.get判定年月日();
    }

    /**
     * 判定結果コードを取得します。
     *
     * @return 判定結果コード
     */
    public Code get判定結果コード() {
        return entity.get判定結果コード();
    }

    /**
     * 認知症加算後の1.5次判定結果を取得します。
     *
     * @return 認知症加算後の1.5次判定結果
     */
    public Code 認知症加算後の一五次判定結果コード() {
        return entity.get認知症加算後の一五次判定結果コード();
    }

    /**
     * 認知症自立度Ⅱ_蓋然性を取得します。
     *
     * @return 認知症自立度Ⅱ_蓋然性
     */
    public Decimal get認知症自立度Ⅱ_蓋然性() {
        return entity.get認知症自立度Ⅱ_蓋然性();
    }

    /**
     * 安定性コードを取得します。
     *
     * @return 安定性コード
     */
    public Code get安定性コード() {
        return entity.get安定性コード();
    }

    /**
     * 給付区分コードを取得します。
     *
     * @return 給付区分コード
     */
    public Code get給付区分コード() {
        return entity.get給付区分コード();
    }

    /**
     * 判定警告コードを取得します。
     *
     * @return 判定警告コード
     */
    public Code get判定警告コード() {
        return entity.get判定警告コード();
    }

    /**
     * 認定調査結果_件数を取得します。
     *
     * @return 認定調査結果_件数
     */
    public int get認定調査結果_件数() {
        return entity.get認定調査結果_件数();
    }

    /**
     * 主治医意見書_件数を取得します。
     *
     * @return 主治医意見書_件数
     */
    public int get主治医意見書_件数() {
        return entity.get主治医意見書_件数();
    }

    /**
     * 基準時間を取得します。
     *
     * @return 基準時間
     */
    public int get基準時間() {
        return entity.get基準時間();
    }

    /**
     * 基準時間_食事を取得します。
     *
     * @return 基準時間_食事
     */
    public int get基準時間_食事() {
        return entity.get基準時間_食事();
    }

    /**
     * 基準時間_排泄を取得します。
     *
     * @return 基準時間_排泄
     */
    public int get基準時間_排泄() {
        return entity.get基準時間_排泄();
    }

    /**
     * 基準時間_移動を取得します。
     *
     * @return 基準時間_移動
     */
    public int get基準時間_移動() {
        return entity.get基準時間_移動();
    }

    /**
     * 基準時間_清潔保持を取得します。
     *
     * @return 基準時間_清潔保持
     */
    public int get基準時間_清潔保持() {
        return entity.get基準時間_清潔保持();
    }

    /**
     * 基準時間_間接ケアを取得します。
     *
     * @return 基準時間_間接ケア
     */
    public int get基準時間_間接ケア() {
        return entity.get基準時間_間接ケア();
    }

    /**
     * 基準時間_BPSD関連を取得します。
     *
     * @return 基準時間_BPSD関連
     */
    public int get基準時間_BPSD関連() {
        return entity.get基準時間_BPSD関連();
    }

    /**
     * 基準時間_機能訓練を取得します。
     *
     * @return 基準時間_機能訓練
     */
    public int get基準時間_機能訓練() {
        return entity.get基準時間_機能訓練();
    }

    /**
     * 基準時間_医療関連を取得します。
     *
     * @return 基準時間_医療関連
     */
    public int get基準時間_医療関連() {
        return entity.get基準時間_医療関連();
    }

    /**
     * 基準時間_認知症加算を取得します。
     *
     * @return 基準時間_認知症加算
     */
    public int get基準時間_認知症加算() {
        return entity.get基準時間_認知症加算();
    }

    /**
     * 中間評価項目得点第一群を取得します。
     *
     * @return 中間評価項目得点第一群
     */
    public int get中間評価項目得点第一群() {
        return entity.get中間評価項目得点第一群();
    }

    /**
     * 中間評価項目得点第二群を取得します。
     *
     * @return 中間評価項目得点第二群
     */
    public int get中間評価項目得点第二群() {
        return entity.get中間評価項目得点第二群();
    }

    /**
     * 中間評価項目得点第三群を取得します。
     *
     * @return 中間評価項目得点第三群
     */
    public int get中間評価項目得点第三群() {
        return entity.get中間評価項目得点第三群();
    }

    /**
     * 中間評価項目得点第四群を取得します。
     *
     * @return 中間評価項目得点第四群
     */
    public int get中間評価項目得点第四群() {
        return entity.get中間評価項目得点第四群();
    }

    /**
     * 中間評価項目得点第五群を取得します。
     *
     * @return 中間評価項目得点第五群
     */
    public int get中間評価項目得点第五群() {
        return entity.get中間評価項目得点第五群();
    }
}
