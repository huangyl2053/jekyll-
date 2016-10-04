/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU070020;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki.KobetsuKoikiunyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBU070020_KobetsujikoRenkei_KoikiParameter extends BatchParameterBase {

    private static final String SHICHOSOMCODE = "kobetsuKoikiunyoParameterList";
    @BatchParameter(key = SHICHOSOMCODE, name = "市町村コード")
    private List<KobetsuKoikiunyoParameter> kobetsuKoikiunyoParameterList;

    /**
     * コンストラクタです。
     */
    public DBU070020_KobetsujikoRenkei_KoikiParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param kobetsuKoikiunyoParameterList kobetsuKoikiunyoParameterList
     */
    public DBU070020_KobetsujikoRenkei_KoikiParameter(
            List<KobetsuKoikiunyoParameter> kobetsuKoikiunyoParameterList) {
        this.kobetsuKoikiunyoParameterList = kobetsuKoikiunyoParameterList;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public KaiGoJuminHyokouKiuProcessParameter toKaiGoJuminHyokouKiuProcessParameter() {
        return new KaiGoJuminHyokouKiuProcessParameter(
                kobetsuKoikiunyoParameterList);
    }
}
