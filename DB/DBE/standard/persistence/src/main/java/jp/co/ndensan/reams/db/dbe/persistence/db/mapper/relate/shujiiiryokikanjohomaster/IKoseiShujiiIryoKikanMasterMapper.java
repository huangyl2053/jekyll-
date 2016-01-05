/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiiryokikanjohomaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiiryokikanjohomaster.KoseiShujiiIryoKikanMasterRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;

/**
 * 主治医医療機関情報のマッパーインタフェースです。
 *
 */
public interface IKoseiShujiiIryoKikanMasterMapper {

    /**
     * 検索条件より、適当な条件を連結して、主治医医療機関情報を検索する。
     *
     * @param 検索条件 主治医医療機関情報検索条件
     * @return KoseiShujiiIryoKikanMasterRelateEntityの{@code list}
     */
    List<KoseiShujiiIryoKikanMasterRelateEntity> selectShujiKikanJohoIchiranList(KoseiShujiiIryoKikanMasterMapperParameter 検索条件);

    /**
     * 主治医医療機関情報の重複チェック。
     *
     * @param 検索条件 主治医医療機関情報検索条件
     * @return 検索件数
     */
    int selectShujiiIryoKikanJohoCount(KoseiShujiiIryoKikanMasterSearchParameter 検索条件);

    /**
     * 削除の場合、主治医情報の検索件数処理。
     *
     * @param 検索条件 検索条件
     * @return 検索処理
     */
    int selectShujiiJohoCount(KoseiShujiiIryoKikanMasterSearchParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、主治医医療機関情報を検索する。
     *
     * @param 検索条件 主治医医療機関マスタ検索条件
     * @return ShujiiIryoKikanJohoEntityの{@code list}
     */
    List<DbT5911ShujiiIryoKikanJohoEntity> selectShujiiIryoKikanJohoList(KoseiShujiiIryoKikanMasterMapperParameter 検索条件);

//    /**
//     * 調査委託先名検索処理。
//     *
//     * @param 検索条件 検索条件
//     * @return 調査委託先名
//     */
//    RString selectNinteichosaItakusakiJoho(KoseiShujiiIryoKikanMasterSearchParameter 検索条件);
}
