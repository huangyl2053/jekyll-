/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteichosajokyo;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * 共有子Div「認定調査状況」のマッパーインタフェースです。
 *
 * @reamsid_L DBZ-1330-020 chengsanyuan
 */
public interface INinteiChosaJokyoMapper {

    /**
     * サーブ業務コードが介護受給の場合、介護事業者の情報取得処理します。
     *
     * @param システム日付 システム日付
     * @return 介護事業者情報
     */
    DbT7060KaigoJigyoshaEntity get介護事業者情報By介護受給(RDate システム日付);

    /**
     * サーブ業務コードが介護認定の場合、介護事業者の情報取得処理します。
     *
     * @param システム日付 システム日付
     * @return 介護事業者情報
     */
    DbT7060KaigoJigyoshaEntity get介護事業者情報By介護認定(RDate システム日付);
}
