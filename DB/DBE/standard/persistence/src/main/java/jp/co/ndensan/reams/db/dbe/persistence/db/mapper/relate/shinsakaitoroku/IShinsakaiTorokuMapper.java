/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaitoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaitoroku.ShinsakaiTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakaikaisai.ShinsakaiKaisaiParameter;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikaisai.ShinsakaiKaisaiRelateEntity;

/**
 * 介護認定審査会登録
 *
 * @author n3402 猪股 祐太
 */
public interface IShinsakaiTorokuMapper {
    
    /**
     * 要介護認定申請情報&構成市町村マスタ&要介護認定完了情報&介護認定審査会割当情報&介護認定審査会開催予定情報
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return List<ShinsakaiTorokuRelateEntity>
     */
    List<ShinsakaiTorokuRelateEntity> get審査会登録(YokaigoNinteiTaskListParameter parameter);
    
    /**
     * 審査会一覧情報検索する。
     *
     * @param parameter 介護認定審査会共有一覧のパラメータクラス
     * @return List<ShinsakaiKaisaiRelateEntity>
     */
    List<ShinsakaiKaisaiRelateEntity> get審査会一覧(ShinsakaiKaisaiParameter parameter);

}
