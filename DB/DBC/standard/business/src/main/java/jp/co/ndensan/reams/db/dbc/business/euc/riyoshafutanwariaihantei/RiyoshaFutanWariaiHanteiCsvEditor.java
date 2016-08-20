/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.riyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc180020.RiyoshaFutanWariaiHanteiCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK1002_利用者負担割合判定（共通）のCSVデータの編集クラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class RiyoshaFutanWariaiHanteiCsvEditor {

    private static final RString 処理区分1 = new RString("1");
    private RString messageKubun;
    private RString hihokenshaNo;

    /**
     * コンストラクタです。
     *
     * @param messageKubun RString
     * @param hihokenshaNo RString
     */
    public RiyoshaFutanWariaiHanteiCsvEditor(
            RString messageKubun, RString hihokenshaNo) {
        this.messageKubun = messageKubun;
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * CSVレコードを取得します。
     *
     * @return FutanWariaiHanteiIchiranCsvEntity
     */
    public RiyoshaFutanWariaiHanteiCsvEntity edit() {
        RString message;
        if (処理区分1.equals(this.messageKubun)) {
            message = new RString(DbcInformationMessages.負担割合_職権データ.getMessage().toString());
        } else {
            message = new RString(DbcInformationMessages.負担割合_期間なし.getMessage().toString());

        }
        return new RiyoshaFutanWariaiHanteiCsvEntity(hihokenshaNo, message);
    }

}
