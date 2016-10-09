/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD104010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd104010.JukyushagenmenshinseiDateManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd104010.DBD104010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijkouTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijyotaiEntity;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者減免月別申請認定状況表を集計するのProcessです。
 *
 * @reamsid_L DBD-3770-030 liuwei2
 */
public class JukyushagenmenshinseiProcess extends BatchProcessBase<NinteijyotaiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper"
            + ".relate.jukyushagenmenjkoujyotai.IJukyushagenmenshinseiMapper.get認定状況情報");
    private List<NinteijkouTempTableEntity> list;
    private DBD104010ProcessParameter processParameter;
    private FlexibleDate 抽出期間開始日;
    private FlexibleDate 抽出期間終了日;
    private final Decimal 標準負担額減免 = new Decimal(1);
    private final Decimal 利用者負担額減額 = new Decimal(2);
    private final Decimal 訪問介護利用者負担額減額 = new Decimal(3);
    private final Decimal 社会福祉法人減免 = new Decimal(4);
    private final Decimal 介護保険負担限度額認定 = new Decimal(5);
    private final Decimal 特別地域加算減免 = new Decimal(6);
    private Decimal num = new Decimal(0);
    private Decimal localflag = new Decimal(1);
    private static final Decimal ZERO = new Decimal(0);
    private static final Decimal SIX = new Decimal(6);
    private static final Decimal THIRTHEEN = new Decimal(13);
    private final RString 全て = new RString("全て");
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private Association 地方公共団体;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpNinteijkou;

    @Override
    protected void initialize() {
        list = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        抽出期間開始日 = new FlexibleDate(processParameter.get対象年度().getYearValue(), Integer.valueOf("04"), Integer.valueOf("01"));
        抽出期間終了日 = 抽出期間開始日.minusDay(1).minusYear(1);
        if (全て.equals(processParameter.get宛名抽出条件().getShichoson_Code().value()) || processParameter.get宛名抽出条件().getShichoson_Code().isEmpty()) {
            市町村コード = 地方公共団体.getLasdecCode_();
            市町村名称 = 地方公共団体.get市町村名();
        } else {
            市町村コード = processParameter.get宛名抽出条件().getShichoson_Code();
            市町村名称 = AssociationFinderFactory.createInstance().getAssociation(processParameter.get宛名抽出条件().getShichoson_Code()).get市町村名();
        }
    }

    @Override
    protected IBatchReader createReader() {
        JukyushagenmenshinseiDateManager manager = new JukyushagenmenshinseiDateManager();
        IShikibetsuTaishoPSMSearchKey key = manager.set抽出条件(processParameter).build();
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toDBD104010MybatisParameter(key, 抽出期間開始日, 抽出期間終了日));
    }

    @Override
    protected void createWriter() {
        tmpNinteijkou = new BatchEntityCreatedTempTableWriter(NinteijkouTempTableEntity.TABLE_NAME,
                NinteijkouTempTableEntity.class);
    }

    @Override
    protected void process(NinteijyotaiEntity entity) {
        JukyushagenmenshinseiDateManager manager = new JukyushagenmenshinseiDateManager();
        if (entity.getTableFlag().equals(標準負担額減免)) {
            set標準負担額減免状況(entity, manager);
        } else if (entity.getTableFlag().equals(利用者負担額減額)) {
            set利用者負担額減額(entity, manager);
        } else if (entity.getTableFlag().equals(訪問介護利用者負担額減額)) {
            set訪問介護利用者負担額減額(entity, manager);
        } else if (entity.getTableFlag().equals(社会福祉法人減免)) {
            set社会福祉法人減免(entity, manager);
        } else if (entity.getTableFlag().equals(介護保険負担限度額認定)) {
            set介護保険負担限度額認定(entity, manager);
        } else if (entity.getTableFlag().equals(特別地域加算減免)) {
            set特別地域加算減免(entity, manager);
        }
    }

    @Override
    protected void afterExecute() {
        JukyushagenmenshinseiDateManager manager = new JukyushagenmenshinseiDateManager();
        while (num.compareTo(SIX) < 0) {
            list.add(manager.add受給者減免月別申請認定状況表中間テーブルEmpty(SIX, num, 市町村コード, 市町村名称));
            num = num.add(1);
        }
        for (NinteijkouTempTableEntity entity : list) {
            tmpNinteijkou.insert(entity);
        }
    }

    private void set標準負担額減免状況(NinteijyotaiEntity entity, JukyushagenmenshinseiDateManager manager) {
        update集計List(entity, manager, SIX);
        if (num.equals(SIX)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set利用者負担額減額(NinteijyotaiEntity entity, JukyushagenmenshinseiDateManager manager) {
        update集計List(entity, manager, SIX);
        if (0 <= num.compareTo(SIX)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set訪問介護利用者負担額減額(NinteijyotaiEntity entity, JukyushagenmenshinseiDateManager manager) {
        update集計List(entity, manager, THIRTHEEN);
        if (num.equals(THIRTHEEN)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set社会福祉法人減免(NinteijyotaiEntity entity, JukyushagenmenshinseiDateManager manager) {
        update集計List(entity, manager, SIX);
        if (num.equals(SIX)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set介護保険負担限度額認定(NinteijyotaiEntity entity, JukyushagenmenshinseiDateManager manager) {
        update集計List(entity, manager, THIRTHEEN);
        if (num.equals(THIRTHEEN)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set特別地域加算減免(NinteijyotaiEntity entity, JukyushagenmenshinseiDateManager manager) {
        update集計List(entity, manager, SIX);
        if (num.equals(SIX)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void update集計List(NinteijyotaiEntity entity, JukyushagenmenshinseiDateManager manager, Decimal index) {
        while (localflag.equals(entity.getTableFlag()) && !num.equals(entity.getFlag()) && num.compareTo(index) < 0) {
            list.add(manager.add受給者減免月別申請認定状況表中間テーブルEmpty(entity.getTableFlag(), num, 市町村コード, 市町村名称));
            num = num.add(1);
        }
        addゼロ記録(entity, manager);
        if (num.equals(entity.getFlag())) {
            list.add(manager.set受給者減免月別申請認定状況表中間テーブル(entity, num, 市町村コード, 市町村名称));
            num = num.add(1);
        }
    }

    private void addゼロ記録(NinteijyotaiEntity entity, JukyushagenmenshinseiDateManager manager) {
        Decimal index1 = SIX;
        if (訪問介護利用者負担額減額.equals(entity.getTableFlag().subtract(1)) || 介護保険負担限度額認定.equals(entity.getTableFlag().subtract(1))) {
            index1 = THIRTHEEN;
        }
        if (!localflag.equals(entity.getTableFlag())) {
            if (num.compareTo(index1) < 0) {
                while (num.compareTo(index1) <= 0) {
                    list.add(manager.add受給者減免月別申請認定状況表中間テーブルEmpty(entity.getTableFlag().subtract(1), num, 市町村コード, 市町村名称));
                    num = num.add(1);
                }
            }
            num = ZERO;
        }
    }
}
