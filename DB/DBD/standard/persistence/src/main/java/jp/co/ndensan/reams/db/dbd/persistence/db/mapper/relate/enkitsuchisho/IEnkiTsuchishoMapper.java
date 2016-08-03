/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.enkitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.enkitsuchisho.EnkiTsuchishoJyohoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.enkitsuchisho.EnkiTsuchishohakenIchiranhyoJyohoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.EnkiTsuchishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;

/**
 * 延期通知書出力のMapperです。
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
public interface IEnkiTsuchishoMapper {

    /**
     * 延期通知書発行一覧表情報を取得する。
     *
     * @param parameter EnkiTsuchishohakenIchiranhyoJyohoMybatisParameter
     * @return List<EnkiTsuchishoEntity>
     */
    List<EnkiTsuchishoEntity> get延期通知書発行一覧表情報(EnkiTsuchishohakenIchiranhyoJyohoMybatisParameter parameter);

    /**
     * 延期通知書情報を取得する。
     *
     * @param parameter EnkiTsuchishoJyohoMybatisParameter
     * @return List<DbT4101NinteiShinseiJohoEntity>
     */
    List<DbT4101NinteiShinseiJohoEntity> selectBy申請書管理番号リスト(EnkiTsuchishoJyohoMybatisParameter parameter);
}
