/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JutakukaishuJizenShinseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjutakukaishu.ShokanJutakuKaishuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei.JutakuKaishuParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei.UpdSyokanbaraiketeJohoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiKey;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.GeifuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3049ShokanJutakuKaishuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishusikyushinsei.IJutakukaishuSikyuShinseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuketteikyufujissekihennsyu.JutakuKaishuKetteiKyufujissekiHennsyuManager;
import jp.co.ndensan.reams.db.dbc.service.core.jyutakukaisyuyichiran.JyutakukaisyuyichiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修費支給申請
 */
public class JutakukaishuSikyuShinseiManager {

    private final MapperProvider mapperProvider;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3038ShokanKihonDac 償還払請求基本Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3049ShokanJutakuKaishuDac 償還払請求住宅改修Dac;

    /**
     * コンストラクタです。
     */
    JutakukaishuSikyuShinseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        this.償還払請求基本Dac = InstanceProvider.create(DbT3038ShokanKihonDac.class);
        this.償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.識別番号管理Dac = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);
        this.償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        this.償還払請求住宅改修Dac = InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JutakukaishuSikyuShinseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JutakukaishuSikyuShinseiManager}のインスタンス
     */
    public static JutakukaishuSikyuShinseiManager createInstance() {

        return InstanceProvider.create(JutakukaishuSikyuShinseiManager.class);
    }

    /**
     * 支給申請一覧取得
     *
     * @param 被保険者番号
     * @return 住宅改修費支給申請情報リスト （List<JutakukaishuSikyuShinseiResult>）
     */
    public List<JutakukaishuSikyuShinseiResult> getShokanShikyuShinseiList(HihokenshaNo 被保険者番号) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("hiHokenshaNo", 被保険者番号);
        IJutakukaishuSikyuShinseiMapper mapper = mapperProvider.create(IJutakukaishuSikyuShinseiMapper.class);
        List<JutakukaishuSikyuShinseiResult> 住宅改修費支給申請情報List = mapper.get住宅改修費支給申請情報(parameter);
        List<JutakukaishuSikyuShinseiResult> 住宅改修費事前申請情報List = mapper.get住宅改修費事前申請情報(parameter);
        if ((住宅改修費支給申請情報List == null || 住宅改修費支給申請情報List.isEmpty())
                && (住宅改修費事前申請情報List == null || 住宅改修費事前申請情報List.isEmpty())) {
            return null;
        }
        List<JutakukaishuSikyuShinseiResult> list = new ArrayList<>();
        if (住宅改修費支給申請情報List != null && !住宅改修費支給申請情報List.isEmpty()) {
            for (JutakukaishuSikyuShinseiResult 住宅改修費支給申請情報 : 住宅改修費支給申請情報List) {
                list.add(住宅改修費支給申請情報);
            }
        }
        if (住宅改修費事前申請情報List != null && !住宅改修費事前申請情報List.isEmpty()) {
            for (JutakukaishuSikyuShinseiResult 住宅改修費事前申請情報 : 住宅改修費事前申請情報List) {
                list.add(住宅改修費事前申請情報);
            }
        }
        Collections.sort(list, new Comparator<JutakukaishuSikyuShinseiResult>() {
            @Override
            public int compare(JutakukaishuSikyuShinseiResult o1, JutakukaishuSikyuShinseiResult o2) {
                int flag = o2.getServiceTeikyoYM().compareTo(o1.getServiceTeikyoYM());
                if (0 == flag) {
                    flag = o2.getShinseiYMD().compareTo(o1.getShinseiYMD());
                    if (0 == flag) {
                        flag = o2.getSeiriNo().compareTo(o1.getSeiriNo());
                    }
                }
                return flag;
            }
        });
        return list;
    }

    /**
     * 事前申請一覧取得
     *
     * @param 被保険者番号
     * @return 住宅改修費事前申請情報リスト　（List<JutakukaishuJizenShinseiResult>）
     */
    public List<JutakukaishuJizenShinseiResult> getShokanJizenShinseiList(HihokenshaNo 被保険者番号) {

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("hiHokenshaNo", 被保険者番号);
        IJutakukaishuSikyuShinseiMapper mapper = mapperProvider.create(IJutakukaishuSikyuShinseiMapper.class);
        List<JutakukaishuJizenShinseiResult> 事前申請一覧List = mapper.get事前申請一覧(parameter);
        if (事前申請一覧List == null || 事前申請一覧List.isEmpty()) {
            return null;
        }
        List<JutakukaishuJizenShinseiResult> list = new ArrayList<>();
        for (JutakukaishuJizenShinseiResult 事前申請一覧 : 事前申請一覧List) {
            list.add(事前申請一覧);
        }
        Collections.sort(list, new Comparator<JutakukaishuJizenShinseiResult>() {
            @Override
            public int compare(JutakukaishuJizenShinseiResult o1, JutakukaishuJizenShinseiResult o2) {
                int flag = o2.getServiceTeikyoYM().compareTo(o1.getServiceTeikyoYM());
                if (0 == flag) {
                    flag = o2.getShinseiYMD().compareTo(o1.getShinseiYMD());
                    if (0 == flag) {
                        flag = o2.getSeiriNo().compareTo(o1.getSeiriNo());
                    }
                }
                return flag;
            }
        });
        return list;
    }

    /**
     * 償還払支給申請情報取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @return ShokanShinsei
     */
    public ShokanShinsei getShokanKihonShinsei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        JutakukaishuSikyuShinseiKey key = JutakukaishuSikyuShinseiKey.createSelectByKeyParam(被保険者番号,
                サービス提供年月, 整理番号);
        IJutakukaishuSikyuShinseiMapper mapper = mapperProvider.create(IJutakukaishuSikyuShinseiMapper.class);
        DbT3034ShokanShinseiEntity entity = mapper.get償還払支給申請(key);
        ShokanShinsei shinsei = new ShokanShinsei(entity);
        return shinsei;
    }

    /**
     * 償還払支給判定結果取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @return ShokanHanteiKekka
     */
    public ShokanHanteiKekka getShokanHanteiKekka(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<DbT3036ShokanHanteiKekkaEntity> entityList
                = 償還払支給判定結果Dac.select償還払支給判定結果(被保険者番号, サービス提供年月, 整理番号);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        ShokanHanteiKekka kekka = new ShokanHanteiKekka(entityList.get(0));
        return kekka;
    }

    /**
     * 償還払請求基本取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @return ShokanKihon
     */
    public ShokanKihon getShokanKihon(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<DbT3038ShokanKihonEntity> entityList
                = 償還払請求基本Dac.selectByKey(被保険者番号, サービス提供年月, 整理番号);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        ShokanKihon kihon = new ShokanKihon(entityList.get(0));
        return kihon;
    }

    /**
     * 償還払請求集計取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return ShokanShukei
     */
    public ShokanShukei getShokanSyukei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号,
            JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        List<DbT3053ShokanShukeiEntity> entityList = 償還払請求集計Dac.selectByKey(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        ShokanShukei shukei = new ShokanShukei(entityList.get(0));
        return shukei;
    }

    /**
     * DB登録
     *
     * @param parameter
     * @return 完了ステータス
     */
    @Transaction
    public boolean saveDBDate(JutakukaishuSikyuShinseiParameter parameter) {

        DbT3034ShokanShinseiEntity dbt3034entity = new DbT3034ShokanShinseiEntity();
        dbt3034entity.setHiHokenshaNo(parameter.get償還払支給申請().get被保険者番号());
        dbt3034entity.setServiceTeikyoYM(parameter.get償還払支給申請().getサービス提供年月());
        dbt3034entity.setSeiriNo(parameter.get償還払支給申請().get整理番号());
        dbt3034entity.setShoKisaiHokenshaNo(parameter.get償還払支給申請().get証記載保険者番号());
        dbt3034entity.setUketsukeYMD(parameter.get償還払支給申請().get受付年月日());
        dbt3034entity.setShinseiYMD(parameter.get償還払支給申請().get申請年月日());
        dbt3034entity.setShinseiRiyu(parameter.get償還払支給申請().get申請理由());
        dbt3034entity.setShinseishaKubun(parameter.get償還払支給申請().get申請者区分());
        dbt3034entity.setShinseishaNameKanji(parameter.get償還払支給申請().get申請者氏名());
        dbt3034entity.setShinseishaNameKana(parameter.get償還払支給申請().get申請者氏名カナ());
        dbt3034entity.setShinseishaYubinNo(parameter.get償還払支給申請().get申請者郵便番号());
        dbt3034entity.setShinseishaAddress(parameter.get償還払支給申請().get申請者住所());
        dbt3034entity.setShinseishaTelNo(parameter.get償還払支給申請().get申請者電話番号());
        dbt3034entity.setShinseiJigyoshaNo(parameter.get償還払支給申請().get申請事業者番号());
        dbt3034entity.setRiyushoSakuseiYMD(parameter.get償還払支給申請().get理由書作成日());
        dbt3034entity.setRiyushoSakuseishaName(parameter.get償還払支給申請().get理由書作成者());
        dbt3034entity.setRiyushoSakuseishaKanaName(parameter.get償還払支給申請().get理由書作成者カナ());
        dbt3034entity.setRiyushoSakuseiJigyoshaNo(parameter.get償還払支給申請().get理由書作成事業者番号());
        dbt3034entity.setShiharaiKingakuTotal(parameter.get償還払支給申請().get支払金額合計());
        dbt3034entity.setHokenTaishoHiyogaku(parameter.get償還払支給申請().get保険対象費用額());
        dbt3034entity.setHokenKyufugaku(parameter.get償還払支給申請().get保険給付額());
        dbt3034entity.setRiyoshaFutangaku(parameter.get償還払支給申請().get利用者負担額());
        dbt3034entity.setShinsaHohoKubun(parameter.get償還払支給申請().get審査方法区分());
        dbt3034entity.setSofuKubun(parameter.get償還払支給申請().get送付区分());
        dbt3034entity.setSofuYM(parameter.get償還払支給申請().get送付年月());
        dbt3034entity.setKokuhorenSaisofuFlag(parameter.get償還払支給申請().is国保連再送付フラグ());
        dbt3034entity.setShiharaiHohoKubunCode(parameter.get償還払支給申請().get支払方法区分コード());
        dbt3034entity.setShiharaiBasho(parameter.get償還払支給申請().get支払場所());
        dbt3034entity.setShiharaiKaishiYMD(parameter.get償還払支給申請().get支払期間開始年月日());
        dbt3034entity.setShiharaiShuryoYMD(parameter.get償還払支給申請().get支払期間終了年月日());
        dbt3034entity.setShiharaiKaishiTime(parameter.get償還払支給申請().get支払窓口開始時間());
        dbt3034entity.setShiharaiShuryoTime(parameter.get償還払支給申請().get支払窓口終了時間());
        dbt3034entity.setKozaID(parameter.get償還払支給申請().get口座ID());
        dbt3034entity.setJuryoininKeiyakuNo(parameter.get償還払支給申請().get受領委任契約番号());
        dbt3034entity.setJutakuShoyusha(parameter.get償還払支給申請().get住宅所有者());
        dbt3034entity.setHihokenshaKankei(parameter.get償還払支給申請().get被保険者との関係());
        dbt3034entity.setYokaigo3DankaiHenko(parameter.get償還払支給申請().is要介護状態３段階変更());
        dbt3034entity.setJutakuJushoHenko(parameter.get償還払支給申請().is住宅住所変更());
        dbt3034entity.setJizenServiceTeikyoYM(parameter.get償還払支給申請().get事前申請サービス提供年月());
        dbt3034entity.setJizenSeiriNo(parameter.get償還払支給申請().get事前申請整理番号());
        dbt3034entity.setKaishuShinseiKubun(parameter.get償還払支給申請().get住宅改修申請区分());
        dbt3034entity.setRyoshuYMD(parameter.get償還払支給申請().get領収年月日());
        dbt3034entity.setState(EntityDataState.Added);
        償還払支給申請Dac.save(dbt3034entity);

        DbT3038ShokanKihonEntity dbt3038entity = new DbT3038ShokanKihonEntity();
        dbt3038entity.setHiHokenshaNo(parameter.get償還払請求基本().get被保険者番号());
        dbt3038entity.setServiceTeikyoYM(parameter.get償還払請求基本().getサービス提供年月());
        dbt3038entity.setSeiriNp(parameter.get償還払請求基本().get整理番号());
        dbt3038entity.setJigyoshaNo(parameter.get償還払請求基本().get事業者番号());
        dbt3038entity.setYoshikiNo(parameter.get償還払請求基本().get様式番号());
        dbt3038entity.setMeisaiNo(parameter.get償還払請求基本().get明細番号());
        dbt3038entity.setHokenKyufuritsu(parameter.get償還払請求基本().get保険給付率());
        dbt3038entity.setServiceTanisu(parameter.get償還払請求基本().getサービス単位数());
        dbt3038entity.setHokenSeikyugaku(parameter.get償還払請求基本().get保険請求額());
        dbt3038entity.setRiyoshaFutangaku(parameter.get償還払請求基本().get利用者負担額());
        dbt3038entity.setState(EntityDataState.Added);
        償還払請求基本Dac.save(dbt3038entity);

        DbT3049ShokanJutakuKaishuEntity dbt3049entity = new DbT3049ShokanJutakuKaishuEntity();
        List<JutakuKaishuParameter> 住宅改修List = parameter.get償還払請求住宅改修().get住宅改修List();
        if (住宅改修List != null && !住宅改修List.isEmpty()) {
            for (JutakuKaishuParameter 住宅改修 : 住宅改修List) {
                dbt3049entity.setHiHokenshaNo(parameter.get償還払請求住宅改修().get被保険者番号());
                dbt3049entity.setServiceTeikyoYM(parameter.get償還払請求住宅改修().getサービス提供年月());
                dbt3049entity.setSeiriNo(parameter.get償還払請求住宅改修().get整理番号());
                dbt3049entity.setJigyoshaNo(parameter.get償還払請求住宅改修().get事業者番号());
                dbt3049entity.setYoshikiNo(parameter.get償還払請求住宅改修().get様式番号());
                dbt3049entity.setMeisaiNo(parameter.get償還払請求住宅改修().get明細番号());
                dbt3049entity.setRenban(住宅改修.get連番());
                dbt3049entity.setServiceCode(住宅改修.getサービスコード());
                dbt3049entity.setJutakuKaishuChakkoYMD(住宅改修.get住宅改修着工年月日());
                dbt3049entity.setJutakuKaishuNaiyo(住宅改修.get住宅改修内容());
                dbt3049entity.setJutakuKaishuJigyoshaName(住宅改修.get住宅改修事業者名());
                dbt3049entity.setJutakuKaishuJutakuAddress(住宅改修.get住宅改修住宅住所());
                dbt3049entity.setKaishuKingaku(住宅改修.get改修金額());
                dbt3049entity.setShinsaHohoKubunCode(parameter.get償還払請求住宅改修().get審査方法区分コード());
                dbt3049entity.setJutakuKaishuKanseiYMD(住宅改修.get住宅改修完成年月日());
                dbt3049entity.setSagakuKingaku(住宅改修.get差額金額());
                dbt3049entity.setJizenServiceTeikyoYM(parameter.get償還払請求住宅改修().get事前申請サービス提供年月());
                dbt3049entity.setJizenSeiriNo(parameter.get償還払請求住宅改修().get事前申請整理番号());
                dbt3049entity.setState(EntityDataState.Added);
                償還払請求住宅改修Dac.save(dbt3049entity);
            }
        }
        DbT3053ShokanShukeiEntity dbt3053entity = new DbT3053ShokanShukeiEntity();
        dbt3053entity.setHiHokenshaNo(parameter.get償還払請求集計().get被保険者番号());
        dbt3053entity.setServiceTeikyoYM(parameter.get償還払請求集計().getサービス提供年月());
        dbt3053entity.setSeiriNo(parameter.get償還払請求集計().get整理番号());
        dbt3053entity.setJigyoshaNo(parameter.get償還払請求集計().get事業者番号());
        dbt3053entity.setYoshikiNo(parameter.get償還払請求集計().get様式番号());
        dbt3053entity.setMeisaiNo(parameter.get償還払請求集計().get明細番号());
        dbt3053entity.setRenban(parameter.get償還払請求集計().get連番());
        dbt3053entity.setServiceShuruiCode(parameter.get償還払請求集計().getサービス種類コード());
        dbt3053entity.setSeikyugaku(parameter.get償還払請求集計().get請求額());
        dbt3053entity.setRiyoshaFutangaku(parameter.get償還払請求集計().get利用者負担額());
        dbt3053entity.setState(EntityDataState.Added);
        償還払請求集計Dac.save(dbt3053entity);

        return true;
    }

    /**
     * DB更新
     *
     * @param parameter
     * @param 画面モード
     * @param kekka
     * @return 完了ステータス
     */
    @Transaction
    public boolean updDBDate(JutakukaishuSikyuShinseiParameter parameter, RString 画面モード,
            ShokanHanteiKekka kekka) {
        RString モード_修正 = new RString("修正");
        RString モード_審査 = new RString("審査");
        RString モード_取消 = new RString("取消");
        DbT3034ShokanShinseiEntity dbt3034entity
                = 償還払支給申請Dac.selectByKey(parameter.get償還払支給申請().get被保険者番号(),
                        parameter.get償還払支給申請().getサービス提供年月(),
                        parameter.get償還払支給申請().get整理番号());
        if (!モード_取消.equals(画面モード)) {
            dbt3034entity.setShoKisaiHokenshaNo(parameter.get償還払支給申請().get証記載保険者番号());
            dbt3034entity.setShinseiYMD(parameter.get償還払支給申請().get申請年月日());
            dbt3034entity.setShinseiRiyu(parameter.get償還払支給申請().get申請理由());
            dbt3034entity.setShinseishaKubun(parameter.get償還払支給申請().get申請者区分());
            dbt3034entity.setShinseishaNameKanji(parameter.get償還払支給申請().get申請者氏名());
            dbt3034entity.setShinseishaNameKana(parameter.get償還払支給申請().get申請者氏名カナ());
            dbt3034entity.setShinseishaYubinNo(parameter.get償還払支給申請().get申請者郵便番号());
            dbt3034entity.setShinseishaAddress(parameter.get償還払支給申請().get申請者住所());
            dbt3034entity.setShinseishaTelNo(parameter.get償還払支給申請().get申請者電話番号());
            dbt3034entity.setShinseiJigyoshaNo(parameter.get償還払支給申請().get申請事業者番号());
            dbt3034entity.setRiyushoSakuseiYMD(parameter.get償還払支給申請().get理由書作成日());
            dbt3034entity.setRiyushoSakuseishaName(parameter.get償還払支給申請().get理由書作成者());
            dbt3034entity.setRiyushoSakuseishaKanaName(parameter.get償還払支給申請().get理由書作成者カナ());
            dbt3034entity.setRiyushoSakuseiJigyoshaNo(parameter.get償還払支給申請().get理由書作成事業者番号());
            dbt3034entity.setShiharaiKingakuTotal(parameter.get償還払支給申請().get支払金額合計());
            dbt3034entity.setHokenTaishoHiyogaku(parameter.get償還払支給申請().get保険対象費用額());
            dbt3034entity.setHokenKyufugaku(parameter.get償還払支給申請().get保険給付額());
            dbt3034entity.setRiyoshaFutangaku(parameter.get償還払支給申請().get利用者負担額());
            dbt3034entity.setSofuYM(parameter.get償還払支給申請().get送付年月());
            dbt3034entity.setKokuhorenSaisofuFlag(parameter.get償還払支給申請().is国保連再送付フラグ());
            dbt3034entity.setShiharaiHohoKubunCode(parameter.get償還払支給申請().get支払方法区分コード());
            dbt3034entity.setShiharaiBasho(parameter.get償還払支給申請().get支払場所());
            dbt3034entity.setShiharaiKaishiYMD(parameter.get償還払支給申請().get支払期間開始年月日());
            dbt3034entity.setShiharaiShuryoYMD(parameter.get償還払支給申請().get支払期間終了年月日());
            dbt3034entity.setShiharaiKaishiTime(parameter.get償還払支給申請().get支払窓口開始時間());
            dbt3034entity.setShiharaiShuryoTime(parameter.get償還払支給申請().get支払窓口終了時間());
            dbt3034entity.setKozaID(parameter.get償還払支給申請().get口座ID());
            dbt3034entity.setJuryoininKeiyakuNo(parameter.get償還払支給申請().get受領委任契約番号());
            dbt3034entity.setJutakuShoyusha(parameter.get償還払支給申請().get住宅所有者());
            dbt3034entity.setHihokenshaKankei(parameter.get償還払支給申請().get被保険者との関係());
            dbt3034entity.setYokaigo3DankaiHenko(parameter.get償還払支給申請().is要介護状態３段階変更());
            dbt3034entity.setJutakuJushoHenko(parameter.get償還払支給申請().is住宅住所変更());
        }
        if (モード_審査.equals(画面モード)) {
            dbt3034entity.setShikyuShinseiShinsaKubun(parameter.get償還払支給申請().get支給申請審査区分());
            dbt3034entity.setShinsaYMD(parameter.get償還払支給申請().get審査年月日());
            dbt3034entity.setShinsaKekka(parameter.get償還払支給申請().get審査結果());
        } else if (モード_取消.equals(画面モード)) {
            dbt3034entity.setKaishuShinseiKubun(parameter.get償還払支給申請().get住宅改修申請区分());
            dbt3034entity.setKaishuShinseiTorikeshijiyuCode(parameter.get償還払支給申請()
                    .get住宅改修申請取消事由コード());
        } else if (モード_修正.equals(画面モード)) {
            dbt3034entity.setRyoshuYMD(parameter.get償還払支給申請().get領収年月日());
        }
        dbt3034entity.setState(EntityDataState.Modified);
        償還払支給申請Dac.save(dbt3034entity);

        if (モード_取消.equals(画面モード)) {
            return true;
        }
        if (モード_審査.equals(画面モード)) {
            DbT3036ShokanHanteiKekkaEntity dbt3036entity = new DbT3036ShokanHanteiKekkaEntity();
            if (kekka == null) {
                dbt3036entity.setHiHokenshaNo(parameter.get償還払支給判定結果().get被保険者番号());
                dbt3036entity.setServiceTeikyoYM(parameter.get償還払支給判定結果().getサービス提供年月());
                dbt3036entity.setSeiriNo(parameter.get償還払支給判定結果().get整理番号());
                dbt3036entity.setShoKisaiHokenshaNo(parameter.get償還払支給判定結果().get証記載保険者番号());
                dbt3036entity.setKetteiYMD(parameter.get償還払支給判定結果().get決定年月日());
                dbt3036entity.setShikyuHushikyuKetteiKubun(parameter.get償還払支給判定結果().get支給決定区分());
                dbt3036entity.setShiharaiKingaku(parameter.get償還払支給判定結果().get支払金額());
                dbt3036entity.setState(EntityDataState.Added);
                償還払支給判定結果Dac.save(dbt3036entity);
            } else {
                dbt3036entity = kekka.toEntity();
                dbt3036entity.setKetteiYMD(parameter.get償還払支給判定結果().get決定年月日());
                dbt3036entity.setShikyuHushikyuKetteiKubun(parameter.get償還払支給判定結果().get支給決定区分());
                dbt3036entity.setShiharaiKingaku(parameter.get償還払支給判定結果().get支払金額());
                dbt3036entity.setState(EntityDataState.Modified);
                償還払支給判定結果Dac.save(dbt3036entity);
            }
        }
        DbT3038ShokanKihonEntity dbt3038entity
                = 償還払請求基本Dac.selectByKey(parameter.get償還払請求基本().get被保険者番号(),
                        parameter.get償還払請求基本().getサービス提供年月(),
                        parameter.get償還払請求基本().get整理番号(),
                        parameter.get償還払請求基本().get事業者番号(),
                        parameter.get償還払請求基本().get様式番号(),
                        parameter.get償還払請求基本().get明細番号());
        dbt3038entity.setHokenKyufuritsu(parameter.get償還払請求基本().get保険給付率());
        dbt3038entity.setServiceTanisu(parameter.get償還払請求基本().getサービス単位数());
        dbt3038entity.setHokenSeikyugaku(parameter.get償還払請求基本().get保険請求額());
        dbt3038entity.setRiyoshaFutangaku(parameter.get償還払請求基本().get利用者負担額());
        dbt3038entity.setState(EntityDataState.Modified);
        償還払請求基本Dac.save(dbt3038entity);

        List<DbT3049ShokanJutakuKaishuEntity> dbt3049List = new ArrayList<>();
        List<JutakuKaishuParameter> 住宅改修List = parameter.get償還払請求住宅改修().get住宅改修List();
        if (住宅改修List != null && !住宅改修List.isEmpty()) {
            for (JutakuKaishuParameter 住宅改修 : 住宅改修List) {
                if (new RString("登録").equals(住宅改修.get状態())) {
                    DbT3049ShokanJutakuKaishuEntity dbt3049entity = new DbT3049ShokanJutakuKaishuEntity();
                    dbt3049entity.setHiHokenshaNo(parameter.get償還払請求住宅改修().get被保険者番号());
                    dbt3049entity.setServiceTeikyoYM(parameter.get償還払請求住宅改修().getサービス提供年月());
                    dbt3049entity.setSeiriNo(parameter.get償還払請求住宅改修().get整理番号());
                    dbt3049entity.setJigyoshaNo(parameter.get償還払請求住宅改修().get事業者番号());
                    dbt3049entity.setYoshikiNo(parameter.get償還払請求住宅改修().get様式番号());
                    dbt3049entity.setMeisaiNo(parameter.get償還払請求住宅改修().get明細番号());
                    dbt3049entity.setRenban(住宅改修.get連番());
                    dbt3049entity.setServiceCode(住宅改修.getサービスコード());
                    dbt3049entity.setJutakuKaishuChakkoYMD(住宅改修.get住宅改修着工年月日());
                    dbt3049entity.setJutakuKaishuNaiyo(住宅改修.get住宅改修内容());
                    dbt3049entity.setJutakuKaishuJigyoshaName(住宅改修.get住宅改修事業者名());
                    dbt3049entity.setJutakuKaishuJutakuAddress(住宅改修.get住宅改修住宅住所());
                    dbt3049entity.setKaishuKingaku(住宅改修.get改修金額());
                    dbt3049entity.setShinsaHohoKubunCode(parameter.get償還払請求住宅改修().get審査方法区分コード());
                    dbt3049entity.setJutakuKaishuKanseiYMD(住宅改修.get住宅改修完成年月日());
                    dbt3049entity.setSagakuKingaku(住宅改修.get差額金額());
                    dbt3049entity.setJizenServiceTeikyoYM(parameter.get償還払請求住宅改修().get事前申請サービス提供年月());
                    dbt3049entity.setJizenSeiriNo(parameter.get償還払請求住宅改修().get事前申請整理番号());
                    dbt3049entity.setState(EntityDataState.Added);
                    償還払請求住宅改修Dac.save(dbt3049entity);
                    DbT3049ShokanJutakuKaishuEntity dbt3049entity1
                            = 償還払請求住宅改修Dac.selectByKey(parameter.get償還払請求住宅改修().get被保険者番号(),
                                    parameter.get償還払請求住宅改修().getサービス提供年月(),
                                    parameter.get償還払請求住宅改修().get整理番号(),
                                    parameter.get償還払請求住宅改修().get事業者番号(),
                                    parameter.get償還払請求住宅改修().get様式番号(),
                                    parameter.get償還払請求住宅改修().get明細番号(),
                                    住宅改修.get連番());
                    dbt3049List.add(dbt3049entity1);
                } else if (new RString("更新").equals(住宅改修.get状態())) {
                    DbT3049ShokanJutakuKaishuEntity dbt3049entity
                            = 償還払請求住宅改修Dac.selectByKey(住宅改修.get被保険者番号(),
                                    住宅改修.getサービス提供年月(),
                                    住宅改修.get整理番号(),
                                    住宅改修.get事業者番号(),
                                    住宅改修.get様式番号(),
                                    住宅改修.get明細番号(),
                                    住宅改修.get連番());
                    dbt3049entity.setJutakuKaishuChakkoYMD(住宅改修.get住宅改修着工年月日());
                    dbt3049entity.setJutakuKaishuNaiyo(住宅改修.get住宅改修内容());
                    dbt3049entity.setJutakuKaishuJigyoshaName(住宅改修.get住宅改修事業者名());
                    dbt3049entity.setJutakuKaishuJutakuAddress(住宅改修.get住宅改修住宅住所());
                    dbt3049entity.setKaishuKingaku(住宅改修.get改修金額());
                    dbt3049entity.setJutakuKaishuKanseiYMD(住宅改修.get住宅改修完成年月日());
                    dbt3049entity.setSagakuKingaku(住宅改修.get差額金額());
                    dbt3049entity.setState(EntityDataState.Modified);
                    償還払請求住宅改修Dac.save(dbt3049entity);
                    DbT3049ShokanJutakuKaishuEntity tmpentity
                            = 償還払請求住宅改修Dac.selectByKey(dbt3049entity.getHiHokenshaNo(),
                                    dbt3049entity.getServiceTeikyoYM(), dbt3049entity.getSeiriNo(),
                                    dbt3049entity.getJigyoshaNo(), dbt3049entity.getYoshikiNo(),
                                    dbt3049entity.getMeisaiNo(), dbt3049entity.getRenban());
                    if (tmpentity != null) {
                        dbt3049List.add(dbt3049entity);
                    }
                } else if (new RString("削除").equals(住宅改修.get状態())) {
                    DbT3049ShokanJutakuKaishuEntity dbt3049entity
                            = 償還払請求住宅改修Dac.selectByKey(住宅改修.get被保険者番号(),
                                    住宅改修.getサービス提供年月(),
                                    住宅改修.get整理番号(),
                                    住宅改修.get事業者番号(),
                                    住宅改修.get様式番号(),
                                    住宅改修.get明細番号(),
                                    住宅改修.get連番());
                    dbt3049entity.setState(EntityDataState.Deleted);
                    償還払請求住宅改修Dac.save(dbt3049entity);
                }
            }
        }
        DbT3053ShokanShukeiEntity dbt3053entity
                = 償還払請求集計Dac.selectByKey(parameter.get償還払請求集計().get被保険者番号(),
                        parameter.get償還払請求集計().getサービス提供年月(),
                        parameter.get償還払請求集計().get整理番号(),
                        parameter.get償還払請求集計().get事業者番号(),
                        parameter.get償還払請求集計().get様式番号(),
                        parameter.get償還払請求集計().get明細番号(),
                        parameter.get償還払請求集計().get連番());
        dbt3053entity.setHiHokenshaNo(parameter.get償還払請求集計().get被保険者番号());
        dbt3053entity.setServiceTeikyoYM(parameter.get償還払請求集計().getサービス提供年月());
        dbt3053entity.setSeiriNo(parameter.get償還払請求集計().get整理番号());
        dbt3053entity.setJigyoshaNo(parameter.get償還払請求集計().get事業者番号());
        dbt3053entity.setYoshikiNo(parameter.get償還払請求集計().get様式番号());
        dbt3053entity.setMeisaiNo(parameter.get償還払請求集計().get明細番号());
        dbt3053entity.setRenban(parameter.get償還払請求集計().get連番());
        dbt3053entity.setSeikyugaku(parameter.get償還払請求集計().get請求額());
        dbt3053entity.setRiyoshaFutangaku(parameter.get償還払請求集計().get利用者負担額());
        if (モード_審査.equals(画面モード)) {
            dbt3053entity.setShinsaYM(parameter.get償還払請求集計().get審査年月());
            dbt3053entity.setShikyuKubunCode(parameter.get償還払請求集計().get支給区分コード());
        }
        dbt3053entity.setState(EntityDataState.Modified);
        償還払請求集計Dac.save(dbt3053entity);
        dbt3053entity = 償還払請求集計Dac.selectByKey(dbt3053entity.getHiHokenshaNo(),
                dbt3053entity.getServiceTeikyoYM(), dbt3053entity.getSeiriNo(),
                dbt3053entity.getJigyoshaNo(), dbt3053entity.getYoshikiNo(),
                dbt3053entity.getMeisaiNo(), dbt3053entity.getRenban());

        if (モード_審査.equals(画面モード)) {
            GeifuEntity kyufuentity = new GeifuEntity();
            kyufuentity.setShikibetsuCode(parameter.get識別コード());
            kyufuentity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
            kyufuentity.setShinsaYM(new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString()));
            kyufuentity.setKyufuSakuseiKubunCode(new RString("1"));
            JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                    = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
            manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049List, dbt3053entity);
        }
        return true;
    }

    /**
     * DB削除
     *
     * @param parameter
     * @param kekka
     * @return 完了ステータス
     */
    @Transaction
    public boolean delDBDate(JutakukaishuSikyuShinseiParameter parameter,
            ShokanHanteiKekka kekka) {

        List<DbT3049ShokanJutakuKaishuEntity> dbt3049List = new ArrayList<>();
        List<JutakuKaishuParameter> 住宅改修List = parameter.get償還払請求住宅改修().get住宅改修List();
        if (住宅改修List != null && !住宅改修List.isEmpty()) {
            for (JutakuKaishuParameter 住宅改修 : 住宅改修List) {
                DbT3049ShokanJutakuKaishuEntity dbt3049entity
                        = 償還払請求住宅改修Dac.selectByKey(住宅改修.get被保険者番号(),
                                住宅改修.getサービス提供年月(),
                                住宅改修.get整理番号(),
                                住宅改修.get事業者番号(),
                                住宅改修.get様式番号(),
                                住宅改修.get明細番号(),
                                住宅改修.get連番());
                dbt3049entity.setState(EntityDataState.Deleted);
                償還払請求住宅改修Dac.save(dbt3049entity);
                dbt3049List.add(dbt3049entity);
            }
        }
        DbT3053ShokanShukeiEntity dbt3053entity
                = 償還払請求集計Dac.selectByKey(parameter.get償還払請求集計().get被保険者番号(),
                        parameter.get償還払請求集計().getサービス提供年月(),
                        parameter.get償還払請求集計().get整理番号(),
                        parameter.get償還払請求集計().get事業者番号(),
                        parameter.get償還払請求集計().get様式番号(),
                        parameter.get償還払請求集計().get明細番号(),
                        parameter.get償還払請求集計().get連番());
        dbt3053entity.setState(EntityDataState.Deleted);
        償還払請求集計Dac.save(dbt3053entity);

        DbT3038ShokanKihonEntity dbt3038entity
                = 償還払請求基本Dac.selectByKey(parameter.get償還払請求基本().get被保険者番号(),
                        parameter.get償還払請求基本().getサービス提供年月(),
                        parameter.get償還払請求基本().get整理番号(),
                        parameter.get償還払請求基本().get事業者番号(),
                        parameter.get償還払請求基本().get様式番号(),
                        parameter.get償還払請求基本().get明細番号());
        dbt3038entity.setState(EntityDataState.Deleted);
        償還払請求基本Dac.save(dbt3038entity);

        if (kekka != null) {
            DbT3036ShokanHanteiKekkaEntity entity = kekka.toEntity();
            entity.setState(EntityDataState.Deleted);
            償還払支給判定結果Dac.save(entity);
        }

        DbT3034ShokanShinseiEntity dbt3034entity
                = 償還払支給申請Dac.selectByKey(parameter.get償還払支給申請().get被保険者番号(),
                        parameter.get償還払支給申請().getサービス提供年月(),
                        parameter.get償還払支給申請().get整理番号());
        dbt3034entity.setState(EntityDataState.Deleted);
        償還払支給申請Dac.save(dbt3034entity);

        GeifuEntity kyufuentity = new GeifuEntity();
        kyufuentity.setShikibetsuCode(parameter.get識別コード());
        kyufuentity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
        kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
        kyufuentity.setKyufuSakuseiKubunCode(new RString("3"));

        if (kekka != null
                && ShikyuFushikyuKubun.支給.getコード().equals(kekka.toEntity().getShikyuHushikyuKetteiKubun())) {
            JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                    = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
            manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049List, dbt3053entity);
        }
        return true;
    }

    /**
     * 償還払決定情報更新
     *
     * @param parameter
     * @param shinsei
     * @return 完了ステータス
     */
    @Transaction
    public boolean updSyokanbaraiketeJoho(UpdSyokanbaraiketeJohoParameter parameter,
            ShokanShinsei shinsei) {

        DbT3034ShokanShinseiEntity dbt3034entity = shinsei.toEntity();
        dbt3034entity.setState(EntityDataState.Modified);
        償還払支給申請Dac.save(dbt3034entity);

        ShokanHanteiKekka kekka = getShokanHanteiKekka(parameter.get被保険者番号(),
                parameter.getサービス提供年月(), parameter.get整理番号());
        DbT3036ShokanHanteiKekkaEntity entity = null;
        if (kekka != null) {
            entity = kekka.toEntity();
        }
        if (entity == null) {
            DbT3036ShokanHanteiKekkaEntity dbt3036entity = new DbT3036ShokanHanteiKekkaEntity();
            dbt3036entity.setHiHokenshaNo(parameter.get償還払支給判定結果().get被保険者番号());
            dbt3036entity.setServiceTeikyoYM(parameter.get償還払支給判定結果().getサービス提供年月());
            dbt3036entity.setSeiriNo(parameter.get償還払支給判定結果().get整理番号());
            dbt3036entity.setKetteiYMD(parameter.get償還払支給判定結果().get決定年月日());
            dbt3036entity.setShikyuHushikyuKetteiKubun(parameter.get償還払支給判定結果().get支給決定区分());
            dbt3036entity.setShiharaiKingaku(parameter.get償還払支給判定結果().get支払金額());
            dbt3036entity.setZenkaiShiharaiKingaku(parameter.get償還払支給判定結果().get前回支払金額());
            dbt3036entity.setSagakuKingakuGokei(parameter.get償還払支給判定結果().get差額金額合計());
            dbt3036entity.setState(EntityDataState.Added);
            償還払支給判定結果Dac.save(dbt3036entity);
        } else {
            entity.setKetteiYMD(parameter.get償還払支給判定結果().get決定年月日());
            entity.setShikyuHushikyuKetteiKubun(parameter.get償還払支給判定結果().get支給決定区分());
            entity.setShiharaiKingaku(parameter.get償還払支給判定結果().get支払金額());
            entity.setSagakuKingakuGokei(parameter.get償還払支給判定結果().get差額金額合計());
            entity.setState(EntityDataState.Modified);
            償還払支給判定結果Dac.save(entity);
        }

        DbT3053ShokanShukeiEntity dbt3053entity
                = 償還払請求集計Dac.selectByKey(parameter.get償還払請求集計().get被保険者番号(),
                        parameter.get償還払請求集計().getサービス提供年月(),
                        parameter.get償還払請求集計().get整理番号(),
                        parameter.get償還払請求集計().get事業者番号(),
                        parameter.get償還払請求集計().get様式番号(),
                        parameter.get償還払請求集計().get明細番号(),
                        parameter.get償還払請求集計().get連番());
        dbt3053entity.setShinsaHohoKubunCode(parameter.get償還払請求集計().get審査方法区分コード());
        dbt3053entity.setShinsaYM(parameter.get償還払請求集計().get審査年月());
        dbt3053entity.setShikyuKubunCode(parameter.get償還払請求集計().get支給区分コード());
        dbt3053entity.setShikyuKingaku(parameter.get償還払請求集計().get支払金額());
        dbt3053entity.setZougenten(parameter.get償還払請求集計().get増減点());
        dbt3053entity.setSeikyugakuSagakuKingaku(parameter.get償還払請求集計().get請求額差額金額());
        dbt3053entity.setZougenRiyu(parameter.get償還払請求集計().get増減理由等());
        dbt3053entity.setHushikyuRiyu(parameter.get償還払請求集計().get不支給理由等());
        dbt3053entity.setKounyuKaishuRireki(parameter.get償還払請求集計().get購入改修履歴等());
        dbt3053entity.setState(EntityDataState.Modified);
        償還払請求集計Dac.save(dbt3053entity);
        dbt3053entity = 償還払請求集計Dac.selectByKey(dbt3053entity.getHiHokenshaNo(),
                dbt3053entity.getServiceTeikyoYM(), dbt3053entity.getSeiriNo(),
                dbt3053entity.getJigyoshaNo(), dbt3053entity.getYoshikiNo(),
                dbt3053entity.getMeisaiNo(), dbt3053entity.getRenban());

        GeifuEntity kyufuentity = new GeifuEntity();
        kyufuentity.setShikibetsuCode(parameter.get識別コード());
        kyufuentity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
        RString 不支給 = ShikyuFushikyuKubun.不支給.getコード();
        RString 支給 = ShikyuFushikyuKubun.支給.getコード();
        if (entity == null) {
            if (支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(new RString("1"));
            }
        } else {
            if (不支給.equals(entity.getShikyuHushikyuKetteiKubun()) && 支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(new RString("1"));
            } else if (支給.equals(entity.getShikyuHushikyuKetteiKubun()) && 不支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(new RString("3"));
            } else if (支給.equals(entity.getShikyuHushikyuKetteiKubun()) && 支給.equals(parameter.get支給区分())) {
                kyufuentity.setShinsaYM(parameter.get決定日().getYearMonth());
                kyufuentity.setKyufuSakuseiKubunCode(new RString("2"));
            }
        }

        List<DbT3049ShokanJutakuKaishuEntity> dbt3049List = new ArrayList<>();
        JyutakukaisyuyichiranFinder finder = JyutakukaisyuyichiranFinder.createInstance();
        SearchResult<ShokanJutakuKaishuBusiness> tmpList
                = finder.selectJyutakukaisyuList(parameter.get被保険者番号(), parameter.getサービス提供年月(),
                        parameter.get整理番号(), parameter.get証明書());
        if (!tmpList.records().isEmpty()) {
            for (ShokanJutakuKaishuBusiness tmp : tmpList.records()) {
                dbt3049List.add(tmp.get住宅改修());
            }
        }
        JutakuKaishuKetteiKyufujissekiHennsyuManager manager
                = JutakuKaishuKetteiKyufujissekiHennsyuManager.createInstance();
        manager.createSikyuKetteiKyufujisseki(kyufuentity, dbt3049List, dbt3053entity);
        return true;
    }

    /**
     * 様式名称取得
     *
     * @param サービス提供年月
     * @return 識別番号管理Entityリスト　（List<ShikibetsuNoKanri>）
     */
    public List<ShikibetsuNoKanri> getYoshikiName(FlexibleYearMonth サービス提供年月) {
        List<DbT3118ShikibetsuNoKanriEntity> entityList
                = 識別番号管理Dac.select様式名称(サービス提供年月);
        List<ShikibetsuNoKanri> 様式名称List = new ArrayList<>();
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        for (DbT3118ShikibetsuNoKanriEntity entity : entityList) {
            様式名称List.add(new ShikibetsuNoKanri(entity));
        }
        return 様式名称List;
    }
}
