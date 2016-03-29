/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.checknyutaisyokikanby;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaikaijo.TekiyoJogaiKaijo;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.checknyutaisyokikanby.ShisetsuJouHouParamer;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.checknyutaisyokikanby.ITekiyoJogaishaKanriMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険適用除外者を管理するクラスです。
 */
public class TekiyoJogaishaKanriFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TekiyoJogaishaKanriFinder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param MapperProvider mapperProvider
     */
    TekiyoJogaishaKanriFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaKanriFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TekiyoJogaishaKanriFinder}のインスタンス
     */
    public static TekiyoJogaishaKanriFinder createInstance() {
        return InstanceProvider.create(TekiyoJogaishaKanriFinder.class);
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
            if ((適用除外情報リスト.get(i).getNyushoTsuchiHakkoYMD() == null && FlexibleDate.MIN.equals(saidaiNyushoTsuchiHakkoYMD)
                    && 適用除外情報リスト.get(i).getTaishoTsuchiHakkoYMD() == null)
                    || (適用除外情報リスト.get(i).getNyushoTsuchiHakkoYMD() != null
                    && 適用除外情報リスト.get(i).getNyushoTsuchiHakkoYMD().equals(saidaiNyushoTsuchiHakkoYMD)
                    && 適用除外情報リスト.get(i).getTaishoTsuchiHakkoYMD() == null)) {
                return false;
            }
        }
        if (適用除外情報リスト.get(0).getNyushoTsuchiHakkoYMD() == null && FlexibleDate.MIN.isBefore(saidaiTaishoTsuchiHakkoYMD)) {
            return false;
        } else if (適用除外情報リスト.get(0).getNyushoTsuchiHakkoYMD() != null
                && 適用除外情報リスト.get(0).getNyushoTsuchiHakkoYMD().isBefore(saidaiTaishoTsuchiHakkoYMD)) {
            return false;
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
        if (適用除外情報リスト.get(0).getNyushoTsuchiHakkoYMD() == null) {
            return true;
        } else if (適用除外情報リスト.get(0).getTaishoTsuchiHakkoYMD() != null
                && 適用除外情報リスト.get(0).getTaishoTsuchiHakkoYMD().isBefore(適用除外情報リスト.get(0).getNyushoTsuchiHakkoYMD())) {
            return false;
        }
        return true;
    }

    /**
     * 変更状態の施設入退所情報を取得です。
     *
     * @param 施設入退所情報リスト List<ShisetsuJouHouParamer>
     * @return 結果フラグ
     */
    @Transaction
    public boolean checkNyuTaiSyoKikanByHenkoMode(List<ShisetsuJouHouParamer> 施設入退所情報リスト) {
        return select適用除外者情報(施設入退所情報リスト);
    }

    private boolean select適用除外者情報(List<ShisetsuJouHouParamer> 施設入退所情報リスト) {
        if (施設入退所情報リスト == null || 施設入退所情報リスト.isEmpty()) {
            return false;
        }
        for (ShisetsuJouHouParamer shisetsuJouHouList : 施設入退所情報リスト) {
            if (shisetsuJouHouList.getState() != null && !shisetsuJouHouList.getState().isEmpty()
                    && shisetsuJouHouList.getState().equals(new RString("削除"))) {
                continue;
            }
            int count = mapperProvider.create(ITekiyoJogaishaKanriMapper.class).get被保険者資格不整合一覧(shisetsuJouHouList);
            if (count > 1 || count == 0) {
                return false;
            }
        }
        return true;
    }
}
