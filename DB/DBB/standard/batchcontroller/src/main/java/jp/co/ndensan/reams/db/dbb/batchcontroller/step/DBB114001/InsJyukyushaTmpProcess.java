/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.ShotokuNendoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.JukyuusyaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.JukyuusyaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SetaiHaakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者Tempテーブルに登録のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class InsJyukyushaTmpProcess extends BatchProcessBase<JukyuusyaEntity> {

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_31 = 31;
    private static final RString FROMAT = new RString("%02d");
    private static final RString NUM_01 = new RString("01");
    private static final RString 住所地特例フラグ = new RString("1");
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.select受給者抽出");
    private static final RString 受給者TEMP = new RString("JukyuusyaTemp");
    private static final RString 世帯員把握入力TEMP = new RString("TmpSetaiHaaku");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 受給者writer;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 世帯員把握入力writer;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private ShotokuNendoParameter myBatisParameter;
    private List<FlexibleDate> 基準日時点;

    @Override
    public void initialize() {
        基準日時点 = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = creatParameter();
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        受給者writer = new BatchEntityCreatedTempTableWriter(受給者TEMP, JukyuusyaTempEntity.class);
        世帯員把握入力writer = new BatchEntityCreatedTempTableWriter(世帯員把握入力TEMP, SetaiHaakuEntity.class);
    }

    @Override
    protected void process(JukyuusyaEntity t) {
        受給者writer.insert(creatEntity(t));
        insertSetaiEntity(t);
    }

    private void insertSetaiEntity(JukyuusyaEntity t) {
        set基準日時点(t.get認定有効期間開始年月日(), t.get認定有効期間終了年月日());
        for (int i = 0; i < 基準日時点.size(); i++) {
            SetaiHaakuEntity entity = new SetaiHaakuEntity();
            entity.setHihokenshaNo(t.get被保険者番号());
            entity.setShikibetsuCode(t.get識別コード());
            entity.setKijunYMD(基準日時点.get(i));
            entity.setShotokuNendo(processParameter.get処理年度());
            if (t.get適用年月日() != null && (基準日時点.get(i).compareTo(t.get適用年月日()) < INDEX_0) && (t.get解除年月日().isEmpty()
                    || t.get解除年月日().compareTo(基準日時点.get(i)) > INDEX_0)) {
                entity.setJushochiTokureiFlag(住所地特例フラグ);
            } else {
                entity.setJushochiTokureiFlag(RString.EMPTY);
            }
            世帯員把握入力writer.insert(entity);
        }
        基準日時点.clear();
    }

    private JukyuusyaTempEntity creatEntity(JukyuusyaEntity t) {
        JukyuusyaTempEntity tempEntity = new JukyuusyaTempEntity();
        tempEntity.setHihokenshaNo(t.get被保険者番号());
        tempEntity.setShikibetsuCode(t.get識別コード());
        tempEntity.setJushochiTokureiFlag(t.get住所地特例フラグ());
        tempEntity.setJushochitokureiTekiyoYMD(t.get適用年月日());
        tempEntity.setJushochitokureiKaijoYMD(t.get解除年月日());
        tempEntity.setHihokennshaKubunCode(t.get被保険者区分コード());
        return tempEntity;
    }

    private List<FlexibleDate> set基準日時点(FlexibleDate 認定有効期間開始年月日, FlexibleDate 認定有効期間終了年月日) {
        int 認定有効期間開始月 = 認定有効期間開始年月日.getMonthValue();
        int 認定有効期間終了月 = 認定有効期間終了年月日.getMonthValue();
        基準日時点.add(認定有効期間開始年月日);
        for (int i = (認定有効期間開始月 + 1); i <= 認定有効期間終了月; i++) {
            認定有効期間開始年月日 = new FlexibleDate(String.valueOf(認定有効期間開始年月日.getYearValue())
                    .concat(new RString(String.format(FROMAT.toString(), i)).toString())
                    .concat(NUM_01.toString()));
            基準日時点.add(認定有効期間開始年月日);
        }
        return 基準日時点;
    }

    private ShotokuNendoParameter creatParameter() {
        ShotokuNendoParameter param = new ShotokuNendoParameter();
        FlexibleYear 処理年度 = processParameter.get処理年度();
        param.set処理年度_0801(new FlexibleDate(処理年度.getYearValue(), INDEX_8, INDEX_1));
        param.set処理年度_plus1_0731(new FlexibleDate(処理年度.getYearValue(), INDEX_7, INDEX_31));
        return param;
    }

}
