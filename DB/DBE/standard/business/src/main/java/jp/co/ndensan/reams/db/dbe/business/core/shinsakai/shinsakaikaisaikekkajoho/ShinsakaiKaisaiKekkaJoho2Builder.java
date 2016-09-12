/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShinsakaiKaisaiKekkaJoho2}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShinsakaiKaisaiKekkaJoho2Builder {

    private final DbT5511ShinsakaiKaisaiKekkaJohoEntity entity;
    private final ShinsakaiKaisaiKekkaJoho2Identifier id;

    /**
     * {@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}より{@link ShinsakaiKaisaiKekkaJoho2}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT5511ShinsakaiKaisaiKekkaJohoEntity}
     * @param id {@link ShinsakaiKaisaiKekkaJoho2Identifier}
     *
     */
    ShinsakaiKaisaiKekkaJoho2Builder(
            DbT5511ShinsakaiKaisaiKekkaJohoEntity entity,
            ShinsakaiKaisaiKekkaJoho2Identifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 合議体番号を設定します。
     *
     * @param 合議体番号 合議体番号
     * @return {@link ShinsakaiKaisaiKekkaJoho2Builder}
     */
    public ShinsakaiKaisaiKekkaJoho2Builder set合議体番号(int 合議体番号) {
        requireNonNull(合議体番号, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体番号"));
        entity.setGogitaiNo(合議体番号);
        return this;
    }

    /**
     * 介護認定審査会開催年月日を設定します。
     *
     * @param 介護認定審査会開催年月日 介護認定審査会開催年月日
     * @return {@link ShinsakaiKaisaiKekkaJoho2Builder}
     */
    public ShinsakaiKaisaiKekkaJoho2Builder set介護認定審査会開催年月日(FlexibleDate 介護認定審査会開催年月日) {
        requireNonNull(介護認定審査会開催年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催年月日"));
        entity.setShinsakaiKaisaiYMD(介護認定審査会開催年月日);
        return this;
    }

    /**
     * 介護認定審査会開始時刻を設定します。
     *
     * @param 介護認定審査会開始時刻 介護認定審査会開始時刻
     * @return {@link ShinsakaiKaisaiKekkaJoho2Builder}
     */
    public ShinsakaiKaisaiKekkaJoho2Builder set介護認定審査会開始時刻(RString 介護認定審査会開始時刻) {
        requireNonNull(介護認定審査会開始時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開始時刻"));
        entity.setShinsakaiKaishiTime(介護認定審査会開始時刻);
        return this;
    }

    /**
     * 介護認定審査会終了時刻を設定します。
     *
     * @param 介護認定審査会終了時刻 介護認定審査会終了時刻
     * @return {@link ShinsakaiKaisaiKekkaJoho2Builder}
     */
    public ShinsakaiKaisaiKekkaJoho2Builder set介護認定審査会終了時刻(RString 介護認定審査会終了時刻) {
        requireNonNull(介護認定審査会終了時刻, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会終了時刻"));
        entity.setShinsakaiShuryoTime(介護認定審査会終了時刻);
        return this;
    }

    /**
     * 介護認定審査会開催場所コードを設定します。
     *
     * @param 介護認定審査会開催場所コード 介護認定審査会開催場所コード
     * @return {@link ShinsakaiKaisaiKekkaJoho2Builder}
     */
    public ShinsakaiKaisaiKekkaJoho2Builder set介護認定審査会開催場所コード(RString 介護認定審査会開催場所コード) {
        requireNonNull(介護認定審査会開催場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所コード"));
        entity.setShinsakaiKaisaiBashoCode(介護認定審査会開催場所コード);
        return this;
    }

    /**
     * 所要時間合計を設定します。
     *
     * @param 所要時間合計 所要時間合計
     * @return {@link ShinsakaiKaisaiKekkaJoho2Builder}
     */
    public ShinsakaiKaisaiKekkaJoho2Builder set所要時間合計(int 所要時間合計) {
        requireNonNull(所要時間合計, UrSystemErrorMessages.値がnull.getReplacedMessage("所要時間合計"));
        entity.setShoyoJikanGokei(所要時間合計);
        return this;
    }

    /**
     * 介護認定審査会実施人数を設定します。
     *
     * @param 介護認定審査会実施人数 介護認定審査会実施人数
     * @return {@link ShinsakaiKaisaiKekkaJoho2Builder}
     */
    public ShinsakaiKaisaiKekkaJoho2Builder set介護認定審査会実施人数(int 介護認定審査会実施人数) {
        requireNonNull(介護認定審査会実施人数, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会実施人数"));
        entity.setShinsakaiJisshiNinzu(介護認定審査会実施人数);
        return this;
    }

    /**
     * {@link ShinsakaiKaisaiKekkaJoho2}のインスタンスを生成します。
     *
     * @return {@link ShinsakaiKaisaiKekkaJoho2}のインスタンス
     */
    public ShinsakaiKaisaiKekkaJoho2 build() {
        return new ShinsakaiKaisaiKekkaJoho2(entity, id);
    }
}
