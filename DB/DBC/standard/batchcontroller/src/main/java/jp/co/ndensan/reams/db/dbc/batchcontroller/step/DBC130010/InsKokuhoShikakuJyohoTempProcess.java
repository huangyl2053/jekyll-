/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.InsKokuhoShikakuJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoShikakuJyohoInpotoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoShikakuＪyohoYoResultEntity;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC130010_国保資格異動情報取込
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
public class InsKokuhoShikakuJyohoTempProcess extends BatchProcessBase<KokuhoShikakuＪyohoYoResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper.get国保資格情報インポート用データ");
    private KokuhoShikakuJyohoInpotoyoEntity 国保資格情報インポート用Entitｙ;
    @BatchWriter
    private IBatchTableWriter<KokuhoShikakuJyohoInpotoyoEntity> torikomiKokuhoJyohoEntityWriter;
    private InsKokuhoShikakuJyohoTempProcessParameter processParameter;
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
    private static final RString エラーコード_14 = new RString("14");
    private static final RString エラーコード_70 = new RString("70");
    private static final RString コード文言_住民コード = new RString("住民コードが重複しています。１件のみ登録します");
    private static final RString エラー区分 = new RString("1");
    private static final RString エラー区分_正常データ = new RString("0");
    private static final RString 取込形式_全件 = new RString("1");
    private static final RString 取込形式_差分 = new RString("2");
    private static final RString TEMP_TABLE = new RString("tempKokuhoShikakuJyohoInpotoyo");

    @Override
    protected void initialize() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        torikomiKokuhoJyohoEntityWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                KokuhoShikakuJyohoInpotoyoEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(KokuhoShikakuＪyohoYoResultEntity entity) {
        国保資格情報インポート用Entitｙ = new KokuhoShikakuJyohoInpotoyoEntity();
        if (エラー区分_正常データ.equals(entity.get取込国保情報Entity().getエラー区分())) {
            国保資格情報インポート用Entityリストの編集(entity);
        }

        // TODO 既存の国保情報が画面登録データのために更新できなかった場合、更新エラーとみなして以下のエラー編集を行う
        if (ＩＦ種類_電算.equals(processParameter.getIF種類())) {
        }

        if (ＩＦ種類_電算２.equals(processParameter.getIF種類())) {
        }
        if (国保資格情報インポート用Entitｙ != null) {
            torikomiKokuhoJyohoEntityWriter.update(国保資格情報インポート用Entitｙ);
        }
    }

    private void 国保資格情報インポート用Entityリストの編集(KokuhoShikakuＪyohoYoResultEntity entity) {
        if (取込形式_全件.equals(processParameter.get取込形式())) {
            // TODO 5.5.1.1　住民コード(識別コード)でマッチングしたデータであれば
            get国保資格情報インポート用Entitｙ(entity);

            // TODO 5.5.1.2　住民コード(識別コード)でマッチングしなかった場合
        }

        if (取込形式_差分.equals(processParameter.get取込形式())) {
            // TODO 5.5.2.1　住民コード(識別コード)でマッチングしたデータであれば
            get国保資格情報インポート用Entitｙ(entity);

            // TODO 5.5.2.2　住民コード(識別コード)でマッチングしなかった場合
        }
    }

    private void get国保資格情報インポート用Entitｙ(KokuhoShikakuＪyohoYoResultEntity entity) {
        if (!TorokuKubun.画面登録.getコード().equals(entity.get現在国保資格情報Entity().getTorokuKubun())) {
            国保資格情報インポート用Entitｙ.set個人区分コード(entity.get取込国保情報Entity().get個人区分コード());
            国保資格情報インポート用Entitｙ.set国保保険者番号(entity.get取込国保情報Entity().get国保保険者番号());
            国保資格情報インポート用Entitｙ.set国保保険証番号(entity.get取込国保情報Entity().get国保保険証番号());
            国保資格情報インポート用Entitｙ.set国保個人番号(entity.get取込国保情報Entity().get国保個人番号());
            国保資格情報インポート用Entitｙ.set国保番号(entity.get取込国保情報Entity().get国保番号());
            国保資格情報インポート用Entitｙ.set履歴番号(entity.get取込国保情報Entity().get履歴番号());
            国保資格情報インポート用Entitｙ.set登録区分(entity.get取込国保情報Entity().get登録区分());
            国保資格情報インポート用Entitｙ.set識別コード(entity.get取込国保情報Entity().getIN住民コード());
            国保資格情報インポート用Entitｙ.set資格取得日(entity.get取込国保情報Entity().get国保資格取得年月日());
            国保資格情報インポート用Entitｙ.set資格喪失日(entity.get取込国保情報Entity().get国保資格喪失年月日());
            国保資格情報インポート用Entitｙ.set退職該当日(entity.get取込国保情報Entity().get国保退職該当日());
            国保資格情報インポート用Entitｙ.set退職非該当日(entity.get取込国保情報Entity().get国保退職非該当日());
        } else {

            国保資格情報インポート用Entitｙ.set個人区分コード(entity.get現在国保資格情報Entity().getKojinKubunCode());
            国保資格情報インポート用Entitｙ.set国保保険者番号(entity.get現在国保資格情報Entity().getKokuhoHokenshaNo());
            国保資格情報インポート用Entitｙ.set国保保険証番号(entity.get現在国保資格情報Entity().getKokuhoHokenshoNo());
            国保資格情報インポート用Entitｙ.set国保個人番号(entity.get現在国保資格情報Entity().getKokuhoKojinNo());
            国保資格情報インポート用Entitｙ.set国保番号(entity.get現在国保資格情報Entity().getKokuhoNo());
            国保資格情報インポート用Entitｙ.set履歴番号(entity.get現在国保資格情報Entity().getRirekiNo());
            国保資格情報インポート用Entitｙ.set登録区分(entity.get現在国保資格情報Entity().getTorokuKubun());
            国保資格情報インポート用Entitｙ.set識別コード(entity.get現在国保資格情報Entity().getShikibetsuCode().value());
            国保資格情報インポート用Entitｙ.set資格取得日(entity.get現在国保資格情報Entity().getShikakuShutokuYMD());
            国保資格情報インポート用Entitｙ.set資格喪失日(entity.get現在国保資格情報Entity().getShikakuSoshitsuYMD());
            国保資格情報インポート用Entitｙ.set退職該当日(entity.get現在国保資格情報Entity().getTaishokuGaitoYMD());
            国保資格情報インポート用Entitｙ.set退職非該当日(entity.get現在国保資格情報Entity().getTaishokuHigaitoYMD());
        }
    }
}
