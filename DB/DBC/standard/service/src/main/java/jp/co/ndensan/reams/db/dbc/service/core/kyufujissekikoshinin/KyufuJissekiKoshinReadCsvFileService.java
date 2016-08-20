/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufujissekikoshinin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KyufuJissekiRecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoControlCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvRecordKensuEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin.DbWT1111KyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 給付実績更新結果情報取込のReadCSVFile。
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
public class KyufuJissekiKoshinReadCsvFileService {

    private final RString 入力識別番号_3411 = new RString("3411");
    private final RString 入力識別番号_3421 = new RString("3421");
    private int 件数_H1 = 0;
    private int 件数_D1 = 0;
    private int 件数_DD = 0;
    private int 件数_D2 = 0;
    private int 件数_DC = 0;
    private int 件数_D3 = 0;
    private int 件数_D4 = 0;
    private int 件数_D5 = 0;
    private int 件数_D6 = 0;
    private int 件数_D7 = 0;
    private int 件数_D8 = 0;
    private int 件数_DE = 0;
    private int 件数_T1 = 0;
    private int 件数_D9 = 0;
    private int 件数_DA = 0;
    private int 件数_DB = 0;
    private static final RString 読点 = new RString("、");
    private boolean 組み合わせ不正フラグ = false;
    private RString 組み合わせ不正の備考 = RString.EMPTY;
    private boolean 必須レコードなしフラグ = false;
    private RString 必須レコードなしの備考 = RString.EMPTY;
    private boolean 複数レコード不可フラグ = false;
    private RString 複数レコード不可の備考 = RString.EMPTY;
    private static final RString エラー区分_キー項目不一致 = new RString("01");
    private static final RString エラー区分_レコード構成不正 = new RString("02");
    private static final RString エラー区分_必須レコードなし = new RString("03");
    private static final RString エラー区分_複数レコード不可 = new RString("04");

    private KyufuJissekiKoshinJohoDataEntity dataEntity;
    private KyufuJissekiKoshinJohoCsvRecordKensuEntity recordKensu;

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuJissekiKoshinReadCsvFileService}のインスタンスを返します。
     *
     * @return KyufuJissekiKoshinReadCsvFileService
     */
    public static KyufuJissekiKoshinReadCsvFileService createInstance() {

        return InstanceProvider.create(KyufuJissekiKoshinReadCsvFileService.class);
    }

    /**
     * 給付実績一時TBL登録する
     *
     * @param 連番 int
     * @param recordKensu KyufuJissekiKoshinJohoCsvRecordKensuEntity
     * @param controlEntity KyufuJissekiKoshinJohoControlCSVEntity
     * @param kihonMeisaiOne KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity
     * @param kihonMeisaiTwo KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity
     * @param kougakuKaigoMeisai
     * KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity
     * @param tableWriter IBatchTableWriter
     *
     */
    public void insert給付実績一時TBL(int 連番, KyufuJissekiKoshinJohoCsvRecordKensuEntity recordKensu,
            KyufuJissekiKoshinJohoControlCSVEntity controlEntity,
            KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity kihonMeisaiOne,
            KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity kihonMeisaiTwo,
            KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity kougakuKaigoMeisai, IBatchTableWriter tableWriter) {

        DbWT1111KyufuJissekiEntity temp = new DbWT1111KyufuJissekiEntity();
        if (null != kihonMeisaiOne) {
            temp.setRenban(連番);
            temp.setKokanJohoShikibetsuNo(kihonMeisaiOne.get交換情報識別番号());
            temp.setNyuryokuShikibetsuNo(new NyuryokuShikibetsuNo(kihonMeisaiOne.get入力識別番号()));
            temp.setRecordShubetsuCode(kihonMeisaiOne.getレコード種別コード());
            temp.setKyufuJissekiSakuseiKubunCode(kihonMeisaiOne.get給付実績情報作成区分コード());
            temp.setServiceTeikyoYM(kihonMeisaiOne.getサービス提供年月());
            temp.setKyufuJissekiKubun(kihonMeisaiOne.get給付実績区分コード());
            if (null != kihonMeisaiOne.get事業所番号()) {
                temp.setJigyoshoNo(new JigyoshaNo(kihonMeisaiOne.get事業所番号()));
            } else {
                temp.setJigyoshoNo(JigyoshaNo.EMPTY);
            }
            if (null != kihonMeisaiOne.get整理番号()) {
                temp.setSeiriNo(kihonMeisaiOne.get整理番号());
            } else {
                temp.setSeiriNo(RString.EMPTY);
            }
            temp.setRecordKensuH1(recordKensu.get件数_H1());
            temp.setRecordKensuD1(recordKensu.get件数_D1());
            temp.setRecordKensuDD(recordKensu.get件数_DD());
            temp.setRecordKensuD2(recordKensu.get件数_D2());
            temp.setRecordKensuDC(recordKensu.get件数_DC());
            temp.setRecordKensuD3(recordKensu.get件数_D3());
            temp.setRecordKensuD4(recordKensu.get件数_D4());
            temp.setRecordKensuD5(recordKensu.get件数_D5());
            temp.setRecordKensuD6(recordKensu.get件数_D6());
            temp.setRecordKensuD7(recordKensu.get件数_D7());
            temp.setRecordKensuD8(recordKensu.get件数_D8());
            temp.setRecordKensuDE(recordKensu.get件数_DE());
            temp.setRecordKensuT1(recordKensu.get件数_T1());
            temp.setRecordKensuD9(recordKensu.get件数_D9());
            temp.setRecordKensuDA(recordKensu.get件数_DA());
            temp.setRecordKensuDB(recordKensu.get件数_DB());
            temp.setKeikokuKubunCode(kihonMeisaiOne.get警告区分コード());
            temp.setHokenshaNo(new HokenshaNo(controlEntity.get保険者番号()));
            HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
            Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(controlEntity.get保険者番号()));
            if (hokensha != null) {
                temp.setHokenshaName(hokensha.get保険者名());
            } else {
                temp.setHokenshaName(RString.EMPTY);
            }
            temp.setJigyoshaName(RString.EMPTY);
            temp.setNyuryokuShikibetsuMeisho(RString.EMPTY);
            temp.setState(EntityDataState.Added);
            tableWriter.insert(temp);
        } else if (null != kihonMeisaiTwo) {
            temp.setRenban(連番);
            temp.setKokanJohoShikibetsuNo(kihonMeisaiTwo.get交換情報識別番号());
            temp.setNyuryokuShikibetsuNo(new NyuryokuShikibetsuNo(kihonMeisaiTwo.get入力識別番号()));
            temp.setRecordShubetsuCode(kihonMeisaiTwo.getレコード種別コード());
            temp.setKyufuJissekiSakuseiKubunCode(kihonMeisaiTwo.get給付実績情報作成区分コード());
            temp.setServiceTeikyoYM(kihonMeisaiTwo.getサービス提供年月());
            temp.setKyufuJissekiKubun(kihonMeisaiTwo.get給付実績区分コード());
            if (null != kihonMeisaiTwo.get事業所番号()) {
                temp.setJigyoshoNo(new JigyoshaNo(kihonMeisaiTwo.get事業所番号()));
            } else {
                temp.setJigyoshoNo(JigyoshaNo.EMPTY);
            }
            if (null != kihonMeisaiTwo.get整理番号()) {
                temp.setSeiriNo(kihonMeisaiTwo.get整理番号());
            } else {
                temp.setSeiriNo(RString.EMPTY);
            }
            temp.setRecordKensuH1(recordKensu.get件数_H1());
            temp.setRecordKensuD1(recordKensu.get件数_D1());
            temp.setRecordKensuDD(recordKensu.get件数_DD());
            temp.setRecordKensuD2(recordKensu.get件数_D2());
            temp.setRecordKensuDC(recordKensu.get件数_DC());
            temp.setRecordKensuD3(recordKensu.get件数_D3());
            temp.setRecordKensuD3(recordKensu.get件数_D4());
            temp.setRecordKensuD3(recordKensu.get件数_D5());
            temp.setRecordKensuD6(recordKensu.get件数_D6());
            temp.setRecordKensuD7(recordKensu.get件数_D7());
            temp.setRecordKensuD8(recordKensu.get件数_D8());
            temp.setRecordKensuDE(recordKensu.get件数_DE());
            temp.setRecordKensuT1(recordKensu.get件数_T1());
            temp.setRecordKensuD9(recordKensu.get件数_D9());
            temp.setRecordKensuDA(recordKensu.get件数_DA());
            temp.setRecordKensuDB(recordKensu.get件数_DB());
            temp.setKeikokuKubunCode(kihonMeisaiTwo.get警告区分コード());
            temp.setHokenshaNo(new HokenshaNo(controlEntity.get保険者番号()));
            HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
            Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(controlEntity.get保険者番号()));
            if (hokensha != null) {
                temp.setHokenshaName(hokensha.get保険者名());
            } else {
                temp.setHokenshaName(RString.EMPTY);
            }
            temp.setJigyoshaName(RString.EMPTY);
            temp.setNyuryokuShikibetsuMeisho(RString.EMPTY);
            temp.setState(EntityDataState.Added);
            tableWriter.insert(temp);
        } else if (null != kougakuKaigoMeisai) {
            temp.setRenban(連番);
            temp.setKokanJohoShikibetsuNo(kougakuKaigoMeisai.get交換情報識別番号());

            if (null != kougakuKaigoMeisai.get入力識別番号()) {
                temp.setNyuryokuShikibetsuNo(new NyuryokuShikibetsuNo(kougakuKaigoMeisai.get入力識別番号()));
            } else {
                if (KyufuJissekiRecordShubetsu.介護給付費_高額介護サービス費情報レコード.getコード()
                        .equals(kougakuKaigoMeisai.getレコード種別コード())) {
                    temp.setNyuryokuShikibetsuNo(new NyuryokuShikibetsuNo(入力識別番号_3411));
                } else if (KyufuJissekiRecordShubetsu.総合事業費_高額介護サービス費情報レコード.getコード()
                        .equals(kougakuKaigoMeisai.getレコード種別コード())) {
                    temp.setNyuryokuShikibetsuNo(new NyuryokuShikibetsuNo(入力識別番号_3421));
                }
            }
            temp.setRecordShubetsuCode(kougakuKaigoMeisai.getレコード種別コード());
            temp.setKyufuJissekiSakuseiKubunCode(kougakuKaigoMeisai.get給付実績情報作成区分コード());
            temp.setServiceTeikyoYM(kougakuKaigoMeisai.getサービス提供年月());
            temp.setKyufuJissekiKubun(kougakuKaigoMeisai.get給付実績区分コード());
            temp.setJigyoshoNo(JigyoshaNo.EMPTY);
            temp.setSeiriNo(RString.EMPTY);
            temp.setRecordKensuH1(recordKensu.get件数_H1());
            temp.setRecordKensuD1(recordKensu.get件数_D1());
            temp.setRecordKensuDD(recordKensu.get件数_DD());
            temp.setRecordKensuD2(recordKensu.get件数_D2());
            temp.setRecordKensuDC(recordKensu.get件数_DC());
            temp.setRecordKensuD3(recordKensu.get件数_D3());
            temp.setRecordKensuD3(recordKensu.get件数_D4());
            temp.setRecordKensuD3(recordKensu.get件数_D5());
            temp.setRecordKensuD6(recordKensu.get件数_D6());
            temp.setRecordKensuD7(recordKensu.get件数_D7());
            temp.setRecordKensuD8(recordKensu.get件数_D8());
            temp.setRecordKensuDE(recordKensu.get件数_DE());
            temp.setRecordKensuT1(recordKensu.get件数_T1());
            temp.setRecordKensuD9(recordKensu.get件数_D9());
            temp.setRecordKensuDA(recordKensu.get件数_DA());
            temp.setRecordKensuDB(recordKensu.get件数_DB());
            temp.setKeikokuKubunCode(RString.EMPTY);
            temp.setHokenshaNo(new HokenshaNo(controlEntity.get保険者番号()));
            HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
            Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(controlEntity.get保険者番号()));
            if (hokensha != null) {
                temp.setHokenshaName(hokensha.get保険者名());
            } else {
                temp.setHokenshaName(RString.EMPTY);
            }
            temp.setJigyoshaName(RString.EMPTY);
            temp.setNyuryokuShikibetsuMeisho(RString.EMPTY);
            temp.setState(EntityDataState.Added);
            tableWriter.insert(temp);
        }
    }

    /**
     * 被保険者一時TBL登録する
     *
     * @param 連番 int
     * @param kihonMeisaiOne KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity
     * @param kihonMeisaiTwo KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity
     * @param kougakuKaigoMeisai
     * KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity
     * @param tableWriter IBatchTableWriter
     *
     */
    public void insert被保険者一時TBL(int 連番, KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity kihonMeisaiOne,
            KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity kihonMeisaiTwo,
            KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity kougakuKaigoMeisai, IBatchTableWriter tableWriter) {

        DbWT0001HihokenshaIchijiEntity hihokensha = new DbWT0001HihokenshaIchijiEntity();
        if (null != kihonMeisaiOne) {

            hihokensha.setMeisaiRenban(連番);
            if (!RString.isNullOrEmpty(kihonMeisaiOne.get証記載保険者番号())) {
                hihokensha.setShoHokenshaNo(new ShoKisaiHokenshaNo(kihonMeisaiOne.get証記載保険者番号()));
            }
            if (!RString.isNullOrEmpty(kihonMeisaiOne.get被保険者番号())) {
                hihokensha.setOrgHihokenshaNo(new HihokenshaNo(kihonMeisaiOne.get被保険者番号()));
            }
            if (null != kihonMeisaiOne.getサービス提供年月()) {
                int lastDay = kihonMeisaiOne.getサービス提供年月().getLastDay();
                hihokensha.setServiceTeikyoYmd(new FlexibleDate(kihonMeisaiOne.getサービス提供年月().toDateString()
                        .concat(new RString(lastDay))));
            }
            hihokensha.setOrgHihokenshaKanaShimei(RString.EMPTY);
            hihokensha.setOrgHihokenshaShimei(RString.EMPTY);
            hihokensha.setOldShichosonCode(LasdecCode.EMPTY);
            hihokensha.setHenkanHihokenshaNo(null);
            if (!RString.isNullOrEmpty(kihonMeisaiOne.get被保険者番号())) {
                hihokensha.setHihokenshaNo(new HihokenshaNo(kihonMeisaiOne.get被保険者番号()));
            }
            hihokensha.setShichosonCode(LasdecCode.EMPTY);
            hihokensha.setKannaiKangaiKubun(RString.EMPTY);
            hihokensha.setYubinNo(RString.EMPTY);
            hihokensha.setChoikiCode(RString.EMPTY);
            hihokensha.setGyoseikuCode(RString.EMPTY);
            hihokensha.setGyoseikuMei(RString.EMPTY);
            hihokensha.setJusho(RString.EMPTY);
            hihokensha.setBanchi(RString.EMPTY);
            hihokensha.setKatagaki(RString.EMPTY);
            hihokensha.setKanaMeisho(RString.EMPTY);
            hihokensha.setMeisho(RString.EMPTY);
            hihokensha.setShimei50onKana(RString.EMPTY);
            hihokensha.setShikibetsuCode(ShikibetsuCode.EMPTY);
            hihokensha.setShikakuShutokuYmd(FlexibleDate.EMPTY);
            hihokensha.setShikakuShutokuJiyuCode(RString.EMPTY);
            hihokensha.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
            hihokensha.setShikakuSoshitsuJiyuCode(RString.EMPTY);
            hihokensha.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
            hihokensha.setState(EntityDataState.Added);
            tableWriter.insert(hihokensha);
        } else if (null != kihonMeisaiTwo) {

            hihokensha.setMeisaiRenban(連番);
            if (!RString.isNullOrEmpty(kihonMeisaiTwo.get証記載保険者番号())) {
                hihokensha.setShoHokenshaNo(new ShoKisaiHokenshaNo(kihonMeisaiTwo.get証記載保険者番号()));
            }
            if (!RString.isNullOrEmpty(kihonMeisaiTwo.get被保険者番号())) {
                hihokensha.setOrgHihokenshaNo(new HihokenshaNo(kihonMeisaiTwo.get被保険者番号()));
            }
            if (null != kihonMeisaiTwo.getサービス提供年月()) {
                int lastDay = kihonMeisaiTwo.getサービス提供年月().getLastDay();
                hihokensha.setServiceTeikyoYmd(new FlexibleDate(kihonMeisaiTwo.getサービス提供年月().toDateString()
                        .concat(new RString(lastDay))));
            }
            hihokensha.setOrgHihokenshaKanaShimei(RString.EMPTY);
            hihokensha.setOrgHihokenshaShimei(RString.EMPTY);
            hihokensha.setOldShichosonCode(LasdecCode.EMPTY);
            hihokensha.setHenkanHihokenshaNo(null);
            if (!RString.isNullOrEmpty(kihonMeisaiTwo.get被保険者番号())) {
                hihokensha.setHihokenshaNo(new HihokenshaNo(kihonMeisaiTwo.get被保険者番号()));
            }
            hihokensha.setShichosonCode(LasdecCode.EMPTY);
            hihokensha.setKannaiKangaiKubun(RString.EMPTY);
            hihokensha.setYubinNo(RString.EMPTY);
            hihokensha.setChoikiCode(RString.EMPTY);
            hihokensha.setGyoseikuCode(RString.EMPTY);
            hihokensha.setGyoseikuMei(RString.EMPTY);
            hihokensha.setJusho(RString.EMPTY);
            hihokensha.setBanchi(RString.EMPTY);
            hihokensha.setKatagaki(RString.EMPTY);
            hihokensha.setKanaMeisho(RString.EMPTY);
            hihokensha.setMeisho(RString.EMPTY);
            hihokensha.setShimei50onKana(RString.EMPTY);
            hihokensha.setShikibetsuCode(ShikibetsuCode.EMPTY);
            hihokensha.setShikakuShutokuYmd(FlexibleDate.EMPTY);
            hihokensha.setShikakuShutokuJiyuCode(RString.EMPTY);
            hihokensha.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
            hihokensha.setShikakuSoshitsuJiyuCode(RString.EMPTY);
            hihokensha.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
            hihokensha.setState(EntityDataState.Added);
            tableWriter.insert(hihokensha);
        } else if (null != kougakuKaigoMeisai) {

            hihokensha.setMeisaiRenban(連番);
            if (!RString.isNullOrEmpty(kougakuKaigoMeisai.get証記載保険者番号())) {
                hihokensha.setShoHokenshaNo(new ShoKisaiHokenshaNo(kougakuKaigoMeisai.get証記載保険者番号()));
            }
            if (!RString.isNullOrEmpty(kougakuKaigoMeisai.get被保険者番号())) {
                hihokensha.setOrgHihokenshaNo(new HihokenshaNo(kougakuKaigoMeisai.get被保険者番号()));
            }
            if (null != kougakuKaigoMeisai.getサービス提供年月()) {
                int lastDay = kougakuKaigoMeisai.getサービス提供年月().getLastDay();
                hihokensha.setServiceTeikyoYmd(new FlexibleDate(kougakuKaigoMeisai.getサービス提供年月().toDateString()
                        .concat(new RString(lastDay))));
            }
            hihokensha.setOrgHihokenshaKanaShimei(RString.EMPTY);
            hihokensha.setOrgHihokenshaShimei(RString.EMPTY);
            hihokensha.setOldShichosonCode(LasdecCode.EMPTY);
            hihokensha.setHenkanHihokenshaNo(null);
            if (!RString.isNullOrEmpty(kougakuKaigoMeisai.get被保険者番号())) {
                hihokensha.setHihokenshaNo(new HihokenshaNo(kougakuKaigoMeisai.get被保険者番号()));
            }
            hihokensha.setShichosonCode(LasdecCode.EMPTY);
            hihokensha.setKannaiKangaiKubun(RString.EMPTY);
            hihokensha.setYubinNo(RString.EMPTY);
            hihokensha.setChoikiCode(RString.EMPTY);
            hihokensha.setGyoseikuCode(RString.EMPTY);
            hihokensha.setGyoseikuMei(RString.EMPTY);
            hihokensha.setJusho(RString.EMPTY);
            hihokensha.setBanchi(RString.EMPTY);
            hihokensha.setKatagaki(RString.EMPTY);
            hihokensha.setKanaMeisho(RString.EMPTY);
            hihokensha.setMeisho(RString.EMPTY);
            hihokensha.setShimei50onKana(RString.EMPTY);
            hihokensha.setShikibetsuCode(ShikibetsuCode.EMPTY);
            hihokensha.setShikakuShutokuYmd(FlexibleDate.EMPTY);
            hihokensha.setShikakuShutokuJiyuCode(RString.EMPTY);
            hihokensha.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
            hihokensha.setShikakuSoshitsuJiyuCode(RString.EMPTY);
            hihokensha.setSetaiShuyakuNo(HihokenshaNo.EMPTY);
            hihokensha.setState(EntityDataState.Added);
            tableWriter.insert(hihokensha);
        }
    }

    /**
     * 明細設定する
     *
     * KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity
     *
     * @param kihonMeisaiOneEntity KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity
     * @param kihonMeisaiTwoEntity KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity
     * @param kougakuKaigoMeisaiEntity
     * KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity
     * @param listCsvTaisyogaiMeisaiEntity
     * List<KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity>
     * @param tableWriter IBatchTableWriter
     * @return dataEntity KyufuJissekiKoshinJohoDataEntity
     *
     */
    public KyufuJissekiKoshinJohoDataEntity addMeisai(KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity kihonMeisaiOneEntity,
            KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity kihonMeisaiTwoEntity,
            KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity kougakuKaigoMeisaiEntity,
            List<KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity> listCsvTaisyogaiMeisaiEntity,
            IBatchTableWriter tableWriter) {
        dataEntity = new KyufuJissekiKoshinJohoDataEntity();
        recordKensu = new KyufuJissekiKoshinJohoCsvRecordKensuEntity();
        組み合わせ不正フラグ = false;
        必須レコードなしフラグ = false;
        複数レコード不可フラグ = false;
        組み合わせ不正の備考 = RString.EMPTY;
        必須レコードなしの備考 = RString.EMPTY;
        複数レコード不可の備考 = RString.EMPTY;
        件数_H1 = 0;
        件数_D1 = 0;
        件数_DD = 0;
        件数_D2 = 0;
        件数_DC = 0;
        件数_D3 = 0;
        件数_D4 = 0;
        件数_D5 = 0;
        件数_D6 = 0;
        件数_D7 = 0;
        件数_D8 = 0;
        件数_DE = 0;
        件数_T1 = 0;
        件数_D9 = 0;
        件数_DA = 0;
        件数_DB = 0;
        RString 申請先頭レコードのキー項目値;
        RString 入力識別番号;
        DbWT0002KokuhorenTorikomiErrorEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorEntity();
        if (null != kihonMeisaiOneEntity) {
            件数_H1 = 件数_H1 + 1;
            入力識別番号 = kihonMeisaiOneEntity.get入力識別番号();
            申請先頭レコードのキー項目値 = kihonMeisaiOneEntity.get交換情報識別番号().concat(入力識別番号)
                    .concat(kihonMeisaiOneEntity.get被保険者番号()).concat(kihonMeisaiOneEntity.getサービス提供年月().toDateString())
                    .concat(kihonMeisaiOneEntity.get事業所番号()).concat(kihonMeisaiOneEntity.get整理番号());
            doキー項目値チェック(申請先頭レコードのキー項目値, listCsvTaisyogaiMeisaiEntity, tableWriter);
            if (do件数チェック(入力識別番号)) {
                setレコード件数();
                dataEntity.setRecordNumber(recordKensu);
                dataEntity.setKihonMeisaiOneEntity(kihonMeisaiOneEntity);
                return dataEntity;
            } else {
                errorTempentity.setShoHokanehshaNo(new ShoKisaiHokenshaNo(kihonMeisaiOneEntity.get証記載保険者番号()));
                errorTempentity.setHihokenshaNo(new HihokenshaNo(kihonMeisaiOneEntity.get被保険者番号()));
                errorTempentity.setKey1(kihonMeisaiOneEntity.get交換情報識別番号());
                errorTempentity.setKey2(kihonMeisaiOneEntity.get入力識別番号());
                errorTempentity.setKey3(kihonMeisaiOneEntity.getサービス提供年月().toDateString());
                errorTempentity.setKey4(kihonMeisaiOneEntity.get事業所番号());
                errorTempentity.setKey5(kihonMeisaiOneEntity.get整理番号());
                組み合わせ不正登録(errorTempentity, tableWriter);
                必須レコードなし登録(errorTempentity, tableWriter);
                複数レコード不可登録(errorTempentity, tableWriter);
            }
        } else if (null != kihonMeisaiTwoEntity) {
            件数_H1 = 件数_H1 + 1;
            入力識別番号 = kihonMeisaiTwoEntity.get入力識別番号();
            申請先頭レコードのキー項目値 = kihonMeisaiTwoEntity.get交換情報識別番号().concat(入力識別番号)
                    .concat(kihonMeisaiTwoEntity.get被保険者番号()).concat(kihonMeisaiTwoEntity.getサービス提供年月().toDateString())
                    .concat(kihonMeisaiTwoEntity.get事業所番号()).concat(kihonMeisaiTwoEntity.get整理番号());
            doキー項目値チェック(申請先頭レコードのキー項目値, listCsvTaisyogaiMeisaiEntity, tableWriter);
            if (do件数チェック(入力識別番号)) {
                setレコード件数();
                dataEntity.setRecordNumber(recordKensu);
                dataEntity.setKihonMeisaiTwoEntity(kihonMeisaiTwoEntity);
                return dataEntity;
            } else {
                errorTempentity.setShoHokanehshaNo(new ShoKisaiHokenshaNo(kihonMeisaiTwoEntity.get証記載保険者番号()));
                errorTempentity.setHihokenshaNo(new HihokenshaNo(kihonMeisaiTwoEntity.get被保険者番号()));
                errorTempentity.setKey1(kihonMeisaiTwoEntity.get交換情報識別番号());
                errorTempentity.setKey2(kihonMeisaiTwoEntity.get入力識別番号());
                errorTempentity.setKey3(kihonMeisaiTwoEntity.getサービス提供年月().toDateString());
                errorTempentity.setKey4(kihonMeisaiTwoEntity.get事業所番号());
                errorTempentity.setKey5(kihonMeisaiTwoEntity.get整理番号());
                組み合わせ不正登録(errorTempentity, tableWriter);
                必須レコードなし登録(errorTempentity, tableWriter);
                複数レコード不可登録(errorTempentity, tableWriter);
            }
        } else if (null != kougakuKaigoMeisaiEntity) {
            if (KyufuJissekiRecordShubetsu.介護給付費_高額介護サービス費情報レコード.getコード()
                    .equals(kougakuKaigoMeisaiEntity.getレコード種別コード())) {
                件数_D8 = 件数_D8 + 1;
            } else if (KyufuJissekiRecordShubetsu.総合事業費_高額介護サービス費情報レコード.getコード()
                    .equals(kougakuKaigoMeisaiEntity.getレコード種別コード())) {
                件数_DE = 件数_DE + 1;
            }
            入力識別番号 = kougakuKaigoMeisaiEntity.get入力識別番号();
            申請先頭レコードのキー項目値 = kougakuKaigoMeisaiEntity.get交換情報識別番号().concat(入力識別番号)
                    .concat(kougakuKaigoMeisaiEntity.get被保険者番号()).concat(kougakuKaigoMeisaiEntity.getサービス提供年月().toDateString())
                    .concat(RString.EMPTY).concat(RString.EMPTY);
            doキー項目値チェック(申請先頭レコードのキー項目値, listCsvTaisyogaiMeisaiEntity, tableWriter);
            if (do件数チェック(入力識別番号)) {
                setレコード件数();
                dataEntity.setRecordNumber(recordKensu);
                dataEntity.setKougakuKaigoMeisaiEntity(kougakuKaigoMeisaiEntity);
                return dataEntity;
            } else {
                errorTempentity.setShoHokanehshaNo(new ShoKisaiHokenshaNo(kougakuKaigoMeisaiEntity.get証記載保険者番号()));
                errorTempentity.setHihokenshaNo(new HihokenshaNo(kougakuKaigoMeisaiEntity.get被保険者番号()));
                errorTempentity.setKey1(kougakuKaigoMeisaiEntity.get交換情報識別番号());
                errorTempentity.setKey2(kougakuKaigoMeisaiEntity.get入力識別番号());
                errorTempentity.setKey3(kougakuKaigoMeisaiEntity.getサービス提供年月().toDateString());
                組み合わせ不正登録(errorTempentity, tableWriter);
                必須レコードなし登録(errorTempentity, tableWriter);
                複数レコード不可登録(errorTempentity, tableWriter);
            }
        }
        return null;
    }

    private void 組み合わせ不正登録(DbWT0002KokuhorenTorikomiErrorEntity errorTempentity, IBatchTableWriter tableWriter) {
        if (組み合わせ不正フラグ) {
            errorTempentity.setErrorKubun(エラー区分_レコード構成不正);
            errorTempentity.setBiko(組み合わせ不正の備考.substring(1));
            errorTempentity.setState(EntityDataState.Added);
            tableWriter.insert(errorTempentity);
        }
    }

    private void 必須レコードなし登録(DbWT0002KokuhorenTorikomiErrorEntity errorTempentity, IBatchTableWriter tableWriter) {
        if (必須レコードなしフラグ) {
            errorTempentity.setErrorKubun(エラー区分_必須レコードなし);
            errorTempentity.setBiko(必須レコードなしの備考.substring(1));
            errorTempentity.setState(EntityDataState.Added);
            tableWriter.insert(errorTempentity);
        }
    }

    private void 複数レコード不可登録(DbWT0002KokuhorenTorikomiErrorEntity errorTempentity, IBatchTableWriter tableWriter) {
        if (複数レコード不可フラグ) {
            errorTempentity.setErrorKubun(エラー区分_複数レコード不可);
            errorTempentity.setBiko(複数レコード不可の備考.substring(1));
            errorTempentity.setState(EntityDataState.Added);
            tableWriter.insert(errorTempentity);
        }
    }

    private void doキー項目値チェック(RString 申請先頭レコードのキー項目値,
            List<KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity> listCsvTaisyogaiMeisaiEntity,
            IBatchTableWriter tableWriter) {
        if (null != listCsvTaisyogaiMeisaiEntity && !listCsvTaisyogaiMeisaiEntity.isEmpty()) {
            for (int index = 0; index < listCsvTaisyogaiMeisaiEntity.size(); index++) {
                KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity taisyogaiMeisai = listCsvTaisyogaiMeisaiEntity.get(index);
                RString 申請先頭以外レコードのキー項目値 = taisyogaiMeisai.get交換情報識別番号().concat(taisyogaiMeisai.get入力識別番号())
                        .concat(taisyogaiMeisai.get被保険者番号()).concat(taisyogaiMeisai.getサービス提供年月())
                        .concat(taisyogaiMeisai.get事業所番号()).concat(taisyogaiMeisai.get整理番号());
                if (!申請先頭以外レコードのキー項目値.equals(申請先頭レコードのキー項目値)) {
                    DbWT0002KokuhorenTorikomiErrorEntity errorTempentity = new DbWT0002KokuhorenTorikomiErrorEntity();
                    errorTempentity.setShoHokanehshaNo(new ShoKisaiHokenshaNo(taisyogaiMeisai.get証記載保険者番号()));
                    errorTempentity.setHihokenshaNo(new HihokenshaNo(taisyogaiMeisai.get被保険者番号()));
                    errorTempentity.setKey1(taisyogaiMeisai.get交換情報識別番号());
                    errorTempentity.setKey2(taisyogaiMeisai.get入力識別番号());
                    errorTempentity.setKey3(taisyogaiMeisai.getサービス提供年月());
                    errorTempentity.setKey4(taisyogaiMeisai.get事業所番号());
                    errorTempentity.setKey5(taisyogaiMeisai.get整理番号());
                    errorTempentity.setErrorKubun(エラー区分_キー項目不一致);
                    errorTempentity.setState(EntityDataState.Added);
                    tableWriter.insert(errorTempentity);
                    listCsvTaisyogaiMeisaiEntity.remove(index);
                    index--;
                } else {
                    calcRecordNumber(taisyogaiMeisai);
                }
            }
        }
    }

    private void calcRecordNumber(KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity taisyogaiMeisai) {

        if (KyufuJissekiRecordShubetsu.明細情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_D1 = 件数_D1 + 1;
        } else if (KyufuJissekiRecordShubetsu.明細情報_住所地特例レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_DD = 件数_DD + 1;
        } else if (KyufuJissekiRecordShubetsu.緊急時施設療養情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_D2 = 件数_D2 + 1;
        } else if (KyufuJissekiRecordShubetsu.所定疾患施設療養費等情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_DC = 件数_DC + 1;
        } else if (KyufuJissekiRecordShubetsu.特定診療費_特別療養費情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_D3 = 件数_D3 + 1;
        } else if (KyufuJissekiRecordShubetsu.食事費用情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_D4 = 件数_D4 + 1;
        } else if (KyufuJissekiRecordShubetsu.居宅サービス計画費情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_D5 = 件数_D5 + 1;
        } else if (KyufuJissekiRecordShubetsu.福祉用具販売費情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_D6 = 件数_D6 + 1;
        } else if (KyufuJissekiRecordShubetsu.住宅改修費情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_D7 = 件数_D7 + 1;
        } else if (KyufuJissekiRecordShubetsu.集計情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_T1 = 件数_T1 + 1;
        } else if (KyufuJissekiRecordShubetsu.特定入所者介護サービス費用情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_D9 = 件数_D9 + 1;
        } else if (KyufuJissekiRecordShubetsu.社会福祉法人軽減額情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_DA = 件数_DA + 1;
        } else if (KyufuJissekiRecordShubetsu.ケアマネジメント費情報レコード.getコード().equals(taisyogaiMeisai.getレコード種別コード())) {
            件数_DB = 件数_DB + 1;
        }
    }

    private boolean do件数チェック(RString 入力識別番号) {
        do件数チェック1(入力識別番号);
        do件数チェック2(入力識別番号);
        do件数チェック3(入力識別番号);
        do件数チェック4(入力識別番号);
        do件数チェック5(入力識別番号);
        do件数チェック6(入力識別番号);
        do件数チェック7(入力識別番号);
        do件数チェック8(入力識別番号);
        do件数チェック9(入力識別番号);
        do件数チェック10(入力識別番号);
        do件数チェック11(入力識別番号);
        do件数チェック12(入力識別番号);
        do件数チェック13(入力識別番号);
        do件数チェック14(入力識別番号);
        do件数チェック15(入力識別番号);
        do件数チェック16(入力識別番号);
        do件数チェック17(入力識別番号);
        do件数チェック18(入力識別番号);
        do件数チェック19(入力識別番号);
        do件数チェック20(入力識別番号);
        do件数チェック21(入力識別番号);
        return !組み合わせ不正フラグ && !必須レコードなしフラグ && !複数レコード不可フラグ;
    }

    private void do件数チェック1(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2131_様式第二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7131_様式第二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2132_様式第二の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7132_様式第二の二.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1とDD件数チェック(入力識別番号);
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック2(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2141_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7141_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2142_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7142_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2171_様式第六.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7171_様式第六.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2172_様式第六の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7172_様式第六の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2173_様式第六の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7173_様式第六の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2174_様式第六の四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7174_様式第六の四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2175_様式第六の五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7175_様式第六の五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2176_様式第六の六.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7176_様式第六の六.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2177_様式第六の七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7177_様式第六の七.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック3(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2143_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7143_様式第三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2144_様式第三の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7144_様式第三の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2183_様式第八.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7183_様式第八.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック4(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2151_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7151_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2152_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7152_様式第四.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック5(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2153_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7153_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2154_様式第四の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7154_様式第四の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2193_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7193_様式第九.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック6(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2155_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7155_様式第四.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2156_様式第四の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7156_様式第四の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2194_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7194_様式第九.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック7(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2161_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7161_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2162_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7162_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2163_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7163_様式第五.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック8(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2164_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7164_様式第五.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2165_様式第五の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7165_様式第五の二.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック9(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2181_様式第八.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7181_様式第八.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2182_様式第八.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7182_様式第八.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が2件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック10(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2191_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7191_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2192_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7192_様式第九.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が2件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック11(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._2195_様式第九.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7195_様式第九.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック12(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21A1_様式第十.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._71A1_様式第十.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21A2_様式第十.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._71A2_様式第十.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が2件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック13(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21A3_様式第十.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._71A3_様式第十.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック14(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21B1_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8121_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21B2_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8122_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21B3_様式第七の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8123_様式第七の二.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が0件チェック();
            doD5件数が2件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が1件以上チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック15(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21B4_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8124_様式第七.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21B5_様式第七の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8125_様式第七の二.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が0件チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が1件以上チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック16(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21C1_福祉用具販売費.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21C2_予防用具販売費.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が0件チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック17(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._21D1_住宅改修費.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._21D2_予防住宅改修費.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が0件チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック18(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._3411_高額介護給付費.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._3421_高額介護総合事業.getコード().equals(入力識別番号)) {
            doH1件数が1件以上チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が1件以上チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック19(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._8161_ケアマネジメント.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が1件以上チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が1件以上チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が0件チェック();
        }
    }

    private void do件数チェック20(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._71R1_様式第二の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8171_様式第七の三.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1とDD件数チェック(入力識別番号);
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void do件数チェック21(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._71P1_予防サービス_生活支援サービス.getコード().equals(入力識別番号)) {
            doH1件数が0件チェック();
            doD1件数が0件チェック();
            doDD件数が1件以上チェック();
            doD2件数が1件以上チェック();
            doDC件数が1件以上チェック();
            doD3件数が1件以上チェック();
            doD4件数が1件以上チェック();
            doD5件数が1件以上チェック();
            doD6件数が1件以上チェック();
            doD7件数が1件以上チェック();
            doD8とDE件数チェック(入力識別番号);
            doT1件数が0件チェック();
            doD9件数が1件以上チェック();
            doDA件数が1件以上チェック();
            doDB件数が1件以上チェック();
        }
    }

    private void doH1件数が1件以上チェック() {
        if (件数_H1 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.基本情報レコード.getコード());
        }
    }

    private void doH1件数が0件チェック() {
        if (件数_H1 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.基本情報レコード.getコード());
        }
    }

    private void doD1とDD件数チェック(RString 入力識別番号) {
        if ((KyufuJissekiYoshikiKubun._71R1_様式第二の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._8171_様式第七の三.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2131_様式第二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7131_様式第二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._2132_様式第二の二.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._7132_様式第二の二.getコード().equals(入力識別番号)) && (件数_D1 == 0 && 件数_DD == 0)) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.明細情報レコード.getコード())
                    .concat(読点).concat(KyufuJissekiRecordShubetsu.明細情報_住所地特例レコード.getコード());
        }
    }

    private void doD1件数が1件以上チェック() {
        if (件数_D1 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.明細情報レコード.getコード());
        }
    }

    private void doD1件数が0件チェック() {
        if (件数_D1 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.明細情報レコード.getコード());
        }
    }

    private void doDD件数が1件以上チェック() {
        if (件数_DD >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.明細情報_住所地特例レコード.getコード());
        }
    }

    private void doD2件数が1件以上チェック() {
        if (件数_D2 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.緊急時施設療養情報レコード.getコード());
        }
    }

    private void doDC件数が1件以上チェック() {
        if (件数_DC >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.所定疾患施設療養費等情報レコード.getコード());
        }
    }

    private void doD3件数が1件以上チェック() {
        if (件数_D3 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.特定診療費_特別療養費情報レコード.getコード());
        }
    }

    private void doD4件数が1件以上チェック() {
        if (件数_D4 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.食事費用情報レコード.getコード());
        }
    }

    private void doD4件数が2件以上チェック() {
        if (件数_D4 >= 2) {
            複数レコード不可フラグ = true;
            複数レコード不可の備考 = 複数レコード不可の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.食事費用情報レコード.getコード());
        }

    }

    private void doD5件数が1件以上チェック() {
        if (件数_D5 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.居宅サービス計画費情報レコード.getコード());
        }
    }

    private void doD5件数が0件チェック() {
        if (件数_D5 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.居宅サービス計画費情報レコード.getコード());
        }
    }

    private void doD5件数が2件以上チェック() {
        if (件数_D5 >= 2) {
            複数レコード不可フラグ = true;
            複数レコード不可の備考 = 複数レコード不可の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.居宅サービス計画費情報レコード.getコード());
        }
    }

    private void doD6件数が1件以上チェック() {
        if (件数_D6 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.福祉用具販売費情報レコード.getコード());
        }

    }

    private void doD6件数が0件チェック() {
        if (件数_D6 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.福祉用具販売費情報レコード.getコード());
        }
    }

    private void doD7件数が1件以上チェック() {
        if (件数_D7 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.住宅改修費情報レコード.getコード());
        }

    }

    private void doD7件数が0件チェック() {
        if (件数_D7 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.福祉用具販売費情報レコード.getコード());
        }
    }

    private void doD8とDE件数チェック(RString 入力識別番号) {
        if (KyufuJissekiYoshikiKubun._3411_高額介護給付費.getコード().equals(入力識別番号)
                || KyufuJissekiYoshikiKubun._3421_高額介護総合事業.getコード().equals(入力識別番号)) {
            if (件数_D8 == 0 && 件数_DE == 0) {
                必須レコードなしフラグ = true;
                必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                        .concat(KyufuJissekiRecordShubetsu.介護給付費_高額介護サービス費情報レコード.getコード()).concat(読点)
                        .concat(KyufuJissekiRecordShubetsu.総合事業費_高額介護サービス費情報レコード.getコード());
            }
        } else {
            if (件数_D8 >= 1) {
                組み合わせ不正フラグ = true;
                組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                        .concat(KyufuJissekiRecordShubetsu.介護給付費_高額介護サービス費情報レコード.getコード());
            }
            if (件数_DE >= 1) {
                組み合わせ不正フラグ = true;
                組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                        .concat(KyufuJissekiRecordShubetsu.総合事業費_高額介護サービス費情報レコード.getコード());
            }
        }

    }

    private void doT1件数が1件以上チェック() {
        if (件数_T1 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.集計情報レコード.getコード());
        }
    }

    private void doT1件数が0件チェック() {
        if (件数_T1 == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.集計情報レコード.getコード());
        }
    }

    private void doD9件数が1件以上チェック() {
        if (件数_D9 >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.特定入所者介護サービス費用情報レコード.getコード());
        }
    }

    private void doDA件数が1件以上チェック() {
        if (件数_DA >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.社会福祉法人軽減額情報レコード.getコード());
        }

    }

    private void doDB件数が1件以上チェック() {
        if (件数_DB >= 1) {
            組み合わせ不正フラグ = true;
            組み合わせ不正の備考 = 組み合わせ不正の備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.ケアマネジメント費情報レコード.getコード());
        }
    }

    private void doDB件数が0件チェック() {
        if (件数_DB == 0) {
            必須レコードなしフラグ = true;
            必須レコードなしの備考 = 必須レコードなしの備考.concat(読点)
                    .concat(KyufuJissekiRecordShubetsu.ケアマネジメント費情報レコード.getコード());
        }
    }

    private void setレコード件数() {
        recordKensu.set件数_D1(件数_D1);
        recordKensu.set件数_D2(件数_D2);
        recordKensu.set件数_D3(件数_D3);
        recordKensu.set件数_D4(件数_D4);
        recordKensu.set件数_D5(件数_D5);
        recordKensu.set件数_D6(件数_D6);
        recordKensu.set件数_D7(件数_D7);
        recordKensu.set件数_D8(件数_D8);
        recordKensu.set件数_D9(件数_D9);
        recordKensu.set件数_DA(件数_DA);
        recordKensu.set件数_DB(件数_DB);
        recordKensu.set件数_DC(件数_DC);
        recordKensu.set件数_DD(件数_DD);
        recordKensu.set件数_DE(件数_DE);
        recordKensu.set件数_H1(件数_H1);
        recordKensu.set件数_T1(件数_T1);

    }

}
