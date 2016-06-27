/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinwaritsuke;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinwaritsuke.ShinsakaiIinWaritsukeParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinwaritsuke.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinwaritsuke.ShinsakaiiinJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会内容検索のインタフェイスです。
 *
 * @reamsid_L DBE-0130-050 xuyannan
 */
public interface IShinsakaiIinWaritsukeMapper {

    /**
     * 開催番号によって、審査会開催予定情報を取得します。
     *
     * @param kaisaiNo 開催番号
     * @return ShinsakaiKaisaiYoteiJohoRelateEntity
     */
    ShinsakaiKaisaiYoteiJohoRelateEntity get審査会開催予定情報By開催番号(RString kaisaiNo);

    /**
     * 開催番号によって、介護認定審査会委員情報を取得します。
     *
     * @param parameter 審査会内容検索パラメータクラス
     * @return List<ShinsakaiiinJohoRelateEntity>
     */
    List<ShinsakaiiinJohoRelateEntity> get審査会委員情報By開催番号(ShinsakaiIinWaritsukeParameter parameter);

    /**
     * 介護認定審査会委員全件情報を取得します。
     *
     * @param parameter 審査会内容検索パラメータクラス
     * @return List<ShinsakaiiinJohoRelateEntity>
     */
    List<ShinsakaiiinJohoRelateEntity> get審査会委員情報By開催年月日(ShinsakaiIinWaritsukeParameter parameter);
}
