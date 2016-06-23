/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigojyuminhyokoukiu;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki.KobetsuKoikiunyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
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

    private final List<KobetsuKoikiunyoParameter> kobetsuKoikiunyoParameterList;

    /**
     * コンストラクタです。
     *
     */
    private KaiGoJuminHyokouKiuMapperParameter(
            List<KobetsuKoikiunyoParameter> kobetsuKoikiunyoParameterList) {

        this.kobetsuKoikiunyoParameterList = kobetsuKoikiunyoParameterList;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param kobetsuKoikiunyoParameterList kobetsuKoikiunyoParameterList
     * @return KaiGoJuminHyokouKiuMapperParameter
     */
    public static KaiGoJuminHyokouKiuMapperParameter createParam(
            List<KobetsuKoikiunyoParameter> kobetsuKoikiunyoParameterList) {
        return new KaiGoJuminHyokouKiuMapperParameter(kobetsuKoikiunyoParameterList);
    }

}
