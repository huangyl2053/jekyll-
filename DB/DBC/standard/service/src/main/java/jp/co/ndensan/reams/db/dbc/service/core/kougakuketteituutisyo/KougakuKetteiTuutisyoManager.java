/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kougakuketteituutisyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3057KogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBCMN43005_高額サービス費支給決定通知書（単）のserviceクラスです。
 *
 * @reamsid_L DBC-5160-010 chenxin
 */
public class KougakuKetteiTuutisyoManager {

    private final DbT3057KogakuShikyuHanteiKekkaDac 高額介護サービス費支給判定結果dac;
    private static final int INDEX_4 = 4;

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KougakuKetteiTuutisyoManager}のインスタンス
     */
    public static KougakuKetteiTuutisyoManager createInstance() {
        return InstanceProvider.create(KougakuKetteiTuutisyoManager.class);
    }

    /**
     * コンストラクタです。
     */
    KougakuKetteiTuutisyoManager() {
        this.高額介護サービス費支給判定結果dac = InstanceProvider.create(DbT3057KogakuShikyuHanteiKekkaDac.class);
    }

    /**
     * サービス提供年月を取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<FlexibleYearMonth>
     */
    public List<FlexibleYearMonth> getサービス提供年月(HihokenshaNo 被保険者番号) {
        List<DbT3057KogakuShikyuHanteiKekkaEntity> list = 高額介護サービス費支給判定結果dac.selectサービス提供年月(被保険者番号);
        List<FlexibleYearMonth> returnList = new ArrayList<>();
        for (DbT3057KogakuShikyuHanteiKekkaEntity entity : list) {
            if (!returnList.contains(entity.getServiceTeikyoYM())) {
                returnList.add(entity.getServiceTeikyoYM());
            }
        }
        return returnList;
    }

    /**
     * 管理番号を取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return List<RString>
     */
    public List<RString> get管理番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        List<Integer> intList = new ArrayList<>();
        List<RString> 管理番号リスト = new ArrayList<>();
        List<DbT3057KogakuShikyuHanteiKekkaEntity> list = 高額介護サービス費支給判定結果dac.select管理番号(被保険者番号, サービス提供年月);
        for (DbT3057KogakuShikyuHanteiKekkaEntity entity : list) {
            if (!intList.contains(entity.getRirekiNo())) {
                intList.add(entity.getRirekiNo());
            }
        }
        for (Integer integer : intList) {
            RString 管理番号 = new RString(integer);
            RString 管理番号padLeft = 管理番号.padLeft("0", INDEX_4);
            管理番号リスト.add(管理番号padLeft);
        }
        return 管理番号リスト;
    }

    /**
     * 前回発行日を取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @return FlexibleDate
     */
    public FlexibleDate get前回発行日(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, int 履歴番号) {
        return 高額介護サービス費支給判定結果dac.select前回発行日(被保険者番号, サービス提供年月, 履歴番号).getKetteiTsuchishoSakuseiYMD();
    }

    /**
     * 更新データを読み込みする。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @return KogakuShikyuHanteiKekka
     */
    public KogakuShikyuHanteiKekka 更新データ読み込み(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, int 履歴番号) {
        return new KogakuShikyuHanteiKekka(高額介護サービス費支給判定結果dac.select前回発行日(被保険者番号, サービス提供年月, 履歴番号));
    }

    /**
     * DB更新を行う。
     *
     * @param 画面情報 KogakuShikyuHanteiKekka
     */
    @Transaction
    public void save(KogakuShikyuHanteiKekka 画面情報) {
        高額介護サービス費支給判定結果dac.save(画面情報.toEntity());
    }
}
