/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijoho.gogitaiwariateiinjoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoRelateEntity;

/**
 * 合議体割当委員情報のマッパーインタフェースです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public interface IGogitaiWariateIinJohoMapper {

    /**
     * 合議体割当委員情報情報をキー検索で１件取得します。
     *
     * @param 合議体割当委員情報検索条件 合議体割当委員情報検索条件
     * @return GogitaiWariateIinJohoRelateEntity
     */
    GogitaiWariateIinJohoRelateEntity select合議体割当委員情報ByKey(GogitaiWariateIinJohoMapperParameter 合議体割当委員情報検索条件);

    /**
     * 主キー1に合致する合議体割当委員情報のリストを取得します。
     *
     * @param 合議体割当委員情報検索条件 合議体割当委員情報検索条件
     * @return GogitaiWariateIinJohoRelateEntityの{@code list}
     */
    List<GogitaiWariateIinJohoRelateEntity> select合議体割当委員情報リストBy主キー1(GogitaiWariateIinJohoMapperParameter 合議体割当委員情報検索条件);
}
