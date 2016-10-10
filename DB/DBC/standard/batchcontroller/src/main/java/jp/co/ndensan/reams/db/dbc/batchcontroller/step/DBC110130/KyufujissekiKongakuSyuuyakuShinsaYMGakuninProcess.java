/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikogakukaigoservicehi.DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成のバッチ給付実績高額一時データの集約の不正データ確認審査年月不正Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class KyufujissekiKongakuSyuuyakuShinsaYMGakuninProcess extends BatchProcessBase<DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get集約_高額対象データ_審査年月同一");
    private static final RString コロン = new RString(":");
    private static final RString 改行 = new RString("\n");
    private static final RString 審査年月不正MESSAGE = new RString("【整理番号：入力識別番号：被保険者番号：サービス提供年月：審査年月】");

    private RString 審査年月不正messages;

    @Override
    protected void initialize() {
        審査年月不正messages = RString.EMPTY;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity entity) {
        審査年月不正messages = getMessage(審査年月不正messages, entity);
    }

    @Override
    protected void afterExecute() {
        if (!審査年月不正messages.isEmpty()) {
            throw new BatchInterruptedException(
                    DbcErrorMessages.給付実績_審査年月不正.getMessage().replace(審査年月不正messages.toString()).evaluate());
        }
    }

    private RString getMessage(RString message, DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity dbWT1132ErrorEntity) {
        RString 入力識別番号 = dbWT1132ErrorEntity.getInputShikibetsuNo() == null
                ? RString.EMPTY : dbWT1132ErrorEntity.getInputShikibetsuNo().getColumnValue();
        RString 被保険者番号 = dbWT1132ErrorEntity.getHiHokenshaNo() == null
                ? RString.EMPTY : dbWT1132ErrorEntity.getHiHokenshaNo().getColumnValue();
        RString サービス提供年月 = dbWT1132ErrorEntity.getServiceTeikyoYM() == null
                ? RString.EMPTY : dbWT1132ErrorEntity.getServiceTeikyoYM().toDateString();
        RString 審査年月 = dbWT1132ErrorEntity.getShinsaYM() == null ? RString.EMPTY : dbWT1132ErrorEntity.getShinsaYM().toDateString();
        message = message.concat(審査年月不正MESSAGE).concat(RString.FULL_SPACE)
                .concat(dbWT1132ErrorEntity.getKanriNo()).concat(コロン)
                .concat(入力識別番号).concat(コロン)
                .concat(被保険者番号).concat(コロン)
                .concat(サービス提供年月).concat(コロン).
                concat(審査年月).concat(改行);
        return message;
    }

}
