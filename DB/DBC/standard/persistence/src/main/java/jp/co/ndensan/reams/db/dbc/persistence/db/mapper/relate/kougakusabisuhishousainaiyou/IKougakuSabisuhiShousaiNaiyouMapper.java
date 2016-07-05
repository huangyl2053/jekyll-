/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakusabisuhishousainaiyou;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouEntity;

/**
 * ビジネス設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-020 quxiaodong
 */
public interface IKougakuSabisuhiShousaiNaiyouMapper {

    /**
     * 高額サービス費詳細内容取得
     *
     * @param 高額サービス費詳細内容 KougakuSabisuhiShousaiNaiyouParameter
     * @return KougakuSabisuhiShousaiNaiyouEntity
     */
    KougakuSabisuhiShousaiNaiyouEntity get高額サービス費詳細内容(
            KougakuSabisuhiShousaiNaiyouParameter 高額サービス費詳細内容);

    /**
     * 事業高額サービス費詳細内容取得
     *
     * @param 事業高額サービス費詳細内容 KougakuSabisuhiShousaiNaiyouParameter
     * @return KougakuSabisuhiShousaiNaiyouEntity
     */
    KougakuSabisuhiShousaiNaiyouEntity get事業高額サービス費詳細内容(
            KougakuSabisuhiShousaiNaiyouParameter 事業高額サービス費詳細内容);

    /**
     * 高額決定エリア情報取得
     *
     * @param 高額決定エリア情報 KougakuSabisuhiShousaiNaiyouParameter
     * @return KougakuSabisuhiShousaiNaiyouEntity
     */
    KougakuSabisuhiShousaiNaiyouEntity get高額決定エリア情報(
            KougakuSabisuhiShousaiNaiyouParameter 高額決定エリア情報);

    /**
     * 事業高額決定エリア情報取得
     *
     * @param 事業高額決定エリア情報 KougakuSabisuhiShousaiNaiyouParameter
     * @return KougakuSabisuhiShousaiNaiyouEntity
     */
    KougakuSabisuhiShousaiNaiyouEntity get事業高額決定エリア情報(
            KougakuSabisuhiShousaiNaiyouParameter 事業高額決定エリア情報);

}
