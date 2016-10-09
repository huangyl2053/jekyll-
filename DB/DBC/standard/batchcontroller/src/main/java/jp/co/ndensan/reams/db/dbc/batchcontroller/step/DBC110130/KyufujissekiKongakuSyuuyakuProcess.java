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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成のバッチ給付実績高額一時データの集約Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class KyufujissekiKongakuSyuuyakuProcess extends BatchProcessBase<DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get集約_高額対象データ_2件存在");
    private static final RString 全てエラーMESSAGE = new RString("【整理番号：入力識別番号：被保険者番号：サービス提供年月】");
    private static final RString 給付実績高額一時NAME = new RString("DbWT1132KyufujissekiKogakuKaigoServicehi");
    private static final RString コロン = new RString(":");
    private static final RString 区分_新規 = new RString("1");
    private static final RString 区分_修正 = new RString("2");
    private static final RString 区分_取消 = new RString("3");
    private static final RString 改行 = new RString("\n");
    private static final RString 作成区分_独自作成 = new RString("1");
    private static final RString 交換情報識別番号_111 = new RString("111");
    private static final int INT_0 = 0;
    private static final int INT_3 = 3;

    private int 件数;
    private DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity データ1件目;
    private RString 全てエラーmessages;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績高額一時tableWriter;

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
        給付実績高額一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績高額一時NAME, DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity.class);
    }

    @Override
    protected void process(DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity entity) {
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

    private void 給付実績情報作成区分のチェック(
            DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity entity1, DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity entity2) {
        RString 区分1 = entity1.getKyufuSakuseiKubunCode();
        RString 区分2 = entity2.getKyufuSakuseiKubunCode();
        if (区分_新規.equals(区分1)) {
            if (区分_修正.equals(区分2)) {
                RString 作成区分コード = 区分_新規;
                entity1.setSofuJogaiFlag(true);
                entity2 = 更新check(entity1, entity2, 作成区分コード);
                給付実績高額一時tableWriter.update(entity1);
                給付実績高額一時tableWriter.update(entity2);
            } else if (区分_取消.equals(区分2)) {
                entity1.setSofuJogaiFlag(true);
                entity2.setSofuJogaiFlag(true);
                給付実績高額一時tableWriter.update(entity1);
                給付実績高額一時tableWriter.update(entity2);
            } else {
                全てエラーmessages = getMessage(全てエラーmessages, entity1);
            }
        } else if (区分_修正.equals(区分1)) {
            if (区分_修正.equals(区分2)) {
                RString 作成区分コード = 区分_修正;
                entity1.setSofuJogaiFlag(true);
                entity2 = 更新check(entity1, entity2, 作成区分コード);
                給付実績高額一時tableWriter.update(entity1);
                給付実績高額一時tableWriter.update(entity2);
            } else if (区分_取消.equals(区分2)) {
                RString 作成区分コード = 区分_取消;
                entity1.setSofuJogaiFlag(true);
                entity2 = 更新check(entity1, entity2, 作成区分コード);
                給付実績高額一時tableWriter.update(entity1);
                給付実績高額一時tableWriter.update(entity2);
            } else {
                全てエラーmessages = getMessage(全てエラーmessages, entity1);
            }
        } else if (区分_取消.equals(区分1)) {
            RString 作成区分コード = 区分_修正;
            entity1.setSofuJogaiFlag(true);
            entity2 = 更新check(entity1, entity2, 作成区分コード);
            給付実績高額一時tableWriter.update(entity1);
            給付実績高額一時tableWriter.update(entity2);
        } else {
            全てエラーmessages = getMessage(全てエラーmessages, entity1);
        }
    }

    private DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity 更新check(
            DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity entity1,
            DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity entity2,
            RString 作成区分コード) {
        RString 交換情報識別番号 = entity1.getKokanJohoShikibetsuNo().getColumnValue();
        RString 作成区分 = entity1.getSakuseiKubun();
        if (交換情報識別番号_111.equals(交換情報識別番号.substring(INT_0, INT_3)) && 作成区分_独自作成.equals(作成区分)) {
            entity2.setKokanJohoShikibetsuNo(entity1.getKokanJohoShikibetsuNo());
            entity2.setRecodeShubetsuCode(entity1.getRecodeShubetsuCode());
        }
        entity2.setKyufuSakuseiKubunCode(作成区分コード);
        return entity2;
    }

    private RString getMessage(RString message, DbWT1132KyufujissekiKogakuKaigoServicehiTempEntity dbWT1132ErrorEntity) {
        RString 入力識別番号 = dbWT1132ErrorEntity.getInputShikibetsuNo() == null
                ? RString.EMPTY : dbWT1132ErrorEntity.getInputShikibetsuNo().getColumnValue();
        RString 被保険者番号 = dbWT1132ErrorEntity.getHiHokenshaNo() == null
                ? RString.EMPTY : dbWT1132ErrorEntity.getHiHokenshaNo().getColumnValue();
        RString サービス提供年月 = dbWT1132ErrorEntity.getServiceTeikyoYM() == null
                ? RString.EMPTY : dbWT1132ErrorEntity.getServiceTeikyoYM().toDateString();
        message = message.concat(全てエラーMESSAGE)
                .concat(RString.FULL_SPACE)
                .concat(dbWT1132ErrorEntity.getKanriNo()).concat(コロン)
                .concat(入力識別番号).concat(コロン)
                .concat(被保険者番号).concat(コロン)
                .concat(サービス提供年月).concat(改行);
        return message;
    }

}
