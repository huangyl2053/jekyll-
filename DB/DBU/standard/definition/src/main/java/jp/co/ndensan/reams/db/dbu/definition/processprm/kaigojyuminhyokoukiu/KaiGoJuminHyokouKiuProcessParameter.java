/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojyuminhyokoukiu;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki.KobetsuKoikiunyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuMapperParameter;
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

    private List<KobetsuKoikiunyoParameter> kobetsuKoikiunyoParameterList;
    private RString 連携ファイル名;
    private RDateTime dateFrom;
    private RDateTime dateTo;
    private RString shichosonCode;

    /**
     * コンストラクタ
     *
     * @param kobetsuKoikiunyoParameterList kobetsuKoikiunyoParameterList
     */
    public KaiGoJuminHyokouKiuProcessParameter(
            List<KobetsuKoikiunyoParameter> kobetsuKoikiunyoParameterList) {
        this.kobetsuKoikiunyoParameterList = kobetsuKoikiunyoParameterList;
    }

    /**
     * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
     *
     * @return KaigoJuminhyoMapperParameter
     */
    public KaiGoJuminHyokouKiuMapperParameter toKaiGoJuminHyokouKiuMapperParameter() {
        return KaiGoJuminHyokouKiuMapperParameter.createParam(shichosonCode, dateFrom, dateTo);
    }
}
