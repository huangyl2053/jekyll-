/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.idoriyoshafutanwariaihantei;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.IdoDateTyuushutuKyoutsuuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.idoriyoshafutanwariaihantei.IdoRiyoshaDateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.HanteiTaishoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 判定対象者TempのEditorクラスです。
 *
 * @reamsid_L DBC-4950-033 pengxingyi
 */
public class HanteiTaishoshaTempEditor {

    private final IdoRiyoshaDateEntity 異動データ;
    private final RString 異動種別;
    private final RString 出力条件;
    private final IdoDateTyuushutuKyoutsuuProcessParameter param;

    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final int NUM_1 = 1;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_31 = 31;

    private static final Code 要介護認定状態区分コード_06 = new Code("06");

    /**
     * インスタンスを生成します。
     *
     * @param 異動データ 異動データ
     * @param 異動種別 異動種別
     * @param 出力条件 出力条件
     * @param param param
     */
    public HanteiTaishoshaTempEditor(IdoRiyoshaDateEntity 異動データ, RString 異動種別, RString 出力条件,
            IdoDateTyuushutuKyoutsuuProcessParameter param) {
        this.異動データ = 異動データ;
        this.異動種別 = 異動種別;
        this.出力条件 = 出力条件;
        this.param = param;
    }

    /**
     * 出力データの編集です。
     *
     * @return {@link HanteiTaishoshaTemp}
     */
    public HanteiTaishoshaTempEntity get出力データ() {
        FlexibleDate 対象年度開始YMD = new FlexibleDate(param.get対象年度().getYearValue(), NUM_8, NUM_1);
        FlexibleDate 対象年度終了YMD = new FlexibleDate(param.get対象年度().getYearValue() + NUM_1, NUM_7, NUM_31);
        HanteiTaishoshaTempEntity entity = new HanteiTaishoshaTempEntity();
        entity.setTaishoNendo(param.get対象年度());
        entity.setTaishoKubun(出力条件);
        if (定数_0.equals(出力条件)) {
            entity.setHihokenshaNo(異動データ.get被保険者台帳().getHihokenshaNo());
            entity.setCityCode(RString.EMPTY);
            entity.setRirekiNo(RString.EMPTY);
            entity.setEdaNo(RString.EMPTY);
            entity.setJukyuShinseiJiyu(RString.EMPTY);
            entity.setNinteiYukoKaishiDate(FlexibleDate.EMPTY);
            entity.setNinteiYukoShuryoDate(FlexibleDate.EMPTY);
            entity.setNinteiDate(FlexibleDate.EMPTY);
            entity.setYoKaigoninteiJoutaiKubunCode(RString.EMPTY);
        } else if (定数_1.equals(出力条件)) {
            entity.setHihokenshaNo(異動データ.get受給者台帳().getHihokenshaNo());
            entity.setCityCode(異動データ.get受給者台帳().getShichosonCode().getColumnValue());
            entity.setRirekiNo(異動データ.get受給者台帳().getRirekiNo());
            entity.setEdaNo(異動データ.get受給者台帳().getEdaban());
            entity.setJukyuShinseiJiyu(異動データ.get受給者台帳().getJukyuShinseiJiyu().getColumnValue());
            if (異動データ.get受給者台帳().getNinteiYukoKikanKaishiYMD() != null
                    && 対象年度開始YMD.isBefore(異動データ.get受給者台帳().getNinteiYukoKikanKaishiYMD())) {
                entity.setNinteiYukoKaishiDate(異動データ.get受給者台帳().getNinteiYukoKikanKaishiYMD());
            } else {
                entity.setNinteiYukoKaishiDate(対象年度開始YMD);
            }
            entity.setNinteiYukoShuryoDate(対象年度終了YMD);
            entity.setNinteiDate(異動データ.get受給者台帳().getNinteiYMD());
            Code temp = 異動データ.get受給者台帳().getYokaigoJotaiKubunCode();
            if (temp != null) {
                entity.setYoKaigoninteiJoutaiKubunCode(temp.getColumnValue());
            }
            entity.setKyuSochishaFlag(異動データ.get受給者台帳().getKyuSochishaFlag());
        } else if (定数_2.equals(出力条件)) {
            entity.setHihokenshaNo(異動データ.get総合事業対象者().getHihokenshaNo());
            entity.setCityCode(RString.EMPTY);
            entity.setRirekiNo(new RString(異動データ.get総合事業対象者().getRirekiNo()));
            entity.setEdaNo(RString.EMPTY);
            entity.setJukyuShinseiJiyu(RString.EMPTY);
            if (異動データ.get総合事業対象者().getTekiyoKaishiYMD() != null
                    && 対象年度開始YMD.isBefore(異動データ.get総合事業対象者().getTekiyoKaishiYMD())) {
                entity.setNinteiYukoKaishiDate(異動データ.get総合事業対象者().getTekiyoKaishiYMD());
            } else {
                entity.setNinteiYukoKaishiDate(対象年度開始YMD);
            }
            entity.setNinteiYukoShuryoDate(対象年度終了YMD);
            entity.setNinteiDate(異動データ.get総合事業対象者().getChecklistJisshiYMD());
            entity.setYoKaigoninteiJoutaiKubunCode(要介護認定状態区分コード_06.getColumnValue());
        }
        entity.setShikibetsuCode(異動データ.get被保険者台帳().getShikibetsuCode());
        entity.setSetaiCode(異動データ.get世帯コード());
        entity.setIdoShubetsu(get異動種別名(異動種別));
        if (異動データ.get宛名識別対象異動分() != null) {
            entity.setAtenaIdobi(異動データ.get宛名識別対象異動分().getIdoYMD());
            entity.setAtenaIdoJiyu(異動データ.get宛名識別対象異動分().getIdoJiyuCode());
        } else {
            entity.setAtenaIdobi(FlexibleDate.EMPTY);
            entity.setAtenaIdoJiyu(RString.EMPTY);
        }
        entity.setIdobi(異動データ.get被保険者台帳().getIdoYMD());
        entity.setIdoJiyuCode(異動データ.get被保険者台帳().getIdoJiyuCode());
        entity.setShikakuShiyutokiDate(異動データ.get被保険者台帳().getShikakuShutokuYMD());
        entity.setFirstShikakuShiyutokiDate(異動データ.get被保険者台帳().getIchigoShikakuShutokuYMD());
        entity.setHihokenshaKubunCode(異動データ.get被保険者台帳().getHihokennshaKubunCode());
        if (異動データ.get介護所得ビュー() != null) {
            entity.setShotokuNendo(異動データ.get介護所得ビュー().getShotokuNendo());
            entity.setShotokuRirekiNo(new RString(異動データ.get介護所得ビュー().getRirekiNo()));
            entity.setKazeiKubun(異動データ.get介護所得ビュー().getKazeiKubun());
            entity.setKazeiKubunGemmenGo(異動データ.get介護所得ビュー().getKazeiKubunGemmenGo());
            entity.setGokeiShotokuGaku(異動データ.get介護所得ビュー().getGokeiShotokuGaku());
            entity.setNenkiniShunyuGaku(異動データ.get介護所得ビュー().getNenkiniShunyuGaku());
            entity.setNenkiniShotokuGaku(異動データ.get介護所得ビュー().getNenkiniShotokuGaku());
            entity.setKazeiShotokuGaku(異動データ.get介護所得ビュー().getKazeiShotokuGaku());
            entity.setGekihenKanwaKubun(異動データ.get介護所得ビュー().getGekihenKanwaKubun());
        }
        return entity;
    }

    private RString get異動種別名(RString 異動種別) {
        if (定数_0.equals(出力条件)) {
            return RString.EMPTY;
        }
        return 異動種別;
    }
}
