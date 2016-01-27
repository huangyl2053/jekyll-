/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.taishouwaritsuke;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.CountShinsakaiIinJogaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.CountShinsakaiWariateIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.KohoshaIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.taishouwaritsuke.TaishouIchiranMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke.KohoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke.TaishouIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke.TaishouWaritsukeHeadEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会対象者割付のmapperクラスです。
 */
public interface ITaishouWaritsukeMapper {

    /**
     * 介護認定審査会対象者割付ヘッドエリア内容検索
     *
     * @param kaisaiNo 開催番号
     * @return ヘッドエリア
     */
    List<TaishouWaritsukeHeadEntity> getTaishouWaritsukeHead(RString kaisaiNo);

    /**
     * 介護認定審査会対象者対象者一覧エリア内容検索
     *
     * @param param パラメータ
     * @return 対象者一覧
     */
    List<TaishouIchiranEntity> getTaishouIchiran(TaishouIchiranMapperParameter param);

    /**
     * 介護認定審査会対象者候補者一覧エリア内容検索
     *
     * @param param パラメータ
     * @return 対象者一覧
     */
    List<KohoshaIchiranEntity> getKohoshaIchiran(KohoshaIchiranMapperParameter param);

    /**
     * 介護認定審査会対象者申請者オブザーバーチェック
     *
     * @param param パラメータ
     * @return 件数
     */
    int countShinsakaiWariateIinJoho(CountShinsakaiWariateIinJohoMapperParameter param);

    /**
     * 介護認定審査会対象者審査会委員除外存在チェック
     *
     * @param param パラメータ
     * @return 件数
     */
    int countShinsakaiIinJogaiJoho(CountShinsakaiIinJogaiJohoMapperParameter param);
}
