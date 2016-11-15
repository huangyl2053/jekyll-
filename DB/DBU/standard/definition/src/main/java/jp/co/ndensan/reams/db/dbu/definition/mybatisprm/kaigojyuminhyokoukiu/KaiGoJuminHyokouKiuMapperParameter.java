/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigojyuminhyokoukiu;

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
    private final RDateTime dateFrom;
    private final RDateTime dateTo;
    private final boolean checkKaishiFlag;
    private final boolean checkShuryoFlag;

    /**
     * コンストラクタです。
     *
     */
    private KaiGoJuminHyokouKiuMapperParameter(
            RString shichosonCode,
            RDateTime dateFrom,
            RDateTime dateTo,
            boolean checkKaishiFlag,
            boolean checkShuryoFlag) {
        this.shichosonCode = shichosonCode;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.checkKaishiFlag = checkKaishiFlag;
        this.checkShuryoFlag = checkShuryoFlag;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shichosonCode RString
     * @param dateFrom RDateTime
     * @param dateTo RDateTime
     * @return KaiGoJuminHyokouKiuMapperParameter
     */
    public static KaiGoJuminHyokouKiuMapperParameter createParam(
            RString shichosonCode,
            RDateTime dateFrom,
            RDateTime dateTo) {
        boolean checkKaishiFlag = false;
        boolean checkShuryoFlag = false;
        if (dateFrom == null) {
            checkShuryoFlag = true;
        } else {
            checkKaishiFlag = true;
        }
        return new KaiGoJuminHyokouKiuMapperParameter(shichosonCode, dateFrom, dateTo, checkKaishiFlag, checkShuryoFlag);
    }

}
