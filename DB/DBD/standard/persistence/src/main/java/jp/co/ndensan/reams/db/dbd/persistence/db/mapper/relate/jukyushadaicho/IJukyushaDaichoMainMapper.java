/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd571001.IdoChushutsuDaichoNewMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.IdoChushutsuDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.IdoChushutsuDaichoNewEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.ShoriDateKanriEntity;

/**
 * 受給者台帳情報を取得。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
public interface IJukyushaDaichoMainMapper {

    /**
     * 新たな抽出対象リストを取得。
     *
     * @return DbT4001JukyushaDaichoEntity
     */
    List<IdoChushutsuDaichoEntity> get新たな抽出対象リスト();

    /**
     * 新たな抽出対象リストを取得。
     *
     * @param mybatisParameter mybatisParameter
     * @return IdoChushutsuDaichoNewEntity
     */
    List<IdoChushutsuDaichoNewEntity> get個人情報と要介護認定情報(IdoChushutsuDaichoNewMybatisParameter mybatisParameter);

    /**
     * 処理日付管理マスタ更新処理
     *
     * @param entity パラメータ
     * @return int
     */
    int updDbt7022ShoriDateKanri(ShoriDateKanriEntity entity);
}
