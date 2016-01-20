/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.ininnteichousairai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.ninnteichousairai.NinnteiChousairaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.ninnteichousairai.NinteichosaIraiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.ninnteichousairai.WaritsukeEntity;

/**
 * 認定調査依頼情報のマッパーインタフェースです。
 */
public interface INinnteiChousairaiMapper {

    /**
     * 認定調査委託先情報を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return NinnteiChousairaiEntity 要介護認定結果情報Entityクラスです。
     */
    List<NinnteiChousairaiEntity> selectNinnteiChousaItaku(NinnteiChousairaiParameter parametere);

    /**
     * 調査員情報を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return NinnteiChousairaiEntity 要介護認定結果情報Entityクラスです。
     */
    List<NinnteiChousairaiEntity> selectChousaIn(NinnteiChousairaiParameter parametere);

    /**
     * 割付済み申請者一覧を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return WaritsukeEntity 割付済み申請者一覧Entityクラスです。
     */
    List<WaritsukeEntity> getWaritsuke(NinnteiChousairaiParameter parametere);

    /**
     * 認定調査依頼情報を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return WaritsukeEntity 割付済み申請者一覧Entityクラスです。
     */
    NinteichosaIraiJohoRelateEntity getNinteichosaIraiJohoList(NinnteiChousairaiParameter parametere);

    /**
     * 未割付申請者一覧（新規依頼）を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return WaritsukeEntity 割付済み申請者一覧Entityクラスです。
     */
    List<WaritsukeEntity> getShiteWaritsuke(NinnteiChousairaiParameter parametere);

    /**
     * 未割付申請者一覧（再依頼）を取得します。
     *
     * @param parametere 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return WaritsukeEntity 割付済み申請者一覧Entityクラスです。
     */
    List<WaritsukeEntity> getShiteWaritsukeSai(NinnteiChousairaiParameter parametere);
}
