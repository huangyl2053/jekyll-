/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.InsKokuhoShikakuJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoShikakuJyohoInpotoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoShikakuJyohoYoResultEntity;
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
public class InsKokuhoShikakuJyohoTempProcess extends BatchProcessBase<KokuhoShikakuJyohoYoResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper.get国保資格情報インポート用データ");
    private KokuhoShikakuJyohoInpotoyoEntity 国保資格情報インポート用Entitｙ;
    @BatchWriter
    private IBatchTableWriter<KokuhoShikakuJyohoInpotoyoEntity> torikomiKokuhoJyohoEntityWriter;
    private InsKokuhoShikakuJyohoTempProcessParameter processParameter;
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
    private static final RString エラー区分_正常データ = new RString("0");
    private static final RString 取込形式_全件 = new RString("1");
    private static final RString 取込形式_差分 = new RString("2");
    private static final RString 登録区分_画面登録 = new RString("1");
    private static final RString エラーコード_32 = new RString("32");
    private static final RString エラーコード_82 = new RString("82");
    private static final RString エラーコード文言 = new RString("画面登録されたデータです");
    private static final RString エラー区分 = new RString("1");
    private static final RString TEMP_TABLE = new RString("tempKokuhoShikakuJyohoInpotoyo");

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
    protected void process(KokuhoShikakuJyohoYoResultEntity entity) {
        if (entity.get取込国保情報Entity() == null || エラー区分_正常データ.equals(entity.get取込国保情報Entity().getエラー区分())) {
            国保資格情報インポート用Entityリストの編集_取込形式_全件(entity);
            国保資格情報インポート用Entityリストの編集_取込形式_差分(entity);
        }

        if (entity.get現在国保資格情報Entity() != null
                && entity.get取込国保情報Entity() != null
                && 登録区分_画面登録.equals(entity.get現在国保資格情報Entity().getTorokuKubun())) {
            if (ＩＦ種類_電算.equals(processParameter.getIf種類())) {
                entity.get取込国保情報Entity().setエラーコード(エラーコード_32);
                entity.get取込国保情報Entity().setエラー文言(エラーコード文言);
                entity.get取込国保情報Entity().setエラー区分(エラー区分);
            }

            if (ＩＦ種類_電算２.equals(processParameter.getIf種類())) {
                entity.get取込国保情報Entity().setエラーコード(エラーコード_82);
                entity.get取込国保情報Entity().setエラー文言(エラーコード文言);
                entity.get取込国保情報Entity().setエラー区分(エラー区分);
            }
        }

        if (国保資格情報インポート用Entitｙ != null) {
            torikomiKokuhoJyohoEntityWriter.insert(国保資格情報インポート用Entitｙ);
        }
    }

    private void 国保資格情報インポート用Entityリストの編集_取込形式_全件(KokuhoShikakuJyohoYoResultEntity entity) {
        if (取込形式_全件.equals(processParameter.get取込形式())) {
            if (entity.get取込国保情報Entity() != null
                    && entity.get現在国保資格情報Entity() != null) {
                get国保資格情報インポート用Entitｙ(entity);
            }

            if (entity.get取込国保情報Entity() != null
                    && entity.get現在国保資格情報Entity() == null) {
                取込国保情報より_項目設定(entity);
            }

            if (entity.get取込国保情報Entity() == null
                    && entity.get現在国保資格情報Entity() != null
                    && TorokuKubun.画面登録.getコード().equals(entity.get現在国保資格情報Entity().getTorokuKubun())) {
                現在国保資格情報より_項目設定(entity);
            }
        }
    }

    private void 国保資格情報インポート用Entityリストの編集_取込形式_差分(KokuhoShikakuJyohoYoResultEntity entity) {
        if (取込形式_差分.equals(processParameter.get取込形式())) {
            if (entity.get取込国保情報Entity() != null
                    && entity.get現在国保資格情報Entity() != null) {
                get国保資格情報インポート用Entitｙ(entity);
            }

            if (entity.get取込国保情報Entity() != null
                    && entity.get現在国保資格情報Entity() == null) {
                取込国保情報より_項目設定(entity);
            }

            if (entity.get取込国保情報Entity() == null
                    && entity.get現在国保資格情報Entity() != null) {
                現在国保資格情報より_項目設定(entity);
            }
        }
    }

    private void get国保資格情報インポート用Entitｙ(KokuhoShikakuJyohoYoResultEntity entity) {
        if (entity.get現在国保資格情報Entity() != null) {
            if (!TorokuKubun.画面登録.getコード().equals(entity.get現在国保資格情報Entity().getTorokuKubun())) {
                取込国保情報より_項目設定(entity);
            } else {
                現在国保資格情報より_項目設定(entity);
            }
        }
    }

    private void 取込国保情報より_項目設定(KokuhoShikakuJyohoYoResultEntity entity) {
        国保資格情報インポート用Entitｙ = new KokuhoShikakuJyohoInpotoyoEntity();
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
    }

    private void 現在国保資格情報より_項目設定(KokuhoShikakuJyohoYoResultEntity entity) {
        国保資格情報インポート用Entitｙ = new KokuhoShikakuJyohoInpotoyoEntity();
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
