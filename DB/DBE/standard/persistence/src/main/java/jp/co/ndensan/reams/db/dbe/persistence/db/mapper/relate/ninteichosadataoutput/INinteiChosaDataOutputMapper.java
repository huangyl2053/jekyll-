/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput.NinteiChosaDataOutputMybitisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputRelateEntity;

/**
 * 認定調査データ出力（モバイル）のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1860-010 duanzhanli
 */
public interface INinteiChosaDataOutputMapper {

    /**
     * 認定調査一覧データを取得します。
     *
     * @param param 認定調査データ出力（モバイル）のパラメータ
     * @return List<NinteiChosaDataOutputRelateEntity>
     */
    List<NinteiChosaDataOutputRelateEntity> get認定調査一覧(NinteiChosaDataOutputMybitisParameter param);

    /**
     * 認定調査一覧データを取得します。
     *
     * @param param 認定調査データ出力（モバイル）のパラメータ
     * @return List<NinteiChosaDataOutputRelateEntity>
     */
    List<NinteiChosaDataOutputRelateEntity> get認定調査データ出力(NinteiChosaDataOutputMybitisParameter param);

}
