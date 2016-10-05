/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.servicecode.SabisuKodoParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author LDNS 燕京
 */
public interface IDbT7130KaigoServiceShuruiMapper {

    /**
     * {@link DbT7130KaigoServiceShuruiEntity}を取得します。
     *
     * @return {@link DbT7130KaigoServiceShuruiEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7130KaigoServiceShuruiEntity getEntity();

    /**
     * サービス種類ドロップダウンリストの取得します。
     *
     * @param systemDate システム日付の年月
     * @return List<DbT7130KaigoServiceShuruiEntity>
     */
    List<DbT7130KaigoServiceShuruiEntity> getserviceShuruiCdDDL(RString systemDate);

    /**
     * 親画面より引き渡されたパラメータのサービス種類コードより、サービス種類情報を取得します。
     *
     * @param param param
     * @return List<DbT7130KaigoServiceShuruiEntity>
     */
    List<DbT7130KaigoServiceShuruiEntity> getServiceTypeList2(SabisuKodoParameter param);
}
