/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA010010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsushikakuido.NenreiIdoHanteiMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba010010.HihokenshaDaichoKoshinProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichokoshin.ShikakuIdoTaishoshaEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsushikakuido.INenreitotatsuShikakuIdoRelateMapper;
import jp.co.ndensan.reams.db.dba.service.core.hihokenshadaichokoshin.HihokenshaDaichoKoshin;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth._DateOfBirth;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格異動対象者の取得と被保険者台帳の更新_バッチフ処理クラスです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
public class HihokenshaDaichoKoshinProcess extends BatchProcessBase<ShikakuIdoTaishoshaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitotatsushikakuido.INenreitotatsuShikakuIdoRelateMapper.select資格異動対象者");
    private INenreitotatsuShikakuIdoRelateMapper mapper;
    private HihokenshaDaichoKoshin hihokenshaDaichoKoshin;
    private HihokenshaDaichoKoshinProcessParameter parameter;
    private FlexibleDate 開始日;
    private FlexibleDate 終了日;
    private static final int AGE_65 = 65;

    @BatchWriter
    private BatchPermanentTableWriter<DbT1001HihokenshaDaichoEntity> dbT1001Writer;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbT7022Writer;

    @Override
    protected void initialize() {
        mapper = getMapper(INenreitotatsuShikakuIdoRelateMapper.class);
        hihokenshaDaichoKoshin = HihokenshaDaichoKoshin.createInstance();
        開始日 = parameter.get開始日();
        終了日 = parameter.get終了日();
        if (parameter.is通常運用時()) {
            DbT7022ShoriDateKanriEntity entity = mapper.selectバッチ内で抽出条件();
            if (entity != null) {
                開始日 = entity.getKijunYMD();
            } else {
                開始日 = new FlexibleDate(RDate.getNowDate().toDateString());
            }
            終了日 = new FlexibleDate(RDate.getNowDate().toDateString());
            if (!開始日.isBeforeOrEquals(終了日)) {
                throw new ApplicationException(DbzErrorMessages.期間が不正_未来日付不可.getMessage().replace("開始日", "終了日"));
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        key.set住民状態(juminJotaiList);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();

        FlexibleDate 年齢到達期間開始日 = 開始日.minusYear(AGE_65).plusDay(1);
        FlexibleDate 年齢到達期間終了日 = 終了日.minusYear(AGE_65).plusDay(1);
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toAtenaMybatisParameter(shikibetsuTaishoPSMSearchKey, 年齢到達期間開始日, 年齢到達期間終了日));
    }

    @Override
    protected void createWriter() {
        dbT1001Writer = new BatchPermanentTableWriter<>(DbT1001HihokenshaDaichoEntity.class);
        dbT7022Writer = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(ShikakuIdoTaishoshaEntity entity) {
        if (entity.get生年月日().isBefore(開始日.minusYear(AGE_65).plusDay(1))
                || 終了日.minusYear(AGE_65).plusDay(1).isBefore(entity.get生年月日())) {
            return;
        }

        AgeCalculator ageCalculator = new AgeCalculator(new _DateOfBirth(entity.get生年月日()),
                JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日);
        FlexibleDate age = ageCalculator.get年齢到達日(AGE_65);

        NenreiIdoHanteiMybatisParameter sqlParam = parameter.toNenreiIdoHanteiMybatisParameter(entity.get識別コード(), age);

        if (!mapper.select他市町村住所地特例(sqlParam).isEmpty()) {
            return;
        }
        if (!mapper.select適用除外者(sqlParam).isEmpty()) {
            return;
        }
        if (!mapper.select資格取得除外者(sqlParam).isEmpty()) {
            return;
        }
        if (!mapper.select転入保留対象者(sqlParam).isEmpty()) {
            return;
        }
        DbT1001HihokenshaDaichoEntity dbT1001Entity = hihokenshaDaichoKoshin.updHihokenshaDaicho(entity);
        if (dbT1001Entity != null) {
            dbT1001Writer.insert(dbT1001Entity);
        }
    }

    @Override
    protected void afterExecute() {
        DbT7022ShoriDateKanriEntity dbt7022 = mapper.selectバッチ内で抽出条件();
        if (dbt7022 == null) {
            DbT7022ShoriDateKanriEntity insertEntity = hihokenshaDaichoKoshin.updNenreitotatsuJoken(開始日, 終了日, null);
            dbT7022Writer.insert(insertEntity);
        } else {
            hihokenshaDaichoKoshin.updNenreitotatsuJoken(開始日, 終了日, dbt7022);
            dbT7022Writer.update(dbt7022);
        }
    }

}
