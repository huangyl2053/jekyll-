/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jyukyusyajoho;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jyukyusyajoho.SogoSyokaiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jyukyusyajoho.JukyuNinteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jyukyusyajoho.JukyuShinseiJohoRelateEntity;

/**
 * 総合照会_受給者情報のMapperクラスです。
 *
 * @reamsid_L DBU-4100-030 xuyannan
 */
public interface ISogoSyokaiMapper {

    /**
     * 受給認定情報を取得します。
     *
     * @param parameter 受給者情報検索用パラメータ
     * @return 受給認定情報
     */
    JukyuNinteiJohoRelateEntity getJukyuNinteiJoho(SogoSyokaiMybatisParameter parameter);

    /**
     * 受給申請情報を取得します。
     *
     * @param parameter 受給申請情報検索用パラメータ
     * @return 受給申請情報
     */
    JukyuShinseiJohoRelateEntity getJukyuShinseiJoho(SogoSyokaiMybatisParameter parameter);
}
