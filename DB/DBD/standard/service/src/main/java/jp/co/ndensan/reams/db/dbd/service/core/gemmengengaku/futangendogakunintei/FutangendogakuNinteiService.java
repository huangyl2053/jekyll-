/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.HaiguuJohoEntity;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.HaigushaKazeiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.futangendogakunintei.IFutanGendogakuNinteiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1006KyokaisoGaitoshaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.setai.ISetaiFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 負担限度額認定申請を管理するクラスです。
 *
 * @reamsid_L DBD-3590-030 huangh
 */
public class FutangendogakuNinteiService {

    private static final int INT_4 = 4;
    private static final long LONG_80000 = 800000L;
    private static final FlexibleDate 基準日_2015年4月1日 = new FlexibleDate("20150401");
    private static final FlexibleDate 基準日_2012年4月1日 = new FlexibleDate("20120401");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    FutangendogakuNinteiService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     */
    FutangendogakuNinteiService(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FutangendogakuNinteiService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FutangendogakuNinteiService}のインスタンス
     */
    public static FutangendogakuNinteiService createInstance() {
        return InstanceProvider.create(FutangendogakuNinteiService.class);
    }

    /**
     * 負担限度額認定申請の情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<FutanGendogakuNintei>
     */
    public List<FutanGendogakuNintei> load負担限度額認定申請All(HihokenshaNo 被保険者番号) {

        List<FutanGendogakuNintei> 負担限度額認定申請の情報List = new ArrayList<>();
        FutanGendogakuNinteiShinseiMapperParameter 検索条件 = FutanGendogakuNinteiShinseiMapperParameter.createParam(
                被保険者番号, GemmenGengakuShurui.負担限度額認定.getコード());
        IFutanGendogakuNinteiMapper mapper = mapperProvider.create(IFutanGendogakuNinteiMapper.class);
        List<FutanGendogakuNinteiEntity> entityList = mapper.get負担限度額認定申請の情報List(検索条件);
        if (entityList != null && !entityList.isEmpty()) {
            for (FutanGendogakuNinteiEntity entity : entityList) {
                entity.initializeMd5ToEntities();
                負担限度額認定申請の情報List.add(new FutanGendogakuNintei(entity));
            }
        }
        return 負担限度額認定申請の情報List;
    }

    /**
     * 標準有効期限判定します。
     *
     * @param 適用日 FlexibleDate
     * @return FlexibleDate
     */
    public FlexibleDate estimate有効期限(FlexibleDate 適用日) {

        if (適用日 == null || 適用日.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        RString 減免期限_特定入所者 = DbBusinessConfig.get(ConfigNameDBD.減免期限_特定入所者,
                new RDate(適用日.getYearValue(), 適用日.getMonthValue(), 適用日.getDayValue()), SubGyomuCode.DBD介護受給);
        FlexibleDate 有効期限候補 = new FlexibleDate(
                適用日.getYearValue(),
                Integer.valueOf(減免期限_特定入所者.substring(0, 2).toString()),
                Integer.valueOf(減免期限_特定入所者.substring(2, INT_4).toString()));
        if (適用日.isBeforeOrEquals(有効期限候補)) {
            return 有効期限候補;
        } else {
            return 有効期限候補.plusYear(1);
        }
    }

    /**
     * 利用者負担段階の判定します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @return RString
     */
    public RiyoshaFutanDankai judge利用者負担段階(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        FlexibleDate 処理日 = new FlexibleDate(RDate.getNowDate().toDateString());
        RDateTime 処理日時 = RDate.getNowDateTime();
        SetaiinShotokuJohoFinder fineder = SetaiinShotokuJohoFinder.createInstance();
        List<SetaiinShotoku> 世帯員所得情報リスト = fineder.get世帯員所得情報(識別コード, 処理日.getYear(), new YMDHMS(処理日時));
        for (SetaiinShotoku 世帯員所得情報 : 世帯員所得情報リスト) {
            if (HaigushaKazeiKubun.課税.getコード().equals(世帯員所得情報.get課税区分_住民税減免後())) {
                return RiyoshaFutanDankai.第四段階;
            }
        }
        return 利用者負担段階の再判定(被保険者番号, 識別コード, 世帯員所得情報リスト, 処理日);
    }

    private RiyoshaFutanDankai 利用者負担段階の再判定(
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            List<SetaiinShotoku> 世帯員所得情報リスト,
            FlexibleDate 処理日) {
        DbT7006RoreiFukushiNenkinJukyushaDac dbT7006Dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
        List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbT7006Entity = dbT7006Dac.selectfor老齢福祉年金受給者の判定(識別コード, 処理日);
        if (dbT7006Entity != null && !dbT7006Entity.isEmpty()) {
            return RiyoshaFutanDankai.第一段階;
        }
        SetaiinShotoku 世帯員所得情報 = null;
        for (SetaiinShotoku 世帯員所得 : 世帯員所得情報リスト) {
            if (識別コード.equals(世帯員所得.get識別コード())) {
                世帯員所得情報 = 世帯員所得;
            }
        }
        if (null == 世帯員所得情報) {
            throw new ApplicationException(DbdErrorMessages.利用者負担段階_判定失敗.getMessage());
        }
        Decimal 合計所得金額 = null == 世帯員所得情報.get合計所得金額() ? Decimal.ZERO : 世帯員所得情報.get合計所得金額();
        Decimal 年金収入額 = null == 世帯員所得情報.get年金収入額() ? Decimal.ZERO : 世帯員所得情報.get年金収入額();

        IFutanGendogakuNinteiMapper mapper = mapperProvider.create(IFutanGendogakuNinteiMapper.class);
        RString result金額 = mapper.get非課税年金勘案額(被保険者番号, 処理日.getYear().minusYear(1).toDateString());
        Decimal 非課税年金勘案額 = (null == result金額 || RString.isNullOrEmpty(result金額)) ? Decimal.ZERO : new Decimal(result金額.toString());
        int result = 合計所得金額.add(年金収入額).add(非課税年金勘案額).compareTo(Decimal.valueOf(LONG_80000));
        if (result <= 0) {
            return RiyoshaFutanDankai.第二段階;
        } else {
            return RiyoshaFutanDankai.第三段階;
        }
    }

    /**
     * 食費負担限度額の取得します。
     *
     * @param 旧措置者区分 RString
     * @param 基準日 FlexibleDate
     * @param 利用者負担段階 RString
     * @return List<RString>
     */
    public List<RString> load食費負担限度額候補(RString 旧措置者区分, FlexibleDate 基準日, RString 利用者負担段階) {

        if (旧措置者区分.isEmpty()) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_食費１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_食費２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_食費３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_食費１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_食費２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_食費３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_食費１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_食費２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_食費３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置食費１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置食費２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置食費３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置食費１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置食費２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置食費３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置食費１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置食費２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置食費３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減食費１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減食費２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減食費３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減食費１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減食費２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減食費３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減食費１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減食費２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減食費３, 基準日));
            }
        }
        return new ArrayList<>();
    }

    /**
     * ユニット型個室負担限度額の取得します。
     *
     * @param 旧措置者区分 RString
     * @param 基準日 FlexibleDate
     * @param 利用者負担段階 RString
     * @return List<RString>
     */
    public List<RString> loadユニット型個室負担限度額候補(RString 旧措置者区分, FlexibleDate 基準日, RString 利用者負担段階) {

        if (旧措置者区分.isEmpty()) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型個室３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型個室３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_ユニット型個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_ユニット型個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_ユニット型個室３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型個室３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型個室３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型個室３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型個室３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型個室３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型個室３, 基準日));
            }
        }
        return new ArrayList<>();
    }

    /**
     * ユニット型準個室負担限度額の取得します。
     *
     * @param 旧措置者区分 RString
     * @param 基準日 FlexibleDate
     * @param 利用者負担段階 RString
     * @return List<RString>
     */
    public List<RString> loadユニット型準個室負担限度額候補(RString 旧措置者区分, FlexibleDate 基準日, RString 利用者負担段階) {

        if (旧措置者区分.isEmpty()) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型準個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型準個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_ユニット型準個室３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型準個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型準個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_ユニット型準個室３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_ユニット型準個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_ユニット型準個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_ユニット型準個室３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型準個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型準個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置ユニット型準個室３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型準個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型準個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置ユニット型準個室３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型準個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型準個室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置ユニット型準個室３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型準個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型準個室２の１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型準個室２の２, 基準日),
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減ユニット型準個室３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型準個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型準個室２の１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型準個室２の２, 基準日),
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減ユニット型準個室３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型準個室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型準個室２の１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型準個室２の２, 基準日),
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減ユニット型準個室３, 基準日));
            }
        }
        return new ArrayList<>();
    }

    /**
     * 従来型個室（特養等）負担限度額の取得します。
     *
     * @param 旧措置者区分 RString
     * @param 基準日 FlexibleDate
     * @param 利用者負担段階 RString
     * @return List<RString>
     */
    public List<RString> load従来型個室特養等負担限度額候補(RString 旧措置者区分, FlexibleDate 基準日, RString 利用者負担段階) {

        if (旧措置者区分.isEmpty()) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_従個特養２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_従個特養３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_従個特養２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_従個特養３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_従個特養２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_従個特養３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置従個特養２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置従個特養３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置従個特養２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置従個特養３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置従個特養２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置従個特養３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養２の１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養２の２, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養２の３, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減従個特養３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養２の１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養２の２, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養２の３, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減従個特養３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養２の１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養２の２, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養２の３, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養３, 基準日));
            }
        }
        return new ArrayList<>();
    }

    /**
     * 従来型個室（老健・療養等）負担限度額の取得します。
     *
     * @param 旧措置者区分 RString
     * @param 基準日 FlexibleDate
     * @param 利用者負担段階 RString
     * @return List<RString>
     */
    public List<RString> load従来型個室老健等負担限度額候補(RString 旧措置者区分, FlexibleDate 基準日, RString 利用者負担段階) {

        if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
            return this.金額リスト作成(
                    利用者負担段階,
                    getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_従個老健１, 基準日),
                    getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_従個老健２, 基準日),
                    RString.EMPTY,
                    RString.EMPTY,
                    getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_従個老健３, 基準日));
        } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
            return this.金額リスト作成(
                    利用者負担段階,
                    getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_従個老健１, 基準日),
                    getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_従個老健２, 基準日),
                    RString.EMPTY,
                    RString.EMPTY,
                    getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_従個老健３, 基準日));
        } else {
            return this.金額リスト作成(
                    利用者負担段階,
                    getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_従個老健１, 基準日),
                    getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_従個老健２, 基準日),
                    RString.EMPTY,
                    RString.EMPTY,
                    getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_従個老健３, 基準日));
        }
    }

    /**
     * 多床室負担限度額の取得します。
     *
     * @param 旧措置者区分 RString
     * @param 基準日 FlexibleDate
     * @param 利用者負担段階 RString
     * @return List<RString>
     */
    public List<RString> load多床室負担限度額候補(RString 旧措置者区分, FlexibleDate 基準日, RString 利用者負担段階) {

        if (旧措置者区分.isEmpty()) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_多床室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_多床室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_多床室３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_多床室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_多床室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_多床室３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_多床室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_多床室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_多床室３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置多床室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置多床室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措置多床室３, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置多床室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置多床室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措置多床室３, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置多床室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置多床室２, 基準日),
                        RString.EMPTY,
                        RString.EMPTY,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措置多床室３, 基準日));
            }
        } else if (KyuSochishaKubun.旧措置者実質的負担軽減者.getコード().equals(旧措置者区分)) {
            if (基準日.isBeforeOrEquals(基準日_2015年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減多床室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減多床室２の１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減多床室２の２, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減多床室３, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201504改正_旧措軽減多床室１, 基準日));
            } else if (基準日.isBeforeOrEquals(基準日_2012年4月1日)) {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減多床室１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減多床室２の１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減多床室２の２, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減多床室３, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_201204改正_旧措軽減多床室１, 基準日));
            } else {
                return this.金額リスト作成(
                        利用者負担段階,
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養２の１, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養２の２, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養２の３, 基準日),
                        getBusinessConfig(ConfigNameDBD.特定入所者負担限度額_旧措軽減従個特養３, 基準日));
            }
        }
        return new ArrayList<>();
    }

    /**
     * 配偶者情報取得します。
     *
     * @param 識別対象 IShikibetsuTaisho
     * @return HaiguuJohoEntity
     */
    public HaiguuJohoEntity find配偶者(IShikibetsuTaisho 識別対象) {

        FlexibleDate 処理日 = new FlexibleDate(RDate.getNowDate().toDateString());
        RDateTime 処理日時 = RDate.getNowDateTime();

        HaiguuJohoEntity haiguuJoho = new HaiguuJohoEntity();
        if (!識別対象.canBe個人()) {
            haiguuJoho.setExists(false);
            haiguuJoho.set課税区分(HaigushaKazeiKubun.空白.getコード());
            haiguuJoho.set現住所と異なる本年1月1日住所(RString.EMPTY);
            return haiguuJoho;
        }

        IKojin 個人 = 識別対象.to個人();
        ISetaiFinder finder = ShikibetsuTaishoService.getSetaiFinder();
        ISetai isetai = finder.find(GyomuCode.DB介護保険, 個人.get世帯コード(), 処理日);

        if (isetai == null) {
            haiguuJoho.setExists(false);
            haiguuJoho.set課税区分(HaigushaKazeiKubun.空白.getコード());
            haiguuJoho.set現住所と異なる本年1月1日住所(RString.EMPTY);
            return haiguuJoho;
        }

        IKojin 配偶者情報 = isetai.get配偶者(個人);
        if (配偶者情報 == null) {
            haiguuJoho.setExists(false);
            haiguuJoho.set課税区分(HaigushaKazeiKubun.空白.getコード());
            haiguuJoho.set現住所と異なる本年1月1日住所(RString.EMPTY);
            return haiguuJoho;
        }

        IShikibetsuTaishoGyomuHanteiKey 業務判定キー
                = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先);
        ShikibetsuTaishoSearchKeyBuilder builder = new ShikibetsuTaishoSearchKeyBuilder(業務判定キー);
        builder.set基準日(new FlexibleDate(処理日.getYearValue(), 1, 1));
        builder.set識別コード(配偶者情報.get識別コード());
        IShikibetsuTaishoSearchKey 識別対象検索キー = builder.build();

        List<IKojin> kojinList = ShikibetsuTaishoService.getKojinFinder().get個人s(識別対象検索キー);
        RString 配偶者1月1日住所 = get配偶者1月1日住所(kojinList, 配偶者情報);

        SetaiinShotokuJohoFinder fineder = SetaiinShotokuJohoFinder.createInstance();
        List<SetaiinShotoku> 世帯員所得情報リスト = fineder.get世帯員所得情報(個人.get識別コード(), 処理日.getYear(), new YMDHMS(処理日時));
        for (SetaiinShotoku 世帯員所得情報 : 世帯員所得情報リスト) {
            return 世帯課税かどうかの判定(世帯員所得情報, 配偶者情報, 配偶者1月1日住所);
        }
        // TODO 処理が終了していない場合、以下の配偶者情報を生成して返却し、処理を終了する。
        return null;
    }

    private RString get配偶者1月1日住所(List<IKojin> kojinList, IKojin 配偶者情報) {
        RString 配偶者1月1日住所;
        if (kojinList.isEmpty()) {
            配偶者1月1日住所 = RString.EMPTY;
        } else {
            RString is1月1日時点住所 = kojinList.get(0).get住所().get住所();
            RString 現住所 = 配偶者情報.get住所().get住所();
            if (!is1月1日時点住所.isNullOrEmpty()
                    && is1月1日時点住所.equals(現住所)) {
                配偶者1月1日住所 = is1月1日時点住所;
            } else {
                配偶者1月1日住所 = RString.EMPTY;
            }
        }
        return 配偶者1月1日住所;
    }

    private HaiguuJohoEntity 世帯課税かどうかの判定(SetaiinShotoku 世帯員所得情報, IKojin 配偶者情報, RString 配偶者1月1日住所) {
        HaiguuJohoEntity haiguuJoho = new HaiguuJohoEntity();
        if (世帯員所得情報.get課税区分_住民税減免後().isNullOrEmpty()) {
            haiguuJoho.setExists(true);
            haiguuJoho.set個人(配偶者情報);
            haiguuJoho.set課税区分(HaigushaKazeiKubun.空白.getコード());
            haiguuJoho.set現住所と異なる本年1月1日住所(配偶者1月1日住所);
        } else if (HaigushaKazeiKubun.課税.getコード().equals(世帯員所得情報.get課税区分_住民税減免後())) {
            haiguuJoho.setExists(true);
            haiguuJoho.set個人(配偶者情報);
            haiguuJoho.set課税区分(HaigushaKazeiKubun.課税.getコード());
            haiguuJoho.set現住所と異なる本年1月1日住所(配偶者1月1日住所);
        } else {
            haiguuJoho.setExists(true);
            haiguuJoho.set個人(配偶者情報);
            haiguuJoho.set課税区分(HaigushaKazeiKubun.非課税.getコード());
            haiguuJoho.set現住所と異なる本年1月1日住所(配偶者1月1日住所);
        }
        return haiguuJoho;
    }

    /**
     * 利用者の判断します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 適用日 適用日
     * @return 減免の利用者になれるかどうか
     */
    public boolean canBe利用者(HihokenshaNo 被保険者番号, FlexibleDate 適用日) {
        DbT4001JukyushaDaichoDac dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        List<DbT4001JukyushaDaichoEntity> dbT4001EntityList = dac.selectfor受給者の判定(被保険者番号, 適用日, YukoMukoKubun.無効.getコード());
        return dbT4001EntityList != null && !dbT4001EntityList.isEmpty();
    }

    /**
     * 旧措置者の判断します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return 減免の利用者になれるかどうか
     */
    public boolean is旧措置者(HihokenshaNo 被保険者番号) {
        DbV4001JukyushaDaichoAliveDac dac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
        List<DbV4001JukyushaDaichoEntity> dbV4001EntityList = dac.selectBy被保険者番号(被保険者番号);
        return dbV4001EntityList != null && !dbV4001EntityList.isEmpty();
    }

    /**
     * 境界層の判断します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 適用日 FlexibleDate
     * @return 減免の利用者になれるかどうか
     */
    public boolean is境界層該当者(HihokenshaNo 被保険者番号, FlexibleDate 適用日) {

        DbT1006KyokaisoGaitoshaDac dbT1006Dac = InstanceProvider.create(DbT1006KyokaisoGaitoshaDac.class);
        List<DbT1006KyokaisoGaitoshaEntity> dbT1006EntityList = dbT1006Dac.select境界層該当者(被保険者番号, 適用日);
        return dbT1006EntityList != null && !dbT1006EntityList.isEmpty();
    }

    private List<RString> 金額リスト作成(RString 利用者負担段階, RString 金額1, RString 金額21, RString 金額22, RString 金額23, RString 金額3) {

        List<RString> 金額リスト = new ArrayList<>();

        if (RiyoshaFutanDankai.第一段階.getコード().equals(利用者負担段階)) {
            金額リスト.add(金額1);
        } else if (RiyoshaFutanDankai.第二段階.getコード().equals(利用者負担段階)) {
            金額リスト.add(金額21);
            if (!金額22.isEmpty()) {
                金額リスト.add(金額22);
            }
            if (!金額23.isEmpty()) {
                金額リスト.add(金額23);
            }
        } else if (RiyoshaFutanDankai.第三段階.getコード().equals(利用者負担段階)
                || RiyoshaFutanDankai.課税層第三段階.getコード().equals(利用者負担段階)) {
            金額リスト.add(金額3);
        }

        return 金額リスト;
    }

    private RString getBusinessConfig(ConfigNameDBD configName, FlexibleDate 適用日) {
        return DbBusinessConfig.get(
                configName, new RDate(適用日.getYearValue(), 適用日.getMonthValue(), 適用日.getDayValue()), SubGyomuCode.DBD介護受給);
    }
}
