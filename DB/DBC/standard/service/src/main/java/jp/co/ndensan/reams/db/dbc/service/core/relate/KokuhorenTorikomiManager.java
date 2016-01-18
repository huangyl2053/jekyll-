/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.relate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KokuhorenTorikomiConfigKeysFactory;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenTorikomiJohoModel;
import jp.co.ndensan.reams.db.dbc.business.core.view.KokuhorenTorikomiJoho;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.IConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhorenInterfaceKanriManager;
import jp.co.ndensan.reams.db.dbc.service.core.view.KokuhorenTorikomiJohoManager;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 国保連取込情報を管理するクラスです。
 */
public class KokuhorenTorikomiManager {

    private final MapperProvider mapperProvider;
    private final KokuhorenInterfaceKanriManager 国保連IF管理Finder;
    private final KokuhorenTorikomiJohoManager 国保連取込情報Manager;

    /**
     * コンストラクタです。
     */
    public KokuhorenTorikomiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.国保連IF管理Finder = new KokuhorenInterfaceKanriManager();
        this.国保連取込情報Manager = new KokuhorenTorikomiJohoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 被保険者台帳Manager 被保険者台帳Manager
     * @param 介護所得Manager 介護所得Manager
     */
    KokuhorenTorikomiManager(MapperProvider mapperProvider,
            KokuhorenInterfaceKanriManager 国保連IF管理Finder, KokuhorenTorikomiJohoManager 国保連取込情報Manager) {
        this.mapperProvider = mapperProvider;
        this.国保連IF管理Finder = 国保連IF管理Finder;
        this.国保連取込情報Manager = 国保連取込情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KokuhorenTorikomiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KokuhorenTorikomiManager}のインスタンス
     */
    public static KokuhorenTorikomiManager createInstance() {
        return InstanceProvider.create(KokuhorenTorikomiManager.class);
    }

    /**
     * 国保連IF管理マスタ内の最大処理年月を返します。 国保連IF管理にデータがない場合はシステム日付の年月を返します
     *
     * @return RYearMonth
     */
    public RYearMonth get国保連IF管理Max処理年月() {
        DbT3104KokuhorenInterfaceKanriEntity kokuhorenInterfaceKanri = 国保連IF管理Finder.get最大処理年月();
        if (kokuhorenInterfaceKanri == null || kokuhorenInterfaceKanri.getShoriYM() == null) {
            return RDate.getNowDate().getYearMonth();
        } else {
            return new RYearMonth(kokuhorenInterfaceKanri.getShoriYM().toDateString());
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
            KokuhorenTorikomiJoho kokuhorenTorikomiJoho = find国保連IF管理(処理年月, model.get交換識別番号());
            if (kokuhorenTorikomiJoho != null) {
                model.set国保連取込管理エンティティ(kokuhorenTorikomiJoho.toEntity());
                result.add(model);
            }
        }

        return result;
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

    /**
     * * 指定した処理年月の国保連IF管理をリストで取得します。
     *
     * @param 処理年月 RString
     * @return List<KokuhorenTorikomiJohoModel>
     */
    private KokuhorenTorikomiJoho find国保連IF管理(RYearMonth 処理年月, RString 交換識別番号) {
        KokuhorenTorikomiJoho entity = 国保連取込情報Manager.get国保連取り込み情報(new FlexibleYearMonth(処理年月.toDateString()), 交換識別番号);
        return entity;
    }
}
