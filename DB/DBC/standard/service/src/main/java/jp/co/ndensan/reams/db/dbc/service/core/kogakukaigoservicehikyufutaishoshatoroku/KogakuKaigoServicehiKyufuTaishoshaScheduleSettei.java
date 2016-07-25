/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukaigoservicehikyufutaishoshatoroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * DBCMN41001_高額介護サービス費給付対象者-スケジュール設定（画面）のクラスです。
 *
 * @reamsid_L DBC-2010-060 wangkanglei
 */
public class KogakuKaigoServicehiKyufuTaishoshaScheduleSettei {

    private final DbT3104KokuhorenInterfaceKanriDac dbT3104Dac;
    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;

    /**
     * コンストラクタです。
     */
    public KogakuKaigoServicehiKyufuTaishoshaScheduleSettei() {
        dbT3104Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した {@link KogakuKaigoServicehiKyufuTaishoshaScheduleSettei}のインスタンス
     */
    public static KogakuKaigoServicehiKyufuTaishoshaScheduleSettei createInstance() {
        return InstanceProvider.create(KogakuKaigoServicehiKyufuTaishoshaScheduleSettei.class);
    }

    /**
     * スケジュール履歴情報取得のメソッドです。
     *
     * @param 交換情報識別番号 RString
     * @return スケジュール履歴情報List List<KokuhorenInterfaceKanri>
     */
    public List<KokuhorenInterfaceKanri> sukijyuruRirekiJyoho(RString 交換情報識別番号) {
        List<KokuhorenInterfaceKanri> スケジュール履歴情報List = new ArrayList<>();
        List<DbT3104KokuhorenInterfaceKanriEntity> dbT3104List = dbT3104Dac.get国保連インターフェース管理(交換情報識別番号);
        if (dbT3104List != null && !dbT3104List.isEmpty()) {
            for (DbT3104KokuhorenInterfaceKanriEntity dbt3104Entity : dbT3104List) {
                スケジュール履歴情報List.add(new KokuhorenInterfaceKanri(dbt3104Entity));
            }
        }
        return スケジュール履歴情報List;
    }

    /**
     * 処理年月重複チェックのメソッドです。
     *
     * @param 交換情報識別番号 RString
     * @param 処理年月 FlexibleYearMonth
     */
    public void shoriNenngetsuJuufukuCheck(RString 交換情報識別番号, FlexibleYearMonth 処理年月) {
        List<DbT3104KokuhorenInterfaceKanriEntity> dbT3104List = dbT3104Dac.get国保連インターフェース管理_処理年月(
                交換情報識別番号, 処理年月);
        if (dbT3104List != null && !dbT3104List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.既に存在.getMessage().replace(
                    処理年月.wareki().toDateString().toString()));
        }
    }

    /**
     * スケジュール履歴情報登録のメソッドです。
     *
     * @param 交換情報識別番号 RString
     * @param データ登録リスト List<SukijyuruRirekiJyoho>
     * @param 確認Flag boolean
     */
    @Transaction
    public void sukijyuruRirekiJyohoToroku(RString 交換情報識別番号,
            List<KokuhorenInterfaceKanri> データ登録リスト,
            boolean 確認Flag) {
        List<KokuhorenInterfaceKanri> スケジュール履歴情報List = sukijyuruRirekiJyoho(交換情報識別番号);
        List<DbT3104KokuhorenInterfaceKanriEntity> 登録_更新List = new ArrayList<>();
        int 履歴情報の件数 = NUM_ZERO;
        for (KokuhorenInterfaceKanri データEntity : データ登録リスト) {
            if (ShoriJotaiKubun.処理前.getコード().equals(データEntity.get処理状態区分())
                    || ShoriJotaiKubun.再処理前.getコード().equals(データEntity.get処理状態区分())) {
                履歴情報の件数 = 履歴情報の件数 + NUM_ONE;
                if (NUM_ONE < 履歴情報の件数) {
                    throw new ApplicationException(DbcErrorMessages.高額判定_処理状態処理前数不正.getMessage()
                            .evaluate().concat(データEntity.get処理年月().wareki().toDateString().toString()));
                }
            }
        }
        DbT3104KokuhorenInterfaceKanriEntity entity;
        int 件数カウント = NUM_ZERO;
        for (KokuhorenInterfaceKanri データEntity : データ登録リスト) {
            KokuhorenInterfaceKanri 国保連インターフェース管理 = get国保連インターフェース管理(
                    スケジュール履歴情報List, データEntity);
            if (国保連インターフェース管理 != null) {
                if (get処理状態区分の比較(国保連インターフェース管理, データEntity)) {
                    件数カウント = 件数カウント + 1;
                } else {
                    entity = データEntity.toEntity();
                    entity.setState(EntityDataState.Modified);
                    登録_更新List.add(entity);
                }
            } else {
                entity = データEntity.toEntity();
                entity.setState(EntityDataState.Added);
                登録_更新List.add(entity);
            }
        }
        if (1 < 件数カウント) {
            throw new ApplicationException(DbcErrorMessages.高額介護スケジュール変更複数不可.getMessage());
        }
        for (DbT3104KokuhorenInterfaceKanriEntity saveEntity : 登録_更新List) {
            dbT3104Dac.save(saveEntity);
        }
    }

    private KokuhorenInterfaceKanri get国保連インターフェース管理(
            List<KokuhorenInterfaceKanri> スケジュール履歴情報List,
            KokuhorenInterfaceKanri データEntity) {
        for (KokuhorenInterfaceKanri スケジュール履歴情報 : スケジュール履歴情報List) {
            if (データEntity.get交換情報識別番号().equals(スケジュール履歴情報.get交換情報識別番号())
                    && データEntity.get処理年月().equals(スケジュール履歴情報.get処理年月())) {
                return スケジュール履歴情報;
            }
        }
        return null;
    }

    private boolean get処理状態区分の比較(KokuhorenInterfaceKanri 国保連インターフェース管理,
            KokuhorenInterfaceKanri データEntity) {
        if ((国保連インターフェース管理.get処理状態区分().equals(ShoriJotaiKubun.処理前.getコード())
                && データEntity.get処理状態区分().equals(ShoriJotaiKubun.処理なし.getコード()))
                || (国保連インターフェース管理.get処理状態区分().equals(ShoriJotaiKubun.処理なし.getコード())
                && データEntity.get処理状態区分().equals(ShoriJotaiKubun.処理前.getコード()))
                || (国保連インターフェース管理.get処理状態区分().equals(ShoriJotaiKubun.再処理前.getコード())
                && データEntity.get処理状態区分().equals(ShoriJotaiKubun.終了.getコード()))
                || (国保連インターフェース管理.get処理状態区分().equals(ShoriJotaiKubun.終了.getコード())
                && データEntity.get処理状態区分().equals(ShoriJotaiKubun.再処理前.getコード()))) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
