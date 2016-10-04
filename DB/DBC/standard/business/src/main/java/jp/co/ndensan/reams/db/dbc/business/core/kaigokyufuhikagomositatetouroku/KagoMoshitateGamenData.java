/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）の画面データを設定クラスです。
 *
 * @reamsid_L DBC-2220-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoMoshitateGamenData implements Serializable {

    private RString 事業者;
    private RString 事業者名;
    private RString 被保番号;
    private RString 被保番名;
    private RDate 提供年月From;
    private RDate 提供年月To;
    private RString 保険者;
    private List<RString> 申立書作成済;

}
