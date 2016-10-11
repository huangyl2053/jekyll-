/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hokenshasofu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.business.core.hokenshasofulist.HokenshaSofuResult;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 国保連情報データ媒体取込のクラスです。
 *
 * @reamsid_L DBC-3030-010 lihang
 */
public class HokenshaSofuFinder {

    private final DbT3104KokuhorenInterfaceKanriDac dbT3104Dac;

    /**
     * コンストラクタです。
     */
    public HokenshaSofuFinder() {
        this.dbT3104Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link  HokenshaSofuFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link  HokenshaSofuFinder}のインスタンス
     */
    public static HokenshaSofuFinder createInstance() {
        return InstanceProvider.create(HokenshaSofuFinder.class);
    }

    /**
     * 国保連連携スケジュール設定のスケジュール履歴情報取得ンメソッドです。
     *
     * @param 交換情報識別番号 RString
     * @param 処理状態区分 RString
     *
     * @return HokenshaSofuResult
     */
    public HokenshaSofuResult getSukejuruRirekiJoho(RString 交換情報識別番号, RString 処理状態区分) {
        HokenshaSofuResult entity = new HokenshaSofuResult();
        List<DbT3104KokuhorenInterfaceKanriEntity> kanriEntityList = dbT3104Dac.get処理年月1(交換情報識別番号, 処理状態区分);
        entity.setKokuhorenInterfaceKanriList(changeList(kanriEntityList));
        return entity;
    }

    /**
     * 国保連インターフェース管理取得返します。
     *
     * @param 交換情報識別番号 RString
     * @return HokenshaSofuResult
     */
    public HokenshaSofuResult getBykokanShikibetsuNo(RString 交換情報識別番号) {
        HokenshaSofuResult entity = new HokenshaSofuResult();
        List<DbT3104KokuhorenInterfaceKanriEntity> kanriEntityList = dbT3104Dac.get処理年月2(交換情報識別番号);
        entity.setKokuhorenInterfaceKanriList(changeList(kanriEntityList));
        return entity;
    }

    /**
     * 国保連インターフェース管理取得返します。
     *
     * @param 交換情報識別番号 RString
     * @param 処理年月 FlexibleYearMonth
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    public HokenshaSofuResult get国保連管理(RString 交換情報識別番号, FlexibleYearMonth 処理年月) {
        HokenshaSofuResult entity = new HokenshaSofuResult();
        List<DbT3104KokuhorenInterfaceKanriEntity> kanriEntityList = dbT3104Dac.get国保連インターフェース管理1(交換情報識別番号, 処理年月);
        entity.setKokuhorenInterfaceKanriList(changeList(kanriEntityList));
        return entity;
    }

    /**
     * 国保連インターフェース管理取得返します。
     *
     * @param 交換情報識別番号 RString
     * @param 処理年月 FlexibleYearMonth
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    public HokenshaSofuResult get国保連管理2(RString 交換情報識別番号, FlexibleYearMonth 処理年月) {
        HokenshaSofuResult entity = new HokenshaSofuResult();
        List<DbT3104KokuhorenInterfaceKanriEntity> kanriEntityList = dbT3104Dac.get国保連インターフェース管理2(交換情報識別番号, 処理年月);
        entity.setKokuhorenInterfaceKanriList(changeList(kanriEntityList));
        return entity;
    }

    private List<KokuhorenInterfaceKanri> changeList(List<DbT3104KokuhorenInterfaceKanriEntity> inputList) {
        List<KokuhorenInterfaceKanri> outputList = new ArrayList<>();
        if (inputList == null) {
            return outputList;
        } else {
            KokuhorenInterfaceKanri kokuhorenInterfaceKanri;
            for (DbT3104KokuhorenInterfaceKanriEntity entity : inputList) {
                kokuhorenInterfaceKanri = new KokuhorenInterfaceKanri(entity);
                outputList.add(kokuhorenInterfaceKanri);
            }
            return outputList;
        }
    }
}
