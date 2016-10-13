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
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.RiyoshaFutanwariaiMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.RiyoshaFutanwariaiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.RiyoshaFutanwariaiRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 負担割合のバッチ処理です。
 *
 * @reamsid_L DBU-4880-060 zhaoyao
 */
public class RiyoshaFutanwariaiProcess extends BatchProcessBase<RiyoshaFutanwariaiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate."
            + "tokuteikojinjohoteikyo.IRiyoshaFutanwariaiMapper.get提供情報_候補");
    private static final RString TABLE_中間DB提供基本情報 = new RString("TeikyoKihonJoho");
    private RiyoshaFutanwariaiProcessParameter processParameter;
    private RiyoshaFutanwariaiMybatisParameter mybatisParameter;
    private List<TokuteiKojinJohoHanKanri> 特定個人版管理特定情報;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間DB提供基本情報;

    @Override
    protected void initialize() {

        特定個人版管理特定情報 = new ArrayList<>();
        RString 新規異動区分 = processParameter.get新規異動区分();
        特定個人版管理特定情報 = TokuteiKojinJohoTeikyoManager.createInstance().get版番号(新規異動区分,
                TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード(), DataSetNo._0202負担割合.getコード(),
                FlexibleDate.getNowDate());
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
        mybatisParameter = RiyoshaFutanwariaiMybatisParameter.createParamter提供情報_候補(新規異動区分,
                processParameter.get対象開始日時(), processParameter.get対象終了日時(),
                processParameter.get個人番号付替対象者被保険者番号());
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
    protected void process(RiyoshaFutanwariaiRelateEntity entity) {
        中間DB提供基本情報.insert(getTeikyoKihonJohoEntity(entity));
    }

    private TeikyoKihonJohoNNTempEntity getTeikyoKihonJohoEntity(RiyoshaFutanwariaiRelateEntity relateEntity) {
        TeikyoKihonJohoNNTempEntity entity = new TeikyoKihonJohoNNTempEntity();
        entity.setHihokenshaNo(relateEntity.getHihokenshaNo());
        entity.setDataSetKey(getデータセットキー(relateEntity.getHihokenshaNo(), relateEntity.getEdaNo()));
        entity.setTeikyoKubun(RString.EMPTY);
        entity.setShikibetsuCode(relateEntity.getShikibetsuCode());
        entity.setKojinNo(RString.EMPTY);
        entity.setTokuteiKojinJohoMeiCode(TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード());
        entity.setHanNo(特定個人版管理特定情報.get(0).get版番号());
        entity.setTeikyoNaiyo01(relateEntity.getFutanWariaiKubun());
        entity.setMisetteiJiyu01(RString.EMPTY);
        entity.setTeikyoNaiyo02(get日期(relateEntity.getYukoKaishiYMD()));
        entity.setMisetteiJiyu02(RString.EMPTY);
        entity.setTeikyoNaiyo03(get日期(relateEntity.getYukoShuryoYMD()));
        entity.setMisetteiJiyu03(RString.EMPTY);
        entity.setTeikyoNaiyo04(RString.EMPTY);
        entity.setMisetteiJiyu04(RString.EMPTY);
        entity.setTeikyoNaiyo05(RString.EMPTY);
        entity.setMisetteiJiyu05(RString.EMPTY);
        entity.setTeikyoNaiyo06(RString.EMPTY);
        entity.setMisetteiJiyu06(RString.EMPTY);
        entity.setTeikyoNaiyo07(RString.EMPTY);
        entity.setMisetteiJiyu07(RString.EMPTY);
        entity.setTeikyoNaiyo08(RString.EMPTY);
        entity.setMisetteiJiyu08(RString.EMPTY);
        entity.setTeikyoNaiyo09(RString.EMPTY);
        entity.setMisetteiJiyu09(RString.EMPTY);
        entity.setTeikyoNaiyo10(RString.EMPTY);
        entity.setMisetteiJiyu10(RString.EMPTY);
        entity.setKokaiYMD(new FlexibleDate(RDate.getNowDate().toDateString()));
        return entity;
    }

    private RString getデータセットキー(HihokenshaNo 被保険者番号, int 枝番号) {
        RStringBuilder データセットキー = new RStringBuilder();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            データセットキー.append(被保険者番号);
        }
        データセットキー.append(DataSetNo._0102住所地特例情報.getコード());
        データセットキー.append(枝番号);
        return データセットキー.toRString();
    }

    private RString get日期(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return new RString(年月日.toString());
        }
        return RString.EMPTY;
    }
}
