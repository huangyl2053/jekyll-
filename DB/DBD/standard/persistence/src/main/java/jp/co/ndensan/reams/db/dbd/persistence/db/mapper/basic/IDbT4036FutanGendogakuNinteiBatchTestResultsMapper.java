/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * {@link jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4036FutanGendogakuNinteiBatchTestResultsEntity}のマッパーIFです。
 *
 * @author n1070 久保裕是
 */
public interface IDbT4036FutanGendogakuNinteiBatchTestResultsMapper {

    int deleteByHihokenshaNo(HihokenshaNo hihokenshaNo);
}
