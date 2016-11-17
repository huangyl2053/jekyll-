/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeikakujikosakuseikanri;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3119KyotakuKeikakuJikosakuseiKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3120YoboKeikakuJikoSakuseiKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 給付管理票作成のビジネスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class KyotakuKeikakuJikosakuseiKanriResult {

    private static final RString 値0 = new RString("0");

    /**
     * edit居宅給付計画自己作成管理Entity
     *
     * @param 居宅給付計画自己作成短期入所利用日数entity
     * DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity
     * @param kyoEntity DbT3119KyotakuKeikakuJikosakuseiKanriEntity
     * @param count count
     * @return KyotakuKeikakuJikosakuseiKanriTempEntity tempEntity
     */
    public KyotakuKeikakuJikosakuseiKanriTempEntity edit居宅給付計画自己作成管理Entity1(
            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity 居宅給付計画自己作成短期入所利用日数entity,
            DbT3119KyotakuKeikakuJikosakuseiKanriEntity kyoEntity, int count) {
        KyotakuKeikakuJikosakuseiKanriTempEntity tempEntity = new KyotakuKeikakuJikosakuseiKanriTempEntity();
        tempEntity.setRenban(new Decimal(count + 1));
        tempEntity.setHihokenshaNo(kyoEntity.getHihokenshaNo());
        tempEntity.setTaishoYM(kyoEntity.getTaishoYM());
        tempEntity.setRirekiNo(new RString(String.valueOf(kyoEntity.getRirekiNo())));
        tempEntity.setRiyoYM(kyoEntity.getRiyoYM());
        tempEntity.setKyotakuServiceKubun(kyoEntity.getKyotakuServiceKubun());
        tempEntity.setMeisaiNo(new RString(String.valueOf(kyoEntity.getMeisaiNo())));
        tempEntity.setServiceTeikyoJigyoshaNo(getColumnValue(kyoEntity.getServiceTeikyoJigyoshaNo()));
        tempEntity.setServiceShuruiCode(getColumnValue(kyoEntity.getServiceShuruiCode()));
        tempEntity.setServiceKomokuCode(getColumnValue(kyoEntity.getServiceKomokuCode()));
        tempEntity.setTaniSu(new RString(String.valueOf(kyoEntity.getTaniSu())));
        tempEntity.setKaisu_Nissu(new RString(String.valueOf(kyoEntity.getKaisu_Nissu())));
        tempEntity.setWaribikiGoTekiyoRitsu(getValue(kyoEntity.getWaribikiGoTekiyoRitsu()));
        tempEntity.setWaribikiGoTekiyoTaniSu(new RString(String.valueOf(kyoEntity.getWaribikiGoTekiyoTaniSu())));
        tempEntity.setKyufuTaishoNissu(RString.EMPTY);
        tempEntity.setGoukeiFlag(kyoEntity.getGoukeiFlag());
        tempEntity.setShuruiGendoChokaTaniSuNissu(new RString(String.valueOf(kyoEntity.getShuruiGendoChokaTaniSu_Nissu())));
        tempEntity.setShuruiGendoNaiTaniSuNissu(new RString(String.valueOf(kyoEntity.getShuruiGendoNaiTaniSu_Nissu())));
        tempEntity.setKubunGendoChokaTaniSuNissu(new RString(String.valueOf(kyoEntity.getKubunGendoChokaTaniSu_Nissu())));
        tempEntity.setKubunGendoNaiTaniSuNissu(kyoEntity.getKubunGendoNaiTaniSu_Nissu());
        tempEntity.setTaniSuTanka(new RString(String.valueOf(kyoEntity.getTaniSuTanka())));
        tempEntity.setKyufuRitsu(getValue(kyoEntity.getKyufuRitsu()));
        tempEntity.setKyufuKeikakuTaniSu(kyoEntity.getKyufuKeikakuTaniSu());
        tempEntity.setZenkaiRiyoNissu(new RString(String.valueOf(居宅給付計画自己作成短期入所利用日数entity.getZenkaiRiyoNissu())));
        tempEntity.setKonkaiKeikakuRiyoNissu(new RString(String.valueOf(居宅給付計画自己作成短期入所利用日数entity.getKonkaiKeikakuRiyoNissu())));
        tempEntity.setKoshinKubun(居宅給付計画自己作成短期入所利用日数entity.getKoshinKubun());
        tempEntity.setZanteiKubun(居宅給付計画自己作成短期入所利用日数entity.getZanteiKubun());
        tempEntity.setKoshinYMD(居宅給付計画自己作成短期入所利用日数entity.getKoshinYMD());
        tempEntity.setSofuYM(居宅給付計画自己作成短期入所利用日数entity.getSofuYM());
        tempEntity.setHyojiYokaigoJotaiKubunCode(RString.EMPTY);
        tempEntity.setHyojiShikyuGendoTanisu(Decimal.ZERO);
        tempEntity.setYokaigoJotaiKubunCode(RString.EMPTY);
        tempEntity.setNinteiYukoKikanKaishiYM(FlexibleYearMonth.EMPTY);
        tempEntity.setNinteiYukoKikanShuryoYM(FlexibleYearMonth.EMPTY);
        tempEntity.setShikyuGendoTanisu(Decimal.ZERO);
        tempEntity.setShikyuGendoKaishiYM(FlexibleYearMonth.EMPTY);
        tempEntity.setShikyuGendoShuryoYM(FlexibleYearMonth.EMPTY);
        tempEntity.setTankiYokaigoJotaiKubunCode(RString.EMPTY);
        tempEntity.setTankiSikyuGendoNissu(値0);
        tempEntity.setTankiShikyuGendoKaishiYM(FlexibleYearMonth.EMPTY);
        tempEntity.setTankiShikyuGendoShuryoYM(FlexibleYearMonth.EMPTY);
        tempEntity.setServiceTeikyoJigyoshaName(RString.EMPTY);
        tempEntity.setHokenshaNo(RString.EMPTY);
        tempEntity.setHokenshaName(RString.EMPTY);
        return tempEntity;
    }

    /**
     * edit被保険者entity
     *
     * @param 居宅給付計画自己作成短期入所利用日数entity
     * DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity
     * @param kyoEntity KyotakuKeikakuJikosakuseiKanriTempEntity
     * @param count count
     * @return HihokenshaTempEntity HihokenshaTempEntity
     */
    public HihokenshaTempEntity edit被保険者entity1(
            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity 居宅給付計画自己作成短期入所利用日数entity,
            DbT3119KyotakuKeikakuJikosakuseiKanriEntity kyoEntity, int count) {
        HihokenshaTempEntity hihokenshaTempEntity = new HihokenshaTempEntity();
        Decimal coun = new Decimal(count).add(1);
        hihokenshaTempEntity.setExRenban(coun);
        hihokenshaTempEntity.setExHokenshaNo(RString.EMPTY);
        hihokenshaTempEntity.setExHokenshaName(RString.EMPTY);
        hihokenshaTempEntity.setExShoHokenshaNo(RString.EMPTY);
        hihokenshaTempEntity.setExHihokenshaNo(getColumnValue(kyoEntity.getHihokenshaNo()));
        hihokenshaTempEntity.setExServiceTeikyoYm(居宅給付計画自己作成短期入所利用日数entity.getRiyoYM());
        hihokenshaTempEntity.setHenkanFlag(値0);
        hihokenshaTempEntity.setOldShichosonCode(RString.EMPTY);
        hihokenshaTempEntity.setSofuHihokenshaNo(getColumnValue(kyoEntity.getHihokenshaNo()));
        hihokenshaTempEntity.setShichosonCode(RString.EMPTY);
        hihokenshaTempEntity.setKannaiKangaiKubun(RString.EMPTY);
        hihokenshaTempEntity.setYubinNo(RString.EMPTY);
        hihokenshaTempEntity.setChoikiCode(RString.EMPTY);
        hihokenshaTempEntity.setGyoseikuCode(RString.EMPTY);
        hihokenshaTempEntity.setGyoseikuMei(RString.EMPTY);
        hihokenshaTempEntity.setJusho(RString.EMPTY);
        hihokenshaTempEntity.setBanchi(RString.EMPTY);
        hihokenshaTempEntity.setBanchi(RString.EMPTY);
        hihokenshaTempEntity.setKatagaki(RString.EMPTY);
        hihokenshaTempEntity.setKanaMeisho(RString.EMPTY);
        hihokenshaTempEntity.setShimei50onKana(RString.EMPTY);
        hihokenshaTempEntity.setMeisho(RString.EMPTY);
        hihokenshaTempEntity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        hihokenshaTempEntity.setShikakuShutokuJiyuCode(RString.EMPTY);
        hihokenshaTempEntity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        hihokenshaTempEntity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        hihokenshaTempEntity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        hihokenshaTempEntity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        hihokenshaTempEntity.setSetaiShuyakuNo(RString.EMPTY);
        hihokenshaTempEntity.setSeinenYmd(FlexibleDate.EMPTY);
        hihokenshaTempEntity.setSeibetsuCode(RString.EMPTY);
        hihokenshaTempEntity.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        hihokenshaTempEntity.setShichosonKanyuYmd(FlexibleDate.EMPTY);
        return hihokenshaTempEntity;
    }

    /**
     * edit居宅給付計画自己作成Entity
     *
     * @param 予防給付計画自己作成短期利用日数entity 予防給付計画自己作成短期利用日数entity
     * @param kyoEntity DbT3120YoboKeikakuJikoSakuseiKanriEntity
     * @param count count
     * @return KyotakuKeikakuJikosakuseiKanriTempEntity tempEntity
     */
    public KyotakuKeikakuJikosakuseiKanriTempEntity edit居宅給付計画自己作成Entity2(
            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity 予防給付計画自己作成短期利用日数entity,
            DbT3120YoboKeikakuJikoSakuseiKanriEntity kyoEntity, int count) {
        KyotakuKeikakuJikosakuseiKanriTempEntity tempEntity = new KyotakuKeikakuJikosakuseiKanriTempEntity();
        tempEntity.setRenban(new Decimal(count));
        tempEntity.setHihokenshaNo(kyoEntity.getHihokenshaNo());
        tempEntity.setTaishoYM(kyoEntity.getTaishoYM());
        tempEntity.setRirekiNo(new RString(String.valueOf(kyoEntity.getRirekiNo())));
        tempEntity.setRiyoYM(kyoEntity.getRiyoYM());
        tempEntity.setKyotakuServiceKubun(kyoEntity.getKyotakuServiceKubun());
        tempEntity.setMeisaiNo(new RString(String.valueOf(kyoEntity.getMeisaiNo())));
        tempEntity.setServiceTeikyoJigyoshaNo(getColumnValue(kyoEntity.getServiceTeikyoJigyoshaNo()));
        tempEntity.setServiceShuruiCode(getColumnValue(kyoEntity.getServiceShuruiCode()));
        tempEntity.setServiceKomokuCode(getColumnValue(kyoEntity.getServiceKomokuCode()));
        tempEntity.setTaniSu(new RString(String.valueOf(kyoEntity.getTaniSu())));
        tempEntity.setKaisu_Nissu(new RString(String.valueOf(kyoEntity.getKaisu_Nissu())));
        tempEntity.setWaribikiGoTekiyoRitsu(getValue(kyoEntity.getWaribikiGoTekiyoRitsu()));
        tempEntity.setWaribikiGoTekiyoTaniSu(new RString(String.valueOf(kyoEntity.getWaribikiGoTekiyoTaniSu())));
        tempEntity.setGoukeiFlag(kyoEntity.getGoukeiFlag());
        tempEntity.setShuruiGendoChokaTaniSuNissu(new RString(String.valueOf(kyoEntity.getShuruiGendoChokaTaniSu_Nissu())));
        tempEntity.setShuruiGendoNaiTaniSuNissu(new RString(String.valueOf(kyoEntity.getShuruiGendoNaiTaniSu_Nissu())));
        tempEntity.setKubunGendoChokaTaniSuNissu(new RString(String.valueOf(kyoEntity.getKubunGendoChokaTaniSu_Nissu())));
        tempEntity.setKubunGendoNaiTaniSuNissu(kyoEntity.getKubunGendoNaiTaniSu_Nissu());
        tempEntity.setTaniSuTanka(new RString(String.valueOf(kyoEntity.getTaniSuTanka())));
        tempEntity.setKyufuRitsu(getValue(kyoEntity.getKyufuRitsu()));
        tempEntity.setKyufuKeikakuTaniSu(kyoEntity.getKeikakuTaniSu());
        tempEntity.setZenkaiRiyoNissu(new RString(String.valueOf(予防給付計画自己作成短期利用日数entity.getZenkaiRiyoNissu())));
        tempEntity.setKonkaiKeikakuRiyoNissu(new RString(String.valueOf(予防給付計画自己作成短期利用日数entity.getKonkaiKeikakuRiyoNissu())));
        tempEntity.setZanteiKubun(予防給付計画自己作成短期利用日数entity.getZanteiKubun());
        tempEntity.setKoshinYMD(予防給付計画自己作成短期利用日数entity.getKoshinYMD());
        tempEntity.setKoshinKubun(予防給付計画自己作成短期利用日数entity.getKoshinKubun());
        tempEntity.setSofuYM(予防給付計画自己作成短期利用日数entity.getSofuYM());
        tempEntity.setHyojiYokaigoJotaiKubunCode(RString.EMPTY);
        tempEntity.setHyojiShikyuGendoTanisu(Decimal.ZERO);
        tempEntity.setYokaigoJotaiKubunCode(RString.EMPTY);
        tempEntity.setNinteiYukoKikanKaishiYM(FlexibleYearMonth.EMPTY);
        tempEntity.setNinteiYukoKikanShuryoYM(FlexibleYearMonth.EMPTY);
        tempEntity.setShikyuGendoTanisu(Decimal.ZERO);
        tempEntity.setShikyuGendoKaishiYM(FlexibleYearMonth.EMPTY);
        tempEntity.setShikyuGendoShuryoYM(FlexibleYearMonth.EMPTY);
        tempEntity.setTankiYokaigoJotaiKubunCode(RString.EMPTY);
        tempEntity.setTankiSikyuGendoNissu(値0);
        tempEntity.setTankiShikyuGendoKaishiYM(FlexibleYearMonth.EMPTY);
        tempEntity.setTankiShikyuGendoShuryoYM(FlexibleYearMonth.EMPTY);
        tempEntity.setServiceTeikyoJigyoshaName(RString.EMPTY);
        tempEntity.setHokenshaNo(RString.EMPTY);
        tempEntity.setHokenshaName(RString.EMPTY);
        return tempEntity;
    }

    /**
     * edit被保険entity
     *
     * @param 予防給付計画自己作成短期利用日数entity
     * DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity
     * @param kyoEntity KyotakuKeikakuJikosakuseiKanriTempEntity
     * @param count count
     * @return HihokenshaTempEntity HihokenshaTempEntity
     */
    public HihokenshaTempEntity edit被保険entity2(
            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity 予防給付計画自己作成短期利用日数entity,
            DbT3120YoboKeikakuJikoSakuseiKanriEntity kyoEntity, int count) {
        HihokenshaTempEntity hihokenshaTempEntity = new HihokenshaTempEntity();
        hihokenshaTempEntity.setExRenban(new Decimal(count));
        hihokenshaTempEntity.setExHokenshaNo(RString.EMPTY);
        hihokenshaTempEntity.setExHokenshaName(RString.EMPTY);
        hihokenshaTempEntity.setExShoHokenshaNo(RString.EMPTY);
        hihokenshaTempEntity.setExHihokenshaNo(getColumnValue(kyoEntity.getHihokenshaNo()));
        hihokenshaTempEntity.setExServiceTeikyoYm(予防給付計画自己作成短期利用日数entity.getRiyoYM());
        hihokenshaTempEntity.setHenkanFlag(値0);
        hihokenshaTempEntity.setOldShichosonCode(RString.EMPTY);
        hihokenshaTempEntity.setSofuHihokenshaNo(getColumnValue(kyoEntity.getHihokenshaNo()));
        hihokenshaTempEntity.setShichosonCode(RString.EMPTY);
        hihokenshaTempEntity.setKannaiKangaiKubun(RString.EMPTY);
        hihokenshaTempEntity.setYubinNo(RString.EMPTY);
        hihokenshaTempEntity.setChoikiCode(RString.EMPTY);
        hihokenshaTempEntity.setGyoseikuMei(RString.EMPTY);
        hihokenshaTempEntity.setJusho(RString.EMPTY);
        hihokenshaTempEntity.setBanchi(RString.EMPTY);
        hihokenshaTempEntity.setBanchi(RString.EMPTY);
        hihokenshaTempEntity.setGyoseikuCode(RString.EMPTY);
        hihokenshaTempEntity.setShimei50onKana(RString.EMPTY);
        hihokenshaTempEntity.setShikakuShutokuJiyuCode(RString.EMPTY);
        hihokenshaTempEntity.setKatagaki(RString.EMPTY);
        hihokenshaTempEntity.setKanaMeisho(RString.EMPTY);
        hihokenshaTempEntity.setMeisho(RString.EMPTY);
        hihokenshaTempEntity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        hihokenshaTempEntity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        hihokenshaTempEntity.setShikibetsuCode(ShikibetsuCode.EMPTY);
        hihokenshaTempEntity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        hihokenshaTempEntity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        hihokenshaTempEntity.setSetaiShuyakuNo(RString.EMPTY);
        hihokenshaTempEntity.setSeinenYmd(FlexibleDate.EMPTY);
        hihokenshaTempEntity.setSeibetsuCode(RString.EMPTY);
        hihokenshaTempEntity.setShichosonDattaiYmd(FlexibleDate.EMPTY);
        hihokenshaTempEntity.setShichosonKanyuYmd(FlexibleDate.EMPTY);
        return hihokenshaTempEntity;
    }

    /**
     * edit処理結果リスト一時TBL 送付対象なし
     *
     * @return KokuhorenSakuseiErrorTempEntity
     */
    public KokuhorenSakuseiErrorTempEntity edit処理結果リスト一時TBL() {
        KokuhorenSakuseiErrorTempEntity errorEntity = new KokuhorenSakuseiErrorTempEntity();
        errorEntity.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        errorEntity.setShoHokanehshaNo(RString.EMPTY);
        errorEntity.setHihokenshaNo(RString.EMPTY);
        errorEntity.setKey1(RString.EMPTY);
        errorEntity.setKey2(RString.EMPTY);
        errorEntity.setKey3(RString.EMPTY);
        errorEntity.setKey4(RString.EMPTY);
        errorEntity.setKey5(RString.EMPTY);
        errorEntity.setHihokenshaKanaShimei(RString.EMPTY);
        errorEntity.setHihokenshaShimei(RString.EMPTY);
        errorEntity.setBiko(RString.EMPTY);
        return errorEntity;

    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

    private RString getValue(HokenKyufuRitsu entity) {
        if (null != entity) {
            return new RString(entity.value().toString());
        }
        return RString.EMPTY;
    }

    /**
     * 帳票分類ID「DBC200009_KyufuKanrihyoSofuIchiran」（給付管理票送付一覧表）出力順設定可能項目です。
     */
    public enum KyufuKanrihyoSofuEnum implements IReportItems {

        /**
         * 保険者番号
         */
        保険者番号(new RString("0365"), new RString("hokenshaNo"), new RString("\"hokenshaNo\"")),
        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("yubinNo"), new RString("\"yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("choikiCode"), new RString("\"choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("gyoseikuCode"), new RString("\"gyoseikuCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("shimei50onKana"), new RString("\"shimei50onKana\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("\"shichosonCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("hihokenshaNo"), new RString("\"hihokenshaNo\"")),
        /**
         * 利用年月
         */
        利用年月(new RString("0370"), new RString("riyoYM"), new RString("\"riyoYM\"")),
        /**
         * 要介護状態区分
         */
        要介護状態区分(new RString("0369"), new RString("yokaigoJotaiKubunCode"), new RString("\"yokaigoJotaiKubunCode\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private KyufuKanrihyoSofuEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }

    }
}
