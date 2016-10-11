/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishosetaiinido.TaishoSetaiinIdoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.UpdTaishoSeitaiyinTemp5ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiinEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.taishosetaiinido.TaishoSetaiinIdoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.taishosetaiinido.ITaishoSetaiinIdoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 対象世帯員クラスTempに更新5のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-4640-080 xuzhao
 */
public class UpdTaishoSeitaiyinTemp5Process extends BatchProcessBase<TaishoSetaiinEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.taishosetaiinido"
            + ".ITaishoSetaiinIdoMapper.対象世帯員クラスTempに更新");
    private static final RString TABLE_NAME = new RString("TaishoSetaiin");
    private static final RString 異動分 = new RString("0001");
    private static final RString 被保険者番号 = new RString("0002");
    private static final RString 基準収入額適用申請書 = new RString("0001");
    private static final RString 無条件抽出 = new RString("0002");
    private static final RString 課税 = new RString("1");
    private static final RString 非課税 = new RString("2");
    private static final RString 資格区分_1 = new RString("1");
    private static final RString 資格区分_3 = new RString("3");
    private static final RString 第１号被保険者あり = new RString("1");
    private static final RString 第１号被保険者なし = new RString("2");
    private static final Decimal DATA_145 = new Decimal("1450000");
    private static final Decimal DATA_383 = new Decimal("3830000");
    private static final Decimal DATA_520 = new Decimal("5200000");
    private static final RString 出力する = new RString("1");
    private static final RString 出力しない = new RString("2");
    private static final RString DATA_第１号被保険者が存在
            = new RString("世帯内に第１号被保険者が存在しないため、申請書を出力しません");
    private static final RString DATA_非課税のため
            = new RString("世帯課税が非課税のため、申請書を出力しません");
    private static final RString DATA_世帯員が存在しないため申請書
            = new RString("課税所得が145万円以上の世帯員が存在しないため、申請書を出力しません");
    private static final RString DATA_単独世帯
            = new RString("単独世帯で総収入額が383万円以上のため、申請書を出力しません");
    private static final RString DATA_複数世帯
            = new RString("複数世帯で総収入額が520万円以上のため、申請書を出力しません");
    private static final RString DATA_既に発行済み
            = new RString("既に発行済みのため、申請書を出力しません");
    private static final RString DATA_世帯把握基準日が遡
            = new RString("世帯把握基準日が遡っているため、申請書を出力しません");
    private static final int TWO = 2;
    private UpdTaishoSeitaiyinTemp5ProcessParameter parameter;
    private List<TaishoSetaiinEntity> 対象世帯員クラスlist;
    private List<TaishoSetaiinEntity> temp_対象世帯員クラスlist;
    private boolean 世帯課税設定flag;
    private boolean 課税所得設定flag;
    private boolean 世帯出力有無設定flag1;
    private boolean 世帯出力有無設定flag2;
    private boolean 世帯出力有無設定flag3;
    private boolean set対象世帯員flag;
    private Decimal 年金収入;
    private Decimal 合計所得;
    private RString pk_世帯コード;
    private ITaishoSetaiinIdoMapper mapper;

    @BatchWriter
    BatchEntityCreatedTempTableWriter taiShoTableWriter;

    @Override
    protected void initialize() {
        対象世帯員クラスlist = new ArrayList<>();
        temp_対象世帯員クラスlist = new ArrayList<>();
        年金収入 = Decimal.ZERO;
        合計所得 = Decimal.ZERO;
        世帯課税設定flag = true;
        課税所得設定flag = true;
        世帯出力有無設定flag1 = true;
        世帯出力有無設定flag2 = true;
        世帯出力有無設定flag3 = true;
        set対象世帯員flag = true;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        taiShoTableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, TaishoSetaiinEntity.class);
    }

    @Override
    protected void process(TaishoSetaiinEntity t) {
        if (!t.getShotaiCode().equals(pk_世帯コード)
                && !対象世帯員クラスlist.isEmpty()) {
            for (TaishoSetaiinEntity entity : 対象世帯員クラスlist) {
                TaishoSetaiinEntity temp_対象世帯員クラス = extractTaishosha(entity);
                temp_対象世帯員クラスlist.add(temp_対象世帯員クラス);
            }
            for (TaishoSetaiinEntity entity : temp_対象世帯員クラスlist) {
                set総収入額(entity);
                taiShoTableWriter.insert(entity);
            }
            対象世帯員クラスlist.clear();
            temp_対象世帯員クラスlist.clear();
            年金収入 = Decimal.ZERO;
            合計所得 = Decimal.ZERO;
            世帯課税設定flag = true;
            課税所得設定flag = true;
            世帯出力有無設定flag1 = true;
            世帯出力有無設定flag2 = true;
            世帯出力有無設定flag3 = true;
            set対象世帯員flag = true;
        }
        pk_世帯コード = t.getShotaiCode();
        対象世帯員クラスlist.add(t);
    }

    @Override
    protected void afterExecute() {
        if (!対象世帯員クラスlist.isEmpty()) {
            for (TaishoSetaiinEntity entity : 対象世帯員クラスlist) {
                TaishoSetaiinEntity temp_対象世帯員クラス = extractTaishosha(entity);
                temp_対象世帯員クラスlist.add(temp_対象世帯員クラス);
            }
            for (TaishoSetaiinEntity entity : temp_対象世帯員クラスlist) {
                set総収入額(entity);
                taiShoTableWriter.insert(entity);
            }
            対象世帯員クラスlist.clear();
            temp_対象世帯員クラスlist.clear();
        }
    }

    private TaishoSetaiinEntity extractTaishosha(TaishoSetaiinEntity 対象世帯員クラス) {
        RString 抽出条件 = parameter.get抽出条件();
        RString 抽出対象 = parameter.get抽出対象();
        FlexibleDate 世帯員把握基準日 = parameter.get世帯員把握基準日();
        対象世帯員クラス.setSoushuu(Decimal.ZERO);
        TaishoSetaiinEntity temp_対象世帯員クラス = clone(対象世帯員クラス);
        if (異動分.equals(抽出条件) || (被保険者番号.equals(抽出条件) && 基準収入額適用申請書.equals(抽出対象))) {
            世帯課税と課税所得の設定(対象世帯員クラス, temp_対象世帯員クラス);
            世帯出力有無の判定(対象世帯員クラス, temp_対象世帯員クラス);
            世帯出力有無の判定２(対象世帯員クラス, temp_対象世帯員クラス, 世帯員把握基準日);
        } else if (被保険者番号.equals(抽出条件)
                && 無条件抽出.equals(抽出対象)) {
            世帯出力有無の判定(対象世帯員クラス, temp_対象世帯員クラス);
            世帯出力有無の判定２(対象世帯員クラス, temp_対象世帯員クラス, 世帯員把握基準日);
        }

        return temp_対象世帯員クラス;
    }

    private TaishoSetaiinEntity clone(TaishoSetaiinEntity entity) {
        TaishoSetaiinEntity entityClone = new TaishoSetaiinEntity();
        entityClone.setShotaiCode(entity.getShotaiCode());
        entityClone.setShoriNendo(entity.getShoriNendo());
        entityClone.setSetaikazeiKubun(entity.getSetaikazeiKubun());
        entityClone.setKazeiShotokuKubun(entity.getKazeiShotokuKubun());
        entityClone.setSoushuu(entity.getSoushuu());
        entityClone.setMessage(entity.getMessage());
        entityClone.setShuturyokuUmu(entity.getShuturyokuUmu());
        entityClone.setNennshouLess16Num(entity.getNennshouLess16Num());
        entityClone.setNennshouLess16_18Num(entity.getNennshouLess16_18Num());
        entityClone.setRannkuShichosonCode(entity.getRannkuShichosonCode());
        entityClone.setShotaikijunDay(entity.getShotaikijunDay());
        entityClone.setShotaikijunDay2(entity.getShotaikijunDay2());
        entityClone.setKoushinnNo(entity.getKoushinnNo());
        entityClone.setInnjiGirisiamojiKubun(entity.getInnjiGirisiamojiKubun());
        entityClone.setHihokenshaNo(entity.getHihokenshaNo());
        entityClone.setShikibetsuCode(entity.getShikibetsuCode());
        entityClone.setShichosonCode(entity.getShichosonCode());
        entityClone.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
        entityClone.setKazeiKubun(entity.getKazeiKubun());
        entityClone.setKazeiShotokuGaku(entity.getKazeiShotokuGaku());
        entityClone.setKazeiShotokuGakuAfter(entity.getKazeiShotokuGakuAfter());
        entityClone.setNenkinShunyuGaku(entity.getNenkinShunyuGaku());
        entityClone.setSonotanoGoukeiShotokuKingakuGoukei(entity.getSonotanoGoukeiShotokuKingakuGoukei());
        entityClone.setHennshuuZokugaraCode(entity.getHennshuuZokugaraCode());
        entityClone.setAtenaDateDhubetsu_1231(entity.getAtenaDateDhubetsu_1231());
        entityClone.setAtenaDateDhubetsu_kijunDay(entity.getAtenaDateDhubetsu_kijunDay());
        entityClone.setHihokenshaName(entity.getHihokenshaName());
        entityClone.setHihokenshaKana(entity.getHihokenshaKana());
        entityClone.setSex(entity.getSex());
        entityClone.setSeinengappiYMD(entity.getSeinengappiYMD());
        entityClone.setAge(entity.getAge());
        entityClone.setHihokennshaKubun(entity.getHihokennshaKubun());
        entityClone.setJukyuKubun(entity.getJukyuKubun());
        entityClone.setNijiHanteiYokaigoJotaiKubunCode(entity.getNijiHanteiYokaigoJotaiKubunCode());
        entityClone.setNinteiYukoKikanKaishiYMD(entity.getNinteiYukoKikanKaishiYMD());
        entityClone.setNinteiYukoKikanShuryoYMD(entity.getNinteiYukoKikanShuryoYMD());
        entityClone.setTekiyoKaishiYMD(entity.getTekiyoKaishiYMD());
        entityClone.setTekiyoShuryoYMD(entity.getTekiyoShuryoYMD());
        entityClone.setAtenaInnjiKubun(entity.getAtenaInnjiKubun());
        entityClone.setShinnseishoJuusho(entity.getShinnseishoJuusho());
        entityClone.setRennrakusaki(entity.getRennrakusaki());
        entityClone.setOshiraseRennrakusaki(entity.getOshiraseRennrakusaki());
        return entityClone;
    }

    private void 世帯出力有無の判定(TaishoSetaiinEntity 対象世帯員クラス, TaishoSetaiinEntity temp_対象世帯員クラス) {
        temp_対象世帯員クラス.setMessage(RString.EMPTY);
        temp_対象世帯員クラス.setShuturyokuUmu(出力する);
        if (資格区分_1.equals(対象世帯員クラス.getHihokennshaKubun())) {
            if (非課税.equals(対象世帯員クラス.getKazeiKubun())) {
                temp_対象世帯員クラス.setMessage(DATA_非課税のため);
                temp_対象世帯員クラス.setShuturyokuUmu(出力しない);
                世帯出力有無設定flag1 = false;
            } else if (世帯出力有無設定flag1
                    && 第１号被保険者なし.equals(temp_対象世帯員クラス.getKazeiShotokuKubun())) {
                temp_対象世帯員クラス.setMessage(DATA_世帯員が存在しないため申請書);
                temp_対象世帯員クラス.setShuturyokuUmu(出力しない);
                世帯出力有無設定flag2 = false;

            } else if (世帯出力有無設定flag1 && 世帯出力有無設定flag2
                    && 対象世帯員クラスlist.size() == 1 && !(temp_対象世帯員クラス.getSoushuu().compareTo(DATA_383) < 0)) {
                temp_対象世帯員クラス.setMessage(DATA_単独世帯);
                temp_対象世帯員クラス.setShuturyokuUmu(出力しない);
                世帯出力有無設定flag3 = false;
            } else if (世帯出力有無設定flag1 && 世帯出力有無設定flag2 && 世帯出力有無設定flag3
                    && (!(対象世帯員クラスlist.size() < TWO)) && (!(temp_対象世帯員クラス.getSoushuu().compareTo(DATA_520) < 0))) {
                temp_対象世帯員クラス.setMessage(DATA_複数世帯);
                temp_対象世帯員クラス.setShuturyokuUmu(出力しない);
            }
        } else {
            temp_対象世帯員クラス.setMessage(DATA_第１号被保険者が存在);
            temp_対象世帯員クラス.setShuturyokuUmu(出力しない);
        }
    }

    private void 世帯出力有無の判定２(TaishoSetaiinEntity 対象世帯員クラス, TaishoSetaiinEntity temp_対象世帯員クラス, FlexibleDate 世帯員把握基準日) {

        if (出力する.equals(temp_対象世帯員クラス.getShuturyokuUmu())) {
            TaishoSetaiinIdoMybatisParameter mybatiParameter = TaishoSetaiinIdoMybatisParameter
                    .createMybatisParam(対象世帯員クラス.getShotaiCode(), 対象世帯員クラス.getShoriNendo());

            TaishoSetaiinIdoEntity entity = mapper.select管理マスタ(mybatiParameter);
            if (entity == null) {
                temp_対象世帯員クラス.setKoushinnNo(対象世帯員クラス.getKoushinnNo() + 1);
            }
            set対象世帯員(entity, 対象世帯員クラス,
                    temp_対象世帯員クラス, 世帯員把握基準日);

        }
    }

    private void 世帯課税と課税所得の設定(TaishoSetaiinEntity 対象世帯員クラス, TaishoSetaiinEntity temp_対象世帯員クラス) {
        if (課税.equals(対象世帯員クラス.getKazeiKubun())) {
            temp_対象世帯員クラス.setSetaikazeiKubun(課税);
            世帯課税設定flag = false;
        } else if (世帯課税設定flag) {
            temp_対象世帯員クラス.setSetaikazeiKubun(非課税);
        }
        RString rs資格区分 = 対象世帯員クラス.getHihokennshaKubun();
        if ((資格区分_1.equals(rs資格区分) || 資格区分_3.equals(rs資格区分)) && (!(対象世帯員クラス.getKazeiShotokuGakuAfter().compareTo(DATA_145) < 0))) {
            temp_対象世帯員クラス.setKazeiShotokuKubun(第１号被保険者あり);
            課税所得設定flag = false;
        } else if (課税所得設定flag) {
            temp_対象世帯員クラス.setKazeiShotokuKubun(第１号被保険者なし);
        }
        if (資格区分_1.equals(rs資格区分) || 資格区分_3.equals(rs資格区分)) {
            年金収入 = 年金収入.add(対象世帯員クラス.getNenkinShunyuGaku());
        }
        合計所得 = 合計所得.add(対象世帯員クラス.getSonotanoGoukeiShotokuKingakuGoukei());
    }

    private void set総収入額(TaishoSetaiinEntity temp_対象世帯員クラス) {
        temp_対象世帯員クラス.setSoushuu(年金収入.add(合計所得));
    }

    private void set対象世帯員(TaishoSetaiinIdoEntity taishosetaiinidoentity,
            TaishoSetaiinEntity 対象世帯員クラス, TaishoSetaiinEntity temp_対象世帯員クラス,
            FlexibleDate 世帯員把握基準日) {
        if (taishosetaiinidoentity.getShinseishoSakuseiSetaiKijunYMD()
                .isBeforeOrEquals(世帯員把握基準日)) {
            if (set対象世帯員flag
                    && taishosetaiinidoentity.getHihokenshaNo().equals(対象世帯員クラス.getHihokenshaNo())) {
                temp_対象世帯員クラス.setMessage(DATA_既に発行済み);
                temp_対象世帯員クラス.setShuturyokuUmu(出力しない);
            } else {
                temp_対象世帯員クラス.setKoushinnNo(taishosetaiinidoentity.getRirekiNo() + 1);
                set対象世帯員flag = false;
            }
        } else {
            temp_対象世帯員クラス.setMessage(DATA_世帯把握基準日が遡);
            temp_対象世帯員クラス.setShuturyokuUmu(出力しない);
        }
    }
}
