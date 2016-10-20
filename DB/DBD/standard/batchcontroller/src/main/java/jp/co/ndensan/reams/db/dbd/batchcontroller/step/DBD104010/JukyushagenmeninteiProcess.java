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
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010.NinteiyotaiTwoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushagenmenjkoujyotai.IJukyushagenmeninteiMapper;
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
    private NinteijkouTempTableEntity entity;
    private final Decimal 標準負担額減免 = new Decimal(1);
    private final Decimal 利用者負担額減額 = new Decimal(2);
    private final Decimal 訪問介護利用者負担額減額 = new Decimal(3);
    private final Decimal 社会福祉法人減免 = new Decimal(4);
    private final Decimal 介護保険負担限度額認定 = new Decimal(5);
    private final Decimal 特別地域加算減免 = new Decimal(6);
    private boolean 標準負担額減免flag = false;
    private boolean 標準負担額減免flag_0 = false;
    private boolean 標準負担額減免flag_1 = false;
    private boolean 標準負担額減免flag_2 = false;
    private boolean 標準負担額減免flag_3 = false;
    private boolean 標準負担額減免flag_4 = false;
    private boolean 標準負担額減免flag_5 = false;

    private boolean 利用者負担額減額flag = false;
    private boolean 利用者負担額減額flag_0 = false;
    private boolean 利用者負担額減額flag_1 = false;
    private boolean 利用者負担額減額flag_2 = false;
    private boolean 利用者負担額減額flag_3 = false;
    private boolean 利用者負担額減額flag_4 = false;
    private boolean 利用者負担額減額flag_5 = false;

    private boolean 訪問介護利用者負担額減額flag = false;
    private boolean 訪問介護利用者負担額減額flag_0 = false;
    private boolean 訪問介護利用者負担額減額flag_1 = false;
    private boolean 訪問介護利用者負担額減額flag_2 = false;
    private boolean 訪問介護利用者負担額減額flag_3 = false;
    private boolean 訪問介護利用者負担額減額flag_4 = false;
    private boolean 訪問介護利用者負担額減額flag_5 = false;
    private boolean 訪問介護利用者負担額減額flag_6 = false;
    private boolean 訪問介護利用者負担額減額flag_7 = false;
    private boolean 訪問介護利用者負担額減額flag_8 = false;
    private boolean 訪問介護利用者負担額減額flag_9 = false;
    private boolean 訪問介護利用者負担額減額flag_10 = false;
    private boolean 訪問介護利用者負担額減額flag_11 = false;

    private boolean 社会福祉法人減免flag = false;
    private boolean 社会福祉法人減免flag_0 = false;
    private boolean 社会福祉法人減免flag_1 = false;
    private boolean 社会福祉法人減免flag_2 = false;
    private boolean 社会福祉法人減免flag_3 = false;
    private boolean 社会福祉法人減免flag_4 = false;
    private boolean 社会福祉法人減免flag_5 = false;

    private boolean 介護保険負担限度額認定flag = false;
    private boolean 介護保険負担限度額認定flag_0 = false;
    private boolean 介護保険負担限度額認定flag_1 = false;
    private boolean 介護保険負担限度額認定flag_2 = false;
    private boolean 介護保険負担限度額認定flag_3 = false;
    private boolean 介護保険負担限度額認定flag_4 = false;
    private boolean 介護保険負担限度額認定flag_5 = false;
    private boolean 介護保険負担限度額認定flag_6 = false;
    private boolean 介護保険負担限度額認定flag_7 = false;
    private boolean 介護保険負担限度額認定flag_8 = false;
    private boolean 介護保険負担限度額認定flag_9 = false;
    private boolean 介護保険負担限度額認定flag_10 = false;
    private boolean 介護保険負担限度額認定flag_11 = false;

    private boolean 特別地域加算減免flag = false;
    private boolean 特別地域加算減免flag_0 = false;
    private boolean 特別地域加算減免flag_1 = false;
    private boolean 特別地域加算減免flag_2 = false;
    private boolean 特別地域加算減免flag_3 = false;
    private boolean 特別地域加算減免flag_4 = false;
    private boolean 特別地域加算減免flag_5 = false;
    private static final Decimal ZERO = new Decimal(0);
    private static final Decimal ONE = new Decimal(1);
    private static final Decimal TWO = new Decimal(2);
    private static final Decimal THREE = new Decimal(3);
    private static final Decimal FOUR = new Decimal(4);
    private static final Decimal FIVE = new Decimal(5);
    private static final Decimal SIX = new Decimal(6);
    private static final Decimal SEVEN = new Decimal(7);
    private static final Decimal EIGHT = new Decimal(8);
    private static final Decimal NINE = new Decimal(9);
    private static final Decimal TEN = new Decimal(10);
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
        抽出期間開始日 = new FlexibleDate(processParameter.get対象年度().getYearValue(), Integer.valueOf("04"), Integer.valueOf("01"));
        抽出期間終了日 = 抽出期間開始日.minusDay(1).plusYear(1);
        if (全て.equals(processParameter.get宛名抽出条件().getShichoson_Code().value()) || processParameter.get宛名抽出条件().getShichoson_Code().isEmpty()) {
            市町村コード = 地方公共団体.getLasdecCode_();
            市町村名称 = 地方公共団体.get市町村名();
        } else {
            市町村コード = processParameter.get宛名抽出条件().getShichoson_Code();
            市町村名称 = AssociationFinderFactory.createInstance().getAssociation(processParameter.get宛名抽出条件().getShichoson_Code()).get市町村名();
        }
    }

    @Override
    protected void beforeExecute() {
        JukyushagenmenshinseiDateManager manager = new JukyushagenmenshinseiDateManager();
        IShikibetsuTaishoPSMSearchKey key = manager.set抽出条件(processParameter).build();
        月の件数 = getMapper(IJukyushagenmeninteiMapper.class).get認定状況情報(processParameter.toDBD104010MybatisParameter(key, 抽出期間開始日, 抽出期間終了日));
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

    }

    @Override
    protected void afterExecute() {
        JukyushagenmenninteiDateManager manager = new JukyushagenmenninteiDateManager();
        for (NinteiyotaiTwoEntity item : 月の件数) {
            set標準負担額減免State(item);
            set利用者負担額減額State(item);
            set訪問介護利用者負担額減額State(item);
            set社会福祉法人減免State(item);
            set介護保険負担限度額認定State(item);
            set特別地域加算減免State(item);
        }
        editor標準負担額減免(manager);
        editor利用者負担額減額(manager);
        editor訪問介護利用者負担額減額(manager);
        editor社会福祉法人減免(manager);
        editor介護保険負担限度額認定(manager);
        editor特別地域加算減免(manager);
        for (NinteijkouTempTableEntity ninteijkouTempTableEntity : list) {
            tmpNinteijkou.insert(ninteijkouTempTableEntity);
        }
    }

    private void editor標準負担額減免(JukyushagenmenninteiDateManager manager) {
        if (!標準負担額減免flag) {
            Decimal index = new Decimal(0);
            while (index.compareTo(FIVE) <= 0) {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(標準負担額減免, index, 市町村コード, 市町村名称));
            }
        } else {
            if (標準負担額減免flag_0) {
                editor減免認定者月の件数(標準負担額減免, ZERO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(標準負担額減免, ZERO, 市町村コード, 市町村名称));
            }

            if (標準負担額減免flag_1) {
                editor減免認定者月の件数(標準負担額減免, ONE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(標準負担額減免, ONE, 市町村コード, 市町村名称));
            }

            if (標準負担額減免flag_2) {
                editor減免認定者月の件数(標準負担額減免, TWO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(標準負担額減免, TWO, 市町村コード, 市町村名称));
            }

            if (標準負担額減免flag_3) {
                editor減免認定者月の件数(標準負担額減免, THREE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(標準負担額減免, THREE, 市町村コード, 市町村名称));
            }

            if (標準負担額減免flag_4) {
                editor減免認定者月の件数(標準負担額減免, FOUR, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(標準負担額減免, FOUR, 市町村コード, 市町村名称));
            }

            if (標準負担額減免flag_5) {
                editor減免認定者月の件数(標準負担額減免, FIVE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(標準負担額減免, FIVE, 市町村コード, 市町村名称));
            }
        }
    }

    private void editor利用者負担額減額(JukyushagenmenninteiDateManager manager) {
        if (!利用者負担額減額flag) {
            Decimal index = new Decimal(0);
            while (index.compareTo(FIVE) <= 0) {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(利用者負担額減額, index, 市町村コード, 市町村名称));
            }
        } else {
            if (利用者負担額減額flag_0) {
                editor減免認定者月の件数(利用者負担額減額, ZERO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(利用者負担額減額, ZERO, 市町村コード, 市町村名称));
            }

            if (利用者負担額減額flag_1) {
                editor減免認定者月の件数(利用者負担額減額, ONE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(利用者負担額減額, ONE, 市町村コード, 市町村名称));
            }

            if (利用者負担額減額flag_2) {
                editor減免認定者月の件数(利用者負担額減額, TWO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(利用者負担額減額, TWO, 市町村コード, 市町村名称));
            }

            if (利用者負担額減額flag_3) {
                editor減免認定者月の件数(利用者負担額減額, THREE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(利用者負担額減額, THREE, 市町村コード, 市町村名称));
            }

            if (利用者負担額減額flag_4) {
                editor減免認定者月の件数(利用者負担額減額, FOUR, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(利用者負担額減額, FOUR, 市町村コード, 市町村名称));
            }

            if (利用者負担額減額flag_5) {
                editor減免認定者月の件数(利用者負担額減額, FIVE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(利用者負担額減額, FIVE, 市町村コード, 市町村名称));
            }
        }
    }

    private void editor訪問介護利用者負担額減額(JukyushagenmenninteiDateManager manager) {
        if (!訪問介護利用者負担額減額flag) {
            Decimal index = new Decimal(0);
            while (index.compareTo(ELEVEN) <= 0) {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, index, 市町村コード, 市町村名称));
            }
        } else {
            if (訪問介護利用者負担額減額flag_0) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, ZERO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, ZERO, 市町村コード, 市町村名称));
            }

            if (訪問介護利用者負担額減額flag_1) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, ONE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, ONE, 市町村コード, 市町村名称));
            }

            if (訪問介護利用者負担額減額flag_2) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, TWO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, TWO, 市町村コード, 市町村名称));
            }

            if (訪問介護利用者負担額減額flag_3) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, THREE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, THREE, 市町村コード, 市町村名称));
            }

            if (訪問介護利用者負担額減額flag_4) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, FOUR, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, FOUR, 市町村コード, 市町村名称));
            }

            if (訪問介護利用者負担額減額flag_5) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, FIVE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, FIVE, 市町村コード, 市町村名称));
            }
            if (訪問介護利用者負担額減額flag_6) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, SIX, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, SIX, 市町村コード, 市町村名称));
            }
            if (訪問介護利用者負担額減額flag_7) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, SEVEN, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, SEVEN, 市町村コード, 市町村名称));
            }
            if (訪問介護利用者負担額減額flag_8) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, EIGHT, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, EIGHT, 市町村コード, 市町村名称));
            }
            if (訪問介護利用者負担額減額flag_9) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, NINE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, NINE, 市町村コード, 市町村名称));
            }
            if (訪問介護利用者負担額減額flag_10) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, TEN, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, TEN, 市町村コード, 市町村名称));
            }
            if (訪問介護利用者負担額減額flag_11) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, ELEVEN, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(訪問介護利用者負担額減額, ELEVEN, 市町村コード, 市町村名称));
            }
        }
    }

    private void editor社会福祉法人減免(JukyushagenmenninteiDateManager manager) {
        if (!社会福祉法人減免flag) {
            Decimal index = new Decimal(0);
            while (index.compareTo(FIVE) <= 0) {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(社会福祉法人減免, index, 市町村コード, 市町村名称));
            }
        } else {
            if (社会福祉法人減免flag_0) {
                editor減免認定者月の件数(社会福祉法人減免, ZERO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(社会福祉法人減免, ZERO, 市町村コード, 市町村名称));
            }

            if (社会福祉法人減免flag_1) {
                editor減免認定者月の件数(社会福祉法人減免, ONE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(社会福祉法人減免, ONE, 市町村コード, 市町村名称));
            }

            if (社会福祉法人減免flag_2) {
                editor減免認定者月の件数(社会福祉法人減免, TWO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(社会福祉法人減免, TWO, 市町村コード, 市町村名称));
            }

            if (社会福祉法人減免flag_3) {
                editor減免認定者月の件数(社会福祉法人減免, THREE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(社会福祉法人減免, THREE, 市町村コード, 市町村名称));
            }

            if (社会福祉法人減免flag_4) {
                editor減免認定者月の件数(社会福祉法人減免, FOUR, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(社会福祉法人減免, FOUR, 市町村コード, 市町村名称));
            }

            if (社会福祉法人減免flag_5) {
                editor減免認定者月の件数(社会福祉法人減免, FIVE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(社会福祉法人減免, FIVE, 市町村コード, 市町村名称));
            }
        }
    }

    private void editor介護保険負担限度額認定(JukyushagenmenninteiDateManager manager) {
        if (!介護保険負担限度額認定flag) {
            Decimal index = new Decimal(0);
            while (index.compareTo(ELEVEN) <= 0) {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, index, 市町村コード, 市町村名称));
            }
        } else {
            if (介護保険負担限度額認定flag_0) {
                editor減免認定者月の件数(訪問介護利用者負担額減額, ZERO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, ZERO, 市町村コード, 市町村名称));
            }

            if (介護保険負担限度額認定flag_1) {
                editor減免認定者月の件数(介護保険負担限度額認定, ONE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, ONE, 市町村コード, 市町村名称));
            }

            if (介護保険負担限度額認定flag_2) {
                editor減免認定者月の件数(介護保険負担限度額認定, TWO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, TWO, 市町村コード, 市町村名称));
            }

            if (介護保険負担限度額認定flag_3) {
                editor減免認定者月の件数(介護保険負担限度額認定, THREE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, THREE, 市町村コード, 市町村名称));
            }

            if (介護保険負担限度額認定flag_4) {
                editor減免認定者月の件数(介護保険負担限度額認定, FOUR, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, FOUR, 市町村コード, 市町村名称));
            }

            if (介護保険負担限度額認定flag_5) {
                editor減免認定者月の件数(介護保険負担限度額認定, FIVE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, FIVE, 市町村コード, 市町村名称));
            }
            if (介護保険負担限度額認定flag_6) {
                editor減免認定者月の件数(介護保険負担限度額認定, SIX, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, SIX, 市町村コード, 市町村名称));
            }
            if (介護保険負担限度額認定flag_7) {
                editor減免認定者月の件数(介護保険負担限度額認定, SEVEN, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, SEVEN, 市町村コード, 市町村名称));
            }
            if (介護保険負担限度額認定flag_8) {
                editor減免認定者月の件数(介護保険負担限度額認定, EIGHT, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, EIGHT, 市町村コード, 市町村名称));
            }
            if (介護保険負担限度額認定flag_9) {
                editor減免認定者月の件数(介護保険負担限度額認定, NINE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, NINE, 市町村コード, 市町村名称));
            }
            if (介護保険負担限度額認定flag_10) {
                editor減免認定者月の件数(介護保険負担限度額認定, TEN, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, TEN, 市町村コード, 市町村名称));
            }
            if (介護保険負担限度額認定flag_11) {
                editor減免認定者月の件数(介護保険負担限度額認定, ELEVEN, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(介護保険負担限度額認定, ELEVEN, 市町村コード, 市町村名称));
            }
        }
    }

    private void editor特別地域加算減免(JukyushagenmenninteiDateManager manager) {
        if (!特別地域加算減免flag) {
            Decimal index = new Decimal(0);
            while (index.compareTo(FIVE) <= 0) {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(特別地域加算減免, index, 市町村コード, 市町村名称));
            }
        } else {
            if (特別地域加算減免flag_0) {
                editor減免認定者月の件数(特別地域加算減免, ZERO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(特別地域加算減免, ZERO, 市町村コード, 市町村名称));
            }

            if (特別地域加算減免flag_1) {
                editor減免認定者月の件数(特別地域加算減免, ONE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(特別地域加算減免, ONE, 市町村コード, 市町村名称));
            }

            if (特別地域加算減免flag_2) {
                editor減免認定者月の件数(特別地域加算減免, TWO, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(特別地域加算減免, TWO, 市町村コード, 市町村名称));
            }

            if (特別地域加算減免flag_3) {
                editor減免認定者月の件数(特別地域加算減免, THREE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(特別地域加算減免, THREE, 市町村コード, 市町村名称));
            }

            if (特別地域加算減免flag_4) {
                editor減免認定者月の件数(特別地域加算減免, FOUR, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(特別地域加算減免, FOUR, 市町村コード, 市町村名称));
            }

            if (特別地域加算減免flag_5) {
                editor減免認定者月の件数(特別地域加算減免, FIVE, manager);
            } else {
                list.add(manager.add受給者減免月別認定者数状況表中間テーブルEmpty(特別地域加算減免, FIVE, 市町村コード, 市町村名称));
            }
        }
    }

    private void editor減免認定者月の件数(Decimal tableflag, Decimal num, JukyushagenmenninteiDateManager manager) {
        List<NinteiyotaiTwoEntity> 減免月の件数 = new ArrayList<>();
        for (NinteiyotaiTwoEntity item1 : 月の件数) {
            減免月の件数 = set月の件数(減免月の件数, item1, tableflag, num);
        }
        entity = manager.add受給者減免月別認定者数状況表中間テーブルEmpty(tableflag, num, 市町村コード, 市町村名称);
        list.add(editor認定者月の件数Empty(entity, 減免月の件数));
    }

    private List<NinteiyotaiTwoEntity> set月の件数(List<NinteiyotaiTwoEntity> entityList, NinteiyotaiTwoEntity item1, Decimal tableflag, Decimal flag) {
        if (tableflag.equals(item1.getTableFlag()) && flag.equals(item1.getFlag())) {
            entityList.add(item1);
        }
        return entityList;
    }

    private NinteijkouTempTableEntity editor認定者月の件数Empty(NinteijkouTempTableEntity entity, List<NinteiyotaiTwoEntity> 標準負担額減免月の件数) {
        for (NinteiyotaiTwoEntity item : 標準負担額減免月の件数) {
            if (item.getFlag1().equals(ONE)) {
                entity.setIchigatukensu(item.getKensu());
                entity.setIchigatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(TWO)) {
                entity.setNigatukensu(item.getKensu());
                entity.setNigatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(THREE)) {
                entity.setSangatukensu(item.getKensu());
                entity.setSangatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(FOUR)) {
                entity.setSigatukensu(item.getKensu());
                entity.setSigatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(FIVE)) {
                entity.setGogatukensu(item.getKensu());
                entity.setGogatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(SIX)) {
                entity.setLokugatukensu(item.getKensu());
                entity.setLokugatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(SEVEN)) {
                entity.setShichigatukensu(item.getKensu());
                entity.setShichigatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(EIGHT)) {
                entity.setHachigatukensu(item.getKensu());
                entity.setHachigatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(NINE)) {
                entity.setKugatukensu(item.getKensu());
                entity.setKugatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(TEN)) {
                entity.setJyugatukensu(item.getKensu());
                entity.setJyugatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(ELEVEN)) {
                entity.setJyuichigatukensu(item.getKensu());
                entity.setJyuichigatusotishakensu(item.getSotishakensu());
            }
            if (item.getFlag1().equals(TWELVE)) {
                entity.setJyunigatukensu(item.getKensu());
                entity.setJyunigatusotishakensu(item.getSotishakensu());
            }
            Decimal sum = entity.getIchigatukensu().add(entity.getNigatukensu()).add(entity.getSangatukensu())
                    .add(entity.getSigatukensu()).add(entity.getGogatukensu()).add(entity.getLokugatukensu()).add(entity.getShichigatukensu())
                    .add(entity.getHachigatukensu()).add(entity.getKugatukensu()).add(entity.getJyugatukensu()).add(entity.getJyuichigatukensu())
                    .add(entity.getJyunigatukensu());
            Decimal sotishasum = entity.getIchigatusotishakensu().add(entity.getNigatusotishakensu()).add(entity.getSangatusotishakensu())
                    .add(entity.getSigatusotishakensu()).add(entity.getGogatusotishakensu()).add(entity.getLokugatusotishakensu())
                    .add(entity.getShichigatusotishakensu())
                    .add(entity.getHachigatusotishakensu()).add(entity.getKugatusotishakensu()).add(entity.getJyugatusotishakensu())
                    .add(entity.getJyuichigatusotishakensu())
                    .add(entity.getJyunigatukensu());
            entity.setGoukeikensu(sum);
            entity.setGoukeisotishakensu(sotishasum);
        }
        return entity;
    }

    private void set標準負担額減免State(NinteiyotaiTwoEntity item) {
        if (標準負担額減免.equals(item.getTableFlag())) {
            標準負担額減免flag = true;
            if (ZERO.equals(item.getFlag())) {
                標準負担額減免flag_0 = true;
            }
            if (ONE.equals(item.getFlag())) {
                標準負担額減免flag_1 = true;
            }
            if (TWO.equals(item.getFlag())) {
                標準負担額減免flag_2 = true;
            }
            if (THREE.equals(item.getFlag())) {
                標準負担額減免flag_3 = true;
            }
            if (FOUR.equals(item.getFlag())) {
                標準負担額減免flag_4 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                標準負担額減免flag_5 = true;
            }
        }
    }

    private void set利用者負担額減額State(NinteiyotaiTwoEntity item) {
        if (利用者負担額減額.equals(item.getTableFlag())) {
            利用者負担額減額flag = true;
            if (ZERO.equals(item.getFlag())) {
                利用者負担額減額flag_0 = true;
            }
            if (ONE.equals(item.getFlag())) {
                利用者負担額減額flag_1 = true;
            }
            if (TWO.equals(item.getFlag())) {
                利用者負担額減額flag_2 = true;
            }
            if (THREE.equals(item.getFlag())) {
                利用者負担額減額flag_3 = true;
            }
            if (FOUR.equals(item.getFlag())) {
                利用者負担額減額flag_4 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                利用者負担額減額flag_5 = true;
            }
        }
    }

    private void set訪問介護利用者負担額減額State(NinteiyotaiTwoEntity item) {
        if (訪問介護利用者負担額減額.equals(item.getTableFlag())) {
            訪問介護利用者負担額減額flag = true;
            if (ZERO.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_0 = true;
            }
            if (ONE.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_1 = true;
            }
            if (TWO.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_2 = true;
            }
            if (THREE.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_3 = true;
            }
            if (FOUR.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_4 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_5 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_6 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_7 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_8 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_9 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_10 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                訪問介護利用者負担額減額flag_11 = true;
            }
        }
    }

    private void set社会福祉法人減免State(NinteiyotaiTwoEntity item) {
        if (社会福祉法人減免.equals(item.getTableFlag())) {
            社会福祉法人減免flag = true;
            if (ZERO.equals(item.getFlag())) {
                社会福祉法人減免flag_0 = true;
            }
            if (ONE.equals(item.getFlag())) {
                社会福祉法人減免flag_1 = true;
            }
            if (TWO.equals(item.getFlag())) {
                社会福祉法人減免flag_2 = true;
            }
            if (THREE.equals(item.getFlag())) {
                社会福祉法人減免flag_3 = true;
            }
            if (FOUR.equals(item.getFlag())) {
                社会福祉法人減免flag_4 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                社会福祉法人減免flag_5 = true;
            }
        }
    }

    private void set介護保険負担限度額認定State(NinteiyotaiTwoEntity item) {
        if (介護保険負担限度額認定.equals(item.getTableFlag())) {
            介護保険負担限度額認定flag = true;
            if (ZERO.equals(item.getFlag())) {
                介護保険負担限度額認定flag_0 = true;
            }
            if (ONE.equals(item.getFlag())) {
                介護保険負担限度額認定flag_1 = true;
            }
            if (TWO.equals(item.getFlag())) {
                介護保険負担限度額認定flag_2 = true;
            }
            if (THREE.equals(item.getFlag())) {
                介護保険負担限度額認定flag_3 = true;
            }
            if (FOUR.equals(item.getFlag())) {
                介護保険負担限度額認定flag_4 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                介護保険負担限度額認定flag_5 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                介護保険負担限度額認定flag_6 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                介護保険負担限度額認定flag_7 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                介護保険負担限度額認定flag_8 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                介護保険負担限度額認定flag_9 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                介護保険負担限度額認定flag_10 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                介護保険負担限度額認定flag_11 = true;
            }
        }
    }

    private void set特別地域加算減免State(NinteiyotaiTwoEntity item) {
        if (特別地域加算減免.equals(item.getTableFlag())) {
            特別地域加算減免flag = true;
            if (ZERO.equals(item.getFlag())) {
                特別地域加算減免flag_0 = true;
            }
            if (ONE.equals(item.getFlag())) {
                特別地域加算減免flag_1 = true;
            }
            if (TWO.equals(item.getFlag())) {
                特別地域加算減免flag_2 = true;
            }
            if (THREE.equals(item.getFlag())) {
                特別地域加算減免flag_3 = true;
            }
            if (FOUR.equals(item.getFlag())) {
                特別地域加算減免flag_4 = true;
            }
            if (FIVE.equals(item.getFlag())) {
                特別地域加算減免flag_5 = true;
            }
        }
    }

}
