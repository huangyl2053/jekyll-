/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichosonselector.KoseiShiChosonSelectorParamter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author LDNS xuxf
 */
public interface IDbT7051KoseiShichosonMasterMapper {

    /** 
     * {@linkDbT7051KoseiShichosonMasterEntity}を取得します。
     * @return {@linkDbT7051KoseiShichosonMasterEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7051KoseiShichosonMasterEntity getEntity();

    /**
     * 旧市町村コード情報Listを取得する。
     *
     * @param gappeiChiikiNoItIchiketame 地域番号の一桁目
     * @return 旧市町村コード情報List
     */
    List<DbT7051KoseiShichosonMasterEntity> getKouikiKyuShichosonCodeJohoList(RString gappeiChiikiNoItIchiketame);
    
    /**
     * 構成市町村を検索します。
     * @param param 構成市町村の検索のパラメータ
     * @return 構成市町村マスタ情報
     */
    List<DbT7051KoseiShichosonMasterEntity> getKoseishichosonList(KoseiShiChosonSelectorParamter param);
    
}
