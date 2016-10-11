/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushagenmenjkoujyotai;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd104010.DBD104010MybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijkouTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijyotaiEntity;

/**
 * 受給者減免実施状況の受給者減免月別申請・認定状況表のMapperです。
 *
 * @reamsid_L DBD-3770-060 liuwei2
 */
public interface IJukyushagenmenshinseiMapper {

    /**
     * 認定状況情報を取得する。
     *
     * @param parameter DBD104010MybatisParameter
     * @return List<NinteijyotaiEntity>
     */
    List<NinteijyotaiEntity> get認定状況情報(DBD104010MybatisParameter parameter);

    /**
     * 帳票の出力情報を取得する。
     *
     * @return List<NinteijkouTempTableEntity>
     */
    List<NinteijkouTempTableEntity> get出力情報();
}
