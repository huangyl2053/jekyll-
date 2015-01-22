/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.mappers;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author N2810 久保 里史
 */
public interface IKyufuKanrihyo200604Mapper {

    //select
//    List<DbT3015KyufuKanrihyo200604Entity> selectAll();
    //update
//    int updateKyufuKanrihyo200604(DbT3015KyufuKanrihyo200604Entity updateData);
    //delete
    int deleteKyufuKanrihyo200604(@Param("shoriYM") RString shoriYM);
}
