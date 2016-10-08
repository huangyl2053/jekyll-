/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供のmapperクラスです。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
public interface ITokuteiKojinJohoTeikyoMapper {

    /**
     * 版改定のcountを取得します。
     *
     * @param shokaiTeikyoKubun 初回提供区分
     * @return COUNT(版番号)
     */
    int getTokuteiKojinJohoHanKanriCount(RString shokaiTeikyoKubun);
//
//    /**
//     * 受給者基本情報の提供情報(候補)を取得します。
//     *
//     * @param shokaiTeikyoKubun 初回提供区分
//     * @return COUNT(版番号)
//     */
//    int getJukyushaDaichoTeikyoJohoKoho(RString shokaiTeikyoKubun);
}
