/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohomeiCode;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.SougouJigyouJyohouMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.SougouJigyouJyohouProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.SougouJigyouJyohouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 総合事業情報のプロセスクラスです。
 *
 * @reamsid_L DBU-4880-080 lishengli
 */
public class SougouJigyouJyohouProcess extends BatchProcessBase<SougouJigyouJyohouRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo."
            + "ISougouJigyouJyohouMapper.get当初_版改定_異動分データ");
    private static final RString TABLE_中間DB提供基本情報 = new RString("TeikyoKihonJohoNNTemp");
    private static final RString NOTACCEPTABLE = new RString("NotAcceptable");
    private SougouJigyouJyohouProcessParameter processParameter;
    private SougouJigyouJyohouMybatisParameter mybatisParameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間DB提供基本情報;

    @Override
    protected void initialize() {
        HihokenshaNo 個人番号付替対象者被保険者番号 = processParameter.get個人番号付替対象者被保険者番号();
        if (個人番号付替対象者被保険者番号 == null) {
            個人番号付替対象者被保険者番号 = HihokenshaNo.EMPTY;
        }
        mybatisParameter = SougouJigyouJyohouMybatisParameter.create_Parameter(processParameter.get新規異動区分(),
                個人番号付替対象者被保険者番号.value(), processParameter.get対象開始日時(), processParameter.get対象終了日時(),
                processParameter.get版番号(), RString.EMPTY);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        中間DB提供基本情報 = new BatchEntityCreatedTempTableWriter(TABLE_中間DB提供基本情報,
                TeikyoKihonJohoNNTempEntity.class);
    }

    @Override
    protected void process(SougouJigyouJyohouRelateEntity entity) {
        中間DB提供基本情報.insert(getTeikyoKihonJohoEntity(entity));
    }

    private TeikyoKihonJohoNNTempEntity getTeikyoKihonJohoEntity(SougouJigyouJyohouRelateEntity relateEntity) {
        TeikyoKihonJohoNNTempEntity entity = new TeikyoKihonJohoNNTempEntity();
        entity.setHihokenshaNo(relateEntity.getHihokenshaNo());
        entity.setDataSetKey(getデータセットキー(relateEntity.getHihokenshaNo(), relateEntity.getShikyuShinseishoSeiriNo()));
        entity.setTeikyoKubun(RString.EMPTY);
        entity.setShikibetsuCode(relateEntity.getShikibetsuCode());
        entity.setKojinNo(RString.EMPTY);
        entity.setTokuteiKojinJohoMeiCode(TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード());
        entity.setHanNo(processParameter.get版番号());
        entity.setTeikyoNaiyo01(relateEntity.getTaishoNendo().toDateString());
        entity.setMisetteiJiyu01(RString.EMPTY);
        entity.setTeikyoNaiyo02(toRString(relateEntity.getTaishoKeisanKaishiYMD()));
        entity.setMisetteiJiyu02(RString.EMPTY);
        entity.setTeikyoNaiyo03(toRString(relateEntity.getTaishoKeisanShuryoYMD()));
        entity.setMisetteiJiyu03(RString.EMPTY);
        entity.setTeikyoNaiyo04(toRString(relateEntity.getHihokenshaKaishiYMD()));
        entity.setMisetteiJiyu04(RString.EMPTY);
        entity.setTeikyoNaiyo05(toRString(relateEntity.getHihokenshaShuryoYMD()));
        if (relateEntity.getHihokenshaShuryoYMD() != null && !relateEntity.getHihokenshaShuryoYMD().isEmpty()) {
            entity.setMisetteiJiyu05(NOTACCEPTABLE);
        } else {
            entity.setMisetteiJiyu05(RString.EMPTY);
        }
        entity.setTeikyoNaiyo06(relateEntity.getSumi_Gokei_JikoFutanGaku());
        entity.setMisetteiJiyu06(RString.EMPTY);
        entity.setTeikyoNaiyo07(relateEntity.getSumi_Gokei_70_74JikoFutanGaku());
        if (!RString.isNullOrEmpty(relateEntity.getSumi_Gokei_70_74JikoFutanGaku())) {
            entity.setMisetteiJiyu07(NOTACCEPTABLE);
        } else {
            entity.setMisetteiJiyu07(RString.EMPTY);
        }
        entity.setTeikyoNaiyo08(RString.EMPTY);
        entity.setMisetteiJiyu08(RString.EMPTY);
        entity.setTeikyoNaiyo09(RString.EMPTY);
        entity.setMisetteiJiyu09(RString.EMPTY);
        entity.setTeikyoNaiyo10(RString.EMPTY);
        entity.setMisetteiJiyu10(RString.EMPTY);
        entity.setKokaiYMD(FlexibleDate.getNowDate());
        return entity;
    }

    private RString getデータセットキー(HihokenshaNo 被保険者番号, RString 支給整理番号) {
        RStringBuilder データセットキー = new RStringBuilder();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            データセットキー.append(被保険者番号);
        }
        if (!RString.isNullOrEmpty(支給整理番号)) {
            データセットキー.append(支給整理番号);
        }
        return データセットキー.toRString();
    }

    private RString toRString(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return new RString(年月日.toString());
        }
        return RString.EMPTY;
    }

}
