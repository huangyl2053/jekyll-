/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.iryohokenRireki;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.iryohokenRireki.IryohokenRirekiShubetsuCodeEntity;

/**
 * 医療保険種別コードを取得する
 * 
 * @author n8429
 */
public interface IIryohokenRirekiMapper {
    
    /**
     *  医療保険種別コードを取得する
     *
     * @return List<SetaiHaakuEntity>
     */
    List<IryohokenRirekiShubetsuCodeEntity> select医療保険種別();
    
}
