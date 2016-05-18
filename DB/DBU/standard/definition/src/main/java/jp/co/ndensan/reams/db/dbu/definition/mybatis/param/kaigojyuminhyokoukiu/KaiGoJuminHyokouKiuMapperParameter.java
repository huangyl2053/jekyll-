/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatis.param.kaigojyuminhyokoukiu;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class KaiGoJuminHyokouKiuMapperParameter implements IMyBatisParameter {

    private final RString shichosonCode;
    private final RDateTime datefrom;
    private final RDateTime dateto;

    /**
     * コンストラクタです。
     *
     * @param taishoKaishiTimestamp 対象開始日時
     * @param taishoShuryoTimestamp 対象終了日時
     */
    private KaiGoJuminHyokouKiuMapperParameter(
            RString shichosonCode,
            RDateTime datefrom,
            RDateTime dateto) {

        this.shichosonCode = shichosonCode;
        this.datefrom = datefrom;
        this.dateto = dateto;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shichosonCode RString
     * @param datefrom FlexibleDate
     * @param dateto FlexibleDate
     * @return KaiGoJuminHyokouKiuMapperParameter
     */
    public static KaiGoJuminHyokouKiuMapperParameter createParam(
            RString shichosonCode,
            RDateTime datefrom,
            RDateTime dateto) {
        return new KaiGoJuminHyokouKiuMapperParameter(shichosonCode, datefrom, dateto);
    }

}
