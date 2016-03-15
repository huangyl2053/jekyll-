/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaikaisai.ShinsakaiKaisaiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 審査会一覧情報クラスです。
 */
public class ShinsakaiKaisai {

    private final ShinsakaiKaisaiRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 審査会一覧情報RelateEntity
     */
    public ShinsakaiKaisai(ShinsakaiKaisaiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護認定審査会開催予定年月日を取得します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public FlexibleDate get介護認定審査会開催予定年月日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 介護認定審査会開始予定時刻を取得します。
     *
     * @return 介護認定審査会開始予定時刻
     */
    public RString get介護認定審査会開始予定時刻() {
        return entity.getShinsakaiKaishiYoteiTime();
    }

    /**
     * 介護認定審査会終了予定時刻を取得します。
     *
     * @return 介護認定審査会終了予定時刻
     */
    public RString get介護認定審査会終了予定時刻() {
        return entity.getShinsakaiShuryoYoteiTime();
    }

    /**
     * 編集合議体名称を取得します。
     *
     * @return 編集合議体名称
     */
    public RString get編集合議体名称() {
        return entity.get合議体名称();
    }

    /**
     * 合議体名称を取得します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.getGogitaiMei();
    }

    /**
     * 種類を取得します。
     *
     * @return 種類
     */
    public RString get種類() {
        return entity.get種類();
    }

    /**
     * 介護認定審査会開催場所名称を取得します。
     *
     * @return 介護認定審査会開催場所名称
     */
    public RString get介護認定審査会開催場所名称() {
        return entity.getShinsakaiKaisaiBashoName();
    }

    /**
     * 介護認定審査会開催年月日を取得します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 介護認定審査会開始時刻を取得します。
     *
     * @return 介護認定審査会開始時刻
     */
    public RString get介護認定審査会開始時刻() {
        return entity.getShinsakaiKaishiTime();
    }

    /**
     * 介護認定審査会終了時刻を取得します。
     *
     * @return 介護認定審査会終了時刻
     */
    public RString get介護認定審査会終了時刻() {
        return entity.getShinsakaiShuryoTime();
    }

    /**
     * 介護認定審査会予定定員を取得します。
     *
     * @return 介護認定審査会予定定員
     */
    public Decimal get介護認定審査会予定定員() {
        return entity.getShinsakaiYoteiTeiin();
    }

    /**
     * 介護認定審査会割当済み人数を取得します。
     *
     * @return 介護認定審査会割当済み人数
     */
    public Decimal get介護認定審査会割当済み人数() {
        return entity.getShinsakaiWariateZumiNinzu();
    }

    /**
     * 介護認定審査会実施人数を取得します。
     *
     * @return 介護認定審査会実施人数
     */
    public Decimal get介護認定審査会実施人数() {
        return entity.getShinsakaiJisshiNinzu();
    }

    /**
     * 音声記録を取得します。
     *
     * @return 音声記録
     */
    public RString get音声記録() {
        return entity.get音声記録();
    }

    /**
     * モバイルデータ出力年月日を取得します。
     *
     * @return モバイルデータ出力年月日
     */
    public FlexibleDate getモバイルデータ出力年月日() {
        return entity.getMobileDataOutputYMD();
    }

    /**
     * 資料作成済フラグを取得します。
     *
     * @return 資料作成済フラグ
     */
    public boolean is資料作成済フラグ() {
        return entity.isShiryoSakuseiZumiFlag();
    }

    /**
     * 介護認定審査会進捗状況を取得します。
     *
     * @return 介護認定審査会進捗状況
     */
    public RString get介護認定審査会進捗状況() {
        return entity.getShinsakaiShinchokuJokyo();
    }

    /**
     * ダミーフラグを取得します。
     *
     * @return ダミーフラグ
     */
    public boolean isダミーフラグ() {
        return entity.isGogitaiDummyFlag();
    }
}
