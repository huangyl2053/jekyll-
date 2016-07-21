/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraShiketteiJohoShuukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho.ShokanBaraShiketteiShuukeiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraishikyuketteijoho.IShokanBaraiShikyuKetteiJohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払支給決定情報の更新
 *
 * @reamsid_L DBC-0980-350 gongliang
 */
public class ShokanBaraiShikyuKetteiJoho {

    private static final int 定数_0 = 0;
    private static final int 定数_1 = 1;
    private static final int 定数_2 = 2;
    private static final int 定数_3 = 3;
    private static final int 定数_4 = 4;
    private static final RString 支給 = new RString("1");
    private static final RString 未発行 = new RString("0");
    private static final RString 取込 = new RString("2");
    private static final RString 終了 = new RString("3");
    private static final RString KOKANSHIBETSUNO = new RString("221");
    private final MapperProvider mProvider;
    private final DbT3036ShokanHanteiKekkaDac shokanHanteiKekkaDac;
    private final DbT3104KokuhorenInterfaceKanriDac kokuhorenInterfaceKanriDac;

    /**
     * コンストラクタです。
     */
    public ShokanBaraiShikyuKetteiJoho() {
        mProvider = InstanceProvider.create(MapperProvider.class);
        shokanHanteiKekkaDac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        kokuhorenInterfaceKanriDac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mProvider mProvider
     * @param shokanHanteiKekkaDac shokanHanteiKekkaDac
     */
    ShokanBaraiShikyuKetteiJoho(
            MapperProvider mProvider,
            DbT3036ShokanHanteiKekkaDac shokanHanteiKekkaDac,
            DbT3104KokuhorenInterfaceKanriDac kokuhorenInterfaceKanriDac) {
        this.mProvider = mProvider;
        this.shokanHanteiKekkaDac = shokanHanteiKekkaDac;
        this.kokuhorenInterfaceKanriDac = kokuhorenInterfaceKanriDac;
    }

    /**
     * 一時テーブルより、DBの更新を実行する
     *
     * @param 処理年月 処理年月
     * @param csvFileNameList Csvファイル名
     */
    @Transaction
    void updShokanBaraiShikyuKetteiJoho(
            FlexibleYearMonth 処理年月,
            List<RString> csvFileNameList) {
        IShokanBaraiShikyuKetteiJohoMapper mapper = mProvider.create(IShokanBaraiShikyuKetteiJohoMapper.class);
        登録償還払支給判定結果(mapper);
        更新償還払請求集計(mapper);
        mapper.update償還払請求食事費用();
        mapper.update償還払請求集計();
        更新償還払請求サービス計画費(mapper);
        mapper.update特定入所者介護サービス費用();
//        TODO QA 更新DB無の処理
        更新国保連インターフェース管理(処理年月, csvFileNameList);
    }

    @Transaction
    private void 登録償還払支給判定結果(IShokanBaraiShikyuKetteiJohoMapper mapper) {
        List<ShokanBaraShiketteiJohoShuukeiEntity> entityList_支給判定結果 = mapper.select一時TBL4償還払支給判定結果();
        DbT3036ShokanHanteiKekkaEntity entity = new DbT3036ShokanHanteiKekkaEntity();
        entity.setShikyuHushikyuKetteiKubun(支給);
        entity.setKetteiTsuchiHakkoKubun(未発行);
        for (ShokanBaraShiketteiJohoShuukeiEntity entity_支給判定結果 : entityList_支給判定結果) {
            entity.setHiHokenshaNo(entity_支給判定結果.get被保険者番号());
            entity.setServiceTeikyoYM(entity_支給判定結果.getサービス提供年月());
            entity.setSeiriNo(entity_支給判定結果.get整理番号());
            // TODO QA 処理日時
            entity.setShoKisaiHokenshaNo(entity_支給判定結果.get証記載保険者番号());
            entity.setKetteiYMD(entity_支給判定結果.get作成年月日());
            entity.setShiharaiKingaku(entity_支給判定結果.get支払金額());
            entity.setShiharaiKingakuUchiwakeRiyoshabun(entity_支給判定結果.get支払金額());
            entity.setKetteiIchiranTorikomiYM(new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toString()));
            // TODO QA 集計項目.前回支払金額
            entity.setZenkaiShiharaiKingaku(entity_支給判定結果.get前回支払金額());
            entity.setSagakuKingakuGokei(entity_支給判定結果.get差額金額合計());
            entity.setKetteiTsuchishoSakuseiYMD(entity_支給判定結果.get作成年月日());
            entity.setKetteiTsuchiNo(entity_支給判定結果.getNo());
            entity.setState(EntityDataState.Added);
            shokanHanteiKekkaDac.save(entity);
        }
    }

    @Transaction
    private void 更新償還払請求集計(IShokanBaraiShikyuKetteiJohoMapper mapper) {
        List<ShokanBaraShiketteiShuukeiEntity> entityList_集計 = mapper.select一時TBL4集計();
        for (ShokanBaraShiketteiShuukeiEntity entity_集計 : entityList_集計) {
            entity_集計.set支給区分コード(支給);
            mapper.insert償還払請求集計一時テーブル(entity_集計);
        }
    }

    @Transaction
    private void 更新償還払請求サービス計画費(IShokanBaraiShikyuKetteiJohoMapper mapper) {
        mapper.update償還払請求サービス計画200004();
        mapper.update償還払請求サービス計画200604();
        mapper.update償還払請求サービス計画200904();
    }

    private void 更新国保連インターフェース管理(FlexibleYearMonth 処理年月,
            List<RString> csvFileNameList) {
        DbT3104KokuhorenInterfaceKanriEntity entity = kokuhorenInterfaceKanriDac.selectByKey(処理年月, KOKANSHIBETSUNO);
        if (null == entity) {
            entity = new DbT3104KokuhorenInterfaceKanriEntity();
            entity.setState(EntityDataState.Added);
            entity.setShoriJikkoKaisu(Decimal.ONE);
        } else {
            entity.setState(EntityDataState.Modified);
            entity.setShoriJikkoKaisu(Decimal.ONE.add(entity.getShoriJikkoKaisu()));
        }
        entity.setShoriYM(処理年月);
        entity.setKokanShikibetsuNo(KOKANSHIBETSUNO);
        entity.setSofuTorikomiKubun(取込);
        entity.setShoriJotaiKubun(終了);
        entity.setShoriJisshiTimestamp(YMDHMS.now());
        entity.setSaiShoriFukaKubun(false);
        entity.setFileName1(null == csvFileNameList || csvFileNameList.isEmpty()
                || null == csvFileNameList.get(定数_0) ? RString.EMPTY : csvFileNameList.get(定数_0));
        entity.setFileName2(null == csvFileNameList || 定数_1 >= csvFileNameList.size()
                || null == csvFileNameList.get(定数_1) ? RString.EMPTY : csvFileNameList.get(定数_1));
        entity.setFileName3(null == csvFileNameList || 定数_2 >= csvFileNameList.size()
                || null == csvFileNameList.get(定数_2) ? RString.EMPTY : csvFileNameList.get(定数_2));
        entity.setFileName4(null == csvFileNameList || 定数_3 >= csvFileNameList.size()
                || null == csvFileNameList.get(定数_3) ? RString.EMPTY : csvFileNameList.get(定数_3));
        entity.setFileName5(null == csvFileNameList || 定数_4 >= csvFileNameList.size()
                || null == csvFileNameList.get(定数_4) ? RString.EMPTY : csvFileNameList.get(定数_4));
        kokuhorenInterfaceKanriDac.save(entity);
    }
}
