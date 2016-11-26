/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.HeijunkaTaishogaiRiyu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.TaishoshaTmpEntity;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.dz.dzx.business.core.heijunka.GyomuConfigJohoClass;
import jp.co.ndensan.reams.dz.dzx.business.core.heijunka.Heijunka;
import jp.co.ndensan.reams.dz.dzx.business.core.heijunka.HeijunkaInput;
import jp.co.ndensan.reams.dz.dzx.business.core.heijunka.HeijunkaOutput;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 平準化計算クラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class HeinjunkaKeisanProcess extends BatchProcessBase<TokuchoHeijunkaRokuBatchTaishogaiTempEntity> {

    private static final RString 平準化計算結果TEMP_TABLE_NAME = new RString("TmpHeijunkaKeisanKeka");
    private static final RString 対象外データTEMP_TABLE_NAME = new RString("TmpTaishogai");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka6gatsu.ITokuchoHeinjunka6GatsuBatchMapper.get対象者データTemp");
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_10 = 10;
    private static final int NUM_100 = 100;
    private static final int NUM_1000 = 1000;
    private static final int NUM_11 = 11;
    private static final RString 平準化対象外理由区分_最小値未満 = new RString("1");
    private static final RString 平準化対象外理由区分_計算方法より = new RString("2");
    private static final RString 平準化しない = new RString("0");
    private static RString 特徴期情報_設定納期数;
    private static RString 特徴期情報_仮算定期数;
    private static RString 特別徴収_期別端数;
    private TokuchoHeinjunka6GatsuProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 平準化計算結果一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 対象外データ一時tableWriter;

    @Override
    protected void initialize() {
        RDate effectiveDate = new RDate(parameter.get賦課年度().toDateString().toString());
        特徴期情報_設定納期数 = コンフィグ値取得(ConfigNameDBB.特徴期情報_設定納期数, effectiveDate);
        特徴期情報_仮算定期数 = コンフィグ値取得(ConfigNameDBB.特徴期情報_仮算定期数, effectiveDate);
        特別徴収_期別端数 = コンフィグ値取得(ConfigNameDBB.特別徴収_期別端数, effectiveDate);
    }

    @Override
    protected void createWriter() {
        平準化計算結果一時tableWriter = new BatchEntityCreatedTempTableWriter(平準化計算結果TEMP_TABLE_NAME,
                TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity.class, true);
        対象外データ一時tableWriter = new BatchEntityCreatedTempTableWriter(対象外データTEMP_TABLE_NAME,
                TaishoshaTmpEntity.class, true);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(TokuchoHeijunkaRokuBatchTaishogaiTempEntity taishogaiTempEntity) {
        Heijunka heijunka = new Heijunka();
        HokenryoDankaiManager 保険料段階取得 = new HokenryoDankaiManager();
        HeijunkaInput heijunkaInput = new HeijunkaInput();
        平準化入力設定(保険料段階取得, parameter.get賦課年度(), taishogaiTempEntity, heijunkaInput, parameter.get増額平準化方法(),
                parameter.get減額平準化方法());
        HeijunkaOutput 平準化結果 = heijunka.calculateHeijunka(heijunkaInput);
        if (平準化結果.is平準化済フラグ()) {
            TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity tmpEntity = new TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity(
                    平準化結果.get変更後特徴期別額().get(NUM_0), 平準化結果.get変更後特徴期別額().get(NUM_1),
                    平準化結果.get変更後特徴期別額().get(NUM_2), taishogaiTempEntity.getTsuchishoNo());
            平準化計算結果一時tableWriter.insert(tmpEntity);
        } else {
            taishogaiTempEntity.set備考コード(get備考コード(平準化結果));
            対象外データ一時tableWriter.insert(taishogaiTempEntity);
        }
    }

    private void 平準化入力設定(HokenryoDankaiManager 保険料段階取得, FlexibleYear 賦課年度,
            TokuchoHeijunkaRokuBatchTaishogaiTempEntity entity, HeijunkaInput heijunkaInput,
            RString 平準化計算方法_増額, RString 平準化計算方法_減額) {
        if (entity.getHokenryoDankaiKarisanntei() != null) {
            Optional<HokenryoDankai> 保険料段階 = 保険料段階取得.get保険料段階(賦課年度, entity.getHokenryoDankaiKarisanntei());
            heijunkaInput.set年保険料額(今年度保険料率取得(保険料段階));
        }
        List<Decimal> 特徴期別額リスト = new ArrayList<>();
        特徴期別額リスト.add(entity.getTokubetsuChoteigaku01() == null ? Decimal.ZERO : entity.getTokubetsuChoteigaku01());
        特徴期別額リスト.add(entity.getTokubetsuChoteigaku02() == null ? Decimal.ZERO : entity.getTokubetsuChoteigaku02());
        特徴期別額リスト.add(entity.getTokubetsuChoteigaku03() == null ? Decimal.ZERO : entity.getTokubetsuChoteigaku03());
        List<Decimal> 普徴期別額リスト = new ArrayList<>();
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku01()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku02()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku03()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku04()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku05()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku06()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku07()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku08()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku09()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku10()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku11()));
        普徴期別額リスト.add(getFuchoChoteigaku(entity.getFuchoChoteigaku12()));
        heijunkaInput.set特徴期別額(特徴期別額リスト);
        heijunkaInput.set平準化開始期idx(NUM_1);
        heijunkaInput.set普徴期別額(普徴期別額リスト);
        heijunkaInput.set八月特徴開始者(NUM_0);
        GyomuConfigJohoClass 業務コンフィグ情報 = new GyomuConfigJohoClass();
        業務コンフィグ情報.set特徴定期数(Integer.parseInt(特徴期情報_設定納期数.toString()));
        業務コンフィグ情報.set特徴仮算定期数(Integer.parseInt(特徴期情報_仮算定期数.toString()));
        業務コンフィグ情報.set平準化計算方法増額分(Integer.parseInt(平準化計算方法_増額.toString()));
        業務コンフィグ情報.set平準化計算方法減額分(Integer.parseInt(平準化計算方法_減額.toString()));
        業務コンフィグ情報.set端数区分特徴期別額(端数区分特徴期別額転換(Integer.parseInt(特別徴収_期別端数.toString())));
        業務コンフィグ情報.set基準となる差額幅(Decimal.ZERO);
        業務コンフィグ情報.set基準となる差額率(Decimal.ZERO);
        業務コンフィグ情報.set平準化対象期別額最小値(Decimal.ONE);
        List<jp.co.ndensan.reams.dz.dzx.business.core.heijunka.Kibetsu> 期別リスト = new ArrayList<>();
        期別リスト作成(期別リスト);
        業務コンフィグ情報.set期別クラス(期別リスト);
        heijunkaInput.set業務コンフィグ情報(業務コンフィグ情報);
    }

    private int 端数区分特徴期別額転換(int 特別徴収_期別端数) {
        int 期別端数 = 0;
        switch (特別徴収_期別端数) {
            case NUM_1:
                期別端数 = NUM_1;
                break;
            case NUM_10:
                期別端数 = NUM_2;
                break;
            case NUM_100:
                期別端数 = NUM_3;
                break;
            case NUM_1000:
                期別端数 = NUM_4;
                break;
            default:
                break;
        }
        return 期別端数;
    }

    private Decimal getFuchoChoteigaku(Decimal fuchoChoteigaku) {
        return fuchoChoteigaku == null ? Decimal.ZERO : fuchoChoteigaku;
    }

    private void 期別リスト作成(List<jp.co.ndensan.reams.dz.dzx.business.core.heijunka.Kibetsu> 期別リスト) {
        jp.co.ndensan.reams.dz.dzx.business.core.heijunka.Kibetsu 期別 = new jp.co.ndensan.reams.dz.dzx.business.core.heijunka.Kibetsu();
        for (int i = 0; i <= NUM_11; i++) {
            期別リスト.add(期別);
        }
    }

    private RString コンフィグ値取得(Enum key, RDate effectiveDate) {
        return DbBusinessConfig.get(key, effectiveDate, SubGyomuCode.DBB介護賦課);
    }

    private Decimal 今年度保険料率取得(Optional<HokenryoDankai> 保険料段階) {
        Decimal 今年度保険料率 = Decimal.ZERO;
        if (保険料段階.isPresent()) {
            今年度保険料率 = 保険料段階.get().get保険料率();
        }
        return 今年度保険料率;
    }

    private RString get備考コード(HeijunkaOutput 平準化結果) {
        RString 平準化対象外理由区分 = 平準化結果.get平準化対象外理由区分();
        RString 備考コード = RString.EMPTY;
        if (平準化対象外理由区分_最小値未満.equals(平準化対象外理由区分)) {
            備考コード = HeijunkaTaishogaiRiyu.平準化の結果0円以下.getコード();
        } else if (平準化対象外理由区分_計算方法より.equals(平準化対象外理由区分)) {
            if (平準化しない.equals(parameter.get減額平準化方法())) {
                備考コード = HeijunkaTaishogaiRiyu.対象外_減額.getコード();
            } else if (平準化しない.equals(parameter.get増額平準化方法())) {
                備考コード = HeijunkaTaishogaiRiyu.対象外_増額.getコード();
            }
        } else {
            備考コード = HeijunkaTaishogaiRiyu.変更なし.getコード();
        }
        return 備考コード;
    }
}
