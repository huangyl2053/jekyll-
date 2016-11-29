/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaishuriyushoshikyuketteitsuchishosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc100020.KaishuriyushoShikyuKetteitsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 住宅改修理由書作成手数料請求取得のMapperクラスです。
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
public interface IKaishuriyushoShikyuKetteitsuchishoSakuseiMapper {

    /**
     * 住宅改修理由書作成手数料請求を取得します。
     *
     * @param parameter 住宅改修理由書作成手数料請求のパラメータ
     * @return 住宅改修理由書作成手数料
     */
    List<KaishuriyushoShikyuKetteitsuchishoEntity> get住宅改修理由書作成手数料請求(KaishuriyushoShikyuKetteitsuchishoParameter parameter);

    /**
     * 住宅改修理由書作成手数料請求決定を取得します。
     *
     * @param parameter 住宅改修理由書作成手数料請求決定のパラメータ
     * @return 住宅改修理由書作成手数料請求決定
     */
    List<KaishuriyushoShikyuKetteitsuchishoEntity> get住宅改修理由書作成手数料請求決定(KaishuriyushoShikyuKetteitsuchishoParameter parameter);

    /**
     * 処理日付管理マスタの更新です。
     *
     * @param parameter 住宅改修理由書作成手数料請求決定のパラメータ
     * @return 処理日付管理
     */
    DbT7022ShoriDateKanriEntity select処理日付管理(KaishuriyushoShikyuKetteitsuchishoParameter parameter);
}
