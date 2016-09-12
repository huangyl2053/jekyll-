/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hanyolisthihokenshadaicho;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoMyBatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoRelateEntity;

/**
 * 汎用リスト_被保険者台帳のMapperクラスです。
 *
 * @reamsid_L DBA-1610-030 lishengli
 */
public interface IHanyoListHihokenshadaichoMapper {

    /**
     * 汎用リスト被保険者台帳データの取得です。
     *
     * @param parameter 汎用リスト_被保険者台帳_マッパー用のパラメータ
     * @return List<HanyoListHihokenshadaichoRelateEntity>
     */
    List<HanyoListHihokenshadaichoRelateEntity> get汎用リスト被保険者台帳データの取得(HanyoListHihokenshadaichoMyBatisParameter parameter);

}
