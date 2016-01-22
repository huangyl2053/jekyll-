/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajohoshutsuryoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkajohoshutsuryoku.HanteiKekkaJohoShutsuryokuRelateEntity;

/**
 * 判定結果情報出力(保険者）のマッパーインタフェースです。
 */
public interface IHanteiKekkaJohoShutsuryokuMapper {

    /**
     * 出力対象者明細一覧Gridデータを取得します。
     *
     * @param param 判定結果情報出力(保険者）のパラメータ
     * @return List<HanteiKekkaJohoShutsuryokuRelateEntity>
     */
    List<HanteiKekkaJohoShutsuryokuRelateEntity> get出力対象者明細一覧(HanteiKekkaJohoShutsuryokuMybitisParamter param);
}
