/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.HenKouData;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.ErrordataIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.FairudetaIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.service.core.dbd492001.NinteiKekkaRenkeiDataTorikomiManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチパラメータ．データリストより、変更したいデータを取得する_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class NinteiKekkaRenkeiDetaTorikomiProcess extends BatchProcessBase<HenKouData> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.INinteiKekkaRenkeiDetaTorikomiMapper.get変更したいデータを取得する");
    private final RString いち = new RString("1");
    private final RString ゼロいち = new RString("01");
    private final RString に = new RString("2");
    private final RString よっ = new RString("4");
    private final RString じゅうに = new RString("12");
    private final RString じゅうさん = new RString("13");
    private final RString にじゅういち = new RString("21");
    private final RString にじゅうに = new RString("22");
    private final RString にじゅうみ = new RString("23");
    private final RString にじゅうよっ = new RString("24");
    private final RString にじゅうご = new RString("25");
    private final RString エラーメッセージ1 = new RString("取り下げ区分が無効です");
    private final RString エラーメッセージ2 = new RString("二次判定結果が無効です");
    private final RString エラーメッセージ3 = new RString("当該被保険者の申請データが存在しません");
    private RendingJieguoLianxieProcessParameter processParameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter ファイルデータ一時テーブル;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 進捗の取込みエラー一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, processParameter.toRendingJieguoLianxieMybatisParameter());
    }

    @Override
    protected void createWriter() {
        ファイルデータ一時テーブル = new BatchEntityCreatedTempTableWriter(FairudetaIchijiTeburuEntity.TABLE_NAME,
                FairudetaIchijiTeburuEntity.class);
        進捗の取込みエラー一時TBL = new BatchEntityCreatedTempTableWriter(ErrordataIchijiTeburuEntity.TABLE_NAME,
                ErrordataIchijiTeburuEntity.class);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void process(HenKouData entity) {
        ErrordataIchijiTeburuEntity error = null;
        FairudetaIchijiTeburuEntity fairu = null;
        if (!いち.equals(entity.get取下区分コード().value())
                && !に.equals(entity.get取下区分コード().value())
                && !よっ.equals(entity.get取下区分コード().value())) {
            error = new ErrordataIchijiTeburuEntity();
            NinteiKekkaRenkeiDataTorikomiManager.createInstance().エラー項目設定(エラーメッセージ1, entity, error);
        } else if (eidt二次判定結果(entity)) {
            error = new ErrordataIchijiTeburuEntity();
            NinteiKekkaRenkeiDataTorikomiManager.createInstance().エラー項目設定(エラーメッセージ2, entity, error);
        } else if (entity.get申請情報_申請書管理番号() == null || entity.get申請情報_申請書管理番号().isEmpty()) {
            error = new ErrordataIchijiTeburuEntity();
            NinteiKekkaRenkeiDataTorikomiManager.createInstance().エラー項目設定(エラーメッセージ3, entity, error);
        } else if ((entity.get被保険者ｶﾅ氏名() == null || entity.get被保険者ｶﾅ氏名().isEmpty())
                && (entity.get被保険者漢字氏名() == null || entity.get被保険者漢字氏名().isEmpty())) {
            entity.set被保険者ｶﾅ氏名(entity.get申請情報_被保険者ｶﾅ氏名());
            entity.set被保険者漢字氏名(entity.get申請情報_被保険者漢字氏名());
            fairu = new FairudetaIchijiTeburuEntity();
            NinteiKekkaRenkeiDataTorikomiManager.createInstance().ファイルデータ一時テーブル(entity, fairu);
        } else {
            fairu = new FairudetaIchijiTeburuEntity();
            NinteiKekkaRenkeiDataTorikomiManager.createInstance().ファイルデータ一時テーブル(entity, fairu);
        }
        if (fairu != null) {
            ファイルデータ一時テーブル.insert(fairu);
        }
        if (error != null) {
            進捗の取込みエラー一時TBL.insert(error);
        }
    }

    @Override
    protected void afterExecute() {
    }

    private boolean eidt二次判定結果(HenKouData entity) {
        return (!ゼロいち.equals(entity.get二次判定結果())
                && !じゅうに.equals(entity.get二次判定結果())
                && !じゅうさん.equals(entity.get二次判定結果())
                && !にじゅういち.equals(entity.get二次判定結果())
                && !にじゅうに.equals(entity.get二次判定結果())
                && !にじゅうみ.equals(entity.get二次判定結果())
                && !にじゅうよっ.equals(entity.get二次判定結果())
                && !にじゅうご.equals(entity.get二次判定結果()));
    }
}
