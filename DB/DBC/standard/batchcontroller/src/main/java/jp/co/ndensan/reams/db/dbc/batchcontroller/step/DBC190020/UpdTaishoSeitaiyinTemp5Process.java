/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.UpdTaishoSeitaiyinTemp5ProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiinEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji.IKijunsyunyunenjiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 対象世帯員クラスTempに更新5のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-4630-060 jiangwenkai
 */
public class UpdTaishoSeitaiyinTemp5Process extends BatchProcessBase<TaishoSetaiinEntity> {

    private InsTaishoSeitaiyinTempProcessParameter parameter;

    private static final RString TABLE_NAME = new RString("TaishoSetaiin");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString MESSAGE_1 = new RString("世帯内に第１号被保険者が存在しないため、申請書を出力しません");
    private static final RString MESSAGE_2 = new RString("世帯課税が非課税のため、申請書を出力しません");
    private static final RString MESSAGE_3 = new RString("課税所得が145万円以上の世帯員が存在しないため、申請書を出力しません");
    private static final RString MESSAGE_4 = new RString("単独世帯で総収入額が383万円以上のため、申請書を出力しません");
    private static final RString MESSAGE_5 = new RString("複数世帯で総収入額が520万円以上のため、申請書を出力しません");
    private static final RString MESSAGE_6 = new RString("既に発行済みのため、申請書を出力しません");
    private static final Decimal DECIMAL_145 = new Decimal(1450000);
    private static final Decimal DECIMAL_383 = new Decimal(3830000);
    private static final Decimal DECIMAL_520 = new Decimal(5200000);
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.対象世帯員クラスTempに更新5");
    private TaishoSetaiinEntity firstEntity;
    private TaishoSetaiinEntity exEntity;
    private int index = 0;
    private List<TaishoSetaiinEntity> entityList;
    private boolean 課税区分flg = false;
    private boolean 課税所得flg = false;
    private boolean 世帯出力flg = false;
    private Decimal 総収入額 = Decimal.ZERO;
    private int 該当件数;

    @Override
    protected void initialize() {
        this.entityList = new ArrayList<>();
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
    protected void process(TaishoSetaiinEntity entity) {
        if (INT_0 == index) {
            this.exEntity = entity;
            this.firstEntity = entity;
            index++;
        } else {
            if (RSTRING_0.equals(parameter.get抽出条件())) {
                this.entityList.add(exEntity);
                this.設定flg(exEntity);
                if (isChangeShotaiCode(exEntity, entity)) {
                    this.get該当件数(exEntity.getShotaiCode());
                    this.所得年度世帯出力有無の判定();
                    this.entityList.clear();
                    this.firstEntity = entity;
                }
            } else if (RSTRING_1.equals(parameter.get抽出条件())) {
                this.entityList.add(exEntity);
                if (isChangeShotaiCode(exEntity, entity)) {
                    this.get該当件数(exEntity.getShotaiCode());
                    this.被保険者番号世帯出力有無の判定();
                    this.entityList.clear();
                    this.firstEntity = entity;
                }
            }
        }

        this.exEntity = entity;

    }

    @Override
    protected void afterExecute() {
        if (exEntity != null && INT_0 == this.entityList.size()) {
            this.entityList.add(exEntity);
            this.設定flg(exEntity);
        }
        if (null != this.exEntity) {
            if (RSTRING_0.equals(parameter.get抽出条件())) {
                this.get該当件数(exEntity.getShotaiCode());
                this.所得年度世帯出力有無の判定();
                this.entityList.clear();
            } else if (RSTRING_1.equals(parameter.get抽出条件())) {
                this.get該当件数(exEntity.getShotaiCode());
                this.被保険者番号世帯出力有無の判定();
                this.entityList.clear();

            }
        }

    }

    private boolean isChangeShotaiCode(TaishoSetaiinEntity ex対象世帯員, TaishoSetaiinEntity 対象世帯員) {
        return !ex対象世帯員.getShotaiCode().equals(対象世帯員.getShotaiCode());

    }

    private void 設定flg(TaishoSetaiinEntity entity) {
        if (RSTRING_1.equals(entity.getKazeiKubun())) {
            this.課税区分flg = true;
        }

        if ((RSTRING_1.equals(entity.getHihokennshaKubun()) || RSTRING_3.equals(entity.getHihokennshaKubun()))) {
            if (DECIMAL_145.compareTo(getDecimal(entity.getKazeiShotokuGakuAfter())) <= 0) {
                this.課税所得flg = true;
            }
            this.総収入額 = this.総収入額.add(getDecimal(entity.getNenkinShunyuGaku())).add(getDecimal(entity.getSonotanoGoukeiShotokuKingakuGoukei()));
        }

        if (RSTRING_1.equals(entity.getHihokennshaKubun())) {
            this.世帯出力flg = true;
        }

    }

    private void 所得年度世帯出力有無の判定() {
        for (TaishoSetaiinEntity 対象世帯員 : entityList) {
            if (this.課税区分flg) {
                対象世帯員.setSetaikazeiKubun(RSTRING_1);
            } else {
                対象世帯員.setSetaikazeiKubun(RSTRING_2);
            }

            if (this.課税所得flg) {
                対象世帯員.setKazeiShotokuKubun(RSTRING_1);
            } else {
                対象世帯員.setKazeiShotokuKubun(RSTRING_2);
            }
            対象世帯員.setSoushuu(this.総収入額);

            if (世帯出力flg) {
                対象世帯員.setMessage(MESSAGE_1);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (RSTRING_2.equals(this.firstEntity.getKazeiKubun())) {
                対象世帯員.setMessage(MESSAGE_2);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (RSTRING_2.equals(対象世帯員.getKazeiShotokuKubun())) {
                対象世帯員.setMessage(MESSAGE_3);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (this.entityList.size() == 1 && DECIMAL_383.compareTo(対象世帯員.getSoushuu()) <= 0) {
                対象世帯員.setMessage(MESSAGE_4);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (2 <= this.entityList.size() && DECIMAL_520.compareTo(対象世帯員.getSoushuu()) <= 0) {
                対象世帯員.setMessage(MESSAGE_5);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (0 < this.該当件数) {
                対象世帯員.setMessage(MESSAGE_6);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else {
                対象世帯員.setMessage(new RString(""));
                対象世帯員.setShuturyokuUmu(RSTRING_1);
                対象世帯員.setKoushinnNo(INT_1);
            }

            this.taiShoTableWriter.update(対象世帯員);
        }

    }

    private void 被保険者番号世帯出力有無の判定() {
        for (TaishoSetaiinEntity 対象世帯員 : entityList) {
            if (世帯出力flg) {
                対象世帯員.setMessage(MESSAGE_1);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (RSTRING_2.equals(this.firstEntity.getKazeiKubun())) {
                対象世帯員.setMessage(MESSAGE_2);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (RSTRING_2.equals(対象世帯員.getKazeiShotokuKubun())) {
                対象世帯員.setMessage(MESSAGE_3);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (this.entityList.size() == 1 && 対象世帯員.getSoushuu() != null && DECIMAL_383.compareTo(対象世帯員.getSoushuu()) <= 0) {
                対象世帯員.setMessage(MESSAGE_4);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (2 <= this.entityList.size() && 対象世帯員.getSoushuu() != null && DECIMAL_520.compareTo(対象世帯員.getSoushuu()) <= 0) {
                対象世帯員.setMessage(MESSAGE_5);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else if (0 < this.該当件数) {
                対象世帯員.setMessage(MESSAGE_6);
                対象世帯員.setShuturyokuUmu(RSTRING_2);
            } else {
                対象世帯員.setMessage(new RString(""));
                対象世帯員.setShuturyokuUmu(RSTRING_1);
                対象世帯員.setKoushinnNo(INT_1);
            }

            this.taiShoTableWriter.update(対象世帯員);
        }

    }

    private void get該当件数(RString 世帯コード) {
        UpdTaishoSeitaiyinTemp5ProcessMybatisParameter para = new UpdTaishoSeitaiyinTemp5ProcessMybatisParameter();
        para.set世帯コード(世帯コード);
        para.set処理年度(parameter.get処理年度());
        this.該当件数 = getMapper(IKijunsyunyunenjiMapper.class).get該当件数(para);
    }

    private Decimal getDecimal(Decimal decimal) {
        if (null != decimal) {
            return decimal;
        }
        return Decimal.ZERO;
    }

}
