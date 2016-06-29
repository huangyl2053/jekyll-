/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.koikinaitenkyojoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkanMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.koikinaitenkyojoho.KoikinaiTenkyoRirekiHenkanRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;

/**
 * 広域内転居のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1660-010 xuyongchao
 */
public interface IKoikinaiTenkyoRirekiHenkanMapper {

    /**
     * 検索条件より、適当な条件を連結して、申請者一覧情報を検索する。
     *
     * @param 検索条件 申請者一覧情報条件
     * @return KoikinaiTenkyoRirekiHenkanRelateEntity 検索結果の{@link KoikinaiTenkyoRirekiHenkanRelateEntity}
     */
    List<KoikinaiTenkyoRirekiHenkanRelateEntity> selectKoikinaiTenkyoList(KoikinaiTenkyoRirekiHenkanMapperParameter 検索条件);

    /**
     * DbT5101NinteiShinseiJohoを更新する。
     *
     * @param 検索条件 申請者一覧情報条件
     * @return KoikinaiTenkyoRirekiHenkanRelateEntity 検索結果の{@link KoikinaiTenkyoRirekiHenkanRelateEntity}
     */
    List<DbT5101NinteiShinseiJohoEntity> selectKoikinaiTenkyoListUpdate(KoikinaiTenkyoRirekiHenkanMapperParameter 検索条件);
}
