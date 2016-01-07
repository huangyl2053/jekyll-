/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.persistence.mapper.relate.koikinaijushochitokurei;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.koikinaijushochitokurei.KoikinaiJushochiTokureiMybatisparamter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.koikinaijushochitokurei.KoikinaiKaijoParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.koikinaijushochitokurei.KoikinaiJushochiTokureiRelateEntity;

/**
 *
 * 広域内住所地特例者情報を取得クラスです。
 */
public interface IKoikinaiJushochiTokureiMapper {
    
    /**
     * 直近広住特適用情報を取得します。
     * @param param 広域内住所地特例者一覧表のMyBatisパラメータ
     * @return 広住特適用情報のエンティティクラスです
     */
    List<KoikinaiJushochiTokureiRelateEntity> get直近広住特適用情報(KoikinaiJushochiTokureiMybatisparamter param);
    
    /**
     * 基準日広住特適用情報を取得します。
     * @param param 広域内住所地特例者一覧表のMyBatisパラメータ
     * @return 広住特適用情報のエンティティクラスです
     */
    List<KoikinaiJushochiTokureiRelateEntity> get基準日広住特適用情報(KoikinaiJushochiTokureiMybatisparamter param);
    
    /**
     * 範囲広住特適用情報を取得します。
     * @param param 広域内住所地特例者一覧表のMyBatisパラメータ
     * @return 広住特適用情報のエンティティクラスです
     */
    List<KoikinaiJushochiTokureiRelateEntity> get範囲広住特適用情報(KoikinaiJushochiTokureiMybatisparamter param);
    
    /**
     * 広域特解除情報を取得します。
     * @param param 広域内住所地特例者一覧表の広域特解除情報を取得処理のMyBatisパラメータ
     * @return 広住特適用情報のエンティティクラスです
     */
    List<KoikinaiJushochiTokureiRelateEntity> get広域特解除情報(KoikinaiKaijoParamter param);
    
}
