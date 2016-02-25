/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.ShujiiIkenshoSakuseiMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoSakuseiRelateEntity;

/**
 * 認定調査依頼発行一覧表のマッパーインタフェースです。
 */
public interface IShujiiIkenshoSakuseiMapper {

    /**
     * 主治医意見書作成依頼発行一覧表を取得します。
     *
     * @param param 主治医意見書作成依頼発行一覧表のパラメータ
     * @return List<ShujiiIkenshoSakuseiRelateEntity>
     */
    List<ShujiiIkenshoSakuseiRelateEntity> get主治医意見書作成依頼発行一覧表(ShujiiIkenshoSakuseiMybitisParamter param);
}
