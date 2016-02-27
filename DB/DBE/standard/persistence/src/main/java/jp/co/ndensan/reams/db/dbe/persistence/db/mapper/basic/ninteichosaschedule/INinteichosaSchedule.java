/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.ninteichosaschedule;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosaschedule.INinteiKanryoJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosaschedule.INinteichosaScheduleMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaschedule.INinteichosaScheduleRelateEntity;

/**
 *
 * 認定調査スケジュール登録3のマッパーインタフェースです。
 */
public interface INinteichosaSchedule {

    /**
     * 検索条件より、該当者一覧照会を検索する。
     *
     * @param parametere INinteichosaScheduleMybatisParameter
     * @return INinteichosaScheduleRelateEntity 検索結果の{@link INinteichosaScheduleRelateEntity}
     */
    List<INinteichosaScheduleRelateEntity> selectNinteichosaScheduleList(INinteichosaScheduleMybatisParameter parametere);

    /**
     * パラメータ．モード：3(未定者管理)の場合、画面の検索条件より、認定調査スケジュール情報を検索する。
     *
     * @param parametere INinteiKanryoJohoMybatisParameter
     * @return INinteichosaScheduleRelateEntity 検索結果の{@link INinteichosaScheduleRelateEntity}
     */
    List<INinteichosaScheduleRelateEntity> selectKoseiShichosonMasterList(INinteiKanryoJohoMybatisParameter parametere);

    /**
     * パラメータ．モード：3(検索対象．みなし2号)の場合、画面の検索条件より、認定調査スケジュール情報を検索する。
     *
     * @param parametere INinteiKanryoJohoMybatisParameter
     * @return INinteichosaScheduleRelateEntity 検索結果の{@link INinteichosaScheduleRelateEntity}
     */
    List<INinteichosaScheduleRelateEntity> selectNinteichosaIraiJohoList(INinteiKanryoJohoMybatisParameter parametere);

    /**
     * パラメータ．モード：3(検索対象．申請者)の場合、画面の検索条件より、認定調査スケジュール情報を検索する。
     *
     * @param parametere INinteiKanryoJohoMybatisParameter
     * @return INinteichosaScheduleRelateEntity 検索結果の{@link INinteichosaScheduleRelateEntity}
     */
    List<INinteichosaScheduleRelateEntity> selectNinteiShinseiJohoList(INinteiKanryoJohoMybatisParameter parametere);

    /**
     * 保険者ドロップダウンリスト値取得。
     *
     * @param parametere INinteiKanryoJohoMybatisParameter
     * @return INinteichosaScheduleRelateEntity 検索結果の{@link INinteichosaScheduleRelateEntity}
     */
    List<INinteichosaScheduleRelateEntity> select保険者ドロップダウンリスト(INinteiKanryoJohoMybatisParameter parametere);

}
