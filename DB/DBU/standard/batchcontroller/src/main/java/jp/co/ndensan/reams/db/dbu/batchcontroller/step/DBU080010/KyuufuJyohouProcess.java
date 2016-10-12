/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.basic.TokuteiKojinJohoHanKanri;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohomeiCode;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.sougoujigyoujyohou.SougouJigyouJyohouMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.sougoujigyoujyohou.SougouJigyouJyohouProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.sougoujigyoujyohou.SougouJigyouJyohouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 給付情報のプロセスクラスです。
 *
 * @reamsid_L DBU-4880-070 lishengli
 */
public class KyuufuJyohouProcess extends BatchProcessBase<SougouJigyouJyohouRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.sougoujigyoujyohou."
            + "ISougouJigyouJyohouMapper.get当初_版改定_異動分データ");
    private static final RString TABLE_中間DB提供基本情報 = new RString("TeikyoKihonJohoNNTemp");
    private List<TokuteiKojinJohoHanKanri> 特定個人版管理特定情報;
    private SougouJigyouJyohouProcessParameter processParameter;
    private SougouJigyouJyohouMybatisParameter mybatisParameter;
    /**
     * 版番号です。
     */
    public static final RString 版番号;

    static {
        版番号 = new RString("hanNo");
    }
    private OutputParameter<RString> hanNo;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間DB提供基本情報;

    @Override
    protected void initialize() {
        特定個人版管理特定情報 = new ArrayList<>();
        特定個人版管理特定情報 = TokuteiKojinJohoTeikyoManager.createInstance().get版番号(processParameter.get新規異動区分(),
                RString.EMPTY, DataSetNo._0300給付情報.getコード(), FlexibleDate.getNowDate());
        hanNo.setValue(特定個人版管理特定情報.get(0).get版番号());
        if ((ShinkiIdoKubun.当初.getコード().equals(processParameter.get新規異動区分())
                || ShinkiIdoKubun.版改定.getコード().equals(processParameter.get新規異動区分()))
                && ShokaiTeikyoKubun.初回提供済み.getコード().equals(特定個人版管理特定情報.get(0).get初回提供区分())) {
            throw new BatchInterruptedException("");
        }
        if ((ShinkiIdoKubun.再登録.getコード().equals(processParameter.get新規異動区分())
                || ShinkiIdoKubun.異動.getコード().equals(processParameter.get新規異動区分()))
                && ShokaiTeikyoKubun.未提供.getコード().equals(特定個人版管理特定情報.get(0).get初回提供区分())) {
            throw new BatchInterruptedException("");
        }
        mybatisParameter = SougouJigyouJyohouMybatisParameter.create_Parameter(processParameter.get新規異動区分(),
                processParameter.get個人番号付替対象者被保険者番号(), processParameter.get対象開始日時(), processParameter.get対象終了日時(),
                特定個人版管理特定情報.get(0).get版番号(), RString.EMPTY);
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
        entity.setHanNo(特定個人版管理特定情報.get(0).get版番号());
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
            entity.setMisetteiJiyu05(RString.EMPTY);
        } else {
            entity.setMisetteiJiyu05(RString.EMPTY);
        }
        entity.setTeikyoNaiyo06(relateEntity.getSumi_Gokei_JikoFutanGaku());
        entity.setMisetteiJiyu06(RString.EMPTY);
        entity.setTeikyoNaiyo07(relateEntity.getSumi_Gokei_70_74JikoFutanGaku());
        if (relateEntity.getSumi_Gokei_70_74JikoFutanGaku() != null && !relateEntity.getSumi_Gokei_70_74JikoFutanGaku().isEmpty()) {
            entity.setMisetteiJiyu07(RString.EMPTY);
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
