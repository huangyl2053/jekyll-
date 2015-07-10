/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.mappers;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author N2810 久保 里史
 */
public interface IKyufuKanrihyo200004Mapper {

    //select
//    List<DbT3014KyufuKanrihyo200004Entity> selectAll();
    //insert
//    int insertKyufuKanrihyo200004(DbT3014KyufuKanrihyo200004Entity newData);
    //delete
    int deleteKyufuKanrihyo200004(@Param("shoriYM") RString shoriYM);
}
