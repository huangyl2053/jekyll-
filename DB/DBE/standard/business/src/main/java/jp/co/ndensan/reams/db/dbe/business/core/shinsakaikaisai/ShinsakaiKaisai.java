/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikaisai.ShinsakaiKaisaiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 審査会一覧情報クラスです。
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
public class ShinsakaiKaisai implements Serializable {

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
     * コンストラクタです.
     */
    public ShinsakaiKaisai() {
        entity = new ShinsakaiKaisaiRelateEntity();
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
     * ダミーフラグを取得します。
     *
     * @return ダミーフラグ
     */
    public boolean isダミーフラグ() {
        return entity.isGogitaiDummyFlag();
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public RString get合議体番号() {
        return new RString(entity.get合議体番号());
    }
    
    /**
     * 最大審査順を取得します。
     * 
     * @return 最大審査順
     */
    public RString get最大審査順() {
        return new RString(entity.get最大審査順());
    }

    /**
     * このクラスの編集を行うBuilderを取得します。
     *
     * @return Builder
     */
    public ShinsakaiKaisaiBuilder createBuilderForEdit() {
        return new ShinsakaiKaisaiBuilder(entity);
    }
}
