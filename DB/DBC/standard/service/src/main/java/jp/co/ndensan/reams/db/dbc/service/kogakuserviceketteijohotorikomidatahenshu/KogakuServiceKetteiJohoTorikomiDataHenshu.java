/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.kogakuserviceketteijohotorikomidatahenshu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceketteijohotorikomidatahenshu.DbShoriDataParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin.KogakuKyufuKetteiInPartEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3058KogakuShikyuShinsaKetteiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakuserviceketteijohotorikomidatahenshu.IKogakuServiceKetteiJohoTorikomiDataHenshuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額サービス費決定情報取込データ編集
 */
public class KogakuServiceKetteiJohoTorikomiDataHenshu {

    private final Decimal DATAONE = new Decimal("1");
    private final int ZERO = 0;
    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;
    private final MapperProvider mapperProvider;
    private final DbT3058KogakuShikyuShinsaKetteiDac 高額介護サービス費支給審査決定Dac;
    private final DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac;

    public KogakuServiceKetteiJohoTorikomiDataHenshu() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.高額介護サービス費支給審査決定Dac = InstanceProvider.create(DbT3058KogakuShikyuShinsaKetteiDac.class);
        this.国保連インターフェース管理Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    public KogakuServiceKetteiJohoTorikomiDataHenshu(MapperProvider mapperProvider,
            DbT3058KogakuShikyuShinsaKetteiDac 高額介護サービス費支給審査決定Dac,
            DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac) {
        this.mapperProvider = mapperProvider;
        this.高額介護サービス費支給審査決定Dac = 高額介護サービス費支給審査決定Dac;
        this.国保連インターフェース管理Dac = 国保連インターフェース管理Dac;
    }

    /**
     * DB処理用データ編集
     *
     * @param 処理年月 FlexibleYearMonth
     * @param ファイル名リスト List<RString>
     */
    @Transaction
    public void getDbShoriDataList(FlexibleYearMonth 処理年月,
            List<RString> ファイル名リスト) {
        DbShoriDataParameter parameter = DbShoriDataParameter.createSelectByKeyParam(処理年月, ファイル名リスト);
        IKogakuServiceKetteiJohoTorikomiDataHenshuMapper mapper = mapperProvider.create(
                IKogakuServiceKetteiJohoTorikomiDataHenshuMapper.class);
        List<KogakuKyufuKetteiInPartEntity> entityList = mapper.select一時TBLデータ(parameter);
        for (KogakuKyufuKetteiInPartEntity entity : entityList) {
            DbT3058KogakuShikyuShinsaKetteiEntity 高額介護サービス費支給審査決定Entity = new DbT3058KogakuShikyuShinsaKetteiEntity();
            高額介護サービス費支給審査決定Entity.setKetteishaUketoriYM(処理年月);
            高額介護サービス費支給審査決定Entity.setShoKisaiHokenshaNo(entity.get証記載保険者番号());
            高額介護サービス費支給審査決定Entity.setHihokenshaNo(entity.get被保険者番号());
            高額介護サービス費支給審査決定Entity.setServiceTeikyoYM(entity.getサービス提供年月());
            高額介護サービス費支給審査決定Entity.setTsuchishoNo(entity.get通知書番号());
            高額介護サービス費支給審査決定Entity.setRiyoshaFutanGaku(entity.get利用者負担額());
            高額介護サービス費支給審査決定Entity.setShikyuKubunCode(entity.get支給区分コード());
            高額介護サービス費支給審査決定Entity.setKetteiYM(entity.get決定年月());
            高額介護サービス費支給審査決定Entity.setKogakuShikyuGaku(entity.get高額支給額());
            高額介護サービス費支給審査決定Dac.insert(高額介護サービス費支給審査決定Entity);
        }
        RString 交換情報識別番号 = new RString("351");
        RString 送付取込区分 = new RString("2");
        RString 処理状態区分 = new RString("3");
        YMDHMS システム日付 = YMDHMS.now();
        boolean 再処理可能区分 = false;
        Decimal 処理実行回数 = new Decimal("1");
        boolean 再処理設定不可区分 = true;
        DbT3104KokuhorenInterfaceKanriEntity 国保連インターフェース管理entity = 国保連インターフェース管理Dac
                .selectByKey(処理年月, 交換情報識別番号);
        if (国保連インターフェース管理entity.getShoriYM() == null) {
            DbT3104KokuhorenInterfaceKanriEntity 国保連インターフェース管理entity1
                    = new DbT3104KokuhorenInterfaceKanriEntity();
            国保連インターフェース管理entity1.setShoriYM(処理年月);
            国保連インターフェース管理entity1.setKokanShikibetsuNo(交換情報識別番号);
            国保連インターフェース管理entity1.setSofuTorikomiKubun(送付取込区分);
            国保連インターフェース管理entity1.setShoriJotaiKubun(処理状態区分);
            国保連インターフェース管理entity1.setShoriJisshiTimestamp(システム日付);
            国保連インターフェース管理entity1.setSaiShoriKanoKubun(再処理可能区分);
            国保連インターフェース管理entity1.setShoriJikkoKaisu(処理実行回数);
            国保連インターフェース管理entity1.setFileName1(ファイル名リスト.get(0));
            国保連インターフェース管理entity1.setFileName2(ファイル名リスト.get(1));
            国保連インターフェース管理entity1.setFileName3(ファイル名リスト.get(2));
            国保連インターフェース管理entity1.setFileName4(ファイル名リスト.get(3));
            国保連インターフェース管理entity1.setFileName5(ファイル名リスト.get(4));
            国保連インターフェース管理entity1.setSaiShoriFukaKubun(再処理設定不可区分);
            国保連インターフェース管理Dac.save(国保連インターフェース管理entity);
        } else {
            国保連インターフェース管理entity.setSofuTorikomiKubun(送付取込区分);
            国保連インターフェース管理entity.setShoriJotaiKubun(処理状態区分);
            国保連インターフェース管理entity.setSofuTorikomiKubun(送付取込区分);
            国保連インターフェース管理entity.setSaiShoriKanoKubun(再処理可能区分);
            Decimal shoriJikkoKaisu = 国保連インターフェース管理entity.getShoriJikkoKaisu();
            if (shoriJikkoKaisu != null) {
                国保連インターフェース管理entity.setShoriJikkoKaisu(shoriJikkoKaisu.add(DATAONE));
            }
            if (ファイル名リスト.size() >= ONE) {
                国保連インターフェース管理entity.setFileName1(ファイル名リスト.get(0));
            } else {
                国保連インターフェース管理entity.setFileName1(new RString(""));
            }
            if (ファイル名リスト.size() >= TWO) {
                国保連インターフェース管理entity.setFileName2(ファイル名リスト.get(1));
            } else {
                国保連インターフェース管理entity.setFileName2(new RString(""));
            }
            if (ファイル名リスト.size() >= THREE) {
                国保連インターフェース管理entity.setFileName3(ファイル名リスト.get(2));
            } else {
                国保連インターフェース管理entity.setFileName3(new RString(""));
            }
            if (ファイル名リスト.size() >= FOUR) {
                国保連インターフェース管理entity.setFileName4(ファイル名リスト.get(3));
            } else {
                国保連インターフェース管理entity.setFileName4(new RString(""));
            }
            if (ファイル名リスト.size() >= FIVE) {
                国保連インターフェース管理entity.setFileName5(ファイル名リスト.get(4));
            } else {
                国保連インターフェース管理entity.setFileName5(new RString(""));
            }
            国保連インターフェース管理Dac.save(国保連インターフェース管理entity);
        }
    }
}
