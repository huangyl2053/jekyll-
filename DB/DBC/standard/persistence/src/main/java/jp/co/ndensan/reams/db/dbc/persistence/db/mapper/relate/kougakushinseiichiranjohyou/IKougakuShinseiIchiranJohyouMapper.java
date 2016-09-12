/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakushinseiichiranjohyou;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakushinseiichiranjohyou.KougakuShinseiIchiranJohyouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakushinseiichiranjohyou.KougakuShinseiIchiranJohyouEntity;

/**
 * ビジネス設計_DBCKD00005_高額申請一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-050 quxiaodong
 */
public interface IKougakuShinseiIchiranJohyouMapper {

    /**
     * 高額申請一覧情報（高額）取得
     *
     * @param 高額一覧情報 KougakuShinseiIchiranJohyouParameter
     * @return List<KogakuKyuufuTaishouListEntity>
     */
    List<KougakuShinseiIchiranJohyouEntity> getKougakuShinseiIchiranJohyou(
            KougakuShinseiIchiranJohyouParameter 高額一覧情報);

    /**
     * 高額申請一覧情報（事業高額）取得
     *
     * @param 事業高額一覧情報 KougakuShinseiIchiranJohyouParameter
     * @return List<KogakuKyuufuTaishouListEntity>
     */
    List<KougakuShinseiIchiranJohyouEntity> getJigyouKougakuShinseiIchiranJohyou(
            KougakuShinseiIchiranJohyouParameter 事業高額一覧情報);

}
