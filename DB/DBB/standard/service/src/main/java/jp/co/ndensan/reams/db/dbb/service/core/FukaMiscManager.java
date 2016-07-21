/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.relate.FukaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課情報のマネージャです。
 */
public class FukaMiscManager {

    private final FukaDac dac;

    /**
     * コンストラクタです。
     */
    public FukaMiscManager() {
        dac = InstanceProvider.create(FukaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac 賦課dac
     */
    FukaMiscManager(FukaDac dac) {
        this.dac = dac;
    }

    /**
     * 条件に該当する全賦課履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 全賦課履歴
     */
    public IItemList<Fuka> load全賦課履歴(HihokenshaNo 被保険者番号) {
        List<Fuka> result = new ArrayList<>();
        for (DbT2002FukaEntity entity : dac.select介護賦課一覧(被保険者番号)) {
            result.add(new Fuka(entity));
        }
        return ItemList.of(result);
//        return dac.select介護賦課一覧(被保険者番号);
    }

    /**
     * 条件に該当する全賦課履歴を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 賦課年度 賦課年度
     * @return 全賦課履歴
     */
    public IItemList<Fuka> load全賦課履歴(HihokenshaNo 被保険者番号, FlexibleYear 賦課年度) {
        List<Fuka> result = new ArrayList<>();
        for (DbT2002FukaEntity entity : dac.select介護賦課一覧(被保険者番号, 賦課年度)) {
            result.add(new Fuka(entity));
        }
        return ItemList.of(result);
//        return dac.select介護賦課一覧(被保険者番号, 賦課年度);
    }

    /**
     * 引数の主キーに該当する１件の賦課モデルを取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @return 賦課モデル
     */
    public Optional<Fuka> find賦課(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) {

        return Optional.ofNullable(new Fuka(dac.select賦課ByKey(調定年度, 賦課年度, 通知書番号, 履歴番号).get()));
    }

    /**
     * 引数に該当するデータから直近の１件を取得します。<br/>
     * 直近とは以下の条件でソートした１件目です。<br/>
     * 通知書番号（降順）＞調定年度（降順）＞処理日時（降順）かつ　引数の処理日時　＞　対象データの処理日時
     *
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return 直近賦課モデル
     */
    public Optional<Fuka> find賦課直近(FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {

        return Optional.ofNullable(new Fuka(dac.select最新介護賦課(賦課年度, 通知書番号).get()));
    }

    /**
     * 引数の通知書番号に一致するデータで<br/>
     * 引数の処理日時より前で一番直近のデータを１件取得します。
     *
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     * @return 直近賦課モデル
     */
    public Optional<Fuka> find賦課直近(TsuchishoNo 通知書番号, RDateTime 処理日時) {

        return Optional.ofNullable(new Fuka(dac.select賦課Recently(通知書番号, 処理日時).get()));
    }

    /**
     * 引数に該当するデータから処理日時の直近のデータを取得します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return 直近賦課モデル
     */
    public IItemList<Fuka> find賦課直近(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        List<Fuka> result = new ArrayList<>();
        for (DbT2002FukaEntity entity : dac.selectRecently賦課(調定年度, 賦課年度, 通知書番号)) {
            result.add(new Fuka(entity));
        }
        return ItemList.of(result);
//        return dac.selectRecently賦課(調定年度, 賦課年度, 通知書番号);
    }

    /**
     * 条件に合致する介護賦課の一覧を返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return IItemList<FukaModel>
     */
    @Transaction
    public IItemList<Fuka> get介護賦課一覧(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        List<Fuka> result = new ArrayList<>();
        for (DbT2002FukaEntity entity : dac.select介護賦課一覧(調定年度, 賦課年度, 通知書番号)) {
            result.add(new Fuka(entity));
        }
        return ItemList.of(result);
//        return dac.select介護賦課一覧(調定年度, 賦課年度, 通知書番号);
    }

    /**
     * 条件に合致する最新介護賦課を返します。
     *
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return Optional<FukaModel>
     * @Transaction
     */
    public Optional<Fuka> get最新介護賦課(FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {
        return Optional.ofNullable(new Fuka(dac.select最新介護賦課(賦課年度, 通知書番号).get()));
    }

    /**
     * 条件に合致する介護賦課の直近の一覧を返します。
     *
     * @param 通知書番号 通知書番号
     * @return IItemList<FukaModel>
     */
    @Transaction
    public IItemList<Fuka> get直近介護賦課一覧(TsuchishoNo 通知書番号) {
        List<Fuka> result = new ArrayList<>();
        for (DbT2002FukaEntity entity : dac.selectRecently賦課一覧by通知書番号(通知書番号)) {
            result.add(new Fuka(entity));
        }
        return ItemList.of(result);
//        return dac.selectRecently賦課一覧by通知書番号(通知書番号);
    }

}
