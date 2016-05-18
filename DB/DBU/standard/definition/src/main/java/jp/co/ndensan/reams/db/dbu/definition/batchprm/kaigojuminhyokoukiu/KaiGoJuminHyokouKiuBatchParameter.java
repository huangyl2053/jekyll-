/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyokoukiu;

import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KaiGoJuminHyokouKiuBatchParameter extends BatchParameterBase {

    private static final String SHICHOSOMCODE = "shichosonCode";
    private static final String DATEFORM = "datefrom";
    private static final String DATETO = "dateto";
    @BatchParameter(key = SHICHOSOMCODE, name = "市町村コード")
    private RString shichosonCode;
    @BatchParameter(key = DATEFORM, name = "日付FROM")
    private RDateTime datefrom;
    @BatchParameter(key = DATETO, name = "日付TO")
    private RDateTime dateto;

    /**
     * コンストラクタです。
     */
    public KaiGoJuminHyokouKiuBatchParameter() {
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public KaiGoJuminHyokouKiuProcessParameter toKaiGoJuminHyokouKiuProcessParameter() {
        return new KaiGoJuminHyokouKiuProcessParameter(
                this.shichosonCode,
                this.datefrom,
                this.dateto);
    }
}
