/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010;

import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_DataKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 短期入所支給限度額情報取得のMyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TankinyushoShikyugendoGakuMybatisParamter implements IMyBatisParameter {

    private RString サービス提供年月;
    private RString データ区分 = RiyojokyoTokeihyo_DataKubun.合計.getコード();
    private RString 有効 = YukoMukoKubun.有効.getコード();
}
