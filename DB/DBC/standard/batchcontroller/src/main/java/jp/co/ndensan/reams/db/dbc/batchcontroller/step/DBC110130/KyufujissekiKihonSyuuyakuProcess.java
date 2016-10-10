/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikihon.DbWT1131KyufujissekiKihonTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成のバッチ給付実績基本一時データの集約Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class KyufujissekiKihonSyuuyakuProcess extends BatchProcessBase<DbWT1131KyufujissekiKihonTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get集約_基本対象データ_2件存在");
    private static final RString 全てエラーMESSAGE = new RString("【整理番号：入力識別番号：被保険者番号：サービス提供年月：事業者番号】");
    private static final RString 給付実績基本一時NAME = new RString("DbWT1131KyufujissekiKihon");
    private static final RString コロン = new RString(":");
    private static final RString 区分_新規 = new RString("1");
    private static final RString 区分_修正 = new RString("2");
    private static final RString 区分_取消 = new RString("3");
    private static final RString 改行 = new RString("\n");
    private static final int INT_0 = 0;

    private int 件数;
    private DbWT1131KyufujissekiKihonTempEntity データ1件目;
    private RString 全てエラーmessages;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績基本一時tableWriter;

    @Override
    protected void initialize() {
        全てエラーmessages = RString.EMPTY;
        件数 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        給付実績基本一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績基本一時NAME, DbWT1131KyufujissekiKihonTempEntity.class);
    }

    @Override
    protected void process(DbWT1131KyufujissekiKihonTempEntity entity) {
        件数 = 件数 + 1;
        if (件数 % 2 == INT_0) {
            給付実績情報作成区分のチェック(データ1件目, entity);
        } else {
            データ1件目 = entity;
        }
    }

    @Override
    protected void afterExecute() {
        if (!全てエラーmessages.isEmpty()) {
            throw new BatchInterruptedException(
                    DbcErrorMessages.給付実績_給付実績情報作成区分不正.getMessage().replace(全てエラーmessages.toString()).evaluate());
        }
    }

    private void 給付実績情報作成区分のチェック(DbWT1131KyufujissekiKihonTempEntity entity1, DbWT1131KyufujissekiKihonTempEntity entity2) {
        RString 区分1 = entity1.getKyufuSakuseiKubunCode();
        RString 区分2 = entity2.getKyufuSakuseiKubunCode();
        if (区分_新規.equals(区分1)) {
            if (区分_修正.equals(区分2)) {
                RString 作成区分コード = 区分_新規;
                entity1.setSofuJogaiFlag(true);
                entity2.setKyufuSakuseiKubunCode(作成区分コード);
                給付実績基本一時tableWriter.update(entity1);
                給付実績基本一時tableWriter.update(entity2);
            } else if (区分_取消.equals(区分2)) {
                entity1.setSofuJogaiFlag(true);
                entity2.setSofuJogaiFlag(true);
                給付実績基本一時tableWriter.update(entity1);
                給付実績基本一時tableWriter.update(entity2);
            } else {
                全てエラーmessages = getMessage(全てエラーmessages, entity1);
            }
        } else if (区分_修正.equals(区分1)) {
            if (区分_修正.equals(区分2)) {
                RString 作成区分コード = 区分_修正;
                entity1.setSofuJogaiFlag(true);
                entity2.setKyufuSakuseiKubunCode(作成区分コード);
                給付実績基本一時tableWriter.update(entity1);
                給付実績基本一時tableWriter.update(entity2);
            } else if (区分_取消.equals(区分2)) {
                RString 作成区分コード = 区分_取消;
                entity1.setSofuJogaiFlag(true);
                entity2.setKyufuSakuseiKubunCode(作成区分コード);
                給付実績基本一時tableWriter.update(entity1);
                給付実績基本一時tableWriter.update(entity2);
            } else {
                全てエラーmessages = getMessage(全てエラーmessages, entity1);
            }
        } else if (区分_取消.equals(区分1)) {
            RString 作成区分コード = 区分_修正;
            entity1.setSofuJogaiFlag(true);
            entity2.setKyufuSakuseiKubunCode(作成区分コード);
            給付実績基本一時tableWriter.update(entity1);
            給付実績基本一時tableWriter.update(entity2);
        } else {
            全てエラーmessages = getMessage(全てエラーmessages, entity1);
        }
    }

    private RString getMessage(RString message, DbWT1131KyufujissekiKihonTempEntity dbWT1131ErrorEntity) {
        RString 入力識別番号 = dbWT1131ErrorEntity.getInputShikibetsuNo() == null
                ? RString.EMPTY : dbWT1131ErrorEntity.getInputShikibetsuNo().getColumnValue();
        RString 被保険者番号 = dbWT1131ErrorEntity.getHiHokenshaNo() == null
                ? RString.EMPTY : dbWT1131ErrorEntity.getHiHokenshaNo().getColumnValue();
        RString サービス提供年月 = dbWT1131ErrorEntity.getServiceTeikyoYM() == null
                ? RString.EMPTY : dbWT1131ErrorEntity.getServiceTeikyoYM().toDateString();
        RString 事業者番号 = dbWT1131ErrorEntity.getJigyoshoNo() == null
                ? RString.EMPTY : dbWT1131ErrorEntity.getJigyoshoNo().getColumnValue();
        message = message.concat(全てエラーMESSAGE)
                .concat(RString.FULL_SPACE)
                .concat(dbWT1131ErrorEntity.getSeiriNo()).concat(コロン)
                .concat(入力識別番号).concat(コロン)
                .concat(被保険者番号).concat(コロン)
                .concat(サービス提供年月).concat(コロン)
                .concat(事業者番号).concat(改行);
        return message;
    }

}
