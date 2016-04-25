/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.HaiguuJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmengengaku.futangendogakunintei.IFutanGendogakuNinteiShinseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.core.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.setai.ISetaiFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 負担限度額認定申請を管理するクラスです。
 *
 * @reamsid_L DBD-3590-030 huangh
 */
public class FutangendogakuNinteiService {

    private static final int INT_4 = 4;
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
                被保険者番号, FlexibleDate.EMPTY);
        IFutanGendogakuNinteiShinseiMapper mapper = mapperProvider.create(IFutanGendogakuNinteiShinseiMapper.class);
        List<FutanGendogakuNinteiEntity> entityList = mapper.get負担限度額認定申請の情報List(検索条件);
        if (entityList != null && !entityList.isEmpty()) {
            for (FutanGendogakuNinteiEntity entity : entityList) {
                負担限度額認定申請の情報List.add(new FutanGendogakuNintei(entity));
            }
        }
        return 負担限度額認定申請の情報List;

    }

    /**
     * 負担限度額認定申請の情報を取得します。
     *
     * @param 適用日 FlexibleDate
     * @return FlexibleDate
     */
    public FlexibleDate estimate有効期限(FlexibleDate 適用日) {

        if (適用日 == null || 適用日.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        RString 減免期限_特定入所者 = BusinessConfig.get(ConfigNameDBD.減免期限_特定入所者,
                new RDate(適用日.getYearValue(), 適用日.getMonthValue(), 適用日.getDayValue()), SubGyomuCode.DBD介護受給);
        if (null == 減免期限_特定入所者 || 減免期限_特定入所者.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
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
    public RString judge利用者負担段階(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        //TODO QA82160
        return null;
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
        } else if (KyuSochishaKubun.旧措置.getコード().equals(旧措置者区分)) {
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
        } else if (KyuSochishaKubun.負担段階.getコード().equals(旧措置者区分)) {
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
        } else if (KyuSochishaKubun.旧措置.getコード().equals(旧措置者区分)) {
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
        } else if (KyuSochishaKubun.負担段階.getコード().equals(旧措置者区分)) {
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
        } else if (KyuSochishaKubun.旧措置.getコード().equals(旧措置者区分)) {
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
        } else if (KyuSochishaKubun.負担段階.getコード().equals(旧措置者区分)) {
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
        } else if (KyuSochishaKubun.旧措置.getコード().equals(旧措置者区分)) {
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
        } else if (KyuSochishaKubun.負担段階.getコード().equals(旧措置者区分)) {
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
        } else if (KyuSochishaKubun.旧措置.getコード().equals(旧措置者区分)) {
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
        } else if (KyuSochishaKubun.負担段階.getコード().equals(旧措置者区分)) {
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

        FlexibleDate 処理日時 = new FlexibleDate(RDate.getNowDate().toDateString());
        HaiguuJohoEntity haiguuJoho = new HaiguuJohoEntity();
        if (!識別対象.canBe個人()) {
            haiguuJoho.setExists(false);
//            haiguuJoho.set個人(null);
            haiguuJoho.set課税区分(RString.EMPTY);
            haiguuJoho.set現住所と異なる本年1月1日住所(RString.EMPTY);

            return haiguuJoho;
        }

        IKojin 個人 = 識別対象.to個人();

        ISetaiFinder finder = ShikibetsuTaishoService.getSetaiFinder();
        ISetai isetai = finder.find(GyomuCode.DB介護保険,
                個人.get世帯コード(),
                処理日時);

        if (isetai == null) {
            haiguuJoho.setExists(false);
//            haiguuJoho.set個人(null);
            haiguuJoho.set課税区分(RString.EMPTY);
            haiguuJoho.set現住所と異なる本年1月1日住所(RString.EMPTY);

            return haiguuJoho;
        }

        //TODO QA204
        return null;
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
     * @param 適用日 FlexibleDate
     * @return 減免の利用者になれるかどうか
     */
    public boolean is旧措置者(HihokenshaNo 被保険者番号, FlexibleDate 適用日) {
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

        IFutanGendogakuNinteiShinseiMapper mapper = this.mapperProvider.create(IFutanGendogakuNinteiShinseiMapper.class);
        FutanGendogakuNinteiShinseiMapperParameter param = FutanGendogakuNinteiShinseiMapperParameter.createParam(被保険者番号, 適用日);

        List<DbT1006KyokaisoGaitoshaEntity> dbT1006EntityList = mapper.select境界層該当者(param);

        return dbT1006EntityList != null && !dbT1006EntityList.isEmpty();
    }

    private List<RString> 金額リスト作成(
            RString 利用者負担段階,
            RString 金額1,
            RString 金額21,
            RString 金額22,
            RString 金額23,
            RString 金額3) {

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
        return BusinessConfig.get(configName, new RDate(適用日.getYearValue(), 適用日.getMonthValue(), 適用日.getDayValue()), SubGyomuCode.DBD介護受給);
    }
}
