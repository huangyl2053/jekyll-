/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.chosaitakusakiandchosainguide;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.param.ikninteichosaitakusakijoho.ChosaItakusakiAndChosainGuideParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.iknijuntsukishichosonjoho.IKijuntsukiShichosonjohoRelateEntity;

/**
 *
 * 調査委託先＆調査員ガイド Mapeerのクラスです。
 */
public interface IChosaItakusakiAndChosainGuideMapper {

    /**
     * 受給モードの取得処理します。
     *
     * @param params 調査委託先＆調査員ガイドパラメータクラス
     * @return List<IKijuntsukiShichosonjohoRelateEntity>
     */
    List<IKijuntsukiShichosonjohoRelateEntity> getKijuntsukiShichosonjoho(ChosaItakusakiAndChosainGuideParameter params);

    /**
     * 認定モードの取得処理します。
     *
     * @param params 調査委託先＆調査員ガイドパラメータクラス
     * @return List<IKijuntsukiShichosonjohoRelateEntity>
     */
    List<IKijuntsukiShichosonjohoRelateEntity> getKijuntsukiShichoson(ChosaItakusakiAndChosainGuideParameter params);
}
