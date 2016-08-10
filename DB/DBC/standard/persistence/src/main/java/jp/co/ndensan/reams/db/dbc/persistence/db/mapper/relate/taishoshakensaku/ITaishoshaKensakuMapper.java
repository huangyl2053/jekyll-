/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.taishoshakensaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishoshakensaku.TaishoshaKensakuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;

/**
 * ビジネス設計_DBCMN81002_受給者訂正連絡票登録（対象者検索）（画面）
 *
 * @reamsid_L DBC-2101-040 quxiaodong
 */
public interface ITaishoshaKensakuMapper {

    /**
     * 検索条件より、受給者異動対象者一覧を取得する。
     *
     * @param 画面Div TaishoshaKensakuParameter
     * @return List<DbT3001JukyushaIdoRenrakuhyoEntity>
     */
    List<DbT3001JukyushaIdoRenrakuhyoEntity> selectJukyushaIdoTaishosha(TaishoshaKensakuParameter 画面Div);
}
