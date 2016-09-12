/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsahoshuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsahoshuichiran.ShinsaHoshuIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員報酬一覧表のデータ取得のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1920-030 zhaoyao
 */
public interface IShinsaHoshuIchiranMapper {

    /**
     * 合計額の取得します。
     *
     * @param paramter 介護認定審査会委員報酬一覧表のMyBatis用パラメータ
     * @return List<ShinsahoshuichiranRelateEntity>
     */
    List<ShinsaHoshuIchiranRelateEntity> get合計額(ShinsaHoshuIchiranMybitisParamter paramter);

    /**
     * 出席状況の取得します。
     *
     * @param 審査会開催年月 審査会開催年月
     * @return List<ShinsahoshuichiranRelateEntity>
     */
    List<ShinsaHoshuIchiranRelateEntity> get出席状況(RString 審査会開催年月);

}
