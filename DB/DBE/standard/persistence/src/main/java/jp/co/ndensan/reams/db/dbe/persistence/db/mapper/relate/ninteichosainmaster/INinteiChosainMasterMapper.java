/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosainmaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosainmaster.NinteiChosainMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosainmaster.NinteiChosainMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosainmaster.NinteiChosainMasterRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;

/**
 * 調査員情報のマッパーインタフェースです。
 */
public interface INinteiChosainMasterMapper {

    /**
     * 検索条件より、適当な条件を連結して、調査員情報を検索する。
     *
     * @param 検索条件 調査員情報検索条件
     * @return NinteiChosainMasterEntityの{@code list}
     */
    List<NinteiChosainMasterRelateEntity> selectChosainJohoIchiranList(NinteiChosainMasterMapperParameter 検索条件);

    /**
     * 調査員情報の重複チェック。
     *
     * @param 検索条件 調査員情報検索条件
     * @return 検索件数
     */
    int selectChosainJohoCount(NinteiChosainMasterSearchParameter 検索条件);

    /**
     * 要介護認定申請情報件数検索処理。
     *
     * @param 検索条件 検索条件
     * @return 検索件数
     */
    int selectNinteiShinseiJohoCount(NinteiChosainMasterSearchParameter 検索条件);

    /**
     * 認定調査依頼情報件数検索処理。
     *
     * @param 検索条件 検索条件
     * @return 検索件数
     */
    int selectNinteichosaIraiJohoCount(NinteiChosainMasterSearchParameter 検索条件);

    /**
     * 検索条件より、適当な条件を連結して、調査員情報を検索する。
     *
     * @param 検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterEntityの{@code list}
     */
    List<DbT5913ChosainJohoEntity> selectChosainJohoList(NinteiChosainMasterMapperParameter 検索条件);
}
