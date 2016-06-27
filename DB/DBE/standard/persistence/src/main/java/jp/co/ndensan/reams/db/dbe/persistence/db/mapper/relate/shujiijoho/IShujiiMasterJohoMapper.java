/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiijoho.ShujiiMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiijoho.ShujiiMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiijoho.ShujiiMasterRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医マスタのマッパーインタフェースです。
 *
 * @reamsid_L DBE-0250-010  suguangjun 
 */
public interface IShujiiMasterJohoMapper {

    /**
     * 検索条件より、適当な条件を連結して、主治医情報を検索する。
     *
     * @param 検索条件 主治医情報検索条件
     * @return ShujiiMasterRelateEntity 検索結果の{@link ShujiiMasterRelateEntity}
     */
    List<ShujiiMasterRelateEntity> selectShujiiIchiranList(ShujiiMasterMapperParameter 検索条件);

    /**
     * 主治医情報の重複チェック。
     *
     * @param 検索条件 主治医情報検索条件
     * @return 主治医情報検索件数
     */
    int selectShujiiJohoCount(ShujiiMasterSearchParameter 検索条件);

    /**
     * 要介護認定申請情報件数検索処理。
     *
     * @param 検索条件 主治医情報検索条件
     * @return 要介護認定申請情報検索件数
     */
    int selectNinteiShinseiJohoCount(ShujiiMasterSearchParameter 検索条件);

    /**
     * 主治医意見書作成依頼情報件数検索処理。
     *
     * @param 検索条件 主治医情報検索条件
     * @return 主治医意見書作成依頼情報検索件数
     */
    int selectIkenshoIraiJohoCount(ShujiiMasterSearchParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、主治医情報を検索する。
     *
     * @param 検索条件 主治医情報検索条件
     * @return DbT5912ShujiiJohoEntityの{@code list}
     */
    List<DbT5912ShujiiJohoEntity> selectShujiiJohoList(ShujiiMasterMapperParameter 検索条件);

    /**
     * 主治医医療機関名検索処理。
     *
     * @param 検索条件 主治医情報検索条件
     * @return 主治医医療機関名
     */
    RString selectShujiiIryoKikanJoho(ShujiiMasterSearchParameter 検索条件);

    /**
     * 市町村名検索処理。
     *
     * @param 検索条件 主治医情報検索条件
     * @return 市町村名
     */
    RString selectShichosonMeisho(ShujiiMasterSearchParameter 検索条件);
}
