/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteikekkajohosearch;

import jp.co.ndensan.reams.db.dbe.entity.ichijihanteikekkajohosearch.IchijiHanteiKekkaJohoSearchEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 一次判定結果情報を管理するクラスです。
 */
public class IchijiHanteiKekkaJohoSearchBusiness {

    private final IchijiHanteiKekkaJohoSearchEntity entity;

    /**
     * 一次判定結果情報を返します。
     *
     * @param entity IchijiHanteiKekkaJohoSearchEntity
     */
    public IchijiHanteiKekkaJohoSearchBusiness(IchijiHanteiKekkaJohoSearchEntity entity) {
        this.entity = entity;
    }

    /**
     * 一次判定結果を返します。
     *
     * @return 一次判定結果
     */
    public RString get一次判定結果() {
        return entity.get一次判定結果();
    }

    /**
     * 一次判定警告コードを返します。
     *
     * @return 一次判定警告コード
     */
    public RString get一次判定警告コード() {
        return entity.get一次判定警告コード();
    }

    /**
     * 中間評価項目得点を返します。
     *
     * @return 中間評価項目得点
     */
    public RString get中間評価項目得点() {
        return entity.get中間評価項目得点();
    }

    /**
     * 状態の安定性を返します。
     *
     * @return 状態の安定性
     */
    public RString get状態の安定性() {
        return entity.get状態の安定性();
    }

    /**
     * 要介護認定等基準時間を返します。
     *
     * @return 要介護認定等基準時間
     */
    public RString get要介護認定等基準時間() {
        return entity.get要介護認定等基準時間();
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分を返します。
     *
     * @return 認知機能及び状態安定性から推定される給付区分
     */
    public RString get認知機能及び状態安定性から推定される給付区分() {
        return entity.get認知機能及び状態安定性から推定される給付区分();
    }

    /**
     * 認知症加算後の一次判定結果を返します。
     *
     * @return 認知症加算後の一次判定結果
     */
    public RString get認知症加算後の一次判定結果() {
        return entity.get認知症加算後の一次判定結果();
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性_評価の１０倍を返します。
     *
     * @return 認知症自立度Ⅱ以上の蓋然性_評価の１０倍
     */
    public RString get認知症自立度Ⅱ以上の蓋然性_評価の１０倍() {
        return entity.get認知症自立度Ⅱ以上の蓋然性_評価の１０倍();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.get厚労省IF識別コード();
    }

    /**
     * 要介護認定主治医意見書情報件数を返します。
     *
     * @return 要介護認定主治医意見書情報件数
     */
    public int get要介護認定主治医意見書情報件数() {
        return entity.get要介護認定主治医意見書情報件数();
    }

    /**
     * 認定調査票_基本調査_件数を返します。
     *
     * @return 認定調査票_基本調査_件数
     */
    public int get認定調査票_基本調査_件数() {
        return entity.get認定調査票_基本調査_件数();
    }

}
