/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KokuhorenTorikomiConfigKeysFactory;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.IConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbc.model.relate.KokuhorenTorikomiJohoModel;
import jp.co.ndensan.reams.db.dbc.persistence.basic.KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.basic.KokuhorenTorikomiJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenTorikomiJohoManager {

    private final KokuhorenTorikomiJohoDac kokuhorenTorikomiJohoDac;
    private final KokuhorenInterfaceKanriDac kokuhorenInterfaceKanriDac;

    private final RString 処理状態区分_起動中 = new RString("2");

    /**
     * デフォルトコンストラクタです。
     */
    public KokuhorenTorikomiJohoManager() {
        kokuhorenTorikomiJohoDac = InstanceProvider.create(KokuhorenTorikomiJohoDac.class);
        kokuhorenInterfaceKanriDac = InstanceProvider.create(KokuhorenInterfaceKanriDac.class);
    }

    /**
     * 国保連IF管理マスタ内の最大処理年月を返します。 国保連IF管理にデータがない場合はシステム日付の年月を返します
     *
     * @return RYearMonth
     */
    public RYearMonth get国保連IF管理Max処理年月() {
        DbT3104KokuhorenInterfaceKanriEntity kokuhorenInterfaceKanri;
        kokuhorenInterfaceKanri = kokuhorenInterfaceKanriDac.getMaxShoriYM();
        if (kokuhorenInterfaceKanri == null || kokuhorenInterfaceKanri.getShoriYM() == null) {
            return RDate.getNowDate().getYearMonth();
        } else {
            return kokuhorenInterfaceKanri.getShoriYM();
        }
    }

    /**
     * 指定された処理年月の画面表示用のデータを返します。
     *
     * @param 処理年月 RYearMonth
     * @return KokuhorenTorikomiJohoModel
     */
    public List<KokuhorenTorikomiJohoModel> get国保連取込情報(RYearMonth 処理年月) {

        List<KokuhorenTorikomiJohoModel> models = new ArrayList<>();
        List<KokuhorenTorikomiJohoModel> result = new ArrayList<>();

        for (ConfigKeysKokuhorenTorikomi 交換識別番号 : ConfigKeysKokuhorenTorikomi.values()) {
            models.add(find国保連取込コンフィグ(交換識別番号.getCode()));
        }

        for (KokuhorenTorikomiJohoModel model : models) {
            model.set国保連取込管理エンティティ(find国保連IF管理(処理年月, model.get交換識別番号()));
            result.add(model);
        }

        return result;
    }

    /**
     * 指定された処理年月の画面表示用のデータを返します。
     *
     * @param 処理年月 RString
     * @param 交換情報識別番号 RString
     * @return boolean
     */
    public boolean Save国保連IF管理の処理状態を起動にする(RYearMonth 処理年月, RString 交換情報識別番号) {
        Integer result;
        DbT3104KokuhorenInterfaceKanriEntity kokuhorenInterfaceKanri;
        kokuhorenInterfaceKanri = kokuhorenInterfaceKanriDac.selectByKey(処理年月, 交換情報識別番号);
        kokuhorenInterfaceKanri.setShoriJotaiKubun(処理状態区分_起動中);
        result = kokuhorenInterfaceKanriDac.update(kokuhorenInterfaceKanri);
        return result == 1 ? true : false;
    }

    /**
     * * 指定した処理年月の国保連IF管理をリストで取得します。
     *
     * @param 処理年月 RString
     * @return List<KokuhorenTorikomiJohoModel>
     */
    private DbV3104KokuhorenTorikomiJohoEntity find国保連IF管理(RYearMonth 処理年月, RString 交換識別番号) {
        DbV3104KokuhorenTorikomiJohoEntity entity = kokuhorenTorikomiJohoDac.selectByKey(処理年月, 交換識別番号);
        return entity;
    }

    /**
     * * 取得したデータにコンフィグデータをセットします
     *
     * @param input KokuhorenTorikomiJohoModel
     * @return List<KokuhorenTorikomiJohoModel>
     */
    private KokuhorenTorikomiJohoModel find国保連取込コンフィグ(RString 交換識別番号) {

        KokuhorenTorikomiJohoModel result = new KokuhorenTorikomiJohoModel();
        IConfigKeysKokuhorenTorikomi configKeys
                = KokuhorenTorikomiConfigKeysFactory.getEnumValues(交換識別番号);

        result.setバッチID(BusinessConfig.get(configKeys.getバッチID()));
        result.set一覧表示順(BusinessConfig.get(configKeys.get一覧表示順()));
        result.set処理名(BusinessConfig.get(configKeys.get処理名称()));

        result.set交換識別番号(交換識別番号);

        return result;
    }
}
