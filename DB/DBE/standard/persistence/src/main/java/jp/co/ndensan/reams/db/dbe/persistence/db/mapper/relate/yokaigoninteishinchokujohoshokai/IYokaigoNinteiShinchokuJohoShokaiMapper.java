/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteishinchokujohoshokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.yokaigoninteishinchokujohoshokai.YokaigoNinteiParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJohoShokaiRelateEntity;

/**
 *
 * 申請者一覧内容検索のインタフェイスです。
 */
public interface IYokaigoNinteiShinchokuJohoShokaiMapper {
    
    /**
     * 申請者一覧内容の検索です。
     * @param paramter 申請者一覧内容検索のパラメータ
     * @return List<YokaigoNinteiShinchokuJohoShokaiRelateEntity>
     */
    List<YokaigoNinteiShinchokuJohoShokaiRelateEntity> get申請者一覧内容(YokaigoNinteiParamter paramter);
}
