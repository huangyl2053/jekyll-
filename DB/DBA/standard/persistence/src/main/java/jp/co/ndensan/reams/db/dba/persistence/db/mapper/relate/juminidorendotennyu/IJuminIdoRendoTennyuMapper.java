/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.juminidorendotennyu;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.juminidorendotennyumanager.JuminIdoRendoTennyuManagerMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendotennyu.JuminIdoRendoTennyuRelateEntity;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録_転入
 *
 * @reamsid_L DBA-1410-012 wanghui
 */
public interface IJuminIdoRendoTennyuMapper {

    /**
     * 宛名識別対象PSMと被保険者台帳を結合して抽出する。
     *
     * @param parameter JuminIdoRendoTennyuManagerMybatisParameter
     * @return List<JuminIdoRendoTennyuRelateEntity>
     */
    List<JuminIdoRendoTennyuRelateEntity> getデータ抽出(JuminIdoRendoTennyuManagerMybatisParameter parameter);

    /**
     * 宛名識別対象PSMと被保険者台帳を結合して抽出する。
     *
     * @param parameter JuminIdoRendoTennyuManagerMybatisParameter
     * @return List<JuminIdoRendoTennyuRelateEntity>
     */
    List<JuminIdoRendoTennyuRelateEntity> get処理対象者(JuminIdoRendoTennyuManagerMybatisParameter parameter);
}
