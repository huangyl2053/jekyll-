/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shotokushokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shotokushokai.ShotokuShokaiTaishoshaIchiranParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokai.ShotokuShokaiTaishoshaEntity;

/**
 * 画面設計_DBBGM51001_所得照会状況一覧のMapperです。<br>
 *
 * @reamsid_L DBB-1700-010 zhangrui
 */
public interface IShotokuShokaiMapper {

    /**
     * 対象者一覧データを取得
     *
     *
     * @param parameter ShotokuShokaiTaishoshaIchiranParameter
     * @return ShotokuShokaiTaishoshaのList
     */
    List<ShotokuShokaiTaishoshaEntity> get対象者一覧データ(ShotokuShokaiTaishoshaIchiranParameter parameter);

}
