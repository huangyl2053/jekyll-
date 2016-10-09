/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成の識別番号管理データがない給付実績基本一時データがあればProcessです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class KyufujissekiNoShikibetsuProcess extends BatchProcessBase<NyuryokuShikibetsuNo> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get識別番号管理がないの基本一時データ");
    private static final RString 対象データなしMESSAGE = new RString("【入力識別番号】");
    private static final RString 改行 = new RString("\n");

    private RString 対象データなしmessagges;

    @Override
    protected void initialize() {
        対象データなしmessagges = RString.EMPTY;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(NyuryokuShikibetsuNo 入力識別番号) {
        対象データなしmessagges = 対象データなしmessagges
                .concat(対象データなしMESSAGE).concat(RString.FULL_SPACE)
                .concat(入力識別番号.getColumnValue()).concat(改行);
    }

    @Override
    protected void afterExecute() {
        if (!対象データなしmessagges.isEmpty()) {
            throw new BatchInterruptedException(
                    UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(対象データなしmessagges.toString()).evaluate());
        }
    }
}
