/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputNaiyo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 結果詳細情報画面の出力パラメータです。
 *
 * @reamsid_L DBZ-1320-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KekkaShosaiJohoOutModel implements Serializable {

    private NinteiInputNaiyo 認定内容;
    private List<KekkaShosaiJohoServiceShuri> サービス類リスト;
    private RString 異動事由コード;
    private RString 除事由コード;
    private RString 理由;
    private FlexibleDate 喪失日;
    private FlexibleDate 取下日;
    private FlexibleDate 当初認定期間開始;
    private FlexibleDate 当初認定期間終了;
    private FlexibleDate 発行日１;
    private FlexibleDate 発行日２;
    private RString 申請区分申請時;
    private RString 申請区分法令;
}
