/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiinEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.UpdTaishoSeitaiyinTemp4Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 対象世帯員クラスTempに更新4のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-4630-060 jiangwenkai
 */
public class UpdTaishoSeitaiyinTemp4Process extends BatchProcessBase<UpdTaishoSeitaiyinTemp4Entity> {

    private static final RString TABLE_NAME = new RString("TaishoSetaiin");
    private static final RString RSTRING_16 = new RString("16");
    private static final RString RSTRING_18 = new RString("18");
    private static final RString RSTRING_10 = new RString("10");
    private static final RString RSTRING_20 = new RString("20");
    private static final RString RSTRING_01 = new RString("01");
    private static final Decimal DECIMAL_38 = new Decimal(380000);
    private static final Decimal DECIMAL_33 = new Decimal(330000);
    private static final Decimal DECIMAL_12 = new Decimal(120000);
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.対象世帯員クラスTempに更新4");
    private static final RString コンマ = new RString(",");
    private UpdTaishoSeitaiyinTemp4Entity exEntity;
    private static final int INT_0 = 0;
    private int index = 0;
    private List<UpdTaishoSeitaiyinTemp4Entity> entityList;
    private int ageLess16;
    private int age16_18;
    private Set<RString> 識別コードSet;
    private Set<RString> 識別コードFlgSet;
    private Set<RString> 対象世帯員重複Set;

    @Override
    protected void initialize() {
        super.initialize();
        this.entityList = new ArrayList<>();
        this.識別コードSet = new HashSet();
        this.識別コードFlgSet = new HashSet();
        対象世帯員重複Set = new HashSet();
    }

    @BatchWriter
    private BatchEntityCreatedTempTableWriter taiShoTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.taiShoTableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, TaishoSetaiinEntity.class);
    }

    @Override
    protected void process(UpdTaishoSeitaiyinTemp4Entity entity) {
        if (INT_0 == index) {
            this.exEntity = entity;
            index++;
        } else {
            this.entityList.add(exEntity);
            this.getAge(exEntity);
            this.get課税所得_控除後Flage(exEntity);
            if (this.isChangeShotaiCode(exEntity.get対象世帯員1(), entity.get対象世帯員1())) {
                for (UpdTaishoSeitaiyinTemp4Entity forEntity : entityList) {
                    TaishoSetaiinEntity 対象世帯員1 = forEntity.get対象世帯員1();
                    対象世帯員1.setNennshouLess16Num(ageLess16);
                    対象世帯員1.setNennshouLess16_18Num(age16_18);
                    this.get課税所得_控除後(対象世帯員1);
                    this.taiShoTableWriter.update(対象世帯員1);
                }
                this.entityList.clear();
                this.age16_18 = 0;
                this.ageLess16 = 0;
                this.識別コードSet.clear();
                this.識別コードFlgSet.clear();
                this.対象世帯員重複Set.clear();
            }
            this.exEntity = entity;
        }

    }

    @Override
    protected void afterExecute() {
        if (exEntity != null && INT_0 == this.entityList.size()) {
            this.entityList.add(exEntity);
            this.getAge(exEntity);
            this.get課税所得_控除後Flage(exEntity);
        }
        for (UpdTaishoSeitaiyinTemp4Entity forEntity : entityList) {
            TaishoSetaiinEntity 対象世帯員1 = forEntity.get対象世帯員1();
            対象世帯員1.setNennshouLess16Num(ageLess16);
            対象世帯員1.setNennshouLess16_18Num(age16_18);
            this.get課税所得_控除後(対象世帯員1);
            this.taiShoTableWriter.update(対象世帯員1);
        }
    }

    private boolean isChangeShotaiCode(TaishoSetaiinEntity ex対象世帯員, TaishoSetaiinEntity 対象世帯員) {
        return !ex対象世帯員.getShotaiCode().equals(対象世帯員.getShotaiCode());

    }

    private void getAge(UpdTaishoSeitaiyinTemp4Entity entity) {
        TaishoSetaiinEntity 対象世帯員2 = entity.get対象世帯員2();
        RString 対象世帯員重複 = 対象世帯員2.getShotaiCode().concat(コンマ).concat(getColumnValue(対象世帯員2.getHihokenshaNo())).concat(コンマ)
                .concat(getColumnValue(対象世帯員2.getShikibetsuCode()));
        if (!対象世帯員重複Set.contains(対象世帯員重複)) {
            if ((!RString.isNullOrEmpty(対象世帯員2.getAge()) && 対象世帯員2.getAge().compareTo(RSTRING_16) < 0)
                    && (this.getDecimal(対象世帯員2.getNenkinShunyuGaku())
                    .add(this.getDecimal(対象世帯員2.getSonotanoGoukeiShotokuKingakuGoukei())).compareTo(DECIMAL_38) <= 0)
                    && (RSTRING_10.equals(対象世帯員2.getAtenaDateDhubetsu_1231()) || RSTRING_20.equals(対象世帯員2.getAtenaDateDhubetsu_1231()))) {
                ageLess16++;
            }

            if (!RString.isNullOrEmpty(対象世帯員2.getAge()) && (RSTRING_16.compareTo(対象世帯員2.getAge()) <= 0 && 対象世帯員2.getAge().compareTo(RSTRING_18) <= 0)
                    && (this.getDecimal(対象世帯員2.getNenkinShunyuGaku())
                    .add(this.getDecimal(対象世帯員2.getSonotanoGoukeiShotokuKingakuGoukei())).compareTo(DECIMAL_38) <= 0)
                    && (RSTRING_10.equals(対象世帯員2.getAtenaDateDhubetsu_1231()) || RSTRING_20.equals(対象世帯員2.getAtenaDateDhubetsu_1231()))) {
                age16_18++;
            }
            対象世帯員重複Set.add(対象世帯員重複);
        }
    }

    private void get課税所得_控除後Flage(UpdTaishoSeitaiyinTemp4Entity entity) {
        TaishoSetaiinEntity 対象世帯員1 = entity.get対象世帯員1();
        TaishoSetaiinEntity 対象世帯員2 = entity.get対象世帯員2();
        if (RSTRING_01.equals(対象世帯員2.getHennshuuZokugaraCode())) {
            this.識別コードSet.add(getColumnValue(対象世帯員2.getShikibetsuCode()));
        }
        if (this.識別コードSet.contains(getColumnValue(対象世帯員1.getShikibetsuCode()))) {
            this.識別コードFlgSet.add(getColumnValue(対象世帯員1.getShikibetsuCode()));
        }
    }

    private void get課税所得_控除後(TaishoSetaiinEntity 対象世帯員1) {
        Decimal 控除後;
        if (識別コードFlgSet.contains(getColumnValue(対象世帯員1.getShikibetsuCode()))) {
            控除後 = getDecimal(対象世帯員1.getKazeiShotokuGaku()).subtract(DECIMAL_33.multiply(this.ageLess16).add(DECIMAL_12.multiply(this.age16_18)));
            if (控除後.compareTo(Decimal.ZERO) < 0) {
                控除後 = Decimal.ZERO;
            }
            対象世帯員1.setKazeiShotokuGakuAfter(控除後);
        }

    }

    private Decimal getDecimal(Decimal decimal) {
        if (null != decimal) {
            return decimal;
        }
        return Decimal.ZERO;
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
