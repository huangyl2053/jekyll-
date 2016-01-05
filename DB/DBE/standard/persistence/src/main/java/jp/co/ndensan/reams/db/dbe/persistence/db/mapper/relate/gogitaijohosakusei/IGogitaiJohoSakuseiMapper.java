/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.gogitaijohosakusei.GogitaiJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiRelateEntity;

/**
 * 合議体情報作成のマッパーインタフェースです。
 */
public interface IGogitaiJohoSakuseiMapper {

    /**
     * 合議体情報Gridデータを取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return List<GogitaiJohoSakuseiRelateEntity>
     */
    List<GogitaiJohoSakuseiRelateEntity> getGogitaiJohoSakuseiGridList(GogitaiJohoSakuseiParameter param);

    /**
     * 審査員一覧のデータを取得します。
     *
     * @param param 合議体情報作成のパラメータ
     * @return List<GogitaiJohoSakuseiRelateEntity>
     */
    List<GogitaiJohoSakuseiRelateEntity> getShinsainList(GogitaiJohoSakuseiParameter param);
}
