/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.checknyutaisyokikanby;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaikaijo.ShisetsuJouHou;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaikaijo.TekiyoJogaiKaijo;
import jp.co.ndensan.reams.db.dba.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険適用除外者を管理するクラスです。
 */
public class TekiyoJogaishaKanriFinder {

    private final DbT1002TekiyoJogaishaDac dac;

    /**
     * コンストラクタです。
     */
    public TekiyoJogaishaKanriFinder() {
        dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param DbT1002TekiyoJogaishaDac dac
     */
    TekiyoJogaishaKanriFinder(DbT1002TekiyoJogaishaDac dac) {
        this.dac = dac;
    }

    /**
     * 適用状態の適用除外情報を取得です。
     *
     * @param 適用除外情報リスト TekiyoJogaiKaijo
     * @return 結果フラグ
     */
    @Transaction
    public boolean checkNyuTaiSyoKikanByTekiyouMode(List<TekiyoJogaiKaijo> 適用除外情報リスト) {
        return check入退所期間(適用除外情報リスト);
    }

    private boolean check入退所期間(List<TekiyoJogaiKaijo> 適用除外情報リスト) {
        if (適用除外情報リスト == null || 適用除外情報リスト.size() < 2) {
            return false;
        }
        FlexibleDate saidaiTaishoTsuchiHakkoYMD = FlexibleDate.MIN;
        FlexibleDate saidaiNyushoTsuchiHakkoYMD = FlexibleDate.MIN;
        for (int i = 1; i < 適用除外情報リスト.size(); i++) {
            TekiyoJogaiKaijo kaijo = 適用除外情報リスト.get(i);

            FlexibleDate taishoTsuchiHakkoYMD = kaijo.getTaishoTsuchiHakkoYMD();
            FlexibleDate nyushoTsuchiHakkoYMD = kaijo.getNyushoTsuchiHakkoYMD();
            if (taishoTsuchiHakkoYMD == null) {
                taishoTsuchiHakkoYMD = FlexibleDate.MIN;
            }
            if (nyushoTsuchiHakkoYMD == null) {
                nyushoTsuchiHakkoYMD = FlexibleDate.MIN;
            }
            if (saidaiTaishoTsuchiHakkoYMD.isBefore(taishoTsuchiHakkoYMD)) {
                saidaiTaishoTsuchiHakkoYMD = taishoTsuchiHakkoYMD;
            }
            if (saidaiNyushoTsuchiHakkoYMD.isBefore(nyushoTsuchiHakkoYMD)) {
                saidaiNyushoTsuchiHakkoYMD = nyushoTsuchiHakkoYMD;
            }
        }
        for (int i = 1; i < 適用除外情報リスト.size(); i++) {
            if (適用除外情報リスト.get(i).getNyushoTsuchiHakkoYMD() == null) {
                if (FlexibleDate.MIN.equals(saidaiNyushoTsuchiHakkoYMD)) {
                    if (適用除外情報リスト.get(i).getTaishoTsuchiHakkoYMD() == null) {
                        return false;
                    }
                }
            } else {
                if (適用除外情報リスト.get(i).getNyushoTsuchiHakkoYMD().equals(saidaiNyushoTsuchiHakkoYMD)) {
                    if (適用除外情報リスト.get(i).getTaishoTsuchiHakkoYMD() == null) {
                        return false;
                    }
                }
            }
        }
        if (適用除外情報リスト.get(0).getNyushoTsuchiHakkoYMD() == null) {
            if (FlexibleDate.MIN.isBefore(saidaiTaishoTsuchiHakkoYMD)) {
                return false;
            }
        } else {
            if (適用除外情報リスト.get(0).getNyushoTsuchiHakkoYMD().isBefore(saidaiTaishoTsuchiHakkoYMD)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 解除状態の適用除外情報を取得です。
     *
     * @param 適用除外情報リスト TekiyoJogaiKaijo
     * @return 結果フラグ
     */
    @Transaction
    public boolean checkNyuTaiSyoKikanByKaijoMode(List<TekiyoJogaiKaijo> 適用除外情報リスト) {
        return check入退所範囲(適用除外情報リスト);
    }

    private boolean check入退所範囲(List<TekiyoJogaiKaijo> 適用除外情報リスト) {
        if (適用除外情報リスト == null || 適用除外情報リスト.isEmpty()) {
            return false;
        }
        FlexibleDate saidaiNyushoTsuchiHakkoYMD = 適用除外情報リスト.get(0).getNyushoTsuchiHakkoYMD();
        FlexibleDate taishoTsuchiHakkoYMD = 適用除外情報リスト.get(0).getTaishoTsuchiHakkoYMD();
        if (適用除外情報リスト.get(0).getNyushoTsuchiHakkoYMD() == null) {
            saidaiNyushoTsuchiHakkoYMD = FlexibleDate.MIN;
        }
        if (taishoTsuchiHakkoYMD != null && taishoTsuchiHakkoYMD.isBefore(saidaiNyushoTsuchiHakkoYMD)) {
            return false;
        }
        return true;
    }

    /**
     * 変更状態の施設入退所情報を取得です。
     *
     * @param 施設入退所情報リスト ShisetsuJouHou
     * @return 結果フラグ
     */
    @Transaction
    public boolean checkNyuTaiSyoKikanByHenkoMode(List<ShisetsuJouHou> 施設入退所情報リスト) {
        return select適用除外者情報(施設入退所情報リスト);
    }

    private boolean select適用除外者情報(List<ShisetsuJouHou> 施設入退所情報リスト) {
        if (施設入退所情報リスト == null || 施設入退所情報リスト.isEmpty()) {
            return false;
        }
        for (ShisetsuJouHou shisetsuJouHouList : 施設入退所情報リスト) {
            if (shisetsuJouHouList.getState() != null && !shisetsuJouHouList.getState().isEmpty()) {
                if (shisetsuJouHouList.getState().equals(new RString("削除"))) {
                    continue;
                }
            }
            int count = dac.getCount(shisetsuJouHouList.getNyushoTsuchiHakkoYMD(), shisetsuJouHouList.getTaishoTsuchiHakkoYMD());
            if (count > 1) {
                return false;
            } else if (count == 0) {
                return false;
            }
        }
        return true;
    }
}
