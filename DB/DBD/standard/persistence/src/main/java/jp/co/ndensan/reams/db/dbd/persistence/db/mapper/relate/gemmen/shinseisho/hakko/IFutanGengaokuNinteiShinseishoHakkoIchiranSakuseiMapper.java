/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmen.shinseisho.hakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmen.shinseisho.hakko.FutanGendogakuMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko.FutanGendogakuNinteiShinseishoHakkoIchiranEntity;

/**
 * 負担限度額認定申請書発行一覧表発行_出力対象者情報を取得のMapperクラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
public interface IFutanGengaokuNinteiShinseishoHakkoIchiranSakuseiMapper {

    /**
     * 出力対象者情報を取得します。
     *
     * @param parameter パラメータク
     * @return List<FutanGendogakuNinteiShinseishoHakkoIchiran>
     */
    List<FutanGendogakuNinteiShinseishoHakkoIchiranEntity> get出力対象者情報(FutanGendogakuMybatisParameter parameter);
}
