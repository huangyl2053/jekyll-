/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteikekkarenkeidetatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001.ShimeiWaKuhakuNoShoriEntity;

/**
 * 被保険者ｶﾅ氏名と被保険者漢字氏名は空白処理のマッパーインタフェースです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public interface IShimeiWaKuhakuNoShoriMapper {

    /**
     * 空白の処理
     *
     * @return 空白の処理
     */
    List<ShimeiWaKuhakuNoShoriEntity> get空白の処理();

}
