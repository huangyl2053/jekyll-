/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.HihokenSeikatsuRoreiRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯課税判定・被保・生保・老齢付加
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public class InsSetaiinShotokuHanteiMeisaiTmpProcess extends BatchProcessBase<TempSetaiinShotokuHanteiEntity> {

    private static final RString MYBATISPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper.select世帯員所得情報一時");
    private static final RString TABLE_世帯員所得判定明細一時 = new RString("TempSetaiinShotokuHanteiMeisai");

    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");

    private IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper;

    private RString 未申告課税区分;
    private RString 所得調査中課税区分;
    private RString 課税取消課税区分;
    private RString 減免前後課税区分;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
        RDate nowDate = RDate.getNowDate();
        未申告課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_未申告課税区分, nowDate, SubGyomuCode.DBB介護賦課);
        所得調査中課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_所得調査中課税区分, nowDate, SubGyomuCode.DBB介護賦課);
        課税取消課税区分 = DbBusinessConfig.get(ConfigNameDBB.賦課基準_課税取消課税区分, nowDate, SubGyomuCode.DBB介護賦課);
        減免前後課税区分 = DbBusinessConfig.get(ConfigNameDBC.減免前後課税区分, nowDate, SubGyomuCode.DBC介護給付);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATISPATH);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_世帯員所得判定明細一時,
                TempSetaiinShotokuHanteiEntity.class);
    }

    @Override
    protected void process(TempSetaiinShotokuHanteiEntity entity) {
        if (区分_1.equals(減免前後課税区分)) {
            entity.setHonninKazeiKubun(entity.getKazeiKubun());
        } else if (区分_2.equals(減免前後課税区分)) {
            entity.setHonninKazeiKubun(entity.getKazeiKubunGemmenGo());
        }
        if (KazeiKubun.未申告.getコード().equals(entity.getHonninKazeiKubun())) {
            entity.setHonninKazeiKubun(未申告課税区分);
        } else if (KazeiKubun.所得調査中.getコード().equals(entity.getHonninKazeiKubun())) {
            entity.setHonninKazeiKubun(所得調査中課税区分);
        } else if (KazeiKubun.課税取消.getコード().equals(entity.getHonninKazeiKubun())) {
            entity.setHonninKazeiKubun(課税取消課税区分);
        } else if (entity.getHonninKazeiKubun() == null || entity.getHonninKazeiKubun().isEmpty()) {
            entity.setHonninKazeiKubun(KazeiKubun.非課税.getコード());
        }
        tableWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
        List<HihokenSeikatsuRoreiRelateEntity> 被保生保老齢情報List = mapper.select被保生保老齢情報();
        boolean 課税区分flag = false;
        for (HihokenSeikatsuRoreiRelateEntity 被保生保老齢情報 : 被保生保老齢情報List) {
            TempSetaiinShotokuHanteiEntity 判定明細Entity = 被保生保老齢情報.get判定明細Entity();
            if (KazeiKubun.課税.getコード().equals(判定明細Entity.getHonninKazeiKubun())) {
                課税区分flag = true;
                break;
            }
        }
        for (HihokenSeikatsuRoreiRelateEntity 被保生保老齢情報 : 被保生保老齢情報List) {
            TempSetaiinShotokuHanteiEntity 判定明細Entity = 被保生保老齢情報.get判定明細Entity();
            List<UrT0508SeikatsuHogoJukyushaEntity> 生保情報List = 被保生保老齢情報.get生保情報List();
            DbT7006RoreiFukushiNenkinJukyushaEntity 老齢情報Entity = 被保生保老齢情報.get老齢情報Entity();
            boolean flag = false;
            for (UrT0508SeikatsuHogoJukyushaEntity 生保情報 : 生保情報List) {
                if (生保情報.getShikibetsuCode() == null || 生保情報.getShikibetsuCode().isEmpty()) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                判定明細Entity.setShoboKubun(区分_1);
            }
            if (老齢情報Entity != null && 老齢情報Entity.getShikibetsuCode() != null
                    && !老齢情報Entity.getShikibetsuCode().isEmpty()) {
                判定明細Entity.setRoreiFukushi(区分_1);
            }
            if (被保生保老齢情報.get被保険者情報Entity() != null) {
                HihokenshaDaicho 被保険者情報 = new HihokenshaDaicho(被保生保老齢情報.get被保険者情報Entity());
                HihokenshaNo 被保険者番号 = 被保険者情報.get被保険者番号();
                FlexibleDate 資格取得日 = 被保険者情報.get資格取得年月日();
                FlexibleDate 資格喪失年月日 = 被保険者情報.get資格喪失年月日();
                FlexibleDate 基準年月日 = 判定明細Entity.getKijunYMD();
                if (被保険者番号 != null && !被保険者番号.isEmpty() && 資格取得日 != null
                        && 資格取得日.isBeforeOrEquals(基準年月日) && 基準年月日 != null && 基準年月日.isBefore(資格喪失年月日)) {
                    判定明細Entity.setSetaiinHihokenshaNo(被保険者番号);
                    判定明細Entity.setSetaiinHihokenshakubun(被保険者情報.get被保険者区分コード());
                }
            }
            if (課税区分flag) {
                判定明細Entity.setSetaiKazeiKubun(KazeiKubun.課税.getコード());
            } else {
                判定明細Entity.setSetaiKazeiKubun(KazeiKubun.非課税.getコード());
            }
            tableWriter.update(判定明細Entity);
        }
    }
}
