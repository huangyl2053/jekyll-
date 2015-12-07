/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinjoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 介護認定審査会委員情報のマッパーインタフェースです。
 */
public interface IShinsakaiIinJohoMapper {

    /**
     * 介護認定審査会委員情報情報をキー検索で１件取得します。
     *
     * @param 介護認定審査会委員情報検索条件 介護認定審査会委員情報検索条件
     * @return ShinsakaiIinJohoEntity
     */
    ShinsakaiIinJohoEntity getShinsakaiIinJohoEntity(ShinsakaiIinJohoMapperParameter 介護認定審査会委員情報検索条件);

    /**
     * 介護認定審査会委員情報を廃止フラグ検索でList取得します。
     *
     * @param boolean 廃止フラグ
     * @return ShinsakaiIinJohoEntity
     */
    List<ShinsakaiIinJohoEntity> get審査会委員情報ByHaishiFlag(@Param(value = "haishiFlag") boolean haishiFlag);

    /**
     * 所属機関一覧情報をUserInfo．市町村コード、選択行の審査会委員コードでList取得します。
     *
     * @param 介護認定審査会委員情報検索条件 介護認定審査会委員情報検索条件
     * @return ShinsakaiIinJohoEntity
     */
    List<ShozokuKikanIchiranEntity> get所属機関一覧ByParameter(ShinsakaiIinJohoMapperParameter parameter);

    /**
     * 所属機関一覧情報をUserInfo．市町村コード、選択行の審査会委員コードでList取得します。
     *
     * @param 介護認定審査会委員情報検索条件 介護認定審査会委員情報検索条件
     * @return ShinsakaiIinJohoEntity
     */
    int get審査会委員カウント(ShinsakaiIinJohoMapperParameter parameter);

}
