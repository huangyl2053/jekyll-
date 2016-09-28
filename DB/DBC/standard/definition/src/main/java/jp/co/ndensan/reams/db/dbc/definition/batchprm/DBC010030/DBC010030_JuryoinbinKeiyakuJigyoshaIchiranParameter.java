/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC010030;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任契約事業者一覧表です。
 *
 * @reamsid_L DBC-2110-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC010030_JuryoinbinKeiyakuJigyoshaIchiranParameter extends BatchParameterBase {

    @BatchParameter(key = "契約事業者番号FROM", name = "契約事業者番号FROM")
    private RString 契約事業者番号FROM;
    @BatchParameter(key = "契約事業者番号TO", name = "契約事業者番号TO")
    private RString 契約事業者番号TO;
    @BatchParameter(key = "契約日FROM", name = "契約日FROM")
    private FlexibleDate 契約日FROM;
    @BatchParameter(key = "契約日TO", name = "契約日TO")
    private FlexibleDate 契約日TO;
    @BatchParameter(key = "契約種別", name = "契約種別")
    private RString 契約種別;
    @BatchParameter(key = "契約期間終了事業者", name = "契約期間終了事業者")
    private RString 契約期間終了事業者;
    @BatchParameter(key = "改頁出力順ID", name = "改頁出力順ID")
    private RString 改頁出力順ID;
    @BatchParameter(key = "市町村コード", name = "市町村コード")
    private LasdecCode 市町村コード;
    @BatchParameter(key = "処理日時", name = "処理日時")
    private RDateTime 処理日時;
}
