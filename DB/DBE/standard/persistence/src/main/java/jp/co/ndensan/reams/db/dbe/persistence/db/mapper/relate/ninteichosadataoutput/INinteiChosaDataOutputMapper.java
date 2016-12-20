/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput.DbT5121MybitisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput.NinteiChosaDataOutputMybitisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;

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

    /**
     * 申請履歴情報データを取得します。
     *
     * @param param 申請履歴情報取得用のパラメータ
     * @return List<DbT5121ShinseiRirekiJohoEntity>
     */
    List<DbT5121ShinseiRirekiJohoEntity> get前回申請管理番号List(DbT5121MybitisParameter param);
}
