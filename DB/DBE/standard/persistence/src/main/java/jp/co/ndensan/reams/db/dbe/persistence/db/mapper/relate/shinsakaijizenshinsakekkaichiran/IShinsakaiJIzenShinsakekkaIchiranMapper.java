/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaijizenshinsakekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaijizenshinsakekkaichiran.ShinsakaiJIzenShinsakekkaIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.JizenShinsaKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.JizenShinsakaiShiryoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranRelateEntity;

/**
 * 審査会事前審査結果一覧表のデータ取得のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
public interface IShinsakaiJIzenShinsakekkaIchiranMapper {

    /**
     * 事前審査会用結果の取得します。
     *
     * @param paramter 審査会事前審査結果一覧表のMyBatis用パラメータ
     * @return JizenShinsakaiShiryoRelateEntity
     */
    JizenShinsakaiShiryoRelateEntity get事前審査会用結果(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter paramter);

    /**
     * 審査員名の取得します。
     *
     * @param paramter 審査会事前審査結果一覧表のMyBatis用パラメータ
     * @return List<JizenShinsaKekkaRelateEntity>
     */
    List<JizenShinsaKekkaRelateEntity> get審査員名(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter paramter);

    /**
     * 審査順の取得します。
     *
     * @param paramter 審査会事前審査結果一覧表のMyBatis用パラメータ
     * @return List<JizenShinsaKekkaRelateEntity>
     */
    List<JizenShinsaKekkaRelateEntity> get審査順(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter paramter);

    /**
     * 審査結果の取得します。
     *
     * @param paramter 審査会事前審査結果一覧表のMyBatis用パラメータ
     * @return List<JizenShinsaKekkaRelateEntity>
     */
    List<JizenShinsaKekkaRelateEntity> get審査結果(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter paramter);

    /**
     * 審査会対象者情報の取得します。
     *
     * @param paramter 審査会事前審査結果一覧表のMyBatis用パラメータ
     * @return List<ShinsakaiJizenshinsakekkaIchiranRelateEntity>
     */
    List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> get審査会対象者情報(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter paramter);

    /**
     * 事前審査会結果情報の取得します。
     *
     * @param paramter 審査会事前審査結果一覧表のMyBatis用パラメータ
     * @return List<ShinsakaiJizenshinsakekkaIchiranRelateEntity>
     */
    List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> get事前審査会結果情報(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter paramter);

    /**
     * 審査会情報の取得します。
     *
     * @param paramter 審査会事前審査結果一覧表のMyBatis用パラメータ
     * @return List<ShinsakaiJizenshinsakekkaIchiranRelateEntity>
     */
    List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> get審査会情報(ShinsakaiJIzenShinsakekkaIchiranMybitisParamter paramter);
}
