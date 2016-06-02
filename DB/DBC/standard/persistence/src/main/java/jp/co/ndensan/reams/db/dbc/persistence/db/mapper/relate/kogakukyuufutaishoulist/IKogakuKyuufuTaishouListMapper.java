/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyuufutaishoulist;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukyuufutaishoulist.KogakuKyuufuTaishouListParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntity;

/**
 * ビジネス設計_DBCKD00006_高額給付対象一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-060 quxiaodong
 */
public interface IKogakuKyuufuTaishouListMapper {

    /**
     * 高額給付対象一覧情報（高額）取得
     *
     * @param 高額給付対象一覧情報 KogakuKyuufuTaishouListParameter
     * @return List<KogakuKyuufuTaishouListEntity>
     */
    List<KogakuKyuufuTaishouListEntity> getKogakuKyuufuTaishouList(
            KogakuKyuufuTaishouListParameter 高額給付対象一覧情報);

    /**
     * 高額給付対象一覧情報（高額）取得
     *
     * @param 事業高額給付対象一覧情報 KogakuKyuufuTaishouListParameter
     * @return List<KogakuKyuufuTaishouListEntity>
     */
    List<KogakuKyuufuTaishouListEntity> getJigyouKogakuKyuufuTaishouList(
            KogakuKyuufuTaishouListParameter 事業高額給付対象一覧情報);

}
