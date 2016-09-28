/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc170010.ServicecodeIdoRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170010.ServicecodeIdoRenrakuhyoOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170010.ServicecodeIdoRenrakuhyoSofuZumiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170010.SogoJigyoServiceCodeTempEntity;

/**
 * 総合事業分サービスコード異動連絡票作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
public interface IServicecodeIdoRenrakuhyoOutMapper {

    /**
     * 送付対象データを取得します。
     *
     * @param parameter ServicecodeIdoRenrakuhyoOutMybatisParameter
     * @return 送付対象データ
     */
    List<ServicecodeIdoRenrakuhyoOutEntity> get送付対象データ(
            ServicecodeIdoRenrakuhyoOutMybatisParameter parameter);

    /**
     * 送付ファイル作成データを取得します。
     *
     * @return 送付ファイル作成データ
     */
    List<SogoJigyoServiceCodeTempEntity> get送付ファイル作成データ();

    /**
     * 送付済データを取得します。
     *
     * @return 送付済データ
     */
    List<ServicecodeIdoRenrakuhyoSofuZumiDataEntity> get送付済データ();
}
