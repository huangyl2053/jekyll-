/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojyuminhyokoukiu;

import jp.co.ndensan.reams.db.dbu.definition.mybatis.param.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuMapperParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KaiGoJuminHyokouKiuProcessParameter implements IBatchProcessParameter {

    private RString shichosonCode;
    private RDateTime datefrom;
    private RDateTime dateto;

    /**
     * コンストラクタ
     *
     * @param shichosonCode 市町村コード
     * @param datefrom 日付FROM
     * @param dateto 日付TO
     */
    public KaiGoJuminHyokouKiuProcessParameter(
            RString shichosonCode,
            RDateTime datefrom,
            RDateTime dateto
    ) {
        this.shichosonCode = shichosonCode;
        this.datefrom = datefrom;
        this.dateto = dateto;
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
     *
     * @return KaigoJuminhyoMapperParameter
     */
    public KaiGoJuminHyokouKiuMapperParameter toKaiGoJuminHyokouKiuMapperParameter() {
        return KaiGoJuminHyokouKiuMapperParameter.createParam(shichosonCode, datefrom, dateto);
    }
}
