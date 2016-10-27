/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KoseiTaishoKyuhuzissekiJohouSakuseiResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KoseitaishoKyuhuzissekiJohoTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(更正対象給付実績情報作成)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class KoseiTaishoKyuhuzissekiJohouSakuseiProcess extends BatchProcessBase<KoseiTaishoKyuhuzissekiJohouSakuseiResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get更正対象給付実績情報作成データ");
    @BatchWriter
    private IBatchTableWriter<KoseitaishoKyuhuzissekiJohoTempEntity> 更正対象給付実績情報Writer;
    private static final RString TEMP_TABLE = new RString("koseitaishoKyuhuzissekiJohoTemp");
    private static final RString 給付実績情報作成区分_削除 = new RString("3");
    private static final int 一百 = 100;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        更正対象給付実績情報Writer = BatchWriters.batchEntityCreatedTempTableWriter(
                KoseitaishoKyuhuzissekiJohoTempEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(KoseiTaishoKyuhuzissekiJohouSakuseiResultEntity entity) {
        if (給付実績情報作成区分_削除.equals(entity.get給付実績情報作成区分コード())) {
            get更正対象給付実績情報(entity);
        } else {
            if (!entity.get保険給付率().value().toString().equals(entity.get給付率().toString())) {
                get更正対象給付実績情報(entity);
            }
        }
    }

    private void get更正対象給付実績情報(KoseiTaishoKyuhuzissekiJohouSakuseiResultEntity entity) {
        KoseitaishoKyuhuzissekiJohoTempEntity tempEntity = new KoseitaishoKyuhuzissekiJohoTempEntity();
        tempEntity.set被保険者番号(entity.get被保険者番号());
        tempEntity.set年度(entity.get年度());
        tempEntity.set識別コード(entity.get識別コード());
        tempEntity.set氏名(entity.get漢字氏名());
        tempEntity.set入力識別番号(entity.get入力識別番号());
        tempEntity.setサービス提供年月(entity.getサービス提供年月());
        tempEntity.set事業所番号(entity.get事業所番号().value());
        tempEntity.set整理番号(entity.get整理番号());
        tempEntity.setサービス種類コード(entity.getサービス種類コード().value());
        tempEntity.set給付実績情報作成区分コード(entity.get給付実績情報作成区分コード());
        tempEntity.setサービス種類(entity.getサービス種類略称());
        tempEntity.set更正前保険給付率(entity.get保険給付率());
        tempEntity.set更正前請求額(entity.get後保険請求分請求額());
        if (entity.get軽減率() != null) {
            tempEntity.set更正前自己負担額(entity.get軽減後自己負担額());
        } else {
            tempEntity.set更正前自己負担額(entity.get利用者負担額());
        }

        Decimal サービス費用額 = null;
        if (tempEntity.get更正前請求額() != null && tempEntity.get更正前自己負担額() != null) {
            サービス費用額 = tempEntity.get更正前請求額().add(tempEntity.get更正前自己負担額());
        }
        HokenKyufuRitsu 更正後保険給付率 = new HokenKyufuRitsu(new Decimal(entity.get給付率().toString()));
        Decimal 更正後請求額 = null;
        Decimal 軽減前自己負担額 = null;
        if (サービス費用額 != null && 更正後保険給付率.value() != null) {
            更正後請求額 = サービス費用額.multiply(更正後保険給付率.value()).divide(一百).roundDownTo(0);
            軽減前自己負担額 = サービス費用額.subtract(更正後請求額);
        }

        tempEntity.setサービス費用額(サービス費用額);

        if (!給付実績情報作成区分_削除.equals(entity.get給付実績情報作成区分コード())) {
            tempEntity.set更正後保険給付率(更正後保険給付率);
            tempEntity.set更正後請求額(更正後請求額);
            tempEntity.set更正後自己負担額(get更正後自己負担額(entity, 軽減前自己負担額));
            if (tempEntity.get更正後自己負担額() != null && tempEntity.get更正前自己負担額() != null) {
                tempEntity.set自己負担額差額(tempEntity.get更正後自己負担額().subtract(tempEntity.get更正前自己負担額()));
            }
        }

        tempEntity.set軽減率(entity.get軽減率());
        tempEntity.set軽減後自己負担額(entity.get軽減後自己負担額());
        tempEntity.set高額サービス費用額(entity.get高額サービス費用額());
        更正対象給付実績情報Writer.insert(tempEntity);
    }

    private Decimal get更正後自己負担額(KoseiTaishoKyuhuzissekiJohouSakuseiResultEntity entity, Decimal 軽減前自己負担額) {
        if (軽減前自己負担額 != null) {
            if (entity.get軽減率() != null) {
                return 軽減前自己負担額.subtract(軽減前自己負担額.multiply(entity.get軽減率()).divide(一百).roundDownTo(0));
            } else {
                return 軽減前自己負担額;
            }
        }
        return null;
    }
}
