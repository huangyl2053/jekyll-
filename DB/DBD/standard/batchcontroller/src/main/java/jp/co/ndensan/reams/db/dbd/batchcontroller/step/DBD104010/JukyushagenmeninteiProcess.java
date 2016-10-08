/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD104010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd104010.JukyushagenmenninteiDateManager;
import jp.co.ndensan.reams.db.dbd.business.core.dbd104010.JukyushagenmenshinseiDateManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd104010.DBD104010ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijkouTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteijyotaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteiyotaiTwoEntity;
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
 * 受給者減免月別認定者数状況表を集計するのProcessです。
 *
 * @reamsid_L DBD-3770-030 liuwei2
 */
public class JukyushagenmeninteiProcess extends BatchProcessBase<NinteiyotaiTwoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper"
            + ".relate.jukyushagenmenjkoujyotai.IJukyushagenmeninteiMapper.get認定状況情報");
    private List<NinteijkouTempTableEntity> list;
    private List<NinteiyotaiTwoEntity> 月の件数;
    private NinteijyotaiEntity entity;

    private final Decimal 標準負担額減免 = new Decimal(1);
    private final Decimal 利用者負担額減額 = new Decimal(2);
    private final Decimal 訪問介護利用者負担額減額 = new Decimal(3);
    private final Decimal 社会福祉法人減免 = new Decimal(4);
    private final Decimal 介護保険負担限度額認定 = new Decimal(5);
    private final Decimal 特別地域加算減免 = new Decimal(6);
    private Decimal num = new Decimal(0);
    private Decimal localflag = new Decimal(1);
    private Decimal flag = new Decimal(1);
    private Decimal 月数;
    private final int twelve = 12;
    private final int eleven = 11;
    private final int five = 5;
    private static final Decimal ZERO = new Decimal(0);
    private static final Decimal ONE = new Decimal(1);
    private static final Decimal FIVE = new Decimal(5);
    private static final Decimal FOUR = new Decimal(4);
    private static final Decimal ELEVEN = new Decimal(11);
    private static final Decimal TWELVE = new Decimal(12);
    private DBD104010ProcessParameter processParameter;
    private FlexibleDate 抽出期間開始日;
    private FlexibleDate 抽出期間終了日;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private final RString 全て = new RString("全て");
    private Association 地方公共団体;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpNinteijkou;

    @Override
    protected void initialize() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        月の件数 = new ArrayList<>();
        list = new ArrayList<>();

        月数 = FOUR;
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
    protected void process(NinteiyotaiTwoEntity t) {
        JukyushagenmenninteiDateManager manager = new JukyushagenmenninteiDateManager();
        if (月の件数.isEmpty()) {
            if (月数.equals(t.getFlag1()) && flag.equals(t.getFlag())) {
                月の件数.add(t);
            } else {
                addNew月の件数(t, manager);
                月の件数.add(t);
                flag = flag.add(1);
            }
        } else if (月の件数.get(0).getTableFlag().equals(t.getTableFlag()) && 月の件数.get(0).getFlag().equals(t.getFlag())) {
            addNew月の件数(t, manager);
            月の件数.add(t);
            flag = flag.add(1);
        } else {
            if ((t.getTableFlag().equals(訪問介護利用者負担額減額) || t.getTableFlag().equals(介護保険負担限度額認定)) && 0 < TWELVE.compareTo(月数)) {
                while (0 <= TWELVE.compareTo(月数) || !月の件数.isEmpty()) {
                    月の件数.add(manager.getNinteiyotai月の件数(月の件数.get(月の件数.size() - 1).getFlag(), t.getTableFlag()));
                    月数 = 月数.add(1);
                }
            } else {
                while (0 <= FIVE.compareTo(月数) || !月の件数.isEmpty()) {
                    月の件数.add(manager.getNinteiyotai月の件数(月の件数.get(月の件数.size() - 1).getFlag(), t.getTableFlag()));
                    月数 = 月数.add(1);
                }
            }

            if (t.getTableFlag().subtract(ONE).equals(訪問介護利用者負担額減額) || t.getTableFlag().subtract(ONE).equals(介護保険負担限度額認定)) {
                while (flag.compareTo(ELEVEN) <= 0) {
                    for (int item = 1; item <= twelve; item++) {
                        月の件数.add(manager.getNinteiyotai月の件数(t.getFlag(), t.getTableFlag()));
                    }
                    flag = flag.add(1);
                }
            } else {
                while (flag.compareTo(FIVE) <= 0) {
                    for (int item = 1; item <= twelve; item++) {
                        月の件数.add(manager.getNinteiyotai月の件数(t.getFlag(), t.getTableFlag()));
                    }
                    flag = flag.add(1);
                }
            }
            entity = manager.setNinteijyotaiEntity(月の件数);
            set認定者数状況(manager);
            月数 = ONE;
            月の件数.clear();
            flag = ONE;
            addNew月の件数(t, manager);
            月の件数.add(t);
        }
    }

    @Override
    protected void afterExecute() {
        JukyushagenmenninteiDateManager manager = new JukyushagenmenninteiDateManager();
        if (!月の件数.isEmpty()) {
            if ((月の件数.get(0).getTableFlag().equals(訪問介護利用者負担額減額) || 月の件数.get(0).getTableFlag().equals(介護保険負担限度額認定)) && 0 < TWELVE.compareTo(月数)) {
                while (0 <= TWELVE.compareTo(月数) || !月の件数.isEmpty()) {
                    月の件数.add(manager.getNinteiyotai月の件数(月の件数.get(月の件数.size() - 1).getFlag(), 月の件数.get(0).getTableFlag()));
                    月数 = 月数.add(1);
                }
            } else {
                while (0 <= FIVE.compareTo(月数) || !月の件数.isEmpty()) {
                    月の件数.add(manager.getNinteiyotai月の件数(月の件数.get(月の件数.size() - 1).getFlag(), 月の件数.get(0).getTableFlag()));
                    月数 = 月数.add(1);
                }
            }

            if (月の件数.get(0).getTableFlag().equals(訪問介護利用者負担額減額) || 月の件数.get(0).getTableFlag().equals(介護保険負担限度額認定)) {
                while (flag.compareTo(ELEVEN) <= 0) {
                    for (int item = 1; item <= twelve; item++) {
                        月の件数.add(manager.getNinteiyotai月の件数(月の件数.get(0).getFlag(), 月の件数.get(0).getTableFlag()));
                    }
                    flag = flag.add(1);
                }
            } else {
                while (flag.compareTo(FIVE) <= 0) {
                    for (int item = 1; item <= twelve; item++) {
                        月の件数.add(manager.getNinteiyotai月の件数(月の件数.get(0).getFlag(), 月の件数.get(0).getTableFlag()));
                    }
                    flag = flag.add(1);
                }
            }
            entity = manager.setNinteijyotaiEntity(月の件数);
            set認定者数状況(manager);
            月数 = FOUR;
            月の件数.clear();
            flag = ONE;
        }
        setEmptyProcessDataの記録(manager, localflag);

        for (NinteijkouTempTableEntity ninteijkouTempTableEntity : list) {
            tmpNinteijkou.insert(ninteijkouTempTableEntity);
        }
    }

    private void set認定者数状況(JukyushagenmenninteiDateManager manager) {
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

    private void set標準負担額減免状況(NinteijyotaiEntity entity, JukyushagenmenninteiDateManager manager) {
        update集計List(entity, manager, FIVE);
        if (num.equals(FIVE)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set利用者負担額減額(NinteijyotaiEntity entity, JukyushagenmenninteiDateManager manager) {
        update集計List(entity, manager, FIVE);
        if (num.equals(FIVE)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set訪問介護利用者負担額減額(NinteijyotaiEntity entity, JukyushagenmenninteiDateManager manager) {
        update集計List(entity, manager, ELEVEN);
        if (num.equals(ELEVEN)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set社会福祉法人減免(NinteijyotaiEntity entity, JukyushagenmenninteiDateManager manager) {
        update集計List(entity, manager, FIVE);
        if (num.equals(FIVE)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set介護保険負担限度額認定(NinteijyotaiEntity entity, JukyushagenmenninteiDateManager manager) {
        update集計List(entity, manager, ELEVEN);
        if (num.equals(ELEVEN)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void set特別地域加算減免(NinteijyotaiEntity entity, JukyushagenmenninteiDateManager manager) {
        update集計List(entity, manager, FIVE);
        if (num.equals(FIVE)) {
            num = ZERO;
        }
        localflag = entity.getTableFlag();
    }

    private void update集計List(NinteijyotaiEntity entity, JukyushagenmenninteiDateManager manager, Decimal index) {
        while (localflag.equals(entity.getTableFlag()) && !num.equals(entity.getFlag()) && num.compareTo(index) < 0) {
            list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(entity.getTableFlag(), num, 市町村コード, 市町村名称));
            num = num.add(1);
        }
        addゼロ記録(entity, manager);
        if (num.equals(entity.getFlag())) {
            list.add(manager.set受給者減免月別認定者数状況表中間テーブル(entity, num, 市町村コード, 市町村名称));
            num = num.add(1);
        }
    }

    private void addゼロ記録(NinteijyotaiEntity entity, JukyushagenmenninteiDateManager manager) {
        Decimal index1 = FIVE;
        if (訪問介護利用者負担額減額.equals(entity.getTableFlag().subtract(1)) || 介護保険負担限度額認定.equals(entity.getTableFlag().subtract(1))) {
            index1 = ELEVEN;
        }
        if (!localflag.equals(entity.getTableFlag())) {
            if (localflag.add(1).compareTo(entity.getTableFlag()) < 0) {
                for (int index = localflag.intValue(); index < entity.getTableFlag().intValue(); index++) {
                    setEmptyTableflag記録(manager, localflag);
                }
            } else if (num.compareTo(index1) < 0) {
                while (num.compareTo(index1) <= 0) {
                    list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(entity.getTableFlag().subtract(1), num, 市町村コード, 市町村名称));
                    num = num.add(1);
                }
            }
            num = ZERO;
        }
    }

    private void setEmptyTableflag記録(JukyushagenmenninteiDateManager manager, Decimal localflag) {
        if (訪問介護利用者負担額減額.equals(localflag) || 介護保険負担限度額認定.equals(localflag)) {
            for (int index2 = 0; index2 <= eleven; index2++) {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(localflag.subtract(1), new Decimal(index2), 市町村コード, 市町村名称));
            }
        } else {
            for (int index2 = 0; index2 <= five; index2++) {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(localflag.subtract(1), new Decimal(index2), 市町村コード, 市町村名称));
            }
        }
    }

    private void addNew月の件数(NinteiyotaiTwoEntity t, JukyushagenmenninteiDateManager manager) {
        while (t.getFlag().compareTo(flag) < 0) {
            for (int item = 1; item <= twelve; item++) {
                月の件数.add(manager.getNinteiyotai月の件数(flag, t.getTableFlag()));
            }
            flag = flag.add(1);
        }
        while (t.getFlag1().compareTo(月数) < 0) {
            月の件数.add(manager.getNinteiyotai月の件数(t.getFlag(), t.getTableFlag()));
            月数 = 月数.add(1);
        }
    }

    private void setEmptyProcessDataの記録(JukyushagenmenninteiDateManager manager, Decimal localflag) {
        if (!特別地域加算減免.equals(localflag)) {
            while (0 <= 特別地域加算減免.compareTo(localflag)) {
                if (訪問介護利用者負担額減額.equals(localflag) || 介護保険負担限度額認定.equals(localflag)) {
                    for (int index2 = 0; index2 <= eleven; index2++) {
                        list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(localflag, new Decimal(index2), 市町村コード, 市町村名称));
                    }
                } else {
                    for (int index2 = 0; index2 <= five; index2++) {
                        list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(localflag, new Decimal(index2), 市町村コード, 市町村名称));
                    }
                }
                localflag = localflag.add(ONE);
            }
        }
    }
}
