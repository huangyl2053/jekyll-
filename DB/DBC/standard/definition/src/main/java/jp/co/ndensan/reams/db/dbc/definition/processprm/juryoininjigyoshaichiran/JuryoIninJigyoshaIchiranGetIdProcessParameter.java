/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.juryoininjigyoshaichiran;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * doIchiranhyoSakuseiパラメータです。
 *
 * @reamsid_L DBC-2110-030 liuxiaoyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuryoIninJigyoshaIchiranGetIdProcessParameter implements IBatchProcessParameter {

    private RString 契約事業者番号FROM;
    private RString 契約事業者番号TO;
    private FlexibleDate 契約日FROM;
    private FlexibleDate 契約日TO;
    private RString 契約種別;
    private RString 契約期間終了事業者;
    private Long 帳票出力順ID;
    private LasdecCode 市町村コード;
    private RDateTime 処理日時;

}
