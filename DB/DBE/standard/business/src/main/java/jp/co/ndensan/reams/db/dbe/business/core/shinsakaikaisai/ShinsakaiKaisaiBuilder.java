/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikaisai.ShinsakaiKaisaiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShinsakaiKaisai}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
public class ShinsakaiKaisaiBuilder {

    private final ShinsakaiKaisaiRelateEntity entity;

    /**
     * {@link ShinsakaiKaisaiRelateEntity}より{@link ShinsakaiKaisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link ShinsakaiKaisaiRelateEntity}
     *
     */
    public ShinsakaiKaisaiBuilder(ShinsakaiKaisaiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護認定審査会開催予定年月日を設定します。
     *
     * @param 介護認定審査会開催予定年月日 介護認定審査会開催予定年月日
     * @return {@link ShinsakaiKaisaiBuilder}
     */
    public ShinsakaiKaisaiBuilder set介護認定審査会開催予定年月日(FlexibleDate 介護認定審査会開催予定年月日) {
        entity.setShinsakaiKaisaiYoteiYMD(介護認定審査会開催予定年月日);
        return this;
    }

    /**
     * 介護認定審査会開始予定時刻を設定します。
     *
     * @param 介護認定審査会開始予定時刻 介護認定審査会開始予定時刻
     * @return {@link ShinsakaiKaisaiBuilder}
     */
    public ShinsakaiKaisaiBuilder set介護認定審査会開始予定時刻(RString 介護認定審査会開始予定時刻) {
        entity.setShinsakaiKaishiYoteiTime(介護認定審査会開始予定時刻);
        return this;
    }

    /**
     * 編集合議体名称を設定します。
     *
     * @param 編集合議体名称 編集合議体名称
     * @return {@link ShinsakaiKaisaiBuilder}
     */
    public ShinsakaiKaisaiBuilder set編集合議体名称(RString 編集合議体名称) {
        entity.set合議体名称(編集合議体名称);
        return this;
    }

    /**
     * 編集合議体名称を設定します。
     *
     * @param 合議体名称 合議体名称
     * @return {@link ShinsakaiKaisaiBuilder}
     */
    public ShinsakaiKaisaiBuilder set合議体名称(RString 合議体名称) {
        entity.setGogitaiMei(合議体名称);
        return this;
    }

    /**
     * 種類を設定します。
     *
     * @param 種類 種類
     * @return {@link ShinsakaiKaisaiBuilder}
     */
    public ShinsakaiKaisaiBuilder set種類(RString 種類) {
        entity.set種類(種類);
        return this;
    }

    /**
     * 介護認定審査会開催場所名称を設定します。
     *
     * @param 介護認定審査会開催場所名称 介護認定審査会開催場所名称
     * @return {@link ShinsakaiKaisaiBuilder}
     */
    public ShinsakaiKaisaiBuilder set介護認定審査会開催場所名称(RString 介護認定審査会開催場所名称) {
        entity.setShinsakaiKaisaiBashoName(介護認定審査会開催場所名称);
        return this;
    }

    /**
     * 介護認定審査会予定定員を設定します。
     *
     * @param 介護認定審査会予定定員 介護認定審査会予定定員
     * @return {@link ShinsakaiKaisaiBuilder}
     */
    public ShinsakaiKaisaiBuilder set介護認定審査会予定定員(Decimal 介護認定審査会予定定員) {
        entity.setShinsakaiYoteiTeiin(介護認定審査会予定定員);
        return this;
    }

    /**
     * 介護認定審査会割当済み人数を設定します。
     *
     * @param 介護認定審査会割当済み人数 介護認定審査会割当済み人数
     * @return {@link ShinsakaiKaisaiBuilder}
     */
    public ShinsakaiKaisaiBuilder set介護認定審査会割当済み人数(Decimal 介護認定審査会割当済み人数) {
        entity.setShinsakaiWariateZumiNinzu(介護認定審査会割当済み人数);
        return this;
    }

    /**
     * ダミーフラグを設定します。
     *
     * @param ダミーフラグ ダミーフラグ
     * @return {@link ShinsakaiKaisaiBuilder}
     */
    public ShinsakaiKaisaiBuilder setダミーフラグ(boolean ダミーフラグ) {
        entity.setGogitaiDummyFlag(ダミーフラグ);
        return this;
    }

    /**
     * {@link ShinsakaiKaisai}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiKaisai}のインスタンス
     */
    public ShinsakaiKaisai build() {
        return new ShinsakaiKaisai(entity);
    }
}
